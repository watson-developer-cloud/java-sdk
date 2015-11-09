/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.Preconditions.*;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.RetrieveAndRankMessages.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;

import com.google.common.base.Throwables;
import com.ibm.watson.developer_cloud.alchemy.v1.util.PublicationDateTypeAdapter;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.RemoteError;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrConfigList;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.JsonSerializationUtils;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.MessageFormatter;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.SolrConfigManager;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.ZipUtils;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Manages SolrCloud configuration.
 */
public class HttpSolrConfigManager extends WatsonService implements SolrConfigManager {
    private static final MessageFormatter MSGS = new MessageFormatter(bundleName());
    private static final Logger LOG = Logger.getLogger(PublicationDateTypeAdapter.class.getName());

    private final String serviceUrl;

    /**
     * Manage configurations via Watson Search Service. The supplied httpClient will not be closed by the
     * SolrConfigManager.
     */
    public HttpSolrConfigManager(String watsonSearchUrl) {
        super("retrieve_and_rank");
        checkArgumentNotNull(watsonSearchUrl, "watsonSearchUrl");
        this.serviceUrl = watsonSearchUrl.toString() + "/config";
    }

    @Override
    public void uploadConfigurationDirectory(final String configName, final File configDirectory) {
        checkArgumentNotBlank(configName, "configName");
        checkArgumentNotNull(configDirectory, "configDirectory");
        if (!configDirectory.isDirectory()) {
            throw new IllegalArgumentException(MSGS.format(CONFIG_NOT_DIR_1, configDirectory));
        }
        final File zipFile = ZipUtils.buildConfigZip(configName, configDirectory.toPath());
        try {
            postConfigZip(configName, zipFile);
        } finally {
            try {
                Files.delete(zipFile.toPath());
            } catch (final IOException e) {
                zipFile.deleteOnExit();
                LOG.warning(MSGS.format(FAILED_TO_DELETE_TEMP_2, zipFile.getPath(), e.getMessage()));
            }
        }
    }

    @Override
    public void uploadConfigurationZip(final String configName, final File zippedConfig) {
        checkArgumentNotBlank(configName, "configName");
        checkArgumentNotNull(zippedConfig, "zippedConfig");
        postConfigZip(configName, zippedConfig);
    }

    @Override
    public void deleteConfiguration(final String configName) {
        checkArgumentNotBlank(configName, "configurationName");
        final String configPath = serviceUrl + '/' + configName;
        final Request delete = RequestBuilder.delete(configPath).build();
        try {
            parseResponse(execute(delete), configPath);
        } catch (final Exception e) {
            Throwables.propagate(e);
        }
    }

    @Override
    public File getConfiguration(String configName) {
        checkArgumentNotBlank(configName, "configurationName");
        final Request get = RequestBuilder.get(serviceUrl + '/' + configName).build();
        final Response response = execute(get);
        final int status = response.code();
        switch (status) {
        case 200:
            return getZipFromResponse(response, configName);
        case 404:
            return null;
        default:
            throw new RuntimeException(MSGS.format(FAILED_GETTING_CONFIG_WITH_CODE_2, configName, status));
        }
    }

    @Override
    public Collection<String> listConfigurations() {
        final Request get = RequestBuilder.get(serviceUrl).build();
        try {
            final Response response = execute(get);

            final int status = response.code();
            if (status != 200) {
                throw new RuntimeException(MSGS.format(FAILED_LISTING_CONFIGS_WITH_CODE_1, status));
            }
            final String entity = response.body().string();
            final SolrConfigList configsList = JsonSerializationUtils.fromJson(entity, SolrConfigList.class);
            return configsList.getSolrConfigs();
        } catch (final IOException e) {
            throw new RuntimeException(MSGS.format(FAILED_LISTING_CONFIGS), e);
        }
    }

    private void postConfigZip(String configName, File file) {
        final String configPath = serviceUrl + '/' + configName;
        final RequestBuilder post = RequestBuilder.post(configPath)
                .withBody(RequestBody.create(MediaType.parse("application/zip"), file));
        try {
            parseResponse(execute(post.build()), configPath);
        } catch (final Exception e) {
            Throwables.propagate(e);
        }
    }

    private File getZipFromResponse(Response response, String configurationName) {
        final int status = response.code();
        switch (status) {
        case 200:
            try {
                final File zipFile = File.createTempFile(configurationName, ".zip");
                final FileOutputStream output = new FileOutputStream(zipFile);
                try {
                    IOUtils.copy(response.body().byteStream(), output);
                } finally {
                    output.close();
                }
                return zipFile;
            } catch (final IOException e) {
                throw new RuntimeException(MSGS.format(FAILED_GETTING_CONFIG_1, configurationName), e);
            }
        case 404:
            return null;
        default:
            throw new RuntimeException(MSGS.format(FAILED_GETTING_CONFIG_WITH_CODE_2, configurationName, status));
        }
    }

    private void parseResponse(Response response, String uri) throws IOException {
        final int statusCode = response.code();
        if (statusCode == 200) {
            return;
        } else if (statusCode == 400 && response.body() != null) {
            final RemoteError error = JsonSerializationUtils.fromJson(response.body().string(), RemoteError.class);

            throw new RuntimeException(error.getMessage());
        } else {
            throw new RuntimeException(MSGS.format(FAILURE_RESPONSE_3, statusCode, uri,
                    safelyGetResponseMessage(response)));
        }
    }

    private String safelyGetResponseMessage(Response response) {
        if (response.body() == null) {
            return "";
        }
        try {
            return response.body().string();
        } catch (@SuppressWarnings("unused") final IOException e) {
            return "";
        }
    }
}

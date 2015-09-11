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
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils;

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.RetrieveAndRankMessages.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.util.Collection;

import javax.ws.rs.core.UriBuilder;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Throwables;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.RemoteError;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrConfigList;

/**
 * Posts config to the Watson search service.
 */
public class SolrConfigRestSender {
    private static final Logger LOG = LoggerFactory.getLogger(SolrConfigRestSender.class);
    private static final MessageFormatter MSGS = new MessageFormatter(bundleName());

    private final URI serviceUrl;
    private final HttpClient httpClient;

    public SolrConfigRestSender(URI serviceUrl, HttpClient httpClient) {
        this.httpClient = httpClient;
        this.serviceUrl = UriBuilder.fromUri(serviceUrl).path("config").build();
    }

    public Collection<String> listConfigurations() {
        final HttpGet get = new HttpGet(serviceUrl);
        try {
            final HttpResponse response = httpClient.execute(get);

            final int status = response.getStatusLine().getStatusCode();
            if (status != HttpStatus.SC_OK) {
                throw new RuntimeException(MSGS.format(FAILED_LISTING_CONFIGS_WITH_CODE_1, status));
            }
            final String entity = EntityUtils.toString(response.getEntity());
            final SolrConfigList configsList = JsonSerializationUtils.fromJson(entity, SolrConfigList.class);
            return configsList.getSolrConfigs();
        } catch (final IOException e) {
            throw new RuntimeException(MSGS.format(FAILED_LISTING_CONFIGS), e);
        }
    }

    public void uploadConfiguration(final String configName, final File file) {
        final File zipFile = ZipUtils.buildConfigZip(configName, file.toPath());
        try {
            postConfigZip(httpClient, configName, zipFile);
        } finally {
            try {
                Files.delete(zipFile.toPath());
            } catch (final IOException e) {
                zipFile.deleteOnExit();
                LOG.warn(MSGS.format(FAILED_TO_DELETE_TEMP_2, zipFile.getPath(), e.getMessage()));
            }
        }
    }

    public void uploadConfigurationZip(String configName, File zipFile) {
        postConfigZip(httpClient, configName, zipFile);
    }

    public void deleteConfiguration(String configName) {
        final URI uri = UriBuilder.fromUri(serviceUrl).path(configName).build();
        try {
            final HttpDelete delete = new HttpDelete(uri);
            parseResponse(httpClient.execute(delete), uri);
        } catch (final Exception e) {
            Throwables.propagate(e);
        }
    }

    public File getConfiguration(String configurationName) {
        final HttpGet get = new HttpGet(UriBuilder.fromUri(serviceUrl).path(configurationName).build());
        try {
            final HttpResponse response = httpClient.execute(get);
            final int status = response.getStatusLine().getStatusCode();
            switch (status) {
            case HttpStatus.SC_OK:
                return getZipFromResponse(response, configurationName);
            case HttpStatus.SC_NOT_FOUND:
                return null;
            default:
                throw new RuntimeException(MSGS.format(FAILED_GETTING_CONFIG_WITH_CODE_2, configurationName, status));
            }
        } catch (final IOException e) {
            throw new RuntimeException(MSGS.format(FAILED_GETTING_CONFIG_1, configurationName), e);
        }
    }

    private void postConfigZip(HttpClient httpClient, String configName, File file) {
        final URI uri = UriBuilder.fromUri(serviceUrl).path(configName).build();
        try {
            final HttpPost post = new HttpPost(uri);
            post.addHeader(HTTP.CONTENT_TYPE, "application/zip");
            post.setEntity(new FileEntity(file));

            parseResponse(httpClient.execute(post), uri);
        } catch (final Exception e) {
            Throwables.propagate(e);
        }
    }

    private File getZipFromResponse(HttpResponse response, String configurationName) {
        final int status = response.getStatusLine().getStatusCode();
        switch (status) {
        case HttpStatus.SC_OK:
            try {
                final File zipFile = File.createTempFile(configurationName, ".zip");
                final FileOutputStream output = new FileOutputStream(zipFile);
                try {
                    IOUtils.copy(response.getEntity().getContent(), output);
                } finally {
                    output.close();
                }
                return zipFile;
            } catch (final IOException e) {
                throw new RuntimeException(MSGS.format(FAILED_GETTING_CONFIG_1, configurationName), e);
            }
        case HttpStatus.SC_NOT_FOUND:
            return null;
        default:
            throw new RuntimeException(MSGS.format(FAILED_GETTING_CONFIG_WITH_CODE_2, configurationName, status));
        }
    }

    private void parseResponse(HttpResponse httpResponse, URI uri) throws IOException {
        final int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == HttpStatus.SC_OK) {
            return;
        } else if (statusCode == HttpStatus.SC_BAD_REQUEST && httpResponse.getEntity() != null) {
            final RemoteError error = JsonSerializationUtils.fromJson(EntityUtils.toString(httpResponse.getEntity()),
                    RemoteError.class);

            throw new RuntimeException(error.getMessage());
        } else {
            throw new RuntimeException(MSGS.format(FAILURE_RESPONSE_3, statusCode, uri.toString(),
                    safelyGetResponseMessage(httpResponse)));
        }
    }

    private String safelyGetResponseMessage(HttpResponse httpResponse) {
        try {
            return EntityUtils.toString(httpResponse.getEntity());
        } catch (@SuppressWarnings("unused") final IllegalArgumentException e) {
            return "";
        } catch (@SuppressWarnings("unused") final ParseException e) {
            return "";
        } catch (@SuppressWarnings("unused") final IOException e) {
            return "";
        }
    }
}

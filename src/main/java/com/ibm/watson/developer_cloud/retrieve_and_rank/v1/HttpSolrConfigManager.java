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
import java.io.IOException;
import java.net.URI;
import java.util.Collection;

import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.HttpClientFactory;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.MessageFormatter;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.SolrConfigManager;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.SolrConfigRestSender;

/**
 * Manages SolrCloud configuration.
 */
public class HttpSolrConfigManager implements SolrConfigManager {
    private static final Logger LOG = LoggerFactory.getLogger(HttpSolrConfigManager.class);
    private final MessageFormatter msgs = new MessageFormatter(bundleName());

    private final SolrConfigRestSender configUploader;
    private final CloseableHttpClient createdHttpClient;

    /**
     * Manage configurations via Watson Search Service. The supplied httpClient will not be closed by the
     * SolrConfigManager.
     */
    public HttpSolrConfigManager(URI watsonSearchUrl, CloseableHttpClient httpClient) {
        checkArgumentNotNull(watsonSearchUrl, "watsonSearchUrl");
        checkArgumentNotNull(httpClient, "httpClient");

        this.configUploader = new SolrConfigRestSender(watsonSearchUrl, httpClient);
        this.createdHttpClient = null;
    }

    /**
     * Manage configurations via Watson Search Service.
     */
    public HttpSolrConfigManager(URI watsonSearchUrl, String username, String password) {
        checkArgumentNotNull(watsonSearchUrl, "watsonSearchUrl");
        checkArgumentNotNull(username, "username");
        checkArgumentNotNull(password, "password");

        this.createdHttpClient = new HttpClientFactory(watsonSearchUrl, username, password).createHttpClient();
        this.configUploader = new SolrConfigRestSender(watsonSearchUrl, createdHttpClient);
    }

    @Override
    public void uploadConfigurationDirectory(final String configName, final File configDirectory) {
        checkArgumentNotBlank(configName, "configName");
        checkArgumentNotNull(configDirectory, "configDirectory");
        if (!configDirectory.isDirectory()) {
            throw new IllegalArgumentException(msgs.format(CONFIG_NOT_DIR_1, configDirectory));
        }
        configUploader.uploadConfiguration(configName, configDirectory);
    }

    @Override
    public void uploadConfigurationZip(final String configName, final File zippedConfig) {
        checkArgumentNotBlank(configName, "configName");
        checkArgumentNotNull(zippedConfig, "zippedConfig");
        configUploader.uploadConfigurationZip(configName, zippedConfig);
    }

    @Override
    public void deleteConfiguration(final String configurationName) {
        checkArgumentNotBlank(configurationName, "configurationName");
        configUploader.deleteConfiguration(configurationName);
    }

    @Override
    public File getConfiguration(String configurationName) {
        checkArgumentNotBlank(configurationName, "configurationName");
        return configUploader.getConfiguration(configurationName);
    }

    @Override
    public Collection<String> listConfigurations() {
        return configUploader.listConfigurations();
    }

    @Override
    public void close() {
        if (createdHttpClient != null) {
            try {
                createdHttpClient.close();
            } catch (final IOException e) {
                LOG.error(msgs.format(UNABLE_TO_CLOSE_HTTP_CLIENT), e);
            }
        }
    }
}

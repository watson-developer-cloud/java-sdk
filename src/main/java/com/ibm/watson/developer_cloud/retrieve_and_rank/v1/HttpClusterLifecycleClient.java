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

import java.io.IOException;
import java.net.URI;

import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterCreationRequest;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterListResponse;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterResponse;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.ClusterLifecycleRestSender;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.HttpClientFactory;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.MessageFormatter;

/**
 * A client for managing Watson Search Service Solr clusters.
 */
public class HttpClusterLifecycleClient implements AutoCloseable, ClusterLifecycleClient {
    private static final Logger LOG = LoggerFactory.getLogger(HttpSolrConfigManager.class);
    private final MessageFormatter msgs = new MessageFormatter(bundleName());

    private final ClusterLifecycleRestSender clusterLifecycleRestSender;
    private final CloseableHttpClient createdHttpClient;

    /**
     * Manage Solr cluster lifecycles via Watson Search Service. The supplied httpClient will not be closed.
     */
    public HttpClusterLifecycleClient(URI watsonSearchUrl, CloseableHttpClient httpClient) {
        checkArgumentNotNull(watsonSearchUrl, "watsonSearchUrl");
        checkArgumentNotNull(httpClient, "httpClient");

        createdHttpClient = null;
        clusterLifecycleRestSender = new ClusterLifecycleRestSender(watsonSearchUrl, httpClient);
    }

    /**
     * Manage Solr cluster lifecycles via Watson Search Service.
     */
    public HttpClusterLifecycleClient(URI watsonSearchUrl, String username, String password) {
        checkArgumentNotNull(watsonSearchUrl, "watsonSearchUrl");
        checkArgumentNotNull(username, "username");
        checkArgumentNotNull(password, "password");

        createdHttpClient = new HttpClientFactory(watsonSearchUrl, username, password).createHttpClient();
        clusterLifecycleRestSender = new ClusterLifecycleRestSender(watsonSearchUrl, createdHttpClient);
    }

    @Override
    public SolrClusterResponse createSolrCluster() {
        return clusterLifecycleRestSender.createSolrCluster();
    }

    @Override
    public SolrClusterResponse createSolrCluster(SolrClusterCreationRequest config) {
        return clusterLifecycleRestSender.createSolrCluster(config);
    }

    @Override
    public void deleteSolrCluster(SolrCluster solrCluster) {
        checkArgumentNotNull(solrCluster, "solrCluster");
        clusterLifecycleRestSender.deleteSolrCluster(solrCluster);
    }

    @Override
    public void deleteSolrClusters() {
        clusterLifecycleRestSender.deleteSolrClusters();
    }

    @Override
    public SolrClusterListResponse listSolrClusters() {
        return clusterLifecycleRestSender.listSolrClusters();
    }

    @Override
    public SolrClusterResponse pollSolrCluster(SolrCluster solrCluster) {
        checkArgumentNotNull(solrCluster, "solrCluster");
        return clusterLifecycleRestSender.pollSolrCluster(solrCluster);
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

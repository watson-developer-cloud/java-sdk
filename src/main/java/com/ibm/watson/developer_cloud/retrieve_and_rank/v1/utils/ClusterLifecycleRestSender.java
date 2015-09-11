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

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.ApiConstants.*;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.Preconditions.*;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.RetrieveAndRankMessages.*;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import com.google.common.base.Throwables;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterCreationRequest;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterListResponse;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterResponse;

/**
 * Sends appropriate REST commands to the Solr cluster lifecycle APIs.
 */
public class ClusterLifecycleRestSender {
    private static final int INITIAL_STRING_SIZE = 256;
    private static final MessageFormatter MSGS = new MessageFormatter(bundleName());

    private final URI watsonSearchUrl;
    private final HttpClient client;

    public ClusterLifecycleRestSender(URI watsonSearchUrl, HttpClient httpClient) {
        checkArgumentNotNull(watsonSearchUrl, "watsonSearchUrl");
        checkArgumentNotNull(httpClient, "httpClient");
        client = httpClient;
        this.watsonSearchUrl = UriBuilder.fromUri(watsonSearchUrl).path(SOLR_CLUSTERS_PATH_SEGMENT).build();
    }

    public SolrClusterResponse createSolrCluster() {
        final HttpPost request = new HttpPost(watsonSearchUrl);
        return sendAndParseCreationRequest(request);
    }

    public SolrClusterResponse createSolrCluster(SolrClusterCreationRequest creationConfig) {
        final HttpPost creationRequest = new HttpPost(watsonSearchUrl);
        addCreationConfigToRequest(creationRequest, creationConfig);
        return sendAndParseCreationRequest(creationRequest);
    }

    public void deleteSolrCluster(SolrCluster solrCluster) {
        checkArgumentNotNull(solrCluster, "solrCluster");
        final URI uri = UriBuilder.fromUri(watsonSearchUrl).path(solrCluster.asString()).build();
        final HttpDelete request = new HttpDelete(uri);
        try {
            final HttpResponse response = client.execute(request);
            final int status = response.getStatusLine().getStatusCode();
            switch (status) {
            case HttpStatus.SC_OK:
                return;
            default:
                throw new RuntimeException(generateErrorMessage(response, ERROR_DELETING_CLUSTER_2, solrCluster));
            }
        } catch (final IOException e) {
            throw new RuntimeException(MSGS.format(ERROR_DELETING_CLUSTER_1, solrCluster.asString()), e);
        }
    }

    public void deleteSolrClusters() {
        final HttpDelete request = new HttpDelete(watsonSearchUrl);
        try {
            final HttpResponse response = client.execute(request);

            if (!(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)) {
                throw new RuntimeException(
                        generateErrorMessage(response, RetrieveAndRankMessages.ERROR_DELETING_CLUSTERS_1));
            }
        } catch (final IOException e) {
            throw new RuntimeException(MSGS.format(ERROR_DELETING_CLUSTERS), e);
        }
    }

    public SolrClusterListResponse listSolrClusters() {
        final HttpUriRequest request = new HttpGet(watsonSearchUrl);

        try {
            final HttpResponse response = client.execute(request);

            if (!(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)) {
                throw new RuntimeException(generateErrorMessage(response, ERROR_LISTING_CLUSTERS_1));
            }
            return JsonSerializationUtils.fromJson(entityToString(response), SolrClusterListResponse.class);
        } catch (final IOException e) {
            throw new RuntimeException(MSGS.format(ERROR_LISTING_CLUSTERS), e);
        }
    }

    public SolrClusterResponse pollSolrCluster(SolrCluster solrCluster) {
        checkArgumentNotNull(solrCluster, "solrCluster");

        final URI uri = UriBuilder.fromUri(watsonSearchUrl).path(solrCluster.asString()).build();
        final HttpUriRequest request = new HttpGet(uri);

        try {
            final HttpResponse response = client.execute(request);

            if (!(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)) {
                throw new RuntimeException(generateErrorMessage(response, ERROR_POLLING_CLUSTER_2, solrCluster));
            }

            return JsonSerializationUtils.fromJson(entityToString(response), SolrClusterResponse.class);
        } catch (final IOException e) {
            throw new RuntimeException(MSGS.format(ERROR_POLLING_CLUSTER_1, solrCluster.asString()), e);
        }

    }

    private String entityToString(final HttpResponse response) {
        if (response.getEntity() == null) {
            return null;
        }
        try {
            return EntityUtils.toString(response.getEntity());
        } catch (final Exception e) {
            throw Throwables.propagate(e);
        }
    }

    private String generateErrorMessage(HttpResponse response, RetrieveAndRankMessages messageKey) {
        final StringBuilder msg = new StringBuilder(INITIAL_STRING_SIZE)
                .append(MSGS.format(messageKey, response.getStatusLine().getStatusCode()));
        if (response.getEntity() != null) {
            return msg.append(MSGS.format(ERROR_CAUSE_1, entityToString(response))).toString();
        }
        return msg.toString();
    }

    private String generateErrorMessage(HttpResponse response, RetrieveAndRankMessages messageKey,
            SolrCluster cluster) {
        final StringBuilder msg = new StringBuilder(INITIAL_STRING_SIZE)
                .append(MSGS.format(messageKey, cluster.asString(), response.getStatusLine().getStatusCode()));
        if (response.getEntity() != null) {
            return msg.append(MSGS.format(ERROR_CAUSE_1, entityToString(response))).toString();
        }
        return msg.toString();
    }

    private SolrClusterResponse sendAndParseCreationRequest(HttpUriRequest request) {
        try {
            final HttpResponse response = client.execute(request);

            if (!(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)) {
                throw new RuntimeException(generateErrorMessage(response, ERROR_CREATING_CLUSTER_1));
            }
            return JsonSerializationUtils.fromJson(entityToString(response), SolrClusterResponse.class);
        } catch (final IOException e) {
            throw new RuntimeException(MSGS.format(ERROR_CREATING_CLUSTER), e);
        }
    }

    private void addCreationConfigToRequest(HttpPost creationRequest, SolrClusterCreationRequest creationConfig) {
        final String configJson = JsonSerializationUtils.toJsonString(creationConfig);
        final StringEntity jsonEntity = new StringEntity(configJson, ContentType.APPLICATION_JSON);
        creationRequest.setEntity(jsonEntity);
    }

}

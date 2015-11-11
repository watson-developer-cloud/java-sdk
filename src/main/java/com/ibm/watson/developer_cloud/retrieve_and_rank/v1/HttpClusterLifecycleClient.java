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

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.ApiConstants.SOLR_CLUSTERS_PATH_SEGMENT;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.Preconditions.checkArgumentNotNull;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.RetrieveAndRankMessages.ERROR_CAUSE_1;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.RetrieveAndRankMessages.ERROR_CREATING_CLUSTER_1;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.RetrieveAndRankMessages.ERROR_DELETING_CLUSTER_2;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.RetrieveAndRankMessages.ERROR_LISTING_CLUSTERS_1;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.RetrieveAndRankMessages.ERROR_POLLING_CLUSTER_2;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.RetrieveAndRankMessages.bundleName;

import java.io.IOException;

import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterList;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterOptions;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.JsonSerializationUtils;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.MessageFormatter;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.RetrieveAndRankMessages;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * A client for managing Watson Search Service Solr clusters.
 */
public class HttpClusterLifecycleClient extends WatsonService implements ClusterLifecycleClient {
    private static final MessageFormatter MSGS = new MessageFormatter(bundleName());

    private final String watsonSearchUrl;

    /**
     * Manage Solr cluster lifecycles via Watson Search Service. The supplied httpClient will not be closed.
     */
    public HttpClusterLifecycleClient(String watsonSearchUrl) {
        super("retrieve_and_rank");
        checkArgumentNotNull(watsonSearchUrl, "watsonSearchUrl");
        this.watsonSearchUrl = watsonSearchUrl + '/' + SOLR_CLUSTERS_PATH_SEGMENT;
    }

    @Override
    public SolrCluster createSolrCluster() {
        final Request request =
                RequestBuilder.post(watsonSearchUrl).withHeader("Content-Type", "application/json").build();
        return sendAndParseCreationRequest(request);
    }

    @Override
    public SolrCluster createSolrCluster(SolrClusterOptions config) {
        final RequestBuilder creationRequest =
                RequestBuilder.post(watsonSearchUrl).withHeader("Content-Type", "application/json");
        addCreationConfigToRequest(creationRequest, config);
        return sendAndParseCreationRequest(creationRequest.build());
    }

    @Override
    public void deleteSolrCluster(String solrClusterId) {
        checkArgumentNotNull(solrClusterId, "solrClusterId");
        final Request request = RequestBuilder.delete(watsonSearchUrl + '/' + solrClusterId).build();
        final Response response = execute(request);
        if (response.code() != 200) {
            throw new RuntimeException(generateErrorMessage(response, ERROR_DELETING_CLUSTER_2, solrClusterId));
        }
    }

    @Override
    public SolrClusterList listSolrClusters() {
        final Request request = RequestBuilder.get(watsonSearchUrl).build();
        final Response response = execute(request);

        if (!(response.code() == 200)) {
            throw new RuntimeException(generateErrorMessage(response, ERROR_LISTING_CLUSTERS_1));
        }
        return JsonSerializationUtils.fromJson(entityToString(response), SolrClusterList.class);
    }

    @Override
    public SolrCluster pollSolrCluster(String solrClusterId) {
        checkArgumentNotNull(solrClusterId, "solrClusterId");

        final Request request = RequestBuilder.get(watsonSearchUrl + '/' + solrClusterId).build();
        final Response response = execute(request);

        if (!(response.code() == 200)) {
            throw new RuntimeException(generateErrorMessage(response, ERROR_POLLING_CLUSTER_2, solrClusterId));
        }

        return JsonSerializationUtils.fromJson(entityToString(response), SolrCluster.class);
    }

    private String entityToString(final Response response) {
        if (response.body() == null) {
            return null;
        }
        try {
            return response.body().string();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateErrorMessage(Response response, RetrieveAndRankMessages messageKey) {
        final StringBuilder msg = new StringBuilder(MSGS.format(messageKey, response.code()));
        if (response.body() != null) {
            return msg.append(MSGS.format(ERROR_CAUSE_1, entityToString(response))).toString();
        }
        return msg.toString();
    }

    private String generateErrorMessage(Response response, RetrieveAndRankMessages messageKey,
            String solrClusterId) {
        final StringBuilder msg = new StringBuilder(MSGS.format(messageKey, solrClusterId, response.code()));
        if (response.body() != null) {
            return msg.append(MSGS.format(ERROR_CAUSE_1, entityToString(response))).toString();
        }
        return msg.toString();
    }

    private SolrCluster sendAndParseCreationRequest(Request request) {
        final Response response = execute(request);

        if (!(response.code() == 200)) {
            throw new RuntimeException(generateErrorMessage(response, ERROR_CREATING_CLUSTER_1));
        }
        return JsonSerializationUtils.fromJson(entityToString(response), SolrCluster.class);
    }

    private void addCreationConfigToRequest(RequestBuilder creationRequest, SolrClusterOptions creationConfig) {
        final String configJson = JsonSerializationUtils.toJsonString(creationConfig);
        creationRequest.withBodyContent(configJson, "application/json");
    }
}

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

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.ApiConstants.*;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.Preconditions.*;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.RetrieveAndRankMessages.*;

import java.io.IOException;

import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterCreationRequest;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterListResponse;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterResponse;
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
    public SolrClusterResponse createSolrCluster() {
        final Request request = RequestBuilder.post(watsonSearchUrl).build();
        return sendAndParseCreationRequest(request);
    }

    @Override
    public SolrClusterResponse createSolrCluster(SolrClusterCreationRequest config) {
        final RequestBuilder creationRequest = RequestBuilder.post(watsonSearchUrl);
        addCreationConfigToRequest(creationRequest, config);
        return sendAndParseCreationRequest(creationRequest.build());
    }

    @Override
    public void deleteSolrCluster(SolrCluster solrCluster) {
        checkArgumentNotNull(solrCluster, "solrCluster");
        final Request request = RequestBuilder.delete(watsonSearchUrl + '/' + solrCluster.asString()).build();
        final Response response = execute(request);
        final int status = response.code();
        switch (status) {
        case 200:
            return;
        default:
            throw new RuntimeException(generateErrorMessage(response, ERROR_DELETING_CLUSTER_2, solrCluster));
        }
    }

    @Override
    public SolrClusterListResponse listSolrClusters() {
        final Request request = RequestBuilder.get(watsonSearchUrl).build();
        final Response response = execute(request);

        if (!(response.code() == 200)) {
            throw new RuntimeException(generateErrorMessage(response, ERROR_LISTING_CLUSTERS_1));
        }
        return JsonSerializationUtils.fromJson(entityToString(response), SolrClusterListResponse.class);
    }

    @Override
    public SolrClusterResponse pollSolrCluster(SolrCluster solrCluster) {
        checkArgumentNotNull(solrCluster, "solrCluster");

        final Request request = RequestBuilder.get(watsonSearchUrl + '/' + solrCluster.asString()).build();
        final Response response = execute(request);

        if (!(response.code() == 200)) {
            throw new RuntimeException(generateErrorMessage(response, ERROR_POLLING_CLUSTER_2, solrCluster));
        }

        return JsonSerializationUtils.fromJson(entityToString(response), SolrClusterResponse.class);
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
            SolrCluster cluster) {
        final StringBuilder msg = new StringBuilder(MSGS.format(messageKey, cluster.asString(), response.code()));
        if (response.body() != null) {
            return msg.append(MSGS.format(ERROR_CAUSE_1, entityToString(response))).toString();
        }
        return msg.toString();
    }

    private SolrClusterResponse sendAndParseCreationRequest(Request request) {
        final Response response = execute(request);

        if (!(response.code() == 200)) {
            throw new RuntimeException(generateErrorMessage(response, ERROR_CREATING_CLUSTER_1));
        }
        return JsonSerializationUtils.fromJson(entityToString(response), SolrClusterResponse.class);
    }

    private void addCreationConfigToRequest(RequestBuilder creationRequest, SolrClusterCreationRequest creationConfig) {
        final String configJson = JsonSerializationUtils.toJsonString(creationConfig);
        creationRequest.withBodyContent("application/json", configJson);
    }
}

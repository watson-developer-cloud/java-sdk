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

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.HttpClusterLifecycleClient;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrCluster;

public class RetrieveAndRankSolrClusterDeleteExample {
    /**
     * The URL of the Watson Solr search service.
     */
    private static final String SERVICE_URL = "https://gateway.watsonplatform.net/retrieve-and-rank/api/v1";

    /**
     * The username for your Watson Solr search service.
     */
    private static final String USERNAME = "your-username";

    /**
     * The password for your Watson Solr search service.
     */
    private static final String PASSWORD = "your-password";

    /**
     * The Solr cluster ID of the Solr cluster to delete
     */
    private static final String SOLR_CLUSTER_ID = "your-solr-cluster-id";

    private static HttpClusterLifecycleClient clusterLifecycleClient;

    public static void main(String[] args) {
        clusterLifecycleClient = new HttpClusterLifecycleClient(SERVICE_URL);
        clusterLifecycleClient.setUsernameAndPassword(USERNAME, PASSWORD);

        try {
            deleteSolrCluster();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete a Solr cluster.
     */
    private static void deleteSolrCluster() {
        System.out.println("Deleting Solr cluster ID " + SOLR_CLUSTER_ID + "...");
        clusterLifecycleClient.deleteSolrCluster(SolrCluster.fromString(SOLR_CLUSTER_ID));

        System.out.println("Deleted Solr cluster.");
    }

    private RetrieveAndRankSolrClusterDeleteExample() {
        throw new UnsupportedOperationException(
                "RetrieveAndRankSolrClusterDeleteExample example cannot be instantiated!");
    }
}

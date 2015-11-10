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

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterList;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterOptions;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrCluster;

public class RetrieveAndRankSolrClusterCreateAndListExample {
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
     * A label you can use to differentiate your cluster in responses.
     */
    private static final String CLUSTER_NAME = "example_cluster";

    /**
     * The size of the Solr cluster to create. The empty string will create a free cluster. Otherwise specify an integer
     * number of units to create a cluster of that size.
     */
    private static final String CLUSTER_SIZE = "";

    private static HttpClusterLifecycleClient clusterLifecycleClient;

    private static String solrClusterId;

    public static void main(String[] args) {
        clusterLifecycleClient = new HttpClusterLifecycleClient(SERVICE_URL);
        clusterLifecycleClient.setUsernameAndPassword(USERNAME, PASSWORD);

        try {
            createSolrCluster();
            pollUntilClusterIsReady();
            listAllSolrClusters();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Submit a Solr cluster creation request.
     */
    private static void createSolrCluster() {
        System.out.println("Creating Solr cluster...");
        final SolrClusterOptions clusterOptions = new SolrClusterOptions(CLUSTER_NAME, CLUSTER_SIZE);
        final SolrCluster response = clusterLifecycleClient.createSolrCluster(clusterOptions);

        solrClusterId = response.getId();
        System.out.println("Solr cluster creation request submitted. ID: " + solrClusterId + "");
    }

    /**
     * Poll for the Solr cluster ID until it is ready.
     *
     * @throws InterruptedException
     */
    private static void pollUntilClusterIsReady() throws InterruptedException {
        System.out.println("Polling for Solr cluster status...");
        boolean isReady = false;

        while (!isReady) {
            final SolrCluster solrClusterResponse =
                    clusterLifecycleClient.pollSolrCluster(solrClusterId);
            if (solrClusterResponse.getStatus().equals(SolrCluster.Status.READY)) {
                System.out.println("Solr cluster is ready.");
                isReady = true;
            } else {
                System.out.println("Not ready...");
            }
            Thread.sleep(10000L);
        }
    }

    /**
     * Lists all Solr Clusters associated with this instance of the service.
     */
    private static void listAllSolrClusters() {
        System.out.println("Listing all Solr clusters...");
        final SolrClusterList solrClustersListResponse = clusterLifecycleClient.listSolrClusters();
        for (final SolrCluster solrCluster : solrClustersListResponse.getSolrClusterResponses()) {
            System.out.println(solrCluster.toString());
        }
    }

    private RetrieveAndRankSolrClusterCreateAndListExample() {
        throw new UnsupportedOperationException(
                "RetrieveAndRankSolrClusterCreateAndListExample example cannot be instantiated!");
    }
}

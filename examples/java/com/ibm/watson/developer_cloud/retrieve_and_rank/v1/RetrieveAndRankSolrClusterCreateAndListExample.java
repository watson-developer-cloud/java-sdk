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
package java.com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import java.net.URI;

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.HttpClusterLifecycleClient;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterListResponse;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterResponse;

public class RetrieveAndRankSolrClusterCreateAndListExample {
    /**
     * The URL of the Watson Solr search service.
     */
    private static final String SERVICE_URL = "{your-base-url}/retrieve-and-rank/api/v1";

    /**
     * The username for your Watson Solr search service.
     */
    private static final String USERNAME = "your-username";

    /**
     * The password for your Watson Solr search service.
     */
    private static final String PASSWORD = "your-password";

    private static HttpClusterLifecycleClient clusterLifecycleClient;

    private static String solrClusterId;

    public static void main(String[] args) {
        clusterLifecycleClient = new HttpClusterLifecycleClient(URI.create(SERVICE_URL), USERNAME, PASSWORD);

        try {
            createSolrCluster();
            pollUntilClusterIsReady();
            listAllSolrClusters();
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            cleanupResources();
        }
    }

    /**
     * Submit a Solr cluster creation request.
     */
    private static void createSolrCluster() {
        System.out.println("Creating Solr cluster...");
        final SolrClusterResponse response = clusterLifecycleClient.createSolrCluster();

        solrClusterId = response.getSolrClusterId();
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
            final SolrClusterResponse solrClusterResponse =
                    clusterLifecycleClient.pollSolrCluster(SolrCluster.fromString(solrClusterId));
            if (solrClusterResponse.getSolrClusterStatus().equals(SolrClusterResponse.Status.READY)) {
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
        final SolrClusterListResponse solrClustersListResponse = clusterLifecycleClient.listSolrClusters();

        for (final SolrClusterResponse solrCluster : solrClustersListResponse.getSolrClusterResponses()) {
            System.out.println("Found Solr cluster with ID: " + solrCluster.getSolrClusterId());
        }
    }

    /**
     * Cleanup the resources created via the example.
     */
    private static void cleanupResources() {
        System.out.println("Closing client...");
        clusterLifecycleClient.close();
        System.out.println("Client closed.");
    }

    private RetrieveAndRankSolrClusterCreateAndListExample() {
        throw new UnsupportedOperationException(
                "WatsonSolrClusterCreateAndListExample example cannot be instantiated!");
    }
}

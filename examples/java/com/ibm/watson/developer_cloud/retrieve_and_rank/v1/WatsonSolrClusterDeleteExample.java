package java.com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import java.net.URI;

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.HttpClusterLifecycleClient;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrCluster;

public class WatsonSolrClusterDeleteExample {
    /**
     * The URL of the Watson Solr search service.
     */
    private static final String SERVICE_URL = "{your-base-url}/search/api/v1";

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
    private static String SOLR_CLUSTER_ID = "your-solr-cluster-id";

    /**
     * Whether to delete all Solr clusters associated with the service instance
     */
    private static boolean DELETE_ALL_SOLR_CLUSTERS = false;

    private static HttpClusterLifecycleClient clusterLifecycleClient;

    public static void main(String[] args) {
        clusterLifecycleClient = new HttpClusterLifecycleClient(URI.create(SERVICE_URL), USERNAME, PASSWORD);

        try {
            deleteSolrCluster();
            if (DELETE_ALL_SOLR_CLUSTERS) {
                deleteAllSolrClusters();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            cleanupResources();
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

    /**
     * Deletes all Solr clusters associated with this instance of the service.
     */
    private static void deleteAllSolrClusters() {
        System.out.println("Deleting all Solr clusters...");
        clusterLifecycleClient.deleteSolrClusters();
        System.out.println("Deleted all Solr clusters.");
    }

    /**
     * Cleanup the resources created via the example.
     */
    private static void cleanupResources() {
        System.out.println("Closing client...");
        clusterLifecycleClient.close();
        System.out.println("Client closed.");
    }

    private WatsonSolrClusterDeleteExample() {
        throw new UnsupportedOperationException("WatsonSolrClusterDeleteExample example cannot be instantiated!");
    }
}

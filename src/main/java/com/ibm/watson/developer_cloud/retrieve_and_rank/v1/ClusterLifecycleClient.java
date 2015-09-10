package com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterCreationRequest;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterListResponse;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterResponse;

/**
 * A client for communicating with Watson Search lifecycle APIs.
 */
public interface ClusterLifecycleClient {
    /**
     * Creates a new Solr cluster.
     */
    SolrClusterResponse createSolrCluster();

    /**
     * Creates a new Solr cluster, based on the provided config object.
     */
    SolrClusterResponse createSolrCluster(SolrClusterCreationRequest creationConfig);

    /**
     * Deletes an existing Solr Cluster {@code solrCluster}.
     * <p/>
     * Reports success even if no corresponding cluster actually exists.
     */
    void deleteSolrCluster(SolrCluster solrCluster);

    /**
     * Deletes all Solr clusters currently associated with the service instance.
     */
    void deleteSolrClusters();

    /**
     * Checks whether a provided Solr cluster is ready for use.
     */
    SolrClusterResponse pollSolrCluster(SolrCluster solrCluster);

    /**
     * Lists all Solr clusters currently associated with the service instance.
     */
    SolrClusterListResponse listSolrClusters();
}

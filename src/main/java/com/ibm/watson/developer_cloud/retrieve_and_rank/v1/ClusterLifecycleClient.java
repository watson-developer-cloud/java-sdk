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

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterList;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models.SolrClusterOptions;

/**
 * A client for communicating with Watson Search lifecycle APIs.
 */
public interface ClusterLifecycleClient {
    /**
     * Creates a new Solr cluster.
     */
    SolrCluster createSolrCluster();

    /**
     * Creates a new Solr cluster, based on the provided config object.
     */
    SolrCluster createSolrCluster(SolrClusterOptions creationConfig);

    /**
     * Deletes an existing Solr Cluster {@code solrCluster}.
     * <p/>
     * Reports success even if no corresponding cluster actually exists.
     */
    void deleteSolrCluster(String solrClusterId);

    /**
     * Checks whether a provided Solr cluster is ready for use.
     */
    SolrCluster pollSolrCluster(String solrClusterId);

    /**
     * Lists all Solr clusters currently associated with the service instance.
     */
    SolrClusterList listSolrClusters();
}

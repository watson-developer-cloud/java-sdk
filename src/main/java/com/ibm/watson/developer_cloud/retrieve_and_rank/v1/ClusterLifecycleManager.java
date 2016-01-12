/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterList;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterOptions;

/**
 * A client for communicating with the Retrieve and Rank API.
 */
public interface ClusterLifecycleManager {

  /**
   * Creates a new Solr cluster.
   * 
   * @return the Solr cluster
   */
  SolrCluster createSolrCluster();

  /**
   * Creates a new Solr cluster, based on the provided configuration.
   * 
   * @param solrClusterConfig the solr cluster configuration
   * @return the Solr cluster
   */
  SolrCluster createSolrCluster(SolrClusterOptions solrClusterConfig);

  /**
   * Deletes an existing Solr Cluster {@code SolrCluster}. <br>
   * Reports success even if no corresponding cluster actually exists.
   * 
   * @param SolrClusterId the Solr cluster id
   */
  void deleteSolrCluster(String SolrClusterId);

  /**
   * Returns a Solr cluster information.
   * 
   * @param SolrClusterId the Solr cluster id
   * @return the Solr cluster
   */
  SolrCluster getSolrCluster(String SolrClusterId);

  /**
   * Lists all Solr clusters currently associated with the service instance.
   * 
   * @return the Solr cluster list
   */
  SolrClusterList getSolrClusters();
}

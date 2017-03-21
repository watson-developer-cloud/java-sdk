/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.ApiConstants.CLUSTER_NAME;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.ApiConstants.CLUSTER_SIZE;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.ApiConstants.SOLR_CLUSTER_ID;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.ApiConstants.SOLR_CLUSTER_STATUS;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Response from a provisioned Solr Cluster.
 */
public class SolrCluster extends GenericModel {

  /**
   * Solr Cluster Status.
   */
  public enum Status {

    /** Ready. */
    READY,

    /** Not available. */
    NOT_AVAILABLE
  }

  @SerializedName(SOLR_CLUSTER_ID)
  private final String solrClusterId;
  @SerializedName(CLUSTER_NAME)
  private final String solrClusterName;
  @SerializedName(CLUSTER_SIZE)
  private final String solrClusterSize;
  @SerializedName(SOLR_CLUSTER_STATUS)
  private final Status solrClusterStatus;

  /**
   * Instantiates a new Solr cluster.
   *
   * @param solrClusterId the Solr cluster id
   * @param solrClusterName the Solr cluster name
   * @param solrClusterSize the Solr cluster size
   * @param solrClusterStatus the Solr cluster status
   */
  public SolrCluster(final String solrClusterId, final String solrClusterName, final String solrClusterSize,
      final Status solrClusterStatus) {
    this.solrClusterId = solrClusterId;
    this.solrClusterName = solrClusterName;
    this.solrClusterSize = solrClusterSize;
    this.solrClusterStatus = solrClusterStatus;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return solrClusterId;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return solrClusterName;
  }

  /**
   * Gets the size of the cluster. Size will either be an integer number of units or the empty string in the case of a
   * free cluster.
   *
   * @return the size
   */
  public String getSize() {
    return solrClusterSize;
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public Status getStatus() {
    return solrClusterStatus;
  }

}

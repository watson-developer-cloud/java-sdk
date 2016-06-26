/*
 * BEGIN_COPYRIGHT
 *
 * IBM Confidential OCO Source Materials
 *
 * 5725-Y07 (C) Copyright IBM Corp. 2016 All Rights Reserved.
 *
 * The source code for this program is not published or otherwise divested of its trade secrets,
 * irrespective of what has been deposited with the U.S. Copyright Office.
 *
 * END_COPYRIGHT
 */
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;


import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.ApiConstants.*;

import com.google.gson.annotations.SerializedName;

/**
 * A value type for the JSON body provided when creating a Solr resize request.
 */
public class SolrClusterResizeRequest {

  @SerializedName(CLUSTER_SIZE)
  private final int clusterSize;

  /**
   * Instantiates a cluster resize request
   *
   * @param clusterSize the desired cluster size
   */
  public SolrClusterResizeRequest(final int clusterSize) {
    this.clusterSize = clusterSize;
  }

  @SerializedName(CLUSTER_SIZE)
  public int getClusterSize() {
    return clusterSize;
  }

}

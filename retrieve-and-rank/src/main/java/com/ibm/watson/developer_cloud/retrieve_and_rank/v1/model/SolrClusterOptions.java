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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * A value type for the JSON body provided when creating a Solr cluster.
 */
public class SolrClusterOptions {
  private static final String FREE_CLUSTER_SIZE = "";

  @SerializedName(CLUSTER_NAME)
  private final String clusterName;
  @SerializedName(CLUSTER_SIZE)
  private final String clusterSize;

  /**
   * Instantiates options to create a new Solr cluster of the specified size.
   *
   * @param clusterName the cluster name
   * @param clusterSize the cluster size
   */
  public SolrClusterOptions(String clusterName, Integer clusterSize) {
    this.clusterName = clusterName;
    if (clusterSize == null) {
      this.clusterSize = FREE_CLUSTER_SIZE;
    } else {
      Validator.isTrue((clusterSize > 0), "clusterSize cannot be lower than 0");
      this.clusterSize = clusterSize.toString();
    }
  }

  /**
   * Instantiates options to create a new free Solr cluster.
   *
   * @param clusterName the cluster name
   */
  public SolrClusterOptions(String clusterName) {
    this.clusterName = clusterName;
    clusterSize = FREE_CLUSTER_SIZE;
  }

  /**
   * Gets the cluster name.
   *
   * @return the cluster name
   */
  public String clusterName() {
    return clusterName;
  }

  /**
   * Gets the cluster size. Null implies a free cluster.
   *
   * @return the cluster size
   */
  public Integer clusterSize() {
    if (FREE_CLUSTER_SIZE.equals(clusterSize)) {
      return null;
    }
    return Integer.valueOf(clusterSize);
  }

}

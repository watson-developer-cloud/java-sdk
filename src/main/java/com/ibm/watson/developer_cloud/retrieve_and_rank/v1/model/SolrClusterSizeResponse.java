/*
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
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.ApiConstants.*;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The status of a Solr Cluster Resize request.
 */
public class SolrClusterSizeResponse extends GenericModel {

  /**
   * The Enum Status.
   */
  public enum Status {
    
    /** The resizing. */
    RESIZING,
    
    /** The error. */
    ERROR
  }

  @SerializedName(CLUSTER_ID)
  private final String clusterId;
  @SerializedName(CLUSTER_SIZE)
  private final Integer currentSize;
  @SerializedName(TARGET_CLUSTER_SIZE)
  private final Integer targetSize;
  @SerializedName(RESIZE_STATUS)
  private final Status status;
  @SerializedName(RESIZE_MESSAGE)
  private final String message;

  /**
   * Instantiates a resize request response.
   *
   * @param clusterId the cluster Id
   * @param currentSize the cluster size
   * @param targetSize size to resize the cluster to
   * @param message response message from the R&R service
   * @param status The status of the resize process
   */
  public SolrClusterSizeResponse(final String clusterId, final Integer currentSize, final Integer targetSize,
      final String message, final Status status) {
    this.clusterId = clusterId;
    this.status = status;
    this.currentSize = currentSize;
    this.targetSize = targetSize;
    this.message = message;
  }

  /**
   * Instantiates size request response for a cluster that's not being resized currently.
   *
   * @param clusterId the cluster Id
   * @param currentSize the cluster size
   * @param message response message from the R&R service.
   */
  public SolrClusterSizeResponse(final String clusterId, final Integer currentSize, final String message) {
    this.clusterId = clusterId;
    this.status = null;
    this.currentSize = currentSize;
    this.targetSize = null;
    this.message = message;
  }

  /**
   * Ge cluster id.
   *
   * @return the string
   */
  @SerializedName(CLUSTER_ID)
  public String geClusterId() {
    return clusterId;
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  @SerializedName(RESIZE_STATUS)
  public Status getStatus() {
    return status;
  }

  /**
   * Gets the current size.
   *
   * @return the current size
   */
  @SerializedName(CLUSTER_SIZE)
  public Integer getCurrentSize() {
    return currentSize;
  }

  /**
   * Gets the target size.
   *
   * @return the target size
   */
  @SerializedName(TARGET_CLUSTER_SIZE)
  public Integer getTargetSize() {
    return targetSize;
  }

  /**
   * Gets the message.
   *
   * @return the message
   */
  @SerializedName(RESIZE_MESSAGE)
  public String getMessage() {
    return message;
  }
}
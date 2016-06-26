/* BEGIN_COPYRIGHT
 *
 * IBM Confidential
 * OCO Source Materials
 *
 * 5725-Y07
 * (C) Copyright IBM Corp. 2016 All Rights Reserved.
 *
 * The source code for this program is not published or otherwise
 * divested of its trade secrets, irrespective of what has been
 * deposited with the U.S. Copyright Office.
 *
 * END_COPYRIGHT
 */
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.ApiConstants.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The status of a Solr Cluster Resize request.
 */
public class SolrClusterSizeResponse extends GenericModel {

  public enum Status {
    RESIZING,
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

  @SerializedName(CLUSTER_ID)
  public String geClusterId() {
    return clusterId;
  }

  @SerializedName(RESIZE_STATUS)
  public Status getStatus() {
    return status;
  }

  @SerializedName(CLUSTER_SIZE)
  public Integer getCurrentSize() {
    return currentSize;
  }

  @SerializedName(TARGET_CLUSTER_SIZE)
  public Integer getTargetSize() {
    return targetSize;
  }

  @SerializedName(RESIZE_MESSAGE)
  public String getMessage() {
    return message;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final SolrClusterSizeResponse other = (SolrClusterSizeResponse) obj;
    return new EqualsBuilder()
        .append(clusterId, other.clusterId)
        .append(currentSize, other.currentSize)
        .append(targetSize, other.targetSize)
        .append(message, other.message)
        .append(status, other.status)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(clusterId)
        .append(currentSize)
        .append(targetSize)
        .append(message)
        .append(status)
        .toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("clusterId", clusterId)
        .append("currentSize", currentSize)
        .append("targetSize", targetSize)
        .append("message", message)
        .append("status", status)
        .toString();
  }

}
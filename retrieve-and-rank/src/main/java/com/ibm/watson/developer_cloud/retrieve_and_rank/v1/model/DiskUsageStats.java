/*
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

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.ApiConstants.PERCENT_USED;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.ApiConstants.READABLE_TOTAL_RESOURCES;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.ApiConstants.READABLE_USED_RESOURCES;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.ApiConstants.TOTAL_RESOURCES_IN_BYTES;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.ApiConstants.USED_RESOURCES_IN_BYTES;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Disk Usage Stats.
 */
public class DiskUsageStats extends GenericModel {

  @SerializedName(USED_RESOURCES_IN_BYTES)
  private final long usedBytes;
  @SerializedName(TOTAL_RESOURCES_IN_BYTES)
  private final long totalBytes;
  @SerializedName(READABLE_USED_RESOURCES)
  private final String used;
  @SerializedName(READABLE_TOTAL_RESOURCES)
  private final String total;
  @SerializedName(PERCENT_USED)
  private final double percentUsed;

  /**
   * Instantiates a new disk usage stats.
   *
   * @param usedBytes the used bytes
   * @param totalBytes the total bytes
   * @param used the used
   * @param total the total
   * @param percentUsed the percent used
   */
  public DiskUsageStats(final long usedBytes, final long totalBytes, final String used, final String total,
      final double percentUsed) {
    this.usedBytes = usedBytes;
    this.totalBytes = totalBytes;
    this.used = used;
    this.total = total;
    this.percentUsed = percentUsed;
  }

  /**
   * Gets the used.
   *
   * @return the used
   */
  public String getUsed() {
    return used;
  }

  /**
   * Gets the used bytes.
   *
   * @return the used bytes
   */
  public long getUsedBytes() {
    return usedBytes;
  }

  /**
   * Gets the total.
   *
   * @return the total
   */
  public String getTotal() {
    return total;
  }

  /**
   * Gets the total bytes.
   *
   * @return the total bytes
   */
  public long getTotalBytes() {
    return totalBytes;
  }

  /**
   * Gets the percent used.
   *
   * @return the percent used
   */
  public double getPercentUsed() {
    return percentUsed;
  }
}

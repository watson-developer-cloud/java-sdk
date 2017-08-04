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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Summary of the disk usage statistics for the environment.
 */
public class DiskUsage extends GenericModel {

  @SerializedName("used_bytes")
  private Long usedBytes;
  @SerializedName("maximum_allowed_bytes")
  private Long maximumAllowedBytes;
  @SerializedName("total_bytes")
  private Long totalBytes;
  private String used;
  private String total;
  @SerializedName("percent_used")
  private Double percentUsed;

  /**
   * Gets the usedBytes.
   *
   * Number of bytes used on the environment's disk capacity.
   *
   * @return the usedBytes
   */
  public Long getUsedBytes() {
    return usedBytes;
  }

  /**
   * Gets the maximumAllowedBytes.
   *
   * Total number of bytes available in the environment's disk capacity.
   *
   * @return the maximumAllowedBytes
   */
  public Long getMaximumAllowedBytes() {
    return maximumAllowedBytes;
  }

  /**
   * Gets the totalBytes.
   *
   * **Deprecated**: Total number of bytes available in the environment's disk capacity.
   *
   * @return the totalBytes
   */
  public Long getTotalBytes() {
    return totalBytes;
  }

  /**
   * Gets the used.
   *
   * **Deprecated**: Amount of disk capacity used, in KB or GB format.
   *
   * @return the used
   */
  public String getUsed() {
    return used;
  }

  /**
   * Gets the total.
   *
   * **Deprecated**: Total amount of the environment's disk capacity, in KB or GB format.
   *
   * @return the total
   */
  public String getTotal() {
    return total;
  }

  /**
   * Gets the percentUsed.
   *
   * **Deprecated**: Percentage of the environment's disk capacity that is being used.
   *
   * @return the percentUsed
   */
  public Double getPercentUsed() {
    return percentUsed;
  }
}

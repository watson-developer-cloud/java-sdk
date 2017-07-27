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
 * Summary of the memory usage statistics for this environment.
 */
public class MemoryUsage extends GenericModel {

  /** Number of bytes used in the environment's memory capacity. */
  @SerializedName("used_bytes")
  private Long usedBytes;
  /** Total number of bytes available in the environment's memory capacity. */
  @SerializedName("total_bytes")
  private Long totalBytes;
  /** Amount of memory capacity used, in KB or GB format. */
  private String used;
  /** Total amount of the environment's memory capacity, in KB or GB format. */
  private String total;
  /** Percentage of the environment's memory capacity that is being used. */
  @SerializedName("percent_used")
  private Double percentUsed;

  /**
   * Gets the usedBytes.
   *
   * @return the usedBytes
   */
  public Long getUsedBytes() {
    return usedBytes;
  }

  /**
   * Gets the totalBytes.
   *
   * @return the totalBytes
   */
  public Long getTotalBytes() {
    return totalBytes;
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
   * Gets the total.
   *
   * @return the total
   */
  public String getTotal() {
    return total;
  }

  /**
   * Gets the percentUsed.
   *
   * @return the percentUsed
   */
  public Double getPercentUsed() {
    return percentUsed;
  }
}

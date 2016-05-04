/**
 * Copyright 2016 IBM Corp. All Rights Reserved.
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

public class MemoryUsageStats extends GenericModel {

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

  public MemoryUsageStats(final long usedBytes, final long totalBytes, final String used,
      final String total, final double percentUsed) {
    this.usedBytes = usedBytes;
    this.totalBytes = totalBytes;
    this.used = used;
    this.total = total;
    this.percentUsed = percentUsed;
  }

  public String getUsed() {
    return used;
  }

  public long getUsedBytes() {
    return usedBytes;
  }

  public String getTotal() {
    return total;
  }

  public long getTotalBytes() {
    return totalBytes;
  }

  public double getPercentUsed() {
    return percentUsed;
  }
}

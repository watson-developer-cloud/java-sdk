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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Solr Cluster Stats.
 */
public class SolrClusterStats extends GenericModel {
  @SerializedName(ApiConstants.DISK_USAGE)
  private final DiskUsageStats diskUsage;
  @SerializedName(ApiConstants.MEMORY_USAGE)
  private final MemoryUsageStats memoryUsage;

  /**
   * Instantiates a new solr cluster stats.
   *
   * @param diskUsage the disk usage
   * @param memoryUsage the memory usage
   */
  public SolrClusterStats(final DiskUsageStats diskUsage, final MemoryUsageStats memoryUsage) {
    this.diskUsage = diskUsage;
    this.memoryUsage = memoryUsage;
  }

  /**
   * Gets the disk usage.
   *
   * @return the disk usage
   */
  public DiskUsageStats getDiskUsage() {
    return diskUsage;
  }

  /**
   * Gets the memory usage.
   *
   * @return the memory usage
   */
  public MemoryUsageStats getMemoryUsage() {
    return memoryUsage;
  }
}

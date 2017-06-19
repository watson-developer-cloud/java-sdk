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
 * Details about the disk and memory usage of this environment.
 */
public class IndexCapacity extends GenericModel {

  /** Summary of the disk usage of the environment. */
  @SerializedName("disk_usage")
  private DiskUsage diskUsage;
  /** Summary of the memory usage of the environment. */
  @SerializedName("memory_usage")
  private MemoryUsage memoryUsage;

  /**
   * Gets the diskUsage.
   *
   * @return the diskUsage
   */
  public DiskUsage getDiskUsage() {
    return diskUsage;
  }

  /**
   * Gets the memoryUsage.
   *
   * @return the memoryUsage
   */
  public MemoryUsage getMemoryUsage() {
    return memoryUsage;
  }

  /**
   * Sets the diskUsage.
   *
   * @param diskUsage the new diskUsage
   */
  public void setDiskUsage(final DiskUsage diskUsage) {
    this.diskUsage = diskUsage;
  }

  /**
   * Sets the memoryUsage.
   *
   * @param memoryUsage the new memoryUsage
   */
  public void setMemoryUsage(final MemoryUsage memoryUsage) {
    this.memoryUsage = memoryUsage;
  }
}

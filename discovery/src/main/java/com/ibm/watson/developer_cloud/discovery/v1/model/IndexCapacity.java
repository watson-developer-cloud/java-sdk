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
 * Details about the resource usage and capacity of the environment.
 */
public class IndexCapacity extends GenericModel {

  private EnvironmentDocuments documents;
  @SerializedName("disk_usage")
  private DiskUsage diskUsage;
  private CollectionUsage collections;
  @SerializedName("memory_usage")
  private MemoryUsage memoryUsage;

  /**
   * Gets the documents.
   *
   * Summary of the document usage statistics for the environment
   *
   * @return the documents
   */
  public EnvironmentDocuments getDocuments() {
    return documents;
  }

  /**
   * Gets the diskUsage.
   *
   * Summary of the disk usage of the environment.
   *
   * @return the diskUsage
   */
  public DiskUsage getDiskUsage() {
    return diskUsage;
  }

  /**
   * Gets the collections.
   *
   * Summary of the collection usage in the environment
   *
   * @return the collections
   */
  public CollectionUsage getCollections() {
    return collections;
  }

  /**
   * Gets the memoryUsage.
   *
   * **Deprecated**: Summary of the memory usage of the environment.
   *
   * @return the memoryUsage
   */
  public MemoryUsage getMemoryUsage() {
    return memoryUsage;
  }

  /**
   * Sets the documents.
   *
   * @param documents the new documents
   */
  public void setDocuments(final EnvironmentDocuments documents) {
    this.documents = documents;
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
   * Sets the collections.
   *
   * @param collections the new collections
   */
  public void setCollections(final CollectionUsage collections) {
    this.collections = collections;
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

/*
 * (C) Copyright IBM Corp. 2017, 2023.
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
package com.ibm.watson.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Details about the resource usage and capacity of the environment. */
public class IndexCapacity extends GenericModel {

  protected EnvironmentDocuments documents;

  @SerializedName("disk_usage")
  protected DiskUsage diskUsage;

  protected CollectionUsage collections;

  protected IndexCapacity() {}

  /**
   * Gets the documents.
   *
   * <p>Summary of the document usage statistics for the environment.
   *
   * @return the documents
   */
  public EnvironmentDocuments getDocuments() {
    return documents;
  }

  /**
   * Gets the diskUsage.
   *
   * <p>Summary of the disk usage statistics for the environment.
   *
   * @return the diskUsage
   */
  public DiskUsage getDiskUsage() {
    return diskUsage;
  }

  /**
   * Gets the collections.
   *
   * <p>Summary of the collection usage in the environment.
   *
   * @return the collections
   */
  public CollectionUsage getCollections() {
    return collections;
  }
}

/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

/**
 * Object that defines a box folder to crawl with this configuration.
 */
public class SourceOptionsFolder extends GenericModel {

  @SerializedName("owner_user_id")
  private String ownerUserId;
  @SerializedName("folder_id")
  private String folderId;
  private Long limit;

  /**
   * Gets the ownerUserId.
   *
   * The Box user ID of the user who owns the folder to crawl.
   *
   * @return the ownerUserId
   */
  public String getOwnerUserId() {
    return ownerUserId;
  }

  /**
   * Gets the folderId.
   *
   * The Box folder ID of the folder to crawl.
   *
   * @return the folderId
   */
  public String getFolderId() {
    return folderId;
  }

  /**
   * Gets the limit.
   *
   * The maximum number of documents to crawl for this folder. By default, all documents in the folder are crawled.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Sets the ownerUserId.
   *
   * @param ownerUserId the new ownerUserId
   */
  public void setOwnerUserId(final String ownerUserId) {
    this.ownerUserId = ownerUserId;
  }

  /**
   * Sets the folderId.
   *
   * @param folderId the new folderId
   */
  public void setFolderId(final String folderId) {
    this.folderId = folderId;
  }

  /**
   * Sets the limit.
   *
   * @param limit the new limit
   */
  public void setLimit(final long limit) {
    this.limit = limit;
  }
}

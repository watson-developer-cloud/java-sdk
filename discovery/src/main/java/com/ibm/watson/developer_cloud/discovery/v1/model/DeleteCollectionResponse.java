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
 * DeleteCollectionResponse.
 */
public class DeleteCollectionResponse extends GenericModel {

  /**
   * The status of the collection. The status of a successful deletion operation is `deleted`.
   */
  public interface Status {
    /** deleted. */
    String DELETED = "deleted";
  }

  @SerializedName("collection_id")
  private String collectionId;
  private String status;

  /**
   * Gets the collectionId.
   *
   * The unique identifier of the collection that is being deleted.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return collectionId;
  }

  /**
   * Gets the status.
   *
   * The status of the collection. The status of a successful deletion operation is `deleted`.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets the collectionId.
   *
   * @param collectionId the new collectionId
   */
  public void setCollectionId(final String collectionId) {
    this.collectionId = collectionId;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(final String status) {
    this.status = status;
  }
}

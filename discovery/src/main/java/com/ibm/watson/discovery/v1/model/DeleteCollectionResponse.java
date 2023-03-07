/*
 * (C) Copyright IBM Corp. 2023.
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

/** Response object returned when deleting a colleciton. */
public class DeleteCollectionResponse extends GenericModel {

  /** The status of the collection. The status of a successful deletion operation is `deleted`. */
  public interface Status {
    /** deleted. */
    String DELETED = "deleted";
  }

  @SerializedName("collection_id")
  protected String collectionId;

  protected String status;

  protected DeleteCollectionResponse() {}

  /**
   * Gets the collectionId.
   *
   * <p>The unique identifier of the collection that is being deleted.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return collectionId;
  }

  /**
   * Gets the status.
   *
   * <p>The status of the collection. The status of a successful deletion operation is `deleted`.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }
}

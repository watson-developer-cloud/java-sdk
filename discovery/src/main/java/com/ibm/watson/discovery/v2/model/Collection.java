/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.discovery.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A collection for storing documents.
 */
public class Collection extends GenericModel {

  @SerializedName("collection_id")
  protected String collectionId;
  protected String name;

  /**
   * Gets the collectionId.
   *
   * The unique identifier of the collection.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return collectionId;
  }

  /**
   * Gets the name.
   *
   * The name of the collection.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }
}

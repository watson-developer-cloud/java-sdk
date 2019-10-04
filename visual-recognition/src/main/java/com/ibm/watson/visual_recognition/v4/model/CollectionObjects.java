/*
 * (C) Copyright IBM Corp. 2019.
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
package com.ibm.watson.visual_recognition.v4.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The objects in a collection that are detected in an image.
 */
public class CollectionObjects extends GenericModel {

  @SerializedName("collection_id")
  private String collectionId;
  private List<ObjectDetail> objects;

  /**
   * Gets the collectionId.
   *
   * The identifier of the collection.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return collectionId;
  }

  /**
   * Gets the objects.
   *
   * The identified objects in a collection.
   *
   * @return the objects
   */
  public List<ObjectDetail> getObjects() {
    return objects;
  }
}

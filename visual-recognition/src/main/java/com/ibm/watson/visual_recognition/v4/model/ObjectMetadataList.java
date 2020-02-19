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
package com.ibm.watson.visual_recognition.v4.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * List of objects.
 */
public class ObjectMetadataList extends GenericModel {

  @SerializedName("object_count")
  protected Long objectCount;
  protected List<ObjectMetadata> objects;

  /**
   * Gets the objectCount.
   *
   * Number of unique named objects in the collection.
   *
   * @return the objectCount
   */
  public Long getObjectCount() {
    return objectCount;
  }

  /**
   * Gets the objects.
   *
   * The objects in the collection.
   *
   * @return the objects
   */
  public List<ObjectMetadata> getObjects() {
    return objects;
  }
}


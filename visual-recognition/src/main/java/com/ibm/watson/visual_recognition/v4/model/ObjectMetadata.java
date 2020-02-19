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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Basic information about an object.
 */
public class ObjectMetadata extends GenericModel {

  protected String object;
  protected Long count;

  /**
   * Gets the object.
   *
   * The name of the object.
   *
   * @return the object
   */
  public String getObject() {
    return object;
  }

  /**
   * Gets the count.
   *
   * Number of bounding boxes with this object name in the collection.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }
}


/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
 * Details about an object in the collection.
 */
public class ObjectDetail extends GenericModel {

  protected String object;
  protected Location location;
  protected Float score;

  /**
   * Gets the object.
   *
   * The label for the object.
   *
   * @return the object
   */
  public String getObject() {
    return object;
  }

  /**
   * Gets the location.
   *
   * Defines the location of the bounding box around the object.
   *
   * @return the location
   */
  public Location getLocation() {
    return location;
  }

  /**
   * Gets the score.
   *
   * Confidence score for the object in the range of 0 to 1. A higher score indicates greater likelihood that the object
   * is depicted at this location in the image.
   *
   * @return the score
   */
  public Float getScore() {
    return score;
  }
}

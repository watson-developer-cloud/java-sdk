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

/** Defines the location of the bounding box around the object. */
public class ObjectDetailLocation extends GenericModel {

  protected Long top;
  protected Long left;
  protected Long width;
  protected Long height;

  /**
   * Gets the top.
   *
   * <p>Y-position of top-left pixel of the bounding box.
   *
   * @return the top
   */
  public Long getTop() {
    return top;
  }

  /**
   * Gets the left.
   *
   * <p>X-position of top-left pixel of the bounding box.
   *
   * @return the left
   */
  public Long getLeft() {
    return left;
  }

  /**
   * Gets the width.
   *
   * <p>Width in pixels of of the bounding box.
   *
   * @return the width
   */
  public Long getWidth() {
    return width;
  }

  /**
   * Gets the height.
   *
   * <p>Height in pixels of the bounding box.
   *
   * @return the height
   */
  public Long getHeight() {
    return height;
  }
}

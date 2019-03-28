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
package com.ibm.watson.visual_recognition.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The location of the bounding box around the face.
 */
public class FaceLocation extends GenericModel {

  private Double width;
  private Double height;
  private Double left;
  private Double top;

  /**
   * Gets the width.
   *
   * Width in pixels of face region.
   *
   * @return the width
   */
  public Double getWidth() {
    return width;
  }

  /**
   * Gets the height.
   *
   * Height in pixels of face region.
   *
   * @return the height
   */
  public Double getHeight() {
    return height;
  }

  /**
   * Gets the left.
   *
   * X-position of top-left pixel of face region.
   *
   * @return the left
   */
  public Double getLeft() {
    return left;
  }

  /**
   * Gets the top.
   *
   * Y-position of top-left pixel of face region.
   *
   * @return the top
   */
  public Double getTop() {
    return top;
  }
}

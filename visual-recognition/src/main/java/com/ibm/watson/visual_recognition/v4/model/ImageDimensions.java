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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Height and width of an image.
 */
public class ImageDimensions extends GenericModel {

  private Long height;
  private Long width;

  /**
   * Gets the height.
   *
   * Height in pixels of the image.
   *
   * @return the height
   */
  public Long getHeight() {
    return height;
  }

  /**
   * Gets the width.
   *
   * Width in pixels of the image.
   *
   * @return the width
   */
  public Long getWidth() {
    return width;
  }
}

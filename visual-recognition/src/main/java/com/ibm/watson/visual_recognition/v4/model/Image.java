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
 * Details about an image.
 */
public class Image extends GenericModel {

  private ImageSource source;
  private ImageDimensions dimensions;
  private DetectedObjects objects;
  private Error errors;

  /**
   * Gets the source.
   *
   * The source type of the image.
   *
   * @return the source
   */
  public ImageSource getSource() {
    return source;
  }

  /**
   * Gets the dimensions.
   *
   * Height and width of an image.
   *
   * @return the dimensions
   */
  public ImageDimensions getDimensions() {
    return dimensions;
  }

  /**
   * Gets the objects.
   *
   * Container for the list of collections that have objects detected in an image.
   *
   * @return the objects
   */
  public DetectedObjects getObjects() {
    return objects;
  }

  /**
   * Gets the errors.
   *
   * Details about an error.
   *
   * @return the errors
   */
  public Error getErrors() {
    return errors;
  }
}

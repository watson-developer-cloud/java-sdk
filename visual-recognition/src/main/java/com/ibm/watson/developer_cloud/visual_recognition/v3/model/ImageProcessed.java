/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;

/**
 * processed image.
 *
 * @see VisualRecognition
 */
public class ImageProcessed {

  @SerializedName("source_url")
  private String sourceUrl;
  @SerializedName("resolved_url")
  private String resolvedUrl;
  private String image;
  private ImageProcessingError error;

  /**
   * Gets the source url.
   *
   * @return The sourceUrl
   */
  public String getSourceUrl() {
    return sourceUrl;
  }

  /**
   * Sets the source url.
   *
   * @param sourceUrl The source_url
   */
  public void setSourceUrl(String sourceUrl) {
    this.sourceUrl = sourceUrl;
  }

  /**
   * Gets the resolved url.
   *
   * @return The resolvedUrl
   */
  public String getResolvedUrl() {
    return resolvedUrl;
  }

  /**
   * Sets the resolved url.
   *
   * @param resolvedUrl The resolved_url
   */
  public void setResolvedUrl(String resolvedUrl) {
    this.resolvedUrl = resolvedUrl;
  }

  /**
   * Gets the image.
   *
   * @return The image
   */
  public String getImage() {
    return image;
  }

  /**
   * Sets the image.
   *
   * @param image The image
   */
  public void setImage(String image) {
    this.image = image;
  }

  /**
   * Gets the error.
   *
   * @return The error
   */
  public ImageProcessingError getError() {
    return error;
  }

  /**
   * Sets the error.
   *
   * @param error The error
   */
  public void setError(ImageProcessingError error) {
    this.error = error;
  }

}

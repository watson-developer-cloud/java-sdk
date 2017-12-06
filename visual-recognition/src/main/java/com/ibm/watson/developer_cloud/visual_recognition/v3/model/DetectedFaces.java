/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * DetectedFaces.
 */
public class DetectedFaces extends GenericModel {

  @SerializedName("images_processed")
  private Long imagesProcessed;
  private List<ImageWithFaces> images;
  private List<WarningInfo> warnings;

  /**
   * Gets the imagesProcessed.
   *
   * Number of images processed for the API call.
   *
   * @return the imagesProcessed
   */
  public Long getImagesProcessed() {
    return imagesProcessed;
  }

  /**
   * Gets the images.
   *
   * The array of images.
   *
   * @return the images
   */
  public List<ImageWithFaces> getImages() {
    return images;
  }

  /**
   * Gets the warnings.
   *
   * Information about what might cause less than optimal output. For example, a request sent with a corrupt .zip file
   * and a list of image URLs will still complete, but does not return the expected output. Not returned when there is
   * no warning.
   *
   * @return the warnings
   */
  public List<WarningInfo> getWarnings() {
    return warnings;
  }

  /**
   * Sets the imagesProcessed.
   *
   * @param imagesProcessed the new imagesProcessed
   */
  public void setImagesProcessed(final long imagesProcessed) {
    this.imagesProcessed = imagesProcessed;
  }

  /**
   * Sets the images.
   *
   * @param images the new images
   */
  public void setImages(final List<ImageWithFaces> images) {
    this.images = images;
  }

  /**
   * Sets the warnings.
   *
   * @param warnings the new warnings
   */
  public void setWarnings(final List<WarningInfo> warnings) {
    this.warnings = warnings;
  }
}

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
 * Classify results for multiple images.
 */
public class ClassifiedImages extends GenericModel {

  @SerializedName("custom_classes")
  private Long customClasses;
  @SerializedName("images_processed")
  private Long imagesProcessed;
  private List<ClassifiedImage> images;
  private List<WarningInfo> warnings;

  /**
   * Gets the customClasses.
   *
   * The number of custom classes identified in the images.
   *
   * @return the customClasses
   */
  public Long getCustomClasses() {
    return customClasses;
  }

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
   * The array of classified images.
   *
   * @return the images
   */
  public List<ClassifiedImage> getImages() {
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
   * Sets the customClasses.
   *
   * @param customClasses the new customClasses
   */
  public void setCustomClasses(final long customClasses) {
    this.customClasses = customClasses;
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
  public void setImages(final List<ClassifiedImage> images) {
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

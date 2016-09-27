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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;


/**
 * Generic model for {@link VisualRecognition} methods.
 *
 * @param <T> the generic type
 * @see VisualRecognition
 */
public class VisualRecognitionGenericModel<T extends ImageProcessed> extends GenericModel {

  @SerializedName("images_processed")
  private Integer imagesProcessed;
  private List<T> images;
  private List<ImageProcessingWarning> warnings;

  /**
   * Gets the images processed.
   *
   * @return The imagesProcessed
   */
  public Integer getImagesProcessed() {
    return imagesProcessed;
  }

  /**
   * Sets the images processed.
   *
   * @param imagesProcessed The images_processed
   */
  public void setImagesProcessed(Integer imagesProcessed) {
    this.imagesProcessed = imagesProcessed;
  }

  /**
   * Gets the images.
   *
   * @return The images
   */
  public List<T> getImages() {
    return images;
  }

  /**
   * Sets the images.
   *
   * @param images The images
   */
  public void setImages(List<T> images) {
    this.images = images;
  }

  /**
   * Gets the warnings.
   *
   * @return The warnings
   */
  public List<ImageProcessingWarning> getWarnings() {
    return warnings;
  }

  /**
   * Sets the warnings.
   *
   * @param warnings The warnings
   */
  public void setWarnings(List<ImageProcessingWarning> warnings) {
    this.warnings = warnings;
  }

}

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
 * List of similar images. Maximum response size 200 kB.
 */
public class SimilarImages extends GenericModel {

  @SerializedName("similar_images")
  private List<CollectionImage> similarImages;
  @SerializedName("images_processed")
  private Double imagesProcessed;

  /**
   * Gets the similarImages.
   *
   * @return the similarImages
   */
  public List<CollectionImage> getSimilarImages() {
    return similarImages;
  }

  /**
   * Gets the imagesProcessed.
   *
   * The number of images processed in this call.
   *
   * @return the imagesProcessed
   */
  public Double getImagesProcessed() {
    return imagesProcessed;
  }

  /**
   * Sets the similarImages.
   *
   * @param similarImages the new similarImages
   */
  public void setSimilarImages(final List<CollectionImage> similarImages) {
    this.similarImages = similarImages;
  }

  /**
   * Sets the imagesProcessed.
   *
   * @param imagesProcessed the new imagesProcessed
   */
  public void setImagesProcessed(final Double imagesProcessed) {
    this.imagesProcessed = imagesProcessed;
  }
}

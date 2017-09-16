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

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The deleteImageMetadata options.
 */
public class DeleteImageMetadataOptions extends GenericModel {

  private String collectionId;
  private String imageId;

  /**
   * Builder.
   */
  public static class Builder {
    private String collectionId;
    private String imageId;

    private Builder(DeleteImageMetadataOptions deleteImageMetadataOptions) {
      collectionId = deleteImageMetadataOptions.collectionId;
      imageId = deleteImageMetadataOptions.imageId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param collectionId the collectionId
     * @param imageId the imageId
     */
    public Builder(String collectionId, String imageId) {
      this.collectionId = collectionId;
      this.imageId = imageId;
    }

    /**
     * Builds a DeleteImageMetadataOptions.
     *
     * @return the deleteImageMetadataOptions
     */
    public DeleteImageMetadataOptions build() {
      return new DeleteImageMetadataOptions(this);
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the DeleteImageMetadataOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the imageId.
     *
     * @param imageId the imageId
     * @return the DeleteImageMetadataOptions builder
     */
    public Builder imageId(String imageId) {
      this.imageId = imageId;
      return this;
    }
  }

  private DeleteImageMetadataOptions(Builder builder) {
    Validator.notEmpty(builder.collectionId, "collectionId cannot be empty");
    Validator.notEmpty(builder.imageId, "imageId cannot be empty");
    collectionId = builder.collectionId;
    imageId = builder.imageId;
  }

  /**
   * New builder.
   *
   * @return a DeleteImageMetadataOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the collectionId.
   *
   * The ID of your collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the imageId.
   *
   * The ID of your image.
   *
   * @return the imageId
   */
  public String imageId() {
    return imageId;
  }
}

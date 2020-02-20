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

/**
 * The deleteImage options.
 */
public class DeleteImageOptions extends GenericModel {

  protected String collectionId;
  protected String imageId;

  /**
   * Builder.
   */
  public static class Builder {
    private String collectionId;
    private String imageId;

    private Builder(DeleteImageOptions deleteImageOptions) {
      this.collectionId = deleteImageOptions.collectionId;
      this.imageId = deleteImageOptions.imageId;
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
     * Builds a DeleteImageOptions.
     *
     * @return the deleteImageOptions
     */
    public DeleteImageOptions build() {
      return new DeleteImageOptions(this);
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the DeleteImageOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the imageId.
     *
     * @param imageId the imageId
     * @return the DeleteImageOptions builder
     */
    public Builder imageId(String imageId) {
      this.imageId = imageId;
      return this;
    }
  }

  protected DeleteImageOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.collectionId,
        "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.imageId,
        "imageId cannot be empty");
    collectionId = builder.collectionId;
    imageId = builder.imageId;
  }

  /**
   * New builder.
   *
   * @return a DeleteImageOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the collectionId.
   *
   * The identifier of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the imageId.
   *
   * The identifier of the image.
   *
   * @return the imageId
   */
  public String imageId() {
    return imageId;
  }
}

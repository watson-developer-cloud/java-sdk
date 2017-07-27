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

import java.io.File;

import com.ibm.watson.developer_cloud.util.Validator;

/**
 * Find Similar Images Request Options.
 */
public class FindSimilarImagesOptions {

  /**
   * Find Similar Images Request Builder.
   */
  public static class Builder {
    private String collectionId;
    private byte[] imageBinary;
    private File imageFile;
    private String imageName;
    private Integer limit;


    private Builder(FindSimilarImagesOptions options) {
      this();
      imageFile = options.imageFile;
      collectionId = options.collectionId;
      limit = options.limit;
      imageBinary = options.imageBinary;
      imageName = options.imageName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds the profile options.
     *
     * @return the profile options
     */
    public FindSimilarImagesOptions build() {
      Validator.isTrue((collectionId != null) || (imageBinary != null) || (imageFile != null),
          "collectionId, imageBinary or imageFile should be specified");
      return new FindSimilarImagesOptions(this);
    }

    /**
     * Sets the image url.
     *
     * @param collectionId the collection id
     * @return the builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Sets the image.
     *
     * @param imageFile the image file
     * @return the builder
     */
    public Builder image(File imageFile) {
      Validator.notNull(imageFile, "'imageFile' cannot be null");
      this.imageFile = imageFile;
      return this;
    }

    /**
     * Sets the image.
     *
     * @param imageBinary the image bytes
     * @param imageName the image name
     * @return the builder
     */
    public Builder image(byte[] imageBinary, String imageName) {
      Validator.notNull(imageBinary, "'imageBinary' cannot be null");
      this.imageBinary = imageBinary;
      this.imageName = imageName;

      return this;
    }

    /**
     * Sets the limit.
     *
     * @param limit the limit
     * @return the builder
     */
    public Builder limit(Integer limit) {
      this.limit = limit;
      return this;
    }

  }

  private String collectionId;
  private byte[] imageBinary;
  private File imageFile;
  private String imageName;
  private Integer limit;

  private FindSimilarImagesOptions(Builder builder) {
    imageFile = builder.imageFile;
    collectionId = builder.collectionId;
    limit = builder.limit;
    imageBinary = builder.imageBinary;
    imageName = builder.imageName;
  }

  /**
   * Returns the Collection id.
   *
   * @return the Collection id
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Returns the image file.
   *
   * @return the image file
   */
  public File image() {
    return imageFile;
  }

  /**
   * Returns the image binary.
   *
   * @return the image binary
   */
  public byte[] imageBinary() {
    return imageBinary;
  }

  /**
   * Image name.
   *
   * @return the string
   */
  public String imageName() {
    return imageName;
  }

  /**
   * Returns the limit.
   *
   * @return the limit
   */
  public Integer limit() {
    return limit;
  }

  /**
   * Creates a new Builder using the current values.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

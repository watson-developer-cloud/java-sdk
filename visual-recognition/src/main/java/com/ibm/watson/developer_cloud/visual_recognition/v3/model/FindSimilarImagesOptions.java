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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The findSimilarImages options.
 */
public class FindSimilarImagesOptions extends GenericModel {

  private String collectionId;
  private InputStream imageFile;
  private String imageFilename;
  private Long limit;
  private String imageFileContentType;

  /**
   * Builder.
   */
  public static class Builder {
    private String collectionId;
    private InputStream imageFile;
    private String imageFilename;
    private Long limit;
    private String imageFileContentType;

    private Builder(FindSimilarImagesOptions findSimilarImagesOptions) {
      collectionId = findSimilarImagesOptions.collectionId;
      imageFile = findSimilarImagesOptions.imageFile;
      imageFilename = findSimilarImagesOptions.imageFilename;
      limit = findSimilarImagesOptions.limit;
      imageFileContentType = findSimilarImagesOptions.imageFileContentType;
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
     * @param imageFile the imageFile
     */
    public Builder(String collectionId, InputStream imageFile) {
      this.collectionId = collectionId;
      this.imageFile = imageFile;
    }

    /**
     * Builds a FindSimilarImagesOptions.
     *
     * @return the findSimilarImagesOptions
     */
    public FindSimilarImagesOptions build() {
      return new FindSimilarImagesOptions(this);
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the FindSimilarImagesOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the imageFile.
     *
     * @param imageFile the imageFile
     * @return the FindSimilarImagesOptions builder
     */
    public Builder imageFile(InputStream imageFile) {
      this.imageFile = imageFile;
      return this;
    }

    /**
     * Set the imageFilename.
     *
     * @param imageFilename the imageFilename
     * @return the FindSimilarImagesOptions builder
     */
    public Builder imageFilename(String imageFilename) {
      this.imageFilename = imageFilename;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the FindSimilarImagesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the imageFileContentType.
     *
     * @param imageFileContentType the imageFileContentType
     * @return the FindSimilarImagesOptions builder
     */
    public Builder imageFileContentType(String imageFileContentType) {
      this.imageFileContentType = imageFileContentType;
      return this;
    }

    /**
     * Set the imageFile.
     *
     * @param imageFile the imageFile
     * @return the FindSimilarImagesOptions builder
     *
     * @throws FileNotFoundException
     */
    public Builder imageFile(File imageFile) throws FileNotFoundException {
      this.imageFile = new FileInputStream(imageFile);
      this.imageFilename = imageFile.getName();
      return this;
    }
  }

  private FindSimilarImagesOptions(Builder builder) {
    Validator.notEmpty(builder.collectionId, "collectionId cannot be empty");
    Validator.notNull(builder.imageFile, "imageFile cannot be null");
    collectionId = builder.collectionId;
    imageFile = builder.imageFile;
    imageFilename = builder.imageFilename;
    limit = builder.limit;
    imageFileContentType = builder.imageFileContentType;
  }

  /**
   * New builder.
   *
   * @return a FindSimilarImagesOptions builder
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
   * Gets the imageFile.
   *
   * The image file (.jpg or .png) of the image to search against the collection.
   *
   * @return the imageFile
   */
  public InputStream imageFile() {
    return imageFile;
  }

  /**
   * Gets the imageFilename.
   *
   * The filename for imageFile.
   *
   * @return the imageFilename
   */
  public String imageFilename() {
    return imageFilename;
  }

  /**
   * Gets the limit.
   *
   * The number of similar results you want returned. Default limit is 10 results, you can specify a maximum limit of
   * 100 results.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the imageFileContentType.
   *
   * The content type of imageFile.
   *
   * @return the imageFileContentType
   */
  public String imageFileContentType() {
    return imageFileContentType;
  }
}

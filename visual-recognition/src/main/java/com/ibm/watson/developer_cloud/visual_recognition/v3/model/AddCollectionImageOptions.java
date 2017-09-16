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
 * The addCollectionImage options.
 */
public class AddCollectionImageOptions extends GenericModel {

  private String collectionId;
  private InputStream imageFile;
  private String imageFilename;
  private InputStream metadata;
  private String metadataFilename;
  private String imageFileContentType;

  /**
   * Builder.
   */
  public static class Builder {
    private String collectionId;
    private InputStream imageFile;
    private String imageFilename;
    private InputStream metadata;
    private String metadataFilename;
    private String imageFileContentType;

    private Builder(AddCollectionImageOptions addCollectionImageOptions) {
      collectionId = addCollectionImageOptions.collectionId;
      imageFile = addCollectionImageOptions.imageFile;
      imageFilename = addCollectionImageOptions.imageFilename;
      metadata = addCollectionImageOptions.metadata;
      metadataFilename = addCollectionImageOptions.metadataFilename;
      imageFileContentType = addCollectionImageOptions.imageFileContentType;
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
     * @param imageFilename the imageFilename
     */
    public Builder(String collectionId, InputStream imageFile, String imageFilename) {
      this.collectionId = collectionId;
      this.imageFile = imageFile;
      this.imageFilename = imageFilename;
    }

    /**
     * Builds a AddCollectionImageOptions.
     *
     * @return the addCollectionImageOptions
     */
    public AddCollectionImageOptions build() {
      return new AddCollectionImageOptions(this);
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the AddCollectionImageOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the imageFile.
     *
     * @param imageFile the imageFile
     * @return the AddCollectionImageOptions builder
     */
    public Builder imageFile(InputStream imageFile) {
      this.imageFile = imageFile;
      return this;
    }

    /**
     * Set the imageFilename.
     *
     * @param imageFilename the imageFilename
     * @return the AddCollectionImageOptions builder
     */
    public Builder imageFilename(String imageFilename) {
      this.imageFilename = imageFilename;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the AddCollectionImageOptions builder
     */
    public Builder metadata(InputStream metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the metadataFilename.
     *
     * @param metadataFilename the metadataFilename
     * @return the AddCollectionImageOptions builder
     */
    public Builder metadataFilename(String metadataFilename) {
      this.metadataFilename = metadataFilename;
      return this;
    }

    /**
     * Set the imageFileContentType.
     *
     * @param imageFileContentType the imageFileContentType
     * @return the AddCollectionImageOptions builder
     */
    public Builder imageFileContentType(String imageFileContentType) {
      this.imageFileContentType = imageFileContentType;
      return this;
    }

    /**
     * Set the imageFile.
     *
     * @param imageFile the imageFile
     * @return the AddCollectionImageOptions builder
     *
     * @throws FileNotFoundException
     */
    public Builder imageFile(File imageFile) throws FileNotFoundException {
      this.imageFile = new FileInputStream(imageFile);
      this.imageFilename = imageFile.getName();
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the AddCollectionImageOptions builder
     *
     * @throws FileNotFoundException
     */
    public Builder metadata(File metadata) throws FileNotFoundException {
      this.metadata = new FileInputStream(metadata);
      this.metadataFilename = metadata.getName();
      return this;
    }
  }

  private AddCollectionImageOptions(Builder builder) {
    Validator.notEmpty(builder.collectionId, "collectionId cannot be empty");
    Validator.notNull(builder.imageFile, "imageFile cannot be null");
    Validator.notNull(builder.imageFilename, "imageFilename cannot be null");
    collectionId = builder.collectionId;
    imageFile = builder.imageFile;
    imageFilename = builder.imageFilename;
    metadata = builder.metadata;
    metadataFilename = builder.metadataFilename;
    imageFileContentType = builder.imageFileContentType;
  }

  /**
   * New builder.
   *
   * @return a AddCollectionImageOptions builder
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
   * The image file (.jpg or .png) of the image to add to the collection. Maximum file size of 2 MB.
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
   * Gets the metadata.
   *
   * A json object file that adds metadata to the image. Maximum 2 KB of metadata for each image.
   *
   * @return the metadata
   */
  public InputStream metadata() {
    return metadata;
  }

  /**
   * Gets the metadataFilename.
   *
   * The filename for metadata.
   *
   * @return the metadataFilename
   */
  public String metadataFilename() {
    return metadataFilename;
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

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
import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.util.Validator;

/**
 * Add Image to Collection Request Options.
 */
public class AddImageToCollectionOptions {

  /**
   * Add Image to Collection Request Builder.
   */
  public static class Builder {
    private String collectionId;
    private File imageFile;
    private Map<String, String>  metadata;

    private Builder(AddImageToCollectionOptions options) {
      this();
      imageFile = options.imageFile;
      collectionId = options.collectionId;
      metadata = options.metadata;
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
    public AddImageToCollectionOptions build() {
      Validator.isTrue((collectionId != null) || (imageFile != null), "collectionId or imageFile should be specified");
      return new AddImageToCollectionOptions(this);
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
    public Builder images(File imageFile) {
      Validator.notNull(imageFile, "'imageFile' cannot be null");
      this.imageFile = imageFile;
      return this;
    }

    /**
     * Sets the metadata.
     *
     * @param metadata the metadata
     * @return the builder
     */
    public Builder metadata(Map<String, String> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Add key,value par to the metadata.
     *
     * @param key the key
     * @param value the value
     * @return the builder
     */
    public Builder metadata(String key, String value) {
      if (this.metadata == null) {
        this.metadata = new HashMap<String, String>();
      }

      this.metadata.put(key, value);
      return this;
    }

  }
  private String collectionId;
  private File imageFile;

  private Map<String, String> metadata;

  private AddImageToCollectionOptions(Builder builder) {
    imageFile = builder.imageFile;
    collectionId = builder.collectionId;
    metadata = builder.metadata;
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
   * Returns the metadata.
   *
   * @return the metadata
   */
  public Map<String, String> metadata() {
    return metadata;
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

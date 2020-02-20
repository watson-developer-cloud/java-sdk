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
 * The listObjectMetadata options.
 */
public class ListObjectMetadataOptions extends GenericModel {

  protected String collectionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String collectionId;

    private Builder(ListObjectMetadataOptions listObjectMetadataOptions) {
      this.collectionId = listObjectMetadataOptions.collectionId;
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
     */
    public Builder(String collectionId) {
      this.collectionId = collectionId;
    }

    /**
     * Builds a ListObjectMetadataOptions.
     *
     * @return the listObjectMetadataOptions
     */
    public ListObjectMetadataOptions build() {
      return new ListObjectMetadataOptions(this);
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the ListObjectMetadataOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }
  }

  protected ListObjectMetadataOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.collectionId,
        "collectionId cannot be empty");
    collectionId = builder.collectionId;
  }

  /**
   * New builder.
   *
   * @return a ListObjectMetadataOptions builder
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
}

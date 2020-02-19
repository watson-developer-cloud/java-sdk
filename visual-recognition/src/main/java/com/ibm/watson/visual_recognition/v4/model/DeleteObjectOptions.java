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
 * The deleteObject options.
 */
public class DeleteObjectOptions extends GenericModel {

  protected String collectionId;
  protected String object;

  /**
   * Builder.
   */
  public static class Builder {
    private String collectionId;
    private String object;

    private Builder(DeleteObjectOptions deleteObjectOptions) {
      this.collectionId = deleteObjectOptions.collectionId;
      this.object = deleteObjectOptions.object;
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
     * @param object the object
     */
    public Builder(String collectionId, String object) {
      this.collectionId = collectionId;
      this.object = object;
    }

    /**
     * Builds a DeleteObjectOptions.
     *
     * @return the deleteObjectOptions
     */
    public DeleteObjectOptions build() {
      return new DeleteObjectOptions(this);
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the DeleteObjectOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the object.
     *
     * @param object the object
     * @return the DeleteObjectOptions builder
     */
    public Builder object(String object) {
      this.object = object;
      return this;
    }
  }

  protected DeleteObjectOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.collectionId,
      "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.object,
      "object cannot be empty");
    collectionId = builder.collectionId;
    object = builder.object;
  }

  /**
   * New builder.
   *
   * @return a DeleteObjectOptions builder
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
   * Gets the object.
   *
   * The name of the object.
   *
   * @return the object
   */
  public String object() {
    return object;
  }
}


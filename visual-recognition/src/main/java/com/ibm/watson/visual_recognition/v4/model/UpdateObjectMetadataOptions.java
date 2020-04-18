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

/** The updateObjectMetadata options. */
public class UpdateObjectMetadataOptions extends GenericModel {

  protected String collectionId;
  protected String object;
  protected String newObject;

  /** Builder. */
  public static class Builder {
    private String collectionId;
    private String object;
    private String newObject;

    private Builder(UpdateObjectMetadataOptions updateObjectMetadataOptions) {
      this.collectionId = updateObjectMetadataOptions.collectionId;
      this.object = updateObjectMetadataOptions.object;
      this.newObject = updateObjectMetadataOptions.newObject;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param collectionId the collectionId
     * @param object the object
     * @param newObject the newObject
     */
    public Builder(String collectionId, String object, String newObject) {
      this.collectionId = collectionId;
      this.object = object;
      this.newObject = newObject;
    }

    /**
     * Builds a UpdateObjectMetadataOptions.
     *
     * @return the updateObjectMetadataOptions
     */
    public UpdateObjectMetadataOptions build() {
      return new UpdateObjectMetadataOptions(this);
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the UpdateObjectMetadataOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the object.
     *
     * @param object the object
     * @return the UpdateObjectMetadataOptions builder
     */
    public Builder object(String object) {
      this.object = object;
      return this;
    }

    /**
     * Set the newObject.
     *
     * @param newObject the newObject
     * @return the UpdateObjectMetadataOptions builder
     */
    public Builder newObject(String newObject) {
      this.newObject = newObject;
      return this;
    }

    /**
     * Set the updateObjectMetadata.
     *
     * @param updateObjectMetadata the updateObjectMetadata
     * @return the UpdateObjectMetadataOptions builder
     */
    public Builder updateObjectMetadata(UpdateObjectMetadata updateObjectMetadata) {
      return this;
    }
  }

  protected UpdateObjectMetadataOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.object, "object cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.newObject, "newObject cannot be null");
    collectionId = builder.collectionId;
    object = builder.object;
    newObject = builder.newObject;
  }

  /**
   * New builder.
   *
   * @return a UpdateObjectMetadataOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the collectionId.
   *
   * <p>The identifier of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the object.
   *
   * <p>The name of the object.
   *
   * @return the object
   */
  public String object() {
    return object;
  }

  /**
   * Gets the newObject.
   *
   * <p>The updated name of the object. The name can contain alphanumeric, underscore, hyphen,
   * space, and dot characters. It cannot begin with the reserved prefix `sys-`.
   *
   * @return the newObject
   */
  public String newObject() {
    return newObject;
  }
}

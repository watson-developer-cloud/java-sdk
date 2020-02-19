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
 * Basic information about an updated object.
 */
public class UpdateObjectMetadata extends GenericModel {

  protected String object;
  protected Long count;

  /**
   * Builder.
   */
  public static class Builder {
    private String object;
    private Long count;

    private Builder(UpdateObjectMetadata updateObjectMetadata) {
      this.object = updateObjectMetadata.object;
      this.count = updateObjectMetadata.count;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param object the object
     * @param count the count
     */
    public Builder(String object, Long count) {
      this.object = object;
      this.count = count;
    }

    /**
     * Builds a UpdateObjectMetadata.
     *
     * @return the updateObjectMetadata
     */
    public UpdateObjectMetadata build() {
      return new UpdateObjectMetadata(this);
    }

    /**
     * Set the object.
     *
     * @param object the object
     * @return the UpdateObjectMetadata builder
     */
    public Builder object(String object) {
      this.object = object;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the UpdateObjectMetadata builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }
  }

  protected UpdateObjectMetadata(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.object,
      "object cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.count,
      "count cannot be null");
    object = builder.object;
    count = builder.count;
  }

  /**
   * New builder.
   *
   * @return a UpdateObjectMetadata builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the object.
   *
   * The updated name of the object. The name can contain alphanumeric, underscore, hyphen, space, and dot characters.
   * It cannot begin with the reserved prefix `sys-`.
   *
   * @return the object
   */
  public String object() {
    return object;
  }

  /**
   * Gets the count.
   *
   * Number of bounding boxes in the collection with the updated object name.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }
}


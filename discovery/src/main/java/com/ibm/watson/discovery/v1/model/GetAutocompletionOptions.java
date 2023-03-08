/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.watson.discovery.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The getAutocompletion options. */
public class GetAutocompletionOptions extends GenericModel {

  protected String environmentId;
  protected String collectionId;
  protected String prefix;
  protected String field;
  protected Long count;

  /** Builder. */
  public static class Builder {
    private String environmentId;
    private String collectionId;
    private String prefix;
    private String field;
    private Long count;

    /**
     * Instantiates a new Builder from an existing GetAutocompletionOptions instance.
     *
     * @param getAutocompletionOptions the instance to initialize the Builder with
     */
    private Builder(GetAutocompletionOptions getAutocompletionOptions) {
      this.environmentId = getAutocompletionOptions.environmentId;
      this.collectionId = getAutocompletionOptions.collectionId;
      this.prefix = getAutocompletionOptions.prefix;
      this.field = getAutocompletionOptions.field;
      this.count = getAutocompletionOptions.count;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     * @param collectionId the collectionId
     * @param prefix the prefix
     */
    public Builder(String environmentId, String collectionId, String prefix) {
      this.environmentId = environmentId;
      this.collectionId = collectionId;
      this.prefix = prefix;
    }

    /**
     * Builds a GetAutocompletionOptions.
     *
     * @return the new GetAutocompletionOptions instance
     */
    public GetAutocompletionOptions build() {
      return new GetAutocompletionOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the GetAutocompletionOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the GetAutocompletionOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the prefix.
     *
     * @param prefix the prefix
     * @return the GetAutocompletionOptions builder
     */
    public Builder prefix(String prefix) {
      this.prefix = prefix;
      return this;
    }

    /**
     * Set the field.
     *
     * @param field the field
     * @return the GetAutocompletionOptions builder
     */
    public Builder field(String field) {
      this.field = field;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the GetAutocompletionOptions builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }
  }

  protected GetAutocompletionOptions() {}

  protected GetAutocompletionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.prefix, "prefix cannot be null");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
    prefix = builder.prefix;
    field = builder.field;
    count = builder.count;
  }

  /**
   * New builder.
   *
   * @return a GetAutocompletionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * <p>The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the collectionId.
   *
   * <p>The ID of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the prefix.
   *
   * <p>The prefix to use for autocompletion. For example, the prefix `Ho` could autocomplete to
   * `hot`, `housing`, or `how`.
   *
   * @return the prefix
   */
  public String prefix() {
    return prefix;
  }

  /**
   * Gets the field.
   *
   * <p>The field in the result documents that autocompletion suggestions are identified from.
   *
   * @return the field
   */
  public String field() {
    return field;
  }

  /**
   * Gets the count.
   *
   * <p>The number of autocompletion suggestions to return.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }
}

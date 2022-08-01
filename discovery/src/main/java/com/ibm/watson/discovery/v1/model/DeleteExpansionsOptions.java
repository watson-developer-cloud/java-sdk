/*
 * (C) Copyright IBM Corp. 2022.
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

/** The deleteExpansions options. */
public class DeleteExpansionsOptions extends GenericModel {

  protected String environmentId;
  protected String collectionId;

  /** Builder. */
  public static class Builder {
    private String environmentId;
    private String collectionId;

    private Builder(DeleteExpansionsOptions deleteExpansionsOptions) {
      this.environmentId = deleteExpansionsOptions.environmentId;
      this.collectionId = deleteExpansionsOptions.collectionId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     * @param collectionId the collectionId
     */
    public Builder(String environmentId, String collectionId) {
      this.environmentId = environmentId;
      this.collectionId = collectionId;
    }

    /**
     * Builds a DeleteExpansionsOptions.
     *
     * @return the new DeleteExpansionsOptions instance
     */
    public DeleteExpansionsOptions build() {
      return new DeleteExpansionsOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the DeleteExpansionsOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the DeleteExpansionsOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }
  }

  protected DeleteExpansionsOptions() {}

  protected DeleteExpansionsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
  }

  /**
   * New builder.
   *
   * @return a DeleteExpansionsOptions builder
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
}

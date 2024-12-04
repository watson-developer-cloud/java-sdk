/*
 * (C) Copyright IBM Corp. 2020, 2024.
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

package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The deleteCollection options. */
public class DeleteCollectionOptions extends GenericModel {

  protected String projectId;
  protected String collectionId;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String collectionId;

    /**
     * Instantiates a new Builder from an existing DeleteCollectionOptions instance.
     *
     * @param deleteCollectionOptions the instance to initialize the Builder with
     */
    private Builder(DeleteCollectionOptions deleteCollectionOptions) {
      this.projectId = deleteCollectionOptions.projectId;
      this.collectionId = deleteCollectionOptions.collectionId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param collectionId the collectionId
     */
    public Builder(String projectId, String collectionId) {
      this.projectId = projectId;
      this.collectionId = collectionId;
    }

    /**
     * Builds a DeleteCollectionOptions.
     *
     * @return the new DeleteCollectionOptions instance
     */
    public DeleteCollectionOptions build() {
      return new DeleteCollectionOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the DeleteCollectionOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the DeleteCollectionOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }
  }

  protected DeleteCollectionOptions() {}

  protected DeleteCollectionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    projectId = builder.projectId;
    collectionId = builder.collectionId;
  }

  /**
   * New builder.
   *
   * @return a DeleteCollectionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the projectId.
   *
   * <p>The Universally Unique Identifier (UUID) of the project. This information can be found from
   * the *Integrate and Deploy* page in Discovery.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the collectionId.
   *
   * <p>The Universally Unique Identifier (UUID) of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }
}

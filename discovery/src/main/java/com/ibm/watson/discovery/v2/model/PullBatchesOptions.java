/*
 * (C) Copyright IBM Corp. 2024.
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

/** The pullBatches options. */
public class PullBatchesOptions extends GenericModel {

  protected String projectId;
  protected String collectionId;
  protected String batchId;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String collectionId;
    private String batchId;

    /**
     * Instantiates a new Builder from an existing PullBatchesOptions instance.
     *
     * @param pullBatchesOptions the instance to initialize the Builder with
     */
    private Builder(PullBatchesOptions pullBatchesOptions) {
      this.projectId = pullBatchesOptions.projectId;
      this.collectionId = pullBatchesOptions.collectionId;
      this.batchId = pullBatchesOptions.batchId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param collectionId the collectionId
     * @param batchId the batchId
     */
    public Builder(String projectId, String collectionId, String batchId) {
      this.projectId = projectId;
      this.collectionId = collectionId;
      this.batchId = batchId;
    }

    /**
     * Builds a PullBatchesOptions.
     *
     * @return the new PullBatchesOptions instance
     */
    public PullBatchesOptions build() {
      return new PullBatchesOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the PullBatchesOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the PullBatchesOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the batchId.
     *
     * @param batchId the batchId
     * @return the PullBatchesOptions builder
     */
    public Builder batchId(String batchId) {
      this.batchId = batchId;
      return this;
    }
  }

  protected PullBatchesOptions() {}

  protected PullBatchesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.batchId, "batchId cannot be empty");
    projectId = builder.projectId;
    collectionId = builder.collectionId;
    batchId = builder.batchId;
  }

  /**
   * New builder.
   *
   * @return a PullBatchesOptions builder
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

  /**
   * Gets the batchId.
   *
   * <p>The Universally Unique Identifier (UUID) of the document batch that is being requested from
   * Discovery.
   *
   * @return the batchId
   */
  public String batchId() {
    return batchId;
  }
}

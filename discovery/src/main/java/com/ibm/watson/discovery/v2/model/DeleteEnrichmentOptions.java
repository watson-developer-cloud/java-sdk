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

/** The deleteEnrichment options. */
public class DeleteEnrichmentOptions extends GenericModel {

  protected String projectId;
  protected String enrichmentId;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String enrichmentId;

    /**
     * Instantiates a new Builder from an existing DeleteEnrichmentOptions instance.
     *
     * @param deleteEnrichmentOptions the instance to initialize the Builder with
     */
    private Builder(DeleteEnrichmentOptions deleteEnrichmentOptions) {
      this.projectId = deleteEnrichmentOptions.projectId;
      this.enrichmentId = deleteEnrichmentOptions.enrichmentId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param enrichmentId the enrichmentId
     */
    public Builder(String projectId, String enrichmentId) {
      this.projectId = projectId;
      this.enrichmentId = enrichmentId;
    }

    /**
     * Builds a DeleteEnrichmentOptions.
     *
     * @return the new DeleteEnrichmentOptions instance
     */
    public DeleteEnrichmentOptions build() {
      return new DeleteEnrichmentOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the DeleteEnrichmentOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the enrichmentId.
     *
     * @param enrichmentId the enrichmentId
     * @return the DeleteEnrichmentOptions builder
     */
    public Builder enrichmentId(String enrichmentId) {
      this.enrichmentId = enrichmentId;
      return this;
    }
  }

  protected DeleteEnrichmentOptions() {}

  protected DeleteEnrichmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.enrichmentId, "enrichmentId cannot be empty");
    projectId = builder.projectId;
    enrichmentId = builder.enrichmentId;
  }

  /**
   * New builder.
   *
   * @return a DeleteEnrichmentOptions builder
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
   * Gets the enrichmentId.
   *
   * <p>The Universally Unique Identifier (UUID) of the enrichment.
   *
   * @return the enrichmentId
   */
  public String enrichmentId() {
    return enrichmentId;
  }
}

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
package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The updateEnrichment options. */
public class UpdateEnrichmentOptions extends GenericModel {

  protected String projectId;
  protected String enrichmentId;
  protected String name;
  protected String description;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String enrichmentId;
    private String name;
    private String description;

    private Builder(UpdateEnrichmentOptions updateEnrichmentOptions) {
      this.projectId = updateEnrichmentOptions.projectId;
      this.enrichmentId = updateEnrichmentOptions.enrichmentId;
      this.name = updateEnrichmentOptions.name;
      this.description = updateEnrichmentOptions.description;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param enrichmentId the enrichmentId
     * @param name the name
     */
    public Builder(String projectId, String enrichmentId, String name) {
      this.projectId = projectId;
      this.enrichmentId = enrichmentId;
      this.name = name;
    }

    /**
     * Builds a UpdateEnrichmentOptions.
     *
     * @return the updateEnrichmentOptions
     */
    public UpdateEnrichmentOptions build() {
      return new UpdateEnrichmentOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the UpdateEnrichmentOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the enrichmentId.
     *
     * @param enrichmentId the enrichmentId
     * @return the UpdateEnrichmentOptions builder
     */
    public Builder enrichmentId(String enrichmentId) {
      this.enrichmentId = enrichmentId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateEnrichmentOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateEnrichmentOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected UpdateEnrichmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.enrichmentId, "enrichmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name, "name cannot be null");
    projectId = builder.projectId;
    enrichmentId = builder.enrichmentId;
    name = builder.name;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a UpdateEnrichmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the projectId.
   *
   * <p>The ID of the project. This information can be found from the deploy page of the Discovery
   * administrative tooling.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the enrichmentId.
   *
   * <p>The ID of the enrichment.
   *
   * @return the enrichmentId
   */
  public String enrichmentId() {
    return enrichmentId;
  }

  /**
   * Gets the name.
   *
   * <p>A new name for the enrichment.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>A new description for the enrichment.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

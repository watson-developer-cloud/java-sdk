/*
 * (C) Copyright IBM Corp. 2020, 2021.
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/** The createEnrichment options. */
public class CreateEnrichmentOptions extends GenericModel {

  protected String projectId;
  protected CreateEnrichment enrichment;
  protected InputStream file;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private CreateEnrichment enrichment;
    private InputStream file;

    private Builder(CreateEnrichmentOptions createEnrichmentOptions) {
      this.projectId = createEnrichmentOptions.projectId;
      this.enrichment = createEnrichmentOptions.enrichment;
      this.file = createEnrichmentOptions.file;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param enrichment the enrichment
     */
    public Builder(String projectId, CreateEnrichment enrichment) {
      this.projectId = projectId;
      this.enrichment = enrichment;
    }

    /**
     * Builds a CreateEnrichmentOptions.
     *
     * @return the new CreateEnrichmentOptions instance
     */
    public CreateEnrichmentOptions build() {
      return new CreateEnrichmentOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the CreateEnrichmentOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the enrichment.
     *
     * @param enrichment the enrichment
     * @return the CreateEnrichmentOptions builder
     */
    public Builder enrichment(CreateEnrichment enrichment) {
      this.enrichment = enrichment;
      return this;
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the CreateEnrichmentOptions builder
     */
    public Builder file(InputStream file) {
      this.file = file;
      return this;
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the CreateEnrichmentOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder file(File file) throws FileNotFoundException {
      this.file = new FileInputStream(file);
      return this;
    }
  }

  protected CreateEnrichmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.enrichment, "enrichment cannot be null");
    projectId = builder.projectId;
    enrichment = builder.enrichment;
    file = builder.file;
  }

  /**
   * New builder.
   *
   * @return a CreateEnrichmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the projectId.
   *
   * <p>The ID of the project. This information can be found from the *Integrate and Deploy* page in
   * Discovery.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the enrichment.
   *
   * <p>Information about a specific enrichment.
   *
   * @return the enrichment
   */
  public CreateEnrichment enrichment() {
    return enrichment;
  }

  /**
   * Gets the file.
   *
   * <p>The enrichment file to upload.
   *
   * @return the file
   */
  public InputStream file() {
    return file;
  }
}

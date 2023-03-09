/*
 * (C) Copyright IBM Corp. 2022, 2023.
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

/** The updateDocumentClassifierModel options. */
public class UpdateDocumentClassifierModelOptions extends GenericModel {

  protected String projectId;
  protected String classifierId;
  protected String modelId;
  protected String name;
  protected String description;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String classifierId;
    private String modelId;
    private String name;
    private String description;

    /**
     * Instantiates a new Builder from an existing UpdateDocumentClassifierModelOptions instance.
     *
     * @param updateDocumentClassifierModelOptions the instance to initialize the Builder with
     */
    private Builder(UpdateDocumentClassifierModelOptions updateDocumentClassifierModelOptions) {
      this.projectId = updateDocumentClassifierModelOptions.projectId;
      this.classifierId = updateDocumentClassifierModelOptions.classifierId;
      this.modelId = updateDocumentClassifierModelOptions.modelId;
      this.name = updateDocumentClassifierModelOptions.name;
      this.description = updateDocumentClassifierModelOptions.description;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param classifierId the classifierId
     * @param modelId the modelId
     */
    public Builder(String projectId, String classifierId, String modelId) {
      this.projectId = projectId;
      this.classifierId = classifierId;
      this.modelId = modelId;
    }

    /**
     * Builds a UpdateDocumentClassifierModelOptions.
     *
     * @return the new UpdateDocumentClassifierModelOptions instance
     */
    public UpdateDocumentClassifierModelOptions build() {
      return new UpdateDocumentClassifierModelOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the UpdateDocumentClassifierModelOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the classifierId.
     *
     * @param classifierId the classifierId
     * @return the UpdateDocumentClassifierModelOptions builder
     */
    public Builder classifierId(String classifierId) {
      this.classifierId = classifierId;
      return this;
    }

    /**
     * Set the modelId.
     *
     * @param modelId the modelId
     * @return the UpdateDocumentClassifierModelOptions builder
     */
    public Builder modelId(String modelId) {
      this.modelId = modelId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateDocumentClassifierModelOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateDocumentClassifierModelOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected UpdateDocumentClassifierModelOptions() {}

  protected UpdateDocumentClassifierModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.classifierId, "classifierId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.modelId, "modelId cannot be empty");
    projectId = builder.projectId;
    classifierId = builder.classifierId;
    modelId = builder.modelId;
    name = builder.name;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a UpdateDocumentClassifierModelOptions builder
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
   * Gets the classifierId.
   *
   * <p>The ID of the classifier.
   *
   * @return the classifierId
   */
  public String classifierId() {
    return classifierId;
  }

  /**
   * Gets the modelId.
   *
   * <p>The ID of the classifier model.
   *
   * @return the modelId
   */
  public String modelId() {
    return modelId;
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

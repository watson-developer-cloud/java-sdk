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

/** The deleteDocumentClassifier options. */
public class DeleteDocumentClassifierOptions extends GenericModel {

  protected String projectId;
  protected String classifierId;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String classifierId;

    /**
     * Instantiates a new Builder from an existing DeleteDocumentClassifierOptions instance.
     *
     * @param deleteDocumentClassifierOptions the instance to initialize the Builder with
     */
    private Builder(DeleteDocumentClassifierOptions deleteDocumentClassifierOptions) {
      this.projectId = deleteDocumentClassifierOptions.projectId;
      this.classifierId = deleteDocumentClassifierOptions.classifierId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param classifierId the classifierId
     */
    public Builder(String projectId, String classifierId) {
      this.projectId = projectId;
      this.classifierId = classifierId;
    }

    /**
     * Builds a DeleteDocumentClassifierOptions.
     *
     * @return the new DeleteDocumentClassifierOptions instance
     */
    public DeleteDocumentClassifierOptions build() {
      return new DeleteDocumentClassifierOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the DeleteDocumentClassifierOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the classifierId.
     *
     * @param classifierId the classifierId
     * @return the DeleteDocumentClassifierOptions builder
     */
    public Builder classifierId(String classifierId) {
      this.classifierId = classifierId;
      return this;
    }
  }

  protected DeleteDocumentClassifierOptions() {}

  protected DeleteDocumentClassifierOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.classifierId, "classifierId cannot be empty");
    projectId = builder.projectId;
    classifierId = builder.classifierId;
  }

  /**
   * New builder.
   *
   * @return a DeleteDocumentClassifierOptions builder
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
   * Gets the classifierId.
   *
   * <p>The Universally Unique Identifier (UUID) of the classifier.
   *
   * @return the classifierId
   */
  public String classifierId() {
    return classifierId;
  }
}

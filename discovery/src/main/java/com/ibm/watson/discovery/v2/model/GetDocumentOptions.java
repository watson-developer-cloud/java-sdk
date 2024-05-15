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

/** The getDocument options. */
public class GetDocumentOptions extends GenericModel {

  protected String projectId;
  protected String collectionId;
  protected String documentId;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String collectionId;
    private String documentId;

    /**
     * Instantiates a new Builder from an existing GetDocumentOptions instance.
     *
     * @param getDocumentOptions the instance to initialize the Builder with
     */
    private Builder(GetDocumentOptions getDocumentOptions) {
      this.projectId = getDocumentOptions.projectId;
      this.collectionId = getDocumentOptions.collectionId;
      this.documentId = getDocumentOptions.documentId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param collectionId the collectionId
     * @param documentId the documentId
     */
    public Builder(String projectId, String collectionId, String documentId) {
      this.projectId = projectId;
      this.collectionId = collectionId;
      this.documentId = documentId;
    }

    /**
     * Builds a GetDocumentOptions.
     *
     * @return the new GetDocumentOptions instance
     */
    public GetDocumentOptions build() {
      return new GetDocumentOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the GetDocumentOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the GetDocumentOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the documentId.
     *
     * @param documentId the documentId
     * @return the GetDocumentOptions builder
     */
    public Builder documentId(String documentId) {
      this.documentId = documentId;
      return this;
    }
  }

  protected GetDocumentOptions() {}

  protected GetDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.documentId, "documentId cannot be empty");
    projectId = builder.projectId;
    collectionId = builder.collectionId;
    documentId = builder.documentId;
  }

  /**
   * New builder.
   *
   * @return a GetDocumentOptions builder
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
   * Gets the documentId.
   *
   * <p>The ID of the document.
   *
   * @return the documentId
   */
  public String documentId() {
    return documentId;
  }
}

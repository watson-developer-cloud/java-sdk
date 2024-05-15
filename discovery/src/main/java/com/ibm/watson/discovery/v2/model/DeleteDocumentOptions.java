/*
 * (C) Copyright IBM Corp. 2019, 2024.
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

/** The deleteDocument options. */
public class DeleteDocumentOptions extends GenericModel {

  protected String projectId;
  protected String collectionId;
  protected String documentId;
  protected Boolean xWatsonDiscoveryForce;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String collectionId;
    private String documentId;
    private Boolean xWatsonDiscoveryForce;

    /**
     * Instantiates a new Builder from an existing DeleteDocumentOptions instance.
     *
     * @param deleteDocumentOptions the instance to initialize the Builder with
     */
    private Builder(DeleteDocumentOptions deleteDocumentOptions) {
      this.projectId = deleteDocumentOptions.projectId;
      this.collectionId = deleteDocumentOptions.collectionId;
      this.documentId = deleteDocumentOptions.documentId;
      this.xWatsonDiscoveryForce = deleteDocumentOptions.xWatsonDiscoveryForce;
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
     * Builds a DeleteDocumentOptions.
     *
     * @return the new DeleteDocumentOptions instance
     */
    public DeleteDocumentOptions build() {
      return new DeleteDocumentOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the DeleteDocumentOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the DeleteDocumentOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the documentId.
     *
     * @param documentId the documentId
     * @return the DeleteDocumentOptions builder
     */
    public Builder documentId(String documentId) {
      this.documentId = documentId;
      return this;
    }

    /**
     * Set the xWatsonDiscoveryForce.
     *
     * @param xWatsonDiscoveryForce the xWatsonDiscoveryForce
     * @return the DeleteDocumentOptions builder
     */
    public Builder xWatsonDiscoveryForce(Boolean xWatsonDiscoveryForce) {
      this.xWatsonDiscoveryForce = xWatsonDiscoveryForce;
      return this;
    }
  }

  protected DeleteDocumentOptions() {}

  protected DeleteDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.documentId, "documentId cannot be empty");
    projectId = builder.projectId;
    collectionId = builder.collectionId;
    documentId = builder.documentId;
    xWatsonDiscoveryForce = builder.xWatsonDiscoveryForce;
  }

  /**
   * New builder.
   *
   * @return a DeleteDocumentOptions builder
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

  /**
   * Gets the xWatsonDiscoveryForce.
   *
   * <p>When `true`, the uploaded document is added to the collection even if the data for that
   * collection is shared with other collections.
   *
   * @return the xWatsonDiscoveryForce
   */
  public Boolean xWatsonDiscoveryForce() {
    return xWatsonDiscoveryForce;
  }
}

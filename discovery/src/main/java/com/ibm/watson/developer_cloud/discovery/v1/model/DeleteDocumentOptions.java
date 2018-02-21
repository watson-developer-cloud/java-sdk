/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The deleteDocument options.
 */
public class DeleteDocumentOptions extends GenericModel {

  private String environmentId;
  private String collectionId;
  private String documentId;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String collectionId;
    private String documentId;

    private Builder(DeleteDocumentOptions deleteDocumentOptions) {
      environmentId = deleteDocumentOptions.environmentId;
      collectionId = deleteDocumentOptions.collectionId;
      documentId = deleteDocumentOptions.documentId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     * @param collectionId the collectionId
     * @param documentId the documentId
     */
    public Builder(String environmentId, String collectionId, String documentId) {
      this.environmentId = environmentId;
      this.collectionId = collectionId;
      this.documentId = documentId;
    }

    /**
     * Builds a DeleteDocumentOptions.
     *
     * @return the deleteDocumentOptions
     */
    public DeleteDocumentOptions build() {
      return new DeleteDocumentOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the DeleteDocumentOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
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
  }

  private DeleteDocumentOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    Validator.notEmpty(builder.collectionId, "collectionId cannot be empty");
    Validator.notEmpty(builder.documentId, "documentId cannot be empty");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
    documentId = builder.documentId;
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
   * Gets the environmentId.
   *
   * The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the collectionId.
   *
   * The ID of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the documentId.
   *
   * The ID of the document.
   *
   * @return the documentId
   */
  public String documentId() {
    return documentId;
  }
}

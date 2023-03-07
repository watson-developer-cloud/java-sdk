/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The deleteDocument options. */
public class DeleteDocumentOptions extends GenericModel {

  protected String documentId;

  /** Builder. */
  public static class Builder {
    private String documentId;

    /**
     * Instantiates a new Builder from an existing DeleteDocumentOptions instance.
     *
     * @param deleteDocumentOptions the instance to initialize the Builder with
     */
    private Builder(DeleteDocumentOptions deleteDocumentOptions) {
      this.documentId = deleteDocumentOptions.documentId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param documentId the documentId
     */
    public Builder(String documentId) {
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

  protected DeleteDocumentOptions() {}

  protected DeleteDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.documentId, "documentId cannot be empty");
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
   * Gets the documentId.
   *
   * <p>Document ID of the document to delete.
   *
   * @return the documentId
   */
  public String documentId() {
    return documentId;
  }
}

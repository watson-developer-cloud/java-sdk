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
package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The getTranslatedDocument options. */
public class GetTranslatedDocumentOptions extends GenericModel {

  protected String documentId;
  protected String accept;

  /** Builder. */
  public static class Builder {
    private String documentId;
    private String accept;

    private Builder(GetTranslatedDocumentOptions getTranslatedDocumentOptions) {
      this.documentId = getTranslatedDocumentOptions.documentId;
      this.accept = getTranslatedDocumentOptions.accept;
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
     * Builds a GetTranslatedDocumentOptions.
     *
     * @return the getTranslatedDocumentOptions
     */
    public GetTranslatedDocumentOptions build() {
      return new GetTranslatedDocumentOptions(this);
    }

    /**
     * Set the documentId.
     *
     * @param documentId the documentId
     * @return the GetTranslatedDocumentOptions builder
     */
    public Builder documentId(String documentId) {
      this.documentId = documentId;
      return this;
    }

    /**
     * Set the accept.
     *
     * @param accept the accept
     * @return the GetTranslatedDocumentOptions builder
     */
    public Builder accept(String accept) {
      this.accept = accept;
      return this;
    }
  }

  protected GetTranslatedDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.documentId, "documentId cannot be empty");
    documentId = builder.documentId;
    accept = builder.accept;
  }

  /**
   * New builder.
   *
   * @return a GetTranslatedDocumentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the documentId.
   *
   * <p>The document ID of the document that was submitted for translation.
   *
   * @return the documentId
   */
  public String documentId() {
    return documentId;
  }

  /**
   * Gets the accept.
   *
   * <p>The type of the response: application/powerpoint, application/mspowerpoint,
   * application/x-rtf, application/json, application/xml, application/vnd.ms-excel,
   * application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,
   * application/vnd.ms-powerpoint,
   * application/vnd.openxmlformats-officedocument.presentationml.presentation, application/msword,
   * application/vnd.openxmlformats-officedocument.wordprocessingml.document,
   * application/vnd.oasis.opendocument.spreadsheet,
   * application/vnd.oasis.opendocument.presentation, application/vnd.oasis.opendocument.text,
   * application/pdf, application/rtf, text/html, text/json, text/plain, text/richtext, text/rtf, or
   * text/xml. A character encoding can be specified by including a `charset` parameter. For
   * example, 'text/html;charset=utf-8'.
   *
   * @return the accept
   */
  public String accept() {
    return accept;
  }
}

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
package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The getTranslatedDocument options.
 */
public class GetTranslatedDocumentOptions extends GenericModel {

  /**
   * The type of the response: application/powerpoint, application/mspowerpoint, application/x-rtf, application/json,
   * application/xml, application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,
   * application/vnd.ms-powerpoint, application/vnd.openxmlformats-officedocument.presentationml.presentation,
   * application/msword, application/vnd.openxmlformats-officedocument.wordprocessingml.document,
   * application/vnd.oasis.opendocument.spreadsheet, application/vnd.oasis.opendocument.presentation,
   * application/vnd.oasis.opendocument.text, application/pdf, application/rtf, text/html, text/json, text/plain,
   * text/richtext, text/rtf, or text/xml. A character encoding can be specified by including a `charset` parameter. For
   * example, 'text/html;charset=utf-8'.
   */
  public interface Accept {
    /** application/powerpoint. */
    String APPLICATION_POWERPOINT = "application/powerpoint";
    /** application/mspowerpoint. */
    String APPLICATION_MSPOWERPOINT = "application/mspowerpoint";
    /** application/x-rtf. */
    String APPLICATION_X_RTF = "application/x-rtf";
    /** application/json. */
    String APPLICATION_JSON = "application/json";
    /** application/xml. */
    String APPLICATION_XML = "application/xml";
    /** application/vnd.ms-excel. */
    String APPLICATION_VND_MS_EXCEL = "application/vnd.ms-excel";
    /** application/vnd.openxmlformats-officedocument.spreadsheetml.sheet. */
    String APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEET = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    /** application/vnd.ms-powerpoint. */
    String APPLICATION_VND_MS_POWERPOINT = "application/vnd.ms-powerpoint";
    /** application/vnd.openxmlformats-officedocument.presentationml.presentation. */
    String APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_PRESENTATION = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
    /** application/msword. */
    String APPLICATION_MSWORD = "application/msword";
    /** application/vnd.openxmlformats-officedocument.wordprocessingml.document. */
    String APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    /** application/vnd.oasis.opendocument.spreadsheet. */
    String APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET = "application/vnd.oasis.opendocument.spreadsheet";
    /** application/vnd.oasis.opendocument.presentation. */
    String APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION = "application/vnd.oasis.opendocument.presentation";
    /** application/vnd.oasis.opendocument.text. */
    String APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT = "application/vnd.oasis.opendocument.text";
    /** application/pdf. */
    String APPLICATION_PDF = "application/pdf";
    /** application/rtf. */
    String APPLICATION_RTF = "application/rtf";
    /** text/html. */
    String TEXT_HTML = "text/html";
    /** text/json. */
    String TEXT_JSON = "text/json";
    /** text/plain. */
    String TEXT_PLAIN = "text/plain";
    /** text/richtext. */
    String TEXT_RICHTEXT = "text/richtext";
    /** text/rtf. */
    String TEXT_RTF = "text/rtf";
    /** text/xml. */
    String TEXT_XML = "text/xml";
  }

  private String documentId;
  private String accept;

  /**
   * Builder.
   */
  public static class Builder {
    private String documentId;
    private String accept;

    private Builder(GetTranslatedDocumentOptions getTranslatedDocumentOptions) {
      this.documentId = getTranslatedDocumentOptions.documentId;
      this.accept = getTranslatedDocumentOptions.accept;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

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

  private GetTranslatedDocumentOptions(Builder builder) {
    Validator.notEmpty(builder.documentId, "documentId cannot be empty");
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
   * The document ID of the document that was submitted for translation.
   *
   * @return the documentId
   */
  public String documentId() {
    return documentId;
  }

  /**
   * Gets the accept.
   *
   * The type of the response: application/powerpoint, application/mspowerpoint, application/x-rtf, application/json,
   * application/xml, application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,
   * application/vnd.ms-powerpoint, application/vnd.openxmlformats-officedocument.presentationml.presentation,
   * application/msword, application/vnd.openxmlformats-officedocument.wordprocessingml.document,
   * application/vnd.oasis.opendocument.spreadsheet, application/vnd.oasis.opendocument.presentation,
   * application/vnd.oasis.opendocument.text, application/pdf, application/rtf, text/html, text/json, text/plain,
   * text/richtext, text/rtf, or text/xml. A character encoding can be specified by including a `charset` parameter. For
   * example, 'text/html;charset=utf-8'.
   *
   * @return the accept
   */
  public String accept() {
    return accept;
  }
}

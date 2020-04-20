/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/** The translateDocument options. */
public class TranslateDocumentOptions extends GenericModel {

  protected InputStream file;
  protected String filename;
  protected String fileContentType;
  protected String modelId;
  protected String source;
  protected String target;
  protected String documentId;

  /** Builder. */
  public static class Builder {
    private InputStream file;
    private String filename;
    private String fileContentType;
    private String modelId;
    private String source;
    private String target;
    private String documentId;

    private Builder(TranslateDocumentOptions translateDocumentOptions) {
      this.file = translateDocumentOptions.file;
      this.filename = translateDocumentOptions.filename;
      this.fileContentType = translateDocumentOptions.fileContentType;
      this.modelId = translateDocumentOptions.modelId;
      this.source = translateDocumentOptions.source;
      this.target = translateDocumentOptions.target;
      this.documentId = translateDocumentOptions.documentId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param file the file
     * @param filename the filename
     */
    public Builder(InputStream file, String filename) {
      this.file = file;
      this.filename = filename;
    }

    /**
     * Builds a TranslateDocumentOptions.
     *
     * @return the translateDocumentOptions
     */
    public TranslateDocumentOptions build() {
      return new TranslateDocumentOptions(this);
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the TranslateDocumentOptions builder
     */
    public Builder file(InputStream file) {
      this.file = file;
      return this;
    }

    /**
     * Set the filename.
     *
     * @param filename the filename
     * @return the TranslateDocumentOptions builder
     */
    public Builder filename(String filename) {
      this.filename = filename;
      return this;
    }

    /**
     * Set the fileContentType.
     *
     * @param fileContentType the fileContentType
     * @return the TranslateDocumentOptions builder
     */
    public Builder fileContentType(String fileContentType) {
      this.fileContentType = fileContentType;
      return this;
    }

    /**
     * Set the modelId.
     *
     * @param modelId the modelId
     * @return the TranslateDocumentOptions builder
     */
    public Builder modelId(String modelId) {
      this.modelId = modelId;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the TranslateDocumentOptions builder
     */
    public Builder source(String source) {
      this.source = source;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the TranslateDocumentOptions builder
     */
    public Builder target(String target) {
      this.target = target;
      return this;
    }

    /**
     * Set the documentId.
     *
     * @param documentId the documentId
     * @return the TranslateDocumentOptions builder
     */
    public Builder documentId(String documentId) {
      this.documentId = documentId;
      return this;
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the TranslateDocumentOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder file(File file) throws FileNotFoundException {
      this.file = new FileInputStream(file);
      this.filename = file.getName();
      return this;
    }
  }

  protected TranslateDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.file, "file cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.filename, "filename cannot be null");
    file = builder.file;
    filename = builder.filename;
    fileContentType = builder.fileContentType;
    modelId = builder.modelId;
    source = builder.source;
    target = builder.target;
    documentId = builder.documentId;
  }

  /**
   * New builder.
   *
   * @return a TranslateDocumentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the file.
   *
   * <p>The contents of the source file to translate.
   *
   * <p>[Supported file
   * types](https://cloud.ibm.com/docs/language-translator?topic=language-translator-document-translator-tutorial#supported-file-formats)
   *
   * <p>Maximum file size: **20 MB**.
   *
   * @return the file
   */
  public InputStream file() {
    return file;
  }

  /**
   * Gets the filename.
   *
   * <p>The filename for file.
   *
   * @return the filename
   */
  public String filename() {
    return filename;
  }

  /**
   * Gets the fileContentType.
   *
   * <p>The content type of file. Values for this parameter can be obtained from the HttpMediaType
   * class.
   *
   * @return the fileContentType
   */
  public String fileContentType() {
    return fileContentType;
  }

  /**
   * Gets the modelId.
   *
   * <p>The model to use for translation. For example, `en-de` selects the IBM provided base model
   * for English to German translation. A model ID overrides the source and target parameters and is
   * required if you use a custom model. If no model ID is specified, you must specify a target
   * language.
   *
   * @return the modelId
   */
  public String modelId() {
    return modelId;
  }

  /**
   * Gets the source.
   *
   * <p>Language code that specifies the language of the source document.
   *
   * @return the source
   */
  public String source() {
    return source;
  }

  /**
   * Gets the target.
   *
   * <p>Language code that specifies the target language for translation. Required if model ID is
   * not specified.
   *
   * @return the target
   */
  public String target() {
    return target;
  }

  /**
   * Gets the documentId.
   *
   * <p>To use a previously submitted document as the source for a new translation, enter the
   * `document_id` of the document.
   *
   * @return the documentId
   */
  public String documentId() {
    return documentId;
  }
}

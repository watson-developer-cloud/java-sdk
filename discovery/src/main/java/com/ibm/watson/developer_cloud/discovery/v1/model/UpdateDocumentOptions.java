/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The updateDocument options.
 */
public class UpdateDocumentOptions extends GenericModel {

  private String environmentId;
  private String collectionId;
  private String documentId;
  private InputStream file;
  private String filename;
  private String metadata;
  private String fileContentType;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String collectionId;
    private String documentId;
    private InputStream file;
    private String filename;
    private String metadata;
    private String fileContentType;

    private Builder(UpdateDocumentOptions updateDocumentOptions) {
      environmentId = updateDocumentOptions.environmentId;
      collectionId = updateDocumentOptions.collectionId;
      documentId = updateDocumentOptions.documentId;
      file = updateDocumentOptions.file;
      filename = updateDocumentOptions.filename;
      metadata = updateDocumentOptions.metadata;
      fileContentType = updateDocumentOptions.fileContentType;
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
     * Builds a UpdateDocumentOptions.
     *
     * @return the updateDocumentOptions
     */
    public UpdateDocumentOptions build() {
      return new UpdateDocumentOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the UpdateDocumentOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the UpdateDocumentOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the documentId.
     *
     * @param documentId the documentId
     * @return the UpdateDocumentOptions builder
     */
    public Builder documentId(String documentId) {
      this.documentId = documentId;
      return this;
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the UpdateDocumentOptions builder
     */
    public Builder file(InputStream file) {
      this.file = file;
      return this;
    }

    /**
     * Set the filename.
     *
     * @param filename the filename
     * @return the UpdateDocumentOptions builder
     */
    public Builder filename(String filename) {
      this.filename = filename;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the UpdateDocumentOptions builder
     */
    public Builder metadata(String metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the fileContentType.
     *
     * @param fileContentType the fileContentType
     * @return the UpdateDocumentOptions builder
     */
    public Builder fileContentType(String fileContentType) {
      this.fileContentType = fileContentType;
      return this;
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the UpdateDocumentOptions builder
     *
     * @throws FileNotFoundException
     */
    public Builder file(File file) throws FileNotFoundException {
      this.file = new FileInputStream(file);
      this.filename = file.getName();
      return this;
    }
  }

  private UpdateDocumentOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    Validator.notEmpty(builder.collectionId, "collectionId cannot be empty");
    Validator.notEmpty(builder.documentId, "documentId cannot be empty");
    Validator.isTrue((builder.file == null) || (builder.filename != null),
        "filename cannot be null if file is not null.");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
    documentId = builder.documentId;
    file = builder.file;
    filename = builder.filename;
    metadata = builder.metadata;
    fileContentType = builder.fileContentType;
  }

  /**
   * New builder.
   *
   * @return a UpdateDocumentOptions builder
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

  /**
   * Gets the file.
   *
   * The content of the document to ingest. The maximum supported file size is 50 megabytes. Files larger than 50
   * megabytes is rejected.
   *
   * @return the file
   */
  public InputStream file() {
    return file;
  }

  /**
   * Gets the filename.
   *
   * The filename for file.
   *
   * @return the filename
   */
  public String filename() {
    return filename;
  }

  /**
   * Gets the metadata.
   *
   * If you're using the Data Crawler to upload your documents, you can test a document against the type of metadata
   * that the Data Crawler might send. The maximum supported metadata file size is 1 MB. Metadata parts larger than 1 MB
   * are rejected. Example: ``` { "Creator": "Johnny Appleseed", "Subject": "Apples" } ```
   *
   * @return the metadata
   */
  public String metadata() {
    return metadata;
  }

  /**
   * Gets the fileContentType.
   *
   * The content type of file. Values for this parameter can be obtained from the HttpMediaType class.
   *
   * @return the fileContentType
   */
  public String fileContentType() {
    return fileContentType;
  }
}

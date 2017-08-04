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

import java.io.InputStream;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The updateDocument options.
 */
public class UpdateDocumentOptions extends GenericModel {

  /**
   * The media type of file.
   */
  public interface FileMediaType {
    /** application/json. */
    String APPLICATION_JSON = "application/json";
    /** application/msword. */
    String APPLICATION_MSWORD = "application/msword";
    /** application/vnd.openxmlformats-officedocument.wordprocessingml.document. */
    String APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT =
        "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    /** application/pdf. */
    String APPLICATION_PDF = "application/pdf";
    /** text/html. */
    String TEXT_HTML = "text/html";
    /** application/xhtml+xml. */
    String APPLICATION_XHTML_XML = "application/xhtml+xml";
  }

  private String environmentId;
  private String collectionId;
  private String documentId;
  private InputStream file;
  private String fileMediaType;
  private String metadata;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String collectionId;
    private String documentId;
    private InputStream file;
    private String fileMediaType;
    private String metadata;

    private Builder(UpdateDocumentOptions updateDocumentOptions) {
      environmentId = updateDocumentOptions.environmentId;
      collectionId = updateDocumentOptions.collectionId;
      documentId = updateDocumentOptions.documentId;
      file = updateDocumentOptions.file;
      fileMediaType = updateDocumentOptions.fileMediaType;
      metadata = updateDocumentOptions.metadata;
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
     * Set the fileMediaType.
     *
     * @param fileMediaType the fileMediaType
     * @return the UpdateDocumentOptions builder
     */
    public Builder fileMediaType(String fileMediaType) {
      this.fileMediaType = fileMediaType;
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
  }

  private UpdateDocumentOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    Validator.notEmpty(builder.collectionId, "collectionId cannot be empty");
    Validator.notEmpty(builder.documentId, "documentId cannot be empty");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
    documentId = builder.documentId;
    file = builder.file;
    fileMediaType = builder.fileMediaType;
    metadata = builder.metadata;
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
   * the ID of your environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the collectionId.
   *
   * the ID of your collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the documentId.
   *
   * the ID of your document.
   *
   * @return the documentId
   */
  public String documentId() {
    return documentId;
  }

  /**
   * Gets the file.
   *
   * The content of the document to ingest.The maximum supported file size is 50 megabytes. Files larger than 50
   * megabytes is rejected.
   *
   * @return the file
   */
  public InputStream file() {
    return file;
  }

  /**
   * Gets the fileMediaType.
   *
   * The media type of file.
   *
   * @return the fileMediaType
   */
  public String fileMediaType() {
    return fileMediaType;
  }

  /**
   * Gets the metadata.
   *
   * If you're using the Data Crawler to upload your documents, you can test a document against the type of metadata
   * that the Data Crawler might send. The maximum supported metadata file size is 1 MB. Metadata parts larger than 1 MB
   * are rejected. Example: ``` { "Creator": "Johnny Appleseed", "Subject": "Apples" } ```.
   *
   * @return the metadata
   */
  public String metadata() {
    return metadata;
  }
}

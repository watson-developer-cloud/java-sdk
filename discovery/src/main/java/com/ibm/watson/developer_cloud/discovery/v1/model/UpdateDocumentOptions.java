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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

import java.io.InputStream;

/**
 * the updateDocument options.
 */
public class UpdateDocumentOptions extends GenericModel {

  /** the ID of your environment. */
  @SerializedName("environment_id")
  private String environmentId;
  /** the ID of your collection. */
  @SerializedName("collection_id")
  private String collectionId;
  /** the ID of your document. */
  @SerializedName("document_id")
  private String documentId;
  /** The ID of the configuration to use to process the document. If the `configuration` form part is also provided
   * (both are present at the same time), then request will be rejected. */
  @SerializedName("configuration_id")
  private String configurationId;
  /** The content of the document to ingest.The maximum supported file size is 50 megabytes. Files larger than 50
   * megabytes is rejected. */
  private InputStream file;
  /** the media type of file. */
  private String fileMediaType;
  /** If you're using the Data Crawler to upload your documents, you can test a document against the type of metadata
   *  that the Data Crawler might send. The maximum supported metadata file size is 1 MB. Metadata parts larger than
   *  1 MB are rejected. Example:  ``` {   "Creator": "Johnny Appleseed",   "Subject": "Apples" } ```. */
  private String metadata;
  /** The configuration to use to process the document. If this part is provided, then the provided configuration is
   * used to process the document. If the `configuration_id` is also provided (both are present at the same time),
   * then request is rejected. The maximum supported configuration size is 1 MB. Configuration parts larger than 1 MB
   * are rejected. See the `GET /configurations/{configuration_id}` operation for an example configuration. */
  private String configuration;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String collectionId;
    private String documentId;
    private String configurationId;
    private InputStream file;
    private String fileMediaType;
    private String metadata;
    private String configuration;

    private Builder(UpdateDocumentOptions updateDocumentOptions) {
      environmentId = updateDocumentOptions.environmentId;
      collectionId = updateDocumentOptions.collectionId;
      documentId = updateDocumentOptions.documentId;
      configurationId = updateDocumentOptions.configurationId;
      file = updateDocumentOptions.file;
      fileMediaType = updateDocumentOptions.fileMediaType;
      metadata = updateDocumentOptions.metadata;
      configuration = updateDocumentOptions.configuration;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
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
     * Set the configurationId.
     *
     * @param configurationId the configurationId
     * @return the UpdateDocumentOptions builder
     */
    public Builder configurationId(String configurationId) {
      this.configurationId = configurationId;
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

    /**
     * Set the configuration.
     *
     * @param configuration the configuration
     * @return the UpdateDocumentOptions builder
     */
    public Builder configuration(String configuration) {
      this.configuration = configuration;
      return this;
    }
  }

  private UpdateDocumentOptions(Builder builder) {
    Validator.notNull(builder.environmentId, "environmentId cannot be null");
    Validator.notNull(builder.collectionId, "collectionId cannot be null");
    Validator.notNull(builder.documentId, "documentId cannot be null");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
    documentId = builder.documentId;
    configurationId = builder.configurationId;
    file = builder.file;
    fileMediaType = builder.fileMediaType;
    metadata = builder.metadata;
    configuration = builder.configuration;
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
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the collectionId.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the documentId.
   *
   * @return the documentId
   */
  public String documentId() {
    return documentId;
  }

  /**
   * Gets the configurationId.
   *
   * @return the configurationId
   */
  public String configurationId() {
    return configurationId;
  }

  /**
   * Gets the file.
   *
   * @return the file
   */
  public InputStream file() {
    return file;
  }

  /**
   * Gets the fileMediaType.
   *
   * @return the fileMediaType
   */
  public String fileMediaType() {
    return fileMediaType;
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public String metadata() {
    return metadata;
  }

  /**
   * Gets the configuration.
   *
   * @return the configuration
   */
  public String configuration() {
    return configuration;
  }
}

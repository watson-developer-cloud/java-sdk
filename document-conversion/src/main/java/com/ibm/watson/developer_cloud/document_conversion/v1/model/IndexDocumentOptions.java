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
package com.ibm.watson.developer_cloud.document_conversion.v1.model;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;

/**
 * Options when indexing a document.
 */
public class IndexDocumentOptions {
  /**
   * Builder.
   */
  public static class Builder {
    private JsonObject conversionConfiguration;
    private File document;
    private InputStream documentInputStream;
    private boolean dryRun;
    private IndexConfiguration indexConfiguration;
    private String mediaType;
    private Map<String, String> metadata;

    /**
     * Instantiates a new builder.
     *
     * @param options the options
     */
    private Builder(IndexDocumentOptions options) {
      document = options.document;
      documentInputStream = options.documentInputStream;
      mediaType = options.mediaType;
      metadata = options.metadata;
      conversionConfiguration = options.convertDocumentConfig;
      indexConfiguration = options.indexConfiguration;
      dryRun = options.dryRun;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds the index document options.
     *
     * @return the index document options
     */
    public IndexDocumentOptions build() {
      return new IndexDocumentOptions(this);
    }

    /**
     * Sets the convert document configuration.
     *
     * @param convertDocumentConfig Configuration for the convert document phase
     * @return the index document options
     */
    public Builder convertDocumentConfig(JsonObject convertDocumentConfig) {
      conversionConfiguration = convertDocumentConfig;
      return this;
    }

    /**
     * Sets the document.
     *
     * @param document The document to be converted and indexed
     * @return the index document options
     */
    public Builder document(File document) {
      this.document = document;
      return this;
    }

    /**
     * Sets the document as an input stream and its media type.
     *
     * @param document The document to be converted and indexed
     * @param mediaType The media type of the document
     * @return the index document options
     */
    public Builder document(InputStream document, String mediaType) {
      documentInputStream = document;
      this.mediaType = mediaType;
      return this;
    }

    /**
     * Sets the dryRun flag.
     *
     * @param dryRun If true, performs a dry run for testing purposes (document won't be indexed), else to index the
     *        document
     * @return the index document options
     */
    public Builder dryRun(Boolean dryRun) {
      this.dryRun = dryRun;
      return this;
    }

    /**
     * Sets the retrieve and rank configuration.
     *
     * @param indexConfiguration Configuration for the retrieve and rank service for the indexing phase
     * @return the index document options
     */
    public Builder indexConfiguration(IndexConfiguration indexConfiguration) {
      this.indexConfiguration = indexConfiguration;
      return this;
    }

    /**
     * Sets the media type.
     *
     * @param mediaType The media type of the document to be converted and indexed
     * @return the index document options
     */
    public Builder mediaType(String mediaType) {
      this.mediaType = mediaType;
      return this;
    }


    /**
     * Sets the metadata.
     *
     * @param metadata The metadata of the document that will be indexed
     * @return the index document options
     */
    public Builder metadata(Map<String, String> metadata) {
      this.metadata = new HashMap<String, String>();
      this.metadata.putAll(metadata);
      return this;
    }
  }

  private JsonObject convertDocumentConfig;
  private File document;
  private InputStream documentInputStream;
  private Boolean dryRun;
  private IndexConfiguration indexConfiguration;
  private String mediaType;

  private Map<String, String> metadata;

  private IndexDocumentOptions(Builder builder) {
    document = builder.document;
    documentInputStream = builder.documentInputStream;
    mediaType = builder.mediaType;
    metadata = builder.metadata;
    convertDocumentConfig = builder.conversionConfiguration;
    indexConfiguration = builder.indexConfiguration;
    dryRun = builder.dryRun;
  }

  /**
   * Gets the configuration for the convert document phase.
   *
   * @return conversionConfiguration Configuration for the convert document phase
   */
  public JsonObject convertDocumentConfig() {
    return convertDocumentConfig;
  }

  /**
   * Gets the document.
   *
   * @return document The document to be converted and indexed
   */
  public File document() {
    return document;
  }

  /**
   * Gets the dryRun flag.
   *
   * @return dryRun If true, performs a dry run for testing purposes (document won't be indexed), else to index the
   *         document
   */
  public Boolean dryRun() {
    return dryRun;
  }

  /**
   * Gets the document as an input stream.
   *
   * @return InputStream The document to be converted and indexed
   */
  public InputStream getDocumentInputStream() {
    return documentInputStream;
  }

  /**
   * Gets configuration for the retrieve and rank service for the indexing phase.
   *
   * @return indexConfiguration Configuration for the retrieve and rank service for the indexing phase
   */
  public IndexConfiguration indexConfiguration() {
    return indexConfiguration;
  }

  /**
   * Gets the media type.
   *
   * @return mediaType The media type of the document to be converted and indexed
   */
  public String mediaType() {
    return mediaType;
  }

  /**
   * Gets the metadata.
   *
   * @return metadata The metadata of the document that will be indexed
   */
  public Map<String, String> metadata() {
    if (metadata == null) {
      return null;
    }
    Map<String, String> copy = new HashMap<String, String>();
    copy.putAll(metadata);
    return copy;
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

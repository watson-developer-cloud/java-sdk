package com.ibm.watson.developer_cloud.document_conversion.v1.model;

import com.google.gson.JsonObject;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

public class IndexDocumentOptions {
  private File document;
  private InputStream documentInputStream;
  private String mediaType;
  private Map<String, String> metadata;
  private JsonObject convertDocumentConfig;
  private IndexConfiguration indexConfiguration;
  private Boolean dryRun;

  /**
   * Gets the document
   *
   * @return document The document to be converted and indexed
   */
  public File document() {
    return document;
  }

  /**
   * Gets the document as an input stream
   *
   * @return InputStream The document to be converted and indexed
   */
  public InputStream getDocumentInputStream() { return documentInputStream; }

  /**
   * Gets the media type
   *
   * @return mediaType The media type of the document to be converted and indexed
   */
  public String mediaType() {
    return mediaType;
  }

  /**
   * Gets the metadata
   *
   * @return metadata The metadata of the document that will be indexed
   */
  public Map<String, String> metadata() {
    return metadata;
  }

  /**
   * Gets the configuration for the convert document phase
   *
   * @return conversionConfiguration Configuration for the convert document phase
   */
  public JsonObject convertDocumentConfig() {
    return convertDocumentConfig;
  }

  /**
   * Gets configuration for the retrieve and rank service for the indexing phase
   *
   * @return indexConfiguration Configuration for the retrieve and rank service for the indexing phase
   */
  public IndexConfiguration indexConfiguration() {
    return indexConfiguration;
  }

  /**
   * Gets the dryRun flag
   *
   * @return dryRun If true, performs a dry run for testing purposes (document won't be indexed), else to index the document
   */
  public Boolean dryRun() {
    return dryRun;
  }

  /**
   * Builder.
   */
  public static class Builder {
    private File document;
    private InputStream documentInputStream;
    private String mediaType;
    private Map<String, String> metadata;
    private JsonObject conversionConfiguration;
    private IndexConfiguration indexConfiguration;
    private boolean dryRun;

    private Builder(IndexDocumentOptions options) {
      this.document = options.document;
      this.documentInputStream = options.documentInputStream;
      this.mediaType = options.mediaType;
      this.metadata = options.metadata;
      this.conversionConfiguration = options.convertDocumentConfig;
      this.indexConfiguration = options.indexConfiguration;
      this.dryRun = options.dryRun;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {}

    /**
     * Builds the index document options.
     *
     * @return the index document options
     */
    public IndexDocumentOptions build() { return new IndexDocumentOptions(this); }

    /**
     * Sets the document as an input stream and its media type
     * @param document The document to be converted and indexed
     * @param mediaType The media type of the document
     * @return the index document options
     */
    public Builder document(InputStream document, String mediaType){
      this.documentInputStream = document;
      this.mediaType = mediaType;
      return this;
    }

    /**
     * Sets the document
     *
     * @param document The document to be converted and indexed
     * @return the index document options
     */
    public Builder document(File document){
      this.document = document;
      return this;
    }

    /**
     * Sets the media type
     *
     * @param mediaType The media type of the document to be converted and indexed
     * @return the index document options
     */
    public Builder mediaType(String mediaType){
      this.mediaType = mediaType;
      return this;
    }

    /**
     * Sets the metadata
     *
     * @param metadata The metadata of the document that will be indexed
     * @return the index document options
     */
    public Builder metadata(Map<String, String> metadata){
      this.metadata = metadata;
      return this;
    }

    /**
     * Sets the convert document configuration
     *
     * @param convertDocumentConfig Configuration for the convert document phase
     * @return the index document options
     */
    public Builder convertDocumentConfig(JsonObject convertDocumentConfig){
      this.conversionConfiguration = convertDocumentConfig;
      return this;
    }

    /*
     * Sets the retrieve and rank configuration
     *
     * @param indexConfiguration Configuration for the retrieve and rank service for the indexing phase
     * @return the index document options
     */
    public Builder indexConfiguration(IndexConfiguration indexConfiguration){
      this.indexConfiguration = indexConfiguration;
      return this;
    }

    /*
    * Sets the dryRun flag
    *
    * @param dryRun If true, performs a dry run for testing purposes (document won't be indexed), else to index the document
    * @return the index document options
    */
    public Builder dryRun(Boolean dryRun){
      this.dryRun = dryRun;
      return this;
    }
  }

  private IndexDocumentOptions(Builder builder) {
    this.document = builder.document;
    this.documentInputStream = builder.documentInputStream;
    this.mediaType = builder.mediaType;
    this.metadata = builder.metadata;
    this.convertDocumentConfig = builder.conversionConfiguration;
    this.indexConfiguration = builder.indexConfiguration;
    this.dryRun = builder.dryRun;
  }
}

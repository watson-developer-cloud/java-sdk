/*
 * (C) Copyright IBM Corp. 2019, 2024.
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

package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/** The updateDocument options. */
public class UpdateDocumentOptions extends GenericModel {

  protected String projectId;
  protected String collectionId;
  protected String documentId;
  protected InputStream file;
  protected String filename;
  protected String fileContentType;
  protected String metadata;
  protected Boolean xWatsonDiscoveryForce;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String collectionId;
    private String documentId;
    private InputStream file;
    private String filename;
    private String fileContentType;
    private String metadata;
    private Boolean xWatsonDiscoveryForce;

    /**
     * Instantiates a new Builder from an existing UpdateDocumentOptions instance.
     *
     * @param updateDocumentOptions the instance to initialize the Builder with
     */
    private Builder(UpdateDocumentOptions updateDocumentOptions) {
      this.projectId = updateDocumentOptions.projectId;
      this.collectionId = updateDocumentOptions.collectionId;
      this.documentId = updateDocumentOptions.documentId;
      this.file = updateDocumentOptions.file;
      this.filename = updateDocumentOptions.filename;
      this.fileContentType = updateDocumentOptions.fileContentType;
      this.metadata = updateDocumentOptions.metadata;
      this.xWatsonDiscoveryForce = updateDocumentOptions.xWatsonDiscoveryForce;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param collectionId the collectionId
     * @param documentId the documentId
     */
    public Builder(String projectId, String collectionId, String documentId) {
      this.projectId = projectId;
      this.collectionId = collectionId;
      this.documentId = documentId;
    }

    /**
     * Builds a UpdateDocumentOptions.
     *
     * @return the new UpdateDocumentOptions instance
     */
    public UpdateDocumentOptions build() {
      return new UpdateDocumentOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the UpdateDocumentOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
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
     * Set the xWatsonDiscoveryForce.
     *
     * @param xWatsonDiscoveryForce the xWatsonDiscoveryForce
     * @return the UpdateDocumentOptions builder
     */
    public Builder xWatsonDiscoveryForce(Boolean xWatsonDiscoveryForce) {
      this.xWatsonDiscoveryForce = xWatsonDiscoveryForce;
      return this;
    }

    /**
     * Set the file.
     *
     * @param file the file
     * @return the UpdateDocumentOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder file(File file) throws FileNotFoundException {
      this.file = new FileInputStream(file);
      this.filename = file.getName();
      return this;
    }
  }

  protected UpdateDocumentOptions() {}

  protected UpdateDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.documentId, "documentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.isTrue(
        (builder.file == null) || (builder.filename != null),
        "filename cannot be null if file is not null.");
    projectId = builder.projectId;
    collectionId = builder.collectionId;
    documentId = builder.documentId;
    file = builder.file;
    filename = builder.filename;
    fileContentType = builder.fileContentType;
    metadata = builder.metadata;
    xWatsonDiscoveryForce = builder.xWatsonDiscoveryForce;
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
   * Gets the projectId.
   *
   * <p>The Universally Unique Identifier (UUID) of the project. This information can be found from
   * the *Integrate and Deploy* page in Discovery.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the collectionId.
   *
   * <p>The Universally Unique Identifier (UUID) of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the documentId.
   *
   * <p>The ID of the document.
   *
   * @return the documentId
   */
  public String documentId() {
    return documentId;
  }

  /**
   * Gets the file.
   *
   * <p>**Add a document**: The content of the document to ingest. For the supported file types and
   * maximum supported file size limits when adding a document, see [the
   * documentation](/docs/discovery-data?topic=discovery-data-collections#supportedfiletypes).
   *
   * <p>**Analyze a document**: The content of the document to analyze but not ingest. Only the
   * `application/json` content type is supported by the Analyze API. For maximum supported file
   * size limits, see [the product
   * documentation](/docs/discovery-data?topic=discovery-data-analyzeapi#analyzeapi-limits).
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
   * Gets the metadata.
   *
   * <p>Add information about the file that you want to include in the response.
   *
   * <p>The maximum supported metadata file size is 1 MB. Metadata parts larger than 1 MB are
   * rejected.
   *
   * <p>Example:
   *
   * <p>``` { "filename": "favorites2.json", "file_type": "json" }.
   *
   * @return the metadata
   */
  public String metadata() {
    return metadata;
  }

  /**
   * Gets the xWatsonDiscoveryForce.
   *
   * <p>When `true`, the uploaded document is added to the collection even if the data for that
   * collection is shared with other collections.
   *
   * @return the xWatsonDiscoveryForce
   */
  public Boolean xWatsonDiscoveryForce() {
    return xWatsonDiscoveryForce;
  }
}

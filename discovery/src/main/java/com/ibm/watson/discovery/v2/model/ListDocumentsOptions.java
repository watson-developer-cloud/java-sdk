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
package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The listDocuments options. */
public class ListDocumentsOptions extends GenericModel {

  protected String projectId;
  protected String collectionId;
  protected Long count;
  protected String status;
  protected Boolean hasNotices;
  protected Boolean isParent;
  protected String parentDocumentId;
  protected String sha256;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String collectionId;
    private Long count;
    private String status;
    private Boolean hasNotices;
    private Boolean isParent;
    private String parentDocumentId;
    private String sha256;

    /**
     * Instantiates a new Builder from an existing ListDocumentsOptions instance.
     *
     * @param listDocumentsOptions the instance to initialize the Builder with
     */
    private Builder(ListDocumentsOptions listDocumentsOptions) {
      this.projectId = listDocumentsOptions.projectId;
      this.collectionId = listDocumentsOptions.collectionId;
      this.count = listDocumentsOptions.count;
      this.status = listDocumentsOptions.status;
      this.hasNotices = listDocumentsOptions.hasNotices;
      this.isParent = listDocumentsOptions.isParent;
      this.parentDocumentId = listDocumentsOptions.parentDocumentId;
      this.sha256 = listDocumentsOptions.sha256;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param collectionId the collectionId
     */
    public Builder(String projectId, String collectionId) {
      this.projectId = projectId;
      this.collectionId = collectionId;
    }

    /**
     * Builds a ListDocumentsOptions.
     *
     * @return the new ListDocumentsOptions instance
     */
    public ListDocumentsOptions build() {
      return new ListDocumentsOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the ListDocumentsOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the ListDocumentsOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the ListDocumentsOptions builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the ListDocumentsOptions builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Set the hasNotices.
     *
     * @param hasNotices the hasNotices
     * @return the ListDocumentsOptions builder
     */
    public Builder hasNotices(Boolean hasNotices) {
      this.hasNotices = hasNotices;
      return this;
    }

    /**
     * Set the isParent.
     *
     * @param isParent the isParent
     * @return the ListDocumentsOptions builder
     */
    public Builder isParent(Boolean isParent) {
      this.isParent = isParent;
      return this;
    }

    /**
     * Set the parentDocumentId.
     *
     * @param parentDocumentId the parentDocumentId
     * @return the ListDocumentsOptions builder
     */
    public Builder parentDocumentId(String parentDocumentId) {
      this.parentDocumentId = parentDocumentId;
      return this;
    }

    /**
     * Set the sha256.
     *
     * @param sha256 the sha256
     * @return the ListDocumentsOptions builder
     */
    public Builder sha256(String sha256) {
      this.sha256 = sha256;
      return this;
    }
  }

  protected ListDocumentsOptions() {}

  protected ListDocumentsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    projectId = builder.projectId;
    collectionId = builder.collectionId;
    count = builder.count;
    status = builder.status;
    hasNotices = builder.hasNotices;
    isParent = builder.isParent;
    parentDocumentId = builder.parentDocumentId;
    sha256 = builder.sha256;
  }

  /**
   * New builder.
   *
   * @return a ListDocumentsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the projectId.
   *
   * <p>The ID of the project. This information can be found from the *Integrate and Deploy* page in
   * Discovery.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the collectionId.
   *
   * <p>The ID of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the count.
   *
   * <p>The maximum number of documents to return. Up to 1,000 documents are returned by default.
   * The maximum number allowed is 10,000.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }

  /**
   * Gets the status.
   *
   * <p>Filters the documents to include only documents with the specified ingestion status. The
   * options include:
   *
   * <p>* `available`: Ingestion is finished and the document is indexed.
   *
   * <p>* `failed`: Ingestion is finished, but the document is not indexed because of an error.
   *
   * <p>* `pending`: The document is uploaded, but the ingestion process is not started.
   *
   * <p>* `processing`: Ingestion is in progress.
   *
   * <p>You can specify one status value or add a comma-separated list of more than one status
   * value. For example, `available,failed`.
   *
   * @return the status
   */
  public String status() {
    return status;
  }

  /**
   * Gets the hasNotices.
   *
   * <p>If set to `true`, only documents that have notices, meaning documents for which warnings or
   * errors were generated during the ingestion, are returned. If set to `false`, only documents
   * that don't have notices are returned. If unspecified, no filter based on notices is applied.
   *
   * <p>Notice details are not available in the result, but you can use the [Query collection
   * notices](#querycollectionnotices) method to find details by adding the parameter
   * `query=notices.document_id:{document-id}`.
   *
   * @return the hasNotices
   */
  public Boolean hasNotices() {
    return hasNotices;
  }

  /**
   * Gets the isParent.
   *
   * <p>If set to `true`, only parent documents, meaning documents that were split during the
   * ingestion process and resulted in two or more child documents, are returned. If set to `false`,
   * only child documents are returned. If unspecified, no filter based on the parent or child
   * relationship is applied.
   *
   * <p>CSV files, for example, are split into separate documents per line and JSON files are split
   * into separate documents per object.
   *
   * @return the isParent
   */
  public Boolean isParent() {
    return isParent;
  }

  /**
   * Gets the parentDocumentId.
   *
   * <p>Filters the documents to include only child documents that were generated when the specified
   * parent document was processed.
   *
   * @return the parentDocumentId
   */
  public String parentDocumentId() {
    return parentDocumentId;
  }

  /**
   * Gets the sha256.
   *
   * <p>Filters the documents to include only documents with the specified SHA-256 hash. Format the
   * hash as a hexadecimal string.
   *
   * @return the sha256
   */
  public String sha256() {
    return sha256;
  }
}

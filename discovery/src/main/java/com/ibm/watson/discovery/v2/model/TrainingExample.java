/*
 * (C) Copyright IBM Corp. 2019, 2021.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;

/** Object that contains example response details for a training query. */
public class TrainingExample extends GenericModel {

  @SerializedName("document_id")
  protected String documentId;

  @SerializedName("collection_id")
  protected String collectionId;

  protected Long relevance;
  protected Date created;
  protected Date updated;

  /** Builder. */
  public static class Builder {
    private String documentId;
    private String collectionId;
    private Long relevance;

    private Builder(TrainingExample trainingExample) {
      this.documentId = trainingExample.documentId;
      this.collectionId = trainingExample.collectionId;
      this.relevance = trainingExample.relevance;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param documentId the documentId
     * @param collectionId the collectionId
     * @param relevance the relevance
     */
    public Builder(String documentId, String collectionId, Long relevance) {
      this.documentId = documentId;
      this.collectionId = collectionId;
      this.relevance = relevance;
    }

    /**
     * Builds a TrainingExample.
     *
     * @return the new TrainingExample instance
     */
    public TrainingExample build() {
      return new TrainingExample(this);
    }

    /**
     * Set the documentId.
     *
     * @param documentId the documentId
     * @return the TrainingExample builder
     */
    public Builder documentId(String documentId) {
      this.documentId = documentId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the TrainingExample builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the relevance.
     *
     * @param relevance the relevance
     * @return the TrainingExample builder
     */
    public Builder relevance(long relevance) {
      this.relevance = relevance;
      return this;
    }
  }

  protected TrainingExample(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.documentId, "documentId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.collectionId, "collectionId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.relevance, "relevance cannot be null");
    documentId = builder.documentId;
    collectionId = builder.collectionId;
    relevance = builder.relevance;
  }

  /**
   * New builder.
   *
   * @return a TrainingExample builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the documentId.
   *
   * <p>The document ID associated with this training example.
   *
   * @return the documentId
   */
  public String documentId() {
    return documentId;
  }

  /**
   * Gets the collectionId.
   *
   * <p>The collection ID associated with this training example.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the relevance.
   *
   * <p>The relevance of the training example.
   *
   * @return the relevance
   */
  public Long relevance() {
    return relevance;
  }

  /**
   * Gets the created.
   *
   * <p>The date and time the example was created.
   *
   * @return the created
   */
  public Date created() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * <p>The date and time the example was updated.
   *
   * @return the updated
   */
  public Date updated() {
    return updated;
  }
}

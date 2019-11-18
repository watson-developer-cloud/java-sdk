/*
 * (C) Copyright IBM Corp. 2019.
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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object containing example resppnse details for a training query.
 */
public class TrainingExample extends GenericModel {

  @SerializedName("document_id")
  private String documentId;
  @SerializedName("cross_reference")
  private String crossReference;
  private Long relevance;
  private Date created;
  private Date updated;

  /**
   * Builder.
   */
  public static class Builder {
    private String documentId;
    private String crossReference;
    private Long relevance;
    private Date created;
    private Date updated;

    private Builder(TrainingExample trainingExample) {
      this.documentId = trainingExample.documentId;
      this.crossReference = trainingExample.crossReference;
      this.relevance = trainingExample.relevance;
      this.created = trainingExample.created;
      this.updated = trainingExample.updated;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a TrainingExample.
     *
     * @return the trainingExample
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
     * Set the crossReference.
     *
     * @param crossReference the crossReference
     * @return the TrainingExample builder
     */
    public Builder crossReference(String crossReference) {
      this.crossReference = crossReference;
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

    /**
     * Set the created.
     *
     * @param created the created
     * @return the TrainingExample builder
     */
    public Builder created(Date created) {
      this.created = created;
      return this;
    }

    /**
     * Set the updated.
     *
     * @param updated the updated
     * @return the TrainingExample builder
     */
    public Builder updated(Date updated) {
      this.updated = updated;
      return this;
    }
  }

  private TrainingExample(Builder builder) {
    documentId = builder.documentId;
    crossReference = builder.crossReference;
    relevance = builder.relevance;
    created = builder.created;
    updated = builder.updated;
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
   * The document ID associated with this training example.
   *
   * @return the documentId
   */
  public String documentId() {
    return documentId;
  }

  /**
   * Gets the crossReference.
   *
   * The cross reference associated with this training example.
   *
   * @return the crossReference
   */
  public String crossReference() {
    return crossReference;
  }

  /**
   * Gets the relevance.
   *
   * The relevance of the training example.
   *
   * @return the relevance
   */
  public Long relevance() {
    return relevance;
  }

  /**
   * Gets the created.
   *
   * The date and time the example was created.
   *
   * @return the created
   */
  public Date created() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The date and time the example was updated.
   *
   * @return the updated
   */
  public Date updated() {
    return updated;
  }
}

/*
 * (C) Copyright IBM Corp. 2017, 2020.
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
package com.ibm.watson.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Training example details.
 */
public class TrainingExample extends GenericModel {

  @SerializedName("document_id")
  protected String documentId;
  @SerializedName("cross_reference")
  protected String crossReference;
  protected Long relevance;

  /**
   * Builder.
   */
  public static class Builder {
    private String documentId;
    private String crossReference;
    private Long relevance;

    private Builder(TrainingExample trainingExample) {
      this.documentId = trainingExample.documentId;
      this.crossReference = trainingExample.crossReference;
      this.relevance = trainingExample.relevance;
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
  }

  protected TrainingExample(Builder builder) {
    documentId = builder.documentId;
    crossReference = builder.crossReference;
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
}

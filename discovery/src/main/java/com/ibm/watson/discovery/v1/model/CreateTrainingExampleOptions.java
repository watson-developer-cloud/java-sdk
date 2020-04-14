/*
 * (C) Copyright IBM Corp. 2020.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The createTrainingExample options. */
public class CreateTrainingExampleOptions extends GenericModel {

  protected String environmentId;
  protected String collectionId;
  protected String queryId;
  protected String documentId;
  protected String crossReference;
  protected Long relevance;

  /** Builder. */
  public static class Builder {
    private String environmentId;
    private String collectionId;
    private String queryId;
    private String documentId;
    private String crossReference;
    private Long relevance;

    private Builder(CreateTrainingExampleOptions createTrainingExampleOptions) {
      this.environmentId = createTrainingExampleOptions.environmentId;
      this.collectionId = createTrainingExampleOptions.collectionId;
      this.queryId = createTrainingExampleOptions.queryId;
      this.documentId = createTrainingExampleOptions.documentId;
      this.crossReference = createTrainingExampleOptions.crossReference;
      this.relevance = createTrainingExampleOptions.relevance;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     * @param collectionId the collectionId
     * @param queryId the queryId
     */
    public Builder(String environmentId, String collectionId, String queryId) {
      this.environmentId = environmentId;
      this.collectionId = collectionId;
      this.queryId = queryId;
    }

    /**
     * Builds a CreateTrainingExampleOptions.
     *
     * @return the createTrainingExampleOptions
     */
    public CreateTrainingExampleOptions build() {
      return new CreateTrainingExampleOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the CreateTrainingExampleOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the CreateTrainingExampleOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the queryId.
     *
     * @param queryId the queryId
     * @return the CreateTrainingExampleOptions builder
     */
    public Builder queryId(String queryId) {
      this.queryId = queryId;
      return this;
    }

    /**
     * Set the documentId.
     *
     * @param documentId the documentId
     * @return the CreateTrainingExampleOptions builder
     */
    public Builder documentId(String documentId) {
      this.documentId = documentId;
      return this;
    }

    /**
     * Set the crossReference.
     *
     * @param crossReference the crossReference
     * @return the CreateTrainingExampleOptions builder
     */
    public Builder crossReference(String crossReference) {
      this.crossReference = crossReference;
      return this;
    }

    /**
     * Set the relevance.
     *
     * @param relevance the relevance
     * @return the CreateTrainingExampleOptions builder
     */
    public Builder relevance(long relevance) {
      this.relevance = relevance;
      return this;
    }

    /**
     * Set the trainingExample.
     *
     * @param trainingExample the trainingExample
     * @return the CreateTrainingExampleOptions builder
     */
    public Builder trainingExample(TrainingExample trainingExample) {
      this.documentId = trainingExample.documentId();
      this.crossReference = trainingExample.crossReference();
      this.relevance = trainingExample.relevance();
      return this;
    }
  }

  protected CreateTrainingExampleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.queryId, "queryId cannot be empty");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
    queryId = builder.queryId;
    documentId = builder.documentId;
    crossReference = builder.crossReference;
    relevance = builder.relevance;
  }

  /**
   * New builder.
   *
   * @return a CreateTrainingExampleOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * <p>The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
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
   * Gets the queryId.
   *
   * <p>The ID of the query used for training.
   *
   * @return the queryId
   */
  public String queryId() {
    return queryId;
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
   * Gets the crossReference.
   *
   * <p>The cross reference associated with this training example.
   *
   * @return the crossReference
   */
  public String crossReference() {
    return crossReference;
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
}

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

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The createTrainingExample options.
 */
public class CreateTrainingExampleOptions extends GenericModel {

  private String environmentId;
  private String collectionId;
  private String queryId;
  private String documentId;
  private Double relevance;
  private String crossReference;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String collectionId;
    private String queryId;
    private String documentId;
    private Double relevance;
    private String crossReference;

    private Builder(CreateTrainingExampleOptions createTrainingExampleOptions) {
      environmentId = createTrainingExampleOptions.environmentId;
      collectionId = createTrainingExampleOptions.collectionId;
      queryId = createTrainingExampleOptions.queryId;
      documentId = createTrainingExampleOptions.documentId;
      relevance = createTrainingExampleOptions.relevance;
      crossReference = createTrainingExampleOptions.crossReference;
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
     * Set the relevance.
     *
     * @param relevance the relevance
     * @return the CreateTrainingExampleOptions builder
     */
    public Builder relevance(Double relevance) {
      this.relevance = relevance;
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
     * Set the trainingExample.
     *
     * @param trainingExample the trainingExample
     * @return the CreateTrainingExampleOptions builder
     */
    public Builder trainingExample(TrainingExample trainingExample) {
      this.documentId = trainingExample.getDocumentId();
      this.relevance = trainingExample.getRelevance();
      this.crossReference = trainingExample.getCrossReference();
      return this;
    }
  }

  private CreateTrainingExampleOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    Validator.notEmpty(builder.collectionId, "collectionId cannot be empty");
    Validator.notEmpty(builder.queryId, "queryId cannot be empty");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
    queryId = builder.queryId;
    documentId = builder.documentId;
    relevance = builder.relevance;
    crossReference = builder.crossReference;
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
   * Gets the queryId.
   *
   * the ID of the query used for training.
   *
   * @return the queryId
   */
  public String queryId() {
    return queryId;
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
   * Gets the relevance.
   *
   * @return the relevance
   */
  public Double relevance() {
    return relevance;
  }

  /**
   * Gets the crossReference.
   *
   * @return the crossReference
   */
  public String crossReference() {
    return crossReference;
  }
}

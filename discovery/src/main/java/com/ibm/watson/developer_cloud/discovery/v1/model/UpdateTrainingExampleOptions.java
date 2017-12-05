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
 * The updateTrainingExample options.
 */
public class UpdateTrainingExampleOptions extends GenericModel {

  private String environmentId;
  private String collectionId;
  private String queryId;
  private String exampleId;
  private String crossReference;
  private Long relevance;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String collectionId;
    private String queryId;
    private String exampleId;
    private String crossReference;
    private Long relevance;

    private Builder(UpdateTrainingExampleOptions updateTrainingExampleOptions) {
      environmentId = updateTrainingExampleOptions.environmentId;
      collectionId = updateTrainingExampleOptions.collectionId;
      queryId = updateTrainingExampleOptions.queryId;
      exampleId = updateTrainingExampleOptions.exampleId;
      crossReference = updateTrainingExampleOptions.crossReference;
      relevance = updateTrainingExampleOptions.relevance;
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
     * @param exampleId the exampleId
     */
    public Builder(String environmentId, String collectionId, String queryId, String exampleId) {
      this.environmentId = environmentId;
      this.collectionId = collectionId;
      this.queryId = queryId;
      this.exampleId = exampleId;
    }

    /**
     * Builds a UpdateTrainingExampleOptions.
     *
     * @return the updateTrainingExampleOptions
     */
    public UpdateTrainingExampleOptions build() {
      return new UpdateTrainingExampleOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the UpdateTrainingExampleOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the UpdateTrainingExampleOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the queryId.
     *
     * @param queryId the queryId
     * @return the UpdateTrainingExampleOptions builder
     */
    public Builder queryId(String queryId) {
      this.queryId = queryId;
      return this;
    }

    /**
     * Set the exampleId.
     *
     * @param exampleId the exampleId
     * @return the UpdateTrainingExampleOptions builder
     */
    public Builder exampleId(String exampleId) {
      this.exampleId = exampleId;
      return this;
    }

    /**
     * Set the crossReference.
     *
     * @param crossReference the crossReference
     * @return the UpdateTrainingExampleOptions builder
     */
    public Builder crossReference(String crossReference) {
      this.crossReference = crossReference;
      return this;
    }

    /**
     * Set the relevance.
     *
     * @param relevance the relevance
     * @return the UpdateTrainingExampleOptions builder
     */
    public Builder relevance(long relevance) {
      this.relevance = relevance;
      return this;
    }
  }

  private UpdateTrainingExampleOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    Validator.notEmpty(builder.collectionId, "collectionId cannot be empty");
    Validator.notEmpty(builder.queryId, "queryId cannot be empty");
    Validator.notEmpty(builder.exampleId, "exampleId cannot be empty");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
    queryId = builder.queryId;
    exampleId = builder.exampleId;
    crossReference = builder.crossReference;
    relevance = builder.relevance;
  }

  /**
   * New builder.
   *
   * @return a UpdateTrainingExampleOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the collectionId.
   *
   * The ID of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the queryId.
   *
   * The ID of the query used for training.
   *
   * @return the queryId
   */
  public String queryId() {
    return queryId;
  }

  /**
   * Gets the exampleId.
   *
   * The ID of the document as it is indexed.
   *
   * @return the exampleId
   */
  public String exampleId() {
    return exampleId;
  }

  /**
   * Gets the crossReference.
   *
   * @return the crossReference
   */
  public String crossReference() {
    return crossReference;
  }

  /**
   * Gets the relevance.
   *
   * @return the relevance
   */
  public Long relevance() {
    return relevance;
  }
}

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
package com.ibm.watson.discovery.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The listTrainingExamples options. */
public class ListTrainingExamplesOptions extends GenericModel {

  protected String environmentId;
  protected String collectionId;
  protected String queryId;

  /** Builder. */
  public static class Builder {
    private String environmentId;
    private String collectionId;
    private String queryId;

    /**
     * Instantiates a new Builder from an existing ListTrainingExamplesOptions instance.
     *
     * @param listTrainingExamplesOptions the instance to initialize the Builder with
     */
    private Builder(ListTrainingExamplesOptions listTrainingExamplesOptions) {
      this.environmentId = listTrainingExamplesOptions.environmentId;
      this.collectionId = listTrainingExamplesOptions.collectionId;
      this.queryId = listTrainingExamplesOptions.queryId;
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
     * Builds a ListTrainingExamplesOptions.
     *
     * @return the new ListTrainingExamplesOptions instance
     */
    public ListTrainingExamplesOptions build() {
      return new ListTrainingExamplesOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the ListTrainingExamplesOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the ListTrainingExamplesOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the queryId.
     *
     * @param queryId the queryId
     * @return the ListTrainingExamplesOptions builder
     */
    public Builder queryId(String queryId) {
      this.queryId = queryId;
      return this;
    }
  }

  protected ListTrainingExamplesOptions() {}

  protected ListTrainingExamplesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.queryId, "queryId cannot be empty");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
    queryId = builder.queryId;
  }

  /**
   * New builder.
   *
   * @return a ListTrainingExamplesOptions builder
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
}

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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * TrainingDataSet.
 */
public class TrainingDataSet extends GenericModel {

  @SerializedName("environment_id")
  private String environmentId;
  @SerializedName("collection_id")
  private String collectionId;
  private List<TrainingQuery> queries;

  /**
   * Gets the environmentId.
   *
   * @return the environmentId
   */
  public String getEnvironmentId() {
    return environmentId;
  }

  /**
   * Gets the collectionId.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return collectionId;
  }

  /**
   * Gets the queries.
   *
   * @return the queries
   */
  public List<TrainingQuery> getQueries() {
    return queries;
  }

  /**
   * Sets the environmentId.
   *
   * @param environmentId the new environmentId
   */
  public void setEnvironmentId(final String environmentId) {
    this.environmentId = environmentId;
  }

  /**
   * Sets the collectionId.
   *
   * @param collectionId the new collectionId
   */
  public void setCollectionId(final String collectionId) {
    this.collectionId = collectionId;
  }

  /**
   * Sets the queries.
   *
   * @param queries the new queries
   */
  public void setQueries(final List<TrainingQuery> queries) {
    this.queries = queries;
  }
}

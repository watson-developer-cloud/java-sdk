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
 * AggregationResult.
 */
public class AggregationResult extends GenericModel {

  /** Key that matched the aggregation type. */
  private String key;
  /** Number of matching results. */
  @SerializedName("matching_results")
  private Long matchingResults;
  /** Aggregations returned in the case of chained aggregations. */
  private List<QueryAggregation> aggregations;

  /**
   * Gets the key.
   *
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * Gets the matchingResults.
   *
   * @return the matchingResults
   */
  public Long getMatchingResults() {
    return matchingResults;
  }

  /**
   * Gets the aggregations.
   *
   * @return the aggregations
   */
  public List<QueryAggregation> getAggregations() {
    return aggregations;
  }

  /**
   * Sets the key.
   *
   * @param key the new key
   */
  public void setKey(final String key) {
    this.key = key;
  }

  /**
   * Sets the matchingResults.
   *
   * @param matchingResults the new matchingResults
   */
  public void setMatchingResults(final Long matchingResults) {
    this.matchingResults = matchingResults;
  }

  /**
   * Sets the aggregations.
   *
   * @param aggregations the new aggregations
   */
  public void setAggregations(final List<QueryAggregation> aggregations) {
    this.aggregations = aggregations;
  }
}

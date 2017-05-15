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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

import java.util.List;

/**
 * A response containing the documents and aggregations for the query.
 */
public class QueryResponse extends GenericModel {

  @SerializedName("matching_results")
  private Long matchingResults;
  private List<QueryResult> results;
  private List<QueryAggregation> aggregations;

  /**
   * Gets the matchingResults.
   *
   * @return the matchingResults
   */
  public Long getMatchingResults() {
    return matchingResults;
  }

  /**
   * Gets the results.
   *
   * @return the results
   */
  public List<QueryResult> getResults() {
    return results;
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
   * Sets the matchingResults.
   *
   * @param matchingResults the new matchingResults
   */
  public void setMatchingResults(final Long matchingResults) {
    this.matchingResults = matchingResults;
  }

  /**
   * Sets the results.
   *
   * @param results the new results
   */
  public void setResults(final List<QueryResult> results) {
    this.results = results;
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

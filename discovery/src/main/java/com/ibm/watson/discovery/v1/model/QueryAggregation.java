/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.watson.discovery.v1.query.AggregationDeserializer;

import java.util.List;

/**
 * An aggregation produced by the Discovery service to analyze the input provided.
 */
@JsonAdapter(AggregationDeserializer.class)
public class QueryAggregation extends GenericModel {

  private String type;
  private List<AggregationResult> results;
  @SerializedName("matching_results")
  private Long matchingResults;
  private List<QueryAggregation> aggregations;

  /**
   * Gets the type.
   *
   * The type of aggregation command used. For example: term, filter, max, min, etc.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the results.
   *
   * @return the results
   */
  public List<AggregationResult> getResults() {
    return results;
  }

  /**
   * Gets the matchingResults.
   *
   * Number of matching results.
   *
   * @return the matchingResults
   */
  public Long getMatchingResults() {
    return matchingResults;
  }

  /**
   * Gets the aggregations.
   *
   * Aggregations returned by the Discovery service.
   *
   * @return the aggregations
   */
  public List<QueryAggregation> getAggregations() {
    return aggregations;
  }
}

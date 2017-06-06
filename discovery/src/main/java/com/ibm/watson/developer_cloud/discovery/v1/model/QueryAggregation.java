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
 * An aggregation produced by the Discovery service to analyze the input provided.
 */
public class QueryAggregation extends GenericModel {

  /** The type of aggregation command used. e.g. term, filter, max, min, etc. */
  private String type;
  /** The field where the aggregation is located in the document. */
  private String field;
  private List<AggregationResult> results;
  /** The match the aggregated results queried for. */
  private String match;
  /** Number of matching results. */
  @SerializedName("matching_results")
  private Long matchingResults;
  /** Aggregations returned by the Discovery service. */
  private List<QueryAggregation> aggregations;
  /** Interval specified by using aggregation type 'timeslice'. */
  private Long interval;
  /** Value of the aggregation. (For 'max' and 'min' type). */
  private Double value;

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the field.
   *
   * @return the field
   */
  public String getField() {
    return field;
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
   * Gets the match.
   *
   * @return the match
   */
  public String getMatch() {
    return match;
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
   * Gets the interval.
   *
   * @return the interval
   */
  public Long getInterval() {
    return interval;
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public Double getValue() {
    return value;
  }

  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(final String type) {
    this.type = type;
  }

  /**
   * Sets the field.
   *
   * @param field the new field
   */
  public void setField(final String field) {
    this.field = field;
  }

  /**
   * Sets the results.
   *
   * @param results the new results
   */
  public void setResults(final List<AggregationResult> results) {
    this.results = results;
  }

  /**
   * Sets the match.
   *
   * @param match the new match
   */
  public void setMatch(final String match) {
    this.match = match;
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

  /**
   * Sets the interval.
   *
   * @param interval the new interval
   */
  public void setInterval(final Long interval) {
    this.interval = interval;
  }

  /**
   * Sets the value.
   *
   * @param value the new value
   */
  public void setValue(final Double value) {
    this.value = value;
  }
}

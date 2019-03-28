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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Aggregation result data for the requested metric.
 */
public class MetricTokenAggregationResult extends GenericModel {

  private String key;
  @SerializedName("matching_results")
  private Long matchingResults;
  @SerializedName("event_rate")
  private Double eventRate;

  /**
   * Gets the key.
   *
   * The content of the **natural_language_query** parameter used in the query that this result represents.
   *
   * @return the key
   */
  public String getKey() {
    return key;
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
   * Gets the eventRate.
   *
   * The number of queries with associated events divided by the total number of queries currently stored (queries and
   * events are stored in the log for 30 days).
   *
   * @return the eventRate
   */
  public Double getEventRate() {
    return eventRate;
  }
}

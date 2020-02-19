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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Aggregation result data for the requested metric.
 */
public class MetricAggregationResult extends GenericModel {

  @SerializedName("key_as_string")
  protected Date keyAsString;
  protected Long key;
  @SerializedName("matching_results")
  protected Long matchingResults;
  @SerializedName("event_rate")
  protected Double eventRate;

  /**
   * Gets the keyAsString.
   *
   * Date in string form representing the start of this interval.
   *
   * @return the keyAsString
   */
  public Date getKeyAsString() {
    return keyAsString;
  }

  /**
   * Gets the key.
   *
   * Unix epoch time equivalent of the **key_as_string**, that represents the start of this interval.
   *
   * @return the key
   */
  public Long getKey() {
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
   * The number of queries with associated events divided by the total number of queries for the interval. Only returned
   * with **event_rate** metrics.
   *
   * @return the eventRate
   */
  public Double getEventRate() {
    return eventRate;
  }
}


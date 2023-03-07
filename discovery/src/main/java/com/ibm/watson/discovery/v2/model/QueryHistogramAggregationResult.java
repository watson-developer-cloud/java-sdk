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
package com.ibm.watson.discovery.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;
import java.util.Map;

/** Histogram numeric interval result. */
public class QueryHistogramAggregationResult extends GenericModel {

  protected Long key;

  @SerializedName("matching_results")
  protected Long matchingResults;

  protected List<Map<String, Object>> aggregations;

  protected QueryHistogramAggregationResult() {}

  /**
   * Gets the key.
   *
   * <p>The value of the upper bound for the numeric segment.
   *
   * @return the key
   */
  public Long getKey() {
    return key;
  }

  /**
   * Gets the matchingResults.
   *
   * <p>Number of documents with the specified key as the upper bound.
   *
   * @return the matchingResults
   */
  public Long getMatchingResults() {
    return matchingResults;
  }

  /**
   * Gets the aggregations.
   *
   * <p>An array of subaggregations. Returned only when this aggregation is returned as a
   * subaggregation.
   *
   * @return the aggregations
   */
  public List<Map<String, Object>> getAggregations() {
    return aggregations;
  }
}

/*
 * (C) Copyright IBM Corp. 2019, 2024.
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

/** A timeslice interval segment. */
public class QueryTimesliceAggregationResult extends GenericModel {

  @SerializedName("key_as_string")
  protected String keyAsString;

  protected Long key;

  @SerializedName("matching_results")
  protected Long matchingResults;

  protected List<Map<String, Object>> aggregations;

  protected QueryTimesliceAggregationResult() {}

  /**
   * Gets the keyAsString.
   *
   * <p>String date value of the upper bound for the timeslice interval in ISO-8601 format.
   *
   * @return the keyAsString
   */
  public String getKeyAsString() {
    return keyAsString;
  }

  /**
   * Gets the key.
   *
   * <p>Numeric date value of the upper bound for the timeslice interval in UNIX milliseconds since
   * epoch.
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

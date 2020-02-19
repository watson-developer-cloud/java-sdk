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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object containing notice query results.
 */
public class QueryNoticesResponse extends GenericModel {

  @SerializedName("matching_results")
  protected Long matchingResults;
  protected List<QueryNoticesResult> results;
  protected List<QueryAggregation> aggregations;
  protected List<QueryPassages> passages;
  @SerializedName("duplicates_removed")
  protected Long duplicatesRemoved;

  /**
   * Gets the matchingResults.
   *
   * The number of matching results.
   *
   * @return the matchingResults
   */
  public Long getMatchingResults() {
    return matchingResults;
  }

  /**
   * Gets the results.
   *
   * Array of document results that match the query.
   *
   * @return the results
   */
  public List<QueryNoticesResult> getResults() {
    return results;
  }

  /**
   * Gets the aggregations.
   *
   * Array of aggregation results that match the query.
   *
   * @return the aggregations
   */
  public List<QueryAggregation> getAggregations() {
    return aggregations;
  }

  /**
   * Gets the passages.
   *
   * Array of passage results that match the query.
   *
   * @return the passages
   */
  public List<QueryPassages> getPassages() {
    return passages;
  }

  /**
   * Gets the duplicatesRemoved.
   *
   * The number of duplicates removed from this notices query.
   *
   * @return the duplicatesRemoved
   */
  public Long getDuplicatesRemoved() {
    return duplicatesRemoved;
  }
}


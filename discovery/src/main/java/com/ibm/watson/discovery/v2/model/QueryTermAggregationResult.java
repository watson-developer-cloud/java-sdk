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

/** Top value result for the `term` aggregation. */
public class QueryTermAggregationResult extends GenericModel {

  protected String key;

  @SerializedName("matching_results")
  protected Long matchingResults;

  protected Double relevancy;

  @SerializedName("total_matching_documents")
  protected Long totalMatchingDocuments;

  @SerializedName("estimated_matching_results")
  protected Double estimatedMatchingResults;

  protected List<Map<String, Object>> aggregations;

  protected QueryTermAggregationResult() {}

  /**
   * Gets the key.
   *
   * <p>Value of the field with a nonzero frequency in the document set.
   *
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * Gets the matchingResults.
   *
   * <p>Number of documents that contain the 'key'.
   *
   * @return the matchingResults
   */
  public Long getMatchingResults() {
    return matchingResults;
  }

  /**
   * Gets the relevancy.
   *
   * <p>The relevancy score for this result. Returned only if `relevancy:true` is specified in the
   * request.
   *
   * @return the relevancy
   */
  public Double getRelevancy() {
    return relevancy;
  }

  /**
   * Gets the totalMatchingDocuments.
   *
   * <p>Number of documents in the collection that contain the term in the specified field. Returned
   * only when `relevancy:true` is specified in the request.
   *
   * @return the totalMatchingDocuments
   */
  public Long getTotalMatchingDocuments() {
    return totalMatchingDocuments;
  }

  /**
   * Gets the estimatedMatchingResults.
   *
   * <p>Number of documents that are estimated to match the query and also meet the condition.
   * Returned only when `relevancy:true` is specified in the request.
   *
   * @return the estimatedMatchingResults
   */
  public Double getEstimatedMatchingResults() {
    return estimatedMatchingResults;
  }

  /**
   * Gets the aggregations.
   *
   * <p>An array of subaggregations. Returned only when this aggregation is combined with other
   * aggregations in the request or is returned as a subaggregation.
   *
   * @return the aggregations
   */
  public List<Map<String, Object>> getAggregations() {
    return aggregations;
  }
}

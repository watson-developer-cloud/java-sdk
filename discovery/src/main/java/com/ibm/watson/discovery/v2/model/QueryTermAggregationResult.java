/*
 * (C) Copyright IBM Corp. 2019, 2021.
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

/** Top value result for the term aggregation. */
public class QueryTermAggregationResult extends GenericModel {

  protected String key;

  @SerializedName("matching_results")
  protected Long matchingResults;

  protected Double relevancy;

  @SerializedName("total_matching_documents")
  protected Long totalMatchingDocuments;

  @SerializedName("estimated_matching_documents")
  protected Long estimatedMatchingDocuments;

  protected List<QueryAggregation> aggregations;

  /**
   * Gets the key.
   *
   * <p>Value of the field with a non-zero frequency in the document set.
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
   * <p>The relevancy for this term.
   *
   * @return the relevancy
   */
  public Double getRelevancy() {
    return relevancy;
  }

  /**
   * Gets the totalMatchingDocuments.
   *
   * <p>The number of documents which have the term as the value of specified field in the whole set
   * of documents in this collection. Returned only when the `relevancy` parameter is set to `true`.
   *
   * @return the totalMatchingDocuments
   */
  public Long getTotalMatchingDocuments() {
    return totalMatchingDocuments;
  }

  /**
   * Gets the estimatedMatchingDocuments.
   *
   * <p>The estimated number of documents which would match the query and also meet the condition.
   * Returned only when the `relevancy` parameter is set to `true`.
   *
   * @return the estimatedMatchingDocuments
   */
  public Long getEstimatedMatchingDocuments() {
    return estimatedMatchingDocuments;
  }

  /**
   * Gets the aggregations.
   *
   * <p>An array of sub-aggregations.
   *
   * @return the aggregations
   */
  public List<QueryAggregation> getAggregations() {
    return aggregations;
  }
}

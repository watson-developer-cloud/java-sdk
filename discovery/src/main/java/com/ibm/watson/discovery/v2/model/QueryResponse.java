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
package com.ibm.watson.discovery.v2.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A response containing the documents and aggregations for the query.
 */
public class QueryResponse extends GenericModel {

  @SerializedName("matching_results")
  protected Long matchingResults;
  protected List<QueryResult> results;
  protected List<QueryAggregation> aggregations;
  @SerializedName("retrieval_details")
  protected RetrievalDetails retrievalDetails;
  @SerializedName("suggested_query")
  protected String suggestedQuery;
  @SerializedName("suggested_refinements")
  protected List<QuerySuggestedRefinement> suggestedRefinements;
  @SerializedName("table_results")
  protected List<QueryTableResult> tableResults;

  /**
   * Gets the matchingResults.
   *
   * The number of matching results for the query.
   *
   * @return the matchingResults
   */
  public Long getMatchingResults() {
    return matchingResults;
  }

  /**
   * Gets the results.
   *
   * Array of document results for the query.
   *
   * @return the results
   */
  public List<QueryResult> getResults() {
    return results;
  }

  /**
   * Gets the aggregations.
   *
   * Array of aggregations for the query.
   *
   * @return the aggregations
   */
  public List<QueryAggregation> getAggregations() {
    return aggregations;
  }

  /**
   * Gets the retrievalDetails.
   *
   * An object contain retrieval type information.
   *
   * @return the retrievalDetails
   */
  public RetrievalDetails getRetrievalDetails() {
    return retrievalDetails;
  }

  /**
   * Gets the suggestedQuery.
   *
   * Suggested correction to the submitted **natural_language_query** value.
   *
   * @return the suggestedQuery
   */
  public String getSuggestedQuery() {
    return suggestedQuery;
  }

  /**
   * Gets the suggestedRefinements.
   *
   * Array of suggested refinements.
   *
   * @return the suggestedRefinements
   */
  public List<QuerySuggestedRefinement> getSuggestedRefinements() {
    return suggestedRefinements;
  }

  /**
   * Gets the tableResults.
   *
   * Array of table results.
   *
   * @return the tableResults
   */
  public List<QueryTableResult> getTableResults() {
    return tableResults;
  }
}

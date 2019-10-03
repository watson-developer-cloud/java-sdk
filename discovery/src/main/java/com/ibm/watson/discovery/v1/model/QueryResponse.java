/*
 * (C) Copyright IBM Corp. 2019.
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
 * A response containing the documents and aggregations for the query.
 */
public class QueryResponse extends GenericModel {

  @SerializedName("matching_results")
  private Long matchingResults;
  private List<QueryResult> results;
  private List<QueryAggregation> aggregations;
  private List<QueryPassages> passages;
  @SerializedName("duplicates_removed")
  private Long duplicatesRemoved;
  @SerializedName("session_token")
  private String sessionToken;
  @SerializedName("retrieval_details")
  private RetrievalDetails retrievalDetails;
  @SerializedName("suggested_query")
  private String suggestedQuery;

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
   * Array of aggregation results for the query.
   *
   * @return the aggregations
   */
  public List<QueryAggregation> getAggregations() {
    return aggregations;
  }

  /**
   * Gets the passages.
   *
   * Array of passage results for the query.
   *
   * @return the passages
   */
  public List<QueryPassages> getPassages() {
    return passages;
  }

  /**
   * Gets the duplicatesRemoved.
   *
   * The number of duplicate results removed.
   *
   * @return the duplicatesRemoved
   */
  public Long getDuplicatesRemoved() {
    return duplicatesRemoved;
  }

  /**
   * Gets the sessionToken.
   *
   * The session token for this query. The session token can be used to add events associated with this query to the
   * query and event log.
   *
   * **Important:** Session tokens are case sensitive.
   *
   * @return the sessionToken
   */
  public String getSessionToken() {
    return sessionToken;
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
   * The suggestions for a misspelled natural language query.
   *
   * @return the suggestedQuery
   */
  public String getSuggestedQuery() {
    return suggestedQuery;
  }
}

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
package com.ibm.watson.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** A response containing the documents and aggregations for the query. */
public class QueryResponse extends GenericModel {

  @SerializedName("matching_results")
  protected Long matchingResults;

  protected List<QueryResult> results;
  protected List<QueryAggregation> aggregations;
  protected List<QueryPassages> passages;

  @SerializedName("duplicates_removed")
  protected Long duplicatesRemoved;

  @SerializedName("session_token")
  protected String sessionToken;

  @SerializedName("retrieval_details")
  protected RetrievalDetails retrievalDetails;

  @SerializedName("suggested_query")
  protected String suggestedQuery;

  protected QueryResponse() {}

  /**
   * Gets the matchingResults.
   *
   * <p>The number of matching results for the query.
   *
   * @return the matchingResults
   */
  public Long getMatchingResults() {
    return matchingResults;
  }

  /**
   * Gets the results.
   *
   * <p>Array of document results for the query.
   *
   * @return the results
   */
  public List<QueryResult> getResults() {
    return results;
  }

  /**
   * Gets the aggregations.
   *
   * <p>Array of aggregation results for the query.
   *
   * @return the aggregations
   */
  public List<QueryAggregation> getAggregations() {
    return aggregations;
  }

  /**
   * Gets the passages.
   *
   * <p>Array of passage results for the query.
   *
   * @return the passages
   */
  public List<QueryPassages> getPassages() {
    return passages;
  }

  /**
   * Gets the duplicatesRemoved.
   *
   * <p>The number of duplicate results removed.
   *
   * @return the duplicatesRemoved
   */
  public Long getDuplicatesRemoved() {
    return duplicatesRemoved;
  }

  /**
   * Gets the sessionToken.
   *
   * <p>The session token for this query. The session token can be used to add events associated
   * with this query to the query and event log.
   *
   * <p>**Important:** Session tokens are case sensitive.
   *
   * @return the sessionToken
   */
  public String getSessionToken() {
    return sessionToken;
  }

  /**
   * Gets the retrievalDetails.
   *
   * <p>An object contain retrieval type information.
   *
   * @return the retrievalDetails
   */
  public RetrievalDetails getRetrievalDetails() {
    return retrievalDetails;
  }

  /**
   * Gets the suggestedQuery.
   *
   * <p>The suggestions for a misspelled natural language query.
   *
   * @return the suggestedQuery
   */
  public String getSuggestedQuery() {
    return suggestedQuery;
  }
}

/*
 * (C) Copyright IBM Corp. 2019, 2022.
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
import java.util.List;

/** A modifier that narrows the document set of the sub-aggregations it precedes. */
public class QueryFilterAggregation extends QueryAggregation {

  protected String match;

  @SerializedName("matching_results")
  protected Long matchingResults;

  protected List<QueryAggregation> aggregations;

  /**
   * Gets the match.
   *
   * <p>The filter that is written in Discovery Query Language syntax and is applied to the
   * documents before sub-aggregations are run.
   *
   * @return the match
   */
  public String getMatch() {
    return match;
  }

  /**
   * Gets the matchingResults.
   *
   * <p>Number of documents that match the filter.
   *
   * @return the matchingResults
   */
  public Long getMatchingResults() {
    return matchingResults;
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

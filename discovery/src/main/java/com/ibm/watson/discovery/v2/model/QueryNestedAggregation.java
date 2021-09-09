/*
 * (C) Copyright IBM Corp. 2021.
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
import java.util.List;

/**
 * A restriction that alters the document set that is used for sub-aggregations it precedes to
 * nested documents found in the field specified.
 */
public class QueryNestedAggregation extends QueryAggregation {

  protected String path;

  @SerializedName("matching_results")
  protected Long matchingResults;

  protected List<QueryAggregation> aggregations;

  /**
   * Gets the path.
   *
   * <p>The path to the document field to scope sub-aggregations to.
   *
   * @return the path
   */
  public String getPath() {
    return path;
  }

  /**
   * Gets the matchingResults.
   *
   * <p>Number of nested documents found in the specified field.
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

/*
 * (C) Copyright IBM Corp. 2023, 2024.
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

/**
 * Detects sharp and unexpected changes in the frequency of a facet or facet value over time based
 * on the past history of frequency changes of the facet value.
 */
public class QueryAggregationQueryTrendAggregation extends QueryAggregation {

  protected List<QueryTrendAggregationResult> results;

  protected QueryAggregationQueryTrendAggregation() {}

  /**
   * Gets the results.
   *
   * <p>An array of results.
   *
   * @return the results
   */
  public List<QueryTrendAggregationResult> getResults() {
    return results;
  }
}

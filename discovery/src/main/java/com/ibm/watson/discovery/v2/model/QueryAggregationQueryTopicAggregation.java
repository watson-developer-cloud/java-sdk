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
package com.ibm.watson.discovery.v2.model;

import java.util.List;

/**
 * Detects how much the frequency of a given facet value deviates from the expected average for the
 * given time period. This aggregation type does not use data from previous time periods. It
 * calculates an index by using the averages of frequency counts of other facet values for the given
 * time period.
 */
public class QueryAggregationQueryTopicAggregation extends QueryAggregation {

  protected List<QueryTopicAggregationResult> results;

  protected QueryAggregationQueryTopicAggregation() {}

  /**
   * Gets the results.
   *
   * <p>An array of results.
   *
   * @return the results
   */
  public List<QueryTopicAggregationResult> getResults() {
    return results;
  }
}

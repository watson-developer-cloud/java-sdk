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
 * Numeric interval segments to categorize documents by using field values from a single numeric
 * field to describe the category.
 */
public class QueryAggregationQueryHistogramAggregation extends QueryAggregation {

  protected Long interval;

  protected List<QueryHistogramAggregationResult> results;

  protected QueryAggregationQueryHistogramAggregation() {}

  /**
    * Gets the interval.
    *
    * <p>The size of the sections that the results are split into.
    *
    * @return the interval
    */
  public Long getInterval() {
    return interval;
  }

  /**
   * Gets the results.
   *
   * <p>An array of results.
   *
   * @return the results
   */
  public List<QueryHistogramAggregationResult> getResults() {
    return results;
  }
}

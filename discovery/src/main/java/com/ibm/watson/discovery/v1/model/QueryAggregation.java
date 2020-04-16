/*
 * (C) Copyright IBM Corp. 2019, 2020.
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

/** An aggregation produced by Discovery to analyze the input provided. */
public class QueryAggregation extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "type";

  protected static java.util.Map<String, Class<?>> discriminatorMapping;

  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put("histogram", Histogram.class);
    discriminatorMapping.put("max", Calculation.class);
    discriminatorMapping.put("min", Calculation.class);
    discriminatorMapping.put("average", Calculation.class);
    discriminatorMapping.put("sum", Calculation.class);
    discriminatorMapping.put("unique_count", Calculation.class);
    discriminatorMapping.put("term", Term.class);
    discriminatorMapping.put("filter", Filter.class);
    discriminatorMapping.put("nested", Nested.class);
    discriminatorMapping.put("timeslice", Timeslice.class);
    discriminatorMapping.put("top_hits", TopHits.class);
  }

  protected String type;
  protected List<AggregationResult> results;

  @SerializedName("matching_results")
  protected Long matchingResults;

  protected List<QueryAggregation> aggregations;

  /**
   * Gets the type.
   *
   * <p>The type of aggregation command used. For example: term, filter, max, min, etc.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the results.
   *
   * <p>Array of aggregation results.
   *
   * @return the results
   */
  public List<AggregationResult> getResults() {
    return results;
  }

  /**
   * Gets the matchingResults.
   *
   * <p>Number of matching results.
   *
   * @return the matchingResults
   */
  public Long getMatchingResults() {
    return matchingResults;
  }

  /**
   * Gets the aggregations.
   *
   * <p>Aggregations returned by Discovery.
   *
   * @return the aggregations
   */
  public List<QueryAggregation> getAggregations() {
    return aggregations;
  }
}

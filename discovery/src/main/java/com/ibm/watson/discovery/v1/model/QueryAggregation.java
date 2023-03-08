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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** An aggregation produced by Discovery to analyze the input provided. */
public class QueryAggregation extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "type";

  protected static java.util.Map<String, Class<?>> discriminatorMapping;

  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put("histogram", QueryHistogramAggregation.class);
    discriminatorMapping.put("max", QueryCalculationAggregation.class);
    discriminatorMapping.put("min", QueryCalculationAggregation.class);
    discriminatorMapping.put("average", QueryCalculationAggregation.class);
    discriminatorMapping.put("sum", QueryCalculationAggregation.class);
    discriminatorMapping.put("unique_count", QueryCalculationAggregation.class);
    discriminatorMapping.put("term", QueryTermAggregation.class);
    discriminatorMapping.put("filter", QueryFilterAggregation.class);
    discriminatorMapping.put("nested", QueryNestedAggregation.class);
    discriminatorMapping.put("timeslice", QueryTimesliceAggregation.class);
    discriminatorMapping.put("top_hits", QueryTopHitsAggregation.class);
  }

  protected String type;

  protected QueryAggregation() {}

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
}

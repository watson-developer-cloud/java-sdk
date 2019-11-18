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
package com.ibm.watson.discovery.v2.model;

import java.util.List;

/**
 * A specialized histogram aggregation that uses dates to create interval segments.
 */
public class QueryTimesliceAggregation extends QueryAggregation {

  private String field;
  private String interval;
  private List<QueryTimesliceAggregationResult> results;

  /**
   * Gets the field.
   *
   * The date field name used to create the timeslice.
   *
   * @return the field
   */
  public String getField() {
    return field;
  }

  /**
   * Gets the interval.
   *
   * The date interval value. Valid values are seconds, minutes, hours, days, weeks, and years.
   *
   * @return the interval
   */
  public String getInterval() {
    return interval;
  }

  /**
   * Gets the results.
   *
   * Array of aggregation results.
   *
   * @return the results
   */
  public List<QueryTimesliceAggregationResult> getResults() {
    return results;
  }
}

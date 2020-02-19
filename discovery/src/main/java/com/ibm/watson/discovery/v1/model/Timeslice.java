/*
 * (C) Copyright IBM Corp. 2020.
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

/**
 * Timeslice.
 */
public class Timeslice extends QueryAggregation {

  protected String field;
  protected String interval;
  protected Boolean anomaly;

  /**
   * Gets the field.
   *
   * The field where the aggregation is located in the document.
   *
   * @return the field
   */
  public String getField() {
    return field;
  }

  /**
   * Gets the interval.
   *
   * Interval of the aggregation. Valid date interval values are second/seconds minute/minutes, hour/hours, day/days,
   * week/weeks, month/months, and year/years.
   *
   * @return the interval
   */
  public String getInterval() {
    return interval;
  }

  /**
   * Gets the anomaly.
   *
   * Used to indicate that anomaly detection should be performed. Anomaly detection is used to locate unusual datapoints
   * within a time series.
   *
   * @return the anomaly
   */
  public Boolean isAnomaly() {
    return anomaly;
  }
}


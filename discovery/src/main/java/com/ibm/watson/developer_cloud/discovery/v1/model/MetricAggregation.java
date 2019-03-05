/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An aggregation analyzing log information for queries and events.
 */
public class MetricAggregation extends GenericModel {

  private String interval;
  @SerializedName("event_type")
  private String eventType;
  private List<MetricAggregationResult> results;

  /**
   * Gets the interval.
   *
   * The measurement interval for this metric. Metric intervals are always 1 day (`1d`).
   *
   * @return the interval
   */
  public String getInterval() {
    return interval;
  }

  /**
   * Gets the eventType.
   *
   * The event type associated with this metric result. This field, when present, will always be `click`.
   *
   * @return the eventType
   */
  public String getEventType() {
    return eventType;
  }

  /**
   * Gets the results.
   *
   * @return the results
   */
  public List<MetricAggregationResult> getResults() {
    return results;
  }
}

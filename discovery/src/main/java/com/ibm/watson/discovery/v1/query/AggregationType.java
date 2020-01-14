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
package com.ibm.watson.discovery.v1.query;

/**
 * Aggregation types.
 *
 * @deprecated This class has been replaced by the top-level version in com.ibm.watson.discovery.query.
 */
public enum AggregationType {
  TERM("term"), FILTER("filter"), NESTED("nested"), HISTOGRAM("histogram"), TIMESLICE("timeslice"), TOP_HITS(
      "top_hits"), UNIQUE_COUNT("unique_count"), MAX("max"), MIN("min"), AVERAGE("average"), SUM("sum");

  private final String name;

  AggregationType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static AggregationType valueOfIgnoreCase(String value) throws IllegalArgumentException {
    for (AggregationType aggregationType : values()) {
      if (aggregationType.getName().equalsIgnoreCase(value)) {
        return aggregationType;
      }
    }
    throw new IllegalArgumentException(value + " is not a valid Aggregation");
  }

  @Override
  public String toString() {
    return name;
  }
}

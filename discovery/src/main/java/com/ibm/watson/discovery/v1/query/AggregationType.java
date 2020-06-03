/*
 * (C) Copyright IBM Corp. 2017, 2020.
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
 * @deprecated This class has been replaced by the top-level version in
 *     com.ibm.watson.discovery.query.
 */
public enum AggregationType {

  /** The term. */
  TERM("term"),

  /** The filter. */
  FILTER("filter"),

  /** The nested. */
  NESTED("nested"),

  /** The histogram. */
  HISTOGRAM("histogram"),

  /** The timeslice. */
  TIMESLICE("timeslice"),

  /** The top hits. */
  TOP_HITS("top_hits"),

  /** The unique count. */
  UNIQUE_COUNT("unique_count"),

  /** The max. */
  MAX("max"),

  /** The min. */
  MIN("min"),

  /** The average. */
  AVERAGE("average"),

  /** The sum. */
  SUM("sum");

  private final String name;

  /**
   * Instantiates a new aggregation type.
   *
   * @param name the name
   */
  AggregationType(String name) {
    this.name = name;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Value of ignore case.
   *
   * @param value the value
   * @return the aggregation type
   * @throws IllegalArgumentException the illegal argument exception
   */
  public static AggregationType valueOfIgnoreCase(String value) throws IllegalArgumentException {
    for (AggregationType aggregationType : values()) {
      if (aggregationType.getName().equalsIgnoreCase(value)) {
        return aggregationType;
      }
    }
    throw new IllegalArgumentException(value + " is not a valid Aggregation");
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return name;
  }
}

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
package com.ibm.watson.discovery.v2.model;

/**
 * Returns a scalar calculation across all documents for the field specified. Possible calculations include min, max,
 * sum, average, and unique_count.
 */
public class QueryCalculationAggregation extends QueryAggregation {

  protected String field;
  protected Double value;

  /**
   * Gets the field.
   *
   * The field to perform the calculation on.
   *
   * @return the field
   */
  public String getField() {
    return field;
  }

  /**
   * Gets the value.
   *
   * The value of the calculation.
   *
   * @return the value
   */
  public Double getValue() {
    return value;
  }
}

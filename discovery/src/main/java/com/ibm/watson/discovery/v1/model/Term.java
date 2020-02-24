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

/**
 * Term.
 */
public class Term extends QueryAggregation {

  protected String field;
  protected Long count;

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
   * Gets the count.
   *
   * The number of terms identified.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }
}

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
package com.ibm.watson.discovery.v2.model;

import java.util.List;

/** Returns the top values for the field specified. */
public class QueryTermAggregation extends QueryAggregation {

  protected String field;
  protected Long count;
  protected String name;
  protected List<QueryTermAggregationResult> results;

  /**
   * Gets the field.
   *
   * <p>The field in the document used to generate top values from.
   *
   * @return the field
   */
  public String getField() {
    return field;
  }

  /**
   * Gets the count.
   *
   * <p>The number of top values returned.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }

  /**
   * Gets the name.
   *
   * <p>Identifier specified in the query request of this aggregation.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the results.
   *
   * <p>Array of top values for the field.
   *
   * @return the results
   */
  public List<QueryTermAggregationResult> getResults() {
    return results;
  }
}

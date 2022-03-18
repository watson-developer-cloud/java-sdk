/*
 * (C) Copyright IBM Corp. 2022.
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

/** Returns the top documents ranked by the score of the query. */
public class QueryTopHitsAggregation extends QueryAggregation {

  protected Long size;
  protected String name;
  protected QueryTopHitsAggregationResult hits;

  /**
   * Gets the size.
   *
   * <p>The number of documents to return.
   *
   * @return the size
   */
  public Long getSize() {
    return size;
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
   * Gets the hits.
   *
   * @return the hits
   */
  public QueryTopHitsAggregationResult getHits() {
    return hits;
  }
}

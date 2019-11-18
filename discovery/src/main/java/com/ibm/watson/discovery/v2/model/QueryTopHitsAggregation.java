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

/**
 * Returns the top documents ranked by the score of the query.
 */
public class QueryTopHitsAggregation extends QueryAggregation {

  private Long size;
  private QueryTopHitsAggregationResult hits;

  /**
   * Gets the size.
   *
   * The number of documents to return.
   *
   * @return the size
   */
  public Long getSize() {
    return size;
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

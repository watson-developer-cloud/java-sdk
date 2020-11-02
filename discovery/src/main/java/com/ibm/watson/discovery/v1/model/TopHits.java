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

/** TopHits. */
public class TopHits extends QueryAggregation {

  protected Long size;
  protected TopHitsResults hits;

  /**
   * Gets the size.
   *
   * <p>Number of top hits returned by the aggregation.
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
  public TopHitsResults getHits() {
    return hits;
  }
}

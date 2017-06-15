/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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

import java.util.HashMap;
import java.util.List;

/**
 * An aggregation produced by the Discovery service to analyze the input provided.
 */
public class QueryAggregation extends HashMap<String, Object> {

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return (String) this.get("type");
  }

  /**
   * Gets the matchingResults.
   *
   * @return the matchingResults
   */
  public Long getMatchingResults() {
    return (Long) this.get("matchingResults");
  }

  /**
   * Gets the results.
   *
   * @return the results
   */
  public List<Object> getResults() {
    return (List<Object>) this.get("results");
  }

  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(final String type) {
    this.put("type", type);
  }

  /**
   * Sets the matchingResults.
   *
   * @param matchingResults the new matchingResults
   */
  public void setMatchingResults(final Long matchingResults) {
    this.put("matchingResults", matchingResults);
  }

  /**
   * Sets the results.
   *
   * @param results the new results
   */
  public void setResults(final List<Object> results) {
    this.put("results", results);
  }
}

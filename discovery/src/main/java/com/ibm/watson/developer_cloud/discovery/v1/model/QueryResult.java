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
import java.util.Map;

/**
 * QueryResult.
 */
public class QueryResult extends HashMap<String, Object> {

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return (String) this.get("id");
  }

  /**
   * Gets the score.
   *
   * @return the score
   */
  public Double getScore() {
    return (Double) this.get("score");
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public Map<String, Object> getMetadata() {
    return (Map<String, Object>) this.get("metadata");
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(final String id) {
    this.put("id", id);
  }

  /**
   * Sets the score.
   *
   * @param score the new score
   */
  public void setScore(final Double score) {
    this.put("score", score);
  }

  /**
   * Sets the metadata.
   *
   * @param metadata the new metadata
   */
  public void setMetadata(final Map<String, Object> metadata) {
    this.put("metadata", metadata);
  }
}


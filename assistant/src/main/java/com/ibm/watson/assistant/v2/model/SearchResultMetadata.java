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
package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An object containing search result metadata from the Discovery service.
 */
public class SearchResultMetadata extends GenericModel {

  protected Double confidence;
  protected Double score;

  /**
   * Gets the confidence.
   *
   * The confidence score for the given result. For more information about how the confidence is calculated, see the
   * Discovery service [documentation](../discovery#query-your-collection).
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Gets the score.
   *
   * An unbounded measure of the relevance of a particular result, dependent on the query and matching document. A
   * higher score indicates a greater match to the query parameters.
   *
   * @return the score
   */
  public Double getScore() {
    return score;
  }
}

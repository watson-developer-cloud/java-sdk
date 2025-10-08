/*
 * (C) Copyright IBM Corp. 2025.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** TurnEventGenerativeAICalledMetrics. */
public class TurnEventGenerativeAICalledMetrics extends GenericModel {

  @SerializedName("search_time_ms")
  protected Double searchTimeMs;

  @SerializedName("answer_generation_time_ms")
  protected Double answerGenerationTimeMs;

  @SerializedName("total_time_ms")
  protected Double totalTimeMs;

  protected TurnEventGenerativeAICalledMetrics() {}

  /**
   * Gets the searchTimeMs.
   *
   * <p>The amount of time (in milliseconds) it took for the system to complete the search using the
   * document search engine.
   *
   * @return the searchTimeMs
   */
  public Double getSearchTimeMs() {
    return searchTimeMs;
  }

  /**
   * Gets the answerGenerationTimeMs.
   *
   * <p>The amount of time (in milliseconds) it took for the system to complete answer generation
   * process by reaching out to watsonx.ai.
   *
   * @return the answerGenerationTimeMs
   */
  public Double getAnswerGenerationTimeMs() {
    return answerGenerationTimeMs;
  }

  /**
   * Gets the totalTimeMs.
   *
   * <p>The amount of time (in milliseconds) it took for the system to fully process the
   * conversational search.
   *
   * @return the totalTimeMs
   */
  public Double getTotalTimeMs() {
    return totalTimeMs;
  }
}

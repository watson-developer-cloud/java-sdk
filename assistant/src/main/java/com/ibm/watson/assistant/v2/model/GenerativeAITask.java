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

/**
 * GenerativeAITask.
 *
 * <p>Classes which extend this class: - GenerativeAITaskContentGroundedAnswering -
 * GenerativeAITaskGeneralPurposeAnswering
 */
public class GenerativeAITask extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "task";

  protected static java.util.Map<String, Class<?>> discriminatorMapping;

  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put(
        "content_grounded_answering", GenerativeAITaskContentGroundedAnswering.class);
    discriminatorMapping.put(
        "general_purpose_answering", GenerativeAITaskGeneralPurposeAnswering.class);
  }

  protected String task;

  @SerializedName("is_idk_response")
  protected Boolean isIdkResponse;

  @SerializedName("is_hap_detected")
  protected Boolean isHapDetected;

  @SerializedName("confidence_scores")
  protected GenerativeAITaskConfidenceScores confidenceScores;

  @SerializedName("original_response")
  protected String originalResponse;

  @SerializedName("inferred_query")
  protected String inferredQuery;

  protected GenerativeAITask() {}

  /**
   * Gets the task.
   *
   * <p>The type of generative ai task.
   *
   * @return the task
   */
  public String getTask() {
    return task;
  }

  /**
   * Gets the isIdkResponse.
   *
   * <p>Whether response was an idk response.
   *
   * @return the isIdkResponse
   */
  public Boolean isIsIdkResponse() {
    return isIdkResponse;
  }

  /**
   * Gets the isHapDetected.
   *
   * <p>Whether response was a hap response.
   *
   * @return the isHapDetected
   */
  public Boolean isIsHapDetected() {
    return isHapDetected;
  }

  /**
   * Gets the confidenceScores.
   *
   * <p>The confidence scores for determining whether to show the generated response or an “I don't
   * know” response.
   *
   * @return the confidenceScores
   */
  public GenerativeAITaskConfidenceScores getConfidenceScores() {
    return confidenceScores;
  }

  /**
   * Gets the originalResponse.
   *
   * <p>The original response returned by the generative ai.
   *
   * @return the originalResponse
   */
  public String getOriginalResponse() {
    return originalResponse;
  }

  /**
   * Gets the inferredQuery.
   *
   * <p>Generated from the input text after auto-correction. If this field is not present, the input
   * text was used as the query to the generative ai.
   *
   * @return the inferredQuery
   */
  public String getInferredQuery() {
    return inferredQuery;
  }
}

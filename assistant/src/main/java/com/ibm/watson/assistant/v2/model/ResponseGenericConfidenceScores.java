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
 * The confidence scores for determining whether to show the generated response or an “I don't know”
 * response.
 */
public class ResponseGenericConfidenceScores extends GenericModel {

  protected Double threshold;

  @SerializedName("pre_gen")
  protected Double preGen;

  @SerializedName("post_gen")
  protected Double postGen;

  protected Double extractiveness;

  protected ResponseGenericConfidenceScores() {}

  /**
   * Gets the threshold.
   *
   * <p>The confidence score threshold. If either the pre_gen or post_gen score is below this
   * threshold, an “I don't know” response will be shown to replace the generated text. It can be
   * configured either in the user interface or through the Update skill API. For more information,
   * see the [watsonx Assistant documentation](
   * https://cloud.ibm.com/docs/watson-assistant?topic=watson-assistant-conversational-search#behavioral-tuning-conversational-search).
   *
   * @return the threshold
   */
  public Double getThreshold() {
    return threshold;
  }

  /**
   * Gets the preGen.
   *
   * <p>The confidence score based on user query and search results.
   *
   * @return the preGen
   */
  public Double getPreGen() {
    return preGen;
  }

  /**
   * Gets the postGen.
   *
   * <p>The confidence score based on user query, search results, and the generated response.
   *
   * @return the postGen
   */
  public Double getPostGen() {
    return postGen;
  }

  /**
   * Gets the extractiveness.
   *
   * <p>It indicates how extractive the generated response is from the search results.
   *
   * @return the extractiveness
   */
  public Double getExtractiveness() {
    return extractiveness;
  }
}

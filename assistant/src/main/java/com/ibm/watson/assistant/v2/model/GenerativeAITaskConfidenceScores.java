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
public class GenerativeAITaskConfidenceScores extends GenericModel {

  @SerializedName("pre_gen")
  protected Double preGen;

  @SerializedName("pre_gen_threshold")
  protected Double preGenThreshold;

  @SerializedName("post_gen")
  protected Double postGen;

  @SerializedName("post_gen_threshold")
  protected Double postGenThreshold;

  protected GenerativeAITaskConfidenceScores() {}

  /**
   * Gets the preGen.
   *
   * @return the preGen
   */
  public Double getPreGen() {
    return preGen;
  }

  /**
   * Gets the preGenThreshold.
   *
   * @return the preGenThreshold
   */
  public Double getPreGenThreshold() {
    return preGenThreshold;
  }

  /**
   * Gets the postGen.
   *
   * @return the postGen
   */
  public Double getPostGen() {
    return postGen;
  }

  /**
   * Gets the postGenThreshold.
   *
   * @return the postGenThreshold
   */
  public Double getPostGenThreshold() {
    return postGenThreshold;
  }
}

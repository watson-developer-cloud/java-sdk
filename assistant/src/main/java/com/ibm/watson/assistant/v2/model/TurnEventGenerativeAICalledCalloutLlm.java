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
import java.util.List;

/** TurnEventGenerativeAICalledCalloutLlm. */
public class TurnEventGenerativeAICalledCalloutLlm extends GenericModel {

  protected String type;

  @SerializedName("model_id")
  protected String modelId;

  @SerializedName("model_class_id")
  protected String modelClassId;

  @SerializedName("generated_token_count")
  protected Long generatedTokenCount;

  @SerializedName("input_token_count")
  protected Long inputTokenCount;

  protected Boolean success;
  protected TurnEventGenerativeAICalledCalloutLlmResponse response;
  protected List<SearchResults> request;

  protected TurnEventGenerativeAICalledCalloutLlm() {}

  /**
   * Gets the type.
   *
   * <p>The name of the LLM engine called by the system.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the modelId.
   *
   * <p>The LLM model used to generate the response.
   *
   * @return the modelId
   */
  public String getModelId() {
    return modelId;
  }

  /**
   * Gets the modelClassId.
   *
   * <p>The watsonx.ai class ID that was used during the answer generation request to the LLM. This
   * is only included when a request to the LLM has been made by the system.
   *
   * @return the modelClassId
   */
  public String getModelClassId() {
    return modelClassId;
  }

  /**
   * Gets the generatedTokenCount.
   *
   * <p>The number of tokens that were generated in the response by the LLM. This is only included
   * when a request to the LLM was successful and a response was generated.
   *
   * @return the generatedTokenCount
   */
  public Long getGeneratedTokenCount() {
    return generatedTokenCount;
  }

  /**
   * Gets the inputTokenCount.
   *
   * <p>The number of tokens that were sent to the LLM during answer generation. This is only
   * included when a request to the LLM has been made by the system.
   *
   * @return the inputTokenCount
   */
  public Long getInputTokenCount() {
    return inputTokenCount;
  }

  /**
   * Gets the success.
   *
   * <p>Whether the answer generation request to the LLM was successful.
   *
   * @return the success
   */
  public Boolean isSuccess() {
    return success;
  }

  /**
   * Gets the response.
   *
   * @return the response
   */
  public TurnEventGenerativeAICalledCalloutLlmResponse getResponse() {
    return response;
  }

  /**
   * Gets the request.
   *
   * <p>n array of objects containing the search results.
   *
   * @return the request
   */
  public List<SearchResults> getRequest() {
    return request;
  }
}

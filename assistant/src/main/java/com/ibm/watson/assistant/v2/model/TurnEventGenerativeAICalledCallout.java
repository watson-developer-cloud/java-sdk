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

/** TurnEventGenerativeAICalledCallout. */
public class TurnEventGenerativeAICalledCallout extends GenericModel {

  @SerializedName("search_called")
  protected Boolean searchCalled;

  @SerializedName("llm_called")
  protected Boolean llmCalled;

  protected TurnEventGenerativeAICalledCalloutSearch search;
  protected TurnEventGenerativeAICalledCalloutLlm llm;

  @SerializedName("idk_reason_code")
  protected String idkReasonCode;

  protected TurnEventGenerativeAICalledCallout() {}

  /**
   * Gets the searchCalled.
   *
   * <p>Whether the document search engine was called.
   *
   * @return the searchCalled
   */
  public Boolean isSearchCalled() {
    return searchCalled;
  }

  /**
   * Gets the llmCalled.
   *
   * <p>Whether watsonx.ai was called during answer generation.
   *
   * @return the llmCalled
   */
  public Boolean isLlmCalled() {
    return llmCalled;
  }

  /**
   * Gets the search.
   *
   * @return the search
   */
  public TurnEventGenerativeAICalledCalloutSearch getSearch() {
    return search;
  }

  /**
   * Gets the llm.
   *
   * @return the llm
   */
  public TurnEventGenerativeAICalledCalloutLlm getLlm() {
    return llm;
  }

  /**
   * Gets the idkReasonCode.
   *
   * <p>Indicates why a conversational search response resolved to an idk response. This field will
   * only be available when the conversational search response is an idk response.
   *
   * @return the idkReasonCode
   */
  public String getIdkReasonCode() {
    return idkReasonCode;
  }
}

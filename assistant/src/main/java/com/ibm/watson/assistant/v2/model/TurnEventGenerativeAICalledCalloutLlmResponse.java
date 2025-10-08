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

/** */
public class TurnEventGenerativeAICalledCalloutLlmResponse extends GenericModel {

  protected String text;

  @SerializedName("response_type")
  protected String responseType;

  @SerializedName("is_idk_response")
  protected Boolean isIdkResponse;

  protected TurnEventGenerativeAICalledCalloutLlmResponse() {}

  /**
   * Gets the text.
   *
   * <p>The LLM response that is returned.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the responseType.
   *
   * <p>The type of response that is returned.
   *
   * @return the responseType
   */
  public String getResponseType() {
    return responseType;
  }

  /**
   * Gets the isIdkResponse.
   *
   * <p>Whether the response is an idk response.
   *
   * @return the isIdkResponse
   */
  public Boolean isIsIdkResponse() {
    return isIdkResponse;
  }
}

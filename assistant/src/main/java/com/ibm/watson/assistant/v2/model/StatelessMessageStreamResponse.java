/*
 * (C) Copyright IBM Corp. 2024.
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
 * A stateless streamed response form the watsonx Assistant service.
 *
 * <p>Classes which extend this class: - StatelessMessageStreamResponseMessageStreamPartialItem -
 * StatelessMessageStreamResponseMessageStreamCompleteItem -
 * StatelessMessageStreamResponseStatelessMessageStreamFinalResponse
 */
public class StatelessMessageStreamResponse extends GenericModel {

  @SerializedName("partial_item")
  protected PartialItem partialItem;

  @SerializedName("complete_item")
  protected CompleteItem completeItem;

  @SerializedName("final_response")
  protected StatelessFinalResponse finalResponse;

  protected StatelessMessageStreamResponse() {}

  /**
   * Gets the partialItem.
   *
   * <p>Message response partial item content.
   *
   * @return the partialItem
   */
  public PartialItem getPartialItem() {
    return partialItem;
  }

  /**
   * Gets the completeItem.
   *
   * @return the completeItem
   */
  public CompleteItem getCompleteItem() {
    return completeItem;
  }

  /**
   * Gets the finalResponse.
   *
   * <p>Message final response content.
   *
   * @return the finalResponse
   */
  public StatelessFinalResponse getFinalResponse() {
    return finalResponse;
  }
}

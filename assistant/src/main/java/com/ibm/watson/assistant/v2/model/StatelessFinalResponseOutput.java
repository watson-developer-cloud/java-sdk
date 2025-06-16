/*
 * (C) Copyright IBM Corp. 2024, 2025.
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
import java.util.Map;

/** Assistant output to be rendered or processed by the client. */
public class StatelessFinalResponseOutput extends GenericModel {

  protected List<RuntimeResponseGeneric> generic;
  protected List<RuntimeIntent> intents;
  protected List<RuntimeEntity> entities;
  protected List<DialogNodeAction> actions;
  protected MessageOutputDebug debug;

  @SerializedName("user_defined")
  protected Map<String, Object> userDefined;

  protected MessageOutputSpelling spelling;

  @SerializedName("llm_metadata")
  protected List<MessageOutputLLMMetadata> llmMetadata;

  @SerializedName("streaming_metadata")
  protected StatelessMessageContext streamingMetadata;

  protected StatelessFinalResponseOutput() {}

  /**
   * Gets the generic.
   *
   * <p>Output intended for any channel. It is the responsibility of the client application to
   * implement the supported response types.
   *
   * @return the generic
   */
  public List<RuntimeResponseGeneric> getGeneric() {
    return generic;
  }

  /**
   * Gets the intents.
   *
   * <p>An array of intents recognized in the user input, sorted in descending order of confidence.
   *
   * @return the intents
   */
  public List<RuntimeIntent> getIntents() {
    return intents;
  }

  /**
   * Gets the entities.
   *
   * <p>An array of entities identified in the user input.
   *
   * @return the entities
   */
  public List<RuntimeEntity> getEntities() {
    return entities;
  }

  /**
   * Gets the actions.
   *
   * <p>An array of objects describing any actions requested by the dialog node.
   *
   * @return the actions
   */
  public List<DialogNodeAction> getActions() {
    return actions;
  }

  /**
   * Gets the debug.
   *
   * <p>Additional detailed information about a message response and how it was generated.
   *
   * @return the debug
   */
  public MessageOutputDebug getDebug() {
    return debug;
  }

  /**
   * Gets the userDefined.
   *
   * <p>An object containing any custom properties included in the response. This object includes
   * any arbitrary properties defined in the dialog JSON editor as part of the dialog node output.
   *
   * @return the userDefined
   */
  public Map<String, Object> getUserDefined() {
    return userDefined;
  }

  /**
   * Gets the spelling.
   *
   * <p>Properties describing any spelling corrections in the user input that was received.
   *
   * @return the spelling
   */
  public MessageOutputSpelling getSpelling() {
    return spelling;
  }

  /**
   * Gets the llmMetadata.
   *
   * <p>An array of objects that provide information about calls to large language models that
   * occured as part of handling this message.
   *
   * @return the llmMetadata
   */
  public List<MessageOutputLLMMetadata> getLlmMetadata() {
    return llmMetadata;
  }

  /**
   * Gets the streamingMetadata.
   *
   * @return the streamingMetadata
   */
  public StatelessMessageContext getStreamingMetadata() {
    return streamingMetadata;
  }
}

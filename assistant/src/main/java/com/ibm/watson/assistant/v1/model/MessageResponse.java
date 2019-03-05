/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.assistant.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The response sent by the workspace, including the output text, detected intents and entities, and context.
 */
public class MessageResponse extends GenericModel {

  private MessageInput input;
  private List<RuntimeIntent> intents;
  private List<RuntimeEntity> entities;
  @SerializedName("alternate_intents")
  private Boolean alternateIntents;
  private Context context;
  private OutputData output;
  private List<DialogNodeAction> actions;

  /**
   * Gets the input.
   *
   * The text of the user input.
   *
   * @return the input
   */
  public MessageInput getInput() {
    return input;
  }

  /**
   * Gets the intents.
   *
   * An array of intents recognized in the user input, sorted in descending order of confidence.
   *
   * @return the intents
   */
  public List<RuntimeIntent> getIntents() {
    return intents;
  }

  /**
   * Gets the entities.
   *
   * An array of entities identified in the user input.
   *
   * @return the entities
   */
  public List<RuntimeEntity> getEntities() {
    return entities;
  }

  /**
   * Gets the alternateIntents.
   *
   * Whether to return more than one intent. A value of `true` indicates that all matching intents are returned.
   *
   * @return the alternateIntents
   */
  public Boolean isAlternateIntents() {
    return alternateIntents;
  }

  /**
   * Gets the context.
   *
   * State information for the conversation. To maintain state, include the context from the previous response.
   *
   * @return the context
   */
  public Context getContext() {
    return context;
  }

  /**
   * Gets the output.
   *
   * An output object that includes the response to the user, the dialog nodes that were triggered, and messages from
   * the log.
   *
   * @return the output
   */
  public OutputData getOutput() {
    return output;
  }

  /**
   * Gets the actions.
   *
   * An array of objects describing any actions requested by the dialog node.
   *
   * @return the actions
   */
  public List<DialogNodeAction> getActions() {
    return actions;
  }
}

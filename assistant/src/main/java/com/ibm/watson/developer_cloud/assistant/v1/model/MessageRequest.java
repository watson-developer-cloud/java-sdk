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
package com.ibm.watson.developer_cloud.assistant.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * A message request formatted for the Watson Assistant service.
 */
public class MessageRequest extends GenericModel {

  private InputData input;
  @SerializedName("alternate_intents")
  private Boolean alternateIntents;
  private Context context;
  private List<RuntimeEntity> entities;
  private List<RuntimeIntent> intents;
  private OutputData output;

  /**
   * Gets the input.
   *
   * The user input.
   *
   * @return the input
   */
  public InputData getInput() {
    return input;
  }

  /**
   * Gets the alternateIntents.
   *
   * Whether to return more than one intent. Set to `true` to return all matching intents.
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
   * Gets the entities.
   *
   * Entities to use when evaluating the message. Include entities from the previous response to continue using those
   * entities rather than detecting entities in the new input.
   *
   * @return the entities
   */
  public List<RuntimeEntity> getEntities() {
    return entities;
  }

  /**
   * Gets the intents.
   *
   * Intents to use when evaluating the user input. Include intents from the previous response to continue using those
   * intents rather than trying to recognize intents in the new input.
   *
   * @return the intents
   */
  public List<RuntimeIntent> getIntents() {
    return intents;
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
   * Sets the input.
   *
   * @param input the new input
   */
  public void setInput(final InputData input) {
    this.input = input;
  }

  /**
   * Sets the alternateIntents.
   *
   * @param alternateIntents the new alternateIntents
   */
  public void setAlternateIntents(final Boolean alternateIntents) {
    this.alternateIntents = alternateIntents;
  }

  /**
   * Sets the context.
   *
   * @param context the new context
   */
  public void setContext(final Context context) {
    this.context = context;
  }

  /**
   * Sets the entities.
   *
   * @param entities the new entities
   */
  public void setEntities(final List<RuntimeEntity> entities) {
    this.entities = entities;
  }

  /**
   * Sets the intents.
   *
   * @param intents the new intents
   */
  public void setIntents(final List<RuntimeIntent> intents) {
    this.intents = intents;
  }

  /**
   * Sets the output.
   *
   * @param output the new output
   */
  public void setOutput(final OutputData output) {
    this.output = output;
  }
}

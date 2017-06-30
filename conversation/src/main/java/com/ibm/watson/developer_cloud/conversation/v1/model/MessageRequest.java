/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * A request formatted for the Conversation service.
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
   * An input object that includes the input text.
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
   * State information for the conversation. Continue a conversation by including the context object from the previous
   * response.
   *
   * @return the context
   */
  public Context getContext() {
    return context;
  }

  /**
   * Gets the entities.
   *
   * Include the entities from the previous response when they do not need to change and to prevent Watson from trying
   * to identify them.
   *
   * @return the entities
   */
  public List<RuntimeEntity> getEntities() {
    return entities;
  }

  /**
   * Gets the intents.
   *
   * An array of name-confidence pairs for the user input. Include the intents from the previous response when they do
   * not need to change and to prevent Watson from trying to identify them.
   *
   * @return the intents
   */
  public List<RuntimeIntent> getIntents() {
    return intents;
  }

  /**
   * Gets the output.
   *
   * System output. Include the output from the request when you have several requests within the same Dialog turn to
   * pass back in the intermediate information.
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

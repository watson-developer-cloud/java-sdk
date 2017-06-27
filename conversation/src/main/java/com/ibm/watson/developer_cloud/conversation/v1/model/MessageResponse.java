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
 * A response from the Conversation service.
 */
public class MessageResponse extends GenericModel {

  private MessageInput input;
  private List<RuntimeIntent> intents;
  private List<RuntimeEntity> entities;
  @SerializedName("alternate_intents")
  private Boolean alternateIntents;
  private Context context;
  private RuntimeOutput output;

  /**
   * Gets the input.
   *
   * The user input from the request.
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
   * Whether to return more than one intent. `true` indicates that all matching intents are returned.
   *
   * @return the alternateIntents
   */
  public Boolean isAlternateIntents() {
    return alternateIntents;
  }

  /**
   * Gets the context.
   *
   * State information for the conversation.
   *
   * @return the context
   */
  public Context getContext() {
    return context;
  }

  /**
   * Gets the output.
   *
   * Output from the dialog, including the response to the user, the nodes that were triggered, and log messages.
   *
   * @return the output
   */
  public RuntimeOutput getOutput() {
    return output;
  }

  /**
   * Sets the input.
   *
   * @param input the new input
   */
  public void setInput(final MessageInput input) {
    this.input = input;
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
   * Sets the entities.
   *
   * @param entities the new entities
   */
  public void setEntities(final List<RuntimeEntity> entities) {
    this.entities = entities;
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
   * Sets the output.
   *
   * @param output the new output
   */
  public void setOutput(final RuntimeOutput output) {
    this.output = output;
  }
}

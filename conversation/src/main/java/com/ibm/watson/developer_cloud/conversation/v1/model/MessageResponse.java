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

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.conversation.v1.model.util.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * A response from the Conversation service.
 */
public class MessageResponse extends DynamicModel {

  private Gson gsonSingleton = GsonSingleton.getGson();

  /**
   * Gets the input.
   *
   * The user input from the request.
   *
   * @return the input
   */
  public MessageInput getInput() {
    return (MessageInput) this.get("input");
  }

  /**
   * Gets the intents.
   *
   * An array of intents recognized in the user input, sorted in descending order of confidence.
   *
   * @return the intents
   */
  public List<RuntimeIntent> getIntents() {
    Type listType = new TypeToken<List<RuntimeIntent>>() { } .getType();
    return gsonSingleton.fromJson(gsonSingleton.toJsonTree(this.get("intents")), listType);
  }

  /**
   * Gets the entities.
   *
   * An array of entities identified in the user input.
   *
   * @return the entities
   */
  public List<RuntimeEntity> getEntities() {
    Type listType = new TypeToken<List<RuntimeEntity>>() { } .getType();
    return gsonSingleton.fromJson(gsonSingleton.toJsonTree(this.get("entities")), listType);
  }

  /**
   * Gets the alternateIntents.
   *
   * Whether to return more than one intent. `true` indicates that all matching intents are returned.
   *
   * @return the alternateIntents
   */
  public Boolean isAlternateIntents() {
    return (Boolean) this.get("alternate_intents");
  }

  /**
   * Gets the context.
   *
   * State information for the conversation.
   *
   * @return the context
   */
  public Context getContext() {
    return gsonSingleton.fromJson(gsonSingleton.toJsonTree(this.get("context")), Context.class);
  }

  /**
   * Gets the output.
   *
   * Output from the dialog, including the response to the user, the nodes that were triggered, and log messages.
   *
   * @return the output
   */
  public OutputData getOutput() {
    return gsonSingleton.fromJson(gsonSingleton.toJsonTree(this.get("output")), OutputData.class);
  }

  /**
   * Sets the input.
   *
   * @param input the new input
   */
  public void setInput(final MessageInput input) {
    this.put("input", input);
  }

  /**
   * Sets the intents.
   *
   * @param intents the new intents
   */
  public void setIntents(final List<RuntimeIntent> intents) {
    this.put("intents", intents);
  }

  /**
   * Sets the entities.
   *
   * @param entities the new entities
   */
  public void setEntities(final List<RuntimeEntity> entities) {
    this.put("entities", entities);
  }

  /**
   * Sets the alternateIntents.
   *
   * @param alternateIntents the new alternateIntents
   */
  public void setAlternateIntents(final Boolean alternateIntents) {
    this.put("alternate_intents", alternateIntents);
  }

  /**
   * Sets the context.
   *
   * @param context the new context
   */
  public void setContext(final Context context) {
    this.put("context", context);
  }

  /**
   * Sets the output.
   *
   * @param output the new output
   */
  public void setOutput(final OutputData output) {
    this.put("output", output);
  }
}

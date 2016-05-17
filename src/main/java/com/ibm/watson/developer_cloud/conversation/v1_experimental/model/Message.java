/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.watson.developer_cloud.conversation.v1_experimental.model;

import java.util.List;

import com.ibm.watson.developer_cloud.conversation.v1_experimental.ConversationService;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Message returned by the {@link ConversationService}
 */
public class Message extends GenericModel {

  private List<Intent> intents;
  private List<Entity> entities;
  private Output output;
  private Context context;

  /**
   * Gets the intents.
   *
   * @return The intents
   */
  public List<Intent> getIntents() {
    return intents;
  }

  /**
   * Sets the intents.
   *
   * @param intents The intents
   */
  public void setIntents(List<Intent> intents) {
    this.intents = intents;
  }

  /**
   * Gets the entities.
   *
   * @return The entities
   */
  public List<Entity> getEntities() {
    return entities;
  }

  /**
   * Sets the entities.
   *
   * @param entities The entities
   */
  public void setEntities(List<Entity> entities) {
    this.entities = entities;
  }

  /**
   * Gets the output.
   *
   * @return The output
   */
  public Output getOutput() {
    return output;
  }

  /**
   * Sets the output.
   *
   * @param output The output
   */
  public void setOutput(Output output) {
    this.output = output;
  }

  /**
   * Gets the context.
   *
   * @return The context
   */
  public Context getContext() {
    return context;
  }

  /**
   * Sets the context.
   *
   * @param context The context
   */
  public void setContext(Context context) {
    this.context = context;
  }

}

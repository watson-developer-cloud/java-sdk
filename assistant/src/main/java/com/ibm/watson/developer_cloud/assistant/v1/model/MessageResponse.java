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

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;

/**
 * The response sent by the workspace, including the output text, detected intents and entities, and context.
 */
public class MessageResponse extends DynamicModel {
  private Type inputType = new TypeToken<MessageInput>() {
  }.getType();
  private Type intentsType = new TypeToken<List<RuntimeIntent>>() {
  }.getType();
  private Type entitiesType = new TypeToken<List<RuntimeEntity>>() {
  }.getType();
  private Type alternateIntentsType = new TypeToken<Boolean>() {
  }.getType();
  private Type contextType = new TypeToken<Context>() {
  }.getType();
  private Type outputType = new TypeToken<OutputData>() {
  }.getType();
  private Type actionsType = new TypeToken<List<DialogNodeAction>>() {
  }.getType();

  /**
   * Gets the input.
   *
   * @return the input
   */
  public MessageInput getInput() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("input"), inputType);
  }

  /**
   * Gets the intents.
   *
   * @return the intents
   */
  public List<RuntimeIntent> getIntents() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("intents"), intentsType);
  }

  /**
   * Gets the entities.
   *
   * @return the entities
   */
  public List<RuntimeEntity> getEntities() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("entities"), entitiesType);
  }

  /**
   * Gets the alternateIntents.
   *
   * @return the alternateIntents
   */
  public Boolean isAlternateIntents() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("alternate_intents"), alternateIntentsType);
  }

  /**
   * Gets the context.
   *
   * @return the context
   */
  public Context getContext() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("context"), contextType);
  }

  /**
   * Gets the output.
   *
   * @return the output
   */
  public OutputData getOutput() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("output"), outputType);
  }

  /**
   * Gets the actions.
   *
   * @return the actions
   */
  public List<DialogNodeAction> getActions() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("actions"), actionsType);
  }
}

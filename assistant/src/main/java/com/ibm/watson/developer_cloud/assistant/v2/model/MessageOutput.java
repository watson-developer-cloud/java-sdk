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
package com.ibm.watson.developer_cloud.assistant.v2.model;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Assistant output to be rendered or processed by the client.
 */
public class MessageOutput extends DynamicModel {

  private Type genericType = new TypeToken<List<DialogRuntimeResponseGeneric>>() {
  }.getType();
  private Type intentsType = new TypeToken<List<RuntimeIntent>>() {
  }.getType();
  private Type entitiesType = new TypeToken<List<RuntimeEntity>>() {
  }.getType();
  private Type actionsType = new TypeToken<List<DialogNodeAction>>() {
  }.getType();
  private Type debugType = new TypeToken<MessageOutputDebug>() {
  }.getType();

  /**
   * Gets the generic.
   *
   * Output intended for any channel. It is the responsibility of the client application to implement the supported
   * response types.
   *
   * @return the generic
   */
  public List<DialogRuntimeResponseGeneric> getGeneric() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("generic"), genericType);
  }

  /**
   * Gets the intents.
   *
   * An array of intents recognized in the user input, sorted in descending order of confidence.
   *
   * @return the intents
   */
  public List<RuntimeIntent> getIntents() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("intents"), intentsType);
  }

  /**
   * Gets the entities.
   *
   * An array of entities identified in the user input.
   *
   * @return the entities
   */
  public List<RuntimeEntity> getEntities() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("entities"), entitiesType);
  }

  /**
   * Gets the actions.
   *
   * An array of objects describing any actions requested by the dialog node.
   *
   * @return the actions
   */
  public List<DialogNodeAction> getActions() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("actions"), actionsType);
  }

  /**
   * Gets the debug.
   *
   * Additional detailed information about a message response and how it was generated.
   *
   * @return the debug
   */
  public MessageOutputDebug getDebug() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("debug"), debugType);
  }
}

/*
 * (C) Copyright IBM Corp. 2020.
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

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Assistant output to be rendered or processed by the client.
 */
public class MessageOutput extends GenericModel {

  protected List<RuntimeResponseGeneric> generic;
  protected List<RuntimeIntent> intents;
  protected List<RuntimeEntity> entities;
  protected List<DialogNodeAction> actions;
  protected MessageOutputDebug debug;
  @SerializedName("user_defined")
  protected Map<String, Object> userDefined;

  /**
   * Gets the generic.
   *
   * Output intended for any channel. It is the responsibility of the client application to implement the supported
   * response types.
   *
   * @return the generic
   */
  public List<RuntimeResponseGeneric> getGeneric() {
    return generic;
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
   * Gets the actions.
   *
   * An array of objects describing any actions requested by the dialog node.
   *
   * @return the actions
   */
  public List<DialogNodeAction> getActions() {
    return actions;
  }

  /**
   * Gets the debug.
   *
   * Additional detailed information about a message response and how it was generated.
   *
   * @return the debug
   */
  public MessageOutputDebug getDebug() {
    return debug;
  }

  /**
   * Gets the userDefined.
   *
   * An object containing any custom properties included in the response. This object includes any arbitrary properties
   * defined in the dialog JSON editor as part of the dialog node output.
   *
   * @return the userDefined
   */
  public Map<String, Object> getUserDefined() {
    return userDefined;
  }
}


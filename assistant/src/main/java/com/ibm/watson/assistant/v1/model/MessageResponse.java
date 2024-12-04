/*
 * (C) Copyright IBM Corp. 2024.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/**
 * The response sent by the workspace, including the output text, detected intents and entities, and
 * context.
 */
public class MessageResponse extends GenericModel {

  protected MessageInput input;
  protected List<RuntimeIntent> intents;
  protected List<RuntimeEntity> entities;

  @SerializedName("alternate_intents")
  protected Boolean alternateIntents;

  protected Context context;
  protected OutputData output;
  protected List<DialogNodeAction> actions;

  @SerializedName("user_id")
  protected String userId;

  protected MessageResponse() {}

  /**
   * Gets the input.
   *
   * <p>An input object that includes the input text.
   *
   * @return the input
   */
  public MessageInput getInput() {
    return input;
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
   * Gets the alternateIntents.
   *
   * <p>Whether to return more than one intent. A value of `true` indicates that all matching
   * intents are returned.
   *
   * @return the alternateIntents
   */
  public Boolean isAlternateIntents() {
    return alternateIntents;
  }

  /**
   * Gets the context.
   *
   * <p>State information for the conversation. To maintain state, include the context from the
   * previous response.
   *
   * @return the context
   */
  public Context getContext() {
    return context;
  }

  /**
   * Gets the output.
   *
   * <p>An output object that includes the response to the user, the dialog nodes that were
   * triggered, and messages from the log.
   *
   * @return the output
   */
  public OutputData getOutput() {
    return output;
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
   * Gets the userId.
   *
   * <p>A string value that identifies the user who is interacting with the workspace. The client
   * must provide a unique identifier for each individual end user who accesses the application. For
   * user-based plans, this user ID is used to identify unique users for billing purposes. This
   * string cannot contain carriage return, newline, or tab characters. If no value is specified in
   * the input, **user_id** is automatically set to the value of **context.conversation_id**.
   *
   * <p>**Note:** This property is the same as the **user_id** property in the context metadata. If
   * **user_id** is specified in both locations in a message request, the value specified at the
   * root is used.
   *
   * @return the userId
   */
  public String getUserId() {
    return userId;
  }
}

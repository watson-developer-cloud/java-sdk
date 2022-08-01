/*
 * (C) Copyright IBM Corp. 2022.
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
import java.util.ArrayList;
import java.util.List;

/** A request sent to the workspace, including the user input and context. */
public class MessageRequest extends GenericModel {

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

  /** Builder. */
  public static class Builder {
    private MessageInput input;
    private List<RuntimeIntent> intents;
    private List<RuntimeEntity> entities;
    private Boolean alternateIntents;
    private Context context;
    private OutputData output;
    private String userId;

    private Builder(MessageRequest messageRequest) {
      this.input = messageRequest.input;
      this.intents = messageRequest.intents;
      this.entities = messageRequest.entities;
      this.alternateIntents = messageRequest.alternateIntents;
      this.context = messageRequest.context;
      this.output = messageRequest.output;
      this.userId = messageRequest.userId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a MessageRequest.
     *
     * @return the new MessageRequest instance
     */
    public MessageRequest build() {
      return new MessageRequest(this);
    }

    /**
     * Adds an intent to intents.
     *
     * @param intent the new intent
     * @return the MessageRequest builder
     */
    public Builder addIntent(RuntimeIntent intent) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(intent, "intent cannot be null");
      if (this.intents == null) {
        this.intents = new ArrayList<RuntimeIntent>();
      }
      this.intents.add(intent);
      return this;
    }

    /**
     * Adds an entity to entities.
     *
     * @param entity the new entity
     * @return the MessageRequest builder
     */
    public Builder addEntity(RuntimeEntity entity) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(entity, "entity cannot be null");
      if (this.entities == null) {
        this.entities = new ArrayList<RuntimeEntity>();
      }
      this.entities.add(entity);
      return this;
    }

    /**
     * Set the input.
     *
     * @param input the input
     * @return the MessageRequest builder
     */
    public Builder input(MessageInput input) {
      this.input = input;
      return this;
    }

    /**
     * Set the intents. Existing intents will be replaced.
     *
     * @param intents the intents
     * @return the MessageRequest builder
     */
    public Builder intents(List<RuntimeIntent> intents) {
      this.intents = intents;
      return this;
    }

    /**
     * Set the entities. Existing entities will be replaced.
     *
     * @param entities the entities
     * @return the MessageRequest builder
     */
    public Builder entities(List<RuntimeEntity> entities) {
      this.entities = entities;
      return this;
    }

    /**
     * Set the alternateIntents.
     *
     * @param alternateIntents the alternateIntents
     * @return the MessageRequest builder
     */
    public Builder alternateIntents(Boolean alternateIntents) {
      this.alternateIntents = alternateIntents;
      return this;
    }

    /**
     * Set the context.
     *
     * @param context the context
     * @return the MessageRequest builder
     */
    public Builder context(Context context) {
      this.context = context;
      return this;
    }

    /**
     * Set the output.
     *
     * @param output the output
     * @return the MessageRequest builder
     */
    public Builder output(OutputData output) {
      this.output = output;
      return this;
    }

    /**
     * Set the userId.
     *
     * @param userId the userId
     * @return the MessageRequest builder
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }
  }

  protected MessageRequest() {}

  protected MessageRequest(Builder builder) {
    input = builder.input;
    intents = builder.intents;
    entities = builder.entities;
    alternateIntents = builder.alternateIntents;
    context = builder.context;
    output = builder.output;
    userId = builder.userId;
  }

  /**
   * New builder.
   *
   * @return a MessageRequest builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the input.
   *
   * <p>An input object that includes the input text.
   *
   * @return the input
   */
  public MessageInput input() {
    return input;
  }

  /**
   * Gets the intents.
   *
   * <p>Intents to use when evaluating the user input. Include intents from the previous response to
   * continue using those intents rather than trying to recognize intents in the new input.
   *
   * @return the intents
   */
  public List<RuntimeIntent> intents() {
    return intents;
  }

  /**
   * Gets the entities.
   *
   * <p>Entities to use when evaluating the message. Include entities from the previous response to
   * continue using those entities rather than detecting entities in the new input.
   *
   * @return the entities
   */
  public List<RuntimeEntity> entities() {
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
  public Boolean alternateIntents() {
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
  public Context context() {
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
  public OutputData output() {
    return output;
  }

  /**
   * Gets the actions.
   *
   * <p>An array of objects describing any actions requested by the dialog node.
   *
   * @return the actions
   */
  public List<DialogNodeAction> actions() {
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
  public String userId() {
    return userId;
  }
}

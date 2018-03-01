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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;
import java.util.ArrayList;

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
   * Builder.
   */
  public static class Builder {
    private InputData input;
    private Boolean alternateIntents;
    private Context context;
    private List<RuntimeEntity> entities;
    private List<RuntimeIntent> intents;
    private OutputData output;

    private Builder(MessageRequest messageRequest) {
      input = messageRequest.input;
      alternateIntents = messageRequest.alternateIntents;
      context = messageRequest.context;
      entities = messageRequest.entities;
      intents = messageRequest.intents;
      output = messageRequest.output;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a MessageRequest.
     *
     * @return the messageRequest
     */
    public MessageRequest build() {
      return new MessageRequest(this);
    }

    /**
     * Adds an entity to entities.
     *
     * @param entity the new entity
     * @return the MessageRequest builder
     */
    public Builder addEntity(RuntimeEntity entity) {
      Validator.notNull(entity, "entity cannot be null");
      if (this.entities == null) {
        this.entities = new ArrayList<RuntimeEntity>();
      }
      this.entities.add(entity);
      return this;
    }

    /**
     * Adds an intent to intents.
     *
     * @param intent the new intent
     * @return the MessageRequest builder
     */
    public Builder addIntent(RuntimeIntent intent) {
      Validator.notNull(intent, "intent cannot be null");
      if (this.intents == null) {
        this.intents = new ArrayList<RuntimeIntent>();
      }
      this.intents.add(intent);
      return this;
    }

    /**
     * Set the input.
     *
     * @param input the input
     * @return the MessageRequest builder
     */
    public Builder input(InputData input) {
      this.input = input;
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
     * Set the entities.
     * Existing entities will be replaced.
     *
     * @param entities the entities
     * @return the MessageRequest builder
     */
    public Builder entities(List<RuntimeEntity> entities) {
      this.entities = entities;
      return this;
    }

    /**
     * Set the intents.
     * Existing intents will be replaced.
     *
     * @param intents the intents
     * @return the MessageRequest builder
     */
    public Builder intents(List<RuntimeIntent> intents) {
      this.intents = intents;
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
  }

  private MessageRequest(Builder builder) {
    input = builder.input;
    alternateIntents = builder.alternateIntents;
    context = builder.context;
    entities = builder.entities;
    intents = builder.intents;
    output = builder.output;
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
   * An input object that includes the input text.
   *
   * @return the input
   */
  public InputData input() {
    return input;
  }

  /**
   * Gets the alternateIntents.
   *
   * Whether to return more than one intent. Set to `true` to return all matching intents.
   *
   * @return the alternateIntents
   */
  public Boolean alternateIntents() {
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
  public Context context() {
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
  public List<RuntimeEntity> entities() {
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
  public List<RuntimeIntent> intents() {
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
  public OutputData output() {
    return output;
  }
}

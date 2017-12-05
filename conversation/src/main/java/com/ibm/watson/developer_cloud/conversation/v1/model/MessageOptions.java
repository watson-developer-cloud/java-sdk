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

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The message options.
 */
public class MessageOptions extends GenericModel {

  private String workspaceId;
  private InputData input;
  private Boolean alternateIntents;
  private Context context;
  private List<RuntimeEntity> entities;
  private List<RuntimeIntent> intents;
  private OutputData output;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private InputData input;
    private Boolean alternateIntents;
    private Context context;
    private List<RuntimeEntity> entities;
    private List<RuntimeIntent> intents;
    private OutputData output;

    private Builder(MessageOptions messageOptions) {
      workspaceId = messageOptions.workspaceId;
      input = messageOptions.input;
      alternateIntents = messageOptions.alternateIntents;
      context = messageOptions.context;
      entities = messageOptions.entities;
      intents = messageOptions.intents;
      output = messageOptions.output;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     */
    public Builder(String workspaceId) {
      this.workspaceId = workspaceId;
    }

    /**
     * Builds a MessageOptions.
     *
     * @return the messageOptions
     */
    public MessageOptions build() {
      return new MessageOptions(this);
    }

    /**
     * Adds an entity to entities.
     *
     * @param entity the new entity
     * @return the MessageOptions builder
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
     * @return the MessageOptions builder
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
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the MessageOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the input.
     *
     * @param input the input
     * @return the MessageOptions builder
     */
    public Builder input(InputData input) {
      this.input = input;
      return this;
    }

    /**
     * Set the alternateIntents.
     *
     * @param alternateIntents the alternateIntents
     * @return the MessageOptions builder
     */
    public Builder alternateIntents(Boolean alternateIntents) {
      this.alternateIntents = alternateIntents;
      return this;
    }

    /**
     * Set the context.
     *
     * @param context the context
     * @return the MessageOptions builder
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
     * @return the MessageOptions builder
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
     * @return the MessageOptions builder
     */
    public Builder intents(List<RuntimeIntent> intents) {
      this.intents = intents;
      return this;
    }

    /**
     * Set the output.
     *
     * @param output the output
     * @return the MessageOptions builder
     */
    public Builder output(OutputData output) {
      this.output = output;
      return this;
    }
  }

  private MessageOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    workspaceId = builder.workspaceId;
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
   * @return a MessageOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the workspaceId.
   *
   * Unique identifier of the workspace.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
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

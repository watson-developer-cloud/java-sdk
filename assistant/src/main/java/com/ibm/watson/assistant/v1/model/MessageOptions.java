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
package com.ibm.watson.assistant.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The message options.
 */
public class MessageOptions extends GenericModel {

  private String workspaceId;
  private MessageInput input;
  private List<RuntimeIntent> intents;
  private List<RuntimeEntity> entities;
  private Boolean alternateIntents;
  private Context context;
  private OutputData output;
  private Boolean nodesVisitedDetails;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private MessageInput input;
    private List<RuntimeIntent> intents;
    private List<RuntimeEntity> entities;
    private Boolean alternateIntents;
    private Context context;
    private OutputData output;
    private Boolean nodesVisitedDetails;

    private Builder(MessageOptions messageOptions) {
      this.workspaceId = messageOptions.workspaceId;
      this.input = messageOptions.input;
      this.intents = messageOptions.intents;
      this.entities = messageOptions.entities;
      this.alternateIntents = messageOptions.alternateIntents;
      this.context = messageOptions.context;
      this.output = messageOptions.output;
      this.nodesVisitedDetails = messageOptions.nodesVisitedDetails;
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
    public Builder input(MessageInput input) {
      this.input = input;
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
     * Set the output.
     *
     * @param output the output
     * @return the MessageOptions builder
     */
    public Builder output(OutputData output) {
      this.output = output;
      return this;
    }

    /**
     * Set the nodesVisitedDetails.
     *
     * @param nodesVisitedDetails the nodesVisitedDetails
     * @return the MessageOptions builder
     */
    public Builder nodesVisitedDetails(Boolean nodesVisitedDetails) {
      this.nodesVisitedDetails = nodesVisitedDetails;
      return this;
    }

    /**
     * Set the messageRequest.
     *
     * @param messageRequest the messageRequest
     * @return the MessageOptions builder
     */
    public Builder messageRequest(MessageRequest messageRequest) {
      this.input = messageRequest.getInput();
      this.intents = messageRequest.getIntents();
      this.entities = messageRequest.getEntities();
      this.alternateIntents = messageRequest.isAlternateIntents();
      this.context = messageRequest.getContext();
      this.output = messageRequest.getOutput();
      return this;
    }
  }

  private MessageOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    workspaceId = builder.workspaceId;
    input = builder.input;
    intents = builder.intents;
    entities = builder.entities;
    alternateIntents = builder.alternateIntents;
    context = builder.context;
    output = builder.output;
    nodesVisitedDetails = builder.nodesVisitedDetails;
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
  public MessageInput input() {
    return input;
  }

  /**
   * Gets the intents.
   *
   * Intents to use when evaluating the user input. Include intents from the previous response to continue using those
   * intents rather than trying to recognize intents in the new input.
   *
   * @return the intents
   */
  public List<RuntimeIntent> intents() {
    return intents;
  }

  /**
   * Gets the entities.
   *
   * Entities to use when evaluating the message. Include entities from the previous response to continue using those
   * entities rather than detecting entities in the new input.
   *
   * @return the entities
   */
  public List<RuntimeEntity> entities() {
    return entities;
  }

  /**
   * Gets the alternateIntents.
   *
   * Whether to return more than one intent. A value of `true` indicates that all matching intents are returned.
   *
   * @return the alternateIntents
   */
  public Boolean alternateIntents() {
    return alternateIntents;
  }

  /**
   * Gets the context.
   *
   * State information for the conversation. To maintain state, include the context from the previous response.
   *
   * @return the context
   */
  public Context context() {
    return context;
  }

  /**
   * Gets the output.
   *
   * An output object that includes the response to the user, the dialog nodes that were triggered, and messages from
   * the log.
   *
   * @return the output
   */
  public OutputData output() {
    return output;
  }

  /**
   * Gets the nodesVisitedDetails.
   *
   * Whether to include additional diagnostic information about the dialog nodes that were visited during processing of
   * the message.
   *
   * @return the nodesVisitedDetails
   */
  public Boolean nodesVisitedDetails() {
    return nodesVisitedDetails;
  }
}

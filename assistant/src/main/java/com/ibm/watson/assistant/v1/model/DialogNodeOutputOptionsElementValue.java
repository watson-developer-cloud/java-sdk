/*
 * (C) Copyright IBM Corp. 2018, 2020.
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

/**
 * An object defining the message input to be sent to the Watson Assistant service if the user selects the corresponding
 * option.
 */
public class DialogNodeOutputOptionsElementValue extends GenericModel {

  protected MessageInput input;
  protected List<RuntimeIntent> intents;
  protected List<RuntimeEntity> entities;

  /**
   * Builder.
   */
  public static class Builder {
    private MessageInput input;
    private List<RuntimeIntent> intents;
    private List<RuntimeEntity> entities;

    private Builder(DialogNodeOutputOptionsElementValue dialogNodeOutputOptionsElementValue) {
      this.input = dialogNodeOutputOptionsElementValue.input;
      this.intents = dialogNodeOutputOptionsElementValue.intents;
      this.entities = dialogNodeOutputOptionsElementValue.entities;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DialogNodeOutputOptionsElementValue.
     *
     * @return the dialogNodeOutputOptionsElementValue
     */
    public DialogNodeOutputOptionsElementValue build() {
      return new DialogNodeOutputOptionsElementValue(this);
    }

    /**
     * Adds an intents to intents.
     *
     * @param intents the new intents
     * @return the DialogNodeOutputOptionsElementValue builder
     */
    public Builder addIntents(RuntimeIntent intents) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(intents,
          "intents cannot be null");
      if (this.intents == null) {
        this.intents = new ArrayList<RuntimeIntent>();
      }
      this.intents.add(intents);
      return this;
    }

    /**
     * Adds an entities to entities.
     *
     * @param entities the new entities
     * @return the DialogNodeOutputOptionsElementValue builder
     */
    public Builder addEntities(RuntimeEntity entities) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(entities,
          "entities cannot be null");
      if (this.entities == null) {
        this.entities = new ArrayList<RuntimeEntity>();
      }
      this.entities.add(entities);
      return this;
    }

    /**
     * Set the input.
     *
     * @param input the input
     * @return the DialogNodeOutputOptionsElementValue builder
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
     * @return the DialogNodeOutputOptionsElementValue builder
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
     * @return the DialogNodeOutputOptionsElementValue builder
     */
    public Builder entities(List<RuntimeEntity> entities) {
      this.entities = entities;
      return this;
    }
  }

  protected DialogNodeOutputOptionsElementValue(Builder builder) {
    input = builder.input;
    intents = builder.intents;
    entities = builder.entities;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeOutputOptionsElementValue builder
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
  public MessageInput input() {
    return input;
  }

  /**
   * Gets the intents.
   *
   * An array of intents to be used while processing the input.
   *
   * **Note:** This property is supported for backward compatibility with applications that use the v1 **Get response to
   * user input** method.
   *
   * @return the intents
   */
  public List<RuntimeIntent> intents() {
    return intents;
  }

  /**
   * Gets the entities.
   *
   * An array of entities to be used while processing the user input.
   *
   * **Note:** This property is supported for backward compatibility with applications that use the v1 **Get response to
   * user input** method.
   *
   * @return the entities
   */
  public List<RuntimeEntity> entities() {
    return entities;
  }
}

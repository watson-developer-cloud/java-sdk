/*
 * (C) Copyright IBM Corp. 2018, 2024.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/**
 * An object defining the message input, intents, and entities to be sent to the Watson Assistant
 * service if the user selects the corresponding disambiguation option.
 *
 * <p>**Note:** These properties must be included in the request body of the next message sent to
 * the assistant. Do not modify or remove any of the included properties.
 */
public class DialogSuggestionValue extends GenericModel {

  protected MessageInput input;
  protected List<RuntimeIntent> intents;
  protected List<RuntimeEntity> entities;

  /** Builder. */
  public static class Builder {
    private MessageInput input;
    private List<RuntimeIntent> intents;
    private List<RuntimeEntity> entities;

    /**
     * Instantiates a new Builder from an existing DialogSuggestionValue instance.
     *
     * @param dialogSuggestionValue the instance to initialize the Builder with
     */
    private Builder(DialogSuggestionValue dialogSuggestionValue) {
      this.input = dialogSuggestionValue.input;
      this.intents = dialogSuggestionValue.intents;
      this.entities = dialogSuggestionValue.entities;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a DialogSuggestionValue.
     *
     * @return the new DialogSuggestionValue instance
     */
    public DialogSuggestionValue build() {
      return new DialogSuggestionValue(this);
    }

    /**
     * Adds a new element to intents.
     *
     * @param intents the new element to be added
     * @return the DialogSuggestionValue builder
     */
    public Builder addIntents(RuntimeIntent intents) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(intents, "intents cannot be null");
      if (this.intents == null) {
        this.intents = new ArrayList<RuntimeIntent>();
      }
      this.intents.add(intents);
      return this;
    }

    /**
     * Adds a new element to entities.
     *
     * @param entities the new element to be added
     * @return the DialogSuggestionValue builder
     */
    public Builder addEntities(RuntimeEntity entities) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(entities, "entities cannot be null");
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
     * @return the DialogSuggestionValue builder
     */
    public Builder input(MessageInput input) {
      this.input = input;
      return this;
    }

    /**
     * Set the intents. Existing intents will be replaced.
     *
     * @param intents the intents
     * @return the DialogSuggestionValue builder
     */
    public Builder intents(List<RuntimeIntent> intents) {
      this.intents = intents;
      return this;
    }

    /**
     * Set the entities. Existing entities will be replaced.
     *
     * @param entities the entities
     * @return the DialogSuggestionValue builder
     */
    public Builder entities(List<RuntimeEntity> entities) {
      this.entities = entities;
      return this;
    }
  }

  protected DialogSuggestionValue() {}

  protected DialogSuggestionValue(Builder builder) {
    input = builder.input;
    intents = builder.intents;
    entities = builder.entities;
  }

  /**
   * New builder.
   *
   * @return a DialogSuggestionValue builder
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
   * <p>An array of intents to be sent along with the user input.
   *
   * @return the intents
   */
  public List<RuntimeIntent> intents() {
    return intents;
  }

  /**
   * Gets the entities.
   *
   * <p>An array of entities to be sent along with the user input.
   *
   * @return the entities
   */
  public List<RuntimeEntity> entities() {
    return entities;
  }
}

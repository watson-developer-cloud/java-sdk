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
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * UpdateWorkspace.
 */
public class UpdateWorkspace extends GenericModel {

  /** The name of the workspace. */
  private String name;
  /** The description of the workspace. */
  private String description;
  /** The language of the workspace. */
  private String language;
  /** An array of objects defining the intents for the workspace. */
  private List<CreateIntent> intents;
  /** An array of objects defining the entities for the workspace. */
  private List<CreateEntity> entities;
  /** An array of objects defining the nodes in the workspace dialog. */
  @SerializedName("dialog_nodes")
  private List<CreateDialogNode> dialogNodes;
  /** An array of objects defining input examples that have been marked as irrelevant input. */
  private List<CreateExample> counterexamples;
  /** Any metadata related to the workspace. */
  private Map<String, Object> metadata;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String description;
    private String language;
    private List<CreateIntent> intents;
    private List<CreateEntity> entities;
    private List<CreateDialogNode> dialogNodes;
    private List<CreateExample> counterexamples;
    private Map<String, Object> metadata;

    private Builder(UpdateWorkspace updateWorkspace) {
      name = updateWorkspace.name;
      description = updateWorkspace.description;
      language = updateWorkspace.language;
      intents = updateWorkspace.intents;
      entities = updateWorkspace.entities;
      dialogNodes = updateWorkspace.dialogNodes;
      counterexamples = updateWorkspace.counterexamples;
      metadata = updateWorkspace.metadata;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a UpdateWorkspace.
     *
     * @return the updateWorkspace
     */
    public UpdateWorkspace build() {
      return new UpdateWorkspace(this);
    }

    /**
     * Adds an intent to intents.
     *
     * @param intent the new intent
     * @return the UpdateWorkspace builder
     */
    public Builder intents(CreateIntent intent) {
      Validator.notNull(intent, "intent cannot be null");
      if (this.intents == null) {
        this.intents = new ArrayList<CreateIntent>();
      }
      this.intents.add(intent);
      return this;
    }

    /**
     * Adds an entity to entities.
     *
     * @param entity the new entity
     * @return the UpdateWorkspace builder
     */
    public Builder entities(CreateEntity entity) {
      Validator.notNull(entity, "entity cannot be null");
      if (this.entities == null) {
        this.entities = new ArrayList<CreateEntity>();
      }
      this.entities.add(entity);
      return this;
    }

    /**
     * Adds an dialogNode to dialogNodes.
     *
     * @param dialogNode the new dialogNode
     * @return the UpdateWorkspace builder
     */
    public Builder dialogNodes(CreateDialogNode dialogNode) {
      Validator.notNull(dialogNode, "dialogNode cannot be null");
      if (this.dialogNodes == null) {
        this.dialogNodes = new ArrayList<CreateDialogNode>();
      }
      this.dialogNodes.add(dialogNode);
      return this;
    }

    /**
     * Adds an counterexample to counterexamples.
     *
     * @param counterexample the new counterexample
     * @return the UpdateWorkspace builder
     */
    public Builder counterexamples(CreateExample counterexample) {
      Validator.notNull(counterexample, "counterexample cannot be null");
      if (this.counterexamples == null) {
        this.counterexamples = new ArrayList<CreateExample>();
      }
      this.counterexamples.add(counterexample);
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateWorkspace builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateWorkspace builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the UpdateWorkspace builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the intents.
     * Existing intents will be replaced.
     *
     * @param intents the intents
     * @return the UpdateWorkspace builder
     */
    public Builder intents(List<CreateIntent> intents) {
      this.intents = intents;
      return this;
    }

    /**
     * Set the entities.
     * Existing entities will be replaced.
     *
     * @param entities the entities
     * @return the UpdateWorkspace builder
     */
    public Builder entities(List<CreateEntity> entities) {
      this.entities = entities;
      return this;
    }

    /**
     * Set the dialogNodes.
     * Existing dialogNodes will be replaced.
     *
     * @param dialogNodes the dialogNodes
     * @return the UpdateWorkspace builder
     */
    public Builder dialogNodes(List<CreateDialogNode> dialogNodes) {
      this.dialogNodes = dialogNodes;
      return this;
    }

    /**
     * Set the counterexamples.
     * Existing counterexamples will be replaced.
     *
     * @param counterexamples the counterexamples
     * @return the UpdateWorkspace builder
     */
    public Builder counterexamples(List<CreateExample> counterexamples) {
      this.counterexamples = counterexamples;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the UpdateWorkspace builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }
  }

  private UpdateWorkspace(Builder builder) {
    name = builder.name;
    description = builder.description;
    language = builder.language;
    intents = builder.intents;
    entities = builder.entities;
    dialogNodes = builder.dialogNodes;
    counterexamples = builder.counterexamples;
    metadata = builder.metadata;
  }

  /**
   * New builder.
   *
   * @return a UpdateWorkspace builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the language.
   *
   * @return the language
   */
  public String language() {
    return language;
  }

  /**
   * Gets the intents.
   *
   * @return the intents
   */
  public List<CreateIntent> intents() {
    return intents;
  }

  /**
   * Gets the entities.
   *
   * @return the entities
   */
  public List<CreateEntity> entities() {
    return entities;
  }

  /**
   * Gets the dialogNodes.
   *
   * @return the dialogNodes
   */
  public List<CreateDialogNode> dialogNodes() {
    return dialogNodes;
  }

  /**
   * Gets the counterexamples.
   *
   * @return the counterexamples
   */
  public List<CreateExample> counterexamples() {
    return counterexamples;
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }
}

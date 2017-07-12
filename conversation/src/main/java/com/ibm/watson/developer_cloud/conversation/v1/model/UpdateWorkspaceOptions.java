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

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * the updateWorkspace options.
 */
public class UpdateWorkspaceOptions extends GenericModel {

  private String workspaceId;
  private Map<String, Object> metadata;
  private List<CreateIntent> intents;
  private List<CreateEntity> entities;
  private String name;
  private List<CreateCounterexample> counterexamples;
  private String description;
  private String language;
  private List<Object> dialogNodes;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private Map<String, Object> metadata;
    private List<CreateIntent> intents;
    private List<CreateEntity> entities;
    private String name;
    private List<CreateCounterexample> counterexamples;
    private String description;
    private String language;
    private List<Object> dialogNodes;

    private Builder(UpdateWorkspaceOptions updateWorkspaceOptions) {
      workspaceId = updateWorkspaceOptions.workspaceId;
      metadata = updateWorkspaceOptions.metadata;
      intents = updateWorkspaceOptions.intents;
      entities = updateWorkspaceOptions.entities;
      name = updateWorkspaceOptions.name;
      counterexamples = updateWorkspaceOptions.counterexamples;
      description = updateWorkspaceOptions.description;
      language = updateWorkspaceOptions.language;
      dialogNodes = updateWorkspaceOptions.dialogNodes;
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
     * Builds a UpdateWorkspaceOptions.
     *
     * @return the updateWorkspaceOptions
     */
    public UpdateWorkspaceOptions build() {
      return new UpdateWorkspaceOptions(this);
    }

    /**
     * Adds an intent to intents.
     *
     * @param intent the new intent
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder addIntent(CreateIntent intent) {
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
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder addEntity(CreateEntity entity) {
      Validator.notNull(entity, "entity cannot be null");
      if (this.entities == null) {
        this.entities = new ArrayList<CreateEntity>();
      }
      this.entities.add(entity);
      return this;
    }

    /**
     * Adds an counterexample to counterexamples.
     *
     * @param counterexample the new counterexample
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder addCounterexample(CreateCounterexample counterexample) {
      Validator.notNull(counterexample, "counterexample cannot be null");
      if (this.counterexamples == null) {
        this.counterexamples = new ArrayList<CreateCounterexample>();
      }
      this.counterexamples.add(counterexample);
      return this;
    }

    /**
     * Adds an dialogNode to dialogNodes.
     *
     * @param dialogNode the new dialogNode
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder addDialogNode(Object dialogNode) {
      Validator.notNull(dialogNode, "dialogNode cannot be null");
      if (this.dialogNodes == null) {
        this.dialogNodes = new ArrayList<Object>();
      }
      this.dialogNodes.add(dialogNode);
      return this;
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the intents.
     * Existing intents will be replaced.
     *
     * @param intents the intents
     * @return the UpdateWorkspaceOptions builder
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
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder entities(List<CreateEntity> entities) {
      this.entities = entities;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the counterexamples.
     * Existing counterexamples will be replaced.
     *
     * @param counterexamples the counterexamples
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder counterexamples(List<CreateCounterexample> counterexamples) {
      this.counterexamples = counterexamples;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the dialogNodes.
     * Existing dialogNodes will be replaced.
     *
     * @param dialogNodes the dialogNodes
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder dialogNodes(List<Object> dialogNodes) {
      this.dialogNodes = dialogNodes;
      return this;
    }
  }

  private UpdateWorkspaceOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    workspaceId = builder.workspaceId;
    metadata = builder.metadata;
    intents = builder.intents;
    entities = builder.entities;
    name = builder.name;
    counterexamples = builder.counterexamples;
    description = builder.description;
    language = builder.language;
    dialogNodes = builder.dialogNodes;
  }

  /**
   * New builder.
   *
   * @return a UpdateWorkspaceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the workspaceId.
   *
   * The workspace ID.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the metadata.
   *
   * Any metadata related to the workspace.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }

  /**
   * Gets the intents.
   *
   * An array of objects defining the intents for the workspace.
   *
   * @return the intents
   */
  public List<CreateIntent> intents() {
    return intents;
  }

  /**
   * Gets the entities.
   *
   * An array of objects defining the entities for the workspace.
   *
   * @return the entities
   */
  public List<CreateEntity> entities() {
    return entities;
  }

  /**
   * Gets the name.
   *
   * The name of the workspace.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the counterexamples.
   *
   * An array of objects defining input examples that have been marked as irrelevant input.
   *
   * @return the counterexamples
   */
  public List<CreateCounterexample> counterexamples() {
    return counterexamples;
  }

  /**
   * Gets the description.
   *
   * The description of the workspace.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the language.
   *
   * The language of the workspace.
   *
   * @return the language
   */
  public String language() {
    return language;
  }

  /**
   * Gets the dialogNodes.
   *
   * An array of objects defining the nodes in the workspace dialog.
   *
   * @return the dialogNodes
   */
  public List<Object> dialogNodes() {
    return dialogNodes;
  }
}

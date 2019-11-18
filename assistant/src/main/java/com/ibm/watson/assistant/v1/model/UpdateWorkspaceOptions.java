/*
 * (C) Copyright IBM Corp. 2019.
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
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateWorkspace options.
 */
public class UpdateWorkspaceOptions extends GenericModel {

  private String workspaceId;
  private String name;
  private String description;
  private String language;
  private Map<String, Object> metadata;
  private Boolean learningOptOut;
  private WorkspaceSystemSettings systemSettings;
  private List<Webhook> webhooks;
  private List<CreateIntent> intents;
  private List<CreateEntity> entities;
  private List<DialogNode> dialogNodes;
  private List<Counterexample> counterexamples;
  private Boolean append;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private String name;
    private String description;
    private String language;
    private Map<String, Object> metadata;
    private Boolean learningOptOut;
    private WorkspaceSystemSettings systemSettings;
    private List<Webhook> webhooks;
    private List<CreateIntent> intents;
    private List<CreateEntity> entities;
    private List<DialogNode> dialogNodes;
    private List<Counterexample> counterexamples;
    private Boolean append;

    private Builder(UpdateWorkspaceOptions updateWorkspaceOptions) {
      this.workspaceId = updateWorkspaceOptions.workspaceId;
      this.name = updateWorkspaceOptions.name;
      this.description = updateWorkspaceOptions.description;
      this.language = updateWorkspaceOptions.language;
      this.metadata = updateWorkspaceOptions.metadata;
      this.learningOptOut = updateWorkspaceOptions.learningOptOut;
      this.systemSettings = updateWorkspaceOptions.systemSettings;
      this.webhooks = updateWorkspaceOptions.webhooks;
      this.intents = updateWorkspaceOptions.intents;
      this.entities = updateWorkspaceOptions.entities;
      this.dialogNodes = updateWorkspaceOptions.dialogNodes;
      this.counterexamples = updateWorkspaceOptions.counterexamples;
      this.append = updateWorkspaceOptions.append;
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
     * Adds an webhooks to webhooks.
     *
     * @param webhooks the new webhooks
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder addWebhooks(Webhook webhooks) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(webhooks,
          "webhooks cannot be null");
      if (this.webhooks == null) {
        this.webhooks = new ArrayList<Webhook>();
      }
      this.webhooks.add(webhooks);
      return this;
    }

    /**
     * Adds an intent to intents.
     *
     * @param intent the new intent
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder addIntent(CreateIntent intent) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(intent,
          "intent cannot be null");
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
      com.ibm.cloud.sdk.core.util.Validator.notNull(entity,
          "entity cannot be null");
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
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder addDialogNode(DialogNode dialogNode) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(dialogNode,
          "dialogNode cannot be null");
      if (this.dialogNodes == null) {
        this.dialogNodes = new ArrayList<DialogNode>();
      }
      this.dialogNodes.add(dialogNode);
      return this;
    }

    /**
     * Adds an counterexample to counterexamples.
     *
     * @param counterexample the new counterexample
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder addCounterexample(Counterexample counterexample) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(counterexample,
          "counterexample cannot be null");
      if (this.counterexamples == null) {
        this.counterexamples = new ArrayList<Counterexample>();
      }
      this.counterexamples.add(counterexample);
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
     * Set the learningOptOut.
     *
     * @param learningOptOut the learningOptOut
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder learningOptOut(Boolean learningOptOut) {
      this.learningOptOut = learningOptOut;
      return this;
    }

    /**
     * Set the systemSettings.
     *
     * @param systemSettings the systemSettings
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder systemSettings(WorkspaceSystemSettings systemSettings) {
      this.systemSettings = systemSettings;
      return this;
    }

    /**
     * Set the webhooks.
     * Existing webhooks will be replaced.
     *
     * @param webhooks the webhooks
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder webhooks(List<Webhook> webhooks) {
      this.webhooks = webhooks;
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
     * Set the dialogNodes.
     * Existing dialogNodes will be replaced.
     *
     * @param dialogNodes the dialogNodes
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder dialogNodes(List<DialogNode> dialogNodes) {
      this.dialogNodes = dialogNodes;
      return this;
    }

    /**
     * Set the counterexamples.
     * Existing counterexamples will be replaced.
     *
     * @param counterexamples the counterexamples
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder counterexamples(List<Counterexample> counterexamples) {
      this.counterexamples = counterexamples;
      return this;
    }

    /**
     * Set the append.
     *
     * @param append the append
     * @return the UpdateWorkspaceOptions builder
     */
    public Builder append(Boolean append) {
      this.append = append;
      return this;
    }
  }

  private UpdateWorkspaceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.workspaceId,
        "workspaceId cannot be empty");
    workspaceId = builder.workspaceId;
    name = builder.name;
    description = builder.description;
    language = builder.language;
    metadata = builder.metadata;
    learningOptOut = builder.learningOptOut;
    systemSettings = builder.systemSettings;
    webhooks = builder.webhooks;
    intents = builder.intents;
    entities = builder.entities;
    dialogNodes = builder.dialogNodes;
    counterexamples = builder.counterexamples;
    append = builder.append;
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
   * Unique identifier of the workspace.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the name.
   *
   * The name of the workspace. This string cannot contain carriage return, newline, or tab characters.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the workspace. This string cannot contain carriage return, newline, or tab characters.
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
   * Gets the learningOptOut.
   *
   * Whether training data from the workspace (including artifacts such as intents and entities) can be used by IBM for
   * general service improvements. `true` indicates that workspace training data is not to be used.
   *
   * @return the learningOptOut
   */
  public Boolean learningOptOut() {
    return learningOptOut;
  }

  /**
   * Gets the systemSettings.
   *
   * Global settings for the workspace.
   *
   * @return the systemSettings
   */
  public WorkspaceSystemSettings systemSettings() {
    return systemSettings;
  }

  /**
   * Gets the webhooks.
   *
   * @return the webhooks
   */
  public List<Webhook> webhooks() {
    return webhooks;
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
   * An array of objects describing the entities for the workspace.
   *
   * @return the entities
   */
  public List<CreateEntity> entities() {
    return entities;
  }

  /**
   * Gets the dialogNodes.
   *
   * An array of objects describing the dialog nodes in the workspace.
   *
   * @return the dialogNodes
   */
  public List<DialogNode> dialogNodes() {
    return dialogNodes;
  }

  /**
   * Gets the counterexamples.
   *
   * An array of objects defining input examples that have been marked as irrelevant input.
   *
   * @return the counterexamples
   */
  public List<Counterexample> counterexamples() {
    return counterexamples;
  }

  /**
   * Gets the append.
   *
   * Whether the new data is to be appended to the existing data in the workspace. If **append**=`false`, elements
   * included in the new data completely replace the corresponding existing elements, including all subelements. For
   * example, if the new data includes **entities** and **append**=`false`, all existing entities in the workspace are
   * discarded and replaced with the new entities.
   *
   * If **append**=`true`, existing elements are preserved, and the new elements are added. If any elements in the new
   * data collide with existing elements, the update request fails.
   *
   * @return the append
   */
  public Boolean append() {
    return append;
  }
}

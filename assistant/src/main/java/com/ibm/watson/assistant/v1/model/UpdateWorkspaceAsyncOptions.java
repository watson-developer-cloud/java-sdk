/*
 * (C) Copyright IBM Corp. 2022, 2024.
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
import java.util.Map;

/** The updateWorkspaceAsync options. */
public class UpdateWorkspaceAsyncOptions extends GenericModel {

  protected String workspaceId;
  protected String name;
  protected String description;
  protected String language;
  protected List<DialogNode> dialogNodes;
  protected List<Counterexample> counterexamples;
  protected Map<String, Object> metadata;
  protected Boolean learningOptOut;
  protected WorkspaceSystemSettings systemSettings;
  protected List<Webhook> webhooks;
  protected List<CreateIntent> intents;
  protected List<CreateEntity> entities;
  protected Boolean append;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String name;
    private String description;
    private String language;
    private List<DialogNode> dialogNodes;
    private List<Counterexample> counterexamples;
    private Map<String, Object> metadata;
    private Boolean learningOptOut;
    private WorkspaceSystemSettings systemSettings;
    private List<Webhook> webhooks;
    private List<CreateIntent> intents;
    private List<CreateEntity> entities;
    private Boolean append;

    /**
     * Instantiates a new Builder from an existing UpdateWorkspaceAsyncOptions instance.
     *
     * @param updateWorkspaceAsyncOptions the instance to initialize the Builder with
     */
    private Builder(UpdateWorkspaceAsyncOptions updateWorkspaceAsyncOptions) {
      this.workspaceId = updateWorkspaceAsyncOptions.workspaceId;
      this.name = updateWorkspaceAsyncOptions.name;
      this.description = updateWorkspaceAsyncOptions.description;
      this.language = updateWorkspaceAsyncOptions.language;
      this.dialogNodes = updateWorkspaceAsyncOptions.dialogNodes;
      this.counterexamples = updateWorkspaceAsyncOptions.counterexamples;
      this.metadata = updateWorkspaceAsyncOptions.metadata;
      this.learningOptOut = updateWorkspaceAsyncOptions.learningOptOut;
      this.systemSettings = updateWorkspaceAsyncOptions.systemSettings;
      this.webhooks = updateWorkspaceAsyncOptions.webhooks;
      this.intents = updateWorkspaceAsyncOptions.intents;
      this.entities = updateWorkspaceAsyncOptions.entities;
      this.append = updateWorkspaceAsyncOptions.append;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     */
    public Builder(String workspaceId) {
      this.workspaceId = workspaceId;
    }

    /**
     * Builds a UpdateWorkspaceAsyncOptions.
     *
     * @return the new UpdateWorkspaceAsyncOptions instance
     */
    public UpdateWorkspaceAsyncOptions build() {
      return new UpdateWorkspaceAsyncOptions(this);
    }

    /**
     * Adds a new element to dialogNodes.
     *
     * @param dialogNode the new element to be added
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder addDialogNode(DialogNode dialogNode) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(dialogNode, "dialogNode cannot be null");
      if (this.dialogNodes == null) {
        this.dialogNodes = new ArrayList<DialogNode>();
      }
      this.dialogNodes.add(dialogNode);
      return this;
    }

    /**
     * Adds a new element to counterexamples.
     *
     * @param counterexample the new element to be added
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder addCounterexample(Counterexample counterexample) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(
          counterexample, "counterexample cannot be null");
      if (this.counterexamples == null) {
        this.counterexamples = new ArrayList<Counterexample>();
      }
      this.counterexamples.add(counterexample);
      return this;
    }

    /**
     * Adds a new element to webhooks.
     *
     * @param webhooks the new element to be added
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder addWebhooks(Webhook webhooks) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(webhooks, "webhooks cannot be null");
      if (this.webhooks == null) {
        this.webhooks = new ArrayList<Webhook>();
      }
      this.webhooks.add(webhooks);
      return this;
    }

    /**
     * Adds a new element to intents.
     *
     * @param intent the new element to be added
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder addIntent(CreateIntent intent) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(intent, "intent cannot be null");
      if (this.intents == null) {
        this.intents = new ArrayList<CreateIntent>();
      }
      this.intents.add(intent);
      return this;
    }

    /**
     * Adds a new element to entities.
     *
     * @param entity the new element to be added
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder addEntity(CreateEntity entity) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(entity, "entity cannot be null");
      if (this.entities == null) {
        this.entities = new ArrayList<CreateEntity>();
      }
      this.entities.add(entity);
      return this;
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the dialogNodes. Existing dialogNodes will be replaced.
     *
     * @param dialogNodes the dialogNodes
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder dialogNodes(List<DialogNode> dialogNodes) {
      this.dialogNodes = dialogNodes;
      return this;
    }

    /**
     * Set the counterexamples. Existing counterexamples will be replaced.
     *
     * @param counterexamples the counterexamples
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder counterexamples(List<Counterexample> counterexamples) {
      this.counterexamples = counterexamples;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the learningOptOut.
     *
     * @param learningOptOut the learningOptOut
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder learningOptOut(Boolean learningOptOut) {
      this.learningOptOut = learningOptOut;
      return this;
    }

    /**
     * Set the systemSettings.
     *
     * @param systemSettings the systemSettings
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder systemSettings(WorkspaceSystemSettings systemSettings) {
      this.systemSettings = systemSettings;
      return this;
    }

    /**
     * Set the webhooks. Existing webhooks will be replaced.
     *
     * @param webhooks the webhooks
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder webhooks(List<Webhook> webhooks) {
      this.webhooks = webhooks;
      return this;
    }

    /**
     * Set the intents. Existing intents will be replaced.
     *
     * @param intents the intents
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder intents(List<CreateIntent> intents) {
      this.intents = intents;
      return this;
    }

    /**
     * Set the entities. Existing entities will be replaced.
     *
     * @param entities the entities
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder entities(List<CreateEntity> entities) {
      this.entities = entities;
      return this;
    }

    /**
     * Set the append.
     *
     * @param append the append
     * @return the UpdateWorkspaceAsyncOptions builder
     */
    public Builder append(Boolean append) {
      this.append = append;
      return this;
    }
  }

  protected UpdateWorkspaceAsyncOptions() {}

  protected UpdateWorkspaceAsyncOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    workspaceId = builder.workspaceId;
    name = builder.name;
    description = builder.description;
    language = builder.language;
    dialogNodes = builder.dialogNodes;
    counterexamples = builder.counterexamples;
    metadata = builder.metadata;
    learningOptOut = builder.learningOptOut;
    systemSettings = builder.systemSettings;
    webhooks = builder.webhooks;
    intents = builder.intents;
    entities = builder.entities;
    append = builder.append;
  }

  /**
   * New builder.
   *
   * @return a UpdateWorkspaceAsyncOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the workspaceId.
   *
   * <p>Unique identifier of the workspace.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the name.
   *
   * <p>The name of the workspace. This string cannot contain carriage return, newline, or tab
   * characters.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>The description of the workspace. This string cannot contain carriage return, newline, or
   * tab characters.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the language.
   *
   * <p>The language of the workspace.
   *
   * @return the language
   */
  public String language() {
    return language;
  }

  /**
   * Gets the dialogNodes.
   *
   * <p>An array of objects describing the dialog nodes in the workspace.
   *
   * @return the dialogNodes
   */
  public List<DialogNode> dialogNodes() {
    return dialogNodes;
  }

  /**
   * Gets the counterexamples.
   *
   * <p>An array of objects defining input examples that have been marked as irrelevant input.
   *
   * @return the counterexamples
   */
  public List<Counterexample> counterexamples() {
    return counterexamples;
  }

  /**
   * Gets the metadata.
   *
   * <p>Any metadata related to the workspace.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }

  /**
   * Gets the learningOptOut.
   *
   * <p>Whether training data from the workspace (including artifacts such as intents and entities)
   * can be used by IBM for general service improvements. `true` indicates that workspace training
   * data is not to be used.
   *
   * @return the learningOptOut
   */
  public Boolean learningOptOut() {
    return learningOptOut;
  }

  /**
   * Gets the systemSettings.
   *
   * <p>Global settings for the workspace.
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
   * <p>An array of objects defining the intents for the workspace.
   *
   * @return the intents
   */
  public List<CreateIntent> intents() {
    return intents;
  }

  /**
   * Gets the entities.
   *
   * <p>An array of objects describing the entities for the workspace.
   *
   * @return the entities
   */
  public List<CreateEntity> entities() {
    return entities;
  }

  /**
   * Gets the append.
   *
   * <p>Whether the new data is to be appended to the existing data in the object. If
   * **append**=`false`, elements included in the new data completely replace the corresponding
   * existing elements, including all subelements. For example, if the new data for a workspace
   * includes **entities** and **append**=`false`, all existing entities in the workspace are
   * discarded and replaced with the new entities.
   *
   * <p>If **append**=`true`, existing elements are preserved, and the new elements are added. If
   * any elements in the new data collide with existing elements, the update request fails.
   *
   * @return the append
   */
  public Boolean append() {
    return append;
  }
}

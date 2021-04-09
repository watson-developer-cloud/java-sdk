/*
 * (C) Copyright IBM Corp. 2021.
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

/** The createWorkspace options. */
public class CreateWorkspaceOptions extends GenericModel {

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
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
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
    private Boolean includeAudit;

    private Builder(CreateWorkspaceOptions createWorkspaceOptions) {
      this.name = createWorkspaceOptions.name;
      this.description = createWorkspaceOptions.description;
      this.language = createWorkspaceOptions.language;
      this.dialogNodes = createWorkspaceOptions.dialogNodes;
      this.counterexamples = createWorkspaceOptions.counterexamples;
      this.metadata = createWorkspaceOptions.metadata;
      this.learningOptOut = createWorkspaceOptions.learningOptOut;
      this.systemSettings = createWorkspaceOptions.systemSettings;
      this.webhooks = createWorkspaceOptions.webhooks;
      this.intents = createWorkspaceOptions.intents;
      this.entities = createWorkspaceOptions.entities;
      this.includeAudit = createWorkspaceOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a CreateWorkspaceOptions.
     *
     * @return the new CreateWorkspaceOptions instance
     */
    public CreateWorkspaceOptions build() {
      return new CreateWorkspaceOptions(this);
    }

    /**
     * Adds an dialogNode to dialogNodes.
     *
     * @param dialogNode the new dialogNode
     * @return the CreateWorkspaceOptions builder
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
     * Adds an counterexample to counterexamples.
     *
     * @param counterexample the new counterexample
     * @return the CreateWorkspaceOptions builder
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
     * Adds an webhooks to webhooks.
     *
     * @param webhooks the new webhooks
     * @return the CreateWorkspaceOptions builder
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
     * Adds an intent to intents.
     *
     * @param intent the new intent
     * @return the CreateWorkspaceOptions builder
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
     * Adds an entity to entities.
     *
     * @param entity the new entity
     * @return the CreateWorkspaceOptions builder
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
     * Set the name.
     *
     * @param name the name
     * @return the CreateWorkspaceOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateWorkspaceOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the CreateWorkspaceOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the dialogNodes. Existing dialogNodes will be replaced.
     *
     * @param dialogNodes the dialogNodes
     * @return the CreateWorkspaceOptions builder
     */
    public Builder dialogNodes(List<DialogNode> dialogNodes) {
      this.dialogNodes = dialogNodes;
      return this;
    }

    /**
     * Set the counterexamples. Existing counterexamples will be replaced.
     *
     * @param counterexamples the counterexamples
     * @return the CreateWorkspaceOptions builder
     */
    public Builder counterexamples(List<Counterexample> counterexamples) {
      this.counterexamples = counterexamples;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the CreateWorkspaceOptions builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the learningOptOut.
     *
     * @param learningOptOut the learningOptOut
     * @return the CreateWorkspaceOptions builder
     */
    public Builder learningOptOut(Boolean learningOptOut) {
      this.learningOptOut = learningOptOut;
      return this;
    }

    /**
     * Set the systemSettings.
     *
     * @param systemSettings the systemSettings
     * @return the CreateWorkspaceOptions builder
     */
    public Builder systemSettings(WorkspaceSystemSettings systemSettings) {
      this.systemSettings = systemSettings;
      return this;
    }

    /**
     * Set the webhooks. Existing webhooks will be replaced.
     *
     * @param webhooks the webhooks
     * @return the CreateWorkspaceOptions builder
     */
    public Builder webhooks(List<Webhook> webhooks) {
      this.webhooks = webhooks;
      return this;
    }

    /**
     * Set the intents. Existing intents will be replaced.
     *
     * @param intents the intents
     * @return the CreateWorkspaceOptions builder
     */
    public Builder intents(List<CreateIntent> intents) {
      this.intents = intents;
      return this;
    }

    /**
     * Set the entities. Existing entities will be replaced.
     *
     * @param entities the entities
     * @return the CreateWorkspaceOptions builder
     */
    public Builder entities(List<CreateEntity> entities) {
      this.entities = entities;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the CreateWorkspaceOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected CreateWorkspaceOptions(Builder builder) {
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
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a CreateWorkspaceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Gets the includeAudit.
   *
   * <p>Whether to include the audit properties (`created` and `updated` timestamps) in the
   * response.
   *
   * @return the includeAudit
   */
  public Boolean includeAudit() {
    return includeAudit;
  }
}

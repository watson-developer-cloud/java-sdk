/*
 * (C) Copyright IBM Corp. 2020.
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

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Workspace.
 */
public class Workspace extends GenericModel {

  /**
   * The current status of the workspace.
   */
  public interface Status {
    /** Non Existent. */
    String NON_EXISTENT = "Non Existent";
    /** Training. */
    String TRAINING = "Training";
    /** Failed. */
    String FAILED = "Failed";
    /** Available. */
    String AVAILABLE = "Available";
    /** Unavailable. */
    String UNAVAILABLE = "Unavailable";
  }

  protected String name;
  protected String description;
  protected String language;
  protected Map<String, Object> metadata;
  @SerializedName("learning_opt_out")
  protected Boolean learningOptOut;
  @SerializedName("system_settings")
  protected WorkspaceSystemSettings systemSettings;
  @SerializedName("workspace_id")
  protected String workspaceId;
  protected String status;
  protected Date created;
  protected Date updated;
  protected List<Intent> intents;
  protected List<Entity> entities;
  @SerializedName("dialog_nodes")
  protected List<DialogNode> dialogNodes;
  protected List<Counterexample> counterexamples;
  protected List<Webhook> webhooks;

  /**
   * Gets the name.
   *
   * The name of the workspace. This string cannot contain carriage return, newline, or tab characters.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the workspace. This string cannot contain carriage return, newline, or tab characters.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the language.
   *
   * The language of the workspace.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the metadata.
   *
   * Any metadata related to the workspace.
   *
   * @return the metadata
   */
  public Map<String, Object> getMetadata() {
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
  public Boolean isLearningOptOut() {
    return learningOptOut;
  }

  /**
   * Gets the systemSettings.
   *
   * Global settings for the workspace.
   *
   * @return the systemSettings
   */
  public WorkspaceSystemSettings getSystemSettings() {
    return systemSettings;
  }

  /**
   * Gets the workspaceId.
   *
   * The workspace ID of the workspace.
   *
   * @return the workspaceId
   */
  public String getWorkspaceId() {
    return workspaceId;
  }

  /**
   * Gets the status.
   *
   * The current status of the workspace.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the created.
   *
   * The timestamp for creation of the object.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The timestamp for the most recent update to the object.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the intents.
   *
   * An array of intents.
   *
   * @return the intents
   */
  public List<Intent> getIntents() {
    return intents;
  }

  /**
   * Gets the entities.
   *
   * An array of objects describing the entities for the workspace.
   *
   * @return the entities
   */
  public List<Entity> getEntities() {
    return entities;
  }

  /**
   * Gets the dialogNodes.
   *
   * An array of objects describing the dialog nodes in the workspace.
   *
   * @return the dialogNodes
   */
  public List<DialogNode> getDialogNodes() {
    return dialogNodes;
  }

  /**
   * Gets the counterexamples.
   *
   * An array of counterexamples.
   *
   * @return the counterexamples
   */
  public List<Counterexample> getCounterexamples() {
    return counterexamples;
  }

  /**
   * Gets the webhooks.
   *
   * @return the webhooks
   */
  public List<Webhook> getWebhooks() {
    return webhooks;
  }
}


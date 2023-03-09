/*
 * (C) Copyright IBM Corp. 2017, 2023.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;
import java.util.List;
import java.util.Map;

/** Workspace. */
public class Workspace extends GenericModel {

  /**
   * The current status of the workspace: - **Available**: The workspace is available and ready to
   * process messages. - **Failed**: An asynchronous operation has failed. See the **status_errors**
   * property for more information about the cause of the failure. Returned only by the **Export
   * workspace asynchronously** method. - **Non Existent**: The workspace does not exist. -
   * **Processing**: An asynchronous operation has not yet completed. Returned only by the **Export
   * workspace asynchronously** method. - **Training**: The workspace is training based on new data
   * such as intents or examples.
   */
  public interface Status {
    /** Available. */
    String AVAILABLE = "Available";
    /** Failed. */
    String FAILED = "Failed";
    /** Non Existent. */
    String NON_EXISTENT = "Non Existent";
    /** Processing. */
    String PROCESSING = "Processing";
    /** Training. */
    String TRAINING = "Training";
    /** Unavailable. */
    String UNAVAILABLE = "Unavailable";
  }

  protected String name;
  protected String description;
  protected String language;

  @SerializedName("workspace_id")
  protected String workspaceId;

  @SerializedName("dialog_nodes")
  protected List<DialogNode> dialogNodes;

  protected List<Counterexample> counterexamples;
  protected Date created;
  protected Date updated;
  protected Map<String, Object> metadata;

  @SerializedName("learning_opt_out")
  protected Boolean learningOptOut;

  @SerializedName("system_settings")
  protected WorkspaceSystemSettings systemSettings;

  protected String status;

  @SerializedName("status_errors")
  protected List<StatusError> statusErrors;

  protected List<Webhook> webhooks;
  protected List<Intent> intents;
  protected List<Entity> entities;
  protected WorkspaceCounts counts;

  protected Workspace() {}

  /**
   * Gets the name.
   *
   * <p>The name of the workspace. This string cannot contain carriage return, newline, or tab
   * characters.
   *
   * @return the name
   */
  public String getName() {
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
  public String getDescription() {
    return description;
  }

  /**
   * Gets the language.
   *
   * <p>The language of the workspace.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the workspaceId.
   *
   * <p>The workspace ID of the workspace.
   *
   * @return the workspaceId
   */
  public String getWorkspaceId() {
    return workspaceId;
  }

  /**
   * Gets the dialogNodes.
   *
   * <p>An array of objects describing the dialog nodes in the workspace.
   *
   * @return the dialogNodes
   */
  public List<DialogNode> getDialogNodes() {
    return dialogNodes;
  }

  /**
   * Gets the counterexamples.
   *
   * <p>An array of objects defining input examples that have been marked as irrelevant input.
   *
   * @return the counterexamples
   */
  public List<Counterexample> getCounterexamples() {
    return counterexamples;
  }

  /**
   * Gets the created.
   *
   * <p>The timestamp for creation of the object.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * <p>The timestamp for the most recent update to the object.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the metadata.
   *
   * <p>Any metadata related to the workspace.
   *
   * @return the metadata
   */
  public Map<String, Object> getMetadata() {
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
  public Boolean isLearningOptOut() {
    return learningOptOut;
  }

  /**
   * Gets the systemSettings.
   *
   * <p>Global settings for the workspace.
   *
   * @return the systemSettings
   */
  public WorkspaceSystemSettings getSystemSettings() {
    return systemSettings;
  }

  /**
   * Gets the status.
   *
   * <p>The current status of the workspace: - **Available**: The workspace is available and ready
   * to process messages. - **Failed**: An asynchronous operation has failed. See the
   * **status_errors** property for more information about the cause of the failure. Returned only
   * by the **Export workspace asynchronously** method. - **Non Existent**: The workspace does not
   * exist. - **Processing**: An asynchronous operation has not yet completed. Returned only by the
   * **Export workspace asynchronously** method. - **Training**: The workspace is training based on
   * new data such as intents or examples.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the statusErrors.
   *
   * <p>An array of messages about errors that caused an asynchronous operation to fail.
   *
   * @return the statusErrors
   */
  public List<StatusError> getStatusErrors() {
    return statusErrors;
  }

  /**
   * Gets the webhooks.
   *
   * @return the webhooks
   */
  public List<Webhook> getWebhooks() {
    return webhooks;
  }

  /**
   * Gets the intents.
   *
   * <p>An array of intents.
   *
   * @return the intents
   */
  public List<Intent> getIntents() {
    return intents;
  }

  /**
   * Gets the entities.
   *
   * <p>An array of objects describing the entities for the workspace.
   *
   * @return the entities
   */
  public List<Entity> getEntities() {
    return entities;
  }

  /**
   * Gets the counts.
   *
   * <p>An object containing properties that indicate how many intents, entities, and dialog nodes
   * are defined in the workspace. This property is included only in responses from the **Export
   * workspace asynchronously** method, and only when the **verbose** query parameter is set to
   * `true`.
   *
   * @return the counts
   */
  public WorkspaceCounts getCounts() {
    return counts;
  }
}

/*
 * (C) Copyright IBM Corp. 2023, 2024.
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
package com.ibm.watson.assistant.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;
import java.util.Map;

/** Skill. */
public class Skill extends GenericModel {

  /**
   * The current status of the skill: - **Available**: The skill is available and ready to process
   * messages. - **Failed**: An asynchronous operation has failed. See the **status_errors**
   * property for more information about the cause of the failure. - **Non Existent**: The skill
   * does not exist. - **Processing**: An asynchronous operation has not yet completed. -
   * **Training**: The skill is training based on new data.
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

  /** The type of skill. */
  public interface Type {
    /** action. */
    String ACTION = "action";
    /** dialog. */
    String DIALOG = "dialog";
    /** search. */
    String SEARCH = "search";
  }

  protected String name;
  protected String description;
  protected Map<String, Object> workspace;

  @SerializedName("skill_id")
  protected String skillId;

  protected String status;

  @SerializedName("status_errors")
  protected List<StatusError> statusErrors;

  @SerializedName("status_description")
  protected String statusDescription;

  @SerializedName("dialog_settings")
  protected Map<String, Object> dialogSettings;

  @SerializedName("assistant_id")
  protected String assistantId;

  @SerializedName("workspace_id")
  protected String workspaceId;

  @SerializedName("environment_id")
  protected String environmentId;

  protected Boolean valid;

  @SerializedName("next_snapshot_version")
  protected String nextSnapshotVersion;

  @SerializedName("search_settings")
  protected SearchSettings searchSettings;

  protected List<SearchSkillWarning> warnings;
  protected String language;
  protected String type;

  protected Skill() {}

  /**
   * Gets the name.
   *
   * <p>The name of the skill. This string cannot contain carriage return, newline, or tab
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
   * <p>The description of the skill. This string cannot contain carriage return, newline, or tab
   * characters.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the workspace.
   *
   * <p>An object containing the conversational content of an action or dialog skill.
   *
   * @return the workspace
   */
  public Map<String, Object> getWorkspace() {
    return workspace;
  }

  /**
   * Gets the skillId.
   *
   * <p>The skill ID of the skill.
   *
   * @return the skillId
   */
  public String getSkillId() {
    return skillId;
  }

  /**
   * Gets the status.
   *
   * <p>The current status of the skill: - **Available**: The skill is available and ready to
   * process messages. - **Failed**: An asynchronous operation has failed. See the **status_errors**
   * property for more information about the cause of the failure. - **Non Existent**: The skill
   * does not exist. - **Processing**: An asynchronous operation has not yet completed. -
   * **Training**: The skill is training based on new data.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the statusErrors.
   *
   * <p>An array of messages about errors that caused an asynchronous operation to fail. Included
   * only if **status**=`Failed`.
   *
   * @return the statusErrors
   */
  public List<StatusError> getStatusErrors() {
    return statusErrors;
  }

  /**
   * Gets the statusDescription.
   *
   * <p>The description of the failed asynchronous operation. Included only if **status**=`Failed`.
   *
   * @return the statusDescription
   */
  public String getStatusDescription() {
    return statusDescription;
  }

  /**
   * Gets the dialogSettings.
   *
   * <p>For internal use only.
   *
   * @return the dialogSettings
   */
  public Map<String, Object> getDialogSettings() {
    return dialogSettings;
  }

  /**
   * Gets the assistantId.
   *
   * <p>The unique identifier of the assistant the skill is associated with.
   *
   * @return the assistantId
   */
  public String getAssistantId() {
    return assistantId;
  }

  /**
   * Gets the workspaceId.
   *
   * <p>The unique identifier of the workspace that contains the skill content. Included only for
   * action and dialog skills.
   *
   * @return the workspaceId
   */
  public String getWorkspaceId() {
    return workspaceId;
  }

  /**
   * Gets the environmentId.
   *
   * <p>The unique identifier of the environment where the skill is defined. For action and dialog
   * skills, this is always the draft environment.
   *
   * @return the environmentId
   */
  public String getEnvironmentId() {
    return environmentId;
  }

  /**
   * Gets the valid.
   *
   * <p>Whether the skill is structurally valid.
   *
   * @return the valid
   */
  public Boolean isValid() {
    return valid;
  }

  /**
   * Gets the nextSnapshotVersion.
   *
   * <p>The name that will be given to the next snapshot that is created for the skill. A snapshot
   * of each versionable skill is saved for each new release of an assistant.
   *
   * @return the nextSnapshotVersion
   */
  public String getNextSnapshotVersion() {
    return nextSnapshotVersion;
  }

  /**
   * Gets the searchSettings.
   *
   * <p>An object describing the search skill configuration.
   *
   * <p>**Note:** Search settings are not supported in **Import skills** requests, and are not
   * included in **Export skills** responses.
   *
   * @return the searchSettings
   */
  public SearchSettings getSearchSettings() {
    return searchSettings;
  }

  /**
   * Gets the warnings.
   *
   * <p>An array of warnings describing errors with the search skill configuration. Included only
   * for search skills.
   *
   * @return the warnings
   */
  public List<SearchSkillWarning> getWarnings() {
    return warnings;
  }

  /**
   * Gets the language.
   *
   * <p>The language of the skill.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the type.
   *
   * <p>The type of skill.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }
}

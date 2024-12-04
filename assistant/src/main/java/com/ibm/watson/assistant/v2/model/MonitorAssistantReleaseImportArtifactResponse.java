/*
 * (C) Copyright IBM Corp. 2024.
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
import java.util.Date;
import java.util.List;

/** MonitorAssistantReleaseImportArtifactResponse. */
public class MonitorAssistantReleaseImportArtifactResponse extends GenericModel {

  /**
   * The current status of the release import process: - **Completed**: The artifact import has
   * completed. - **Failed**: The asynchronous artifact import process has failed. - **Processing**:
   * An asynchronous operation to import the artifact is underway and not yet completed.
   */
  public interface Status {
    /** Completed. */
    String COMPLETED = "Completed";
    /** Failed. */
    String FAILED = "Failed";
    /** Processing. */
    String PROCESSING = "Processing";
  }

  /** The type of the skill in the draft environment. */
  public interface SkillImpactInDraft {
    /** action. */
    String ACTION = "action";
    /** dialog. */
    String DIALOG = "dialog";
  }

  protected String status;

  @SerializedName("task_id")
  protected String taskId;

  @SerializedName("assistant_id")
  protected String assistantId;

  @SerializedName("status_errors")
  protected List<StatusError> statusErrors;

  @SerializedName("status_description")
  protected String statusDescription;

  @SerializedName("skill_impact_in_draft")
  protected List<String> skillImpactInDraft;

  protected Date created;
  protected Date updated;

  protected MonitorAssistantReleaseImportArtifactResponse() {}

  /**
   * Gets the status.
   *
   * <p>The current status of the release import process: - **Completed**: The artifact import has
   * completed. - **Failed**: The asynchronous artifact import process has failed. - **Processing**:
   * An asynchronous operation to import the artifact is underway and not yet completed.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the taskId.
   *
   * <p>A unique identifier for a background asynchronous task that is executing or has executed the
   * operation.
   *
   * @return the taskId
   */
  public String getTaskId() {
    return taskId;
  }

  /**
   * Gets the assistantId.
   *
   * <p>The ID of the assistant to which the release belongs.
   *
   * @return the assistantId
   */
  public String getAssistantId() {
    return assistantId;
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
   * Gets the skillImpactInDraft.
   *
   * <p>An array of skill types in the draft environment which will be overridden with skills from
   * the artifact being imported.
   *
   * @return the skillImpactInDraft
   */
  public List<String> getSkillImpactInDraft() {
    return skillImpactInDraft;
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
}

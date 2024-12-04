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

/** CreateReleaseExportWithStatusErrors. */
public class CreateReleaseExportWithStatusErrors extends GenericModel {

  /**
   * The current status of the release export creation process: - **Available**: The release export
   * package is available for download. - **Failed**: The asynchronous release export package
   * creation process has failed. - **Processing**: An asynchronous operation to create the release
   * export package is underway and not yet completed.
   */
  public interface Status {
    /** Available. */
    String AVAILABLE = "Available";
    /** Failed. */
    String FAILED = "Failed";
    /** Processing. */
    String PROCESSING = "Processing";
  }

  protected String status;

  @SerializedName("task_id")
  protected String taskId;

  @SerializedName("assistant_id")
  protected String assistantId;

  protected String release;
  protected Date created;
  protected Date updated;

  @SerializedName("status_errors")
  protected List<StatusError> statusErrors;

  @SerializedName("status_description")
  protected String statusDescription;

  protected CreateReleaseExportWithStatusErrors() {}

  /**
   * Gets the status.
   *
   * <p>The current status of the release export creation process: - **Available**: The release
   * export package is available for download. - **Failed**: The asynchronous release export package
   * creation process has failed. - **Processing**: An asynchronous operation to create the release
   * export package is underway and not yet completed.
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
   * Gets the release.
   *
   * <p>The name of the release. The name is the version number (an integer), returned as a string.
   *
   * @return the release
   */
  public String getRelease() {
    return release;
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
}

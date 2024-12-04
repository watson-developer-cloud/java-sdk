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

/** SkillsAsyncRequestStatus. */
public class SkillsAsyncRequestStatus extends GenericModel {

  /**
   * The current status of the asynchronous operation: - `Available`: An asynchronous export is
   * available. - `Completed`: An asynchronous import operation has completed successfully. -
   * `Failed`: An asynchronous operation has failed. See the **status_errors** property for more
   * information about the cause of the failure. - `Processing`: An asynchronous operation has not
   * yet completed.
   */
  public interface Status {
    /** Available. */
    String AVAILABLE = "Available";
    /** Completed. */
    String COMPLETED = "Completed";
    /** Failed. */
    String FAILED = "Failed";
    /** Processing. */
    String PROCESSING = "Processing";
  }

  @SerializedName("assistant_id")
  protected String assistantId;

  protected String status;

  @SerializedName("status_description")
  protected String statusDescription;

  @SerializedName("status_errors")
  protected List<StatusError> statusErrors;

  protected SkillsAsyncRequestStatus() {}

  /**
   * Gets the assistantId.
   *
   * <p>The assistant ID of the assistant.
   *
   * @return the assistantId
   */
  public String getAssistantId() {
    return assistantId;
  }

  /**
   * Gets the status.
   *
   * <p>The current status of the asynchronous operation: - `Available`: An asynchronous export is
   * available. - `Completed`: An asynchronous import operation has completed successfully. -
   * `Failed`: An asynchronous operation has failed. See the **status_errors** property for more
   * information about the cause of the failure. - `Processing`: An asynchronous operation has not
   * yet completed.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
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
}

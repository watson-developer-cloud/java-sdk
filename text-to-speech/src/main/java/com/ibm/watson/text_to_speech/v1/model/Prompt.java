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

package com.ibm.watson.text_to_speech.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Information about a custom prompt. */
public class Prompt extends GenericModel {

  protected String prompt;

  @SerializedName("prompt_id")
  protected String promptId;

  protected String status;
  protected String error;

  @SerializedName("speaker_id")
  protected String speakerId;

  protected Prompt() {}

  /**
   * Gets the prompt.
   *
   * <p>The user-specified text of the prompt.
   *
   * @return the prompt
   */
  public String getPrompt() {
    return prompt;
  }

  /**
   * Gets the promptId.
   *
   * <p>The user-specified identifier (name) of the prompt.
   *
   * @return the promptId
   */
  public String getPromptId() {
    return promptId;
  }

  /**
   * Gets the status.
   *
   * <p>The status of the prompt: * `processing`: The service received the request to add the prompt
   * and is analyzing the validity of the prompt. * `available`: The service successfully validated
   * the prompt, which is now ready for use in a speech synthesis request. * `failed`: The service's
   * validation of the prompt failed. The status of the prompt includes an `error` field that
   * describes the reason for the failure.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the error.
   *
   * <p>If the status of the prompt is `failed`, an error message that describes the reason for the
   * failure. The field is omitted if no error occurred.
   *
   * @return the error
   */
  public String getError() {
    return error;
  }

  /**
   * Gets the speakerId.
   *
   * <p>The speaker ID (GUID) of the speaker for which the prompt was defined. The field is omitted
   * if no speaker ID was specified.
   *
   * @return the speakerId
   */
  public String getSpeakerId() {
    return speakerId;
  }
}

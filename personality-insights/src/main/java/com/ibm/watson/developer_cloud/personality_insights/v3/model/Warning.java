/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.personality_insights.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Warning.
 */
public class Warning extends GenericModel {

  /**
   * The identifier of the warning message.
   */
  public interface WarningId {
    /** WORD_COUNT_MESSAGE. */
    String WORD_COUNT_MESSAGE = "WORD_COUNT_MESSAGE";
    /** JSON_AS_TEXT. */
    String JSON_AS_TEXT = "JSON_AS_TEXT";
    /** CONTENT_TRUNCATED. */
    String CONTENT_TRUNCATED = "CONTENT_TRUNCATED";
    /** PARTIAL_TEXT_USED. */
    String PARTIAL_TEXT_USED = "PARTIAL_TEXT_USED";
  }

  @SerializedName("warning_id")
  private String warningId;
  private String message;

  /**
   * Gets the warningId.
   *
   * The identifier of the warning message.
   *
   * @return the warningId
   */
  public String getWarningId() {
    return warningId;
  }

  /**
   * Gets the message.
   *
   * The message associated with the `warning_id`: * `WORD_COUNT_MESSAGE`: "There were {number} words in the input. We
   * need a minimum of 600, preferably 1,200 or more, to compute statistically significant estimates." * `JSON_AS_TEXT`:
   * "Request input was processed as text/plain as indicated, however detected a JSON input. Did you mean
   * application/json?" * `CONTENT_TRUNCATED`: "For maximum accuracy while also optimizing processing time, only the
   * first 250KB of input text (excluding markup) was analyzed. Accuracy levels off at approximately 3,000 words so this
   * did not affect the accuracy of the profile." * `PARTIAL_TEXT_USED`, "The text provided to compute the profile was
   * trimmed for performance reasons. This action does not affect the accuracy of the output, as not all of the input
   * text was required." Applies only when Arabic input text exceeds a threshold at which additional words do not
   * contribute to the accuracy of the profile.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets the warningId.
   *
   * @param warningId the new warningId
   */
  public void setWarningId(final String warningId) {
    this.warningId = warningId;
  }

  /**
   * Sets the message.
   *
   * @param message the new message
   */
  public void setMessage(final String message) {
    this.message = message;
  }
}

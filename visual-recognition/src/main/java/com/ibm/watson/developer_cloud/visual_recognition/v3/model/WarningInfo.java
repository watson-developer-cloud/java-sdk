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
package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Information about something that went wrong.
 */
public class WarningInfo extends GenericModel {

  @SerializedName("warning_id")
  private String warningId;
  private String description;

  /**
   * Gets the warningId.
   *
   * Codified warning string, such as `limit_reached`.
   *
   * @return the warningId
   */
  public String getWarningId() {
    return warningId;
  }

  /**
   * Gets the description.
   *
   * Information about the error.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
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
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(final String description) {
    this.description = description;
  }
}

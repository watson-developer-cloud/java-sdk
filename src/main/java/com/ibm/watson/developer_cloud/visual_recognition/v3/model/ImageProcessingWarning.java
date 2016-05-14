/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import com.google.gson.annotations.SerializedName;

/**
 * Image processing warning.
 */
public class ImageProcessingWarning {

  @SerializedName("warning_id")
  private String warningId;
  @SerializedName("description")
  private String description;

  /**
   * Gets the warning id.
   *
   * @return the warning id
   */
  public String getWarningId() {
    return warningId;
  }

  /**
   * Sets the warning id.
   *
   * @param warningId the new warning id
   */
  public void setWarningId(String warningId) {
    this.warningId = warningId;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(String description) {
    this.description = description;
  }

}

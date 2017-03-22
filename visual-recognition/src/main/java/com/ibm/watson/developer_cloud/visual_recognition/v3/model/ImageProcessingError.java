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

/**
 * Image processing error.
 */
public class ImageProcessingError {

  private String description;
  @SerializedName("error_id")
  private String errorId;

  /**
   * Gets the description.
   *
   * @return The description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the error id.
   *
   * @return The error identifier
   */
  public String getErrorId() {
    return errorId;
  }

  /**
   * Sets the description.
   *
   * @param description The description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Sets the error id.
   *
   * @param errorId The error identifier
   */
  public void setErrorId(String errorId) {
    this.errorId = errorId;
  }

}

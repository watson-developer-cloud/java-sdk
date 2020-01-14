/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.visual_recognition.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about what might have caused a failure, such as an image that is too large. Not returned when there is no
 * error.
 */
public class ErrorInfo extends GenericModel {

  protected Long code;
  protected String description;
  @SerializedName("error_id")
  protected String errorId;

  /**
   * Gets the code.
   *
   * HTTP status code.
   *
   * @return the code
   */
  public Long getCode() {
    return code;
  }

  /**
   * Gets the description.
   *
   * Human-readable error description. For example, `File size limit exceeded`.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the errorId.
   *
   * Codified error string. For example, `limit_exceeded`.
   *
   * @return the errorId
   */
  public String getErrorId() {
    return errorId;
  }
}

/*
 * (C) Copyright IBM Corp. 2019.
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
package com.ibm.watson.visual_recognition.v4.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Details about a problem.
 */
public class BaseError extends GenericModel {

  /**
   * Identifier of the problem.
   */
  public interface Code {
    /** invalid_field. */
    String INVALID_FIELD = "invalid_field";
    /** invalid_header. */
    String INVALID_HEADER = "invalid_header";
    /** invalid_method. */
    String INVALID_METHOD = "invalid_method";
    /** missing_field. */
    String MISSING_FIELD = "missing_field";
    /** server_error. */
    String SERVER_ERROR = "server_error";
  }

  private String code;
  private String message;
  @SerializedName("more_info")
  private String moreInfo;

  /**
   * Gets the code.
   *
   * Identifier of the problem.
   *
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * Gets the message.
   *
   * An explanation of the problem with possible solutions.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Gets the moreInfo.
   *
   * A URL for more information about the solution.
   *
   * @return the moreInfo
   */
  public String getMoreInfo() {
    return moreInfo;
  }
}

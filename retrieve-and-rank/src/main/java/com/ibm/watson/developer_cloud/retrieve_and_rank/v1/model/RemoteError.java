/**
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
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Error class for remote failures.
 *
 * Meant to copy Solr's error format.
 */
public class RemoteError extends GenericModel {
  @SerializedName(ApiConstants.ERROR_MESSAGE)
  private final String message;
  private final int code;

  /**
   * Instantiates a new remote error.
   *
   * @param message the message
   * @param code the code
   */
  public RemoteError(String message, int code) {
    this.message = message;
    this.code = code;
  }

  /**
   * Gets the message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Gets the code.
   *
   * @return the code
   */
  public int getCode() {
    return code;
  }

}

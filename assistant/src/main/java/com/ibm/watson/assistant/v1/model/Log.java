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
package com.ibm.watson.assistant.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Log. */
public class Log extends GenericModel {

  protected MessageRequest request;
  protected MessageResponse response;

  @SerializedName("log_id")
  protected String logId;

  @SerializedName("request_timestamp")
  protected String requestTimestamp;

  @SerializedName("response_timestamp")
  protected String responseTimestamp;

  @SerializedName("workspace_id")
  protected String workspaceId;

  protected String language;

  /**
   * Gets the request.
   *
   * <p>A request sent to the workspace, including the user input and context.
   *
   * @return the request
   */
  public MessageRequest getRequest() {
    return request;
  }

  /**
   * Gets the response.
   *
   * <p>The response sent by the workspace, including the output text, detected intents and
   * entities, and context.
   *
   * @return the response
   */
  public MessageResponse getResponse() {
    return response;
  }

  /**
   * Gets the logId.
   *
   * <p>A unique identifier for the logged event.
   *
   * @return the logId
   */
  public String getLogId() {
    return logId;
  }

  /**
   * Gets the requestTimestamp.
   *
   * <p>The timestamp for receipt of the message.
   *
   * @return the requestTimestamp
   */
  public String getRequestTimestamp() {
    return requestTimestamp;
  }

  /**
   * Gets the responseTimestamp.
   *
   * <p>The timestamp for the system response to the message.
   *
   * @return the responseTimestamp
   */
  public String getResponseTimestamp() {
    return responseTimestamp;
  }

  /**
   * Gets the workspaceId.
   *
   * <p>The unique identifier of the workspace where the request was made.
   *
   * @return the workspaceId
   */
  public String getWorkspaceId() {
    return workspaceId;
  }

  /**
   * Gets the language.
   *
   * <p>The language of the workspace where the message request was made.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }
}

/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * LogExport.
 */
public class LogExport extends GenericModel {

  private MessageRequest request;
  private MessageResponse response;
  @SerializedName("log_id")
  private String logId;
  @SerializedName("request_timestamp")
  private String requestTimestamp;
  @SerializedName("response_timestamp")
  private String responseTimestamp;
  @SerializedName("workspace_id")
  private String workspaceId;
  private String language;

  /**
   * Gets the request.
   *
   * A request formatted for the Conversation service.
   *
   * @return the request
   */
  public MessageRequest getRequest() {
    return request;
  }

  /**
   * Gets the response.
   *
   * A response from the Conversation service.
   *
   * @return the response
   */
  public MessageResponse getResponse() {
    return response;
  }

  /**
   * Gets the logId.
   *
   * A unique identifier for the logged message.
   *
   * @return the logId
   */
  public String getLogId() {
    return logId;
  }

  /**
   * Gets the requestTimestamp.
   *
   * The timestamp for receipt of the message.
   *
   * @return the requestTimestamp
   */
  public String getRequestTimestamp() {
    return requestTimestamp;
  }

  /**
   * Gets the responseTimestamp.
   *
   * The timestamp for the system response to the message.
   *
   * @return the responseTimestamp
   */
  public String getResponseTimestamp() {
    return responseTimestamp;
  }

  /**
   * Gets the workspaceId.
   *
   * The workspace ID.
   *
   * @return the workspaceId
   */
  public String getWorkspaceId() {
    return workspaceId;
  }

  /**
   * Gets the language.
   *
   * The language of the workspace where the message request was made.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }
}

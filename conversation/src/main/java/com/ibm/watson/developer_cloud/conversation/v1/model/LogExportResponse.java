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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * LogExportResponse.
 */
public class LogExportResponse extends GenericModel {

  private MessageRequest request;
  private MessageResponse response;
  /** A unique identifier for the logged message. */
  @SerializedName("log_id")
  private String logId;
  /** The timestamp for receipt of the message. */
  @SerializedName("request_timestamp")
  private String requestTimestamp;
  /** The timestamp for the system response to the message. */
  @SerializedName("response_timestamp")
  private String responseTimestamp;

  /**
   * Gets the request.
   *
   * @return the request
   */
  public MessageRequest getRequest() {
    return request;
  }

  /**
   * Gets the response.
   *
   * @return the response
   */
  public MessageResponse getResponse() {
    return response;
  }

  /**
   * Gets the logId.
   *
   * @return the logId
   */
  public String getLogId() {
    return logId;
  }

  /**
   * Gets the requestTimestamp.
   *
   * @return the requestTimestamp
   */
  public String getRequestTimestamp() {
    return requestTimestamp;
  }

  /**
   * Gets the responseTimestamp.
   *
   * @return the responseTimestamp
   */
  public String getResponseTimestamp() {
    return responseTimestamp;
  }

  /**
   * Sets the request.
   *
   * @param request the new request
   */
  public void setRequest(final MessageRequest request) {
    this.request = request;
  }

  /**
   * Sets the response.
   *
   * @param response the new response
   */
  public void setResponse(final MessageResponse response) {
    this.response = response;
  }

  /**
   * Sets the logId.
   *
   * @param logId the new logId
   */
  public void setLogId(final String logId) {
    this.logId = logId;
  }

  /**
   * Sets the requestTimestamp.
   *
   * @param requestTimestamp the new requestTimestamp
   */
  public void setRequestTimestamp(final String requestTimestamp) {
    this.requestTimestamp = requestTimestamp;
  }

  /**
   * Sets the responseTimestamp.
   *
   * @param responseTimestamp the new responseTimestamp
   */
  public void setResponseTimestamp(final String responseTimestamp) {
    this.responseTimestamp = responseTimestamp;
  }
}

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
package com.ibm.watson.assistant.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Log. */
public class Log extends GenericModel {

  @SerializedName("log_id")
  protected String logId;

  protected MessageRequest request;
  protected MessageResponse response;

  @SerializedName("assistant_id")
  protected String assistantId;

  @SerializedName("session_id")
  protected String sessionId;

  @SerializedName("skill_id")
  protected String skillId;

  protected String snapshot;

  @SerializedName("request_timestamp")
  protected String requestTimestamp;

  @SerializedName("response_timestamp")
  protected String responseTimestamp;

  protected String language;

  @SerializedName("customer_id")
  protected String customerId;

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
   * Gets the request.
   *
   * <p>A stateful message request formatted for the Watson Assistant service.
   *
   * @return the request
   */
  public MessageRequest getRequest() {
    return request;
  }

  /**
   * Gets the response.
   *
   * <p>A response from the Watson Assistant service.
   *
   * @return the response
   */
  public MessageResponse getResponse() {
    return response;
  }

  /**
   * Gets the assistantId.
   *
   * <p>Unique identifier of the assistant.
   *
   * @return the assistantId
   */
  public String getAssistantId() {
    return assistantId;
  }

  /**
   * Gets the sessionId.
   *
   * <p>The ID of the session the message was part of.
   *
   * @return the sessionId
   */
  public String getSessionId() {
    return sessionId;
  }

  /**
   * Gets the skillId.
   *
   * <p>The unique identifier of the skill that responded to the message.
   *
   * @return the skillId
   */
  public String getSkillId() {
    return skillId;
  }

  /**
   * Gets the snapshot.
   *
   * <p>The name of the snapshot (dialog skill version) that responded to the message (for example,
   * `draft`).
   *
   * @return the snapshot
   */
  public String getSnapshot() {
    return snapshot;
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
   * Gets the language.
   *
   * <p>The language of the assistant to which the message request was made.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the customerId.
   *
   * <p>The customer ID specified for the message, if any.
   *
   * @return the customerId
   */
  public String getCustomerId() {
    return customerId;
  }
}

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
package com.ibm.watson.developer_cloud.assistant.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Properties that are shared by all skills used by the assistant.
 */
public class MessageContextGlobalSystem extends GenericModel {

  private String timezone;
  @SerializedName("user_id")
  private String userId;
  @SerializedName("turn_count")
  private Long turnCount;

  /**
   * Gets the timezone.
   *
   * The user time zone. The assistant uses the time zone to correctly resolve relative time references.
   *
   * @return the timezone
   */
  public String getTimezone() {
    return timezone;
  }

  /**
   * Gets the userId.
   *
   * A string value that identifies the user who is interacting with the assistant. The client must provide a unique
   * identifier for each individual end user who accesses the application. For Plus and Premium plans, this user ID is
   * used to identify unique users for billing purposes. This string cannot contain carriage return, newline, or tab
   * characters.
   *
   * @return the userId
   */
  public String getUserId() {
    return userId;
  }

  /**
   * Gets the turnCount.
   *
   * A counter that is automatically incremented with each turn of the conversation. A value of 1 indicates that this is
   * the the first turn of a new conversation, which can affect the behavior of some skills.
   *
   * @return the turnCount
   */
  public Long getTurnCount() {
    return turnCount;
  }

  /**
   * Sets the timezone.
   *
   * @param timezone the new timezone
   */
  public void setTimezone(final String timezone) {
    this.timezone = timezone;
  }

  /**
   * Sets the userId.
   *
   * @param userId the new userId
   */
  public void setUserId(final String userId) {
    this.userId = userId;
  }

  /**
   * Sets the turnCount.
   *
   * @param turnCount the new turnCount
   */
  public void setTurnCount(final long turnCount) {
    this.turnCount = turnCount;
  }
}

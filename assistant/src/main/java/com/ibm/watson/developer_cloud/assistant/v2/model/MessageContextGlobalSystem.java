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
import com.ibm.watson.developer_cloud.service.model.GenericModel;

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
   * String value provided by the API client that should be unique per each distinct end user of the service powered by
   * Assistant.
   *
   * @return the userId
   */
  public String getUserId() {
    return userId;
  }

  /**
   * Gets the turnCount.
   *
   * This property is normally set by the Assistant which sets this to 1 during the first conversation turn and then
   * increments it by 1 with every subsequent turn. A turn count equal to 0 (or > 0) informs the Assistant that this is
   * (or is not) the first turn in a conversation which influences the behavior of some skills. The Conversation skill
   * uses this to evaluate its `welcome` and `conversation_start` conditions.
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

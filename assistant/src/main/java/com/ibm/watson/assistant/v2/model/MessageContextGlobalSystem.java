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

/**
 * Built-in system properties that apply to all skills used by the assistant.
 */
public class MessageContextGlobalSystem extends GenericModel {

  protected String timezone;
  @SerializedName("user_id")
  protected String userId;
  @SerializedName("turn_count")
  protected Long turnCount;

  /**
   * Builder.
   */
  public static class Builder {
    private String timezone;
    private String userId;
    private Long turnCount;

    private Builder(MessageContextGlobalSystem messageContextGlobalSystem) {
      this.timezone = messageContextGlobalSystem.timezone;
      this.userId = messageContextGlobalSystem.userId;
      this.turnCount = messageContextGlobalSystem.turnCount;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a MessageContextGlobalSystem.
     *
     * @return the messageContextGlobalSystem
     */
    public MessageContextGlobalSystem build() {
      return new MessageContextGlobalSystem(this);
    }

    /**
     * Set the timezone.
     *
     * @param timezone the timezone
     * @return the MessageContextGlobalSystem builder
     */
    public Builder timezone(String timezone) {
      this.timezone = timezone;
      return this;
    }

    /**
     * Set the userId.
     *
     * @param userId the userId
     * @return the MessageContextGlobalSystem builder
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }

    /**
     * Set the turnCount.
     *
     * @param turnCount the turnCount
     * @return the MessageContextGlobalSystem builder
     */
    public Builder turnCount(long turnCount) {
      this.turnCount = turnCount;
      return this;
    }
  }

  protected MessageContextGlobalSystem(Builder builder) {
    timezone = builder.timezone;
    userId = builder.userId;
    turnCount = builder.turnCount;
  }

  /**
   * New builder.
   *
   * @return a MessageContextGlobalSystem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the timezone.
   *
   * The user time zone. The assistant uses the time zone to correctly resolve relative time references.
   *
   * @return the timezone
   */
  public String timezone() {
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
  public String userId() {
    return userId;
  }

  /**
   * Gets the turnCount.
   *
   * A counter that is automatically incremented with each turn of the conversation. A value of 1 indicates that this is
   * the the first turn of a new conversation, which can affect the behavior of some skills (for example, triggering the
   * start node of a dialog).
   *
   * @return the turnCount
   */
  public Long turnCount() {
    return turnCount;
  }
}

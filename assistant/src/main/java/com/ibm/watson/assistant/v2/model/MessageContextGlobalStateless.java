/*
 * (C) Copyright IBM Corp. 2020, 2022.
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

/** Session context data that is shared by all skills used by the assistant. */
public class MessageContextGlobalStateless extends GenericModel {

  protected MessageContextGlobalSystem system;

  @SerializedName("session_id")
  protected String sessionId;

  /** Builder. */
  public static class Builder {
    private MessageContextGlobalSystem system;
    private String sessionId;

    private Builder(MessageContextGlobalStateless messageContextGlobalStateless) {
      this.system = messageContextGlobalStateless.system;
      this.sessionId = messageContextGlobalStateless.sessionId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a MessageContextGlobalStateless.
     *
     * @return the new MessageContextGlobalStateless instance
     */
    public MessageContextGlobalStateless build() {
      return new MessageContextGlobalStateless(this);
    }

    /**
     * Set the system.
     *
     * @param system the system
     * @return the MessageContextGlobalStateless builder
     */
    public Builder system(MessageContextGlobalSystem system) {
      this.system = system;
      return this;
    }

    /**
     * Set the sessionId.
     *
     * @param sessionId the sessionId
     * @return the MessageContextGlobalStateless builder
     */
    public Builder sessionId(String sessionId) {
      this.sessionId = sessionId;
      return this;
    }
  }

  protected MessageContextGlobalStateless() {}

  protected MessageContextGlobalStateless(Builder builder) {
    system = builder.system;
    sessionId = builder.sessionId;
  }

  /**
   * New builder.
   *
   * @return a MessageContextGlobalStateless builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the system.
   *
   * <p>Built-in system properties that apply to all skills used by the assistant.
   *
   * @return the system
   */
  public MessageContextGlobalSystem system() {
    return system;
  }

  /**
   * Gets the sessionId.
   *
   * <p>The unique identifier of the session.
   *
   * @return the sessionId
   */
  public String sessionId() {
    return sessionId;
  }
}

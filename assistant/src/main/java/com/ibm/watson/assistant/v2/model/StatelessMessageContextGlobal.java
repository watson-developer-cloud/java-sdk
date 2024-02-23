/*
 * (C) Copyright IBM Corp. 2024.
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
public class StatelessMessageContextGlobal extends GenericModel {

  protected MessageContextGlobalSystem system;

  @SerializedName("session_id")
  protected String sessionId;

  /** Builder. */
  public static class Builder {
    private MessageContextGlobalSystem system;
    private String sessionId;

    /**
     * Instantiates a new Builder from an existing StatelessMessageContextGlobal instance.
     *
     * @param statelessMessageContextGlobal the instance to initialize the Builder with
     */
    private Builder(StatelessMessageContextGlobal statelessMessageContextGlobal) {
      this.system = statelessMessageContextGlobal.system;
      this.sessionId = statelessMessageContextGlobal.sessionId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a StatelessMessageContextGlobal.
     *
     * @return the new StatelessMessageContextGlobal instance
     */
    public StatelessMessageContextGlobal build() {
      return new StatelessMessageContextGlobal(this);
    }

    /**
     * Set the system.
     *
     * @param system the system
     * @return the StatelessMessageContextGlobal builder
     */
    public Builder system(MessageContextGlobalSystem system) {
      this.system = system;
      return this;
    }

    /**
     * Set the sessionId.
     *
     * @param sessionId the sessionId
     * @return the StatelessMessageContextGlobal builder
     */
    public Builder sessionId(String sessionId) {
      this.sessionId = sessionId;
      return this;
    }
  }

  protected StatelessMessageContextGlobal() {}

  protected StatelessMessageContextGlobal(Builder builder) {
    system = builder.system;
    sessionId = builder.sessionId;
  }

  /**
   * New builder.
   *
   * @return a StatelessMessageContextGlobal builder
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

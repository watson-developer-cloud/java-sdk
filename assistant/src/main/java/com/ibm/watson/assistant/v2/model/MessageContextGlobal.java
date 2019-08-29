/*
 * (C) Copyright IBM Corp. 2019.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information that is shared by all skills used by the Assistant.
 */
public class MessageContextGlobal extends GenericModel {

  private MessageContextGlobalSystem system;

  /**
   * Builder.
   */
  public static class Builder {
    private MessageContextGlobalSystem system;

    private Builder(MessageContextGlobal messageContextGlobal) {
      this.system = messageContextGlobal.system;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a MessageContextGlobal.
     *
     * @return the messageContextGlobal
     */
    public MessageContextGlobal build() {
      return new MessageContextGlobal(this);
    }

    /**
     * Set the system.
     *
     * @param system the system
     * @return the MessageContextGlobal builder
     */
    public Builder system(MessageContextGlobalSystem system) {
      this.system = system;
      return this;
    }
  }

  private MessageContextGlobal(Builder builder) {
    system = builder.system;
  }

  /**
   * New builder.
   *
   * @return a MessageContextGlobal builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the system.
   *
   * Built-in system properties that apply to all skills used by the assistant.
   *
   * @return the system
   */
  public MessageContextGlobalSystem system() {
    return system;
  }
}

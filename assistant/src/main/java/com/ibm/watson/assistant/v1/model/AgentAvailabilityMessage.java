/*
 * (C) Copyright IBM Corp. 2020, 2023.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** AgentAvailabilityMessage. */
public class AgentAvailabilityMessage extends GenericModel {

  protected String message;

  /** Builder. */
  public static class Builder {
    private String message;

    /**
     * Instantiates a new Builder from an existing AgentAvailabilityMessage instance.
     *
     * @param agentAvailabilityMessage the instance to initialize the Builder with
     */
    private Builder(AgentAvailabilityMessage agentAvailabilityMessage) {
      this.message = agentAvailabilityMessage.message;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a AgentAvailabilityMessage.
     *
     * @return the new AgentAvailabilityMessage instance
     */
    public AgentAvailabilityMessage build() {
      return new AgentAvailabilityMessage(this);
    }

    /**
     * Set the message.
     *
     * @param message the message
     * @return the AgentAvailabilityMessage builder
     */
    public Builder message(String message) {
      this.message = message;
      return this;
    }
  }

  protected AgentAvailabilityMessage() {}

  protected AgentAvailabilityMessage(Builder builder) {
    message = builder.message;
  }

  /**
   * New builder.
   *
   * @return a AgentAvailabilityMessage builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the message.
   *
   * <p>The text of the message.
   *
   * @return the message
   */
  public String message() {
    return message;
  }
}

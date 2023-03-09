/*
 * (C) Copyright IBM Corp. 2018, 2023.
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
import java.util.Map;

/** MessageContext. */
public class MessageContext extends GenericModel {

  protected MessageContextGlobal global;
  protected MessageContextSkills skills;
  protected Map<String, Object> integrations;

  /** Builder. */
  public static class Builder {
    private MessageContextGlobal global;
    private MessageContextSkills skills;
    private Map<String, Object> integrations;

    /**
     * Instantiates a new Builder from an existing MessageContext instance.
     *
     * @param messageContext the instance to initialize the Builder with
     */
    private Builder(MessageContext messageContext) {
      this.global = messageContext.global;
      this.skills = messageContext.skills;
      this.integrations = messageContext.integrations;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a MessageContext.
     *
     * @return the new MessageContext instance
     */
    public MessageContext build() {
      return new MessageContext(this);
    }

    /**
     * Set the global.
     *
     * @param global the global
     * @return the MessageContext builder
     */
    public Builder global(MessageContextGlobal global) {
      this.global = global;
      return this;
    }

    /**
     * Set the skills.
     *
     * @param skills the skills
     * @return the MessageContext builder
     */
    public Builder skills(MessageContextSkills skills) {
      this.skills = skills;
      return this;
    }

    /**
     * Set the integrations.
     *
     * @param integrations the integrations
     * @return the MessageContext builder
     */
    public Builder integrations(Map<String, Object> integrations) {
      this.integrations = integrations;
      return this;
    }
  }

  protected MessageContext() {}

  protected MessageContext(Builder builder) {
    global = builder.global;
    skills = builder.skills;
    integrations = builder.integrations;
  }

  /**
   * New builder.
   *
   * @return a MessageContext builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the global.
   *
   * <p>Session context data that is shared by all skills used by the assistant.
   *
   * @return the global
   */
  public MessageContextGlobal global() {
    return global;
  }

  /**
   * Gets the skills.
   *
   * <p>Context data specific to particular skills used by the assistant.
   *
   * @return the skills
   */
  public MessageContextSkills skills() {
    return skills;
  }

  /**
   * Gets the integrations.
   *
   * <p>An object containing context data that is specific to particular integrations. For more
   * information, see the
   * [documentation](https://cloud.ibm.com/docs/assistant?topic=assistant-dialog-integrations).
   *
   * @return the integrations
   */
  public Map<String, Object> integrations() {
    return integrations;
  }
}

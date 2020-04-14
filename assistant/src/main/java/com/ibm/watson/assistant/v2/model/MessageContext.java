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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** MessageContext. */
public class MessageContext extends GenericModel {

  protected MessageContextGlobal global;
  protected MessageContextSkills skills;

  /** Builder. */
  public static class Builder {
    private MessageContextGlobal global;
    private MessageContextSkills skills;

    private Builder(MessageContext messageContext) {
      this.global = messageContext.global;
      this.skills = messageContext.skills;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a MessageContext.
     *
     * @return the messageContext
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
  }

  protected MessageContext(Builder builder) {
    global = builder.global;
    skills = builder.skills;
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
   * <p>Information that is shared by all skills used by the Assistant.
   *
   * @return the global
   */
  public MessageContextGlobal global() {
    return global;
  }

  /**
   * Gets the skills.
   *
   * <p>Information specific to particular skills used by the Assistant.
   *
   * <p>**Note:** Currently, only a single property named `main skill` is supported. This object
   * contains variables that apply to the dialog skill used by the assistant.
   *
   * @return the skills
   */
  public MessageContextSkills skills() {
    return skills;
  }
}

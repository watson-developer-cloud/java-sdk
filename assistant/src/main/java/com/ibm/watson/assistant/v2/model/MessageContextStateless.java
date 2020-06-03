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

/** MessageContextStateless. */
public class MessageContextStateless extends GenericModel {

  protected MessageContextGlobalStateless global;
  protected MessageContextSkills skills;

  /** Builder. */
  public static class Builder {
    private MessageContextGlobalStateless global;
    private MessageContextSkills skills;

    private Builder(MessageContextStateless messageContextStateless) {
      this.global = messageContextStateless.global;
      this.skills = messageContextStateless.skills;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a MessageContextStateless.
     *
     * @return the messageContextStateless
     */
    public MessageContextStateless build() {
      return new MessageContextStateless(this);
    }

    /**
     * Set the global.
     *
     * @param global the global
     * @return the MessageContextStateless builder
     */
    public Builder global(MessageContextGlobalStateless global) {
      this.global = global;
      return this;
    }

    /**
     * Set the skills.
     *
     * @param skills the skills
     * @return the MessageContextStateless builder
     */
    public Builder skills(MessageContextSkills skills) {
      this.skills = skills;
      return this;
    }
  }

  protected MessageContextStateless(Builder builder) {
    global = builder.global;
    skills = builder.skills;
  }

  /**
   * New builder.
   *
   * @return a MessageContextStateless builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the global.
   *
   * <p>Session context data that is shared by all skills used by the Assistant.
   *
   * @return the global
   */
  public MessageContextGlobalStateless global() {
    return global;
  }

  /**
   * Gets the skills.
   *
   * <p>Information specific to particular skills used by the assistant.
   *
   * <p>**Note:** Currently, only a single child property is supported, containing variables that
   * apply to the dialog skill used by the assistant.
   *
   * @return the skills
   */
  public MessageContextSkills skills() {
    return skills;
  }
}

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
import java.util.Map;

/**
 * Contains information specific to a particular skill used by the Assistant. The property name must
 * be the same as the name of the skill (for example, `main skill`).
 */
public class MessageContextSkill extends GenericModel {

  @SerializedName("user_defined")
  protected Map<String, Object> userDefined;

  protected MessageContextSkillSystem system;

  /** Builder. */
  public static class Builder {
    private Map<String, Object> userDefined;
    private MessageContextSkillSystem system;

    private Builder(MessageContextSkill messageContextSkill) {
      this.userDefined = messageContextSkill.userDefined;
      this.system = messageContextSkill.system;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a MessageContextSkill.
     *
     * @return the messageContextSkill
     */
    public MessageContextSkill build() {
      return new MessageContextSkill(this);
    }

    /**
     * Set the userDefined.
     *
     * @param userDefined the userDefined
     * @return the MessageContextSkill builder
     */
    public Builder userDefined(Map<String, Object> userDefined) {
      this.userDefined = userDefined;
      return this;
    }

    /**
     * Set the system.
     *
     * @param system the system
     * @return the MessageContextSkill builder
     */
    public Builder system(MessageContextSkillSystem system) {
      this.system = system;
      return this;
    }
  }

  protected MessageContextSkill(Builder builder) {
    userDefined = builder.userDefined;
    system = builder.system;
  }

  /**
   * New builder.
   *
   * @return a MessageContextSkill builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the userDefined.
   *
   * <p>Arbitrary variables that can be read and written by a particular skill.
   *
   * @return the userDefined
   */
  public Map<String, Object> userDefined() {
    return userDefined;
  }

  /**
   * Gets the system.
   *
   * <p>System context data used by the skill.
   *
   * @return the system
   */
  public MessageContextSkillSystem system() {
    return system;
  }
}

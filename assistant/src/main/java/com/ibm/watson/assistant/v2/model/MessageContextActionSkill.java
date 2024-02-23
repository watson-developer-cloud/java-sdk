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
import java.util.Map;

/**
 * Context variables that are used by the action skill. Private variables are persisted, but not
 * shown.
 */
public class MessageContextActionSkill extends GenericModel {

  @SerializedName("user_defined")
  protected Map<String, Object> userDefined;

  protected MessageContextSkillSystem system;

  @SerializedName("action_variables")
  protected Map<String, Object> actionVariables;

  @SerializedName("skill_variables")
  protected Map<String, Object> skillVariables;

  /** Builder. */
  public static class Builder {
    private Map<String, Object> userDefined;
    private MessageContextSkillSystem system;
    private Map<String, Object> actionVariables;
    private Map<String, Object> skillVariables;

    /**
     * Instantiates a new Builder from an existing MessageContextActionSkill instance.
     *
     * @param messageContextActionSkill the instance to initialize the Builder with
     */
    private Builder(MessageContextActionSkill messageContextActionSkill) {
      this.userDefined = messageContextActionSkill.userDefined;
      this.system = messageContextActionSkill.system;
      this.actionVariables = messageContextActionSkill.actionVariables;
      this.skillVariables = messageContextActionSkill.skillVariables;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a MessageContextActionSkill.
     *
     * @return the new MessageContextActionSkill instance
     */
    public MessageContextActionSkill build() {
      return new MessageContextActionSkill(this);
    }

    /**
     * Set the userDefined.
     *
     * @param userDefined the userDefined
     * @return the MessageContextActionSkill builder
     */
    public Builder userDefined(Map<String, Object> userDefined) {
      this.userDefined = userDefined;
      return this;
    }

    /**
     * Set the system.
     *
     * @param system the system
     * @return the MessageContextActionSkill builder
     */
    public Builder system(MessageContextSkillSystem system) {
      this.system = system;
      return this;
    }

    /**
     * Set the actionVariables.
     *
     * @param actionVariables the actionVariables
     * @return the MessageContextActionSkill builder
     */
    public Builder actionVariables(Map<String, Object> actionVariables) {
      this.actionVariables = actionVariables;
      return this;
    }

    /**
     * Set the skillVariables.
     *
     * @param skillVariables the skillVariables
     * @return the MessageContextActionSkill builder
     */
    public Builder skillVariables(Map<String, Object> skillVariables) {
      this.skillVariables = skillVariables;
      return this;
    }
  }

  protected MessageContextActionSkill() {}

  protected MessageContextActionSkill(Builder builder) {
    userDefined = builder.userDefined;
    system = builder.system;
    actionVariables = builder.actionVariables;
    skillVariables = builder.skillVariables;
  }

  /**
   * New builder.
   *
   * @return a MessageContextActionSkill builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the userDefined.
   *
   * <p>An object containing any arbitrary variables that can be read and written by a particular
   * skill.
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

  /**
   * Gets the actionVariables.
   *
   * <p>An object containing action variables. Action variables can be accessed only by steps in the
   * same action, and do not persist after the action ends.
   *
   * @return the actionVariables
   */
  public Map<String, Object> actionVariables() {
    return actionVariables;
  }

  /**
   * Gets the skillVariables.
   *
   * <p>An object containing skill variables. (In the watsonx Assistant user interface, skill
   * variables are called _session variables_.) Skill variables can be accessed by any action and
   * persist for the duration of the session.
   *
   * @return the skillVariables
   */
  public Map<String, Object> skillVariables() {
    return skillVariables;
  }
}

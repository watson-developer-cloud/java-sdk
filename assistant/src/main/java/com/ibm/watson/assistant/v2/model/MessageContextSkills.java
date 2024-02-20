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

/** Context data specific to particular skills used by the assistant. */
public class MessageContextSkills extends GenericModel {

  @SerializedName("main skill")
  protected MessageContextSkillDialog mainSkill;

  @SerializedName("actions skill")
  protected MessageContextSkillAction actionsSkill;

  /** Builder. */
  public static class Builder {
    private MessageContextSkillDialog mainSkill;
    private MessageContextSkillAction actionsSkill;

    /**
     * Instantiates a new Builder from an existing MessageContextSkills instance.
     *
     * @param messageContextSkills the instance to initialize the Builder with
     */
    private Builder(MessageContextSkills messageContextSkills) {
      this.mainSkill = messageContextSkills.mainSkill;
      this.actionsSkill = messageContextSkills.actionsSkill;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a MessageContextSkills.
     *
     * @return the new MessageContextSkills instance
     */
    public MessageContextSkills build() {
      return new MessageContextSkills(this);
    }

    /**
     * Set the mainSkill.
     *
     * @param mainSkill the mainSkill
     * @return the MessageContextSkills builder
     */
    public Builder mainSkill(MessageContextSkillDialog mainSkill) {
      this.mainSkill = mainSkill;
      return this;
    }

    /**
     * Set the actionsSkill.
     *
     * @param actionsSkill the actionsSkill
     * @return the MessageContextSkills builder
     */
    public Builder actionsSkill(MessageContextSkillAction actionsSkill) {
      this.actionsSkill = actionsSkill;
      return this;
    }
  }

  protected MessageContextSkills() {}

  protected MessageContextSkills(Builder builder) {
    mainSkill = builder.mainSkill;
    actionsSkill = builder.actionsSkill;
  }

  /**
   * New builder.
   *
   * @return a MessageContextSkills builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the mainSkill.
   *
   * <p>Context variables that are used by the dialog skill.
   *
   * @return the mainSkill
   */
  public MessageContextSkillDialog mainSkill() {
    return mainSkill;
  }

  /**
   * Gets the actionsSkill.
   *
   * <p>Context variables that are used by the action skill. Private variables are persisted, but
   * not shown.
   *
   * @return the actionsSkill
   */
  public MessageContextSkillAction actionsSkill() {
    return actionsSkill;
  }
}

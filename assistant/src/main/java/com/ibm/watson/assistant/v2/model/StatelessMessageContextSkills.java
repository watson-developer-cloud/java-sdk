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
public class StatelessMessageContextSkills extends GenericModel {

  @SerializedName("main skill")
  protected MessageContextDialogSkill mainSkill;

  @SerializedName("actions skill")
  protected StatelessMessageContextSkillsActionsSkill actionsSkill;

  /** Builder. */
  public static class Builder {
    private MessageContextDialogSkill mainSkill;
    private StatelessMessageContextSkillsActionsSkill actionsSkill;

    /**
     * Instantiates a new Builder from an existing StatelessMessageContextSkills instance.
     *
     * @param statelessMessageContextSkills the instance to initialize the Builder with
     */
    private Builder(StatelessMessageContextSkills statelessMessageContextSkills) {
      this.mainSkill = statelessMessageContextSkills.mainSkill;
      this.actionsSkill = statelessMessageContextSkills.actionsSkill;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a StatelessMessageContextSkills.
     *
     * @return the new StatelessMessageContextSkills instance
     */
    public StatelessMessageContextSkills build() {
      return new StatelessMessageContextSkills(this);
    }

    /**
     * Set the mainSkill.
     *
     * @param mainSkill the mainSkill
     * @return the StatelessMessageContextSkills builder
     */
    public Builder mainSkill(MessageContextDialogSkill mainSkill) {
      this.mainSkill = mainSkill;
      return this;
    }

    /**
     * Set the actionsSkill.
     *
     * @param actionsSkill the actionsSkill
     * @return the StatelessMessageContextSkills builder
     */
    public Builder actionsSkill(StatelessMessageContextSkillsActionsSkill actionsSkill) {
      this.actionsSkill = actionsSkill;
      return this;
    }
  }

  protected StatelessMessageContextSkills() {}

  protected StatelessMessageContextSkills(Builder builder) {
    mainSkill = builder.mainSkill;
    actionsSkill = builder.actionsSkill;
  }

  /**
   * New builder.
   *
   * @return a StatelessMessageContextSkills builder
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
  public MessageContextDialogSkill mainSkill() {
    return mainSkill;
  }

  /**
   * Gets the actionsSkill.
   *
   * <p>Context variables that are used by the action skill.
   *
   * @return the actionsSkill
   */
  public StatelessMessageContextSkillsActionsSkill actionsSkill() {
    return actionsSkill;
  }
}

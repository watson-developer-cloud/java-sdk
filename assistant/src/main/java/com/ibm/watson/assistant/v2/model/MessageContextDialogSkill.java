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

/** Context variables that are used by the dialog skill. */
public class MessageContextDialogSkill extends GenericModel {

  @SerializedName("user_defined")
  protected Map<String, Object> userDefined;

  protected MessageContextSkillSystem system;

  /** Builder. */
  public static class Builder {
    private Map<String, Object> userDefined;
    private MessageContextSkillSystem system;

    /**
     * Instantiates a new Builder from an existing MessageContextDialogSkill instance.
     *
     * @param messageContextDialogSkill the instance to initialize the Builder with
     */
    private Builder(MessageContextDialogSkill messageContextDialogSkill) {
      this.userDefined = messageContextDialogSkill.userDefined;
      this.system = messageContextDialogSkill.system;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a MessageContextDialogSkill.
     *
     * @return the new MessageContextDialogSkill instance
     */
    public MessageContextDialogSkill build() {
      return new MessageContextDialogSkill(this);
    }

    /**
     * Set the userDefined.
     *
     * @param userDefined the userDefined
     * @return the MessageContextDialogSkill builder
     */
    public Builder userDefined(Map<String, Object> userDefined) {
      this.userDefined = userDefined;
      return this;
    }

    /**
     * Set the system.
     *
     * @param system the system
     * @return the MessageContextDialogSkill builder
     */
    public Builder system(MessageContextSkillSystem system) {
      this.system = system;
      return this;
    }
  }

  protected MessageContextDialogSkill() {}

  protected MessageContextDialogSkill(Builder builder) {
    userDefined = builder.userDefined;
    system = builder.system;
  }

  /**
   * New builder.
   *
   * @return a MessageContextDialogSkill builder
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
}

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

/** AssistantSkill. */
public class AssistantSkill extends GenericModel {

  /** The type of the skill. */
  public interface Type {
    /** dialog. */
    String DIALOG = "dialog";
    /** action. */
    String ACTION = "action";
    /** search. */
    String SEARCH = "search";
  }

  @SerializedName("skill_id")
  protected String skillId;

  protected String type;

  /** Builder. */
  public static class Builder {
    private String skillId;
    private String type;

    /**
     * Instantiates a new Builder from an existing AssistantSkill instance.
     *
     * @param assistantSkill the instance to initialize the Builder with
     */
    private Builder(AssistantSkill assistantSkill) {
      this.skillId = assistantSkill.skillId;
      this.type = assistantSkill.type;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param skillId the skillId
     */
    public Builder(String skillId) {
      this.skillId = skillId;
    }

    /**
     * Builds a AssistantSkill.
     *
     * @return the new AssistantSkill instance
     */
    public AssistantSkill build() {
      return new AssistantSkill(this);
    }

    /**
     * Set the skillId.
     *
     * @param skillId the skillId
     * @return the AssistantSkill builder
     */
    public Builder skillId(String skillId) {
      this.skillId = skillId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the AssistantSkill builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }
  }

  protected AssistantSkill() {}

  protected AssistantSkill(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.skillId, "skillId cannot be null");
    skillId = builder.skillId;
    type = builder.type;
  }

  /**
   * New builder.
   *
   * @return a AssistantSkill builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the skillId.
   *
   * <p>The skill ID of the skill.
   *
   * @return the skillId
   */
  public String skillId() {
    return skillId;
  }

  /**
   * Gets the type.
   *
   * <p>The type of the skill.
   *
   * @return the type
   */
  public String type() {
    return type;
  }
}

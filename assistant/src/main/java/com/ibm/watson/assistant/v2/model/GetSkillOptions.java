/*
 * (C) Copyright IBM Corp. 2023, 2025.
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

/** The getSkill options. */
public class GetSkillOptions extends GenericModel {

  protected String assistantId;
  protected String skillId;

  /** Builder. */
  public static class Builder {
    private String assistantId;
    private String skillId;

    /**
     * Instantiates a new Builder from an existing GetSkillOptions instance.
     *
     * @param getSkillOptions the instance to initialize the Builder with
     */
    private Builder(GetSkillOptions getSkillOptions) {
      this.assistantId = getSkillOptions.assistantId;
      this.skillId = getSkillOptions.skillId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param assistantId the assistantId
     * @param skillId the skillId
     */
    public Builder(String assistantId, String skillId) {
      this.assistantId = assistantId;
      this.skillId = skillId;
    }

    /**
     * Builds a GetSkillOptions.
     *
     * @return the new GetSkillOptions instance
     */
    public GetSkillOptions build() {
      return new GetSkillOptions(this);
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the GetSkillOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }

    /**
     * Set the skillId.
     *
     * @param skillId the skillId
     * @return the GetSkillOptions builder
     */
    public Builder skillId(String skillId) {
      this.skillId = skillId;
      return this;
    }
  }

  protected GetSkillOptions() {}

  protected GetSkillOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.assistantId, "assistantId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.skillId, "skillId cannot be empty");
    assistantId = builder.assistantId;
    skillId = builder.skillId;
  }

  /**
   * New builder.
   *
   * @return a GetSkillOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assistantId.
   *
   * <p>Unique identifier of the assistant. To get the **assistant ID** in the watsonx Assistant
   * interface, open the **Assistant settings** page, and scroll to the **Assistant IDs and API
   * details** section and click **View Details**.
   *
   * @return the assistantId
   */
  public String assistantId() {
    return assistantId;
  }

  /**
   * Gets the skillId.
   *
   * <p>Unique identifier of the skill. To find the action or dialog skill ID in the watsonx
   * Assistant user interface, open the skill settings and click **API Details**. To find the search
   * skill ID, use the Get environment API to retrieve the skill references for an environment and
   * it will include the search skill info, if available.
   *
   * @return the skillId
   */
  public String skillId() {
    return skillId;
  }
}

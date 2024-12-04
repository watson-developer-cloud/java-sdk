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
   * <p>The assistant ID or the environment ID of the environment where the assistant is deployed,
   * depending on the type of request: - For message, session, and log requests, specify the
   * environment ID of the environment where the assistant is deployed. - For all other requests,
   * specify the assistant ID of the assistant.
   *
   * <p>To find the environment ID or assistant ID in the watsonx Assistant user interface, open the
   * assistant settings and scroll to the **Environments** section.
   *
   * <p>**Note:** If you are using the classic Watson Assistant experience, always use the assistant
   * ID. To find the assistant ID in the user interface, open the assistant settings and click API
   * Details.
   *
   * @return the assistantId
   */
  public String assistantId() {
    return assistantId;
  }

  /**
   * Gets the skillId.
   *
   * <p>Unique identifier of the skill. To find the skill ID in the watsonx Assistant user
   * interface, open the skill settings and click **API Details**.
   *
   * @return the skillId
   */
  public String skillId() {
    return skillId;
  }
}

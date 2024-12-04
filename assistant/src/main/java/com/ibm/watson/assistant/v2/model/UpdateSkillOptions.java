/*
 * (C) Copyright IBM Corp. 2023, 2024.
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
import java.util.Map;

/** The updateSkill options. */
public class UpdateSkillOptions extends GenericModel {

  protected String assistantId;
  protected String skillId;
  protected String name;
  protected String description;
  protected Map<String, Object> workspace;
  protected Map<String, Object> dialogSettings;
  protected SearchSettings searchSettings;

  /** Builder. */
  public static class Builder {
    private String assistantId;
    private String skillId;
    private String name;
    private String description;
    private Map<String, Object> workspace;
    private Map<String, Object> dialogSettings;
    private SearchSettings searchSettings;

    /**
     * Instantiates a new Builder from an existing UpdateSkillOptions instance.
     *
     * @param updateSkillOptions the instance to initialize the Builder with
     */
    private Builder(UpdateSkillOptions updateSkillOptions) {
      this.assistantId = updateSkillOptions.assistantId;
      this.skillId = updateSkillOptions.skillId;
      this.name = updateSkillOptions.name;
      this.description = updateSkillOptions.description;
      this.workspace = updateSkillOptions.workspace;
      this.dialogSettings = updateSkillOptions.dialogSettings;
      this.searchSettings = updateSkillOptions.searchSettings;
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
     * Builds a UpdateSkillOptions.
     *
     * @return the new UpdateSkillOptions instance
     */
    public UpdateSkillOptions build() {
      return new UpdateSkillOptions(this);
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the UpdateSkillOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }

    /**
     * Set the skillId.
     *
     * @param skillId the skillId
     * @return the UpdateSkillOptions builder
     */
    public Builder skillId(String skillId) {
      this.skillId = skillId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateSkillOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateSkillOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the workspace.
     *
     * @param workspace the workspace
     * @return the UpdateSkillOptions builder
     */
    public Builder workspace(Map<String, Object> workspace) {
      this.workspace = workspace;
      return this;
    }

    /**
     * Set the dialogSettings.
     *
     * @param dialogSettings the dialogSettings
     * @return the UpdateSkillOptions builder
     */
    public Builder dialogSettings(Map<String, Object> dialogSettings) {
      this.dialogSettings = dialogSettings;
      return this;
    }

    /**
     * Set the searchSettings.
     *
     * @param searchSettings the searchSettings
     * @return the UpdateSkillOptions builder
     */
    public Builder searchSettings(SearchSettings searchSettings) {
      this.searchSettings = searchSettings;
      return this;
    }
  }

  protected UpdateSkillOptions() {}

  protected UpdateSkillOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.assistantId, "assistantId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.skillId, "skillId cannot be empty");
    assistantId = builder.assistantId;
    skillId = builder.skillId;
    name = builder.name;
    description = builder.description;
    workspace = builder.workspace;
    dialogSettings = builder.dialogSettings;
    searchSettings = builder.searchSettings;
  }

  /**
   * New builder.
   *
   * @return a UpdateSkillOptions builder
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

  /**
   * Gets the name.
   *
   * <p>The name of the skill. This string cannot contain carriage return, newline, or tab
   * characters.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>The description of the skill. This string cannot contain carriage return, newline, or tab
   * characters.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the workspace.
   *
   * <p>An object containing the conversational content of an action or dialog skill.
   *
   * @return the workspace
   */
  public Map<String, Object> workspace() {
    return workspace;
  }

  /**
   * Gets the dialogSettings.
   *
   * <p>For internal use only.
   *
   * @return the dialogSettings
   */
  public Map<String, Object> dialogSettings() {
    return dialogSettings;
  }

  /**
   * Gets the searchSettings.
   *
   * <p>An object describing the search skill configuration.
   *
   * <p>**Note:** Search settings are not supported in **Import skills** requests, and are not
   * included in **Export skills** responses.
   *
   * @return the searchSettings
   */
  public SearchSettings searchSettings() {
    return searchSettings;
  }
}

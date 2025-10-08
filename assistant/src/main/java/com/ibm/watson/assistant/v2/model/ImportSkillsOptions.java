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
import java.util.ArrayList;
import java.util.List;

/** The importSkills options. */
public class ImportSkillsOptions extends GenericModel {

  protected String assistantId;
  protected List<SkillImport> assistantSkills;
  protected AssistantState assistantState;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String assistantId;
    private List<SkillImport> assistantSkills;
    private AssistantState assistantState;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing ImportSkillsOptions instance.
     *
     * @param importSkillsOptions the instance to initialize the Builder with
     */
    private Builder(ImportSkillsOptions importSkillsOptions) {
      this.assistantId = importSkillsOptions.assistantId;
      this.assistantSkills = importSkillsOptions.assistantSkills;
      this.assistantState = importSkillsOptions.assistantState;
      this.includeAudit = importSkillsOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param assistantId the assistantId
     * @param assistantSkills the assistantSkills
     * @param assistantState the assistantState
     */
    public Builder(
        String assistantId, List<SkillImport> assistantSkills, AssistantState assistantState) {
      this.assistantId = assistantId;
      this.assistantSkills = assistantSkills;
      this.assistantState = assistantState;
    }

    /**
     * Builds a ImportSkillsOptions.
     *
     * @return the new ImportSkillsOptions instance
     */
    public ImportSkillsOptions build() {
      return new ImportSkillsOptions(this);
    }

    /**
     * Adds a new element to assistantSkills.
     *
     * @param assistantSkills the new element to be added
     * @return the ImportSkillsOptions builder
     */
    public Builder addAssistantSkills(SkillImport assistantSkills) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(
          assistantSkills, "assistantSkills cannot be null");
      if (this.assistantSkills == null) {
        this.assistantSkills = new ArrayList<SkillImport>();
      }
      this.assistantSkills.add(assistantSkills);
      return this;
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the ImportSkillsOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }

    /**
     * Set the assistantSkills. Existing assistantSkills will be replaced.
     *
     * @param assistantSkills the assistantSkills
     * @return the ImportSkillsOptions builder
     */
    public Builder assistantSkills(List<SkillImport> assistantSkills) {
      this.assistantSkills = assistantSkills;
      return this;
    }

    /**
     * Set the assistantState.
     *
     * @param assistantState the assistantState
     * @return the ImportSkillsOptions builder
     */
    public Builder assistantState(AssistantState assistantState) {
      this.assistantState = assistantState;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the ImportSkillsOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected ImportSkillsOptions() {}

  protected ImportSkillsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.assistantId, "assistantId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.assistantSkills, "assistantSkills cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.assistantState, "assistantState cannot be null");
    assistantId = builder.assistantId;
    assistantSkills = builder.assistantSkills;
    assistantState = builder.assistantState;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a ImportSkillsOptions builder
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
   * Gets the assistantSkills.
   *
   * <p>An array of objects describing the skills for the assistant. Included in responses only if
   * **status**=`Available`.
   *
   * @return the assistantSkills
   */
  public List<SkillImport> assistantSkills() {
    return assistantSkills;
  }

  /**
   * Gets the assistantState.
   *
   * <p>Status information about the skills for the assistant. Included in responses only if
   * **status**=`Available`.
   *
   * @return the assistantState
   */
  public AssistantState assistantState() {
    return assistantState;
  }

  /**
   * Gets the includeAudit.
   *
   * <p>Whether to include the audit properties (`created` and `updated` timestamps) in the
   * response.
   *
   * @return the includeAudit
   */
  public Boolean includeAudit() {
    return includeAudit;
  }
}

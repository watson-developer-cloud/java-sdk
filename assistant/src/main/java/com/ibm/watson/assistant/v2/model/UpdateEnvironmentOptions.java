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
import java.util.ArrayList;
import java.util.List;

/** The updateEnvironment options. */
public class UpdateEnvironmentOptions extends GenericModel {

  protected String assistantId;
  protected String environmentId;
  protected String name;
  protected String description;
  protected BaseEnvironmentOrchestration orchestration;
  protected Long sessionTimeout;
  protected List<EnvironmentSkill> skillReferences;

  /** Builder. */
  public static class Builder {
    private String assistantId;
    private String environmentId;
    private String name;
    private String description;
    private BaseEnvironmentOrchestration orchestration;
    private Long sessionTimeout;
    private List<EnvironmentSkill> skillReferences;

    /**
     * Instantiates a new Builder from an existing UpdateEnvironmentOptions instance.
     *
     * @param updateEnvironmentOptions the instance to initialize the Builder with
     */
    private Builder(UpdateEnvironmentOptions updateEnvironmentOptions) {
      this.assistantId = updateEnvironmentOptions.assistantId;
      this.environmentId = updateEnvironmentOptions.environmentId;
      this.name = updateEnvironmentOptions.name;
      this.description = updateEnvironmentOptions.description;
      this.orchestration = updateEnvironmentOptions.orchestration;
      this.sessionTimeout = updateEnvironmentOptions.sessionTimeout;
      this.skillReferences = updateEnvironmentOptions.skillReferences;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param assistantId the assistantId
     * @param environmentId the environmentId
     */
    public Builder(String assistantId, String environmentId) {
      this.assistantId = assistantId;
      this.environmentId = environmentId;
    }

    /**
     * Builds a UpdateEnvironmentOptions.
     *
     * @return the new UpdateEnvironmentOptions instance
     */
    public UpdateEnvironmentOptions build() {
      return new UpdateEnvironmentOptions(this);
    }

    /**
     * Adds a new element to skillReferences.
     *
     * @param skillReference the new element to be added
     * @return the UpdateEnvironmentOptions builder
     */
    public Builder addSkillReference(EnvironmentSkill skillReference) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(
          skillReference, "skillReference cannot be null");
      if (this.skillReferences == null) {
        this.skillReferences = new ArrayList<EnvironmentSkill>();
      }
      this.skillReferences.add(skillReference);
      return this;
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the UpdateEnvironmentOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the UpdateEnvironmentOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateEnvironmentOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateEnvironmentOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the orchestration.
     *
     * @param orchestration the orchestration
     * @return the UpdateEnvironmentOptions builder
     */
    public Builder orchestration(BaseEnvironmentOrchestration orchestration) {
      this.orchestration = orchestration;
      return this;
    }

    /**
     * Set the sessionTimeout.
     *
     * @param sessionTimeout the sessionTimeout
     * @return the UpdateEnvironmentOptions builder
     */
    public Builder sessionTimeout(long sessionTimeout) {
      this.sessionTimeout = sessionTimeout;
      return this;
    }

    /**
     * Set the skillReferences. Existing skillReferences will be replaced.
     *
     * @param skillReferences the skillReferences
     * @return the UpdateEnvironmentOptions builder
     */
    public Builder skillReferences(List<EnvironmentSkill> skillReferences) {
      this.skillReferences = skillReferences;
      return this;
    }
  }

  protected UpdateEnvironmentOptions() {}

  protected UpdateEnvironmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.assistantId, "assistantId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    assistantId = builder.assistantId;
    environmentId = builder.environmentId;
    name = builder.name;
    description = builder.description;
    orchestration = builder.orchestration;
    sessionTimeout = builder.sessionTimeout;
    skillReferences = builder.skillReferences;
  }

  /**
   * New builder.
   *
   * @return a UpdateEnvironmentOptions builder
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
   * Gets the environmentId.
   *
   * <p>Unique identifier of the environment. To find the environment ID in the watsonx Assistant
   * user interface, open the environment settings and click **API Details**. **Note:** Currently,
   * the API does not support creating environments.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the name.
   *
   * <p>The name of the environment.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>The description of the environment.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the orchestration.
   *
   * <p>The search skill orchestration settings for the environment.
   *
   * @return the orchestration
   */
  public BaseEnvironmentOrchestration orchestration() {
    return orchestration;
  }

  /**
   * Gets the sessionTimeout.
   *
   * <p>The session inactivity timeout setting for the environment (in seconds).
   *
   * @return the sessionTimeout
   */
  public Long sessionTimeout() {
    return sessionTimeout;
  }

  /**
   * Gets the skillReferences.
   *
   * <p>An array of objects identifying the skills (such as action and dialog) that exist in the
   * environment.
   *
   * @return the skillReferences
   */
  public List<EnvironmentSkill> skillReferences() {
    return skillReferences;
  }
}

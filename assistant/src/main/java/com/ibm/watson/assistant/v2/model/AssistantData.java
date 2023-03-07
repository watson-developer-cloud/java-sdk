/*
 * (C) Copyright IBM Corp. 2023.
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
import java.util.List;

/** AssistantData. */
public class AssistantData extends GenericModel {

  @SerializedName("assistant_id")
  protected String assistantId;

  protected String name;
  protected String description;
  protected String language;

  @SerializedName("assistant_skills")
  protected List<AssistantSkill> assistantSkills;

  @SerializedName("assistant_environments")
  protected List<EnvironmentReference> assistantEnvironments;

  /** Builder. */
  public static class Builder {
    private String name;
    private String description;
    private String language;

    /**
     * Instantiates a new Builder from an existing AssistantData instance.
     *
     * @param assistantData the instance to initialize the Builder with
     */
    private Builder(AssistantData assistantData) {
      this.name = assistantData.name;
      this.description = assistantData.description;
      this.language = assistantData.language;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param language the language
     */
    public Builder(String language) {
      this.language = language;
    }

    /**
     * Builds a AssistantData.
     *
     * @return the new AssistantData instance
     */
    public AssistantData build() {
      return new AssistantData(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the AssistantData builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the AssistantData builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the AssistantData builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }
  }

  protected AssistantData() {}

  protected AssistantData(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.language, "language cannot be null");
    name = builder.name;
    description = builder.description;
    language = builder.language;
  }

  /**
   * New builder.
   *
   * @return a AssistantData builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assistantId.
   *
   * <p>The unique identifier of the assistant.
   *
   * @return the assistantId
   */
  public String assistantId() {
    return assistantId;
  }

  /**
   * Gets the name.
   *
   * <p>The name of the assistant. This string cannot contain carriage return, newline, or tab
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
   * <p>The description of the assistant. This string cannot contain carriage return, newline, or
   * tab characters.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the language.
   *
   * <p>The language of the assistant.
   *
   * @return the language
   */
  public String language() {
    return language;
  }

  /**
   * Gets the assistantSkills.
   *
   * <p>An array of skill references identifying the skills associated with the assistant.
   *
   * @return the assistantSkills
   */
  public List<AssistantSkill> assistantSkills() {
    return assistantSkills;
  }

  /**
   * Gets the assistantEnvironments.
   *
   * <p>An array of objects describing the environments defined for the assistant.
   *
   * @return the assistantEnvironments
   */
  public List<EnvironmentReference> assistantEnvironments() {
    return assistantEnvironments;
  }
}

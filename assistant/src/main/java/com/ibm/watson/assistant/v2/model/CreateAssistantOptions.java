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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The createAssistant options. */
public class CreateAssistantOptions extends GenericModel {

  protected String name;
  protected String description;
  protected String language;

  /** Builder. */
  public static class Builder {
    private String name;
    private String description;
    private String language;

    /**
     * Instantiates a new Builder from an existing CreateAssistantOptions instance.
     *
     * @param createAssistantOptions the instance to initialize the Builder with
     */
    private Builder(CreateAssistantOptions createAssistantOptions) {
      this.name = createAssistantOptions.name;
      this.description = createAssistantOptions.description;
      this.language = createAssistantOptions.language;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a CreateAssistantOptions.
     *
     * @return the new CreateAssistantOptions instance
     */
    public CreateAssistantOptions build() {
      return new CreateAssistantOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateAssistantOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateAssistantOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the CreateAssistantOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the assistantData.
     *
     * @param assistantData the assistantData
     * @return the CreateAssistantOptions builder
     */
    public Builder assistantData(AssistantData assistantData) {
      this.name = assistantData.name();
      this.description = assistantData.description();
      this.language = assistantData.language();
      return this;
    }
  }

  protected CreateAssistantOptions() {}

  protected CreateAssistantOptions(Builder builder) {
    name = builder.name;
    description = builder.description;
    language = builder.language;
  }

  /**
   * New builder.
   *
   * @return a CreateAssistantOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
}

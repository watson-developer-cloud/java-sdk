/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The createCollection options.
 */
public class CreateCollectionOptions extends GenericModel {

  /**
   * The language of the documents stored in the collection. The value should be in the form of an ISO 639-1 language
   * code.
   */
  public interface Language {
    /** en. */
    String EN = "en";
    /** es. */
    String ES = "es";
    /** de. */
    String DE = "de";
  }

  private String environmentId;
  private String name;
  private String description;
  private String language;
  private String configurationId;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String name;
    private String description;
    private String language;
    private String configurationId;

    private Builder(CreateCollectionOptions createCollectionOptions) {
      environmentId = createCollectionOptions.environmentId;
      name = createCollectionOptions.name;
      description = createCollectionOptions.description;
      language = createCollectionOptions.language;
      configurationId = createCollectionOptions.configurationId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     * @param name the name
     */
    public Builder(String environmentId, String name) {
      this.environmentId = environmentId;
      this.name = name;
    }

    /**
     * Builds a CreateCollectionOptions.
     *
     * @return the createCollectionOptions
     */
    public CreateCollectionOptions build() {
      return new CreateCollectionOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the CreateCollectionOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateCollectionOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateCollectionOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the CreateCollectionOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the configurationId.
     *
     * @param configurationId the configurationId
     * @return the CreateCollectionOptions builder
     */
    public Builder configurationId(String configurationId) {
      this.configurationId = configurationId;
      return this;
    }
  }

  private CreateCollectionOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    Validator.notNull(builder.name, "name cannot be null");
    environmentId = builder.environmentId;
    name = builder.name;
    description = builder.description;
    language = builder.language;
    configurationId = builder.configurationId;
  }

  /**
   * New builder.
   *
   * @return a CreateCollectionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * the ID of your environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the name.
   *
   * The name of the collection to be created.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * A description of the collection.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the language.
   *
   * The language of the documents stored in the collection. The value should be in the form of an ISO 639-1 language
   * code.
   *
   * @return the language
   */
  public String language() {
    return language;
  }

  /**
   * Gets the configurationId.
   *
   * The ID of the configuration in which the collection is to be created.
   *
   * @return the configurationId
   */
  public String configurationId() {
    return configurationId;
  }
}

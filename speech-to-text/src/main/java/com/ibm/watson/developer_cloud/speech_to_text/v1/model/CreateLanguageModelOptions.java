/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The createLanguageModel options.
 */
public class CreateLanguageModelOptions extends GenericModel {

  private String name;
  private String baseModelName;
  private String dialect;
  private String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String baseModelName;
    private String dialect;
    private String description;

    private Builder(CreateLanguageModelOptions createLanguageModelOptions) {
      name = createLanguageModelOptions.name;
      baseModelName = createLanguageModelOptions.baseModelName;
      dialect = createLanguageModelOptions.dialect;
      description = createLanguageModelOptions.description;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param baseModelName the baseModelName
     */
    public Builder(String name, String baseModelName) {
      this.name = name;
      this.baseModelName = baseModelName;
    }

    /**
     * Builds a CreateLanguageModelOptions.
     *
     * @return the createLanguageModelOptions
     */
    public CreateLanguageModelOptions build() {
      return new CreateLanguageModelOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateLanguageModelOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the baseModelName.
     *
     * @param baseModelName the baseModelName
     * @return the CreateLanguageModelOptions builder
     */
    public Builder baseModelName(String baseModelName) {
      this.baseModelName = baseModelName;
      return this;
    }

    /**
     * Set the dialect.
     *
     * @param dialect the dialect
     * @return the CreateLanguageModelOptions builder
     */
    public Builder dialect(String dialect) {
      this.dialect = dialect;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateLanguageModelOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  private CreateLanguageModelOptions(Builder builder) {
    Validator.notNull(builder.name, "name cannot be null");
    Validator.notNull(builder.baseModelName, "baseModelName cannot be null");
    name = builder.name;
    baseModelName = builder.baseModelName;
    dialect = builder.dialect;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a CreateLanguageModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * A user-defined name for the new custom language model. Use a name that is unique among all custom language models
   * that you own. Use a localized name that matches the language of the custom model. Use a name that describes the
   * domain of the custom model, such as `Medical custom model` or `Legal custom model`.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the baseModelName.
   *
   * The name of the base language model that is to be customized by the new custom language model. The new custom model
   * can be used only with the base model that it customizes. To determine whether a base model supports language model
   * customization, request information about the base model and check that the attribute `custom_language_model` is set
   * to `true`, or refer to [Language support for
   * customization](https://console.bluemix.net/docs/services/speech-to-text/custom.html#languageSupport).
   *
   * @return the baseModelName
   */
  public String baseModelName() {
    return baseModelName;
  }

  /**
   * Gets the dialect.
   *
   * The dialect of the specified language that is to be used with the custom language model. The parameter is
   * meaningful only for Spanish models, for which the service creates a custom language model that is suited for speech
   * in one of the following dialects: * `es-ES` for Castilian Spanish (the default) * `es-LA` for Latin American
   * Spanish * `es-US` for North American (Mexican) Spanish A specified dialect must be valid for the base model. By
   * default, the dialect matches the language of the base model; for example, `en-US` for either of the US English
   * language models.
   *
   * @return the dialect
   */
  public String dialect() {
    return dialect;
  }

  /**
   * Gets the description.
   *
   * A description of the new custom language model. Use a localized description that matches the language of the custom
   * model.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

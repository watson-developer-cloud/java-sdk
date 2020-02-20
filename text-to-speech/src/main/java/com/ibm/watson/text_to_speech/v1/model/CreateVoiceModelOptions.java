/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.text_to_speech.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createVoiceModel options.
 */
public class CreateVoiceModelOptions extends GenericModel {

  /**
   * The language of the new custom voice model. Omit the parameter to use the the default language, `en-US`.
   */
  public interface Language {
    /** de-DE. */
    String DE_DE = "de-DE";
    /** en-GB. */
    String EN_GB = "en-GB";
    /** en-US. */
    String EN_US = "en-US";
    /** es-ES. */
    String ES_ES = "es-ES";
    /** es-LA. */
    String ES_LA = "es-LA";
    /** es-US. */
    String ES_US = "es-US";
    /** fr-FR. */
    String FR_FR = "fr-FR";
    /** it-IT. */
    String IT_IT = "it-IT";
    /** ja-JP. */
    String JA_JP = "ja-JP";
    /** pt-BR. */
    String PT_BR = "pt-BR";
  }

  protected String name;
  protected String language;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String language;
    private String description;

    private Builder(CreateVoiceModelOptions createVoiceModelOptions) {
      this.name = createVoiceModelOptions.name;
      this.language = createVoiceModelOptions.language;
      this.description = createVoiceModelOptions.description;
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
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Builds a CreateVoiceModelOptions.
     *
     * @return the createVoiceModelOptions
     */
    public CreateVoiceModelOptions build() {
      return new CreateVoiceModelOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateVoiceModelOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the CreateVoiceModelOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateVoiceModelOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected CreateVoiceModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
        "name cannot be null");
    name = builder.name;
    language = builder.language;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a CreateVoiceModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The name of the new custom voice model.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the language.
   *
   * The language of the new custom voice model. Omit the parameter to use the the default language, `en-US`.
   *
   * @return the language
   */
  public String language() {
    return language;
  }

  /**
   * Gets the description.
   *
   * A description of the new custom voice model. Specifying a description is recommended.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

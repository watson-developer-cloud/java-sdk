/*
 * (C) Copyright IBM Corp. 2020, 2023.
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

/** The createCustomModel options. */
public class CreateCustomModelOptions extends GenericModel {

  /**
   * The language of the new custom model. You create a custom model for a specific language, not
   * for a specific voice. A custom model can be used with any voice for its specified language.
   * Omit the parameter to use the the default language, `en-US`.
   */
  public interface Language {
    /** ar-MS. */
    String AR_MS = "ar-MS";
    /** cs-CZ. */
    String CS_CZ = "cs-CZ";
    /** de-DE. */
    String DE_DE = "de-DE";
    /** en-AU. */
    String EN_AU = "en-AU";
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
    /** fr-CA. */
    String FR_CA = "fr-CA";
    /** fr-FR. */
    String FR_FR = "fr-FR";
    /** it-IT. */
    String IT_IT = "it-IT";
    /** ja-JP. */
    String JA_JP = "ja-JP";
    /** ko-KR. */
    String KO_KR = "ko-KR";
    /** nl-BE. */
    String NL_BE = "nl-BE";
    /** nl-NL. */
    String NL_NL = "nl-NL";
    /** pt-BR. */
    String PT_BR = "pt-BR";
    /** sv-SE. */
    String SV_SE = "sv-SE";
    /** zh-CN. */
    String ZH_CN = "zh-CN";
  }

  protected String name;
  protected String language;
  protected String description;

  /** Builder. */
  public static class Builder {
    private String name;
    private String language;
    private String description;

    /**
     * Instantiates a new Builder from an existing CreateCustomModelOptions instance.
     *
     * @param createCustomModelOptions the instance to initialize the Builder with
     */
    private Builder(CreateCustomModelOptions createCustomModelOptions) {
      this.name = createCustomModelOptions.name;
      this.language = createCustomModelOptions.language;
      this.description = createCustomModelOptions.description;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Builds a CreateCustomModelOptions.
     *
     * @return the new CreateCustomModelOptions instance
     */
    public CreateCustomModelOptions build() {
      return new CreateCustomModelOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateCustomModelOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the CreateCustomModelOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateCustomModelOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected CreateCustomModelOptions() {}

  protected CreateCustomModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name, "name cannot be null");
    name = builder.name;
    language = builder.language;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a CreateCustomModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * <p>The name of the new custom model. Use a localized name that matches the language of the
   * custom model. Use a name that describes the purpose of the custom model, such as `Medical
   * custom model` or `Legal custom model`. Use a name that is unique among all custom models that
   * you own.
   *
   * <p>Include a maximum of 256 characters in the name. Do not use backslashes, slashes, colons,
   * equal signs, ampersands, or question marks in the name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the language.
   *
   * <p>The language of the new custom model. You create a custom model for a specific language, not
   * for a specific voice. A custom model can be used with any voice for its specified language.
   * Omit the parameter to use the the default language, `en-US`.
   *
   * @return the language
   */
  public String language() {
    return language;
  }

  /**
   * Gets the description.
   *
   * <p>A recommended description of the new custom model. Use a localized description that matches
   * the language of the custom model. Include a maximum of 128 characters in the description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

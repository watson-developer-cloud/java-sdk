/*
 * (C) Copyright IBM Corp. 2020, 2022.
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
   *
   * <p>**Important:** If you are using the service on IBM Cloud Pak for Data _and_ you install the
   * neural voices, the `language`parameter is required. You must specify the language for the
   * custom model in the indicated format (for example, `en-AU` for Australian English). The request
   * fails if you do not specify a language.
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
   * <p>The name of the new custom model.
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
   * <p>**Important:** If you are using the service on IBM Cloud Pak for Data _and_ you install the
   * neural voices, the `language`parameter is required. You must specify the language for the
   * custom model in the indicated format (for example, `en-AU` for Australian English). The request
   * fails if you do not specify a language.
   *
   * @return the language
   */
  public String language() {
    return language;
  }

  /**
   * Gets the description.
   *
   * <p>A description of the new custom model. Specifying a description is recommended.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

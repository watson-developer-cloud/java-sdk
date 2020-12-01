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
package com.ibm.watson.speech_to_text.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The createAcousticModel options. */
public class CreateAcousticModelOptions extends GenericModel {

  /**
   * The name of the base language model that is to be customized by the new custom acoustic model.
   * The new custom model can be used only with the base model that it customizes.
   *
   * <p>To determine whether a base model supports acoustic model customization, refer to [Language
   * support for
   * customization](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-customization#languageSupport).
   */
  public interface BaseModelName {
    /** ar-AR_BroadbandModel. */
    String AR_AR_BROADBANDMODEL = "ar-AR_BroadbandModel";
    /** de-DE_BroadbandModel. */
    String DE_DE_BROADBANDMODEL = "de-DE_BroadbandModel";
    /** de-DE_NarrowbandModel. */
    String DE_DE_NARROWBANDMODEL = "de-DE_NarrowbandModel";
    /** en-AU_BroadbandModel. */
    String EN_AU_BROADBANDMODEL = "en-AU_BroadbandModel";
    /** en-AU_NarrowbandModel. */
    String EN_AU_NARROWBANDMODEL = "en-AU_NarrowbandModel";
    /** en-GB_BroadbandModel. */
    String EN_GB_BROADBANDMODEL = "en-GB_BroadbandModel";
    /** en-GB_NarrowbandModel. */
    String EN_GB_NARROWBANDMODEL = "en-GB_NarrowbandModel";
    /** en-US_BroadbandModel. */
    String EN_US_BROADBANDMODEL = "en-US_BroadbandModel";
    /** en-US_NarrowbandModel. */
    String EN_US_NARROWBANDMODEL = "en-US_NarrowbandModel";
    /** en-US_ShortForm_NarrowbandModel. */
    String EN_US_SHORTFORM_NARROWBANDMODEL = "en-US_ShortForm_NarrowbandModel";
    /** es-AR_BroadbandModel. */
    String ES_AR_BROADBANDMODEL = "es-AR_BroadbandModel";
    /** es-AR_NarrowbandModel. */
    String ES_AR_NARROWBANDMODEL = "es-AR_NarrowbandModel";
    /** es-CL_BroadbandModel. */
    String ES_CL_BROADBANDMODEL = "es-CL_BroadbandModel";
    /** es-CL_NarrowbandModel. */
    String ES_CL_NARROWBANDMODEL = "es-CL_NarrowbandModel";
    /** es-CO_BroadbandModel. */
    String ES_CO_BROADBANDMODEL = "es-CO_BroadbandModel";
    /** es-CO_NarrowbandModel. */
    String ES_CO_NARROWBANDMODEL = "es-CO_NarrowbandModel";
    /** es-ES_BroadbandModel. */
    String ES_ES_BROADBANDMODEL = "es-ES_BroadbandModel";
    /** es-ES_NarrowbandModel. */
    String ES_ES_NARROWBANDMODEL = "es-ES_NarrowbandModel";
    /** es-MX_BroadbandModel. */
    String ES_MX_BROADBANDMODEL = "es-MX_BroadbandModel";
    /** es-MX_NarrowbandModel. */
    String ES_MX_NARROWBANDMODEL = "es-MX_NarrowbandModel";
    /** es-PE_BroadbandModel. */
    String ES_PE_BROADBANDMODEL = "es-PE_BroadbandModel";
    /** es-PE_NarrowbandModel. */
    String ES_PE_NARROWBANDMODEL = "es-PE_NarrowbandModel";
    /** fr-CA_BroadbandModel. */
    String FR_CA_BROADBANDMODEL = "fr-CA_BroadbandModel";
    /** fr-CA_NarrowbandModel. */
    String FR_CA_NARROWBANDMODEL = "fr-CA_NarrowbandModel";
    /** fr-FR_BroadbandModel. */
    String FR_FR_BROADBANDMODEL = "fr-FR_BroadbandModel";
    /** fr-FR_NarrowbandModel. */
    String FR_FR_NARROWBANDMODEL = "fr-FR_NarrowbandModel";
    /** it-IT_BroadbandModel. */
    String IT_IT_BROADBANDMODEL = "it-IT_BroadbandModel";
    /** it-IT_NarrowbandModel. */
    String IT_IT_NARROWBANDMODEL = "it-IT_NarrowbandModel";
    /** ja-JP_BroadbandModel. */
    String JA_JP_BROADBANDMODEL = "ja-JP_BroadbandModel";
    /** ja-JP_NarrowbandModel. */
    String JA_JP_NARROWBANDMODEL = "ja-JP_NarrowbandModel";
    /** ko-KR_BroadbandModel. */
    String KO_KR_BROADBANDMODEL = "ko-KR_BroadbandModel";
    /** ko-KR_NarrowbandModel. */
    String KO_KR_NARROWBANDMODEL = "ko-KR_NarrowbandModel";
    /** nl-NL_BroadbandModel. */
    String NL_NL_BROADBANDMODEL = "nl-NL_BroadbandModel";
    /** nl-NL_NarrowbandModel. */
    String NL_NL_NARROWBANDMODEL = "nl-NL_NarrowbandModel";
    /** pt-BR_BroadbandModel. */
    String PT_BR_BROADBANDMODEL = "pt-BR_BroadbandModel";
    /** pt-BR_NarrowbandModel. */
    String PT_BR_NARROWBANDMODEL = "pt-BR_NarrowbandModel";
    /** zh-CN_BroadbandModel. */
    String ZH_CN_BROADBANDMODEL = "zh-CN_BroadbandModel";
    /** zh-CN_NarrowbandModel. */
    String ZH_CN_NARROWBANDMODEL = "zh-CN_NarrowbandModel";
  }

  protected String name;
  protected String baseModelName;
  protected String description;

  /** Builder. */
  public static class Builder {
    private String name;
    private String baseModelName;
    private String description;

    private Builder(CreateAcousticModelOptions createAcousticModelOptions) {
      this.name = createAcousticModelOptions.name;
      this.baseModelName = createAcousticModelOptions.baseModelName;
      this.description = createAcousticModelOptions.description;
    }

    /** Instantiates a new builder. */
    public Builder() {}

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
     * Builds a CreateAcousticModelOptions.
     *
     * @return the new CreateAcousticModelOptions instance
     */
    public CreateAcousticModelOptions build() {
      return new CreateAcousticModelOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateAcousticModelOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the baseModelName.
     *
     * @param baseModelName the baseModelName
     * @return the CreateAcousticModelOptions builder
     */
    public Builder baseModelName(String baseModelName) {
      this.baseModelName = baseModelName;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateAcousticModelOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected CreateAcousticModelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name, "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.baseModelName, "baseModelName cannot be null");
    name = builder.name;
    baseModelName = builder.baseModelName;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a CreateAcousticModelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * <p>A user-defined name for the new custom acoustic model. Use a name that is unique among all
   * custom acoustic models that you own. Use a localized name that matches the language of the
   * custom model. Use a name that describes the acoustic environment of the custom model, such as
   * `Mobile custom model` or `Noisy car custom model`.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the baseModelName.
   *
   * <p>The name of the base language model that is to be customized by the new custom acoustic
   * model. The new custom model can be used only with the base model that it customizes.
   *
   * <p>To determine whether a base model supports acoustic model customization, refer to [Language
   * support for
   * customization](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-customization#languageSupport).
   *
   * @return the baseModelName
   */
  public String baseModelName() {
    return baseModelName;
  }

  /**
   * Gets the description.
   *
   * <p>A description of the new custom acoustic model. Use a localized description that matches the
   * language of the custom model.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

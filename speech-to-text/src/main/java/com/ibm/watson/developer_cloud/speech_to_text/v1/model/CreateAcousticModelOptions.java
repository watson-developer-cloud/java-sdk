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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The createAcousticModel options.
 */
public class CreateAcousticModelOptions extends GenericModel {

  /**
   * The name of the base language model that is to be customized by the new custom acoustic model. The new custom model
   * can be used only with the base model that it customizes.
   *
   * To determine whether a base model supports acoustic model customization, refer to [Language support for
   * customization](https://cloud.ibm.com/docs/services/speech-to-text/custom.html#languageSupport).
   */
  public interface BaseModelName {
    /** ar-AR_BroadbandModel. */
    String AR_AR_BROADBANDMODEL = "ar-AR_BroadbandModel";
    /** de-DE_BroadbandModel. */
    String DE_DE_BROADBANDMODEL = "de-DE_BroadbandModel";
    /** de-DE_NarrowbandModel. */
    String DE_DE_NARROWBANDMODEL = "de-DE_NarrowbandModel";
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
    /** es-ES_BroadbandModel. */
    String ES_ES_BROADBANDMODEL = "es-ES_BroadbandModel";
    /** es-ES_NarrowbandModel. */
    String ES_ES_NARROWBANDMODEL = "es-ES_NarrowbandModel";
    /** fr-FR_BroadbandModel. */
    String FR_FR_BROADBANDMODEL = "fr-FR_BroadbandModel";
    /** fr-FR_NarrowbandModel. */
    String FR_FR_NARROWBANDMODEL = "fr-FR_NarrowbandModel";
    /** ja-JP_BroadbandModel. */
    String JA_JP_BROADBANDMODEL = "ja-JP_BroadbandModel";
    /** ja-JP_NarrowbandModel. */
    String JA_JP_NARROWBANDMODEL = "ja-JP_NarrowbandModel";
    /** ko-KR_BroadbandModel. */
    String KO_KR_BROADBANDMODEL = "ko-KR_BroadbandModel";
    /** ko-KR_NarrowbandModel. */
    String KO_KR_NARROWBANDMODEL = "ko-KR_NarrowbandModel";
    /** pt-BR_BroadbandModel. */
    String PT_BR_BROADBANDMODEL = "pt-BR_BroadbandModel";
    /** pt-BR_NarrowbandModel. */
    String PT_BR_NARROWBANDMODEL = "pt-BR_NarrowbandModel";
    /** zh-CN_BroadbandModel. */
    String ZH_CN_BROADBANDMODEL = "zh-CN_BroadbandModel";
    /** zh-CN_NarrowbandModel. */
    String ZH_CN_NARROWBANDMODEL = "zh-CN_NarrowbandModel";
  }

  private String name;
  private String baseModelName;
  private String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String baseModelName;
    private String description;

    private Builder(CreateAcousticModelOptions createAcousticModelOptions) {
      name = createAcousticModelOptions.name;
      baseModelName = createAcousticModelOptions.baseModelName;
      description = createAcousticModelOptions.description;
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
     * Builds a CreateAcousticModelOptions.
     *
     * @return the createAcousticModelOptions
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

  private CreateAcousticModelOptions(Builder builder) {
    Validator.notNull(builder.name, "name cannot be null");
    Validator.notNull(builder.baseModelName, "baseModelName cannot be null");
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
   * A user-defined name for the new custom acoustic model. Use a name that is unique among all custom acoustic models
   * that you own. Use a localized name that matches the language of the custom model. Use a name that describes the
   * acoustic environment of the custom model, such as `Mobile custom model` or `Noisy car custom model`.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the baseModelName.
   *
   * The name of the base language model that is to be customized by the new custom acoustic model. The new custom model
   * can be used only with the base model that it customizes.
   *
   * To determine whether a base model supports acoustic model customization, refer to [Language support for
   * customization](https://cloud.ibm.com/docs/services/speech-to-text/custom.html#languageSupport).
   *
   * @return the baseModelName
   */
  public String baseModelName() {
    return baseModelName;
  }

  /**
   * Gets the description.
   *
   * A description of the new custom acoustic model. Use a localized description that matches the language of the custom
   * model.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

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
package com.ibm.watson.speech_to_text.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The listAcousticModels options. */
public class ListAcousticModelsOptions extends GenericModel {

  /**
   * The identifier of the language for which custom language or custom acoustic models are to be
   * returned. Specify the five-character language identifier; for example, specify `en-US` to see
   * all custom language or custom acoustic models that are based on US English models. Omit the
   * parameter to see all custom language or custom acoustic models that are owned by the requesting
   * credentials.
   *
   * <p>To determine the languages for which customization is available, see [Language support for
   * customization](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-custom-support).
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
    /** en-IN. */
    String EN_IN = "en-IN";
    /** en-US. */
    String EN_US = "en-US";
    /** en-WW. */
    String EN_WW = "en-WW";
    /** es-AR. */
    String ES_AR = "es-AR";
    /** es-CL. */
    String ES_CL = "es-CL";
    /** es-CO. */
    String ES_CO = "es-CO";
    /** es-ES. */
    String ES_ES = "es-ES";
    /** es-LA. */
    String ES_LA = "es-LA";
    /** es-MX. */
    String ES_MX = "es-MX";
    /** es-PE. */
    String ES_PE = "es-PE";
    /** fr-CA. */
    String FR_CA = "fr-CA";
    /** fr-FR. */
    String FR_FR = "fr-FR";
    /** hi-IN. */
    String HI_IN = "hi-IN";
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

  protected String language;

  /** Builder. */
  public static class Builder {
    private String language;

    /**
     * Instantiates a new Builder from an existing ListAcousticModelsOptions instance.
     *
     * @param listAcousticModelsOptions the instance to initialize the Builder with
     */
    private Builder(ListAcousticModelsOptions listAcousticModelsOptions) {
      this.language = listAcousticModelsOptions.language;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ListAcousticModelsOptions.
     *
     * @return the new ListAcousticModelsOptions instance
     */
    public ListAcousticModelsOptions build() {
      return new ListAcousticModelsOptions(this);
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the ListAcousticModelsOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }
  }

  protected ListAcousticModelsOptions() {}

  protected ListAcousticModelsOptions(Builder builder) {
    language = builder.language;
  }

  /**
   * New builder.
   *
   * @return a ListAcousticModelsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the language.
   *
   * <p>The identifier of the language for which custom language or custom acoustic models are to be
   * returned. Specify the five-character language identifier; for example, specify `en-US` to see
   * all custom language or custom acoustic models that are based on US English models. Omit the
   * parameter to see all custom language or custom acoustic models that are owned by the requesting
   * credentials.
   *
   * <p>To determine the languages for which customization is available, see [Language support for
   * customization](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-custom-support).
   *
   * @return the language
   */
  public String language() {
    return language;
  }
}

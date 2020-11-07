/*
 * (C) Copyright IBM Corp. 2018, 2020.
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
   * returned. Omit the parameter to see all custom language or custom acoustic models that are
   * owned by the requesting credentials.
   *
   * <p>To determine the languages for which customization is available, see [Language support for
   * customization](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-customization#languageSupport).
   */
  public interface Language {
    /** ar-AR. */
    String AR_AR = "ar-AR";
    /** de-DE. */
    String DE_DE = "de-DE";
    /** en-AU. */
    String EN_AU = "en-AU";
    /** en-GB. */
    String EN_GB = "en-GB";
    /** en-US. */
    String EN_US = "en-US";
    /** es-AR. */
    String ES_AR = "es-AR";
    /** es-ES. */
    String ES_ES = "es-ES";
    /** es-CL. */
    String ES_CL = "es-CL";
    /** es-CO. */
    String ES_CO = "es-CO";
    /** es-MX. */
    String ES_MX = "es-MX";
    /** es-PE. */
    String ES_PE = "es-PE";
    /** fr-FR. */
    String FR_FR = "fr-FR";
    /** it-IT. */
    String IT_IT = "it-IT";
    /** ja-JP. */
    String JA_JP = "ja-JP";
    /** ko-KR. */
    String KO_KR = "ko-KR";
    /** nl-NL. */
    String NL_NL = "nl-NL";
    /** pt-BR. */
    String PT_BR = "pt-BR";
    /** zh-CN. */
    String ZH_CN = "zh-CN";
  }

  protected String language;

  /** Builder. */
  public static class Builder {
    private String language;

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
   * returned. Omit the parameter to see all custom language or custom acoustic models that are
   * owned by the requesting credentials.
   *
   * <p>To determine the languages for which customization is available, see [Language support for
   * customization](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-customization#languageSupport).
   *
   * @return the language
   */
  public String language() {
    return language;
  }
}

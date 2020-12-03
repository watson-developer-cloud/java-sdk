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

/** The listCustomModels options. */
public class ListCustomModelsOptions extends GenericModel {

  /**
   * The language for which custom models that are owned by the requesting credentials are to be
   * returned. Omit the parameter to see all custom models that are owned by the requester.
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

    private Builder(ListCustomModelsOptions listCustomModelsOptions) {
      this.language = listCustomModelsOptions.language;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ListCustomModelsOptions.
     *
     * @return the new ListCustomModelsOptions instance
     */
    public ListCustomModelsOptions build() {
      return new ListCustomModelsOptions(this);
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the ListCustomModelsOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }
  }

  protected ListCustomModelsOptions(Builder builder) {
    language = builder.language;
  }

  /**
   * New builder.
   *
   * @return a ListCustomModelsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the language.
   *
   * <p>The language for which custom models that are owned by the requesting credentials are to be
   * returned. Omit the parameter to see all custom models that are owned by the requester.
   *
   * @return the language
   */
  public String language() {
    return language;
  }
}

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
package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The listVoiceModels options.
 */
public class ListVoiceModelsOptions extends GenericModel {

  /**
   * The language for which custom voice models that are owned by the requesting service credentials are to be returned.
   * Omit the parameter to see all custom voice models that are owned by the requester.
   */
  public interface Language {
    /** de-DE. */
    String DE_DE = "de-DE";
    /** en-US. */
    String EN_US = "en-US";
    /** en-GB. */
    String EN_GB = "en-GB";
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

  private String language;

  /**
   * Builder.
   */
  public static class Builder {
    private String language;

    private Builder(ListVoiceModelsOptions listVoiceModelsOptions) {
      language = listVoiceModelsOptions.language;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListVoiceModelsOptions.
     *
     * @return the listVoiceModelsOptions
     */
    public ListVoiceModelsOptions build() {
      return new ListVoiceModelsOptions(this);
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the ListVoiceModelsOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }
  }

  private ListVoiceModelsOptions(Builder builder) {
    language = builder.language;
  }

  /**
   * New builder.
   *
   * @return a ListVoiceModelsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the language.
   *
   * The language for which custom voice models that are owned by the requesting service credentials are to be returned.
   * Omit the parameter to see all custom voice models that are owned by the requester.
   *
   * @return the language
   */
  public String language() {
    return language;
  }
}

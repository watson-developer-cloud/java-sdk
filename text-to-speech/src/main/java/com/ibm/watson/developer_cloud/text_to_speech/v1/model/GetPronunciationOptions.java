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
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The getPronunciation options.
 */
public class GetPronunciationOptions extends GenericModel {

  /**
   * A voice that specifies the language in which the pronunciation is to be returned. All voices for the same language
   * (for example, `en-US`) return the same translation. Retrieve available voices with the `GET /v1/voices` method.
   */
  public interface Voice {
    /** en-US_AllisonVoice. */
    String EN_US_ALLISONVOICE = "en-US_AllisonVoice";
    /** en-US_LisaVoice. */
    String EN_US_LISAVOICE = "en-US_LisaVoice";
    /** en-US_MichaelVoice. */
    String EN_US_MICHAELVOICE = "en-US_MichaelVoice";
    /** en-GB_KateVoice. */
    String EN_GB_KATEVOICE = "en-GB_KateVoice";
    /** es-ES_EnriqueVoice. */
    String ES_ES_ENRIQUEVOICE = "es-ES_EnriqueVoice";
    /** es-ES_LauraVoice. */
    String ES_ES_LAURAVOICE = "es-ES_LauraVoice";
    /** es-LA_SofiaVoice. */
    String ES_LA_SOFIAVOICE = "es-LA_SofiaVoice";
    /** es-US_SofiaVoice. */
    String ES_US_SOFIAVOICE = "es-US_SofiaVoice";
    /** de-DE_DieterVoice. */
    String DE_DE_DIETERVOICE = "de-DE_DieterVoice";
    /** de-DE_BirgitVoice. */
    String DE_DE_BIRGITVOICE = "de-DE_BirgitVoice";
    /** fr-FR_ReneeVoice. */
    String FR_FR_RENEEVOICE = "fr-FR_ReneeVoice";
    /** it-IT_FrancescaVoice. */
    String IT_IT_FRANCESCAVOICE = "it-IT_FrancescaVoice";
    /** ja-JP_EmiVoice. */
    String JA_JP_EMIVOICE = "ja-JP_EmiVoice";
    /** pt-BR_IsabelaVoice. */
    String PT_BR_ISABELAVOICE = "pt-BR_IsabelaVoice";
  }

  /**
   * The phoneme format in which to return the pronunciation. Omit the parameter to obtain the pronunciation in the
   * default format.
   */
  public interface Format {
    /** ipa. */
    String IPA = "ipa";
    /** ibm. */
    String IBM = "ibm";
  }

  private String text;
  private String voice;
  private String format;
  private String customizationId;

  /**
   * Builder.
   */
  public static class Builder {
    private String text;
    private String voice;
    private String format;
    private String customizationId;

    private Builder(GetPronunciationOptions getPronunciationOptions) {
      text = getPronunciationOptions.text;
      voice = getPronunciationOptions.voice;
      format = getPronunciationOptions.format;
      customizationId = getPronunciationOptions.customizationId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param text the text
     */
    public Builder(String text) {
      this.text = text;
    }

    /**
     * Builds a GetPronunciationOptions.
     *
     * @return the getPronunciationOptions
     */
    public GetPronunciationOptions build() {
      return new GetPronunciationOptions(this);
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the GetPronunciationOptions builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the voice.
     *
     * @param voice the voice
     * @return the GetPronunciationOptions builder
     */
    public Builder voice(String voice) {
      this.voice = voice;
      return this;
    }

    /**
     * Set the format.
     *
     * @param format the format
     * @return the GetPronunciationOptions builder
     */
    public Builder format(String format) {
      this.format = format;
      return this;
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the GetPronunciationOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }
  }

  private GetPronunciationOptions(Builder builder) {
    Validator.notNull(builder.text, "text cannot be null");
    text = builder.text;
    voice = builder.voice;
    format = builder.format;
    customizationId = builder.customizationId;
  }

  /**
   * New builder.
   *
   * @return a GetPronunciationOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * The word for which the pronunciation is requested.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the voice.
   *
   * A voice that specifies the language in which the pronunciation is to be returned. All voices for the same language
   * (for example, `en-US`) return the same translation. Retrieve available voices with the `GET /v1/voices` method.
   *
   * @return the voice
   */
  public String voice() {
    return voice;
  }

  /**
   * Gets the format.
   *
   * The phoneme format in which to return the pronunciation. Omit the parameter to obtain the pronunciation in the
   * default format.
   *
   * @return the format
   */
  public String format() {
    return format;
  }

  /**
   * Gets the customizationId.
   *
   * The GUID of a custom voice model for which the pronunciation is to be returned. The language of a specified custom
   * model must match the language of the specified voice. If the word is not defined in the specified custom model, the
   * service returns the default translation for the custom model's language. You must make the request with service
   * credentials created for the instance of the service that owns the custom model. Omit the parameter to see the
   * translation for the specified voice with no customization.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }
}

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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The getVoice options.
 */
public class GetVoiceOptions extends GenericModel {

  /**
   * The voice for which information is to be returned.
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

  private String voice;
  private String customizationId;

  /**
   * Builder.
   */
  public static class Builder {
    private String voice;
    private String customizationId;

    private Builder(GetVoiceOptions getVoiceOptions) {
      voice = getVoiceOptions.voice;
      customizationId = getVoiceOptions.customizationId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param voice the voice
     */
    public Builder(String voice) {
      this.voice = voice;
    }

    /**
     * Builds a GetVoiceOptions.
     *
     * @return the getVoiceOptions
     */
    public GetVoiceOptions build() {
      return new GetVoiceOptions(this);
    }

    /**
     * Set the voice.
     *
     * @param voice the voice
     * @return the GetVoiceOptions builder
     */
    public Builder voice(String voice) {
      this.voice = voice;
      return this;
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the GetVoiceOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }
  }

  private GetVoiceOptions(Builder builder) {
    Validator.notEmpty(builder.voice, "voice cannot be empty");
    voice = builder.voice;
    customizationId = builder.customizationId;
  }

  /**
   * New builder.
   *
   * @return a GetVoiceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the voice.
   *
   * The voice for which information is to be returned.
   *
   * @return the voice
   */
  public String voice() {
    return voice;
  }

  /**
   * Gets the customizationId.
   *
   * The customization ID (GUID) of a custom voice model for which information is to be returned. You must make the
   * request with service credentials created for the instance of the service that owns the custom model. Omit the
   * parameter to see information about the specified voice with no customization.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }
}

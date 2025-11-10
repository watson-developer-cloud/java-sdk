/*
 * (C) Copyright IBM Corp. 2018, 2025.
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

/** The getVoice options. */
public class GetVoiceOptions extends GenericModel {

  /** The voice for which information is to be returned. */
  public interface Voice {
    /** de-DE_BirgitV3Voice. */
    String DE_DE_BIRGITV3VOICE = "de-DE_BirgitV3Voice";
    /** de-DE_DieterV3Voice. */
    String DE_DE_DIETERV3VOICE = "de-DE_DieterV3Voice";
    /** de-DE_ErikaV3Voice. */
    String DE_DE_ERIKAV3VOICE = "de-DE_ErikaV3Voice";
    /** en-AU_HeidiExpressive. */
    String EN_AU_HEIDIEXPRESSIVE = "en-AU_HeidiExpressive";
    /** en-AU_JackExpressive. */
    String EN_AU_JACKEXPRESSIVE = "en-AU_JackExpressive";
    /** en-CA_HannahNatural. */
    String EN_CA_HANNAHNATURAL = "en-CA_HannahNatural";
    /** en-GB_CharlotteV3Voice. */
    String EN_GB_CHARLOTTEV3VOICE = "en-GB_CharlotteV3Voice";
    /** en-GB_ChloeNatural. */
    String EN_GB_CHLOENATURAL = "en-GB_ChloeNatural";
    /** en-GB_GeorgeExpressive. */
    String EN_GB_GEORGEEXPRESSIVE = "en-GB_GeorgeExpressive";
    /** en-GB_JamesV3Voice. */
    String EN_GB_JAMESV3VOICE = "en-GB_JamesV3Voice";
    /** en-GB_GeorgeNatural. */
    String EN_GB_GEORGENATURAL = "en-GB_GeorgeNatural";
    /** en-GB_KateV3Voice. */
    String EN_GB_KATEV3VOICE = "en-GB_KateV3Voice";
    /** en-US_AllisonExpressive. */
    String EN_US_ALLISONEXPRESSIVE = "en-US_AllisonExpressive";
    /** en-US_AllisonV3Voice. */
    String EN_US_ALLISONV3VOICE = "en-US_AllisonV3Voice";
    /** en-US_EllieNatural. */
    String EN_US_ELLIENATURAL = "en-US_EllieNatural";
    /** en-US_EmilyV3Voice. */
    String EN_US_EMILYV3VOICE = "en-US_EmilyV3Voice";
    /** en-US_EmmaExpressive. */
    String EN_US_EMMAEXPRESSIVE = "en-US_EmmaExpressive";
    /** en-US_EmmaNatural. */
    String EN_US_EMMANATURAL = "en-US_EmmaNatural";
    /** en-US_EthanNatural. */
    String EN_US_ETHANNATURAL = "en-US_EthanNatural";
    /** en-US_HenryV3Voice. */
    String EN_US_HENRYV3VOICE = "en-US_HenryV3Voice";
    /** en-US_JacksonNatural. */
    String EN_US_JACKSONNATURAL = "en-US_JacksonNatural";
    /** en-US_KevinV3Voice. */
    String EN_US_KEVINV3VOICE = "en-US_KevinV3Voice";
    /** en-US_LisaExpressive. */
    String EN_US_LISAEXPRESSIVE = "en-US_LisaExpressive";
    /** en-US_LisaV3Voice. */
    String EN_US_LISAV3VOICE = "en-US_LisaV3Voice";
    /** en-US_MichaelExpressive. */
    String EN_US_MICHAELEXPRESSIVE = "en-US_MichaelExpressive";
    /** en-US_MichaelV3Voice. */
    String EN_US_MICHAELV3VOICE = "en-US_MichaelV3Voice";
    /** en-US_OliviaV3Voice. */
    String EN_US_OLIVIAV3VOICE = "en-US_OliviaV3Voice";
    /** en-US_VictoriaNatural. */
    String EN_US_VICTORIANATURAL = "en-US_VictoriaNatural";
    /** es-ES_EnriqueV3Voice. */
    String ES_ES_ENRIQUEV3VOICE = "es-ES_EnriqueV3Voice";
    /** es-ES_LauraV3Voice. */
    String ES_ES_LAURAV3VOICE = "es-ES_LauraV3Voice";
    /** es-LA_DanielaExpressive. */
    String ES_LA_DANIELAEXPRESSIVE = "es-LA_DanielaExpressive";
    /** es-LA_SofiaV3Voice. */
    String ES_LA_SOFIAV3VOICE = "es-LA_SofiaV3Voice";
    /** es-US_SofiaV3Voice. */
    String ES_US_SOFIAV3VOICE = "es-US_SofiaV3Voice";
    /** fr-CA_LouiseV3Voice. */
    String FR_CA_LOUISEV3VOICE = "fr-CA_LouiseV3Voice";
    /** fr-FR_NicolasV3Voice. */
    String FR_FR_NICOLASV3VOICE = "fr-FR_NicolasV3Voice";
    /** fr-FR_ReneeV3Voice. */
    String FR_FR_RENEEV3VOICE = "fr-FR_ReneeV3Voice";
    /** it-IT_FrancescaV3Voice. */
    String IT_IT_FRANCESCAV3VOICE = "it-IT_FrancescaV3Voice";
    /** ja-JP_EmiV3Voice. */
    String JA_JP_EMIV3VOICE = "ja-JP_EmiV3Voice";
    /** ko-KR_JinV3Voice. */
    String KO_KR_JINV3VOICE = "ko-KR_JinV3Voice";
    /** nl-NL_MerelV3Voice. */
    String NL_NL_MERELV3VOICE = "nl-NL_MerelV3Voice";
    /** pt-BR_CamilaNatural. */
    String PT_BR_CAMILANATURAL = "pt-BR_CamilaNatural";
    /** pt-BR_IsabelaV3Voice. */
    String PT_BR_ISABELAV3VOICE = "pt-BR_IsabelaV3Voice";
    /** pt-BR_LucasExpressive. */
    String PT_BR_LUCASEXPRESSIVE = "pt-BR_LucasExpressive";
    /** pt-BR_LucasNatural. */
    String PT_BR_LUCASNATURAL = "pt-BR_LucasNatural";
  }

  protected String voice;
  protected String customizationId;

  /** Builder. */
  public static class Builder {
    private String voice;
    private String customizationId;

    /**
     * Instantiates a new Builder from an existing GetVoiceOptions instance.
     *
     * @param getVoiceOptions the instance to initialize the Builder with
     */
    private Builder(GetVoiceOptions getVoiceOptions) {
      this.voice = getVoiceOptions.voice;
      this.customizationId = getVoiceOptions.customizationId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

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
     * @return the new GetVoiceOptions instance
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

  protected GetVoiceOptions() {}

  protected GetVoiceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.voice, "voice cannot be empty");
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
   * <p>The voice for which information is to be returned.
   *
   * @return the voice
   */
  public String voice() {
    return voice;
  }

  /**
   * Gets the customizationId.
   *
   * <p>The customization ID (GUID) of a custom model for which information is to be returned. You
   * must make the request with credentials for the instance of the service that owns the custom
   * model. Omit the parameter to see information about the specified voice with no customization.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }
}

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
package com.ibm.watson.text_to_speech.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The getVoice options. */
public class GetVoiceOptions extends GenericModel {

  /** The voice for which information is to be returned. */
  public interface Voice {
    /** ar-AR_OmarVoice. */
    String AR_AR_OMARVOICE = "ar-AR_OmarVoice";
    /** de-DE_BirgitVoice. */
    String DE_DE_BIRGITVOICE = "de-DE_BirgitVoice";
    /** de-DE_BirgitV3Voice. */
    String DE_DE_BIRGITV3VOICE = "de-DE_BirgitV3Voice";
    /** de-DE_DieterVoice. */
    String DE_DE_DIETERVOICE = "de-DE_DieterVoice";
    /** de-DE_DieterV3Voice. */
    String DE_DE_DIETERV3VOICE = "de-DE_DieterV3Voice";
    /** de-DE_ErikaV3Voice. */
    String DE_DE_ERIKAV3VOICE = "de-DE_ErikaV3Voice";
    /** en-GB_CharlotteV3Voice. */
    String EN_GB_CHARLOTTEV3VOICE = "en-GB_CharlotteV3Voice";
    /** en-GB_JamesV3Voice. */
    String EN_GB_JAMESV3VOICE = "en-GB_JamesV3Voice";
    /** en-GB_KateVoice. */
    String EN_GB_KATEVOICE = "en-GB_KateVoice";
    /** en-GB_KateV3Voice. */
    String EN_GB_KATEV3VOICE = "en-GB_KateV3Voice";
    /** en-US_AllisonVoice. */
    String EN_US_ALLISONVOICE = "en-US_AllisonVoice";
    /** en-US_AllisonV3Voice. */
    String EN_US_ALLISONV3VOICE = "en-US_AllisonV3Voice";
    /** en-US_EmilyV3Voice. */
    String EN_US_EMILYV3VOICE = "en-US_EmilyV3Voice";
    /** en-US_HenryV3Voice. */
    String EN_US_HENRYV3VOICE = "en-US_HenryV3Voice";
    /** en-US_KevinV3Voice. */
    String EN_US_KEVINV3VOICE = "en-US_KevinV3Voice";
    /** en-US_LisaVoice. */
    String EN_US_LISAVOICE = "en-US_LisaVoice";
    /** en-US_LisaV3Voice. */
    String EN_US_LISAV3VOICE = "en-US_LisaV3Voice";
    /** en-US_MichaelVoice. */
    String EN_US_MICHAELVOICE = "en-US_MichaelVoice";
    /** en-US_MichaelV3Voice. */
    String EN_US_MICHAELV3VOICE = "en-US_MichaelV3Voice";
    /** en-US_OliviaV3Voice. */
    String EN_US_OLIVIAV3VOICE = "en-US_OliviaV3Voice";
    /** es-ES_EnriqueVoice. */
    String ES_ES_ENRIQUEVOICE = "es-ES_EnriqueVoice";
    /** es-ES_EnriqueV3Voice. */
    String ES_ES_ENRIQUEV3VOICE = "es-ES_EnriqueV3Voice";
    /** es-ES_LauraVoice. */
    String ES_ES_LAURAVOICE = "es-ES_LauraVoice";
    /** es-ES_LauraV3Voice. */
    String ES_ES_LAURAV3VOICE = "es-ES_LauraV3Voice";
    /** es-LA_SofiaVoice. */
    String ES_LA_SOFIAVOICE = "es-LA_SofiaVoice";
    /** es-LA_SofiaV3Voice. */
    String ES_LA_SOFIAV3VOICE = "es-LA_SofiaV3Voice";
    /** es-US_SofiaVoice. */
    String ES_US_SOFIAVOICE = "es-US_SofiaVoice";
    /** es-US_SofiaV3Voice. */
    String ES_US_SOFIAV3VOICE = "es-US_SofiaV3Voice";
    /** fr-FR_NicolasV3Voice. */
    String FR_FR_NICOLASV3VOICE = "fr-FR_NicolasV3Voice";
    /** fr-FR_ReneeVoice. */
    String FR_FR_RENEEVOICE = "fr-FR_ReneeVoice";
    /** fr-FR_ReneeV3Voice. */
    String FR_FR_RENEEV3VOICE = "fr-FR_ReneeV3Voice";
    /** it-IT_FrancescaVoice. */
    String IT_IT_FRANCESCAVOICE = "it-IT_FrancescaVoice";
    /** it-IT_FrancescaV3Voice. */
    String IT_IT_FRANCESCAV3VOICE = "it-IT_FrancescaV3Voice";
    /** ja-JP_EmiVoice. */
    String JA_JP_EMIVOICE = "ja-JP_EmiVoice";
    /** ja-JP_EmiV3Voice. */
    String JA_JP_EMIV3VOICE = "ja-JP_EmiV3Voice";
    /** ko-KR_YoungmiVoice. */
    String KO_KR_YOUNGMIVOICE = "ko-KR_YoungmiVoice";
    /** ko-KR_YunaVoice. */
    String KO_KR_YUNAVOICE = "ko-KR_YunaVoice";
    /** nl-NL_EmmaVoice. */
    String NL_NL_EMMAVOICE = "nl-NL_EmmaVoice";
    /** nl-NL_LiamVoice. */
    String NL_NL_LIAMVOICE = "nl-NL_LiamVoice";
    /** pt-BR_IsabelaVoice. */
    String PT_BR_ISABELAVOICE = "pt-BR_IsabelaVoice";
    /** pt-BR_IsabelaV3Voice. */
    String PT_BR_ISABELAV3VOICE = "pt-BR_IsabelaV3Voice";
    /** zh-CN_LiNaVoice. */
    String ZH_CN_LINAVOICE = "zh-CN_LiNaVoice";
    /** zh-CN_WangWeiVoice. */
    String ZH_CN_WANGWEIVOICE = "zh-CN_WangWeiVoice";
    /** zh-CN_ZhangJingVoice. */
    String ZH_CN_ZHANGJINGVOICE = "zh-CN_ZhangJingVoice";
  }

  protected String voice;
  protected String customizationId;

  /** Builder. */
  public static class Builder {
    private String voice;
    private String customizationId;

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
   * <p>The customization ID (GUID) of a custom voice model for which information is to be returned.
   * You must make the request with credentials for the instance of the service that owns the custom
   * model. Omit the parameter to see information about the specified voice with no customization.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }
}

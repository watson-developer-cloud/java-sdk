/*
 * (C) Copyright IBM Corp. 2022.
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
import java.util.List;

/** The synthesize options. */
public class SynthesizeOptions extends GenericModel {

  /**
   * The voice to use for speech synthesis. If you omit the `voice` parameter, the service uses the
   * US English `en-US_MichaelV3Voice` by default.
   *
   * <p>_For IBM Cloud Pak for Data,_ if you do not install the `en-US_MichaelV3Voice`, you must
   * either specify a voice with the request or specify a new default voice for your installation of
   * the service.
   *
   * <p>**See also:** * [Using languages and
   * voices](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-voices) * [The default
   * voice](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-voices#specify-voice-default).
   */
  public interface Voice {
    /** ar-MS_OmarVoice. */
    String AR_MS_OMARVOICE = "ar-MS_OmarVoice";
    /** cs-CZ_AlenaVoice. */
    String CS_CZ_ALENAVOICE = "cs-CZ_AlenaVoice";
    /** de-DE_BirgitV3Voice. */
    String DE_DE_BIRGITV3VOICE = "de-DE_BirgitV3Voice";
    /** de-DE_DieterV3Voice. */
    String DE_DE_DIETERV3VOICE = "de-DE_DieterV3Voice";
    /** de-DE_ErikaV3Voice. */
    String DE_DE_ERIKAV3VOICE = "de-DE_ErikaV3Voice";
    /** en-AU_CraigVoice. */
    String EN_AU_CRAIGVOICE = "en-AU_CraigVoice";
    /** en-AU_MadisonVoice. */
    String EN_AU_MADISONVOICE = "en-AU_MadisonVoice";
    /** en-AU_SteveVoice. */
    String EN_AU_STEVEVOICE = "en-AU_SteveVoice";
    /** en-GB_CharlotteV3Voice. */
    String EN_GB_CHARLOTTEV3VOICE = "en-GB_CharlotteV3Voice";
    /** en-GB_JamesV3Voice. */
    String EN_GB_JAMESV3VOICE = "en-GB_JamesV3Voice";
    /** en-GB_KateV3Voice. */
    String EN_GB_KATEV3VOICE = "en-GB_KateV3Voice";
    /** en-US_AllisonV3Voice. */
    String EN_US_ALLISONV3VOICE = "en-US_AllisonV3Voice";
    /** en-US_EmilyV3Voice. */
    String EN_US_EMILYV3VOICE = "en-US_EmilyV3Voice";
    /** en-US_HenryV3Voice. */
    String EN_US_HENRYV3VOICE = "en-US_HenryV3Voice";
    /** en-US_KevinV3Voice. */
    String EN_US_KEVINV3VOICE = "en-US_KevinV3Voice";
    /** en-US_LisaV3Voice. */
    String EN_US_LISAV3VOICE = "en-US_LisaV3Voice";
    /** en-US_MichaelV3Voice. */
    String EN_US_MICHAELV3VOICE = "en-US_MichaelV3Voice";
    /** en-US_OliviaV3Voice. */
    String EN_US_OLIVIAV3VOICE = "en-US_OliviaV3Voice";
    /** es-ES_EnriqueV3Voice. */
    String ES_ES_ENRIQUEV3VOICE = "es-ES_EnriqueV3Voice";
    /** es-ES_LauraV3Voice. */
    String ES_ES_LAURAV3VOICE = "es-ES_LauraV3Voice";
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
    /** ko-KR_HyunjunVoice. */
    String KO_KR_HYUNJUNVOICE = "ko-KR_HyunjunVoice";
    /** ko-KR_SiWooVoice. */
    String KO_KR_SIWOOVOICE = "ko-KR_SiWooVoice";
    /** ko-KR_YoungmiVoice. */
    String KO_KR_YOUNGMIVOICE = "ko-KR_YoungmiVoice";
    /** ko-KR_YunaVoice. */
    String KO_KR_YUNAVOICE = "ko-KR_YunaVoice";
    /** nl-BE_AdeleVoice. */
    String NL_BE_ADELEVOICE = "nl-BE_AdeleVoice";
    /** nl-BE_BramVoice. */
    String NL_BE_BRAMVOICE = "nl-BE_BramVoice";
    /** nl-NL_EmmaVoice. */
    String NL_NL_EMMAVOICE = "nl-NL_EmmaVoice";
    /** nl-NL_LiamVoice. */
    String NL_NL_LIAMVOICE = "nl-NL_LiamVoice";
    /** pt-BR_IsabelaV3Voice. */
    String PT_BR_ISABELAV3VOICE = "pt-BR_IsabelaV3Voice";
    /** sv-SE_IngridVoice. */
    String SV_SE_INGRIDVOICE = "sv-SE_IngridVoice";
    /** zh-CN_LiNaVoice. */
    String ZH_CN_LINAVOICE = "zh-CN_LiNaVoice";
    /** zh-CN_WangWeiVoice. */
    String ZH_CN_WANGWEIVOICE = "zh-CN_WangWeiVoice";
    /** zh-CN_ZhangJingVoice. */
    String ZH_CN_ZHANGJINGVOICE = "zh-CN_ZhangJingVoice";
  }

  /**
   * *For German voices,* indicates how the service is to spell out strings of individual letters.
   * To indicate the pace of the spelling, specify one of the following values: * `default` - The
   * service reads the characters at the rate at which it synthesizes speech for the request. You
   * can also omit the parameter entirely to achieve the default behavior. * `singles` - The service
   * reads the characters one at a time, with a brief pause between each character. * `pairs` - The
   * service reads the characters two at a time, with a brief pause between each pair. * `triples` -
   * The service reads the characters three at a time, with a brief pause between each triplet.
   *
   * <p>The parameter is available only for IBM Cloud.
   *
   * <p>**See also:** [Specifying how strings are spelled
   * out](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-synthesis-params#params-spell-out-mode).
   */
  public interface SpellOutMode {
    /** default. */
    String X_DEFAULT = "default";
    /** singles. */
    String SINGLES = "singles";
    /** pairs. */
    String PAIRS = "pairs";
    /** triples. */
    String TRIPLES = "triples";
  }

  protected String text;
  protected String accept;
  protected String voice;
  protected String customizationId;
  protected List<String> timings;
  protected String spellOutMode;

  /** Builder. */
  public static class Builder {
    private String text;
    private String accept;
    private String voice;
    private String customizationId;
    protected List<String> timings;
    private String spellOutMode;

    private Builder(SynthesizeOptions synthesizeOptions) {
      this.text = synthesizeOptions.text;
      this.accept = synthesizeOptions.accept;
      this.voice = synthesizeOptions.voice;
      this.customizationId = synthesizeOptions.customizationId;
      this.timings = synthesizeOptions.timings;
      this.spellOutMode = synthesizeOptions.spellOutMode;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param text the text
     */
    public Builder(String text) {
      this.text = text;
    }

    /**
     * Builds a SynthesizeOptions.
     *
     * @return the new SynthesizeOptions instance
     */
    public SynthesizeOptions build() {
      return new SynthesizeOptions(this);
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the SynthesizeOptions builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the accept.
     *
     * @param accept the accept
     * @return the SynthesizeOptions builder
     */
    public Builder accept(String accept) {
      this.accept = accept;
      return this;
    }

    /**
     * Set the voice.
     *
     * @param voice the voice
     * @return the SynthesizeOptions builder
     */
    public Builder voice(String voice) {
      this.voice = voice;
      return this;
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the SynthesizeOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the timings.
     *
     * @param timings the timings
     * @return the SynthesizeOptions builder
     */
    public Builder timings(List<String> timings) {
      this.timings = timings;
      return this;
    }

    /**
     * Set the spellOutMode.
     *
     * @param spellOutMode the spellOutMode
     * @return the SynthesizeOptions builder
     */
    public Builder spellOutMode(String spellOutMode) {
      this.spellOutMode = spellOutMode;
      return this;
    }
  }

  protected SynthesizeOptions() {}

  protected SynthesizeOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text, "text cannot be null");
    text = builder.text;
    accept = builder.accept;
    voice = builder.voice;
    customizationId = builder.customizationId;
    timings = builder.timings;
    spellOutMode = builder.spellOutMode;
  }

  /**
   * New builder.
   *
   * @return a SynthesizeOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * <p>The text to synthesize.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the accept.
   *
   * <p>The requested format (MIME type) of the audio. You can use the `Accept` header or the
   * `accept` parameter to specify the audio format. For more information about specifying an audio
   * format, see **Audio formats (accept types)** in the method description.
   *
   * @return the accept
   */
  public String accept() {
    return accept;
  }

  /**
   * Gets the voice.
   *
   * <p>The voice to use for speech synthesis. If you omit the `voice` parameter, the service uses
   * the US English `en-US_MichaelV3Voice` by default.
   *
   * <p>_For IBM Cloud Pak for Data,_ if you do not install the `en-US_MichaelV3Voice`, you must
   * either specify a voice with the request or specify a new default voice for your installation of
   * the service.
   *
   * <p>**See also:** * [Using languages and
   * voices](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-voices) * [The default
   * voice](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-voices#specify-voice-default).
   *
   * @return the voice
   */
  public String voice() {
    return voice;
  }

  /**
   * Gets the customizationId.
   *
   * <p>The customization ID (GUID) of a custom model to use for the synthesis. If a custom model is
   * specified, it works only if it matches the language of the indicated voice. You must make the
   * request with credentials for the instance of the service that owns the custom model. Omit the
   * parameter to use the specified voice with no customization.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the timings.
   *
   * <p>An array that specifies whether the service is to return word timing information for all
   * strings of the input text. Specify `words` as the element of the array to request word timing
   * information. The service returns the start and end time of each word of the input. Specify an
   * empty array or omit the parameter to receive no word timing information. Not supported for
   * Japanese input text.
   *
   * <p>NOTE: This parameter only works for the `synthesizeUsingWebSocket` method.
   *
   * @return the timings
   */
  public List<String> getTimings() {
    return timings;
  }

  /**
   * Gets the spellOutMode.
   *
   * <p>*For German voices,* indicates how the service is to spell out strings of individual
   * letters. To indicate the pace of the spelling, specify one of the following values: * `default`
   * - The service reads the characters at the rate at which it synthesizes speech for the request.
   * You can also omit the parameter entirely to achieve the default behavior. * `singles` - The
   * service reads the characters one at a time, with a brief pause between each character. *
   * `pairs` - The service reads the characters two at a time, with a brief pause between each pair.
   * * `triples` - The service reads the characters three at a time, with a brief pause between each
   * triplet.
   *
   * <p>The parameter is available only for IBM Cloud.
   *
   * <p>**See also:** [Specifying how strings are spelled
   * out](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-synthesis-params#params-spell-out-mode).
   *
   * @return the spellOutMode
   */
  public String spellOutMode() {
    return spellOutMode;
  }
}

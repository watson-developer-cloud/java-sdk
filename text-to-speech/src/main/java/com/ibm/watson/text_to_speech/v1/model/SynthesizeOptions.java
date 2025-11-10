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
   * <p>**See also:** * [Languages and
   * voices](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-voices) * [Using the
   * default
   * voice](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-voices-use#specify-voice-default).
   */
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

  /**
   * *For German voices,* indicates how the service is to spell out strings of individual letters.
   * To indicate the pace of the spelling, specify one of the following values: * `default` - The
   * service reads the characters at the rate at which it synthesizes speech for the request. You
   * can also omit the parameter entirely to achieve the default behavior. * `singles` - The service
   * reads the characters one at a time, with a brief pause between each character. * `pairs` - The
   * service reads the characters two at a time, with a brief pause between each pair. * `triples` -
   * The service reads the characters three at a time, with a brief pause between each triplet.
   *
   * <p>For more information, see [Specifying how strings are spelled
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
  protected String spellOutMode;
  protected Long ratePercentage;
  protected Long pitchPercentage;
  protected List<String> timings;

  /** Builder. */
  public static class Builder {
    private String text;
    private String accept;
    private String voice;
    private String customizationId;
    private String spellOutMode;
    private Long ratePercentage;
    private Long pitchPercentage;
    private List<String> timings;

    /**
     * Instantiates a new Builder from an existing SynthesizeOptions instance.
     *
     * @param synthesizeOptions the instance to initialize the Builder with
     */
    private Builder(SynthesizeOptions synthesizeOptions) {
      this.text = synthesizeOptions.text;
      this.accept = synthesizeOptions.accept;
      this.voice = synthesizeOptions.voice;
      this.customizationId = synthesizeOptions.customizationId;
      this.spellOutMode = synthesizeOptions.spellOutMode;
      this.ratePercentage = synthesizeOptions.ratePercentage;
      this.pitchPercentage = synthesizeOptions.pitchPercentage;
      this.timings = synthesizeOptions.timings;
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
     * Set the spellOutMode.
     *
     * @param spellOutMode the spellOutMode
     * @return the SynthesizeOptions builder
     */
    public Builder spellOutMode(String spellOutMode) {
      this.spellOutMode = spellOutMode;
      return this;
    }

    /**
     * Set the ratePercentage.
     *
     * @param ratePercentage the ratePercentage
     * @return the SynthesizeOptions builder
     */
    public Builder ratePercentage(long ratePercentage) {
      this.ratePercentage = ratePercentage;
      return this;
    }

    /**
     * Set the pitchPercentage.
     *
     * @param pitchPercentage the pitchPercentage
     * @return the SynthesizeOptions builder
     */
    public Builder pitchPercentage(long pitchPercentage) {
      this.pitchPercentage = pitchPercentage;
      return this;
    }

    /**
     * Set the timings.
     *
     * @param timings the list of timings
     * @return the SynthesizeOptions builder
     */
    public Builder timings(List<String> timings) {
      this.timings = timings;
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
    spellOutMode = builder.spellOutMode;
    ratePercentage = builder.ratePercentage;
    pitchPercentage = builder.pitchPercentage;
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
   * <p>**See also:** * [Languages and
   * voices](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-voices) * [Using the
   * default
   * voice](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-voices-use#specify-voice-default).
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
   * <p>For more information, see [Specifying how strings are spelled
   * out](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-synthesis-params#params-spell-out-mode).
   *
   * @return the spellOutMode
   */
  public String spellOutMode() {
    return spellOutMode;
  }

  /**
   * Gets the ratePercentage.
   *
   * <p>The percentage change from the default speaking rate of the voice that is used for speech
   * synthesis. Each voice has a default speaking rate that is optimized to represent a normal rate
   * of speech. The parameter accepts an integer that represents the percentage change from the
   * voice's default rate: * Specify a signed negative integer to reduce the speaking rate by that
   * percentage. For example, -10 reduces the rate by ten percent. * Specify an unsigned or signed
   * positive integer to increase the speaking rate by that percentage. For example, 10 and +10
   * increase the rate by ten percent. * Specify 0 or omit the parameter to get the default speaking
   * rate for the voice.
   *
   * <p>The parameter affects the rate for an entire request.
   *
   * <p>For more information, see [Modifying the speaking
   * rate](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-synthesis-params#params-rate-percentage).
   *
   * @return the ratePercentage
   */
  public Long ratePercentage() {
    return ratePercentage;
  }

  /**
   * Gets the pitchPercentage.
   *
   * <p>The percentage change from the default speaking pitch of the voice that is used for speech
   * synthesis. Each voice has a default speaking pitch that is optimized to represent a normal tone
   * of voice. The parameter accepts an integer that represents the percentage change from the
   * voice's default tone: * Specify a signed negative integer to lower the voice's pitch by that
   * percentage. For example, -5 reduces the tone by five percent. * Specify an unsigned or signed
   * positive integer to increase the voice's pitch by that percentage. For example, 5 and +5
   * increase the tone by five percent. * Specify 0 or omit the parameter to get the default
   * speaking pitch for the voice.
   *
   * <p>The parameter affects the pitch for an entire request.
   *
   * <p>For more information, see [Modifying the speaking
   * pitch](https://cloud.ibm.com/docs/text-to-speech?topic=text-to-speech-synthesis-params#params-pitch-percentage).
   *
   * @return the pitchPercentage
   */
  public Long pitchPercentage() {
    return pitchPercentage;
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
  public List<String> timings() {
    return timings;
  }
}

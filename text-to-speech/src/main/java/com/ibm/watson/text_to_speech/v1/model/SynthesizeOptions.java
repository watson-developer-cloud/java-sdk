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
package com.ibm.watson.text_to_speech.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

import java.util.List;

/**
 * The synthesize options.
 */
public class SynthesizeOptions extends GenericModel {

  /**
   * The requested format (MIME type) of the audio. You can use the `Accept` header or the `accept` parameter to specify
   * the audio format. For more information about specifying an audio format, see **Audio formats (accept types)** in
   * the method description.
   *
   * Default: `audio/ogg;codecs=opus`.
   */
  public interface Accept {
    /** audio/basic. */
    String AUDIO_BASIC = "audio/basic";
    /** audio/flac. */
    String AUDIO_FLAC = "audio/flac";
    /** audio/l16. */
    String AUDIO_L16 = "audio/l16";
    /** audio/ogg. */
    String AUDIO_OGG = "audio/ogg";
    /** audio/ogg;codecs=opus. */
    String AUDIO_OGG_CODECS_OPUS = "audio/ogg;codecs=opus";
    /** audio/ogg;codecs=vorbis. */
    String AUDIO_OGG_CODECS_VORBIS = "audio/ogg;codecs=vorbis";
    /** audio/mp3. */
    String AUDIO_MP3 = "audio/mp3";
    /** audio/mpeg. */
    String AUDIO_MPEG = "audio/mpeg";
    /** audio/mulaw. */
    String AUDIO_MULAW = "audio/mulaw";
    /** audio/wav. */
    String AUDIO_WAV = "audio/wav";
    /** audio/webm. */
    String AUDIO_WEBM = "audio/webm";
    /** audio/webm;codecs=opus. */
    String AUDIO_WEBM_CODECS_OPUS = "audio/webm;codecs=opus";
    /** audio/webm;codecs=vorbis. */
    String AUDIO_WEBM_CODECS_VORBIS = "audio/webm;codecs=vorbis";
  }

  /**
   * The voice to use for synthesis.
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

  private String text;
  private String accept;
  private String voice;
  private String customizationId;
  private List<String> timings;

  /**
   * Builder.
   */
  public static class Builder {
    private String text;
    private String accept;
    private String voice;
    private String customizationId;
    private List<String> timings;

    private Builder(SynthesizeOptions synthesizeOptions) {
      text = synthesizeOptions.text;
      accept = synthesizeOptions.accept;
      voice = synthesizeOptions.voice;
      customizationId = synthesizeOptions.customizationId;
      timings = synthesizeOptions.timings;
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
     * Builds a SynthesizeOptions.
     *
     * @return the synthesizeOptions
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
  }

  private SynthesizeOptions(Builder builder) {
    Validator.notNull(builder.text, "text cannot be null");
    text = builder.text;
    accept = builder.accept;
    voice = builder.voice;
    customizationId = builder.customizationId;
    timings = builder.timings;
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
   * The text to synthesize.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the accept.
   *
   * The requested format (MIME type) of the audio. You can use the `Accept` header or the `accept` parameter to specify
   * the audio format. For more information about specifying an audio format, see **Audio formats (accept types)** in
   * the method description.
   *
   * Default: `audio/ogg;codecs=opus`.
   *
   * @return the accept
   */
  public String accept() {
    return accept;
  }

  /**
   * Gets the voice.
   *
   * The voice to use for synthesis.
   *
   * @return the voice
   */
  public String voice() {
    return voice;
  }

  /**
   * Gets the customizationId.
   *
   * The customization ID (GUID) of a custom voice model to use for the synthesis. If a custom voice model is specified,
   * it is guaranteed to work only if it matches the language of the indicated voice. You must make the request with
   * service credentials created for the instance of the service that owns the custom model. Omit the parameter to use
   * the specified voice with no customization.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the timings.
   *
   * An array that specifies whether the service is to return word timing information for all strings of the input
   * text. Specify `words` as the element of the array to request word timing information. The service returns the
   * start and end time of each word of the input. Specify an empty array or omit the parameter to receive no word
   * timing information. Not supported for Japanese input text.
   *
   * NOTE: This parameter only works for the `synthesizeUsingWebSocket` method.
   *
   * @return the timings
   */
  public List<String> timings() {
    return timings;
  }
}

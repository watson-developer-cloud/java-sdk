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
package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The recognize options.
 */
public class RecognizeOptions extends GenericModel {

  /**
   * The type of the input.
   */
  public interface ContentType {
    /** application/octet-stream. */
    String APPLICATION_OCTET_STREAM = "application/octet-stream";
    /** audio/basic. */
    String AUDIO_BASIC = "audio/basic";
    /** audio/flac. */
    String AUDIO_FLAC = "audio/flac";
    /** audio/l16. */
    String AUDIO_L16 = "audio/l16";
    /** audio/mp3. */
    String AUDIO_MP3 = "audio/mp3";
    /** audio/mpeg. */
    String AUDIO_MPEG = "audio/mpeg";
    /** audio/mulaw. */
    String AUDIO_MULAW = "audio/mulaw";
    /** audio/ogg. */
    String AUDIO_OGG = "audio/ogg";
    /** audio/ogg;codecs=opus. */
    String AUDIO_OGG_CODECS_OPUS = "audio/ogg;codecs=opus";
    /** audio/ogg;codecs=vorbis. */
    String AUDIO_OGG_CODECS_VORBIS = "audio/ogg;codecs=vorbis";
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
   * The identifier of the model that is to be used for the recognition request.
   */
  public interface Model {
    /** ar-AR_BroadbandModel. */
    String AR_AR_BROADBANDMODEL = "ar-AR_BroadbandModel";
    /** de-DE_BroadbandModel. */
    String DE_DE_BROADBANDMODEL = "de-DE_BroadbandModel";
    /** en-GB_BroadbandModel. */
    String EN_GB_BROADBANDMODEL = "en-GB_BroadbandModel";
    /** en-GB_NarrowbandModel. */
    String EN_GB_NARROWBANDMODEL = "en-GB_NarrowbandModel";
    /** en-US_BroadbandModel. */
    String EN_US_BROADBANDMODEL = "en-US_BroadbandModel";
    /** en-US_NarrowbandModel. */
    String EN_US_NARROWBANDMODEL = "en-US_NarrowbandModel";
    /** es-ES_BroadbandModel. */
    String ES_ES_BROADBANDMODEL = "es-ES_BroadbandModel";
    /** es-ES_NarrowbandModel. */
    String ES_ES_NARROWBANDMODEL = "es-ES_NarrowbandModel";
    /** fr-FR_BroadbandModel. */
    String FR_FR_BROADBANDMODEL = "fr-FR_BroadbandModel";
    /** ja-JP_BroadbandModel. */
    String JA_JP_BROADBANDMODEL = "ja-JP_BroadbandModel";
    /** ja-JP_NarrowbandModel. */
    String JA_JP_NARROWBANDMODEL = "ja-JP_NarrowbandModel";
    /** ko-KR_BroadbandModel. */
    String KO_KR_BROADBANDMODEL = "ko-KR_BroadbandModel";
    /** ko-KR_NarrowbandModel. */
    String KO_KR_NARROWBANDMODEL = "ko-KR_NarrowbandModel";
    /** pt-BR_BroadbandModel. */
    String PT_BR_BROADBANDMODEL = "pt-BR_BroadbandModel";
    /** pt-BR_NarrowbandModel. */
    String PT_BR_NARROWBANDMODEL = "pt-BR_NarrowbandModel";
    /** zh-CN_BroadbandModel. */
    String ZH_CN_BROADBANDMODEL = "zh-CN_BroadbandModel";
    /** zh-CN_NarrowbandModel. */
    String ZH_CN_NARROWBANDMODEL = "zh-CN_NarrowbandModel";
  }

  private InputStream audio;
  private String contentType;
  private String model;
  private String languageCustomizationId;
  private String acousticCustomizationId;
  private String baseModelVersion;
  private Double customizationWeight;
  private Long inactivityTimeout;
  private List<String> keywords;
  private Float keywordsThreshold;
  private Long maxAlternatives;
  private Float wordAlternativesThreshold;
  private Boolean wordConfidence;
  private Boolean timestamps;
  private Boolean profanityFilter;
  private Boolean smartFormatting;
  private Boolean speakerLabels;
  private String customizationId;

  /**
   * Builder.
   */
  public static class Builder {
    private InputStream audio;
    private String contentType;
    private String model;
    private String languageCustomizationId;
    private String acousticCustomizationId;
    private String baseModelVersion;
    private Double customizationWeight;
    private Long inactivityTimeout;
    private List<String> keywords;
    private Float keywordsThreshold;
    private Long maxAlternatives;
    private Float wordAlternativesThreshold;
    private Boolean wordConfidence;
    private Boolean timestamps;
    private Boolean profanityFilter;
    private Boolean smartFormatting;
    private Boolean speakerLabels;
    private String customizationId;

    private Builder(RecognizeOptions recognizeOptions) {
      audio = recognizeOptions.audio;
      contentType = recognizeOptions.contentType;
      model = recognizeOptions.model;
      languageCustomizationId = recognizeOptions.languageCustomizationId;
      acousticCustomizationId = recognizeOptions.acousticCustomizationId;
      baseModelVersion = recognizeOptions.baseModelVersion;
      customizationWeight = recognizeOptions.customizationWeight;
      inactivityTimeout = recognizeOptions.inactivityTimeout;
      keywords = recognizeOptions.keywords;
      keywordsThreshold = recognizeOptions.keywordsThreshold;
      maxAlternatives = recognizeOptions.maxAlternatives;
      wordAlternativesThreshold = recognizeOptions.wordAlternativesThreshold;
      wordConfidence = recognizeOptions.wordConfidence;
      timestamps = recognizeOptions.timestamps;
      profanityFilter = recognizeOptions.profanityFilter;
      smartFormatting = recognizeOptions.smartFormatting;
      speakerLabels = recognizeOptions.speakerLabels;
      customizationId = recognizeOptions.customizationId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param audio the audio
     * @param contentType the contentType
     */
    public Builder(InputStream audio, String contentType) {
      this.audio = audio;
      this.contentType = contentType;
    }

    /**
     * Builds a RecognizeOptions.
     *
     * @return the recognizeOptions
     */
    public RecognizeOptions build() {
      return new RecognizeOptions(this);
    }

    /**
     * Adds an keyword to keywords.
     *
     * @param keyword the new keyword
     * @return the RecognizeOptions builder
     */
    public Builder addKeyword(String keyword) {
      Validator.notNull(keyword, "keyword cannot be null");
      if (this.keywords == null) {
        this.keywords = new ArrayList<String>();
      }
      this.keywords.add(keyword);
      return this;
    }

    /**
     * Set the audio.
     *
     * @param audio the audio
     * @return the RecognizeOptions builder
     */
    public Builder audio(InputStream audio) {
      this.audio = audio;
      return this;
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the RecognizeOptions builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the model.
     *
     * @param model the model
     * @return the RecognizeOptions builder
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }

    /**
     * Set the languageCustomizationId.
     *
     * @param languageCustomizationId the languageCustomizationId
     * @return the RecognizeOptions builder
     */
    public Builder languageCustomizationId(String languageCustomizationId) {
      this.languageCustomizationId = languageCustomizationId;
      return this;
    }

    /**
     * Set the acousticCustomizationId.
     *
     * @param acousticCustomizationId the acousticCustomizationId
     * @return the RecognizeOptions builder
     */
    public Builder acousticCustomizationId(String acousticCustomizationId) {
      this.acousticCustomizationId = acousticCustomizationId;
      return this;
    }

    /**
     * Set the baseModelVersion.
     *
     * @param baseModelVersion the baseModelVersion
     * @return the RecognizeOptions builder
     */
    public Builder baseModelVersion(String baseModelVersion) {
      this.baseModelVersion = baseModelVersion;
      return this;
    }

    /**
     * Set the customizationWeight.
     *
     * @param customizationWeight the customizationWeight
     * @return the RecognizeOptions builder
     */
    public Builder customizationWeight(Double customizationWeight) {
      this.customizationWeight = customizationWeight;
      return this;
    }

    /**
     * Set the inactivityTimeout.
     *
     * @param inactivityTimeout the inactivityTimeout
     * @return the RecognizeOptions builder
     */
    public Builder inactivityTimeout(long inactivityTimeout) {
      this.inactivityTimeout = inactivityTimeout;
      return this;
    }

    /**
     * Set the keywords.
     * Existing keywords will be replaced.
     *
     * @param keywords the keywords
     * @return the RecognizeOptions builder
     */
    public Builder keywords(List<String> keywords) {
      this.keywords = keywords;
      return this;
    }

    /**
     * Set the keywordsThreshold.
     *
     * @param keywordsThreshold the keywordsThreshold
     * @return the RecognizeOptions builder
     */
    public Builder keywordsThreshold(Float keywordsThreshold) {
      this.keywordsThreshold = keywordsThreshold;
      return this;
    }

    /**
     * Set the maxAlternatives.
     *
     * @param maxAlternatives the maxAlternatives
     * @return the RecognizeOptions builder
     */
    public Builder maxAlternatives(long maxAlternatives) {
      this.maxAlternatives = maxAlternatives;
      return this;
    }

    /**
     * Set the wordAlternativesThreshold.
     *
     * @param wordAlternativesThreshold the wordAlternativesThreshold
     * @return the RecognizeOptions builder
     */
    public Builder wordAlternativesThreshold(Float wordAlternativesThreshold) {
      this.wordAlternativesThreshold = wordAlternativesThreshold;
      return this;
    }

    /**
     * Set the wordConfidence.
     *
     * @param wordConfidence the wordConfidence
     * @return the RecognizeOptions builder
     */
    public Builder wordConfidence(Boolean wordConfidence) {
      this.wordConfidence = wordConfidence;
      return this;
    }

    /**
     * Set the timestamps.
     *
     * @param timestamps the timestamps
     * @return the RecognizeOptions builder
     */
    public Builder timestamps(Boolean timestamps) {
      this.timestamps = timestamps;
      return this;
    }

    /**
     * Set the profanityFilter.
     *
     * @param profanityFilter the profanityFilter
     * @return the RecognizeOptions builder
     */
    public Builder profanityFilter(Boolean profanityFilter) {
      this.profanityFilter = profanityFilter;
      return this;
    }

    /**
     * Set the smartFormatting.
     *
     * @param smartFormatting the smartFormatting
     * @return the RecognizeOptions builder
     */
    public Builder smartFormatting(Boolean smartFormatting) {
      this.smartFormatting = smartFormatting;
      return this;
    }

    /**
     * Set the speakerLabels.
     *
     * @param speakerLabels the speakerLabels
     * @return the RecognizeOptions builder
     */
    public Builder speakerLabels(Boolean speakerLabels) {
      this.speakerLabels = speakerLabels;
      return this;
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the RecognizeOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the audio.
     *
     * @param audio the audio
     * @return the RecognizeOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder audio(File audio) throws FileNotFoundException {
      this.audio = new FileInputStream(audio);
      return this;
    }
  }

  private RecognizeOptions(Builder builder) {
    Validator.notNull(builder.audio, "audio cannot be null");
    Validator.notNull(builder.contentType, "contentType cannot be null");
    audio = builder.audio;
    contentType = builder.contentType;
    model = builder.model;
    languageCustomizationId = builder.languageCustomizationId;
    acousticCustomizationId = builder.acousticCustomizationId;
    baseModelVersion = builder.baseModelVersion;
    customizationWeight = builder.customizationWeight;
    inactivityTimeout = builder.inactivityTimeout;
    keywords = builder.keywords;
    keywordsThreshold = builder.keywordsThreshold;
    maxAlternatives = builder.maxAlternatives;
    wordAlternativesThreshold = builder.wordAlternativesThreshold;
    wordConfidence = builder.wordConfidence;
    timestamps = builder.timestamps;
    profanityFilter = builder.profanityFilter;
    smartFormatting = builder.smartFormatting;
    speakerLabels = builder.speakerLabels;
    customizationId = builder.customizationId;
  }

  /**
   * New builder.
   *
   * @return a RecognizeOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the audio.
   *
   * The audio to transcribe.
   *
   * @return the audio
   */
  public InputStream audio() {
    return audio;
  }

  /**
   * Gets the contentType.
   *
   * The type of the input.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }

  /**
   * Gets the model.
   *
   * The identifier of the model that is to be used for the recognition request.
   *
   * @return the model
   */
  public String model() {
    return model;
  }

  /**
   * Gets the languageCustomizationId.
   *
   * The customization ID (GUID) of a custom language model that is to be used with the recognition request. The base
   * model of the specified custom language model must match the model specified with the `model` parameter. You must
   * make the request with service credentials created for the instance of the service that owns the custom model. By
   * default, no custom language model is used. See [Custom
   * models](https://console.bluemix.net/docs/services/speech-to-text/input.html#custom).
   *
   * **Note:** Use this parameter instead of the deprecated `customization_id` parameter.
   *
   * @return the languageCustomizationId
   */
  public String languageCustomizationId() {
    return languageCustomizationId;
  }

  /**
   * Gets the acousticCustomizationId.
   *
   * The customization ID (GUID) of a custom acoustic model that is to be used with the recognition request. The base
   * model of the specified custom acoustic model must match the model specified with the `model` parameter. You must
   * make the request with service credentials created for the instance of the service that owns the custom model. By
   * default, no custom acoustic model is used. See [Custom
   * models](https://console.bluemix.net/docs/services/speech-to-text/input.html#custom).
   *
   * @return the acousticCustomizationId
   */
  public String acousticCustomizationId() {
    return acousticCustomizationId;
  }

  /**
   * Gets the baseModelVersion.
   *
   * The version of the specified base model that is to be used with recognition request. Multiple versions of a base
   * model can exist when a model is updated for internal improvements. The parameter is intended primarily for use with
   * custom models that have been upgraded for a new base model. The default value depends on whether the parameter is
   * used with or without a custom model. See [Base model
   * version](https://console.bluemix.net/docs/services/speech-to-text/input.html#version).
   *
   * @return the baseModelVersion
   */
  public String baseModelVersion() {
    return baseModelVersion;
  }

  /**
   * Gets the customizationWeight.
   *
   * If you specify the customization ID (GUID) of a custom language model with the recognition request, the
   * customization weight tells the service how much weight to give to words from the custom language model compared to
   * those from the base model for the current request.
   *
   * Specify a value between 0.0 and 1.0. Unless a different customization weight was specified for the custom model
   * when it was trained, the default value is 0.3. A customization weight that you specify overrides a weight that was
   * specified when the custom model was trained.
   *
   * The default value yields the best performance in general. Assign a higher value if your audio makes frequent use of
   * OOV words from the custom model. Use caution when setting the weight: a higher value can improve the accuracy of
   * phrases from the custom model's domain, but it can negatively affect performance on non-domain phrases.
   *
   * See [Custom models](https://console.bluemix.net/docs/services/speech-to-text/input.html#custom).
   *
   * @return the customizationWeight
   */
  public Double customizationWeight() {
    return customizationWeight;
  }

  /**
   * Gets the inactivityTimeout.
   *
   * The time in seconds after which, if only silence (no speech) is detected in submitted audio, the connection is
   * closed with a 400 error. The parameter is useful for stopping audio submission from a live microphone when a user
   * simply walks away. Use `-1` for infinity. See
   * [Timeouts](https://console.bluemix.net/docs/services/speech-to-text/input.html#timeouts).
   *
   * @return the inactivityTimeout
   */
  public Long inactivityTimeout() {
    return inactivityTimeout;
  }

  /**
   * Gets the keywords.
   *
   * An array of keyword strings to spot in the audio. Each keyword string can include one or more string tokens.
   * Keywords are spotted only in the final results, not in interim hypotheses. If you specify any keywords, you must
   * also specify a keywords threshold. You can spot a maximum of 1000 keywords. Omit the parameter or specify an empty
   * array if you do not need to spot keywords. See [Keyword
   * spotting](https://console.bluemix.net/docs/services/speech-to-text/output.html#keyword_spotting).
   *
   * @return the keywords
   */
  public List<String> keywords() {
    return keywords;
  }

  /**
   * Gets the keywordsThreshold.
   *
   * A confidence value that is the lower bound for spotting a keyword. A word is considered to match a keyword if its
   * confidence is greater than or equal to the threshold. Specify a probability between 0.0 and 1.0. No keyword
   * spotting is performed if you omit the parameter. If you specify a threshold, you must also specify one or more
   * keywords. See [Keyword
   * spotting](https://console.bluemix.net/docs/services/speech-to-text/output.html#keyword_spotting).
   *
   * @return the keywordsThreshold
   */
  public Float keywordsThreshold() {
    return keywordsThreshold;
  }

  /**
   * Gets the maxAlternatives.
   *
   * The maximum number of alternative transcripts that the service is to return. By default, a single transcription is
   * returned. See [Maximum
   * alternatives](https://console.bluemix.net/docs/services/speech-to-text/output.html#max_alternatives).
   *
   * @return the maxAlternatives
   */
  public Long maxAlternatives() {
    return maxAlternatives;
  }

  /**
   * Gets the wordAlternativesThreshold.
   *
   * A confidence value that is the lower bound for identifying a hypothesis as a possible word alternative (also known
   * as "Confusion Networks"). An alternative word is considered if its confidence is greater than or equal to the
   * threshold. Specify a probability between 0.0 and 1.0. No alternative words are computed if you omit the parameter.
   * See [Word alternatives](https://console.bluemix.net/docs/services/speech-to-text/output.html#word_alternatives).
   *
   * @return the wordAlternativesThreshold
   */
  public Float wordAlternativesThreshold() {
    return wordAlternativesThreshold;
  }

  /**
   * Gets the wordConfidence.
   *
   * If `true`, the service returns a confidence measure in the range of 0.0 to 1.0 for each word. By default, no word
   * confidence measures are returned. See [Word
   * confidence](https://console.bluemix.net/docs/services/speech-to-text/output.html#word_confidence).
   *
   * @return the wordConfidence
   */
  public Boolean wordConfidence() {
    return wordConfidence;
  }

  /**
   * Gets the timestamps.
   *
   * If `true`, the service returns time alignment for each word. By default, no timestamps are returned. See [Word
   * timestamps](https://console.bluemix.net/docs/services/speech-to-text/output.html#word_timestamps).
   *
   * @return the timestamps
   */
  public Boolean timestamps() {
    return timestamps;
  }

  /**
   * Gets the profanityFilter.
   *
   * If `true`, the service filters profanity from all output except for keyword results by replacing inappropriate
   * words with a series of asterisks. Set the parameter to `false` to return results with no censoring. Applies to US
   * English transcription only. See [Profanity
   * filtering](https://console.bluemix.net/docs/services/speech-to-text/output.html#profanity_filter).
   *
   * @return the profanityFilter
   */
  public Boolean profanityFilter() {
    return profanityFilter;
  }

  /**
   * Gets the smartFormatting.
   *
   * If `true`, the service converts dates, times, series of digits and numbers, phone numbers, currency values, and
   * internet addresses into more readable, conventional representations in the final transcript of a recognition
   * request. For US English, the service also converts certain keyword strings to punctuation symbols. By default, no
   * smart formatting is performed. Applies to US English and Spanish transcription only. See [Smart
   * formatting](https://console.bluemix.net/docs/services/speech-to-text/output.html#smart_formatting).
   *
   * @return the smartFormatting
   */
  public Boolean smartFormatting() {
    return smartFormatting;
  }

  /**
   * Gets the speakerLabels.
   *
   * If `true`, the response includes labels that identify which words were spoken by which participants in a
   * multi-person exchange. By default, no speaker labels are returned. Setting `speaker_labels` to `true` forces the
   * `timestamps` parameter to be `true`, regardless of whether you specify `false` for the parameter. To determine
   * whether a language model supports speaker labels, use the **Get models** method and check that the attribute
   * `speaker_labels` is set to `true`. See [Speaker
   * labels](https://console.bluemix.net/docs/services/speech-to-text/output.html#speaker_labels).
   *
   * @return the speakerLabels
   */
  public Boolean speakerLabels() {
    return speakerLabels;
  }

  /**
   * Gets the customizationId.
   *
   * **Deprecated.** Use the `language_customization_id` parameter to specify the customization ID (GUID) of a custom
   * language model that is to be used with the recognition request. Do not specify both parameters with a request.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }
}

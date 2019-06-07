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
package com.ibm.watson.speech_to_text.v1.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The recognize options.
 */
public class RecognizeOptions extends GenericModel {

  /**
   * The identifier of the model that is to be used for the recognition request. See [Languages and
   * models](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-models#models).
   */
  public interface Model {
    /** ar-AR_BroadbandModel. */
    String AR_AR_BROADBANDMODEL = "ar-AR_BroadbandModel";
    /** de-DE_BroadbandModel. */
    String DE_DE_BROADBANDMODEL = "de-DE_BroadbandModel";
    /** de-DE_NarrowbandModel. */
    String DE_DE_NARROWBANDMODEL = "de-DE_NarrowbandModel";
    /** en-GB_BroadbandModel. */
    String EN_GB_BROADBANDMODEL = "en-GB_BroadbandModel";
    /** en-GB_NarrowbandModel. */
    String EN_GB_NARROWBANDMODEL = "en-GB_NarrowbandModel";
    /** en-US_BroadbandModel. */
    String EN_US_BROADBANDMODEL = "en-US_BroadbandModel";
    /** en-US_NarrowbandModel. */
    String EN_US_NARROWBANDMODEL = "en-US_NarrowbandModel";
    /** en-US_ShortForm_NarrowbandModel. */
    String EN_US_SHORTFORM_NARROWBANDMODEL = "en-US_ShortForm_NarrowbandModel";
    /** es-ES_BroadbandModel. */
    String ES_ES_BROADBANDMODEL = "es-ES_BroadbandModel";
    /** es-ES_NarrowbandModel. */
    String ES_ES_NARROWBANDMODEL = "es-ES_NarrowbandModel";
    /** fr-FR_BroadbandModel. */
    String FR_FR_BROADBANDMODEL = "fr-FR_BroadbandModel";
    /** fr-FR_NarrowbandModel. */
    String FR_FR_NARROWBANDMODEL = "fr-FR_NarrowbandModel";
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

  /**
   * The format (MIME type) of the audio. For more information about specifying an audio format, see **Audio formats
   * (content types)** in the method description.
   */
  public interface ContentType {
    /** application/octet-stream. */
    String APPLICATION_OCTET_STREAM = "application/octet-stream";
    /** audio/alaw. */
    String AUDIO_ALAW = "audio/alaw";
    /** audio/basic. */
    String AUDIO_BASIC = "audio/basic";
    /** audio/flac. */
    String AUDIO_FLAC = "audio/flac";
    /** audio/g729. */
    String AUDIO_G729 = "audio/g729";
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

  private transient InputStream audio;
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
  private Boolean interimResults;
  private String grammarName;
  private Boolean redaction;
  private Boolean processingMetrics;
  private Float processingMetricsInterval;
  private Boolean audioMetrics;
  @SerializedName("content-type")
  private String contentType;

  /**
   * Builder.
   */
  public static class Builder {
    private InputStream audio;
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
    private Boolean interimResults;
    private String grammarName;
    private Boolean redaction;
    private Boolean processingMetrics;
    private Float processingMetricsInterval;
    private Boolean audioMetrics;
    private String contentType;

    private Builder(RecognizeOptions recognizeOptions) {
      this.audio = recognizeOptions.audio;
      this.model = recognizeOptions.model;
      this.languageCustomizationId = recognizeOptions.languageCustomizationId;
      this.acousticCustomizationId = recognizeOptions.acousticCustomizationId;
      this.baseModelVersion = recognizeOptions.baseModelVersion;
      this.customizationWeight = recognizeOptions.customizationWeight;
      this.inactivityTimeout = recognizeOptions.inactivityTimeout;
      this.keywords = recognizeOptions.keywords;
      this.keywordsThreshold = recognizeOptions.keywordsThreshold;
      this.maxAlternatives = recognizeOptions.maxAlternatives;
      this.wordAlternativesThreshold = recognizeOptions.wordAlternativesThreshold;
      this.wordConfidence = recognizeOptions.wordConfidence;
      this.timestamps = recognizeOptions.timestamps;
      this.profanityFilter = recognizeOptions.profanityFilter;
      this.smartFormatting = recognizeOptions.smartFormatting;
      this.speakerLabels = recognizeOptions.speakerLabels;
      this.customizationId = recognizeOptions.customizationId;
      this.interimResults = recognizeOptions.interimResults;
      this.grammarName = recognizeOptions.grammarName;
      this.redaction = recognizeOptions.redaction;
      this.processingMetrics = recognizeOptions.processingMetrics;
      this.processingMetricsInterval = recognizeOptions.processingMetricsInterval;
      this.audioMetrics = recognizeOptions.audioMetrics;
      this.contentType = recognizeOptions.contentType;
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
     */
    public Builder(InputStream audio) {
      this.audio = audio;
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
     * Set the interimResults.
     *
     * NOTE: This parameter only works for the `recognizeUsingWebSocket` method.
     *
     * @param interimResults the interimResults
     * @return the interimResults
     */
    public Builder interimResults(Boolean interimResults) {
      this.interimResults = interimResults;
      return this;
    }

    /**
     * Set the grammarName.
     *
     * @param grammarName the grammarName
     * @return the RecognizeOptions builder
     */
    public Builder grammarName(String grammarName) {
      this.grammarName = grammarName;
      return this;
    }

    /**
     * Set the redaction.
     *
     * @param redaction the redaction
     * @return the RecognizeOptions builder
     */
    public Builder redaction(Boolean redaction) {
      this.redaction = redaction;
      return this;
    }

    /**
     * Set the processingMetrics.
     *
     * @param processingMetrics the processingMetrics
     * @return the RecognizeOptions builder
     */
    public Builder processingMetrics(Boolean processingMetrics) {
      this.processingMetrics = processingMetrics;
      return this;
    }

    /**
     * Set the processingMetricsInterval.
     *
     * @param processingMetricsInterval the processingMetricsInterval
     * @return the RecognizeOptions builder
     */
    public Builder processingMetricsInterval(Float processingMetricsInterval) {
      this.processingMetricsInterval = processingMetricsInterval;
      return this;
    }

    /**
     * Set the audioMetrics.
     *
     * @param audioMetrics the audioMetrics
     * @return the RecognizeOptions builder
     */
    public Builder audioMetrics(Boolean audioMetrics) {
      this.audioMetrics = audioMetrics;
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
    audio = builder.audio;
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
    interimResults = builder.interimResults;
    grammarName = builder.grammarName;
    redaction = builder.redaction;
    processingMetrics = builder.processingMetrics;
    processingMetricsInterval = builder.processingMetricsInterval;
    audioMetrics = builder.audioMetrics;
    contentType = builder.contentType;
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
   * Gets the model.
   *
   * The identifier of the model that is to be used for the recognition request. See [Languages and
   * models](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-models#models).
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
   * make the request with credentials for the instance of the service that owns the custom model. By default, no custom
   * language model is used. See [Custom
   * models](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-input#custom-input).
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
   * make the request with credentials for the instance of the service that owns the custom model. By default, no custom
   * acoustic model is used. See [Custom
   * models](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-input#custom-input).
   *
   * @return the acousticCustomizationId
   */
  public String acousticCustomizationId() {
    return acousticCustomizationId;
  }

  /**
   * Gets the baseModelVersion.
   *
   * The version of the specified base model that is to be used with the recognition request. Multiple versions of a
   * base model can exist when a model is updated for internal improvements. The parameter is intended primarily for use
   * with custom models that have been upgraded for a new base model. The default value depends on whether the parameter
   * is used with or without a custom model. See [Base model
   * version](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-input#version).
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
   * See [Custom models](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-input#custom-input).
   *
   * @return the customizationWeight
   */
  public Double customizationWeight() {
    return customizationWeight;
  }

  /**
   * Gets the inactivityTimeout.
   *
   * The time in seconds after which, if only silence (no speech) is detected in streaming audio, the connection is
   * closed with a 400 error. The parameter is useful for stopping audio submission from a live microphone when a user
   * simply walks away. Use `-1` for infinity. See [Inactivity
   * timeout](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-input#timeouts-inactivity).
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
   * spotting](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-output#keyword_spotting).
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
   * confidence is greater than or equal to the threshold. Specify a probability between 0.0 and 1.0. If you specify a
   * threshold, you must also specify one or more keywords. The service performs no keyword spotting if you omit either
   * parameter. See [Keyword
   * spotting](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-output#keyword_spotting).
   *
   * @return the keywordsThreshold
   */
  public Float keywordsThreshold() {
    return keywordsThreshold;
  }

  /**
   * Gets the maxAlternatives.
   *
   * The maximum number of alternative transcripts that the service is to return. By default, the service returns a
   * single transcript. If you specify a value of `0`, the service uses the default value, `1`. See [Maximum
   * alternatives](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-output#max_alternatives).
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
   * threshold. Specify a probability between 0.0 and 1.0. By default, the service computes no alternative words. See
   * [Word
   * alternatives](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-output#word_alternatives).
   *
   * @return the wordAlternativesThreshold
   */
  public Float wordAlternativesThreshold() {
    return wordAlternativesThreshold;
  }

  /**
   * Gets the wordConfidence.
   *
   * If `true`, the service returns a confidence measure in the range of 0.0 to 1.0 for each word. By default, the
   * service returns no word confidence scores. See [Word
   * confidence](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-output#word_confidence).
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
   * timestamps](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-output#word_timestamps).
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
   * filtering](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-output#profanity_filter).
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
   * request. For US English, the service also converts certain keyword strings to punctuation symbols. By default, the
   * service performs no smart formatting.
   *
   * **Note:** Applies to US English, Japanese, and Spanish transcription only.
   *
   * See [Smart
   * formatting](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-output#smart_formatting).
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
   * multi-person exchange. By default, the service returns no speaker labels. Setting `speaker_labels` to `true` forces
   * the `timestamps` parameter to be `true`, regardless of whether you specify `false` for the parameter.
   *
   * **Note:** Applies to US English, Japanese, and Spanish transcription only. To determine whether a language model
   * supports speaker labels, you can also use the **Get a model** method and check that the attribute `speaker_labels`
   * is set to `true`.
   *
   * See [Speaker
   * labels](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-output#speaker_labels).
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

  /**
   * Gets the interimResults.
   *
   * If `true`, the service returns interim results as a stream of `SpeechRecognitionResults` objects. By default,
   * the service returns a single `SpeechRecognitionResults` object with final results only.
   *
   * NOTE: This parameter only works for the `recognizeUsingWebSocket` method.
   *
   * @return the interimResults
   */
  public Boolean interimResults() {
    return interimResults;
  }

  /**
   * Gets the grammarName.
   *
   * The name of a grammar that is to be used with the recognition request. If you specify a grammar, you must also use
   * the `language_customization_id` parameter to specify the name of the custom language model for which the grammar is
   * defined. The service recognizes only strings that are recognized by the specified grammar; it does not recognize
   * other custom words from the model's words resource. See
   * [Grammars](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-input#grammars-input).
   *
   * @return the grammarName
   */
  public String grammarName() {
    return grammarName;
  }

  /**
   * Gets the redaction.
   *
   * If `true`, the service redacts, or masks, numeric data from final transcripts. The feature redacts any number that
   * has three or more consecutive digits by replacing each digit with an `X` character. It is intended to redact
   * sensitive numeric data, such as credit card numbers. By default, the service performs no redaction.
   *
   * When you enable redaction, the service automatically enables smart formatting, regardless of whether you explicitly
   * disable that feature. To ensure maximum security, the service also disables keyword spotting (ignores the
   * `keywords` and `keywords_threshold` parameters) and returns only a single final transcript (forces the
   * `max_alternatives` parameter to be `1`).
   *
   * **Note:** Applies to US English, Japanese, and Korean transcription only.
   *
   * See [Numeric redaction](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-output#redaction).
   *
   * @return the redaction
   */
  public Boolean redaction() {
    return redaction;
  }

  /**
   * Gets the processingMetrics.
   *
   * If `true`, requests processing metrics about the service's transcription of the input audio. The service returns
   * processing metrics at the interval specified by the `processing_metrics_interval` parameter. It also returns
   * processing metrics for transcription events, for example, for final and interim results. By default, the service
   * returns no processing metrics.
   *
   * @return the processingMetrics
   */
  public Boolean processingMetrics() {
    return processingMetrics;
  }

  /**
   * Gets the processingMetricsInterval.
   *
   * Specifies the interval in real wall-clock seconds at which the service is to return processing metrics. The
   * parameter is ignored unless the `processing_metrics` parameter is set to `true`.
   *
   * The parameter accepts a minimum value of 0.1 seconds. The level of precision is not restricted, so you can specify
   * values such as 0.25 and 0.125.
   *
   * The service does not impose a maximum value. If you want to receive processing metrics only for transcription
   * events instead of at periodic intervals, set the value to a large number. If the value is larger than the duration
   * of the audio, the service returns processing metrics only for transcription events.
   *
   * @return the processingMetricsInterval
   */
  public Float processingMetricsInterval() {
    return processingMetricsInterval;
  }

  /**
   * Gets the audioMetrics.
   *
   * If `true`, requests detailed information about the signal characteristics of the input audio. The service returns
   * audio metrics with the final transcription results. By default, the service returns no audio metrics.
   *
   * @return the audioMetrics
   */
  public Boolean audioMetrics() {
    return audioMetrics;
  }

  /**
   * Gets the contentType.
   *
   * The format (MIME type) of the audio. For more information about specifying an audio format, see **Audio formats
   * (content types)** in the method description.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }
}

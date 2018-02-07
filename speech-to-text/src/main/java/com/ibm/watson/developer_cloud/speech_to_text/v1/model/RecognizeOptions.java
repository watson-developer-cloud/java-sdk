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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The recognize options.
 */
public class RecognizeOptions extends GenericModel {

  /**
   * The identifier of the model to be used for the recognition request. (Use `GET /v1/models` for a list of available
   * models.).
   */
  public interface Model {
    /** ar-AR_BroadbandModel. */
    String AR_AR_BROADBANDMODEL = "ar-AR_BroadbandModel";
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
   * The type of the input: audio/basic, audio/flac, audio/l16, audio/mp3, audio/mpeg, audio/mulaw, audio/ogg,
   * audio/ogg;codecs=opus, audio/ogg;codecs=vorbis, audio/wav, audio/webm, audio/webm;codecs=opus,
   * audio/webm;codecs=vorbis, or multipart/form-data.
   */
  public interface ContentType {
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
    /** multipart/form-data. */
    String MULTIPART_FORM_DATA = "multipart/form-data";
  }

  private String model;
  private String customizationId;
  private String acousticCustomizationId;
  private Double customizationWeight;
  private String version;
  private transient InputStream audio;
  @SerializedName("content-type")
  private String contentType;
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
  private Boolean interimResults;

  /**
   * Builder.
   */
  public static class Builder {
    private String model;
    private String customizationId;
    private String acousticCustomizationId;
    private Double customizationWeight;
    private String version;
    private InputStream audio;
    private String contentType;
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
    private Boolean interimResults;

    private Builder(RecognizeOptions recognizeOptions) {
      model = recognizeOptions.model;
      customizationId = recognizeOptions.customizationId;
      acousticCustomizationId = recognizeOptions.acousticCustomizationId;
      customizationWeight = recognizeOptions.customizationWeight;
      version = recognizeOptions.version;
      audio = recognizeOptions.audio;
      contentType = recognizeOptions.contentType;
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
      interimResults = recognizeOptions.interimResults;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
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
     * Set the version.
     *
     * @param version the version
     * @return the RecognizeOptions builder
     */
    public Builder version(String version) {
      this.version = version;
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

    /**
     * Set the interimResults.
     *
     * @param interimResults the interimResults
     * @return the RecognizeOptions builder
     */
    public Builder interimResults(Boolean interimResults) {
      this.interimResults = interimResults;
      return this;
    }
  }

  private RecognizeOptions(Builder builder) {
    model = builder.model;
    customizationId = builder.customizationId;
    acousticCustomizationId = builder.acousticCustomizationId;
    customizationWeight = builder.customizationWeight;
    version = builder.version;
    audio = builder.audio;
    contentType = builder.contentType;
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
    interimResults = builder.interimResults;
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
   * Gets the model.
   *
   * The identifier of the model to be used for the recognition request. (Use `GET /v1/models` for a list of available
   * models.).
   *
   * @return the model
   */
  public String model() {
    return model;
  }

  /**
   * Gets the customizationId.
   *
   * The GUID of a custom language model that is to be used with the request. The base model of the specified custom
   * language model must match the model specified with the `model` parameter. You must make the request with service
   * credentials created for the instance of the service that owns the custom model. By default, no custom language
   * model is used.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the acousticCustomizationId.
   *
   * The GUID of a custom acoustic model that is to be used with the request. The base model of the specified custom
   * acoustic model must match the model specified with the `model` parameter. You must make the request with service
   * credentials created for the instance of the service that owns the custom model. By default, no custom acoustic
   * model is used.
   *
   * @return the acousticCustomizationId
   */
  public String acousticCustomizationId() {
    return acousticCustomizationId;
  }

  /**
   * Gets the customizationWeight.
   *
   * If you specify a `customization_id` with the request, you can use the `customization_weight` parameter to tell the
   * service how much weight to give to words from the custom language model compared to those from the base model for
   * speech recognition. Specify a value between 0.0 and 1.0. Unless a different customization weight was specified for
   * the custom model when it was trained, the default value is 0.3. A customization weight that you specify overrides a
   * weight that was specified when the custom model was trained. The default value yields the best performance in
   * general. Assign a higher value if your audio makes frequent use of OOV words from the custom model. Use caution
   * when setting the weight: a higher value can improve the accuracy of phrases from the custom model's domain, but it
   * can negatively affect performance on non-domain phrases.
   *
   * @return the customizationWeight
   */
  public Double customizationWeight() {
    return customizationWeight;
  }

  /**
   * Gets the version.
   *
   * The version of the specified base `model` that is to be used for speech recognition. Multiple versions of a base
   * model can exist when a model is updated for internal improvements. The parameter is intended primarily for use with
   * custom models that have been upgraded for a new base model. The default value depends on whether the parameter is
   * used with or without a custom model. For more information, see [Base model
   * version](https://console.bluemix.net/docs/services/speech-to-text/input.html#version).
   *
   * @return the version
   */
  public String version() {
    return version;
  }

  /**
   * Gets the audio.
   *
   * @return the audio
   */
  public InputStream audio() {
    return audio;
  }

  /**
   * Gets the contentType.
   *
   * The type of the input: audio/basic, audio/flac, audio/l16, audio/mp3, audio/mpeg, audio/mulaw, audio/ogg,
   * audio/ogg;codecs=opus, audio/ogg;codecs=vorbis, audio/wav, audio/webm, audio/webm;codecs=opus,
   * audio/webm;codecs=vorbis, or multipart/form-data.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }

  /**
   * Gets the inactivityTimeout.
   *
   * NON-MULTIPART ONLY: The time in seconds after which, if only silence (no speech) is detected in submitted audio,
   * the connection is closed with a 400 error. Useful for stopping audio submission from a live microphone when a user
   * simply walks away. Use `-1` for infinity.
   *
   * @return the inactivityTimeout
   */
  public Long inactivityTimeout() {
    return inactivityTimeout;
  }

  /**
   * Gets the keywords.
   *
   * NON-MULTIPART ONLY: Array of keyword strings to spot in the audio. Each keyword string can include one or more
   * tokens. Keywords are spotted only in the final hypothesis, not in interim results. If you specify any keywords, you
   * must also specify a keywords threshold. Omit the parameter or specify an empty array if you do not need to spot
   * keywords.
   *
   * @return the keywords
   */
  public List<String> keywords() {
    return keywords;
  }

  /**
   * Gets the keywordsThreshold.
   *
   * NON-MULTIPART ONLY: Confidence value that is the lower bound for spotting a keyword. A word is considered to match
   * a keyword if its confidence is greater than or equal to the threshold. Specify a probability between 0 and 1
   * inclusive. No keyword spotting is performed if you omit the parameter. If you specify a threshold, you must also
   * specify one or more keywords.
   *
   * @return the keywordsThreshold
   */
  public Float keywordsThreshold() {
    return keywordsThreshold;
  }

  /**
   * Gets the maxAlternatives.
   *
   * NON-MULTIPART ONLY: Maximum number of alternative transcripts to be returned. By default, a single transcription is
   * returned.
   *
   * @return the maxAlternatives
   */
  public Long maxAlternatives() {
    return maxAlternatives;
  }

  /**
   * Gets the wordAlternativesThreshold.
   *
   * NON-MULTIPART ONLY: Confidence value that is the lower bound for identifying a hypothesis as a possible word
   * alternative (also known as "Confusion Networks"). An alternative word is considered if its confidence is greater
   * than or equal to the threshold. Specify a probability between 0 and 1 inclusive. No alternative words are computed
   * if you omit the parameter.
   *
   * @return the wordAlternativesThreshold
   */
  public Float wordAlternativesThreshold() {
    return wordAlternativesThreshold;
  }

  /**
   * Gets the wordConfidence.
   *
   * NON-MULTIPART ONLY: If `true`, confidence measure per word is returned.
   *
   * @return the wordConfidence
   */
  public Boolean wordConfidence() {
    return wordConfidence;
  }

  /**
   * Gets the timestamps.
   *
   * NON-MULTIPART ONLY: If `true`, time alignment for each word is returned.
   *
   * @return the timestamps
   */
  public Boolean timestamps() {
    return timestamps;
  }

  /**
   * Gets the profanityFilter.
   *
   * NON-MULTIPART ONLY: If `true` (the default), filters profanity from all output except for keyword results by
   * replacing inappropriate words with a series of asterisks. Set the parameter to `false` to return results with no
   * censoring. Applies to US English transcription only.
   *
   * @return the profanityFilter
   */
  public Boolean profanityFilter() {
    return profanityFilter;
  }

  /**
   * Gets the smartFormatting.
   *
   * NON-MULTIPART ONLY: If `true`, converts dates, times, series of digits and numbers, phone numbers, currency values,
   * and Internet addresses into more readable, conventional representations in the final transcript of a recognition
   * request. If `false` (the default), no formatting is performed. Applies to US English transcription only.
   *
   * @return the smartFormatting
   */
  public Boolean smartFormatting() {
    return smartFormatting;
  }

  /**
   * Gets the speakerLabels.
   *
   * NON-MULTIPART ONLY: Indicates whether labels that identify which words were spoken by which participants in a
   * multi-person exchange are to be included in the response. The default is `false`; no speaker labels are returned.
   * Setting `speaker_labels` to `true` forces the `timestamps` parameter to be `true`, regardless of whether you
   * specify `false` for the parameter. To determine whether a language model supports speaker labels, use the `GET
   * /v1/models` method and check that the attribute `speaker_labels` is set to `true`. You can also refer to [Speaker
   * labels](https://console.bluemix.net/docs/services/speech-to-text/output.html#speaker_labels).
   *
   * @return the speakerLabels
   */
  public Boolean speakerLabels() {
    return speakerLabels;
  }

  /**
   * Gets the interimResults.
   *
   * Indicates whether the service is to return interim results. If true, interim results are returned as a stream of
   * JSON {@link SpeechRecognitionResults} objects. If false (the default), the response is a single
   * {@link SpeechRecognitionResults} object with final results only.
   *
   * @return the interimResults
   */
  public Boolean interimResults() {
    return interimResults;
  }
}

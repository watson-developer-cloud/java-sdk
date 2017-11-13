/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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

import java.io.InputStream;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.RecognizeCallback;
import com.ibm.watson.developer_cloud.util.Validator;

import okhttp3.MediaType;


/**
 * Parameters to be use during a recognize call in the {@link SpeechToText} service.
 */
public class RecognizeOptions {

  /**
   * Builder.
   */
  public static class Builder {
    private String contentType;
    private Boolean continuous;
    private Integer inactivityTimeout;
    private Boolean interimResults;
    private String[] keywords;
    private Double keywordsThreshold;
    private Integer maxAlternatives;
    private String model;
    private String sessionId;
    private Boolean timestamps;
    private Double wordAlternativesThreshold;
    private Boolean wordConfidence;
    private Boolean profanityFilter;
    private Boolean smartFormatting;
    private String customizationId;
    private Boolean speakerLabels;
    private Double customizationWeight;

    private Builder(RecognizeOptions options) {
      contentType = options.contentType;
      continuous = options.continuous;
      inactivityTimeout = options.inactivityTimeout;
      interimResults = options.interimResults;
      keywords = options.keywords;
      keywordsThreshold = options.keywordsThreshold;
      maxAlternatives = options.maxAlternatives;
      model = options.model;
      sessionId = options.sessionId;
      timestamps = options.timestamps;
      wordAlternativesThreshold = options.wordAlternativesThreshold;
      wordConfidence = options.wordConfidence;
      profanityFilter = options.profanityFilter;
      smartFormatting = options.smartFormatting;
      customizationId = options.customizationId;
      speakerLabels = options.speakerLabels;
      customizationWeight = options.customizationWeight;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds the profile options.
     *
     * @return the profile options
     */
    public RecognizeOptions build() {
      return new RecognizeOptions(this);
    }

    /**
     * The format of the audio data specified.
     * <ul>
     * <li><code>audio/flac</code> for Free Lossless Audio Codec (FLAC)</li>
     * <li><code>audio/l16</code> for Linear 16-bit Pulse-Code Modulation (PCM)</li>
     * <li><code>audio/mp3</code> for MP3</li>
     * <li><code>audio/mpeg</code> for MPEG-1</li>
     * <li><code>audio/mulaw</code> for Mulaw</li>
     * <li><code>audio/webm</code> for Webm</li>
     * <li><code>audio/wav</code> for Waveform Audio File Format (WAV)</li>
     * <li><code>audio/ogg;codecs=opus</code> for OGG format files that use the opus codec</li>
     * </ul>
     *
     * @param contentType the content type
     * @return the recognize options
     * @throws IllegalArgumentException when contentType is null or invalid
     */
    public Builder contentType(String contentType) {
      Validator.isTrue((MediaType.parse(contentType) != null) && contentType.startsWith("audio/"),
          "contentType is not a valid mime audio format. Valid formats start with 'audio/'");

      Validator.isTrue(!contentType.contains(HttpMediaType.AUDIO_RAW) || contentType.contains("rate"),
          "When using PCM the audio rate should be specified.");

      this.contentType = contentType;
      return this;
    }

    /**
     * If <code>true</code>, converts dates, times, series of digits and numbers, phone numbers, currency values, and
     * Internet addresses into more readable, conventional representations in the final transcript of a recognition
     * request. If <code>false</code> (the default), no formatting is performed. Applies to US English transcription
     * only.
     *
     * @param smartFormatting Smart formatting
     * @return the recognize options
     */
    public Builder smartFormatting(Boolean smartFormatting) {
      this.smartFormatting = smartFormatting;
      return this;
    }

    /**
     * If <code>true</code>, adds speaker labels to the transcript.
     *
     * @param speakerLabels Labels or "diarization"
     * @return the recognize options
     */
    public Builder speakerLabels(Boolean speakerLabels) {
      this.speakerLabels = speakerLabels;
      return this;
    }

    /**
     * If a custom model is specified, this parameter tells the service how much weight to give
     * to words from the custom language model compared to those from the base model.
     * Specify a value between 0.0 and 1.0 (inclusive). If value is null or omitted, the customization
     * weight from the model is used. If no customization weight is specified on the model, the default
     * value of the service will be used.
     *
     * @param customizationWeight Labels or "diarization"
     * @return the recognize options
     */
    public Builder customizationWeight(Double customizationWeight) {
      this.customizationWeight = customizationWeight;
      return this;
    }

    /**
     * If true, filters profanity from all output except for keyword results by replacing inappropriate words with a
     * series of asterisks. Set the parameter to false to return results with no censoring. Applies to US English
     * transcription only.
     *
     * @param profanityFilter the profanity filter
     * @return the recognize options
     */
    public Builder profanityFilter(Boolean profanityFilter) {
      this.profanityFilter = profanityFilter;
      return this;
    }

    /**
     * Inactivity timeout.
     *
     * @param inactivityTimeout the inactivity timeout
     * @return the recognize options
     */
    public Builder inactivityTimeout(Integer inactivityTimeout) {
      this.inactivityTimeout = inactivityTimeout;
      return this;
    }

    /**
     * If true, the service sends interim results for the transcription. Otherwise, the recognition ends after first
     * "end of speech" is detected. The default is false. This option is only supported with the
     * {@link SpeechToText#recognizeUsingWebSocket(InputStream, RecognizeOptions, RecognizeCallback)} method.
     *
     * @param interimResults the interim results
     * @return the recognize options
     */
    public Builder interimResults(Boolean interimResults) {
      this.interimResults = interimResults;
      return this;
    }

    /**
     * Specifies the customization id(GUID).
     *
     * @param customizationId the customization id
     * @return the recognize options
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Specifies an array of keyword strings to be matched in the input audio. By default, the service does no keyword
     * spotting.
     *
     *
     * @param keywords the keywords
     * @return the recognize options
     */
    public Builder keywords(String... keywords) {
      this.keywords = (keywords == null) ? null : keywords.clone();
      return this;
    }

    /**
     * Specifies a minimum level of confidence that the service must have to report a matching keyword in the input
     * audio. Specify a probability value between 0 and 1 inclusive. A match must have at least the specified confidence
     * to be returned. Omit the parameter or specify a value of null (the default) to spot no keywords. If you specify a
     * valid threshold, you must also specify at least one keyword.
     *
     *
     * @param keywordsThreshold the keywords threshold
     * @return the recognize options
     */
    public Builder keywordsThreshold(Double keywordsThreshold) {
      this.keywordsThreshold = keywordsThreshold;
      return this;
    }

    /**
     * Maximum number of alternative transcripts returned.
     *
     * @param maxAlternatives the max alternatives
     * @return the recognize options
     */
    public Builder maxAlternatives(Integer maxAlternatives) {
      this.maxAlternatives = maxAlternatives;
      return this;
    }

    /**
     * Sets the model name used for the recognition.
     *
     * @param model the model
     * @return the recognize options
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }

    /**
     * Sets the session id.
     *
     * @param session the {@link SpeechSession}
     * @return the recognize options
     */
    public Builder session(SpeechSession session) {
      sessionId = session.getSessionId();
      return this;
    }

    /**
     * Sets session id.
     *
     * @param sessionId the session id
     * @return the recognize options
     */
    public Builder sessionId(String sessionId) {
      this.sessionId = sessionId;
      return this;
    }

    /**
     * If true, time alignment for each word is returned.
     *
     * @param timestamps the timestamps
     * @return the recognize options
     */
    public Builder timestamps(Boolean timestamps) {
      this.timestamps = timestamps;
      return this;
    }

    /**
     * Specifies a minimum level of confidence that the service must have to report a hypothesis for a word from the
     * input audio. Specify a probability value between 0 and 1 inclusive. A hypothesis must have at least the specified
     * confidence to be returned as a word alternative. Omit the parameter or specify a value of null (the default) to
     * return no word alternatives.
     *
     *
     *
     * @param wordAlternativesThreshold the wordAalternatives threshold
     * @return the recognize options
     */
    public Builder wordAlternativesThreshold(Double wordAlternativesThreshold) {
      this.wordAlternativesThreshold = wordAlternativesThreshold;
      return this;
    }

    /**
     * If true, confidence measure per word is returned if available.
     *
     * @param wordConfidence the word confidence
     * @return the recognize options
     */
    public Builder wordConfidence(Boolean wordConfidence) {
      this.wordConfidence = wordConfidence;
      return this;
    }
  }

  @SerializedName("content-type")
  private String contentType;
  private Boolean continuous;
  @SerializedName("inactivity_timeout")
  private Integer inactivityTimeout;

  @SerializedName("interim_results")
  private Boolean interimResults;
  private String[] keywords;

  @SerializedName("keywords_threshold")
  private Double keywordsThreshold;
  @SerializedName("max_alternatives")
  private Integer maxAlternatives;
  @SerializedName("profanity_filter")
  private Boolean profanityFilter;
  private String model;
  @SerializedName("session_id")
  private String sessionId;
  private Boolean timestamps;

  @SerializedName("word_alternatives_threshold")
  private Double wordAlternativesThreshold;

  @SerializedName("word_confidence")
  private Boolean wordConfidence;

  @SerializedName("smart_formatting")
  private Boolean smartFormatting;

  @SerializedName("customization_id")
  private String customizationId;

  @SerializedName("speaker_labels")
  private Boolean speakerLabels;

  @SerializedName("customization_weight")
  private Double customizationWeight;

  private RecognizeOptions(Builder builder) {
    contentType = builder.contentType;
    continuous = builder.continuous;
    inactivityTimeout = builder.inactivityTimeout;
    interimResults = builder.interimResults;
    keywords = builder.keywords;
    keywordsThreshold = builder.keywordsThreshold;
    maxAlternatives = builder.maxAlternatives;
    model = builder.model;
    sessionId = builder.sessionId;
    timestamps = builder.timestamps;
    wordAlternativesThreshold = builder.wordAlternativesThreshold;
    wordConfidence = builder.wordConfidence;
    profanityFilter = builder.profanityFilter;
    smartFormatting = builder.smartFormatting;
    customizationId = builder.customizationId;
    speakerLabels = builder.speakerLabels;
    customizationWeight = builder.customizationWeight;
  }

  /**
   * Gets the customization Id.
   *
   * @return the customization id.
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the content type.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }

  /**
   * Gets the profanity filter.
   *
   * @return the profanity filter
   */
  public Boolean profanityFilter() {
    return profanityFilter;
  }

  /**
   * Gets the smart formatting.
   *
   * @return the smart formatting
   */
  public Boolean smartFormatting() {
    return smartFormatting;
  }

  /**
   * Gets the speakerLabels.
   *
   * @return the speakerLabels
   */
  public Boolean speakerLabels() {
    return speakerLabels;
  }

  /**
   * Gets the customizationWeight.
   *
   * @return the customizationWeight
   */
  public Double customizationWeight() {
    return customizationWeight;
  }

  /**
   * Gets the continuous.
   *
   * @return the continuous
   */
  public Boolean continuous() {
    return continuous;
  }

  /**
   * Gets the inactivity timeout.
   *
   * @return the inactivity timeout
   */
  public Integer inactivityTimeout() {
    return inactivityTimeout;
  }

  /**
   * Gets the interim results.
   *
   * @return the interimResults
   */
  public Boolean interimResults() {
    return interimResults;
  }

  /**
   * Gets the keywords.
   *
   * @return the keywords
   */
  public String[] keywords() {
    return (keywords == null) ? null : keywords.clone();
  }

  /**
   * Gets the keywords threshold.
   *
   * @return the keywordsThreshold
   */
  public Double keywordsThreshold() {
    return keywordsThreshold;
  }

  /**
   * Gets the max alternatives.
   *
   * @return the maxAlternatives
   */
  public Integer maxAlternatives() {
    return maxAlternatives;
  }

  /**
   * Gets the model.
   *
   * @return the model
   */
  public String model() {
    return model;
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the session id.
   *
   * @return the sessionId
   */
  public String sessionId() {
    return sessionId;
  }

  /**
   * Gets the timestamps.
   *
   * @return the timestamps
   */
  public Boolean timestamps() {
    return timestamps;
  }

  /**
   * Gets the word alternatives threshold.
   *
   * @return the wordAlternativesThreshold
   */
  public Double wordAlternativesThreshold() {
    return wordAlternativesThreshold;
  }

  /**
   * Gets the word confidence.
   *
   * @return the wordConfidence
   */
  public Boolean wordConfidence() {
    return wordConfidence;
  }
}

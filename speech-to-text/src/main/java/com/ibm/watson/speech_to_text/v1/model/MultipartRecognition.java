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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * MultipartRecognition.
 */
public class MultipartRecognition extends GenericModel {

  /**
   * The audio format (MIME type) of the audio in the following parts:
   * * `audio/basic` (Use only with narrowband models.)
   * * `audio/flac`
   * * `audio/l16` (Specify the sampling rate (`rate`) and optionally the number of channels (`channels`) and
   * endianness (`endianness`) of the audio.)
   * * `audio/mp3`
   * * `audio/mpeg`
   * * `audio/mulaw` (Specify the sampling rate of the audio.)
   * * `audio/ogg` (The service automatically detects the codec of the input audio.)
   * * `audio/ogg;codecs=opus`
   * * `audio/ogg;codecs=vorbis`
   * * `audio/wav` (Provide audio with a maximum of nine channels.)
   * * `audio/webm` (The service automatically detects the codec of the input audio.)
   * * `audio/webm;codecs=opus`
   * * `audio/webm;codecs=vorbis`
   *
   * All data parts must have the same audio format. For information about the supported audio formats, including
   * specifying the sampling rate, channels, and endianness for the indicated formats, see [Audio formats]
   * (https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-audio-formats). The information includes links to
   * a number of Internet sites that provide technical and usage details about the different formats.
   */
  public interface PartContentType {
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

  @SerializedName("part_content_type")
  private String partContentType;
  @SerializedName("data_parts_count")
  private Long dataPartsCount;
  @SerializedName("sequence_id")
  private Long sequenceId;
  @SerializedName("inactivity_timeout")
  private Long inactivityTimeout;
  private List<String> keywords;
  @SerializedName("keywords_threshold")
  private Float keywordsThreshold;
  @SerializedName("max_alternatives")
  private Long maxAlternatives;
  @SerializedName("word_alternatives_threshold")
  private Float wordAlternativesThreshold;
  @SerializedName("word_confidence")
  private Boolean wordConfidence;
  private Boolean timestamps;
  @SerializedName("profanity_filter")
  private Boolean profanityFilter;
  @SerializedName("smart_formatting")
  private Boolean smartFormatting;
  @SerializedName("speaker_labels")
  private Boolean speakerLabels;

  /**
   * Builder.
   */
  public static class Builder {
    private String partContentType;
    private Long dataPartsCount;
    private Long sequenceId;
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

    private Builder(MultipartRecognition multipartRecognition) {
      partContentType = multipartRecognition.partContentType;
      dataPartsCount = multipartRecognition.dataPartsCount;
      sequenceId = multipartRecognition.sequenceId;
      inactivityTimeout = multipartRecognition.inactivityTimeout;
      keywords = multipartRecognition.keywords;
      keywordsThreshold = multipartRecognition.keywordsThreshold;
      maxAlternatives = multipartRecognition.maxAlternatives;
      wordAlternativesThreshold = multipartRecognition.wordAlternativesThreshold;
      wordConfidence = multipartRecognition.wordConfidence;
      timestamps = multipartRecognition.timestamps;
      profanityFilter = multipartRecognition.profanityFilter;
      smartFormatting = multipartRecognition.smartFormatting;
      speakerLabels = multipartRecognition.speakerLabels;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a MultipartRecognition.
     *
     * @return the customWord
     */
    public MultipartRecognition build() {
      return new MultipartRecognition(this);
    }

    /**
     * Adds a keyword to keywords.
     *
     * @param keyword the new keyword
     * @return the MultipartRecognition builder
     */
    public Builder addKeyword(String keyword) {
      Validator.notNull(keywords, "soundsLike cannot be null");
      if (this.keywords == null) {
        this.keywords = new ArrayList<String>();
      }
      this.keywords.add(keyword);
      return this;
    }

    /**
     * Set the partContentType.
     *
     * @param partContentType the partContentType
     * @return the MultipartRecognition builder
     */
    public Builder partContentType(String partContentType) {
      this.partContentType = partContentType;
      return this;
    }

    /**
     * Set the dataPartsCount.
     *
     * @param dataPartsCount the dataPartsCount
     * @return the MultipartRecognition builder
     */
    public Builder dataPartsCount(Long dataPartsCount) {
      this.dataPartsCount = dataPartsCount;
      return this;
    }

    /**
     * Set the sequenceId.
     *
     * @param sequenceId the sequenceId
     * @return the MultipartRecognition builder
     */
    public Builder sequenceId(Long sequenceId) {
      this.sequenceId = sequenceId;
      return this;
    }

    /**
     * Set the inactivityTimeout.
     *
     * @param inactivityTimeout the inactivityTimeout
     * @return the MultipartRecognition builder
     */
    public Builder inactivityTimeout(Long inactivityTimeout) {
      this.inactivityTimeout = inactivityTimeout;
      return this;
    }

    /**
     * Set the keywords.
     * Existing keywords will be replaced.
     *
     * @param keywords the keywords
     * @return the MultipartRecognition builder
     */
    public Builder keywords(List<String> keywords) {
      this.keywords = keywords;
      return this;
    }

    /**
     * Set the keywordsThreshold.
     *
     * @param keywordsThreshold the keywordsThreshold
     * @return the MultipartRecognition builder
     */
    public Builder keywordsThreshold(Float keywordsThreshold) {
      this.keywordsThreshold = keywordsThreshold;
      return this;
    }

    /**
     * Set the maxAlternatives.
     *
     * @param maxAlternatives the maxAlternatives
     * @return the MultipartRecognition builder
     */
    public Builder maxAlternatives(Long maxAlternatives) {
      this.maxAlternatives = maxAlternatives;
      return this;
    }

    /**
     * Set the wordAlternativesThreshold.
     *
     * @param wordAlternativesThreshold the wordAlternativesThreshold
     * @return the MultipartRecognition builder
     */
    public Builder wordAlternativesThreshold(Float wordAlternativesThreshold) {
      this.wordAlternativesThreshold = wordAlternativesThreshold;
      return this;
    }

    /**
     * Set the wordConfidence.
     *
     * @param wordConfidence the wordConfidence
     * @return the MultipartRecognition builder
     */
    public Builder wordConfidence(Boolean wordConfidence) {
      this.wordConfidence = wordConfidence;
      return this;
    }

    /**
     * Set the timestamps.
     *
     * @param timestamps the timestamps
     * @return the MultipartRecognition builder
     */
    public Builder timestamps(Boolean timestamps) {
      this.timestamps = timestamps;
      return this;
    }

    /**
     * Set the profanityFilter.
     *
     * @param profanityFilter the profanityFilter
     * @return the MultipartRecognition builder
     */
    public Builder profanityFilter(Boolean profanityFilter) {
      this.profanityFilter = profanityFilter;
      return this;
    }

    /**
     * Set the smartFormatting.
     *
     * @param smartFormatting the smartFormatting
     * @return the MultipartRecognition builder
     */
    public Builder smartFormatting(Boolean smartFormatting) {
      this.smartFormatting = smartFormatting;
      return this;
    }

    /**
     * Set the speakerLabels.
     *
     * @param speakerLabels the speakerLabels
     * @return the MultipartRecognition builder
     */
    public Builder speakerLabels(Boolean speakerLabels) {
      this.speakerLabels = speakerLabels;
      return this;
    }
  }

  private MultipartRecognition(Builder builder) {
    Validator.isTrue(builder.partContentType != null, "partContentType cannot be null");
    partContentType = builder.partContentType;
    dataPartsCount = builder.dataPartsCount;
    sequenceId = builder.sequenceId;
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
  }

  /**
   * New builder.
   *
   * @return a MultipartRecognition builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the partContentType.
   *
   * The audio format (MIME type) of the audio in the following parts:
   * * `audio/basic` (Use only with narrowband models.)
   * * `audio/flac`
   * * `audio/l16` (Specify the sampling rate (`rate`) and optionally the number of channels (`channels`) and
   * endianness (`endianness`) of the audio.)
   * * `audio/mp3`
   * * `audio/mpeg`
   * * `audio/mulaw` (Specify the sampling rate of the audio.)
   * * `audio/ogg` (The service automatically detects the codec of the input audio.)
   * * `audio/ogg;codecs=opus`
   * * `audio/ogg;codecs=vorbis`
   * * `audio/wav` (Provide audio with a maximum of nine channels.)
   * * `audio/webm` (The service automatically detects the codec of the input audio.)
   * * `audio/webm;codecs=opus`
   * * `audio/webm;codecs=vorbis`
   *
   * All data parts must have the same audio format. For information about the supported audio formats, including
   * specifying the sampling rate, channels, and endianness for the indicated formats, see [Audio formats]
   * (https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-audio-formats). The information includes 
   * links to a number of Internet sites that provide technical and usage details about the different formats.
   *
   * @return the partContentType
   */
  public String partContentType() {
    return partContentType;
  }

  /**
   * Gets the dataPartsCount.
   *
   * The number of audio data parts (audio files) sent with the request. Server-side end-of-stream detection is
   * applied to the last (and possibly the only) data part. If omitted, the number of parts is determined from the
   * request itself.
   *
   * @return the dataPartsCount
   */
  public Long dataPartsCount() {
    return dataPartsCount;
  }

  /**
   * Gets the sequenceId.
   *
   * The sequence ID for all data parts of this recognition task in the form of a user-specified integer. If
   * omitted, no sequence ID is associated with the recognition task. Used only for session-based requests.
   *
   * @return the sequenceId
   */
  public Long sequenceId() {
    return sequenceId;
  }

  /**
   * Gets the inactivityTimeout.
   *
   * The time in seconds after which, if only silence (no speech) is detected in submitted audio, the connection is
   * closed with a 400 error and, for session-based methods, with `session_closed` set to `true`. Useful for stopping
   * audio submission from a live microphone when a user simply walks away. Use `-1` for infinity.
   *
   * @return the inactivityTimeout
   */
  public Long inactivityTimeout() {
    return inactivityTimeout;
  }

  /**
   * Gets the keywords.
   *
   * Array of keyword strings to spot in the audio. Each keyword string can include one or more tokens. Keywords are
   * spotted only in the final hypothesis, not in interim results (if supported by the method). If you specify any
   * keywords, you must also specify a keywords threshold. Omit the parameter or specify an empty array if you do not
   * need to spot keywords.
   *
   * @return the keywords
   */
  public List<String> keywords() {
    return keywords;
  }

  /**
   * Gets the keywordsThreshold.
   *
   * Confidence value that is the lower bound for spotting a keyword. A word is considered to match a keyword if its
   * confidence is greater than or equal to the threshold. Specify a probability between 0 and 1 inclusive. No
   * keyword spotting is performed if you omit the parameter. If you specify a threshold, you must also specify one
   * or more keywords.
   *
   * @return the keywordsThreshold
   */
  public Float keywordsThreshold() {
    return keywordsThreshold;
  }

  /**
   * Gets the maxAlternatives.
   *
   * Maximum number of alternative transcripts to be returned. By default, a single transcription is returned.
   *
   * @return the maxAlternatives
   */
  public Long maxAlternatives() {
    return maxAlternatives;
  }

  /**
   * Gets the wordAlternativesThreshold.
   *
   * Confidence value that is the lower bound for identifying a hypothesis as a possible word alternative (also known
   * as \"Confusion Networks\"). An alternative word is considered if its confidence is greater than or equal to the
   * threshold. Specify a probability between 0 and 1 inclusive. No alternative words are computed if you omit the
   * parameter.
   *
   * @return the wordAlternativesThreshold
   */
  public Float wordAlternativesThreshold() {
    return wordAlternativesThreshold;
  }

  /**
   * Gets the wordConfidence.
   *
   * If `true`, a confidence measure in the range 0 to 1 is returned for each word.
   *
   * @return the wordConfidence
   */
  public Boolean wordConfidence() {
    return wordConfidence;
  }

  /**
   * Gets the timestamps.
   *
   * If `true`, time alignment for each word is returned.
   *
   * @return the timestamps
   */
  public Boolean timestamps() {
    return timestamps;
  }

  /**
   * Gets the profanityFilter.
   *
   * If `true` (the default), filters profanity from all output except for keyword results by replacing inappropriate
   * words with a series of asterisks. Set the parameter to `false` to return results with no censoring. Applies to
   * US English transcription only.
   *
   * @return the profanityFilter
   */
  public Boolean profanityFilter() {
    return profanityFilter;
  }

  /**
   * Gets the smartFormatting.
   *
   * If `true`, converts dates, times, series of digits and numbers, phone numbers, currency values, and Internet
   * addresses into more readable, conventional representations in the final transcript of a recognition request. If
   * `false` (the default), no formatting is performed. Applies to US English transcription only.
   *
   * @return the smartFormatting
   */
  public Boolean smartFormatting() {
    return smartFormatting;
  }

  /**
   * Gets the speakerLabels.
   *
   * Indicates whether labels that identify which words were spoken by which participants in a multi-person exchange
   * are to be included in the response. The default is `false`; no speaker labels are returned. Setting
   * `speaker_labels` to `true` forces the `timestamps` parameter to be `true`, regardless of whether you specify
   * `false` for the parameter.\n\n To determine whether a language model supports speaker labels, use the `GET
   * /v1/models` method and check that the attribute `speaker_labels` is set to `true`. You can also refer to
   * [Speaker labels](https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-output#speaker_labels).
   *
   * @return the speakerLabels
   */
  public Boolean speakerLabels() {
    return speakerLabels;
  }
}

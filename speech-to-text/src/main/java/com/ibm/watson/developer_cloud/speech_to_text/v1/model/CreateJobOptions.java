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
import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The createJob options.
 */
public class CreateJobOptions extends GenericModel {

  /**
   * If the job includes a callback URL, a comma-separated list of notification events to which to subscribe. Valid
   * events are: `recognitions.started` generates a callback notification when the service begins to process the job.
   * `recognitions.completed` generates a callback notification when the job is complete; you must use the `GET
   * /v1/recognitions/{id}` method to retrieve the results before they time out or are deleted.
   * `recognitions.completed_with_results` generates a callback notification when the job is complete; the notification
   * includes the results of the request. `recognitions.failed` generates a callback notification if the service
   * experiences an error while processing the job. Omit the parameter to subscribe to the default events:
   * `recognitions.started`, `recognitions.completed`, and `recognitions.failed`. The `recognitions.completed` and
   * `recognitions.completed_with_results` events are incompatible; you can specify only of the two events. If the job
   * does not include a callback URL, omit the parameter.
   */
  public interface Events {
    /** recognitions.started. */
    String RECOGNITIONS_STARTED = "recognitions.started";
    /** recognitions.completed. */
    String RECOGNITIONS_COMPLETED = "recognitions.completed";
    /** recognitions.completed_with_results. */
    String RECOGNITIONS_COMPLETED_WITH_RESULTS = "recognitions.completed_with_results";
    /** recognitions.failed. */
    String RECOGNITIONS_FAILED = "recognitions.failed";
  }

  /**
   * Set to `chunked` to send the audio in streaming mode. The data does not need to exist fully before being streamed
   * to the service.
   */
  public interface TransferEncoding {
    /** chunked. */
    String CHUNKED = "chunked";
  }

  /**
   * The type of the input: audio/basic, audio/flac, audio/l16, audio/mp3, audio/mpeg, audio/mulaw, audio/ogg,
   * audio/ogg;codecs=opus, audio/ogg;codecs=vorbis, audio/wav, audio/webm, audio/webm;codecs=opus, or
   * audio/webm;codecs=vorbis.
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
  }

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

  private String callbackUrl;
  private String events;
  private String userToken;
  private Long resultsTtl;
  private String transferEncoding;
  private File audio;
  private String contentType;
  private String model;
  private String customizationId;
  private String acousticCustomizationId;
  private Double customizationWeight;
  private String version;
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

  /**
   * Builder.
   */
  public static class Builder {
    private String callbackUrl;
    private String events;
    private String userToken;
    private Long resultsTtl;
    private String transferEncoding;
    private File audio;
    private String contentType;
    private String model;
    private String customizationId;
    private String acousticCustomizationId;
    private Double customizationWeight;
    private String version;
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

    private Builder(CreateJobOptions createJobOptions) {
      callbackUrl = createJobOptions.callbackUrl;
      events = createJobOptions.events;
      userToken = createJobOptions.userToken;
      resultsTtl = createJobOptions.resultsTtl;
      transferEncoding = createJobOptions.transferEncoding;
      audio = createJobOptions.audio;
      contentType = createJobOptions.contentType;
      model = createJobOptions.model;
      customizationId = createJobOptions.customizationId;
      acousticCustomizationId = createJobOptions.acousticCustomizationId;
      customizationWeight = createJobOptions.customizationWeight;
      version = createJobOptions.version;
      inactivityTimeout = createJobOptions.inactivityTimeout;
      keywords = createJobOptions.keywords;
      keywordsThreshold = createJobOptions.keywordsThreshold;
      maxAlternatives = createJobOptions.maxAlternatives;
      wordAlternativesThreshold = createJobOptions.wordAlternativesThreshold;
      wordConfidence = createJobOptions.wordConfidence;
      timestamps = createJobOptions.timestamps;
      profanityFilter = createJobOptions.profanityFilter;
      smartFormatting = createJobOptions.smartFormatting;
      speakerLabels = createJobOptions.speakerLabels;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CreateJobOptions.
     *
     * @return the createJobOptions
     */
    public CreateJobOptions build() {
      return new CreateJobOptions(this);
    }

    /**
     * Adds an keywords to keywords.
     *
     * @param keywords the new keywords
     * @return the CreateJobOptions builder
     */
    public Builder addKeywords(String keywords) {
      Validator.notNull(keywords, "keywords cannot be null");
      if (this.keywords == null) {
        this.keywords = new ArrayList<String>();
      }
      this.keywords.add(keywords);
      return this;
    }

    /**
     * Set the callbackUrl.
     *
     * @param callbackUrl the callbackUrl
     * @return the CreateJobOptions builder
     */
    public Builder callbackUrl(String callbackUrl) {
      this.callbackUrl = callbackUrl;
      return this;
    }

    /**
     * Set the events.
     *
     * @param events the events
     * @return the CreateJobOptions builder
     */
    public Builder events(String events) {
      this.events = events;
      return this;
    }

    /**
     * Set the userToken.
     *
     * @param userToken the userToken
     * @return the CreateJobOptions builder
     */
    public Builder userToken(String userToken) {
      this.userToken = userToken;
      return this;
    }

    /**
     * Set the resultsTtl.
     *
     * @param resultsTtl the resultsTtl
     * @return the CreateJobOptions builder
     */
    public Builder resultsTtl(long resultsTtl) {
      this.resultsTtl = resultsTtl;
      return this;
    }

    /**
     * Set the transferEncoding.
     *
     * @param transferEncoding the transferEncoding
     * @return the CreateJobOptions builder
     */
    public Builder transferEncoding(String transferEncoding) {
      this.transferEncoding = transferEncoding;
      return this;
    }

    /**
     * Set the audio.
     *
     * @param audio the audio
     * @return the CreateJobOptions builder
     */
    public Builder audio(File audio) {
      this.audio = audio;
      return this;
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the CreateJobOptions builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the model.
     *
     * @param model the model
     * @return the CreateJobOptions builder
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the CreateJobOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the acousticCustomizationId.
     *
     * @param acousticCustomizationId the acousticCustomizationId
     * @return the CreateJobOptions builder
     */
    public Builder acousticCustomizationId(String acousticCustomizationId) {
      this.acousticCustomizationId = acousticCustomizationId;
      return this;
    }

    /**
     * Set the customizationWeight.
     *
     * @param customizationWeight the customizationWeight
     * @return the CreateJobOptions builder
     */
    public Builder customizationWeight(Double customizationWeight) {
      this.customizationWeight = customizationWeight;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the CreateJobOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the inactivityTimeout.
     *
     * @param inactivityTimeout the inactivityTimeout
     * @return the CreateJobOptions builder
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
     * @return the CreateJobOptions builder
     */
    public Builder keywords(List<String> keywords) {
      this.keywords = keywords;
      return this;
    }

    /**
     * Set the keywordsThreshold.
     *
     * @param keywordsThreshold the keywordsThreshold
     * @return the CreateJobOptions builder
     */
    public Builder keywordsThreshold(Float keywordsThreshold) {
      this.keywordsThreshold = keywordsThreshold;
      return this;
    }

    /**
     * Set the maxAlternatives.
     *
     * @param maxAlternatives the maxAlternatives
     * @return the CreateJobOptions builder
     */
    public Builder maxAlternatives(long maxAlternatives) {
      this.maxAlternatives = maxAlternatives;
      return this;
    }

    /**
     * Set the wordAlternativesThreshold.
     *
     * @param wordAlternativesThreshold the wordAlternativesThreshold
     * @return the CreateJobOptions builder
     */
    public Builder wordAlternativesThreshold(Float wordAlternativesThreshold) {
      this.wordAlternativesThreshold = wordAlternativesThreshold;
      return this;
    }

    /**
     * Set the wordConfidence.
     *
     * @param wordConfidence the wordConfidence
     * @return the CreateJobOptions builder
     */
    public Builder wordConfidence(Boolean wordConfidence) {
      this.wordConfidence = wordConfidence;
      return this;
    }

    /**
     * Set the timestamps.
     *
     * @param timestamps the timestamps
     * @return the CreateJobOptions builder
     */
    public Builder timestamps(Boolean timestamps) {
      this.timestamps = timestamps;
      return this;
    }

    /**
     * Set the profanityFilter.
     *
     * @param profanityFilter the profanityFilter
     * @return the CreateJobOptions builder
     */
    public Builder profanityFilter(Boolean profanityFilter) {
      this.profanityFilter = profanityFilter;
      return this;
    }

    /**
     * Set the smartFormatting.
     *
     * @param smartFormatting the smartFormatting
     * @return the CreateJobOptions builder
     */
    public Builder smartFormatting(Boolean smartFormatting) {
      this.smartFormatting = smartFormatting;
      return this;
    }

    /**
     * Set the speakerLabels.
     *
     * @param speakerLabels the speakerLabels
     * @return the CreateJobOptions builder
     */
    public Builder speakerLabels(Boolean speakerLabels) {
      this.speakerLabels = speakerLabels;
      return this;
    }
  }

  private CreateJobOptions(Builder builder) {
    Validator.isTrue(builder.contentType != null, "contentType cannot be null");
    callbackUrl = builder.callbackUrl;
    events = builder.events;
    userToken = builder.userToken;
    resultsTtl = builder.resultsTtl;
    transferEncoding = builder.transferEncoding;
    audio = builder.audio;
    contentType = builder.contentType;
    model = builder.model;
    customizationId = builder.customizationId;
    acousticCustomizationId = builder.acousticCustomizationId;
    customizationWeight = builder.customizationWeight;
    version = builder.version;
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
   * @return a CreateJobOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the callbackUrl.
   *
   * A URL to which callback notifications are to be sent. The URL must already be successfully white-listed by using
   * the `POST /v1/register_callback` method. Omit the parameter to poll the service for job completion and results. You
   * can include the same callback URL with any number of job creation requests. Use the `user_token` query parameter to
   * specify a unique user-specified string with each job to differentiate the callback notifications for the jobs.
   *
   * @return the callbackUrl
   */
  public String callbackUrl() {
    return callbackUrl;
  }

  /**
   * Gets the events.
   *
   * If the job includes a callback URL, a comma-separated list of notification events to which to subscribe. Valid
   * events are: `recognitions.started` generates a callback notification when the service begins to process the job.
   * `recognitions.completed` generates a callback notification when the job is complete; you must use the `GET
   * /v1/recognitions/{id}` method to retrieve the results before they time out or are deleted.
   * `recognitions.completed_with_results` generates a callback notification when the job is complete; the notification
   * includes the results of the request. `recognitions.failed` generates a callback notification if the service
   * experiences an error while processing the job. Omit the parameter to subscribe to the default events:
   * `recognitions.started`, `recognitions.completed`, and `recognitions.failed`. The `recognitions.completed` and
   * `recognitions.completed_with_results` events are incompatible; you can specify only of the two events. If the job
   * does not include a callback URL, omit the parameter.
   *
   * @return the events
   */
  public String events() {
    return events;
  }

  /**
   * Gets the userToken.
   *
   * If the job includes a callback URL, a user-specified string that the service is to include with each callback
   * notification for the job; the token allows the user to maintain an internal mapping between jobs and notification
   * events. If the job does not include a callback URL, omit the parameter.
   *
   * @return the userToken
   */
  public String userToken() {
    return userToken;
  }

  /**
   * Gets the resultsTtl.
   *
   * The number of minutes for which the results are to be available after the job has finished. If not delivered via a
   * callback, the results must be retrieved within this time. Omit the parameter to use a time to live of one week. The
   * parameter is valid with or without a callback URL.
   *
   * @return the resultsTtl
   */
  public Long resultsTtl() {
    return resultsTtl;
  }

  /**
   * Gets the transferEncoding.
   *
   * Set to `chunked` to send the audio in streaming mode. The data does not need to exist fully before being streamed
   * to the service.
   *
   * @return the transferEncoding
   */
  public String transferEncoding() {
    return transferEncoding;
  }

  /**
   * Gets the audio.
   *
   * @return the audio
   */
  public File audio() {
    return audio;
  }

  /**
   * Gets the contentType.
   *
   * The type of the input: audio/basic, audio/flac, audio/l16, audio/mp3, audio/mpeg, audio/mulaw, audio/ogg,
   * audio/ogg;codecs=opus, audio/ogg;codecs=vorbis, audio/wav, audio/webm, audio/webm;codecs=opus, or
   * audio/webm;codecs=vorbis.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
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
   * The version of the specified base `model` that is to be used with the request. Multiple versions of a base model
   * can exist when a model is updated for internal improvements. The parameter is intended primarily for use with
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
   * Gets the inactivityTimeout.
   *
   * The time in seconds after which, if only silence (no speech) is detected in submitted audio, the connection is
   * closed with a 400 error. Useful for stopping audio submission from a live microphone when a user simply walks away.
   * Use `-1` for infinity.
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
   * spotted only in the final hypothesis, not in interim results. If you specify any keywords, you must also specify a
   * keywords threshold. Omit the parameter or specify an empty array if you do not need to spot keywords.
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
   * confidence is greater than or equal to the threshold. Specify a probability between 0 and 1 inclusive. No keyword
   * spotting is performed if you omit the parameter. If you specify a threshold, you must also specify one or more
   * keywords.
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
   * Confidence value that is the lower bound for identifying a hypothesis as a possible word alternative (also known as
   * "Confusion Networks"). An alternative word is considered if its confidence is greater than or equal to the
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
   * If `true`, confidence measure per word is returned.
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
   * words with a series of asterisks. Set the parameter to `false` to return results with no censoring. Applies to US
   * English transcription only.
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
   * Indicates whether labels that identify which words were spoken by which participants in a multi-person exchange are
   * to be included in the response. The default is `false`; no speaker labels are returned. Setting `speaker_labels` to
   * `true` forces the `timestamps` parameter to be `true`, regardless of whether you specify `false` for the parameter.
   * To determine whether a language model supports speaker labels, use the `GET /v1/models` method and check that the
   * attribute `speaker_labels` is set to `true`. You can also refer to [Speaker
   * labels](https://console.bluemix.net/docs/services/speech-to-text/output.html#speaker_labels).
   *
   * @return the speakerLabels
   */
  public Boolean speakerLabels() {
    return speakerLabels;
  }
}

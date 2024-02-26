/*
 * (C) Copyright IBM Corp. 2018, 2024.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/** The createJob options. */
public class CreateJobOptions extends GenericModel {

  /**
   * The model to use for speech recognition. If you omit the `model` parameter, the service uses
   * the US English `en-US_BroadbandModel` by default.
   *
   * <p>_For IBM Cloud Pak for Data,_ if you do not install the `en-US_BroadbandModel`, you must
   * either specify a model with the request or specify a new default model for your installation of
   * the service.
   *
   * <p>**See also:** * [Using a model for speech
   * recognition](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-models-use) *
   * [Using the default
   * model](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-models-use#models-use-default).
   */
  public interface Model {
    /** ar-MS_BroadbandModel. */
    String AR_MS_BROADBANDMODEL = "ar-MS_BroadbandModel";
    /** ar-MS_Telephony. */
    String AR_MS_TELEPHONY = "ar-MS_Telephony";
    /** cs-CZ_Telephony. */
    String CS_CZ_TELEPHONY = "cs-CZ_Telephony";
    /** de-DE_BroadbandModel. */
    String DE_DE_BROADBANDMODEL = "de-DE_BroadbandModel";
    /** de-DE_Multimedia. */
    String DE_DE_MULTIMEDIA = "de-DE_Multimedia";
    /** de-DE_NarrowbandModel. */
    String DE_DE_NARROWBANDMODEL = "de-DE_NarrowbandModel";
    /** de-DE_Telephony. */
    String DE_DE_TELEPHONY = "de-DE_Telephony";
    /** en-AU_BroadbandModel. */
    String EN_AU_BROADBANDMODEL = "en-AU_BroadbandModel";
    /** en-AU_Multimedia. */
    String EN_AU_MULTIMEDIA = "en-AU_Multimedia";
    /** en-AU_NarrowbandModel. */
    String EN_AU_NARROWBANDMODEL = "en-AU_NarrowbandModel";
    /** en-AU_Telephony. */
    String EN_AU_TELEPHONY = "en-AU_Telephony";
    /** en-IN_Telephony. */
    String EN_IN_TELEPHONY = "en-IN_Telephony";
    /** en-GB_BroadbandModel. */
    String EN_GB_BROADBANDMODEL = "en-GB_BroadbandModel";
    /** en-GB_Multimedia. */
    String EN_GB_MULTIMEDIA = "en-GB_Multimedia";
    /** en-GB_NarrowbandModel. */
    String EN_GB_NARROWBANDMODEL = "en-GB_NarrowbandModel";
    /** en-GB_Telephony. */
    String EN_GB_TELEPHONY = "en-GB_Telephony";
    /** en-US_BroadbandModel. */
    String EN_US_BROADBANDMODEL = "en-US_BroadbandModel";
    /** en-US_Multimedia. */
    String EN_US_MULTIMEDIA = "en-US_Multimedia";
    /** en-US_NarrowbandModel. */
    String EN_US_NARROWBANDMODEL = "en-US_NarrowbandModel";
    /** en-US_ShortForm_NarrowbandModel. */
    String EN_US_SHORTFORM_NARROWBANDMODEL = "en-US_ShortForm_NarrowbandModel";
    /** en-US_Telephony. */
    String EN_US_TELEPHONY = "en-US_Telephony";
    /** en-WW_Medical_Telephony. */
    String EN_WW_MEDICAL_TELEPHONY = "en-WW_Medical_Telephony";
    /** es-AR_BroadbandModel. */
    String ES_AR_BROADBANDMODEL = "es-AR_BroadbandModel";
    /** es-AR_NarrowbandModel. */
    String ES_AR_NARROWBANDMODEL = "es-AR_NarrowbandModel";
    /** es-CL_BroadbandModel. */
    String ES_CL_BROADBANDMODEL = "es-CL_BroadbandModel";
    /** es-CL_NarrowbandModel. */
    String ES_CL_NARROWBANDMODEL = "es-CL_NarrowbandModel";
    /** es-CO_BroadbandModel. */
    String ES_CO_BROADBANDMODEL = "es-CO_BroadbandModel";
    /** es-CO_NarrowbandModel. */
    String ES_CO_NARROWBANDMODEL = "es-CO_NarrowbandModel";
    /** es-ES_BroadbandModel. */
    String ES_ES_BROADBANDMODEL = "es-ES_BroadbandModel";
    /** es-ES_NarrowbandModel. */
    String ES_ES_NARROWBANDMODEL = "es-ES_NarrowbandModel";
    /** es-ES_Multimedia. */
    String ES_ES_MULTIMEDIA = "es-ES_Multimedia";
    /** es-ES_Telephony. */
    String ES_ES_TELEPHONY = "es-ES_Telephony";
    /** es-LA_Telephony. */
    String ES_LA_TELEPHONY = "es-LA_Telephony";
    /** es-MX_BroadbandModel. */
    String ES_MX_BROADBANDMODEL = "es-MX_BroadbandModel";
    /** es-MX_NarrowbandModel. */
    String ES_MX_NARROWBANDMODEL = "es-MX_NarrowbandModel";
    /** es-PE_BroadbandModel. */
    String ES_PE_BROADBANDMODEL = "es-PE_BroadbandModel";
    /** es-PE_NarrowbandModel. */
    String ES_PE_NARROWBANDMODEL = "es-PE_NarrowbandModel";
    /** fr-CA_BroadbandModel. */
    String FR_CA_BROADBANDMODEL = "fr-CA_BroadbandModel";
    /** fr-CA_Multimedia. */
    String FR_CA_MULTIMEDIA = "fr-CA_Multimedia";
    /** fr-CA_NarrowbandModel. */
    String FR_CA_NARROWBANDMODEL = "fr-CA_NarrowbandModel";
    /** fr-CA_Telephony. */
    String FR_CA_TELEPHONY = "fr-CA_Telephony";
    /** fr-FR_BroadbandModel. */
    String FR_FR_BROADBANDMODEL = "fr-FR_BroadbandModel";
    /** fr-FR_Multimedia. */
    String FR_FR_MULTIMEDIA = "fr-FR_Multimedia";
    /** fr-FR_NarrowbandModel. */
    String FR_FR_NARROWBANDMODEL = "fr-FR_NarrowbandModel";
    /** fr-FR_Telephony. */
    String FR_FR_TELEPHONY = "fr-FR_Telephony";
    /** hi-IN_Telephony. */
    String HI_IN_TELEPHONY = "hi-IN_Telephony";
    /** it-IT_BroadbandModel. */
    String IT_IT_BROADBANDMODEL = "it-IT_BroadbandModel";
    /** it-IT_NarrowbandModel. */
    String IT_IT_NARROWBANDMODEL = "it-IT_NarrowbandModel";
    /** it-IT_Multimedia. */
    String IT_IT_MULTIMEDIA = "it-IT_Multimedia";
    /** it-IT_Telephony. */
    String IT_IT_TELEPHONY = "it-IT_Telephony";
    /** ja-JP_BroadbandModel. */
    String JA_JP_BROADBANDMODEL = "ja-JP_BroadbandModel";
    /** ja-JP_Multimedia. */
    String JA_JP_MULTIMEDIA = "ja-JP_Multimedia";
    /** ja-JP_NarrowbandModel. */
    String JA_JP_NARROWBANDMODEL = "ja-JP_NarrowbandModel";
    /** ja-JP_Telephony. */
    String JA_JP_TELEPHONY = "ja-JP_Telephony";
    /** ko-KR_BroadbandModel. */
    String KO_KR_BROADBANDMODEL = "ko-KR_BroadbandModel";
    /** ko-KR_Multimedia. */
    String KO_KR_MULTIMEDIA = "ko-KR_Multimedia";
    /** ko-KR_NarrowbandModel. */
    String KO_KR_NARROWBANDMODEL = "ko-KR_NarrowbandModel";
    /** ko-KR_Telephony. */
    String KO_KR_TELEPHONY = "ko-KR_Telephony";
    /** nl-BE_Telephony. */
    String NL_BE_TELEPHONY = "nl-BE_Telephony";
    /** nl-NL_BroadbandModel. */
    String NL_NL_BROADBANDMODEL = "nl-NL_BroadbandModel";
    /** nl-NL_Multimedia. */
    String NL_NL_MULTIMEDIA = "nl-NL_Multimedia";
    /** nl-NL_NarrowbandModel. */
    String NL_NL_NARROWBANDMODEL = "nl-NL_NarrowbandModel";
    /** nl-NL_Telephony. */
    String NL_NL_TELEPHONY = "nl-NL_Telephony";
    /** pt-BR_BroadbandModel. */
    String PT_BR_BROADBANDMODEL = "pt-BR_BroadbandModel";
    /** pt-BR_Multimedia. */
    String PT_BR_MULTIMEDIA = "pt-BR_Multimedia";
    /** pt-BR_NarrowbandModel. */
    String PT_BR_NARROWBANDMODEL = "pt-BR_NarrowbandModel";
    /** pt-BR_Telephony. */
    String PT_BR_TELEPHONY = "pt-BR_Telephony";
    /** sv-SE_Telephony. */
    String SV_SE_TELEPHONY = "sv-SE_Telephony";
    /** zh-CN_BroadbandModel. */
    String ZH_CN_BROADBANDMODEL = "zh-CN_BroadbandModel";
    /** zh-CN_NarrowbandModel. */
    String ZH_CN_NARROWBANDMODEL = "zh-CN_NarrowbandModel";
    /** zh-CN_Telephony. */
    String ZH_CN_TELEPHONY = "zh-CN_Telephony";
  }

  /**
   * If the job includes a callback URL, a comma-separated list of notification events to which to
   * subscribe. Valid events are * `recognitions.started` generates a callback notification when the
   * service begins to process the job. * `recognitions.completed` generates a callback notification
   * when the job is complete. You must use the [Check a job](#checkjob) method to retrieve the
   * results before they time out or are deleted. * `recognitions.completed_with_results` generates
   * a callback notification when the job is complete. The notification includes the results of the
   * request. * `recognitions.failed` generates a callback notification if the service experiences
   * an error while processing the job.
   *
   * <p>The `recognitions.completed` and `recognitions.completed_with_results` events are
   * incompatible. You can specify only of the two events.
   *
   * <p>If the job includes a callback URL, omit the parameter to subscribe to the default events:
   * `recognitions.started`, `recognitions.completed`, and `recognitions.failed`. If the job does
   * not include a callback URL, omit the parameter.
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

  protected InputStream audio;
  protected String contentType;
  protected String model;
  protected String callbackUrl;
  protected String events;
  protected String userToken;
  protected Long resultsTtl;
  protected String languageCustomizationId;
  protected String acousticCustomizationId;
  protected String baseModelVersion;
  protected Double customizationWeight;
  protected Long inactivityTimeout;
  protected List<String> keywords;
  protected Float keywordsThreshold;
  protected Long maxAlternatives;
  protected Float wordAlternativesThreshold;
  protected Boolean wordConfidence;
  protected Boolean timestamps;
  protected Boolean profanityFilter;
  protected Boolean smartFormatting;
  protected Boolean smartFormattingVersion;
  protected Boolean speakerLabels;
  protected String grammarName;
  protected Boolean redaction;
  protected Boolean processingMetrics;
  protected Float processingMetricsInterval;
  protected Boolean audioMetrics;
  protected Double endOfPhraseSilenceTime;
  protected Boolean splitTranscriptAtPhraseEnd;
  protected Float speechDetectorSensitivity;
  protected Float backgroundAudioSuppression;
  protected Boolean lowLatency;
  protected Float characterInsertionBias;

  /** Builder. */
  public static class Builder {
    private InputStream audio;
    private String contentType;
    private String model;
    private String callbackUrl;
    private String events;
    private String userToken;
    private Long resultsTtl;
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
    private Boolean smartFormattingVersion;
    private Boolean speakerLabels;
    private String grammarName;
    private Boolean redaction;
    private Boolean processingMetrics;
    private Float processingMetricsInterval;
    private Boolean audioMetrics;
    private Double endOfPhraseSilenceTime;
    private Boolean splitTranscriptAtPhraseEnd;
    private Float speechDetectorSensitivity;
    private Float backgroundAudioSuppression;
    private Boolean lowLatency;
    private Float characterInsertionBias;

    /**
     * Instantiates a new Builder from an existing CreateJobOptions instance.
     *
     * @param createJobOptions the instance to initialize the Builder with
     */
    private Builder(CreateJobOptions createJobOptions) {
      this.audio = createJobOptions.audio;
      this.contentType = createJobOptions.contentType;
      this.model = createJobOptions.model;
      this.callbackUrl = createJobOptions.callbackUrl;
      this.events = createJobOptions.events;
      this.userToken = createJobOptions.userToken;
      this.resultsTtl = createJobOptions.resultsTtl;
      this.languageCustomizationId = createJobOptions.languageCustomizationId;
      this.acousticCustomizationId = createJobOptions.acousticCustomizationId;
      this.baseModelVersion = createJobOptions.baseModelVersion;
      this.customizationWeight = createJobOptions.customizationWeight;
      this.inactivityTimeout = createJobOptions.inactivityTimeout;
      this.keywords = createJobOptions.keywords;
      this.keywordsThreshold = createJobOptions.keywordsThreshold;
      this.maxAlternatives = createJobOptions.maxAlternatives;
      this.wordAlternativesThreshold = createJobOptions.wordAlternativesThreshold;
      this.wordConfidence = createJobOptions.wordConfidence;
      this.timestamps = createJobOptions.timestamps;
      this.profanityFilter = createJobOptions.profanityFilter;
      this.smartFormatting = createJobOptions.smartFormatting;
      this.smartFormattingVersion = createJobOptions.smartFormattingVersion;
      this.speakerLabels = createJobOptions.speakerLabels;
      this.grammarName = createJobOptions.grammarName;
      this.redaction = createJobOptions.redaction;
      this.processingMetrics = createJobOptions.processingMetrics;
      this.processingMetricsInterval = createJobOptions.processingMetricsInterval;
      this.audioMetrics = createJobOptions.audioMetrics;
      this.endOfPhraseSilenceTime = createJobOptions.endOfPhraseSilenceTime;
      this.splitTranscriptAtPhraseEnd = createJobOptions.splitTranscriptAtPhraseEnd;
      this.speechDetectorSensitivity = createJobOptions.speechDetectorSensitivity;
      this.backgroundAudioSuppression = createJobOptions.backgroundAudioSuppression;
      this.lowLatency = createJobOptions.lowLatency;
      this.characterInsertionBias = createJobOptions.characterInsertionBias;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param audio the audio
     */
    public Builder(InputStream audio) {
      this.audio = audio;
    }

    /**
     * Builds a CreateJobOptions.
     *
     * @return the new CreateJobOptions instance
     */
    public CreateJobOptions build() {
      return new CreateJobOptions(this);
    }

    /**
     * Adds a new element to keywords.
     *
     * @param keyword the new element to be added
     * @return the CreateJobOptions builder
     */
    public Builder addKeyword(String keyword) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(keyword, "keyword cannot be null");
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
     * @return the CreateJobOptions builder
     */
    public Builder audio(InputStream audio) {
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
     * Set the languageCustomizationId.
     *
     * @param languageCustomizationId the languageCustomizationId
     * @return the CreateJobOptions builder
     */
    public Builder languageCustomizationId(String languageCustomizationId) {
      this.languageCustomizationId = languageCustomizationId;
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
     * Set the baseModelVersion.
     *
     * @param baseModelVersion the baseModelVersion
     * @return the CreateJobOptions builder
     */
    public Builder baseModelVersion(String baseModelVersion) {
      this.baseModelVersion = baseModelVersion;
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
     * Set the keywords. Existing keywords will be replaced.
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
     * Set the smartFormattingVersion.
     *
     * @param smartFormattingVersion the smartFormattingVersion
     * @return the CreateJobOptions builder
     */
    public Builder smartFormattingVersion(Boolean smartFormattingVersion) {
      this.smartFormattingVersion = smartFormattingVersion;
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

    /**
     * Set the grammarName.
     *
     * @param grammarName the grammarName
     * @return the CreateJobOptions builder
     */
    public Builder grammarName(String grammarName) {
      this.grammarName = grammarName;
      return this;
    }

    /**
     * Set the redaction.
     *
     * @param redaction the redaction
     * @return the CreateJobOptions builder
     */
    public Builder redaction(Boolean redaction) {
      this.redaction = redaction;
      return this;
    }

    /**
     * Set the processingMetrics.
     *
     * @param processingMetrics the processingMetrics
     * @return the CreateJobOptions builder
     */
    public Builder processingMetrics(Boolean processingMetrics) {
      this.processingMetrics = processingMetrics;
      return this;
    }

    /**
     * Set the processingMetricsInterval.
     *
     * @param processingMetricsInterval the processingMetricsInterval
     * @return the CreateJobOptions builder
     */
    public Builder processingMetricsInterval(Float processingMetricsInterval) {
      this.processingMetricsInterval = processingMetricsInterval;
      return this;
    }

    /**
     * Set the audioMetrics.
     *
     * @param audioMetrics the audioMetrics
     * @return the CreateJobOptions builder
     */
    public Builder audioMetrics(Boolean audioMetrics) {
      this.audioMetrics = audioMetrics;
      return this;
    }

    /**
     * Set the endOfPhraseSilenceTime.
     *
     * @param endOfPhraseSilenceTime the endOfPhraseSilenceTime
     * @return the CreateJobOptions builder
     */
    public Builder endOfPhraseSilenceTime(Double endOfPhraseSilenceTime) {
      this.endOfPhraseSilenceTime = endOfPhraseSilenceTime;
      return this;
    }

    /**
     * Set the splitTranscriptAtPhraseEnd.
     *
     * @param splitTranscriptAtPhraseEnd the splitTranscriptAtPhraseEnd
     * @return the CreateJobOptions builder
     */
    public Builder splitTranscriptAtPhraseEnd(Boolean splitTranscriptAtPhraseEnd) {
      this.splitTranscriptAtPhraseEnd = splitTranscriptAtPhraseEnd;
      return this;
    }

    /**
     * Set the speechDetectorSensitivity.
     *
     * @param speechDetectorSensitivity the speechDetectorSensitivity
     * @return the CreateJobOptions builder
     */
    public Builder speechDetectorSensitivity(Float speechDetectorSensitivity) {
      this.speechDetectorSensitivity = speechDetectorSensitivity;
      return this;
    }

    /**
     * Set the backgroundAudioSuppression.
     *
     * @param backgroundAudioSuppression the backgroundAudioSuppression
     * @return the CreateJobOptions builder
     */
    public Builder backgroundAudioSuppression(Float backgroundAudioSuppression) {
      this.backgroundAudioSuppression = backgroundAudioSuppression;
      return this;
    }

    /**
     * Set the lowLatency.
     *
     * @param lowLatency the lowLatency
     * @return the CreateJobOptions builder
     */
    public Builder lowLatency(Boolean lowLatency) {
      this.lowLatency = lowLatency;
      return this;
    }

    /**
     * Set the characterInsertionBias.
     *
     * @param characterInsertionBias the characterInsertionBias
     * @return the CreateJobOptions builder
     */
    public Builder characterInsertionBias(Float characterInsertionBias) {
      this.characterInsertionBias = characterInsertionBias;
      return this;
    }

    /**
     * Set the audio.
     *
     * @param audio the audio
     * @return the CreateJobOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder audio(File audio) throws FileNotFoundException {
      this.audio = new FileInputStream(audio);
      return this;
    }
  }

  protected CreateJobOptions() {}

  protected CreateJobOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.audio, "audio cannot be null");
    audio = builder.audio;
    contentType = builder.contentType;
    model = builder.model;
    callbackUrl = builder.callbackUrl;
    events = builder.events;
    userToken = builder.userToken;
    resultsTtl = builder.resultsTtl;
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
    smartFormattingVersion = builder.smartFormattingVersion;
    speakerLabels = builder.speakerLabels;
    grammarName = builder.grammarName;
    redaction = builder.redaction;
    processingMetrics = builder.processingMetrics;
    processingMetricsInterval = builder.processingMetricsInterval;
    audioMetrics = builder.audioMetrics;
    endOfPhraseSilenceTime = builder.endOfPhraseSilenceTime;
    splitTranscriptAtPhraseEnd = builder.splitTranscriptAtPhraseEnd;
    speechDetectorSensitivity = builder.speechDetectorSensitivity;
    backgroundAudioSuppression = builder.backgroundAudioSuppression;
    lowLatency = builder.lowLatency;
    characterInsertionBias = builder.characterInsertionBias;
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
   * Gets the audio.
   *
   * <p>The audio to transcribe.
   *
   * @return the audio
   */
  public InputStream audio() {
    return audio;
  }

  /**
   * Gets the contentType.
   *
   * <p>The format (MIME type) of the audio. For more information about specifying an audio format,
   * see **Audio formats (content types)** in the method description.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }

  /**
   * Gets the model.
   *
   * <p>The model to use for speech recognition. If you omit the `model` parameter, the service uses
   * the US English `en-US_BroadbandModel` by default.
   *
   * <p>_For IBM Cloud Pak for Data,_ if you do not install the `en-US_BroadbandModel`, you must
   * either specify a model with the request or specify a new default model for your installation of
   * the service.
   *
   * <p>**See also:** * [Using a model for speech
   * recognition](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-models-use) *
   * [Using the default
   * model](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-models-use#models-use-default).
   *
   * @return the model
   */
  public String model() {
    return model;
  }

  /**
   * Gets the callbackUrl.
   *
   * <p>A URL to which callback notifications are to be sent. The URL must already be successfully
   * allowlisted by using the [Register a callback](#registercallback) method. You can include the
   * same callback URL with any number of job creation requests. Omit the parameter to poll the
   * service for job completion and results.
   *
   * <p>Use the `user_token` parameter to specify a unique user-specified string with each job to
   * differentiate the callback notifications for the jobs.
   *
   * @return the callbackUrl
   */
  public String callbackUrl() {
    return callbackUrl;
  }

  /**
   * Gets the events.
   *
   * <p>If the job includes a callback URL, a comma-separated list of notification events to which
   * to subscribe. Valid events are * `recognitions.started` generates a callback notification when
   * the service begins to process the job. * `recognitions.completed` generates a callback
   * notification when the job is complete. You must use the [Check a job](#checkjob) method to
   * retrieve the results before they time out or are deleted. *
   * `recognitions.completed_with_results` generates a callback notification when the job is
   * complete. The notification includes the results of the request. * `recognitions.failed`
   * generates a callback notification if the service experiences an error while processing the job.
   *
   * <p>The `recognitions.completed` and `recognitions.completed_with_results` events are
   * incompatible. You can specify only of the two events.
   *
   * <p>If the job includes a callback URL, omit the parameter to subscribe to the default events:
   * `recognitions.started`, `recognitions.completed`, and `recognitions.failed`. If the job does
   * not include a callback URL, omit the parameter.
   *
   * @return the events
   */
  public String events() {
    return events;
  }

  /**
   * Gets the userToken.
   *
   * <p>If the job includes a callback URL, a user-specified string that the service is to include
   * with each callback notification for the job; the token allows the user to maintain an internal
   * mapping between jobs and notification events. If the job does not include a callback URL, omit
   * the parameter.
   *
   * @return the userToken
   */
  public String userToken() {
    return userToken;
  }

  /**
   * Gets the resultsTtl.
   *
   * <p>The number of minutes for which the results are to be available after the job has finished.
   * If not delivered via a callback, the results must be retrieved within this time. Omit the
   * parameter to use a time to live of one week. The parameter is valid with or without a callback
   * URL.
   *
   * @return the resultsTtl
   */
  public Long resultsTtl() {
    return resultsTtl;
  }

  /**
   * Gets the languageCustomizationId.
   *
   * <p>The customization ID (GUID) of a custom language model that is to be used with the
   * recognition request. The base model of the specified custom language model must match the model
   * specified with the `model` parameter. You must make the request with credentials for the
   * instance of the service that owns the custom model. By default, no custom language model is
   * used. See [Using a custom language model for speech
   * recognition](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-languageUse).
   *
   * <p>**Note:** Use this parameter instead of the deprecated `customization_id` parameter.
   *
   * @return the languageCustomizationId
   */
  public String languageCustomizationId() {
    return languageCustomizationId;
  }

  /**
   * Gets the acousticCustomizationId.
   *
   * <p>The customization ID (GUID) of a custom acoustic model that is to be used with the
   * recognition request. The base model of the specified custom acoustic model must match the model
   * specified with the `model` parameter. You must make the request with credentials for the
   * instance of the service that owns the custom model. By default, no custom acoustic model is
   * used. See [Using a custom acoustic model for speech
   * recognition](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-acousticUse).
   *
   * @return the acousticCustomizationId
   */
  public String acousticCustomizationId() {
    return acousticCustomizationId;
  }

  /**
   * Gets the baseModelVersion.
   *
   * <p>The version of the specified base model that is to be used with the recognition request.
   * Multiple versions of a base model can exist when a model is updated for internal improvements.
   * The parameter is intended primarily for use with custom models that have been upgraded for a
   * new base model. The default value depends on whether the parameter is used with or without a
   * custom model. See [Making speech recognition requests with upgraded custom
   * models](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-custom-upgrade-use#custom-upgrade-use-recognition).
   *
   * @return the baseModelVersion
   */
  public String baseModelVersion() {
    return baseModelVersion;
  }

  /**
   * Gets the customizationWeight.
   *
   * <p>If you specify the customization ID (GUID) of a custom language model with the recognition
   * request, the customization weight tells the service how much weight to give to words from the
   * custom language model compared to those from the base model for the current request.
   *
   * <p>Specify a value between 0.0 and 1.0. Unless a different customization weight was specified
   * for the custom model when the model was trained, the default value is: * 0.3 for
   * previous-generation models * 0.2 for most next-generation models * 0.1 for next-generation
   * English and Japanese models
   *
   * <p>A customization weight that you specify overrides a weight that was specified when the
   * custom model was trained. The default value yields the best performance in general. Assign a
   * higher value if your audio makes frequent use of OOV words from the custom model. Use caution
   * when setting the weight: a higher value can improve the accuracy of phrases from the custom
   * model's domain, but it can negatively affect performance on non-domain phrases.
   *
   * <p>See [Using customization
   * weight](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-languageUse#weight).
   *
   * @return the customizationWeight
   */
  public Double customizationWeight() {
    return customizationWeight;
  }

  /**
   * Gets the inactivityTimeout.
   *
   * <p>The time in seconds after which, if only silence (no speech) is detected in streaming audio,
   * the connection is closed with a 400 error. The parameter is useful for stopping audio
   * submission from a live microphone when a user simply walks away. Use `-1` for infinity. See
   * [Inactivity
   * timeout](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-input#timeouts-inactivity).
   *
   * @return the inactivityTimeout
   */
  public Long inactivityTimeout() {
    return inactivityTimeout;
  }

  /**
   * Gets the keywords.
   *
   * <p>An array of keyword strings to spot in the audio. Each keyword string can include one or
   * more string tokens. Keywords are spotted only in the final results, not in interim hypotheses.
   * If you specify any keywords, you must also specify a keywords threshold. Omit the parameter or
   * specify an empty array if you do not need to spot keywords.
   *
   * <p>You can spot a maximum of 1000 keywords with a single request. A single keyword can have a
   * maximum length of 1024 characters, though the maximum effective length for double-byte
   * languages might be shorter. Keywords are case-insensitive.
   *
   * <p>See [Keyword
   * spotting](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-spotting#keyword-spotting).
   *
   * @return the keywords
   */
  public List<String> keywords() {
    return keywords;
  }

  /**
   * Gets the keywordsThreshold.
   *
   * <p>A confidence value that is the lower bound for spotting a keyword. A word is considered to
   * match a keyword if its confidence is greater than or equal to the threshold. Specify a
   * probability between 0.0 and 1.0. If you specify a threshold, you must also specify one or more
   * keywords. The service performs no keyword spotting if you omit either parameter. See [Keyword
   * spotting](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-spotting#keyword-spotting).
   *
   * @return the keywordsThreshold
   */
  public Float keywordsThreshold() {
    return keywordsThreshold;
  }

  /**
   * Gets the maxAlternatives.
   *
   * <p>The maximum number of alternative transcripts that the service is to return. By default, the
   * service returns a single transcript. If you specify a value of `0`, the service uses the
   * default value, `1`. See [Maximum
   * alternatives](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-metadata#max-alternatives).
   *
   * @return the maxAlternatives
   */
  public Long maxAlternatives() {
    return maxAlternatives;
  }

  /**
   * Gets the wordAlternativesThreshold.
   *
   * <p>A confidence value that is the lower bound for identifying a hypothesis as a possible word
   * alternative (also known as "Confusion Networks"). An alternative word is considered if its
   * confidence is greater than or equal to the threshold. Specify a probability between 0.0 and
   * 1.0. By default, the service computes no alternative words. See [Word
   * alternatives](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-spotting#word-alternatives).
   *
   * @return the wordAlternativesThreshold
   */
  public Float wordAlternativesThreshold() {
    return wordAlternativesThreshold;
  }

  /**
   * Gets the wordConfidence.
   *
   * <p>If `true`, the service returns a confidence measure in the range of 0.0 to 1.0 for each
   * word. By default, the service returns no word confidence scores. See [Word
   * confidence](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-metadata#word-confidence).
   *
   * @return the wordConfidence
   */
  public Boolean wordConfidence() {
    return wordConfidence;
  }

  /**
   * Gets the timestamps.
   *
   * <p>If `true`, the service returns time alignment for each word. By default, no timestamps are
   * returned. See [Word
   * timestamps](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-metadata#word-timestamps).
   *
   * @return the timestamps
   */
  public Boolean timestamps() {
    return timestamps;
  }

  /**
   * Gets the profanityFilter.
   *
   * <p>If `true`, the service filters profanity from all output except for keyword results by
   * replacing inappropriate words with a series of asterisks. Set the parameter to `false` to
   * return results with no censoring.
   *
   * <p>**Note:** The parameter can be used with US English and Japanese transcription only. See
   * [Profanity
   * filtering](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-formatting#profanity-filtering).
   *
   * @return the profanityFilter
   */
  public Boolean profanityFilter() {
    return profanityFilter;
  }

  /**
   * Gets the smartFormatting.
   *
   * <p>If `true`, the service converts dates, times, series of digits and numbers, phone numbers,
   * currency values, and internet addresses into more readable, conventional representations in the
   * final transcript of a recognition request. For US English, the service also converts certain
   * keyword strings to punctuation symbols. By default, the service performs no smart formatting.
   *
   * <p>**Note:** The parameter can be used with US English, Japanese, and Spanish (all dialects)
   * transcription only.
   *
   * <p>See [Smart
   * formatting](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-formatting#smart-formatting).
   *
   * @return the smartFormatting
   */
  public Boolean smartFormatting() {
    return smartFormatting;
  }

  /**
   * Gets the smartFormattingVersion.
   *
   * <p>Smart formatting version is for next-generation models and that is supported in US English,
   * Brazilian Portuguese, French and German languages.
   *
   * @return the smartFormattingVersion
   */
  public Boolean smartFormattingVersion() {
    return smartFormattingVersion;
  }

  /**
   * Gets the speakerLabels.
   *
   * <p>If `true`, the response includes labels that identify which words were spoken by which
   * participants in a multi-person exchange. By default, the service returns no speaker labels.
   * Setting `speaker_labels` to `true` forces the `timestamps` parameter to be `true`, regardless
   * of whether you specify `false` for the parameter. * _For previous-generation models,_ the
   * parameter can be used with Australian English, US English, German, Japanese, Korean, and
   * Spanish (both broadband and narrowband models) and UK English (narrowband model) transcription
   * only. * _For next-generation models,_ the parameter can be used with Czech, English
   * (Australian, Indian, UK, and US), German, Japanese, Korean, and Spanish transcription only.
   *
   * <p>See [Speaker
   * labels](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-speaker-labels).
   *
   * @return the speakerLabels
   */
  public Boolean speakerLabels() {
    return speakerLabels;
  }

  /**
   * Gets the grammarName.
   *
   * <p>The name of a grammar that is to be used with the recognition request. If you specify a
   * grammar, you must also use the `language_customization_id` parameter to specify the name of the
   * custom language model for which the grammar is defined. The service recognizes only strings
   * that are recognized by the specified grammar; it does not recognize other custom words from the
   * model's words resource.
   *
   * <p>See [Using a grammar for speech
   * recognition](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-grammarUse).
   *
   * @return the grammarName
   */
  public String grammarName() {
    return grammarName;
  }

  /**
   * Gets the redaction.
   *
   * <p>If `true`, the service redacts, or masks, numeric data from final transcripts. The feature
   * redacts any number that has three or more consecutive digits by replacing each digit with an
   * `X` character. It is intended to redact sensitive numeric data, such as credit card numbers. By
   * default, the service performs no redaction.
   *
   * <p>When you enable redaction, the service automatically enables smart formatting, regardless of
   * whether you explicitly disable that feature. To ensure maximum security, the service also
   * disables keyword spotting (ignores the `keywords` and `keywords_threshold` parameters) and
   * returns only a single final transcript (forces the `max_alternatives` parameter to be `1`).
   *
   * <p>**Note:** The parameter can be used with US English, Japanese, and Korean transcription
   * only.
   *
   * <p>See [Numeric
   * redaction](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-formatting#numeric-redaction).
   *
   * @return the redaction
   */
  public Boolean redaction() {
    return redaction;
  }

  /**
   * Gets the processingMetrics.
   *
   * <p>If `true`, requests processing metrics about the service's transcription of the input audio.
   * The service returns processing metrics at the interval specified by the
   * `processing_metrics_interval` parameter. It also returns processing metrics for transcription
   * events, for example, for final and interim results. By default, the service returns no
   * processing metrics.
   *
   * <p>See [Processing
   * metrics](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-metrics#processing-metrics).
   *
   * @return the processingMetrics
   */
  public Boolean processingMetrics() {
    return processingMetrics;
  }

  /**
   * Gets the processingMetricsInterval.
   *
   * <p>Specifies the interval in real wall-clock seconds at which the service is to return
   * processing metrics. The parameter is ignored unless the `processing_metrics` parameter is set
   * to `true`.
   *
   * <p>The parameter accepts a minimum value of 0.1 seconds. The level of precision is not
   * restricted, so you can specify values such as 0.25 and 0.125.
   *
   * <p>The service does not impose a maximum value. If you want to receive processing metrics only
   * for transcription events instead of at periodic intervals, set the value to a large number. If
   * the value is larger than the duration of the audio, the service returns processing metrics only
   * for transcription events.
   *
   * <p>See [Processing
   * metrics](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-metrics#processing-metrics).
   *
   * @return the processingMetricsInterval
   */
  public Float processingMetricsInterval() {
    return processingMetricsInterval;
  }

  /**
   * Gets the audioMetrics.
   *
   * <p>If `true`, requests detailed information about the signal characteristics of the input
   * audio. The service returns audio metrics with the final transcription results. By default, the
   * service returns no audio metrics.
   *
   * <p>See [Audio
   * metrics](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-metrics#audio-metrics).
   *
   * @return the audioMetrics
   */
  public Boolean audioMetrics() {
    return audioMetrics;
  }

  /**
   * Gets the endOfPhraseSilenceTime.
   *
   * <p>Specifies the duration of the pause interval at which the service splits a transcript into
   * multiple final results. If the service detects pauses or extended silence before it reaches the
   * end of the audio stream, its response can include multiple final results. Silence indicates a
   * point at which the speaker pauses between spoken words or phrases.
   *
   * <p>Specify a value for the pause interval in the range of 0.0 to 120.0. * A value greater than
   * 0 specifies the interval that the service is to use for speech recognition. * A value of 0
   * indicates that the service is to use the default interval. It is equivalent to omitting the
   * parameter.
   *
   * <p>The default pause interval for most languages is 0.8 seconds; the default for Chinese is 0.6
   * seconds.
   *
   * <p>See [End of phrase silence
   * time](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-parsing#silence-time).
   *
   * @return the endOfPhraseSilenceTime
   */
  public Double endOfPhraseSilenceTime() {
    return endOfPhraseSilenceTime;
  }

  /**
   * Gets the splitTranscriptAtPhraseEnd.
   *
   * <p>If `true`, directs the service to split the transcript into multiple final results based on
   * semantic features of the input, for example, at the conclusion of meaningful phrases such as
   * sentences. The service bases its understanding of semantic features on the base language model
   * that you use with a request. Custom language models and grammars can also influence how and
   * where the service splits a transcript.
   *
   * <p>By default, the service splits transcripts based solely on the pause interval. If the
   * parameters are used together on the same request, `end_of_phrase_silence_time` has precedence
   * over `split_transcript_at_phrase_end`.
   *
   * <p>See [Split transcript at phrase
   * end](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-parsing#split-transcript).
   *
   * @return the splitTranscriptAtPhraseEnd
   */
  public Boolean splitTranscriptAtPhraseEnd() {
    return splitTranscriptAtPhraseEnd;
  }

  /**
   * Gets the speechDetectorSensitivity.
   *
   * <p>The sensitivity of speech activity detection that the service is to perform. Use the
   * parameter to suppress word insertions from music, coughing, and other non-speech events. The
   * service biases the audio it passes for speech recognition by evaluating the input audio against
   * prior models of speech and non-speech activity.
   *
   * <p>Specify a value between 0.0 and 1.0: * 0.0 suppresses all audio (no speech is transcribed).
   * * 0.5 (the default) provides a reasonable compromise for the level of sensitivity. * 1.0
   * suppresses no audio (speech detection sensitivity is disabled).
   *
   * <p>The values increase on a monotonic curve. Specifying one or two decimal places of precision
   * (for example, `0.55`) is typically more than sufficient.
   *
   * <p>The parameter is supported with all next-generation models and with most previous-generation
   * models. See [Speech detector
   * sensitivity](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-detection#detection-parameters-sensitivity)
   * and [Language model
   * support](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-detection#detection-support).
   *
   * @return the speechDetectorSensitivity
   */
  public Float speechDetectorSensitivity() {
    return speechDetectorSensitivity;
  }

  /**
   * Gets the backgroundAudioSuppression.
   *
   * <p>The level to which the service is to suppress background audio based on its volume to
   * prevent it from being transcribed as speech. Use the parameter to suppress side conversations
   * or background noise.
   *
   * <p>Specify a value in the range of 0.0 to 1.0: * 0.0 (the default) provides no suppression
   * (background audio suppression is disabled). * 0.5 provides a reasonable level of audio
   * suppression for general usage. * 1.0 suppresses all audio (no audio is transcribed).
   *
   * <p>The values increase on a monotonic curve. Specifying one or two decimal places of precision
   * (for example, `0.55`) is typically more than sufficient.
   *
   * <p>The parameter is supported with all next-generation models and with most previous-generation
   * models. See [Background audio
   * suppression](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-detection#detection-parameters-suppression)
   * and [Language model
   * support](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-detection#detection-support).
   *
   * @return the backgroundAudioSuppression
   */
  public Float backgroundAudioSuppression() {
    return backgroundAudioSuppression;
  }

  /**
   * Gets the lowLatency.
   *
   * <p>If `true` for next-generation `Multimedia` and `Telephony` models that support low latency,
   * directs the service to produce results even more quickly than it usually does. Next-generation
   * models produce transcription results faster than previous-generation models. The `low_latency`
   * parameter causes the models to produce results even more quickly, though the results might be
   * less accurate when the parameter is used.
   *
   * <p>The parameter is not available for previous-generation `Broadband` and `Narrowband` models.
   * It is available for most next-generation models. * For a list of next-generation models that
   * support low latency, see [Supported next-generation language
   * models](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-models-ng#models-ng-supported).
   * * For more information about the `low_latency` parameter, see [Low
   * latency](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-interim#low-latency).
   *
   * @return the lowLatency
   */
  public Boolean lowLatency() {
    return lowLatency;
  }

  /**
   * Gets the characterInsertionBias.
   *
   * <p>For next-generation models, an indication of whether the service is biased to recognize
   * shorter or longer strings of characters when developing transcription hypotheses. By default,
   * the service is optimized to produce the best balance of strings of different lengths.
   *
   * <p>The default bias is 0.0. The allowable range of values is -1.0 to 1.0. * Negative values
   * bias the service to favor hypotheses with shorter strings of characters. * Positive values bias
   * the service to favor hypotheses with longer strings of characters.
   *
   * <p>As the value approaches -1.0 or 1.0, the impact of the parameter becomes more pronounced. To
   * determine the most effective value for your scenario, start by setting the value of the
   * parameter to a small increment, such as -0.1, -0.05, 0.05, or 0.1, and assess how the value
   * impacts the transcription results. Then experiment with different values as necessary,
   * adjusting the value by small increments.
   *
   * <p>The parameter is not available for previous-generation models.
   *
   * <p>See [Character insertion
   * bias](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-parsing#insertion-bias).
   *
   * @return the characterInsertionBias
   */
  public Float characterInsertionBias() {
    return characterInsertionBias;
  }
}

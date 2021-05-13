/*
 * (C) Copyright IBM Corp. 2016, 2021.
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

/** The recognize options. */
public class RecognizeOptions extends GenericModel {

  /**
   * The identifier of the model that is to be used for the recognition request. (**Note:** The
   * model `ar-AR_BroadbandModel` is deprecated; use `ar-MS_BroadbandModel` instead.) See [Languages
   * and models](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-models) and
   * [Next-generation languages and
   * models](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-models-ng).
   */
  public interface Model {
    /** ar-AR_BroadbandModel. */
    String AR_AR_BROADBANDMODEL = "ar-AR_BroadbandModel";
    /** ar-MS_BroadbandModel. */
    String AR_MS_BROADBANDMODEL = "ar-MS_BroadbandModel";
    /** ar-MS_Telephony. */
    String AR_MS_TELEPHONY = "ar-MS_Telephony";
    /** de-DE_BroadbandModel. */
    String DE_DE_BROADBANDMODEL = "de-DE_BroadbandModel";
    /** de-DE_NarrowbandModel. */
    String DE_DE_NARROWBANDMODEL = "de-DE_NarrowbandModel";
    /** de-DE_Telephony. */
    String DE_DE_TELEPHONY = "de-DE_Telephony";
    /** en-AU_BroadbandModel. */
    String EN_AU_BROADBANDMODEL = "en-AU_BroadbandModel";
    /** en-AU_NarrowbandModel. */
    String EN_AU_NARROWBANDMODEL = "en-AU_NarrowbandModel";
    /** en-AU_Telephony. */
    String EN_AU_TELEPHONY = "en-AU_Telephony";
    /** en-GB_BroadbandModel. */
    String EN_GB_BROADBANDMODEL = "en-GB_BroadbandModel";
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
    /** es-ES_Telephony. */
    String ES_ES_TELEPHONY = "es-ES_Telephony";
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
    /** fr-CA_NarrowbandModel. */
    String FR_CA_NARROWBANDMODEL = "fr-CA_NarrowbandModel";
    /** fr-CA_Telephony. */
    String FR_CA_TELEPHONY = "fr-CA_Telephony";
    /** fr-FR_BroadbandModel. */
    String FR_FR_BROADBANDMODEL = "fr-FR_BroadbandModel";
    /** fr-FR_NarrowbandModel. */
    String FR_FR_NARROWBANDMODEL = "fr-FR_NarrowbandModel";
    /** fr-FR_Telephony. */
    String FR_FR_TELEPHONY = "fr-FR_Telephony";
    /** it-IT_BroadbandModel. */
    String IT_IT_BROADBANDMODEL = "it-IT_BroadbandModel";
    /** it-IT_NarrowbandModel. */
    String IT_IT_NARROWBANDMODEL = "it-IT_NarrowbandModel";
    /** it-IT_Telephony. */
    String IT_IT_TELEPHONY = "it-IT_Telephony";
    /** ja-JP_BroadbandModel. */
    String JA_JP_BROADBANDMODEL = "ja-JP_BroadbandModel";
    /** ja-JP_NarrowbandModel. */
    String JA_JP_NARROWBANDMODEL = "ja-JP_NarrowbandModel";
    /** ko-KR_BroadbandModel. */
    String KO_KR_BROADBANDMODEL = "ko-KR_BroadbandModel";
    /** ko-KR_NarrowbandModel. */
    String KO_KR_NARROWBANDMODEL = "ko-KR_NarrowbandModel";
    /** nl-NL_BroadbandModel. */
    String NL_NL_BROADBANDMODEL = "nl-NL_BroadbandModel";
    /** nl-NL_NarrowbandModel. */
    String NL_NL_NARROWBANDMODEL = "nl-NL_NarrowbandModel";
    /** pt-BR_BroadbandModel. */
    String PT_BR_BROADBANDMODEL = "pt-BR_BroadbandModel";
    /** pt-BR_NarrowbandModel. */
    String PT_BR_NARROWBANDMODEL = "pt-BR_NarrowbandModel";
    /** pt-BR_Telephony. */
    String PT_BR_TELEPHONY = "pt-BR_Telephony";
    /** zh-CN_BroadbandModel. */
    String ZH_CN_BROADBANDMODEL = "zh-CN_BroadbandModel";
    /** zh-CN_NarrowbandModel. */
    String ZH_CN_NARROWBANDMODEL = "zh-CN_NarrowbandModel";
  }

  protected InputStream audio;
  protected String contentType;
  protected String model;
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
  protected Boolean speakerLabels;
  protected String customizationId;
  protected String grammarName;
  protected Boolean redaction;
  protected Boolean audioMetrics;
  protected Double endOfPhraseSilenceTime;
  protected Boolean splitTranscriptAtPhraseEnd;
  protected Float speechDetectorSensitivity;
  protected Float backgroundAudioSuppression;
  protected Boolean lowLatency;

  /** Builder. */
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
    private String grammarName;
    private Boolean redaction;
    private Boolean audioMetrics;
    private Double endOfPhraseSilenceTime;
    private Boolean splitTranscriptAtPhraseEnd;
    private Float speechDetectorSensitivity;
    private Float backgroundAudioSuppression;
    private Boolean lowLatency;

    private Builder(RecognizeOptions recognizeOptions) {
      this.audio = recognizeOptions.audio;
      this.contentType = recognizeOptions.contentType;
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
      this.grammarName = recognizeOptions.grammarName;
      this.redaction = recognizeOptions.redaction;
      this.audioMetrics = recognizeOptions.audioMetrics;
      this.endOfPhraseSilenceTime = recognizeOptions.endOfPhraseSilenceTime;
      this.splitTranscriptAtPhraseEnd = recognizeOptions.splitTranscriptAtPhraseEnd;
      this.speechDetectorSensitivity = recognizeOptions.speechDetectorSensitivity;
      this.backgroundAudioSuppression = recognizeOptions.backgroundAudioSuppression;
      this.lowLatency = recognizeOptions.lowLatency;
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
     * Builds a RecognizeOptions.
     *
     * @return the new RecognizeOptions instance
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
     * Set the keywords. Existing keywords will be replaced.
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
     * Set the endOfPhraseSilenceTime.
     *
     * @param endOfPhraseSilenceTime the endOfPhraseSilenceTime
     * @return the RecognizeOptions builder
     */
    public Builder endOfPhraseSilenceTime(Double endOfPhraseSilenceTime) {
      this.endOfPhraseSilenceTime = endOfPhraseSilenceTime;
      return this;
    }

    /**
     * Set the splitTranscriptAtPhraseEnd.
     *
     * @param splitTranscriptAtPhraseEnd the splitTranscriptAtPhraseEnd
     * @return the RecognizeOptions builder
     */
    public Builder splitTranscriptAtPhraseEnd(Boolean splitTranscriptAtPhraseEnd) {
      this.splitTranscriptAtPhraseEnd = splitTranscriptAtPhraseEnd;
      return this;
    }

    /**
     * Set the speechDetectorSensitivity.
     *
     * @param speechDetectorSensitivity the speechDetectorSensitivity
     * @return the RecognizeOptions builder
     */
    public Builder speechDetectorSensitivity(Float speechDetectorSensitivity) {
      this.speechDetectorSensitivity = speechDetectorSensitivity;
      return this;
    }

    /**
     * Set the backgroundAudioSuppression.
     *
     * @param backgroundAudioSuppression the backgroundAudioSuppression
     * @return the RecognizeOptions builder
     */
    public Builder backgroundAudioSuppression(Float backgroundAudioSuppression) {
      this.backgroundAudioSuppression = backgroundAudioSuppression;
      return this;
    }

    /**
     * Set the lowLatency.
     *
     * @param lowLatency the lowLatency
     * @return the RecognizeOptions builder
     */
    public Builder lowLatency(Boolean lowLatency) {
      this.lowLatency = lowLatency;
      return this;
    }

    /**
     * Set the audio.
     *
     * @param audio the audio
     * @return the RecognizeOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder audio(File audio) throws FileNotFoundException {
      this.audio = new FileInputStream(audio);
      return this;
    }
  }

  protected RecognizeOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.audio, "audio cannot be null");
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
    grammarName = builder.grammarName;
    redaction = builder.redaction;
    audioMetrics = builder.audioMetrics;
    endOfPhraseSilenceTime = builder.endOfPhraseSilenceTime;
    splitTranscriptAtPhraseEnd = builder.splitTranscriptAtPhraseEnd;
    speechDetectorSensitivity = builder.speechDetectorSensitivity;
    backgroundAudioSuppression = builder.backgroundAudioSuppression;
    lowLatency = builder.lowLatency;
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
   * <p>The identifier of the model that is to be used for the recognition request. (**Note:** The
   * model `ar-AR_BroadbandModel` is deprecated; use `ar-MS_BroadbandModel` instead.) See [Languages
   * and models](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-models) and
   * [Next-generation languages and
   * models](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-models-ng).
   *
   * @return the model
   */
  public String model() {
    return model;
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
   * for the custom model when it was trained, the default value is 0.3. A customization weight that
   * you specify overrides a weight that was specified when the custom model was trained.
   *
   * <p>The default value yields the best performance in general. Assign a higher value if your
   * audio makes frequent use of OOV words from the custom model. Use caution when setting the
   * weight: a higher value can improve the accuracy of phrases from the custom model's domain, but
   * it can negatively affect performance on non-domain phrases.
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
   * return results with no censoring. Applies to US English and Japanese transcription only. See
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
   * <p>**Note:** Applies to US English, Japanese, and Spanish transcription only.
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
   * Gets the speakerLabels.
   *
   * <p>If `true`, the response includes labels that identify which words were spoken by which
   * participants in a multi-person exchange. By default, the service returns no speaker labels.
   * Setting `speaker_labels` to `true` forces the `timestamps` parameter to be `true`, regardless
   * of whether you specify `false` for the parameter. * For previous-generation models, can be used
   * for US English, Australian English, German, Japanese, Korean, and Spanish (both broadband and
   * narrowband models) and UK English (narrowband model) transcription only. * For next-generation
   * models, can be used for English (Australian, UK, and US), German, and Spanish transcription
   * only.
   *
   * <p>Restrictions and limitations apply to the use of speaker labels for both types of models.
   * See [Speaker
   * labels](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-speaker-labels).
   *
   * @return the speakerLabels
   */
  public Boolean speakerLabels() {
    return speakerLabels;
  }

  /**
   * Gets the customizationId.
   *
   * <p>**Deprecated.** Use the `language_customization_id` parameter to specify the customization
   * ID (GUID) of a custom language model that is to be used with the recognition request. Do not
   * specify both parameters with a request.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the grammarName.
   *
   * <p>The name of a grammar that is to be used with the recognition request. If you specify a
   * grammar, you must also use the `language_customization_id` parameter to specify the name of the
   * custom language model for which the grammar is defined. The service recognizes only strings
   * that are recognized by the specified grammar; it does not recognize other custom words from the
   * model's words resource. See [Using a grammar for speech
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
   * <p>**Note:** Applies to US English, Japanese, and Korean transcription only.
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
   * <p>If `true`, specifies the duration of the pause interval at which the service splits a
   * transcript into multiple final results. If the service detects pauses or extended silence
   * before it reaches the end of the audio stream, its response can include multiple final results.
   * Silence indicates a point at which the speaker pauses between spoken words or phrases.
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
   * where the service splits a transcript. By default, the service splits transcripts based solely
   * on the pause interval.
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
   * <p>The values increase on a monotonic curve. See [Speech detector
   * sensitivity](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-detection#detection-parameters-sensitivity).
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
   * <p>The values increase on a monotonic curve. See [Background audio
   * suppression](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-detection#detection-parameters-suppression).
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
   * <p>**Note:** The parameter is beta functionality. It is not available for previous-generation
   * `Broadband` and `Narrowband` models. It is available only for some next-generation models.
   *
   * <p>* For a list of next-generation models that support low latency, see [Supported language
   * models](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-models-ng#models-ng-supported)
   * for next-generation models. * For more information about the `low_latency` parameter, see [Low
   * latency](https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-interim#low-latency).
   *
   * @return the lowLatency
   */
  public Boolean lowLatency() {
    return lowLatency;
  }
}

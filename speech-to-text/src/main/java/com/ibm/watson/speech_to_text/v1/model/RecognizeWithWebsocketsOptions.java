package com.ibm.watson.speech_to_text.v1.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class RecognizeWithWebsocketsOptions extends RecognizeOptions{

  private Boolean interimResults;
  private Boolean processingMetrics;
  private Float processingMetricsInterval;

  /** Builder. */
  public static class Builder extends RecognizeOptions.Builder{
    private Boolean interimResults;
    private Boolean processingMetrics;
    private Float processingMetricsInterval;

    private Builder(RecognizeWithWebsocketsOptions recognizeOptions) {
      this.interimResults = recognizeOptions.interimResults;
      this.processingMetrics = recognizeOptions.processingMetrics;
      this.processingMetricsInterval = recognizeOptions.processingMetricsInterval;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param audio the audio
     */
    public Builder(InputStream audio) {
      super(audio);
    }

    /**
     * Builds a RecognizeOptions.
     *
     * @return the recognizeOptions
     */
    public RecognizeWithWebsocketsOptions build() {
      return new RecognizeWithWebsocketsOptions(this);
    }

    /**
     * Adds an keyword to keywords.
     *
     * @param keyword the new keyword
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder addKeyword(String keyword) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(keyword, "keyword cannot be null");
      super.addKeyword(keyword);
      return this;
    }

    /**
     * Set the audio.
     *
     * @param audio the audio
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder audio(InputStream audio) {
      super.audio(audio);
      return this;
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder contentType(String contentType) {
      super.contentType(contentType);
      return this;
    }

    /**
     * Set the model.
     *
     * @param model the model
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder model(String model) {
      super.model(model);
      return this;
    }

    /**
     * Set the languageCustomizationId.
     *
     * @param languageCustomizationId the languageCustomizationId
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder languageCustomizationId(String languageCustomizationId) {
      super.languageCustomizationId(languageCustomizationId);
      return this;
    }

    /**
     * Set the acousticCustomizationId.
     *
     * @param acousticCustomizationId the acousticCustomizationId
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder acousticCustomizationId(String acousticCustomizationId) {
      super.acousticCustomizationId(acousticCustomizationId);
      return this;
    }

    /**
     * Set the baseModelVersion.
     *
     * @param baseModelVersion the baseModelVersion
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder baseModelVersion(String baseModelVersion) {
      super.baseModelVersion(baseModelVersion);
      return this;
    }

    /**
     * Set the customizationWeight.
     *
     * @param customizationWeight the customizationWeight
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder customizationWeight(Double customizationWeight) {
      super.customizationWeight(customizationWeight);
      return this;
    }

    /**
     * Set the inactivityTimeout.
     *
     * @param inactivityTimeout the inactivityTimeout
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder inactivityTimeout(long inactivityTimeout) {
      super.inactivityTimeout(inactivityTimeout);
      return this;
    }

    /**
     * Set the keywords. Existing keywords will be replaced.
     *
     * @param keywords the keywords
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder keywords(List<String> keywords) {
      super.keywords(keywords);
      return this;
    }

    /**
     * Set the keywordsThreshold.
     *
     * @param keywordsThreshold the keywordsThreshold
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder keywordsThreshold(Float keywordsThreshold) {
      super.keywordsThreshold(keywordsThreshold);
      return this;
    }

    /**
     * Set the maxAlternatives.
     *
     * @param maxAlternatives the maxAlternatives
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder maxAlternatives(long maxAlternatives) {
      super.maxAlternatives(maxAlternatives);
      return this;
    }

    /**
     * Set the wordAlternativesThreshold.
     *
     * @param wordAlternativesThreshold the wordAlternativesThreshold
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder wordAlternativesThreshold(Float wordAlternativesThreshold) {
      super.wordAlternativesThreshold(wordAlternativesThreshold);
      return this;
    }

    /**
     * Set the wordConfidence.
     *
     * @param wordConfidence the wordConfidence
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder wordConfidence(Boolean wordConfidence) {
      super.wordConfidence(wordConfidence);
      return this;
    }

    /**
     * Set the timestamps.
     *
     * @param timestamps the timestamps
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder timestamps(Boolean timestamps) {
      super.timestamps(timestamps);
      return this;
    }

    /**
     * Set the profanityFilter.
     *
     * @param profanityFilter the profanityFilter
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder profanityFilter(Boolean profanityFilter) {
      super.profanityFilter(profanityFilter);
      return this;
    }

    /**
     * Set the smartFormatting.
     *
     * @param smartFormatting the smartFormatting
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder smartFormatting(Boolean smartFormatting) {
      super.smartFormatting(smartFormatting);
      return this;
    }

    /**
     * Set the speakerLabels.
     *
     * @param speakerLabels the speakerLabels
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder speakerLabels(Boolean speakerLabels) {
      super.speakerLabels(speakerLabels);
      return this;
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder customizationId(String customizationId) {
      super.customizationId(customizationId);
      return this;
    }

    /**
     * Set the grammarName.
     *
     * @param grammarName the grammarName
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder grammarName(String grammarName) {
      super.grammarName(grammarName);
      return this;
    }

    /**
     * Set the redaction.
     *
     * @param redaction the redaction
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder redaction(Boolean redaction) {
      super.redaction(redaction);
      return this;
    }

    /**
     * Set the audioMetrics.
     *
     * @param audioMetrics the audioMetrics
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder audioMetrics(Boolean audioMetrics) {
      super.audioMetrics(audioMetrics);
      return this;
    }

    /**
     * Set the endOfPhraseSilenceTime.
     *
     * @param endOfPhraseSilenceTime the endOfPhraseSilenceTime
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder endOfPhraseSilenceTime(Double endOfPhraseSilenceTime) {
      super.endOfPhraseSilenceTime(endOfPhraseSilenceTime);
      return this;
    }

    /**
     * Set the splitTranscriptAtPhraseEnd.
     *
     * @param splitTranscriptAtPhraseEnd the splitTranscriptAtPhraseEnd
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder splitTranscriptAtPhraseEnd(Boolean splitTranscriptAtPhraseEnd) {
      super.splitTranscriptAtPhraseEnd(splitTranscriptAtPhraseEnd);
      return this;
    }

    /**
     * Set the speechDetectorSensitivity.
     *
     * @param speechDetectorSensitivity the speechDetectorSensitivity
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder speechDetectorSensitivity(Float speechDetectorSensitivity) {
      super.speechDetectorSensitivity(speechDetectorSensitivity);
      return this;
    }

    /**
     * Set the backgroundAudioSuppression.
     *
     * @param backgroundAudioSuppression the backgroundAudioSuppression
     * @return the RecognizeWithWebsocketsOptions builder
     */
    public Builder backgroundAudioSuppression(Float backgroundAudioSuppression) {
      super.backgroundAudioSuppression(backgroundAudioSuppression);
      return this;
    }

    /**
     * Set the audio.
     *
     * @param audio the audio
     * @return the RecognizeWithWebsocketsOptions builder
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder audio(File audio) throws FileNotFoundException {
      super.audio(new FileInputStream(audio));
      return this;
    }
    /**
     * Gets the interimResults.
     *
     * <p>If `true`, the service returns interim results as a stream of `SpeechRecognitionResults`
     * objects. By default, the service returns a single `SpeechRecognitionResults` object with
     * final results only.
     *
     * <p>NOTE: This parameter only works for the `recognizeUsingWebSocket` method.
     *
     * @return the interimResults
     */
    public Boolean interimResults() {
      return interimResults;
    }

    /**
     * Gets the processingMetrics.
     *
     * <p>If `true`, requests processing metrics about the service's transcription of the input
     * audio. The service returns processing metrics at the interval specified by the
     * `processing_metrics_interval` parameter. It also returns processing metrics for transcription
     * events, for example, for final and interim results. By default, the service returns no
     * processing metrics.
     *
     * <p>NOTE: This parameter only works for the `recognizeUsingWebSocket` method.
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
     * <p>The service does not impose a maximum value. If you want to receive processing metrics
     * only for transcription events instead of at periodic intervals, set the value to a large
     * number. If the value is larger than the duration of the audio, the service returns processing
     * metrics only for transcription events.
     *
     * <p>NOTE: This parameter only works for the `recognizeUsingWebSocket` method.
     *
     * @return the processingMetricsInterval
     */
    public Float processingMetricsInterval() {
      return processingMetricsInterval;
    }

    /**
     * Set the interimResults.
     *
     * <p>NOTE: This parameter only works for the `recognizeUsingWebSocket` method.
     *
     * @param interimResults the interimResults
     * @return the interimResults
     */
    public Builder interimResults(Boolean interimResults) {
      this.interimResults = interimResults;
      return this;
    }

    /**
     * Set the processingMetrics.
     *
     * <p>NOTE: This parameter only works for the `recognizeUsingWebSocket` method.
     *
     * @param processingMetrics the processingMetrics
     * @return the processingMetrics
     */
    public Builder processingMetrics(Boolean processingMetrics) {
      this.processingMetrics = processingMetrics;
      return this;
    }

    /**
     * Set the processingMetricsInterval.
     *
     * <p>NOTE: This parameter only works for the `recognizeUsingWebSocket` method.
     *
     * @param processingMetricsInterval the processingMetricsInterval
     * @return the processingMetricsInterval
     */
    public Builder processingMetricsInterval(Float processingMetricsInterval) {
      this.processingMetricsInterval = processingMetricsInterval;
      return this;
    }
  }

  protected RecognizeWithWebsocketsOptions(Builder builder) {
    super(builder);
    interimResults = builder.interimResults;
    processingMetrics = builder.processingMetrics;
    processingMetricsInterval = builder.processingMetricsInterval;
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
   * Gets the processingMetrics.
   *
   * If `true`, requests processing metrics about the service's transcription of the input audio. The service returns
   * processing metrics at the interval specified by the `processing_metrics_interval` parameter. It also returns
   * processing metrics for transcription events, for example, for final and interim results. By default, the service
   * returns no processing metrics.
   *
   * NOTE: This parameter only works for the `recognizeUsingWebSocket` method.
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
   * The parameter accepts a minimum value of 0.1 seconds. The level of precision is not restricted, so you can
   * specify values such as 0.25 and 0.125.
   *
   * The service does not impose a maximum value. If you want to receive processing metrics only for transcription
   * events instead of at periodic intervals, set the value to a large number. If the value is larger than the
   * duration of the audio, the service returns processing metrics only for transcription events.
   *
   * NOTE: This parameter only works for the `recognizeUsingWebSocket` method.
   *
   * @return the processingMetricsInterval
   */
  public Float processingMetricsInterval() {
    return processingMetricsInterval;
  }
}

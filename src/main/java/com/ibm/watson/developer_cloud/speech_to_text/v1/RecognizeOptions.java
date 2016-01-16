/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.speech_to_text.v1;

import org.apache.commons.lang3.Validate;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSession;
import com.squareup.okhttp.MediaType;


/**
 * Parameters to be use during a recognize call in the {@link SpeechToText} service.
 */
public class RecognizeOptions {


  @SerializedName("content-type")
  private String contentType;
  private Boolean continuous;
  private Integer inactivityTimeout;

  @SerializedName("interim_results")
  private Boolean interimResults;
  private String[] keywords;

  @SerializedName("keywords_threshold")
  private Double keywordsThreshold;
  private Integer maxAlternatives;
  private String model;
  private String sessionId;
  private Boolean timestamps;

  @SerializedName("word_alternatives_threshold")
  private Double wordAlternativesThreshold;

  @SerializedName("word_confidence")
  private Boolean wordConfidence;

  /**
   * If true, multiple final results that represent multiple consecutive phrases separated by pauses
   * are returned. Otherwise, the recognition ends after first "end of speech" is detected.
   * 
   * @param continuous the continuous
   * @return the recognize options
   */
  public RecognizeOptions continuous(Boolean continuous) {
    this.continuous = continuous;
    return this;
  }

  /**
   * Gets the content type.
   * 
   * @return the contentType
   */
  public String getContentType() {
    return contentType;
  }

  /**
   * Gets the continuous.
   * 
   * @return the continuous
   */
  public Boolean getContinuous() {
    return continuous;
  }

  /**
   * Gets the inactivity timeout.
   * 
   * @return the inactivity timeout
   */
  public Integer getInactivityTimeout() {
    return inactivityTimeout;
  }

  /**
   * Gets the interim results.
   * 
   * @return the interimResults
   */
  public Boolean getInterimResults() {
    return interimResults;
  }

  /**
   * Gets the keywords.
   * 
   * @return the keywords
   */
  public String[] getKeywords() {
    return keywords;
  }

  /**
   * Gets the keywords threshold.
   * 
   * @return the keywordsThreshold
   */
  public Double getKeywordsThreshold() {
    return keywordsThreshold;
  }

  /**
   * Gets the max alternatives.
   * 
   * @return the maxAlternatives
   */
  public Integer getMaxAlternatives() {
    return maxAlternatives;
  }

  /**
   * Gets the model.
   * 
   * @return the model
   */
  public String getModel() {
    return model;
  }

  /**
   * Gets the session id.
   * 
   * @return the sessionId
   */
  public String getSessionId() {
    return sessionId;
  }

  /**
   * Gets the timestamps.
   * 
   * @return the timestamps
   */
  public Boolean getTimestamps() {
    return timestamps;
  }

  /**
   * Gets the word alternatives threshold.
   * 
   * @return the wordAlternativesThreshold
   */
  public Double getWordAlternativesThreshold() {
    return wordAlternativesThreshold;
  }

  /**
   * Gets the word confidence.
   * 
   * @return the wordConfidence
   */
  public Boolean getWordConfidence() {
    return wordConfidence;
  }

  /**
   * Inactivity timeout.
   * 
   * @param inactivityTimeout the inactivity timeout
   * @return the recognize options
   */
  public RecognizeOptions inactivityTimeout(Integer inactivityTimeout) {
    this.inactivityTimeout = inactivityTimeout;
    return this;
  }

  /**
   * If true, the service sends interim results for the transcription. Otherwise, the recognition
   * ends after first "end of speech" is detected. The default is false.
   * 
   * @param interimResults the interim results
   * @return the recognize options
   */
  public RecognizeOptions interimResults(Boolean interimResults) {
    this.interimResults = interimResults;
    return this;
  }

  /**
   * Specifies an array of keyword strings to be matched in the input audio. By default, the service
   * does no keyword spotting.
   * 
   * 
   * @param keywords the keywords
   * @return the recognize options
   */
  public RecognizeOptions keywords(String[] keywords) {
    this.keywords = keywords;
    return this;
  }



  /**
   * Specifies a minimum level of confidence that the service must have to report a matching keyword
   * in the input audio. Specify a probability value between 0 and 1 inclusive. A match must have at
   * least the specified confidence to be returned. Omit the parameter or specify a value of null
   * (the default) to spot no keywords. If you specify a valid threshold, you must also specify at
   * least one keyword.
   * 
   * 
   * @param keywordsThreshold the keywords threshold
   * @return the recognize options
   */
  public RecognizeOptions keywordsThreshold(Double keywordsThreshold) {
    this.keywordsThreshold = keywordsThreshold;
    return this;
  }

  /**
   * Maximum number of alternative transcripts returned.
   * 
   * @param maxAlternatives the max alternatives
   * @return the recognize options
   */
  public RecognizeOptions maxAlternatives(Integer maxAlternatives) {
    this.maxAlternatives = maxAlternatives;
    return this;
  }

  /**
   * Sets the model name used for the recognition.
   * 
   * @param model the model
   * @return the recognize options
   */
  public RecognizeOptions model(String model) {
    this.model = model;
    return this;
  }

  /**
   * Sets the session id.
   * 
   * @param session the {@link SpeechSession}
   * @return the recognize options
   */
  public RecognizeOptions session(SpeechSession session) {
    this.sessionId = session.getSessionId();
    return this;
  }

  /**
   * Sets session id.
   * 
   * @param sessionId the session id
   * @return the recognize options
   */
  public RecognizeOptions sessionId(String sessionId) {
    this.sessionId = sessionId;
    return this;
  }

  /**
   * If true, time alignment for each word is returned.
   * 
   * @param timestamps the timestamps
   * @return the recognize options
   */
  public RecognizeOptions timestamps(Boolean timestamps) {
    this.timestamps = timestamps;
    return this;
  }

  /**
   * Specifies a minimum level of confidence that the service must have to report a hypothesis for a
   * word from the input audio. Specify a probability value between 0 and 1 inclusive. A hypothesis
   * must have at least the specified confidence to be returned as a word alternative. Omit the
   * parameter or specify a value of null (the default) to return no word alternatives.
   * 
   * 
   * 
   * @param wordAlternativesThreshold the wordAalternatives threshold
   * @return the recognize options
   */
  public RecognizeOptions wordAlternativesThreshold(Double wordAlternativesThreshold) {
    this.wordAlternativesThreshold = wordAlternativesThreshold;
    return this;
  }

  /**
   * The format of the audio data specified as one of the following values: <br>
   * <ul>
   * <li><code>audio/flac</code> for Free Lossless Audio Codec (FLAC)</li>
   * <li><code>audio/l16</code> for Linear 16-bit Pulse-Code Modulation (PCM)</li>
   * <li><code>audio/wav</code> for Waveform Audio File Format (WAV)</li>
   * <li><code>audio/ogg;codecs=opus</code> for Ogg format files that use the opus codec</li>
   * </ul>
   * 
   * @param contentType the content type
   * @return the recognize options
   */
  public RecognizeOptions contentType(String contentType) {
    Validate.isTrue(MediaType.parse(contentType) != null,
        "contentType is not a valid mime audio format. Valid formats start with 'audio/'");
    this.contentType = contentType;
    return this;
  }


  /**
   * If true, confidence measure per word is returned if available.
   * 
   * @param wordConfidence the word confidence
   * @return the recognize options
   */
  public RecognizeOptions wordConfidence(Boolean wordConfidence) {
    this.wordConfidence = wordConfidence;
    return this;
  }

}

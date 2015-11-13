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

import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSession;


/**
 * Recognize Options when using the
 * {@link SpeechToText#recognize(java.io.File, String, RecognizeOptions)} method.
 */
public class RecognizeOptions {

  private Boolean continuous;
  private Integer inactivityTimeout;
  private Integer maxAlternatives;
  private String model;
  private String sessionId;

  private Boolean timestamps;
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
   * Maximum number of alternative transcripts returned
   * 
   * @param maxAlternatives the max alternatives
   * @return the recognize options
   */
  public RecognizeOptions maxAlternatives(Integer maxAlternatives) {
    this.maxAlternatives = maxAlternatives;
    return this;
  }

  /**
   * Sets the model name used for the recognition
   * 
   * @param model the model
   * @return the recognize options
   */
  public RecognizeOptions model(String model) {
    this.model = model;
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
   * If true, time alignment for each word is returned
   * 
   * @param timestamps the timestamps
   * @return the recognize options
   */
  public RecognizeOptions timestamps(Boolean timestamps) {
    this.timestamps = timestamps;
    return this;
  }

  /**
   * If true, confidence measure per word is returned if available
   * 
   * @param wordConfidence the word confidence
   * @return the recognize options
   */
  public RecognizeOptions wordConfidence(Boolean wordConfidence) {
    this.wordConfidence = wordConfidence;
    return this;
  }

}

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

package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * SpeechAlternative contains the transcript of the utterance along with confidence, timestamp,
 * etc...
 */
public class SpeechAlternative extends GenericModel {

  /** The transcript. */
  private String transcript;

  /** The confidence. */
  private Double confidence;

  /** The timestamps. */
  private List<SpeechTimestamp> timestamps;

  /** The word confidences. */
  @SerializedName("word_confidence")
  private List<SpeechWordConfidence> wordConfidences;

  /**
   * Gets the transcript.
   * 
   * @return The transcript
   */
  public String getTranscript() {
    return transcript;
  }

  /**
   * Sets the transcript.
   * 
   * @param transcript The transcript
   */
  public void setTranscript(final String transcript) {
    this.transcript = transcript;
  }

  /**
   * Gets the confidence.
   * 
   * @return The confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Sets the confidence.
   * 
   * @param confidence The confidence
   */
  public void setConfidence(final Double confidence) {
    this.confidence = confidence;
  }

  /**
   * Gets the timestamps.
   * 
   * @return The timestamps
   */
  public List<SpeechTimestamp> getTimestamps() {
    return timestamps;
  }

  /**
   * Sets the timestamps.
   * 
   * @param timestamps The timestamps
   */
  public void setTimestamps(final List<SpeechTimestamp> timestamps) {
    this.timestamps = timestamps;
  }

  /**
   * With timestamps.
   * 
   * @param timestamps the timestamps
   * @return the speech
   */
  public SpeechAlternative withTimestamps(final List<SpeechTimestamp> timestamps) {
    this.timestamps = timestamps;
    return this;
  }


  /**
   * Gets the word confidences.
   * 
   * @return The wordConfidences
   */
  public List<SpeechWordConfidence> getWordConfidences() {
    return wordConfidences;
  }

  /**
   * Sets the word confidences.
   * 
   * @param wordConfidences The wordConfidences
   */
  public void setWordConfidences(final List<SpeechWordConfidence> wordConfidences) {
    this.wordConfidences = wordConfidences;
  }

  /**
   * With word confidences.
   * 
   * @param wordConfidences the wordConfidences
   * @return the speech
   */
  public SpeechAlternative withWordConfidences(final List<SpeechWordConfidence> wordConfidences) {
    this.wordConfidences = wordConfidences;
    return this;
  }
}

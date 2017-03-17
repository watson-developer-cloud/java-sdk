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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Contains the transcript of the utterance along with confidence and timestamp.
 */
public class SpeechAlternative extends GenericModel {
  private Double confidence;
  private List<SpeechTimestamp> timestamps;
  private String transcript;

  @SerializedName("word_confidence")
  private List<SpeechWordConfidence> wordConfidences;

  /**
   * Gets the confidence.
   *
   * @return The confidence
   */
  public Double getConfidence() {
    return confidence;
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
   * Gets the transcript.
   *
   * @return The transcript
   */
  public String getTranscript() {
    return transcript;
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
   * Sets the confidence.
   *
   * @param confidence The confidence
   */
  public void setConfidence(final Double confidence) {
    this.confidence = confidence;
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
   * Sets the transcript.
   *
   * @param transcript The transcript
   */
  public void setTranscript(final String transcript) {
    this.transcript = transcript;
  }

  /**
   * Sets the word confidences.
   *
   * @param wordConfidences The wordConfidences
   */
  public void setWordConfidences(final List<SpeechWordConfidence> wordConfidences) {
    this.wordConfidences = wordConfidences;
  }
}

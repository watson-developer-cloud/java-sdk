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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class SpeechAlternative.
 */
public class SpeechAlternative extends GenericModel {

  /** The transcript. */
  private String transcript;

  /** The confidence. */
  private float confidence;

  /** The word confidences. */
  @SerializedName("word_confidence")
  private List<SpeechWordConfidence> wordConfidences;

  /** The timestampts. */
  private List<SpeechTimestamp> timestamps;

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
  public float getConfidence() {
    return confidence;
  }

  /**
   * Sets the confidence.
   *
   * @param confidence The confidence
   */
  public void setConfidence(final float confidence) {
    this.confidence = confidence;
  }

  /**
   * Gets the word confidences.
   *
   * @return The word confidences
   */
  public List<SpeechWordConfidence> getWordConfidences() {
    return wordConfidences;
  }

  /**
   * Sets the word confidences.
   *
   * @param wordConfidences The word confidences
   */
  public void setWordConfidences(final List<SpeechWordConfidence> wordConfidences) {
    this.wordConfidences = wordConfidences;
  }

  /**
   * With word confidences.
   *
   * @param wordConfidences the word confidences
   * @return the speech
   */
  public Transcript withWordConfidences(final List<SpeechWordConfidence> wordConfidences) {
    this.wordConfidences = wordConfidences;
    return this;
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
  public Transcript withTimestamps(final List<SpeechTimestamp> timestamps) {
    this.timestamps = timestamps;
    return this;
  }
}

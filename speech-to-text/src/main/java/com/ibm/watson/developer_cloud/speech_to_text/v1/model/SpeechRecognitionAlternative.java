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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * SpeechRecognitionAlternative.
 */
public class SpeechRecognitionAlternative extends GenericModel {

  private String transcript;
  private Double confidence;
  private List<SpeechTimestamp> timestamps;
  @SerializedName("word_confidence")
  private List<SpeechWordConfidence> wordConfidence;

  /**
   * Gets the transcript.
   *
   * A transcription of the audio.
   *
   * @return the transcript
   */
  public String getTranscript() {
    return transcript;
  }

  /**
   * Gets the confidence.
   *
   * A score that indicates the service's confidence in the transcript in the range of 0 to 1. Available only for the
   * best alternative and only in results marked as final.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Gets the timestamps.
   *
   * Time alignments for each word from the transcript as a list of lists. Each inner list consists of three elements:
   * the word followed by its start and end time in seconds. Example: `[["hello",0.0,1.2],["world",1.2,2.5]]`. Available
   * only for the best alternative.
   *
   * @return the timestamps
   */
  public List<SpeechTimestamp> getTimestamps() {
    return timestamps;
  }

  /**
   * Gets the wordConfidence.
   *
   * A confidence score for each word of the transcript as a list of lists. Each inner list consists of two elements:
   * the word and its confidence score in the range of 0 to 1. Example: `[["hello",0.95],["world",0.866]]`. Available
   * only for the best alternative and only in results marked as final.
   *
   * @return the wordConfidence
   */
  public List<SpeechWordConfidence> getWordConfidence() {
    return wordConfidence;
  }

  /**
   * Sets the transcript.
   *
   * @param transcript the new transcript
   */
  public void setTranscript(final String transcript) {
    this.transcript = transcript;
  }

  /**
   * Sets the confidence.
   *
   * @param confidence the new confidence
   */
  public void setConfidence(final Double confidence) {
    this.confidence = confidence;
  }

  /**
   * Sets the timestamps.
   *
   * @param timestamps the new timestamps
   */
  public void setTimestamps(final List<SpeechTimestamp> timestamps) {
    this.timestamps = timestamps;
  }

  /**
   * Sets the wordConfidence.
   *
   * @param wordConfidence the new wordConfidence
   */
  public void setWordConfidence(final List<SpeechWordConfidence> wordConfidence) {
    this.wordConfidence = wordConfidence;
  }
}

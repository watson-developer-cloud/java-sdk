/*
 * (C) Copyright IBM Corp. 2019.
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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An alternative transcript from speech recognition results.
 */
public class SpeechRecognitionAlternative extends GenericModel {

  private String transcript;
  private Double confidence;
  private List<String> timestamps;
  @SerializedName("word_confidence")
  private List<String> wordConfidence;

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
   * A score that indicates the service's confidence in the transcript in the range of 0.0 to 1.0. A confidence score is
   * returned only for the best alternative and only with results marked as final.
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
   * the word followed by its start and end time in seconds, for example: `[["hello",0.0,1.2],["world",1.2,2.5]]`.
   * Timestamps are returned only for the best alternative.
   *
   * @return the timestamps
   */
  public List<String> getTimestamps() {
    return timestamps;
  }

  /**
   * Gets the wordConfidence.
   *
   * A confidence score for each word of the transcript as a list of lists. Each inner list consists of two elements:
   * the word and its confidence score in the range of 0.0 to 1.0, for example: `[["hello",0.95],["world",0.866]]`.
   * Confidence scores are returned only for the best alternative and only with results marked as final.
   *
   * @return the wordConfidence
   */
  public List<String> getWordConfidence() {
    return wordConfidence;
  }
}

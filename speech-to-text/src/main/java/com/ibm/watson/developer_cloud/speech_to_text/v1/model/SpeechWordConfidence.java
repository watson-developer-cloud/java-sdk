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

import com.google.gson.annotations.JsonAdapter;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.util.SpeechWordConfidenceTypeAdapter;

/**
 * Transcription word confidence.
 */
@JsonAdapter(SpeechWordConfidenceTypeAdapter.class)
public class SpeechWordConfidence extends GenericModel {
  private Double confidence;
  private String word;

  /**
   * Gets the confidence.
   *
   * @return The confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Gets the word.
   *
   * @return The word
   */
  public String getWord() {
    return word;
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
   * Sets the word.
   *
   * @param word The word
   */
  public void setWord(final String word) {
    this.word = word;
  }
}

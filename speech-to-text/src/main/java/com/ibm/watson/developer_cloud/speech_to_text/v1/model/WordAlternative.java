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

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;

/**
 * Word alternative used by {@link SpeechToText}.
 */
public class WordAlternative extends GenericModel {

  private Double confidence;
  private String word;

  /**
   * Instantiates a new word alternative.
   *
   * @param confidence the confidence
   * @param word the word
   */
  public WordAlternative(Double confidence, String word) {
    this.confidence = confidence;
    this.word = word;
  }

  /**
   * Gets the confidence.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Sets the confidence.
   *
   * @param confidence the new confidence
   */
  public void setConfidence(Double confidence) {
    this.confidence = confidence;
  }

  /**
   * Gets the word.
   *
   * @return the word
   */
  public String getWord() {
    return word;
  }

  /**
   * Sets the word.
   *
   * @param word the new word
   */
  public void setWord(String word) {
    this.word = word;
  }
}

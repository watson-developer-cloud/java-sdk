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
package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * SentenceAnalysis.
 */
public class SentenceAnalysis extends GenericModel {

  @SerializedName("sentence_id")
  private Long sentenceId;
  private String text;
  private List<ToneScore> tones;

  /**
   * Gets the sentenceId.
   *
   * The unique identifier of a sentence of the input content. The first sentence has ID 0, and the ID of each subsequent sentence is incremented by one.
   *
   * @return the sentenceId
   */
  public Long getSentenceId() {
    return sentenceId;
  }

  /**
   * Gets the text.
   *
   * The text of the input sentence.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the tones.
   *
   * An array of `ToneScore` objects that provides the results of the analysis for each qualifying tone of the sentence. The array includes results for any tone whose score is at least 0.5. The array is empty if no tone has a score that meets this threshold.
   *
   * @return the tones
   */
  public List<ToneScore> getTones() {
    return tones;
  }

  /**
   * Sets the sentenceId.
   *
   * @param sentenceId the new sentenceId
   */
  public void setSentenceId(final long sentenceId) {
    this.sentenceId = sentenceId;
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(final String text) {
    this.text = text;
  }

  /**
   * Sets the tones.
   *
   * @param tones the new tones
   */
  public void setTones(final List<ToneScore> tones) {
    this.tones = tones;
  }
}

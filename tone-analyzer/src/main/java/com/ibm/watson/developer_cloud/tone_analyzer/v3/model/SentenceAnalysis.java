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

  /**
   * The unique identifier of a sentence of the input content. The first sentence has ID 0, and the ID of each
   * subsequent sentence is incremented by one.
   */
  @SerializedName("sentence_id")
  private Long sentenceId;
  /** The text of the input sentence. */
  private String text;
  /** The offset of the first character of the sentence in the overall input content. */
  @SerializedName("input_from")
  private Long inputFrom;
  /** The offset of the last character of the sentence in the overall input content. */
  @SerializedName("input_to")
  private Long inputTo;
  /**
   * An array of `ToneCategory` objects that provides the results for the tone analysis of the sentence. The service
   * returns results only for the tones specified with the `tones` parameter of the request.
   */
  @SerializedName("tone_categories")
  private List<ToneCategory> toneCategories;

  /**
   * Gets the sentenceId.
   *
   * @return the sentenceId
   */
  public Long getSentenceId() {
    return sentenceId;
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the inputFrom.
   *
   * @return the inputFrom
   */
  public Long getInputFrom() {
    return inputFrom;
  }

  /**
   * Gets the inputTo.
   *
   * @return the inputTo
   */
  public Long getInputTo() {
    return inputTo;
  }

  /**
   * Gets the toneCategories.
   *
   * @return the toneCategories
   */
  public List<ToneCategory> getToneCategories() {
    return toneCategories;
  }

  /**
   * Sets the sentenceId.
   *
   * @param sentenceId the new sentenceId
   */
  public void setSentenceId(final Long sentenceId) {
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
   * Sets the inputFrom.
   *
   * @param inputFrom the new inputFrom
   */
  public void setInputFrom(final Long inputFrom) {
    this.inputFrom = inputFrom;
  }

  /**
   * Sets the inputTo.
   *
   * @param inputTo the new inputTo
   */
  public void setInputTo(final Long inputTo) {
    this.inputTo = inputTo;
  }

  /**
   * Sets the toneCategories.
   *
   * @param toneCategories the new toneCategories
   */
  public void setToneCategories(final List<ToneCategory> toneCategories) {
    this.toneCategories = toneCategories;
  }
}

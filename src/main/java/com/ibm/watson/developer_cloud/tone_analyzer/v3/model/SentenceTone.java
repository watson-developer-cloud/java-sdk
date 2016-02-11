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
package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import com.google.gson.annotations.SerializedName;

/**
 * This element contains the result of analyzing an individual sentence. It contains a list of
 * ToneCategory objects which is the actual result, and also some metadata about the sentence: The
 * original text (if it needs to be tracked back), and the position of the sentence in the original
 * text (as index of first and last character).
 * 
 */
public class SentenceTone extends ElementTone {

  @SerializedName("sentence_id")
  private Integer id;

  @SerializedName("input_from")
  private Integer inputFrom;

  @SerializedName("input_to")
  private Integer inputTo;

  @SerializedName("text")
  private String text;

  /**
   * Gets the id.
   *
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Gets the input from.
   *
   * @return the input from
   */
  public Integer getInputFrom() {
    return inputFrom;
  }

  /**
   * Sets the input from.
   *
   * @param inputFrom the new input from
   */
  public void setInputFrom(Integer inputFrom) {
    this.inputFrom = inputFrom;
  }

  /**
   * Gets the input to.
   *
   * @return the input to
   */
  public Integer getInputTo() {
    return inputTo;
  }

  /**
   * Sets the input to.
   *
   * @param inputTo the new input to
   */
  public void setInputTo(Integer inputTo) {
    this.inputTo = inputTo;
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
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(String text) {
    this.text = text;
  }

}

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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class SpeechWordConfidence.
 */
public class SpeechWordConfidence extends GenericModel {

  /** The word. */
  private String word;

  /** The start time. */
  private float start;

  /** The end time. */
  private float end;

  /**
   * Gets the word.
   *
   * @return The word
   */
  public String getWord() {
    return word;
  }

  /**
   * Sets the word.
   *
   * @param word The word
   */
  public void setWord(final String word) {
    this.word = word;
  }

  /**
   * Gets the start.
   *
   * @return The start
   */
  public float getStart() {
    return start;
  }

  /**
   * Sets the start.
   *
   * @param start The start
   */
  public void setStart(final float start) {
    this.start = start;
  }

  /**
   * Gets the end.
   *
   * @return The end
   */
  public float getEnd() {
    return end;
  }

  /**
   * Sets the end.
   *
   * @param end The end
   */
  public void setEnd(final float end) {
    this.end = end;
  }

}

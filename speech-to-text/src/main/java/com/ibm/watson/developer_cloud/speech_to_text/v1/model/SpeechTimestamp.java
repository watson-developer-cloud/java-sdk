/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
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
import com.ibm.watson.developer_cloud.speech_to_text.v1.util.SpeechTimestampTypeAdapter;

/**
 * Transcription timestamp.
 */
@JsonAdapter(SpeechTimestampTypeAdapter.class)
public class SpeechTimestamp extends GenericModel {
  private Double endTime;
  private Double startTime;
  private String word;

  /**
   * Gets the end time.
   *
   * @return The end time
   */
  public Double getEndTime() {
    return endTime;
  }

  /**
   * Gets the start time.
   *
   * @return The start time
   */
  public Double getStartTime() {
    return startTime;
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
   * Sets the end time.
   *
   * @param endTime The end time
   */
  public void setEndTime(final Double endTime) {
    this.endTime = endTime;
  }

  /**
   * Sets the start time.
   *
   * @param startTime The start time
   */
  public void setStartTime(final Double startTime) {
    this.startTime = startTime;
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

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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * A keyword spotting result.
 *
 * @see <a href="http://www.ibm.com/watson/developercloud/doc/speech-to-text/output.shtml"> Speech to Text: Transcribing
 *      audio</a>
 */
public class KeywordsResult extends GenericModel {
  @SerializedName("normalized_text")
  private String normalizedText;

  @SerializedName("start_time")
  private Double startTime;

  @SerializedName("end_time")
  private Double endTime;

  private Double confidence;

  /**
   * Gets the specified keyword normalized to the spoken phrase that matched in the input audio.
   *
   * @return the keyword
   */
  public String getNormalizedText() {
    return normalizedText;
  }

  /**
   * Sets the normalized keyword.
   *
   * @param normalizedText the keyword
   */
  public void setNormalizedText(String normalizedText) {
    this.normalizedText = normalizedText;
  }

  /**
   * Gets the start time (in seconds).
   *
   * @return the start time
   */
  public Double getStartTime() {
    return startTime;
  }

  /**
   * Sets the start time (in seconds).
   *
   * @param startTime the start time
   */
  public void setStartTime(Double startTime) {
    this.startTime = startTime;
  }

  /**
   * Gets the end time (in seconds).
   *
   * @return the end time
   */
  public Double getEndTime() {
    return endTime;
  }

  /**
   * Sets the end time (in seconds).
   *
   * @param endTime the end time
   */
  public void setEndTime(Double endTime) {
    this.endTime = endTime;
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
   * @param confidence the confidence
   */
  public void setConfidence(Double confidence) {
    this.confidence = confidence;
  }
}

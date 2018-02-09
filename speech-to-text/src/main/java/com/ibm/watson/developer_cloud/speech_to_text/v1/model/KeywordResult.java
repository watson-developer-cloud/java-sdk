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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * KeywordResult.
 */
public class KeywordResult extends GenericModel {

  @SerializedName("normalized_text")
  private String normalizedText;
  @SerializedName("start_time")
  private Double startTime;
  @SerializedName("end_time")
  private Double endTime;
  private Double confidence;

  /**
   * Gets the normalizedText.
   *
   * A specified keyword normalized to the spoken phrase that matched in the audio input.
   *
   * @return the normalizedText
   */
  public String getNormalizedText() {
    return normalizedText;
  }

  /**
   * Gets the startTime.
   *
   * The start time in seconds of the keyword match.
   *
   * @return the startTime
   */
  public Double getStartTime() {
    return startTime;
  }

  /**
   * Gets the endTime.
   *
   * The end time in seconds of the keyword match.
   *
   * @return the endTime
   */
  public Double getEndTime() {
    return endTime;
  }

  /**
   * Gets the confidence.
   *
   * A confidence score for the keyword match in the range of 0 to 1.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Sets the normalizedText.
   *
   * @param normalizedText the new normalizedText
   */
  public void setNormalizedText(final String normalizedText) {
    this.normalizedText = normalizedText;
  }

  /**
   * Sets the startTime.
   *
   * @param startTime the new startTime
   */
  public void setStartTime(final Double startTime) {
    this.startTime = startTime;
  }

  /**
   * Sets the endTime.
   *
   * @param endTime the new endTime
   */
  public void setEndTime(final Double endTime) {
    this.endTime = endTime;
  }

  /**
   * Sets the confidence.
   *
   * @param confidence the new confidence
   */
  public void setConfidence(final Double confidence) {
    this.confidence = confidence;
  }
}

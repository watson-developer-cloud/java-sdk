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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;

/**
 * Word alternative list used by {@link SpeechToText} during a recognition.
 */
public class SpeechWordAlternatives extends GenericModel {

  @SerializedName("start_time")
  private Double startTime;
  private List<WordAlternative> alternatives;

  @SerializedName("end_time")
  private Double endTime;

  /**
   * Gets the start time.
   *
   * @return the start time
   */
  public Double getStartTime() {
    return startTime;
  }


  /**
   * Sets the start time.
   *
   * @param startTime the new start time
   */
  public void setStartTime(Double startTime) {
    this.startTime = startTime;
  }

  /**
   * Gets the alternatives.
   *
   * @return the alternatives
   */
  public List<WordAlternative> getAlternatives() {
    return alternatives;
  }

  /**
   * Sets the alternatives.
   *
   * @param alternatives the new alternatives
   */
  public void setAlternatives(List<WordAlternative> alternatives) {
    this.alternatives = alternatives;
  }

  /**
   * Gets the end time.
   *
   * @return the end time
   */
  public Double getEndTime() {
    return endTime;
  }

  /**
   * Sets the end time.
   *
   * @param endTime the new end time
   */
  public void setEndTime(Double endTime) {
    this.endTime = endTime;
  }
}

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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * WordAlternativeResults.
 */
public class WordAlternativeResults extends GenericModel {

  @SerializedName("start_time")
  private Double startTime;
  @SerializedName("end_time")
  private Double endTime;
  private List<WordAlternativeResult> alternatives;

  /**
   * Gets the startTime.
   *
   * The start time in seconds of the word from the input audio that corresponds to the word alternatives.
   *
   * @return the startTime
   */
  public Double getStartTime() {
    return startTime;
  }

  /**
   * Gets the endTime.
   *
   * The end time in seconds of the word from the input audio that corresponds to the word alternatives.
   *
   * @return the endTime
   */
  public Double getEndTime() {
    return endTime;
  }

  /**
   * Gets the alternatives.
   *
   * An array of alternative hypotheses for a word from the input audio.
   *
   * @return the alternatives
   */
  public List<WordAlternativeResult> getAlternatives() {
    return alternatives;
  }
}

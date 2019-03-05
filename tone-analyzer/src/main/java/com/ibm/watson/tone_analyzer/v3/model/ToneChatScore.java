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
package com.ibm.watson.tone_analyzer.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ToneChatScore.
 */
public class ToneChatScore extends GenericModel {

  /**
   * The unique, non-localized identifier of the tone for the results. The service returns results only for tones whose
   * scores meet a minimum threshold of 0.5.
   */
  public interface ToneId {
    /** excited. */
    String EXCITED = "excited";
    /** frustrated. */
    String FRUSTRATED = "frustrated";
    /** impolite. */
    String IMPOLITE = "impolite";
    /** polite. */
    String POLITE = "polite";
    /** sad. */
    String SAD = "sad";
    /** satisfied. */
    String SATISFIED = "satisfied";
    /** sympathetic. */
    String SYMPATHETIC = "sympathetic";
  }

  private Double score;
  @SerializedName("tone_id")
  private String toneId;
  @SerializedName("tone_name")
  private String toneName;

  /**
   * Gets the score.
   *
   * The score for the tone in the range of 0.5 to 1. A score greater than 0.75 indicates a high likelihood that the
   * tone is perceived in the utterance.
   *
   * @return the score
   */
  public Double getScore() {
    return score;
  }

  /**
   * Gets the toneId.
   *
   * The unique, non-localized identifier of the tone for the results. The service returns results only for tones whose
   * scores meet a minimum threshold of 0.5.
   *
   * @return the toneId
   */
  public String getToneId() {
    return toneId;
  }

  /**
   * Gets the toneName.
   *
   * The user-visible, localized name of the tone.
   *
   * @return the toneName
   */
  public String getToneName() {
    return toneName;
  }
}

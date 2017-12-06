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
package com.ibm.watson.developer_cloud.personality_insights.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * ConsumptionPreferences.
 */
public class ConsumptionPreferences extends GenericModel {

  @SerializedName("consumption_preference_id")
  private String consumptionPreferenceId;
  private String name;
  private Double score;

  /**
   * Gets the consumptionPreferenceId.
   *
   * The unique identifier of the consumption preference to which the results pertain. IDs have the form
   * `consumption_preferences_{preference}`.
   *
   * @return the consumptionPreferenceId
   */
  public String getConsumptionPreferenceId() {
    return consumptionPreferenceId;
  }

  /**
   * Gets the name.
   *
   * The user-visible name of the consumption preference.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the score.
   *
   * The score for the consumption preference: * `0.0`: Unlikely * `0.5`: Neutral * `1.0`: Likely The scores for some
   * preferences are binary and do not allow a neutral value. The score is an indication of preference based on the
   * results inferred from the input text, not a normalized percentile.
   *
   * @return the score
   */
  public Double getScore() {
    return score;
  }

  /**
   * Sets the consumptionPreferenceId.
   *
   * @param consumptionPreferenceId the new consumptionPreferenceId
   */
  public void setConsumptionPreferenceId(final String consumptionPreferenceId) {
    this.consumptionPreferenceId = consumptionPreferenceId;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the score.
   *
   * @param score the new score
   */
  public void setScore(final Double score) {
    this.score = score;
  }
}

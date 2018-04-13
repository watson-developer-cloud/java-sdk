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
package com.ibm.watson.developer_cloud.personality_insights.v3.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * ConsumptionPreferencesCategory.
 */
public class ConsumptionPreferencesCategory extends GenericModel {

  @SerializedName("consumption_preference_category_id")
  private String consumptionPreferenceCategoryId;
  private String name;
  @SerializedName("consumption_preferences")
  private List<ConsumptionPreferences> consumptionPreferences;

  /**
   * Gets the consumptionPreferenceCategoryId.
   *
   * The unique identifier of the consumption preferences category to which the results pertain. IDs have the form
   * `consumption_preferences_{category}`.
   *
   * @return the consumptionPreferenceCategoryId
   */
  public String getConsumptionPreferenceCategoryId() {
    return consumptionPreferenceCategoryId;
  }

  /**
   * Gets the name.
   *
   * The user-visible name of the consumption preferences category.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the consumptionPreferences.
   *
   * Detailed results inferred from the input text for the individual preferences of the category.
   *
   * @return the consumptionPreferences
   */
  public List<ConsumptionPreferences> getConsumptionPreferences() {
    return consumptionPreferences;
  }
}

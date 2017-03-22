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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Set of preferences inferred from the input text for an individual.
 */
public class ConsumptionPreferences extends GenericModel {

  /**
   * Detailed results inferred from the input text for the individual preferences of the category.
   */
  public class ConsumptionPreference extends GenericModel {

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
      return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
      this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
      return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
      this.name = name;
    }

    /**
     * Gets the score for the consumption preference.
     *
     * @return the score
     */
    public Double getScore() {
      return score;
    }

    /**
     * Sets the score for the consumption preference.
     *
     * @param score the new score
     */
    public void setScore(Double score) {
      this.score = score;
    }

    @SerializedName("consumption_preference_id")
    private String id;
    private String name;
    private Double score;

  }

  @SerializedName("consumption_preferences")
  private List<ConsumptionPreference> consumptionPreferences;

  @SerializedName("consumption_preference_category_id")
  private String categoryId;

  private String name;

  /**
   * Gets the consumption preferences.
   *
   * @return the consumption preferences
   */
  public List<ConsumptionPreference> getConsumptionPreferences() {
    return consumptionPreferences;
  }

  /**
   * Sets the consumption preferences.
   *
   * @param consumptionPreferences the new consumption preferences
   */
  public void setConsumptionPreferences(List<ConsumptionPreference> consumptionPreferences) {
    this.consumptionPreferences = consumptionPreferences;
  }

  /**
   * Gets the category id.
   *
   * @return the category id
   */
  public String getCategoryId() {
    return categoryId;
  }

  /**
   * Sets the category id.
   *
   * @param categoryId the new category id
   */
  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }


}

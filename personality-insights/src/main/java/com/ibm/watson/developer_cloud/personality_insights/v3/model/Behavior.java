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
 * Personality Behavior information.
 */
public class Behavior extends GenericModel {

  @SerializedName("trait_id")
  private String traitId;

  private String name;
  private String category;
  private Double percentage;

  /**
   * Gets the unique identifier of the characteristic to which the results pertain.
   *
   * @return the trait id
   */
  public String getTraitId() {
    return traitId;
  }

  /**
   * Sets the unique identifier of the characteristic to which the results pertain.
   *
   * @param traitId the new trait id
   */
  public void setTraitId(String traitId) {
    this.traitId = traitId;
  }

  /**
   * Gets the user-visible name of the characteristic.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the user-visible name of the characteristic.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the category of the characteristic.
   *
   * @return the category
   */
  public String getCategory() {
    return category;
  }

  /**
   * Sets the category of the characteristic.
   *
   * @param category the new category
   */
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * Gets the percentage of timestamped input data that occurred during that day of the week or hour of the day. The
   * range is 0 to 1.
   *
   * @return the percentage
   */
  public Double getPercentage() {
    return percentage;
  }

  /**
   * Sets the percentage of timestamped input data that occurred during that day of the week or hour of the day. The
   * range is 0 to 1.
   *
   * @param percentage the new percentage
   */
  public void setPercentage(Double percentage) {
    this.percentage = percentage;
  }

}

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
package com.ibm.watson.personality_insights.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The temporal behavior for the input content.
 */
public class Behavior extends GenericModel {

  @SerializedName("trait_id")
  private String traitId;
  private String name;
  private String category;
  private Double percentage;

  /**
   * Gets the traitId.
   *
   * The unique, non-localized identifier of the characteristic to which the results pertain. IDs have the form
   * `behavior_{value}`.
   *
   * @return the traitId
   */
  public String getTraitId() {
    return traitId;
  }

  /**
   * Gets the name.
   *
   * The user-visible, localized name of the characteristic.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the category.
   *
   * The category of the characteristic: `behavior` for temporal data.
   *
   * @return the category
   */
  public String getCategory() {
    return category;
  }

  /**
   * Gets the percentage.
   *
   * For JSON content that is timestamped, the percentage of timestamped input data that occurred during that day of the
   * week or hour of the day. The range is 0 to 1.
   *
   * @return the percentage
   */
  public Double getPercentage() {
    return percentage;
  }
}

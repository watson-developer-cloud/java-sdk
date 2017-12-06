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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Usage information.
 */
public class Usage extends GenericModel {

  private Long features;
  @SerializedName("text_characters")
  private Long textCharacters;
  @SerializedName("text_units")
  private Long textUnits;

  /**
   * Gets the features.
   *
   * Number of features used in the API call
   *
   * @return the features
   */
  public Long getFeatures() {
    return features;
  }

  /**
   * Gets the textCharacters.
   *
   * Number of text characters processed
   *
   * @return the textCharacters
   */
  public Long getTextCharacters() {
    return textCharacters;
  }

  /**
   * Gets the textUnits.
   *
   * Number of 10,000-character units processed
   *
   * @return the textUnits
   */
  public Long getTextUnits() {
    return textUnits;
  }

  /**
   * Sets the features.
   *
   * @param features the new features
   */
  public void setFeatures(final long features) {
    this.features = features;
  }

  /**
   * Sets the textCharacters.
   *
   * @param textCharacters the new textCharacters
   */
  public void setTextCharacters(final long textCharacters) {
    this.textCharacters = textCharacters;
  }

  /**
   * Sets the textUnits.
   *
   * @param textUnits the new textUnits
   */
  public void setTextUnits(final long textUnits) {
    this.textUnits = textUnits;
  }
}

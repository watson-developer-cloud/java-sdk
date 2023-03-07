/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.watson.natural_language_understanding.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** API usage information for the request. */
public class AnalysisResultsUsage extends GenericModel {

  protected Long features;

  @SerializedName("text_characters")
  protected Long textCharacters;

  @SerializedName("text_units")
  protected Long textUnits;

  protected AnalysisResultsUsage() {}

  /**
   * Gets the features.
   *
   * <p>Number of features used in the API call.
   *
   * @return the features
   */
  public Long getFeatures() {
    return features;
  }

  /**
   * Gets the textCharacters.
   *
   * <p>Number of text characters processed.
   *
   * @return the textCharacters
   */
  public Long getTextCharacters() {
    return textCharacters;
  }

  /**
   * Gets the textUnits.
   *
   * <p>Number of 10,000-character units processed.
   *
   * @return the textUnits
   */
  public Long getTextUnits() {
    return textUnits;
  }
}

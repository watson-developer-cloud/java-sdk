/*
 * (C) Copyright IBM Corp. 2016, 2024.
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

package com.ibm.watson.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Information about an available language model. */
public class SpeechModel extends GenericModel {

  protected String name;
  protected String language;
  protected Long rate;
  protected String url;

  @SerializedName("supported_features")
  protected SupportedFeatures supportedFeatures;

  protected String description;

  protected SpeechModel() {}

  /**
   * Gets the name.
   *
   * <p>The name of the model for use as an identifier in calls to the service (for example,
   * `en-US_BroadbandModel`).
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the language.
   *
   * <p>The language identifier of the model (for example, `en-US`).
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the rate.
   *
   * <p>The sampling rate (minimum acceptable rate for audio) used by the model in Hertz.
   *
   * @return the rate
   */
  public Long getRate() {
    return rate;
  }

  /**
   * Gets the url.
   *
   * <p>The URI for the model.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the supportedFeatures.
   *
   * <p>Indicates whether select service features are supported with the model.
   *
   * @return the supportedFeatures
   */
  public SupportedFeatures getSupportedFeatures() {
    return supportedFeatures;
  }

  /**
   * Gets the description.
   *
   * <p>A brief description of the model.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }
}

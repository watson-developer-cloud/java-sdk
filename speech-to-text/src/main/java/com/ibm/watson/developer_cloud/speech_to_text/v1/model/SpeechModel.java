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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * SpeechModel.
 */
public class SpeechModel extends GenericModel {

  private String name;
  private String language;
  private Long rate;
  private String url;
  @SerializedName("supported_features")
  private SupportedFeatures supportedFeatures;
  private String description;
  private String sessions;

  /**
   * Gets the name.
   *
   * The name of the model for use as an identifier in calls to the service (for example, `en-US_BroadbandModel`).
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the language.
   *
   * The language identifier for the model (for example, `en-US`).
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the rate.
   *
   * The sampling rate (minimum acceptable rate for audio) used by the model in Hertz.
   *
   * @return the rate
   */
  public Long getRate() {
    return rate;
  }

  /**
   * Gets the url.
   *
   * The URI for the model.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the supportedFeatures.
   *
   * Describes the additional service features supported with the model.
   *
   * @return the supportedFeatures
   */
  public SupportedFeatures getSupportedFeatures() {
    return supportedFeatures;
  }

  /**
   * Gets the description.
   *
   * Brief description of the model.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the sessions.
   *
   * The URI for the model for use with the `POST /v1/sessions` method. (Returned only for requests for a single model
   * with the `GET /v1/models/{model_id}` method.).
   *
   * @return the sessions
   */
  public String getSessions() {
    return sessions;
  }
}

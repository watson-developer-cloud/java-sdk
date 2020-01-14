/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.text_to_speech.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about an available voice model.
 */
public class Voice extends GenericModel {

  protected String url;
  protected String gender;
  protected String name;
  protected String language;
  protected String description;
  protected Boolean customizable;
  @SerializedName("supported_features")
  protected SupportedFeatures supportedFeatures;
  protected VoiceModel customization;

  /**
   * Gets the url.
   *
   * The URI of the voice.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the gender.
   *
   * The gender of the voice: `male` or `female`.
   *
   * @return the gender
   */
  public String getGender() {
    return gender;
  }

  /**
   * Gets the name.
   *
   * The name of the voice. Use this as the voice identifier in all requests.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the language.
   *
   * The language and region of the voice (for example, `en-US`).
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the description.
   *
   * A textual description of the voice.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the customizable.
   *
   * If `true`, the voice can be customized; if `false`, the voice cannot be customized. (Same as
   * `custom_pronunciation`; maintained for backward compatibility.).
   *
   * @return the customizable
   */
  public Boolean isCustomizable() {
    return customizable;
  }

  /**
   * Gets the supportedFeatures.
   *
   * Additional service features that are supported with the voice.
   *
   * @return the supportedFeatures
   */
  public SupportedFeatures getSupportedFeatures() {
    return supportedFeatures;
  }

  /**
   * Gets the customization.
   *
   * Returns information about a specified custom voice model. This field is returned only by the **Get a voice** method
   * and only when you specify the customization ID of a custom voice model.
   *
   * @return the customization
   */
  public VoiceModel getCustomization() {
    return customization;
  }
}

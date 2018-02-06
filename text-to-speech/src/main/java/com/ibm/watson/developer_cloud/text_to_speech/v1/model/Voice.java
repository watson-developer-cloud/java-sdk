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
package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Voice.
 */
public class Voice extends GenericModel {

  private String url;
  private String gender;
  private String name;
  private String language;
  private String description;
  private Boolean customizable;
  @SerializedName("supported_features")
  private SupportedFeatures supportedFeatures;
  private VoiceModel customization;

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
   * Describes the additional service features supported with the voice.
   *
   * @return the supportedFeatures
   */
  public SupportedFeatures getSupportedFeatures() {
    return supportedFeatures;
  }

  /**
   * Gets the customization.
   *
   * Returns information about a specified custom voice model. **Note:** This field is returned only when you list
   * information about a specific voice and specify the GUID of a custom voice model that is based on that voice.
   *
   * @return the customization
   */
  public VoiceModel getCustomization() {
    return customization;
  }

  /**
   * Sets the url.
   *
   * @param url the new url
   */
  public void setUrl(final String url) {
    this.url = url;
  }

  /**
   * Sets the gender.
   *
   * @param gender the new gender
   */
  public void setGender(final String gender) {
    this.gender = gender;
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
   * Sets the language.
   *
   * @param language the new language
   */
  public void setLanguage(final String language) {
    this.language = language;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Sets the customizable.
   *
   * @param customizable the new customizable
   */
  public void setCustomizable(final Boolean customizable) {
    this.customizable = customizable;
  }

  /**
   * Sets the supportedFeatures.
   *
   * @param supportedFeatures the new supportedFeatures
   */
  public void setSupportedFeatures(final SupportedFeatures supportedFeatures) {
    this.supportedFeatures = supportedFeatures;
  }

  /**
   * Sets the customization.
   *
   * @param customization the new customization
   */
  public void setCustomization(final VoiceModel customization) {
    this.customization = customization;
  }
}

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
package com.ibm.watson.text_to_speech.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Information about an available voice. */
public class Voice extends GenericModel {

  protected String url;
  protected String gender;
  protected String name;
  protected String language;
  protected String description;
  protected Boolean customizable;

  @SerializedName("supported_features")
  protected SupportedFeatures supportedFeatures;

  protected CustomModel customization;

  protected Voice() {}

  /**
   * Gets the url.
   *
   * <p>The URI of the voice.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the gender.
   *
   * <p>The gender of the voice: `male` or `female`.
   *
   * @return the gender
   */
  public String getGender() {
    return gender;
  }

  /**
   * Gets the name.
   *
   * <p>The name of the voice. Use this as the voice identifier in all requests.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the language.
   *
   * <p>The language and region of the voice (for example, `en-US`).
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the description.
   *
   * <p>A textual description of the voice.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the customizable.
   *
   * <p>If `true`, the voice can be customized; if `false`, the voice cannot be customized. (Same as
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
   * <p>Additional service features that are supported with the voice.
   *
   * @return the supportedFeatures
   */
  public SupportedFeatures getSupportedFeatures() {
    return supportedFeatures;
  }

  /**
   * Gets the customization.
   *
   * <p>Returns information about a specified custom model. This field is returned only by the [Get
   * a voice](#getvoice) method and only when you specify the customization ID of a custom model.
   *
   * @return the customization
   */
  public CustomModel getCustomization() {
    return customization;
  }
}

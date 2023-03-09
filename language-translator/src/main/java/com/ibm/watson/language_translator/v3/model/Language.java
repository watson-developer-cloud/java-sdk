/*
 * (C) Copyright IBM Corp. 2020, 2023.
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
package com.ibm.watson.language_translator.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Response payload for languages. */
public class Language extends GenericModel {

  protected String language;

  @SerializedName("language_name")
  protected String languageName;

  @SerializedName("native_language_name")
  protected String nativeLanguageName;

  @SerializedName("country_code")
  protected String countryCode;

  @SerializedName("words_separated")
  protected Boolean wordsSeparated;

  protected String direction;

  @SerializedName("supported_as_source")
  protected Boolean supportedAsSource;

  @SerializedName("supported_as_target")
  protected Boolean supportedAsTarget;

  protected Boolean identifiable;

  protected Language() {}

  /**
   * Gets the language.
   *
   * <p>The language code for the language (for example, `af`).
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the languageName.
   *
   * <p>The name of the language in English (for example, `Afrikaans`).
   *
   * @return the languageName
   */
  public String getLanguageName() {
    return languageName;
  }

  /**
   * Gets the nativeLanguageName.
   *
   * <p>The native name of the language (for example, `Afrikaans`).
   *
   * @return the nativeLanguageName
   */
  public String getNativeLanguageName() {
    return nativeLanguageName;
  }

  /**
   * Gets the countryCode.
   *
   * <p>The country code for the language (for example, `ZA` for South Africa).
   *
   * @return the countryCode
   */
  public String getCountryCode() {
    return countryCode;
  }

  /**
   * Gets the wordsSeparated.
   *
   * <p>Indicates whether words of the language are separated by whitespace: `true` if the words are
   * separated; `false` otherwise.
   *
   * @return the wordsSeparated
   */
  public Boolean isWordsSeparated() {
    return wordsSeparated;
  }

  /**
   * Gets the direction.
   *
   * <p>Indicates the direction of the language: `right_to_left` or `left_to_right`.
   *
   * @return the direction
   */
  public String getDirection() {
    return direction;
  }

  /**
   * Gets the supportedAsSource.
   *
   * <p>Indicates whether the language can be used as the source for translation: `true` if the
   * language can be used as the source; `false` otherwise.
   *
   * @return the supportedAsSource
   */
  public Boolean isSupportedAsSource() {
    return supportedAsSource;
  }

  /**
   * Gets the supportedAsTarget.
   *
   * <p>Indicates whether the language can be used as the target for translation: `true` if the
   * language can be used as the target; `false` otherwise.
   *
   * @return the supportedAsTarget
   */
  public Boolean isSupportedAsTarget() {
    return supportedAsTarget;
  }

  /**
   * Gets the identifiable.
   *
   * <p>Indicates whether the language supports automatic detection: `true` if the language can be
   * detected automatically; `false` otherwise.
   *
   * @return the identifiable
   */
  public Boolean isIdentifiable() {
    return identifiable;
  }
}

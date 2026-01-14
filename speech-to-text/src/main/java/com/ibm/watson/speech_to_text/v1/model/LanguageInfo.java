/*
 * (C) Copyright IBM Corp. 2026.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Language detection info such as confidence and language detected. */
public class LanguageInfo extends GenericModel {

  protected Float confidence;
  protected String language;
  protected Float timestamp;

  protected LanguageInfo() {}

  /**
   * Gets the confidence.
   *
   * <p>A score that indicates the service's confidence in its identification of the language in the
   * range of 0.0 to 1.0.
   *
   * @return the confidence
   */
  public Float getConfidence() {
    return confidence;
  }

  /**
   * Gets the language.
   *
   * <p>The language detected in standard abbreviated ISO 639 format.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the timestamp.
   *
   * <p>The timestamp of the detected language.
   *
   * @return the timestamp
   */
  public Float getTimestamp() {
    return timestamp;
  }
}

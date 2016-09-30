/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.language_translator.v2.model;

import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;

/**
 * Language detected by the {@link LanguageTranslator} service.
 *
 */
public class IdentifiedLanguage extends IdentifiableLanguage {

  /** The confidence. */
  private final Double confidence;

  /**
   * Instantiates a new language.
   *
   * @param language the language
   * @param confidence the confidence
   */
  public IdentifiedLanguage(final String language, final Double confidence) {
    super(language);
    this.confidence = confidence;
  }

  /**
   * Gets the confidence.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }
}

/**
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
package com.ibm.watson.developer_cloud.language_translation.v2.model;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;

/**
 * The languages available in {@link LanguageTranslation}.
 */
public enum Language {
  /** arabic. */
  ARABIC("ar"), /** english. */
  ENGLISH("en"), /** spanish. */
  SPANISH("es"), /** french. */
  FRENCH("fr"), /** italian. */
  ITALIAN("it"), /** portuguese. */
  PORTUGUESE("pt");

  /** language. */
  String language;

  /**
   * Instantiates a new language.
   *
   * @param language the language
   */
  Language(String language) {
    this.language = language;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Enum#toString()
   */
  @Override
  public String toString() {
    return language;
  }
}

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
package com.ibm.watson.language_translator.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** TranslationResult. */
public class TranslationResult extends GenericModel {

  @SerializedName("word_count")
  protected Long wordCount;

  @SerializedName("character_count")
  protected Long characterCount;

  @SerializedName("detected_language")
  protected String detectedLanguage;

  @SerializedName("detected_language_confidence")
  protected Double detectedLanguageConfidence;

  protected List<Translation> translations;

  protected TranslationResult() {}

  /**
   * Gets the wordCount.
   *
   * <p>An estimate of the number of words in the input text.
   *
   * @return the wordCount
   */
  public Long getWordCount() {
    return wordCount;
  }

  /**
   * Gets the characterCount.
   *
   * <p>Number of characters in the input text.
   *
   * @return the characterCount
   */
  public Long getCharacterCount() {
    return characterCount;
  }

  /**
   * Gets the detectedLanguage.
   *
   * <p>The language code of the source text if the source language was automatically detected.
   *
   * @return the detectedLanguage
   */
  public String getDetectedLanguage() {
    return detectedLanguage;
  }

  /**
   * Gets the detectedLanguageConfidence.
   *
   * <p>A score between 0 and 1 indicating the confidence of source language detection. A higher
   * value indicates greater confidence. This is returned only when the service automatically
   * detects the source language.
   *
   * @return the detectedLanguageConfidence
   */
  public Double getDetectedLanguageConfidence() {
    return detectedLanguageConfidence;
  }

  /**
   * Gets the translations.
   *
   * <p>List of translation output in UTF-8, corresponding to the input text entries.
   *
   * @return the translations
   */
  public List<Translation> getTranslations() {
    return translations;
  }
}

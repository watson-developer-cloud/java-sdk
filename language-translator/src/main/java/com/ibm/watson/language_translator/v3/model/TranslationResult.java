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
package com.ibm.watson.language_translator.v3.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * TranslationResult.
 */
public class TranslationResult extends GenericModel {

  @SerializedName("word_count")
  private Long wordCount;
  @SerializedName("character_count")
  private Long characterCount;
  private List<Translation> translations;

  /**
   * Gets the wordCount.
   *
   * Number of words in the input text.
   *
   * @return the wordCount
   */
  public Long getWordCount() {
    return wordCount;
  }

  /**
   * Gets the characterCount.
   *
   * Number of characters in the input text.
   *
   * @return the characterCount
   */
  public Long getCharacterCount() {
    return characterCount;
  }

  /**
   * Gets the translations.
   *
   * List of translation output in UTF-8, corresponding to the input text entries.
   *
   * @return the translations
   */
  public List<Translation> getTranslations() {
    return translations;
  }
}

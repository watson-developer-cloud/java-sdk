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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Translation results from calling the translate method. Contains the word count, character count and the
 * {@link Translation} list
 *
 */
public class TranslationResult extends GenericModel {

  @SerializedName("character_count")
  private Integer characterCount;
  private List<Translation> translations;
  @SerializedName("word_count")
  private Integer wordCount;

  /**
   * Gets the character count.
   *
   * @return The characterCount
   */
  public Integer getCharacterCount() {
    return characterCount;
  }

  /**
   * Gets the first translation.
   *
   * @return the first translation, or null if none found
   */
  public String getFirstTranslation() {
    if ((translations != null) && !translations.isEmpty()) {
      return translations.get(0).getTranslation();
    } else {
      return null;
    }
  }

  /**
   * Gets the translations.
   *
   * @return The translations
   */
  public List<Translation> getTranslations() {
    return translations;
  }

  /**
   * Gets the word count.
   *
   * @return The word count
   */
  public Integer getWordCount() {
    return wordCount;
  }

  /**
   * Sets the character count.
   *
   * @param characterCount The character count
   */
  public void setCharacterCount(final Integer characterCount) {
    this.characterCount = characterCount;
  }

  /**
   * Sets the translations.
   *
   * @param translations The translations
   */
  public void setTranslations(final List<Translation> translations) {
    this.translations = translations;
  }

  /**
   * Sets the word count.
   *
   * @param wordCount The word count
   */
  public void setWordCount(final Integer wordCount) {
    this.wordCount = wordCount;
  }
}

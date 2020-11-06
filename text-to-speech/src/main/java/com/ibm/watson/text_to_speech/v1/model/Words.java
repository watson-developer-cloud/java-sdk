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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/**
 * For the **Add custom words** method, one or more words that are to be added or updated for the
 * custom model and the translation for each specified word.
 *
 * <p>For the **List custom words** method, the words and their translations from the custom model.
 */
public class Words extends GenericModel {

  protected List<Word> words;

  /** Builder. */
  public static class Builder {
    private List<Word> words;

    private Builder(Words words) {
      this.words = words.words;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param words the words
     */
    public Builder(List<Word> words) {
      this.words = words;
    }

    /**
     * Builds a Words.
     *
     * @return the new Words instance
     */
    public Words build() {
      return new Words(this);
    }

    /**
     * Adds an word to words.
     *
     * @param word the new word
     * @return the Words builder
     */
    public Builder addWord(Word word) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(word, "word cannot be null");
      if (this.words == null) {
        this.words = new ArrayList<Word>();
      }
      this.words.add(word);
      return this;
    }

    /**
     * Set the words. Existing words will be replaced.
     *
     * @param words the words
     * @return the Words builder
     */
    public Builder words(List<Word> words) {
      this.words = words;
      return this;
    }
  }

  protected Words(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.words, "words cannot be null");
    words = builder.words;
  }

  /**
   * New builder.
   *
   * @return a Words builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the words.
   *
   * <p>The **Add custom words** method accepts an array of `Word` objects. Each object provides a
   * word that is to be added or updated for the custom model and the word's translation.
   *
   * <p>The **List custom words** method returns an array of `Word` objects. Each object shows a
   * word and its translation from the custom model. The words are listed in alphabetical order,
   * with uppercase letters listed before lowercase letters. The array is empty if the custom model
   * contains no words.
   *
   * @return the words
   */
  public List<Word> words() {
    return words;
  }
}

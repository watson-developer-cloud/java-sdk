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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The addWords options.
 */
public class AddWordsOptions extends GenericModel {

  protected String customizationId;
  protected List<Word> words;

  /**
   * Builder.
   */
  public static class Builder {
    private String customizationId;
    private List<Word> words;

    private Builder(AddWordsOptions addWordsOptions) {
      this.customizationId = addWordsOptions.customizationId;
      this.words = addWordsOptions.words;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     * @param words the words
     */
    public Builder(String customizationId, List<Word> words) {
      this.customizationId = customizationId;
      this.words = words;
    }

    /**
     * Builds a AddWordsOptions.
     *
     * @return the addWordsOptions
     */
    public AddWordsOptions build() {
      return new AddWordsOptions(this);
    }

    /**
     * Adds an word to words.
     *
     * @param word the new word
     * @return the AddWordsOptions builder
     */
    public Builder addWord(Word word) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(word,
        "word cannot be null");
      if (this.words == null) {
        this.words = new ArrayList<Word>();
      }
      this.words.add(word);
      return this;
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the AddWordsOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the words.
     * Existing words will be replaced.
     *
     * @param words the words
     * @return the AddWordsOptions builder
     */
    public Builder words(List<Word> words) {
      this.words = words;
      return this;
    }

    /**
     * Set the words.
     *
     * @param words the words
     * @return the AddWordsOptions builder
     */
    public Builder words(Words words) {
      this.words = words.words();
      return this;
    }
  }

  protected AddWordsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.customizationId,
      "customizationId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.words,
      "words cannot be null");
    customizationId = builder.customizationId;
    words = builder.words;
  }

  /**
   * New builder.
   *
   * @return a AddWordsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * The customization ID (GUID) of the custom voice model. You must make the request with credentials for the instance
   * of the service that owns the custom model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the words.
   *
   * The **Add custom words** method accepts an array of `Word` objects. Each object provides a word that is to be added
   * or updated for the custom voice model and the word's translation.
   *
   * The **List custom words** method returns an array of `Word` objects. Each object shows a word and its translation
   * from the custom voice model. The words are listed in alphabetical order, with uppercase letters listed before
   * lowercase letters. The array is empty if the custom model contains no words.
   *
   * @return the words
   */
  public List<Word> words() {
    return words;
  }
}


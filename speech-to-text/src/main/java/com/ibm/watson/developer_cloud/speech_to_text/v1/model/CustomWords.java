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
package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * CustomWords.
 */
public class CustomWords extends GenericModel {

  private List<CustomWord> words;

  /**
   * Builder.
   */
  public static class Builder {
    private List<CustomWord> words;

    private Builder(CustomWords customWords) {
      words = customWords.words;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param words the words
     */
    public Builder(List<CustomWord> words) {
      this.words = words;
    }

    /**
     * Builds a CustomWords.
     *
     * @return the customWords
     */
    public CustomWords build() {
      return new CustomWords(this);
    }

    /**
     * Adds an words to words.
     *
     * @param words the new words
     * @return the CustomWords builder
     */
    public Builder addWords(CustomWord words) {
      Validator.notNull(words, "words cannot be null");
      if (this.words == null) {
        this.words = new ArrayList<CustomWord>();
      }
      this.words.add(words);
      return this;
    }

    /**
     * Set the words.
     * Existing words will be replaced.
     *
     * @param words the words
     * @return the CustomWords builder
     */
    public Builder words(List<CustomWord> words) {
      this.words = words;
      return this;
    }
  }

  private CustomWords(Builder builder) {
    Validator.notNull(builder.words, "words cannot be null");
    words = builder.words;
  }

  /**
   * New builder.
   *
   * @return a CustomWords builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the words.
   *
   * An array of objects that provides information about each custom word that is to be added to or updated in the
   * custom language model.
   *
   * @return the words
   */
  public List<CustomWord> words() {
    return words;
  }
}

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
package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Words.
 */
public class Words extends GenericModel {

  private List<Word> words;

  /**
   * Gets the words.
   *
   * **When adding words to a custom voice model,** an array of `Word` objects that provides one or more words that are
   * to be added or updated for the custom voice model and the translation for each specified word. **When listing words
   * from a custom voice model,** an array of `Word` objects that lists the words and their translations from the custom
   * voice model. The words are listed in alphabetical order, with uppercase letters listed before lowercase letters.
   * The array is empty if the custom model contains no words.
   *
   * @return the words
   */
  public List<Word> getWords() {
    return words;
  }

  /**
   * Sets the words.
   *
   * @param words the new words
   */
  public void setWords(final List<Word> words) {
    this.words = words;
  }
}

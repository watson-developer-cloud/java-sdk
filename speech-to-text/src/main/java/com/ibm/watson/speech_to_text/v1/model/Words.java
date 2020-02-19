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
package com.ibm.watson.speech_to_text.v1.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about the words from a custom language model.
 */
public class Words extends GenericModel {

  protected List<Word> words;

  /**
   * Gets the words.
   *
   * An array of `Word` objects that provides information about each word in the custom model's words resource. The
   * array is empty if the custom model has no words.
   *
   * @return the words
   */
  public List<Word> getWords() {
    return words;
  }
}


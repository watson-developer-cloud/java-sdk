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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** An alternative hypothesis for a word from speech recognition results. */
public class WordAlternativeResult extends GenericModel {

  protected Double confidence;
  protected String word;

  /**
   * Gets the confidence.
   *
   * <p>A confidence score for the word alternative hypothesis in the range of 0.0 to 1.0.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Gets the word.
   *
   * <p>An alternative hypothesis for a word from the input audio.
   *
   * @return the word
   */
  public String getWord() {
    return word;
  }
}

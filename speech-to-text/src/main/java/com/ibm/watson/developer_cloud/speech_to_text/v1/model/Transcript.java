/*
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

package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Encapsulates a transcription along with the alternatives.
 */
public class Transcript extends GenericModel {

  @SerializedName("final")
  private boolean ffinal;
  private List<SpeechAlternative> alternatives;
  @SerializedName("keywords_result")
  private Map<String, List<KeywordsResult>> keywordsResult;

  /**
   * The word_alternatives. Add by Focuson
   */
  @SerializedName("word_alternatives")
  private List<SpeechWordAlternatives> wordAlternatives;

  /**
   * Gets the alternatives.
   *
   * @return The alternatives
   */
  public List<SpeechAlternative> getAlternatives() {
    return alternatives;
  }

  /**
   * Checks if is final.
   *
   * @return The ffinal
   */
  public boolean isFinal() {
    return ffinal;
  }

  /**
   * Sets the alternatives.
   *
   * @param alternatives The alternatives
   */
  public void setAlternatives(final List<SpeechAlternative> alternatives) {
    this.alternatives = alternatives;
  }

  /**
   * Sets the final value.
   *
   * @param finalValue The final
   */
  public void setFinal(final boolean finalValue) {
    ffinal = finalValue;
  }

  /**
   * Gets the keyword spotting results.
   *
   * @return the results
   */
  public Map<String, List<KeywordsResult>> getKeywordsResult() {
    return keywordsResult;
  }

  /**
   * Sets the keyword spotting results.
   *
   * @param keywordsResult the results
   */
  public void setKeywordsResult(Map<String, List<KeywordsResult>> keywordsResult) {
    this.keywordsResult = keywordsResult;
  }

  /**
   * Gets the word alternatives.
   *
   * @return the word alternatives
   */
  public List<SpeechWordAlternatives> getWordAlternatives() {
    return wordAlternatives;
  }

  /**
   * Sets the word alternatives.
   *
   * @param wordAlternatives the new word alternatives
   */
  public void setWordAlternatives(List<SpeechWordAlternatives> wordAlternatives) {
    this.wordAlternatives = wordAlternatives;
  }
}

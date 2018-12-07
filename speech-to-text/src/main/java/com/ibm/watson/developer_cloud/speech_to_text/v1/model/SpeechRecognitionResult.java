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

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * SpeechRecognitionResult.
 */
public class SpeechRecognitionResult extends GenericModel {

  @SerializedName("final")
  private Boolean finalResults;
  private List<SpeechRecognitionAlternative> alternatives;
  @SerializedName("keywords_result")
  private Map<String, List<KeywordResult>> keywordsResult;
  @SerializedName("word_alternatives")
  private List<WordAlternativeResults> wordAlternatives;

  /**
   * Gets the finalResults.
   *
   * An indication of whether the transcription results are final. If `true`, the results for this utterance are not
   * updated further; no additional results are sent for a `result_index` once its results are indicated as final.
   *
   * @return the finalResults
   */
  public Boolean isFinalResults() {
    return finalResults;
  }

  /**
   * Gets the alternatives.
   *
   * An array of alternative transcripts. The `alternatives` array can include additional requested output such as word
   * confidence or timestamps.
   *
   * @return the alternatives
   */
  public List<SpeechRecognitionAlternative> getAlternatives() {
    return alternatives;
  }

  /**
   * Gets the keywordsResult.
   *
   * A dictionary (or associative array) whose keys are the strings specified for `keywords` if both that parameter and
   * `keywords_threshold` are specified. The value for each key is an array of matches spotted in the audio for that
   * keyword. Each match is described by a `KeywordResult` object. A keyword for which no matches are found is omitted
   * from the dictionary. The dictionary is omitted entirely if no matches are found for any keywords.
   *
   * @return the keywordsResult
   */
  public Map<String, List<KeywordResult>> getKeywordsResult() {
    return keywordsResult;
  }

  /**
   * Gets the wordAlternatives.
   *
   * An array of alternative hypotheses found for words of the input audio if a `word_alternatives_threshold` is
   * specified.
   *
   * @return the wordAlternatives
   */
  public List<WordAlternativeResults> getWordAlternatives() {
    return wordAlternatives;
  }
}

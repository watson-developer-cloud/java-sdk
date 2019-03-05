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
package com.ibm.watson.tone_analyzer.v3.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * SentenceAnalysis.
 */
public class SentenceAnalysis extends GenericModel {

  @SerializedName("sentence_id")
  private Long sentenceId;
  private String text;
  private List<ToneScore> tones;
  @SerializedName("tone_categories")
  private List<ToneCategory> toneCategories;
  @SerializedName("input_from")
  private Long inputFrom;
  @SerializedName("input_to")
  private Long inputTo;

  /**
   * Gets the sentenceId.
   *
   * The unique identifier of a sentence of the input content. The first sentence has ID 0, and the ID of each
   * subsequent sentence is incremented by one.
   *
   * @return the sentenceId
   */
  public Long getSentenceId() {
    return sentenceId;
  }

  /**
   * Gets the text.
   *
   * The text of the input sentence.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the tones.
   *
   * **`2017-09-21`:** An array of `ToneScore` objects that provides the results of the analysis for each qualifying
   * tone of the sentence. The array includes results for any tone whose score is at least 0.5. The array is empty if no
   * tone has a score that meets this threshold. **`2016-05-19`:** Not returned.
   *
   * @return the tones
   */
  public List<ToneScore> getTones() {
    return tones;
  }

  /**
   * Gets the toneCategories.
   *
   * **`2017-09-21`:** Not returned. **`2016-05-19`:** An array of `ToneCategory` objects that provides the results of
   * the tone analysis for the sentence. The service returns results only for the tones specified with the `tones`
   * parameter of the request.
   *
   * @return the toneCategories
   */
  public List<ToneCategory> getToneCategories() {
    return toneCategories;
  }

  /**
   * Gets the inputFrom.
   *
   * **`2017-09-21`:** Not returned. **`2016-05-19`:** The offset of the first character of the sentence in the overall
   * input content.
   *
   * @return the inputFrom
   */
  public Long getInputFrom() {
    return inputFrom;
  }

  /**
   * Gets the inputTo.
   *
   * **`2017-09-21`:** Not returned. **`2016-05-19`:** The offset of the last character of the sentence in the overall
   * input content.
   *
   * @return the inputTo
   */
  public Long getInputTo() {
    return inputTo;
  }
}

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
 * UtteranceAnalyses.
 */
public class UtteranceAnalyses extends GenericModel {

  @SerializedName("utterances_tone")
  private List<UtteranceAnalysis> utterancesTone;
  private String warning;

  /**
   * Gets the utterancesTone.
   *
   * An array of `UtteranceAnalysis` objects that provides the results for each utterance of the input.
   *
   * @return the utterancesTone
   */
  public List<UtteranceAnalysis> getUtterancesTone() {
    return utterancesTone;
  }

  /**
   * Gets the warning.
   *
   * **`2017-09-21`:** A warning message if the content contains more than 50 utterances. The service analyzes only the
   * first 50 utterances. **`2016-05-19`:** Not returned.
   *
   * @return the warning
   */
  public String getWarning() {
    return warning;
  }
}

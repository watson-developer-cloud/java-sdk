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
package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * DocumentAnalysis.
 */
public class DocumentAnalysis extends GenericModel {

  private List<ToneScore> tones;
  private String warning;

  /**
   * Gets the tones.
   *
   * An array of `ToneScore` objects that provides the results of the analysis for each qualifying tone of the document. The array includes results for any tone whose score is at least 0.5. The array is empty if no tone has a score that meets this threshold.
   *
   * @return the tones
   */
  public List<ToneScore> getTones() {
    return tones;
  }

  /**
   * Gets the warning.
   *
   * A warning message if the overall content exceeds 128 KB or contains more than 1000 sentences. The service analyzes only the first 1000 sentences for document-level analysis and the first 100 sentences for sentence-level analysis.
   *
   * @return the warning
   */
  public String getWarning() {
    return warning;
  }

  /**
   * Sets the tones.
   *
   * @param tones the new tones
   */
  public void setTones(final List<ToneScore> tones) {
    this.tones = tones;
  }

  /**
   * Sets the warning.
   *
   * @param warning the new warning
   */
  public void setWarning(final String warning) {
    this.warning = warning;
  }
}

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
 * ToneAnalysis.
 */
public class ToneAnalysis extends GenericModel {

  @SerializedName("document_tone")
  private DocumentAnalysis documentTone;
  @SerializedName("sentences_tone")
  private List<SentenceAnalysis> sentencesTone;

  /**
   * Gets the documentTone.
   *
   * An object of type `DocumentAnalysis` that provides the results of the analysis for the full input document.
   *
   * @return the documentTone
   */
  public DocumentAnalysis getDocumentTone() {
    return documentTone;
  }

  /**
   * Gets the sentencesTone.
   *
   * An array of `SentenceAnalysis` objects that provides the results of the analysis for the individual sentences of
   * the input content. The service returns results only for the first 100 sentences of the input. The field is omitted
   * if the `sentences` parameter of the request is set to `false`.
   *
   * @return the sentencesTone
   */
  public List<SentenceAnalysis> getSentencesTone() {
    return sentencesTone;
  }
}

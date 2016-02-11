/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * 
 * Main object containing the result of running Tone Analyzer on a document. It contains both the
 * sentence-level and document-level results.
 * 
 */
public class ToneAnalysis extends GenericModel {

  @SerializedName("document_tone")
  private ElementTone documentTone;

  @SerializedName("sentences_tone")
  private List<SentenceTone> sentencesTone;

  /**
   * Gets the document tone.
   *
   * @return the document tone
   */
  public ElementTone getDocumentTone() {
    return documentTone;
  }

  /**
   * Sets the document tone.
   *
   * @param documentTone the new document tone
   */
  public void setDocumentTone(ElementTone documentTone) {
    this.documentTone = documentTone;
  }

  /**
   * Gets the sentences tone.
   *
   * @return the sentences tone
   */
  public List<SentenceTone> getSentencesTone() {
    return sentencesTone;
  }

  /**
   * Sets the sentences tone.
   *
   * @param sentencesTone the new sentences tone
   */
  public void setSentencesTone(List<SentenceTone> sentencesTone) {
    this.sentencesTone = sentencesTone;
  }

  /**
   * Adds the sentences tone.
   *
   * @param analysis the analysis
   */
  public void addSentencesTone(SentenceTone analysis) {
    this.sentencesTone.add(analysis);
  }


}

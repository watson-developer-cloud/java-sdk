/*
 * (C) Copyright IBM Corp. 2023.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Information about a grammar from a custom language model. */
public class Grammar extends GenericModel {

  /**
   * The status of the grammar: * `analyzed`: The service successfully analyzed the grammar. The
   * custom model can be trained with data from the grammar. * `being_processed`: The service is
   * still analyzing the grammar. The service cannot accept requests to add new resources or to
   * train the custom model. * `undetermined`: The service encountered an error while processing the
   * grammar. The `error` field describes the failure.
   */
  public interface Status {
    /** analyzed. */
    String ANALYZED = "analyzed";
    /** being_processed. */
    String BEING_PROCESSED = "being_processed";
    /** undetermined. */
    String UNDETERMINED = "undetermined";
  }

  protected String name;

  @SerializedName("out_of_vocabulary_words")
  protected Long outOfVocabularyWords;

  protected String status;
  protected String error;

  protected Grammar() {}

  /**
   * Gets the name.
   *
   * <p>The name of the grammar.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the outOfVocabularyWords.
   *
   * <p>_For custom models that are based on previous-generation models_, the number of OOV words
   * extracted from the grammar. The value is `0` while the grammar is being processed.
   *
   * <p>_For custom models that are based on next-generation models_, no OOV words are extracted
   * from grammars, so the value is always `0`.
   *
   * @return the outOfVocabularyWords
   */
  public Long getOutOfVocabularyWords() {
    return outOfVocabularyWords;
  }

  /**
   * Gets the status.
   *
   * <p>The status of the grammar: * `analyzed`: The service successfully analyzed the grammar. The
   * custom model can be trained with data from the grammar. * `being_processed`: The service is
   * still analyzing the grammar. The service cannot accept requests to add new resources or to
   * train the custom model. * `undetermined`: The service encountered an error while processing the
   * grammar. The `error` field describes the failure.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the error.
   *
   * <p>If the status of the grammar is `undetermined`, the following message: `Analysis of grammar
   * '{grammar_name}' failed. Please try fixing the error or adding the grammar again by setting the
   * 'allow_overwrite' flag to 'true'.`.
   *
   * @return the error
   */
  public String getError() {
    return error;
  }
}

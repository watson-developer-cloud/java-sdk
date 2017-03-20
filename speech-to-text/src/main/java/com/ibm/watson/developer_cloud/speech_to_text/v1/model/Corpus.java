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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Customization corpus. The information includes the total number of
 * words and out-of-vocabulary (OOV) words, name, and status of each corpus.
 * Only the owner of a custom model can use this method to list the model's corpora.
 */
public class Corpus extends GenericModel {

  /**
   * Corpus Status.
   */
  public enum Status {

    /** The corpus has been successfully analyzed. */
    @SerializedName("analyzed") ANALYZED,

    /** The corpus is being processed. */
    @SerializedName("being_processed") BEING_PROCESSED,

    /** The corpus analysis has encountered a problem. */
    @SerializedName("undetermined") UNDETERMINED
  }

  private String error;
  private String name;
  @SerializedName("out_of_vocabulary_words")
  private Integer outOfVocabularyWords;
  private Status status;
  @SerializedName("total_words")
  private Integer totalWords;

  /**
   * Gets the error.
   *
   * @return the error
   */
  public String getError() {
    return error;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * The number of OOV words in the corpus. The value is 0 while the corpus is being processed.
   *
   * @return the out of vocabulary words
   */
  public Integer getOutOfVocabularyWords() {
    return outOfVocabularyWords;
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public Status getStatus() {
    return status;
  }

  /**
   * The total number of words in the corpus. The value is 0 while the corpus is being processed.
   *
   * @return the total words
   */
  public Integer getTotalWords() {
    return totalWords;
  }

  /**
   * Sets the error.
   *
   * @param error the new error
   */
  public void setError(String error) {
    this.error = error;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the number of OOV words in the corpus.
   *
   * @param outOfVocabularyWOrds the new out of vocabulary words
   */
  public void setOutOfVocabularyWords(Integer outOfVocabularyWOrds) {
    this.outOfVocabularyWords = outOfVocabularyWOrds;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(Status status) {
    this.status = status;
  }

  /**
   * Sets the total words.
   *
   * @param totalWords the new total words
   */
  public void setTotalWords(Integer totalWords) {
    this.totalWords = totalWords;
  }
}

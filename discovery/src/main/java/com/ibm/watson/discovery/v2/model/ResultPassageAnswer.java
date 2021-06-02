/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.watson.discovery.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Object containing a potential answer to the specified query. */
public class ResultPassageAnswer extends GenericModel {

  @SerializedName("answer_text")
  protected String answerText;

  @SerializedName("start_offset")
  protected Long startOffset;

  @SerializedName("end_offset")
  protected Long endOffset;

  protected Double confidence;

  /**
   * Gets the answerText.
   *
   * <p>Answer text for the specified query as identified by Discovery.
   *
   * @return the answerText
   */
  public String getAnswerText() {
    return answerText;
  }

  /**
   * Gets the startOffset.
   *
   * <p>The position of the first character of the extracted answer in the originating field.
   *
   * @return the startOffset
   */
  public Long getStartOffset() {
    return startOffset;
  }

  /**
   * Gets the endOffset.
   *
   * <p>The position of the last character of the extracted answer in the originating field.
   *
   * @return the endOffset
   */
  public Long getEndOffset() {
    return endOffset;
  }

  /**
   * Gets the confidence.
   *
   * <p>An estimate of the probability that the answer is relevant.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }
}

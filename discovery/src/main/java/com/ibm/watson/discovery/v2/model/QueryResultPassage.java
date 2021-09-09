/*
 * (C) Copyright IBM Corp. 2019, 2021.
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
import java.util.List;

/** A passage query result. */
public class QueryResultPassage extends GenericModel {

  @SerializedName("passage_text")
  protected String passageText;

  @SerializedName("start_offset")
  protected Long startOffset;

  @SerializedName("end_offset")
  protected Long endOffset;

  protected String field;
  protected Double confidence;
  protected List<ResultPassageAnswer> answers;

  /**
   * Gets the passageText.
   *
   * <p>The content of the extracted passage.
   *
   * @return the passageText
   */
  public String getPassageText() {
    return passageText;
  }

  /**
   * Gets the startOffset.
   *
   * <p>The position of the first character of the extracted passage in the originating field.
   *
   * @return the startOffset
   */
  public Long getStartOffset() {
    return startOffset;
  }

  /**
   * Gets the endOffset.
   *
   * <p>The position after the last character of the extracted passage in the originating field.
   *
   * @return the endOffset
   */
  public Long getEndOffset() {
    return endOffset;
  }

  /**
   * Gets the field.
   *
   * <p>The label of the field from which the passage has been extracted.
   *
   * @return the field
   */
  public String getField() {
    return field;
  }

  /**
   * Gets the confidence.
   *
   * <p>Estimate of the probability that the passage is relevant.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Gets the answers.
   *
   * <p>An arry of extracted answers to the specified query.
   *
   * @return the answers
   */
  public List<ResultPassageAnswer> getAnswers() {
    return answers;
  }
}

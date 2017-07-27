/**
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

package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * {@link RankedAnswer} class used by {@link Ranking}.
 *
 * @version v1
 */
public class RankedAnswer extends GenericModel {

  /** The answer id. */
  @SerializedName("answer_id")
  private String answerID;

  /** The score. */
  @SerializedName("score")
  private Double score;

  /** The confidence. */
  @SerializedName("confidence")
  private Double confidence;

  /**
   * Returns the answer ID.
   *
   * @return answerID
   */
  public String getAnswerID() {
    return answerID;
  }

  /**
   * Sets the answer ID.
   *
   * @param answerID the new answerID
   */
  public void setAnswerID(String answerID) {
    this.answerID = answerID;
  }

  /**
   * Returns the score of the candidate answer.
   *
   * @return score
   */
  public Double getScore() {
    return score;
  }

  /**
   * Sets the score of the candidate answer.
   *
   * @param score the score to set
   */
  public void setScore(Double score) {
    this.score = score;
  }

  /**
   * Gets the confidence that Watson has in this answer's ranking. Higher values represent higher confidences.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Sets the confidence that Watson has in this answer's ranking Higher values represent higher confidences.
   *
   * @param confidence the new confidence
   */
  public void setConfidence(Double confidence) {
    this.confidence = confidence;
  }
}

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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * TargetedSentimentResults.
 */
public class TargetedSentimentResults extends GenericModel {

  private String text;
  private Double score;

  /**
   * Gets the text.
   *
   * Targeted text
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the score.
   *
   * Sentiment score from -1 (negative) to 1 (positive)
   *
   * @return the score
   */
  public Double getScore() {
    return score;
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(final String text) {
    this.text = text;
  }

  /**
   * Sets the score.
   *
   * @param score the new score
   */
  public void setScore(final Double score) {
    this.score = score;
  }
}

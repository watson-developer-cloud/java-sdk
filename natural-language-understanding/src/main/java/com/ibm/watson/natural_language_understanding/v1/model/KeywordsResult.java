/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.natural_language_understanding.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The important keywords in the content, organized by relevance.
 */
public class KeywordsResult extends GenericModel {

  protected Long count;
  protected Double relevance;
  protected String text;
  protected EmotionScores emotion;
  protected FeatureSentimentResults sentiment;

  /**
   * Gets the count.
   *
   * Number of times the keyword appears in the analyzed text.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }

  /**
   * Gets the relevance.
   *
   * Relevance score from 0 to 1. Higher values indicate greater relevance.
   *
   * @return the relevance
   */
  public Double getRelevance() {
    return relevance;
  }

  /**
   * Gets the text.
   *
   * The keyword text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the emotion.
   *
   * Emotion analysis results for the keyword, enabled with the `emotion` option.
   *
   * @return the emotion
   */
  public EmotionScores getEmotion() {
    return emotion;
  }

  /**
   * Gets the sentiment.
   *
   * Sentiment analysis results for the keyword, enabled with the `sentiment` option.
   *
   * @return the sentiment
   */
  public FeatureSentimentResults getSentiment() {
    return sentiment;
  }
}


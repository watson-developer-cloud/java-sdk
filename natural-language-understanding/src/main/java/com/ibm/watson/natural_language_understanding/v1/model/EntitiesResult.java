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
package com.ibm.watson.natural_language_understanding.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/**
 * The important people, places, geopolitical entities and other types of entities in your content.
 */
public class EntitiesResult extends GenericModel {

  protected String type;
  protected String text;
  protected Double relevance;
  protected Double confidence;
  protected List<EntityMention> mentions;
  protected Long count;
  protected EmotionScores emotion;
  protected FeatureSentimentResults sentiment;
  protected DisambiguationResult disambiguation;

  protected EntitiesResult() {}

  /**
   * Gets the type.
   *
   * <p>Entity type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the text.
   *
   * <p>The name of the entity.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the relevance.
   *
   * <p>Relevance score from 0 to 1. Higher values indicate greater relevance.
   *
   * @return the relevance
   */
  public Double getRelevance() {
    return relevance;
  }

  /**
   * Gets the confidence.
   *
   * <p>Confidence in the entity identification from 0 to 1. Higher values indicate higher
   * confidence. In standard entities requests, confidence is returned only for English text. All
   * entities requests that use custom models return the confidence score.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Gets the mentions.
   *
   * <p>Entity mentions and locations.
   *
   * @return the mentions
   */
  public List<EntityMention> getMentions() {
    return mentions;
  }

  /**
   * Gets the count.
   *
   * <p>How many times the entity was mentioned in the text.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }

  /**
   * Gets the emotion.
   *
   * <p>Emotion analysis results for the entity, enabled with the `emotion` option.
   *
   * @return the emotion
   */
  public EmotionScores getEmotion() {
    return emotion;
  }

  /**
   * Gets the sentiment.
   *
   * <p>Sentiment analysis results for the entity, enabled with the `sentiment` option.
   *
   * @return the sentiment
   */
  public FeatureSentimentResults getSentiment() {
    return sentiment;
  }

  /**
   * Gets the disambiguation.
   *
   * <p>Disambiguation information for the entity.
   *
   * @return the disambiguation
   */
  public DisambiguationResult getDisambiguation() {
    return disambiguation;
  }
}

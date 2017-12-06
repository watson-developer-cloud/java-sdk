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

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The important people, places, geopolitical entities and other types of entities in your content.
 */
public class EntitiesResult extends GenericModel {

  private String type;
  private String text;
  private Double relevance;
  private List<EntityMention> mentions;
  private Long count;
  private EmotionScores emotion;
  private FeatureSentimentResults sentiment;
  private DisambiguationResult disambiguation;

  /**
   * Gets the type.
   *
   * Entity type
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the text.
   *
   * The name of the entity
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the relevance.
   *
   * Relevance score from 0 to 1. Higher values indicate greater relevance
   *
   * @return the relevance
   */
  public Double getRelevance() {
    return relevance;
  }

  /**
   * Gets the mentions.
   *
   * Entity mentions and locations
   *
   * @return the mentions
   */
  public List<EntityMention> getMentions() {
    return mentions;
  }

  /**
   * Gets the count.
   *
   * How many times the entity was mentioned in the text
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }

  /**
   * Gets the emotion.
   *
   * Emotion analysis results for the entity, enabled with the "emotion" option
   *
   * @return the emotion
   */
  public EmotionScores getEmotion() {
    return emotion;
  }

  /**
   * Gets the sentiment.
   *
   * Sentiment analysis results for the entity, enabled with the "sentiment" option
   *
   * @return the sentiment
   */
  public FeatureSentimentResults getSentiment() {
    return sentiment;
  }

  /**
   * Gets the disambiguation.
   *
   * Disambiguation information for the entity
   *
   * @return the disambiguation
   */
  public DisambiguationResult getDisambiguation() {
    return disambiguation;
  }

  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(final String type) {
    this.type = type;
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
   * Sets the relevance.
   *
   * @param relevance the new relevance
   */
  public void setRelevance(final Double relevance) {
    this.relevance = relevance;
  }

  /**
   * Sets the mentions.
   *
   * @param mentions the new mentions
   */
  public void setMentions(final List<EntityMention> mentions) {
    this.mentions = mentions;
  }

  /**
   * Sets the count.
   *
   * @param count the new count
   */
  public void setCount(final long count) {
    this.count = count;
  }

  /**
   * Sets the emotion.
   *
   * @param emotion the new emotion
   */
  public void setEmotion(final EmotionScores emotion) {
    this.emotion = emotion;
  }

  /**
   * Sets the sentiment.
   *
   * @param sentiment the new sentiment
   */
  public void setSentiment(final FeatureSentimentResults sentiment) {
    this.sentiment = sentiment;
  }

  /**
   * Sets the disambiguation.
   *
   * @param disambiguation the new disambiguation
   */
  public void setDisambiguation(final DisambiguationResult disambiguation) {
    this.disambiguation = disambiguation;
  }
}

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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * An object speficying the Entities enrichment and related parameters.
 */
public class NluEnrichmentEntities extends GenericModel {

  private Boolean sentiment;
  private Boolean emotion;
  private Long limit;
  private Boolean mentions;
  @SerializedName("mention_types")
  private Boolean mentionTypes;
  @SerializedName("sentence_location")
  private Boolean sentenceLocation;
  private String model;

  /**
   * Gets the sentiment.
   *
   * When `true`, sentiment analysis of entities will be performed on the specified field.
   *
   * @return the sentiment
   */
  public Boolean isSentiment() {
    return sentiment;
  }

  /**
   * Gets the emotion.
   *
   * When `true`, emotion detection of entities will be performed on the specified field.
   *
   * @return the emotion
   */
  public Boolean isEmotion() {
    return emotion;
  }

  /**
   * Gets the limit.
   *
   * The maximum number of entities to extract for each instance of the specified field.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the mentions.
   *
   * When `true`, the number of mentions of each identified entity is recorded. The default is `false`.
   *
   * @return the mentions
   */
  public Boolean isMentions() {
    return mentions;
  }

  /**
   * Gets the mentionTypes.
   *
   * When `true`, the types of mentions for each idetifieid entity is recorded. The default is `false`.
   *
   * @return the mentionTypes
   */
  public Boolean isMentionTypes() {
    return mentionTypes;
  }

  /**
   * Gets the sentenceLocation.
   *
   * When `true`, a list of sentence locations for each instance of each identified entity is recorded. The default is
   * `false`.
   *
   * @return the sentenceLocation
   */
  public Boolean isSentenceLocation() {
    return sentenceLocation;
  }

  /**
   * Gets the model.
   *
   * The enrichement model to use with entity extraction. May be a custom model provided by Watson Knowledge Studio, the
   * public model for use with Knowledge Graph `en-news`, or the default public model `alchemy`.
   *
   * @return the model
   */
  public String getModel() {
    return model;
  }

  /**
   * Sets the sentiment.
   *
   * @param sentiment the new sentiment
   */
  public void setSentiment(final Boolean sentiment) {
    this.sentiment = sentiment;
  }

  /**
   * Sets the emotion.
   *
   * @param emotion the new emotion
   */
  public void setEmotion(final Boolean emotion) {
    this.emotion = emotion;
  }

  /**
   * Sets the limit.
   *
   * @param limit the new limit
   */
  public void setLimit(final long limit) {
    this.limit = limit;
  }

  /**
   * Sets the mentions.
   *
   * @param mentions the new mentions
   */
  public void setMentions(final Boolean mentions) {
    this.mentions = mentions;
  }

  /**
   * Sets the mentionTypes.
   *
   * @param mentionTypes the new mentionTypes
   */
  public void setMentionTypes(final Boolean mentionTypes) {
    this.mentionTypes = mentionTypes;
  }

  /**
   * Sets the sentenceLocation.
   *
   * @param sentenceLocation the new sentenceLocation
   */
  public void setSentenceLocation(final Boolean sentenceLocation) {
    this.sentenceLocation = sentenceLocation;
  }

  /**
   * Sets the model.
   *
   * @param model the new model
   */
  public void setModel(final String model) {
    this.model = model;
  }
}

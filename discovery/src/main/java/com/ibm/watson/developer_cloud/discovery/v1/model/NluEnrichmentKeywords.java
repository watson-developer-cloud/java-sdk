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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * An object specifying the Keyword enrichment and related parameters.
 */
public class NluEnrichmentKeywords extends GenericModel {

  private Boolean sentiment;
  private Boolean emotion;
  private Long limit;

  /**
   * Gets the sentiment.
   *
   * When `true`, sentiment analysis of keywords will be performed on the specified field.
   *
   * @return the sentiment
   */
  public Boolean isSentiment() {
    return sentiment;
  }

  /**
   * Gets the emotion.
   *
   * When `true`, emotion detection of keywords will be performed on the specified field.
   *
   * @return the emotion
   */
  public Boolean isEmotion() {
    return emotion;
  }

  /**
   * Gets the limit.
   *
   * The maximum number of keywords to extract for each instance of the specified field.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
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
}

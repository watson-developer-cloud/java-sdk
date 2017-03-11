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
 * An option indicating whether or not important keywords from the analyzed content should be returned.
 */
public class KeywordsOptions extends GenericModel {

  /** Maximum number of keywords to return. */
  private Integer limit;
  /** Set this to true to return sentiment information for detected keywords. */
  private Boolean sentiment;
  /** Set this to true to analyze emotion for detected keywords. */
  private Boolean emotion;

  /**
   * Gets the limit.
   *
   * @return the limit
   */
  public Integer getLimit() {
    return limit;
  }

  /**
   * Gets the sentiment.
   *
   * @return the sentiment
   */
  public Boolean isSentiment() {
    return sentiment;
  }

  /**
   * Gets the emotion.
   *
   * @return the emotion
   */
  public Boolean isEmotion() {
    return emotion;
  }

  /**
   * Sets the limit.
   *
   * @param limit the new limit
   */
  public void setLimit(final Integer limit) {
    this.limit = limit;
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

}

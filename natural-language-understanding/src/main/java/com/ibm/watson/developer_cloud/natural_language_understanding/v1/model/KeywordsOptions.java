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

  private Long limit;
  private Boolean sentiment;
  private Boolean emotion;

  /**
   * Builder.
   */
  public static class Builder {
    private Long limit;
    private Boolean sentiment;
    private Boolean emotion;

    private Builder(KeywordsOptions keywordsOptions) {
      limit = keywordsOptions.limit;
      sentiment = keywordsOptions.sentiment;
      emotion = keywordsOptions.emotion;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a KeywordsOptions.
     *
     * @return the keywordsOptions
     */
    public KeywordsOptions build() {
      return new KeywordsOptions(this);
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the KeywordsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the sentiment.
     *
     * @param sentiment the sentiment
     * @return the KeywordsOptions builder
     */
    public Builder sentiment(Boolean sentiment) {
      this.sentiment = sentiment;
      return this;
    }

    /**
     * Set the emotion.
     *
     * @param emotion the emotion
     * @return the KeywordsOptions builder
     */
    public Builder emotion(Boolean emotion) {
      this.emotion = emotion;
      return this;
    }
  }

  private KeywordsOptions(Builder builder) {
    limit = builder.limit;
    sentiment = builder.sentiment;
    emotion = builder.emotion;
  }

  /**
   * New builder.
   *
   * @return a KeywordsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the limit.
   *
   * Maximum number of keywords to return
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the sentiment.
   *
   * Set this to true to return sentiment information for detected keywords
   *
   * @return the sentiment
   */
  public Boolean sentiment() {
    return sentiment;
  }

  /**
   * Gets the emotion.
   *
   * Set this to true to analyze emotion for detected keywords
   *
   * @return the emotion
   */
  public Boolean emotion() {
    return emotion;
  }
}

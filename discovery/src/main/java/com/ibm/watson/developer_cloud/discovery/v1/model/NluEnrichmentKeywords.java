/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
   * Builder.
   */
  public static class Builder {
    private Boolean sentiment;
    private Boolean emotion;
    private Long limit;

    private Builder(NluEnrichmentKeywords nluEnrichmentKeywords) {
      sentiment = nluEnrichmentKeywords.sentiment;
      emotion = nluEnrichmentKeywords.emotion;
      limit = nluEnrichmentKeywords.limit;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a NluEnrichmentKeywords.
     *
     * @return the nluEnrichmentKeywords
     */
    public NluEnrichmentKeywords build() {
      return new NluEnrichmentKeywords(this);
    }

    /**
     * Set the sentiment.
     *
     * @param sentiment the sentiment
     * @return the NluEnrichmentKeywords builder
     */
    public Builder sentiment(Boolean sentiment) {
      this.sentiment = sentiment;
      return this;
    }

    /**
     * Set the emotion.
     *
     * @param emotion the emotion
     * @return the NluEnrichmentKeywords builder
     */
    public Builder emotion(Boolean emotion) {
      this.emotion = emotion;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the NluEnrichmentKeywords builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  private NluEnrichmentKeywords(Builder builder) {
    sentiment = builder.sentiment;
    emotion = builder.emotion;
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return a NluEnrichmentKeywords builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the sentiment.
   *
   * When `true`, sentiment analysis of keywords will be performed on the specified field.
   *
   * @return the sentiment
   */
  public Boolean sentiment() {
    return sentiment;
  }

  /**
   * Gets the emotion.
   *
   * When `true`, emotion detection of keywords will be performed on the specified field.
   *
   * @return the emotion
   */
  public Boolean emotion() {
    return emotion;
  }

  /**
   * Gets the limit.
   *
   * The maximum number of keywords to extract for each instance of the specified field.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

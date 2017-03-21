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
 * Whether or not to return important people, places, geopolitical, and other entities detected in the analyzed content.
 */
public class EntitiesOptions extends GenericModel {

  /** Maximum number of entities to return. */
  private Integer limit;
  /** Enter a custom model ID to override the standard entity detection model. */
  private String model;
  /** Set this to true to return sentiment information for detected entities. */
  private Boolean sentiment;
  /** Set this to true to analyze emotion for detected keywords. */
  private Boolean emotion;

  /**
   * Builder.
   */
  public static class Builder {
    private Integer limit;
    private String model;
    private Boolean sentiment;
    private Boolean emotion;

    private Builder(EntitiesOptions entitiesOptions) {
      limit = entitiesOptions.limit;
      model = entitiesOptions.model;
      sentiment = entitiesOptions.sentiment;
      emotion = entitiesOptions.emotion;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds the EntitiesOptions.
     *
     * @return the entitiesOptions
     */
    public EntitiesOptions build() {
      return new EntitiesOptions(this);
    }

    /**
     * Add the limit.
     *
     * @param limit the limit
     * @return a EntitiesOptions Builder
     */
    public Builder limit(Integer limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Add the model.
     *
     * @param model the model
     * @return a EntitiesOptions Builder
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }

    /**
     * Add the sentiment.
     *
     * @param sentiment the sentiment
     * @return a EntitiesOptions Builder
     */
    public Builder sentiment(Boolean sentiment) {
      this.sentiment = sentiment;
      return this;
    }

    /**
     * Add the emotion.
     *
     * @param emotion the emotion
     * @return a EntitiesOptions Builder
     */
    public Builder emotion(Boolean emotion) {
      this.emotion = emotion;
      return this;
    }
  }

  private EntitiesOptions(Builder builder) {
    limit = builder.limit;
    model = builder.model;
    sentiment = builder.sentiment;
    emotion = builder.emotion;
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the limit.
   *
   * @return the limit
   */
  public Integer limit() {
    return limit;
  }

  /**
   * Gets the model.
   *
   * @return the model
   */
  public String model() {
    return model;
  }

  /**
   * Gets the sentiment.
   *
   * @return the sentiment
   */
  public Boolean sentiment() {
    return sentiment;
  }

  /**
   * Gets the emotion.
   *
   * @return the emotion
   */
  public Boolean emotion() {
    return emotion;
  }

}

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

/**
 * Returns important keywords in the content.
 *
 * <p>Supported languages: English, French, German, Italian, Japanese, Korean, Portuguese, Russian,
 * Spanish, Swedish.
 */
public class KeywordsOptions extends GenericModel {

  protected Long limit;
  protected Boolean sentiment;
  protected Boolean emotion;

  /** Builder. */
  public static class Builder {
    private Long limit;
    private Boolean sentiment;
    private Boolean emotion;

    /**
     * Instantiates a new Builder from an existing KeywordsOptions instance.
     *
     * @param keywordsOptions the instance to initialize the Builder with
     */
    private Builder(KeywordsOptions keywordsOptions) {
      this.limit = keywordsOptions.limit;
      this.sentiment = keywordsOptions.sentiment;
      this.emotion = keywordsOptions.emotion;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a KeywordsOptions.
     *
     * @return the new KeywordsOptions instance
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

  protected KeywordsOptions() {}

  protected KeywordsOptions(Builder builder) {
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
   * <p>Maximum number of keywords to return.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the sentiment.
   *
   * <p>Set this to `true` to return sentiment information for detected keywords.
   *
   * @return the sentiment
   */
  public Boolean sentiment() {
    return sentiment;
  }

  /**
   * Gets the emotion.
   *
   * <p>Set this to `true` to analyze emotion for detected keywords.
   *
   * @return the emotion
   */
  public Boolean emotion() {
    return emotion;
  }
}

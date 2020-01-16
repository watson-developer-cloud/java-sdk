/*
 * (C) Copyright IBM Corp. 2017, 2020.
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
package com.ibm.watson.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An object speficying the Entities enrichment and related parameters.
 */
public class NluEnrichmentEntities extends GenericModel {

  protected Boolean sentiment;
  protected Boolean emotion;
  protected Long limit;
  protected Boolean mentions;
  @SerializedName("mention_types")
  protected Boolean mentionTypes;
  @SerializedName("sentence_locations")
  protected Boolean sentenceLocations;
  protected String model;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean sentiment;
    private Boolean emotion;
    private Long limit;
    private Boolean mentions;
    private Boolean mentionTypes;
    private Boolean sentenceLocations;
    private String model;

    private Builder(NluEnrichmentEntities nluEnrichmentEntities) {
      this.sentiment = nluEnrichmentEntities.sentiment;
      this.emotion = nluEnrichmentEntities.emotion;
      this.limit = nluEnrichmentEntities.limit;
      this.mentions = nluEnrichmentEntities.mentions;
      this.mentionTypes = nluEnrichmentEntities.mentionTypes;
      this.sentenceLocations = nluEnrichmentEntities.sentenceLocations;
      this.model = nluEnrichmentEntities.model;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a NluEnrichmentEntities.
     *
     * @return the nluEnrichmentEntities
     */
    public NluEnrichmentEntities build() {
      return new NluEnrichmentEntities(this);
    }

    /**
     * Set the sentiment.
     *
     * @param sentiment the sentiment
     * @return the NluEnrichmentEntities builder
     */
    public Builder sentiment(Boolean sentiment) {
      this.sentiment = sentiment;
      return this;
    }

    /**
     * Set the emotion.
     *
     * @param emotion the emotion
     * @return the NluEnrichmentEntities builder
     */
    public Builder emotion(Boolean emotion) {
      this.emotion = emotion;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the NluEnrichmentEntities builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the mentions.
     *
     * @param mentions the mentions
     * @return the NluEnrichmentEntities builder
     */
    public Builder mentions(Boolean mentions) {
      this.mentions = mentions;
      return this;
    }

    /**
     * Set the mentionTypes.
     *
     * @param mentionTypes the mentionTypes
     * @return the NluEnrichmentEntities builder
     */
    public Builder mentionTypes(Boolean mentionTypes) {
      this.mentionTypes = mentionTypes;
      return this;
    }

    /**
     * Set the sentenceLocations.
     *
     * @param sentenceLocations the sentenceLocations
     * @return the NluEnrichmentEntities builder
     */
    public Builder sentenceLocations(Boolean sentenceLocations) {
      this.sentenceLocations = sentenceLocations;
      return this;
    }

    /**
     * Set the model.
     *
     * @param model the model
     * @return the NluEnrichmentEntities builder
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }
  }

  protected NluEnrichmentEntities(Builder builder) {
    sentiment = builder.sentiment;
    emotion = builder.emotion;
    limit = builder.limit;
    mentions = builder.mentions;
    mentionTypes = builder.mentionTypes;
    sentenceLocations = builder.sentenceLocations;
    model = builder.model;
  }

  /**
   * New builder.
   *
   * @return a NluEnrichmentEntities builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the sentiment.
   *
   * When `true`, sentiment analysis of entities will be performed on the specified field.
   *
   * @return the sentiment
   */
  public Boolean sentiment() {
    return sentiment;
  }

  /**
   * Gets the emotion.
   *
   * When `true`, emotion detection of entities will be performed on the specified field.
   *
   * @return the emotion
   */
  public Boolean emotion() {
    return emotion;
  }

  /**
   * Gets the limit.
   *
   * The maximum number of entities to extract for each instance of the specified field.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the mentions.
   *
   * When `true`, the number of mentions of each identified entity is recorded. The default is `false`.
   *
   * @return the mentions
   */
  public Boolean mentions() {
    return mentions;
  }

  /**
   * Gets the mentionTypes.
   *
   * When `true`, the types of mentions for each idetifieid entity is recorded. The default is `false`.
   *
   * @return the mentionTypes
   */
  public Boolean mentionTypes() {
    return mentionTypes;
  }

  /**
   * Gets the sentenceLocations.
   *
   * When `true`, a list of sentence locations for each instance of each identified entity is recorded. The default is
   * `false`.
   *
   * @return the sentenceLocations
   */
  public Boolean sentenceLocations() {
    return sentenceLocations;
  }

  /**
   * Gets the model.
   *
   * The enrichement model to use with entity extraction. May be a custom model provided by Watson Knowledge Studio, or
   * the default public model `alchemy`.
   *
   * @return the model
   */
  public String model() {
    return model;
  }
}

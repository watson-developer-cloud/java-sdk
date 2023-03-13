/*
 * (C) Copyright IBM Corp. 2017, 2023.
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
import java.util.Map;

/** Object containing Natural Language Understanding features to be used. */
public class NluEnrichmentFeatures extends GenericModel {

  protected NluEnrichmentKeywords keywords;
  protected NluEnrichmentEntities entities;
  protected NluEnrichmentSentiment sentiment;
  protected NluEnrichmentEmotion emotion;
  protected Map<String, Object> categories;

  @SerializedName("semantic_roles")
  protected NluEnrichmentSemanticRoles semanticRoles;

  protected NluEnrichmentRelations relations;
  protected NluEnrichmentConcepts concepts;

  /** Builder. */
  public static class Builder {
    private NluEnrichmentKeywords keywords;
    private NluEnrichmentEntities entities;
    private NluEnrichmentSentiment sentiment;
    private NluEnrichmentEmotion emotion;
    private Map<String, Object> categories;
    private NluEnrichmentSemanticRoles semanticRoles;
    private NluEnrichmentRelations relations;
    private NluEnrichmentConcepts concepts;

    /**
     * Instantiates a new Builder from an existing NluEnrichmentFeatures instance.
     *
     * @param nluEnrichmentFeatures the instance to initialize the Builder with
     */
    private Builder(NluEnrichmentFeatures nluEnrichmentFeatures) {
      this.keywords = nluEnrichmentFeatures.keywords;
      this.entities = nluEnrichmentFeatures.entities;
      this.sentiment = nluEnrichmentFeatures.sentiment;
      this.emotion = nluEnrichmentFeatures.emotion;
      this.categories = nluEnrichmentFeatures.categories;
      this.semanticRoles = nluEnrichmentFeatures.semanticRoles;
      this.relations = nluEnrichmentFeatures.relations;
      this.concepts = nluEnrichmentFeatures.concepts;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a NluEnrichmentFeatures.
     *
     * @return the new NluEnrichmentFeatures instance
     */
    public NluEnrichmentFeatures build() {
      return new NluEnrichmentFeatures(this);
    }

    /**
     * Set the keywords.
     *
     * @param keywords the keywords
     * @return the NluEnrichmentFeatures builder
     */
    public Builder keywords(NluEnrichmentKeywords keywords) {
      this.keywords = keywords;
      return this;
    }

    /**
     * Set the entities.
     *
     * @param entities the entities
     * @return the NluEnrichmentFeatures builder
     */
    public Builder entities(NluEnrichmentEntities entities) {
      this.entities = entities;
      return this;
    }

    /**
     * Set the sentiment.
     *
     * @param sentiment the sentiment
     * @return the NluEnrichmentFeatures builder
     */
    public Builder sentiment(NluEnrichmentSentiment sentiment) {
      this.sentiment = sentiment;
      return this;
    }

    /**
     * Set the emotion.
     *
     * @param emotion the emotion
     * @return the NluEnrichmentFeatures builder
     */
    public Builder emotion(NluEnrichmentEmotion emotion) {
      this.emotion = emotion;
      return this;
    }

    /**
     * Set the categories.
     *
     * @param categories the categories
     * @return the NluEnrichmentFeatures builder
     */
    public Builder categories(Map<String, Object> categories) {
      this.categories = categories;
      return this;
    }

    /**
     * Set the semanticRoles.
     *
     * @param semanticRoles the semanticRoles
     * @return the NluEnrichmentFeatures builder
     */
    public Builder semanticRoles(NluEnrichmentSemanticRoles semanticRoles) {
      this.semanticRoles = semanticRoles;
      return this;
    }

    /**
     * Set the relations.
     *
     * @param relations the relations
     * @return the NluEnrichmentFeatures builder
     */
    public Builder relations(NluEnrichmentRelations relations) {
      this.relations = relations;
      return this;
    }

    /**
     * Set the concepts.
     *
     * @param concepts the concepts
     * @return the NluEnrichmentFeatures builder
     */
    public Builder concepts(NluEnrichmentConcepts concepts) {
      this.concepts = concepts;
      return this;
    }
  }

  protected NluEnrichmentFeatures() {}

  protected NluEnrichmentFeatures(Builder builder) {
    keywords = builder.keywords;
    entities = builder.entities;
    sentiment = builder.sentiment;
    emotion = builder.emotion;
    categories = builder.categories;
    semanticRoles = builder.semanticRoles;
    relations = builder.relations;
    concepts = builder.concepts;
  }

  /**
   * New builder.
   *
   * @return a NluEnrichmentFeatures builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the keywords.
   *
   * <p>An object specifying the Keyword enrichment and related parameters.
   *
   * @return the keywords
   */
  public NluEnrichmentKeywords keywords() {
    return keywords;
  }

  /**
   * Gets the entities.
   *
   * <p>An object speficying the Entities enrichment and related parameters.
   *
   * @return the entities
   */
  public NluEnrichmentEntities entities() {
    return entities;
  }

  /**
   * Gets the sentiment.
   *
   * <p>An object specifying the sentiment extraction enrichment and related parameters.
   *
   * @return the sentiment
   */
  public NluEnrichmentSentiment sentiment() {
    return sentiment;
  }

  /**
   * Gets the emotion.
   *
   * <p>An object specifying the emotion detection enrichment and related parameters.
   *
   * @return the emotion
   */
  public NluEnrichmentEmotion emotion() {
    return emotion;
  }

  /**
   * Gets the categories.
   *
   * <p>An object that indicates the Categories enrichment will be applied to the specified field.
   *
   * @return the categories
   */
  public Map<String, Object> categories() {
    return categories;
  }

  /**
   * Gets the semanticRoles.
   *
   * <p>An object specifiying the semantic roles enrichment and related parameters.
   *
   * @return the semanticRoles
   */
  public NluEnrichmentSemanticRoles semanticRoles() {
    return semanticRoles;
  }

  /**
   * Gets the relations.
   *
   * <p>An object specifying the relations enrichment and related parameters.
   *
   * @return the relations
   */
  public NluEnrichmentRelations relations() {
    return relations;
  }

  /**
   * Gets the concepts.
   *
   * <p>An object specifiying the concepts enrichment and related parameters.
   *
   * @return the concepts
   */
  public NluEnrichmentConcepts concepts() {
    return concepts;
  }
}

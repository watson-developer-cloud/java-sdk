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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Analysis features and options.
 */
public class Features extends GenericModel {

  private ConceptsOptions concepts;
  private EmotionOptions emotion;
  private EntitiesOptions entities;
  private KeywordsOptions keywords;
  private MetadataOptions metadata;
  private RelationsOptions relations;
  @SerializedName("semantic_roles")
  private SemanticRolesOptions semanticRoles;
  private SentimentOptions sentiment;
  private CategoriesOptions categories;

  /**
   * Builder.
   */
  public static class Builder {
    private ConceptsOptions concepts;
    private EmotionOptions emotion;
    private EntitiesOptions entities;
    private KeywordsOptions keywords;
    private MetadataOptions metadata;
    private RelationsOptions relations;
    private SemanticRolesOptions semanticRoles;
    private SentimentOptions sentiment;
    private CategoriesOptions categories;

    private Builder(Features features) {
      concepts = features.concepts;
      emotion = features.emotion;
      entities = features.entities;
      keywords = features.keywords;
      metadata = features.metadata;
      relations = features.relations;
      semanticRoles = features.semanticRoles;
      sentiment = features.sentiment;
      categories = features.categories;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Features.
     *
     * @return the features
     */
    public Features build() {
      return new Features(this);
    }

    /**
     * Set the concepts.
     *
     * @param concepts the concepts
     * @return the Features builder
     */
    public Builder concepts(ConceptsOptions concepts) {
      this.concepts = concepts;
      return this;
    }

    /**
     * Set the emotion.
     *
     * @param emotion the emotion
     * @return the Features builder
     */
    public Builder emotion(EmotionOptions emotion) {
      this.emotion = emotion;
      return this;
    }

    /**
     * Set the entities.
     *
     * @param entities the entities
     * @return the Features builder
     */
    public Builder entities(EntitiesOptions entities) {
      this.entities = entities;
      return this;
    }

    /**
     * Set the keywords.
     *
     * @param keywords the keywords
     * @return the Features builder
     */
    public Builder keywords(KeywordsOptions keywords) {
      this.keywords = keywords;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the Features builder
     */
    public Builder metadata(MetadataOptions metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the relations.
     *
     * @param relations the relations
     * @return the Features builder
     */
    public Builder relations(RelationsOptions relations) {
      this.relations = relations;
      return this;
    }

    /**
     * Set the semanticRoles.
     *
     * @param semanticRoles the semanticRoles
     * @return the Features builder
     */
    public Builder semanticRoles(SemanticRolesOptions semanticRoles) {
      this.semanticRoles = semanticRoles;
      return this;
    }

    /**
     * Set the sentiment.
     *
     * @param sentiment the sentiment
     * @return the Features builder
     */
    public Builder sentiment(SentimentOptions sentiment) {
      this.sentiment = sentiment;
      return this;
    }

    /**
     * Set the categories.
     *
     * @param categories the categories
     * @return the Features builder
     */
    public Builder categories(CategoriesOptions categories) {
      this.categories = categories;
      return this;
    }
  }

  private Features(Builder builder) {
    concepts = builder.concepts;
    emotion = builder.emotion;
    entities = builder.entities;
    keywords = builder.keywords;
    metadata = builder.metadata;
    relations = builder.relations;
    semanticRoles = builder.semanticRoles;
    sentiment = builder.sentiment;
    categories = builder.categories;
  }

  /**
   * New builder.
   *
   * @return a Features builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the concepts.
   *
   * Whether or not to return the concepts that are mentioned in the analyzed text
   *
   * @return the concepts
   */
  public ConceptsOptions concepts() {
    return concepts;
  }

  /**
   * Gets the emotion.
   *
   * Whether or not to extract the emotions implied in the analyzed text
   *
   * @return the emotion
   */
  public EmotionOptions emotion() {
    return emotion;
  }

  /**
   * Gets the entities.
   *
   * Whether or not to extract detected entity objects from the analyzed text
   *
   * @return the entities
   */
  public EntitiesOptions entities() {
    return entities;
  }

  /**
   * Gets the keywords.
   *
   * Whether or not to return the keywords in the analyzed text
   *
   * @return the keywords
   */
  public KeywordsOptions keywords() {
    return keywords;
  }

  /**
   * Gets the metadata.
   *
   * Whether or not the author, publication date, and title of the analyzed text should be returned. This parameter is
   * only available for URL and HTML input
   *
   * @return the metadata
   */
  public MetadataOptions metadata() {
    return metadata;
  }

  /**
   * Gets the relations.
   *
   * Whether or not to return the relationships between detected entities in the analyzed text
   *
   * @return the relations
   */
  public RelationsOptions relations() {
    return relations;
  }

  /**
   * Gets the semanticRoles.
   *
   * Whether or not to return the subject-action-object relations from the analyzed text
   *
   * @return the semanticRoles
   */
  public SemanticRolesOptions semanticRoles() {
    return semanticRoles;
  }

  /**
   * Gets the sentiment.
   *
   * Whether or not to return the overall sentiment of the analyzed text
   *
   * @return the sentiment
   */
  public SentimentOptions sentiment() {
    return sentiment;
  }

  /**
   * Gets the categories.
   *
   * Whether or not to return the high level category the content is categorized as (i.e. news, art)
   *
   * @return the categories
   */
  public CategoriesOptions categories() {
    return categories;
  }
}

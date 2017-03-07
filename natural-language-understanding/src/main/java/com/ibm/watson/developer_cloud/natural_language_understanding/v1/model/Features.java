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
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.CategoriesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.ConceptsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EmotionOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.MetadataOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.RelationsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SemanticRolesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SentimentOptions;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Analysis features and options.
 */
public class Features extends GenericModel {

  /** Whether or not to return the concepts that are mentioned in the analyzed text. */
  private ConceptsOptions concepts;
  /** Whether or not to extract the emotions implied in the analyzed text. */
  private EmotionOptions emotion;
  /** Whether or not to extract detected entity objects from the analyzed text. */
  private EntitiesOptions entities;
  /** Whether or not to return the keywords in the analyzed text. */
  private KeywordsOptions keywords;
  /** Whether or not the author, publication date, and title of the analyzed text should be returned. This parameter is only available for URL and HTML input. */
  private MetadataOptions metadata;
  /** Whether or not to return the relationships between detected entities in the analyzed text. */
  private RelationsOptions relations;
  /** Whether or not to return the subject-action-object relations from the analyzed text. */
  @SerializedName("semantic_roles")
  private SemanticRolesOptions semanticRoles;
  /** Whether or not to return the overall sentiment of the analyzed text. */
  private SentimentOptions sentiment;
  /** Whether or not to return the high level category the content is categorized as (i.e. news, art). */
  private CategoriesOptions categories;

  /**
   * Instantiates a new `Features`
   *
   * @param concepts Whether or not to return the concepts that are mentioned in the analyzed text.
   * @param emotion Whether or not to extract the emotions implied in the analyzed text.
   * @param entities Whether or not to extract detected entity objects from the analyzed text.
   * @param keywords Whether or not to return the keywords in the analyzed text.
   * @param metadata Whether or not the author, publication date, and title of the analyzed text should be returned. This parameter is only available for URL and HTML input.
   * @param relations Whether or not to return the relationships between detected entities in the analyzed text.
   * @param semanticRoles Whether or not to return the subject-action-object relations from the analyzed text.
   * @param sentiment Whether or not to return the overall sentiment of the analyzed text.
   * @param categories Whether or not to return the high level category the content is categorized as (i.e. news, art).
   */
  public Features(final ConceptsOptions concepts, final EmotionOptions emotion, final EntitiesOptions entities, final KeywordsOptions keywords, final MetadataOptions metadata, final RelationsOptions relations, final SemanticRolesOptions semanticRoles, final SentimentOptions sentiment, final CategoriesOptions categories) {
    this.concepts = concepts;
    this.emotion = emotion;
    this.entities = entities;
    this.keywords = keywords;
    this.metadata = metadata;
    this.relations = relations;
    this.semanticRoles = semanticRoles;
    this.sentiment = sentiment;
    this.categories = categories;
  }

  /**
   * Gets the concepts.
   *
   * @return the concepts
   */
  public ConceptsOptions getConcepts() {
    return concepts;
  }

  /**
   * Gets the emotion.
   *
   * @return the emotion
   */
  public EmotionOptions getEmotion() {
    return emotion;
  }

  /**
   * Gets the entities.
   *
   * @return the entities
   */
  public EntitiesOptions getEntities() {
    return entities;
  }

  /**
   * Gets the keywords.
   *
   * @return the keywords
   */
  public KeywordsOptions getKeywords() {
    return keywords;
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public MetadataOptions getMetadata() {
    return metadata;
  }

  /**
   * Gets the relations.
   *
   * @return the relations
   */
  public RelationsOptions getRelations() {
    return relations;
  }

  /**
   * Gets the semanticRoles.
   *
   * @return the semanticRoles
   */
  public SemanticRolesOptions getSemanticRoles() {
    return semanticRoles;
  }

  /**
   * Gets the sentiment.
   *
   * @return the sentiment
   */
  public SentimentOptions getSentiment() {
    return sentiment;
  }

  /**
   * Gets the categories.
   *
   * @return the categories
   */
  public CategoriesOptions getCategories() {
    return categories;
  }

  /**
   * Sets the concepts.
   *
   * @param concepts the new concepts
   */
  public void setConcepts(final ConceptsOptions concepts) {
    this.concepts = concepts;
  }

  /**
   * Sets the emotion.
   *
   * @param emotion the new emotion
   */
  public void setEmotion(final EmotionOptions emotion) {
    this.emotion = emotion;
  }

  /**
   * Sets the entities.
   *
   * @param entities the new entities
   */
  public void setEntities(final EntitiesOptions entities) {
    this.entities = entities;
  }

  /**
   * Sets the keywords.
   *
   * @param keywords the new keywords
   */
  public void setKeywords(final KeywordsOptions keywords) {
    this.keywords = keywords;
  }

  /**
   * Sets the metadata.
   *
   * @param metadata the new metadata
   */
  public void setMetadata(final MetadataOptions metadata) {
    this.metadata = metadata;
  }

  /**
   * Sets the relations.
   *
   * @param relations the new relations
   */
  public void setRelations(final RelationsOptions relations) {
    this.relations = relations;
  }

  /**
   * Sets the semanticRoles.
   *
   * @param semanticRoles the new semanticRoles
   */
  public void setSemanticRoles(final SemanticRolesOptions semanticRoles) {
    this.semanticRoles = semanticRoles;
  }

  /**
   * Sets the sentiment.
   *
   * @param sentiment the new sentiment
   */
  public void setSentiment(final SentimentOptions sentiment) {
    this.sentiment = sentiment;
  }

  /**
   * Sets the categories.
   *
   * @param categories the new categories
   */
  public void setCategories(final CategoriesOptions categories) {
    this.categories = categories;
  }

}

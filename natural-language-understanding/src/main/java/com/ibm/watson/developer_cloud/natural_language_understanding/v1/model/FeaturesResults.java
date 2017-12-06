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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Analysis results for each requested feature.
 */
public class FeaturesResults extends GenericModel {

  private List<ConceptsResult> concepts;
  private List<EntitiesResult> entities;
  private List<KeywordsResult> keywords;
  private List<CategoriesResult> categories;
  private EmotionResult emotion;
  private MetadataResult metadata;
  private List<RelationsResult> relations;
  @SerializedName("semantic_roles")
  private List<SemanticRolesResult> semanticRoles;
  private SentimentResult sentiment;

  /**
   * Gets the concepts.
   *
   * The general concepts referenced or alluded to in the specified content
   *
   * @return the concepts
   */
  public List<ConceptsResult> getConcepts() {
    return concepts;
  }

  /**
   * Gets the entities.
   *
   * The important entities in the specified content
   *
   * @return the entities
   */
  public List<EntitiesResult> getEntities() {
    return entities;
  }

  /**
   * Gets the keywords.
   *
   * The important keywords in content organized by relevance
   *
   * @return the keywords
   */
  public List<KeywordsResult> getKeywords() {
    return keywords;
  }

  /**
   * Gets the categories.
   *
   * The hierarchical 5-level taxonomy the content is categorized into
   *
   * @return the categories
   */
  public List<CategoriesResult> getCategories() {
    return categories;
  }

  /**
   * Gets the emotion.
   *
   * The anger, disgust, fear, joy, or sadness conveyed by the content
   *
   * @return the emotion
   */
  public EmotionResult getEmotion() {
    return emotion;
  }

  /**
   * Gets the metadata.
   *
   * The metadata holds author information, publication date and the title of the text/HTML content
   *
   * @return the metadata
   */
  public MetadataResult getMetadata() {
    return metadata;
  }

  /**
   * Gets the relations.
   *
   * The relationships between entities in the content
   *
   * @return the relations
   */
  public List<RelationsResult> getRelations() {
    return relations;
  }

  /**
   * Gets the semanticRoles.
   *
   * The subjects of actions and the objects the actions act upon
   *
   * @return the semanticRoles
   */
  public List<SemanticRolesResult> getSemanticRoles() {
    return semanticRoles;
  }

  /**
   * Gets the sentiment.
   *
   * The sentiment of the content
   *
   * @return the sentiment
   */
  public SentimentResult getSentiment() {
    return sentiment;
  }

  /**
   * Sets the concepts.
   *
   * @param concepts the new concepts
   */
  public void setConcepts(final List<ConceptsResult> concepts) {
    this.concepts = concepts;
  }

  /**
   * Sets the entities.
   *
   * @param entities the new entities
   */
  public void setEntities(final List<EntitiesResult> entities) {
    this.entities = entities;
  }

  /**
   * Sets the keywords.
   *
   * @param keywords the new keywords
   */
  public void setKeywords(final List<KeywordsResult> keywords) {
    this.keywords = keywords;
  }

  /**
   * Sets the categories.
   *
   * @param categories the new categories
   */
  public void setCategories(final List<CategoriesResult> categories) {
    this.categories = categories;
  }

  /**
   * Sets the emotion.
   *
   * @param emotion the new emotion
   */
  public void setEmotion(final EmotionResult emotion) {
    this.emotion = emotion;
  }

  /**
   * Sets the metadata.
   *
   * @param metadata the new metadata
   */
  public void setMetadata(final MetadataResult metadata) {
    this.metadata = metadata;
  }

  /**
   * Sets the relations.
   *
   * @param relations the new relations
   */
  public void setRelations(final List<RelationsResult> relations) {
    this.relations = relations;
  }

  /**
   * Sets the semanticRoles.
   *
   * @param semanticRoles the new semanticRoles
   */
  public void setSemanticRoles(final List<SemanticRolesResult> semanticRoles) {
    this.semanticRoles = semanticRoles;
  }

  /**
   * Sets the sentiment.
   *
   * @param sentiment the new sentiment
   */
  public void setSentiment(final SentimentResult sentiment) {
    this.sentiment = sentiment;
  }
}

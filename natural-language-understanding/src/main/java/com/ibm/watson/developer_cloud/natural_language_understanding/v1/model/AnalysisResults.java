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
 * Results of the analysis, organized by feature.
 */
public class AnalysisResults extends GenericModel {

  /** Language used to analyze the text. */
  private String language;
  /** Text that was used in the analysis. */
  @SerializedName("analyzed_text")
  private String analyzedText;
  /** URL that was used to retrieve HTML content. */
  @SerializedName("retrieved_url")
  private String retrievedUrl;
  /** API usage information for the request. */
  private Usage usage;
  /** The general concepts referenced or alluded to in the specified content. */
  private List<ConceptsResult> concepts;
  /** The important entities in the specified content. */
  private List<EntitiesResult> entities;
  /** The important keywords in content organized by relevance. */
  private List<KeywordsResult> keywords;
  /** The hierarchical 5-level taxonomy the content is categorized into. */
  private List<CategoriesResult> categories;
  /** The anger, disgust, fear, joy, or sadness conveyed by the content. */
  private EmotionResult emotion;
  /** The metadata holds author information, publication date and the title of the text/HTML content. */
  private MetadataResult metadata;
  /** The relationships between entities in the content. */
  private List<RelationsResult> relations;
  /** The subjects of actions and the objects the actions act upon. */
  @SerializedName("semantic_roles")
  private List<SemanticRolesResult> semanticRoles;
  /** The sentiment of the content. */
  private SentimentResult sentiment;

  /**
   * Adds the concepts.
   *
   * @param concepts the new concepts
   */
  public void addconcepts(ConceptsResult concepts) {
    this.concepts.add(concepts);
  }

  /**
   * Adds the entities.
   *
   * @param entities the new entities
   */
  public void addentities(EntitiesResult entities) {
    this.entities.add(entities);
  }

  /**
   * Adds the keywords.
   *
   * @param keywords the new keywords
   */
  public void addkeywords(KeywordsResult keywords) {
    this.keywords.add(keywords);
  }

  /**
   * Adds the categories.
   *
   * @param categories the new categories
   */
  public void addcategories(CategoriesResult categories) {
    this.categories.add(categories);
  }

  /**
   * Adds the relations.
   *
   * @param relations the new relations
   */
  public void addrelations(RelationsResult relations) {
    this.relations.add(relations);
  }

  /**
   * Adds the semanticRoles.
   *
   * @param semanticRoles the new semanticRoles
   */
  public void addsemanticRoles(SemanticRolesResult semanticRoles) {
    this.semanticRoles.add(semanticRoles);
  }

  /**
   * Gets the language.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the analyzedText.
   *
   * @return the analyzedText
   */
  public String getAnalyzedText() {
    return analyzedText;
  }

  /**
   * Gets the retrievedUrl.
   *
   * @return the retrievedUrl
   */
  public String getRetrievedUrl() {
    return retrievedUrl;
  }

  /**
   * Gets the usage.
   *
   * @return the usage
   */
  public Usage getUsage() {
    return usage;
  }

  /**
   * Gets the concepts.
   *
   * @return the concepts
   */
  public List<ConceptsResult> getConcepts() {
    return concepts;
  }

  /**
   * Gets the entities.
   *
   * @return the entities
   */
  public List<EntitiesResult> getEntities() {
    return entities;
  }

  /**
   * Gets the keywords.
   *
   * @return the keywords
   */
  public List<KeywordsResult> getKeywords() {
    return keywords;
  }

  /**
   * Gets the categories.
   *
   * @return the categories
   */
  public List<CategoriesResult> getCategories() {
    return categories;
  }

  /**
   * Gets the emotion.
   *
   * @return the emotion
   */
  public EmotionResult getEmotion() {
    return emotion;
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public MetadataResult getMetadata() {
    return metadata;
  }

  /**
   * Gets the relations.
   *
   * @return the relations
   */
  public List<RelationsResult> getRelations() {
    return relations;
  }

  /**
   * Gets the semanticRoles.
   *
   * @return the semanticRoles
   */
  public List<SemanticRolesResult> getSemanticRoles() {
    return semanticRoles;
  }

  /**
   * Gets the sentiment.
   *
   * @return the sentiment
   */
  public SentimentResult getSentiment() {
    return sentiment;
  }

  /**
   * Sets the language.
   *
   * @param language the new language
   */
  public void setLanguage(final String language) {
    this.language = language;
  }

  /**
   * Sets the analyzedText.
   *
   * @param analyzedText the new analyzedText
   */
  public void setAnalyzedText(final String analyzedText) {
    this.analyzedText = analyzedText;
  }

  /**
   * Sets the retrievedUrl.
   *
   * @param retrievedUrl the new retrievedUrl
   */
  public void setRetrievedUrl(final String retrievedUrl) {
    this.retrievedUrl = retrievedUrl;
  }

  /**
   * Sets the usage.
   *
   * @param usage the new usage
   */
  public void setUsage(final Usage usage) {
    this.usage = usage;
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

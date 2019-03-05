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
package com.ibm.watson.natural_language_understanding.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Results of the analysis, organized by feature.
 */
public class AnalysisResults extends GenericModel {

  private String language;
  @SerializedName("analyzed_text")
  private String analyzedText;
  @SerializedName("retrieved_url")
  private String retrievedUrl;
  private Usage usage;
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
   * Gets the language.
   *
   * Language used to analyze the text.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the analyzedText.
   *
   * Text that was used in the analysis.
   *
   * @return the analyzedText
   */
  public String getAnalyzedText() {
    return analyzedText;
  }

  /**
   * Gets the retrievedUrl.
   *
   * URL of the webpage that was analyzed.
   *
   * @return the retrievedUrl
   */
  public String getRetrievedUrl() {
    return retrievedUrl;
  }

  /**
   * Gets the usage.
   *
   * Usage information.
   *
   * @return the usage
   */
  public Usage getUsage() {
    return usage;
  }

  /**
   * Gets the concepts.
   *
   * The general concepts referenced or alluded to in the analyzed text.
   *
   * @return the concepts
   */
  public List<ConceptsResult> getConcepts() {
    return concepts;
  }

  /**
   * Gets the entities.
   *
   * The entities detected in the analyzed text.
   *
   * @return the entities
   */
  public List<EntitiesResult> getEntities() {
    return entities;
  }

  /**
   * Gets the keywords.
   *
   * The keywords from the analyzed text.
   *
   * @return the keywords
   */
  public List<KeywordsResult> getKeywords() {
    return keywords;
  }

  /**
   * Gets the categories.
   *
   * The categories that the service assigned to the analyzed text.
   *
   * @return the categories
   */
  public List<CategoriesResult> getCategories() {
    return categories;
  }

  /**
   * Gets the emotion.
   *
   * The detected anger, disgust, fear, joy, or sadness that is conveyed by the content. Emotion information can be
   * returned for detected entities, keywords, or user-specified target phrases found in the text.
   *
   * @return the emotion
   */
  public EmotionResult getEmotion() {
    return emotion;
  }

  /**
   * Gets the metadata.
   *
   * The authors, publication date, title, prominent page image, and RSS/ATOM feeds of the webpage. Supports URL and
   * HTML input types.
   *
   * @return the metadata
   */
  public MetadataResult getMetadata() {
    return metadata;
  }

  /**
   * Gets the relations.
   *
   * The relationships between entities in the content.
   *
   * @return the relations
   */
  public List<RelationsResult> getRelations() {
    return relations;
  }

  /**
   * Gets the semanticRoles.
   *
   * Sentences parsed into `subject`, `action`, and `object` form.
   *
   * @return the semanticRoles
   */
  public List<SemanticRolesResult> getSemanticRoles() {
    return semanticRoles;
  }

  /**
   * Gets the sentiment.
   *
   * The sentiment of the content.
   *
   * @return the sentiment
   */
  public SentimentResult getSentiment() {
    return sentiment;
  }
}

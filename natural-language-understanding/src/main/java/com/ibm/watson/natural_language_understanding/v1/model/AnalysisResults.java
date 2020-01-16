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
package com.ibm.watson.natural_language_understanding.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Results of the analysis, organized by feature.
 */
public class AnalysisResults extends GenericModel {

  protected String language;
  @SerializedName("analyzed_text")
  protected String analyzedText;
  @SerializedName("retrieved_url")
  protected String retrievedUrl;
  protected AnalysisResultsUsage usage;
  protected List<ConceptsResult> concepts;
  protected List<EntitiesResult> entities;
  protected List<KeywordsResult> keywords;
  protected List<CategoriesResult> categories;
  protected EmotionResult emotion;
  protected AnalysisResultsMetadata metadata;
  protected List<RelationsResult> relations;
  @SerializedName("semantic_roles")
  protected List<SemanticRolesResult> semanticRoles;
  protected SentimentResult sentiment;
  protected SyntaxResult syntax;

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
   * API usage information for the request.
   *
   * @return the usage
   */
  public AnalysisResultsUsage getUsage() {
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
   * The anger, disgust, fear, joy, or sadness conveyed by the content.
   *
   * @return the emotion
   */
  public EmotionResult getEmotion() {
    return emotion;
  }

  /**
   * Gets the metadata.
   *
   * Webpage metadata, such as the author and the title of the page.
   *
   * @return the metadata
   */
  public AnalysisResultsMetadata getMetadata() {
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

  /**
   * Gets the syntax.
   *
   * Tokens and sentences returned from syntax analysis.
   *
   * @return the syntax
   */
  public SyntaxResult getSyntax() {
    return syntax;
  }
}

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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * NluEnrichmentFeatures.
 */
public class NluEnrichmentFeatures extends GenericModel {

  private NluEnrichmentKeywords keywords;
  private NluEnrichmentEntities entities;
  private NluEnrichmentSentiment sentiment;
  private NluEnrichmentEmotion emotion;
  private NluEnrichmentCategories categories;
  @SerializedName("semantic_roles")
  private NluEnrichmentSemanticRoles semanticRoles;
  private NluEnrichmentRelations relations;

  /**
   * Gets the keywords.
   *
   * An object specifying the Keyword enrichment and related parameters.
   *
   * @return the keywords
   */
  public NluEnrichmentKeywords getKeywords() {
    return keywords;
  }

  /**
   * Gets the entities.
   *
   * An object speficying the Entities enrichment and related parameters.
   *
   * @return the entities
   */
  public NluEnrichmentEntities getEntities() {
    return entities;
  }

  /**
   * Gets the sentiment.
   *
   * An object specifying the sentiment extraction enrichment and related parameters.
   *
   * @return the sentiment
   */
  public NluEnrichmentSentiment getSentiment() {
    return sentiment;
  }

  /**
   * Gets the emotion.
   *
   * An object specifying the emotion detection enrichment and related parameters.
   *
   * @return the emotion
   */
  public NluEnrichmentEmotion getEmotion() {
    return emotion;
  }

  /**
   * Gets the categories.
   *
   * An object specifying the categories enrichment and related parameters.
   *
   * @return the categories
   */
  public NluEnrichmentCategories getCategories() {
    return categories;
  }

  /**
   * Gets the semanticRoles.
   *
   * An object specifiying the semantic roles enrichment and related parameters.
   *
   * @return the semanticRoles
   */
  public NluEnrichmentSemanticRoles getSemanticRoles() {
    return semanticRoles;
  }

  /**
   * Gets the relations.
   *
   * An object specifying the relations enrichment and related parameters.
   *
   * @return the relations
   */
  public NluEnrichmentRelations getRelations() {
    return relations;
  }

  /**
   * Sets the keywords.
   *
   * @param keywords the new keywords
   */
  public void setKeywords(final NluEnrichmentKeywords keywords) {
    this.keywords = keywords;
  }

  /**
   * Sets the entities.
   *
   * @param entities the new entities
   */
  public void setEntities(final NluEnrichmentEntities entities) {
    this.entities = entities;
  }

  /**
   * Sets the sentiment.
   *
   * @param sentiment the new sentiment
   */
  public void setSentiment(final NluEnrichmentSentiment sentiment) {
    this.sentiment = sentiment;
  }

  /**
   * Sets the emotion.
   *
   * @param emotion the new emotion
   */
  public void setEmotion(final NluEnrichmentEmotion emotion) {
    this.emotion = emotion;
  }

  /**
   * Sets the categories.
   *
   * @param categories the new categories
   */
  public void setCategories(final NluEnrichmentCategories categories) {
    this.categories = categories;
  }

  /**
   * Sets the semanticRoles.
   *
   * @param semanticRoles the new semanticRoles
   */
  public void setSemanticRoles(final NluEnrichmentSemanticRoles semanticRoles) {
    this.semanticRoles = semanticRoles;
  }

  /**
   * Sets the relations.
   *
   * @param relations the new relations
   */
  public void setRelations(final NluEnrichmentRelations relations) {
    this.relations = relations;
  }
}

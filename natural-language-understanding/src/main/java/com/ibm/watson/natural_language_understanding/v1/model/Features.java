/*
 * (C) Copyright IBM Corp. 2019.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

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
  private SyntaxOptions syntax;

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
    private SyntaxOptions syntax;

    private Builder(Features features) {
      this.concepts = features.concepts;
      this.emotion = features.emotion;
      this.entities = features.entities;
      this.keywords = features.keywords;
      this.metadata = features.metadata;
      this.relations = features.relations;
      this.semanticRoles = features.semanticRoles;
      this.sentiment = features.sentiment;
      this.categories = features.categories;
      this.syntax = features.syntax;
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

    /**
     * Set the syntax.
     *
     * @param syntax the syntax
     * @return the Features builder
     */
    public Builder syntax(SyntaxOptions syntax) {
      this.syntax = syntax;
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
    syntax = builder.syntax;
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
   * Returns high-level concepts in the content. For example, a research paper about deep learning might return the
   * concept, "Artificial Intelligence" although the term is not mentioned.
   *
   * Supported languages: English, French, German, Italian, Japanese, Korean, Portuguese, Spanish.
   *
   * @return the concepts
   */
  public ConceptsOptions concepts() {
    return concepts;
  }

  /**
   * Gets the emotion.
   *
   * Detects anger, disgust, fear, joy, or sadness that is conveyed in the content or by the context around target
   * phrases specified in the targets parameter. You can analyze emotion for detected entities with `entities.emotion`
   * and for keywords with `keywords.emotion`.
   *
   * Supported languages: English.
   *
   * @return the emotion
   */
  public EmotionOptions emotion() {
    return emotion;
  }

  /**
   * Gets the entities.
   *
   * Identifies people, cities, organizations, and other entities in the content. See [Entity types and
   * subtypes]
   * (https://cloud.ibm.com/docs/services/natural-language-understanding
   * ?topic=natural-language-understanding-entity-types).
   *
   * Supported languages: English, French, German, Italian, Japanese, Korean, Portuguese, Russian, Spanish, Swedish.
   * Arabic, Chinese, and Dutch are supported only through custom models.
   *
   * @return the entities
   */
  public EntitiesOptions entities() {
    return entities;
  }

  /**
   * Gets the keywords.
   *
   * Returns important keywords in the content.
   *
   * Supported languages: English, French, German, Italian, Japanese, Korean, Portuguese, Russian, Spanish, Swedish.
   *
   * @return the keywords
   */
  public KeywordsOptions keywords() {
    return keywords;
  }

  /**
   * Gets the metadata.
   *
   * Returns information from the document, including author name, title, RSS/ATOM feeds, prominent page image, and
   * publication date. Supports URL and HTML input types only.
   *
   * @return the metadata
   */
  public MetadataOptions metadata() {
    return metadata;
  }

  /**
   * Gets the relations.
   *
   * Recognizes when two entities are related and identifies the type of relation. For example, an `awardedTo` relation
   * might connect the entities "Nobel Prize" and "Albert Einstein". See [Relation
   * types]
   * (https://cloud.ibm.com/docs/services/natural-language-understanding
   * ?topic=natural-language-understanding-relations).
   *
   * Supported languages: Arabic, English, German, Japanese, Korean, Spanish. Chinese, Dutch, French, Italian, and
   * Portuguese custom models are also supported.
   *
   * @return the relations
   */
  public RelationsOptions relations() {
    return relations;
  }

  /**
   * Gets the semanticRoles.
   *
   * Parses sentences into subject, action, and object form.
   *
   * Supported languages: English, German, Japanese, Korean, Spanish.
   *
   * @return the semanticRoles
   */
  public SemanticRolesOptions semanticRoles() {
    return semanticRoles;
  }

  /**
   * Gets the sentiment.
   *
   * Analyzes the general sentiment of your content or the sentiment toward specific target phrases. You can analyze
   * sentiment for detected entities with `entities.sentiment` and for keywords with `keywords.sentiment`.
   *
   * Supported languages: Arabic, English, French, German, Italian, Japanese, Korean, Portuguese, Russian, Spanish.
   *
   * @return the sentiment
   */
  public SentimentOptions sentiment() {
    return sentiment;
  }

  /**
   * Gets the categories.
   *
   * Returns a five-level taxonomy of the content. The top three categories are returned.
   *
   * Supported languages: Arabic, English, French, German, Italian, Japanese, Korean, Portuguese, Spanish.
   *
   * @return the categories
   */
  public CategoriesOptions categories() {
    return categories;
  }

  /**
   * Gets the syntax.
   *
   * Returns tokens and sentences from the input text.
   *
   * @return the syntax
   */
  public SyntaxOptions syntax() {
    return syntax;
  }
}

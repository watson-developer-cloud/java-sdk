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
package com.ibm.watson.developer_cloud.alchemy.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyDataNews;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Article returned by the {@link AlchemyDataNews} service.
 */
public class Article extends GenericModel {

  /**
   * EnrichedTitle returned from {@link AlchemyDataNews#getNewsDocuments(java.util.Map)}.
   */
  public static class EnrichedTitle extends GenericModel {

    private List<Concept> concepts;
    private List<Entity> entities;
    private List<Keyword> keywords;
    private List<SAORelation> relations;
    @SerializedName("docSentiment")
    private Sentiment sentiment;
    private List<Taxonomy> taxonomy;


    /**
     * Gets the concepts.
     *
     * @return the concepts
     */
    public List<Concept> getConcepts() {
      return concepts;
    }

    /**
     * Gets the entities.
     *
     * @return the entities
     */
    public List<Entity> getEntities() {
      return entities;
    }

    /**
     * Gets the keywords.
     *
     * @return the keywords
     */
    public List<Keyword> getKeywords() {
      return keywords;
    }

    /**
     * Gets the relations.
     *
     * @return the relations
     */
    public List<SAORelation> getRelations() {
      return relations;
    }

    /**
     * Gets the sentiment.
     *
     * @return the sentiment
     */
    public Sentiment getSentiment() {
      return sentiment;
    }

    /**
     * Gets the taxonomy.
     *
     * @return the taxonomy
     */
    public List<Taxonomy> getTaxonomy() {
      return taxonomy;
    }

    /**
     * Sets the concepts.
     *
     * @param concepts the new concepts
     */
    public void setConcepts(List<Concept> concepts) {
      this.concepts = concepts;
    }

    /**
     * Sets the entities.
     *
     * @param entities the new entities
     */
    public void setEntities(List<Entity> entities) {
      this.entities = entities;
    }

    /**
     * Sets the keywords.
     *
     * @param keywords the new keywords
     */
    public void setKeywords(List<Keyword> keywords) {
      this.keywords = keywords;
    }

    /**
     * Sets the relations.
     *
     * @param relations the new relations
     */
    public void setRelations(List<SAORelation> relations) {
      this.relations = relations;
    }

    /**
     * Sets the sentiment.
     *
     * @param sentiment the new sentiment
     */
    public void setSentiment(Sentiment sentiment) {
      this.sentiment = sentiment;
    }

    /**
     * Sets the taxonomy.
     *
     * @param taxonomy the new taxonomy
     */
    public void setTaxonomy(List<Taxonomy> taxonomy) {
      this.taxonomy = taxonomy;
    }
  }

  private String author;
  private String cleanedTitle;
  private List<Concept> concepts;
  private EnrichedTitle enrichedTitle;
  private List<Entity> entities;
  private List<Feed> feeds;
  private String image;
  private List<ImageKeyword> imageKeywords;
  private List<Keyword> keywords;
  private String language;
  private PublicationDate publicationDate;
  private List<SAORelation> relations;
  @SerializedName("docSentiment")
  private Sentiment sentiment;
  private List<Taxonomy> taxonomy;
  private String text;
  private String title;
  private String url;

  /**
   * Gets the author.
   *
   * @return the author
   */
  public String getAuthor() {
    return author;
  }

  /**
   * Gets the cleaned title.
   *
   * @return the cleaned title
   */
  public String getCleanedTitle() {
    return cleanedTitle;
  }

  /**
   * Gets the concepts.
   *
   * @return the concepts
   */
  public List<Concept> getConcepts() {
    return concepts;
  }

  /**
   * Gets the enriched title.
   *
   * @return the enriched title
   */
  public EnrichedTitle getEnrichedTitle() {
    return enrichedTitle;
  }

  /**
   * Gets the entities.
   *
   * @return the entities
   */
  public List<Entity> getEntities() {
    return entities;
  }

  /**
   * Gets the feeds.
   *
   * @return the feeds
   */
  public List<Feed> getFeeds() {
    return feeds;
  }

  /**
   * Gets the image.
   *
   * @return the image
   */
  public String getImage() {
    return image;
  }

  /**
   * Gets the image keywords.
   *
   * @return the image keywords
   */
  public List<ImageKeyword> getImageKeywords() {
    return imageKeywords;
  }

  /**
   * Gets the keywords.
   *
   * @return the keywords
   */
  public List<Keyword> getKeywords() {
    return keywords;
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
   * Gets the publication date.
   *
   * @return the publication date
   */
  public PublicationDate getPublicationDate() {
    return publicationDate;
  }

  /**
   * Gets the relations.
   *
   * @return the relations
   */
  public List<SAORelation> getRelations() {
    return relations;
  }

  /**
   * Gets the sentiment.
   *
   * @return the sentiment
   */
  public Sentiment getSentiment() {
    return sentiment;
  }

  /**
   * Gets the taxonomy.
   *
   * @return the taxonomy
   */
  public List<Taxonomy> getTaxonomy() {
    return taxonomy;
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the title.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the url.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets the author.
   *
   * @param author the new author
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * Sets the cleaned title.
   *
   * @param cleanedTitle the new cleaned title
   */
  public void setCleanedTitle(String cleanedTitle) {
    this.cleanedTitle = cleanedTitle;
  }


  /**
   * Sets the concepts.
   *
   * @param concepts the new concepts
   */
  public void setConcepts(List<Concept> concepts) {
    this.concepts = concepts;
  }

  /**
   * Sets the enriched title.
   *
   * @param enrichedTitle the new enriched title
   */
  public void setEnrichedTitle(EnrichedTitle enrichedTitle) {
    this.enrichedTitle = enrichedTitle;
  }

  /**
   * Sets the entities.
   *
   * @param entities the new entities
   */
  public void setEntities(List<Entity> entities) {
    this.entities = entities;
  }

  /**
   * Sets the feeds.
   *
   * @param feeds the new feeds
   */
  public void setFeeds(List<Feed> feeds) {
    this.feeds = feeds;
  }

  /**
   * Sets the image.
   *
   * @param image the new image
   */
  public void setImage(String image) {
    this.image = image;
  }

  /**
   * Sets the image keywords.
   *
   * @param imageKeywords the new image keywords
   */
  public void setImageKeywords(List<ImageKeyword> imageKeywords) {
    this.imageKeywords = imageKeywords;
  }

  /**
   * Sets the keywords.
   *
   * @param keywords the new keywords
   */
  public void setKeywords(List<Keyword> keywords) {
    this.keywords = keywords;
  }

  /**
   * Sets the language.
   *
   * @param language the new language
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  /**
   * Sets the publication date.
   *
   * @param publicationDate the new publication date
   */
  public void setPublicationDate(PublicationDate publicationDate) {
    this.publicationDate = publicationDate;
  }

  /**
   * Sets the relations.
   *
   * @param relations the new relations
   */
  public void setRelations(List<SAORelation> relations) {
    this.relations = relations;
  }

  /**
   * Sets the sentiment.
   *
   * @param sentiment the new sentiment
   */
  public void setSentiment(Sentiment sentiment) {
    this.sentiment = sentiment;
  }

  /**
   * Sets the taxonomy.
   *
   * @param taxonomy the new taxonomy
   */
  public void setTaxonomy(List<Taxonomy> taxonomy) {
    this.taxonomy = taxonomy;
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Sets the title.
   *
   * @param title the new title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Sets the url.
   *
   * @param url the new url
   */
  public void setUrl(String url) {
    this.url = url;
  }
}

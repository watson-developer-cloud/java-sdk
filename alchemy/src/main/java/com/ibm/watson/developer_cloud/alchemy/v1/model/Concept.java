/**
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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Concept returned by the AlchemyLanguage service.
 *
 */
public class Concept extends GenericModel {

  /**
   * The link to the US Census for the disambiguated entity. Note: Provided only for entities that exist in this linked
   * data-set.
   */
  private String census;

  /**
   * The cia link to the CIA World Factbook for the disambiguated entity. Note: Provided only for entities that exist in
   * this linked data-set.
   */
  private String ciaFactbook;

  /**
   * The link to CrunchBase for the disambiguated entity. Note: Provided only for entities that exist in CrunchBase.
   */
  private String crunchbase;

  /**
   * The link to DBpedia for the disambiguated entity. Note: Provided only for entities that exist in this linked
   * data-set.
   */
  private String dbpedia;

  /**
   * The link to Freebase for the disambiguated entity. Note: Provided only for entities that exist in this linked
   * data-set.
   */
  private String freebase;

  /** The geographic coordinates. */
  private String geo;

  /**
   * The link to Geonames for the disambiguated entity. Note: Provided only for entities that exist in this linked
   * data-set.
   */
  private String geonames;

  /**
   * The link to OpenCyc for the disambiguated entity. Note: Provided only for entities that exist in this linked
   * data-set.
   */
  private String opencyc;

  /** The relevance. */
  private Double relevance;

  /** The text. */
  private String text;

  /** The website. */
  private String website;

  /**
   * The link to YAGO for the disambiguated entity. Note: Provided only for entities that exist in this linked data-set.
   */
  private String yago;


  /** The knowledge graph. */
  private KnowledgeGraph knowledgeGraph;

  /**
   * Gets the knowledge graph.
   *
   * @return the knowledge graph
   */
  public KnowledgeGraph getKnowledgeGraph() {
    return knowledgeGraph;
  }

  /**
   * Sets the knowledge graph.
   *
   * @param knowledgeGraph the new knowledge graph
   */
  public void setKnowledgeGraph(KnowledgeGraph knowledgeGraph) {
    this.knowledgeGraph = knowledgeGraph;
  }

  /**
   * Gets the census.
   *
   * @return the census
   */
  public String getCensus() {
    return census;
  }

  /**
   * Gets the cia factbook.
   *
   * @return the ciaFactbook
   */
  public String getCiaFactbook() {
    return ciaFactbook;
  }

  /**
   * Gets the crunchbase.
   *
   * @return The crunchbase
   */
  public String getCrunchbase() {
    return crunchbase;
  }

  /**
   * Gets the dbpedia.
   *
   * @return The dbpedia
   */
  public String getDbpedia() {
    return dbpedia;
  }

  /**
   * Gets the freebase.
   *
   * @return The freebase
   */
  public String getFreebase() {
    return freebase;
  }

  /**
   * Gets the geo.
   *
   * @return the geo
   */
  public String getGeo() {
    return geo;
  }

  /**
   * Gets the geonames.
   *
   * @return the geonames
   */
  public String getGeonames() {
    return geonames;
  }

  /**
   * Gets the opencyc.
   *
   * @return The opencyc
   */
  public String getOpencyc() {
    return opencyc;
  }

  /**
   * Gets the relevance.
   *
   * @return The relevance
   */
  public Double getRelevance() {
    return relevance;
  }

  /**
   * Gets the text.
   *
   * @return The text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the website.
   *
   * @return The website
   */
  public String getWebsite() {
    return website;
  }

  /**
   * Gets the yago.
   *
   * @return The yago
   */
  public String getYago() {
    return yago;
  }

  /**
   * Sets the census.
   *
   * @param census the census to set
   */
  public void setCensus(String census) {
    this.census = census;
  }

  /**
   * Sets the cia factbook.
   *
   * @param ciaFactbook the ciaFactbook to set
   */
  public void setCiaFactbook(String ciaFactbook) {
    this.ciaFactbook = ciaFactbook;
  }

  /**
   * Sets the crunchbase.
   *
   * @param crunchbase The crunchbase
   */
  public void setCrunchbase(String crunchbase) {
    this.crunchbase = crunchbase;
  }

  /**
   * Sets the dbpedia.
   *
   * @param dbpedia The dbpedia
   */
  public void setDbpedia(String dbpedia) {
    this.dbpedia = dbpedia;
  }

  /**
   * Sets the freebase.
   *
   * @param freebase The freebase
   */
  public void setFreebase(String freebase) {
    this.freebase = freebase;
  }

  /**
   * Sets the geo.
   *
   * @param geo the geo to set
   */
  public void setGeo(String geo) {
    this.geo = geo;
  }

  /**
   * Sets the geonames.
   *
   * @param geonames the geonames to set
   */
  public void setGeonames(String geonames) {
    this.geonames = geonames;
  }

  /**
   * Sets the opencyc.
   *
   * @param opencyc The opencyc
   */
  public void setOpencyc(String opencyc) {
    this.opencyc = opencyc;
  }

  /**
   * Sets the relevance.
   *
   * @param relevance The relevance
   */
  public void setRelevance(Double relevance) {
    this.relevance = relevance;
  }

  /**
   * Sets the text.
   *
   * @param text The text
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Sets the website.
   *
   * @param website The website
   */
  public void setWebsite(String website) {
    this.website = website;
  }

  /**
   * Sets the yago.
   *
   * @param yago The yago
   */
  public void setYago(String yago) {
    this.yago = yago;
  }
}

/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.concept_insights.v2.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validate;

/**
 * Concept returned by the {@link ConceptInsights} service.
 * 
 */
public class Concept extends GenericModel {

  @SerializedName("abstract")
  private String _abstract;

  /** The id. */
  private String id;

  /** The label. */
  private String label;

  private String link;

  /** The concept name. */
  private String name;

  private List<String> ontology;

  private String thumbnail;

  /**
   * Instantiates a new concept.
   */
  public Concept() {}

  /**
   * Instantiates a new concept.
   * 
   * @param graph the graph
   * @param concept the concept
   */
  public Concept(final Graph graph, final String concept) {
    Validate.notNull(graph, "graph cannot be null");
    Validate.notNull(graph.getId(), "graph.id cannot be null");
    setName(concept);
    setId(graph.getId() + "/concepts/" + concept);
  }

  /**
   * Instantiates a new concept.
   * 
   * @param accountId the account id
   * @param graphName the graph name
   * @param concept the concept
   */
  public Concept(final String accountId, final String graphName, final String concept) {
    Validate.notNull(concept, "concept cannot be null");
    setName(concept);
    setId(new Graph(accountId, graphName).getId() + "/concepts/" + concept);
  }

  /**
   * @return the abstract. Brief description of the concept. Typically 1-3 sentences. ,
   */
  public String getAbstract() {
    return _abstract;
  }

  /**
   * Gets the id.
   * 
   * @return The id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the Human-readable title of the concept
   * 
   * @return The label
   */
  public String getLabel() {
    return label;
  }

  /**
   * @return the Link to external resource for this concept (for example, a wikipedia page)
   */
  public String getLink() {
    return link;
  }

  /**
   * Gets the name.
   * 
   * @return The name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the list of potential categories for a concept
   */
  public List<String> getOntology() {
    return ontology;
  }

  /**
   * @return the URL of a small image of the concept
   */
  public String getThumbnail() {
    return thumbnail;
  }

  /**
   * @param abs the brief description of the concept. Typically 1-3 sentences. ,
   */
  public void setAbstract(String abs) {
    this._abstract = abs;
  }

  /**
   * Sets the id.
   * 
   * @param id The id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets the Human-readable title of the concept
   * 
   * @param label The label
   */
  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * @param link the Link to external resource for this concept (for example, a wikipedia page)
   */
  public void setLink(String link) {
    this.link = link;
  }

  /**
   * Sets the name.
   * 
   * @param name The name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @param ontology the list of potential categories for a concept
   */
  public void setOntology(List<String> ontology) {
    this.ontology = ontology;
  }

  /**
   * @param thumbnail the URL of a small image of the concept
   */
  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }
}

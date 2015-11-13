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

import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validate;

/**
 * Graph returned by the {@link ConceptInsights} service.
 * 
 */
public class Graph extends GenericModel {

  /** The WIKIPEDIA Graph. */
  public static final Graph WIKIPEDIA = new Graph("wikipedia", "en-20120601");

  /** The id. */
  private String id;

  /** The name. */
  private String name;

  /**
   * Instantiates a new graph.
   */
  public Graph() {}

  /**
   * Instantiates a new graph using the account id and graph name.
   * 
   * @param accountId the account id
   * @param name the name
   */
  public Graph(String accountId, String name) {
    Validate.notEmpty(accountId, "accountId cannot be empty");
    Validate.notEmpty(name, "name cannot be empty");
    setName(name);
    setId("/graphs/" + accountId + "/" + name);
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
   * Gets the name.
   * 
   * @return The name
   */
  public String getName() {
    return name;
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
   * Sets the name.
   * 
   * @param name The name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * With name.
   * 
   * @param name the name
   * @return the graph
   */
  public Graph withName(String name) {
    setName(name);
    return this;
  }
}

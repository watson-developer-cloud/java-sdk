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


import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * An option specifying whether or not to identify the subjects, actions, and verbs in the analyzed content.
 */
public class SemanticRolesOptions extends GenericModel {

  /** Maximum number of semantic_roles results to return. */
  private Integer limit;
  /** Set this to true to return keyword information for subjects and objects. */
  private Boolean keywords;
  /** Set this to true to return entity information for subjects and objects. */
  private Boolean entities;

  /**
   * Instantiates a new `SemanticRolesOptions`
   *
   * @param limit Maximum number of semantic_roles results to return.
   * @param keywords Set this to true to return keyword information for subjects and objects.
   * @param entities Set this to true to return entity information for subjects and objects.
   */
  public SemanticRolesOptions(final Integer limit, final Boolean keywords, final Boolean entities) {
    this.limit = limit;
    this.keywords = keywords;
    this.entities = entities;
  }

  /**
   * Gets the limit.
   *
   * @return the limit
   */
  public Integer getLimit() {
    return limit;
  }

  /**
   * Gets the keywords.
   *
   * @return the keywords
   */
  public Boolean isKeywords() {
    return keywords;
  }

  /**
   * Gets the entities.
   *
   * @return the entities
   */
  public Boolean isEntities() {
    return entities;
  }

  /**
   * Sets the limit.
   *
   * @param limit the new limit
   */
  public void setLimit(final Integer limit) {
    this.limit = limit;
  }

  /**
   * Sets the keywords.
   *
   * @param keywords the new keywords
   */
  public void setKeywords(final Boolean keywords) {
    this.keywords = keywords;
  }

  /**
   * Sets the entities.
   *
   * @param entities the new entities
   */
  public void setEntities(final Boolean entities) {
    this.entities = entities;
  }

}

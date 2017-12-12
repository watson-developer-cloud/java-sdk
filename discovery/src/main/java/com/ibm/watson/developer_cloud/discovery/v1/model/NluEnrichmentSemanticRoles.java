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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * An object specifiying the semantic roles enrichment and related parameters.
 */
public class NluEnrichmentSemanticRoles extends GenericModel {

  private Boolean entities;
  private Boolean keywords;
  private Long limit;

  /**
   * Gets the entities.
   *
   * When `true` entities are extracted from the identified sentence parts.
   *
   * @return the entities
   */
  public Boolean isEntities() {
    return entities;
  }

  /**
   * Gets the keywords.
   *
   * When `true`, keywords are extracted from the identified sentence parts.
   *
   * @return the keywords
   */
  public Boolean isKeywords() {
    return keywords;
  }

  /**
   * Gets the limit.
   *
   * The maximum number of semantic roles enrichments to extact from each instance of the specified field.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Sets the entities.
   *
   * @param entities the new entities
   */
  public void setEntities(final Boolean entities) {
    this.entities = entities;
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
   * Sets the limit.
   *
   * @param limit the new limit
   */
  public void setLimit(final long limit) {
    this.limit = limit;
  }
}

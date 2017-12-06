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
 * QueryEntities.
 */
public class QueryEntities extends GenericModel {

  private String feature;
  private QueryEntitiesEntity entity;
  private QueryEntitiesContext context;
  private Long count;

  /**
   * Gets the feature.
   *
   * The entity query feature to perform. Must be `disambiguate`
   *
   * @return the feature
   */
  public String getFeature() {
    return feature;
  }

  /**
   * Gets the entity.
   *
   * A text string that appears within the entity text field.
   *
   * @return the entity
   */
  public QueryEntitiesEntity getEntity() {
    return entity;
  }

  /**
   * Gets the context.
   *
   * Entity text to provide context for the queried entity and rank based on that association. For example, if you
   * wanted to query the city of London in England your query would look for `London` with the context of `England`.
   *
   * @return the context
   */
  public QueryEntitiesContext getContext() {
    return context;
  }

  /**
   * Gets the count.
   *
   * The number of results to return. The default is `10`. The maximum is `1000`.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }

  /**
   * Sets the feature.
   *
   * @param feature the new feature
   */
  public void setFeature(final String feature) {
    this.feature = feature;
  }

  /**
   * Sets the entity.
   *
   * @param entity the new entity
   */
  public void setEntity(final QueryEntitiesEntity entity) {
    this.entity = entity;
  }

  /**
   * Sets the context.
   *
   * @param context the new context
   */
  public void setContext(final QueryEntitiesContext context) {
    this.context = context;
  }

  /**
   * Sets the count.
   *
   * @param count the new count
   */
  public void setCount(final long count) {
    this.count = count;
  }
}

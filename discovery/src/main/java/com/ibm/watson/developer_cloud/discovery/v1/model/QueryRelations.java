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

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * A JSON respresentation of a relationship query.
 */
public class QueryRelations extends GenericModel {

  /**
   * The sorting method for the relationships, can be `score` or `frequency`. `frequency` is the number of unique times
   * each entity is identified. The default is `score`
   */
  public interface Sort {
    /** score. */
    String SCORE = "score";
    /** frequency. */
    String FREQUENCY = "frequency";
  }

  private List<QueryRelationsEntity> entities;
  private QueryEntitiesContext context;
  private String sort;
  private QueryRelationsFilter filter;
  private Long count;

  /**
   * Gets the entities.
   *
   * An array of entities to find relationships for.
   *
   * @return the entities
   */
  public List<QueryRelationsEntity> getEntities() {
    return entities;
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
   * Gets the sort.
   *
   * The sorting method for the relationships, can be `score` or `frequency`. `frequency` is the number of unique times
   * each entity is identified. The default is `score`
   *
   * @return the sort
   */
  public String getSort() {
    return sort;
  }

  /**
   * Gets the filter.
   *
   * Filters to apply to the relationship query
   *
   * @return the filter
   */
  public QueryRelationsFilter getFilter() {
    return filter;
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
   * Sets the entities.
   *
   * @param entities the new entities
   */
  public void setEntities(final List<QueryRelationsEntity> entities) {
    this.entities = entities;
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
   * Sets the sort.
   *
   * @param sort the new sort
   */
  public void setSort(final String sort) {
    this.sort = sort;
  }

  /**
   * Sets the filter.
   *
   * @param filter the new filter
   */
  public void setFilter(final QueryRelationsFilter filter) {
    this.filter = filter;
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

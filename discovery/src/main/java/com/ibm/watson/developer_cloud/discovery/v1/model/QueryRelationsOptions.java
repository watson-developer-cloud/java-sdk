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

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The queryRelations options.
 */
public class QueryRelationsOptions extends GenericModel {

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

  private String environmentId;
  private String collectionId;
  private List<QueryRelationsEntity> entities;
  private QueryEntitiesContext context;
  private String sort;
  private QueryRelationsFilter filter;
  private Long count;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String collectionId;
    private List<QueryRelationsEntity> entities;
    private QueryEntitiesContext context;
    private String sort;
    private QueryRelationsFilter filter;
    private Long count;

    private Builder(QueryRelationsOptions queryRelationsOptions) {
      environmentId = queryRelationsOptions.environmentId;
      collectionId = queryRelationsOptions.collectionId;
      entities = queryRelationsOptions.entities;
      context = queryRelationsOptions.context;
      sort = queryRelationsOptions.sort;
      filter = queryRelationsOptions.filter;
      count = queryRelationsOptions.count;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     * @param collectionId the collectionId
     */
    public Builder(String environmentId, String collectionId) {
      this.environmentId = environmentId;
      this.collectionId = collectionId;
    }

    /**
     * Builds a QueryRelationsOptions.
     *
     * @return the queryRelationsOptions
     */
    public QueryRelationsOptions build() {
      return new QueryRelationsOptions(this);
    }

    /**
     * Adds an entities to entities.
     *
     * @param entities the new entities
     * @return the QueryRelationsOptions builder
     */
    public Builder addEntities(QueryRelationsEntity entities) {
      Validator.notNull(entities, "entities cannot be null");
      if (this.entities == null) {
        this.entities = new ArrayList<QueryRelationsEntity>();
      }
      this.entities.add(entities);
      return this;
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the QueryRelationsOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the QueryRelationsOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the entities.
     * Existing entities will be replaced.
     *
     * @param entities the entities
     * @return the QueryRelationsOptions builder
     */
    public Builder entities(List<QueryRelationsEntity> entities) {
      this.entities = entities;
      return this;
    }

    /**
     * Set the context.
     *
     * @param context the context
     * @return the QueryRelationsOptions builder
     */
    public Builder context(QueryEntitiesContext context) {
      this.context = context;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the QueryRelationsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the QueryRelationsOptions builder
     */
    public Builder filter(QueryRelationsFilter filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the QueryRelationsOptions builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }
  }

  private QueryRelationsOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    Validator.notEmpty(builder.collectionId, "collectionId cannot be empty");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
    entities = builder.entities;
    context = builder.context;
    sort = builder.sort;
    filter = builder.filter;
    count = builder.count;
  }

  /**
   * New builder.
   *
   * @return a QueryRelationsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the collectionId.
   *
   * The ID of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the entities.
   *
   * An array of entities to find relationships for.
   *
   * @return the entities
   */
  public List<QueryRelationsEntity> entities() {
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
  public QueryEntitiesContext context() {
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
  public String sort() {
    return sort;
  }

  /**
   * Gets the filter.
   *
   * Filters to apply to the relationship query
   *
   * @return the filter
   */
  public QueryRelationsFilter filter() {
    return filter;
  }

  /**
   * Gets the count.
   *
   * The number of results to return. The default is `10`. The maximum is `1000`.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }
}

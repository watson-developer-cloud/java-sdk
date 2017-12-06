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
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The queryEntities options.
 */
public class QueryEntitiesOptions extends GenericModel {

  private String environmentId;
  private String collectionId;
  private String feature;
  private QueryEntitiesEntity entity;
  private QueryEntitiesContext context;
  private Long count;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String collectionId;
    private String feature;
    private QueryEntitiesEntity entity;
    private QueryEntitiesContext context;
    private Long count;

    private Builder(QueryEntitiesOptions queryEntitiesOptions) {
      environmentId = queryEntitiesOptions.environmentId;
      collectionId = queryEntitiesOptions.collectionId;
      feature = queryEntitiesOptions.feature;
      entity = queryEntitiesOptions.entity;
      context = queryEntitiesOptions.context;
      count = queryEntitiesOptions.count;
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
     * Builds a QueryEntitiesOptions.
     *
     * @return the queryEntitiesOptions
     */
    public QueryEntitiesOptions build() {
      return new QueryEntitiesOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the QueryEntitiesOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the QueryEntitiesOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the feature.
     *
     * @param feature the feature
     * @return the QueryEntitiesOptions builder
     */
    public Builder feature(String feature) {
      this.feature = feature;
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return the QueryEntitiesOptions builder
     */
    public Builder entity(QueryEntitiesEntity entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the context.
     *
     * @param context the context
     * @return the QueryEntitiesOptions builder
     */
    public Builder context(QueryEntitiesContext context) {
      this.context = context;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the QueryEntitiesOptions builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }
  }

  private QueryEntitiesOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    Validator.notEmpty(builder.collectionId, "collectionId cannot be empty");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
    feature = builder.feature;
    entity = builder.entity;
    context = builder.context;
    count = builder.count;
  }

  /**
   * New builder.
   *
   * @return a QueryEntitiesOptions builder
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
   * Gets the feature.
   *
   * The entity query feature to perform. Must be `disambiguate`
   *
   * @return the feature
   */
  public String feature() {
    return feature;
  }

  /**
   * Gets the entity.
   *
   * A text string that appears within the entity text field.
   *
   * @return the entity
   */
  public QueryEntitiesEntity entity() {
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
  public QueryEntitiesContext context() {
    return context;
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

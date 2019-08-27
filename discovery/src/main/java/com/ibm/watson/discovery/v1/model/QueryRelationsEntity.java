/*
 * (C) Copyright IBM Corp. 2019.
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
package com.ibm.watson.discovery.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * QueryRelationsEntity.
 */
public class QueryRelationsEntity extends GenericModel {

  private String text;
  private String type;
  private Boolean exact;

  /**
   * Builder.
   */
  public static class Builder {
    private String text;
    private String type;
    private Boolean exact;

    private Builder(QueryRelationsEntity queryRelationsEntity) {
      this.text = queryRelationsEntity.text;
      this.type = queryRelationsEntity.type;
      this.exact = queryRelationsEntity.exact;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a QueryRelationsEntity.
     *
     * @return the queryRelationsEntity
     */
    public QueryRelationsEntity build() {
      return new QueryRelationsEntity(this);
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the QueryRelationsEntity builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the QueryRelationsEntity builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the exact.
     *
     * @param exact the exact
     * @return the QueryRelationsEntity builder
     */
    public Builder exact(Boolean exact) {
      this.exact = exact;
      return this;
    }
  }

  private QueryRelationsEntity(Builder builder) {
    text = builder.text;
    type = builder.type;
    exact = builder.exact;
  }

  /**
   * New builder.
   *
   * @return a QueryRelationsEntity builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * Entity text content.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the type.
   *
   * The type of the specified entity.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the exact.
   *
   * If false, implicit querying is performed. The default is `false`.
   *
   * @return the exact
   */
  public Boolean exact() {
    return exact;
  }
}

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
 * Entity text to provide context for the queried entity and rank based on that association. For example, if you wanted
 * to query the city of London in England your query would look for `London` with the context of `England`.
 */
public class QueryEntitiesContext extends GenericModel {

  private String text;

  /**
   * Builder.
   */
  public static class Builder {
    private String text;

    private Builder(QueryEntitiesContext queryEntitiesContext) {
      this.text = queryEntitiesContext.text;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a QueryEntitiesContext.
     *
     * @return the queryEntitiesContext
     */
    public QueryEntitiesContext build() {
      return new QueryEntitiesContext(this);
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the QueryEntitiesContext builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  private QueryEntitiesContext(Builder builder) {
    text = builder.text;
  }

  /**
   * New builder.
   *
   * @return a QueryEntitiesContext builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * Entity text to provide context for the queried entity and rank based on that association. For example, if you
   * wanted to query the city of London in England your query would look for `London` with the context of `England`.
   *
   * @return the text
   */
  public String text() {
    return text;
  }
}

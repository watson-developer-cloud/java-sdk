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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * QueryFilterType.
 */
public class QueryFilterType extends GenericModel {

  private List<String> exclude;
  private List<String> include;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> exclude;
    private List<String> include;

    private Builder(QueryFilterType queryFilterType) {
      this.exclude = queryFilterType.exclude;
      this.include = queryFilterType.include;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a QueryFilterType.
     *
     * @return the queryFilterType
     */
    public QueryFilterType build() {
      return new QueryFilterType(this);
    }

    /**
     * Adds an exclude to exclude.
     *
     * @param exclude the new exclude
     * @return the QueryFilterType builder
     */
    public Builder addExclude(String exclude) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(exclude,
          "exclude cannot be null");
      if (this.exclude == null) {
        this.exclude = new ArrayList<String>();
      }
      this.exclude.add(exclude);
      return this;
    }

    /**
     * Adds an include to include.
     *
     * @param include the new include
     * @return the QueryFilterType builder
     */
    public Builder addInclude(String include) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(include,
          "include cannot be null");
      if (this.include == null) {
        this.include = new ArrayList<String>();
      }
      this.include.add(include);
      return this;
    }

    /**
     * Set the exclude.
     * Existing exclude will be replaced.
     *
     * @param exclude the exclude
     * @return the QueryFilterType builder
     */
    public Builder exclude(List<String> exclude) {
      this.exclude = exclude;
      return this;
    }

    /**
     * Set the include.
     * Existing include will be replaced.
     *
     * @param include the include
     * @return the QueryFilterType builder
     */
    public Builder include(List<String> include) {
      this.include = include;
      return this;
    }
  }

  private QueryFilterType(Builder builder) {
    exclude = builder.exclude;
    include = builder.include;
  }

  /**
   * New builder.
   *
   * @return a QueryFilterType builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the exclude.
   *
   * A comma-separated list of types to exclude.
   *
   * @return the exclude
   */
  public List<String> exclude() {
    return exclude;
  }

  /**
   * Gets the include.
   *
   * A comma-separated list of types to include. All other types are excluded.
   *
   * @return the include
   */
  public List<String> include() {
    return include;
  }
}

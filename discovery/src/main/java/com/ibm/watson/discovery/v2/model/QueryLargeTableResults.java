/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Configuration for table retrieval. */
public class QueryLargeTableResults extends GenericModel {

  protected Boolean enabled;
  protected Long count;

  /** Builder. */
  public static class Builder {
    private Boolean enabled;
    private Long count;

    /**
     * Instantiates a new Builder from an existing QueryLargeTableResults instance.
     *
     * @param queryLargeTableResults the instance to initialize the Builder with
     */
    private Builder(QueryLargeTableResults queryLargeTableResults) {
      this.enabled = queryLargeTableResults.enabled;
      this.count = queryLargeTableResults.count;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a QueryLargeTableResults.
     *
     * @return the new QueryLargeTableResults instance
     */
    public QueryLargeTableResults build() {
      return new QueryLargeTableResults(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the QueryLargeTableResults builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the QueryLargeTableResults builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }
  }

  protected QueryLargeTableResults() {}

  protected QueryLargeTableResults(Builder builder) {
    enabled = builder.enabled;
    count = builder.count;
  }

  /**
   * New builder.
   *
   * @return a QueryLargeTableResults builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * <p>Whether to enable table retrieval.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the count.
   *
   * <p>Maximum number of tables to return.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }
}

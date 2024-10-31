/*
 * (C) Copyright IBM Corp. 2024.
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

/**
 * Configuration for suggested refinements.
 *
 * <p>**Note**: The **suggested_refinements** parameter that identified dynamic facets from the data
 * is deprecated.
 */
public class QueryLargeSuggestedRefinements extends GenericModel {

  protected Boolean enabled;
  protected Long count;

  /** Builder. */
  public static class Builder {
    private Boolean enabled;
    private Long count;

    /**
     * Instantiates a new Builder from an existing QueryLargeSuggestedRefinements instance.
     *
     * @param queryLargeSuggestedRefinements the instance to initialize the Builder with
     */
    private Builder(QueryLargeSuggestedRefinements queryLargeSuggestedRefinements) {
      this.enabled = queryLargeSuggestedRefinements.enabled;
      this.count = queryLargeSuggestedRefinements.count;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a QueryLargeSuggestedRefinements.
     *
     * @return the new QueryLargeSuggestedRefinements instance
     */
    public QueryLargeSuggestedRefinements build() {
      return new QueryLargeSuggestedRefinements(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the QueryLargeSuggestedRefinements builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the QueryLargeSuggestedRefinements builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }
  }

  protected QueryLargeSuggestedRefinements() {}

  protected QueryLargeSuggestedRefinements(Builder builder) {
    enabled = builder.enabled;
    count = builder.count;
  }

  /**
   * New builder.
   *
   * @return a QueryLargeSuggestedRefinements builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * <p>Whether to perform suggested refinements.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the count.
   *
   * <p>Maximum number of suggested refinements texts to be returned. The maximum is `100`.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }
}

/*
 * (C) Copyright IBM Corp. 2022.
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
 * Object that contains suggested refinement settings.
 *
 * <p>**Note**: The `suggested_refinements` parameter that identified dynamic facets from the data
 * is deprecated.
 */
public class DefaultQueryParamsSuggestedRefinements extends GenericModel {

  protected Boolean enabled;
  protected Long count;

  /** Builder. */
  public static class Builder {
    private Boolean enabled;
    private Long count;

    private Builder(DefaultQueryParamsSuggestedRefinements defaultQueryParamsSuggestedRefinements) {
      this.enabled = defaultQueryParamsSuggestedRefinements.enabled;
      this.count = defaultQueryParamsSuggestedRefinements.count;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a DefaultQueryParamsSuggestedRefinements.
     *
     * @return the new DefaultQueryParamsSuggestedRefinements instance
     */
    public DefaultQueryParamsSuggestedRefinements build() {
      return new DefaultQueryParamsSuggestedRefinements(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the DefaultQueryParamsSuggestedRefinements builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the DefaultQueryParamsSuggestedRefinements builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }
  }

  protected DefaultQueryParamsSuggestedRefinements() {}

  protected DefaultQueryParamsSuggestedRefinements(Builder builder) {
    enabled = builder.enabled;
    count = builder.count;
  }

  /**
   * New builder.
   *
   * @return a DefaultQueryParamsSuggestedRefinements builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * <p>When `true`, suggested refinements for the query are returned by default.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the count.
   *
   * <p>The number of suggested refinements to return by default.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }
}

/*
 * (C) Copyright IBM Corp. 2020, 2023.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Default project query settings for table results. */
public class DefaultQueryParamsTableResults extends GenericModel {

  protected Boolean enabled;
  protected Long count;

  @SerializedName("per_document")
  protected Long perDocument;

  /** Builder. */
  public static class Builder {
    private Boolean enabled;
    private Long count;
    private Long perDocument;

    /**
     * Instantiates a new Builder from an existing DefaultQueryParamsTableResults instance.
     *
     * @param defaultQueryParamsTableResults the instance to initialize the Builder with
     */
    private Builder(DefaultQueryParamsTableResults defaultQueryParamsTableResults) {
      this.enabled = defaultQueryParamsTableResults.enabled;
      this.count = defaultQueryParamsTableResults.count;
      this.perDocument = defaultQueryParamsTableResults.perDocument;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a DefaultQueryParamsTableResults.
     *
     * @return the new DefaultQueryParamsTableResults instance
     */
    public DefaultQueryParamsTableResults build() {
      return new DefaultQueryParamsTableResults(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the DefaultQueryParamsTableResults builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the DefaultQueryParamsTableResults builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }

    /**
     * Set the perDocument.
     *
     * @param perDocument the perDocument
     * @return the DefaultQueryParamsTableResults builder
     */
    public Builder perDocument(long perDocument) {
      this.perDocument = perDocument;
      return this;
    }
  }

  protected DefaultQueryParamsTableResults() {}

  protected DefaultQueryParamsTableResults(Builder builder) {
    enabled = builder.enabled;
    count = builder.count;
    perDocument = builder.perDocument;
  }

  /**
   * New builder.
   *
   * @return a DefaultQueryParamsTableResults builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * <p>When `true`, a table results for the query are returned by default.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the count.
   *
   * <p>The number of table results to return by default.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }

  /**
   * Gets the perDocument.
   *
   * <p>The number of table results to include in each result document.
   *
   * @return the perDocument
   */
  public Long perDocument() {
    return perDocument;
  }
}

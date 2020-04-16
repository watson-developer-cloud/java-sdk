/*
 * (C) Copyright IBM Corp. 2018, 2020.
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

/** The getMetricsQueryTokenEvent options. */
public class GetMetricsQueryTokenEventOptions extends GenericModel {

  protected Long count;

  /** Builder. */
  public static class Builder {
    private Long count;

    private Builder(GetMetricsQueryTokenEventOptions getMetricsQueryTokenEventOptions) {
      this.count = getMetricsQueryTokenEventOptions.count;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a GetMetricsQueryTokenEventOptions.
     *
     * @return the getMetricsQueryTokenEventOptions
     */
    public GetMetricsQueryTokenEventOptions build() {
      return new GetMetricsQueryTokenEventOptions(this);
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the GetMetricsQueryTokenEventOptions builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }
  }

  protected GetMetricsQueryTokenEventOptions(Builder builder) {
    count = builder.count;
  }

  /**
   * New builder.
   *
   * @return a GetMetricsQueryTokenEventOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the count.
   *
   * <p>Number of results to return. The maximum for the **count** and **offset** values together in
   * any one query is **10000**.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }
}

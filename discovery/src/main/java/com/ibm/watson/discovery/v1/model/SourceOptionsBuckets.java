/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
 * Object defining a cloud object store bucket to crawl.
 */
public class SourceOptionsBuckets extends GenericModel {

  protected String name;
  protected Long limit;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private Long limit;

    private Builder(SourceOptionsBuckets sourceOptionsBuckets) {
      this.name = sourceOptionsBuckets.name;
      this.limit = sourceOptionsBuckets.limit;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Builds a SourceOptionsBuckets.
     *
     * @return the sourceOptionsBuckets
     */
    public SourceOptionsBuckets build() {
      return new SourceOptionsBuckets(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the SourceOptionsBuckets builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the SourceOptionsBuckets builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  protected SourceOptionsBuckets(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
        "name cannot be null");
    name = builder.name;
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return a SourceOptionsBuckets builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The name of the cloud object store bucket to crawl.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the limit.
   *
   * The number of documents to crawl from this cloud object store bucket. If not specified, all documents in the bucket
   * are crawled.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

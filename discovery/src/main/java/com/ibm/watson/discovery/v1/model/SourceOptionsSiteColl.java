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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object that defines a Microsoft SharePoint site collection to crawl with this configuration.
 */
public class SourceOptionsSiteColl extends GenericModel {

  @SerializedName("site_collection_path")
  private String siteCollectionPath;
  private Long limit;

  /**
   * Builder.
   */
  public static class Builder {
    private String siteCollectionPath;
    private Long limit;

    private Builder(SourceOptionsSiteColl sourceOptionsSiteColl) {
      this.siteCollectionPath = sourceOptionsSiteColl.siteCollectionPath;
      this.limit = sourceOptionsSiteColl.limit;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param siteCollectionPath the siteCollectionPath
     */
    public Builder(String siteCollectionPath) {
      this.siteCollectionPath = siteCollectionPath;
    }

    /**
     * Builds a SourceOptionsSiteColl.
     *
     * @return the sourceOptionsSiteColl
     */
    public SourceOptionsSiteColl build() {
      return new SourceOptionsSiteColl(this);
    }

    /**
     * Set the siteCollectionPath.
     *
     * @param siteCollectionPath the siteCollectionPath
     * @return the SourceOptionsSiteColl builder
     */
    public Builder siteCollectionPath(String siteCollectionPath) {
      this.siteCollectionPath = siteCollectionPath;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the SourceOptionsSiteColl builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  private SourceOptionsSiteColl(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.siteCollectionPath,
        "siteCollectionPath cannot be null");
    siteCollectionPath = builder.siteCollectionPath;
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return a SourceOptionsSiteColl builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the siteCollectionPath.
   *
   * The Microsoft SharePoint Online site collection path to crawl. The path must be be relative to the
   * **organization_url** that was specified in the credentials associated with this source configuration.
   *
   * @return the siteCollectionPath
   */
  public String siteCollectionPath() {
    return siteCollectionPath;
  }

  /**
   * Gets the limit.
   *
   * The maximum number of documents to crawl for this site collection. By default, all documents in the site collection
   * are crawled.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

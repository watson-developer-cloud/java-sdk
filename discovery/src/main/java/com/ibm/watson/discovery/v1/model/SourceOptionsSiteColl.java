/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
   * Gets the siteCollectionPath.
   *
   * The Microsoft SharePoint Online site collection path to crawl. The path must be be relative to the
   * **organization_url** that was specified in the credentials associated with this source configuration.
   *
   * @return the siteCollectionPath
   */
  public String getSiteCollectionPath() {
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
  public Long getLimit() {
    return limit;
  }

  /**
   * Sets the siteCollectionPath.
   *
   * @param siteCollectionPath the new siteCollectionPath
   */
  public void setSiteCollectionPath(final String siteCollectionPath) {
    this.siteCollectionPath = siteCollectionPath;
  }

  /**
   * Sets the limit.
   *
   * @param limit the new limit
   */
  public void setLimit(final long limit) {
    this.limit = limit;
  }
}

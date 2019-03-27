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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object defining a cloud object store bucket to crawl.
 */
public class SourceOptionsBuckets extends GenericModel {

  private String name;
  private Long limit;

  /**
   * Gets the name.
   *
   * The name of the cloud object store bucket to crawl.
   *
   * @return the name
   */
  public String getName() {
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
  public Long getLimit() {
    return limit;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
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

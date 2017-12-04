/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The listAllLogs options.
 */
public class ListAllLogsOptions extends GenericModel {

  private String sort;
  private String filter;
  private Long pageLimit;
  private String cursor;

  /**
   * Builder.
   */
  public static class Builder {
    private String sort;
    private String filter;
    private Long pageLimit;
    private String cursor;

    private Builder(ListAllLogsOptions listAllLogsOptions) {
      sort = listAllLogsOptions.sort;
      filter = listAllLogsOptions.filter;
      pageLimit = listAllLogsOptions.pageLimit;
      cursor = listAllLogsOptions.cursor;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param filter the filter
     */
    public Builder(String filter) {
      this.filter = filter;
    }

    /**
     * Builds a ListAllLogsOptions.
     *
     * @return the listAllLogsOptions
     */
    public ListAllLogsOptions build() {
      return new ListAllLogsOptions(this);
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListAllLogsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the ListAllLogsOptions builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the pageLimit.
     *
     * @param pageLimit the pageLimit
     * @return the ListAllLogsOptions builder
     */
    public Builder pageLimit(long pageLimit) {
      this.pageLimit = pageLimit;
      return this;
    }

    /**
     * Set the cursor.
     *
     * @param cursor the cursor
     * @return the ListAllLogsOptions builder
     */
    public Builder cursor(String cursor) {
      this.cursor = cursor;
      return this;
    }
  }

  private ListAllLogsOptions(Builder builder) {
    Validator.notNull(builder.filter, "filter cannot be null");
    sort = builder.sort;
    filter = builder.filter;
    pageLimit = builder.pageLimit;
    cursor = builder.cursor;
  }

  /**
   * New builder.
   *
   * @return a ListAllLogsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the sort.
   *
   * Sorts the response according to the value of the specified property, in ascending or descending order.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }

  /**
   * Gets the filter.
   *
   * A cacheable parameter that limits the results to those matching the specified filter. You must specify a filter
   * query that includes a value for `language`, as well as a value for `workspace_id` or
   * `request.context.metadata.deployment`. For more information, see the
   * [documentation](https://console.bluemix.net/docs/services/conversation/filter-reference.html#filter-query-syntax).
   *
   * @return the filter
   */
  public String filter() {
    return filter;
  }

  /**
   * Gets the pageLimit.
   *
   * The number of records to return in each page of results. The default page limit is 100.
   *
   * @return the pageLimit
   */
  public Long pageLimit() {
    return pageLimit;
  }

  /**
   * Gets the cursor.
   *
   * A token identifying the last value from the previous page of results.
   *
   * @return the cursor
   */
  public String cursor() {
    return cursor;
  }
}

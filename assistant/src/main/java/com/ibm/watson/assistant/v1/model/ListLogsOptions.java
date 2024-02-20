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
package com.ibm.watson.assistant.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The listLogs options. */
public class ListLogsOptions extends GenericModel {

  protected String workspaceId;
  protected String sort;
  protected String filter;
  protected Long pageLimit;
  protected String cursor;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String sort;
    private String filter;
    private Long pageLimit;
    private String cursor;

    /**
     * Instantiates a new Builder from an existing ListLogsOptions instance.
     *
     * @param listLogsOptions the instance to initialize the Builder with
     */
    private Builder(ListLogsOptions listLogsOptions) {
      this.workspaceId = listLogsOptions.workspaceId;
      this.sort = listLogsOptions.sort;
      this.filter = listLogsOptions.filter;
      this.pageLimit = listLogsOptions.pageLimit;
      this.cursor = listLogsOptions.cursor;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     */
    public Builder(String workspaceId) {
      this.workspaceId = workspaceId;
    }

    /**
     * Builds a ListLogsOptions.
     *
     * @return the new ListLogsOptions instance
     */
    public ListLogsOptions build() {
      return new ListLogsOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the ListLogsOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListLogsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the ListLogsOptions builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the pageLimit.
     *
     * @param pageLimit the pageLimit
     * @return the ListLogsOptions builder
     */
    public Builder pageLimit(long pageLimit) {
      this.pageLimit = pageLimit;
      return this;
    }

    /**
     * Set the cursor.
     *
     * @param cursor the cursor
     * @return the ListLogsOptions builder
     */
    public Builder cursor(String cursor) {
      this.cursor = cursor;
      return this;
    }
  }

  protected ListLogsOptions() {}

  protected ListLogsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    workspaceId = builder.workspaceId;
    sort = builder.sort;
    filter = builder.filter;
    pageLimit = builder.pageLimit;
    cursor = builder.cursor;
  }

  /**
   * New builder.
   *
   * @return a ListLogsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the workspaceId.
   *
   * <p>Unique identifier of the workspace.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the sort.
   *
   * <p>How to sort the returned log events. You can sort by **request_timestamp**. To reverse the
   * sort order, prefix the parameter value with a minus sign (`-`).
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }

  /**
   * Gets the filter.
   *
   * <p>A cacheable parameter that limits the results to those matching the specified filter. For
   * more information, see the
   * [documentation](https://cloud.ibm.com/docs/assistant?topic=assistant-filter-reference#filter-reference).
   *
   * @return the filter
   */
  public String filter() {
    return filter;
  }

  /**
   * Gets the pageLimit.
   *
   * <p>The number of records to return in each page of results.
   *
   * <p>**Note:** If the API is not returning your data, try lowering the page_limit value.
   *
   * @return the pageLimit
   */
  public Long pageLimit() {
    return pageLimit;
  }

  /**
   * Gets the cursor.
   *
   * <p>A token identifying the page of results to retrieve.
   *
   * @return the cursor
   */
  public String cursor() {
    return cursor;
  }
}

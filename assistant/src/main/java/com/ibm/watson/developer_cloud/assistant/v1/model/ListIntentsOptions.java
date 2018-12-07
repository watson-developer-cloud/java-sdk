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
package com.ibm.watson.developer_cloud.assistant.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The listIntents options.
 */
public class ListIntentsOptions extends GenericModel {

  /**
   * The attribute by which returned intents will be sorted. To reverse the sort order, prefix the value with a minus
   * sign (`-`).
   */
  public interface Sort {
    /** intent. */
    String INTENT = "intent";
    /** updated. */
    String UPDATED = "updated";
  }

  private String workspaceId;
  private Boolean export;
  private Long pageLimit;
  private Boolean includeCount;
  private String sort;
  private String cursor;
  private Boolean includeAudit;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private Boolean export;
    private Long pageLimit;
    private Boolean includeCount;
    private String sort;
    private String cursor;
    private Boolean includeAudit;

    private Builder(ListIntentsOptions listIntentsOptions) {
      workspaceId = listIntentsOptions.workspaceId;
      export = listIntentsOptions.export;
      pageLimit = listIntentsOptions.pageLimit;
      includeCount = listIntentsOptions.includeCount;
      sort = listIntentsOptions.sort;
      cursor = listIntentsOptions.cursor;
      includeAudit = listIntentsOptions.includeAudit;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     */
    public Builder(String workspaceId) {
      this.workspaceId = workspaceId;
    }

    /**
     * Builds a ListIntentsOptions.
     *
     * @return the listIntentsOptions
     */
    public ListIntentsOptions build() {
      return new ListIntentsOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the ListIntentsOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the export.
     *
     * @param export the export
     * @return the ListIntentsOptions builder
     */
    public Builder export(Boolean export) {
      this.export = export;
      return this;
    }

    /**
     * Set the pageLimit.
     *
     * @param pageLimit the pageLimit
     * @return the ListIntentsOptions builder
     */
    public Builder pageLimit(long pageLimit) {
      this.pageLimit = pageLimit;
      return this;
    }

    /**
     * Set the includeCount.
     *
     * @param includeCount the includeCount
     * @return the ListIntentsOptions builder
     */
    public Builder includeCount(Boolean includeCount) {
      this.includeCount = includeCount;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListIntentsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the cursor.
     *
     * @param cursor the cursor
     * @return the ListIntentsOptions builder
     */
    public Builder cursor(String cursor) {
      this.cursor = cursor;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the ListIntentsOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  private ListIntentsOptions(Builder builder) {
    Validator.notEmpty(builder.workspaceId, "workspaceId cannot be empty");
    workspaceId = builder.workspaceId;
    export = builder.export;
    pageLimit = builder.pageLimit;
    includeCount = builder.includeCount;
    sort = builder.sort;
    cursor = builder.cursor;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a ListIntentsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the workspaceId.
   *
   * Unique identifier of the workspace.
   *
   * @return the workspaceId
   */
  public String workspaceId() {
    return workspaceId;
  }

  /**
   * Gets the export.
   *
   * Whether to include all element content in the returned data. If **export**=`false`, the returned data includes only
   * information about the element itself. If **export**=`true`, all content, including subelements, is included.
   *
   * @return the export
   */
  public Boolean export() {
    return export;
  }

  /**
   * Gets the pageLimit.
   *
   * The number of records to return in each page of results.
   *
   * @return the pageLimit
   */
  public Long pageLimit() {
    return pageLimit;
  }

  /**
   * Gets the includeCount.
   *
   * Whether to include information about the number of records returned.
   *
   * @return the includeCount
   */
  public Boolean includeCount() {
    return includeCount;
  }

  /**
   * Gets the sort.
   *
   * The attribute by which returned intents will be sorted. To reverse the sort order, prefix the value with a minus
   * sign (`-`).
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }

  /**
   * Gets the cursor.
   *
   * A token identifying the page of results to retrieve.
   *
   * @return the cursor
   */
  public String cursor() {
    return cursor;
  }

  /**
   * Gets the includeAudit.
   *
   * Whether to include the audit properties (`created` and `updated` timestamps) in the response.
   *
   * @return the includeAudit
   */
  public Boolean includeAudit() {
    return includeAudit;
  }
}

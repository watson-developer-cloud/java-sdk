/*
 * (C) Copyright IBM Corp. 2020.
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

/**
 * The listCounterexamples options.
 */
public class ListCounterexamplesOptions extends GenericModel {

  /**
   * The attribute by which returned counterexamples will be sorted. To reverse the sort order, prefix the value with a
   * minus sign (`-`).
   */
  public interface Sort {
    /** text. */
    String TEXT = "text";
    /** updated. */
    String UPDATED = "updated";
  }

  protected String workspaceId;
  protected Long pageLimit;
  protected String sort;
  protected String cursor;
  protected Boolean includeAudit;

  /**
   * Builder.
   */
  public static class Builder {
    private String workspaceId;
    private Long pageLimit;
    private String sort;
    private String cursor;
    private Boolean includeAudit;

    private Builder(ListCounterexamplesOptions listCounterexamplesOptions) {
      this.workspaceId = listCounterexamplesOptions.workspaceId;
      this.pageLimit = listCounterexamplesOptions.pageLimit;
      this.sort = listCounterexamplesOptions.sort;
      this.cursor = listCounterexamplesOptions.cursor;
      this.includeAudit = listCounterexamplesOptions.includeAudit;
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
     * Builds a ListCounterexamplesOptions.
     *
     * @return the listCounterexamplesOptions
     */
    public ListCounterexamplesOptions build() {
      return new ListCounterexamplesOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the ListCounterexamplesOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the pageLimit.
     *
     * @param pageLimit the pageLimit
     * @return the ListCounterexamplesOptions builder
     */
    public Builder pageLimit(long pageLimit) {
      this.pageLimit = pageLimit;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListCounterexamplesOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the cursor.
     *
     * @param cursor the cursor
     * @return the ListCounterexamplesOptions builder
     */
    public Builder cursor(String cursor) {
      this.cursor = cursor;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the ListCounterexamplesOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected ListCounterexamplesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.workspaceId,
        "workspaceId cannot be empty");
    workspaceId = builder.workspaceId;
    pageLimit = builder.pageLimit;
    sort = builder.sort;
    cursor = builder.cursor;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a ListCounterexamplesOptions builder
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
   * Gets the sort.
   *
   * The attribute by which returned counterexamples will be sorted. To reverse the sort order, prefix the value with a
   * minus sign (`-`).
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

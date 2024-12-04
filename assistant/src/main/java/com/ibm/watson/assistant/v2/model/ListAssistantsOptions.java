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

package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The listAssistants options. */
public class ListAssistantsOptions extends GenericModel {

  /**
   * The attribute by which returned assistants will be sorted. To reverse the sort order, prefix
   * the value with a minus sign (`-`).
   */
  public interface Sort {
    /** name. */
    String NAME = "name";
    /** updated. */
    String UPDATED = "updated";
  }

  protected Long pageLimit;
  protected Boolean includeCount;
  protected String sort;
  protected String cursor;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private Long pageLimit;
    private Boolean includeCount;
    private String sort;
    private String cursor;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing ListAssistantsOptions instance.
     *
     * @param listAssistantsOptions the instance to initialize the Builder with
     */
    private Builder(ListAssistantsOptions listAssistantsOptions) {
      this.pageLimit = listAssistantsOptions.pageLimit;
      this.includeCount = listAssistantsOptions.includeCount;
      this.sort = listAssistantsOptions.sort;
      this.cursor = listAssistantsOptions.cursor;
      this.includeAudit = listAssistantsOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ListAssistantsOptions.
     *
     * @return the new ListAssistantsOptions instance
     */
    public ListAssistantsOptions build() {
      return new ListAssistantsOptions(this);
    }

    /**
     * Set the pageLimit.
     *
     * @param pageLimit the pageLimit
     * @return the ListAssistantsOptions builder
     */
    public Builder pageLimit(long pageLimit) {
      this.pageLimit = pageLimit;
      return this;
    }

    /**
     * Set the includeCount.
     *
     * @param includeCount the includeCount
     * @return the ListAssistantsOptions builder
     */
    public Builder includeCount(Boolean includeCount) {
      this.includeCount = includeCount;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListAssistantsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the cursor.
     *
     * @param cursor the cursor
     * @return the ListAssistantsOptions builder
     */
    public Builder cursor(String cursor) {
      this.cursor = cursor;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the ListAssistantsOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected ListAssistantsOptions() {}

  protected ListAssistantsOptions(Builder builder) {
    pageLimit = builder.pageLimit;
    includeCount = builder.includeCount;
    sort = builder.sort;
    cursor = builder.cursor;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a ListAssistantsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the pageLimit.
   *
   * <p>The number of records to return in each page of results.
   *
   * @return the pageLimit
   */
  public Long pageLimit() {
    return pageLimit;
  }

  /**
   * Gets the includeCount.
   *
   * <p>Whether to include information about the number of records that satisfy the request,
   * regardless of the page limit. If this parameter is `true`, the `pagination` object in the
   * response includes the `total` property.
   *
   * @return the includeCount
   */
  public Boolean includeCount() {
    return includeCount;
  }

  /**
   * Gets the sort.
   *
   * <p>The attribute by which returned assistants will be sorted. To reverse the sort order, prefix
   * the value with a minus sign (`-`).
   *
   * @return the sort
   */
  public String sort() {
    return sort;
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

  /**
   * Gets the includeAudit.
   *
   * <p>Whether to include the audit properties (`created` and `updated` timestamps) in the
   * response.
   *
   * @return the includeAudit
   */
  public Boolean includeAudit() {
    return includeAudit;
  }
}

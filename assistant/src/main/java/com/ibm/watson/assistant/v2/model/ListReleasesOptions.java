/*
 * (C) Copyright IBM Corp. 2022, 2024.
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

/** The listReleases options. */
public class ListReleasesOptions extends GenericModel {

  /**
   * The attribute by which returned workspaces will be sorted. To reverse the sort order, prefix
   * the value with a minus sign (`-`).
   */
  public interface Sort {
    /** name. */
    String NAME = "name";
    /** updated. */
    String UPDATED = "updated";
  }

  protected String assistantId;
  protected Long pageLimit;
  protected Boolean includeCount;
  protected String sort;
  protected String cursor;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String assistantId;
    private Long pageLimit;
    private Boolean includeCount;
    private String sort;
    private String cursor;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing ListReleasesOptions instance.
     *
     * @param listReleasesOptions the instance to initialize the Builder with
     */
    private Builder(ListReleasesOptions listReleasesOptions) {
      this.assistantId = listReleasesOptions.assistantId;
      this.pageLimit = listReleasesOptions.pageLimit;
      this.includeCount = listReleasesOptions.includeCount;
      this.sort = listReleasesOptions.sort;
      this.cursor = listReleasesOptions.cursor;
      this.includeAudit = listReleasesOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param assistantId the assistantId
     */
    public Builder(String assistantId) {
      this.assistantId = assistantId;
    }

    /**
     * Builds a ListReleasesOptions.
     *
     * @return the new ListReleasesOptions instance
     */
    public ListReleasesOptions build() {
      return new ListReleasesOptions(this);
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the ListReleasesOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }

    /**
     * Set the pageLimit.
     *
     * @param pageLimit the pageLimit
     * @return the ListReleasesOptions builder
     */
    public Builder pageLimit(long pageLimit) {
      this.pageLimit = pageLimit;
      return this;
    }

    /**
     * Set the includeCount.
     *
     * @param includeCount the includeCount
     * @return the ListReleasesOptions builder
     */
    public Builder includeCount(Boolean includeCount) {
      this.includeCount = includeCount;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListReleasesOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the cursor.
     *
     * @param cursor the cursor
     * @return the ListReleasesOptions builder
     */
    public Builder cursor(String cursor) {
      this.cursor = cursor;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the ListReleasesOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected ListReleasesOptions() {}

  protected ListReleasesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.assistantId, "assistantId cannot be empty");
    assistantId = builder.assistantId;
    pageLimit = builder.pageLimit;
    includeCount = builder.includeCount;
    sort = builder.sort;
    cursor = builder.cursor;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a ListReleasesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assistantId.
   *
   * <p>The assistant ID or the environment ID of the environment where the assistant is deployed,
   * depending on the type of request: - For message, session, and log requests, specify the
   * environment ID of the environment where the assistant is deployed. - For all other requests,
   * specify the assistant ID of the assistant.
   *
   * <p>To find the environment ID or assistant ID in the watsonx Assistant user interface, open the
   * assistant settings and scroll to the **Environments** section.
   *
   * <p>**Note:** If you are using the classic Watson Assistant experience, always use the assistant
   * ID. To find the assistant ID in the user interface, open the assistant settings and click API
   * Details.
   *
   * @return the assistantId
   */
  public String assistantId() {
    return assistantId;
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
   * <p>The attribute by which returned workspaces will be sorted. To reverse the sort order, prefix
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

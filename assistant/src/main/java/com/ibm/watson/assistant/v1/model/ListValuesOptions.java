/*
 * (C) Copyright IBM Corp. 2017, 2023.
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

/** The listValues options. */
public class ListValuesOptions extends GenericModel {

  /**
   * The attribute by which returned entity values will be sorted. To reverse the sort order, prefix
   * the value with a minus sign (`-`).
   */
  public interface Sort {
    /** value. */
    String VALUE = "value";
    /** updated. */
    String UPDATED = "updated";
  }

  protected String workspaceId;
  protected String entity;
  protected Boolean export;
  protected Long pageLimit;
  protected Boolean includeCount;
  protected String sort;
  protected String cursor;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String entity;
    private Boolean export;
    private Long pageLimit;
    private Boolean includeCount;
    private String sort;
    private String cursor;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing ListValuesOptions instance.
     *
     * @param listValuesOptions the instance to initialize the Builder with
     */
    private Builder(ListValuesOptions listValuesOptions) {
      this.workspaceId = listValuesOptions.workspaceId;
      this.entity = listValuesOptions.entity;
      this.export = listValuesOptions.export;
      this.pageLimit = listValuesOptions.pageLimit;
      this.includeCount = listValuesOptions.includeCount;
      this.sort = listValuesOptions.sort;
      this.cursor = listValuesOptions.cursor;
      this.includeAudit = listValuesOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     * @param entity the entity
     */
    public Builder(String workspaceId, String entity) {
      this.workspaceId = workspaceId;
      this.entity = entity;
    }

    /**
     * Builds a ListValuesOptions.
     *
     * @return the new ListValuesOptions instance
     */
    public ListValuesOptions build() {
      return new ListValuesOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the ListValuesOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return the ListValuesOptions builder
     */
    public Builder entity(String entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the export.
     *
     * @param export the export
     * @return the ListValuesOptions builder
     */
    public Builder export(Boolean export) {
      this.export = export;
      return this;
    }

    /**
     * Set the pageLimit.
     *
     * @param pageLimit the pageLimit
     * @return the ListValuesOptions builder
     */
    public Builder pageLimit(long pageLimit) {
      this.pageLimit = pageLimit;
      return this;
    }

    /**
     * Set the includeCount.
     *
     * @param includeCount the includeCount
     * @return the ListValuesOptions builder
     */
    public Builder includeCount(Boolean includeCount) {
      this.includeCount = includeCount;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListValuesOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the cursor.
     *
     * @param cursor the cursor
     * @return the ListValuesOptions builder
     */
    public Builder cursor(String cursor) {
      this.cursor = cursor;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the ListValuesOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected ListValuesOptions() {}

  protected ListValuesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.entity, "entity cannot be empty");
    workspaceId = builder.workspaceId;
    entity = builder.entity;
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
   * @return a ListValuesOptions builder
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
   * Gets the entity.
   *
   * <p>The name of the entity.
   *
   * @return the entity
   */
  public String entity() {
    return entity;
  }

  /**
   * Gets the export.
   *
   * <p>Whether to include all element content in the returned data. If **export**=`false`, the
   * returned data includes only information about the element itself. If **export**=`true`, all
   * content, including subelements, is included.
   *
   * @return the export
   */
  public Boolean export() {
    return export;
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
   * <p>The attribute by which returned entity values will be sorted. To reverse the sort order,
   * prefix the value with a minus sign (`-`).
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

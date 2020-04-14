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

/** The listSynonyms options. */
public class ListSynonymsOptions extends GenericModel {

  /**
   * The attribute by which returned entity value synonyms will be sorted. To reverse the sort
   * order, prefix the value with a minus sign (`-`).
   */
  public interface Sort {
    /** synonym. */
    String SYNONYM = "synonym";
    /** updated. */
    String UPDATED = "updated";
  }

  protected String workspaceId;
  protected String entity;
  protected String value;
  protected Long pageLimit;
  protected String sort;
  protected String cursor;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String workspaceId;
    private String entity;
    private String value;
    private Long pageLimit;
    private String sort;
    private String cursor;
    private Boolean includeAudit;

    private Builder(ListSynonymsOptions listSynonymsOptions) {
      this.workspaceId = listSynonymsOptions.workspaceId;
      this.entity = listSynonymsOptions.entity;
      this.value = listSynonymsOptions.value;
      this.pageLimit = listSynonymsOptions.pageLimit;
      this.sort = listSynonymsOptions.sort;
      this.cursor = listSynonymsOptions.cursor;
      this.includeAudit = listSynonymsOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param workspaceId the workspaceId
     * @param entity the entity
     * @param value the value
     */
    public Builder(String workspaceId, String entity, String value) {
      this.workspaceId = workspaceId;
      this.entity = entity;
      this.value = value;
    }

    /**
     * Builds a ListSynonymsOptions.
     *
     * @return the listSynonymsOptions
     */
    public ListSynonymsOptions build() {
      return new ListSynonymsOptions(this);
    }

    /**
     * Set the workspaceId.
     *
     * @param workspaceId the workspaceId
     * @return the ListSynonymsOptions builder
     */
    public Builder workspaceId(String workspaceId) {
      this.workspaceId = workspaceId;
      return this;
    }

    /**
     * Set the entity.
     *
     * @param entity the entity
     * @return the ListSynonymsOptions builder
     */
    public Builder entity(String entity) {
      this.entity = entity;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the ListSynonymsOptions builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the pageLimit.
     *
     * @param pageLimit the pageLimit
     * @return the ListSynonymsOptions builder
     */
    public Builder pageLimit(long pageLimit) {
      this.pageLimit = pageLimit;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListSynonymsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the cursor.
     *
     * @param cursor the cursor
     * @return the ListSynonymsOptions builder
     */
    public Builder cursor(String cursor) {
      this.cursor = cursor;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the ListSynonymsOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected ListSynonymsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.workspaceId, "workspaceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.entity, "entity cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.value, "value cannot be empty");
    workspaceId = builder.workspaceId;
    entity = builder.entity;
    value = builder.value;
    pageLimit = builder.pageLimit;
    sort = builder.sort;
    cursor = builder.cursor;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a ListSynonymsOptions builder
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
   * Gets the value.
   *
   * <p>The text of the entity value.
   *
   * @return the value
   */
  public String value() {
    return value;
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
   * Gets the sort.
   *
   * <p>The attribute by which returned entity value synonyms will be sorted. To reverse the sort
   * order, prefix the value with a minus sign (`-`).
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

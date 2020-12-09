/*
 * (C) Copyright IBM Corp. 2018, 2020.
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
package com.ibm.watson.compare_comply.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The listFeedback options. */
public class ListFeedbackOptions extends GenericModel {

  protected String feedbackType;
  protected String documentTitle;
  protected String modelId;
  protected String modelVersion;
  protected String categoryRemoved;
  protected String categoryAdded;
  protected String categoryNotChanged;
  protected String typeRemoved;
  protected String typeAdded;
  protected String typeNotChanged;
  protected Long pageLimit;
  protected String cursor;
  protected String sort;
  protected Boolean includeTotal;

  /** Builder. */
  public static class Builder {
    private String feedbackType;
    private String documentTitle;
    private String modelId;
    private String modelVersion;
    private String categoryRemoved;
    private String categoryAdded;
    private String categoryNotChanged;
    private String typeRemoved;
    private String typeAdded;
    private String typeNotChanged;
    private Long pageLimit;
    private String cursor;
    private String sort;
    private Boolean includeTotal;

    private Builder(ListFeedbackOptions listFeedbackOptions) {
      this.feedbackType = listFeedbackOptions.feedbackType;
      this.documentTitle = listFeedbackOptions.documentTitle;
      this.modelId = listFeedbackOptions.modelId;
      this.modelVersion = listFeedbackOptions.modelVersion;
      this.categoryRemoved = listFeedbackOptions.categoryRemoved;
      this.categoryAdded = listFeedbackOptions.categoryAdded;
      this.categoryNotChanged = listFeedbackOptions.categoryNotChanged;
      this.typeRemoved = listFeedbackOptions.typeRemoved;
      this.typeAdded = listFeedbackOptions.typeAdded;
      this.typeNotChanged = listFeedbackOptions.typeNotChanged;
      this.pageLimit = listFeedbackOptions.pageLimit;
      this.cursor = listFeedbackOptions.cursor;
      this.sort = listFeedbackOptions.sort;
      this.includeTotal = listFeedbackOptions.includeTotal;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ListFeedbackOptions.
     *
     * @return the new ListFeedbackOptions instance
     */
    public ListFeedbackOptions build() {
      return new ListFeedbackOptions(this);
    }

    /**
     * Set the feedbackType.
     *
     * @param feedbackType the feedbackType
     * @return the ListFeedbackOptions builder
     */
    public Builder feedbackType(String feedbackType) {
      this.feedbackType = feedbackType;
      return this;
    }

    /**
     * Set the documentTitle.
     *
     * @param documentTitle the documentTitle
     * @return the ListFeedbackOptions builder
     */
    public Builder documentTitle(String documentTitle) {
      this.documentTitle = documentTitle;
      return this;
    }

    /**
     * Set the modelId.
     *
     * @param modelId the modelId
     * @return the ListFeedbackOptions builder
     */
    public Builder modelId(String modelId) {
      this.modelId = modelId;
      return this;
    }

    /**
     * Set the modelVersion.
     *
     * @param modelVersion the modelVersion
     * @return the ListFeedbackOptions builder
     */
    public Builder modelVersion(String modelVersion) {
      this.modelVersion = modelVersion;
      return this;
    }

    /**
     * Set the categoryRemoved.
     *
     * @param categoryRemoved the categoryRemoved
     * @return the ListFeedbackOptions builder
     */
    public Builder categoryRemoved(String categoryRemoved) {
      this.categoryRemoved = categoryRemoved;
      return this;
    }

    /**
     * Set the categoryAdded.
     *
     * @param categoryAdded the categoryAdded
     * @return the ListFeedbackOptions builder
     */
    public Builder categoryAdded(String categoryAdded) {
      this.categoryAdded = categoryAdded;
      return this;
    }

    /**
     * Set the categoryNotChanged.
     *
     * @param categoryNotChanged the categoryNotChanged
     * @return the ListFeedbackOptions builder
     */
    public Builder categoryNotChanged(String categoryNotChanged) {
      this.categoryNotChanged = categoryNotChanged;
      return this;
    }

    /**
     * Set the typeRemoved.
     *
     * @param typeRemoved the typeRemoved
     * @return the ListFeedbackOptions builder
     */
    public Builder typeRemoved(String typeRemoved) {
      this.typeRemoved = typeRemoved;
      return this;
    }

    /**
     * Set the typeAdded.
     *
     * @param typeAdded the typeAdded
     * @return the ListFeedbackOptions builder
     */
    public Builder typeAdded(String typeAdded) {
      this.typeAdded = typeAdded;
      return this;
    }

    /**
     * Set the typeNotChanged.
     *
     * @param typeNotChanged the typeNotChanged
     * @return the ListFeedbackOptions builder
     */
    public Builder typeNotChanged(String typeNotChanged) {
      this.typeNotChanged = typeNotChanged;
      return this;
    }

    /**
     * Set the pageLimit.
     *
     * @param pageLimit the pageLimit
     * @return the ListFeedbackOptions builder
     */
    public Builder pageLimit(long pageLimit) {
      this.pageLimit = pageLimit;
      return this;
    }

    /**
     * Set the cursor.
     *
     * @param cursor the cursor
     * @return the ListFeedbackOptions builder
     */
    public Builder cursor(String cursor) {
      this.cursor = cursor;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListFeedbackOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the includeTotal.
     *
     * @param includeTotal the includeTotal
     * @return the ListFeedbackOptions builder
     */
    public Builder includeTotal(Boolean includeTotal) {
      this.includeTotal = includeTotal;
      return this;
    }
  }

  protected ListFeedbackOptions(Builder builder) {
    feedbackType = builder.feedbackType;
    documentTitle = builder.documentTitle;
    modelId = builder.modelId;
    modelVersion = builder.modelVersion;
    categoryRemoved = builder.categoryRemoved;
    categoryAdded = builder.categoryAdded;
    categoryNotChanged = builder.categoryNotChanged;
    typeRemoved = builder.typeRemoved;
    typeAdded = builder.typeAdded;
    typeNotChanged = builder.typeNotChanged;
    pageLimit = builder.pageLimit;
    cursor = builder.cursor;
    sort = builder.sort;
    includeTotal = builder.includeTotal;
  }

  /**
   * New builder.
   *
   * @return a ListFeedbackOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the feedbackType.
   *
   * <p>An optional string that filters the output to include only feedback with the specified
   * feedback type. The only permitted value is `element_classification`.
   *
   * @return the feedbackType
   */
  public String feedbackType() {
    return feedbackType;
  }

  /**
   * Gets the documentTitle.
   *
   * <p>An optional string that filters the output to include only feedback from the document with
   * the specified `document_title`.
   *
   * @return the documentTitle
   */
  public String documentTitle() {
    return documentTitle;
  }

  /**
   * Gets the modelId.
   *
   * <p>An optional string that filters the output to include only feedback with the specified
   * `model_id`. The only permitted value is `contracts`.
   *
   * @return the modelId
   */
  public String modelId() {
    return modelId;
  }

  /**
   * Gets the modelVersion.
   *
   * <p>An optional string that filters the output to include only feedback with the specified
   * `model_version`.
   *
   * @return the modelVersion
   */
  public String modelVersion() {
    return modelVersion;
  }

  /**
   * Gets the categoryRemoved.
   *
   * <p>An optional string in the form of a comma-separated list of categories. If it is specified,
   * the service filters the output to include only feedback that has at least one category from the
   * list removed.
   *
   * @return the categoryRemoved
   */
  public String categoryRemoved() {
    return categoryRemoved;
  }

  /**
   * Gets the categoryAdded.
   *
   * <p>An optional string in the form of a comma-separated list of categories. If this is
   * specified, the service filters the output to include only feedback that has at least one
   * category from the list added.
   *
   * @return the categoryAdded
   */
  public String categoryAdded() {
    return categoryAdded;
  }

  /**
   * Gets the categoryNotChanged.
   *
   * <p>An optional string in the form of a comma-separated list of categories. If this is
   * specified, the service filters the output to include only feedback that has at least one
   * category from the list unchanged.
   *
   * @return the categoryNotChanged
   */
  public String categoryNotChanged() {
    return categoryNotChanged;
  }

  /**
   * Gets the typeRemoved.
   *
   * <p>An optional string of comma-separated `nature`:`party` pairs. If this is specified, the
   * service filters the output to include only feedback that has at least one `nature`:`party` pair
   * from the list removed.
   *
   * @return the typeRemoved
   */
  public String typeRemoved() {
    return typeRemoved;
  }

  /**
   * Gets the typeAdded.
   *
   * <p>An optional string of comma-separated `nature`:`party` pairs. If this is specified, the
   * service filters the output to include only feedback that has at least one `nature`:`party` pair
   * from the list removed.
   *
   * @return the typeAdded
   */
  public String typeAdded() {
    return typeAdded;
  }

  /**
   * Gets the typeNotChanged.
   *
   * <p>An optional string of comma-separated `nature`:`party` pairs. If this is specified, the
   * service filters the output to include only feedback that has at least one `nature`:`party` pair
   * from the list unchanged.
   *
   * @return the typeNotChanged
   */
  public String typeNotChanged() {
    return typeNotChanged;
  }

  /**
   * Gets the pageLimit.
   *
   * <p>An optional integer specifying the number of documents that you want the service to return.
   *
   * @return the pageLimit
   */
  public Long pageLimit() {
    return pageLimit;
  }

  /**
   * Gets the cursor.
   *
   * <p>An optional string that returns the set of documents after the previous set. Use this
   * parameter with the `page_limit` parameter.
   *
   * @return the cursor
   */
  public String cursor() {
    return cursor;
  }

  /**
   * Gets the sort.
   *
   * <p>An optional comma-separated list of fields in the document to sort on. You can optionally
   * specify the sort direction by prefixing the value of the field with `-` for descending order or
   * `+` for ascending order (the default). Currently permitted sorting fields are `created`,
   * `user_id`, and `document_title`.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }

  /**
   * Gets the includeTotal.
   *
   * <p>An optional boolean value. If specified as `true`, the `pagination` object in the output
   * includes a value called `total` that gives the total count of feedback created.
   *
   * @return the includeTotal
   */
  public Boolean includeTotal() {
    return includeTotal;
  }
}

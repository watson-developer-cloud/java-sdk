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
package com.ibm.watson.developer_cloud.compare_comply.v1.model;

import java.util.Date;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The listFeedback options.
 */
public class ListFeedbackOptions extends GenericModel {

  private String feedbackType;
  private Date before;
  private Date after;
  private String documentTitle;
  private String modelId;
  private String modelVersion;
  private String categoryRemoved;
  private String categoryAdded;
  private String categoryUnchanged;
  private String typeRemoved;
  private String typeAdded;
  private String typeUnchanged;
  private Long count;
  private Long offset;
  private String sort;

  /**
   * Builder.
   */
  public static class Builder {
    private String feedbackType;
    private Date before;
    private Date after;
    private String documentTitle;
    private String modelId;
    private String modelVersion;
    private String categoryRemoved;
    private String categoryAdded;
    private String categoryUnchanged;
    private String typeRemoved;
    private String typeAdded;
    private String typeUnchanged;
    private Long count;
    private Long offset;
    private String sort;

    private Builder(ListFeedbackOptions listFeedbackOptions) {
      feedbackType = listFeedbackOptions.feedbackType;
      before = listFeedbackOptions.before;
      after = listFeedbackOptions.after;
      documentTitle = listFeedbackOptions.documentTitle;
      modelId = listFeedbackOptions.modelId;
      modelVersion = listFeedbackOptions.modelVersion;
      categoryRemoved = listFeedbackOptions.categoryRemoved;
      categoryAdded = listFeedbackOptions.categoryAdded;
      categoryUnchanged = listFeedbackOptions.categoryUnchanged;
      typeRemoved = listFeedbackOptions.typeRemoved;
      typeAdded = listFeedbackOptions.typeAdded;
      typeUnchanged = listFeedbackOptions.typeUnchanged;
      count = listFeedbackOptions.count;
      offset = listFeedbackOptions.offset;
      sort = listFeedbackOptions.sort;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListFeedbackOptions.
     *
     * @return the listFeedbackOptions
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
     * Set the before.
     *
     * @param before the before
     * @return the ListFeedbackOptions builder
     */
    public Builder before(Date before) {
      this.before = before;
      return this;
    }

    /**
     * Set the after.
     *
     * @param after the after
     * @return the ListFeedbackOptions builder
     */
    public Builder after(Date after) {
      this.after = after;
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
     * Set the categoryUnchanged.
     *
     * @param categoryUnchanged the categoryUnchanged
     * @return the ListFeedbackOptions builder
     */
    public Builder categoryUnchanged(String categoryUnchanged) {
      this.categoryUnchanged = categoryUnchanged;
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
     * Set the typeUnchanged.
     *
     * @param typeUnchanged the typeUnchanged
     * @return the ListFeedbackOptions builder
     */
    public Builder typeUnchanged(String typeUnchanged) {
      this.typeUnchanged = typeUnchanged;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the ListFeedbackOptions builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the ListFeedbackOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
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
  }

  private ListFeedbackOptions(Builder builder) {
    feedbackType = builder.feedbackType;
    before = builder.before;
    after = builder.after;
    documentTitle = builder.documentTitle;
    modelId = builder.modelId;
    modelVersion = builder.modelVersion;
    categoryRemoved = builder.categoryRemoved;
    categoryAdded = builder.categoryAdded;
    categoryUnchanged = builder.categoryUnchanged;
    typeRemoved = builder.typeRemoved;
    typeAdded = builder.typeAdded;
    typeUnchanged = builder.typeUnchanged;
    count = builder.count;
    offset = builder.offset;
    sort = builder.sort;
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
   * An optional string that filters the output to include only feedback with the specified feedback type. The only
   * permitted value is `element_classification`.
   *
   * @return the feedbackType
   */
  public String feedbackType() {
    return feedbackType;
  }

  /**
   * Gets the before.
   *
   * An optional string in the format `YYYY-MM-DD` that filters the output to include only feedback that was added
   * before the specified date.
   *
   * @return the before
   */
  public Date before() {
    return before;
  }

  /**
   * Gets the after.
   *
   * An optional string in the format `YYYY-MM-DD` that filters the output to include only feedback that was added after
   * the specified date.
   *
   * @return the after
   */
  public Date after() {
    return after;
  }

  /**
   * Gets the documentTitle.
   *
   * An optional string that filters the output to include only feedback from the document with the specified
   * `document_title`.
   *
   * @return the documentTitle
   */
  public String documentTitle() {
    return documentTitle;
  }

  /**
   * Gets the modelId.
   *
   * An optional string that filters the output to include only feedback with the specified `model_id`. The only
   * permitted value is `contracts`.
   *
   * @return the modelId
   */
  public String modelId() {
    return modelId;
  }

  /**
   * Gets the modelVersion.
   *
   * An optional string that filters the output to include only feedback with the specified `model_version`.
   *
   * @return the modelVersion
   */
  public String modelVersion() {
    return modelVersion;
  }

  /**
   * Gets the categoryRemoved.
   *
   * An optional string in the form of a comma-separated list of categories. If this is specified, the service filters
   * the output to include only feedback that has at least one category from the list removed.
   *
   * @return the categoryRemoved
   */
  public String categoryRemoved() {
    return categoryRemoved;
  }

  /**
   * Gets the categoryAdded.
   *
   * An optional string in the form of a comma-separated list of categories. If this is specified, the service filters
   * the output to include only feedback that has at least one category from the list added.
   *
   * @return the categoryAdded
   */
  public String categoryAdded() {
    return categoryAdded;
  }

  /**
   * Gets the categoryUnchanged.
   *
   * An optional string in the form of a comma-separated list of categories. If this is specified, the service filters
   * the output to include only feedback that has at least one category from the list unchanged.
   *
   * @return the categoryUnchanged
   */
  public String categoryUnchanged() {
    return categoryUnchanged;
  }

  /**
   * Gets the typeRemoved.
   *
   * An optional string of comma-separated `nature`:`party` pairs. If this is specified, the service filters the output
   * to include only feedback that has at least one `nature`:`party` pair from the list removed.
   *
   * @return the typeRemoved
   */
  public String typeRemoved() {
    return typeRemoved;
  }

  /**
   * Gets the typeAdded.
   *
   * An optional string of comma-separated `nature`:`party` pairs. If this is specified, the service filters the output
   * to include only feedback that has at least one `nature`:`party` pair from the list removed.
   *
   * @return the typeAdded
   */
  public String typeAdded() {
    return typeAdded;
  }

  /**
   * Gets the typeUnchanged.
   *
   * An optional string of comma-separated `nature`:`party` pairs. If this is specified, the service filters the output
   * to include only feedback that has at least one `nature`:`party` pair from the list unchanged.
   *
   * @return the typeUnchanged
   */
  public String typeUnchanged() {
    return typeUnchanged;
  }

  /**
   * Gets the count.
   *
   * An optional integer specifying the number of documents returned by the service. The default is `200`. The sum of
   * the `count` and `offset` values in any single query cannot exceed `10000`.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }

  /**
   * Gets the offset.
   *
   * An optional integer specifying the number of documents returned by the service. The default is `0`. The sum of the
   * `count` and `offset` values in any single query cannot exceed `10000`.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }

  /**
   * Gets the sort.
   *
   * An optional comma-separated list of fields in the document to sort on. You can optionally specify the sort
   * direction by prefixing the value of the field with `-` for descending order or `+` for ascending order (the
   * default). Currently permitted sorting fields are `created` and `document_title`.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }
}

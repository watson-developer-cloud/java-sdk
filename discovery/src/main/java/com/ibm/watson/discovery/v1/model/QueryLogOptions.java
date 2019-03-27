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
package com.ibm.watson.discovery.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The queryLog options.
 */
public class QueryLogOptions extends GenericModel {

  private String filter;
  private String query;
  private Long count;
  private Long offset;
  private List<String> sort;

  /**
   * Builder.
   */
  public static class Builder {
    private String filter;
    private String query;
    private Long count;
    private Long offset;
    private List<String> sort;

    private Builder(QueryLogOptions queryLogOptions) {
      this.filter = queryLogOptions.filter;
      this.query = queryLogOptions.query;
      this.count = queryLogOptions.count;
      this.offset = queryLogOptions.offset;
      this.sort = queryLogOptions.sort;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a QueryLogOptions.
     *
     * @return the queryLogOptions
     */
    public QueryLogOptions build() {
      return new QueryLogOptions(this);
    }

    /**
     * Adds an sort to sort.
     *
     * @param sort the new sort
     * @return the QueryLogOptions builder
     */
    public Builder addSort(String sort) {
      Validator.notNull(sort, "sort cannot be null");
      if (this.sort == null) {
        this.sort = new ArrayList<String>();
      }
      this.sort.add(sort);
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the QueryLogOptions builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the query.
     *
     * @param query the query
     * @return the QueryLogOptions builder
     */
    public Builder query(String query) {
      this.query = query;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the QueryLogOptions builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the QueryLogOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the sort.
     * Existing sort will be replaced.
     *
     * @param sort the sort
     * @return the QueryLogOptions builder
     */
    public Builder sort(List<String> sort) {
      this.sort = sort;
      return this;
    }
  }

  private QueryLogOptions(Builder builder) {
    filter = builder.filter;
    query = builder.query;
    count = builder.count;
    offset = builder.offset;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a QueryLogOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the filter.
   *
   * A cacheable query that excludes documents that don't mention the query content. Filter searches are better for
   * metadata-type searches and for assessing the concepts in the data set.
   *
   * @return the filter
   */
  public String filter() {
    return filter;
  }

  /**
   * Gets the query.
   *
   * A query search returns all documents in your data set with full enrichments and full text, but with the most
   * relevant documents listed first. Use a query search when you want to find the most relevant search results. You
   * cannot use **natural_language_query** and **query** at the same time.
   *
   * @return the query
   */
  public String query() {
    return query;
  }

  /**
   * Gets the count.
   *
   * Number of results to return. The maximum for the **count** and **offset** values together in any one query is
   * **10000**.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }

  /**
   * Gets the offset.
   *
   * The number of query results to skip at the beginning. For example, if the total number of results that are returned
   * is 10 and the offset is 8, it returns the last two results. The maximum for the **count** and **offset** values
   * together in any one query is **10000**.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }

  /**
   * Gets the sort.
   *
   * A comma-separated list of fields in the document to sort on. You can optionally specify a sort direction by
   * prefixing the field with `-` for descending or `+` for ascending. Ascending is the default sort direction if no
   * prefix is specified.
   *
   * @return the sort
   */
  public List<String> sort() {
    return sort;
  }
}

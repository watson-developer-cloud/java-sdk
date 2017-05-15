/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * the queryNotices options.
 */
public class QueryNoticesOptions extends GenericModel {

  /** the ID of your environment. */
  @SerializedName("environment_id")
  private String environmentId;
  /** the ID of your collection. */
  @SerializedName("collection_id")
  private String collectionId;
  /** A cacheable query that limits the documents returned to exclude any documents that don't mention the query
   * content. Filter searches are better for metadata type searches and when you are trying to get a sense of
   * concepts in the data set. */
  private String filter;
  /** A query search returns all documents in your data set with full enrichments and full text, but with the most
   * relevant documents listed first. Use a query search when you want to find the most relevant search results. You
   * cannot use `natural_language_query` and `query` at the same time. */
  private String query;
  /** A natural language query that returns relevant documents by utilizing training data and natural language
   * understanding. You cannot use `natural_language_query` and `query` at the same time. */
  @SerializedName("natural_language_query")
  private String naturalLanguageQuery;
  /** A passages query that returns the most relevant passages from the document. */
  private Boolean passages;
  /** An aggregation search uses combinations of filters and query search to return an exact answer. Aggregations are
   *  useful for building applications, because you can use them to build lists, tables, and time series. For a full
   *  list of possible aggregrations, see the Query reference. */
  private String aggregation;
  /** Number of documents to return. */
  private Long count;
  /** A comma separated list of the portion of the document hierarchy to return. */
  @SerializedName("return")
  private List<String> returnFields;
  /** The number of query results to skip at the beginning. For example, if the total number of results that are
   * returned is 10, and the offset is 8, it returns the last two results. */
  private Long offset;
  /** A comma separated list of fields in the document to sort on. You can optionally specify a sort direction by
   * prefixing the field with `-` for descending or `+` for ascending. Ascending is the default sort direction if no
   * prefix is specified. */
  private String sort;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String collectionId;
    private String filter;
    private String query;
    private String naturalLanguageQuery;
    private Boolean passages;
    private String aggregation;
    private Long count;
    private List<String> returnFields;
    private Long offset;
    private String sort;

    private Builder(QueryNoticesOptions queryNoticesOptions) {
      environmentId = queryNoticesOptions.environmentId;
      collectionId = queryNoticesOptions.collectionId;
      filter = queryNoticesOptions.filter;
      query = queryNoticesOptions.query;
      naturalLanguageQuery = queryNoticesOptions.naturalLanguageQuery;
      passages = queryNoticesOptions.passages;
      aggregation = queryNoticesOptions.aggregation;
      count = queryNoticesOptions.count;
      returnFields = queryNoticesOptions.returnFields;
      offset = queryNoticesOptions.offset;
      sort = queryNoticesOptions.sort;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     */
    public Builder(String environmentId, String collectionId) {
      this.environmentId = environmentId;
      this.collectionId = collectionId;
    }

    /**
     * Builds a QueryNoticesOptions.
     *
     * @return the queryNoticesOptions
     */
    public QueryNoticesOptions build() {
      return new QueryNoticesOptions(this);
    }

    /**
     * Adds an xreturn to returnFields.
     *
     * @param xreturn the new xreturn
     * @return the QueryNoticesOptions builder
     */
    public Builder addXreturn(String xreturn) {
      if (this.returnFields == null) {
        this.returnFields = new ArrayList<String>();
      }
      this.returnFields.add(xreturn);
      return this;
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the QueryNoticesOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the QueryNoticesOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the QueryNoticesOptions builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the query.
     *
     * @param query the query
     * @return the QueryNoticesOptions builder
     */
    public Builder query(String query) {
      this.query = query;
      return this;
    }

    /**
     * Set the naturalLanguageQuery.
     *
     * @param naturalLanguageQuery the naturalLanguageQuery
     * @return the QueryNoticesOptions builder
     */
    public Builder naturalLanguageQuery(String naturalLanguageQuery) {
      this.naturalLanguageQuery = naturalLanguageQuery;
      return this;
    }

    /**
     * Set the passages.
     *
     * @param passages the passages
     * @return the QueryNoticesOptions builder
     */
    public Builder passages(Boolean passages) {
      this.passages = passages;
      return this;
    }

    /**
     * Set the aggregation.
     *
     * @param aggregation the aggregation
     * @return the QueryNoticesOptions builder
     */
    public Builder aggregation(String aggregation) {
      this.aggregation = aggregation;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the QueryNoticesOptions builder
     */
    public Builder count(Long count) {
      this.count = count;
      return this;
    }

    /**
     * Set the returnFields.
     * Existing returnFields will be replaced.
     *
     * @param returnFields the returnFields
     * @return the QueryNoticesOptions builder
     */
    public Builder returnFields(List<String> returnFields) {
      this.returnFields = returnFields;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the QueryNoticesOptions builder
     */
    public Builder offset(Long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the QueryNoticesOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }
  }

  private QueryNoticesOptions(Builder builder) {
    Validator.notNull(builder.environmentId, "environmentId cannot be null");
    Validator.notNull(builder.collectionId, "collectionId cannot be null");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
    filter = builder.filter;
    query = builder.query;
    naturalLanguageQuery = builder.naturalLanguageQuery;
    passages = builder.passages;
    aggregation = builder.aggregation;
    count = builder.count;
    returnFields = builder.returnFields;
    offset = builder.offset;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a QueryNoticesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the collectionId.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the filter.
   *
   * @return the filter
   */
  public String filter() {
    return filter;
  }

  /**
   * Gets the query.
   *
   * @return the query
   */
  public String query() {
    return query;
  }

  /**
   * Gets the naturalLanguageQuery.
   *
   * @return the naturalLanguageQuery
   */
  public String naturalLanguageQuery() {
    return naturalLanguageQuery;
  }

  /**
   * Gets the passages.
   *
   * @return the passages
   */
  public Boolean passages() {
    return passages;
  }

  /**
   * Gets the aggregation.
   *
   * @return the aggregation
   */
  public String aggregation() {
    return aggregation;
  }

  /**
   * Gets the count.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }

  /**
   * Gets the returnFields.
   *
   * @return the returnFields
   */
  public List<String> returnFields() {
    return returnFields;
  }

  /**
   * Gets the offset.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }

  /**
   * Gets the sort.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }
}

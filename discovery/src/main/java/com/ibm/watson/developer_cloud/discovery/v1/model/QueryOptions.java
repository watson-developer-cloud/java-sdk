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

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The query options.
 */
public class QueryOptions extends GenericModel {

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
  private List<String> sort;
  private Boolean highlight;
  private List<String> passagesFields;
  private Long passagesCount;
  private Long passagesCharacters;
  private Boolean deduplicate;
  private String deduplicateField;

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
    private List<String> sort;
    private Boolean highlight;
    private List<String> passagesFields;
    private Long passagesCount;
    private Long passagesCharacters;
    private Boolean deduplicate;
    private String deduplicateField;

    private Builder(QueryOptions queryOptions) {
      environmentId = queryOptions.environmentId;
      collectionId = queryOptions.collectionId;
      filter = queryOptions.filter;
      query = queryOptions.query;
      naturalLanguageQuery = queryOptions.naturalLanguageQuery;
      passages = queryOptions.passages;
      aggregation = queryOptions.aggregation;
      count = queryOptions.count;
      returnFields = queryOptions.returnFields;
      offset = queryOptions.offset;
      sort = queryOptions.sort;
      highlight = queryOptions.highlight;
      passagesFields = queryOptions.passagesFields;
      passagesCount = queryOptions.passagesCount;
      passagesCharacters = queryOptions.passagesCharacters;
      deduplicate = queryOptions.deduplicate;
      deduplicateField = queryOptions.deduplicateField;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     * @param collectionId the collectionId
     */
    public Builder(String environmentId, String collectionId) {
      this.environmentId = environmentId;
      this.collectionId = collectionId;
    }

    /**
     * Builds a QueryOptions.
     *
     * @return the queryOptions
     */
    public QueryOptions build() {
      return new QueryOptions(this);
    }

    /**
     * Adds an returnField to returnFields.
     *
     * @param returnField the new returnField
     * @return the QueryOptions builder
     */
    public Builder addReturnField(String returnField) {
      Validator.notNull(returnField, "returnField cannot be null");
      if (this.returnFields == null) {
        this.returnFields = new ArrayList<String>();
      }
      this.returnFields.add(returnField);
      return this;
    }

    /**
     * Adds an sort to sort.
     *
     * @param sort the new sort
     * @return the QueryOptions builder
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
     * Adds an passagesFields to passagesFields.
     *
     * @param passagesFields the new passagesFields
     * @return the QueryOptions builder
     */
    public Builder addPassagesFields(String passagesFields) {
      Validator.notNull(passagesFields, "passagesFields cannot be null");
      if (this.passagesFields == null) {
        this.passagesFields = new ArrayList<String>();
      }
      this.passagesFields.add(passagesFields);
      return this;
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the QueryOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the QueryOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the QueryOptions builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the query.
     *
     * @param query the query
     * @return the QueryOptions builder
     */
    public Builder query(String query) {
      this.query = query;
      return this;
    }

    /**
     * Set the naturalLanguageQuery.
     *
     * @param naturalLanguageQuery the naturalLanguageQuery
     * @return the QueryOptions builder
     */
    public Builder naturalLanguageQuery(String naturalLanguageQuery) {
      this.naturalLanguageQuery = naturalLanguageQuery;
      return this;
    }

    /**
     * Set the passages.
     *
     * @param passages the passages
     * @return the QueryOptions builder
     */
    public Builder passages(Boolean passages) {
      this.passages = passages;
      return this;
    }

    /**
     * Set the aggregation.
     *
     * @param aggregation the aggregation
     * @return the QueryOptions builder
     */
    public Builder aggregation(String aggregation) {
      this.aggregation = aggregation;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the QueryOptions builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }

    /**
     * Set the returnFields.
     * Existing returnFields will be replaced.
     *
     * @param returnFields the returnFields
     * @return the QueryOptions builder
     */
    public Builder returnFields(List<String> returnFields) {
      this.returnFields = returnFields;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the QueryOptions builder
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
     * @return the QueryOptions builder
     */
    public Builder sort(List<String> sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the highlight.
     *
     * @param highlight the highlight
     * @return the QueryOptions builder
     */
    public Builder highlight(Boolean highlight) {
      this.highlight = highlight;
      return this;
    }

    /**
     * Set the passagesFields.
     * Existing passagesFields will be replaced.
     *
     * @param passagesFields the passagesFields
     * @return the QueryOptions builder
     */
    public Builder passagesFields(List<String> passagesFields) {
      this.passagesFields = passagesFields;
      return this;
    }

    /**
     * Set the passagesCount.
     *
     * @param passagesCount the passagesCount
     * @return the QueryOptions builder
     */
    public Builder passagesCount(long passagesCount) {
      this.passagesCount = passagesCount;
      return this;
    }

    /**
     * Set the passagesCharacters.
     *
     * @param passagesCharacters the passagesCharacters
     * @return the QueryOptions builder
     */
    public Builder passagesCharacters(long passagesCharacters) {
      this.passagesCharacters = passagesCharacters;
      return this;
    }

    /**
     * Set the deduplicate.
     *
     * @param deduplicate the deduplicate
     * @return the QueryOptions builder
     */
    public Builder deduplicate(Boolean deduplicate) {
      this.deduplicate = deduplicate;
      return this;
    }

    /**
     * Set the deduplicateField.
     *
     * @param deduplicateField the deduplicateField
     * @return the QueryOptions builder
     */
    public Builder deduplicateField(String deduplicateField) {
      this.deduplicateField = deduplicateField;
      return this;
    }
  }

  private QueryOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    Validator.notEmpty(builder.collectionId, "collectionId cannot be empty");
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
    highlight = builder.highlight;
    passagesFields = builder.passagesFields;
    passagesCount = builder.passagesCount;
    passagesCharacters = builder.passagesCharacters;
    deduplicate = builder.deduplicate;
    deduplicateField = builder.deduplicateField;
  }

  /**
   * New builder.
   *
   * @return a QueryOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the collectionId.
   *
   * The ID of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the filter.
   *
   * A cacheable query that limits the documents returned to exclude any documents that don't mention the query content.
   * Filter searches are better for metadata type searches and when you are trying to get a sense of concepts in the
   * data set.
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
   * cannot use `natural_language_query` and `query` at the same time.
   *
   * @return the query
   */
  public String query() {
    return query;
  }

  /**
   * Gets the naturalLanguageQuery.
   *
   * A natural language query that returns relevant documents by utilizing training data and natural language
   * understanding. You cannot use `natural_language_query` and `query` at the same time.
   *
   * @return the naturalLanguageQuery
   */
  public String naturalLanguageQuery() {
    return naturalLanguageQuery;
  }

  /**
   * Gets the passages.
   *
   * A passages query that returns the most relevant passages from the results.
   *
   * @return the passages
   */
  public Boolean passages() {
    return passages;
  }

  /**
   * Gets the aggregation.
   *
   * An aggregation search uses combinations of filters and query search to return an exact answer. Aggregations are
   * useful for building applications, because you can use them to build lists, tables, and time series. For a full list
   * of possible aggregrations, see the Query reference.
   *
   * @return the aggregation
   */
  public String aggregation() {
    return aggregation;
  }

  /**
   * Gets the count.
   *
   * Number of documents to return.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }

  /**
   * Gets the returnFields.
   *
   * A comma separated list of the portion of the document hierarchy to return.
   *
   * @return the returnFields
   */
  public List<String> returnFields() {
    return returnFields;
  }

  /**
   * Gets the offset.
   *
   * The number of query results to skip at the beginning. For example, if the total number of results that are returned
   * is 10, and the offset is 8, it returns the last two results.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }

  /**
   * Gets the sort.
   *
   * A comma separated list of fields in the document to sort on. You can optionally specify a sort direction by
   * prefixing the field with `-` for descending or `+` for ascending. Ascending is the default sort direction if no
   * prefix is specified.
   *
   * @return the sort
   */
  public List<String> sort() {
    return sort;
  }

  /**
   * Gets the highlight.
   *
   * When true a highlight field is returned for each result which contains the fields that match the query with
   * `<em></em>` tags around the matching query terms. Defaults to false.
   *
   * @return the highlight
   */
  public Boolean highlight() {
    return highlight;
  }

  /**
   * Gets the passagesFields.
   *
   * A comma-separated list of fields that passages are drawn from. If this parameter not specified, then all top-level
   * fields are included.
   *
   * @return the passagesFields
   */
  public List<String> passagesFields() {
    return passagesFields;
  }

  /**
   * Gets the passagesCount.
   *
   * The maximum number of passages to return. The search returns fewer passages if the requested total is not found.
   * The default is `10`. The maximum is `100`.
   *
   * @return the passagesCount
   */
  public Long passagesCount() {
    return passagesCount;
  }

  /**
   * Gets the passagesCharacters.
   *
   * The approximate number of characters that any one passage will have. The default is `400`. The minimum is `50`. The
   * maximum is `2000`.
   *
   * @return the passagesCharacters
   */
  public Long passagesCharacters() {
    return passagesCharacters;
  }

  /**
   * Gets the deduplicate.
   *
   * When `true` and used with a Watson Discovery News collection, duplicate results (based on the contents of the
   * `title` field) are removed. Duplicate comparison is limited to the current query only, `offset` is not considered.
   * Defaults to `false`. This parameter is currently Beta functionality.
   *
   * @return the deduplicate
   */
  public Boolean deduplicate() {
    return deduplicate;
  }

  /**
   * Gets the deduplicateField.
   *
   * When specified, duplicate results based on the field specified are removed from the returned results. Duplicate
   * comparison is limited to the current query only, `offset` is not considered. This parameter is currently Beta
   * functionality.
   *
   * @return the deduplicateField
   */
  public String deduplicateField() {
    return deduplicateField;
  }
}

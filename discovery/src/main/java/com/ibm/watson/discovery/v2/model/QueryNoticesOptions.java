/*
 * (C) Copyright IBM Corp. 2019.
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
package com.ibm.watson.discovery.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The queryNotices options.
 */
public class QueryNoticesOptions extends GenericModel {

  private String projectId;
  private String filter;
  private String query;
  private String naturalLanguageQuery;
  private String aggregation;
  private Long count;
  private List<String> xReturn;
  private Long offset;
  private List<String> sort;
  private Boolean highlight;
  private Boolean spellingSuggestions;

  /**
   * Builder.
   */
  public static class Builder {
    private String projectId;
    private String filter;
    private String query;
    private String naturalLanguageQuery;
    private String aggregation;
    private Long count;
    private List<String> xReturn;
    private Long offset;
    private List<String> sort;
    private Boolean highlight;
    private Boolean spellingSuggestions;

    private Builder(QueryNoticesOptions queryNoticesOptions) {
      this.projectId = queryNoticesOptions.projectId;
      this.filter = queryNoticesOptions.filter;
      this.query = queryNoticesOptions.query;
      this.naturalLanguageQuery = queryNoticesOptions.naturalLanguageQuery;
      this.aggregation = queryNoticesOptions.aggregation;
      this.count = queryNoticesOptions.count;
      this.xReturn = queryNoticesOptions.xReturn;
      this.offset = queryNoticesOptions.offset;
      this.sort = queryNoticesOptions.sort;
      this.highlight = queryNoticesOptions.highlight;
      this.spellingSuggestions = queryNoticesOptions.spellingSuggestions;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     */
    public Builder(String projectId) {
      this.projectId = projectId;
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
     * Adds an returnField to xReturn.
     *
     * @param returnField the new returnField
     * @return the QueryNoticesOptions builder
     */
    public Builder addReturnField(String returnField) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(returnField,
          "returnField cannot be null");
      if (this.xReturn == null) {
        this.xReturn = new ArrayList<String>();
      }
      this.xReturn.add(returnField);
      return this;
    }

    /**
     * Adds an sort to sort.
     *
     * @param sort the new sort
     * @return the QueryNoticesOptions builder
     */
    public Builder addSort(String sort) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(sort,
          "sort cannot be null");
      if (this.sort == null) {
        this.sort = new ArrayList<String>();
      }
      this.sort.add(sort);
      return this;
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the QueryNoticesOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
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
    public Builder count(long count) {
      this.count = count;
      return this;
    }

    /**
     * Set the xReturn.
     * Existing xReturn will be replaced.
     *
     * @param xReturn the xReturn
     * @return the QueryNoticesOptions builder
     */
    public Builder xReturn(List<String> xReturn) {
      this.xReturn = xReturn;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the QueryNoticesOptions builder
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
     * @return the QueryNoticesOptions builder
     */
    public Builder sort(List<String> sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the highlight.
     *
     * @param highlight the highlight
     * @return the QueryNoticesOptions builder
     */
    public Builder highlight(Boolean highlight) {
      this.highlight = highlight;
      return this;
    }

    /**
     * Set the spellingSuggestions.
     *
     * @param spellingSuggestions the spellingSuggestions
     * @return the QueryNoticesOptions builder
     */
    public Builder spellingSuggestions(Boolean spellingSuggestions) {
      this.spellingSuggestions = spellingSuggestions;
      return this;
    }
  }

  private QueryNoticesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId,
        "projectId cannot be empty");
    projectId = builder.projectId;
    filter = builder.filter;
    query = builder.query;
    naturalLanguageQuery = builder.naturalLanguageQuery;
    aggregation = builder.aggregation;
    count = builder.count;
    xReturn = builder.xReturn;
    offset = builder.offset;
    sort = builder.sort;
    highlight = builder.highlight;
    spellingSuggestions = builder.spellingSuggestions;
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
   * Gets the projectId.
   *
   * The ID of the project. This information can be found from the deploy page of the Discovery administrative tooling.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
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
   * relevant documents listed first.
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
   * understanding.
   *
   * @return the naturalLanguageQuery
   */
  public String naturalLanguageQuery() {
    return naturalLanguageQuery;
  }

  /**
   * Gets the aggregation.
   *
   * An aggregation search that returns an exact answer by combining query search with filters. Useful for applications
   * to build lists, tables, and time series. For a full list of possible aggregations, see the Query reference.
   *
   * @return the aggregation
   */
  public String aggregation() {
    return aggregation;
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
   * Gets the xReturn.
   *
   * A comma-separated list of the portion of the document hierarchy to return.
   *
   * @return the xReturn
   */
  public List<String> xReturn() {
    return xReturn;
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

  /**
   * Gets the highlight.
   *
   * When true, a highlight field is returned for each result which contains the fields which match the query with
   * `<em></em>` tags around the matching query terms.
   *
   * @return the highlight
   */
  public Boolean highlight() {
    return highlight;
  }

  /**
   * Gets the spellingSuggestions.
   *
   * When `true` and the **natural_language_query** parameter is used, the **natural_language_query** parameter is spell
   * checked. The most likely correction is returned in the **suggested_query** field of the response (if one exists).
   *
   * @return the spellingSuggestions
   */
  public Boolean spellingSuggestions() {
    return spellingSuggestions;
  }
}

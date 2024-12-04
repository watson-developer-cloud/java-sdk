/*
 * (C) Copyright IBM Corp. 2019, 2024.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** The query options. */
public class QueryOptions extends GenericModel {

  protected String projectId;
  protected List<String> collectionIds;
  protected String filter;
  protected String query;
  protected String naturalLanguageQuery;
  protected String aggregation;
  protected Long count;
  protected List<String> xReturn;
  protected Long offset;
  protected String sort;
  protected Boolean highlight;
  protected Boolean spellingSuggestions;
  protected QueryLargeTableResults tableResults;
  protected QueryLargeSuggestedRefinements suggestedRefinements;
  protected QueryLargePassages passages;
  protected QueryLargeSimilar similar;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private List<String> collectionIds;
    private String filter;
    private String query;
    private String naturalLanguageQuery;
    private String aggregation;
    private Long count;
    private List<String> xReturn;
    private Long offset;
    private String sort;
    private Boolean highlight;
    private Boolean spellingSuggestions;
    private QueryLargeTableResults tableResults;
    private QueryLargeSuggestedRefinements suggestedRefinements;
    private QueryLargePassages passages;
    private QueryLargeSimilar similar;

    /**
     * Instantiates a new Builder from an existing QueryOptions instance.
     *
     * @param queryOptions the instance to initialize the Builder with
     */
    private Builder(QueryOptions queryOptions) {
      this.projectId = queryOptions.projectId;
      this.collectionIds = queryOptions.collectionIds;
      this.filter = queryOptions.filter;
      this.query = queryOptions.query;
      this.naturalLanguageQuery = queryOptions.naturalLanguageQuery;
      this.aggregation = queryOptions.aggregation;
      this.count = queryOptions.count;
      this.xReturn = queryOptions.xReturn;
      this.offset = queryOptions.offset;
      this.sort = queryOptions.sort;
      this.highlight = queryOptions.highlight;
      this.spellingSuggestions = queryOptions.spellingSuggestions;
      this.tableResults = queryOptions.tableResults;
      this.suggestedRefinements = queryOptions.suggestedRefinements;
      this.passages = queryOptions.passages;
      this.similar = queryOptions.similar;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     */
    public Builder(String projectId) {
      this.projectId = projectId;
    }

    /**
     * Builds a QueryOptions.
     *
     * @return the new QueryOptions instance
     */
    public QueryOptions build() {
      return new QueryOptions(this);
    }

    /**
     * Adds a new element to collectionIds.
     *
     * @param collectionIds the new element to be added
     * @return the QueryOptions builder
     */
    public Builder addCollectionIds(String collectionIds) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(collectionIds, "collectionIds cannot be null");
      if (this.collectionIds == null) {
        this.collectionIds = new ArrayList<String>();
      }
      this.collectionIds.add(collectionIds);
      return this;
    }

    /**
     * Adds a new element to xReturn.
     *
     * @param returnField the new element to be added
     * @return the QueryOptions builder
     */
    public Builder addReturnField(String returnField) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(returnField, "returnField cannot be null");
      if (this.xReturn == null) {
        this.xReturn = new ArrayList<String>();
      }
      this.xReturn.add(returnField);
      return this;
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the QueryOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the collectionIds. Existing collectionIds will be replaced.
     *
     * @param collectionIds the collectionIds
     * @return the QueryOptions builder
     */
    public Builder collectionIds(List<String> collectionIds) {
      this.collectionIds = collectionIds;
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
     * Set the xReturn. Existing xReturn will be replaced.
     *
     * @param xReturn the xReturn
     * @return the QueryOptions builder
     */
    public Builder xReturn(List<String> xReturn) {
      this.xReturn = xReturn;
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
     *
     * @param sort the sort
     * @return the QueryOptions builder
     */
    public Builder sort(String sort) {
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
     * Set the spellingSuggestions.
     *
     * @param spellingSuggestions the spellingSuggestions
     * @return the QueryOptions builder
     */
    public Builder spellingSuggestions(Boolean spellingSuggestions) {
      this.spellingSuggestions = spellingSuggestions;
      return this;
    }

    /**
     * Set the tableResults.
     *
     * @param tableResults the tableResults
     * @return the QueryOptions builder
     */
    public Builder tableResults(QueryLargeTableResults tableResults) {
      this.tableResults = tableResults;
      return this;
    }

    /**
     * Set the suggestedRefinements.
     *
     * @param suggestedRefinements the suggestedRefinements
     * @return the QueryOptions builder
     */
    public Builder suggestedRefinements(QueryLargeSuggestedRefinements suggestedRefinements) {
      this.suggestedRefinements = suggestedRefinements;
      return this;
    }

    /**
     * Set the passages.
     *
     * @param passages the passages
     * @return the QueryOptions builder
     */
    public Builder passages(QueryLargePassages passages) {
      this.passages = passages;
      return this;
    }

    /**
     * Set the similar.
     *
     * @param similar the similar
     * @return the QueryOptions builder
     */
    public Builder similar(QueryLargeSimilar similar) {
      this.similar = similar;
      return this;
    }
  }

  protected QueryOptions() {}

  protected QueryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    projectId = builder.projectId;
    collectionIds = builder.collectionIds;
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
    tableResults = builder.tableResults;
    suggestedRefinements = builder.suggestedRefinements;
    passages = builder.passages;
    similar = builder.similar;
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
   * Gets the projectId.
   *
   * <p>The Universally Unique Identifier (UUID) of the project. This information can be found from
   * the *Integrate and Deploy* page in Discovery.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the collectionIds.
   *
   * <p>A comma-separated list of collection IDs to be queried against.
   *
   * @return the collectionIds
   */
  public List<String> collectionIds() {
    return collectionIds;
  }

  /**
   * Gets the filter.
   *
   * <p>Searches for documents that match the Discovery Query Language criteria that is specified as
   * input. Filter calls are cached and are faster than query calls because the results are not
   * ordered by relevance. When used with the **aggregation**, **query**, or
   * **natural_language_query** parameters, the **filter** parameter runs first. This parameter is
   * useful for limiting results to those that contain specific metadata values.
   *
   * @return the filter
   */
  public String filter() {
    return filter;
  }

  /**
   * Gets the query.
   *
   * <p>A query search that is written in the Discovery Query Language and returns all matching
   * documents in your data set with full enrichments and full text, and with the most relevant
   * documents listed first. Use a query search when you want to find the most relevant search
   * results. You can use this parameter or the **natural_language_query** parameter to specify the
   * query input, but not both.
   *
   * @return the query
   */
  public String query() {
    return query;
  }

  /**
   * Gets the naturalLanguageQuery.
   *
   * <p>A natural language query that returns relevant documents by using training data and natural
   * language understanding. You can use this parameter or the **query** parameter to specify the
   * query input, but not both. To filter the results based on criteria you specify, include the
   * **filter** parameter in the request.
   *
   * @return the naturalLanguageQuery
   */
  public String naturalLanguageQuery() {
    return naturalLanguageQuery;
  }

  /**
   * Gets the aggregation.
   *
   * <p>An aggregation search that returns an exact answer by combining query search with filters.
   * Useful for applications to build lists, tables, and time series. For more information about the
   * supported types of aggregations, see the [Discovery
   * documentation](/docs/discovery-data?topic=discovery-data-query-aggregations).
   *
   * @return the aggregation
   */
  public String aggregation() {
    return aggregation;
  }

  /**
   * Gets the count.
   *
   * <p>Number of results to return.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }

  /**
   * Gets the xReturn.
   *
   * <p>A list of the fields in the document hierarchy to return. You can specify both root-level
   * (`text`) and nested (`extracted_metadata.filename`) fields. If this parameter is an empty list,
   * then all fields are returned.
   *
   * @return the xReturn
   */
  public List<String> xReturn() {
    return xReturn;
  }

  /**
   * Gets the offset.
   *
   * <p>The number of query results to skip at the beginning. Consider that the `count` is set to 10
   * (the default value) and the total number of results that are returned is 100. In this case, the
   * following examples show the returned results for different `offset` values:
   *
   * <p>* If `offset` is set to 95, it returns the last 5 results.
   *
   * <p>* If `offset` is set to 10, it returns the second batch of 10 results.
   *
   * <p>* If `offset` is set to 100 or more, it returns empty results.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }

  /**
   * Gets the sort.
   *
   * <p>A comma-separated list of fields in the document to sort on. You can optionally specify a
   * sort direction by prefixing the field with `-` for descending or `+` for ascending. Ascending
   * is the default sort direction if no prefix is specified.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }

  /**
   * Gets the highlight.
   *
   * <p>When `true`, a highlight field is returned for each result that contains fields that match
   * the query. The matching query terms are emphasized with surrounding `&lt;em&gt;&lt;/em&gt;`
   * tags. This parameter is ignored if **passages.enabled** and **passages.per_document** are
   * `true`, in which case passages are returned for each document instead of highlights.
   *
   * @return the highlight
   */
  public Boolean highlight() {
    return highlight;
  }

  /**
   * Gets the spellingSuggestions.
   *
   * <p>When `true` and the **natural_language_query** parameter is used, the
   * **natural_language_query** parameter is spell checked. The most likely correction is returned
   * in the **suggested_query** field of the response (if one exists).
   *
   * @return the spellingSuggestions
   */
  public Boolean spellingSuggestions() {
    return spellingSuggestions;
  }

  /**
   * Gets the tableResults.
   *
   * <p>Configuration for table retrieval.
   *
   * @return the tableResults
   */
  public QueryLargeTableResults tableResults() {
    return tableResults;
  }

  /**
   * Gets the suggestedRefinements.
   *
   * <p>Configuration for suggested refinements.
   *
   * <p>**Note**: The **suggested_refinements** parameter that identified dynamic facets from the
   * data is deprecated.
   *
   * @return the suggestedRefinements
   */
  public QueryLargeSuggestedRefinements suggestedRefinements() {
    return suggestedRefinements;
  }

  /**
   * Gets the passages.
   *
   * <p>Configuration for passage retrieval.
   *
   * @return the passages
   */
  public QueryLargePassages passages() {
    return passages;
  }

  /**
   * Gets the similar.
   *
   * <p>Finds results from documents that are similar to documents of interest. Use this parameter
   * to add a *More like these* function to your search. You can include this parameter with or
   * without a **query**, **filter** or **natural_language_query** parameter.
   *
   * @return the similar
   */
  public QueryLargeSimilar similar() {
    return similar;
  }
}

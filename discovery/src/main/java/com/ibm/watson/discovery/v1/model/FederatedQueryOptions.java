/*
 * (C) Copyright IBM Corp. 2017, 2022.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The federatedQuery options. */
public class FederatedQueryOptions extends GenericModel {

  protected String environmentId;
  protected String collectionIds;
  protected String filter;
  protected String query;
  protected String naturalLanguageQuery;
  protected Boolean passages;
  protected String aggregation;
  protected Long count;
  protected String xReturn;
  protected Long offset;
  protected String sort;
  protected Boolean highlight;
  protected String passagesFields;
  protected Long passagesCount;
  protected Long passagesCharacters;
  protected Boolean deduplicate;
  protected String deduplicateField;
  protected Boolean similar;
  protected String similarDocumentIds;
  protected String similarFields;
  protected String bias;
  protected Boolean xWatsonLoggingOptOut;

  /** Builder. */
  public static class Builder {
    private String environmentId;
    private String collectionIds;
    private String filter;
    private String query;
    private String naturalLanguageQuery;
    private Boolean passages;
    private String aggregation;
    private Long count;
    private String xReturn;
    private Long offset;
    private String sort;
    private Boolean highlight;
    private String passagesFields;
    private Long passagesCount;
    private Long passagesCharacters;
    private Boolean deduplicate;
    private String deduplicateField;
    private Boolean similar;
    private String similarDocumentIds;
    private String similarFields;
    private String bias;
    private Boolean xWatsonLoggingOptOut;

    private Builder(FederatedQueryOptions federatedQueryOptions) {
      this.environmentId = federatedQueryOptions.environmentId;
      this.collectionIds = federatedQueryOptions.collectionIds;
      this.filter = federatedQueryOptions.filter;
      this.query = federatedQueryOptions.query;
      this.naturalLanguageQuery = federatedQueryOptions.naturalLanguageQuery;
      this.passages = federatedQueryOptions.passages;
      this.aggregation = federatedQueryOptions.aggregation;
      this.count = federatedQueryOptions.count;
      this.xReturn = federatedQueryOptions.xReturn;
      this.offset = federatedQueryOptions.offset;
      this.sort = federatedQueryOptions.sort;
      this.highlight = federatedQueryOptions.highlight;
      this.passagesFields = federatedQueryOptions.passagesFields;
      this.passagesCount = federatedQueryOptions.passagesCount;
      this.passagesCharacters = federatedQueryOptions.passagesCharacters;
      this.deduplicate = federatedQueryOptions.deduplicate;
      this.deduplicateField = federatedQueryOptions.deduplicateField;
      this.similar = federatedQueryOptions.similar;
      this.similarDocumentIds = federatedQueryOptions.similarDocumentIds;
      this.similarFields = federatedQueryOptions.similarFields;
      this.bias = federatedQueryOptions.bias;
      this.xWatsonLoggingOptOut = federatedQueryOptions.xWatsonLoggingOptOut;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     * @param collectionIds the collectionIds
     */
    public Builder(String environmentId, String collectionIds) {
      this.environmentId = environmentId;
      this.collectionIds = collectionIds;
    }

    /**
     * Builds a FederatedQueryOptions.
     *
     * @return the new FederatedQueryOptions instance
     */
    public FederatedQueryOptions build() {
      return new FederatedQueryOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the FederatedQueryOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionIds.
     *
     * @param collectionIds the collectionIds
     * @return the FederatedQueryOptions builder
     */
    public Builder collectionIds(String collectionIds) {
      this.collectionIds = collectionIds;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the FederatedQueryOptions builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the query.
     *
     * @param query the query
     * @return the FederatedQueryOptions builder
     */
    public Builder query(String query) {
      this.query = query;
      return this;
    }

    /**
     * Set the naturalLanguageQuery.
     *
     * @param naturalLanguageQuery the naturalLanguageQuery
     * @return the FederatedQueryOptions builder
     */
    public Builder naturalLanguageQuery(String naturalLanguageQuery) {
      this.naturalLanguageQuery = naturalLanguageQuery;
      return this;
    }

    /**
     * Set the passages.
     *
     * @param passages the passages
     * @return the FederatedQueryOptions builder
     */
    public Builder passages(Boolean passages) {
      this.passages = passages;
      return this;
    }

    /**
     * Set the aggregation.
     *
     * @param aggregation the aggregation
     * @return the FederatedQueryOptions builder
     */
    public Builder aggregation(String aggregation) {
      this.aggregation = aggregation;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the FederatedQueryOptions builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }

    /**
     * Set the xReturn.
     *
     * @param xReturn the xReturn
     * @return the FederatedQueryOptions builder
     */
    public Builder xReturn(String xReturn) {
      this.xReturn = xReturn;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the FederatedQueryOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the FederatedQueryOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the highlight.
     *
     * @param highlight the highlight
     * @return the FederatedQueryOptions builder
     */
    public Builder highlight(Boolean highlight) {
      this.highlight = highlight;
      return this;
    }

    /**
     * Set the passagesFields.
     *
     * @param passagesFields the passagesFields
     * @return the FederatedQueryOptions builder
     */
    public Builder passagesFields(String passagesFields) {
      this.passagesFields = passagesFields;
      return this;
    }

    /**
     * Set the passagesCount.
     *
     * @param passagesCount the passagesCount
     * @return the FederatedQueryOptions builder
     */
    public Builder passagesCount(long passagesCount) {
      this.passagesCount = passagesCount;
      return this;
    }

    /**
     * Set the passagesCharacters.
     *
     * @param passagesCharacters the passagesCharacters
     * @return the FederatedQueryOptions builder
     */
    public Builder passagesCharacters(long passagesCharacters) {
      this.passagesCharacters = passagesCharacters;
      return this;
    }

    /**
     * Set the deduplicate.
     *
     * @param deduplicate the deduplicate
     * @return the FederatedQueryOptions builder
     */
    public Builder deduplicate(Boolean deduplicate) {
      this.deduplicate = deduplicate;
      return this;
    }

    /**
     * Set the deduplicateField.
     *
     * @param deduplicateField the deduplicateField
     * @return the FederatedQueryOptions builder
     */
    public Builder deduplicateField(String deduplicateField) {
      this.deduplicateField = deduplicateField;
      return this;
    }

    /**
     * Set the similar.
     *
     * @param similar the similar
     * @return the FederatedQueryOptions builder
     */
    public Builder similar(Boolean similar) {
      this.similar = similar;
      return this;
    }

    /**
     * Set the similarDocumentIds.
     *
     * @param similarDocumentIds the similarDocumentIds
     * @return the FederatedQueryOptions builder
     */
    public Builder similarDocumentIds(String similarDocumentIds) {
      this.similarDocumentIds = similarDocumentIds;
      return this;
    }

    /**
     * Set the similarFields.
     *
     * @param similarFields the similarFields
     * @return the FederatedQueryOptions builder
     */
    public Builder similarFields(String similarFields) {
      this.similarFields = similarFields;
      return this;
    }

    /**
     * Set the bias.
     *
     * @param bias the bias
     * @return the FederatedQueryOptions builder
     */
    public Builder bias(String bias) {
      this.bias = bias;
      return this;
    }

    /**
     * Set the xWatsonLoggingOptOut.
     *
     * @param xWatsonLoggingOptOut the xWatsonLoggingOptOut
     * @return the FederatedQueryOptions builder
     */
    public Builder xWatsonLoggingOptOut(Boolean xWatsonLoggingOptOut) {
      this.xWatsonLoggingOptOut = xWatsonLoggingOptOut;
      return this;
    }
  }

  protected FederatedQueryOptions() {}

  protected FederatedQueryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.collectionIds, "collectionIds cannot be null");
    environmentId = builder.environmentId;
    collectionIds = builder.collectionIds;
    filter = builder.filter;
    query = builder.query;
    naturalLanguageQuery = builder.naturalLanguageQuery;
    passages = builder.passages;
    aggregation = builder.aggregation;
    count = builder.count;
    xReturn = builder.xReturn;
    offset = builder.offset;
    sort = builder.sort;
    highlight = builder.highlight;
    passagesFields = builder.passagesFields;
    passagesCount = builder.passagesCount;
    passagesCharacters = builder.passagesCharacters;
    deduplicate = builder.deduplicate;
    deduplicateField = builder.deduplicateField;
    similar = builder.similar;
    similarDocumentIds = builder.similarDocumentIds;
    similarFields = builder.similarFields;
    bias = builder.bias;
    xWatsonLoggingOptOut = builder.xWatsonLoggingOptOut;
  }

  /**
   * New builder.
   *
   * @return a FederatedQueryOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * <p>The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the collectionIds.
   *
   * <p>A comma-separated list of collection IDs to be queried against.
   *
   * @return the collectionIds
   */
  public String collectionIds() {
    return collectionIds;
  }

  /**
   * Gets the filter.
   *
   * <p>A cacheable query that excludes documents that don't mention the query content. Filter
   * searches are better for metadata-type searches and for assessing the concepts in the data set.
   *
   * @return the filter
   */
  public String filter() {
    return filter;
  }

  /**
   * Gets the query.
   *
   * <p>A query search returns all documents in your data set with full enrichments and full text,
   * but with the most relevant documents listed first. Use a query search when you want to find the
   * most relevant search results.
   *
   * @return the query
   */
  public String query() {
    return query;
  }

  /**
   * Gets the naturalLanguageQuery.
   *
   * <p>A natural language query that returns relevant documents by utilizing training data and
   * natural language understanding.
   *
   * @return the naturalLanguageQuery
   */
  public String naturalLanguageQuery() {
    return naturalLanguageQuery;
  }

  /**
   * Gets the passages.
   *
   * <p>A passages query that returns the most relevant passages from the results.
   *
   * @return the passages
   */
  public Boolean passages() {
    return passages;
  }

  /**
   * Gets the aggregation.
   *
   * <p>An aggregation search that returns an exact answer by combining query search with filters.
   * Useful for applications to build lists, tables, and time series. For a full list of possible
   * aggregations, see the Query reference.
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
   * <p>A comma-separated list of the portion of the document hierarchy to return.
   *
   * @return the xReturn
   */
  public String xReturn() {
    return xReturn;
  }

  /**
   * Gets the offset.
   *
   * <p>The number of query results to skip at the beginning. For example, if the total number of
   * results that are returned is 10 and the offset is 8, it returns the last two results.
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
   * is the default sort direction if no prefix is specified. This parameter cannot be used in the
   * same query as the **bias** parameter.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }

  /**
   * Gets the highlight.
   *
   * <p>When true, a highlight field is returned for each result which contains the fields which
   * match the query with `&lt;em&gt;&lt;/em&gt;` tags around the matching query terms.
   *
   * @return the highlight
   */
  public Boolean highlight() {
    return highlight;
  }

  /**
   * Gets the passagesFields.
   *
   * <p>A comma-separated list of fields that passages are drawn from. If this parameter not
   * specified, then all top-level fields are included.
   *
   * @return the passagesFields
   */
  public String passagesFields() {
    return passagesFields;
  }

  /**
   * Gets the passagesCount.
   *
   * <p>The maximum number of passages to return. The search returns fewer passages if the requested
   * total is not found. The default is `10`. The maximum is `100`.
   *
   * @return the passagesCount
   */
  public Long passagesCount() {
    return passagesCount;
  }

  /**
   * Gets the passagesCharacters.
   *
   * <p>The approximate number of characters that any one passage will have.
   *
   * @return the passagesCharacters
   */
  public Long passagesCharacters() {
    return passagesCharacters;
  }

  /**
   * Gets the deduplicate.
   *
   * <p>When `true`, and used with a Watson Discovery News collection, duplicate results (based on
   * the contents of the **title** field) are removed. Duplicate comparison is limited to the
   * current query only; **offset** is not considered. This parameter is currently Beta
   * functionality.
   *
   * @return the deduplicate
   */
  public Boolean deduplicate() {
    return deduplicate;
  }

  /**
   * Gets the deduplicateField.
   *
   * <p>When specified, duplicate results based on the field specified are removed from the returned
   * results. Duplicate comparison is limited to the current query only, **offset** is not
   * considered. This parameter is currently Beta functionality.
   *
   * @return the deduplicateField
   */
  public String deduplicateField() {
    return deduplicateField;
  }

  /**
   * Gets the similar.
   *
   * <p>When `true`, results are returned based on their similarity to the document IDs specified in
   * the **similar.document_ids** parameter.
   *
   * @return the similar
   */
  public Boolean similar() {
    return similar;
  }

  /**
   * Gets the similarDocumentIds.
   *
   * <p>A comma-separated list of document IDs to find similar documents.
   *
   * <p>**Tip:** Include the **natural_language_query** parameter to expand the scope of the
   * document similarity search with the natural language query. Other query parameters, such as
   * **filter** and **query**, are subsequently applied and reduce the scope.
   *
   * @return the similarDocumentIds
   */
  public String similarDocumentIds() {
    return similarDocumentIds;
  }

  /**
   * Gets the similarFields.
   *
   * <p>A comma-separated list of field names that are used as a basis for comparison to identify
   * similar documents. If not specified, the entire document is used for comparison.
   *
   * @return the similarFields
   */
  public String similarFields() {
    return similarFields;
  }

  /**
   * Gets the bias.
   *
   * <p>Field which the returned results will be biased against. The specified field must be either
   * a **date** or **number** format. When a **date** type field is specified returned results are
   * biased towards field values closer to the current date. When a **number** type field is
   * specified, returned results are biased towards higher field values. This parameter cannot be
   * used in the same query as the **sort** parameter.
   *
   * @return the bias
   */
  public String bias() {
    return bias;
  }

  /**
   * Gets the xWatsonLoggingOptOut.
   *
   * <p>If `true`, queries are not stored in the Discovery **Logs** endpoint.
   *
   * @return the xWatsonLoggingOptOut
   */
  public Boolean xWatsonLoggingOptOut() {
    return xWatsonLoggingOptOut;
  }
}

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
package com.ibm.watson.discovery.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** The queryNotices options. */
public class QueryNoticesOptions extends GenericModel {

  protected String environmentId;
  protected String collectionId;
  protected String filter;
  protected String query;
  protected String naturalLanguageQuery;
  protected Boolean passages;
  protected String aggregation;
  protected Long count;
  protected List<String> xReturn;
  protected Long offset;
  protected List<String> sort;
  protected Boolean highlight;
  protected List<String> passagesFields;
  protected Long passagesCount;
  protected Long passagesCharacters;
  protected String deduplicateField;
  protected Boolean similar;
  protected List<String> similarDocumentIds;
  protected List<String> similarFields;

  /** Builder. */
  public static class Builder {
    private String environmentId;
    private String collectionId;
    private String filter;
    private String query;
    private String naturalLanguageQuery;
    private Boolean passages;
    private String aggregation;
    private Long count;
    private List<String> xReturn;
    private Long offset;
    private List<String> sort;
    private Boolean highlight;
    private List<String> passagesFields;
    private Long passagesCount;
    private Long passagesCharacters;
    private String deduplicateField;
    private Boolean similar;
    private List<String> similarDocumentIds;
    private List<String> similarFields;

    /**
     * Instantiates a new Builder from an existing QueryNoticesOptions instance.
     *
     * @param queryNoticesOptions the instance to initialize the Builder with
     */
    private Builder(QueryNoticesOptions queryNoticesOptions) {
      this.environmentId = queryNoticesOptions.environmentId;
      this.collectionId = queryNoticesOptions.collectionId;
      this.filter = queryNoticesOptions.filter;
      this.query = queryNoticesOptions.query;
      this.naturalLanguageQuery = queryNoticesOptions.naturalLanguageQuery;
      this.passages = queryNoticesOptions.passages;
      this.aggregation = queryNoticesOptions.aggregation;
      this.count = queryNoticesOptions.count;
      this.xReturn = queryNoticesOptions.xReturn;
      this.offset = queryNoticesOptions.offset;
      this.sort = queryNoticesOptions.sort;
      this.highlight = queryNoticesOptions.highlight;
      this.passagesFields = queryNoticesOptions.passagesFields;
      this.passagesCount = queryNoticesOptions.passagesCount;
      this.passagesCharacters = queryNoticesOptions.passagesCharacters;
      this.deduplicateField = queryNoticesOptions.deduplicateField;
      this.similar = queryNoticesOptions.similar;
      this.similarDocumentIds = queryNoticesOptions.similarDocumentIds;
      this.similarFields = queryNoticesOptions.similarFields;
    }

    /** Instantiates a new builder. */
    public Builder() {}

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
     * Builds a QueryNoticesOptions.
     *
     * @return the new QueryNoticesOptions instance
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
      com.ibm.cloud.sdk.core.util.Validator.notNull(returnField, "returnField cannot be null");
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
      com.ibm.cloud.sdk.core.util.Validator.notNull(sort, "sort cannot be null");
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
     * @return the QueryNoticesOptions builder
     */
    public Builder addPassagesFields(String passagesFields) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(
          passagesFields, "passagesFields cannot be null");
      if (this.passagesFields == null) {
        this.passagesFields = new ArrayList<String>();
      }
      this.passagesFields.add(passagesFields);
      return this;
    }

    /**
     * Adds an similarDocumentIds to similarDocumentIds.
     *
     * @param similarDocumentIds the new similarDocumentIds
     * @return the QueryNoticesOptions builder
     */
    public Builder addSimilarDocumentIds(String similarDocumentIds) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(
          similarDocumentIds, "similarDocumentIds cannot be null");
      if (this.similarDocumentIds == null) {
        this.similarDocumentIds = new ArrayList<String>();
      }
      this.similarDocumentIds.add(similarDocumentIds);
      return this;
    }

    /**
     * Adds an similarFields to similarFields.
     *
     * @param similarFields the new similarFields
     * @return the QueryNoticesOptions builder
     */
    public Builder addSimilarFields(String similarFields) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(similarFields, "similarFields cannot be null");
      if (this.similarFields == null) {
        this.similarFields = new ArrayList<String>();
      }
      this.similarFields.add(similarFields);
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
    public Builder count(long count) {
      this.count = count;
      return this;
    }

    /**
     * Set the xReturn. Existing xReturn will be replaced.
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
     * Set the sort. Existing sort will be replaced.
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
     * Set the passagesFields. Existing passagesFields will be replaced.
     *
     * @param passagesFields the passagesFields
     * @return the QueryNoticesOptions builder
     */
    public Builder passagesFields(List<String> passagesFields) {
      this.passagesFields = passagesFields;
      return this;
    }

    /**
     * Set the passagesCount.
     *
     * @param passagesCount the passagesCount
     * @return the QueryNoticesOptions builder
     */
    public Builder passagesCount(long passagesCount) {
      this.passagesCount = passagesCount;
      return this;
    }

    /**
     * Set the passagesCharacters.
     *
     * @param passagesCharacters the passagesCharacters
     * @return the QueryNoticesOptions builder
     */
    public Builder passagesCharacters(long passagesCharacters) {
      this.passagesCharacters = passagesCharacters;
      return this;
    }

    /**
     * Set the deduplicateField.
     *
     * @param deduplicateField the deduplicateField
     * @return the QueryNoticesOptions builder
     */
    public Builder deduplicateField(String deduplicateField) {
      this.deduplicateField = deduplicateField;
      return this;
    }

    /**
     * Set the similar.
     *
     * @param similar the similar
     * @return the QueryNoticesOptions builder
     */
    public Builder similar(Boolean similar) {
      this.similar = similar;
      return this;
    }

    /**
     * Set the similarDocumentIds. Existing similarDocumentIds will be replaced.
     *
     * @param similarDocumentIds the similarDocumentIds
     * @return the QueryNoticesOptions builder
     */
    public Builder similarDocumentIds(List<String> similarDocumentIds) {
      this.similarDocumentIds = similarDocumentIds;
      return this;
    }

    /**
     * Set the similarFields. Existing similarFields will be replaced.
     *
     * @param similarFields the similarFields
     * @return the QueryNoticesOptions builder
     */
    public Builder similarFields(List<String> similarFields) {
      this.similarFields = similarFields;
      return this;
    }
  }

  protected QueryNoticesOptions() {}

  protected QueryNoticesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    environmentId = builder.environmentId;
    collectionId = builder.collectionId;
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
    deduplicateField = builder.deduplicateField;
    similar = builder.similar;
    similarDocumentIds = builder.similarDocumentIds;
    similarFields = builder.similarFields;
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
   * <p>The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the collectionId.
   *
   * <p>The ID of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
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
   * but with the most relevant documents listed first.
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
   * <p>Number of results to return. The maximum for the **count** and **offset** values together in
   * any one query is **10000**.
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
  public List<String> xReturn() {
    return xReturn;
  }

  /**
   * Gets the offset.
   *
   * <p>The number of query results to skip at the beginning. For example, if the total number of
   * results that are returned is 10 and the offset is 8, it returns the last two results. The
   * maximum for the **count** and **offset** values together in any one query is **10000**.
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
  public List<String> sort() {
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
  public List<String> passagesFields() {
    return passagesFields;
  }

  /**
   * Gets the passagesCount.
   *
   * <p>The maximum number of passages to return. The search returns fewer passages if the requested
   * total is not found.
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
  public List<String> similarDocumentIds() {
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
  public List<String> similarFields() {
    return similarFields;
  }
}

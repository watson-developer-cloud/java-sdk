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
package com.ibm.watson.discovery.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The federatedQueryNotices options.
 */
public class FederatedQueryNoticesOptions extends GenericModel {

  protected String environmentId;
  protected List<String> collectionIds;
  protected String filter;
  protected String query;
  protected String naturalLanguageQuery;
  protected String aggregation;
  protected Long count;
  protected List<String> xReturn;
  protected Long offset;
  protected List<String> sort;
  protected Boolean highlight;
  protected String deduplicateField;
  protected Boolean similar;
  protected List<String> similarDocumentIds;
  protected List<String> similarFields;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private List<String> collectionIds;
    private String filter;
    private String query;
    private String naturalLanguageQuery;
    private String aggregation;
    private Long count;
    private List<String> xReturn;
    private Long offset;
    private List<String> sort;
    private Boolean highlight;
    private String deduplicateField;
    private Boolean similar;
    private List<String> similarDocumentIds;
    private List<String> similarFields;

    private Builder(FederatedQueryNoticesOptions federatedQueryNoticesOptions) {
      this.environmentId = federatedQueryNoticesOptions.environmentId;
      this.collectionIds = federatedQueryNoticesOptions.collectionIds;
      this.filter = federatedQueryNoticesOptions.filter;
      this.query = federatedQueryNoticesOptions.query;
      this.naturalLanguageQuery = federatedQueryNoticesOptions.naturalLanguageQuery;
      this.aggregation = federatedQueryNoticesOptions.aggregation;
      this.count = federatedQueryNoticesOptions.count;
      this.xReturn = federatedQueryNoticesOptions.xReturn;
      this.offset = federatedQueryNoticesOptions.offset;
      this.sort = federatedQueryNoticesOptions.sort;
      this.highlight = federatedQueryNoticesOptions.highlight;
      this.deduplicateField = federatedQueryNoticesOptions.deduplicateField;
      this.similar = federatedQueryNoticesOptions.similar;
      this.similarDocumentIds = federatedQueryNoticesOptions.similarDocumentIds;
      this.similarFields = federatedQueryNoticesOptions.similarFields;
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
     * @param collectionIds the collectionIds
     */
    public Builder(String environmentId, List<String> collectionIds) {
      this.environmentId = environmentId;
      this.collectionIds = collectionIds;
    }

    /**
     * Builds a FederatedQueryNoticesOptions.
     *
     * @return the federatedQueryNoticesOptions
     */
    public FederatedQueryNoticesOptions build() {
      return new FederatedQueryNoticesOptions(this);
    }

    /**
     * Adds an collectionIds to collectionIds.
     *
     * @param collectionIds the new collectionIds
     * @return the FederatedQueryNoticesOptions builder
     */
    public Builder addCollectionIds(String collectionIds) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(collectionIds,
          "collectionIds cannot be null");
      if (this.collectionIds == null) {
        this.collectionIds = new ArrayList<String>();
      }
      this.collectionIds.add(collectionIds);
      return this;
    }

    /**
     * Adds an returnField to xReturn.
     *
     * @param returnField the new returnField
     * @return the FederatedQueryNoticesOptions builder
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
     * @return the FederatedQueryNoticesOptions builder
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
     * Adds an similarDocumentIds to similarDocumentIds.
     *
     * @param similarDocumentIds the new similarDocumentIds
     * @return the FederatedQueryNoticesOptions builder
     */
    public Builder addSimilarDocumentIds(String similarDocumentIds) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(similarDocumentIds,
          "similarDocumentIds cannot be null");
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
     * @return the FederatedQueryNoticesOptions builder
     */
    public Builder addSimilarFields(String similarFields) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(similarFields,
          "similarFields cannot be null");
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
     * @return the FederatedQueryNoticesOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the collectionIds.
     * Existing collectionIds will be replaced.
     *
     * @param collectionIds the collectionIds
     * @return the FederatedQueryNoticesOptions builder
     */
    public Builder collectionIds(List<String> collectionIds) {
      this.collectionIds = collectionIds;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the FederatedQueryNoticesOptions builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the query.
     *
     * @param query the query
     * @return the FederatedQueryNoticesOptions builder
     */
    public Builder query(String query) {
      this.query = query;
      return this;
    }

    /**
     * Set the naturalLanguageQuery.
     *
     * @param naturalLanguageQuery the naturalLanguageQuery
     * @return the FederatedQueryNoticesOptions builder
     */
    public Builder naturalLanguageQuery(String naturalLanguageQuery) {
      this.naturalLanguageQuery = naturalLanguageQuery;
      return this;
    }

    /**
     * Set the aggregation.
     *
     * @param aggregation the aggregation
     * @return the FederatedQueryNoticesOptions builder
     */
    public Builder aggregation(String aggregation) {
      this.aggregation = aggregation;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the FederatedQueryNoticesOptions builder
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
     * @return the FederatedQueryNoticesOptions builder
     */
    public Builder xReturn(List<String> xReturn) {
      this.xReturn = xReturn;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the FederatedQueryNoticesOptions builder
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
     * @return the FederatedQueryNoticesOptions builder
     */
    public Builder sort(List<String> sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the highlight.
     *
     * @param highlight the highlight
     * @return the FederatedQueryNoticesOptions builder
     */
    public Builder highlight(Boolean highlight) {
      this.highlight = highlight;
      return this;
    }

    /**
     * Set the deduplicateField.
     *
     * @param deduplicateField the deduplicateField
     * @return the FederatedQueryNoticesOptions builder
     */
    public Builder deduplicateField(String deduplicateField) {
      this.deduplicateField = deduplicateField;
      return this;
    }

    /**
     * Set the similar.
     *
     * @param similar the similar
     * @return the FederatedQueryNoticesOptions builder
     */
    public Builder similar(Boolean similar) {
      this.similar = similar;
      return this;
    }

    /**
     * Set the similarDocumentIds.
     * Existing similarDocumentIds will be replaced.
     *
     * @param similarDocumentIds the similarDocumentIds
     * @return the FederatedQueryNoticesOptions builder
     */
    public Builder similarDocumentIds(List<String> similarDocumentIds) {
      this.similarDocumentIds = similarDocumentIds;
      return this;
    }

    /**
     * Set the similarFields.
     * Existing similarFields will be replaced.
     *
     * @param similarFields the similarFields
     * @return the FederatedQueryNoticesOptions builder
     */
    public Builder similarFields(List<String> similarFields) {
      this.similarFields = similarFields;
      return this;
    }
  }

  protected FederatedQueryNoticesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.environmentId,
        "environmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.collectionIds,
        "collectionIds cannot be null");
    environmentId = builder.environmentId;
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
    deduplicateField = builder.deduplicateField;
    similar = builder.similar;
    similarDocumentIds = builder.similarDocumentIds;
    similarFields = builder.similarFields;
  }

  /**
   * New builder.
   *
   * @return a FederatedQueryNoticesOptions builder
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
   * Gets the collectionIds.
   *
   * A comma-separated list of collection IDs to be queried against.
   *
   * @return the collectionIds
   */
  public List<String> collectionIds() {
    return collectionIds;
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
   * Gets the deduplicateField.
   *
   * When specified, duplicate results based on the field specified are removed from the returned results. Duplicate
   * comparison is limited to the current query only, **offset** is not considered. This parameter is currently Beta
   * functionality.
   *
   * @return the deduplicateField
   */
  public String deduplicateField() {
    return deduplicateField;
  }

  /**
   * Gets the similar.
   *
   * When `true`, results are returned based on their similarity to the document IDs specified in the
   * **similar.document_ids** parameter.
   *
   * @return the similar
   */
  public Boolean similar() {
    return similar;
  }

  /**
   * Gets the similarDocumentIds.
   *
   * A comma-separated list of document IDs to find similar documents.
   *
   * **Tip:** Include the **natural_language_query** parameter to expand the scope of the document similarity search
   * with the natural language query. Other query parameters, such as **filter** and **query**, are subsequently applied
   * and reduce the scope.
   *
   * @return the similarDocumentIds
   */
  public List<String> similarDocumentIds() {
    return similarDocumentIds;
  }

  /**
   * Gets the similarFields.
   *
   * A comma-separated list of field names that are used as a basis for comparison to identify similar documents. If not
   * specified, the entire document is used for comparison.
   *
   * @return the similarFields
   */
  public List<String> similarFields() {
    return similarFields;
  }
}

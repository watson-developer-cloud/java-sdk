/*
 * (C) Copyright IBM Corp. 2021, 2024.
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

/** The queryCollectionNotices options. */
public class QueryCollectionNoticesOptions extends GenericModel {

  protected String projectId;
  protected String collectionId;
  protected String filter;
  protected String query;
  protected String naturalLanguageQuery;
  protected Long count;
  protected Long offset;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String collectionId;
    private String filter;
    private String query;
    private String naturalLanguageQuery;
    private Long count;
    private Long offset;

    /**
     * Instantiates a new Builder from an existing QueryCollectionNoticesOptions instance.
     *
     * @param queryCollectionNoticesOptions the instance to initialize the Builder with
     */
    private Builder(QueryCollectionNoticesOptions queryCollectionNoticesOptions) {
      this.projectId = queryCollectionNoticesOptions.projectId;
      this.collectionId = queryCollectionNoticesOptions.collectionId;
      this.filter = queryCollectionNoticesOptions.filter;
      this.query = queryCollectionNoticesOptions.query;
      this.naturalLanguageQuery = queryCollectionNoticesOptions.naturalLanguageQuery;
      this.count = queryCollectionNoticesOptions.count;
      this.offset = queryCollectionNoticesOptions.offset;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param collectionId the collectionId
     */
    public Builder(String projectId, String collectionId) {
      this.projectId = projectId;
      this.collectionId = collectionId;
    }

    /**
     * Builds a QueryCollectionNoticesOptions.
     *
     * @return the new QueryCollectionNoticesOptions instance
     */
    public QueryCollectionNoticesOptions build() {
      return new QueryCollectionNoticesOptions(this);
    }

    /**
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the QueryCollectionNoticesOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the QueryCollectionNoticesOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the QueryCollectionNoticesOptions builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the query.
     *
     * @param query the query
     * @return the QueryCollectionNoticesOptions builder
     */
    public Builder query(String query) {
      this.query = query;
      return this;
    }

    /**
     * Set the naturalLanguageQuery.
     *
     * @param naturalLanguageQuery the naturalLanguageQuery
     * @return the QueryCollectionNoticesOptions builder
     */
    public Builder naturalLanguageQuery(String naturalLanguageQuery) {
      this.naturalLanguageQuery = naturalLanguageQuery;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the QueryCollectionNoticesOptions builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the QueryCollectionNoticesOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }
  }

  protected QueryCollectionNoticesOptions() {}

  protected QueryCollectionNoticesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    projectId = builder.projectId;
    collectionId = builder.collectionId;
    filter = builder.filter;
    query = builder.query;
    naturalLanguageQuery = builder.naturalLanguageQuery;
    count = builder.count;
    offset = builder.offset;
  }

  /**
   * New builder.
   *
   * @return a QueryCollectionNoticesOptions builder
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
   * Gets the collectionId.
   *
   * <p>The Universally Unique Identifier (UUID) of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the filter.
   *
   * <p>Searches for documents that match the Discovery Query Language criteria that is specified as
   * input. Filter calls are cached and are faster than query calls because the results are not
   * ordered by relevance. When used with the `aggregation`, `query`, or `natural_language_query`
   * parameters, the `filter` parameter runs first. This parameter is useful for limiting results to
   * those that contain specific metadata values.
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
   * documents listed first. You can use this parameter or the **natural_language_query** parameter
   * to specify the query input, but not both.
   *
   * @return the query
   */
  public String query() {
    return query;
  }

  /**
   * Gets the naturalLanguageQuery.
   *
   * <p>A natural language query that returns relevant documents by using natural language
   * understanding. You can use this parameter or the **query** parameter to specify the query
   * input, but not both. To filter the results based on criteria you specify, include the
   * **filter** parameter in the request.
   *
   * @return the naturalLanguageQuery
   */
  public String naturalLanguageQuery() {
    return naturalLanguageQuery;
  }

  /**
   * Gets the count.
   *
   * <p>Number of results to return. The maximum for the **count** and **offset** values together in
   * any one query is **10,000**.
   *
   * @return the count
   */
  public Long count() {
    return count;
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
}

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
package com.ibm.watson.discovery.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** Default query parameters for this project. */
public class DefaultQueryParams extends GenericModel {

  @SerializedName("collection_ids")
  protected List<String> collectionIds;

  protected DefaultQueryParamsPassages passages;

  @SerializedName("table_results")
  protected DefaultQueryParamsTableResults tableResults;

  protected String aggregation;

  @SerializedName("suggested_refinements")
  protected DefaultQueryParamsSuggestedRefinements suggestedRefinements;

  @SerializedName("spelling_suggestions")
  protected Boolean spellingSuggestions;

  protected Boolean highlight;
  protected Long count;
  protected String sort;

  @SerializedName("return")
  protected List<String> xReturn;

  /** Builder. */
  public static class Builder {
    private List<String> collectionIds;
    private DefaultQueryParamsPassages passages;
    private DefaultQueryParamsTableResults tableResults;
    private String aggregation;
    private DefaultQueryParamsSuggestedRefinements suggestedRefinements;
    private Boolean spellingSuggestions;
    private Boolean highlight;
    private Long count;
    private String sort;
    private List<String> xReturn;

    private Builder(DefaultQueryParams defaultQueryParams) {
      this.collectionIds = defaultQueryParams.collectionIds;
      this.passages = defaultQueryParams.passages;
      this.tableResults = defaultQueryParams.tableResults;
      this.aggregation = defaultQueryParams.aggregation;
      this.suggestedRefinements = defaultQueryParams.suggestedRefinements;
      this.spellingSuggestions = defaultQueryParams.spellingSuggestions;
      this.highlight = defaultQueryParams.highlight;
      this.count = defaultQueryParams.count;
      this.sort = defaultQueryParams.sort;
      this.xReturn = defaultQueryParams.xReturn;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a DefaultQueryParams.
     *
     * @return the defaultQueryParams
     */
    public DefaultQueryParams build() {
      return new DefaultQueryParams(this);
    }

    /**
     * Adds an collectionIds to collectionIds.
     *
     * @param collectionIds the new collectionIds
     * @return the DefaultQueryParams builder
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
     * Adds an xReturn to xReturn.
     *
     * @param xReturn the new xReturn
     * @return the DefaultQueryParams builder
     */
    public Builder addXReturn(String xReturn) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(xReturn, "xReturn cannot be null");
      if (this.xReturn == null) {
        this.xReturn = new ArrayList<String>();
      }
      this.xReturn.add(xReturn);
      return this;
    }

    /**
     * Set the collectionIds. Existing collectionIds will be replaced.
     *
     * @param collectionIds the collectionIds
     * @return the DefaultQueryParams builder
     */
    public Builder collectionIds(List<String> collectionIds) {
      this.collectionIds = collectionIds;
      return this;
    }

    /**
     * Set the passages.
     *
     * @param passages the passages
     * @return the DefaultQueryParams builder
     */
    public Builder passages(DefaultQueryParamsPassages passages) {
      this.passages = passages;
      return this;
    }

    /**
     * Set the tableResults.
     *
     * @param tableResults the tableResults
     * @return the DefaultQueryParams builder
     */
    public Builder tableResults(DefaultQueryParamsTableResults tableResults) {
      this.tableResults = tableResults;
      return this;
    }

    /**
     * Set the aggregation.
     *
     * @param aggregation the aggregation
     * @return the DefaultQueryParams builder
     */
    public Builder aggregation(String aggregation) {
      this.aggregation = aggregation;
      return this;
    }

    /**
     * Set the suggestedRefinements.
     *
     * @param suggestedRefinements the suggestedRefinements
     * @return the DefaultQueryParams builder
     */
    public Builder suggestedRefinements(
        DefaultQueryParamsSuggestedRefinements suggestedRefinements) {
      this.suggestedRefinements = suggestedRefinements;
      return this;
    }

    /**
     * Set the spellingSuggestions.
     *
     * @param spellingSuggestions the spellingSuggestions
     * @return the DefaultQueryParams builder
     */
    public Builder spellingSuggestions(Boolean spellingSuggestions) {
      this.spellingSuggestions = spellingSuggestions;
      return this;
    }

    /**
     * Set the highlight.
     *
     * @param highlight the highlight
     * @return the DefaultQueryParams builder
     */
    public Builder highlight(Boolean highlight) {
      this.highlight = highlight;
      return this;
    }

    /**
     * Set the count.
     *
     * @param count the count
     * @return the DefaultQueryParams builder
     */
    public Builder count(long count) {
      this.count = count;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the DefaultQueryParams builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the xReturn. Existing xReturn will be replaced.
     *
     * @param xReturn the xReturn
     * @return the DefaultQueryParams builder
     */
    public Builder xReturn(List<String> xReturn) {
      this.xReturn = xReturn;
      return this;
    }
  }

  protected DefaultQueryParams(Builder builder) {
    collectionIds = builder.collectionIds;
    passages = builder.passages;
    tableResults = builder.tableResults;
    aggregation = builder.aggregation;
    suggestedRefinements = builder.suggestedRefinements;
    spellingSuggestions = builder.spellingSuggestions;
    highlight = builder.highlight;
    count = builder.count;
    sort = builder.sort;
    xReturn = builder.xReturn;
  }

  /**
   * New builder.
   *
   * @return a DefaultQueryParams builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the collectionIds.
   *
   * <p>An array of collection identifiers to query. If empty or omitted all collections in the
   * project are queried.
   *
   * @return the collectionIds
   */
  public List<String> collectionIds() {
    return collectionIds;
  }

  /**
   * Gets the passages.
   *
   * <p>Default settings configuration for passage search options.
   *
   * @return the passages
   */
  public DefaultQueryParamsPassages passages() {
    return passages;
  }

  /**
   * Gets the tableResults.
   *
   * <p>Default project query settings for table results.
   *
   * @return the tableResults
   */
  public DefaultQueryParamsTableResults tableResults() {
    return tableResults;
  }

  /**
   * Gets the aggregation.
   *
   * <p>A string representing the default aggregation query for the project.
   *
   * @return the aggregation
   */
  public String aggregation() {
    return aggregation;
  }

  /**
   * Gets the suggestedRefinements.
   *
   * <p>Object containing suggested refinement settings.
   *
   * @return the suggestedRefinements
   */
  public DefaultQueryParamsSuggestedRefinements suggestedRefinements() {
    return suggestedRefinements;
  }

  /**
   * Gets the spellingSuggestions.
   *
   * <p>When `true`, a spelling suggestions for the query are retuned by default.
   *
   * @return the spellingSuggestions
   */
  public Boolean spellingSuggestions() {
    return spellingSuggestions;
  }

  /**
   * Gets the highlight.
   *
   * <p>When `true`, a highlights for the query are retuned by default.
   *
   * @return the highlight
   */
  public Boolean highlight() {
    return highlight;
  }

  /**
   * Gets the count.
   *
   * <p>The number of document results returned by default.
   *
   * @return the count
   */
  public Long count() {
    return count;
  }

  /**
   * Gets the sort.
   *
   * <p>A comma separated list of document fields to sort results by default.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }

  /**
   * Gets the xReturn.
   *
   * <p>An array of field names to return in document results if present by default.
   *
   * @return the xReturn
   */
  public List<String> xReturn() {
    return xReturn;
  }
}

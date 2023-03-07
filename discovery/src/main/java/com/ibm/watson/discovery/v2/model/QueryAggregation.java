/*
 * (C) Copyright IBM Corp. 2023.
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
import java.util.List;
import java.util.Map;

/**
 * An object that defines how to aggregate query results.
 *
 * <p>Classes which extend this class: - QueryAggregationQueryTermAggregation -
 * QueryAggregationQueryGroupByAggregation - QueryAggregationQueryHistogramAggregation -
 * QueryAggregationQueryTimesliceAggregation - QueryAggregationQueryNestedAggregation -
 * QueryAggregationQueryFilterAggregation - QueryAggregationQueryCalculationAggregation -
 * QueryAggregationQueryTopHitsAggregation - QueryAggregationQueryPairAggregation -
 * QueryAggregationQueryTrendAggregation - QueryAggregationQueryTopicAggregation
 */
public class QueryAggregation extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "type";

  protected static java.util.Map<String, Class<?>> discriminatorMapping;

  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put("term", QueryAggregationQueryTermAggregation.class);
    discriminatorMapping.put("group_by", QueryAggregationQueryGroupByAggregation.class);
    discriminatorMapping.put("histogram", QueryAggregationQueryHistogramAggregation.class);
    discriminatorMapping.put("timeslice", QueryAggregationQueryTimesliceAggregation.class);
    discriminatorMapping.put("nested", QueryAggregationQueryNestedAggregation.class);
    discriminatorMapping.put("filter", QueryAggregationQueryFilterAggregation.class);
    discriminatorMapping.put("min", QueryAggregationQueryCalculationAggregation.class);
    discriminatorMapping.put("max", QueryAggregationQueryCalculationAggregation.class);
    discriminatorMapping.put("sum", QueryAggregationQueryCalculationAggregation.class);
    discriminatorMapping.put("average", QueryAggregationQueryCalculationAggregation.class);
    discriminatorMapping.put("unique_count", QueryAggregationQueryCalculationAggregation.class);
    discriminatorMapping.put("top_hits", QueryAggregationQueryTopHitsAggregation.class);
    discriminatorMapping.put("pair", QueryAggregationQueryPairAggregation.class);
    discriminatorMapping.put("trend", QueryAggregationQueryTrendAggregation.class);
    discriminatorMapping.put("topic", QueryAggregationQueryTopicAggregation.class);
  }

  protected String type;
  protected String field;
  protected Long count;
  protected String name;
  protected List<QueryTermAggregationResult> results;
  protected Long interval;
  protected String path;

  @SerializedName("matching_results")
  protected Long matchingResults;

  protected List<Map<String, Object>> aggregations;
  protected String match;
  protected Double value;
  protected Long size;
  protected QueryTopHitsAggregationResult hits;
  protected String first;
  protected String second;

  @SerializedName("show_estimated_matching_results")
  protected Boolean showEstimatedMatchingResults;

  @SerializedName("show_total_matching_documents")
  protected Boolean showTotalMatchingDocuments;

  protected String facet;

  @SerializedName("time_segments")
  protected String timeSegments;

  protected QueryAggregation() {}

  /**
   * Gets the type.
   *
   * <p>Specifies that the aggregation type is `term`.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the field.
   *
   * <p>The field in the document where the values come from.
   *
   * @return the field
   */
  public String getField() {
    return field;
  }

  /**
   * Gets the count.
   *
   * <p>The number of results returned. Not returned if `relevancy:true` is specified in the
   * request.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }

  /**
   * Gets the name.
   *
   * <p>Identifier specified in the query request of this aggregation. Not returned if
   * `relevancy:true` is specified in the request.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the results.
   *
   * <p>An array of results.
   *
   * @return the results
   */
  public List<QueryTermAggregationResult> getResults() {
    return results;
  }

  /**
   * Gets the interval.
   *
   * <p>The size of the sections that the results are split into.
   *
   * @return the interval
   */
  public Long getInterval() {
    return interval;
  }

  /**
   * Gets the path.
   *
   * <p>The path to the document field to scope subsequent aggregations to.
   *
   * @return the path
   */
  public String getPath() {
    return path;
  }

  /**
   * Gets the matchingResults.
   *
   * <p>Number of nested documents found in the specified field.
   *
   * @return the matchingResults
   */
  public Long getMatchingResults() {
    return matchingResults;
  }

  /**
   * Gets the aggregations.
   *
   * <p>An array of subaggregations.
   *
   * @return the aggregations
   */
  public List<Map<String, Object>> getAggregations() {
    return aggregations;
  }

  /**
   * Gets the match.
   *
   * <p>The filter that is written in Discovery Query Language syntax and is applied to the
   * documents before subaggregations are run.
   *
   * @return the match
   */
  public String getMatch() {
    return match;
  }

  /**
   * Gets the value.
   *
   * <p>The value of the calculation.
   *
   * @return the value
   */
  public Double getValue() {
    return value;
  }

  /**
   * Gets the size.
   *
   * <p>The number of documents to return.
   *
   * @return the size
   */
  public Long getSize() {
    return size;
  }

  /**
   * Gets the hits.
   *
   * <p>A query response that contains the matching documents for the preceding aggregations.
   *
   * @return the hits
   */
  public QueryTopHitsAggregationResult getHits() {
    return hits;
  }

  /**
   * Gets the first.
   *
   * <p>Specifies the first aggregation in the pair. The aggregation must be a `term`, `group_by`,
   * `histogram`, or `timeslice` aggregation type.
   *
   * @return the first
   */
  public String getFirst() {
    return first;
  }

  /**
   * Gets the second.
   *
   * <p>Specifies the second aggregation in the pair. The aggregation must be a `term`, `group_by`,
   * `histogram`, or `timeslice` aggregation type.
   *
   * @return the second
   */
  public String getSecond() {
    return second;
  }

  /**
   * Gets the showEstimatedMatchingResults.
   *
   * <p>Indicates whether to include estimated matching result information.
   *
   * @return the showEstimatedMatchingResults
   */
  public Boolean isShowEstimatedMatchingResults() {
    return showEstimatedMatchingResults;
  }

  /**
   * Gets the showTotalMatchingDocuments.
   *
   * <p>Indicates whether to include total matching documents information.
   *
   * @return the showTotalMatchingDocuments
   */
  public Boolean isShowTotalMatchingDocuments() {
    return showTotalMatchingDocuments;
  }

  /**
   * Gets the facet.
   *
   * <p>Specifies the `term` or `group_by` aggregation for the facet that you want to analyze.
   *
   * @return the facet
   */
  public String getFacet() {
    return facet;
  }

  /**
   * Gets the timeSegments.
   *
   * <p>Specifies the `timeslice` aggregation that defines the time segments.
   *
   * @return the timeSegments
   */
  public String getTimeSegments() {
    return timeSegments;
  }
}

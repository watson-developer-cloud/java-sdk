/*
 * (C) Copyright IBM Corp. 2019, 2023.
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
import java.util.Date;
import java.util.List;

/** Object that contains training query details. */
public class TrainingQuery extends GenericModel {

  @SerializedName("query_id")
  protected String queryId;

  @SerializedName("natural_language_query")
  protected String naturalLanguageQuery;

  protected String filter;
  protected Date created;
  protected Date updated;
  protected List<TrainingExample> examples;

  /** Builder. */
  public static class Builder {
    private String naturalLanguageQuery;
    private String filter;
    private List<TrainingExample> examples;

    /**
     * Instantiates a new Builder from an existing TrainingQuery instance.
     *
     * @param trainingQuery the instance to initialize the Builder with
     */
    private Builder(TrainingQuery trainingQuery) {
      this.naturalLanguageQuery = trainingQuery.naturalLanguageQuery;
      this.filter = trainingQuery.filter;
      this.examples = trainingQuery.examples;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param naturalLanguageQuery the naturalLanguageQuery
     * @param examples the examples
     */
    public Builder(String naturalLanguageQuery, List<TrainingExample> examples) {
      this.naturalLanguageQuery = naturalLanguageQuery;
      this.examples = examples;
    }

    /**
     * Builds a TrainingQuery.
     *
     * @return the new TrainingQuery instance
     */
    public TrainingQuery build() {
      return new TrainingQuery(this);
    }

    /**
     * Adds an examples to examples.
     *
     * @param examples the new examples
     * @return the TrainingQuery builder
     */
    public Builder addExamples(TrainingExample examples) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(examples, "examples cannot be null");
      if (this.examples == null) {
        this.examples = new ArrayList<TrainingExample>();
      }
      this.examples.add(examples);
      return this;
    }

    /**
     * Set the naturalLanguageQuery.
     *
     * @param naturalLanguageQuery the naturalLanguageQuery
     * @return the TrainingQuery builder
     */
    public Builder naturalLanguageQuery(String naturalLanguageQuery) {
      this.naturalLanguageQuery = naturalLanguageQuery;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the TrainingQuery builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the examples. Existing examples will be replaced.
     *
     * @param examples the examples
     * @return the TrainingQuery builder
     */
    public Builder examples(List<TrainingExample> examples) {
      this.examples = examples;
      return this;
    }
  }

  protected TrainingQuery() {}

  protected TrainingQuery(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.naturalLanguageQuery, "naturalLanguageQuery cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.examples, "examples cannot be null");
    naturalLanguageQuery = builder.naturalLanguageQuery;
    filter = builder.filter;
    examples = builder.examples;
  }

  /**
   * New builder.
   *
   * @return a TrainingQuery builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the queryId.
   *
   * <p>The query ID associated with the training query.
   *
   * @return the queryId
   */
  public String queryId() {
    return queryId;
  }

  /**
   * Gets the naturalLanguageQuery.
   *
   * <p>The natural text query that is used as the training query.
   *
   * @return the naturalLanguageQuery
   */
  public String naturalLanguageQuery() {
    return naturalLanguageQuery;
  }

  /**
   * Gets the filter.
   *
   * <p>The filter used on the collection before the **natural_language_query** is applied.
   *
   * @return the filter
   */
  public String filter() {
    return filter;
  }

  /**
   * Gets the created.
   *
   * <p>The date and time the query was created.
   *
   * @return the created
   */
  public Date created() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * <p>The date and time the query was updated.
   *
   * @return the updated
   */
  public Date updated() {
    return updated;
  }

  /**
   * Gets the examples.
   *
   * <p>Array of training examples.
   *
   * @return the examples
   */
  public List<TrainingExample> examples() {
    return examples;
  }
}

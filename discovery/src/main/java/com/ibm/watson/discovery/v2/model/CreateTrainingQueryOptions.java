/*
 * (C) Copyright IBM Corp. 2019, 2021.
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

/** The createTrainingQuery options. */
public class CreateTrainingQueryOptions extends GenericModel {

  protected String projectId;
  protected String naturalLanguageQuery;
  protected List<TrainingExample> examples;
  protected String filter;

  /** Builder. */
  public static class Builder {
    private String projectId;
    private String naturalLanguageQuery;
    private List<TrainingExample> examples;
    private String filter;

    private Builder(CreateTrainingQueryOptions createTrainingQueryOptions) {
      this.projectId = createTrainingQueryOptions.projectId;
      this.naturalLanguageQuery = createTrainingQueryOptions.naturalLanguageQuery;
      this.examples = createTrainingQueryOptions.examples;
      this.filter = createTrainingQueryOptions.filter;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param projectId the projectId
     * @param naturalLanguageQuery the naturalLanguageQuery
     * @param examples the examples
     */
    public Builder(String projectId, String naturalLanguageQuery, List<TrainingExample> examples) {
      this.projectId = projectId;
      this.naturalLanguageQuery = naturalLanguageQuery;
      this.examples = examples;
    }

    /**
     * Builds a CreateTrainingQueryOptions.
     *
     * @return the new CreateTrainingQueryOptions instance
     */
    public CreateTrainingQueryOptions build() {
      return new CreateTrainingQueryOptions(this);
    }

    /**
     * Adds an examples to examples.
     *
     * @param examples the new examples
     * @return the CreateTrainingQueryOptions builder
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
     * Set the projectId.
     *
     * @param projectId the projectId
     * @return the CreateTrainingQueryOptions builder
     */
    public Builder projectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set the naturalLanguageQuery.
     *
     * @param naturalLanguageQuery the naturalLanguageQuery
     * @return the CreateTrainingQueryOptions builder
     */
    public Builder naturalLanguageQuery(String naturalLanguageQuery) {
      this.naturalLanguageQuery = naturalLanguageQuery;
      return this;
    }

    /**
     * Set the examples. Existing examples will be replaced.
     *
     * @param examples the examples
     * @return the CreateTrainingQueryOptions builder
     */
    public Builder examples(List<TrainingExample> examples) {
      this.examples = examples;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the CreateTrainingQueryOptions builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the trainingQuery.
     *
     * @param trainingQuery the trainingQuery
     * @return the CreateTrainingQueryOptions builder
     */
    public Builder trainingQuery(TrainingQuery trainingQuery) {
      this.naturalLanguageQuery = trainingQuery.naturalLanguageQuery();
      this.examples = trainingQuery.examples();
      this.filter = trainingQuery.filter();
      return this;
    }
  }

  protected CreateTrainingQueryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.projectId, "projectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.naturalLanguageQuery, "naturalLanguageQuery cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.examples, "examples cannot be null");
    projectId = builder.projectId;
    naturalLanguageQuery = builder.naturalLanguageQuery;
    examples = builder.examples;
    filter = builder.filter;
  }

  /**
   * New builder.
   *
   * @return a CreateTrainingQueryOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the projectId.
   *
   * <p>The ID of the project. This information can be found from the *Integrate and Deploy* page in
   * Discovery.
   *
   * @return the projectId
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Gets the naturalLanguageQuery.
   *
   * <p>The natural text query for the training query.
   *
   * @return the naturalLanguageQuery
   */
  public String naturalLanguageQuery() {
    return naturalLanguageQuery;
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
}

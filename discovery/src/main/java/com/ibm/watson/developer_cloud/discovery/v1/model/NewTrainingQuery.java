/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * NewTrainingQuery.
 */
public class NewTrainingQuery extends GenericModel {

  @SerializedName("natural_language_query")
  private String naturalLanguageQuery;
  private String filter;
  private List<TrainingExample> examples;

  /**
   * Gets the naturalLanguageQuery.
   *
   * @return the naturalLanguageQuery
   */
  public String getNaturalLanguageQuery() {
    return naturalLanguageQuery;
  }

  /**
   * Gets the filter.
   *
   * @return the filter
   */
  public String getFilter() {
    return filter;
  }

  /**
   * Gets the examples.
   *
   * @return the examples
   */
  public List<TrainingExample> getExamples() {
    return examples;
  }

  /**
   * Sets the naturalLanguageQuery.
   *
   * @param naturalLanguageQuery the new naturalLanguageQuery
   */
  public void setNaturalLanguageQuery(final String naturalLanguageQuery) {
    this.naturalLanguageQuery = naturalLanguageQuery;
  }

  /**
   * Sets the filter.
   *
   * @param filter the new filter
   */
  public void setFilter(final String filter) {
    this.filter = filter;
  }

  /**
   * Sets the examples.
   *
   * @param examples the new examples
   */
  public void setExamples(final List<TrainingExample> examples) {
    this.examples = examples;
  }
}

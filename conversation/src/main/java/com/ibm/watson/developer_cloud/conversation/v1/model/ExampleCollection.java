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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * ExampleCollection.
 */
public class ExampleCollection extends GenericModel {

  private List<Example> examples;
  private Pagination pagination;

  /**
   * Gets the examples.
   *
   * An array of Example objects describing the examples defined for the intent.
   *
   * @return the examples
   */
  public List<Example> getExamples() {
    return examples;
  }

  /**
   * Gets the pagination.
   *
   * An object defining the pagination data for the returned objects.
   *
   * @return the pagination
   */
  public Pagination getPagination() {
    return pagination;
  }

  /**
   * Sets the examples.
   *
   * @param examples the new examples
   */
  public void setExamples(final List<Example> examples) {
    this.examples = examples;
  }

  /**
   * Sets the pagination.
   *
   * @param pagination the new pagination
   */
  public void setPagination(final Pagination pagination) {
    this.pagination = pagination;
  }
}

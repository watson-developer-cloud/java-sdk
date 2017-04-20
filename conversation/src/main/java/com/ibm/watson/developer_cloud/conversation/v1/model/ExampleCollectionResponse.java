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
 * ExampleCollectionResponse.
 */
public class ExampleCollectionResponse extends GenericModel {

  /** An array of ExampleResponse objects describing the examples defined for the intent. */
  private List<ExampleResponse> examples;
  private PaginationResponse pagination;

  /**
   * Gets the examples.
   *
   * @return the examples
   */
  public List<ExampleResponse> getExamples() {
    return examples;
  }

  /**
   * Gets the pagination.
   *
   * @return the pagination
   */
  public PaginationResponse getPagination() {
    return pagination;
  }

  /**
   * Sets the examples.
   *
   * @param examples the new examples
   */
  public void setExamples(final List<ExampleResponse> examples) {
    this.examples = examples;
  }

  /**
   * Sets the pagination.
   *
   * @param pagination the new pagination
   */
  public void setPagination(final PaginationResponse pagination) {
    this.pagination = pagination;
  }
}

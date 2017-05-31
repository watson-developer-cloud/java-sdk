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
 * ValueCollectionResponse.
 */
public class ValueCollectionResponse extends GenericModel {

  /** An array of entity values. */
  private List<ValueExportResponse> values;
  private PaginationResponse pagination;

  /**
   * Gets the values.
   *
   * @return the values
   */
  public List<ValueExportResponse> getValues() {
    return values;
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
   * Sets the values.
   *
   * @param values the new values
   */
  public void setValues(final List<ValueExportResponse> values) {
    this.values = values;
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

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
 * IntentCollection.
 */
public class IntentCollection extends GenericModel {

  private List<IntentExport> intents;
  private Pagination pagination;

  /**
   * Gets the intents.
   *
   * An array of intents.
   *
   * @return the intents
   */
  public List<IntentExport> getIntents() {
    return intents;
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
   * Sets the intents.
   *
   * @param intents the new intents
   */
  public void setIntents(final List<IntentExport> intents) {
    this.intents = intents;
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

/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.assistant.v1.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * IntentCollection.
 */
public class IntentCollection extends GenericModel {

  private List<IntentExport> intents;
  private Pagination pagination;

  /**
   * Gets the intents.
   *
   * An array of objects describing the intents defined for the workspace.
   *
   * @return the intents
   */
  public List<IntentExport> getIntents() {
    return intents;
  }

  /**
   * Gets the pagination.
   *
   * The pagination data for the returned objects.
   *
   * @return the pagination
   */
  public Pagination getPagination() {
    return pagination;
  }
}

/*
 * (C) Copyright IBM Corp. 2022, 2024.
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

package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** EnvironmentCollection. */
public class EnvironmentCollection extends GenericModel {

  protected List<Environment> environments;
  protected Pagination pagination;

  protected EnvironmentCollection() {}

  /**
   * Gets the environments.
   *
   * <p>An array of objects describing the environments associated with an assistant.
   *
   * @return the environments
   */
  public List<Environment> getEnvironments() {
    return environments;
  }

  /**
   * Gets the pagination.
   *
   * <p>The pagination data for the returned objects. For more information about using pagination,
   * see [Pagination](#pagination).
   *
   * @return the pagination
   */
  public Pagination getPagination() {
    return pagination;
  }
}

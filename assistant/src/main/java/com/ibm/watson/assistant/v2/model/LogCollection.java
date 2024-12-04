/*
 * (C) Copyright IBM Corp. 2024.
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

/** LogCollection. */
public class LogCollection extends GenericModel {

  protected List<Log> logs;
  protected LogPagination pagination;

  protected LogCollection() {}

  /**
   * Gets the logs.
   *
   * <p>An array of objects describing log events.
   *
   * @return the logs
   */
  public List<Log> getLogs() {
    return logs;
  }

  /**
   * Gets the pagination.
   *
   * <p>The pagination data for the returned objects. For more information about using pagination,
   * see [Pagination](#pagination).
   *
   * @return the pagination
   */
  public LogPagination getPagination() {
    return pagination;
  }
}

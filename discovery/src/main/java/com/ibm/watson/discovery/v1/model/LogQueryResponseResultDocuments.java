/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.discovery.v1.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object containing result information that was returned by the query used to create this log entry. Only returned with
 * logs of type `query`.
 */
public class LogQueryResponseResultDocuments extends GenericModel {

  protected List<LogQueryResponseResultDocumentsResult> results;
  protected Long count;

  /**
   * Gets the results.
   *
   * Array of log query response results.
   *
   * @return the results
   */
  public List<LogQueryResponseResultDocumentsResult> getResults() {
    return results;
  }

  /**
   * Gets the count.
   *
   * The number of results returned in the query associate with this log.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }
}

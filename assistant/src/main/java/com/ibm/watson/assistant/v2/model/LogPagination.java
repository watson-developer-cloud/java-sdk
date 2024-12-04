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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The pagination data for the returned objects. For more information about using pagination, see
 * [Pagination](#pagination).
 */
public class LogPagination extends GenericModel {

  @SerializedName("next_url")
  protected String nextUrl;

  protected Long matched;

  @SerializedName("next_cursor")
  protected String nextCursor;

  protected LogPagination() {}

  /**
   * Gets the nextUrl.
   *
   * <p>The URL that will return the next page of results, if any.
   *
   * @return the nextUrl
   */
  public String getNextUrl() {
    return nextUrl;
  }

  /**
   * Gets the matched.
   *
   * <p>Reserved for future use.
   *
   * @return the matched
   */
  public Long getMatched() {
    return matched;
  }

  /**
   * Gets the nextCursor.
   *
   * <p>A token identifying the next page of results.
   *
   * @return the nextCursor
   */
  public String getNextCursor() {
    return nextCursor;
  }
}

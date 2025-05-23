/*
 * (C) Copyright IBM Corp. 2025.
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

/** SearchResults. */
public class SearchResults extends GenericModel {

  @SerializedName("result_metadata")
  protected SearchResultsResultMetadata resultMetadata;

  protected String id;
  protected String title;
  protected String body;

  protected SearchResults() {}

  /**
   * Gets the resultMetadata.
   *
   * <p>The metadata of the search result.
   *
   * @return the resultMetadata
   */
  public SearchResultsResultMetadata getResultMetadata() {
    return resultMetadata;
  }

  /**
   * Gets the id.
   *
   * <p>The ID of the search result. It may not be unique.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the title.
   *
   * <p>The title of the search result.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the body.
   *
   * <p>The body content of the search result.
   *
   * @return the body
   */
  public String getBody() {
    return body;
  }
}

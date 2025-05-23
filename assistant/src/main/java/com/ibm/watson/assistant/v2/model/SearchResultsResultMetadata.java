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

/** The metadata of the search result. */
public class SearchResultsResultMetadata extends GenericModel {

  @SerializedName("document_retrieval_source")
  protected String documentRetrievalSource;

  protected Long score;

  protected SearchResultsResultMetadata() {}

  /**
   * Gets the documentRetrievalSource.
   *
   * <p>The source of the search result.
   *
   * @return the documentRetrievalSource
   */
  public String getDocumentRetrievalSource() {
    return documentRetrievalSource;
  }

  /**
   * Gets the score.
   *
   * <p>The relevance score of the search result to the user query.
   *
   * @return the score
   */
  public Long getScore() {
    return score;
  }
}

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

package com.ibm.watson.discovery.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** Response object that contains an array of documents. */
public class ListDocumentsResponse extends GenericModel {

  @SerializedName("matching_results")
  protected Long matchingResults;

  protected List<DocumentDetails> documents;

  protected ListDocumentsResponse() {}

  /**
   * Gets the matchingResults.
   *
   * <p>The number of matching results for the document query.
   *
   * @return the matchingResults
   */
  public Long getMatchingResults() {
    return matchingResults;
  }

  /**
   * Gets the documents.
   *
   * <p>An array that lists the documents in a collection. Only the document ID of each document is
   * returned in the list. You can use the [Get document](#getdocument) method to get more
   * information about an individual document.
   *
   * @return the documents
   */
  public List<DocumentDetails> getDocuments() {
    return documents;
  }
}

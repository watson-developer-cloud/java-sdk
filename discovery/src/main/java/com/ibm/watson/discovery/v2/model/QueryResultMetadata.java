/*
 * (C) Copyright IBM Corp. 2023.
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

/** Metadata of a query result. */
public class QueryResultMetadata extends GenericModel {

  /** The document retrieval source that produced this search result. */
  public interface DocumentRetrievalSource {
    /** search. */
    String SEARCH = "search";
    /** curation. */
    String CURATION = "curation";
  }

  @SerializedName("document_retrieval_source")
  protected String documentRetrievalSource;

  @SerializedName("collection_id")
  protected String collectionId;

  protected Double confidence;

  protected QueryResultMetadata() {}

  /**
   * Gets the documentRetrievalSource.
   *
   * <p>The document retrieval source that produced this search result.
   *
   * @return the documentRetrievalSource
   */
  public String getDocumentRetrievalSource() {
    return documentRetrievalSource;
  }

  /**
   * Gets the collectionId.
   *
   * <p>The collection id associated with this training data set.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return collectionId;
  }

  /**
   * Gets the confidence.
   *
   * <p>The confidence score for the given result. Calculated based on how relevant the result is
   * estimated to be. The score can range from `0.0` to `1.0`. The higher the number, the more
   * relevant the document. The `confidence` value for a result was calculated using the model
   * specified in the `document_retrieval_strategy` field of the result set. This field is returned
   * only if the **natural_language_query** parameter is specified in the query.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }
}

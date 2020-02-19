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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Each object in the **results** array corresponds to an individual document returned by the original query.
 */
public class LogQueryResponseResultDocumentsResult extends GenericModel {

  protected Long position;
  @SerializedName("document_id")
  protected String documentId;
  protected Double score;
  protected Double confidence;
  @SerializedName("collection_id")
  protected String collectionId;

  /**
   * Gets the position.
   *
   * The result rank of this document. A position of `1` indicates that it was the first returned result.
   *
   * @return the position
   */
  public Long getPosition() {
    return position;
  }

  /**
   * Gets the documentId.
   *
   * The **document_id** of the document that this result represents.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the score.
   *
   * The raw score of this result. A higher score indicates a greater match to the query parameters.
   *
   * @return the score
   */
  public Double getScore() {
    return score;
  }

  /**
   * Gets the confidence.
   *
   * The confidence score of the result's analysis. A higher score indicating greater confidence.
   *
   * @return the confidence
   */
  public Double getConfidence() {
    return confidence;
  }

  /**
   * Gets the collectionId.
   *
   * The **collection_id** of the document represented by this result.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return collectionId;
  }
}


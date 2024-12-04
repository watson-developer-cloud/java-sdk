/*
 * (C) Copyright IBM Corp. 2020, 2024.
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

/** A passage query response. */
public class QueryResponsePassage extends GenericModel {

  @SerializedName("passage_text")
  protected String passageText;

  @SerializedName("passage_score")
  protected Double passageScore;

  @SerializedName("document_id")
  protected String documentId;

  @SerializedName("collection_id")
  protected String collectionId;

  @SerializedName("start_offset")
  protected Long startOffset;

  @SerializedName("end_offset")
  protected Long endOffset;

  protected String field;
  protected List<ResultPassageAnswer> answers;

  protected QueryResponsePassage() {}

  /**
   * Gets the passageText.
   *
   * <p>The content of the extracted passage.
   *
   * @return the passageText
   */
  public String getPassageText() {
    return passageText;
  }

  /**
   * Gets the passageScore.
   *
   * <p>The confidence score of the passage's analysis. A higher score indicates greater confidence.
   * The score is used to rank the passages from all documents and is returned only if
   * **passages.per_document** is `false`.
   *
   * @return the passageScore
   */
  public Double getPassageScore() {
    return passageScore;
  }

  /**
   * Gets the documentId.
   *
   * <p>The unique identifier of the ingested document.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the collectionId.
   *
   * <p>The unique identifier of the collection.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return collectionId;
  }

  /**
   * Gets the startOffset.
   *
   * <p>The position of the first character of the extracted passage in the originating field.
   *
   * @return the startOffset
   */
  public Long getStartOffset() {
    return startOffset;
  }

  /**
   * Gets the endOffset.
   *
   * <p>The position after the last character of the extracted passage in the originating field.
   *
   * @return the endOffset
   */
  public Long getEndOffset() {
    return endOffset;
  }

  /**
   * Gets the field.
   *
   * <p>The label of the field from which the passage has been extracted.
   *
   * @return the field
   */
  public String getField() {
    return field;
  }

  /**
   * Gets the answers.
   *
   * <p>An array of extracted answers to the specified query. Returned for natural language queries
   * when **passages.per_document** is `false`.
   *
   * @return the answers
   */
  public List<ResultPassageAnswer> getAnswers() {
    return answers;
  }
}

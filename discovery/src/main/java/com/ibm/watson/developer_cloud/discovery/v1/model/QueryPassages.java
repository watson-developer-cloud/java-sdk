/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * QueryPassages.
 */
public class QueryPassages extends GenericModel {

  @SerializedName("document_id")
  private String documentId;
  @SerializedName("passage_score")
  private Double passageScore;
  @SerializedName("passage_text")
  private String passageText;
  @SerializedName("start_offset")
  private Long startOffset;
  @SerializedName("end_offset")
  private Long endOffset;
  private String field;

  /**
   * Gets the documentId.
   *
   * The unique identifier of the document from which the passage has been extracted.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the passageScore.
   *
   * The confidence score of the passages's analysis. A higher score indicates greater confidence.
   *
   * @return the passageScore
   */
  public Double getPassageScore() {
    return passageScore;
  }

  /**
   * Gets the passageText.
   *
   * The content of the extracted passage.
   *
   * @return the passageText
   */
  public String getPassageText() {
    return passageText;
  }

  /**
   * Gets the startOffset.
   *
   * The position of the first character of the extracted passage in the originating field.
   *
   * @return the startOffset
   */
  public Long getStartOffset() {
    return startOffset;
  }

  /**
   * Gets the endOffset.
   *
   * The position of the last character of the extracted passage in the originating field.
   *
   * @return the endOffset
   */
  public Long getEndOffset() {
    return endOffset;
  }

  /**
   * Gets the field.
   *
   * The label of the field from which the passage has been extracted.
   *
   * @return the field
   */
  public String getField() {
    return field;
  }

  /**
   * Sets the documentId.
   *
   * @param documentId the new documentId
   */
  public void setDocumentId(final String documentId) {
    this.documentId = documentId;
  }

  /**
   * Sets the passageScore.
   *
   * @param passageScore the new passageScore
   */
  public void setPassageScore(final Double passageScore) {
    this.passageScore = passageScore;
  }

  /**
   * Sets the passageText.
   *
   * @param passageText the new passageText
   */
  public void setPassageText(final String passageText) {
    this.passageText = passageText;
  }

  /**
   * Sets the startOffset.
   *
   * @param startOffset the new startOffset
   */
  public void setStartOffset(final long startOffset) {
    this.startOffset = startOffset;
  }

  /**
   * Sets the endOffset.
   *
   * @param endOffset the new endOffset
   */
  public void setEndOffset(final long endOffset) {
    this.endOffset = endOffset;
  }

  /**
   * Sets the field.
   *
   * @param field the new field
   */
  public void setField(final String field) {
    this.field = field;
  }
}

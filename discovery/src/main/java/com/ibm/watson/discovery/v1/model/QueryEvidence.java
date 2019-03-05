/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Description of evidence location supporting Knoweldge Graph query result.
 */
public class QueryEvidence extends GenericModel {

  @SerializedName("document_id")
  private String documentId;
  private String field;
  @SerializedName("start_offset")
  private Long startOffset;
  @SerializedName("end_offset")
  private Long endOffset;
  private List<QueryEvidenceEntity> entities;

  /**
   * Gets the documentId.
   *
   * The docuemnt ID (as indexed in Discovery) of the evidence location.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the field.
   *
   * The field of the document where the supporting evidence was identified.
   *
   * @return the field
   */
  public String getField() {
    return field;
  }

  /**
   * Gets the startOffset.
   *
   * The start location of the evidence in the identified field. This value is inclusive.
   *
   * @return the startOffset
   */
  public Long getStartOffset() {
    return startOffset;
  }

  /**
   * Gets the endOffset.
   *
   * The end location of the evidence in the identified field. This value is inclusive.
   *
   * @return the endOffset
   */
  public Long getEndOffset() {
    return endOffset;
  }

  /**
   * Gets the entities.
   *
   * An array of entity objects that show evidence of the result.
   *
   * @return the entities
   */
  public List<QueryEvidenceEntity> getEntities() {
    return entities;
  }
}

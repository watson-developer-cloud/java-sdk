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
 * TrainingExample.
 */
public class TrainingExample extends GenericModel {

  @SerializedName("document_id")
  private String documentId;
  @SerializedName("cross_reference")
  private String crossReference;
  private Long relevance;

  /**
   * Gets the documentId.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the crossReference.
   *
   * @return the crossReference
   */
  public String getCrossReference() {
    return crossReference;
  }

  /**
   * Gets the relevance.
   *
   * @return the relevance
   */
  public Long getRelevance() {
    return relevance;
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
   * Sets the crossReference.
   *
   * @param crossReference the new crossReference
   */
  public void setCrossReference(final String crossReference) {
    this.crossReference = crossReference;
  }

  /**
   * Sets the relevance.
   *
   * @param relevance the new relevance
   */
  public void setRelevance(final long relevance) {
    this.relevance = relevance;
  }
}

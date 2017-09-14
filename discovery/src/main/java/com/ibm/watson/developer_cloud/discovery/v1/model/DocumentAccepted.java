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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * DocumentAccepted.
 */
public class DocumentAccepted extends GenericModel {

  /**
   * Status of the document in the ingestion process.
   */
  public interface Status {
    /** processing. */
    String PROCESSING = "processing";
  }

  @SerializedName("document_id")
  private String documentId;
  private String status;
  private List<Notice> notices;

  /**
   * Gets the documentId.
   *
   * The unique identifier of the ingested document.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the status.
   *
   * Status of the document in the ingestion process.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the notices.
   *
   * Array of notices produced by the document-ingestion process.
   *
   * @return the notices
   */
  public List<Notice> getNotices() {
    return notices;
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
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(final String status) {
    this.status = status;
  }

  /**
   * Sets the notices.
   *
   * @param notices the new notices
   */
  public void setNotices(final List<Notice> notices) {
    this.notices = notices;
  }
}

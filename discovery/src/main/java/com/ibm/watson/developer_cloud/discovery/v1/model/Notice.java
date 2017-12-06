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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * A notice produced for the collection.
 */
public class Notice extends GenericModel {

  /**
   * Severity level of the notice.
   */
  public interface Severity {
    /** warning. */
    String WARNING = "warning";
    /** error. */
    String ERROR = "error";
  }

  @SerializedName("notice_id")
  private String noticeId;
  private Date created;
  @SerializedName("document_id")
  private String documentId;
  @SerializedName("query_id")
  private String queryId;
  private String severity;
  private String step;
  private String description;

  /**
   * Gets the noticeId.
   *
   * Identifies the notice. Many notices might have the same ID. This field exists so that user applications can
   * programmatically identify a notice and take automatic corrective action.
   *
   * @return the noticeId
   */
  public String getNoticeId() {
    return noticeId;
  }

  /**
   * Gets the created.
   *
   * The creation date of the collection in the format yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the documentId.
   *
   * Unique identifier of the document.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the queryId.
   *
   * Unique identifier of the query used for relevance training.
   *
   * @return the queryId
   */
  public String getQueryId() {
    return queryId;
  }

  /**
   * Gets the severity.
   *
   * Severity level of the notice.
   *
   * @return the severity
   */
  public String getSeverity() {
    return severity;
  }

  /**
   * Gets the step.
   *
   * Ingestion or training step in which the notice occurred.
   *
   * @return the step
   */
  public String getStep() {
    return step;
  }

  /**
   * Gets the description.
   *
   * The description of the notice.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }
}

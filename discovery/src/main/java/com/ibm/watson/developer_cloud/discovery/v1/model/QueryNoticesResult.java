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
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * QueryNoticesResult.
 */
public class QueryNoticesResult extends GenericModel {

  /**
   * Severity level of the notice.
   */
  public interface Severity {
    /** warning. */
    String WARNING = "warning";
    /** error. */
    String ERROR = "error";
  }

  /** The unique identifier of the document. */
  private String id;
  /**
   * The confidence score of the result's analysis. Scores range from 0 to 1, with a higher score indicating greater
   * confidence.
   */
  private Double score;
  /** Metadata of the document. */
  private Map<String, Object> metadata;
  /**
   * Identifies the notice. Many notices may have the same ID. This field exists so that user applications can
   * programmatically identify a notice and take automatic corrective action.
   */
  @SerializedName("notice_id")
  private String noticeId;
  /** The creation date of the collection in the format yyyy-MM-dd'T'HH:mm:ss.SSS'Z'. */
  private Date created;
  /** Unique identifier of the ingested document. */
  @SerializedName("document_id")
  private String documentId;
  /** Severity level of the notice. */
  private String severity;
  /** Ingestion step in which the notice occurred. */
  private String step;
  /** The description of the notice. */
  private String description;

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the score.
   *
   * @return the score
   */
  public Double getScore() {
    return score;
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public Map<String, Object> getMetadata() {
    return metadata;
  }

  /**
   * Gets the noticeId.
   *
   * @return the noticeId
   */
  public String getNoticeId() {
    return noticeId;
  }

  /**
   * Gets the created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the documentId.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the severity.
   *
   * @return the severity
   */
  public String getSeverity() {
    return severity;
  }

  /**
   * Gets the step.
   *
   * @return the step
   */
  public String getStep() {
    return step;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(final String id) {
    this.id = id;
  }

  /**
   * Sets the score.
   *
   * @param score the new score
   */
  public void setScore(final Double score) {
    this.score = score;
  }

  /**
   * Sets the metadata.
   *
   * @param metadata the new metadata
   */
  public void setMetadata(final Map<String, Object> metadata) {
    this.metadata = metadata;
  }

  /**
   * Sets the noticeId.
   *
   * @param noticeId the new noticeId
   */
  public void setNoticeId(final String noticeId) {
    this.noticeId = noticeId;
  }

  /**
   * Sets the created.
   *
   * @param created the new created
   */
  public void setCreated(final Date created) {
    this.created = created;
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
   * Sets the severity.
   *
   * @param severity the new severity
   */
  public void setSeverity(final String severity) {
    this.severity = severity;
  }

  /**
   * Sets the step.
   *
   * @param step the new step
   */
  public void setStep(final String step) {
    this.step = step;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(final String description) {
    this.description = description;
  }
}

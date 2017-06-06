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
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Status information about a submitted document.
 */
public class DocumentStatus extends GenericModel {

  /**
   * Status of the document in the ingestion process.
   */
  public interface Status {
    /** available. */
    String AVAILABLE = "available";
    /** available with notices. */
    String AVAILABLE_WITH_NOTICES = "available with notices";
    /** failed. */
    String FAILED = "failed";
    /** processing. */
    String PROCESSING = "processing";
  }

  /** The unique identifier of the document. */
  @SerializedName("document_id")
  private String documentId;
  @SerializedName("configuration_id")
  private String configurationId;
  private Date created;
  private Date updated;
  /** Status of the document in the ingestion process. */
  private String status;
  /** Description of the document status. */
  @SerializedName("status_description")
  private String statusDescription;
  /** Array of notices produced by the document-ingestion process. */
  private List<Notice> notices;

  /**
   * Gets the documentId.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the configurationId.
   *
   * @return the configurationId
   */
  public String getConfigurationId() {
    return configurationId;
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
   * Gets the updated.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the statusDescription.
   *
   * @return the statusDescription
   */
  public String getStatusDescription() {
    return statusDescription;
  }

  /**
   * Gets the notices.
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
   * Sets the configurationId.
   *
   * @param configurationId the new configurationId
   */
  public void setConfigurationId(final String configurationId) {
    this.configurationId = configurationId;
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
   * Sets the updated.
   *
   * @param updated the new updated
   */
  public void setUpdated(final Date updated) {
    this.updated = updated;
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
   * Sets the statusDescription.
   *
   * @param statusDescription the new statusDescription
   */
  public void setStatusDescription(final String statusDescription) {
    this.statusDescription = statusDescription;
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

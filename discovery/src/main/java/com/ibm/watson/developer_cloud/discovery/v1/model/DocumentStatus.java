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

  /**
   * The type of the original source file.
   */
  public interface FileType {
    /** pdf. */
    String PDF = "pdf";
    /** html. */
    String HTML = "html";
    /** word. */
    String WORD = "word";
    /** json. */
    String JSON = "json";
  }

  @SerializedName("document_id")
  private String documentId;
  @SerializedName("configuration_id")
  private String configurationId;
  private Date created;
  private Date updated;
  private String status;
  @SerializedName("status_description")
  private String statusDescription;
  private String filename;
  @SerializedName("file_type")
  private String fileType;
  private String sha1;
  private List<Notice> notices;

  /**
   * Gets the documentId.
   *
   * The unique identifier of the document.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the configurationId.
   *
   * The unique identifier for the configuration.
   *
   * @return the configurationId
   */
  public String getConfigurationId() {
    return configurationId;
  }

  /**
   * Gets the created.
   *
   * The creation date of the document in the format yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * Date of the most recent document update, in the format yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
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
   * Gets the statusDescription.
   *
   * Description of the document status.
   *
   * @return the statusDescription
   */
  public String getStatusDescription() {
    return statusDescription;
  }

  /**
   * Gets the filename.
   *
   * Name of the original source file (if available).
   *
   * @return the filename
   */
  public String getFilename() {
    return filename;
  }

  /**
   * Gets the fileType.
   *
   * The type of the original source file.
   *
   * @return the fileType
   */
  public String getFileType() {
    return fileType;
  }

  /**
   * Gets the sha1.
   *
   * The SHA-1 hash of the original source file (formatted as a hexadecimal string).
   *
   * @return the sha1
   */
  public String getSha1() {
    return sha1;
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
   * Sets the filename.
   *
   * @param filename the new filename
   */
  public void setFilename(final String filename) {
    this.filename = filename;
  }

  /**
   * Sets the fileType.
   *
   * @param fileType the new fileType
   */
  public void setFileType(final String fileType) {
    this.fileType = fileType;
  }

  /**
   * Sets the sha1.
   *
   * @param sha1 the new sha1
   */
  public void setSha1(final String sha1) {
    this.sha1 = sha1;
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

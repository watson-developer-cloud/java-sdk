/*
 * (C) Copyright IBM Corp. 2017, 2020.
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
    /** pending. */
    String PENDING = "pending";
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
  protected String documentId;
  @SerializedName("configuration_id")
  protected String configurationId;
  protected String status;
  @SerializedName("status_description")
  protected String statusDescription;
  protected String filename;
  @SerializedName("file_type")
  protected String fileType;
  protected String sha1;
  protected List<Notice> notices;

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
}

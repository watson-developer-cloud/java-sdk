/*
 * (C) Copyright IBM Corp. 2023.
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
import java.util.Date;
import java.util.List;

/** Information about a document. */
public class DocumentDetails extends GenericModel {

  /**
   * The status of the ingestion of the document. The possible values are:
   *
   * <p>* `available`: Ingestion is finished and the document is indexed.
   *
   * <p>* `failed`: Ingestion is finished, but the document is not indexed because of an error.
   *
   * <p>* `pending`: The document is uploaded, but the ingestion process is not started.
   *
   * <p>* `processing`: Ingestion is in progress.
   */
  public interface Status {
    /** available. */
    String AVAILABLE = "available";
    /** failed. */
    String FAILED = "failed";
    /** pending. */
    String PENDING = "pending";
    /** processing. */
    String PROCESSING = "processing";
  }

  @SerializedName("document_id")
  protected String documentId;

  protected Date created;
  protected Date updated;
  protected String status;
  protected List<Notice> notices;
  protected DocumentDetailsChildren children;
  protected String filename;

  @SerializedName("file_type")
  protected String fileType;

  protected String sha256;

  protected DocumentDetails() {}

  /**
   * Gets the documentId.
   *
   * <p>The unique identifier of the document.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the created.
   *
   * <p>Date and time that the document is added to the collection. For a child document, the date
   * and time when the process that generates the child document runs. The date-time format is
   * `yyyy-MM-dd'T'HH:mm:ss.SSS'Z'`.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * <p>Date and time that the document is finished being processed and is indexed. This date
   * changes whenever the document is reprocessed, including for enrichment changes. The date-time
   * format is `yyyy-MM-dd'T'HH:mm:ss.SSS'Z'`.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the status.
   *
   * <p>The status of the ingestion of the document. The possible values are:
   *
   * <p>* `available`: Ingestion is finished and the document is indexed.
   *
   * <p>* `failed`: Ingestion is finished, but the document is not indexed because of an error.
   *
   * <p>* `pending`: The document is uploaded, but the ingestion process is not started.
   *
   * <p>* `processing`: Ingestion is in progress.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the notices.
   *
   * <p>Array of JSON objects for notices, meaning warning or error messages, that are produced by
   * the document ingestion process. The array does not include notices that are produced for child
   * documents that are generated when a document is processed.
   *
   * @return the notices
   */
  public List<Notice> getNotices() {
    return notices;
  }

  /**
   * Gets the children.
   *
   * <p>Information about the child documents that are generated from a single document during
   * ingestion or other processing.
   *
   * @return the children
   */
  public DocumentDetailsChildren getChildren() {
    return children;
  }

  /**
   * Gets the filename.
   *
   * <p>Name of the original source file (if available).
   *
   * @return the filename
   */
  public String getFilename() {
    return filename;
  }

  /**
   * Gets the fileType.
   *
   * <p>The type of the original source file, such as `csv`, `excel`, `html`, `json`, `pdf`, `text`,
   * `word`, and so on.
   *
   * @return the fileType
   */
  public String getFileType() {
    return fileType;
  }

  /**
   * Gets the sha256.
   *
   * <p>The SHA-256 hash of the original source file. The hash is formatted as a hexadecimal string.
   *
   * @return the sha256
   */
  public String getSha256() {
    return sha256;
  }
}

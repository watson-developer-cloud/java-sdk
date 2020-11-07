/*
 * (C) Copyright IBM Corp. 2019, 2020.
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

/** A notice produced for the collection. */
public class Notice extends GenericModel {

  /** Severity level of the notice. */
  public interface Severity {
    /** warning. */
    String WARNING = "warning";
    /** error. */
    String ERROR = "error";
  }

  @SerializedName("notice_id")
  protected String noticeId;

  protected Date created;

  @SerializedName("document_id")
  protected String documentId;

  @SerializedName("collection_id")
  protected String collectionId;

  @SerializedName("query_id")
  protected String queryId;

  protected String severity;
  protected String step;
  protected String description;

  /**
   * Gets the noticeId.
   *
   * <p>Identifies the notice. Many notices might have the same ID. This field exists so that user
   * applications can programmatically identify a notice and take automatic corrective action.
   * Typical notice IDs include: `index_failed`, `index_failed_too_many_requests`,
   * `index_failed_incompatible_field`, `index_failed_cluster_unavailable`, `ingestion_timeout`,
   * `ingestion_error`, `bad_request`, `internal_error`, `missing_model`, `unsupported_model`,
   * `smart_document_understanding_failed_incompatible_field`,
   * `smart_document_understanding_failed_internal_error`,
   * `smart_document_understanding_failed_internal_error`,
   * `smart_document_understanding_failed_warning`, `smart_document_understanding_page_error`,
   * `smart_document_understanding_page_warning`. **Note:** This is not a complete list, other
   * values might be returned.
   *
   * @return the noticeId
   */
  public String getNoticeId() {
    return noticeId;
  }

  /**
   * Gets the created.
   *
   * <p>The creation date of the collection in the format yyyy-MM-dd'T'HH:mm:ss.SSS'Z'.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the documentId.
   *
   * <p>Unique identifier of the document.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the collectionId.
   *
   * <p>Unique identifier of the collection.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return collectionId;
  }

  /**
   * Gets the queryId.
   *
   * <p>Unique identifier of the query used for relevance training.
   *
   * @return the queryId
   */
  public String getQueryId() {
    return queryId;
  }

  /**
   * Gets the severity.
   *
   * <p>Severity level of the notice.
   *
   * @return the severity
   */
  public String getSeverity() {
    return severity;
  }

  /**
   * Gets the step.
   *
   * <p>Ingestion or training step in which the notice occurred.
   *
   * @return the step
   */
  public String getStep() {
    return step;
  }

  /**
   * Gets the description.
   *
   * <p>The description of the notice.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }
}

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

/** Information returned after an uploaded document is accepted. */
public class DocumentAccepted extends GenericModel {

  /**
   * Status of the document in the ingestion process. A status of `processing` is returned for
   * documents that are ingested with a *version* date before `2019-01-01`. The `pending` status is
   * returned for all others.
   */
  public interface Status {
    /** processing. */
    String PROCESSING = "processing";
    /** pending. */
    String PENDING = "pending";
  }

  @SerializedName("document_id")
  protected String documentId;

  protected String status;

  /**
   * Gets the documentId.
   *
   * <p>The unique identifier of the ingested document.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the status.
   *
   * <p>Status of the document in the ingestion process. A status of `processing` is returned for
   * documents that are ingested with a *version* date before `2019-01-01`. The `pending` status is
   * returned for all others.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }
}

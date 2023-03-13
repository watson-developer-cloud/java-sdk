/*
 * (C) Copyright IBM Corp. 2019, 2023.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Information returned when a document is deleted. */
public class DeleteDocumentResponse extends GenericModel {

  /** Status of the document. A deleted document has the status deleted. */
  public interface Status {
    /** deleted. */
    String DELETED = "deleted";
  }

  @SerializedName("document_id")
  protected String documentId;

  protected String status;

  protected DeleteDocumentResponse() {}

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
   * Gets the status.
   *
   * <p>Status of the document. A deleted document has the status deleted.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }
}

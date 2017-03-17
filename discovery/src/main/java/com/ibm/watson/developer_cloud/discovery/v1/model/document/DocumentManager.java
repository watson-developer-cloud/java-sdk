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

package com.ibm.watson.developer_cloud.discovery.v1.model.document;

import com.ibm.watson.developer_cloud.http.ServiceCall;

/**
 * Interface defining the constants and methods associated with Environments.
 *
 * @see Document
 */
public interface DocumentManager {
    //Document
    String ID = "document_id";
    String CONFIGURATION_ID = "configuration_id";
    String CREATED = "created";
    String UPDATED = "updated";
    String STATUS = "status";
    String STATUS_DESCRIPTION = "status_description";
    String FILE = "file";
    String METADATA = "metadata";

    /**
     * Gets a {@link Document}.
     *
     * @param getRequest options for getting a {@link Document}
     * @return a {@link GetDocumentResponse} containing the details of {@link GetDocumentRequest}
     */
    ServiceCall<GetDocumentResponse> getDocument(GetDocumentRequest getRequest);

    /**
     * Starts ingesting a document with optional metadata and optional configuration overrides.
     *
     * Returns immediately after the system has accepted the document for processing.
     * The user must provide document content, metadata, or both.
     * If the request is missing both document content and metadata, then it will be rejected.
     * User can set the Content-Type parameter on the file part to indicate the media type of the document.
     * If the Content-Type parameter is missing or is one of the generic media types (e.g. application/octet-stream),
     * then the service will attempt to automatically detect the document's media type.
     *
     * @param createRequest options for creating a {@link Document}
     * @return a {@link CreateDocumentResponse} containing the details of {@link CreateDocumentRequest}
     */
    ServiceCall<CreateDocumentResponse> createDocument(CreateDocumentRequest createRequest);

    /**
     * Deletes a {@link Document}.
     *
     * @param deleteRequest options for deleting a {@link Document}
     * @return a {@link DeleteDocumentResponse} containing the details of {@link DeleteDocumentRequest}
     */
    ServiceCall<DeleteDocumentResponse> deleteDocument(DeleteDocumentRequest deleteRequest);

    /**
     * Starts ingesting a source document to create or replace an existing document.
     *
     * This is a POST operation instead of a PUT operation because an existing document may be partially updated,
     * depending on whether or not the new, replacement document is successfully ingested (see the next bullet for
     * details).
     * - If a document already exists with the provided Document ID, then the fate of the original document
     * depends on whether or not the new document is successfully ingested
     * - If the new document fails, then the original document is left intact in the collection's index.
     * However, any previous notices (warnings or errors) that were stored for the original document are replaced
     * with the new document's notices.
     * - If the new document is successfully processed, then the original document is replaced with the new document
     * in the collection's index, including any notices.
     * - Only the document_id from the request path is used. If the user provides a document_id in the input document
     * (assuming JSON is submitted), it will be ignored. Returns immediately after the system has accepted
     * the document for processing. The user must provide document content, metadata, or both.
     * If the request is missing both document content and metadata, then it will be rejected.
     * User can set the Content-Type parameter on the file part to indicate the media type of the document.
     * If the Content-Type parameter is missing or is one of the generic media types
     * (e.g. application/octet-stream), then the service will attempt to automatically detect the document's
     * media type.
     *
     * @param updateRequest options for updating a {@link Document}
     * @return a {@link UpdateDocumentResponse} containing the details of {@link UpdateDocumentRequest}
     */
    ServiceCall<UpdateDocumentResponse> updateDocument(UpdateDocumentRequest updateRequest);
}

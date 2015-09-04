/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.document_conversion.v1.helpers;

import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Document;

import com.ibm.watson.developer_cloud.document_conversion.v1.model.DocumentCollection;
import com.ibm.watson.developer_cloud.document_conversion.v1.util.ConversionUtils;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Helper for the document API calls
 *
 * @see DocumentConversion
 */
public class DocumentHelper {
    /**
     * The document service object
     */
    @Expose
    private DocumentConversion docConversionService;

    /**
     * Sets the service object
     * @param docConversionService
     */
    public DocumentHelper(DocumentConversion docConversionService) {
        this.docConversionService = docConversionService;
    }

    /**
     * Retrieves a document from the store with the given id
     *
     * GET /v1/documents/{document_id}
     * @param documentId id of the document to be retrieved
     * @return requested Document
     * @see DocumentConversion#getDocument(String)
     */
    public String getDocument(final String documentId) {
        if (documentId == null || documentId.isEmpty())
            throw new IllegalArgumentException("batchId can not be null or empty");
        HttpRequestBase request = Request.Get("/v1/documents/"+documentId).build();
        try {
            HttpResponse response = docConversionService.execute(request);
            String documentAsJson = ResponseUtil.getString(response);
            return documentAsJson;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Uploads the document to the store with the given media type
     *
     * POST /v1/documents
     * @param document the document to be uploaded
     * @return Document
     *
     * @see DocumentConversion#uploadDocument(File)
     */
    public Document uploadDocument(final File document) {
        String mediaType = ConversionUtils.getMediaTypeFromFile(document);
        if (mediaType == null)
            throw new IllegalArgumentException("file with the given media type is not supported");
        if (document == null || !document.exists())
            throw new IllegalArgumentException("document cannot be null and must exist");
        if (mediaType == null || mediaType.isEmpty())
            throw new IllegalArgumentException("media type can not be null or empty");
        try {
            MultipartEntity reqEntity = new MultipartEntity();
            reqEntity.addPart("file", new FileBody(document, mediaType));
            HttpRequestBase request = Request.Post("/v1/documents")
                                             .withEntity(reqEntity).build();

            HttpResponse response = docConversionService.execute(request);
            String documentAsJson = ResponseUtil.getString(response);
            Document doc = GsonSingleton.getGson().fromJson(documentAsJson, Document.class);
            return doc;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets a collection of all existing documents with optional query parameters for filtering results.
     * GET /v1/documents
     * @param token The reference to the starting element of the requested page which is provided
     *              by the server, pass null to get the first page
     * @param limit The number of documents to get, pass null to use the default limit from server (100)
     * @param name The name of the documents to get, pass null to exclude this filter
     * @param since The date to filter on, documents created on or after the provided date and time format
     *              will be returned. NOTE: ISO 8601 date and time format is required: (YYYY-MM-DDTHH:MM:SSZ),
     *              pass null to exclude this filter
     * @param mediaType The Internet media type to filter on, pass null to exclude this filter
     * @return Documents based on filtering parameters provided
     *
     * @see DocumentConversion#getDocumentCollection(String, int, String, Date, String)
     */
    public DocumentCollection getDocumentCollection(final String token, final int limit,
                                                    final String name, final Date since, final String mediaType) {
        Request request = Request.Get("/v1/documents");
        if(token != null && !token.isEmpty())
            request.withQuery("token", token);

        if (limit > 0)
            request.withQuery("limit", limit);
        else
            request.withQuery("limit", 100);

        if(name != null && !name.isEmpty())
            request.withQuery("name", name);

        if(since != null)
            request.withQuery("since", ConversionUtils.convertToISO(since));

        if(mediaType != null && !mediaType.isEmpty())
            request.withQuery("media_type", mediaType);

        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = docConversionService.execute(requestBase);
            String documentCollectionAsJson = ResponseUtil.getString(response);
            DocumentCollection documentCollection = GsonSingleton.getGson().fromJson(
                                                    documentCollectionAsJson, DocumentCollection.class);
            return documentCollection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

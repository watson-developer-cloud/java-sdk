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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;

import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Document;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.DocumentCollection;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * Helper for the document API calls
 *
 * NOTE: The methods in this class should not be called directly! Please
 * make all calls to the service using the DocumentConversion class.
 *
 * @see DocumentConversion
 */
public class DocumentHelper {
    
    /** The document service object. */
    @Expose
    private DocumentConversion docConversionService;

    /**
     * Sets the service object.
     *
     * @param docConversionService the doc conversion service
     */
    public DocumentHelper(DocumentConversion docConversionService) {
        this.docConversionService = docConversionService;
    }

    /**
     * Retrieves a document from the store with the given id
     * 
     * GET /v1/documents/{document_id}.
     *
     * @param documentId id of the document to be retrieved
     * @return requested Document
     * @see DocumentConversion#getDocument(String)
     */
    public InputStream getDocument(final String documentId) {
        if (documentId == null || documentId.isEmpty())
            throw new IllegalArgumentException("documentId can not be null or empty");
        HttpRequestBase request = Request.Get(DocumentConversion.DOCUMENTS_PATH + "/"+ documentId).build();
        try {
            HttpResponse response = docConversionService.execute(request);
            InputStream is = ResponseUtil.getInputStream(response);
            return is;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Uploads the document to the store with the given media type
     * 
     * POST /v1/documents.
     *
     * @param document the document to be uploaded
     * @return Document
     * @see DocumentConversion#uploadDocument(File)
     */
    public Document uploadDocument(final File document) {
        String mediaType = ConversionUtils.getMediaTypeFromFile(document);
        return uploadDocument(document, mediaType);
    }

    /**
     * Uploads the document to the store with the given media type
     * 
     * POST /v1/documents.
     *
     * @param document the document to be uploaded
     * @param mediaType the Internet media type for the file
     * @return Document
     * @see DocumentConversion#uploadDocument(File, String)
     */
    public Document uploadDocument(final File document, final String mediaType) {
        if (mediaType == null || mediaType.isEmpty())
            throw new IllegalArgumentException("media type cannot be null or empty");
        if(!ConversionUtils.isValidMediaType(mediaType))
            throw new IllegalArgumentException("file with the given media type is not supported");
        if (document == null || !document.exists())
            throw new IllegalArgumentException("document cannot be null and must exist");
        try {
            MultipartEntity reqEntity = new MultipartEntity();
            reqEntity.addPart("file", new FileBody(document, mediaType));
            HttpRequestBase request = Request.Post(DocumentConversion.DOCUMENTS_PATH)
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
     *
     * @param docListParams The parameters to be used in the documents list service call.
     *                      The parameters - token, limit, name, since and media_type are optional
     * <ul>
     * <li> String token - The reference to the starting element of the requested page which is provided
     *                     by the server, pass null to get the first page </li>
     * <li> int limit - The number of documents to get, pass 0 to use the default limit from server (100) </li>
     * <li> String name - The name of the documents to get, pass null to exclude this filter </li>
     * <li> Date since - The date to filter on, documents created on or after the provided date and time format
     *                  will be returned, pass null to exclude this filter </li>
     * <li> String media_type - The Internet media type to filter on, pass null to exclude this filter </li>
     * @return Documents based on filtering parameters provided
     *
     * @see DocumentConversion#getDocumentCollection(Map)
     **/
    public DocumentCollection getDocumentCollection(Map<String, Object> docListParams) {
        Request request = Request.Get(DocumentConversion.DOCUMENTS_PATH);

        if(docListParams != null) {
            if (docListParams.get(DocumentConversion.TOKEN) != null) {
                String token = (String) docListParams.get(DocumentConversion.TOKEN);
                if (!token.isEmpty())
                    request.withQuery(DocumentConversion.TOKEN, token);
            }

            if (docListParams.get(DocumentConversion.LIMIT) != null) {
                int limit = ((Integer) docListParams.get(DocumentConversion.LIMIT)).intValue();
                if (limit > 0)
                    request.withQuery(DocumentConversion.LIMIT, limit);
                else
                    request.withQuery(DocumentConversion.LIMIT, DocumentConversion.DEFAULT_LIMIT);
            }

            if (docListParams.get(DocumentConversion.NAME) != null) {
                String name = (String) docListParams.get(DocumentConversion.NAME);
                if (!name.isEmpty())
                    request.withQuery(DocumentConversion.NAME, name);
            }

            if (docListParams.get(DocumentConversion.SINCE) != null) {
                Date since = (Date) docListParams.get(DocumentConversion.SINCE);
                request.withQuery(DocumentConversion.SINCE, ConversionUtils.convertToISO(since));
            }

            if (docListParams.get(DocumentConversion.MEDIA_TYPE) != null) {
                String mediaType = (String) docListParams.get(DocumentConversion.MEDIA_TYPE);
                if (!mediaType.isEmpty())
                    request.withQuery(DocumentConversion.MEDIA_TYPE, mediaType);
            }
        }
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

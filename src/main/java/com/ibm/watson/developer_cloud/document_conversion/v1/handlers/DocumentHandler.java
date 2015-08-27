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
package com.ibm.watson.developer_cloud.document_conversion.v1.handlers;

import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Document;

import com.ibm.watson.developer_cloud.document_conversion.v1.model.DocumentCollection;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;
import java.io.IOException;

/**
 * Handler for the documents
 *
 * @see DocumentConversion
 */
public class DocumentHandler {
    /**
     * The document service object
     */
    @Expose
    private DocumentConversion docConversionService;

    public DocumentHandler(DocumentConversion docConversionService) {
        this.docConversionService = docConversionService;
    }

    /**
     * Returns the document with the id
     *
     * @param documentId
     *          id for the document
     * @return
     *
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
     * Uploads the document which is provided to the input
     *
     * @param document
     *          input document
     * @return
     *
     * @see DocumentConversion#uploadDocument(File)
     */
    public Document uploadDocument(final File document) {
        if(document == null || !document.exists())
            throw new IllegalArgumentException("document cannot be null and must exist");
        try {
            MultipartEntity reqEntity = new MultipartEntity();
            reqEntity.addPart("file", new FileBody(document));
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
     *
     * Returns all the documents which match the parameters
     *
     * @param token
     *          token to navigate to the next page
     * @param limit
     *          number of documents per page
     * @param name
     *          name of the document
     * @param since
     *          documents created after since
     * @param mediaType
     *          mediatype of the document
     * @return
     *
     * @see DocumentConversion#getDocumentCollection(String, String, String, String, String)
     */
    public DocumentCollection getDocumentCollection(final String token, final String limit, final String name, final String since, final String mediaType) {
        Request request = Request.Get("/v1/documents");
        if(token != null && !token.isEmpty())
            request.withQuery("token", token);

        if(limit != null && !limit.isEmpty())
            request.withQuery("limit", limit);

        if(name != null && !name.isEmpty())
            request.withQuery("name", name);

        if(since != null && !since.isEmpty())
            request.withQuery("since", since);

        if(mediaType != null && !mediaType.isEmpty())
            request.withQuery("media_type", mediaType);

        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = docConversionService.execute(requestBase);
            String documentCollectionAsJson = ResponseUtil.getString(response);
            DocumentCollection documentCollection = GsonSingleton.getGson().fromJson(documentCollectionAsJson, DocumentCollection.class);
            return documentCollection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

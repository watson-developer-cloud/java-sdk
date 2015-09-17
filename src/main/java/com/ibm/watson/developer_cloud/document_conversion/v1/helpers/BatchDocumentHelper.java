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

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.BatchDocumentCollection;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.BatchDocumentResponse;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * Helper for the batch documents API calls
 *
 * NOTE: The methods in this class should not be called directly! Please
 * make all calls to the service using the DocumentConversion class.
 *
 * @see DocumentConversion
 */
public class BatchDocumentHelper {
    
    /** The document service object. */
    @Expose
    private DocumentConversion docConversionService;

    /**
     * Sets the service object.
     *
     * @param docConversionService the doc conversion service
     */
    public BatchDocumentHelper(DocumentConversion docConversionService) {
        this.docConversionService = docConversionService;
    }

    /**
     * Adds a document to the batch whose ids are specified
     * 
     * PUT /v1/batches/{batch_id}/documents/{document_id}.
     *
     * @param batchId          id of the batch to be retrieved
     * @param documentId          id of the document to be retrieved
     * @return BatchDocumentResponse
     * @see DocumentConversion#addDocumentToBatch(String, String)
     */
    public BatchDocumentResponse addDocumentToBatch(final String batchId, final String documentId) {
        if (batchId == null || batchId.isEmpty())
            throw new IllegalArgumentException("batchId cannot be null or empty");
        if (documentId == null || documentId.isEmpty())
            throw new IllegalArgumentException("documentId cannot be null or empty");

        HttpRequestBase request = Request.Put(DocumentConversion.BATCHES_PATH + "/"+ batchId + "/documents/"+ documentId).build();
        try {
            HttpResponse response = docConversionService.execute(request);
            String batchDocumentAsJson = ResponseUtil.getString(response);
            BatchDocumentResponse batchDocumentResponse = ConversionUtils.getGsonWithIso8601DateDeserializer()
                    .fromJson(batchDocumentAsJson, BatchDocumentResponse.class);
            return batchDocumentResponse;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets a list of existing documents in the batch with optional query parameters for filtering results.
     *
     * GET /v1/batches/{batch_id}/documents
     *
     * @param batchId The id for the batch whose documents are returned
     * @param batchDocListParams The parameters to be used in the batch documents list service call.
     *                         The parameters - token, limit, since, job_id and media_type are optional
     * <ul>
     * <li> String token - The reference to the starting element of the requested page which is provided
     *                     by the server, pass null to get the first page </li>
     * <li> int limit - The number of documents in a batch to get, pass 0 to use the default limit from server (100) </li>
     * <li> Date since - The date to filter on, documents added to the batch on or after the provided date and time format
     *              will be returned. </li>
     * </ul>
     * @return Documents in a batch based on the filtering parameters provided
     *
     * @see DocumentConversion#getBatchDocumentCollection(String, Map)
     */
    public BatchDocumentCollection getBatchDocumentCollection(String batchId, Map<String, Object> batchDocListParams) {
        if (batchId == null || batchId.isEmpty())
            throw new IllegalArgumentException("batchId cannot be null or empty");

        Request request = Request.Get(DocumentConversion.BATCHES_PATH + "/" + batchId +"/documents");
        if(batchDocListParams != null) {
            if (batchDocListParams.get(DocumentConversion.TOKEN) != null) {
                String token = (String) batchDocListParams.get(DocumentConversion.TOKEN);
                if (!token.isEmpty())
                    request.withQuery(DocumentConversion.TOKEN, token);
            }

            if (batchDocListParams.get(DocumentConversion.LIMIT) != null) {
                int limit = ((Integer) batchDocListParams.get(DocumentConversion.LIMIT)).intValue();
                if (limit > 0)
                    request.withQuery(DocumentConversion.LIMIT, limit);
                else
                    request.withQuery(DocumentConversion.LIMIT, DocumentConversion.DEFAULT_LIMIT);
            }

            if (batchDocListParams.get(DocumentConversion.SINCE) != null) {
                Date since = (Date) batchDocListParams.get(DocumentConversion.SINCE);
                request.withQuery(DocumentConversion.SINCE, ConversionUtils.convertToISO(since));
            }
        }
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = docConversionService.execute(requestBase);
            String batchDocumentCollectionAsJson = ResponseUtil.getString(response);
            BatchDocumentCollection batchDocumentCollection = ConversionUtils.getGsonWithIso8601DateDeserializer()
                    .fromJson(batchDocumentCollectionAsJson, BatchDocumentCollection.class);
            return batchDocumentCollection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the document from the batch whose ids are specified
     * 
     * GET /v1/batches/{batch_id}/documents/{document_id}.
     *
     * @param batchId          id of the batch to be retrieved
     * @param documentId          id of the document to be retrieved
     * @return BatchDocumentResponse
     * @see DocumentConversion#getBatchDocument(String, String)
     */
    public BatchDocumentResponse getBatchDocument(final String batchId, final String documentId) {
        if (batchId == null || batchId.isEmpty())
            throw new IllegalArgumentException("batchId cannot be null or empty");
        if (documentId == null || documentId.isEmpty())
            throw new IllegalArgumentException("documentId cannot be null or empty");

        HttpRequestBase request = Request.Get(DocumentConversion.BATCHES_PATH + "/" + batchId + "/documents/"+ documentId).build();
        try {
            HttpResponse response = docConversionService.execute(request);
            String batchDocumentAsJson = ResponseUtil.getString(response);
            BatchDocumentResponse batchDocumentResponse = ConversionUtils.getGsonWithIso8601DateDeserializer()
                    .fromJson(batchDocumentAsJson, BatchDocumentResponse.class);
            return batchDocumentResponse;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

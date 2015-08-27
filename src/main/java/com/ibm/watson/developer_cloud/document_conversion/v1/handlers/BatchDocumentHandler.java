package com.ibm.watson.developer_cloud.document_conversion.v1.handlers;

import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.*;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import java.io.IOException;

/**
 * Handler for the batch documents
 *
 * @see DocumentConversion
 */
public class BatchDocumentHandler {
    /**
     * The document service object
     */
    @Expose
    private DocumentConversion docConversionService;

    /**
     * Sets the service object
     *
     * @param docConversionService
     */
    public BatchDocumentHandler(DocumentConversion docConversionService) {
        this.docConversionService = docConversionService;
    }

    /**
     * Adds the document to the batch
     *
     * @param batchId
     *          id for the batch
     * @param documentId
     *          id to the document
     * @return
     *
     * @see DocumentConversion#addDocumentToBatch(String, String)
     */
    public BatchDocumentResponse addDocumentToBatch(final String batchId, final String documentId) {
        if (batchId == null || batchId.isEmpty())
            throw new IllegalArgumentException("batchId cannot be null or empty");
        if (documentId == null || documentId.isEmpty())
            throw new IllegalArgumentException("documentId cannot be null or empty");

        HttpRequestBase request = Request.Put("/v1/batches/" + batchId + "/documents/"+ documentId).build();
        try {
            HttpResponse response = docConversionService.execute(request);
            String batchDocumentAsJson = ResponseUtil.getString(response);
            BatchDocumentResponse batchDocumentResponse = GsonSingleton.getGson().fromJson(batchDocumentAsJson, BatchDocumentResponse.class);
            return batchDocumentResponse;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the document from the batch
     *
     * @param batchId
     *          id for the batch
     * @param token
     *          token to the next page
     * @param limit
     *          number of batches per page
     * @param since
     *          documents added to the batch after 'since'
     * @return
     *
     * @see DocumentConversion#getBatchDocumentCollection(String, String, String, String)
     */
    public BatchDocumentCollection getBatchDocumentCollection(final String batchId, final String token, final String limit, final String since) {
        if (batchId == null || batchId.isEmpty())
            throw new IllegalArgumentException("batchId cannot be null or empty");

        Request request = Request.Get("/v1/batches/"+ batchId +"/documents");
        if(token != null && !token.isEmpty())
            request.withQuery("token", token);

        if(limit != null && !limit.isEmpty())
            request.withQuery("limit", limit);

        if(since != null && !since.isEmpty())
            request.withQuery("since", since);

        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = docConversionService.execute(requestBase);
            String batchDocumentCollectionAsJson = ResponseUtil.getString(response);
            BatchDocumentCollection batchDocumentCollection = GsonSingleton.getGson().fromJson(batchDocumentCollectionAsJson, BatchDocumentCollection.class);
            return batchDocumentCollection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the batch document from the batch
     *
     * @param batchId
     *          id to the batch
     * @param documentId
     *          id to the document
     * @return
     *
     * @see DocumentConversion#getBatchDocument(String, String)
     */
    public BatchDocumentResponse getBatchDocument(final String batchId, final String documentId) {
        if (batchId == null || batchId.isEmpty())
            throw new IllegalArgumentException("batchId cannot be null or empty");
        if (documentId == null || documentId.isEmpty())
            throw new IllegalArgumentException("documentId cannot be null or empty");

        HttpRequestBase request = Request.Get("/v1/batches/" + batchId + "/documents/"+ documentId).build();
        try {
            HttpResponse response = docConversionService.execute(request);
            String batchDocumentAsJson = ResponseUtil.getString(response);
            BatchDocumentResponse batchDocumentResponse = GsonSingleton.getGson().fromJson(batchDocumentAsJson, BatchDocumentResponse.class);
            return batchDocumentResponse;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.ibm.watson.developer_cloud.document_conversion.v1.helpers;

import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.*;
import com.ibm.watson.developer_cloud.document_conversion.v1.util.ConversionUtils;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import java.io.IOException;
import java.util.Date;

/**
 * Helper for the batch documents API calls
 *
 * NOTE: The methods in this class should not be called directly! Please
 * make all calls to the service using the DocumentConversion class.
 *
 * @see DocumentConversion
 */
public class BatchDocumentHelper {
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
    public BatchDocumentHelper(DocumentConversion docConversionService) {
        this.docConversionService = docConversionService;
    }

    /**
     * Adds a document to the batch whose ids are specified
     *
     * PUT /v1/batches/{batch_id}/documents/{document_id}
     * @param batchId
     *          id of the batch to be retrieved
     * @param documentId
     *          id of the document to be retrieved
     * @return BatchDocumentResponse
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
            BatchDocumentResponse batchDocumentResponse = GsonSingleton.getGson().fromJson(batchDocumentAsJson,
                                                                                           BatchDocumentResponse.class);
            return batchDocumentResponse;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets a list of existing documents in the batch with optional query parameters for filtering results.
     *
     * GET /v1/batches/{batch_id}/documents
     * @param batchId The id for the batch whose documents are returned
     * @param token The reference to the starting element of the requested page which is provided
     *              by the server, pass null to get the first page
     * @param limit The number of documents in a batch to get, pass 0 to use the default limit from server (100)
     * @param since The date to filter on, documents added to the batch on or after the provided date and time format
     *              will be returned.
     * @return Documents in a batch based on the filtering parameters provided
     *
     * @see DocumentConversion#getBatchDocumentCollection(String, String, int, Date)
     */
    public BatchDocumentCollection getBatchDocumentCollection(final String batchId, final String token,
                                                              final int limit, final Date since) {
        if (batchId == null || batchId.isEmpty())
            throw new IllegalArgumentException("batchId cannot be null or empty");

        Request request = Request.Get("/v1/batches/"+ batchId +"/documents");
        if(token != null && !token.isEmpty())
            request.withQuery("token", token);

        if (limit > 0)
            request.withQuery("limit", limit);
        else
            request.withQuery("limit", DocumentConversion.LIMIT);

        if(since != null)
            request.withQuery("since", ConversionUtils.convertToISO(since));

        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = docConversionService.execute(requestBase);
            String batchDocumentCollectionAsJson = ResponseUtil.getString(response);
            BatchDocumentCollection batchDocumentCollection = GsonSingleton.getGson().fromJson
                                                              (batchDocumentCollectionAsJson,
                                                               BatchDocumentCollection.class);
            return batchDocumentCollection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the document from the batch whose ids are specified
     *
     * GET /v1/batches/{batch_id}/documents/{document_id}
     * @param batchId
     *          id of the batch to be retrieved
     * @param documentId
     *          id of the document to be retrieved
     * @return BatchDocumentResponse
     *
     *  @see DocumentConversion#getBatchDocument(String, String)
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
            BatchDocumentResponse batchDocumentResponse = GsonSingleton.getGson().fromJson(batchDocumentAsJson,
                                                                                           BatchDocumentResponse.class);
            return batchDocumentResponse;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

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
package com.ibm.watson.developer_cloud.document_conversion.v1;

import com.ibm.watson.developer_cloud.document_conversion.v1.handlers.*;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.*;
import com.ibm.watson.developer_cloud.service.WatsonService;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.File;
import java.util.List;

/**
 * The IBM Watson Document Conversion service converts provided source
 * documents (HTML, Word, PDF) into JSON Answer Units, Normalized HTML,
 * or Normalized Text.
 *
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/document-conversion.html">
 *      Document Conversion</a>
 */
public class DocumentConversion extends WatsonService {

    /** The Constant URL. */
    //private static final String URL = "https://gateway.watsonplatform.net/document-conversion/api";
    /**
     * TODO: Remove LocalHost URL. Currently only used for testing purposes!
     * NOTES:
     * For testing locally:
     * 1. Start the ingestion service "gradlew :ingestion-service-server: run"
     * 2. Start the document conversion service "gradlew :document-conversion-service-server: run"
     * 3. You can access IS url's via: http://localhost:8080 (ex. http://localhost:8080/v1/documents)
     * 4. You can access DCS urls via: http://localhost:8090 (ex. http://localhost:8090/v1/documents)
     */
    private static final String URL = "http://localhost:8090";

    private final BatchHandler batchHandler = new BatchHandler(this);
    private final DocumentHandler documentHandler = new DocumentHandler(this);
    private final BatchDocumentHandler batchDocumentHandler = new BatchDocumentHandler(this);
    private final JobHandler jobHandler = new JobHandler(this);
    private final OutputHandler outputHandler = new OutputHandler(this);
    private final ConvertDocumentHandler convertDocumentHandler = new ConvertDocumentHandler(this);


    /**
     * Sets the endpoint url for the service
     */
    public DocumentConversion() {
        setEndPoint(URL);
    }

    /**
     * Gets a list of existing batches
     *
     * GET /v1/batches
     * @return BatchCollection
     */
    public BatchCollection getBatchCollection() {
        return getBatchCollection(null, null, null, null);
    }

    /**
     * Gets a list of existing batches with parameters
     *
     * GET /v1/batches
     * @param token
     *          token to the navigate to the next page
     * @param limit
     *          number of batches per page
     * @param name
     *          name of the batch to be filtered on
     * @param since
     *          the batches which are created after the date/time
     * @return BatchCollection
     */
    public BatchCollection getBatchCollection(final String token, final String limit, final String name, final String since) {
        return batchHandler.getBatchCollection(token, limit, name, since);
    }

    /**
     * Creates a new batch
     *
     * POST /v1/batches
     * @return Batch
     */
    public Batch createBatch() {
        return createBatch(null, null);
    }

    /**
     * Creates a new batch with a name
     *
     * POST /v1/batches
     * @param name
     *         the name of the created batch
     * @return Batch
     */
    public Batch createBatch(final String name) {
        return createBatch(name, null);
    }

    /**
     * Creates a new batch with name and properties
     *
     * POST /v1/batches
     * @param name
     *         the name of the created batch
     * @param properties
     *         the properties for the created batch
     * @return Batch
     */
    public Batch createBatch(final String name, final List<Property> properties) {
        return batchHandler.createBatch(name, properties);
    }

    /**
     * Gets an existing batch
     *
     * GET /v1/batches/{batch_id}
     * @param batchId
     *          id for the batch to be updated
     * @return Batch
     */
    public Batch getBatch(final String batchId) {
        return batchHandler.getBatch(batchId);
    }

    /**
     * Updates an existing batch
     *
     * PUT /v1/batches/{batch_id}
     * @param batchId
     *          id for the batch to be updated
     * @param name
     *          name of the batch to be updated
     * @param properties
     *          properties of the batch to be updated
     *
     */
    public Batch updateBatch(final String batchId, final String name, final List<Property> properties) {
        return batchHandler.updateBatch(batchId, name, properties);
    }

    /**
     * Gets a list of uploaded documents
     *
     * GET /v1/documents
     * @return Document
     */
    public DocumentCollection getDocumentCollection() {
        return getDocumentCollection(null, null, null, null, null);
    }

    /**
     * Gets a list of existing documents with parameters
     *
     * GET /v1/documents
     * @param token
     *          token to the navigate to the next page
     * @param limit
     *          number of documents per page
     * @param since
     *          the documents which are created after the date/time
     * @param mediaType
     *          the documents with the given mediaType
     * @return DocumentCollection
     */
    public DocumentCollection getDocumentCollection(final String token, final String limit, final String name, final String since, final String mediaType) {
        return documentHandler.getDocumentCollection(token, limit, name, since, mediaType);
    }

    /**
     * Adds a document
     *
     * POST /v1/documents
     * @param document
     *          the document to be uploaded
     * @return Document
     */
    public Document uploadDocument(final File document) {
        return documentHandler.uploadDocument(document);
    }

    /**
     * Gets a document
     *
     * GET /v1/documents/{document_id}
     * @param documentId
     *              document to be retrieved
     * @return String
     */
    public String getDocument(final String documentId) {
        return documentHandler.getDocument(documentId);
    }

    /**
     * Gets a list of existing documents in the batch
     *
     * GET /v1/batches/{batch_id}/documents
     *  @param batchId
     *          the id for the batch whose documents are to be paged
     * @return BatchDocumentCollection
     */
    public BatchDocumentCollection getBatchDocumentCollection(final String batchId) {
        return getBatchDocumentCollection(batchId, null, null, null);
    }

    /**
     * Gets a list of existing documents in the batch
     *
     * GET /v1/batches/{batch_id}/documents
     * @param batchId
     *          the id for the batch whose documents are to be paged
     * @param token
     *          token to the navigate to the next page
     * @param limit
     *          number of batches per page
     * @param since
     *          the batches which are created after the date/time
     * @return BatchDocumentCollection
     */
    public BatchDocumentCollection getBatchDocumentCollection(final String batchId, final String token, final String limit, final String since) {
        return batchDocumentHandler.getBatchDocumentCollection(batchId, token, limit, since);
    }


    /**
     * Gets a document in the batch
     *
     * GET /v1/batches/{batch_id}/documents/{document_id}
     * @param batchId
     *          id of the batch to be retrieved
     * @param documentId
     *          id of the document to be retrieved
     * @return BatchDocumentResponse
     */
    public BatchDocumentResponse getBatchDocument(final String batchId, final String documentId) {
        return batchDocumentHandler.getBatchDocument(batchId, documentId);
    }

    /**
     * Adds a document to the batch
     *
     * PUT /v1/batches/{batch_id}/documents/{document_id}
     * @param batchId
     *          id of the batch to be retrieved
     * @param documentId
     *          id of the document to be retrieved
     * @return BatchDocumentResponse
     */
    public BatchDocumentResponse addDocumentToBatch(final String batchId, final String documentId) {
        return batchDocumentHandler.addDocumentToBatch(batchId, documentId);
    }

    /**
     * Synchronously converts a new document without persistence
     *
     * POST /v1/convert_document
     * @param document
     * @return String
     */
    public String convertDocument(final File document) {
        return convertDocumentHandler.convertDocument(document);
    }

    /**
     * Synchronously converts a single previously uploaded document
     *
     * POST /v1/convert_document
     * @param documentId
     * @return String
     */
    public String convertDocument(final String documentId) {
        return convertDocumentHandler.convertDocument(documentId);
    }

    /**
     * Gets a list of jobs
     *
     * GET /v1/jobs
     * @return List
     */
    public List<Job> getJobs() {
        return jobHandler.getJobs();
    }

    /**
     * Creates a new job by submitting a batch for processing
     *
     * POST /v1/jobs
     * @param batchId
     * @return String
     */
    public String createJob(final String batchId) {
        return jobHandler.createJob(batchId);
    }

    /**
     * Gets information about a job
     *
     * GET /v1/jobs/{job_id}
     * @param jobId
     * @return Job
     */
    public Job getJob(final String jobId) {
        return jobHandler.getJob(jobId);
    }

    /**
     * Gets the job processing log
     *
     * GET /v1/jobs/{job_id}/log
     * @param jobId
     * @return String
     */
    public String getJobLog(final String jobId) {
        return jobHandler.getJobLog(jobId);
    }

    /**
     * Gets a collection of generated outputs
     *
     * GET /v1/output
     * @return List
     */
    public List<Output> getOutputCollection() {
        return outputHandler.getOutputCollection();
    }

    /**
     * Gets the content of the output
     *
     * GET /v1/output/{output_id}
     * @param outputId
     * @return List
     */
    public Output getOutput(final String outputId) {
        return outputHandler.getOutput(outputId);
    }

    @Override
    public HttpResponse execute(final HttpRequestBase request) {
        return super.execute(request);
    }

}

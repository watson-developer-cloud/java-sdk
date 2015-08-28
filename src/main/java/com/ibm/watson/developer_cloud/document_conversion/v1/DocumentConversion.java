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

import com.google.gson.JsonObject;
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
     * Synchronously converts a new document without persistence.
     * Uses the ANSWER_UNITS conversion target as the default.
     * POST /v1/convert_document
     * @param document The file to convert
     * @param mediaType The Internet mediaType of the file being converted
     * @return Converted document as an Answer Unit
     */
    public String convertDocument(final File document, final String mediaType) {
        return convertDocument(document, mediaType, ConversionTarget.ANSWER_UNITS);
    }

    /**
     * Synchronously converts a new document without persistence
     * POST /v1/convert_document
     * @param document The file to convert
     * @param mediaType The Internet mediaType of the file being converted
     * @param conversionTarget The conversion target to use
     * @return Converted document in the specified format
     */
    public String convertDocument(final File document, final String mediaType,
                                  final ConversionTarget conversionTarget) {
        return convertDocumentHandler.convertDocument(document, mediaType, conversionTarget);
    }

    /**
     * Synchronously converts a single previously uploaded document.
     * Uses the ANSWER_UNITS conversion target as the default.
     * POST /v1/convert_document
     * @param documentId The id of the document to convert
     * @return Converted document as an Answer Unit
     */
    public String convertDocument(final String documentId) {
        return convertDocument(documentId, ConversionTarget.ANSWER_UNITS);
    }

    /**
     * Synchronously converts a single previously uploaded document
     * POST /v1/convert_document
     * @param documentId The id of the document to convert
     * @param conversionTarget The conversion target to use
     * @return Converted document in the specified format
     */
    public String convertDocument(final String documentId, final ConversionTarget conversionTarget) {
        return convertDocumentHandler.convertDocument(documentId, conversionTarget);
    }

    /**
     * Gets a collection of all jobs
     * GET /v1/jobs
     * @return Jobs
     */
    public JobCollection getJobs() {
        return getJobs(null, 100, null, null, null);
    }

    /**
     * Gets a list of all jobs with optional query parameters for filtering results.
     * GET /v1/jobs
     * @param token The reference to the starting element of the requested page which is provided
     *              by the server, pass null to get the first page
     * @param limit The number of jobs to get, pass null to use the default limit from server (100)
     * @param name The name of the jobs to get, pass null to exclude this filter
     * @param since The date to filter on, jobs created on or after the provided date and time format will
     *              be returned. NOTE: ISO 8601 date and time format is required: (YYYY-MM-DDTHH:MM:SSZ),
     *              pass null to exclude this filter
     * @param status The status of the job to filter on, pass null to exclude this filter
     * @return Jobs based on filtering parameters provided
     */
    public JobCollection getJobs(final String token, final int limit, final String name,
                                 final String since, final JobStatus status) {
        return jobHandler.getJobs(token, limit, name, since, status);
    }

    /**
     * Creates a new job by submitting a batch for processing
     * POST /v1/jobs
     * @param name The name of the job
     * @param batchId The id of the batch to process
     * @param conversionTarget The conversion target to use
     * @return CreateJobResponse
     */
    public CreateJobResponse createJob(final String name, final String batchId, final ConversionTarget conversionTarget) {
        return createJob(name, batchId, conversionTarget, null);
    }

    /**
     * Creates a new job by submitting a batch for processing
     * POST /v1/jobs
     * @param name The name of the job
     * @param batchId The id of the batch to process
     * @param conversionTarget The conversion target to use
     * @param config The configuration to use for the job (optional), pass null to use default config
     * @return CreateJobResponse
     */
    public CreateJobResponse createJob(final String name, final String batchId,
                         final ConversionTarget conversionTarget, final JsonObject config) {
        return jobHandler.createJob(name, batchId, conversionTarget, config);
    }

    /**
     * Gets information about a job
     * GET /v1/jobs/{job_id}
     * @param jobId The id of the job
     * @return Job
     */
    public Job getJob(final String jobId) {
        return jobHandler.getJob(jobId);
    }

    /**
     * Gets the job processing log
     * GET /v1/jobs/{job_id}/log
     * @param jobId The id of the job
     * @return Job's processing log
     */
    public String getJobLog(final String jobId) {
        return jobHandler.getJobLog(jobId);
    }

    /**
     * Gets a collection of all generated outputs
     * GET /v1/output
     * @return All Outputs
     */
    public OutputCollection getOutputCollection() {
        return getOutputCollection(null, 100, null, null, null);
    }

    /**
     * Gets a collection of all generated outputs with optional query parameters for filtering results.
     * GET /v1/output
     * @param token The reference to the starting element of the requested page which is provided
     *              by the server, pass null to get the first page
     * @param limit The number of outputs to get, pass null to use the default limit from server (100)
     * @param since The date to filter on, outputs created on or after the provided date and time format
     *              will be returned. NOTE: ISO 8601 date and time format is required: (YYYY-MM-DDTHH:MM:SSZ),
     *              pass null to exclude this filter
     * @param jobId The id of a job to filter outputs by, pass null to exclude this filter
     * @param mediaType The Internet media type to filter on, pass null to exclude this filter
     * @return Outputs based on filtering parameters provided
     */
    public OutputCollection getOutputCollection(final String token, final int limit, final String since,
                                                final String jobId, final String mediaType) {
        return outputHandler.getOutputCollection(token, limit, since, jobId, mediaType);
    }

    /**
     * Gets the content of the output requested
     * @param outputId The id of the output to get
     * @return The requested Output
     */
    public String getOutput(final String outputId) {
        return outputHandler.getOutput(outputId);
    }

    @Override
    public HttpResponse execute(final HttpRequestBase request) {
        return super.execute(request);
    }

}

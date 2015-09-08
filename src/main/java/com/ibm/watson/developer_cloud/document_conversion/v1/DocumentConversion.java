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
import com.ibm.watson.developer_cloud.document_conversion.v1.helpers.*;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.*;
import com.ibm.watson.developer_cloud.service.WatsonService;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.File;
import java.util.Date;
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

    /** The default limit for get requests */
    public static final int LIMIT = 100;
    /** The Constant URL. */
    private static final String URL = "https://gateway.watsonplatform.net/document-conversion-experimental/api";

    private final BatchHelper batchHelper = new BatchHelper(this);
    private final DocumentHelper documentHelper = new DocumentHelper(this);
    private final BatchDocumentHelper batchDocumentHelper = new BatchDocumentHelper(this);
    private final JobHelper jobHelper = new JobHelper(this);
    private final OutputHelper outputHelper = new OutputHelper(this);
    private final ConvertDocumentHelper convertDocumentHelper = new ConvertDocumentHelper(this);


    /**
     * Sets the endpoint url for the service
     */
    public DocumentConversion() {
        setEndPoint(URL);
    }

    /**
     * Gets a collection of all existing batches
     * GET /v1/batches
     * @return All batches
     */
    public BatchCollection getBatchCollection() {
        return getBatchCollection(null, LIMIT, null, null);
    }

    /**
     * Gets a collection of all existing batches with optional query parameters for filtering results.
     * GET /v1/batches
     * @param limit The number of batches to get, pass null to use the default limit from server (100)
     * @param name The name of batches to get, pass null to exclude this filter
     * @param since The date to filter on, batches created on or after the provided date and time format
     *              will be returned. NOTE: ISO 8601 date and time format is required: (YYYY-MM-DDTHH:MM:SSZ),
     *              pass null to exclude this filter
     * @return Batches based on filtering parameters provided
     */
    public BatchCollection getBatchCollection(final int limit, final String name, final Date since) {
        return getBatchCollection(null, limit, name, since);
    }

    /**
     * Gets a collection of all existing batches with optional query parameters for filtering results.
     * GET /v1/batches
     * @param token The reference to the starting element of the requested page which is provided
     *              by the server, pass null to get the first page
     * @param limit The number of batches to get, pass null to use the default limit from server (100)
     * @param name The name of batches to get, pass null to exclude this filter
     * @param since The date to filter on, batches created on or after the provided date and time format
     *              will be returned. NOTE: ISO 8601 date and time format is required: (YYYY-MM-DDTHH:MM:SSZ),
     *              pass null to exclude this filter
     * @return Batches based on filtering parameters provided
     */
    public BatchCollection getBatchCollection(final String token, final int limit,
                                              final String name, final Date since) {
        return batchHelper.getBatchCollection(token, limit, name, since);
    }

     /**
     * Creates a new batch
     *
     * POST /v1/batches
     * @return requested Batch
     */
    public Batch createBatch() {
        return createBatch(null, null);
    }

    /**
     * Creates a new batch with a name
     *
     * POST /v1/batches
     * @param name the name of the batch to create
     * @return requested Batch
     */
    public Batch createBatch(final String name) {
        return createBatch(name, null);
    }

    /**
     * Creates a new batch with name and properties
     *
     * POST /v1/batches
     * @param name the name of the created batch
     * @param properties the properties for the created batch
     * @return requested Batch
     */
    public Batch createBatch(final String name, final List<Property> properties) {
        return batchHelper.createBatch(name, properties);
    }

    /**
     * Gets an existing batch
     *
     * GET /v1/batches/{batch_id}
     * @param batchId id for the batch to be updated
     * @return requested Batch
     */
    public Batch getBatch(final String batchId) {
        return batchHelper.getBatch(batchId);
    }

    /**
     * Updates an existing batch with the provided name and properties
     *
     * PUT /v1/batches/{batch_id}
     * @param batchId id for the batch to be updated
     * @param name name of the batch to be updated
     * @param properties properties of the batch to be updated
     * @return updated Batch
     *
     */
    public Batch updateBatch(final String batchId, final String name,
                             final List<Property> properties) {
        return batchHelper.updateBatch(batchId, name, properties);
    }

    /**
     * Gets a collection of uploaded documents
     * GET /v1/documents
     * @return All documents
     */
    public DocumentCollection getDocumentCollection() {
        return getDocumentCollection(null, LIMIT, null, null, null);
    }

    /**
     * Gets a collection of all existing documents with optional query parameters for filtering results.
     * GET /v1/documents
     * @param limit The number of documents to get, pass null to use the default limit from server (100)
     * @param name The name of the documents to get, pass null to exclude this filter
     * @param since The date to filter on, documents created on or after the provided date and time format
     *              will be returned. NOTE: ISO 8601 date and time format is required: (YYYY-MM-DDTHH:MM:SSZ),
     *              pass null to exclude this filter
     * @param mediaType The Internet media type to filter on, pass null to exclude this filter
     * @return Documents based on filtering parameters provided
     */
    public DocumentCollection getDocumentCollection(final int limit, final String name,
                                                    final Date since, final String mediaType) {
        return getDocumentCollection (null, limit, name, since, mediaType);
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
     */
    public DocumentCollection getDocumentCollection(final String token, final int limit, final String name,
                                                    final Date since, final String mediaType) {
        return documentHelper.getDocumentCollection(token, limit, name, since, mediaType);
    }

    /**
     * Uploads the document to the store with the given media type
     *
     * POST /v1/documents
     * @param document the document to be uploaded
     * @return Document
     */
    public Document uploadDocument(final File document) {
        return documentHelper.uploadDocument(document);
    }

    /**
     * Retrieves a document from the store with the given id
     *
     * GET /v1/documents/{document_id}
     * @param documentId id of the document to be retrieved
     * @return requested Document
     */
    public String getDocument(final String documentId) {
        return documentHelper.getDocument(documentId);
    }

    /**
     * Gets a collection of existing documents in the batch
     *
     * GET /v1/batches/{batch_id}/documents
     * @param batchId The id for the batch whose documents are returned
     * @return All documents in a batch
     */
    public BatchDocumentCollection getBatchDocumentCollection(final String batchId) {
        return getBatchDocumentCollection(batchId, null, LIMIT, null);
    }


    /**
     * Gets a list of existing documents in the batch with optional query parameters for filtering results.
     *
     * GET /v1/batches/{batch_id}/documents
     * @param batchId The id for the batch whose documents are returned
     * @param limit The number of documents in a batch to get, pass null to use the default limit
     *              from server (100)
     * @param since The date to filter on, documents added to the batch on or after the provided date and time format
     *              will be returned. NOTE: ISO 8601 date and time format is required: (YYYY-MM-DDTHH:MM:SSZ),
     *              pass null to exclude this filter
     * @return Documents in a batch based on the filtering parameters provided
     */
    public BatchDocumentCollection getBatchDocumentCollection(final String batchId, final int limit,
                                                              final Date since) {
        return getBatchDocumentCollection(batchId, null, limit, since);
    }

    /**
     * Gets a list of existing documents in the batch with optional query parameters for filtering results.
     *
     * GET /v1/batches/{batch_id}/documents
     * @param batchId The id for the batch whose documents are returned
     * @param token The reference to the starting element of the requested page which is provided
     *              by the server, pass null to get the first page
     * @param limit The number of documents in a batch to get, pass null to use the default limit
     *              from server (100)
     * @param since The date to filter on, documents added to the batch on or after the provided date and time format
     *              will be returned. NOTE: ISO 8601 date and time format is required: (YYYY-MM-DDTHH:MM:SSZ),
     *              pass null to exclude this filter
     * @return Documents in a batch based on the filtering parameters provided
     */
    public BatchDocumentCollection getBatchDocumentCollection(final String batchId, final String token,
                                                              final int limit, final Date since) {
        return batchDocumentHelper.getBatchDocumentCollection(batchId, token, limit, since);
    }


    /**
     * Retrieves the document from the batch whose ids are specified
     *
     * GET /v1/batches/{batch_id}/documents/{document_id}
     * @param batchId
     *          id of the batch to be retrieved
     * @param documentId
     *          id of the document to be retrieved
     * @return document from the batch
     */
    public BatchDocumentResponse getBatchDocument(final String batchId, final String documentId) {
        return batchDocumentHelper.getBatchDocument(batchId, documentId);
    }

    /**
     * Adds a document to the batch whose ids are specified
     *
     * PUT /v1/batches/{batch_id}/documents/{document_id}
     * @param batchId
     *          id of the batch to be retrieved
     * @param documentId
     *          id of the document to be retrieved
     * @return document from the batch
     */
    public BatchDocumentResponse addDocumentToBatch(final String batchId, final String documentId) {
        return batchDocumentHelper.addDocumentToBatch(batchId, documentId);
    }

    /**
     * Synchronously converts a new document without persistence into an Answer object
     * POST /v1/convert_document
     * @param document The file to convert
     * @return Converted document as an Answer Unit
     */
    public Answer convertDocumentToAnswer(final File document) {
        return convertDocumentHelper.convertDocumentToAnswer(document);
    }

    /**
     * Synchronously converts a new document without persistence
     * POST /v1/convert_document
     * @param document The file to convert
     * @param conversionTarget The conversion target to use
     * @return Converted document in the specified format
     */
    public String convertDocument(final File document, final ConversionTarget conversionTarget) {
        return convertDocumentHelper.convertDocument(document, conversionTarget);
    }

    /**
     * Synchronously converts a single previously uploaded document into an Answer object
     * POST /v1/convert_document
     * @param documentId The id of the document to convert
     * @return Converted document as an Answer
     */
    public Answer convertDocumentToAnswer(final String documentId) {
        return convertDocumentHelper.convertDocumentToAnswer(documentId);
    }

    /**
     * Synchronously converts a single previously uploaded document
     * POST /v1/convert_document
     * @param documentId The id of the document to convert
     * @param conversionTarget The conversion target to use
     * @return Converted document in the specified format
     */
    public String convertDocument(final String documentId, final ConversionTarget conversionTarget) {
        return convertDocumentHelper.convertDocument(documentId, conversionTarget);
    }

    /**
     * Gets a collection of all jobs
     * GET /v1/jobs
     * @return Jobs
     */
    public JobCollection getJobCollection() {
        return getJobCollection(null, LIMIT, null, null, null);
    }


    /**
     * Gets a list of all jobs with optional query parameters for filtering results.
     * GET /v1/jobs
     * @param limit The number of jobs to get, pass 0 to use the default limit from server (100)
     * @param name The name of the jobs to get, pass null to exclude this filter
     * @param since The date to filter on, jobs created on or after the provided date and time format will
     *              be returned.
     * @param status The status of the job to filter on, pass null to exclude this filter
     * @return Jobs based on filtering parameters provided
     */
    public JobCollection getJobCollection(final int limit, final String name,
                                          final Date since, final JobStatus status) {
        return getJobCollection(null, limit, name, since, status);
    }

    /**
     * Gets a list of all jobs with optional query parameters for filtering results.
     * GET /v1/jobs
     * @param token The reference to the starting element of the requested page which is provided
     *              by the server, pass null to get the first page
     * @param limit The number of jobs to get, pass 0 to use the default limit from server (100)
     * @param name The name of the jobs to get, pass null to exclude this filter
     * @param since The date to filter on, jobs created on or after the provided date and time format will
     *              be returned.
     * @param status The status of the job to filter on, pass null to exclude this filter
     * @return Jobs based on filtering parameters provided
     */
    public JobCollection getJobCollection(final String token, final int limit, final String name,
                                          final Date since, final JobStatus status) {
        return jobHelper.getJobCollection(token, limit, name, since, status);
    }

    /**
     * Creates a new job by submitting a batch for processing
     * POST /v1/jobs
     * @param name The name of the job
     * @param batchId The id of the batch to process
     * @param conversionTarget The conversion target to use
     * @return JobResponse
     */
    public JobResponse createJob(final String name, final String batchId, final ConversionTarget conversionTarget) {
        return createJob(name, batchId, conversionTarget, null);
    }

    /**
     * Creates a new job by submitting a batch for processing
     * POST /v1/jobs
     * @param name The name of the job
     * @param batchId The id of the batch to process
     * @param conversionTarget The conversion target to use
     * @param config The configuration to use for the job (optional), pass null to use default config
     * @return JobResponse
     */
    public JobResponse createJob(final String name, final String batchId,
                         final ConversionTarget conversionTarget, final JsonObject config) {
        return jobHelper.createJob(name, batchId, conversionTarget, config);
    }

    /**
     * Gets information about a job
     * GET /v1/jobs/{job_id}
     * @param jobId The id of the job
     * @return Job
     */
    public Job getJob(final String jobId) {
        return jobHelper.getJob(jobId);
    }

    /**
     * Gets the job processing log
     * GET /v1/jobs/{job_id}/log
     * @param jobId The id of the job
     * @return Job's processing log
     */
    public String getJobLog(final String jobId) {
        return jobHelper.getJobLog(jobId);
    }

    /**
     * Gets a collection of all generated outputs
     * GET /v1/output
     * @return All Outputs
     */
    public OutputCollection getOutputCollection() {
        return getOutputCollection(null, LIMIT, null, null, null);
    }

    /**
     * Gets a collection of all generated outputs with optional query parameters for filtering results.
     * GET /v1/output
     * @param limit The number of outputs to get, pass null to use the default limit from server (100)
     * @param since The date to filter on, outputs created on or after the provided date and time format
     *              will be returned. NOTE: ISO 8601 date and time format is required: (YYYY-MM-DDTHH:MM:SSZ),
     *              pass null to exclude this filter
     * @param jobId The id of a job to filter outputs by, pass null to exclude this filter
     * @param mediaType The Internet media type to filter on, pass null to exclude this filter, for example "text/html"
     * @return Outputs based on filtering parameters provided
     */
    public OutputCollection getOutputCollection(final int limit, final Date since,
                                                final String jobId, final String mediaType) {
        return getOutputCollection(null, limit, since, jobId, mediaType);
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
    public OutputCollection getOutputCollection(final String token, final int limit, final Date since,
                                                final String jobId, final String mediaType) {
        return outputHelper.getOutputCollection(token, limit, since, jobId, mediaType);
    }

    /**
     * Gets the content of the output of the document conversion process. This can represent a single converted document
     * or the combined output of multiple input documents.
     * @param outputId The id of the output to get
     * @return The requested Output
     */
    public String getOutput(final String outputId) {
        return outputHelper.getOutput(outputId);
    }

    @Override
    public HttpResponse execute(final HttpRequestBase request) {
        return super.execute(request);
    }

}

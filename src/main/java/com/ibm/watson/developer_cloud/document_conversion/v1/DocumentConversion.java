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
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    private BatchHandler batchHandler = new BatchHandler(this);
    private ConvertDocumentHandler convertDocumentHandler = new ConvertDocumentHandler(this);
    private DocumentHandler documentHandler = new DocumentHandler(this);
    private JobHandler jobHandler = new JobHandler(this);
    private OutputHandler outputHandler = new OutputHandler(this);

    public DocumentConversion() {
        setEndPoint(URL);
    }

    /**
     * Gets a list of existing batches
     *
     * GET /v1/batches
     * @return List
     */
    public List<Batch> getBatches() {
        return batchHandler.getBatches();
    }

    /**
     * Creates a new batch
     *
     * POST /v1/batches
     * @return Batch
     */
    public Batch createBatch() {
        return batchHandler.createBatch();
    }

    /**
     * Gets an existing batch
     *
     * GET /v1/batches/{batch_id}
     * @param batchId
     * @return Batch
     */
    public Batch getBatch(String batchId) {
        return batchHandler.getBatch(batchId);
    }

    /**
     * Updates an existing batch
     *
     * PUT /v1/batches/{batch_id}
     * @param batchId
     */
    public void updateBatch(String batchId) {
        batchHandler.updateBatch(batchId);
    }

    /**
     * Gets a list of existing documents in the batch
     *
     * GET /v1/batches/{batch_id}/documents
     * @return BatchDocument
     */
    public List<BatchDocument> getBatchDocuments() {
        return batchHandler.getBatchDocuments();
    }

    /**
     * Gets a document in the batch
     *
     * GET /v1/batches/{batch_id}/documents/{document_id}
     * @param documentId
     * @return BatchDocument
     */
    public BatchDocument getBatchDocument(String documentId) {
        return batchHandler.getBatchDocument(documentId);
    }

    /**
     * Adds a document to the batch
     *
     * PUT /v1/batches/{batch_id}/documents/{document_id}
     * @param batchId
     * @param documentId
     */
    public void addDocumentToBatch(String batchId, String documentId) {
        batchHandler.addDocumentToBatch(batchId, documentId);
    }


    /**
     * Synchronously converts a new document without persistence
     *
     * POST /v1/convert_document
     * @param document
     * @return String
     */
    public String convertDocument(File document) {
        return convertDocumentHandler.convertDocument(document);
    }

    /**
     * Synchronously converts a single previously uploaded document
     *
     * POST /v1/convert_document
     * @param documentId
     * @return String
     */
    public String convertDocument(String documentId) {
        return convertDocumentHandler.convertDocument(documentId);
    }

    /**
     * Gets a list of uploaded documents
     *
     * GET /v1/documents
     * @return Document
     */
    public List<Document> getDocuments() {
        return documentHandler.getDocuments();
    }

    /**
     * Adds a document
     *
     * POST /v1/documents
     * @param document
     * @return String
     */
    public String addDocument(File document) {
        return documentHandler.addDocument(document);
    }

    /**
     * Gets a document
     *
     * GET /v1/documents/{document_id}
     * @param documentId
     * @return Document
     */
    public Document getDocument(String documentId) {
        return documentHandler.getDocument(documentId);
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
    public String createJob(String batchId) {
        return jobHandler.createJob(batchId);
    }

    /**
     * Gets information about a job
     *
     * GET /v1/jobs/{job_id}
     * @param jobId
     * @return Job
     */
    public Job getJob(String jobId) {
        return jobHandler.getJob(jobId);
    }

    /**
     * Gets the job processing log
     *
     * GET /v1/jobs/{job_id}/log
     * @param jobId
     * @return String
     */
    public String getJobLog(String jobId) {
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
    public Output getOutput(String outputId) {
        return outputHandler.getOutput(outputId);
    }

    @Override
    public HttpResponse execute(HttpRequestBase request) {
        return super.execute(request);
    }

}

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

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Parameter;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.document_conversion.v1.helpers.ConversionUtils;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Batch;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.BatchCollection;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.BatchDocument;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.BatchDocumentCollection;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.BatchDocumentResponse;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.ConversionTarget;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Document;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.DocumentCollection;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Job;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.JobCollection;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.JobResponse;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.JobStatus;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Link;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Output;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.OutputCollection;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Property;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.MediaType;

/**
 * The Class DocumentConversionTest.
 */
public class DocumentConversionTest extends WatsonServiceTest {

    /** The Constant log. */
    private static final Logger log = Logger.getLogger(DocumentConversionTest.class.getName());

    /** Mock Server *. */
    private ClientAndServer mockServer;

    /** The service. */
    private DocumentConversion service;

    /**
     * Start mock server.
     */
    @Before
    public void startMockServer() {
        try {
            mockServer = startClientAndServer(Integer.parseInt(prop.getProperty("mock.server.port")));
            service = new DocumentConversion();
            service.setApiKey("");
            service.setEndPoint("http://" + prop.getProperty("mock.server.host") + ":"
                    + prop.getProperty("mock.server.port"));
        } catch (NumberFormatException e) {
            log.log(Level.SEVERE, "Error mocking the service", e);
        }

    }

    /**
     * Stop mock server.
     */
    @After
    public void stopMockServer() {
        mockServer.stop();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
     */
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

    }

    /**
     * Test convert document with no persistence.
     *
     * @throws URISyntaxException the URI syntax exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testConvertDocumentNoPersistence() throws URISyntaxException, IOException {
        File expAnswerFile = new File("src/test/resources/document_conversion/html-with-extra-content-input-to-answer.json");
        File html = new File("src/test/resources/document_conversion/html-with-extra-content-input.htm");
        byte[] expAnswer = IOUtils.toByteArray(new FileInputStream(expAnswerFile));

        mockServer.when(
                request().withMethod("POST").withPath(DocumentConversion.CONVERT_DOCUMENT_PATH)
        ).respond(response().withBody(expAnswer));

        String convertedDoc = ConversionUtils.writeInputStreamToString(service.convertDocument(html, ConversionTarget.ANSWER_UNITS));
        Assert.assertNotNull(convertedDoc);
        Assert.assertEquals(convertedDoc, new String(expAnswer));

        // Convert document with a specified media type
        String convertWithMediaType = ConversionUtils.writeInputStreamToString(
                service.convertDocument(html, MediaType.TEXT_HTML, ConversionTarget.ANSWER_UNITS)
        );
        Assert.assertNotNull(convertWithMediaType);
        Assert.assertEquals(convertWithMediaType, new String(expAnswer));

        // Convert to Answers
        Answers answers = service.convertDocumentToAnswer(html);
        Assert.assertNotNull(answers);
    }

    /**
     * Test convert document with persistence.
     *
     * @throws URISyntaxException the URI syntax exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testConvertDocumentWithPersistence() throws URISyntaxException, IOException {
        File expAnswerFile = new File("src/test/resources/document_conversion/html-with-extra-content-input-to-answer.json");
        File html = new File("src/test/resources/document_conversion/html-with-extra-content-input.htm");
        byte[] expAnswer = IOUtils.toByteArray(new FileInputStream(expAnswerFile));

        String docId = UUID.randomUUID().toString();
        Document createDocResponse = createMockDocument(docId, "html-with-extra-content-input.htm", MediaType.TEXT_HTML);
        mockServer.when(
                request().withMethod("POST").withPath(DocumentConversion.DOCUMENTS_PATH)
        ).respond((response().withBody(GsonSingleton.getGson().toJson(createDocResponse))));
        service.uploadDocument(html);

        mockServer.when(
                request().withMethod("POST").withPath(DocumentConversion.CONVERT_DOCUMENT_PATH)
        ).respond(response().withBody(expAnswer));

        String convertedDoc = ConversionUtils.writeInputStreamToString(service.convertDocument(docId, ConversionTarget.ANSWER_UNITS));
        Assert.assertNotNull(convertedDoc);
        Assert.assertEquals(convertedDoc, new String(expAnswer));

        // Convert to Answers
        Answers answers = service.convertDocumentToAnswer(docId);
        Assert.assertNotNull(answers);
    }

    /**
     * Test upload document.
     *
     * @throws URISyntaxException the URI syntax exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testUploadDocument() throws URISyntaxException, IOException {
        String docId = UUID.randomUUID().toString();
        String pdfDocId = UUID.randomUUID().toString();
        Document response = createMockDocument(docId, "html-with-extra-content-input.htm", MediaType.TEXT_HTML);
        Document pdfResponse = createMockDocument(pdfDocId, "pdf-with-sections-input.pdf", MediaType.APPLICATION_PDF);
        File html = new File("src/test/resources/document_conversion/html-with-extra-content-input.htm");
        File pdf = new File("src/test/resources/document_conversion/pdf-with-sections-input.pdf");

        mockServer.when(
                request().withMethod("POST").withPath(DocumentConversion.DOCUMENTS_PATH)
        ).respond((response().withBody(GsonSingleton.getGson().toJson(response))));

        // Call upload document
        Document document = service.uploadDocument(html);

        Assert.assertNotNull(document);
        Assert.assertEquals(document.toString(), response.toString());

        mockServer.reset().when(
                request().withMethod("POST").withPath(DocumentConversion.DOCUMENTS_PATH)
        ).respond((response().withBody(GsonSingleton.getGson().toJson(pdfResponse))));

        // Call upload document with media type
        Document pdfDocument = service.uploadDocument(pdf, MediaType.APPLICATION_PDF);
        Assert.assertNotNull(pdfDocument);
        Assert.assertEquals(pdfDocument.toString(), pdfResponse.toString());
    }

    /**
     * Test create batch.
     */
    @Test
    public void testCreateBatch() {
        // Expected Mock response
        String batchId = UUID.randomUUID().toString();
        String name = "testBatch";
        // NOTE: Setting null time, no current way to simulate JodaTime to service getters
        Date currentTime = null;
        List<Property> propertyList = Arrays.asList(
                new Property("media_type", MediaType.TEXT_HTML), new Property("num_docs", "2"));
        Batch response = createMockBatch(batchId, name, currentTime, currentTime, propertyList);

        mockServer.when(
                request().withMethod("POST").withPath(DocumentConversion.BATCHES_PATH)
        ).respond((response().withBody(GsonSingleton.getGson().toJson(response))));

        // Call create batch
        Batch batch = service.createBatch(name, propertyList);
        Assert.assertNotNull(batch);
        Assert.assertEquals(batch.toString(), response.toString());
    }

    /**
     * Test create job.
     */
    @Test
    public void testCreateJob() {
        // Expected Mock response
        String batchId = UUID.randomUUID().toString();
        String jobId = UUID.randomUUID().toString();
        String jobName = "testJob";

        JobResponse response = new JobResponse();
        response.setId(jobId);
        response.setName(jobName);
        response.setLinks(Arrays.asList(createLink("self", DocumentConversion.JOBS_PATH + "/" + jobId)));

        mockServer.when(
                request().withMethod("POST").withPath(DocumentConversion.JOBS_PATH)
        ).respond((response().withBody(GsonSingleton.getGson().toJson(response))));

        // Call create job
        JobResponse job = service.createJob(jobName, batchId, ConversionTarget.ANSWER_UNITS);
        Assert.assertNotNull(job);
        Assert.assertEquals(job.toString(), response.toString());

        // Call create job with a custom config
        JsonObject customJobConfig = new JsonObject();
        JsonObject configOptions = new JsonObject();
        configOptions.addProperty("selector", "h3");
        customJobConfig.add("html-to-pau", configOptions);
        JobResponse jobWithConfig = service.createJob(jobName, batchId, ConversionTarget.ANSWER_UNITS, customJobConfig);
        Assert.assertNotNull(jobWithConfig);
        Assert.assertEquals(jobWithConfig.toString(), response.toString());
    }

    /**
     * Test get document collection and get document.
     */
    @Test
    public void testGetDocumentCollection() {
        // Expected Mock response
        DocumentCollection docCollWithQueryResponse = new DocumentCollection();
        List<Document> documentsWithQuery = new ArrayList<Document>();
        String docId = UUID.randomUUID().toString();
        String docName = "documentName";
        Document doc = createMockDocument(docId, docName, MediaType.TEXT_HTML);
        String docContent = "<html><title>Test</title><body><text>test document</text></body></html>";
        documentsWithQuery.add(doc);
        List<Link> links = new ArrayList<Link>();
        docCollWithQueryResponse.setLinks(links);

        // Call get documents without query parameters
        mockServer.reset().when(request()
                .withPath(DocumentConversion.DOCUMENTS_PATH))
                .respond(response().withBody(GsonSingleton.getGson().toJson(docCollWithQueryResponse))
                );
        DocumentCollection docColl = service.getDocumentCollection();
        Assert.assertNotNull(docColl);
        Assert.assertEquals(docColl.toString(), docCollWithQueryResponse.toString());

        // Call get documents with query parameters
        List<Parameter> queryParams = new ArrayList<Parameter>();
        queryParams.add(new Parameter("name", docName));
        queryParams.add(new Parameter("limit", "5"));
        mockServer.reset().when(request()
                .withPath(DocumentConversion.DOCUMENTS_PATH).withQueryStringParameters(queryParams))
                .respond(response().withBody(GsonSingleton.getGson().toJson(docCollWithQueryResponse))
                );
        Map<String, Object> docListParams = new HashMap<String, Object>();
        docListParams.put(DocumentConversion.LIMIT, 5);
        docListParams.put(DocumentConversion.NAME, docName);
        DocumentCollection docCollWithQuery = service.getDocumentCollection(docListParams);
        Assert.assertNotNull(docCollWithQuery);
        Assert.assertEquals(docCollWithQuery.toString(), docCollWithQueryResponse.toString());

        // Call get document
        mockServer.when(request().withPath(DocumentConversion.DOCUMENTS_PATH + "/" + docId)).respond(
                response().withBody(docContent)
        );
        String document1 = ConversionUtils.writeInputStreamToString(service.getDocument(docId));
        Assert.assertNotNull(document1);
        Assert.assertEquals(document1, docContent);
    }

    /**
     * Test batches.
     */
    @Test
    public void testBatches() {
        // Expected Mock response
        BatchCollection batchCollWithQueryResponse = new BatchCollection();
        List<Batch> batchList = new ArrayList<Batch>();
        String batchId = UUID.randomUUID().toString();
        String batchName = "batchName";
        // NOTE: Setting null time, no current way to simulate JodaTime to service getters
        Date currentTime = null;
        List<Property> propertyList = Arrays.asList(
                new Property("media_type", MediaType.TEXT_HTML), new Property("num_docs", "2"));
        Batch batch = createMockBatch(batchId, batchName, currentTime, currentTime, propertyList);
        batchList.add(batch);
        batchCollWithQueryResponse.setBatches(batchList);
        List<Link> links = new ArrayList<Link>();
        batchCollWithQueryResponse.setLinks(links);

        // Call get batches without query parameters
        mockServer.reset().when(request()
                .withPath(DocumentConversion.BATCHES_PATH))
                .respond(response().withBody(GsonSingleton.getGson().toJson(batchCollWithQueryResponse))
                );
        BatchCollection batchColl = service.getBatchCollection();
        Assert.assertNotNull(batchColl);
        Assert.assertEquals(batchColl.toString(), batchCollWithQueryResponse.toString());

        // Call get batches with query parameters
        List<Parameter> queryParams = new ArrayList<Parameter>();
        queryParams.add(new Parameter("name", batchName));
        queryParams.add(new Parameter("limit", "10"));
        mockServer.reset().when(request()
                .withPath(DocumentConversion.BATCHES_PATH).withQueryStringParameters(queryParams))
                .respond(response().withBody(GsonSingleton.getGson().toJson(batchCollWithQueryResponse))
                );
        Map<String, Object> batchListParams = new HashMap<String, Object>();
        batchListParams.put(DocumentConversion.LIMIT, 10);
        batchListParams.put(DocumentConversion.NAME, batchName);
        BatchCollection batchCollWithQuery = service.getBatchCollection(batchListParams);
        Assert.assertNotNull(batchCollWithQuery);
        Assert.assertEquals(batchCollWithQuery.toString(), batchCollWithQueryResponse.toString());

        // Call get batch
        mockServer.when(request().withPath(DocumentConversion.BATCHES_PATH + "/" + batchId)).respond(
                response().withBody(GsonSingleton.getGson().toJson(batch))
        );
        Batch getBatch = service.getBatch(batchId);
        Assert.assertNotNull(getBatch);
        Assert.assertEquals(getBatch.toString(), batch.toString());

        // Update Batch
        String newBatchName = "updatedBatchName";
        List<Property> newPropertyList = Arrays.asList(
                new Property("media_type", MediaType.APPLICATION_PDF), new Property("num_docs", "6"));
        // NOTE: Setting null time, no current way to simulate JodaTime to service getters
        Date newTime = null;
        Batch updatedBatch = createMockBatch(batchId, newBatchName, currentTime, newTime, newPropertyList);

        // Call update batch
        mockServer.reset().when(request().withMethod("PUT").withPath(DocumentConversion.BATCHES_PATH + "/" + batchId)).respond(
                response().withBody(GsonSingleton.getGson().toJson(updatedBatch))
        );

        Batch updatedBatchResponse = service.updateBatch(batchId, newBatchName, newPropertyList);
        Assert.assertNotNull(updatedBatchResponse);
        Assert.assertEquals(updatedBatch.toString(), updatedBatchResponse.toString());
    }

    /**
     * Test get batch documents.
     */
    @Test
    public void testGetBatchDocuments() {
        // Create a mock batch
        String batchId = UUID.randomUUID().toString();
        BatchDocumentCollection batchDocCollWithQueryResponse = new BatchDocumentCollection();
        batchDocCollWithQueryResponse.setLinks(
                Arrays.asList(createLink("first", DocumentConversion.BATCHES_PATH + "/" + batchId + "/documents"))
        );

        // Create a mock batch document
        String batchDocId = UUID.randomUUID().toString();
        BatchDocument batchDocument = new BatchDocument();
        batchDocument.setId(batchDocId);
        // NOTE: Setting null time, no current way to simulate JodaTime to service getters
        batchDocument.setAddedToBatch(null);
        batchDocument.setLinks(Arrays.asList(
                        createLink("self", DocumentConversion.BATCHES_PATH + "/" + batchId + "/documents/" + batchDocId),
                        createLink("document", DocumentConversion.DOCUMENTS_PATH + "/documents/" + batchDocId)
                )
        );

        // Create mock batch document response
        BatchDocumentResponse batchDocumentResponse = new BatchDocumentResponse();
        batchDocumentResponse.setDocument(batchDocument);

        // Add document to batch
        batchDocCollWithQueryResponse.setDocuments(Arrays.asList(batchDocument));

        mockServer.when(request().withMethod("PUT")
                .withPath(DocumentConversion.BATCHES_PATH + "/" + batchId + "/documents/" + batchDocId)).respond(
                response().withBody(GsonSingleton.getGson().toJson(batchDocumentResponse))
        );
        BatchDocumentResponse addBatchDocResponse = service.addDocumentToBatch(batchId, batchDocId);
        Assert.assertNotNull(addBatchDocResponse);
        Assert.assertEquals(addBatchDocResponse.toString(), batchDocumentResponse.toString());

        // Call get batch documents without query parameters
        mockServer.reset().when(request()
                .withPath(DocumentConversion.BATCHES_PATH + "/" + batchId + "/documents"))
                .respond(response().withBody(GsonSingleton.getGson().toJson(batchDocCollWithQueryResponse))
                );
        BatchDocumentCollection batchDocColl = service.getBatchDocumentCollection(batchId);
        Assert.assertNotNull(batchDocColl);
        Assert.assertEquals(batchDocColl.toString(), batchDocCollWithQueryResponse.toString());

        // Call get batch documents with query parameters
        List<Parameter> queryParams = new ArrayList<Parameter>();
        queryParams.add(new Parameter("limit", "15"));
        mockServer.reset().when(request()
                .withPath(DocumentConversion.BATCHES_PATH + "/" + batchId + "/documents").withQueryStringParameters(queryParams))
                .respond(response().withBody(GsonSingleton.getGson().toJson(batchDocCollWithQueryResponse))
                );
        Map<String, Object> batchDocListParams = new HashMap<String, Object>();
        batchDocListParams.put(DocumentConversion.LIMIT, 15);
        BatchDocumentCollection batchDocCollWithQuery = service.getBatchDocumentCollection(batchId, batchDocListParams);
        Assert.assertNotNull(batchDocCollWithQuery);
        Assert.assertEquals(batchDocCollWithQuery.toString(), batchDocCollWithQueryResponse.toString());

        // Call get batch document
        mockServer.when(request().withPath(DocumentConversion.BATCHES_PATH + "/" + batchId + "/documents/" + batchDocId)).respond(
                response().withBody(GsonSingleton.getGson().toJson(batchDocumentResponse))
        );
        BatchDocumentResponse response = service.getBatchDocument(batchId, batchDocId);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.toString(), batchDocumentResponse.toString());
    }

    /**
     * Test jobs.
     */
    @Test
    public void testJobs() {
        // Expected Mock response
        JobCollection jobCollWithQueryResponse = new JobCollection();
        List<Job> jobList = new ArrayList<Job>();
        String jobId = UUID.randomUUID().toString();
        String batchId = UUID.randomUUID().toString();
        String documentId = UUID.randomUUID().toString();
        String jobName = "testJob";
        // NOTE: Setting null time, no current way to simulate JodaTime to service getters
        Date currentTime = null;
        Job job = createMockJob(jobId, jobName, batchId, null, ConversionTarget.ANSWER_UNITS,
                currentTime, null, "25", "Result", JobStatus.COMPLETE);
        jobList.add(job);
        jobCollWithQueryResponse.setJobs(jobList);
        List<Link> links = new ArrayList<Link>();
        jobCollWithQueryResponse.setLinks(links);

        // Call get jobs without query parameters
        mockServer.reset().when(request()
                .withPath(DocumentConversion.JOBS_PATH))
                .respond(response().withBody(GsonSingleton.getGson().toJson(jobCollWithQueryResponse))
                );
        JobCollection jobColl = service.getJobCollection();
        Assert.assertNotNull(jobColl);
        Assert.assertEquals(jobColl.toString(), jobCollWithQueryResponse.toString());

        // Call get jobs with query parameters
        List<Parameter> queryParams = new ArrayList<Parameter>();
        queryParams.add(new Parameter("name", jobName));
        queryParams.add(new Parameter("limit", "7"));
        queryParams.add(new Parameter("status", JobStatus.COMPLETE.toString()));
        mockServer.reset().when(request()
                .withPath(DocumentConversion.JOBS_PATH).withQueryStringParameters(queryParams))
                .respond(response().withBody(GsonSingleton.getGson().toJson(jobCollWithQueryResponse))
                );
        Map<String, Object> jobListParams = new HashMap<String, Object>();
        jobListParams.put(DocumentConversion.LIMIT, 7);
        jobListParams.put(DocumentConversion.NAME, jobName);
        jobListParams.put(DocumentConversion.STATUS, JobStatus.COMPLETE);
        JobCollection jobCollWithQuery = service.getJobCollection(jobListParams);
        Assert.assertNotNull(jobCollWithQuery);
        Assert.assertEquals(jobCollWithQuery.toString(), jobCollWithQueryResponse.toString());

        // Call get job
        mockServer.when(request().withPath(DocumentConversion.JOBS_PATH + "/" + jobId)).respond(
                response().withBody(GsonSingleton.getGson().toJson(job))
        );
        Job getJob = service.getJob(jobId);
        Assert.assertNotNull(getJob);
        Assert.assertEquals(getJob.toString(), job.toString());

        // Call get job log
        String expectedJobLog = "Document " + documentId + " - SUCCESS";
        mockServer.when(request().withPath(DocumentConversion.JOBS_PATH + "/" + jobId + "/log")).respond(
                response().withBody(expectedJobLog)
        );

        String jobLog = ConversionUtils.writeInputStreamToString(service.getJobLog(jobId));
        Assert.assertNotNull(getJob);
        Assert.assertEquals(expectedJobLog, jobLog);
    }

    /**
     * Test outputs.
     *
     * @throws URISyntaxException the URI syntax exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testOutputs() throws URISyntaxException, IOException {
        // Expected Mock response
        OutputCollection outputCollWithQueryResponse = new OutputCollection();
        List<Output> outputList = new ArrayList<Output>();
        String outputId = UUID.randomUUID().toString();
        String jobId = UUID.randomUUID().toString();
        Output output = createMockOutput(outputId, jobId, null, null, null);
        outputList.add(output);
        outputCollWithQueryResponse.setOutputs(outputList);
        List<Link> links = new ArrayList<Link>();
        outputCollWithQueryResponse.setLinks(links);

        File expAnswerFile = new File("src/test/resources/document_conversion/html-with-extra-content-input-to-answer.json");
        byte[] expAnswer = IOUtils.toByteArray(new FileInputStream(expAnswerFile));

        // Call get outputs without query parameters
        mockServer.reset().when(request()
                .withPath(DocumentConversion.OUTPUT_PATH))
                .respond(response().withBody(GsonSingleton.getGson().toJson(outputCollWithQueryResponse))
                );
        OutputCollection outputColl = service.getOutputCollection();
        Assert.assertNotNull(outputColl);
        Assert.assertEquals(outputColl.toString(), outputCollWithQueryResponse.toString());

        // Call get outputs with query parameters
        List<Parameter> queryParams = new ArrayList<Parameter>();
        queryParams.add(new Parameter("job_id", jobId));
        queryParams.add(new Parameter("limit", "8"));
        mockServer.reset().when(request()
                .withPath(DocumentConversion.OUTPUT_PATH).withQueryStringParameters(queryParams))
                .respond(response().withBody(GsonSingleton.getGson().toJson(outputCollWithQueryResponse))
                );
        Map<String, Object> outputListParams = new HashMap<String, Object>();
        outputListParams.put(DocumentConversion.LIMIT, 8);
        outputListParams.put(DocumentConversion.JOB_ID, jobId);
        OutputCollection outputCollWithQuery = service.getOutputCollection(outputListParams);
        Assert.assertNotNull(outputCollWithQuery);
        Assert.assertEquals(outputCollWithQuery.toString(), outputCollWithQueryResponse.toString());

        // Call get output
        mockServer.when(request().withPath(DocumentConversion.OUTPUT_PATH + "/" + outputId)).respond(
                response().withBody(expAnswer.toString())
        );
        String getOutput = ConversionUtils.writeInputStreamToString(service.getOutput(outputId));
        Assert.assertNotNull(getOutput);
        Assert.assertEquals(getOutput, expAnswer.toString());
    }

    // ####################################
    // ########## HELPER METHODS ##########
    // ####################################

    /**
     * Create a Document object.
     *
     * @param id The id of the document
     * @param name The name of the document
     * @param mediaType The Internet media type of the document
     * @return Document
     */
    private Document createMockDocument(String id, String name, String mediaType) {
        Document doc = new Document();
        doc.setId(id);
        doc.setName(name);
        doc.setMediaType(mediaType);
        doc.setLinks(Arrays.asList(createLink("self", DocumentConversion.DOCUMENTS_PATH + "/" + id)));
        return doc;
    }

    /**
     * Create a Batch object.
     *
     * @param id The id of the batch
     * @param name The name of the batch
     * @param createdOn The time the batch was created
     * @param updatedOn The time the batch was updated
     * @param props The list of properties for the batch
     * @return Batch
     */
    private Batch createMockBatch(String id, String name, Date createdOn, Date updatedOn, List<Property> props) {
        Batch batch = new Batch();
        batch.setId(id);
        batch.setName(name);
        batch.setCreatedOn(createdOn);
        batch.setUpdatedOn(updatedOn);
        batch.setProperties(props);
        batch.setLinks(Arrays.asList(createLink("self", DocumentConversion.BATCHES_PATH + "/" + id)));
        return batch;
    }

    /**
     * Create a Job object.
     *
     * @param id The id of the job
     * @param name The name of the job
     * @param batchId The id of the batch that the job will execute
     * @param config The configuration for the job
     * @param convTarget The conversion target that the job should run
     * @param createdOn The time the job was created
     * @param docCounts The document counts for the job
     * @param duration The duration of the job
     * @param result The result of the job
     * @param status The status of the job
     * @return Job
     */
    private Job createMockJob(String id, String name, String batchId, JsonObject config,
                              ConversionTarget convTarget, Date createdOn, JsonObject docCounts,
                              String duration, String result, JobStatus status ) {
        Job job = new Job();
        job.setId(id);
        job.setName(name);
        job.setBatchId(batchId);
        job.setConfig(config);
        job.setConversionTarget(convTarget);
        job.setCreatedOn(createdOn);
        job.setDocumentCounts(docCounts);
        job.setDuration(duration);
        job.setResult(result);
        job.setStatus(status);
        job.setLinks(Arrays.asList(createLink("self", DocumentConversion.JOBS_PATH + "/" + id)));
        return job;
    }

    /**
     * Create an Output object.
     *
     * @param id The id of the output
     * @param jobId The id of job that generated the output
     * @param srcDocId The id of the source document used to generate this output
     * @param createdOn The time the output was created
     * @param mediaType The internet media type of the output
     * @return Output
     */
    private Output createMockOutput(String id, String jobId, String srcDocId, Date createdOn, String mediaType) {
        Output output = new Output();
        output.setId(id);
        output.setJobId(jobId);
        output.setSourceDocumentId(srcDocId);
        output.setCreatedOn(createdOn);
        output.setMediaType(mediaType);
        output.setLinks(Arrays.asList(createLink("self", DocumentConversion.OUTPUT_PATH + "/" + id)));
        return output;
    }

    /**
     * Create a Link object.
     *
     * @param linkName The name of the link
     * @param linkPath The path of the link
     * @return Link
     */
    private Link createLink(String linkName, String linkPath) {
        Link selfLink = new Link();
        selfLink.setName(linkName);
        selfLink.setLink(linkPath);
        return selfLink;
    }
}

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
import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.*;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.MediaType;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Parameter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

/**
 * The Class DocumentConversionTest
 */
public class DocumentConversionTest extends WatsonServiceTest {

    /** The Constant log. */
    private static final Logger log = Logger.getLogger(DocumentConversionTest.class.getName());

    /** Mock Server *. */
    private ClientAndServer mockServer;

    /** The DOCUMENTS_PATH.  (value is "/v1/documents") */
    private final static String DOCUMENTS_PATH = "/v1/documents";

    /** The BATCHES_PATH.  (value is "/v1/batches") */
    private final static String BATCHES_PATH = "/v1/batches";

    /** The JOBS_PATH.  (value is "/v1/jobs") */
    private final static String JOBS_PATH = "/v1/jobs";

    /** The OUTPUT_PATH.  (value is "/v1/output") */
    private final static String OUTPUT_PATH = "/v1/output";

    private final static String CONVERT_DOCUMENT_PATH = "/v1/convert_document";

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
     * Test convert document with no persistence
     */
    @Test
    public void testConvertDocumentNoPersistence() throws URISyntaxException, IOException {
        File expAnswerFile = getResourceFile("document_conversion/html-with-extra-content-input-to-answer.json");
        File html = getResourceFile("document_conversion/html-with-extra-content-input.htm");
        byte[] expAnswer = IOUtils.toByteArray(new FileInputStream(expAnswerFile));

        mockServer.when(
                request().withMethod("POST").withPath(CONVERT_DOCUMENT_PATH)
        ).respond(response().withBody(expAnswer));

        String convertedDoc = service.convertDocument(html, ConversionTarget.ANSWER_UNITS);
        Assert.assertNotNull(convertedDoc);
        Assert.assertEquals(convertedDoc, new String(expAnswer));
    }

    /**
     * Test convert document with persistence
     */
    @Test
    public void testConvertDocumentWithPersistence() throws URISyntaxException, IOException {
        File expAnswerFile = getResourceFile("document_conversion/html-with-extra-content-input-to-answer.json");
        File html = getResourceFile("document_conversion/html-with-extra-content-input.htm");
        byte[] expAnswer = IOUtils.toByteArray(new FileInputStream(expAnswerFile));

        String docId = UUID.randomUUID().toString();
        Document createDocResponse = createMockDocument(docId, "html-with-extra-content-input.htm", MediaType.TEXT_HTML);
        mockServer.when(
                request().withMethod("POST").withPath(DOCUMENTS_PATH)
        ).respond((response().withBody(GsonSingleton.getGson().toJson(createDocResponse))));
        service.uploadDocument(html);

        mockServer.when(
                request().withMethod("POST").withPath(CONVERT_DOCUMENT_PATH)
        ).respond(response().withBody(expAnswer));

        String convertedDoc = service.convertDocument(docId, ConversionTarget.ANSWER_UNITS);
        Assert.assertNotNull(convertedDoc);
        Assert.assertEquals(convertedDoc, new String(expAnswer));
    }

    /**
     * Test upload document
     */
    @Test
    public void testUploadDocument() throws URISyntaxException, IOException {
        String docId = UUID.randomUUID().toString();
        Document response = createMockDocument(docId, "html-with-extra-content-input.htm", MediaType.TEXT_HTML);
        File html = getResourceFile("document_conversion/html-with-extra-content-input.htm");

        mockServer.when(
                request().withMethod("POST").withPath(DOCUMENTS_PATH)
        ).respond((response().withBody(GsonSingleton.getGson().toJson(response))));

        // Call upload document
        Document document = service.uploadDocument(html);

        Assert.assertNotNull(document);
        Assert.assertEquals(document.toString(), response.toString());
    }

    /**
     * Test create batch
     */
    @Test
    public void testCreateBatch() {
        // Expected Mock response
        String batchId = UUID.randomUUID().toString();
        String name = "testBatch";
        String currentTime = DateTime.now().toString();
        List<Property> propertyList = Arrays.asList(
                new Property("media_type", MediaType.TEXT_HTML), new Property("num_docs", "2"));
        Batch response = createMockBatch(batchId, name, currentTime, currentTime, propertyList);

        mockServer.when(
                request().withMethod("POST").withPath(BATCHES_PATH)
        ).respond((response().withBody(GsonSingleton.getGson().toJson(response))));

        // Call create batch
        Batch batch = service.createBatch(name, propertyList);
        Assert.assertNotNull(batch);
        Assert.assertEquals(batch.toString(), response.toString());
    }

    /**
     * Test create job
     */
    @Test
    public void testCreateJob() {
        // Expected Mock response
        String batchId = UUID.randomUUID().toString();
        String jobId = UUID.randomUUID().toString();
        String jobName = "testJob";

        CreateJobResponse response = new CreateJobResponse();
        response.setId(jobId);
        response.setName(jobName);
        response.setLinks(Arrays.asList(createLink("self", JOBS_PATH + "/" + jobId)));

        mockServer.when(
                request().withMethod("POST").withPath(JOBS_PATH)
        ).respond((response().withBody(GsonSingleton.getGson().toJson(response))));

        // Call create batch
        CreateJobResponse job = service.createJob(jobName, batchId, ConversionTarget.ANSWER_UNITS);
        Assert.assertNotNull(job);
        Assert.assertEquals(job.toString(), response.toString());
    }

    /**
     * Test get document collection and get document
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

        // Call get documents with query parameters
        List<Parameter> queryParams = new ArrayList<Parameter>();
        queryParams.add(new Parameter("name", docName));
        queryParams.add(new Parameter("limit", "5"));
        mockServer.reset().when(request()
                .withPath(DOCUMENTS_PATH).withQueryStringParameters(queryParams))
                .respond(response().withBody(GsonSingleton.getGson().toJson(docCollWithQueryResponse))
                );
        DocumentCollection docCollWithQuery = service.getDocumentCollection(null, 5, docName, null, null);
        Assert.assertNotNull(docCollWithQuery);
        Assert.assertEquals(docCollWithQuery.toString(), docCollWithQueryResponse.toString());

        // Call get document
        mockServer.when(request().withPath(DOCUMENTS_PATH + "/" + docId)).respond(
                response().withBody(docContent)
        );
        String document1 = service.getDocument(docId);
        Assert.assertNotNull(document1);
        Assert.assertEquals(document1, docContent);
    }

    /**
     * Test batches
     */
    @Test
    public void testBatches() {
        // Expected Mock response
        BatchCollection batchCollWithQueryResponse = new BatchCollection();
        List<Batch> batchList = new ArrayList<Batch>();
        String batchId = UUID.randomUUID().toString();
        String batchName = "batchName";
        String currentTime = DateTime.now().toString();
        List<Property> propertyList = Arrays.asList(
                new Property("media_type", MediaType.TEXT_HTML), new Property("num_docs", "2"));
        Batch batch = createMockBatch(batchId, batchName, currentTime, currentTime, propertyList);
        batchList.add(batch);
        batchCollWithQueryResponse.setBatches(batchList);
        List<Link> links = new ArrayList<Link>();
        batchCollWithQueryResponse.setLinks(links);

        // Call get batches with query parameters
        List<Parameter> queryParams = new ArrayList<Parameter>();
        queryParams.add(new Parameter("name", batchName));
        queryParams.add(new Parameter("limit", "10"));
        mockServer.reset().when(request()
                .withPath(BATCHES_PATH).withQueryStringParameters(queryParams))
                .respond(response().withBody(GsonSingleton.getGson().toJson(batchCollWithQueryResponse))
                );
        BatchCollection batchCollWithQuery = service.getBatchCollection(null, 10, batchName, null);
        Assert.assertNotNull(batchCollWithQuery);
        Assert.assertEquals(batchCollWithQuery.toString(), batchCollWithQueryResponse.toString());

        // Call get batch
        mockServer.when(request().withPath(BATCHES_PATH + "/" + batchId)).respond(
                response().withBody(GsonSingleton.getGson().toJson(batch))
        );
        Batch getBatch = service.getBatch(batchId);
        Assert.assertNotNull(getBatch);
        Assert.assertEquals(getBatch.toString(), batch.toString());

        // Update Batch
        String newBatchName = "updatedBatchName";
        List<Property> newPropertyList = Arrays.asList(
                new Property("media_type", MediaType.APPLICATION_PDF), new Property("num_docs", "6"));
        String newTime = DateTime.now().toString();
        Batch updatedBatch = createMockBatch(batchId, newBatchName, currentTime, newTime, newPropertyList);

        // Call update batch
        mockServer.reset().when(request().withMethod("PUT").withPath(BATCHES_PATH + "/" + batchId)).respond(
                response().withBody(GsonSingleton.getGson().toJson(updatedBatch))
        );

        Batch updatedBatchResponse = service.updateBatch(batchId, newBatchName, newPropertyList);
        Assert.assertNotNull(updatedBatchResponse);
        Assert.assertEquals(updatedBatch.toString(), updatedBatchResponse.toString());
    }

    /**
     * Test get batch documents
     */
    @Test
    public void testGetBatchDocuments() {
        // Create a mock batch
        String batchId = UUID.randomUUID().toString();
        BatchDocumentCollection batchDocCollWithQueryResponse = new BatchDocumentCollection();
        batchDocCollWithQueryResponse.setLinks(
                Arrays.asList(createLink("first", BATCHES_PATH + "/" + batchId + "/documents"))
        );

        // Create a mock batch document
        String batchDocId = UUID.randomUUID().toString();
        BatchDocument batchDocument = new BatchDocument();
        batchDocument.setId(batchDocId);
        batchDocument.setAddedToBatch(DateTime.now().toString());
        batchDocument.setLinks(Arrays.asList(
                        createLink("self", BATCHES_PATH + "/" + batchId + "/documents/" + batchDocId),
                        createLink("document", DOCUMENTS_PATH + "/documents/" + batchDocId)
                )
        );

        // Create mock batch document response
        BatchDocumentResponse batchDocumentResponse = new BatchDocumentResponse();
        batchDocumentResponse.setDocument(batchDocument);

        // Add document to batch
        batchDocCollWithQueryResponse.setDocuments(Arrays.asList(batchDocument));

        mockServer.when(request().withMethod("PUT")
                .withPath(BATCHES_PATH + "/" + batchId + "/documents/" + batchDocId)).respond(
                response().withBody(GsonSingleton.getGson().toJson(batchDocumentResponse))
        );
        BatchDocumentResponse addBatchDocResponse = service.addDocumentToBatch(batchId, batchDocId);
        Assert.assertNotNull(addBatchDocResponse);
        Assert.assertEquals(addBatchDocResponse.toString(), batchDocumentResponse.toString());

        // Call get batch documents with query parameters
        List<Parameter> queryParams = new ArrayList<Parameter>();
        queryParams.add(new Parameter("limit", "15"));
        mockServer.reset().when(request()
                .withPath(BATCHES_PATH + "/" + batchId + "/documents").withQueryStringParameters(queryParams))
                .respond(response().withBody(GsonSingleton.getGson().toJson(batchDocCollWithQueryResponse))
                );
        BatchDocumentCollection batchDocCollWithQuery = service.getBatchDocumentCollection(batchId, null, 15, null);
        Assert.assertNotNull(batchDocCollWithQuery);
        Assert.assertEquals(batchDocCollWithQuery.toString(), batchDocCollWithQueryResponse.toString());

        // Call get batch document
        mockServer.when(request().withPath(BATCHES_PATH + "/" + batchId + "/documents/" + batchDocId)).respond(
                response().withBody(GsonSingleton.getGson().toJson(batchDocumentResponse))
        );
        BatchDocumentResponse response = service.getBatchDocument(batchId, batchDocId);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.toString(), batchDocumentResponse.toString());
    }

    /**
     * Test jobs
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
        String currentTime = DateTime.now().toString();
        Job job = createMockJob(jobId, jobName, batchId, null, ConversionTarget.ANSWER_UNITS,
                currentTime, null, "25", "Result", JobStatus.COMPLETE);
        jobList.add(job);
        jobCollWithQueryResponse.setJobs(jobList);
        List<Link> links = new ArrayList<Link>();
        jobCollWithQueryResponse.setLinks(links);

        // Call get jobs with query parameters
        List<Parameter> queryParams = new ArrayList<Parameter>();
        queryParams.add(new Parameter("name", jobName));
        queryParams.add(new Parameter("limit", "7"));
        queryParams.add(new Parameter("status", JobStatus.COMPLETE.toString()));
        mockServer.reset().when(request()
                .withPath(JOBS_PATH).withQueryStringParameters(queryParams))
                .respond(response().withBody(GsonSingleton.getGson().toJson(jobCollWithQueryResponse))
                );
        JobCollection jobCollWithQuery = service.getJobCollection(null, 7, jobName, null, JobStatus.COMPLETE);
        Assert.assertNotNull(jobCollWithQuery);
        Assert.assertEquals(jobCollWithQuery.toString(), jobCollWithQueryResponse.toString());

        // Call get job
        mockServer.when(request().withPath(JOBS_PATH + "/" + jobId)).respond(
                response().withBody(GsonSingleton.getGson().toJson(job))
        );
        Job getJob = service.getJob(jobId);
        Assert.assertNotNull(getJob);
        Assert.assertEquals(getJob.toString(), job.toString());

        // Call get job log
        String expectedJobLog = "Document " + documentId + " - SUCCESS";
        mockServer.when(request().withPath(JOBS_PATH + "/" + jobId + "/log")).respond(
                response().withBody(expectedJobLog)
        );

        String jobLog = service.getJobLog(jobId);
        Assert.assertNotNull(getJob);
        Assert.assertEquals(expectedJobLog, jobLog);
    }

    /**
     * Test outputs
     */
    @Test
    public void testOutputs() throws URISyntaxException, IOException {
        // Expected Mock response
        OutputCollection outputCollWithQueryResponse = new OutputCollection();
        List<Output> outputList = new ArrayList<Output>();
        String outputId = UUID.randomUUID().toString();
        String jobId = UUID.randomUUID().toString();
        Output output = createMockOutput(outputId, null, null, null);
        outputList.add(output);
        outputCollWithQueryResponse.setOutput(outputList);
        List<Link> links = new ArrayList<Link>();
        outputCollWithQueryResponse.setLinks(links);

        File expAnswerFile = getResourceFile("document_conversion/html-with-extra-content-input-to-answer.json");
        byte[] expAnswer = IOUtils.toByteArray(new FileInputStream(expAnswerFile));

        // Call get outputs with query parameters
        List<Parameter> queryParams = new ArrayList<Parameter>();
        queryParams.add(new Parameter("job_id", jobId));
        queryParams.add(new Parameter("limit", "8"));
        mockServer.reset().when(request()
                .withPath(OUTPUT_PATH).withQueryStringParameters(queryParams))
                .respond(response().withBody(GsonSingleton.getGson().toJson(outputCollWithQueryResponse))
                );
        OutputCollection outputCollWithQuery = service.getOutputCollection(null, 8, null, jobId, null);
        Assert.assertNotNull(outputCollWithQuery);
        Assert.assertEquals(outputCollWithQuery.toString(), outputCollWithQueryResponse.toString());

        // Call get output
        mockServer.when(request().withPath(OUTPUT_PATH + "/" + outputId)).respond(
                response().withBody(expAnswer.toString())
        );
        String getOutput = service.getOutput(outputId);
        Assert.assertNotNull(getOutput);
        Assert.assertEquals(getOutput, expAnswer.toString());
    }

    // ####################################
    // ########## HELPER METHODS ##########
    // ####################################

    /**
     * Gets a local resource file
     * @param resourceName name of the resource
     * @return The resource File
     * @throws URISyntaxException
     * @throws IOException
     */
    public static File getResourceFile(String resourceName) throws URISyntaxException, IOException {
        ClassLoader cl = DocumentConversionExample.class.getClassLoader();
        URL url = cl.getResource(resourceName);
        if( url == null ) {
            throw new IOException("Unable to find resource: " + url);
        }
        return new File(url.toURI());
    }

    /**
     * Create a Document object
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
        doc.setLinks(Arrays.asList(createLink("self", DOCUMENTS_PATH + "/" + id)));
        return doc;
    }

    /**
     * Create a Batch object
     * @param id The id of the batch
     * @param name The name of the batch
     * @param createdOn The time the batch was created
     * @param updatedOn The time the batch was updated
     * @param props The list of properties for the batch
     * @return Batch
     */
    private Batch createMockBatch(String id, String name, String createdOn, String updatedOn, List<Property> props) {
        Batch batch = new Batch();
        batch.setId(id);
        batch.setName(name);
        batch.setCreatedOn(createdOn);
        batch.setUpdatedOn(updatedOn);
        batch.setProperties(props);
        batch.setLinks(Arrays.asList(createLink("self", BATCHES_PATH + "/" + id)));
        return batch;
    }

    /**
     * Create a Job object
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
                              ConversionTarget convTarget, String createdOn, JsonObject docCounts,
                              String duration, String result, JobStatus status ) {
        Job job = new Job();
        job.setId(id);
        job.setName(name);
        job.setBatchId(batchId);
        job.setConfiguration(config);
        job.setConversionTarget(convTarget);
        job.setCreatedOn(createdOn);
        job.setDocumentCounts(docCounts);
        job.setDuration(duration);
        job.setResult(result);
        job.setStatus(status);
        job.setLinks(Arrays.asList(createLink("self", JOBS_PATH + "/" + id)));
        return job;
    }

    /**
     * Create an Output object
     * @param id The id of the output
     * @param srcDocId The id of the source document used to generate this output
     * @param createdOn The time the output was created
     * @param mediaType The internet media type of the output
     * @return Output
     */
    private Output createMockOutput(String id, String srcDocId, String createdOn, String mediaType) {
        Output output = new Output();
        output.setId(id);
        output.setSourceDocumentId(srcDocId);
        output.setCreatedOn(createdOn);
        output.setMediaType(mediaType);
        output.setLinks(Arrays.asList(createLink("self", OUTPUT_PATH + "/" + id)));
        return output;
    }

    /**
     * Create a Link object
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

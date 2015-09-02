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

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.*;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.MediaType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Parameter;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

/**
 * The Class DocumentConversionTest.
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

    public void callsToTest() {
        service.addDocumentToBatch("batchid", "documentid");
       // service.convertDocument(null, ConversionTarget.ANSWER_UNITS);
        service.convertDocument("documentid", ConversionTarget.ANSWER_UNITS);
        service.createBatch("name", null);
        service.createJob("name", "batchid", ConversionTarget.ANSWER_UNITS);
        service.getBatch("batchid");
        //service.getBatchCollection("token", 100, "name", "since");
        service.getBatchDocument("batchId", "documentid");
        // service.getBatchDocumentCollection("batchid", "token", 100, "since");
        //service.getDocument("documentid");
        //service.getDocumentCollection("token", "limit", "name", "since", "mediatype");
        service.getJob("jobid");
        service.getJobLog("jobid");
       // service.getJobCollection("token", 100, "name", "since", JobStatus.COMPLETE);
        service.getOutput("outputid");
       // service.getOutputCollection("token", 100, "name", "since", "mediatype");
        service.updateBatch("batchid", "name", null);
        //service.uploadDocument(null, "mediatype");

        //####################
        // DON"T TEST:
        //####################

        //service.convertDocument(null, "mediatype");
        //service.convertDocument("documentid");
        //service.getBatchCollection();
        //service.getBatchDocumentCollection("batchid");
        //service.getDocumentCollection();
        //service.getJobs();
        //service.getOutputCollection();
        //service.createBatch();
        //service.createBatch("name");
    }

    public static File getResourceFile(String resourceName) throws URISyntaxException, IOException {
        ClassLoader cl = DocumentConversionExample.class.getClassLoader();
        URL rescUrl = cl.getResource(resourceName);
        if( rescUrl == null ) {
            throw new IOException("Unable to find resource: " + rescUrl);
        }
        return new File(rescUrl.toURI());
    }

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

    private Document createDocument(String documentId, String name, String mediaType) {
        Document doc = new Document();
        doc.setId(documentId);
        doc.setName(name);
        doc.setMediaType(mediaType);

        List<Link> links = new ArrayList<Link>();
        Link selfLink = new Link();
        selfLink.setName("self");
        selfLink.setLink(DOCUMENTS_PATH + "/" + documentId);
        links.add(selfLink);
        doc.setLinks(links);

        return doc;
    }

    @Test
    public void testUploadDocument() throws URISyntaxException, IOException {
        String docId = UUID.randomUUID().toString();
        Document response = createDocument(docId, "html-with-extra-content-input.htm", MediaType.TEXT_HTML);
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
     * Test get document collection.
     */
    @Test
    public void testGetDocumentCollection() {
        // Expected Mock response
        DocumentCollection docCollWithQueryResponse = new DocumentCollection();
        List<Document> documentsWithQuery = new ArrayList<Document>();
        String documentId1 = UUID.randomUUID().toString();
        String docName = "documentName";
        String docContent1 = "<html><title>Test</title><body><text>test document</text></body></html>";
        Document doc1 = new Document();
        doc1.setId(documentId1);
        doc1.setName(docName);
        doc1.setMediaType(MediaType.TEXT_HTML);
        List<Link> doc1Links = new ArrayList<Link>();
        Link doc1Link = new Link();
        doc1Link.setName("self");
        doc1Link.setLink("/v1/documents/" + documentId1);
        doc1Links.add(doc1Link);
        doc1.setLinks(doc1Links);
        documentsWithQuery.add(doc1);
        docCollWithQueryResponse.setDocuments(documentsWithQuery);
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
        mockServer.when(request().withPath(DOCUMENTS_PATH + "/" + documentId1)).respond(
                response().withBody(docContent1)
        );
        String document1 = service.getDocument(documentId1);
        Assert.assertNotNull(document1);
        Assert.assertEquals(document1, docContent1);
    }

    /**
     * Test get batch collection.
     */
    @Test
    public void testGetBatchCollection() {
        // Expected Mock response
        BatchCollection response = new BatchCollection();
        List<Batch> batches = new ArrayList<Batch>();
        response.setBatches(batches);
        List<Link> links = new ArrayList<Link>();
        response.setLinks(links);

        mockServer.when(request().withPath(BATCHES_PATH)).respond(
                response().withBody(GsonSingleton.getGson().toJson(response))

        );

        // Call the service and get batches
        BatchCollection batchCollection = service.getBatchCollection();
        Assert.assertNotNull(batchCollection);
        Assert.assertEquals(batchCollection.toString(), response.toString());
    }

    /**
     * Test get job collection.
     */
    @Test
    public void testGetJobCollection() {
        // Expected Mock response
        JobCollection response = new JobCollection();
        List<Job> jobs = new ArrayList<Job>();
        response.setJobs(jobs);
        List<Link> links = new ArrayList<Link>();
        response.setLinks(links);

        mockServer.when(request().withPath(JOBS_PATH)).respond(
                response().withBody(GsonSingleton.getGson().toJson(response))

        );

        // Call the service and get jobs
        JobCollection jobCollection = service.getJobCollection();
        Assert.assertNotNull(jobCollection);
        Assert.assertEquals(jobCollection.toString(), response.toString());
    }

    /**
     * Test get output collection.
     */
    @Test
    public void testGetOutputCollection() {
        // Expected Mock response
        OutputCollection response = new OutputCollection();
        List<Output> outputs = new ArrayList<Output>();
        response.setOutput(outputs);
        List<Link> links = new ArrayList<Link>();
        response.setLinks(links);

        mockServer.when(request().withPath(OUTPUT_PATH)).respond(
                response().withBody(GsonSingleton.getGson().toJson(response))

        );

        // Call the service and get outputs
        OutputCollection outputCollection = service.getOutputCollection();
        Assert.assertNotNull(outputCollection);
        Assert.assertEquals(outputCollection.toString(), response.toString());
    }
}
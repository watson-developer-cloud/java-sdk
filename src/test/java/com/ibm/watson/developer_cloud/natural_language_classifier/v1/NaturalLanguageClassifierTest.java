/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.natural_language_classifier.v1;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import io.netty.handler.codec.http.HttpHeaders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifiedClass;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifiers;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.MediaType;

/**
 * The Class NaturalLanguageClassifierTest.
 */
public class NaturalLanguageClassifierTest extends WatsonServiceTest {

    /** The Constant log. */
    private static final Logger log = Logger.getLogger(NaturalLanguageClassifierTest.class.getName());

    /** The service. */
    private NaturalLanguageClassifier service;

    /** The classifier id. */
    private String classifierId;

    /** Mock Server *. */
    private ClientAndServer mockServer;

    /** The Constant CLASSIFY_PATH.  (value is "/v1/classifiers/%s/classify") */
    private final static String LANGUAGE_CLASSIFY_PATH = "/v1/classifiers/%s/classify";

    /** The Constant LANGUAGE_CLASSIFIERS_PATH. (value is "/v1/classifiers/") */
    private final static String LANGUAGE_CLASSIFIERS_PATH = "/v1/classifiers";

    /**
     * Start mock server.
     */
    @Before
    public void startMockServer() {
        try {
            mockServer = startClientAndServer(Integer.parseInt(prop.getProperty("mock.server.port")));
            service = new NaturalLanguageClassifier();
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

    /* (non-Javadoc)
     * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
     */
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        classifierId = prop.getProperty("natural_language_classifier.classifier_id");
    }

    /**
     * Test classify.
     */
    @Test
    public void testClassify() {

        Classification response = new Classification();
        response.setId("testId");
        response.setText("is it sunny?");
        response.setUrl("http://www.ibm.com");
        response.setTopClass("conditions");

        List<ClassifiedClass> classes = new ArrayList<ClassifiedClass>();
        ClassifiedClass c1 = new ClassifiedClass();
        c1.setConfidence(0.98189);
        c1.setName("class1");

        ClassifiedClass c2 = new ClassifiedClass();
        c2.setConfidence(0.98188);
        c2.setName("class2");
        classes.add(c1);
        classes.add(c2);

        response.setClasses(classes);
        System.out.println(GsonSingleton.getGson().toJson(response));

        StringBuilder text = new StringBuilder().append("is it sunny?");

        JsonObject contentJson = new JsonObject();
        contentJson.addProperty("text", text.toString());
        String path = String
                .format(LANGUAGE_CLASSIFY_PATH, classifierId);

        mockServer.when(
                request().withMethod("POST").withPath(path)
                        .withBody(contentJson.toString())

        )
                .respond(
                        response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                                .withBody(GsonSingleton.getGson().toJson(response)));

        Classification c = service.classify(classifierId, text.toString());

        Assert.assertNotNull(c);
        Assert.assertEquals(c, response);

    }

    /**
     * Test get classifier.
     */
    @Test
    public void testGetClassifier() {

        System.out.println(GsonSingleton.getGson().toJson(""));
        Classifier response = new Classifier();
        response.setId("testId");
        response.setStatus(Classifier.Status.AVAILABLE);
        response.setUrl("http://gateway.watson.net/");
        response.setStatusDescription("The classifier instance is now available and is ready to take classifier requests.");

        mockServer.when(request().withPath(LANGUAGE_CLASSIFIERS_PATH + "/" + classifierId)).respond(
                response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                        .withBody(GsonSingleton.getGson().toJson(response)));

        Classifier c = service.getClassifier(classifierId);
        Assert.assertNotNull(c);
        Assert.assertEquals(c, response);

    }

    /**
     * Test get classifiers.
     */
    @Test
    public void testGetClassifiers() {

        Map<String, Object> response = new HashMap<String, Object>();
        List<Classifier> classifiersResponse = new ArrayList<Classifier>();

        Classifier c = new Classifier();
        c.setId("testId");
        c.setStatus(Classifier.Status.AVAILABLE);
        c.setUrl("http://gateway.watson.net/");
        c.setStatusDescription("The classifier instance is now available and is ready to take classifier requests.");
        classifiersResponse.add(c);

        Classifier c1 = new Classifier();
        c1.setId("testId1");
        c1.setStatus(Classifier.Status.AVAILABLE);
        c1.setUrl("http://gateway.watson.net/");
        c1.setStatusDescription("The classifier instance is now available and is ready to take classifier requests.");
        classifiersResponse.add(c1);

        Classifier c2 = new Classifier();
        c2.setId("testId2");
        c2.setStatus(Classifier.Status.AVAILABLE);
        c2.setUrl("http://gateway.watson.net/");
        c2.setStatusDescription("The classifier instance is now available and is ready to take classifier requests.");
        classifiersResponse.add(c2);

        response.put("classifiers", classifiersResponse);

        mockServer.when(request().withPath(LANGUAGE_CLASSIFIERS_PATH)).respond(
                response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                        .withBody(GsonSingleton.getGson().toJson(response)));


        Classifiers classifiers = service.getClassifiers();
        Assert.assertNotNull(classifiers.getClassifiers());
        Assert.assertFalse(classifiers.getClassifiers().isEmpty());
        Assert.assertFalse(classifiers.getClassifiers().contains(classifiersResponse));

    }

}

/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.natural_language_classifier.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import io.netty.handler.codec.http.HttpHeaders;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifiedClass;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifiers;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.TrainingData;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class NaturalLanguageClassifierTest.
 */
public class NaturalLanguageClassifierTest extends WatsonServiceTest {

  /** The Constant CLASSIFIERS_PATH. (value is "/v1/classifiers/") */
  private final static String CLASSIFIERS_PATH = "/v1/classifiers";

  /** The Constant CLASSIFY_PATH. (value is "/v1/classifiers/%s/classify") */
  private final static String CLASSIFY_PATH = "/v1/classifiers/%s/classify";

  /** The Constant log. */
  private static final Logger log = Logger.getLogger(NaturalLanguageClassifierTest.class.getName());

  /** The classifier id. */
  private String classifierId;

  /** Mock Server *. */
  private ClientAndServer mockServer;

  /** The service. */
  private NaturalLanguageClassifier service;

  /**
   * Creates the classifier.
   * 
   * @throws Exception the exception
   */
  @Test
  public void createClassifier() throws Exception {
    final Classifier createdClassifier = new Classifier();
    createdClassifier.setId("testId2");
    createdClassifier.setStatus(Classifier.Status.AVAILABLE);
    createdClassifier.setUrl("http://gateway.watson.net/");

    mockServer.when(request().withMethod("POST").withPath(CLASSIFIERS_PATH)).respond(
        response().withHeaders(
            new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)).withBody(
            createdClassifier.toString()));

    final List<TrainingData> training = new ArrayList<TrainingData>();
    training.add(new TrainingData().withText("text1").withClasses("k1"));
    final Classifier classifier = service.createClassifier(null, null, training);

    assertEquals(createdClassifier.toString(), classifier.toString());
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
    classifierId = getValidProperty("natural_language_classifier.classifier_id");
  }

  /**
   * Start mock server.
   */
  @Before
  public void startMockServer() {
    try {
      mockServer = startClientAndServer(Integer.parseInt(getValidProperty("mock.server.port")));
      service = new NaturalLanguageClassifier();
      service.setApiKey("");
      service.setEndPoint("http://" + getValidProperty("mock.server.host") + ":"
          + getValidProperty("mock.server.port"));

    } catch (final NumberFormatException e) {
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

  /**
   * Test classify.
   */
  @Test
  public void testClassify() {

    final Classification response = new Classification();
    response.setId("testId");
    response.setText("is it sunny?");
    response.setUrl("http://www.ibm.com");
    response.setTopClass("class2");

    final List<ClassifiedClass> classes = new ArrayList<ClassifiedClass>();
    final ClassifiedClass c1 = new ClassifiedClass();
    c1.setConfidence(0.98189);
    c1.setName("class1");

    final ClassifiedClass c2 = new ClassifiedClass();
    c2.setConfidence(0.98188);
    c2.setName("class2");
    classes.add(c1);
    classes.add(c2);

    response.setClasses(classes);

    final StringBuilder text = new StringBuilder().append("is it sunny?");

    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("text", text.toString());
    final String path = String.format(CLASSIFY_PATH, classifierId);

    mockServer.when(request().withMethod("POST").withPath(path).withBody(contentJson.toString())

    ).respond(
        response().withHeaders(
            new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)).withBody(
            GsonSingleton.getGson().toJson(response)));

    final Classification c = service.classify(classifierId, text.toString());

    assertNotNull(service.toString());
    assertNotNull(c);
    assertEquals(c, response);

  }

  /**
   * Test get classifier.
   */
  @Test
  public void testGetClassifier() {

    System.out.println(GsonSingleton.getGson().toJson(""));
    final Classifier response = new Classifier();
    response.setId("testId");
    response.setStatus(Classifier.Status.AVAILABLE);
    response.setUrl("http://gateway.watson.net/");
    response
        .setStatusDescription("The classifier instance is now available and is ready to take classifier requests.");

    mockServer.when(request().withPath(CLASSIFIERS_PATH + "/" + classifierId)).respond(
        response().withHeaders(
            new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)).withBody(
            GsonSingleton.getGson().toJson(response)));

    final Classifier c = service.getClassifier(classifierId);
    assertNotNull(c);
    assertEquals(c, response);

  }

  /**
   * Test get classifiers.
   */
  @Test
  public void testGetClassifiers() {

    final Map<String, Object> response = new HashMap<String, Object>();
    final List<Classifier> classifiersResponse = new ArrayList<Classifier>();

    final Classifier c = new Classifier();
    c.setId("testId");
    c.setStatus(Classifier.Status.AVAILABLE);
    c.setUrl("http://gateway.watson.net/");
    c.setStatusDescription("The classifier instance is now available and is ready to take classifier requests.");
    classifiersResponse.add(c);

    final Classifier c1 = new Classifier();
    c1.setId("testId1");
    c1.setStatus(Classifier.Status.AVAILABLE);
    c1.setUrl("http://gateway.watson.net/");
    c1.setStatusDescription("The classifier instance is now available and is ready to take classifier requests.");
    classifiersResponse.add(c1);



    response.put("classifiers", classifiersResponse);

    mockServer.when(request().withPath(CLASSIFIERS_PATH)).respond(
        response().withHeaders(
            new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)).withBody(
            GsonSingleton.getGson().toJson(response)));


    final Classifiers classifiers = service.getClassifiers();
    assertNotNull(classifiers.getClassifiers());
    assertFalse(classifiers.getClassifiers().isEmpty());
    assertFalse(classifiers.getClassifiers().contains(classifiersResponse));

  }

  /**
   * Test null classifier.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullClassifier() {
    service.classify("", "test");
  }

  /**
   * Test null delete classifier.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullDeleteClassifier() {
    service.deleteClassifier("");
  }

  /**
   * Test null text.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullText() {
    service.classify(classifierId, null);
  }

  /**
   * Test null training data.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullTrainingData() {
    service.createClassifier(null, null, new ArrayList<TrainingData>());
  }

  /**
   * Test null training data file.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullTrainingDataFile() {
    service.createClassifier(null, null, new File("src/test/resources/notfound.txt"));
  }

}

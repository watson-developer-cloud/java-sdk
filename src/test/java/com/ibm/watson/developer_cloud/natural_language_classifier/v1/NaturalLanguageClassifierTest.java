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
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifiers;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class NaturalLanguageClassifierTest.
 */
public class NaturalLanguageClassifierTest extends WatsonServiceUnitTest {
  private static final String TEXT = "text";
  private final static String CLASSIFIERS_PATH = "/v1/classifiers";
  private final static String CLASSIFY_PATH = "/v1/classifiers/%s/classify";
  private final static String RESOURCE = "src/test/resources/natural_language_classifier/";

  private Classifiers classifiers;
  private Classifier classifier;
  private Classification classification;

  private String classifierId;
  private NaturalLanguageClassifier service;

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new NaturalLanguageClassifier();
    service.setApiKey("");
    service.setEndPoint(MOCK_SERVER_URL);

    classifierId = "foo";
    classifiers = loadFixture(RESOURCE + "classifiers.json", Classifiers.class);
    classifier = loadFixture(RESOURCE + "classifier.json", Classifier.class);
    classification = loadFixture(RESOURCE + "classification.json", Classification.class);
  }

  /**
   * Test classify.
   */
  @Test
  public void testClassify() {
    JsonObject contentJson = new JsonObject();
    contentJson.addProperty(TEXT, classification.getText());

    String path = String.format(CLASSIFY_PATH, classifierId);

    mockServer.when(request().withMethod(POST).withPath(path).withBody(contentJson.toString()))
        .respond(
            response().withHeader(APPLICATION_JSON).withBody(
                GsonSingleton.getGsonWithoutPrettyPrinting().toJson(classification)));

    Classification result = service.classify(classifierId, classification.getText());

    assertEquals(classification, result);
  }

  /**
   * Test get classifier.
   */
  @Test
  public void testGetClassifier() {
    mockServer.when(request().withPath(CLASSIFIERS_PATH + "/" + classifierId)).respond(
        response().withHeader(APPLICATION_JSON)
            .withBody(GsonSingleton.getGsonWithoutPrettyPrinting().toJson(classifier)));

    Classifier response = service.getClassifier(classifierId);
    assertEquals(classifier, response);

  }

  /**
   * Test get classifiers.
   */
  @Test
  public void testGetClassifiers() {
    mockServer.when(request().withPath(CLASSIFIERS_PATH)).respond(
        response().withHeader(APPLICATION_JSON).withBody(
            GsonSingleton.getGsonWithoutPrettyPrinting().toJson(classifiers)));


    Classifiers response = service.getClassifiers();

    assertEquals(classifiers, response);
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
   * Test null training data file.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullTrainingDataFile() {
    service.createClassifier(null, null, new File("src/test/resources/notfound.txt"));
  }

}

/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.natural_language_classifier.v1;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifiers;

import okhttp3.mockwebserver.RecordedRequest;

/**
 * The Class NaturalLanguageClassifierTest.
 */
public class NaturalLanguageClassifierTest extends WatsonServiceUnitTest {
  private static final String TEXT = "text";
  private static final String CLASSIFIERS_PATH = "/v1/classifiers";
  private static final String CLASSIFY_PATH = "/v1/classifiers/%s/classify";
  private static final String RESOURCE = "src/test/resources/natural_language_classifier/";

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
    service.setEndPoint(getMockWebServerUrl());

    classifierId = "foo";
    classifiers = loadFixture(RESOURCE + "classifiers.json", Classifiers.class);
    classifier = loadFixture(RESOURCE + "classifier.json", Classifier.class);
    classification = loadFixture(RESOURCE + "classification.json", Classification.class);
  }

  /**
   * Test classify.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClassify() throws InterruptedException {
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty(TEXT, classification.getText());

    final String path = String.format(CLASSIFY_PATH, classifierId);

    server.enqueue(jsonResponse(classification));
    final Classification result = service.classify(classifierId, classification.getText()).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(contentJson.toString(), request.getBody().readUtf8());
    assertEquals(classification, result);
  }

  /**
   * Test get classifier.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetClassifier() throws InterruptedException {
    server.enqueue(jsonResponse(classifier));
    final Classifier response = service.getClassifier(classifierId).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(CLASSIFIERS_PATH + "/" + classifierId, request.getPath());
    assertEquals(classifier, response);
  }

  /**
   * Test get classifiers.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetClassifiers() throws InterruptedException {
    server.enqueue(jsonResponse(classifiers));
    final Classifiers response = service.getClassifiers().execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(CLASSIFIERS_PATH, request.getPath());
    assertEquals(classifiers, response);
  }

  /**
   * Test create classifier.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testCreateClassifier() throws InterruptedException {
    server.enqueue(jsonResponse(classifier));
    final Classifier response = service.createClassifier(classifierId, "en",
        new File("src/test/resources/natural_language_classifier/weather_data_train.csv")).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(CLASSIFIERS_PATH, request.getPath());
    assertEquals(classifier, response);
  }

  /**
   * Test delete classifier.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteClassifier() throws InterruptedException {
    service.deleteClassifier(classifierId);
  }

  // START NEGATIVE TESTS
  /**
   * Test null classifier.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullClassifier() {
    service.classify("", "test");
  }

  /**
   * Test null text.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullText() {
    service.classify(classifierId, null);
  }

  /**
   * Test null delete classifier.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullDeleteClassifier() {
    service.deleteClassifier("");
  }

  /**
   * Test null training data file.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullTrainingDataFile() {
    service.createClassifier(null, null, new File("src/test/resources/notfound.txt"));
  }

}

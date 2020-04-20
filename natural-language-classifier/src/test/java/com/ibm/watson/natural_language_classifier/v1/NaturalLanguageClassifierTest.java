/*
 * (C) Copyright IBM Corp. 2019.
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
package com.ibm.watson.natural_language_classifier.v1;

import static org.junit.Assert.assertEquals;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.watson.common.WatsonServiceUnitTest;
import com.ibm.watson.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.natural_language_classifier.v1.model.ClassificationCollection;
import com.ibm.watson.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.natural_language_classifier.v1.model.ClassifierList;
import com.ibm.watson.natural_language_classifier.v1.model.ClassifyCollectionOptions;
import com.ibm.watson.natural_language_classifier.v1.model.ClassifyInput;
import com.ibm.watson.natural_language_classifier.v1.model.ClassifyOptions;
import com.ibm.watson.natural_language_classifier.v1.model.CreateClassifierOptions;
import com.ibm.watson.natural_language_classifier.v1.model.DeleteClassifierOptions;
import com.ibm.watson.natural_language_classifier.v1.model.GetClassifierOptions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

/** The Class NaturalLanguageClassifierTest. */
public class NaturalLanguageClassifierTest extends WatsonServiceUnitTest {
  private static final String TEXT = "text";
  private static final String CLASSIFIERS_PATH = "/v1/classifiers";
  private static final String CLASSIFY_PATH = "/v1/classifiers/%s/classify";
  private static final String CLASSIFY_COLLECTION_PATH = "/v1/classifiers/%s/classify_collection";
  private static final String RESOURCE = "src/test/resources/natural_language_classifier/";

  private ClassifierList classifiers;
  private Classifier classifier;
  private Classification classification;
  private ClassificationCollection classificationCollection;

  private String classifierId;
  private NaturalLanguageClassifier service;

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.common.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new NaturalLanguageClassifier(new NoAuthAuthenticator());
    service.setServiceUrl(getMockWebServerUrl());

    classifierId = "foo";
    classifiers = loadFixture(RESOURCE + "classifiers.json", ClassifierList.class);
    classifier = loadFixture(RESOURCE + "classifier.json", Classifier.class);
    classification = loadFixture(RESOURCE + "classification.json", Classification.class);
    classificationCollection =
        loadFixture(RESOURCE + "classification_collection.json", ClassificationCollection.class);
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
    ClassifyOptions classifyOptions =
        new ClassifyOptions.Builder()
            .classifierId(classifierId)
            .text(classification.getText())
            .build();
    final Classification result = service.classify(classifyOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(contentJson.toString(), request.getBody().readUtf8());
    assertEquals(classification, result);
  }

  /**
   * Test classifying a collection.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClassifyCollection() throws InterruptedException {
    final String path = String.format(CLASSIFY_COLLECTION_PATH, classifierId);

    server.enqueue(jsonResponse(classificationCollection));

    ClassifyInput input1 = new ClassifyInput.Builder().text("How hot will it be today?").build();
    ClassifyInput input2 = new ClassifyInput.Builder().text("Is it hot outside?").build();
    List<ClassifyInput> inputCollection = Arrays.asList(input1, input2);

    ClassifyCollectionOptions classifyOptions =
        new ClassifyCollectionOptions.Builder()
            .classifierId(classifierId)
            .collection(inputCollection)
            .build();
    final ClassificationCollection result =
        service.classifyCollection(classifyOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(classificationCollection, result);
  }

  /**
   * Test get classifier.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetClassifier() throws InterruptedException {
    server.enqueue(jsonResponse(classifier));
    GetClassifierOptions getOptions =
        new GetClassifierOptions.Builder().classifierId(classifierId).build();
    final Classifier response = service.getClassifier(getOptions).execute().getResult();
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
    final ClassifierList response = service.listClassifiers().execute().getResult();
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
  public void testCreateClassifier() throws InterruptedException, FileNotFoundException {
    server.enqueue(jsonResponse(classifier));
    File metadata = new File(RESOURCE + "metadata.json");
    File trainingData = new File(RESOURCE + "weather_data_train.csv");
    CreateClassifierOptions createOptions =
        new CreateClassifierOptions.Builder()
            .trainingMetadata(metadata)
            .trainingData(trainingData)
            .build();
    final Classifier response = service.createClassifier(createOptions).execute().getResult();
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
    DeleteClassifierOptions deleteOptions =
        new DeleteClassifierOptions.Builder().classifierId(classifierId).build();
    service.deleteClassifier(deleteOptions);
  }

  // START NEGATIVE TESTS
  /** Test null classifier. */
  @Test(expected = IllegalArgumentException.class)
  public void testNullClassifier() {
    ClassifyOptions classifyOptions = new ClassifyOptions.Builder().text("test").build();
    service.classify(classifyOptions);
  }

  /** Test null text. */
  @Test(expected = IllegalArgumentException.class)
  public void testNullText() {
    ClassifyOptions classifyOptions =
        new ClassifyOptions.Builder().classifierId(classifierId).build();
    service.classify(classifyOptions);
  }

  /** Test null delete classifier. */
  @Test(expected = IllegalArgumentException.class)
  public void testNullDeleteClassifier() {
    DeleteClassifierOptions deleteOptions = new DeleteClassifierOptions.Builder().build();
    service.deleteClassifier(deleteOptions);
  }

  /** Test null training data file. */
  @Test(expected = FileNotFoundException.class)
  public void testNullTrainingDataFile() throws FileNotFoundException {
    server.enqueue(jsonResponse(classifier));
    File metadata = new File(RESOURCE + "metadata.json");
    File trainingData = new File(RESOURCE + "notfound.txt");
    CreateClassifierOptions createOptions =
        new CreateClassifierOptions.Builder()
            .trainingMetadata(metadata)
            .trainingData(trainingData)
            .build();
    service.createClassifier(createOptions).execute();
  }
}

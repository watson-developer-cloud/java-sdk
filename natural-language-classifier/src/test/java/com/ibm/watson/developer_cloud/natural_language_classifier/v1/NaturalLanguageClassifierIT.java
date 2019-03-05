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

import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.test.WatsonServiceTest;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassificationCollection;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier.Status;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifierList;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifyCollectionOptions;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifyInput;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifyOptions;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.CreateClassifierOptions;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.DeleteClassifierOptions;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.GetClassifierOptions;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ListClassifiersOptions;
import org.junit.Assume;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * The Class NaturalLanguageClassifierTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NaturalLanguageClassifierIT extends WatsonServiceTest {

  /** The classifier id. */
  private static String classifierId = null;
  private String preCreatedClassifierId;

  /** The service. */
  private NaturalLanguageClassifier service;

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String username = getProperty("natural_language_classifier.username");
    String password = getProperty("natural_language_classifier.password");

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    service = new NaturalLanguageClassifier();
    service.setDefaultHeaders(getDefaultHeaders());
    service.setUsernameAndPassword(username, password);
    service.setEndPoint(getProperty("natural_language_classifier.url"));

    preCreatedClassifierId = getProperty("natural_language_classifier.classifier_id");
  }

  /**
   * Creates the classifier.
   *
   * @throws Exception the exception
   */
  @Test
  public void aCreate() throws Exception {
    final File trainingData = new File("src/test/resources/natural_language_classifier/weather_data_train.csv");
    final File metadata = new File("src/test/resources/natural_language_classifier/metadata.json");

    CreateClassifierOptions createOptions = new CreateClassifierOptions.Builder()
        .metadata(metadata)
        .trainingData(trainingData)
        .trainingDataFilename("weather_data_train.csv")
        .build();
    Classifier classifier = service.createClassifier(createOptions).execute();

    try {
      assertNotNull(classifier);
      assertEquals(Status.TRAINING, classifier.getStatus());
      assertEquals("test-classifier", classifier.getName());
      assertEquals("en", classifier.getLanguage());
    } finally {
      classifierId = classifier.getClassifierId();
    }

  }

  /**
   * Test get classifier.
   */
  @Test
  public void bGetClassifier() {
    final Classifier classifier;

    try {
      GetClassifierOptions getOptions = new GetClassifierOptions.Builder()
          .classifierId(classifierId)
          .build();
      classifier = service.getClassifier(getOptions).execute();
    } catch (NotFoundException e) {
      // #324: Classifiers may be empty, because of other tests interfering.
      // The build should not fail here, because this is out of our control.
      throw new AssumptionViolatedException(e.getMessage(), e);
    }
    assertNotNull(classifier);
    assertEquals(classifierId, classifier.getClassifierId());
    assertEquals(Classifier.Status.TRAINING, classifier.getStatus());
  }

  /**
   * Test list classifiers.
   */
  @Test
  public void cListClassifiers() {
    ListClassifiersOptions listOptions = new ListClassifiersOptions.Builder()
        .build();
    final ClassifierList classifiers = service.listClassifiers(listOptions).execute();
    assertNotNull(classifiers);

    // #324: Classifiers may be empty, because of other tests interfering.
    // The build should not fail here, because this is out of our control.
    Assume.assumeFalse(classifiers.getClassifiers().isEmpty());
  }

  /**
   * Test classify. Use the pre created classifier to avoid waiting for availability
   */
  @Test
  public void dClassify() {
    Classification classification = null;

    try {
      ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
          .classifierId(preCreatedClassifierId)
          .text("is it hot outside?")
          .build();
      classification = service.classify(classifyOptions).execute();
    } catch (NotFoundException e) {
      // #324: Classifiers may be empty, because of other tests interfering.
      // The build should not fail here, because this is out of our control.
      throw new AssumptionViolatedException(e.getMessage(), e);
    }

    assertNotNull(classification);
    assertEquals("temperature", classification.getTopClass());
  }

  /**
   * Test delete classifier. Only delete the classifier we created earlier.
   */
  @Test
  public void eDelete() throws InterruptedException {
    DeleteClassifierOptions deleteOptions = new DeleteClassifierOptions.Builder()
        .classifierId(classifierId)
        .build();
    service.deleteClassifier(deleteOptions).execute();
  }

  /**
   * Test classifyCollection. Use the pre created classifier to avoid waiting for availability
   */
  @Test
  public void fClassifyCollection() {
    ClassificationCollection classificationCollection = null;
    ClassifyInput input1 = new ClassifyInput();
    input1.setText("How hot will it be today?");
    ClassifyInput input2 = new ClassifyInput();
    input2.setText("Is it hot outside?");

    try {
      ClassifyCollectionOptions classifyOptions = new ClassifyCollectionOptions.Builder()
          .classifierId(preCreatedClassifierId)
          .addClassifyInput(input1)
          .addClassifyInput(input2)
          .build();
      classificationCollection = service.classifyCollection(classifyOptions).execute();
    } catch (NotFoundException e) {
      // #324: Classifiers may be empty, because of other tests interfering.
      // The build should not fail here, because this is out of our control.
      throw new AssumptionViolatedException(e.getMessage(), e);
    }

    assertNotNull(classificationCollection);
    assertEquals("temperature", classificationCollection.getCollection().get(0).getTopClass());
    assertEquals("temperature", classificationCollection.getCollection().get(1).getTopClass());
  }

}

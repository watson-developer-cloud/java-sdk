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
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import org.junit.Assume;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier.Status;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifiers;
import com.ibm.watson.developer_cloud.service.exception.NotFoundException;

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
   *
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
    final String classifierName = "devexp-available";

    Classifier classifier = service.createClassifier(classifierName, "en", trainingData).execute();

    try {
      assertNotNull(classifier);
      assertEquals(Status.TRAINING, classifier.getStatus());
      assertEquals(classifierName, classifier.getName());
    } finally {
      classifierId = classifier.getId();
    }

  }

  /**
   * Test get classifier.
   */
  @Test
  public void bGetClassifier() {
    final Classifier classifier;

    try {
      classifier = service.getClassifier(classifierId).execute();
    } catch (NotFoundException e) {
      // #324: Classifiers may be empty, because of other tests interfering.
      // The build should not fail here, because this is out of our control.
      throw new AssumptionViolatedException(e.getMessage(), e);
    }
    assertNotNull(classifier);
    assertEquals(classifierId, classifier.getId());
    assertEquals(Classifier.Status.TRAINING, classifier.getStatus());
  }

  /**
   * Test get classifiers.
   */
  @Test
  public void cGetClassifiers() {
    final Classifiers classifiers = service.getClassifiers().execute();
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
      classification = service.classify(preCreatedClassifierId, "is it hot outside?").execute();
    } catch (NotFoundException e) {
      // #324: Classifiers may be empty, because of other tests interfering.
      // The build should not fail here, because this is out of our control.
      throw new AssumptionViolatedException(e.getMessage(), e);
    }

    assertNotNull(classification);
    assertEquals("temperature", classification.getTopClass());
  }

  /**
   * Test delete classifier. Do not delete the pre created classifier. We need it for classify
   */
  @Test
  public void eDelete() {
    List<Classifier> classifiers = service.getClassifiers().execute().getClassifiers();

    for (Classifier classifier : classifiers) {
      if (!classifier.getId().equals(preCreatedClassifierId)) {
        service.deleteClassifier(classifier.getId()).execute();
      }
    }
  }

}

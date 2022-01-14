/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
import static org.junit.Assert.assertNotNull;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.watson.common.WatsonServiceTest;
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
import com.ibm.watson.natural_language_classifier.v1.model.ListClassifiersOptions;
import java.io.File;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/** The Class NaturalLanguageClassifierTest. */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NaturalLanguageClassifierIT extends WatsonServiceTest {

  /** The classifier id. */
  private static String classifierId = null;

  private String preCreatedClassifierId;

  /** The service. */
  private NaturalLanguageClassifier service;

  /**
   * Sets up the tests.
   *
   * @throws Exception the exception
   */
  /*
   * (non-Javadoc)
   * @see com.ibm.watson.common.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String apiKey = System.getenv("NATURAL_LANGUAGE_CLASSIFIER_APIKEY");
    String serviceUrl = System.getenv("NATURAL_LANGUAGE_CLASSIFIER_URL");
    preCreatedClassifierId = System.getenv("NATURAL_LANGUAGE_CLASSIFIER_ID");

    if (apiKey == null) {
      apiKey = getProperty("natural_language_classifier.apikey");
      serviceUrl = getProperty("natural_language_classifier.url");
      preCreatedClassifierId = getProperty("natural_language_classifier.classifier_id");
    }

    assertNotNull("NATURAL_LANGUAGE_CLASSIFIER_APIKEY is not defined and config.properties doesn't have valid credentials.", apiKey);

    Authenticator authenticator = new IamAuthenticator(apiKey);
    service = new NaturalLanguageClassifier(authenticator);
    service.setDefaultHeaders(getDefaultHeaders());
    service.setServiceUrl(serviceUrl);


  }

  /**
   * Creates the classifier.
   *
   * @throws Exception the exception
   */
  @Test
  public void aCreate() throws Exception {
    final File trainingData =
        new File("src/test/resources/natural_language_classifier/weather_data_train.csv");
    final File metadata = new File("src/test/resources/natural_language_classifier/metadata.json");

    CreateClassifierOptions createOptions =
        new CreateClassifierOptions.Builder()
            .trainingMetadata(metadata)
            .trainingData(trainingData)
            .build();
    Classifier classifier = service.createClassifier(createOptions).execute().getResult();

    try {
      assertNotNull(classifier);
      Assert.assertEquals(Classifier.Status.TRAINING, classifier.getStatus());
      assertEquals("test-classifier", classifier.getName());
      assertEquals("en", classifier.getLanguage());
    } finally {
      classifierId = classifier.getClassifierId();
    }
  }

  /** Test get classifier. */
  @Test
  public void bGetClassifier() {
    final Classifier classifier;

    try {
      GetClassifierOptions getOptions =
          new GetClassifierOptions.Builder().classifierId(classifierId).build();
      classifier = service.getClassifier(getOptions).execute().getResult();
    } catch (NotFoundException e) {
      // #324: Classifiers may be empty, because of other tests interfering.
      // The build should not fail here, because this is out of our control.
      throw new AssumptionViolatedException(e.getMessage(), e);
    }
    assertNotNull(classifier);
    assertEquals(classifierId, classifier.getClassifierId());
    assertEquals(Classifier.Status.TRAINING, classifier.getStatus());
  }

  /** Test list classifiers. */
  @Test
  public void cListClassifiers() {
    ListClassifiersOptions listOptions = new ListClassifiersOptions();
    final ClassifierList classifiers = service.listClassifiers(listOptions).execute().getResult();
    assertNotNull(classifiers);

    // #324: Classifiers may be empty, because of other tests interfering.
    // The build should not fail here, because this is out of our control.
    Assume.assumeFalse(classifiers.getClassifiers().isEmpty());
  }

  /** Test classify. Use the pre created classifier to avoid waiting for availability */
  @Test
  public void dClassify() {
    Classification classification = null;

    try {
      ClassifyOptions classifyOptions =
          new ClassifyOptions.Builder()
              .classifierId(preCreatedClassifierId)
              .text("is it hot outside?")
              .build();
      classification = service.classify(classifyOptions).execute().getResult();
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
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void eDelete() throws InterruptedException {
    DeleteClassifierOptions deleteOptions =
        new DeleteClassifierOptions.Builder().classifierId(classifierId).build();
    service.deleteClassifier(deleteOptions).execute();
  }

  /** Test classifyCollection. Use the pre created classifier to avoid waiting for availability */
  @Test
  public void fClassifyCollection() {
    ClassificationCollection classificationCollection = null;
    ClassifyInput input1 = new ClassifyInput.Builder().text("How hot will it be today?").build();
    ClassifyInput input2 = new ClassifyInput.Builder().text("Is it hot outside?").build();

    try {
      ClassifyCollectionOptions classifyOptions =
          new ClassifyCollectionOptions.Builder()
              .classifierId(preCreatedClassifierId)
              .addClassifyInput(input1)
              .addClassifyInput(input2)
              .build();
      classificationCollection = service.classifyCollection(classifyOptions).execute().getResult();
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

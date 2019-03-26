/*
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
package com.ibm.watson.visual_recognition.v3;

import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.common.RetryRunner;
import com.ibm.watson.common.WatsonServiceTest;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.Classifier;
import com.ibm.watson.visual_recognition.v3.model.Classifier.Status;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;
import com.ibm.watson.visual_recognition.v3.model.CreateClassifierOptions;
import com.ibm.watson.visual_recognition.v3.model.DeleteClassifierOptions;
import com.ibm.watson.visual_recognition.v3.model.DeleteUserDataOptions;
import com.ibm.watson.visual_recognition.v3.model.DetectFacesOptions;
import com.ibm.watson.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.visual_recognition.v3.model.GetClassifierOptions;
import com.ibm.watson.visual_recognition.v3.model.GetCoreMlModelOptions;
import com.ibm.watson.visual_recognition.v3.model.ListClassifiersOptions;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Visual Recognition Integration test.
 *
 * @version v3
 */
@RunWith(RetryRunner.class)
public class VisualRecognitionIT extends WatsonServiceTest {
  private static final String VERSION = "2018-03-19";
  private static final String IMAGE_FACE_FILE = "src/test/resources/visual_recognition/faces.zip";
  private static final String IMAGE_FACE_URL = "https://watson-test-resources.mybluemix.net/resources/obama.jpg";
  private static final String IMAGE_FILE = "src/test/resources/visual_recognition/test.zip";
  private static final String IMAGE_URL = "https://watson-test-resources.mybluemix.net/resources/car.png";
  private static final String SINGLE_IMAGE_FILE = "src/test/resources/visual_recognition/car.png";

  private String classifierId;
  private VisualRecognition service;

  private void assertClassifyImage(ClassifiedImages result, ClassifyOptions options) {
    assertNotNull(result);
    assertNotNull(result.getImages());
    assertTrue(result.getImages().size() > 0);
    assertNull(result.getImages().get(0).getError());
    assertNotNull(result.getImages().get(0).getClassifiers());
    assertTrue(!result.getImages().get(0).getClassifiers().isEmpty());

    if (options.url() != null || (options.parameters() != null && options.parameters().contains("url"))) {
      assertNotNull(result.getImages().get(0).getResolvedUrl());
      assertNotNull(result.getImages().get(0).getSourceUrl());
    } else {
      assertNotNull(result.getImages().get(0).getImage());
    }
  }

  /**
   * Assert detected faces.
   *
   * @param detectedFaces the detected faces
   * @param options the detect faces options
   */
  private void assertDetectedFaces(DetectedFaces detectedFaces, DetectFacesOptions options) {
    assertNotNull(detectedFaces);
    assertNotNull(detectedFaces.getImages());
    assertTrue(detectedFaces.getImages().size() > 0);
    assertNull(detectedFaces.getImages().get(0).getError());
    assertNotNull(detectedFaces.getImages().get(0).getFaces());

    if (options.url() != null || (options.parameters() != null && options.parameters().contains("url"))) {
      assertEquals(IMAGE_FACE_URL, detectedFaces.getImages().get(0).getResolvedUrl());
      assertEquals(IMAGE_FACE_URL, detectedFaces.getImages().get(0).getSourceUrl());
    } else {
      assertNotNull(detectedFaces.getImages().get(0).getImage());
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String iamApiKey = getProperty("visual_recognition.apikey");
    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (iamApiKey == null) || iamApiKey.equals("API_KEY"));

    String url = getProperty("visual_recognition.url");
    classifierId = getProperty("visual_recognition.classifier_id");

    service = new VisualRecognition(VERSION);
    IamOptions iamOptions = new IamOptions.Builder()
        .apiKey(iamApiKey)
        .build();
    service.setIamCredentials(iamOptions);
    service.setDefaultHeaders(getDefaultHeaders());
    service.setEndPoint(url);
  }

  /**
   * Test classify a single jpg image.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testClassifyImagesFromBytes() throws IOException {
    InputStream imagesStream = new FileInputStream(SINGLE_IMAGE_FILE);
    ClassifyOptions options = new ClassifyOptions.Builder()
        .imagesFile(imagesStream)
        .imagesFilename("car.png")
        .build();
    ClassifiedImages result = service.classify(options).execute().getResult();
    assertClassifyImage(result, options);
  }

  /**
   * Test classify images from zip file.
   */
  @Test
  public void testClassifyImagesFromFile() throws FileNotFoundException {
    File images = new File(IMAGE_FILE);
    ClassifyOptions options = new ClassifyOptions.Builder().imagesFile(images).build();
    ClassifiedImages result = service.classify(options).execute().getResult();

    assertClassifyImage(result, options);
  }

  /**
   * Test classify images from url.
   */
  @Test
  public void testClassifyImagesFromUrl() {
    ClassifyOptions options = new ClassifyOptions.Builder()
        .url(IMAGE_URL)
        .build();
    ClassifiedImages result = service.classify(options).execute().getResult();
    assertClassifyImage(result, options);
  }

  /**
   * Test classify images from url using the deprecated parameters option.
   */
  @Test
  public void testClassifyImagesFromUrlUsingParameters() {
    String parameters = "{\"url\":\"" + IMAGE_URL + "\"}";

    ClassifyOptions options = new ClassifyOptions.Builder()
        .parameters(parameters)
        .build();
    ClassifiedImages result = service.classify(options).execute().getResult();
    assertClassifyImage(result, options);
  }

  /**
   * Test create a classifier.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Ignore
  @Test
  public void testCreateClassifierAndClassifyImage() throws FileNotFoundException, InterruptedException {
    String classifierName = "integration-test-java-sdk";
    String carClassifier = "car";
    String baseballClassifier = "baseball";

    File carImages = new File("src/test/resources/visual_recognition/car_positive.zip");
    File baseballImages = new File("src/test/resources/visual_recognition/baseball_positive.zip");
    File negativeImages = new File("src/test/resources/visual_recognition/negative.zip");
    File imageToClassify = new File("src/test/resources/visual_recognition/car.png");

    CreateClassifierOptions.Builder builder = new CreateClassifierOptions.Builder().name(classifierName);
    builder.addClass(carClassifier, carImages);
    builder.addClass(baseballClassifier, baseballImages);
    builder.negativeExamples(negativeImages);

    Classifier newClassifier = service.createClassifier(builder.build()).execute().getResult();
    try {
      assertEquals(classifierName, newClassifier.getName());
      boolean ready = false;
      for (int x = 0; (x < 20) && !ready; x++) {
        Thread.sleep(2000);
        GetClassifierOptions getOptions = new GetClassifierOptions.Builder(newClassifier.getClassifierId()).build();
        newClassifier = service.getClassifier(getOptions).execute().getResult();
        ready = newClassifier.getStatus().equals(Status.READY);
      }
      assertEquals(Status.READY, newClassifier.getStatus());

      ClassifyOptions options = new ClassifyOptions.Builder().imagesFile(imageToClassify).build();
      ClassifiedImages classification = service.classify(options).execute().getResult();
      assertNotNull(classification);
    } finally {
      DeleteClassifierOptions deleteOptions = new DeleteClassifierOptions.Builder(newClassifier.getClassifierId())
          .build();
      service.deleteClassifier(deleteOptions).execute();
    }
  }

  /**
   * Test create a classifier.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Ignore
  @Test
  public void testCreateClassifier() throws FileNotFoundException, InterruptedException {
    String classifierName = "integration-test-java-sdk";
    String carClassifier = "car";
    String baseballClassifier = "baseball";

    File carImages = new File("src/test/resources/visual_recognition/car_positive.zip");
    File baseballImages = new File("src/test/resources/visual_recognition/baseball_positive.zip");
    InputStream negativeImages = new FileInputStream("src/test/resources/visual_recognition/negative.zip");

    CreateClassifierOptions.Builder builder = new CreateClassifierOptions.Builder().name(classifierName);
    builder.addClass(carClassifier, carImages);
    builder.addClass(baseballClassifier, baseballImages);
    builder.negativeExamples(negativeImages);
    builder.negativeExamplesFilename("negative.zip");

    Classifier newClass = service.createClassifier(builder.build()).execute().getResult();
    try {
      assertEquals(classifierName, newClass.getName());
      boolean ready = false;
      for (int x = 0; (x < 20) && !ready; x++) {
        Thread.sleep(2000);
        GetClassifierOptions getOptions = new GetClassifierOptions.Builder(newClass.getClassifierId()).build();
        newClass = service.getClassifier(getOptions).execute().getResult();
        ready = newClass.getStatus().equals(Status.READY);
      }
      assertEquals(Status.READY, newClass.getStatus());
    } finally {
      DeleteClassifierOptions deleteOptions = new DeleteClassifierOptions.Builder(newClass.getClassifierId()).build();
      service.deleteClassifier(deleteOptions).execute();
    }
  }

  /**
   * Delete all the visual classifiers.
   */
  @Test
  @Ignore
  public void testDeleteAllClassifiers() {
    List<Classifier> classifiers = service.listClassifiers(null).execute().getResult().getClassifiers();
    for (Classifier classifier : classifiers) {
      if (!classifier.getClassifierId().equals(classifierId)) {
        DeleteClassifierOptions deleteOptions = new DeleteClassifierOptions.Builder(classifier.getClassifierId())
            .build();
        service.deleteClassifier(deleteOptions).execute();
      }
    }
  }

  /**
   * Test detect faces from bytes or stream.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testDetectFacesFromBytes() throws IOException {
    File images = new File(IMAGE_FACE_FILE);
    DetectFacesOptions options = new DetectFacesOptions.Builder().imagesFile(images).build();
    DetectedFaces result = service.detectFaces(options).execute().getResult();
    assertDetectedFaces(result, options);
  }

  /**
   * Test detect faces from file.
   *
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testDetectFacesFromFile() throws FileNotFoundException {
    File images = new File(IMAGE_FACE_FILE);

    DetectFacesOptions options = new DetectFacesOptions.Builder().imagesFile(images).build();
    DetectedFaces detectedFaces = service.detectFaces(options).execute().getResult();
    assertDetectedFaces(detectedFaces, options);
  }

  /**
   * Test detect faces from url.
   */
  @Test
  public void testDetectFacesFromUrl() {
    DetectFacesOptions options = new DetectFacesOptions.Builder()
        .url(IMAGE_FACE_URL)
        .build();

    DetectedFaces detectedFaces = service.detectFaces(options).execute().getResult();
    assertDetectedFaces(detectedFaces, options);
  }

  /**
   * Test detect faces from url using the deprecated parameters option.
   */
  @Test
  public void testDetectFacesFromUrlUsingParameters() {
    String parameters = "{\"url\":\"" + IMAGE_FACE_URL + "\"}";

    DetectFacesOptions options = new DetectFacesOptions.Builder()
        .parameters(parameters)
        .build();

    DetectedFaces detectedFaces = service.detectFaces(options).execute().getResult();
    assertDetectedFaces(detectedFaces, options);
  }

  /**
   * Test list all the classifiers.
   */
  @Ignore
  @Test
  public void testListClassifiers() {
    ListClassifiersOptions options = new ListClassifiersOptions.Builder().verbose(true).build();
    List<Classifier> classifiers = service.listClassifiers(options).execute().getResult().getClassifiers();
    assertNotNull(classifiers);
    assertTrue(!classifiers.isEmpty());

    Classifier classifier = classifiers.get(0);
    assertNotNull(classifier.getClassifierId());
    assertNotNull(classifier.getName());
    assertNotNull(classifier.getOwner());
    assertNotNull(classifier.getStatus());
    assertNotNull(classifier.getClasses());
    assertNotNull(classifier.getCreated());
  }

  /**
   * Test getting the Core ML file for a classifier.
   */
  @Ignore
  @Test
  public void testGetCoreMlModel() {
    ListClassifiersOptions options = new ListClassifiersOptions.Builder().verbose(true).build();
    List<Classifier> classifiers = service.listClassifiers(options).execute().getResult().getClassifiers();

    for (Classifier classifier : classifiers) {
      if (classifier.isCoreMlEnabled()) {
        GetCoreMlModelOptions getCoreMlModelOptions = new GetCoreMlModelOptions.Builder()
            .classifierId(classifier.getClassifierId())
            .build();
        InputStream coreMlFile = service.getCoreMlModel(getCoreMlModelOptions).execute().getResult();
        assertNotNull(coreMlFile);
        break;
      }
    }
  }

  @Test
  public void testDeleteUserData() {
    String customerId = "java_sdk_test_id";

    try {
      DeleteUserDataOptions deleteOptions = new DeleteUserDataOptions.Builder()
          .customerId(customerId)
          .build();
      service.deleteUserData(deleteOptions);
    } catch (Exception ex) {
      fail(ex.getMessage());
    }
  }
}

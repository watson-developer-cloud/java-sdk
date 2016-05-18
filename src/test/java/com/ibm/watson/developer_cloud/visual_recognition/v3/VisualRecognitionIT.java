/*
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
package com.ibm.watson.developer_cloud.visual_recognition.v3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.CreateClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.CreateClassifierOptions.Builder;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.RecognizedText;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier.Status;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualRecognitionOptions;

/**
 * Visual Recognition Integration test.
 *
 * @version v3
 */
public class VisualRecognitionIT extends WatsonServiceTest {
  private static final String IMAGE_FACE_FILE = "src/test/resources/visual_recognition/faces.zip";
  private static final String IMAGE_FACE_URL = "https://watson-test-resources.mybluemix.net/resources/obama.jpg";
  private static final String IMAGE_FILE = "src/test/resources/visual_recognition/test.zip";
  private static final String IMAGE_TEXT_FILE = "src/test/resources/visual_recognition/open.png";
  private static final String IMAGE_TEXT_URL = "https://watson-test-resources.mybluemix.net/resources/open.png";
  private static final String IMAGE_URL = "https://watson-test-resources.mybluemix.net/resources/car.png";

  private VisualRecognition service;

  private void assertClassifyImage(VisualClassification result, ClassifyImagesOptions options) {
    assertNotNull(result);
    assertNotNull(result.getImages());
    assertTrue(result.getImages().size() > 0);
    assertNull(result.getImages().get(0).getError());
    assertNotNull(result.getImages().get(0).getClassifiers());
    assertTrue(!result.getImages().get(0).getClassifiers().isEmpty());
    
    if (options.url() != null) {
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
  private void assertDetectedFaces(DetectedFaces detectedFaces, VisualRecognitionOptions options) {
    assertNotNull(detectedFaces);
    assertNotNull(detectedFaces.getImages());
    assertTrue(detectedFaces.getImages().size() > 0);
    assertNull(detectedFaces.getImages().get(0).getError());
    assertNotNull(detectedFaces.getImages().get(0).getFaces());

    if (options.url() != null) {
      assertEquals(IMAGE_FACE_URL, detectedFaces.getImages().get(0).getResolvedUrl());
      assertEquals(IMAGE_FACE_URL, detectedFaces.getImages().get(0).getSourceUrl());
    } else {
      assertNotNull(detectedFaces.getImages().get(0).getImage());
    }
  }

  private void assertRecognizedText(RecognizedText recognizedText, VisualRecognitionOptions options) {
    assertNotNull(recognizedText);
    assertNotNull(recognizedText.getImages());
    assertEquals(1, recognizedText.getImages().size());
    assertNull(recognizedText.getImages().get(0).getError());
    assertNotNull(recognizedText.getImages().get(0).getWords());
    assertTrue(!recognizedText.getImages().get(0).getWords().isEmpty());

    if (options.url() != null) {
      assertEquals(IMAGE_TEXT_URL, recognizedText.getImages().get(0).getResolvedUrl());
      assertEquals(IMAGE_TEXT_URL, recognizedText.getImages().get(0).getSourceUrl());
    } else {
      assertNotNull(recognizedText.getImages().get(0).getImage());
    }
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
    service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_19);
    service.setApiKey(getValidProperty("visual_recognition.v3.api_key"));
    service.setDefaultHeaders(getDefaultHeaders());
  }

  /**
   * Test classify images from file.
   */
  @Test
  public void testClassifyImagesFromFile() {
    File images = new File(IMAGE_FILE);
    ClassifyImagesOptions options = new ClassifyImagesOptions.Builder().images(images).build();
    VisualClassification result = service.classify(options).execute();

    assertClassifyImage(result, options);
  }


  /**
   * Test classify images from url.
   */
  @Test
  public void testClassifyImagesFromUrl() {
    ClassifyImagesOptions options = new ClassifyImagesOptions.Builder().url(IMAGE_URL).build();
    VisualClassification result = service.classify(options).execute();
    assertClassifyImage(result, options);
  }

  /**
   * Test create a classifier.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException
   */
  @Test
  public void testCreateClassifierAndClassifyImage() throws FileNotFoundException, InterruptedException {
    String classifierName = "integration-test-classifier";
    String carClassifier = "car";
    String baseballClassifier = "baseball";

    File carImages = new File("src/test/resources/visual_recognition/car_positive.zip");
    File baseballImages = new File("src/test/resources/visual_recognition/baseball_positive.zip");
    File negativeImages = new File("src/test/resources/visual_recognition/negative.zip");
    File imageToClassify = new File("src/test/resources/visual_recognition/car.png");


    Builder builder = new CreateClassifierOptions.Builder().classifierName(classifierName);
    builder.addClass(carClassifier, carImages);
    builder.addClass(baseballClassifier, baseballImages);
    builder.negativeExamples(negativeImages);

    VisualClassifier newClass = service.createClassifier(builder.build()).execute();
    try {
      assertEquals(classifierName, newClass.getName());
      boolean ready = false;
      for (int x = 0; x < 20 && !ready; x++) {
        Thread.sleep(2000);
        newClass = service.getClassifier(newClass.getId()).execute();
        ready = newClass.getStatus().equals(Status.AVAILABLE);
      }
      assertEquals(VisualClassifier.Status.AVAILABLE, newClass.getStatus());

      ClassifyImagesOptions options = new ClassifyImagesOptions.Builder().images(imageToClassify).build();
      VisualClassification classification = service.classify(options).execute();
      assertNotNull(classification);
    } finally {
      service.deleteClassifier(newClass.getId());
    }
  }

  /**
   * Test detect faces from file.
   *
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testDetectFacesFromFile() throws FileNotFoundException {
    File images = new File(IMAGE_FACE_FILE);

    VisualRecognitionOptions options = new VisualRecognitionOptions.Builder().images(images).build();
    DetectedFaces detectedFaces = service.detectFaces(options).execute();
    assertDetectedFaces(detectedFaces, options);
  }

  /**
   * Test detect faces from url
   */
  @Test
  public void testDetectFacesFromUrl() {
    VisualRecognitionOptions options = new VisualRecognitionOptions.Builder().url(IMAGE_FACE_URL).build();

    DetectedFaces detectedFaces = service.detectFaces(options).execute();
    assertDetectedFaces(detectedFaces, options);
  }


  /**
   * Test get all the classifiers.
   */
  @Test
  public void testGetClassifiers() {
    List<VisualClassifier> classifiers = service.getClassifiers().execute();
    assertNotNull(classifiers);
    assertTrue(!classifiers.isEmpty());

    VisualClassifier classifier = classifiers.get(0);
    assertNotNull(classifier.getId());
    assertNotNull(classifier.getName());
    assertNotNull(classifier.getOwner());
    assertNotNull(classifier.getStatus());
    assertNotNull(classifier.getClasses());
    assertNotNull(classifier.getCreated());
  }

  /**
   * Test recognize text from file.
   *
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testRecognizeTextFromFile() throws FileNotFoundException {
    File images = new File(IMAGE_TEXT_FILE);

    VisualRecognitionOptions options = new VisualRecognitionOptions.Builder().images(images).build();
    RecognizedText recognizedText = service.recognizeText(options).execute();
    assertRecognizedText(recognizedText, options);
  }

  /**
   * Test recognize text from url
   */
  @Test
  public void testRecognizeTextFromUrl() {
    VisualRecognitionOptions options = new VisualRecognitionOptions.Builder().url(IMAGE_TEXT_URL).build();

    RecognizedText recognizedText = service.recognizeText(options).execute();
    assertRecognizedText(recognizedText, options);
  }

}

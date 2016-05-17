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
package com.ibm.watson.developer_cloud.visual_recognition.v2_beta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.service.exception.NotFoundException;
import com.ibm.watson.developer_cloud.visual_recognition.v2_beta.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v2_beta.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v2_beta.model.VisualClassifier;

/**
 * Visual Recognition Integration test.
 *
 * @version v2
 */
public class VisualRecognitionIT extends WatsonServiceTest {

  private static final String CLASSIFIER_ID_CAR = "Car";
  private VisualRecognition service;

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new VisualRecognition(VisualRecognition.VERSION_DATE_2015_12_02);
    service.setUsernameAndPassword(getValidProperty("visual_recognition.v2.username"),
        getValidProperty("visual_recognition.v2.password"));
    service.setEndPoint(getValidProperty("visual_recognition.v2.url"));
    service.setDefaultHeaders(getDefaultHeaders());
  }

  /**
   * Test classify image.
   */
  @Test
  public void testClassifyImages() {
    File images = new File("src/test/resources/visual_recognition/test.zip");
    final VisualClassification result = service.classify(images).execute();

    Assert.assertNotNull(result);
    Assert.assertNotNull(result.getImages());
    Assert.assertEquals(2, result.getImages().size());
    Assert.assertNotNull(result.getImages().get(0).getImage());
    Assert.assertNotNull(result.getImages().get(0).getScores());
    Assert.assertNotNull(result.getImages().get(0).getScores().get(0));
    Assert.assertNotNull(result.getImages().get(0).getScores().get(0).getClassifierId());
    Assert.assertNotNull(result.getImages().get(0).getScores().get(0).getScore());
  }

  /**
   * Test classify image using stream.
   *
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testClassifyInputStreamImages() throws FileNotFoundException {
    FileInputStream images = new FileInputStream("src/test/resources/visual_recognition/test.zip");
    final VisualClassification result = service.classify("images.zip", images).execute();

    Assert.assertNotNull(result);
    Assert.assertNotNull(result.getImages());
    Assert.assertEquals(2, result.getImages().size());
    Assert.assertNotNull(result.getImages().get(0).getImage());
    Assert.assertNotNull(result.getImages().get(0).getScores());
    Assert.assertNotNull(result.getImages().get(0).getScores().get(0));
    Assert.assertNotNull(result.getImages().get(0).getScores().get(0).getClassifierId());
    Assert.assertNotNull(result.getImages().get(0).getScores().get(0).getScore());
  }

  /**
   * Test recognize with labels.
   * 
   */
  @Test
  public void testClassifyWithClassifiers() {


  }

  /**
   * Test create a classifier.
   *
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testCreateClassifierAndClassifyImage() throws FileNotFoundException {
    File positiveImages = new File("src/test/resources/visual_recognition/positive.zip");
    File negativeImages = new File("src/test/resources/visual_recognition/negative.zip");
    File image = new File("src/test/resources/visual_recognition/car.png");

    VisualClassifier newClass = service.createClassifier("foo", positiveImages, negativeImages).execute();
    try {
      newClass = service.getClassifier(newClass.getId()).execute();
      VisualClassification result = service.classify(image, newClass).execute();
      Assert.assertNotNull(result);
    } finally {
      // FIXME: deleteClassifier is returning 404 but the classifier is deleted
      try {
        service.deleteClassifier(newClass.getId());
      } catch (NotFoundException e) {
      }
    }

  }

  /**
   * Test get all the classifiers.
   */
  @Test
  public void testGetClassifiers() {
    List<VisualClassifier> classifiers = service.getClassifiers().execute();
    Assert.assertNotNull(classifiers);

    VisualClassifier classifier = classifiers.get(0);
    Assert.assertNotNull(classifier.getId());
    Assert.assertNotNull(classifier.getName());
    Assert.assertNotNull(classifier.getOwner());
    Assert.assertNotNull(classifier.getCreated());
  }

  /**
   * Test get all the classifiers.
   */
  @Test
  public void testGetClassifier() {
    VisualClassifier classifier = service.getClassifier(CLASSIFIER_ID_CAR).execute();
    Assert.assertNotNull(classifier);
    Assert.assertNotNull(classifier.getId());
    Assert.assertNotNull(classifier.getName());
    Assert.assertNotNull(classifier.getOwner());
    Assert.assertNotNull(classifier.getCreated());
  }
}

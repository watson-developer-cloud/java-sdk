/*
 * (C) Copyright IBM Corp. 2020.
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

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.watson.common.WatsonServiceUnitTest;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.Classifier;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;
import com.ibm.watson.visual_recognition.v3.model.CreateClassifierOptions;
import com.ibm.watson.visual_recognition.v3.model.DeleteClassifierOptions;
import com.ibm.watson.visual_recognition.v3.model.DeleteUserDataOptions;
import com.ibm.watson.visual_recognition.v3.model.GetClassifierOptions;
import com.ibm.watson.visual_recognition.v3.model.GetCoreMlModelOptions;
import com.ibm.watson.visual_recognition.v3.model.ListClassifiersOptions;
import com.ibm.watson.visual_recognition.v3.model.UpdateClassifierOptions;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for the {@link VisualRecognition} service.
 */
public class VisualRecognitionTest extends WatsonServiceUnitTest {
  private static final String FIXTURE_CLASSIFICATION
      = "src/test/resources/visual_recognition/v3/visual_classification.json";
  private static final String FIXTURE_CLASSIFIER = "src/test/resources/visual_recognition/v3/visual_classifier.json";
  private static final String IMAGE_FILE = "src/test/resources/visual_recognition/v3/test.zip";
  private static final String SINGLE_IMAGE_FILE = "src/test/resources/visual_recognition/v3/car.png";
  private static final String PATH_CLASSIFY = "/v3/classify";
  private static final String VERSION_KEY = "version";
  private static final String VERSION = "2018-03-19";
  private static final String PATH_CLASSIFIERS = "/v3/classifiers";
  private static final String PATH_CLASSIFIER = "/v3/classifiers/%s";
  private static final String PATH_CORE_ML = "/v3/classifiers/%s/core_ml_model";
  private static final String FILENAME = "test_file";

  private VisualRecognition service;

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceUnitTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    service = new VisualRecognition(VERSION, new NoAuthAuthenticator());
    service.setServiceUrl(getMockWebServerUrl());
  }

  /**
   * Test classify with file.
   *
   * @throws IOException          Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClassifyWithFile() throws IOException, InterruptedException {
    ClassifiedImages mockResponse = loadFixture(FIXTURE_CLASSIFICATION, ClassifiedImages.class);
    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    File images = new File(IMAGE_FILE);
    ClassifyOptions options = new ClassifyOptions.Builder()
        .imagesFile(images)
        .classifierIds(Collections.singletonList("car"))
        .build();
    ClassifiedImages serviceResponse = service.classify(options).execute().getResult();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = PATH_CLASSIFY + "?" + VERSION_KEY + "=" + VERSION;
    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(serviceResponse, mockResponse);
  }

  /**
   * Test classify with bytes or stream.
   *
   * @throws IOException          Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClassifyWithBytes() throws IOException, InterruptedException {
    ClassifiedImages mockResponse = loadFixture(FIXTURE_CLASSIFICATION, ClassifiedImages.class);
    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    File images = new File(SINGLE_IMAGE_FILE);

    InputStream fileStream = new FileInputStream(images);

    ClassifyOptions options = new ClassifyOptions.Builder()
        .imagesFile(fileStream)
        .imagesFilename(FILENAME)
        .classifierIds(Collections.singletonList("car"))
        .build();
    ClassifiedImages serviceResponse = service.classify(options).execute().getResult();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = PATH_CLASSIFY + "?" + VERSION_KEY + "=" + VERSION;
    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(serviceResponse, mockResponse);
  }

  /**
   * Test update classifier.
   *
   * @throws IOException          Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testUpdateClassifier() throws IOException, InterruptedException {
    Classifier mockResponse = loadFixture(FIXTURE_CLASSIFIER, Classifier.class);

    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    File images = new File(IMAGE_FILE);
    String class1 = "class1";
    String classifierId = "foo123";

    UpdateClassifierOptions options = new UpdateClassifierOptions.Builder(classifierId)
        .addPositiveExamples(class1, images)
        .build();

    Classifier serviceResponse = service.updateClassifier(options).execute().getResult();

    // first request
    String path = String.format(PATH_CLASSIFIER, classifierId);
    RecordedRequest request = server.takeRequest();
    path += "?" + VERSION_KEY + "=" + VERSION;

    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    String body = request.getBody().readUtf8();

    String contentDisposition
        = "Content-Disposition: form-data; name=\"class1_positive_examples\";";
    assertTrue(body.contains(contentDisposition));
    assertTrue(!body.contains("Content-Disposition: form-data; name=\"name\""));
    assertEquals(serviceResponse, mockResponse);
  }

  /**
   * Test create classifier.
   *
   * @throws IOException          Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testCreateClassifier() throws IOException, InterruptedException {
    Classifier mockResponse = loadFixture(FIXTURE_CLASSIFIER, Classifier.class);

    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    File positiveImages = new File(IMAGE_FILE);
    File negativeImages = new File(IMAGE_FILE);
    String class1 = "class1";
    CreateClassifierOptions options = new CreateClassifierOptions.Builder()
        .name(class1)
        .addPositiveExamples(class1, positiveImages)
        .negativeExamples(negativeImages)
        .build();

    Classifier serviceResponse = service.createClassifier(options).execute().getResult();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = PATH_CLASSIFIERS + "?" + VERSION_KEY + "=" + VERSION;

    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    String body = request.getBody().readUtf8();

    String contentDisposition
        = "Content-Disposition: form-data; name=\"class1_positive_examples\";";
    assertTrue(body.contains(contentDisposition));
    assertTrue(body.contains("Content-Disposition: form-data; name=\"name\""));
    assertEquals(serviceResponse, mockResponse);
  }

  /**
   * Test delete classifier.
   *
   * @throws IOException          Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteClassifier() throws IOException, InterruptedException {
    server.enqueue(new MockResponse().setBody(""));

    String class1 = "class1";
    DeleteClassifierOptions options = new DeleteClassifierOptions.Builder(class1).build();
    service.deleteClassifier(options).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = String.format(PATH_CLASSIFIER + "?" + VERSION_KEY + "=" + VERSION, class1);

    assertEquals(path, request.getPath());
    assertEquals("DELETE", request.getMethod());
  }

  /**
   * Test get classifier.
   *
   * @throws InterruptedException the interrupted exception
   * @throws IOException          Signals that an I/O exception has occurred.
   */
  @Test
  public void testGetClassifier() throws InterruptedException, IOException {
    try {
      Classifier mockResponse = loadFixture(FIXTURE_CLASSIFIER, Classifier.class);

      server.enqueue(new MockResponse().setBody(mockResponse.toString()));

      // execute request
      String class1 = "class1";
      GetClassifierOptions getOptions = new GetClassifierOptions.Builder(class1).build();
      Classifier serviceResponse = service.getClassifier(getOptions).execute().getResult();

      // first request
      RecordedRequest request = server.takeRequest();
      String path = String.format(PATH_CLASSIFIER + "?" + VERSION_KEY + "=" + VERSION, class1);

      assertEquals(path, request.getPath());
      assertEquals("GET", request.getMethod());
      assertEquals(serviceResponse, mockResponse);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  /**
   * Test get classifiers.
   *
   * @throws InterruptedException the interrupted exception
   * @throws IOException          Signals that an I/O exception has occurred.
   */
  @Test
  public void testGetClassifiers() throws InterruptedException, IOException {
    Classifier mockClassifier = loadFixture(FIXTURE_CLASSIFIER, Classifier.class);
    List<Classifier> classifiers = new ArrayList<>();
    classifiers.add(mockClassifier);
    classifiers.add(mockClassifier);
    classifiers.add(mockClassifier);

    JsonObject mockResponse = new JsonObject();
    mockResponse.add("classifiers", new Gson().toJsonTree(classifiers));

    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    ListClassifiersOptions options = new ListClassifiersOptions.Builder().verbose(true).build();
    List<Classifier> serviceResponse = service.listClassifiers(options).execute().getResult().getClassifiers();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = PATH_CLASSIFIERS + "?" + VERSION_KEY + "=" + VERSION + "&verbose=true";

    assertEquals(path, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(serviceResponse, classifiers);
  }

  @Test
  public void testGetCoreMlModel() throws IOException, InterruptedException {
    final File model = new File("src/test/resources/visual_recognition/v3/custom_model.mlmodel");
    final Buffer buffer = new Buffer().write(Files.toByteArray(model));

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_OCTET_STREAM).setBody(buffer));

    String classifierId = "classifier_id";
    GetCoreMlModelOptions options = new GetCoreMlModelOptions.Builder()
        .classifierId(classifierId)
        .build();

    InputStream modelFile = service.getCoreMlModel(options).execute().getResult();

    RecordedRequest request = server.takeRequest();
    String path = String.format(PATH_CORE_ML, classifierId) + "?" + VERSION_KEY + "=" + VERSION;

    assertEquals(path, request.getPath());
    assertEquals("GET", request.getMethod());
    File outputFile = new File("src/test/resources/visual_recognition/v3/model_result.mlmodel");
    outputFile.createNewFile();
    writeInputStreamToFile(modelFile, outputFile);
  }

  @Test
  public void testDeleteUserDataOptionsBuilder() {
    String customerId = "java_sdk_test_id";

    DeleteUserDataOptions deleteOptions = new DeleteUserDataOptions.Builder()
        .customerId(customerId)
        .build();

    assertEquals(deleteOptions.customerId(), customerId);
  }
}

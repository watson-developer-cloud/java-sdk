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
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.CreateClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.RecognizedText;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualRecognitionOptions;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

public class VisualRecognitionTest extends WatsonServiceUnitTest {

  private static final String API_KEY = "alchemykey";
  private static final String FIXTURE_CLASSIFICATION = "src/test/resources/visual_recognition/visual_classification.json";
  private static final String FIXTURE_CLASSIFIER = "src/test/resources/visual_recognition/visual_classifier.json";
  private static final String FIXTURE_FACES = "src/test/resources/visual_recognition/detected_faces.json";
  private static final String FIXTURE_TEXT = "src/test/resources/visual_recognition/detected_text.json";
  private static final String IMAGE_FILE = "src/test/resources/visual_recognition/test.zip";
  private static final String PATH_CLASSIFY = "/v3/classify";
  private static final String VERSION_DATE = "version";
  private static final String PATH_CLASSIFIERS = "/v3/classifiers";
  private static final String PATH_CLASSIFIER = "/v3/classifiers/%s";
  private static final String PATH_DETECT_FACES = "/v3/detect_faces";
  private static final String PATH_RECOGNIZE_TEXT = "/v3/recognize_text";

  /**
   * Test classify with file.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClassifyWithFile() throws IOException, InterruptedException {
    MockWebServer server = new MockWebServer();

    VisualClassification mockResponse = loadFixture(FIXTURE_CLASSIFICATION, VisualClassification.class);
    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    server.start();

    VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_19);
    service.setApiKey(API_KEY);
    service.setEndPoint(getMockWebServerUrl(server));

    // execute request
    File images = new File(IMAGE_FILE);
    ClassifyImagesOptions options = new ClassifyImagesOptions.Builder().images(images).build();
    VisualClassification serviceResponse = service.classify(options).execute();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = PATH_CLASSIFY + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_19 +
        "&api_key=" + API_KEY;
    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(serviceResponse, mockResponse);

    // Shut down the server.
    server.shutdown();
  }

  /**
   * Test create classifier.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testCreateClassifier() throws IOException, InterruptedException {
    VisualClassifier mockResponse = loadFixture(FIXTURE_CLASSIFIER, VisualClassifier.class);
    
    MockWebServer server = new MockWebServer();
    server.enqueue(new MockResponse().setBody(mockResponse.toString()));
    server.start();

    VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_19);
    service.setApiKey(API_KEY);
    service.setEndPoint(getMockWebServerUrl(server));

    // execute request
    File images = new File(IMAGE_FILE);
    String class1 = "class1"; 
    CreateClassifierOptions options = new CreateClassifierOptions.Builder()
        .classifierName(class1)
        .addClass(class1, images)
        .negativeExamples(images)
        .build();
    
    VisualClassifier serviceResponse = service.createClassifier(options).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = PATH_CLASSIFIERS + "?" +
        VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_19 + 
        "&api_key=" + API_KEY;
    
    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    String body = request.getBody().readUtf8();
    
    String contentDisposition = "Content-Disposition: form-data; name=\"class1_positive_examples\"; filename=\"test.zip\"";
    assertTrue(body.contains(contentDisposition));
    assertTrue(body.contains("Content-Disposition: form-data; name=\"name\""));
    assertEquals(serviceResponse, mockResponse);

    // Shut down the server.
    server.shutdown();
  }

  @Test
  public void testDeleteClassifier() throws IOException, InterruptedException {
    
    MockWebServer server = new MockWebServer();
    server.enqueue(new MockResponse().setBody(""));
    server.start();

    VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_19);
    service.setApiKey(API_KEY);
    service.setEndPoint(getMockWebServerUrl(server));

    String class1 = "class1"; 
    service.deleteClassifier(class1).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = String.format(PATH_CLASSIFIER + "?" +
        VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_19 + 
        "&" + "api_key=" + API_KEY, class1);
    
    assertEquals(path, request.getPath());
    assertEquals("DELETE", request.getMethod());

    // Shut down the server.
    server.shutdown();
  }

  @Test
  public void testDetectFaces() throws IOException, InterruptedException  {
    DetectedFaces mockResponse = loadFixture(FIXTURE_FACES, DetectedFaces.class);
    
    MockWebServer server = new MockWebServer();
    server.enqueue(new MockResponse().setBody(mockResponse.toString()));
    server.start();

    VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_19);
    service.setApiKey(API_KEY);
    service.setEndPoint(getMockWebServerUrl(server));

    // execute request
    File images = new File(IMAGE_FILE);
    VisualRecognitionOptions options = new VisualRecognitionOptions.Builder()
        .images(images)
        .build();
    
    DetectedFaces serviceResponse = service.detectFaces(options).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = PATH_DETECT_FACES + "?" +
        VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_19 + 
        "&api_key=" + API_KEY;
    
    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(serviceResponse, mockResponse);
    String contentDisposition = "Content-Disposition: form-data; name=\"images_file\"; filename=\"test.zip\"";
    assertTrue(request.getBody().readUtf8().contains(contentDisposition));
    
    // Shut down the server.
    server.shutdown();
  }

  @Test
  public void testGetClassifier() throws InterruptedException, IOException {
    try {
      VisualClassifier mockResponse = loadFixture(FIXTURE_CLASSIFIER, VisualClassifier.class);
      
      MockWebServer server = new MockWebServer();
      server.enqueue(new MockResponse().setBody(mockResponse.toString()));
      server.start();

      VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_19);
      service.setApiKey(API_KEY);
      service.setEndPoint(getMockWebServerUrl(server));

      // execute request
      String class1 = "class1"; 
      VisualClassifier serviceResponse = service.getClassifier(class1).execute();

      // first request
      RecordedRequest request = server.takeRequest();
      String path = String.format(PATH_CLASSIFIER +  "?" +
          VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_19 + 
          "&" + "api_key=" + API_KEY, class1);
      
      assertEquals(path, request.getPath());
      assertEquals("GET", request.getMethod());
      assertEquals(serviceResponse, mockResponse);

      // Shut down the server.
      server.shutdown();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Test
  public void testGetClassifiers() throws InterruptedException, IOException {
    VisualClassifier mockClassifier = loadFixture(FIXTURE_CLASSIFIER, VisualClassifier.class);
    List<VisualClassifier> classifiers = new ArrayList<VisualClassifier>();
    classifiers.add(mockClassifier);
    classifiers.add(mockClassifier);
    classifiers.add(mockClassifier);
    
    JsonObject mockResponse = new JsonObject();
    mockResponse.add("classifiers", new Gson().toJsonTree(classifiers));
    
    MockWebServer server = new MockWebServer();
    server.enqueue(new MockResponse().setBody(mockResponse.toString()));
    server.start();

    VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_19);
    service.setApiKey(API_KEY);
    service.setEndPoint(getMockWebServerUrl(server));

    List<VisualClassifier> serviceResponse = service.getClassifiers().execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = PATH_CLASSIFIERS + "?" +
        VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_19 +
        "&verbose=true&api_key=" + API_KEY;
    
    assertEquals(path, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(serviceResponse, classifiers);

    // Shut down the server.
    server.shutdown();

  }

  @Test
  public void testRecognizeText() throws IOException, InterruptedException  {
    RecognizedText mockResponse = loadFixture(FIXTURE_TEXT, RecognizedText.class);
    
    MockWebServer server = new MockWebServer();
    server.enqueue(new MockResponse().setBody(mockResponse.toString()));
    server.start();

    VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_19);
    service.setApiKey(API_KEY);
    service.setEndPoint(getMockWebServerUrl(server));

    // execute request
    String url = "https://test.com";
    VisualRecognitionOptions options = new VisualRecognitionOptions.Builder()
        .url(url)
        .build();
    
    RecognizedText serviceResponse = service.recognizeText(options).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = PATH_RECOGNIZE_TEXT + "?" +
        VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_19 + 
        "&api_key=" + API_KEY;
    
    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(serviceResponse, mockResponse);
    
    String body = request.getBody().readUtf8();
    assertTrue(body.contains("Content-Disposition: form-data; name=\"parameters\""));
    assertTrue(body.contains("{\"url\":\"https://test.com/\"}"));
    

    // Shut down the server.
    server.shutdown();
  }

}

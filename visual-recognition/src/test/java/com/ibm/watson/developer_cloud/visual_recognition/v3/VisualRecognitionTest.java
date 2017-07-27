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
package com.ibm.watson.developer_cloud.visual_recognition.v3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.AddImageToCollectionOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.Collection;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.CollectionImage;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.FindSimilarImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.RecognizedText;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualRecognitionOptions;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Unit tests for the {@link VisualRecognition} service.
 */
public class VisualRecognitionTest extends WatsonServiceUnitTest {

  private static final String API_KEY = "alchemykey";
  private static final String FIXTURE_CLASSIFICATION =
      "src/test/resources/visual_recognition/visual_classification.json";
  private static final String FIXTURE_CLASSIFIER = "src/test/resources/visual_recognition/visual_classifier.json";
  private static final String FIXTURE_FACES = "src/test/resources/visual_recognition/detected_faces.json";
  private static final String FIXTURE_TEXT = "src/test/resources/visual_recognition/detected_text.json";
  private static final String FIXTURE_COLLECTION = "src/test/resources/visual_recognition/collection.json";
  private static final String FIXTURE_IMAGE = "src/test/resources/visual_recognition/image.json";
  private static final String IMAGE_FILE = "src/test/resources/visual_recognition/test.zip";
  private static final String SINGLE_IMAGE_FILE = "src/test/resources/visual_recognition/car.png";
  private static final String PATH_CLASSIFY = "/v3/classify";
  private static final String VERSION_DATE = "version";
  private static final String PATH_CLASSIFIERS = "/v3/classifiers";
  private static final String PATH_CLASSIFIER = "/v3/classifiers/%s";
  private static final String PATH_DETECT_FACES = "/v3/detect_faces";
  private static final String PATH_RECOGNIZE_TEXT = "/v3/recognize_text";
  private static final String PATH_COLLECTION = "/v3/collections/%s";
  private static final String PATH_COLLECTIONS = "/v3/collections";
  private static final String PATH_IMAGE = "/v3/collections/collection1/images/%s";
  private static final String PATH_IMAGES = "/v3/collections/collection1/images";
  private static final String PATH_IMAGESFIND = "/v3/collections/collection1/find_similar";

  private VisualRecognition service;

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceUnitTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
    service.setApiKey(API_KEY);
    service.setEndPoint(getMockWebServerUrl());
  }

  /**
   * Test classify with file.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClassifyWithFile() throws IOException, InterruptedException {
    VisualClassification mockResponse = loadFixture(FIXTURE_CLASSIFICATION, VisualClassification.class);
    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    File images = new File(IMAGE_FILE);
    ClassifyImagesOptions options = new ClassifyImagesOptions.Builder().images(images).classifierIds("car").build();
    VisualClassification serviceResponse = service.classify(options).execute();

    // first request
    RecordedRequest request = server.takeRequest();

    String path =
        PATH_CLASSIFY + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20 + "&api_key=" + API_KEY;
    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(serviceResponse, mockResponse);
  }

  /**
   * Test classify with bytes or stream.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClassifyWithBytes() throws IOException, InterruptedException {
    VisualClassification mockResponse = loadFixture(FIXTURE_CLASSIFICATION, VisualClassification.class);
    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    File images = new File(SINGLE_IMAGE_FILE);

    byte[] fileBytes = Files.readAllBytes(Paths.get(images.getPath()));

    ClassifyImagesOptions options =
        new ClassifyImagesOptions.Builder().images(fileBytes, "car.png").classifierIds("car").build();
    VisualClassification serviceResponse = service.classify(options).execute();

    // first request
    RecordedRequest request = server.takeRequest();

    String path =
        PATH_CLASSIFY + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20 + "&api_key=" + API_KEY;
    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(serviceResponse, mockResponse);
  }
  /**
   * Test update classifier.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testUpdateClassifier() throws IOException, InterruptedException {
    VisualClassifier mockResponse = loadFixture(FIXTURE_CLASSIFIER, VisualClassifier.class);

    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    File images = new File(IMAGE_FILE);
    String class1 = "class1";
    String classifierId = "foo123";

    ClassifierOptions options = new ClassifierOptions.Builder().classifierName(class1).addClass(class1, images).build();

    VisualClassifier serviceResponse = service.updateClassifier(classifierId, options).execute();

    // first request
    String path = String.format(PATH_CLASSIFIER, classifierId);
    RecordedRequest request = server.takeRequest();
    path += "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20 + "&api_key=" + API_KEY;

    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    String body = request.getBody().readUtf8();

    String contentDisposition =
        "Content-Disposition: form-data; name=\"class1_positive_examples\"; filename=\"test.zip\"";
    assertTrue(body.contains(contentDisposition));
    assertTrue(!body.contains("Content-Disposition: form-data; name=\"name\""));
    assertEquals(serviceResponse, mockResponse);
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

    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    File images = new File(IMAGE_FILE);
    String class1 = "class1";
    ClassifierOptions options = new ClassifierOptions.Builder().classifierName(class1).addClass(class1, images)
        .negativeExamples(images).build();

    VisualClassifier serviceResponse = service.createClassifier(options).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path =
        PATH_CLASSIFIERS + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20 + "&api_key=" + API_KEY;

    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    String body = request.getBody().readUtf8();

    String contentDisposition =
        "Content-Disposition: form-data; name=\"class1_positive_examples\"; filename=\"test.zip\"";
    assertTrue(body.contains(contentDisposition));
    assertTrue(body.contains("Content-Disposition: form-data; name=\"name\""));
    assertEquals(serviceResponse, mockResponse);
  }

  /**
   * Test delete classifier.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteClassifier() throws IOException, InterruptedException {
    server.enqueue(new MockResponse().setBody(""));

    String class1 = "class1";
    service.deleteClassifier(class1).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = String.format(PATH_CLASSIFIER + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20
        + "&" + "api_key=" + API_KEY, class1);

    assertEquals(path, request.getPath());
    assertEquals("DELETE", request.getMethod());
  }

  /**
   * Test detect faces.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDetectFaces() throws IOException, InterruptedException {
    DetectedFaces mockResponse = loadFixture(FIXTURE_FACES, DetectedFaces.class);

    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    File images = new File(IMAGE_FILE);
    VisualRecognitionOptions options = new VisualRecognitionOptions.Builder().images(images).build();

    DetectedFaces serviceResponse = service.detectFaces(options).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = PATH_DETECT_FACES + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20 + "&api_key="
        + API_KEY;

    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(serviceResponse, mockResponse);
    String contentDisposition = "Content-Disposition: form-data; name=\"images_file\"; filename=\"test.zip\"";
    assertTrue(request.getBody().readUtf8().contains(contentDisposition));
  }

  /**
   * Test get classifier.
   *
   * @throws InterruptedException the interrupted exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testGetClassifier() throws InterruptedException, IOException {
    try {
      VisualClassifier mockResponse = loadFixture(FIXTURE_CLASSIFIER, VisualClassifier.class);

      server.enqueue(new MockResponse().setBody(mockResponse.toString()));

      // execute request
      String class1 = "class1";
      VisualClassifier serviceResponse = service.getClassifier(class1).execute();

      // first request
      RecordedRequest request = server.takeRequest();
      String path = String.format(PATH_CLASSIFIER + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20
          + "&" + "api_key=" + API_KEY, class1);

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
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testGetClassifiers() throws InterruptedException, IOException {
    VisualClassifier mockClassifier = loadFixture(FIXTURE_CLASSIFIER, VisualClassifier.class);
    List<VisualClassifier> classifiers = new ArrayList<VisualClassifier>();
    classifiers.add(mockClassifier);
    classifiers.add(mockClassifier);
    classifiers.add(mockClassifier);

    JsonObject mockResponse = new JsonObject();
    mockResponse.add("classifiers", new Gson().toJsonTree(classifiers));

    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    List<VisualClassifier> serviceResponse = service.getClassifiers().execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = PATH_CLASSIFIERS + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20
        + "&verbose=true&api_key=" + API_KEY;

    assertEquals(path, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(serviceResponse, classifiers);
  }

  /**
   * Test recognize text.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRecognizeText() throws IOException, InterruptedException {
    RecognizedText mockResponse = loadFixture(FIXTURE_TEXT, RecognizedText.class);

    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    String url = "https://test.com";
    VisualRecognitionOptions options = new VisualRecognitionOptions.Builder().url(url).build();

    RecognizedText serviceResponse = service.recognizeText(options).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = PATH_RECOGNIZE_TEXT + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20
        + "&api_key=" + API_KEY;

    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(serviceResponse, mockResponse);

    String body = request.getBody().readUtf8();
    assertTrue(body.contains("Content-Disposition: form-data; name=\"parameters\""));
    assertTrue(body.contains("{\"url\":\"https://test.com/\"}"));
  }

  // Begin Similarity Search functionality
  // Collection tests
  /**
   * Test get collection.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetCollection() throws IOException, InterruptedException {
    Collection mockResponse = loadFixture(FIXTURE_COLLECTION, Collection.class);

    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    String collectionId = "collection1";
    Collection serviceResponse = service.getCollection(collectionId).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = String.format(PATH_COLLECTION + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20
        + "&" + "api_key=" + API_KEY, collectionId);

    assertEquals(path, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(serviceResponse, mockResponse);
  }

  /**
   * Negative Test for get collection.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetCollectionNeg() {
    @SuppressWarnings("unused")
    Collection serviceResponse = service.getCollection(null).execute();
  }

  /**
   * Test get collections.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetCollections() throws IOException, InterruptedException {
    Collection mockCollection = loadFixture(FIXTURE_COLLECTION, Collection.class);
    List<Collection> collections = new ArrayList<Collection>();
    collections.add(mockCollection);
    collections.add(mockCollection);
    collections.add(mockCollection);

    JsonObject mockResponse = new JsonObject();
    mockResponse.add("collections", new Gson().toJsonTree(collections));

    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    List<Collection> serviceResponse = service.getCollections().execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = PATH_COLLECTIONS + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20
        + "&" + "api_key=" + API_KEY;

    assertEquals(path, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(serviceResponse, collections);
  }

  /**
   * Test delete collection.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteCollection() throws IOException, InterruptedException {
    server.enqueue(new MockResponse().setBody(""));

    // execute request
    String collectionId = "collection1";
    service.deleteCollection(collectionId).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = String.format(PATH_COLLECTION + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20
        + "&" + "api_key=" + API_KEY, collectionId);

    assertEquals(path, request.getPath());
    assertEquals("DELETE", request.getMethod());
  }

  /**
   * Negative Test for delete collection.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDeleteCollectionNeg() {
    service.deleteCollection("").execute();
  }

  /**
   * Test create collection.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testCreateCollection() throws IOException, InterruptedException {
    Collection mockResponse = loadFixture(FIXTURE_COLLECTION, Collection.class);
    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    String collectionNme = "collectionName1";
    Collection serviceResponse = service.createCollection(collectionNme).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = String.format(PATH_COLLECTIONS + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20
        + "&" + "name=" + "%s" + "&" + "api_key=" + API_KEY, collectionNme);

    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(serviceResponse, mockResponse);
  }

  /**
   * Negative Test for create collection.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCreateCollectionNeg() {
    service.createCollection(null).execute();
  }

  // Image tests
  /**
   * Test get image.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetImage() throws IOException, InterruptedException {
    CollectionImage mockResponse = loadFixture(FIXTURE_IMAGE, CollectionImage.class);

    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    String collectionId = "collection1";
    String imageId = "image1";
    CollectionImage serviceResponse = service.getCollectionImage(collectionId, imageId).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = String.format(PATH_IMAGE + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20
        + "&" + "api_key=" + API_KEY, imageId);

    assertEquals(path, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(serviceResponse, mockResponse);
  }

  /**
   * Negative Test for get image.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetImageNeg() {
    @SuppressWarnings("unused")
    CollectionImage serviceResponse = service.getCollectionImage("null", null).execute();
  }

  /**
   * Test get images.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetImages() throws IOException, InterruptedException {
    CollectionImage mockCollection = loadFixture(FIXTURE_IMAGE, CollectionImage.class);
    List<CollectionImage> images = new ArrayList<CollectionImage>();
    images.add(mockCollection);
    images.add(mockCollection);
    images.add(mockCollection);

    JsonObject mockResponse = new JsonObject();
    mockResponse.add("images", new Gson().toJsonTree(images));

    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    String collectionId = "collection1";
    List<CollectionImage> serviceResponse = service.getCollectionImages(collectionId).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = PATH_IMAGES + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20
        + "&" + "api_key=" + API_KEY;

    assertEquals(path, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(serviceResponse, images);
  }

  /**
   * Negative Test for get images.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetImagesNeg() {
    @SuppressWarnings("unused")
    List<CollectionImage> serviceResponse = service.getCollectionImages(null).execute();
  }

  /**
   * Test create image.
   *
   * @throws IOException Signals that an I/O exception has occurred
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testCreateImage() throws IOException, InterruptedException {
    server.enqueue(new MockResponse().setBody(""));

    // execute request
    String collectionId = "collection1";
    AddImageToCollectionOptions options = new AddImageToCollectionOptions.Builder()
        .collectionId(collectionId)
        .image(new File(SINGLE_IMAGE_FILE))
        .metadata("key1", "value1")
        .build();

    service.addImageToCollection(options).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = PATH_IMAGES + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20
        + "&" + "api_key=" + API_KEY;

    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
  }

  /**
   * Negative Test for create image.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCreateImageNeg1() {
    service.addImageToCollection(null).execute();
  }

  /**
   * Test find image.
   *
   * @throws IOException Signals that an I/O exception has occurred
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testFindImages() throws IOException, InterruptedException {
    CollectionImage mockCollection = loadFixture(FIXTURE_IMAGE, CollectionImage.class);
    List<CollectionImage> images = new ArrayList<CollectionImage>();
    images.add(mockCollection);
    images.add(mockCollection);
    images.add(mockCollection);

    JsonObject mockResponse = new JsonObject();
    mockResponse.add("images", new Gson().toJsonTree(images));

    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    String collectionId = "collection1";
    FindSimilarImagesOptions findImageOptions = new FindSimilarImagesOptions.Builder()
        .collectionId(collectionId)
        .image(new File(SINGLE_IMAGE_FILE))
        .limit(10)
        .build();
    List<CollectionImage> serviceResponse = service.findSimilarImages(findImageOptions).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = PATH_IMAGESFIND + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20
        + "&" + "limit=10" + "&" + "api_key=" + API_KEY;

    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    // serviceResponse is null?
    assertEquals(serviceResponse, null /*images*/);
  }

  /**
   * Test delete image.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteImage() throws IOException, InterruptedException {
    server.enqueue(new MockResponse().setBody(""));

    // execute request
    String collectionId = "collection1";
    String imageId = "image1";
    service.deleteCollectionImage(collectionId, imageId).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = String.format(PATH_IMAGE + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20
        + "&" + "api_key=" + API_KEY, imageId);

    assertEquals(path, request.getPath());
    assertEquals("DELETE", request.getMethod());
  }

}

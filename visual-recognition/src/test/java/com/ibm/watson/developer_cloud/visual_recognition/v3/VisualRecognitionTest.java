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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.AddCollectionImageOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.Classifier;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.Collection;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.CollectionImage;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.CollectionImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.CreateClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.CreateCollectionOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DeleteClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DeleteCollectionImageOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DeleteCollectionOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectFacesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.FindSimilarImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.GetClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.GetCollectionImageOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.GetCollectionOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ListClassifiersOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ListCollectionImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.UpdateClassifierOptions;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;

import org.junit.Before;
import org.junit.Test;

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
    ClassifiedImages mockResponse = loadFixture(FIXTURE_CLASSIFICATION, ClassifiedImages.class);
    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    String parameters = "{\"classifier_ids\":\"car\"}";

    // execute request
    File images = new File(IMAGE_FILE);
    ClassifyOptions options = new ClassifyOptions.Builder().imagesFile(images).parameters(parameters).build();
    ClassifiedImages serviceResponse = service.classify(options).execute();

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
    ClassifiedImages mockResponse = loadFixture(FIXTURE_CLASSIFICATION, ClassifiedImages.class);
    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    File images = new File(SINGLE_IMAGE_FILE);

    InputStream fileStream = new FileInputStream(images);

    String parameters = "{\"classifier_ids\":\"car\"}";

    ClassifyOptions options = new ClassifyOptions.Builder()
        .imagesFile(fileStream)
        .parameters(parameters)
        .build();
    ClassifiedImages serviceResponse = service.classify(options).execute();

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
    Classifier mockResponse = loadFixture(FIXTURE_CLASSIFIER, Classifier.class);

    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    File images = new File(IMAGE_FILE);
    String class1 = "class1";
    String classifierId = "foo123";

    UpdateClassifierOptions options =
        new UpdateClassifierOptions.Builder(classifierId).addClass(class1, images).build();

    Classifier serviceResponse = service.updateClassifier(options).execute();

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
    Classifier mockResponse = loadFixture(FIXTURE_CLASSIFIER, Classifier.class);

    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    // execute request
    File positiveImages = new File(IMAGE_FILE);
    File negativeImages = new File(IMAGE_FILE);
    String class1 = "class1";
    CreateClassifierOptions options = new CreateClassifierOptions.Builder()
        .name(class1)
        .addClass(class1, positiveImages)
        .negativeExamples(negativeImages)
        .build();

    Classifier serviceResponse = service.createClassifier(options).execute();

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
    DeleteClassifierOptions options = new DeleteClassifierOptions.Builder(class1).build();
    service.deleteClassifier(options).execute();

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
    DetectFacesOptions options = new DetectFacesOptions.Builder().imagesFile(images).build();

    DetectedFaces serviceResponse = service.detectFaces(options).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = PATH_DETECT_FACES + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20 + "&api_key="
        + API_KEY;

    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(serviceResponse, mockResponse);
    String contentDisposition = "Content-Disposition: form-data; name=\"images_file\"; filename=\"test.zip\"";
    String body = request.getBody().readUtf8();
    assertTrue(body.contains(contentDisposition));
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
      Classifier mockResponse = loadFixture(FIXTURE_CLASSIFIER, Classifier.class);

      server.enqueue(new MockResponse().setBody(mockResponse.toString()));

      // execute request
      String class1 = "class1";
      GetClassifierOptions getOptions = new GetClassifierOptions.Builder(class1).build();
      Classifier serviceResponse = service.getClassifier(getOptions).execute();

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
    Classifier mockClassifier = loadFixture(FIXTURE_CLASSIFIER, Classifier.class);
    List<Classifier> classifiers = new ArrayList<Classifier>();
    classifiers.add(mockClassifier);
    classifiers.add(mockClassifier);
    classifiers.add(mockClassifier);

    JsonObject mockResponse = new JsonObject();
    mockResponse.add("classifiers", new Gson().toJsonTree(classifiers));

    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    ListClassifiersOptions options = new ListClassifiersOptions.Builder().verbose(true).build();
    List<Classifier> serviceResponse = service.listClassifiers(options).execute().getClassifiers();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = PATH_CLASSIFIERS + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20
        + "&verbose=true&api_key=" + API_KEY;

    assertEquals(path, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(serviceResponse, classifiers);
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
    GetCollectionOptions getOptions = new GetCollectionOptions.Builder(collectionId).build();
    Collection serviceResponse = service.getCollection(getOptions).execute();

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
    List<Collection> serviceResponse = service.listCollections(null).execute().getCollections();

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
    DeleteCollectionOptions options = new DeleteCollectionOptions.Builder(collectionId).build();
    service.deleteCollection(options).execute();

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
    service.deleteCollection(null).execute();
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
    String collectionName = "collectionName1";
    CreateCollectionOptions createOptions = new CreateCollectionOptions.Builder(collectionName).build();
    Collection serviceResponse = service.createCollection(createOptions).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = String.format(PATH_COLLECTIONS + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20
        + "&" + "api_key=" + API_KEY);

    assertEquals(path, request.getPath());
    assertEquals("POST", request.getMethod());
    String body = request.getBody().readUtf8();
    assertTrue(body.contains("Content-Disposition: form-data; name=\"name\""));
    assertTrue(body.contains(collectionName));
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
    GetCollectionImageOptions getOptions = new GetCollectionImageOptions.Builder(collectionId, imageId).build();
    CollectionImage serviceResponse = service.getCollectionImage(getOptions).execute();

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
    GetCollectionImageOptions options = new GetCollectionImageOptions.Builder("null", null).build();
    CollectionImage serviceResponse = service.getCollectionImage(options).execute();
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
    ListCollectionImagesOptions options = new ListCollectionImagesOptions.Builder(collectionId).build();
    List<CollectionImage> serviceResponse = service.listCollectionImages(options).execute().getImages();

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
    CollectionImages serviceResponse = service.listCollectionImages(null).execute();
  }

  /**
   * Test create image.
   *
   * @throws IOException Signals that an I/O exception has occurred
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testCreateImage() throws IOException, InterruptedException {
    server.enqueue(new MockResponse().setBody("{ \"images\": [] }"));

    String metadataString = "{\"key1\":\"value1\"}";
    InputStream metadata = new ByteArrayInputStream(metadataString.getBytes());

    // execute request
    String collectionId = "collection1";
    AddCollectionImageOptions options = new AddCollectionImageOptions.Builder()
        .collectionId(collectionId)
        .imageFile(new File(SINGLE_IMAGE_FILE))
        .metadata(metadata)
        .build();

    service.addCollectionImage(options).execute();

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
    service.addCollectionImage(null).execute();
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
        .imageFile(new File(SINGLE_IMAGE_FILE))
        .limit(10)
        .build();
    List<CollectionImage> serviceResponse = service.findSimilarImages(findImageOptions).execute().getSimilarImages();

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
    DeleteCollectionImageOptions options = new DeleteCollectionImageOptions.Builder(collectionId, imageId).build();
    service.deleteCollectionImage(options).execute();

    // first request
    RecordedRequest request = server.takeRequest();
    String path = String.format(PATH_IMAGE + "?" + VERSION_DATE + "=" + VisualRecognition.VERSION_DATE_2016_05_20
        + "&" + "api_key=" + API_KEY, imageId);

    assertEquals(path, request.getPath());
    assertEquals("DELETE", request.getMethod());
  }

}

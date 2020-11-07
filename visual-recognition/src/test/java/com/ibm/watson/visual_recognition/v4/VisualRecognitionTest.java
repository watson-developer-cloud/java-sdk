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
package com.ibm.watson.visual_recognition.v4;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.visual_recognition.v4.model.AddImageTrainingDataOptions;
import com.ibm.watson.visual_recognition.v4.model.AddImagesOptions;
import com.ibm.watson.visual_recognition.v4.model.AnalyzeOptions;
import com.ibm.watson.visual_recognition.v4.model.AnalyzeResponse;
import com.ibm.watson.visual_recognition.v4.model.Collection;
import com.ibm.watson.visual_recognition.v4.model.CollectionsList;
import com.ibm.watson.visual_recognition.v4.model.CreateCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.DeleteCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.DeleteImageOptions;
import com.ibm.watson.visual_recognition.v4.model.DeleteObjectOptions;
import com.ibm.watson.visual_recognition.v4.model.DeleteUserDataOptions;
import com.ibm.watson.visual_recognition.v4.model.GetCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.GetImageDetailsOptions;
import com.ibm.watson.visual_recognition.v4.model.GetJpegImageOptions;
import com.ibm.watson.visual_recognition.v4.model.GetModelFileOptions;
import com.ibm.watson.visual_recognition.v4.model.GetObjectMetadataOptions;
import com.ibm.watson.visual_recognition.v4.model.GetTrainingUsageOptions;
import com.ibm.watson.visual_recognition.v4.model.ImageDetails;
import com.ibm.watson.visual_recognition.v4.model.ImageDetailsList;
import com.ibm.watson.visual_recognition.v4.model.ImageSummaryList;
import com.ibm.watson.visual_recognition.v4.model.ListCollectionsOptions;
import com.ibm.watson.visual_recognition.v4.model.ListImagesOptions;
import com.ibm.watson.visual_recognition.v4.model.ListObjectMetadataOptions;
import com.ibm.watson.visual_recognition.v4.model.Location;
import com.ibm.watson.visual_recognition.v4.model.ObjectMetadata;
import com.ibm.watson.visual_recognition.v4.model.ObjectMetadataList;
import com.ibm.watson.visual_recognition.v4.model.ObjectTrainingStatus;
import com.ibm.watson.visual_recognition.v4.model.TrainOptions;
import com.ibm.watson.visual_recognition.v4.model.TrainingDataObject;
import com.ibm.watson.visual_recognition.v4.model.TrainingDataObjects;
import com.ibm.watson.visual_recognition.v4.model.TrainingEvents;
import com.ibm.watson.visual_recognition.v4.model.TrainingStatus;
import com.ibm.watson.visual_recognition.v4.model.UpdateCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.UpdateObjectMetadata;
import com.ibm.watson.visual_recognition.v4.model.UpdateObjectMetadataOptions;
import com.ibm.watson.visual_recognition.v4.utils.TestUtilities;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/** Unit test class for the VisualRecognition service. */
public class VisualRecognitionTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected VisualRecognition visualRecognitionService;

  public void constructClientService() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    final Authenticator authenticator = new NoAuthAuthenticator();

    visualRecognitionService = new VisualRecognition(version, serviceName, authenticator);
    String url = server.url("/").toString();
    visualRecognitionService.setServiceUrl(url);
  }

  /** Negative Test - construct the service with a null authenticator. */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    new VisualRecognition(version, serviceName, null);
  }

  @Test
  public void testGetVersion() throws Throwable {
    constructClientService();
    assertEquals(visualRecognitionService.getVersion(), "testString");
  }

  @Test
  public void testAnalyzeWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"images\": [{\"source\": {\"type\": \"file\", \"filename\": \"filename\", \"archive_filename\": \"archiveFilename\", \"source_url\": \"sourceUrl\", \"resolved_url\": \"resolvedUrl\"}, \"dimensions\": {\"height\": 6, \"width\": 5}, \"objects\": {\"collections\": [{\"collection_id\": \"collectionId\", \"objects\": [{\"object\": \"object\", \"location\": {\"top\": 3, \"left\": 4, \"width\": 5, \"height\": 6}, \"score\": 5}]}]}, \"errors\": [{\"code\": \"invalid_field\", \"message\": \"message\", \"more_info\": \"moreInfo\", \"target\": {\"type\": \"field\", \"name\": \"name\"}}]}], \"warnings\": [{\"code\": \"invalid_field\", \"message\": \"message\", \"more_info\": \"moreInfo\"}], \"trace\": \"trace\"}";
    String analyzePath = "/v4/analyze";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AnalyzeOptions model
    AnalyzeOptions analyzeOptionsModel =
        new AnalyzeOptions.Builder()
            .collectionIds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .features(new java.util.ArrayList<String>(java.util.Arrays.asList("objects")))
            .imagesFile(mockListFileWithMetadata)
            .imageUrl(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .threshold(Float.valueOf("0.15"))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<AnalyzeResponse> response =
        visualRecognitionService.analyze(analyzeOptionsModel).execute();
    assertNotNull(response);
    AnalyzeResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, analyzePath);
  }

  // Test the analyze operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAnalyzeNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.analyze(null).execute();
  }

  @Test
  public void testCreateCollectionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"image_count\": 10, \"training_status\": {\"objects\": {\"ready\": false, \"in_progress\": true, \"data_changed\": false, \"latest_failed\": true, \"rscnn_ready\": true, \"description\": \"description\"}}}";
    String createCollectionPath = "/v4/collections";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ObjectTrainingStatus model
    ObjectTrainingStatus objectTrainingStatusModel =
        new ObjectTrainingStatus.Builder()
            .ready(true)
            .inProgress(true)
            .dataChanged(true)
            .latestFailed(true)
            .rscnnReady(true)
            .description("testString")
            .build();

    // Construct an instance of the TrainingStatus model
    TrainingStatus trainingStatusModel =
        new TrainingStatus.Builder().objects(objectTrainingStatusModel).build();

    // Construct an instance of the CreateCollectionOptions model
    CreateCollectionOptions createCollectionOptionsModel =
        new CreateCollectionOptions.Builder()
            .name("testString")
            .description("testString")
            .trainingStatus(trainingStatusModel)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Collection> response =
        visualRecognitionService.createCollection(createCollectionOptionsModel).execute();
    assertNotNull(response);
    Collection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createCollectionPath);
  }

  @Test
  public void testListCollectionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"collections\": [{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"image_count\": 10, \"training_status\": {\"objects\": {\"ready\": false, \"in_progress\": true, \"data_changed\": false, \"latest_failed\": true, \"rscnn_ready\": true, \"description\": \"description\"}}}]}";
    String listCollectionsPath = "/v4/collections";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListCollectionsOptions model
    ListCollectionsOptions listCollectionsOptionsModel = new ListCollectionsOptions();

    // Invoke operation with valid options model (positive test)
    Response<CollectionsList> response =
        visualRecognitionService.listCollections(listCollectionsOptionsModel).execute();
    assertNotNull(response);
    CollectionsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listCollectionsPath);
  }

  @Test
  public void testGetCollectionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"image_count\": 10, \"training_status\": {\"objects\": {\"ready\": false, \"in_progress\": true, \"data_changed\": false, \"latest_failed\": true, \"rscnn_ready\": true, \"description\": \"description\"}}}";
    String getCollectionPath = "/v4/collections/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCollectionOptions model
    GetCollectionOptions getCollectionOptionsModel =
        new GetCollectionOptions.Builder().collectionId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Collection> response =
        visualRecognitionService.getCollection(getCollectionOptionsModel).execute();
    assertNotNull(response);
    Collection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCollectionPath);
  }

  // Test the getCollection operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCollectionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.getCollection(null).execute();
  }

  @Test
  public void testUpdateCollectionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"image_count\": 10, \"training_status\": {\"objects\": {\"ready\": false, \"in_progress\": true, \"data_changed\": false, \"latest_failed\": true, \"rscnn_ready\": true, \"description\": \"description\"}}}";
    String updateCollectionPath = "/v4/collections/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ObjectTrainingStatus model
    ObjectTrainingStatus objectTrainingStatusModel =
        new ObjectTrainingStatus.Builder()
            .ready(true)
            .inProgress(true)
            .dataChanged(true)
            .latestFailed(true)
            .rscnnReady(true)
            .description("testString")
            .build();

    // Construct an instance of the TrainingStatus model
    TrainingStatus trainingStatusModel =
        new TrainingStatus.Builder().objects(objectTrainingStatusModel).build();

    // Construct an instance of the UpdateCollectionOptions model
    UpdateCollectionOptions updateCollectionOptionsModel =
        new UpdateCollectionOptions.Builder()
            .collectionId("testString")
            .name("testString")
            .description("testString")
            .trainingStatus(trainingStatusModel)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Collection> response =
        visualRecognitionService.updateCollection(updateCollectionOptionsModel).execute();
    assertNotNull(response);
    Collection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateCollectionPath);
  }

  // Test the updateCollection operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCollectionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.updateCollection(null).execute();
  }

  @Test
  public void testDeleteCollectionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteCollectionPath = "/v4/collections/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteCollectionOptions model
    DeleteCollectionOptions deleteCollectionOptionsModel =
        new DeleteCollectionOptions.Builder().collectionId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        visualRecognitionService.deleteCollection(deleteCollectionOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCollectionPath);
  }

  // Test the deleteCollection operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCollectionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.deleteCollection(null).execute();
  }

  @Test
  public void testGetModelFileWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "This is a mock binary response.";
    String getModelFilePath = "/v4/collections/testString/model";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/octet-stream")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetModelFileOptions model
    GetModelFileOptions getModelFileOptionsModel =
        new GetModelFileOptions.Builder()
            .collectionId("testString")
            .feature("objects")
            .modelFormat("rscnn")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response =
        visualRecognitionService.getModelFile(getModelFileOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("feature"), "objects");
    assertEquals(query.get("model_format"), "rscnn");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getModelFilePath);
  }

  // Test the getModelFile operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetModelFileNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.getModelFile(null).execute();
  }

  @Test
  public void testAddImagesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"images\": [{\"image_id\": \"imageId\", \"updated\": \"2019-01-01T12:00:00\", \"created\": \"2019-01-01T12:00:00\", \"source\": {\"type\": \"file\", \"filename\": \"filename\", \"archive_filename\": \"archiveFilename\", \"source_url\": \"sourceUrl\", \"resolved_url\": \"resolvedUrl\"}, \"dimensions\": {\"height\": 6, \"width\": 5}, \"errors\": [{\"code\": \"invalid_field\", \"message\": \"message\", \"more_info\": \"moreInfo\", \"target\": {\"type\": \"field\", \"name\": \"name\"}}], \"training_data\": {\"objects\": [{\"object\": \"object\", \"location\": {\"top\": 3, \"left\": 4, \"width\": 5, \"height\": 6}}]}}], \"warnings\": [{\"code\": \"invalid_field\", \"message\": \"message\", \"more_info\": \"moreInfo\"}], \"trace\": \"trace\"}";
    String addImagesPath = "/v4/collections/testString/images";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AddImagesOptions model
    AddImagesOptions addImagesOptionsModel =
        new AddImagesOptions.Builder()
            .collectionId("testString")
            .imagesFile(mockListFileWithMetadata)
            .imageUrl(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .trainingData(
                "\"{\"objects\":[{\"object\":\"2018-Fit\",\"location\":{\"left\":33,\"top\":8,\"width\":760,\"height\":419}}]}\"")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ImageDetailsList> response =
        visualRecognitionService.addImages(addImagesOptionsModel).execute();
    assertNotNull(response);
    ImageDetailsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addImagesPath);
  }

  // Test the addImages operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddImagesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.addImages(null).execute();
  }

  @Test
  public void testListImagesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"images\": [{\"image_id\": \"imageId\", \"updated\": \"2019-01-01T12:00:00\"}]}";
    String listImagesPath = "/v4/collections/testString/images";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListImagesOptions model
    ListImagesOptions listImagesOptionsModel =
        new ListImagesOptions.Builder().collectionId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<ImageSummaryList> response =
        visualRecognitionService.listImages(listImagesOptionsModel).execute();
    assertNotNull(response);
    ImageSummaryList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listImagesPath);
  }

  // Test the listImages operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListImagesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.listImages(null).execute();
  }

  @Test
  public void testGetImageDetailsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"image_id\": \"imageId\", \"updated\": \"2019-01-01T12:00:00\", \"created\": \"2019-01-01T12:00:00\", \"source\": {\"type\": \"file\", \"filename\": \"filename\", \"archive_filename\": \"archiveFilename\", \"source_url\": \"sourceUrl\", \"resolved_url\": \"resolvedUrl\"}, \"dimensions\": {\"height\": 6, \"width\": 5}, \"errors\": [{\"code\": \"invalid_field\", \"message\": \"message\", \"more_info\": \"moreInfo\", \"target\": {\"type\": \"field\", \"name\": \"name\"}}], \"training_data\": {\"objects\": [{\"object\": \"object\", \"location\": {\"top\": 3, \"left\": 4, \"width\": 5, \"height\": 6}}]}}";
    String getImageDetailsPath = "/v4/collections/testString/images/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetImageDetailsOptions model
    GetImageDetailsOptions getImageDetailsOptionsModel =
        new GetImageDetailsOptions.Builder()
            .collectionId("testString")
            .imageId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ImageDetails> response =
        visualRecognitionService.getImageDetails(getImageDetailsOptionsModel).execute();
    assertNotNull(response);
    ImageDetails responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getImageDetailsPath);
  }

  // Test the getImageDetails operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetImageDetailsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.getImageDetails(null).execute();
  }

  @Test
  public void testDeleteImageWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteImagePath = "/v4/collections/testString/images/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteImageOptions model
    DeleteImageOptions deleteImageOptionsModel =
        new DeleteImageOptions.Builder().collectionId("testString").imageId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        visualRecognitionService.deleteImage(deleteImageOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteImagePath);
  }

  // Test the deleteImage operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteImageNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.deleteImage(null).execute();
  }

  @Test
  public void testGetJpegImageWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "This is a mock binary response.";
    String getJpegImagePath = "/v4/collections/testString/images/testString/jpeg";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "image/jpeg")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetJpegImageOptions model
    GetJpegImageOptions getJpegImageOptionsModel =
        new GetJpegImageOptions.Builder()
            .collectionId("testString")
            .imageId("testString")
            .size("full")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response =
        visualRecognitionService.getJpegImage(getJpegImageOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("size"), "full");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getJpegImagePath);
  }

  // Test the getJpegImage operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetJpegImageNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.getJpegImage(null).execute();
  }

  @Test
  public void testListObjectMetadataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"object_count\": 11, \"objects\": [{\"object\": \"object\", \"count\": 5}]}";
    String listObjectMetadataPath = "/v4/collections/testString/objects";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListObjectMetadataOptions model
    ListObjectMetadataOptions listObjectMetadataOptionsModel =
        new ListObjectMetadataOptions.Builder().collectionId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<ObjectMetadataList> response =
        visualRecognitionService.listObjectMetadata(listObjectMetadataOptionsModel).execute();
    assertNotNull(response);
    ObjectMetadataList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listObjectMetadataPath);
  }

  // Test the listObjectMetadata operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListObjectMetadataNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.listObjectMetadata(null).execute();
  }

  @Test
  public void testUpdateObjectMetadataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"object\": \"object\", \"count\": 5}";
    String updateObjectMetadataPath = "/v4/collections/testString/objects/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateObjectMetadataOptions model
    UpdateObjectMetadataOptions updateObjectMetadataOptionsModel =
        new UpdateObjectMetadataOptions.Builder()
            .collectionId("testString")
            .object("testString")
            .newObject("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<UpdateObjectMetadata> response =
        visualRecognitionService.updateObjectMetadata(updateObjectMetadataOptionsModel).execute();
    assertNotNull(response);
    UpdateObjectMetadata responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateObjectMetadataPath);
  }

  // Test the updateObjectMetadata operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateObjectMetadataNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.updateObjectMetadata(null).execute();
  }

  @Test
  public void testGetObjectMetadataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"object\": \"object\", \"count\": 5}";
    String getObjectMetadataPath = "/v4/collections/testString/objects/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetObjectMetadataOptions model
    GetObjectMetadataOptions getObjectMetadataOptionsModel =
        new GetObjectMetadataOptions.Builder()
            .collectionId("testString")
            .object("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ObjectMetadata> response =
        visualRecognitionService.getObjectMetadata(getObjectMetadataOptionsModel).execute();
    assertNotNull(response);
    ObjectMetadata responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getObjectMetadataPath);
  }

  // Test the getObjectMetadata operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetObjectMetadataNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.getObjectMetadata(null).execute();
  }

  @Test
  public void testDeleteObjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteObjectPath = "/v4/collections/testString/objects/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteObjectOptions model
    DeleteObjectOptions deleteObjectOptionsModel =
        new DeleteObjectOptions.Builder().collectionId("testString").object("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        visualRecognitionService.deleteObject(deleteObjectOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteObjectPath);
  }

  // Test the deleteObject operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteObjectNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.deleteObject(null).execute();
  }

  @Test
  public void testTrainWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"image_count\": 10, \"training_status\": {\"objects\": {\"ready\": false, \"in_progress\": true, \"data_changed\": false, \"latest_failed\": true, \"rscnn_ready\": true, \"description\": \"description\"}}}";
    String trainPath = "/v4/collections/testString/train";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the TrainOptions model
    TrainOptions trainOptionsModel = new TrainOptions.Builder().collectionId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Collection> response = visualRecognitionService.train(trainOptionsModel).execute();
    assertNotNull(response);
    Collection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, trainPath);
  }

  // Test the train operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTrainNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.train(null).execute();
  }

  @Test
  public void testAddImageTrainingDataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"objects\": [{\"object\": \"object\", \"location\": {\"top\": 3, \"left\": 4, \"width\": 5, \"height\": 6}}]}";
    String addImageTrainingDataPath = "/v4/collections/testString/images/testString/training_data";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Location model
    Location locationModel =
        new Location.Builder()
            .top(Long.valueOf("26"))
            .left(Long.valueOf("26"))
            .width(Long.valueOf("26"))
            .height(Long.valueOf("26"))
            .build();

    // Construct an instance of the TrainingDataObject model
    TrainingDataObject trainingDataObjectModel =
        new TrainingDataObject.Builder().object("testString").location(locationModel).build();

    // Construct an instance of the AddImageTrainingDataOptions model
    AddImageTrainingDataOptions addImageTrainingDataOptionsModel =
        new AddImageTrainingDataOptions.Builder()
            .collectionId("testString")
            .imageId("testString")
            .objects(
                new java.util.ArrayList<TrainingDataObject>(
                    java.util.Arrays.asList(trainingDataObjectModel)))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TrainingDataObjects> response =
        visualRecognitionService.addImageTrainingData(addImageTrainingDataOptionsModel).execute();
    assertNotNull(response);
    TrainingDataObjects responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addImageTrainingDataPath);
  }

  // Test the addImageTrainingData operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddImageTrainingDataNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.addImageTrainingData(null).execute();
  }

  @Test
  public void testGetTrainingUsageWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"start_time\": \"2019-01-01T12:00:00\", \"end_time\": \"2019-01-01T12:00:00\", \"completed_events\": 15, \"trained_images\": 13, \"events\": [{\"type\": \"objects\", \"collection_id\": \"collectionId\", \"completion_time\": \"2019-01-01T12:00:00\", \"status\": \"failed\", \"image_count\": 10}]}";
    String getTrainingUsagePath = "/v4/training_usage";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetTrainingUsageOptions model
    GetTrainingUsageOptions getTrainingUsageOptionsModel =
        new GetTrainingUsageOptions.Builder()
            .startTime(TestUtilities.createMockDate("2019-01-01"))
            .endTime(TestUtilities.createMockDate("2019-01-01"))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TrainingEvents> response =
        visualRecognitionService.getTrainingUsage(getTrainingUsageOptionsModel).execute();
    assertNotNull(response);
    TrainingEvents responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTrainingUsagePath);
  }

  @Test
  public void testDeleteUserDataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteUserDataPath = "/v4/user_data";

    server.enqueue(new MockResponse().setResponseCode(202).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteUserDataOptions model
    DeleteUserDataOptions deleteUserDataOptionsModel =
        new DeleteUserDataOptions.Builder().customerId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        visualRecognitionService.deleteUserData(deleteUserDataOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("customer_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteUserDataPath);
  }

  // Test the deleteUserData operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteUserDataNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.deleteUserData(null).execute();
  }

  /** Initialize the server */
  @BeforeMethod
  public void setUpMockServer() {
    try {
      server = new MockWebServer();
      // register handler
      server.start();
    } catch (IOException err) {
      fail("Failed to instantiate mock web server");
    }
  }

  @AfterMethod
  public void tearDownMockServer() throws IOException {
    server.shutdown();
    visualRecognitionService = null;
  }
}

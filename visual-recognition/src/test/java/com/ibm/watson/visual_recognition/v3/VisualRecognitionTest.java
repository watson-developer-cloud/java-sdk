/*
 * (C) Copyright IBM Corp. 2021.
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

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.Classifier;
import com.ibm.watson.visual_recognition.v3.model.Classifiers;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;
import com.ibm.watson.visual_recognition.v3.model.CreateClassifierOptions;
import com.ibm.watson.visual_recognition.v3.model.DeleteClassifierOptions;
import com.ibm.watson.visual_recognition.v3.model.DeleteUserDataOptions;
import com.ibm.watson.visual_recognition.v3.model.GetClassifierOptions;
import com.ibm.watson.visual_recognition.v3.model.GetCoreMlModelOptions;
import com.ibm.watson.visual_recognition.v3.model.ListClassifiersOptions;
import com.ibm.watson.visual_recognition.v3.model.UpdateClassifierOptions;
import com.ibm.watson.visual_recognition.v3.utils.TestUtilities;
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
  public void testClassifyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"custom_classes\": 13, \"images_processed\": 15, \"images\": [{\"source_url\": \"sourceUrl\", \"resolved_url\": \"resolvedUrl\", \"image\": \"image\", \"error\": {\"code\": 4, \"description\": \"description\", \"error_id\": \"errorId\"}, \"classifiers\": [{\"name\": \"name\", \"classifier_id\": \"classifierId\", \"classes\": [{\"class\": \"xClass\", \"score\": 0, \"type_hierarchy\": \"typeHierarchy\"}]}]}], \"warnings\": [{\"warning_id\": \"warningId\", \"description\": \"description\"}]}";
    String classifyPath = "/v3/classify";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ClassifyOptions model
    ClassifyOptions classifyOptionsModel =
        new ClassifyOptions.Builder()
            .imagesFile(TestUtilities.createMockStream("This is a mock file."))
            .imagesFilename("testString")
            .imagesFileContentType("testString")
            .url("testString")
            .threshold(Float.valueOf("36.0"))
            .owners(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .classifierIds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .acceptLanguage("en")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ClassifiedImages> response =
        visualRecognitionService.classify(classifyOptionsModel).execute();
    assertNotNull(response);
    ClassifiedImages responseObj = response.getResult();
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
    assertEquals(parsedPath, classifyPath);
  }

  @Test
  public void testCreateClassifierWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"classifier_id\": \"classifierId\", \"name\": \"name\", \"owner\": \"owner\", \"status\": \"ready\", \"core_ml_enabled\": false, \"explanation\": \"explanation\", \"created\": \"2019-01-01T12:00:00.000Z\", \"classes\": [{\"class\": \"xClass\"}], \"retrained\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String createClassifierPath = "/v3/classifiers";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateClassifierOptions model
    CreateClassifierOptions createClassifierOptionsModel =
        new CreateClassifierOptions.Builder()
            .name("testString")
            .positiveExamples(mockStreamMap)
            .negativeExamples(TestUtilities.createMockStream("This is a mock file."))
            .negativeExamplesFilename("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Classifier> response =
        visualRecognitionService.createClassifier(createClassifierOptionsModel).execute();
    assertNotNull(response);
    Classifier responseObj = response.getResult();
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
    assertEquals(parsedPath, createClassifierPath);
  }

  // Test the createClassifier operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateClassifierNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.createClassifier(null).execute();
  }

  @Test
  public void testListClassifiersWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"classifiers\": [{\"classifier_id\": \"classifierId\", \"name\": \"name\", \"owner\": \"owner\", \"status\": \"ready\", \"core_ml_enabled\": false, \"explanation\": \"explanation\", \"created\": \"2019-01-01T12:00:00.000Z\", \"classes\": [{\"class\": \"xClass\"}], \"retrained\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}";
    String listClassifiersPath = "/v3/classifiers";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListClassifiersOptions model
    ListClassifiersOptions listClassifiersOptionsModel =
        new ListClassifiersOptions.Builder().verbose(true).build();

    // Invoke operation with valid options model (positive test)
    Response<Classifiers> response =
        visualRecognitionService.listClassifiers(listClassifiersOptionsModel).execute();
    assertNotNull(response);
    Classifiers responseObj = response.getResult();
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
    assertEquals(Boolean.valueOf(query.get("verbose")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listClassifiersPath);
  }

  @Test
  public void testGetClassifierWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"classifier_id\": \"classifierId\", \"name\": \"name\", \"owner\": \"owner\", \"status\": \"ready\", \"core_ml_enabled\": false, \"explanation\": \"explanation\", \"created\": \"2019-01-01T12:00:00.000Z\", \"classes\": [{\"class\": \"xClass\"}], \"retrained\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String getClassifierPath = "/v3/classifiers/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetClassifierOptions model
    GetClassifierOptions getClassifierOptionsModel =
        new GetClassifierOptions.Builder().classifierId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Classifier> response =
        visualRecognitionService.getClassifier(getClassifierOptionsModel).execute();
    assertNotNull(response);
    Classifier responseObj = response.getResult();
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
    assertEquals(parsedPath, getClassifierPath);
  }

  // Test the getClassifier operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetClassifierNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.getClassifier(null).execute();
  }

  @Test
  public void testUpdateClassifierWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"classifier_id\": \"classifierId\", \"name\": \"name\", \"owner\": \"owner\", \"status\": \"ready\", \"core_ml_enabled\": false, \"explanation\": \"explanation\", \"created\": \"2019-01-01T12:00:00.000Z\", \"classes\": [{\"class\": \"xClass\"}], \"retrained\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String updateClassifierPath = "/v3/classifiers/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateClassifierOptions model
    UpdateClassifierOptions updateClassifierOptionsModel =
        new UpdateClassifierOptions.Builder()
            .classifierId("testString")
            .positiveExamples(mockStreamMap)
            .negativeExamples(TestUtilities.createMockStream("This is a mock file."))
            .negativeExamplesFilename("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Classifier> response =
        visualRecognitionService.updateClassifier(updateClassifierOptionsModel).execute();
    assertNotNull(response);
    Classifier responseObj = response.getResult();
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
    assertEquals(parsedPath, updateClassifierPath);
  }

  // Test the updateClassifier operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateClassifierNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.updateClassifier(null).execute();
  }

  @Test
  public void testDeleteClassifierWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteClassifierPath = "/v3/classifiers/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteClassifierOptions model
    DeleteClassifierOptions deleteClassifierOptionsModel =
        new DeleteClassifierOptions.Builder().classifierId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        visualRecognitionService.deleteClassifier(deleteClassifierOptionsModel).execute();
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
    assertEquals(parsedPath, deleteClassifierPath);
  }

  // Test the deleteClassifier operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteClassifierNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.deleteClassifier(null).execute();
  }

  @Test
  public void testGetCoreMlModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "This is a mock binary response.";
    String getCoreMlModelPath = "/v3/classifiers/testString/core_ml_model";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/octet-stream")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCoreMlModelOptions model
    GetCoreMlModelOptions getCoreMlModelOptionsModel =
        new GetCoreMlModelOptions.Builder().classifierId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response =
        visualRecognitionService.getCoreMlModel(getCoreMlModelOptionsModel).execute();
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
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCoreMlModelPath);
  }

  // Test the getCoreMlModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCoreMlModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    visualRecognitionService.getCoreMlModel(null).execute();
  }

  @Test
  public void testDeleteUserDataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteUserDataPath = "/v3/user_data";

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

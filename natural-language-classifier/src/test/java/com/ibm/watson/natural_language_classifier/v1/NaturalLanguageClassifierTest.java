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

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
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
import com.ibm.watson.natural_language_classifier.v1.utils.TestUtilities;
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

/** Unit test class for the NaturalLanguageClassifier service. */
public class NaturalLanguageClassifierTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected NaturalLanguageClassifier naturalLanguageClassifierService;

  public void constructClientService() throws Throwable {
    final String serviceName = "testService";

    final Authenticator authenticator = new NoAuthAuthenticator();

    naturalLanguageClassifierService = new NaturalLanguageClassifier(serviceName, authenticator);
    String url = server.url("/").toString();
    naturalLanguageClassifierService.setServiceUrl(url);
  }

  /** Negative Test - construct the service with a null authenticator. */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new NaturalLanguageClassifier(serviceName, null);
  }

  @Test
  public void testClassifyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"classifier_id\": \"classifierId\", \"url\": \"url\", \"text\": \"text\", \"top_class\": \"topClass\", \"classes\": [{\"confidence\": 10, \"class_name\": \"className\"}]}";
    String classifyPath = "/v1/classifiers/testString/classify";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ClassifyOptions model
    ClassifyOptions classifyOptionsModel =
        new ClassifyOptions.Builder().classifierId("testString").text("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Classification> response =
        naturalLanguageClassifierService.classify(classifyOptionsModel).execute();
    assertNotNull(response);
    Classification responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, classifyPath);
  }

  // Test the classify operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testClassifyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    naturalLanguageClassifierService.classify(null).execute();
  }

  @Test
  public void testClassifyCollectionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"classifier_id\": \"classifierId\", \"url\": \"url\", \"collection\": [{\"text\": \"text\", \"top_class\": \"topClass\", \"classes\": [{\"confidence\": 10, \"class_name\": \"className\"}]}]}";
    String classifyCollectionPath = "/v1/classifiers/testString/classify_collection";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ClassifyInput model
    ClassifyInput classifyInputModel =
        new ClassifyInput.Builder().text("How hot will it be today?").build();

    // Construct an instance of the ClassifyCollectionOptions model
    ClassifyCollectionOptions classifyCollectionOptionsModel =
        new ClassifyCollectionOptions.Builder()
            .classifierId("testString")
            .collection(
                new java.util.ArrayList<ClassifyInput>(java.util.Arrays.asList(classifyInputModel)))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ClassificationCollection> response =
        naturalLanguageClassifierService
            .classifyCollection(classifyCollectionOptionsModel)
            .execute();
    assertNotNull(response);
    ClassificationCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, classifyCollectionPath);
  }

  // Test the classifyCollection operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testClassifyCollectionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    naturalLanguageClassifierService.classifyCollection(null).execute();
  }

  @Test
  public void testCreateClassifierWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"name\": \"name\", \"url\": \"url\", \"status\": \"Non Existent\", \"classifier_id\": \"classifierId\", \"created\": \"2019-01-01T12:00:00\", \"status_description\": \"statusDescription\", \"language\": \"language\"}";
    String createClassifierPath = "/v1/classifiers";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateClassifierOptions model
    CreateClassifierOptions createClassifierOptionsModel =
        new CreateClassifierOptions.Builder()
            .trainingMetadata(TestUtilities.createMockStream("This is a mock file."))
            .trainingData(TestUtilities.createMockStream("This is a mock file."))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Classifier> response =
        naturalLanguageClassifierService.createClassifier(createClassifierOptionsModel).execute();
    assertNotNull(response);
    Classifier responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

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
    naturalLanguageClassifierService.createClassifier(null).execute();
  }

  @Test
  public void testListClassifiersWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"classifiers\": [{\"name\": \"name\", \"url\": \"url\", \"status\": \"Non Existent\", \"classifier_id\": \"classifierId\", \"created\": \"2019-01-01T12:00:00\", \"status_description\": \"statusDescription\", \"language\": \"language\"}]}";
    String listClassifiersPath = "/v1/classifiers";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListClassifiersOptions model
    ListClassifiersOptions listClassifiersOptionsModel = new ListClassifiersOptions();

    // Invoke operation with valid options model (positive test)
    Response<ClassifierList> response =
        naturalLanguageClassifierService.listClassifiers(listClassifiersOptionsModel).execute();
    assertNotNull(response);
    ClassifierList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listClassifiersPath);
  }

  @Test
  public void testGetClassifierWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"name\": \"name\", \"url\": \"url\", \"status\": \"Non Existent\", \"classifier_id\": \"classifierId\", \"created\": \"2019-01-01T12:00:00\", \"status_description\": \"statusDescription\", \"language\": \"language\"}";
    String getClassifierPath = "/v1/classifiers/testString";

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
        naturalLanguageClassifierService.getClassifier(getClassifierOptionsModel).execute();
    assertNotNull(response);
    Classifier responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

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
    naturalLanguageClassifierService.getClassifier(null).execute();
  }

  @Test
  public void testDeleteClassifierWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteClassifierPath = "/v1/classifiers/testString";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteClassifierOptions model
    DeleteClassifierOptions deleteClassifierOptionsModel =
        new DeleteClassifierOptions.Builder().classifierId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        naturalLanguageClassifierService.deleteClassifier(deleteClassifierOptionsModel).execute();
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
    assertNull(query);

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
    naturalLanguageClassifierService.deleteClassifier(null).execute();
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
    naturalLanguageClassifierService = null;
  }
}

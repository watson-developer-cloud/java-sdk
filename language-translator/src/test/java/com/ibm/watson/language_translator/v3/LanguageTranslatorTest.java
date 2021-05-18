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
package com.ibm.watson.language_translator.v3;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.language_translator.v3.model.CreateModelOptions;
import com.ibm.watson.language_translator.v3.model.DeleteDocumentOptions;
import com.ibm.watson.language_translator.v3.model.DeleteModelOptions;
import com.ibm.watson.language_translator.v3.model.DeleteModelResult;
import com.ibm.watson.language_translator.v3.model.DocumentList;
import com.ibm.watson.language_translator.v3.model.DocumentStatus;
import com.ibm.watson.language_translator.v3.model.GetDocumentStatusOptions;
import com.ibm.watson.language_translator.v3.model.GetModelOptions;
import com.ibm.watson.language_translator.v3.model.GetTranslatedDocumentOptions;
import com.ibm.watson.language_translator.v3.model.IdentifiableLanguages;
import com.ibm.watson.language_translator.v3.model.IdentifiedLanguages;
import com.ibm.watson.language_translator.v3.model.IdentifyOptions;
import com.ibm.watson.language_translator.v3.model.Languages;
import com.ibm.watson.language_translator.v3.model.ListDocumentsOptions;
import com.ibm.watson.language_translator.v3.model.ListIdentifiableLanguagesOptions;
import com.ibm.watson.language_translator.v3.model.ListLanguagesOptions;
import com.ibm.watson.language_translator.v3.model.ListModelsOptions;
import com.ibm.watson.language_translator.v3.model.TranslateDocumentOptions;
import com.ibm.watson.language_translator.v3.model.TranslateOptions;
import com.ibm.watson.language_translator.v3.model.TranslationModel;
import com.ibm.watson.language_translator.v3.model.TranslationModels;
import com.ibm.watson.language_translator.v3.model.TranslationResult;
import com.ibm.watson.language_translator.v3.utils.TestUtilities;
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

/** Unit test class for the LanguageTranslator service. */
public class LanguageTranslatorTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected LanguageTranslator languageTranslatorService;

  public void constructClientService() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    final Authenticator authenticator = new NoAuthAuthenticator();

    languageTranslatorService = new LanguageTranslator(version, serviceName, authenticator);
    String url = server.url("/").toString();
    languageTranslatorService.setServiceUrl(url);
  }

  /** Negative Test - construct the service with a null authenticator. */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    new LanguageTranslator(version, serviceName, null);
  }

  @Test
  public void testGetVersion() throws Throwable {
    constructClientService();
    assertEquals(languageTranslatorService.getVersion(), "testString");
  }

  @Test
  public void testListLanguagesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"languages\": [{\"language\": \"language\", \"language_name\": \"languageName\", \"native_language_name\": \"nativeLanguageName\", \"country_code\": \"countryCode\", \"words_separated\": true, \"direction\": \"direction\", \"supported_as_source\": false, \"supported_as_target\": false, \"identifiable\": true}]}";
    String listLanguagesPath = "/v3/languages";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListLanguagesOptions model
    ListLanguagesOptions listLanguagesOptionsModel = new ListLanguagesOptions();

    // Invoke operation with valid options model (positive test)
    Response<Languages> response =
        languageTranslatorService.listLanguages(listLanguagesOptionsModel).execute();
    assertNotNull(response);
    Languages responseObj = response.getResult();
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
    assertEquals(parsedPath, listLanguagesPath);
  }

  @Test
  public void testTranslateWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"word_count\": 9, \"character_count\": 14, \"detected_language\": \"detectedLanguage\", \"detected_language_confidence\": 0, \"translations\": [{\"translation\": \"translation\"}]}";
    String translatePath = "/v3/translate";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the TranslateOptions model
    TranslateOptions translateOptionsModel =
        new TranslateOptions.Builder()
            .text(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .modelId("testString")
            .source("testString")
            .target("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TranslationResult> response =
        languageTranslatorService.translate(translateOptionsModel).execute();
    assertNotNull(response);
    TranslationResult responseObj = response.getResult();
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
    assertEquals(parsedPath, translatePath);
  }

  // Test the translate operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTranslateNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    languageTranslatorService.translate(null).execute();
  }

  @Test
  public void testListIdentifiableLanguagesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"languages\": [{\"language\": \"language\", \"name\": \"name\"}]}";
    String listIdentifiableLanguagesPath = "/v3/identifiable_languages";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListIdentifiableLanguagesOptions model
    ListIdentifiableLanguagesOptions listIdentifiableLanguagesOptionsModel =
        new ListIdentifiableLanguagesOptions();

    // Invoke operation with valid options model (positive test)
    Response<IdentifiableLanguages> response =
        languageTranslatorService
            .listIdentifiableLanguages(listIdentifiableLanguagesOptionsModel)
            .execute();
    assertNotNull(response);
    IdentifiableLanguages responseObj = response.getResult();
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
    assertEquals(parsedPath, listIdentifiableLanguagesPath);
  }

  @Test
  public void testIdentifyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"languages\": [{\"language\": \"language\", \"confidence\": 0}]}";
    String identifyPath = "/v3/identify";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the IdentifyOptions model
    IdentifyOptions identifyOptionsModel = new IdentifyOptions.Builder().text("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<IdentifiedLanguages> response =
        languageTranslatorService.identify(identifyOptionsModel).execute();
    assertNotNull(response);
    IdentifiedLanguages responseObj = response.getResult();
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
    assertEquals(parsedPath, identifyPath);
  }

  // Test the identify operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testIdentifyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    languageTranslatorService.identify(null).execute();
  }

  @Test
  public void testListModelsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"models\": [{\"model_id\": \"modelId\", \"name\": \"name\", \"source\": \"source\", \"target\": \"target\", \"base_model_id\": \"baseModelId\", \"domain\": \"domain\", \"customizable\": true, \"default_model\": true, \"owner\": \"owner\", \"status\": \"uploading\"}]}";
    String listModelsPath = "/v3/models";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListModelsOptions model
    ListModelsOptions listModelsOptionsModel =
        new ListModelsOptions.Builder()
            .source("testString")
            .target("testString")
            .xDefault(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TranslationModels> response =
        languageTranslatorService.listModels(listModelsOptionsModel).execute();
    assertNotNull(response);
    TranslationModels responseObj = response.getResult();
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
    assertEquals(query.get("source"), "testString");
    assertEquals(query.get("target"), "testString");
    assertEquals(Boolean.valueOf(query.get("default")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listModelsPath);
  }

  @Test
  public void testCreateModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"model_id\": \"modelId\", \"name\": \"name\", \"source\": \"source\", \"target\": \"target\", \"base_model_id\": \"baseModelId\", \"domain\": \"domain\", \"customizable\": true, \"default_model\": true, \"owner\": \"owner\", \"status\": \"uploading\"}";
    String createModelPath = "/v3/models";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateModelOptions model
    CreateModelOptions createModelOptionsModel =
        new CreateModelOptions.Builder()
            .baseModelId("testString")
            .forcedGlossary(TestUtilities.createMockStream("This is a mock file."))
            .parallelCorpus(TestUtilities.createMockStream("This is a mock file."))
            .name("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TranslationModel> response =
        languageTranslatorService.createModel(createModelOptionsModel).execute();
    assertNotNull(response);
    TranslationModel responseObj = response.getResult();
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
    assertEquals(query.get("base_model_id"), "testString");
    assertEquals(query.get("name"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createModelPath);
  }

  // Test the createModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    languageTranslatorService.createModel(null).execute();
  }

  @Test
  public void testDeleteModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"status\": \"status\"}";
    String deleteModelPath = "/v3/models/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteModelOptions model
    DeleteModelOptions deleteModelOptionsModel =
        new DeleteModelOptions.Builder().modelId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteModelResult> response =
        languageTranslatorService.deleteModel(deleteModelOptionsModel).execute();
    assertNotNull(response);
    DeleteModelResult responseObj = response.getResult();
    assertNotNull(responseObj);

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
    assertEquals(parsedPath, deleteModelPath);
  }

  // Test the deleteModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    languageTranslatorService.deleteModel(null).execute();
  }

  @Test
  public void testGetModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"model_id\": \"modelId\", \"name\": \"name\", \"source\": \"source\", \"target\": \"target\", \"base_model_id\": \"baseModelId\", \"domain\": \"domain\", \"customizable\": true, \"default_model\": true, \"owner\": \"owner\", \"status\": \"uploading\"}";
    String getModelPath = "/v3/models/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetModelOptions model
    GetModelOptions getModelOptionsModel =
        new GetModelOptions.Builder().modelId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<TranslationModel> response =
        languageTranslatorService.getModel(getModelOptionsModel).execute();
    assertNotNull(response);
    TranslationModel responseObj = response.getResult();
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
    assertEquals(parsedPath, getModelPath);
  }

  // Test the getModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    languageTranslatorService.getModel(null).execute();
  }

  @Test
  public void testListDocumentsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"documents\": [{\"document_id\": \"documentId\", \"filename\": \"filename\", \"status\": \"processing\", \"model_id\": \"modelId\", \"base_model_id\": \"baseModelId\", \"source\": \"source\", \"detected_language_confidence\": 0, \"target\": \"target\", \"created\": \"2019-01-01T12:00:00.000Z\", \"completed\": \"2019-01-01T12:00:00.000Z\", \"word_count\": 9, \"character_count\": 14}]}";
    String listDocumentsPath = "/v3/documents";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListDocumentsOptions model
    ListDocumentsOptions listDocumentsOptionsModel = new ListDocumentsOptions();

    // Invoke operation with valid options model (positive test)
    Response<DocumentList> response =
        languageTranslatorService.listDocuments(listDocumentsOptionsModel).execute();
    assertNotNull(response);
    DocumentList responseObj = response.getResult();
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
    assertEquals(parsedPath, listDocumentsPath);
  }

  @Test
  public void testTranslateDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"filename\": \"filename\", \"status\": \"processing\", \"model_id\": \"modelId\", \"base_model_id\": \"baseModelId\", \"source\": \"source\", \"detected_language_confidence\": 0, \"target\": \"target\", \"created\": \"2019-01-01T12:00:00.000Z\", \"completed\": \"2019-01-01T12:00:00.000Z\", \"word_count\": 9, \"character_count\": 14}";
    String translateDocumentPath = "/v3/documents";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the TranslateDocumentOptions model
    TranslateDocumentOptions translateDocumentOptionsModel =
        new TranslateDocumentOptions.Builder()
            .file(TestUtilities.createMockStream("This is a mock file."))
            .filename("testString")
            .fileContentType("application/powerpoint")
            .modelId("testString")
            .source("testString")
            .target("testString")
            .documentId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentStatus> response =
        languageTranslatorService.translateDocument(translateDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentStatus responseObj = response.getResult();
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
    assertEquals(parsedPath, translateDocumentPath);
  }

  // Test the translateDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTranslateDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    languageTranslatorService.translateDocument(null).execute();
  }

  @Test
  public void testGetDocumentStatusWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"filename\": \"filename\", \"status\": \"processing\", \"model_id\": \"modelId\", \"base_model_id\": \"baseModelId\", \"source\": \"source\", \"detected_language_confidence\": 0, \"target\": \"target\", \"created\": \"2019-01-01T12:00:00.000Z\", \"completed\": \"2019-01-01T12:00:00.000Z\", \"word_count\": 9, \"character_count\": 14}";
    String getDocumentStatusPath = "/v3/documents/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetDocumentStatusOptions model
    GetDocumentStatusOptions getDocumentStatusOptionsModel =
        new GetDocumentStatusOptions.Builder().documentId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentStatus> response =
        languageTranslatorService.getDocumentStatus(getDocumentStatusOptionsModel).execute();
    assertNotNull(response);
    DocumentStatus responseObj = response.getResult();
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
    assertEquals(parsedPath, getDocumentStatusPath);
  }

  // Test the getDocumentStatus operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentStatusNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    languageTranslatorService.getDocumentStatus(null).execute();
  }

  @Test
  public void testDeleteDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteDocumentPath = "/v3/documents/testString";

    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteDocumentOptions model
    DeleteDocumentOptions deleteDocumentOptionsModel =
        new DeleteDocumentOptions.Builder().documentId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        languageTranslatorService.deleteDocument(deleteDocumentOptionsModel).execute();
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
    assertEquals(parsedPath, deleteDocumentPath);
  }

  // Test the deleteDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    languageTranslatorService.deleteDocument(null).execute();
  }

  @Test
  public void testGetTranslatedDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "This is a mock binary response.";
    String getTranslatedDocumentPath = "/v3/documents/testString/translated_document";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/powerpoint")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetTranslatedDocumentOptions model
    GetTranslatedDocumentOptions getTranslatedDocumentOptionsModel =
        new GetTranslatedDocumentOptions.Builder()
            .documentId("testString")
            .accept("application/powerpoint")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response =
        languageTranslatorService
            .getTranslatedDocument(getTranslatedDocumentOptionsModel)
            .execute();
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
    assertEquals(parsedPath, getTranslatedDocumentPath);
  }

  // Test the getTranslatedDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTranslatedDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    languageTranslatorService.getTranslatedDocument(null).execute();
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
    languageTranslatorService = null;
  }
}

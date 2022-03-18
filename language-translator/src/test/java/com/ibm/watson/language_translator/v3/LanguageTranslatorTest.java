/*
 * (C) Copyright IBM Corp. 2022.
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

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    // Set mock values for global params
    String version = "2018-05-01";
    new LanguageTranslator(version, serviceName, null);
  }

  // Test the getter for the version global parameter
  @Test
  public void testGetVersion() throws Throwable {
    assertEquals(languageTranslatorService.getVersion(), "2018-05-01");
  }

  // Test the listLanguages operation with a valid options model parameter
  @Test
  public void testListLanguagesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"languages\": [{\"language\": \"language\", \"language_name\": \"languageName\", \"native_language_name\": \"nativeLanguageName\", \"country_code\": \"countryCode\", \"words_separated\": true, \"direction\": \"direction\", \"supported_as_source\": false, \"supported_as_target\": false, \"identifiable\": true}]}";
    String listLanguagesPath = "/v3/languages";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListLanguagesOptions model
    ListLanguagesOptions listLanguagesOptionsModel = new ListLanguagesOptions();

    // Invoke listLanguages() with a valid options model and verify the result
    Response<Languages> response =
        languageTranslatorService.listLanguages(listLanguagesOptionsModel).execute();
    assertNotNull(response);
    Languages responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listLanguagesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "2018-05-01");
  }

  // Test the listLanguages operation with and without retries enabled
  @Test
  public void testListLanguagesWRetries() throws Throwable {
    languageTranslatorService.enableRetries(4, 30);
    testListLanguagesWOptions();

    languageTranslatorService.disableRetries();
    testListLanguagesWOptions();
  }

  // Test the translate operation with a valid options model parameter
  @Test
  public void testTranslateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"word_count\": 9, \"character_count\": 14, \"detected_language\": \"detectedLanguage\", \"detected_language_confidence\": 0, \"translations\": [{\"translation\": \"translation\"}]}";
    String translatePath = "/v3/translate";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the TranslateOptions model
    TranslateOptions translateOptionsModel =
        new TranslateOptions.Builder()
            .text(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .modelId("testString")
            .source("testString")
            .target("testString")
            .build();

    // Invoke translate() with a valid options model and verify the result
    Response<TranslationResult> response =
        languageTranslatorService.translate(translateOptionsModel).execute();
    assertNotNull(response);
    TranslationResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, translatePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "2018-05-01");
  }

  // Test the translate operation with and without retries enabled
  @Test
  public void testTranslateWRetries() throws Throwable {
    languageTranslatorService.enableRetries(4, 30);
    testTranslateWOptions();

    languageTranslatorService.disableRetries();
    testTranslateWOptions();
  }

  // Test the translate operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTranslateNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    languageTranslatorService.translate(null).execute();
  }

  // Test the listIdentifiableLanguages operation with a valid options model parameter
  @Test
  public void testListIdentifiableLanguagesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"languages\": [{\"language\": \"language\", \"name\": \"name\"}]}";
    String listIdentifiableLanguagesPath = "/v3/identifiable_languages";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListIdentifiableLanguagesOptions model
    ListIdentifiableLanguagesOptions listIdentifiableLanguagesOptionsModel =
        new ListIdentifiableLanguagesOptions();

    // Invoke listIdentifiableLanguages() with a valid options model and verify the result
    Response<IdentifiableLanguages> response =
        languageTranslatorService
            .listIdentifiableLanguages(listIdentifiableLanguagesOptionsModel)
            .execute();
    assertNotNull(response);
    IdentifiableLanguages responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listIdentifiableLanguagesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "2018-05-01");
  }

  // Test the listIdentifiableLanguages operation with and without retries enabled
  @Test
  public void testListIdentifiableLanguagesWRetries() throws Throwable {
    languageTranslatorService.enableRetries(4, 30);
    testListIdentifiableLanguagesWOptions();

    languageTranslatorService.disableRetries();
    testListIdentifiableLanguagesWOptions();
  }

  // Test the identify operation with a valid options model parameter
  @Test
  public void testIdentifyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"languages\": [{\"language\": \"language\", \"confidence\": 0}]}";
    String identifyPath = "/v3/identify";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the IdentifyOptions model
    IdentifyOptions identifyOptionsModel = new IdentifyOptions.Builder().text("testString").build();

    // Invoke identify() with a valid options model and verify the result
    Response<IdentifiedLanguages> response =
        languageTranslatorService.identify(identifyOptionsModel).execute();
    assertNotNull(response);
    IdentifiedLanguages responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, identifyPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "2018-05-01");
  }

  // Test the identify operation with and without retries enabled
  @Test
  public void testIdentifyWRetries() throws Throwable {
    languageTranslatorService.enableRetries(4, 30);
    testIdentifyWOptions();

    languageTranslatorService.disableRetries();
    testIdentifyWOptions();
  }

  // Test the identify operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testIdentifyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    languageTranslatorService.identify(null).execute();
  }

  // Test the listModels operation with a valid options model parameter
  @Test
  public void testListModelsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"models\": [{\"model_id\": \"modelId\", \"name\": \"name\", \"source\": \"source\", \"target\": \"target\", \"base_model_id\": \"baseModelId\", \"domain\": \"domain\", \"customizable\": true, \"default_model\": true, \"owner\": \"owner\", \"status\": \"uploading\"}]}";
    String listModelsPath = "/v3/models";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListModelsOptions model
    ListModelsOptions listModelsOptionsModel =
        new ListModelsOptions.Builder()
            .source("testString")
            .target("testString")
            .xDefault(true)
            .build();

    // Invoke listModels() with a valid options model and verify the result
    Response<TranslationModels> response =
        languageTranslatorService.listModels(listModelsOptionsModel).execute();
    assertNotNull(response);
    TranslationModels responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listModelsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "2018-05-01");
    assertEquals(query.get("source"), "testString");
    assertEquals(query.get("target"), "testString");
    assertEquals(Boolean.valueOf(query.get("default")), Boolean.valueOf(true));
  }

  // Test the listModels operation with and without retries enabled
  @Test
  public void testListModelsWRetries() throws Throwable {
    languageTranslatorService.enableRetries(4, 30);
    testListModelsWOptions();

    languageTranslatorService.disableRetries();
    testListModelsWOptions();
  }

  // Test the createModel operation with a valid options model parameter
  @Test
  public void testCreateModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"model_id\": \"modelId\", \"name\": \"name\", \"source\": \"source\", \"target\": \"target\", \"base_model_id\": \"baseModelId\", \"domain\": \"domain\", \"customizable\": true, \"default_model\": true, \"owner\": \"owner\", \"status\": \"uploading\"}";
    String createModelPath = "/v3/models";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateModelOptions model
    CreateModelOptions createModelOptionsModel =
        new CreateModelOptions.Builder()
            .baseModelId("testString")
            .forcedGlossary(TestUtilities.createMockStream("This is a mock file."))
            .parallelCorpus(TestUtilities.createMockStream("This is a mock file."))
            .name("testString")
            .build();

    // Invoke createModel() with a valid options model and verify the result
    Response<TranslationModel> response =
        languageTranslatorService.createModel(createModelOptionsModel).execute();
    assertNotNull(response);
    TranslationModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "2018-05-01");
    assertEquals(query.get("base_model_id"), "testString");
    assertEquals(query.get("name"), "testString");
  }

  // Test the createModel operation with and without retries enabled
  @Test
  public void testCreateModelWRetries() throws Throwable {
    languageTranslatorService.enableRetries(4, 30);
    testCreateModelWOptions();

    languageTranslatorService.disableRetries();
    testCreateModelWOptions();
  }

  // Test the createModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    languageTranslatorService.createModel(null).execute();
  }

  // Test the deleteModel operation with a valid options model parameter
  @Test
  public void testDeleteModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"status\": \"status\"}";
    String deleteModelPath = "/v3/models/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the DeleteModelOptions model
    DeleteModelOptions deleteModelOptionsModel =
        new DeleteModelOptions.Builder().modelId("testString").build();

    // Invoke deleteModel() with a valid options model and verify the result
    Response<DeleteModelResult> response =
        languageTranslatorService.deleteModel(deleteModelOptionsModel).execute();
    assertNotNull(response);
    DeleteModelResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "2018-05-01");
  }

  // Test the deleteModel operation with and without retries enabled
  @Test
  public void testDeleteModelWRetries() throws Throwable {
    languageTranslatorService.enableRetries(4, 30);
    testDeleteModelWOptions();

    languageTranslatorService.disableRetries();
    testDeleteModelWOptions();
  }

  // Test the deleteModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    languageTranslatorService.deleteModel(null).execute();
  }

  // Test the getModel operation with a valid options model parameter
  @Test
  public void testGetModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"model_id\": \"modelId\", \"name\": \"name\", \"source\": \"source\", \"target\": \"target\", \"base_model_id\": \"baseModelId\", \"domain\": \"domain\", \"customizable\": true, \"default_model\": true, \"owner\": \"owner\", \"status\": \"uploading\"}";
    String getModelPath = "/v3/models/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetModelOptions model
    GetModelOptions getModelOptionsModel =
        new GetModelOptions.Builder().modelId("testString").build();

    // Invoke getModel() with a valid options model and verify the result
    Response<TranslationModel> response =
        languageTranslatorService.getModel(getModelOptionsModel).execute();
    assertNotNull(response);
    TranslationModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "2018-05-01");
  }

  // Test the getModel operation with and without retries enabled
  @Test
  public void testGetModelWRetries() throws Throwable {
    languageTranslatorService.enableRetries(4, 30);
    testGetModelWOptions();

    languageTranslatorService.disableRetries();
    testGetModelWOptions();
  }

  // Test the getModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    languageTranslatorService.getModel(null).execute();
  }

  // Test the listDocuments operation with a valid options model parameter
  @Test
  public void testListDocumentsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"documents\": [{\"document_id\": \"documentId\", \"filename\": \"filename\", \"status\": \"processing\", \"model_id\": \"modelId\", \"base_model_id\": \"baseModelId\", \"source\": \"source\", \"detected_language_confidence\": 0, \"target\": \"target\", \"created\": \"2019-01-01T12:00:00.000Z\", \"completed\": \"2019-01-01T12:00:00.000Z\", \"word_count\": 9, \"character_count\": 14}]}";
    String listDocumentsPath = "/v3/documents";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListDocumentsOptions model
    ListDocumentsOptions listDocumentsOptionsModel = new ListDocumentsOptions();

    // Invoke listDocuments() with a valid options model and verify the result
    Response<DocumentList> response =
        languageTranslatorService.listDocuments(listDocumentsOptionsModel).execute();
    assertNotNull(response);
    DocumentList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listDocumentsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "2018-05-01");
  }

  // Test the listDocuments operation with and without retries enabled
  @Test
  public void testListDocumentsWRetries() throws Throwable {
    languageTranslatorService.enableRetries(4, 30);
    testListDocumentsWOptions();

    languageTranslatorService.disableRetries();
    testListDocumentsWOptions();
  }

  // Test the translateDocument operation with a valid options model parameter
  @Test
  public void testTranslateDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"filename\": \"filename\", \"status\": \"processing\", \"model_id\": \"modelId\", \"base_model_id\": \"baseModelId\", \"source\": \"source\", \"detected_language_confidence\": 0, \"target\": \"target\", \"created\": \"2019-01-01T12:00:00.000Z\", \"completed\": \"2019-01-01T12:00:00.000Z\", \"word_count\": 9, \"character_count\": 14}";
    String translateDocumentPath = "/v3/documents";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

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

    // Invoke translateDocument() with a valid options model and verify the result
    Response<DocumentStatus> response =
        languageTranslatorService.translateDocument(translateDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentStatus responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, translateDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "2018-05-01");
  }

  // Test the translateDocument operation with and without retries enabled
  @Test
  public void testTranslateDocumentWRetries() throws Throwable {
    languageTranslatorService.enableRetries(4, 30);
    testTranslateDocumentWOptions();

    languageTranslatorService.disableRetries();
    testTranslateDocumentWOptions();
  }

  // Test the translateDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTranslateDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    languageTranslatorService.translateDocument(null).execute();
  }

  // Test the getDocumentStatus operation with a valid options model parameter
  @Test
  public void testGetDocumentStatusWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"filename\": \"filename\", \"status\": \"processing\", \"model_id\": \"modelId\", \"base_model_id\": \"baseModelId\", \"source\": \"source\", \"detected_language_confidence\": 0, \"target\": \"target\", \"created\": \"2019-01-01T12:00:00.000Z\", \"completed\": \"2019-01-01T12:00:00.000Z\", \"word_count\": 9, \"character_count\": 14}";
    String getDocumentStatusPath = "/v3/documents/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetDocumentStatusOptions model
    GetDocumentStatusOptions getDocumentStatusOptionsModel =
        new GetDocumentStatusOptions.Builder().documentId("testString").build();

    // Invoke getDocumentStatus() with a valid options model and verify the result
    Response<DocumentStatus> response =
        languageTranslatorService.getDocumentStatus(getDocumentStatusOptionsModel).execute();
    assertNotNull(response);
    DocumentStatus responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDocumentStatusPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "2018-05-01");
  }

  // Test the getDocumentStatus operation with and without retries enabled
  @Test
  public void testGetDocumentStatusWRetries() throws Throwable {
    languageTranslatorService.enableRetries(4, 30);
    testGetDocumentStatusWOptions();

    languageTranslatorService.disableRetries();
    testGetDocumentStatusWOptions();
  }

  // Test the getDocumentStatus operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentStatusNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    languageTranslatorService.getDocumentStatus(null).execute();
  }

  // Test the deleteDocument operation with a valid options model parameter
  @Test
  public void testDeleteDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteDocumentPath = "/v3/documents/testString";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteDocumentOptions model
    DeleteDocumentOptions deleteDocumentOptionsModel =
        new DeleteDocumentOptions.Builder().documentId("testString").build();

    // Invoke deleteDocument() with a valid options model and verify the result
    Response<Void> response =
        languageTranslatorService.deleteDocument(deleteDocumentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "2018-05-01");
  }

  // Test the deleteDocument operation with and without retries enabled
  @Test
  public void testDeleteDocumentWRetries() throws Throwable {
    languageTranslatorService.enableRetries(4, 30);
    testDeleteDocumentWOptions();

    languageTranslatorService.disableRetries();
    testDeleteDocumentWOptions();
  }

  // Test the deleteDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    languageTranslatorService.deleteDocument(null).execute();
  }

  // Test the getTranslatedDocument operation with a valid options model parameter
  @Test
  public void testGetTranslatedDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "This is a mock binary response.";
    String getTranslatedDocumentPath = "/v3/documents/testString/translated_document";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/powerpoint")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetTranslatedDocumentOptions model
    GetTranslatedDocumentOptions getTranslatedDocumentOptionsModel =
        new GetTranslatedDocumentOptions.Builder()
            .documentId("testString")
            .accept("application/powerpoint")
            .build();

    // Invoke getTranslatedDocument() with a valid options model and verify the result
    Response<InputStream> response =
        languageTranslatorService
            .getTranslatedDocument(getTranslatedDocumentOptionsModel)
            .execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);
    responseObj.close();

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTranslatedDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "2018-05-01");
  }

  // Test the getTranslatedDocument operation with and without retries enabled
  @Test
  public void testGetTranslatedDocumentWRetries() throws Throwable {
    languageTranslatorService.enableRetries(4, 30);
    testGetTranslatedDocumentWOptions();

    languageTranslatorService.disableRetries();
    testGetTranslatedDocumentWOptions();
  }

  // Test the getTranslatedDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTranslatedDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    languageTranslatorService.getTranslatedDocument(null).execute();
  }

  // Perform setup needed before each test method
  @BeforeMethod
  public void beforeEachTest() {
    // Start the mock server.
    try {
      server = new MockWebServer();
      server.start();
    } catch (IOException err) {
      fail("Failed to instantiate mock web server");
    }

    // Construct an instance of the service
    constructClientService();
  }

  // Perform tear down after each test method
  @AfterMethod
  public void afterEachTest() throws IOException {
    server.shutdown();
    languageTranslatorService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "2018-05-01";

    final Authenticator authenticator = new NoAuthAuthenticator();
    languageTranslatorService = new LanguageTranslator(version, serviceName, authenticator);
    String url = server.url("/").toString();
    languageTranslatorService.setServiceUrl(url);
  }
}

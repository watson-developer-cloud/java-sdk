/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.watson.natural_language_understanding.v1;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.natural_language_understanding.v1.model.CategoriesModel;
import com.ibm.watson.natural_language_understanding.v1.model.CategoriesModelList;
import com.ibm.watson.natural_language_understanding.v1.model.CategoriesOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ClassificationsModel;
import com.ibm.watson.natural_language_understanding.v1.model.ClassificationsModelList;
import com.ibm.watson.natural_language_understanding.v1.model.ClassificationsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ClassificationsTrainingParameters;
import com.ibm.watson.natural_language_understanding.v1.model.ConceptsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.CreateCategoriesModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.CreateClassificationsModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.DeleteCategoriesModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.DeleteClassificationsModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.DeleteModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.DeleteModelResults;
import com.ibm.watson.natural_language_understanding.v1.model.EmotionOptions;
import com.ibm.watson.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.natural_language_understanding.v1.model.Features;
import com.ibm.watson.natural_language_understanding.v1.model.GetCategoriesModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.GetClassificationsModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.KeywordsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ListCategoriesModelsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ListClassificationsModelsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ListModelsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ListModelsResults;
import com.ibm.watson.natural_language_understanding.v1.model.RelationsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.SemanticRolesOptions;
import com.ibm.watson.natural_language_understanding.v1.model.SentimentOptions;
import com.ibm.watson.natural_language_understanding.v1.model.SummarizationOptions;
import com.ibm.watson.natural_language_understanding.v1.model.SyntaxOptions;
import com.ibm.watson.natural_language_understanding.v1.model.SyntaxOptionsTokens;
import com.ibm.watson.natural_language_understanding.v1.model.UpdateCategoriesModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.UpdateClassificationsModelOptions;
import com.ibm.watson.natural_language_understanding.v1.utils.TestUtilities;
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

/** Unit test class for the NaturalLanguageUnderstanding service. */
public class NaturalLanguageUnderstandingTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected NaturalLanguageUnderstanding naturalLanguageUnderstandingService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    // Set mock values for global params
    String version = "testString";
    new NaturalLanguageUnderstanding(version, serviceName, null);
  }

  // Test the getter for the version global parameter
  @Test
  public void testGetVersion() throws Throwable {
    assertEquals(naturalLanguageUnderstandingService.getVersion(), "testString");
  }

  // Test the analyze operation with a valid options model parameter
  @Test
  public void testAnalyzeWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"language\": \"language\", \"analyzed_text\": \"analyzedText\", \"retrieved_url\": \"retrievedUrl\", \"usage\": {\"features\": 8, \"text_characters\": 14, \"text_units\": 9}, \"concepts\": [{\"text\": \"text\", \"relevance\": 9, \"dbpedia_resource\": \"dbpediaResource\"}], \"entities\": [{\"type\": \"type\", \"text\": \"text\", \"relevance\": 9, \"confidence\": 10, \"mentions\": [{\"text\": \"text\", \"location\": [8], \"confidence\": 10}], \"count\": 5, \"emotion\": {\"anger\": 5, \"disgust\": 7, \"fear\": 4, \"joy\": 3, \"sadness\": 7}, \"sentiment\": {\"score\": 5}, \"disambiguation\": {\"name\": \"name\", \"dbpedia_resource\": \"dbpediaResource\", \"subtype\": [\"subtype\"]}}], \"keywords\": [{\"count\": 5, \"relevance\": 9, \"text\": \"text\", \"emotion\": {\"anger\": 5, \"disgust\": 7, \"fear\": 4, \"joy\": 3, \"sadness\": 7}, \"sentiment\": {\"score\": 5}}], \"categories\": [{\"label\": \"label\", \"score\": 5, \"explanation\": {\"relevant_text\": [{\"text\": \"text\"}]}}], \"classifications\": [{\"class_name\": \"className\", \"confidence\": 10}], \"emotion\": {\"document\": {\"emotion\": {\"anger\": 5, \"disgust\": 7, \"fear\": 4, \"joy\": 3, \"sadness\": 7}}, \"targets\": [{\"text\": \"text\", \"emotion\": {\"anger\": 5, \"disgust\": 7, \"fear\": 4, \"joy\": 3, \"sadness\": 7}}]}, \"metadata\": {\"authors\": [{\"name\": \"name\"}], \"publication_date\": \"publicationDate\", \"title\": \"title\", \"image\": \"image\", \"feeds\": [{\"link\": \"link\"}]}, \"relations\": [{\"score\": 5, \"sentence\": \"sentence\", \"type\": \"type\", \"arguments\": [{\"entities\": [{\"text\": \"text\", \"type\": \"type\"}], \"location\": [8], \"text\": \"text\"}]}], \"semantic_roles\": [{\"sentence\": \"sentence\", \"subject\": {\"text\": \"text\", \"entities\": [{\"type\": \"type\", \"text\": \"text\"}], \"keywords\": [{\"text\": \"text\"}]}, \"action\": {\"text\": \"text\", \"normalized\": \"normalized\", \"verb\": {\"text\": \"text\", \"tense\": \"tense\"}}, \"object\": {\"text\": \"text\", \"keywords\": [{\"text\": \"text\"}]}}], \"sentiment\": {\"document\": {\"label\": \"label\", \"score\": 5}, \"targets\": [{\"text\": \"text\", \"score\": 5}]}, \"syntax\": {\"tokens\": [{\"text\": \"text\", \"part_of_speech\": \"ADJ\", \"location\": [8], \"lemma\": \"lemma\"}], \"sentences\": [{\"text\": \"text\", \"location\": [8]}]}}";
    String analyzePath = "/v1/analyze";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ClassificationsOptions model
    ClassificationsOptions classificationsOptionsModel =
        new ClassificationsOptions.Builder().model("testString").build();

    // Construct an instance of the ConceptsOptions model
    ConceptsOptions conceptsOptionsModel =
        new ConceptsOptions.Builder().limit(Long.valueOf("50")).build();

    // Construct an instance of the EmotionOptions model
    EmotionOptions emotionOptionsModel =
        new EmotionOptions.Builder()
            .document(true)
            .targets(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the EntitiesOptions model
    EntitiesOptions entitiesOptionsModel =
        new EntitiesOptions.Builder()
            .limit(Long.valueOf("250"))
            .mentions(false)
            .model("testString")
            .sentiment(false)
            .emotion(false)
            .build();

    // Construct an instance of the KeywordsOptions model
    KeywordsOptions keywordsOptionsModel =
        new KeywordsOptions.Builder()
            .limit(Long.valueOf("250"))
            .sentiment(false)
            .emotion(false)
            .build();

    // Construct an instance of the RelationsOptions model
    RelationsOptions relationsOptionsModel =
        new RelationsOptions.Builder().model("testString").build();

    // Construct an instance of the SemanticRolesOptions model
    SemanticRolesOptions semanticRolesOptionsModel =
        new SemanticRolesOptions.Builder()
            .limit(Long.valueOf("26"))
            .keywords(false)
            .entities(false)
            .build();

    // Construct an instance of the SentimentOptions model
    SentimentOptions sentimentOptionsModel =
        new SentimentOptions.Builder()
            .document(true)
            .targets(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the SummarizationOptions model
    SummarizationOptions summarizationOptionsModel =
        new SummarizationOptions.Builder().limit(Long.valueOf("10")).build();

    // Construct an instance of the CategoriesOptions model
    CategoriesOptions categoriesOptionsModel =
        new CategoriesOptions.Builder()
            .explanation(false)
            .limit(Long.valueOf("10"))
            .model("testString")
            .build();

    // Construct an instance of the SyntaxOptionsTokens model
    SyntaxOptionsTokens syntaxOptionsTokensModel =
        new SyntaxOptionsTokens.Builder().lemma(true).partOfSpeech(true).build();

    // Construct an instance of the SyntaxOptions model
    SyntaxOptions syntaxOptionsModel =
        new SyntaxOptions.Builder().tokens(syntaxOptionsTokensModel).sentences(true).build();

    // Construct an instance of the Features model
    Features featuresModel =
        new Features.Builder()
            .classifications(classificationsOptionsModel)
            .concepts(conceptsOptionsModel)
            .emotion(emotionOptionsModel)
            .entities(entitiesOptionsModel)
            .keywords(keywordsOptionsModel)
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .relations(relationsOptionsModel)
            .semanticRoles(semanticRolesOptionsModel)
            .sentiment(sentimentOptionsModel)
            .summarization(summarizationOptionsModel)
            .categories(categoriesOptionsModel)
            .syntax(syntaxOptionsModel)
            .build();

    // Construct an instance of the AnalyzeOptions model
    AnalyzeOptions analyzeOptionsModel =
        new AnalyzeOptions.Builder()
            .features(featuresModel)
            .text("testString")
            .html("testString")
            .url("testString")
            .clean(true)
            .xpath("testString")
            .fallbackToRaw(true)
            .returnAnalyzedText(false)
            .language("testString")
            .limitTextCharacters(Long.valueOf("26"))
            .build();

    // Invoke analyze() with a valid options model and verify the result
    Response<AnalysisResults> response =
        naturalLanguageUnderstandingService.analyze(analyzeOptionsModel).execute();
    assertNotNull(response);
    AnalysisResults responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, analyzePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the analyze operation with and without retries enabled
  @Test
  public void testAnalyzeWRetries() throws Throwable {
    naturalLanguageUnderstandingService.enableRetries(4, 30);
    testAnalyzeWOptions();

    naturalLanguageUnderstandingService.disableRetries();
    testAnalyzeWOptions();
  }

  // Test the analyze operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAnalyzeNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    naturalLanguageUnderstandingService.analyze(null).execute();
  }

  // Test the listModels operation with a valid options model parameter
  @Test
  public void testListModelsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"models\": [{\"status\": \"starting\", \"model_id\": \"modelId\", \"language\": \"language\", \"description\": \"description\", \"workspace_id\": \"workspaceId\", \"model_version\": \"modelVersion\", \"version\": \"version\", \"version_description\": \"versionDescription\", \"created\": \"2019-01-01T12:00:00.000Z\"}]}";
    String listModelsPath = "/v1/models";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListModelsOptions model
    ListModelsOptions listModelsOptionsModel = new ListModelsOptions();

    // Invoke listModels() with a valid options model and verify the result
    Response<ListModelsResults> response =
        naturalLanguageUnderstandingService.listModels(listModelsOptionsModel).execute();
    assertNotNull(response);
    ListModelsResults responseObj = response.getResult();
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
    assertEquals(query.get("version"), "testString");
  }

  // Test the listModels operation with and without retries enabled
  @Test
  public void testListModelsWRetries() throws Throwable {
    naturalLanguageUnderstandingService.enableRetries(4, 30);
    testListModelsWOptions();

    naturalLanguageUnderstandingService.disableRetries();
    testListModelsWOptions();
  }

  // Test the deleteModel operation with a valid options model parameter
  @Test
  public void testDeleteModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"deleted\": \"deleted\"}";
    String deleteModelPath = "/v1/models/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the DeleteModelOptions model
    DeleteModelOptions deleteModelOptionsModel =
        new DeleteModelOptions.Builder().modelId("testString").build();

    // Invoke deleteModel() with a valid options model and verify the result
    Response<DeleteModelResults> response =
        naturalLanguageUnderstandingService.deleteModel(deleteModelOptionsModel).execute();
    assertNotNull(response);
    DeleteModelResults responseObj = response.getResult();
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
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteModel operation with and without retries enabled
  @Test
  public void testDeleteModelWRetries() throws Throwable {
    naturalLanguageUnderstandingService.enableRetries(4, 30);
    testDeleteModelWOptions();

    naturalLanguageUnderstandingService.disableRetries();
    testDeleteModelWOptions();
  }

  // Test the deleteModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    naturalLanguageUnderstandingService.deleteModel(null).execute();
  }

  // Test the createCategoriesModel operation with a valid options model parameter
  @Test
  public void testCreateCategoriesModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"user_metadata\": {\"mapKey\": \"unknown property type: inner\"}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\", \"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"notices\": [{\"message\": \"message\"}], \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\"}";
    String createCategoriesModelPath = "/v1/models/categories";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateCategoriesModelOptions model
    CreateCategoriesModelOptions createCategoriesModelOptionsModel =
        new CreateCategoriesModelOptions.Builder()
            .language("testString")
            .trainingData(TestUtilities.createMockStream("This is a mock file."))
            .trainingDataContentType("json")
            .name("testString")
            .description("testString")
            .modelVersion("testString")
            .workspaceId("testString")
            .versionDescription("testString")
            .build();

    // Invoke createCategoriesModel() with a valid options model and verify the result
    Response<CategoriesModel> response =
        naturalLanguageUnderstandingService
            .createCategoriesModel(createCategoriesModelOptionsModel)
            .execute();
    assertNotNull(response);
    CategoriesModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createCategoriesModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createCategoriesModel operation with and without retries enabled
  @Test
  public void testCreateCategoriesModelWRetries() throws Throwable {
    naturalLanguageUnderstandingService.enableRetries(4, 30);
    testCreateCategoriesModelWOptions();

    naturalLanguageUnderstandingService.disableRetries();
    testCreateCategoriesModelWOptions();
  }

  // Test the createCategoriesModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCategoriesModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    naturalLanguageUnderstandingService.createCategoriesModel(null).execute();
  }

  // Test the listCategoriesModels operation with a valid options model parameter
  @Test
  public void testListCategoriesModelsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"models\": [{\"name\": \"name\", \"user_metadata\": {\"mapKey\": \"unknown property type: inner\"}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\", \"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"notices\": [{\"message\": \"message\"}], \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\"}]}";
    String listCategoriesModelsPath = "/v1/models/categories";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListCategoriesModelsOptions model
    ListCategoriesModelsOptions listCategoriesModelsOptionsModel =
        new ListCategoriesModelsOptions();

    // Invoke listCategoriesModels() with a valid options model and verify the result
    Response<CategoriesModelList> response =
        naturalLanguageUnderstandingService
            .listCategoriesModels(listCategoriesModelsOptionsModel)
            .execute();
    assertNotNull(response);
    CategoriesModelList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listCategoriesModelsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the listCategoriesModels operation with and without retries enabled
  @Test
  public void testListCategoriesModelsWRetries() throws Throwable {
    naturalLanguageUnderstandingService.enableRetries(4, 30);
    testListCategoriesModelsWOptions();

    naturalLanguageUnderstandingService.disableRetries();
    testListCategoriesModelsWOptions();
  }

  // Test the getCategoriesModel operation with a valid options model parameter
  @Test
  public void testGetCategoriesModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"user_metadata\": {\"mapKey\": \"unknown property type: inner\"}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\", \"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"notices\": [{\"message\": \"message\"}], \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\"}";
    String getCategoriesModelPath = "/v1/models/categories/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetCategoriesModelOptions model
    GetCategoriesModelOptions getCategoriesModelOptionsModel =
        new GetCategoriesModelOptions.Builder().modelId("testString").build();

    // Invoke getCategoriesModel() with a valid options model and verify the result
    Response<CategoriesModel> response =
        naturalLanguageUnderstandingService
            .getCategoriesModel(getCategoriesModelOptionsModel)
            .execute();
    assertNotNull(response);
    CategoriesModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCategoriesModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getCategoriesModel operation with and without retries enabled
  @Test
  public void testGetCategoriesModelWRetries() throws Throwable {
    naturalLanguageUnderstandingService.enableRetries(4, 30);
    testGetCategoriesModelWOptions();

    naturalLanguageUnderstandingService.disableRetries();
    testGetCategoriesModelWOptions();
  }

  // Test the getCategoriesModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCategoriesModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    naturalLanguageUnderstandingService.getCategoriesModel(null).execute();
  }

  // Test the updateCategoriesModel operation with a valid options model parameter
  @Test
  public void testUpdateCategoriesModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"user_metadata\": {\"mapKey\": \"unknown property type: inner\"}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\", \"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"notices\": [{\"message\": \"message\"}], \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\"}";
    String updateCategoriesModelPath = "/v1/models/categories/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the UpdateCategoriesModelOptions model
    UpdateCategoriesModelOptions updateCategoriesModelOptionsModel =
        new UpdateCategoriesModelOptions.Builder()
            .modelId("testString")
            .language("testString")
            .trainingData(TestUtilities.createMockStream("This is a mock file."))
            .trainingDataContentType("json")
            .name("testString")
            .description("testString")
            .modelVersion("testString")
            .workspaceId("testString")
            .versionDescription("testString")
            .build();

    // Invoke updateCategoriesModel() with a valid options model and verify the result
    Response<CategoriesModel> response =
        naturalLanguageUnderstandingService
            .updateCategoriesModel(updateCategoriesModelOptionsModel)
            .execute();
    assertNotNull(response);
    CategoriesModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateCategoriesModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the updateCategoriesModel operation with and without retries enabled
  @Test
  public void testUpdateCategoriesModelWRetries() throws Throwable {
    naturalLanguageUnderstandingService.enableRetries(4, 30);
    testUpdateCategoriesModelWOptions();

    naturalLanguageUnderstandingService.disableRetries();
    testUpdateCategoriesModelWOptions();
  }

  // Test the updateCategoriesModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCategoriesModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    naturalLanguageUnderstandingService.updateCategoriesModel(null).execute();
  }

  // Test the deleteCategoriesModel operation with a valid options model parameter
  @Test
  public void testDeleteCategoriesModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"deleted\": \"deleted\"}";
    String deleteCategoriesModelPath = "/v1/models/categories/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the DeleteCategoriesModelOptions model
    DeleteCategoriesModelOptions deleteCategoriesModelOptionsModel =
        new DeleteCategoriesModelOptions.Builder().modelId("testString").build();

    // Invoke deleteCategoriesModel() with a valid options model and verify the result
    Response<DeleteModelResults> response =
        naturalLanguageUnderstandingService
            .deleteCategoriesModel(deleteCategoriesModelOptionsModel)
            .execute();
    assertNotNull(response);
    DeleteModelResults responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCategoriesModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteCategoriesModel operation with and without retries enabled
  @Test
  public void testDeleteCategoriesModelWRetries() throws Throwable {
    naturalLanguageUnderstandingService.enableRetries(4, 30);
    testDeleteCategoriesModelWOptions();

    naturalLanguageUnderstandingService.disableRetries();
    testDeleteCategoriesModelWOptions();
  }

  // Test the deleteCategoriesModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCategoriesModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    naturalLanguageUnderstandingService.deleteCategoriesModel(null).execute();
  }

  // Test the createClassificationsModel operation with a valid options model parameter
  @Test
  public void testCreateClassificationsModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"user_metadata\": {\"mapKey\": \"unknown property type: inner\"}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\", \"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"notices\": [{\"message\": \"message\"}], \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\"}";
    String createClassificationsModelPath = "/v1/models/classifications";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the ClassificationsTrainingParameters model
    ClassificationsTrainingParameters classificationsTrainingParametersModel =
        new ClassificationsTrainingParameters.Builder().modelType("single_label").build();

    // Construct an instance of the CreateClassificationsModelOptions model
    CreateClassificationsModelOptions createClassificationsModelOptionsModel =
        new CreateClassificationsModelOptions.Builder()
            .language("testString")
            .trainingData(TestUtilities.createMockStream("This is a mock file."))
            .trainingDataContentType("json")
            .name("testString")
            .description("testString")
            .modelVersion("testString")
            .workspaceId("testString")
            .versionDescription("testString")
            .trainingParameters(classificationsTrainingParametersModel)
            .build();

    // Invoke createClassificationsModel() with a valid options model and verify the result
    Response<ClassificationsModel> response =
        naturalLanguageUnderstandingService
            .createClassificationsModel(createClassificationsModelOptionsModel)
            .execute();
    assertNotNull(response);
    ClassificationsModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createClassificationsModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createClassificationsModel operation with and without retries enabled
  @Test
  public void testCreateClassificationsModelWRetries() throws Throwable {
    naturalLanguageUnderstandingService.enableRetries(4, 30);
    testCreateClassificationsModelWOptions();

    naturalLanguageUnderstandingService.disableRetries();
    testCreateClassificationsModelWOptions();
  }

  // Test the createClassificationsModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateClassificationsModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    naturalLanguageUnderstandingService.createClassificationsModel(null).execute();
  }

  // Test the listClassificationsModels operation with a valid options model parameter
  @Test
  public void testListClassificationsModelsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"models\": [{\"name\": \"name\", \"user_metadata\": {\"mapKey\": \"unknown property type: inner\"}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\", \"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"notices\": [{\"message\": \"message\"}], \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\"}]}";
    String listClassificationsModelsPath = "/v1/models/classifications";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListClassificationsModelsOptions model
    ListClassificationsModelsOptions listClassificationsModelsOptionsModel =
        new ListClassificationsModelsOptions();

    // Invoke listClassificationsModels() with a valid options model and verify the result
    Response<ClassificationsModelList> response =
        naturalLanguageUnderstandingService
            .listClassificationsModels(listClassificationsModelsOptionsModel)
            .execute();
    assertNotNull(response);
    ClassificationsModelList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listClassificationsModelsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the listClassificationsModels operation with and without retries enabled
  @Test
  public void testListClassificationsModelsWRetries() throws Throwable {
    naturalLanguageUnderstandingService.enableRetries(4, 30);
    testListClassificationsModelsWOptions();

    naturalLanguageUnderstandingService.disableRetries();
    testListClassificationsModelsWOptions();
  }

  // Test the getClassificationsModel operation with a valid options model parameter
  @Test
  public void testGetClassificationsModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"user_metadata\": {\"mapKey\": \"unknown property type: inner\"}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\", \"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"notices\": [{\"message\": \"message\"}], \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\"}";
    String getClassificationsModelPath = "/v1/models/classifications/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetClassificationsModelOptions model
    GetClassificationsModelOptions getClassificationsModelOptionsModel =
        new GetClassificationsModelOptions.Builder().modelId("testString").build();

    // Invoke getClassificationsModel() with a valid options model and verify the result
    Response<ClassificationsModel> response =
        naturalLanguageUnderstandingService
            .getClassificationsModel(getClassificationsModelOptionsModel)
            .execute();
    assertNotNull(response);
    ClassificationsModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getClassificationsModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getClassificationsModel operation with and without retries enabled
  @Test
  public void testGetClassificationsModelWRetries() throws Throwable {
    naturalLanguageUnderstandingService.enableRetries(4, 30);
    testGetClassificationsModelWOptions();

    naturalLanguageUnderstandingService.disableRetries();
    testGetClassificationsModelWOptions();
  }

  // Test the getClassificationsModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetClassificationsModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    naturalLanguageUnderstandingService.getClassificationsModel(null).execute();
  }

  // Test the updateClassificationsModel operation with a valid options model parameter
  @Test
  public void testUpdateClassificationsModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"name\": \"name\", \"user_metadata\": {\"mapKey\": \"unknown property type: inner\"}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\", \"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"notices\": [{\"message\": \"message\"}], \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\"}";
    String updateClassificationsModelPath = "/v1/models/classifications/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ClassificationsTrainingParameters model
    ClassificationsTrainingParameters classificationsTrainingParametersModel =
        new ClassificationsTrainingParameters.Builder().modelType("single_label").build();

    // Construct an instance of the UpdateClassificationsModelOptions model
    UpdateClassificationsModelOptions updateClassificationsModelOptionsModel =
        new UpdateClassificationsModelOptions.Builder()
            .modelId("testString")
            .language("testString")
            .trainingData(TestUtilities.createMockStream("This is a mock file."))
            .trainingDataContentType("json")
            .name("testString")
            .description("testString")
            .modelVersion("testString")
            .workspaceId("testString")
            .versionDescription("testString")
            .trainingParameters(classificationsTrainingParametersModel)
            .build();

    // Invoke updateClassificationsModel() with a valid options model and verify the result
    Response<ClassificationsModel> response =
        naturalLanguageUnderstandingService
            .updateClassificationsModel(updateClassificationsModelOptionsModel)
            .execute();
    assertNotNull(response);
    ClassificationsModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateClassificationsModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the updateClassificationsModel operation with and without retries enabled
  @Test
  public void testUpdateClassificationsModelWRetries() throws Throwable {
    naturalLanguageUnderstandingService.enableRetries(4, 30);
    testUpdateClassificationsModelWOptions();

    naturalLanguageUnderstandingService.disableRetries();
    testUpdateClassificationsModelWOptions();
  }

  // Test the updateClassificationsModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateClassificationsModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    naturalLanguageUnderstandingService.updateClassificationsModel(null).execute();
  }

  // Test the deleteClassificationsModel operation with a valid options model parameter
  @Test
  public void testDeleteClassificationsModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"deleted\": \"deleted\"}";
    String deleteClassificationsModelPath = "/v1/models/classifications/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the DeleteClassificationsModelOptions model
    DeleteClassificationsModelOptions deleteClassificationsModelOptionsModel =
        new DeleteClassificationsModelOptions.Builder().modelId("testString").build();

    // Invoke deleteClassificationsModel() with a valid options model and verify the result
    Response<DeleteModelResults> response =
        naturalLanguageUnderstandingService
            .deleteClassificationsModel(deleteClassificationsModelOptionsModel)
            .execute();
    assertNotNull(response);
    DeleteModelResults responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteClassificationsModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteClassificationsModel operation with and without retries enabled
  @Test
  public void testDeleteClassificationsModelWRetries() throws Throwable {
    naturalLanguageUnderstandingService.enableRetries(4, 30);
    testDeleteClassificationsModelWOptions();

    naturalLanguageUnderstandingService.disableRetries();
    testDeleteClassificationsModelWOptions();
  }

  // Test the deleteClassificationsModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteClassificationsModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    naturalLanguageUnderstandingService.deleteClassificationsModel(null).execute();
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
    naturalLanguageUnderstandingService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    final Authenticator authenticator = new NoAuthAuthenticator();
    naturalLanguageUnderstandingService =
        new NaturalLanguageUnderstanding(version, serviceName, authenticator);
    String url = server.url("/").toString();
    naturalLanguageUnderstandingService.setServiceUrl(url);
  }
}

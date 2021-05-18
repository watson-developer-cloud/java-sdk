/*
 * (C) Copyright IBM Corp. 2019, 2021.
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
import com.ibm.watson.natural_language_understanding.v1.model.CategoriesOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ClassificationsModel;
import com.ibm.watson.natural_language_understanding.v1.model.ClassificationsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ConceptsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.CreateCategoriesModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.CreateClassificationsModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.CreateSentimentModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.DeleteCategoriesModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.DeleteClassificationsModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.DeleteModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.DeleteModelResults;
import com.ibm.watson.natural_language_understanding.v1.model.DeleteSentimentModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.EmotionOptions;
import com.ibm.watson.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.natural_language_understanding.v1.model.Features;
import com.ibm.watson.natural_language_understanding.v1.model.GetCategoriesModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.GetClassificationsModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.GetSentimentModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.KeywordsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ListCategoriesModelsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ListCategoriesModelsResponse;
import com.ibm.watson.natural_language_understanding.v1.model.ListClassificationsModelsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ListClassificationsModelsResponse;
import com.ibm.watson.natural_language_understanding.v1.model.ListModelsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ListModelsResults;
import com.ibm.watson.natural_language_understanding.v1.model.ListSentimentModelsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ListSentimentModelsResponse;
import com.ibm.watson.natural_language_understanding.v1.model.MetadataOptions;
import com.ibm.watson.natural_language_understanding.v1.model.RelationsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.SemanticRolesOptions;
import com.ibm.watson.natural_language_understanding.v1.model.SentimentModel;
import com.ibm.watson.natural_language_understanding.v1.model.SentimentOptions;
import com.ibm.watson.natural_language_understanding.v1.model.SummarizationOptions;
import com.ibm.watson.natural_language_understanding.v1.model.SyntaxOptions;
import com.ibm.watson.natural_language_understanding.v1.model.SyntaxOptionsTokens;
import com.ibm.watson.natural_language_understanding.v1.model.UpdateCategoriesModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.UpdateClassificationsModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.UpdateSentimentModelOptions;
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

  public void constructClientService() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    final Authenticator authenticator = new NoAuthAuthenticator();

    naturalLanguageUnderstandingService =
        new NaturalLanguageUnderstanding(version, serviceName, authenticator);
    String url = server.url("/").toString();
    naturalLanguageUnderstandingService.setServiceUrl(url);
  }

  /** Negative Test - construct the service with a null authenticator. */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    new NaturalLanguageUnderstanding(version, serviceName, null);
  }

  @Test
  public void testGetVersion() throws Throwable {
    constructClientService();
    assertEquals(naturalLanguageUnderstandingService.getVersion(), "testString");
  }

  @Test
  public void testAnalyzeWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"language\": \"language\", \"analyzed_text\": \"analyzedText\", \"retrieved_url\": \"retrievedUrl\", \"usage\": {\"features\": 8, \"text_characters\": 14, \"text_units\": 9}, \"concepts\": [{\"text\": \"text\", \"relevance\": 9, \"dbpedia_resource\": \"dbpediaResource\"}], \"entities\": [{\"type\": \"type\", \"text\": \"text\", \"relevance\": 9, \"confidence\": 10, \"mentions\": [{\"text\": \"text\", \"location\": [8], \"confidence\": 10}], \"count\": 5, \"emotion\": {\"anger\": 5, \"disgust\": 7, \"fear\": 4, \"joy\": 3, \"sadness\": 7}, \"sentiment\": {\"score\": 5}, \"disambiguation\": {\"name\": \"name\", \"dbpedia_resource\": \"dbpediaResource\", \"subtype\": [\"subtype\"]}}], \"keywords\": [{\"count\": 5, \"relevance\": 9, \"text\": \"text\", \"emotion\": {\"anger\": 5, \"disgust\": 7, \"fear\": 4, \"joy\": 3, \"sadness\": 7}, \"sentiment\": {\"score\": 5}}], \"categories\": [{\"label\": \"label\", \"score\": 5, \"explanation\": {\"relevant_text\": [{\"text\": \"text\"}]}}], \"classifications\": [{\"class_name\": \"className\", \"confidence\": 10}], \"emotion\": {\"document\": {\"emotion\": {\"anger\": 5, \"disgust\": 7, \"fear\": 4, \"joy\": 3, \"sadness\": 7}}, \"targets\": [{\"text\": \"text\", \"emotion\": {\"anger\": 5, \"disgust\": 7, \"fear\": 4, \"joy\": 3, \"sadness\": 7}}]}, \"metadata\": {\"authors\": [{\"name\": \"name\"}], \"publication_date\": \"publicationDate\", \"title\": \"title\", \"image\": \"image\", \"feeds\": [{\"link\": \"link\"}]}, \"relations\": [{\"score\": 5, \"sentence\": \"sentence\", \"type\": \"type\", \"arguments\": [{\"entities\": [{\"text\": \"text\", \"type\": \"type\"}], \"location\": [8], \"text\": \"text\"}]}], \"semantic_roles\": [{\"sentence\": \"sentence\", \"subject\": {\"text\": \"text\", \"entities\": [{\"type\": \"type\", \"text\": \"text\"}], \"keywords\": [{\"text\": \"text\"}]}, \"action\": {\"text\": \"text\", \"normalized\": \"normalized\", \"verb\": {\"text\": \"text\", \"tense\": \"tense\"}}, \"object\": {\"text\": \"text\", \"keywords\": [{\"text\": \"text\"}]}}], \"sentiment\": {\"document\": {\"label\": \"label\", \"score\": 5}, \"targets\": [{\"text\": \"text\", \"score\": 5}]}, \"syntax\": {\"tokens\": [{\"text\": \"text\", \"part_of_speech\": \"ADJ\", \"location\": [8], \"lemma\": \"lemma\"}], \"sentences\": [{\"text\": \"text\", \"location\": [8]}]}}";
    String analyzePath = "/v1/analyze";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CategoriesOptions model
    CategoriesOptions categoriesOptionsModel =
        new CategoriesOptions.Builder()
            .explanation(true)
            .limit(Long.valueOf("10"))
            .model("testString")
            .build();

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
            .targets(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the EntitiesOptions model
    EntitiesOptions entitiesOptionsModel =
        new EntitiesOptions.Builder()
            .limit(Long.valueOf("250"))
            .mentions(true)
            .model("testString")
            .sentiment(true)
            .emotion(true)
            .build();

    // Construct an instance of the KeywordsOptions model
    KeywordsOptions keywordsOptionsModel =
        new KeywordsOptions.Builder()
            .limit(Long.valueOf("250"))
            .sentiment(true)
            .emotion(true)
            .build();

    // Construct an instance of the MetadataOptions model
    MetadataOptions metadataOptionsModel = new MetadataOptions();

    // Construct an instance of the RelationsOptions model
    RelationsOptions relationsOptionsModel =
        new RelationsOptions.Builder().model("testString").build();

    // Construct an instance of the SemanticRolesOptions model
    SemanticRolesOptions semanticRolesOptionsModel =
        new SemanticRolesOptions.Builder()
            .limit(Long.valueOf("26"))
            .keywords(true)
            .entities(true)
            .build();

    // Construct an instance of the SentimentOptions model
    SentimentOptions sentimentOptionsModel =
        new SentimentOptions.Builder()
            .document(true)
            .targets(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .model("testString")
            .build();

    // Construct an instance of the SummarizationOptions model
    SummarizationOptions summarizationOptionsModel =
        new SummarizationOptions.Builder().limit(Long.valueOf("10")).build();

    // Construct an instance of the SyntaxOptionsTokens model
    SyntaxOptionsTokens syntaxOptionsTokensModel =
        new SyntaxOptionsTokens.Builder().lemma(true).partOfSpeech(true).build();

    // Construct an instance of the SyntaxOptions model
    SyntaxOptions syntaxOptionsModel =
        new SyntaxOptions.Builder().tokens(syntaxOptionsTokensModel).sentences(true).build();

    // Construct an instance of the Features model
    Features featuresModel =
        new Features.Builder()
            .categories(categoriesOptionsModel)
            .classifications(classificationsOptionsModel)
            .concepts(conceptsOptionsModel)
            .emotion(emotionOptionsModel)
            .entities(entitiesOptionsModel)
            .keywords(keywordsOptionsModel)
            .metadata(metadataOptionsModel)
            .relations(relationsOptionsModel)
            .semanticRoles(semanticRolesOptionsModel)
            .sentiment(sentimentOptionsModel)
            .summarization(summarizationOptionsModel)
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
            .returnAnalyzedText(true)
            .language("testString")
            .limitTextCharacters(Long.valueOf("26"))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<AnalysisResults> response =
        naturalLanguageUnderstandingService.analyze(analyzeOptionsModel).execute();
    assertNotNull(response);
    AnalysisResults responseObj = response.getResult();
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
    naturalLanguageUnderstandingService.analyze(null).execute();
  }

  @Test
  public void testListModelsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"models\": [{\"status\": \"starting\", \"model_id\": \"modelId\", \"language\": \"language\", \"description\": \"description\", \"workspace_id\": \"workspaceId\", \"model_version\": \"modelVersion\", \"version\": \"version\", \"version_description\": \"versionDescription\", \"created\": \"2019-01-01T12:00:00.000Z\"}]}";
    String listModelsPath = "/v1/models";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListModelsOptions model
    ListModelsOptions listModelsOptionsModel = new ListModelsOptions();

    // Invoke operation with valid options model (positive test)
    Response<ListModelsResults> response =
        naturalLanguageUnderstandingService.listModels(listModelsOptionsModel).execute();
    assertNotNull(response);
    ListModelsResults responseObj = response.getResult();
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
    assertEquals(parsedPath, listModelsPath);
  }

  @Test
  public void testDeleteModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"deleted\": \"deleted\"}";
    String deleteModelPath = "/v1/models/testString";

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
    Response<DeleteModelResults> response =
        naturalLanguageUnderstandingService.deleteModel(deleteModelOptionsModel).execute();
    assertNotNull(response);
    DeleteModelResults responseObj = response.getResult();
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
    naturalLanguageUnderstandingService.deleteModel(null).execute();
  }

  @Test
  public void testCreateSentimentModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"user_metadata\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"notices\": [{\"message\": \"message\"}], \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\"}";
    String createSentimentModelPath = "/v1/models/sentiment";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateSentimentModelOptions model
    CreateSentimentModelOptions createSentimentModelOptionsModel =
        new CreateSentimentModelOptions.Builder()
            .language("testString")
            .trainingData(TestUtilities.createMockStream("This is a mock file."))
            .name("testString")
            .description("testString")
            .modelVersion("testString")
            .workspaceId("testString")
            .versionDescription("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<SentimentModel> response =
        naturalLanguageUnderstandingService
            .createSentimentModel(createSentimentModelOptionsModel)
            .execute();
    assertNotNull(response);
    SentimentModel responseObj = response.getResult();
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
    assertEquals(parsedPath, createSentimentModelPath);
  }

  // Test the createSentimentModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateSentimentModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    naturalLanguageUnderstandingService.createSentimentModel(null).execute();
  }

  @Test
  public void testListSentimentModelsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"models\": [{\"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"user_metadata\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"notices\": [{\"message\": \"message\"}], \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\"}]}";
    String listSentimentModelsPath = "/v1/models/sentiment";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListSentimentModelsOptions model
    ListSentimentModelsOptions listSentimentModelsOptionsModel = new ListSentimentModelsOptions();

    // Invoke operation with valid options model (positive test)
    Response<ListSentimentModelsResponse> response =
        naturalLanguageUnderstandingService
            .listSentimentModels(listSentimentModelsOptionsModel)
            .execute();
    assertNotNull(response);
    ListSentimentModelsResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, listSentimentModelsPath);
  }

  @Test
  public void testGetSentimentModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"user_metadata\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"notices\": [{\"message\": \"message\"}], \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\"}";
    String getSentimentModelPath = "/v1/models/sentiment/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetSentimentModelOptions model
    GetSentimentModelOptions getSentimentModelOptionsModel =
        new GetSentimentModelOptions.Builder().modelId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<SentimentModel> response =
        naturalLanguageUnderstandingService
            .getSentimentModel(getSentimentModelOptionsModel)
            .execute();
    assertNotNull(response);
    SentimentModel responseObj = response.getResult();
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
    assertEquals(parsedPath, getSentimentModelPath);
  }

  // Test the getSentimentModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSentimentModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    naturalLanguageUnderstandingService.getSentimentModel(null).execute();
  }

  @Test
  public void testUpdateSentimentModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"user_metadata\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"notices\": [{\"message\": \"message\"}], \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\"}";
    String updateSentimentModelPath = "/v1/models/sentiment/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateSentimentModelOptions model
    UpdateSentimentModelOptions updateSentimentModelOptionsModel =
        new UpdateSentimentModelOptions.Builder()
            .modelId("testString")
            .language("testString")
            .trainingData(TestUtilities.createMockStream("This is a mock file."))
            .name("testString")
            .description("testString")
            .modelVersion("testString")
            .workspaceId("testString")
            .versionDescription("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<SentimentModel> response =
        naturalLanguageUnderstandingService
            .updateSentimentModel(updateSentimentModelOptionsModel)
            .execute();
    assertNotNull(response);
    SentimentModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateSentimentModelPath);
  }

  // Test the updateSentimentModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateSentimentModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    naturalLanguageUnderstandingService.updateSentimentModel(null).execute();
  }

  @Test
  public void testDeleteSentimentModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"deleted\": \"deleted\"}";
    String deleteSentimentModelPath = "/v1/models/sentiment/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteSentimentModelOptions model
    DeleteSentimentModelOptions deleteSentimentModelOptionsModel =
        new DeleteSentimentModelOptions.Builder().modelId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteModelResults> response =
        naturalLanguageUnderstandingService
            .deleteSentimentModel(deleteSentimentModelOptionsModel)
            .execute();
    assertNotNull(response);
    DeleteModelResults responseObj = response.getResult();
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
    assertEquals(parsedPath, deleteSentimentModelPath);
  }

  // Test the deleteSentimentModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteSentimentModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    naturalLanguageUnderstandingService.deleteSentimentModel(null).execute();
  }

  @Test
  public void testCreateCategoriesModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"name\": \"name\", \"user_metadata\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\", \"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"notices\": [{\"message\": \"message\"}], \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\"}";
    String createCategoriesModelPath = "/v1/models/categories";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

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

    // Invoke operation with valid options model (positive test)
    Response<CategoriesModel> response =
        naturalLanguageUnderstandingService
            .createCategoriesModel(createCategoriesModelOptionsModel)
            .execute();
    assertNotNull(response);
    CategoriesModel responseObj = response.getResult();
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
    assertEquals(parsedPath, createCategoriesModelPath);
  }

  // Test the createCategoriesModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCategoriesModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    naturalLanguageUnderstandingService.createCategoriesModel(null).execute();
  }

  @Test
  public void testListCategoriesModelsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"models\": [{\"models\": [{\"name\": \"name\", \"user_metadata\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\", \"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"notices\": [{\"message\": \"message\"}], \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\"}]}]}";
    String listCategoriesModelsPath = "/v1/models/categories";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListCategoriesModelsOptions model
    ListCategoriesModelsOptions listCategoriesModelsOptionsModel =
        new ListCategoriesModelsOptions();

    // Invoke operation with valid options model (positive test)
    Response<ListCategoriesModelsResponse> response =
        naturalLanguageUnderstandingService
            .listCategoriesModels(listCategoriesModelsOptionsModel)
            .execute();
    assertNotNull(response);
    ListCategoriesModelsResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, listCategoriesModelsPath);
  }

  @Test
  public void testGetCategoriesModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"name\": \"name\", \"user_metadata\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\", \"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"notices\": [{\"message\": \"message\"}], \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\"}";
    String getCategoriesModelPath = "/v1/models/categories/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCategoriesModelOptions model
    GetCategoriesModelOptions getCategoriesModelOptionsModel =
        new GetCategoriesModelOptions.Builder().modelId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<CategoriesModel> response =
        naturalLanguageUnderstandingService
            .getCategoriesModel(getCategoriesModelOptionsModel)
            .execute();
    assertNotNull(response);
    CategoriesModel responseObj = response.getResult();
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
    assertEquals(parsedPath, getCategoriesModelPath);
  }

  // Test the getCategoriesModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCategoriesModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    naturalLanguageUnderstandingService.getCategoriesModel(null).execute();
  }

  @Test
  public void testUpdateCategoriesModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"name\": \"name\", \"user_metadata\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\", \"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"notices\": [{\"message\": \"message\"}], \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\"}";
    String updateCategoriesModelPath = "/v1/models/categories/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

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

    // Invoke operation with valid options model (positive test)
    Response<CategoriesModel> response =
        naturalLanguageUnderstandingService
            .updateCategoriesModel(updateCategoriesModelOptionsModel)
            .execute();
    assertNotNull(response);
    CategoriesModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateCategoriesModelPath);
  }

  // Test the updateCategoriesModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCategoriesModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    naturalLanguageUnderstandingService.updateCategoriesModel(null).execute();
  }

  @Test
  public void testDeleteCategoriesModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"deleted\": \"deleted\"}";
    String deleteCategoriesModelPath = "/v1/models/categories/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteCategoriesModelOptions model
    DeleteCategoriesModelOptions deleteCategoriesModelOptionsModel =
        new DeleteCategoriesModelOptions.Builder().modelId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteModelResults> response =
        naturalLanguageUnderstandingService
            .deleteCategoriesModel(deleteCategoriesModelOptionsModel)
            .execute();
    assertNotNull(response);
    DeleteModelResults responseObj = response.getResult();
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
    assertEquals(parsedPath, deleteCategoriesModelPath);
  }

  // Test the deleteCategoriesModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCategoriesModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    naturalLanguageUnderstandingService.deleteCategoriesModel(null).execute();
  }

  @Test
  public void testCreateClassificationsModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"name\": \"name\", \"user_metadata\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\", \"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"notices\": [{\"message\": \"message\"}], \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\"}";
    String createClassificationsModelPath = "/v1/models/classifications";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

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
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ClassificationsModel> response =
        naturalLanguageUnderstandingService
            .createClassificationsModel(createClassificationsModelOptionsModel)
            .execute();
    assertNotNull(response);
    ClassificationsModel responseObj = response.getResult();
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
    assertEquals(parsedPath, createClassificationsModelPath);
  }

  // Test the createClassificationsModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateClassificationsModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    naturalLanguageUnderstandingService.createClassificationsModel(null).execute();
  }

  @Test
  public void testListClassificationsModelsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"models\": [{\"models\": [{\"name\": \"name\", \"user_metadata\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\", \"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"notices\": [{\"message\": \"message\"}], \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\"}]}]}";
    String listClassificationsModelsPath = "/v1/models/classifications";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListClassificationsModelsOptions model
    ListClassificationsModelsOptions listClassificationsModelsOptionsModel =
        new ListClassificationsModelsOptions();

    // Invoke operation with valid options model (positive test)
    Response<ListClassificationsModelsResponse> response =
        naturalLanguageUnderstandingService
            .listClassificationsModels(listClassificationsModelsOptionsModel)
            .execute();
    assertNotNull(response);
    ListClassificationsModelsResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, listClassificationsModelsPath);
  }

  @Test
  public void testGetClassificationsModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"name\": \"name\", \"user_metadata\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\", \"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"notices\": [{\"message\": \"message\"}], \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\"}";
    String getClassificationsModelPath = "/v1/models/classifications/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetClassificationsModelOptions model
    GetClassificationsModelOptions getClassificationsModelOptionsModel =
        new GetClassificationsModelOptions.Builder().modelId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<ClassificationsModel> response =
        naturalLanguageUnderstandingService
            .getClassificationsModel(getClassificationsModelOptionsModel)
            .execute();
    assertNotNull(response);
    ClassificationsModel responseObj = response.getResult();
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
    assertEquals(parsedPath, getClassificationsModelPath);
  }

  // Test the getClassificationsModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetClassificationsModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    naturalLanguageUnderstandingService.getClassificationsModel(null).execute();
  }

  @Test
  public void testUpdateClassificationsModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"name\": \"name\", \"user_metadata\": {\"mapKey\": {\"anyKey\": \"anyValue\"}}, \"language\": \"language\", \"description\": \"description\", \"model_version\": \"modelVersion\", \"workspace_id\": \"workspaceId\", \"version_description\": \"versionDescription\", \"features\": [\"features\"], \"status\": \"starting\", \"model_id\": \"modelId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"notices\": [{\"message\": \"message\"}], \"last_trained\": \"2019-01-01T12:00:00.000Z\", \"last_deployed\": \"2019-01-01T12:00:00.000Z\"}";
    String updateClassificationsModelPath = "/v1/models/classifications/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

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
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ClassificationsModel> response =
        naturalLanguageUnderstandingService
            .updateClassificationsModel(updateClassificationsModelOptionsModel)
            .execute();
    assertNotNull(response);
    ClassificationsModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateClassificationsModelPath);
  }

  // Test the updateClassificationsModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateClassificationsModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    naturalLanguageUnderstandingService.updateClassificationsModel(null).execute();
  }

  @Test
  public void testDeleteClassificationsModelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"deleted\": \"deleted\"}";
    String deleteClassificationsModelPath = "/v1/models/classifications/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteClassificationsModelOptions model
    DeleteClassificationsModelOptions deleteClassificationsModelOptionsModel =
        new DeleteClassificationsModelOptions.Builder().modelId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteModelResults> response =
        naturalLanguageUnderstandingService
            .deleteClassificationsModel(deleteClassificationsModelOptionsModel)
            .execute();
    assertNotNull(response);
    DeleteModelResults responseObj = response.getResult();
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
    assertEquals(parsedPath, deleteClassificationsModelPath);
  }

  // Test the deleteClassificationsModel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteClassificationsModelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    naturalLanguageUnderstandingService.deleteClassificationsModel(null).execute();
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
    naturalLanguageUnderstandingService = null;
  }
}

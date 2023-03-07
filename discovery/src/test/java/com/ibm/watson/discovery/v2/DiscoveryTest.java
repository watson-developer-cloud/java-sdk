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
package com.ibm.watson.discovery.v2;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.watson.discovery.v2.model.AddDocumentOptions;
import com.ibm.watson.discovery.v2.model.AnalyzeDocumentOptions;
import com.ibm.watson.discovery.v2.model.AnalyzedDocument;
import com.ibm.watson.discovery.v2.model.ClassifierFederatedModel;
import com.ibm.watson.discovery.v2.model.CollectionDetails;
import com.ibm.watson.discovery.v2.model.CollectionEnrichment;
import com.ibm.watson.discovery.v2.model.Completions;
import com.ibm.watson.discovery.v2.model.ComponentSettingsResponse;
import com.ibm.watson.discovery.v2.model.CreateCollectionOptions;
import com.ibm.watson.discovery.v2.model.CreateDocumentClassifier;
import com.ibm.watson.discovery.v2.model.CreateDocumentClassifierModelOptions;
import com.ibm.watson.discovery.v2.model.CreateDocumentClassifierOptions;
import com.ibm.watson.discovery.v2.model.CreateEnrichment;
import com.ibm.watson.discovery.v2.model.CreateEnrichmentOptions;
import com.ibm.watson.discovery.v2.model.CreateExpansionsOptions;
import com.ibm.watson.discovery.v2.model.CreateProjectOptions;
import com.ibm.watson.discovery.v2.model.CreateStopwordListOptions;
import com.ibm.watson.discovery.v2.model.CreateTrainingQueryOptions;
import com.ibm.watson.discovery.v2.model.DefaultQueryParams;
import com.ibm.watson.discovery.v2.model.DefaultQueryParamsPassages;
import com.ibm.watson.discovery.v2.model.DefaultQueryParamsSuggestedRefinements;
import com.ibm.watson.discovery.v2.model.DefaultQueryParamsTableResults;
import com.ibm.watson.discovery.v2.model.DeleteCollectionOptions;
import com.ibm.watson.discovery.v2.model.DeleteDocumentClassifierModelOptions;
import com.ibm.watson.discovery.v2.model.DeleteDocumentClassifierOptions;
import com.ibm.watson.discovery.v2.model.DeleteDocumentOptions;
import com.ibm.watson.discovery.v2.model.DeleteDocumentResponse;
import com.ibm.watson.discovery.v2.model.DeleteEnrichmentOptions;
import com.ibm.watson.discovery.v2.model.DeleteExpansionsOptions;
import com.ibm.watson.discovery.v2.model.DeleteProjectOptions;
import com.ibm.watson.discovery.v2.model.DeleteStopwordListOptions;
import com.ibm.watson.discovery.v2.model.DeleteTrainingQueriesOptions;
import com.ibm.watson.discovery.v2.model.DeleteTrainingQueryOptions;
import com.ibm.watson.discovery.v2.model.DeleteUserDataOptions;
import com.ibm.watson.discovery.v2.model.DocumentAccepted;
import com.ibm.watson.discovery.v2.model.DocumentClassifier;
import com.ibm.watson.discovery.v2.model.DocumentClassifierEnrichment;
import com.ibm.watson.discovery.v2.model.DocumentClassifierModel;
import com.ibm.watson.discovery.v2.model.DocumentClassifierModels;
import com.ibm.watson.discovery.v2.model.DocumentClassifiers;
import com.ibm.watson.discovery.v2.model.DocumentDetails;
import com.ibm.watson.discovery.v2.model.Enrichment;
import com.ibm.watson.discovery.v2.model.EnrichmentOptions;
import com.ibm.watson.discovery.v2.model.Enrichments;
import com.ibm.watson.discovery.v2.model.Expansion;
import com.ibm.watson.discovery.v2.model.Expansions;
import com.ibm.watson.discovery.v2.model.GetAutocompletionOptions;
import com.ibm.watson.discovery.v2.model.GetCollectionOptions;
import com.ibm.watson.discovery.v2.model.GetComponentSettingsOptions;
import com.ibm.watson.discovery.v2.model.GetDocumentClassifierModelOptions;
import com.ibm.watson.discovery.v2.model.GetDocumentClassifierOptions;
import com.ibm.watson.discovery.v2.model.GetDocumentOptions;
import com.ibm.watson.discovery.v2.model.GetEnrichmentOptions;
import com.ibm.watson.discovery.v2.model.GetProjectOptions;
import com.ibm.watson.discovery.v2.model.GetStopwordListOptions;
import com.ibm.watson.discovery.v2.model.GetTrainingQueryOptions;
import com.ibm.watson.discovery.v2.model.ListCollectionsOptions;
import com.ibm.watson.discovery.v2.model.ListCollectionsResponse;
import com.ibm.watson.discovery.v2.model.ListDocumentClassifierModelsOptions;
import com.ibm.watson.discovery.v2.model.ListDocumentClassifiersOptions;
import com.ibm.watson.discovery.v2.model.ListDocumentsOptions;
import com.ibm.watson.discovery.v2.model.ListDocumentsResponse;
import com.ibm.watson.discovery.v2.model.ListEnrichmentsOptions;
import com.ibm.watson.discovery.v2.model.ListExpansionsOptions;
import com.ibm.watson.discovery.v2.model.ListFieldsOptions;
import com.ibm.watson.discovery.v2.model.ListFieldsResponse;
import com.ibm.watson.discovery.v2.model.ListProjectsOptions;
import com.ibm.watson.discovery.v2.model.ListProjectsResponse;
import com.ibm.watson.discovery.v2.model.ListTrainingQueriesOptions;
import com.ibm.watson.discovery.v2.model.ProjectDetails;
import com.ibm.watson.discovery.v2.model.QueryCollectionNoticesOptions;
import com.ibm.watson.discovery.v2.model.QueryLargePassages;
import com.ibm.watson.discovery.v2.model.QueryLargeSimilar;
import com.ibm.watson.discovery.v2.model.QueryLargeSuggestedRefinements;
import com.ibm.watson.discovery.v2.model.QueryLargeTableResults;
import com.ibm.watson.discovery.v2.model.QueryNoticesOptions;
import com.ibm.watson.discovery.v2.model.QueryNoticesResponse;
import com.ibm.watson.discovery.v2.model.QueryOptions;
import com.ibm.watson.discovery.v2.model.QueryResponse;
import com.ibm.watson.discovery.v2.model.StopWordList;
import com.ibm.watson.discovery.v2.model.TrainingExample;
import com.ibm.watson.discovery.v2.model.TrainingQuery;
import com.ibm.watson.discovery.v2.model.TrainingQuerySet;
import com.ibm.watson.discovery.v2.model.UpdateCollectionOptions;
import com.ibm.watson.discovery.v2.model.UpdateDocumentClassifier;
import com.ibm.watson.discovery.v2.model.UpdateDocumentClassifierModelOptions;
import com.ibm.watson.discovery.v2.model.UpdateDocumentClassifierOptions;
import com.ibm.watson.discovery.v2.model.UpdateDocumentOptions;
import com.ibm.watson.discovery.v2.model.UpdateEnrichmentOptions;
import com.ibm.watson.discovery.v2.model.UpdateProjectOptions;
import com.ibm.watson.discovery.v2.model.UpdateTrainingQueryOptions;
import com.ibm.watson.discovery.v2.utils.TestUtilities;
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

/** Unit test class for the Discovery service. */
public class DiscoveryTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected Discovery discoveryService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    // Set mock values for global params
    String version = "testString";
    new Discovery(version, serviceName, null);
  }

  // Test the getter for the version global parameter
  @Test
  public void testGetVersion() throws Throwable {
    assertEquals(discoveryService.getVersion(), "testString");
  }

  // Test the listProjects operation with a valid options model parameter
  @Test
  public void testListProjectsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"projects\": [{\"project_id\": \"projectId\", \"name\": \"name\", \"type\": \"document_retrieval\", \"relevancy_training_status\": {\"data_updated\": \"dataUpdated\", \"total_examples\": 13, \"sufficient_label_diversity\": true, \"processing\": true, \"minimum_examples_added\": true, \"successfully_trained\": \"successfullyTrained\", \"available\": false, \"notices\": 7, \"minimum_queries_added\": false}, \"collection_count\": 15}]}";
    String listProjectsPath = "/v2/projects";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListProjectsOptions model
    ListProjectsOptions listProjectsOptionsModel = new ListProjectsOptions();

    // Invoke listProjects() with a valid options model and verify the result
    Response<ListProjectsResponse> response =
        discoveryService.listProjects(listProjectsOptionsModel).execute();
    assertNotNull(response);
    ListProjectsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listProjectsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the listProjects operation with and without retries enabled
  @Test
  public void testListProjectsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testListProjectsWOptions();

    discoveryService.disableRetries();
    testListProjectsWOptions();
  }

  // Test the createProject operation with a valid options model parameter
  @Test
  public void testCreateProjectWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"project_id\": \"projectId\", \"name\": \"name\", \"type\": \"document_retrieval\", \"relevancy_training_status\": {\"data_updated\": \"dataUpdated\", \"total_examples\": 13, \"sufficient_label_diversity\": true, \"processing\": true, \"minimum_examples_added\": true, \"successfully_trained\": \"successfullyTrained\", \"available\": false, \"notices\": 7, \"minimum_queries_added\": false}, \"collection_count\": 15, \"default_query_parameters\": {\"collection_ids\": [\"collectionIds\"], \"passages\": {\"enabled\": false, \"count\": 5, \"fields\": [\"fields\"], \"characters\": 10, \"per_document\": false, \"max_per_document\": 14}, \"table_results\": {\"enabled\": false, \"count\": 5, \"per_document\": 11}, \"aggregation\": \"aggregation\", \"suggested_refinements\": {\"enabled\": false, \"count\": 5}, \"spelling_suggestions\": false, \"highlight\": false, \"count\": 5, \"sort\": \"sort\", \"return\": [\"xReturn\"]}}";
    String createProjectPath = "/v2/projects";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the DefaultQueryParamsPassages model
    DefaultQueryParamsPassages defaultQueryParamsPassagesModel =
        new DefaultQueryParamsPassages.Builder()
            .enabled(true)
            .count(Long.valueOf("26"))
            .fields(java.util.Arrays.asList("testString"))
            .characters(Long.valueOf("26"))
            .perDocument(true)
            .maxPerDocument(Long.valueOf("26"))
            .build();

    // Construct an instance of the DefaultQueryParamsTableResults model
    DefaultQueryParamsTableResults defaultQueryParamsTableResultsModel =
        new DefaultQueryParamsTableResults.Builder()
            .enabled(true)
            .count(Long.valueOf("26"))
            .perDocument(Long.valueOf("26"))
            .build();

    // Construct an instance of the DefaultQueryParamsSuggestedRefinements model
    DefaultQueryParamsSuggestedRefinements defaultQueryParamsSuggestedRefinementsModel =
        new DefaultQueryParamsSuggestedRefinements.Builder()
            .enabled(true)
            .count(Long.valueOf("26"))
            .build();

    // Construct an instance of the DefaultQueryParams model
    DefaultQueryParams defaultQueryParamsModel =
        new DefaultQueryParams.Builder()
            .collectionIds(java.util.Arrays.asList("testString"))
            .passages(defaultQueryParamsPassagesModel)
            .tableResults(defaultQueryParamsTableResultsModel)
            .aggregation("testString")
            .suggestedRefinements(defaultQueryParamsSuggestedRefinementsModel)
            .spellingSuggestions(true)
            .highlight(true)
            .count(Long.valueOf("26"))
            .sort("testString")
            .xReturn(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the CreateProjectOptions model
    CreateProjectOptions createProjectOptionsModel =
        new CreateProjectOptions.Builder()
            .name("testString")
            .type("document_retrieval")
            .defaultQueryParameters(defaultQueryParamsModel)
            .build();

    // Invoke createProject() with a valid options model and verify the result
    Response<ProjectDetails> response =
        discoveryService.createProject(createProjectOptionsModel).execute();
    assertNotNull(response);
    ProjectDetails responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createProjectPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createProject operation with and without retries enabled
  @Test
  public void testCreateProjectWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testCreateProjectWOptions();

    discoveryService.disableRetries();
    testCreateProjectWOptions();
  }

  // Test the createProject operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateProjectNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.createProject(null).execute();
  }

  // Test the getProject operation with a valid options model parameter
  @Test
  public void testGetProjectWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"project_id\": \"projectId\", \"name\": \"name\", \"type\": \"document_retrieval\", \"relevancy_training_status\": {\"data_updated\": \"dataUpdated\", \"total_examples\": 13, \"sufficient_label_diversity\": true, \"processing\": true, \"minimum_examples_added\": true, \"successfully_trained\": \"successfullyTrained\", \"available\": false, \"notices\": 7, \"minimum_queries_added\": false}, \"collection_count\": 15, \"default_query_parameters\": {\"collection_ids\": [\"collectionIds\"], \"passages\": {\"enabled\": false, \"count\": 5, \"fields\": [\"fields\"], \"characters\": 10, \"per_document\": false, \"max_per_document\": 14}, \"table_results\": {\"enabled\": false, \"count\": 5, \"per_document\": 11}, \"aggregation\": \"aggregation\", \"suggested_refinements\": {\"enabled\": false, \"count\": 5}, \"spelling_suggestions\": false, \"highlight\": false, \"count\": 5, \"sort\": \"sort\", \"return\": [\"xReturn\"]}}";
    String getProjectPath = "/v2/projects/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetProjectOptions model
    GetProjectOptions getProjectOptionsModel =
        new GetProjectOptions.Builder().projectId("testString").build();

    // Invoke getProject() with a valid options model and verify the result
    Response<ProjectDetails> response =
        discoveryService.getProject(getProjectOptionsModel).execute();
    assertNotNull(response);
    ProjectDetails responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getProjectPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getProject operation with and without retries enabled
  @Test
  public void testGetProjectWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetProjectWOptions();

    discoveryService.disableRetries();
    testGetProjectWOptions();
  }

  // Test the getProject operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetProjectNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getProject(null).execute();
  }

  // Test the updateProject operation with a valid options model parameter
  @Test
  public void testUpdateProjectWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"project_id\": \"projectId\", \"name\": \"name\", \"type\": \"document_retrieval\", \"relevancy_training_status\": {\"data_updated\": \"dataUpdated\", \"total_examples\": 13, \"sufficient_label_diversity\": true, \"processing\": true, \"minimum_examples_added\": true, \"successfully_trained\": \"successfullyTrained\", \"available\": false, \"notices\": 7, \"minimum_queries_added\": false}, \"collection_count\": 15, \"default_query_parameters\": {\"collection_ids\": [\"collectionIds\"], \"passages\": {\"enabled\": false, \"count\": 5, \"fields\": [\"fields\"], \"characters\": 10, \"per_document\": false, \"max_per_document\": 14}, \"table_results\": {\"enabled\": false, \"count\": 5, \"per_document\": 11}, \"aggregation\": \"aggregation\", \"suggested_refinements\": {\"enabled\": false, \"count\": 5}, \"spelling_suggestions\": false, \"highlight\": false, \"count\": 5, \"sort\": \"sort\", \"return\": [\"xReturn\"]}}";
    String updateProjectPath = "/v2/projects/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the UpdateProjectOptions model
    UpdateProjectOptions updateProjectOptionsModel =
        new UpdateProjectOptions.Builder().projectId("testString").name("testString").build();

    // Invoke updateProject() with a valid options model and verify the result
    Response<ProjectDetails> response =
        discoveryService.updateProject(updateProjectOptionsModel).execute();
    assertNotNull(response);
    ProjectDetails responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateProjectPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the updateProject operation with and without retries enabled
  @Test
  public void testUpdateProjectWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testUpdateProjectWOptions();

    discoveryService.disableRetries();
    testUpdateProjectWOptions();
  }

  // Test the updateProject operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateProjectNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.updateProject(null).execute();
  }

  // Test the deleteProject operation with a valid options model parameter
  @Test
  public void testDeleteProjectWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteProjectPath = "/v2/projects/testString";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteProjectOptions model
    DeleteProjectOptions deleteProjectOptionsModel =
        new DeleteProjectOptions.Builder().projectId("testString").build();

    // Invoke deleteProject() with a valid options model and verify the result
    Response<Void> response = discoveryService.deleteProject(deleteProjectOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteProjectPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteProject operation with and without retries enabled
  @Test
  public void testDeleteProjectWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteProjectWOptions();

    discoveryService.disableRetries();
    testDeleteProjectWOptions();
  }

  // Test the deleteProject operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteProjectNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteProject(null).execute();
  }

  // Test the listFields operation with a valid options model parameter
  @Test
  public void testListFieldsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"fields\": [{\"field\": \"field\", \"type\": \"nested\", \"collection_id\": \"collectionId\"}]}";
    String listFieldsPath = "/v2/projects/testString/fields";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListFieldsOptions model
    ListFieldsOptions listFieldsOptionsModel =
        new ListFieldsOptions.Builder()
            .projectId("testString")
            .collectionIds(java.util.Arrays.asList("testString"))
            .build();

    // Invoke listFields() with a valid options model and verify the result
    Response<ListFieldsResponse> response =
        discoveryService.listFields(listFieldsOptionsModel).execute();
    assertNotNull(response);
    ListFieldsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listFieldsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(
        query.get("collection_ids"), RequestUtils.join(java.util.Arrays.asList("testString"), ","));
  }

  // Test the listFields operation with and without retries enabled
  @Test
  public void testListFieldsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testListFieldsWOptions();

    discoveryService.disableRetries();
    testListFieldsWOptions();
  }

  // Test the listFields operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListFieldsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.listFields(null).execute();
  }

  // Test the listCollections operation with a valid options model parameter
  @Test
  public void testListCollectionsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"collections\": [{\"collection_id\": \"collectionId\", \"name\": \"name\"}]}";
    String listCollectionsPath = "/v2/projects/testString/collections";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListCollectionsOptions model
    ListCollectionsOptions listCollectionsOptionsModel =
        new ListCollectionsOptions.Builder().projectId("testString").build();

    // Invoke listCollections() with a valid options model and verify the result
    Response<ListCollectionsResponse> response =
        discoveryService.listCollections(listCollectionsOptionsModel).execute();
    assertNotNull(response);
    ListCollectionsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listCollectionsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the listCollections operation with and without retries enabled
  @Test
  public void testListCollectionsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testListCollectionsWOptions();

    discoveryService.disableRetries();
    testListCollectionsWOptions();
  }

  // Test the listCollections operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListCollectionsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.listCollections(null).execute();
  }

  // Test the createCollection operation with a valid options model parameter
  @Test
  public void testCreateCollectionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"language\": \"en\", \"enrichments\": [{\"enrichment_id\": \"enrichmentId\", \"fields\": [\"fields\"]}], \"smart_document_understanding\": {\"enabled\": false, \"model\": \"custom\"}}";
    String createCollectionPath = "/v2/projects/testString/collections";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the CollectionEnrichment model
    CollectionEnrichment collectionEnrichmentModel =
        new CollectionEnrichment.Builder()
            .enrichmentId("testString")
            .fields(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the CreateCollectionOptions model
    CreateCollectionOptions createCollectionOptionsModel =
        new CreateCollectionOptions.Builder()
            .projectId("testString")
            .name("testString")
            .description("testString")
            .language("en")
            .enrichments(java.util.Arrays.asList(collectionEnrichmentModel))
            .build();

    // Invoke createCollection() with a valid options model and verify the result
    Response<CollectionDetails> response =
        discoveryService.createCollection(createCollectionOptionsModel).execute();
    assertNotNull(response);
    CollectionDetails responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createCollectionPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createCollection operation with and without retries enabled
  @Test
  public void testCreateCollectionWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testCreateCollectionWOptions();

    discoveryService.disableRetries();
    testCreateCollectionWOptions();
  }

  // Test the createCollection operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCollectionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.createCollection(null).execute();
  }

  // Test the getCollection operation with a valid options model parameter
  @Test
  public void testGetCollectionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"language\": \"en\", \"enrichments\": [{\"enrichment_id\": \"enrichmentId\", \"fields\": [\"fields\"]}], \"smart_document_understanding\": {\"enabled\": false, \"model\": \"custom\"}}";
    String getCollectionPath = "/v2/projects/testString/collections/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetCollectionOptions model
    GetCollectionOptions getCollectionOptionsModel =
        new GetCollectionOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .build();

    // Invoke getCollection() with a valid options model and verify the result
    Response<CollectionDetails> response =
        discoveryService.getCollection(getCollectionOptionsModel).execute();
    assertNotNull(response);
    CollectionDetails responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCollectionPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getCollection operation with and without retries enabled
  @Test
  public void testGetCollectionWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetCollectionWOptions();

    discoveryService.disableRetries();
    testGetCollectionWOptions();
  }

  // Test the getCollection operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCollectionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getCollection(null).execute();
  }

  // Test the updateCollection operation with a valid options model parameter
  @Test
  public void testUpdateCollectionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"language\": \"en\", \"enrichments\": [{\"enrichment_id\": \"enrichmentId\", \"fields\": [\"fields\"]}], \"smart_document_understanding\": {\"enabled\": false, \"model\": \"custom\"}}";
    String updateCollectionPath = "/v2/projects/testString/collections/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the CollectionEnrichment model
    CollectionEnrichment collectionEnrichmentModel =
        new CollectionEnrichment.Builder()
            .enrichmentId("testString")
            .fields(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the UpdateCollectionOptions model
    UpdateCollectionOptions updateCollectionOptionsModel =
        new UpdateCollectionOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .name("testString")
            .description("testString")
            .enrichments(java.util.Arrays.asList(collectionEnrichmentModel))
            .build();

    // Invoke updateCollection() with a valid options model and verify the result
    Response<CollectionDetails> response =
        discoveryService.updateCollection(updateCollectionOptionsModel).execute();
    assertNotNull(response);
    CollectionDetails responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateCollectionPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the updateCollection operation with and without retries enabled
  @Test
  public void testUpdateCollectionWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testUpdateCollectionWOptions();

    discoveryService.disableRetries();
    testUpdateCollectionWOptions();
  }

  // Test the updateCollection operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCollectionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.updateCollection(null).execute();
  }

  // Test the deleteCollection operation with a valid options model parameter
  @Test
  public void testDeleteCollectionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteCollectionPath = "/v2/projects/testString/collections/testString";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteCollectionOptions model
    DeleteCollectionOptions deleteCollectionOptionsModel =
        new DeleteCollectionOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .build();

    // Invoke deleteCollection() with a valid options model and verify the result
    Response<Void> response =
        discoveryService.deleteCollection(deleteCollectionOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCollectionPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteCollection operation with and without retries enabled
  @Test
  public void testDeleteCollectionWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteCollectionWOptions();

    discoveryService.disableRetries();
    testDeleteCollectionWOptions();
  }

  // Test the deleteCollection operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCollectionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteCollection(null).execute();
  }

  // Test the listDocuments operation with a valid options model parameter
  @Test
  public void testListDocumentsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"matching_results\": 15, \"documents\": [{\"document_id\": \"documentId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"available\", \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}], \"children\": {\"have_notices\": false, \"count\": 5}, \"filename\": \"filename\", \"file_type\": \"fileType\", \"sha256\": \"sha256\"}]}";
    String listDocumentsPath = "/v2/projects/testString/collections/testString/documents";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListDocumentsOptions model
    ListDocumentsOptions listDocumentsOptionsModel =
        new ListDocumentsOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .count(Long.valueOf("26"))
            .status("testString")
            .hasNotices(true)
            .isParent(true)
            .parentDocumentId("testString")
            .sha256("testString")
            .build();

    // Invoke listDocuments() with a valid options model and verify the result
    Response<ListDocumentsResponse> response =
        discoveryService.listDocuments(listDocumentsOptionsModel).execute();
    assertNotNull(response);
    ListDocumentsResponse responseObj = response.getResult();
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
    assertEquals(query.get("version"), "testString");
    assertEquals(Long.valueOf(query.get("count")), Long.valueOf("26"));
    assertEquals(query.get("status"), "testString");
    assertEquals(Boolean.valueOf(query.get("has_notices")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("is_parent")), Boolean.valueOf(true));
    assertEquals(query.get("parent_document_id"), "testString");
    assertEquals(query.get("sha256"), "testString");
  }

  // Test the listDocuments operation with and without retries enabled
  @Test
  public void testListDocumentsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testListDocumentsWOptions();

    discoveryService.disableRetries();
    testListDocumentsWOptions();
  }

  // Test the listDocuments operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListDocumentsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.listDocuments(null).execute();
  }

  // Test the addDocument operation with a valid options model parameter
  @Test
  public void testAddDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"document_id\": \"documentId\", \"status\": \"processing\"}";
    String addDocumentPath = "/v2/projects/testString/collections/testString/documents";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    // Construct an instance of the AddDocumentOptions model
    AddDocumentOptions addDocumentOptionsModel =
        new AddDocumentOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .file(TestUtilities.createMockStream("This is a mock file."))
            .filename("testString")
            .fileContentType("application/json")
            .metadata("testString")
            .xWatsonDiscoveryForce(false)
            .build();

    // Invoke addDocument() with a valid options model and verify the result
    Response<DocumentAccepted> response =
        discoveryService.addDocument(addDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentAccepted responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the addDocument operation with and without retries enabled
  @Test
  public void testAddDocumentWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testAddDocumentWOptions();

    discoveryService.disableRetries();
    testAddDocumentWOptions();
  }

  // Test the addDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.addDocument(null).execute();
  }

  // Test the getDocument operation with a valid options model parameter
  @Test
  public void testGetDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"available\", \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}], \"children\": {\"have_notices\": false, \"count\": 5}, \"filename\": \"filename\", \"file_type\": \"fileType\", \"sha256\": \"sha256\"}";
    String getDocumentPath = "/v2/projects/testString/collections/testString/documents/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetDocumentOptions model
    GetDocumentOptions getDocumentOptionsModel =
        new GetDocumentOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .documentId("testString")
            .build();

    // Invoke getDocument() with a valid options model and verify the result
    Response<DocumentDetails> response =
        discoveryService.getDocument(getDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentDetails responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getDocument operation with and without retries enabled
  @Test
  public void testGetDocumentWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetDocumentWOptions();

    discoveryService.disableRetries();
    testGetDocumentWOptions();
  }

  // Test the getDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getDocument(null).execute();
  }

  // Test the updateDocument operation with a valid options model parameter
  @Test
  public void testUpdateDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"document_id\": \"documentId\", \"status\": \"processing\"}";
    String updateDocumentPath =
        "/v2/projects/testString/collections/testString/documents/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    // Construct an instance of the UpdateDocumentOptions model
    UpdateDocumentOptions updateDocumentOptionsModel =
        new UpdateDocumentOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .documentId("testString")
            .file(TestUtilities.createMockStream("This is a mock file."))
            .filename("testString")
            .fileContentType("application/json")
            .metadata("testString")
            .xWatsonDiscoveryForce(false)
            .build();

    // Invoke updateDocument() with a valid options model and verify the result
    Response<DocumentAccepted> response =
        discoveryService.updateDocument(updateDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentAccepted responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the updateDocument operation with and without retries enabled
  @Test
  public void testUpdateDocumentWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testUpdateDocumentWOptions();

    discoveryService.disableRetries();
    testUpdateDocumentWOptions();
  }

  // Test the updateDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.updateDocument(null).execute();
  }

  // Test the deleteDocument operation with a valid options model parameter
  @Test
  public void testDeleteDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"document_id\": \"documentId\", \"status\": \"deleted\"}";
    String deleteDocumentPath =
        "/v2/projects/testString/collections/testString/documents/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the DeleteDocumentOptions model
    DeleteDocumentOptions deleteDocumentOptionsModel =
        new DeleteDocumentOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .documentId("testString")
            .xWatsonDiscoveryForce(false)
            .build();

    // Invoke deleteDocument() with a valid options model and verify the result
    Response<DeleteDocumentResponse> response =
        discoveryService.deleteDocument(deleteDocumentOptionsModel).execute();
    assertNotNull(response);
    DeleteDocumentResponse responseObj = response.getResult();
    assertNotNull(responseObj);

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
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteDocument operation with and without retries enabled
  @Test
  public void testDeleteDocumentWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteDocumentWOptions();

    discoveryService.disableRetries();
    testDeleteDocumentWOptions();
  }

  // Test the deleteDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteDocument(null).execute();
  }

  // Test the query operation with a valid options model parameter
  @Test
  public void testQueryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"matching_results\": 15, \"results\": [{\"document_id\": \"documentId\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"result_metadata\": {\"document_retrieval_source\": \"search\", \"collection_id\": \"collectionId\", \"confidence\": 0}, \"document_passages\": [{\"passage_text\": \"passageText\", \"start_offset\": 11, \"end_offset\": 9, \"field\": \"field\", \"answers\": [{\"answer_text\": \"answerText\", \"start_offset\": 11, \"end_offset\": 9, \"confidence\": 0}]}]}], \"aggregations\": [{\"type\": \"term\", \"field\": \"field\", \"count\": 5, \"name\": \"name\", \"results\": [{\"key\": \"key\", \"matching_results\": 15, \"relevancy\": 9, \"total_matching_documents\": 22, \"estimated_matching_results\": 24, \"aggregations\": [{\"anyKey\": \"anyValue\"}]}]}], \"retrieval_details\": {\"document_retrieval_strategy\": \"untrained\"}, \"suggested_query\": \"suggestedQuery\", \"suggested_refinements\": [{\"text\": \"text\"}], \"table_results\": [{\"table_id\": \"tableId\", \"source_document_id\": \"sourceDocumentId\", \"collection_id\": \"collectionId\", \"table_html\": \"tableHtml\", \"table_html_offset\": 15, \"table\": {\"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"section_title\": {\"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}, \"title\": {\"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}, \"table_headers\": [{\"cell_id\": \"cellId\", \"location\": {\"anyKey\": \"anyValue\"}, \"text\": \"text\", \"row_index_begin\": 13, \"row_index_end\": 11, \"column_index_begin\": 16, \"column_index_end\": 14}], \"row_headers\": [{\"cell_id\": \"cellId\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"text_normalized\": \"textNormalized\", \"row_index_begin\": 13, \"row_index_end\": 11, \"column_index_begin\": 16, \"column_index_end\": 14}], \"column_headers\": [{\"cell_id\": \"cellId\", \"location\": {\"anyKey\": \"anyValue\"}, \"text\": \"text\", \"text_normalized\": \"textNormalized\", \"row_index_begin\": 13, \"row_index_end\": 11, \"column_index_begin\": 16, \"column_index_end\": 14}], \"key_value_pairs\": [{\"key\": {\"cell_id\": \"cellId\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\"}, \"value\": [{\"cell_id\": \"cellId\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\"}]}], \"body_cells\": [{\"cell_id\": \"cellId\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"row_index_begin\": 13, \"row_index_end\": 11, \"column_index_begin\": 16, \"column_index_end\": 14, \"row_header_ids\": [{\"id\": \"id\"}], \"row_header_texts\": [{\"text\": \"text\"}], \"row_header_texts_normalized\": [{\"text_normalized\": \"textNormalized\"}], \"column_header_ids\": [{\"id\": \"id\"}], \"column_header_texts\": [{\"text\": \"text\"}], \"column_header_texts_normalized\": [{\"text_normalized\": \"textNormalized\"}], \"attributes\": [{\"type\": \"type\", \"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}]}], \"contexts\": [{\"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}]}}], \"passages\": [{\"passage_text\": \"passageText\", \"passage_score\": 12, \"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"start_offset\": 11, \"end_offset\": 9, \"field\": \"field\", \"answers\": [{\"answer_text\": \"answerText\", \"start_offset\": 11, \"end_offset\": 9, \"confidence\": 0}]}]}";
    String queryPath = "/v2/projects/testString/query";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the QueryLargeTableResults model
    QueryLargeTableResults queryLargeTableResultsModel =
        new QueryLargeTableResults.Builder().enabled(true).count(Long.valueOf("26")).build();

    // Construct an instance of the QueryLargeSuggestedRefinements model
    QueryLargeSuggestedRefinements queryLargeSuggestedRefinementsModel =
        new QueryLargeSuggestedRefinements.Builder().enabled(true).count(Long.valueOf("1")).build();

    // Construct an instance of the QueryLargePassages model
    QueryLargePassages queryLargePassagesModel =
        new QueryLargePassages.Builder()
            .enabled(true)
            .perDocument(true)
            .maxPerDocument(Long.valueOf("26"))
            .fields(java.util.Arrays.asList("testString"))
            .count(Long.valueOf("400"))
            .characters(Long.valueOf("50"))
            .findAnswers(false)
            .maxAnswersPerPassage(Long.valueOf("26"))
            .build();

    // Construct an instance of the QueryLargeSimilar model
    QueryLargeSimilar queryLargeSimilarModel =
        new QueryLargeSimilar.Builder()
            .enabled(false)
            .documentIds(java.util.Arrays.asList("testString"))
            .fields(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the QueryOptions model
    QueryOptions queryOptionsModel =
        new QueryOptions.Builder()
            .projectId("testString")
            .collectionIds(java.util.Arrays.asList("testString"))
            .filter("testString")
            .query("testString")
            .naturalLanguageQuery("testString")
            .aggregation("testString")
            .count(Long.valueOf("26"))
            .xReturn(java.util.Arrays.asList("testString"))
            .offset(Long.valueOf("26"))
            .sort("testString")
            .highlight(true)
            .spellingSuggestions(true)
            .tableResults(queryLargeTableResultsModel)
            .suggestedRefinements(queryLargeSuggestedRefinementsModel)
            .passages(queryLargePassagesModel)
            .similar(queryLargeSimilarModel)
            .build();

    // Invoke query() with a valid options model and verify the result
    Response<QueryResponse> response = discoveryService.query(queryOptionsModel).execute();
    assertNotNull(response);
    QueryResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, queryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the query operation with and without retries enabled
  @Test
  public void testQueryWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testQueryWOptions();

    discoveryService.disableRetries();
    testQueryWOptions();
  }

  // Test the query operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testQueryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.query(null).execute();
  }

  // Test the getAutocompletion operation with a valid options model parameter
  @Test
  public void testGetAutocompletionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"completions\": [\"completions\"]}";
    String getAutocompletionPath = "/v2/projects/testString/autocompletion";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetAutocompletionOptions model
    GetAutocompletionOptions getAutocompletionOptionsModel =
        new GetAutocompletionOptions.Builder()
            .projectId("testString")
            .prefix("testString")
            .collectionIds(java.util.Arrays.asList("testString"))
            .field("testString")
            .count(Long.valueOf("26"))
            .build();

    // Invoke getAutocompletion() with a valid options model and verify the result
    Response<Completions> response =
        discoveryService.getAutocompletion(getAutocompletionOptionsModel).execute();
    assertNotNull(response);
    Completions responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAutocompletionPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("prefix"), "testString");
    assertEquals(
        query.get("collection_ids"), RequestUtils.join(java.util.Arrays.asList("testString"), ","));
    assertEquals(query.get("field"), "testString");
    assertEquals(Long.valueOf(query.get("count")), Long.valueOf("26"));
  }

  // Test the getAutocompletion operation with and without retries enabled
  @Test
  public void testGetAutocompletionWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetAutocompletionWOptions();

    discoveryService.disableRetries();
    testGetAutocompletionWOptions();
  }

  // Test the getAutocompletion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAutocompletionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getAutocompletion(null).execute();
  }

  // Test the queryCollectionNotices operation with a valid options model parameter
  @Test
  public void testQueryCollectionNoticesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"matching_results\": 15, \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}]}";
    String queryCollectionNoticesPath = "/v2/projects/testString/collections/testString/notices";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the QueryCollectionNoticesOptions model
    QueryCollectionNoticesOptions queryCollectionNoticesOptionsModel =
        new QueryCollectionNoticesOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .filter("testString")
            .query("testString")
            .naturalLanguageQuery("testString")
            .count(Long.valueOf("26"))
            .offset(Long.valueOf("26"))
            .build();

    // Invoke queryCollectionNotices() with a valid options model and verify the result
    Response<QueryNoticesResponse> response =
        discoveryService.queryCollectionNotices(queryCollectionNoticesOptionsModel).execute();
    assertNotNull(response);
    QueryNoticesResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, queryCollectionNoticesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("filter"), "testString");
    assertEquals(query.get("query"), "testString");
    assertEquals(query.get("natural_language_query"), "testString");
    assertEquals(Long.valueOf(query.get("count")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
  }

  // Test the queryCollectionNotices operation with and without retries enabled
  @Test
  public void testQueryCollectionNoticesWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testQueryCollectionNoticesWOptions();

    discoveryService.disableRetries();
    testQueryCollectionNoticesWOptions();
  }

  // Test the queryCollectionNotices operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testQueryCollectionNoticesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.queryCollectionNotices(null).execute();
  }

  // Test the queryNotices operation with a valid options model parameter
  @Test
  public void testQueryNoticesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"matching_results\": 15, \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}]}";
    String queryNoticesPath = "/v2/projects/testString/notices";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the QueryNoticesOptions model
    QueryNoticesOptions queryNoticesOptionsModel =
        new QueryNoticesOptions.Builder()
            .projectId("testString")
            .filter("testString")
            .query("testString")
            .naturalLanguageQuery("testString")
            .count(Long.valueOf("26"))
            .offset(Long.valueOf("26"))
            .build();

    // Invoke queryNotices() with a valid options model and verify the result
    Response<QueryNoticesResponse> response =
        discoveryService.queryNotices(queryNoticesOptionsModel).execute();
    assertNotNull(response);
    QueryNoticesResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, queryNoticesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("filter"), "testString");
    assertEquals(query.get("query"), "testString");
    assertEquals(query.get("natural_language_query"), "testString");
    assertEquals(Long.valueOf(query.get("count")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
  }

  // Test the queryNotices operation with and without retries enabled
  @Test
  public void testQueryNoticesWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testQueryNoticesWOptions();

    discoveryService.disableRetries();
    testQueryNoticesWOptions();
  }

  // Test the queryNotices operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testQueryNoticesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.queryNotices(null).execute();
  }

  // Test the getStopwordList operation with a valid options model parameter
  @Test
  public void testGetStopwordListWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"stopwords\": [\"stopwords\"]}";
    String getStopwordListPath = "/v2/projects/testString/collections/testString/stopwords";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetStopwordListOptions model
    GetStopwordListOptions getStopwordListOptionsModel =
        new GetStopwordListOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .build();

    // Invoke getStopwordList() with a valid options model and verify the result
    Response<StopWordList> response =
        discoveryService.getStopwordList(getStopwordListOptionsModel).execute();
    assertNotNull(response);
    StopWordList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getStopwordListPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getStopwordList operation with and without retries enabled
  @Test
  public void testGetStopwordListWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetStopwordListWOptions();

    discoveryService.disableRetries();
    testGetStopwordListWOptions();
  }

  // Test the getStopwordList operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetStopwordListNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getStopwordList(null).execute();
  }

  // Test the createStopwordList operation with a valid options model parameter
  @Test
  public void testCreateStopwordListWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"stopwords\": [\"stopwords\"]}";
    String createStopwordListPath = "/v2/projects/testString/collections/testString/stopwords";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateStopwordListOptions model
    CreateStopwordListOptions createStopwordListOptionsModel =
        new CreateStopwordListOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .stopwords(java.util.Arrays.asList("testString"))
            .build();

    // Invoke createStopwordList() with a valid options model and verify the result
    Response<StopWordList> response =
        discoveryService.createStopwordList(createStopwordListOptionsModel).execute();
    assertNotNull(response);
    StopWordList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createStopwordListPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createStopwordList operation with and without retries enabled
  @Test
  public void testCreateStopwordListWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testCreateStopwordListWOptions();

    discoveryService.disableRetries();
    testCreateStopwordListWOptions();
  }

  // Test the createStopwordList operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateStopwordListNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.createStopwordList(null).execute();
  }

  // Test the deleteStopwordList operation with a valid options model parameter
  @Test
  public void testDeleteStopwordListWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteStopwordListPath = "/v2/projects/testString/collections/testString/stopwords";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteStopwordListOptions model
    DeleteStopwordListOptions deleteStopwordListOptionsModel =
        new DeleteStopwordListOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .build();

    // Invoke deleteStopwordList() with a valid options model and verify the result
    Response<Void> response =
        discoveryService.deleteStopwordList(deleteStopwordListOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteStopwordListPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteStopwordList operation with and without retries enabled
  @Test
  public void testDeleteStopwordListWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteStopwordListWOptions();

    discoveryService.disableRetries();
    testDeleteStopwordListWOptions();
  }

  // Test the deleteStopwordList operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteStopwordListNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteStopwordList(null).execute();
  }

  // Test the listExpansions operation with a valid options model parameter
  @Test
  public void testListExpansionsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"expansions\": [{\"input_terms\": [\"inputTerms\"], \"expanded_terms\": [\"expandedTerms\"]}]}";
    String listExpansionsPath = "/v2/projects/testString/collections/testString/expansions";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListExpansionsOptions model
    ListExpansionsOptions listExpansionsOptionsModel =
        new ListExpansionsOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .build();

    // Invoke listExpansions() with a valid options model and verify the result
    Response<Expansions> response =
        discoveryService.listExpansions(listExpansionsOptionsModel).execute();
    assertNotNull(response);
    Expansions responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listExpansionsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the listExpansions operation with and without retries enabled
  @Test
  public void testListExpansionsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testListExpansionsWOptions();

    discoveryService.disableRetries();
    testListExpansionsWOptions();
  }

  // Test the listExpansions operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListExpansionsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.listExpansions(null).execute();
  }

  // Test the createExpansions operation with a valid options model parameter
  @Test
  public void testCreateExpansionsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"expansions\": [{\"input_terms\": [\"inputTerms\"], \"expanded_terms\": [\"expandedTerms\"]}]}";
    String createExpansionsPath = "/v2/projects/testString/collections/testString/expansions";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the Expansion model
    Expansion expansionModel =
        new Expansion.Builder()
            .inputTerms(java.util.Arrays.asList("testString"))
            .expandedTerms(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the CreateExpansionsOptions model
    CreateExpansionsOptions createExpansionsOptionsModel =
        new CreateExpansionsOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .expansions(java.util.Arrays.asList(expansionModel))
            .build();

    // Invoke createExpansions() with a valid options model and verify the result
    Response<Expansions> response =
        discoveryService.createExpansions(createExpansionsOptionsModel).execute();
    assertNotNull(response);
    Expansions responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createExpansionsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createExpansions operation with and without retries enabled
  @Test
  public void testCreateExpansionsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testCreateExpansionsWOptions();

    discoveryService.disableRetries();
    testCreateExpansionsWOptions();
  }

  // Test the createExpansions operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateExpansionsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.createExpansions(null).execute();
  }

  // Test the deleteExpansions operation with a valid options model parameter
  @Test
  public void testDeleteExpansionsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteExpansionsPath = "/v2/projects/testString/collections/testString/expansions";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteExpansionsOptions model
    DeleteExpansionsOptions deleteExpansionsOptionsModel =
        new DeleteExpansionsOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .build();

    // Invoke deleteExpansions() with a valid options model and verify the result
    Response<Void> response =
        discoveryService.deleteExpansions(deleteExpansionsOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteExpansionsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteExpansions operation with and without retries enabled
  @Test
  public void testDeleteExpansionsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteExpansionsWOptions();

    discoveryService.disableRetries();
    testDeleteExpansionsWOptions();
  }

  // Test the deleteExpansions operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteExpansionsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteExpansions(null).execute();
  }

  // Test the getComponentSettings operation with a valid options model parameter
  @Test
  public void testGetComponentSettingsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"fields_shown\": {\"body\": {\"use_passage\": true, \"field\": \"field\"}, \"title\": {\"field\": \"field\"}}, \"autocomplete\": true, \"structured_search\": true, \"results_per_page\": 14, \"aggregations\": [{\"name\": \"name\", \"label\": \"label\", \"multiple_selections_allowed\": false, \"visualization_type\": \"auto\"}]}";
    String getComponentSettingsPath = "/v2/projects/testString/component_settings";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetComponentSettingsOptions model
    GetComponentSettingsOptions getComponentSettingsOptionsModel =
        new GetComponentSettingsOptions.Builder().projectId("testString").build();

    // Invoke getComponentSettings() with a valid options model and verify the result
    Response<ComponentSettingsResponse> response =
        discoveryService.getComponentSettings(getComponentSettingsOptionsModel).execute();
    assertNotNull(response);
    ComponentSettingsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getComponentSettingsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getComponentSettings operation with and without retries enabled
  @Test
  public void testGetComponentSettingsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetComponentSettingsWOptions();

    discoveryService.disableRetries();
    testGetComponentSettingsWOptions();
  }

  // Test the getComponentSettings operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetComponentSettingsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getComponentSettings(null).execute();
  }

  // Test the listTrainingQueries operation with a valid options model parameter
  @Test
  public void testListTrainingQueriesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"queries\": [{\"query_id\": \"queryId\", \"natural_language_query\": \"naturalLanguageQuery\", \"filter\": \"filter\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"examples\": [{\"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"relevance\": 9, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}]}";
    String listTrainingQueriesPath = "/v2/projects/testString/training_data/queries";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListTrainingQueriesOptions model
    ListTrainingQueriesOptions listTrainingQueriesOptionsModel =
        new ListTrainingQueriesOptions.Builder().projectId("testString").build();

    // Invoke listTrainingQueries() with a valid options model and verify the result
    Response<TrainingQuerySet> response =
        discoveryService.listTrainingQueries(listTrainingQueriesOptionsModel).execute();
    assertNotNull(response);
    TrainingQuerySet responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listTrainingQueriesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the listTrainingQueries operation with and without retries enabled
  @Test
  public void testListTrainingQueriesWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testListTrainingQueriesWOptions();

    discoveryService.disableRetries();
    testListTrainingQueriesWOptions();
  }

  // Test the listTrainingQueries operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTrainingQueriesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.listTrainingQueries(null).execute();
  }

  // Test the deleteTrainingQueries operation with a valid options model parameter
  @Test
  public void testDeleteTrainingQueriesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteTrainingQueriesPath = "/v2/projects/testString/training_data/queries";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteTrainingQueriesOptions model
    DeleteTrainingQueriesOptions deleteTrainingQueriesOptionsModel =
        new DeleteTrainingQueriesOptions.Builder().projectId("testString").build();

    // Invoke deleteTrainingQueries() with a valid options model and verify the result
    Response<Void> response =
        discoveryService.deleteTrainingQueries(deleteTrainingQueriesOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTrainingQueriesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteTrainingQueries operation with and without retries enabled
  @Test
  public void testDeleteTrainingQueriesWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteTrainingQueriesWOptions();

    discoveryService.disableRetries();
    testDeleteTrainingQueriesWOptions();
  }

  // Test the deleteTrainingQueries operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTrainingQueriesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteTrainingQueries(null).execute();
  }

  // Test the createTrainingQuery operation with a valid options model parameter
  @Test
  public void testCreateTrainingQueryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"query_id\": \"queryId\", \"natural_language_query\": \"naturalLanguageQuery\", \"filter\": \"filter\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"examples\": [{\"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"relevance\": 9, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}";
    String createTrainingQueryPath = "/v2/projects/testString/training_data/queries";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the TrainingExample model
    TrainingExample trainingExampleModel =
        new TrainingExample.Builder()
            .documentId("testString")
            .collectionId("testString")
            .relevance(Long.valueOf("26"))
            .build();

    // Construct an instance of the CreateTrainingQueryOptions model
    CreateTrainingQueryOptions createTrainingQueryOptionsModel =
        new CreateTrainingQueryOptions.Builder()
            .projectId("testString")
            .naturalLanguageQuery("testString")
            .examples(java.util.Arrays.asList(trainingExampleModel))
            .filter("testString")
            .build();

    // Invoke createTrainingQuery() with a valid options model and verify the result
    Response<TrainingQuery> response =
        discoveryService.createTrainingQuery(createTrainingQueryOptionsModel).execute();
    assertNotNull(response);
    TrainingQuery responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createTrainingQueryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createTrainingQuery operation with and without retries enabled
  @Test
  public void testCreateTrainingQueryWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testCreateTrainingQueryWOptions();

    discoveryService.disableRetries();
    testCreateTrainingQueryWOptions();
  }

  // Test the createTrainingQuery operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTrainingQueryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.createTrainingQuery(null).execute();
  }

  // Test the getTrainingQuery operation with a valid options model parameter
  @Test
  public void testGetTrainingQueryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"query_id\": \"queryId\", \"natural_language_query\": \"naturalLanguageQuery\", \"filter\": \"filter\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"examples\": [{\"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"relevance\": 9, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}";
    String getTrainingQueryPath = "/v2/projects/testString/training_data/queries/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetTrainingQueryOptions model
    GetTrainingQueryOptions getTrainingQueryOptionsModel =
        new GetTrainingQueryOptions.Builder().projectId("testString").queryId("testString").build();

    // Invoke getTrainingQuery() with a valid options model and verify the result
    Response<TrainingQuery> response =
        discoveryService.getTrainingQuery(getTrainingQueryOptionsModel).execute();
    assertNotNull(response);
    TrainingQuery responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTrainingQueryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getTrainingQuery operation with and without retries enabled
  @Test
  public void testGetTrainingQueryWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetTrainingQueryWOptions();

    discoveryService.disableRetries();
    testGetTrainingQueryWOptions();
  }

  // Test the getTrainingQuery operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTrainingQueryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getTrainingQuery(null).execute();
  }

  // Test the updateTrainingQuery operation with a valid options model parameter
  @Test
  public void testUpdateTrainingQueryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"query_id\": \"queryId\", \"natural_language_query\": \"naturalLanguageQuery\", \"filter\": \"filter\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"examples\": [{\"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"relevance\": 9, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}";
    String updateTrainingQueryPath = "/v2/projects/testString/training_data/queries/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the TrainingExample model
    TrainingExample trainingExampleModel =
        new TrainingExample.Builder()
            .documentId("testString")
            .collectionId("testString")
            .relevance(Long.valueOf("26"))
            .build();

    // Construct an instance of the UpdateTrainingQueryOptions model
    UpdateTrainingQueryOptions updateTrainingQueryOptionsModel =
        new UpdateTrainingQueryOptions.Builder()
            .projectId("testString")
            .queryId("testString")
            .naturalLanguageQuery("testString")
            .examples(java.util.Arrays.asList(trainingExampleModel))
            .filter("testString")
            .build();

    // Invoke updateTrainingQuery() with a valid options model and verify the result
    Response<TrainingQuery> response =
        discoveryService.updateTrainingQuery(updateTrainingQueryOptionsModel).execute();
    assertNotNull(response);
    TrainingQuery responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateTrainingQueryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the updateTrainingQuery operation with and without retries enabled
  @Test
  public void testUpdateTrainingQueryWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testUpdateTrainingQueryWOptions();

    discoveryService.disableRetries();
    testUpdateTrainingQueryWOptions();
  }

  // Test the updateTrainingQuery operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateTrainingQueryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.updateTrainingQuery(null).execute();
  }

  // Test the deleteTrainingQuery operation with a valid options model parameter
  @Test
  public void testDeleteTrainingQueryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteTrainingQueryPath = "/v2/projects/testString/training_data/queries/testString";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteTrainingQueryOptions model
    DeleteTrainingQueryOptions deleteTrainingQueryOptionsModel =
        new DeleteTrainingQueryOptions.Builder()
            .projectId("testString")
            .queryId("testString")
            .build();

    // Invoke deleteTrainingQuery() with a valid options model and verify the result
    Response<Void> response =
        discoveryService.deleteTrainingQuery(deleteTrainingQueryOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTrainingQueryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteTrainingQuery operation with and without retries enabled
  @Test
  public void testDeleteTrainingQueryWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteTrainingQueryWOptions();

    discoveryService.disableRetries();
    testDeleteTrainingQueryWOptions();
  }

  // Test the deleteTrainingQuery operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTrainingQueryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteTrainingQuery(null).execute();
  }

  // Test the listEnrichments operation with a valid options model parameter
  @Test
  public void testListEnrichmentsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"enrichments\": [{\"enrichment_id\": \"enrichmentId\", \"name\": \"name\", \"description\": \"description\", \"type\": \"part_of_speech\", \"options\": {\"languages\": [\"languages\"], \"entity_type\": \"entityType\", \"regular_expression\": \"regularExpression\", \"result_field\": \"resultField\", \"classifier_id\": \"classifierId\", \"model_id\": \"modelId\", \"confidence_threshold\": 0, \"top_k\": 4}}]}";
    String listEnrichmentsPath = "/v2/projects/testString/enrichments";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListEnrichmentsOptions model
    ListEnrichmentsOptions listEnrichmentsOptionsModel =
        new ListEnrichmentsOptions.Builder().projectId("testString").build();

    // Invoke listEnrichments() with a valid options model and verify the result
    Response<Enrichments> response =
        discoveryService.listEnrichments(listEnrichmentsOptionsModel).execute();
    assertNotNull(response);
    Enrichments responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listEnrichmentsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the listEnrichments operation with and without retries enabled
  @Test
  public void testListEnrichmentsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testListEnrichmentsWOptions();

    discoveryService.disableRetries();
    testListEnrichmentsWOptions();
  }

  // Test the listEnrichments operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListEnrichmentsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.listEnrichments(null).execute();
  }

  // Test the createEnrichment operation with a valid options model parameter
  @Test
  public void testCreateEnrichmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"enrichment_id\": \"enrichmentId\", \"name\": \"name\", \"description\": \"description\", \"type\": \"part_of_speech\", \"options\": {\"languages\": [\"languages\"], \"entity_type\": \"entityType\", \"regular_expression\": \"regularExpression\", \"result_field\": \"resultField\", \"classifier_id\": \"classifierId\", \"model_id\": \"modelId\", \"confidence_threshold\": 0, \"top_k\": 4}}";
    String createEnrichmentPath = "/v2/projects/testString/enrichments";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the EnrichmentOptions model
    EnrichmentOptions enrichmentOptionsModel =
        new EnrichmentOptions.Builder()
            .languages(java.util.Arrays.asList("testString"))
            .entityType("testString")
            .regularExpression("testString")
            .resultField("testString")
            .classifierId("testString")
            .modelId("testString")
            .confidenceThreshold(Double.valueOf("0"))
            .topK(Long.valueOf("26"))
            .build();

    // Construct an instance of the CreateEnrichment model
    CreateEnrichment createEnrichmentModel =
        new CreateEnrichment.Builder()
            .name("testString")
            .description("testString")
            .type("classifier")
            .options(enrichmentOptionsModel)
            .build();

    // Construct an instance of the CreateEnrichmentOptions model
    CreateEnrichmentOptions createEnrichmentOptionsModel =
        new CreateEnrichmentOptions.Builder()
            .projectId("testString")
            .enrichment(createEnrichmentModel)
            .file(TestUtilities.createMockStream("This is a mock file."))
            .build();

    // Invoke createEnrichment() with a valid options model and verify the result
    Response<Enrichment> response =
        discoveryService.createEnrichment(createEnrichmentOptionsModel).execute();
    assertNotNull(response);
    Enrichment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createEnrichmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createEnrichment operation with and without retries enabled
  @Test
  public void testCreateEnrichmentWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testCreateEnrichmentWOptions();

    discoveryService.disableRetries();
    testCreateEnrichmentWOptions();
  }

  // Test the createEnrichment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateEnrichmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.createEnrichment(null).execute();
  }

  // Test the getEnrichment operation with a valid options model parameter
  @Test
  public void testGetEnrichmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"enrichment_id\": \"enrichmentId\", \"name\": \"name\", \"description\": \"description\", \"type\": \"part_of_speech\", \"options\": {\"languages\": [\"languages\"], \"entity_type\": \"entityType\", \"regular_expression\": \"regularExpression\", \"result_field\": \"resultField\", \"classifier_id\": \"classifierId\", \"model_id\": \"modelId\", \"confidence_threshold\": 0, \"top_k\": 4}}";
    String getEnrichmentPath = "/v2/projects/testString/enrichments/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetEnrichmentOptions model
    GetEnrichmentOptions getEnrichmentOptionsModel =
        new GetEnrichmentOptions.Builder()
            .projectId("testString")
            .enrichmentId("testString")
            .build();

    // Invoke getEnrichment() with a valid options model and verify the result
    Response<Enrichment> response =
        discoveryService.getEnrichment(getEnrichmentOptionsModel).execute();
    assertNotNull(response);
    Enrichment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getEnrichmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getEnrichment operation with and without retries enabled
  @Test
  public void testGetEnrichmentWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetEnrichmentWOptions();

    discoveryService.disableRetries();
    testGetEnrichmentWOptions();
  }

  // Test the getEnrichment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetEnrichmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getEnrichment(null).execute();
  }

  // Test the updateEnrichment operation with a valid options model parameter
  @Test
  public void testUpdateEnrichmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"enrichment_id\": \"enrichmentId\", \"name\": \"name\", \"description\": \"description\", \"type\": \"part_of_speech\", \"options\": {\"languages\": [\"languages\"], \"entity_type\": \"entityType\", \"regular_expression\": \"regularExpression\", \"result_field\": \"resultField\", \"classifier_id\": \"classifierId\", \"model_id\": \"modelId\", \"confidence_threshold\": 0, \"top_k\": 4}}";
    String updateEnrichmentPath = "/v2/projects/testString/enrichments/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the UpdateEnrichmentOptions model
    UpdateEnrichmentOptions updateEnrichmentOptionsModel =
        new UpdateEnrichmentOptions.Builder()
            .projectId("testString")
            .enrichmentId("testString")
            .name("testString")
            .description("testString")
            .build();

    // Invoke updateEnrichment() with a valid options model and verify the result
    Response<Enrichment> response =
        discoveryService.updateEnrichment(updateEnrichmentOptionsModel).execute();
    assertNotNull(response);
    Enrichment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateEnrichmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the updateEnrichment operation with and without retries enabled
  @Test
  public void testUpdateEnrichmentWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testUpdateEnrichmentWOptions();

    discoveryService.disableRetries();
    testUpdateEnrichmentWOptions();
  }

  // Test the updateEnrichment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateEnrichmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.updateEnrichment(null).execute();
  }

  // Test the deleteEnrichment operation with a valid options model parameter
  @Test
  public void testDeleteEnrichmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteEnrichmentPath = "/v2/projects/testString/enrichments/testString";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteEnrichmentOptions model
    DeleteEnrichmentOptions deleteEnrichmentOptionsModel =
        new DeleteEnrichmentOptions.Builder()
            .projectId("testString")
            .enrichmentId("testString")
            .build();

    // Invoke deleteEnrichment() with a valid options model and verify the result
    Response<Void> response =
        discoveryService.deleteEnrichment(deleteEnrichmentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteEnrichmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteEnrichment operation with and without retries enabled
  @Test
  public void testDeleteEnrichmentWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteEnrichmentWOptions();

    discoveryService.disableRetries();
    testDeleteEnrichmentWOptions();
  }

  // Test the deleteEnrichment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteEnrichmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteEnrichment(null).execute();
  }

  // Test the listDocumentClassifiers operation with a valid options model parameter
  @Test
  public void testListDocumentClassifiersWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"classifiers\": [{\"classifier_id\": \"classifierId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"language\": \"en\", \"enrichments\": [{\"enrichment_id\": \"enrichmentId\", \"fields\": [\"fields\"]}], \"recognized_fields\": [\"recognizedFields\"], \"answer_field\": \"answerField\", \"training_data_file\": \"trainingDataFile\", \"test_data_file\": \"testDataFile\", \"federated_classification\": {\"field\": \"field\"}}]}";
    String listDocumentClassifiersPath = "/v2/projects/testString/document_classifiers";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListDocumentClassifiersOptions model
    ListDocumentClassifiersOptions listDocumentClassifiersOptionsModel =
        new ListDocumentClassifiersOptions.Builder().projectId("testString").build();

    // Invoke listDocumentClassifiers() with a valid options model and verify the result
    Response<DocumentClassifiers> response =
        discoveryService.listDocumentClassifiers(listDocumentClassifiersOptionsModel).execute();
    assertNotNull(response);
    DocumentClassifiers responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listDocumentClassifiersPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the listDocumentClassifiers operation with and without retries enabled
  @Test
  public void testListDocumentClassifiersWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testListDocumentClassifiersWOptions();

    discoveryService.disableRetries();
    testListDocumentClassifiersWOptions();
  }

  // Test the listDocumentClassifiers operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListDocumentClassifiersNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.listDocumentClassifiers(null).execute();
  }

  // Test the createDocumentClassifier operation with a valid options model parameter
  @Test
  public void testCreateDocumentClassifierWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"classifier_id\": \"classifierId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"language\": \"en\", \"enrichments\": [{\"enrichment_id\": \"enrichmentId\", \"fields\": [\"fields\"]}], \"recognized_fields\": [\"recognizedFields\"], \"answer_field\": \"answerField\", \"training_data_file\": \"trainingDataFile\", \"test_data_file\": \"testDataFile\", \"federated_classification\": {\"field\": \"field\"}}";
    String createDocumentClassifierPath = "/v2/projects/testString/document_classifiers";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the DocumentClassifierEnrichment model
    DocumentClassifierEnrichment documentClassifierEnrichmentModel =
        new DocumentClassifierEnrichment.Builder()
            .enrichmentId("testString")
            .fields(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the ClassifierFederatedModel model
    ClassifierFederatedModel classifierFederatedModelModel =
        new ClassifierFederatedModel.Builder().field("testString").build();

    // Construct an instance of the CreateDocumentClassifier model
    CreateDocumentClassifier createDocumentClassifierModel =
        new CreateDocumentClassifier.Builder()
            .name("testString")
            .description("testString")
            .language("en")
            .answerField("testString")
            .enrichments(java.util.Arrays.asList(documentClassifierEnrichmentModel))
            .federatedClassification(classifierFederatedModelModel)
            .build();

    // Construct an instance of the CreateDocumentClassifierOptions model
    CreateDocumentClassifierOptions createDocumentClassifierOptionsModel =
        new CreateDocumentClassifierOptions.Builder()
            .projectId("testString")
            .trainingData(TestUtilities.createMockStream("This is a mock file."))
            .classifier(createDocumentClassifierModel)
            .testData(TestUtilities.createMockStream("This is a mock file."))
            .build();

    // Invoke createDocumentClassifier() with a valid options model and verify the result
    Response<DocumentClassifier> response =
        discoveryService.createDocumentClassifier(createDocumentClassifierOptionsModel).execute();
    assertNotNull(response);
    DocumentClassifier responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createDocumentClassifierPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createDocumentClassifier operation with and without retries enabled
  @Test
  public void testCreateDocumentClassifierWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testCreateDocumentClassifierWOptions();

    discoveryService.disableRetries();
    testCreateDocumentClassifierWOptions();
  }

  // Test the createDocumentClassifier operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateDocumentClassifierNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.createDocumentClassifier(null).execute();
  }

  // Test the getDocumentClassifier operation with a valid options model parameter
  @Test
  public void testGetDocumentClassifierWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"classifier_id\": \"classifierId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"language\": \"en\", \"enrichments\": [{\"enrichment_id\": \"enrichmentId\", \"fields\": [\"fields\"]}], \"recognized_fields\": [\"recognizedFields\"], \"answer_field\": \"answerField\", \"training_data_file\": \"trainingDataFile\", \"test_data_file\": \"testDataFile\", \"federated_classification\": {\"field\": \"field\"}}";
    String getDocumentClassifierPath = "/v2/projects/testString/document_classifiers/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetDocumentClassifierOptions model
    GetDocumentClassifierOptions getDocumentClassifierOptionsModel =
        new GetDocumentClassifierOptions.Builder()
            .projectId("testString")
            .classifierId("testString")
            .build();

    // Invoke getDocumentClassifier() with a valid options model and verify the result
    Response<DocumentClassifier> response =
        discoveryService.getDocumentClassifier(getDocumentClassifierOptionsModel).execute();
    assertNotNull(response);
    DocumentClassifier responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDocumentClassifierPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getDocumentClassifier operation with and without retries enabled
  @Test
  public void testGetDocumentClassifierWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetDocumentClassifierWOptions();

    discoveryService.disableRetries();
    testGetDocumentClassifierWOptions();
  }

  // Test the getDocumentClassifier operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentClassifierNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getDocumentClassifier(null).execute();
  }

  // Test the updateDocumentClassifier operation with a valid options model parameter
  @Test
  public void testUpdateDocumentClassifierWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"classifier_id\": \"classifierId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"language\": \"en\", \"enrichments\": [{\"enrichment_id\": \"enrichmentId\", \"fields\": [\"fields\"]}], \"recognized_fields\": [\"recognizedFields\"], \"answer_field\": \"answerField\", \"training_data_file\": \"trainingDataFile\", \"test_data_file\": \"testDataFile\", \"federated_classification\": {\"field\": \"field\"}}";
    String updateDocumentClassifierPath = "/v2/projects/testString/document_classifiers/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the UpdateDocumentClassifier model
    UpdateDocumentClassifier updateDocumentClassifierModel =
        new UpdateDocumentClassifier.Builder().name("testString").description("testString").build();

    // Construct an instance of the UpdateDocumentClassifierOptions model
    UpdateDocumentClassifierOptions updateDocumentClassifierOptionsModel =
        new UpdateDocumentClassifierOptions.Builder()
            .projectId("testString")
            .classifierId("testString")
            .classifier(updateDocumentClassifierModel)
            .trainingData(TestUtilities.createMockStream("This is a mock file."))
            .testData(TestUtilities.createMockStream("This is a mock file."))
            .build();

    // Invoke updateDocumentClassifier() with a valid options model and verify the result
    Response<DocumentClassifier> response =
        discoveryService.updateDocumentClassifier(updateDocumentClassifierOptionsModel).execute();
    assertNotNull(response);
    DocumentClassifier responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateDocumentClassifierPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the updateDocumentClassifier operation with and without retries enabled
  @Test
  public void testUpdateDocumentClassifierWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testUpdateDocumentClassifierWOptions();

    discoveryService.disableRetries();
    testUpdateDocumentClassifierWOptions();
  }

  // Test the updateDocumentClassifier operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateDocumentClassifierNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.updateDocumentClassifier(null).execute();
  }

  // Test the deleteDocumentClassifier operation with a valid options model parameter
  @Test
  public void testDeleteDocumentClassifierWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteDocumentClassifierPath = "/v2/projects/testString/document_classifiers/testString";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteDocumentClassifierOptions model
    DeleteDocumentClassifierOptions deleteDocumentClassifierOptionsModel =
        new DeleteDocumentClassifierOptions.Builder()
            .projectId("testString")
            .classifierId("testString")
            .build();

    // Invoke deleteDocumentClassifier() with a valid options model and verify the result
    Response<Void> response =
        discoveryService.deleteDocumentClassifier(deleteDocumentClassifierOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteDocumentClassifierPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteDocumentClassifier operation with and without retries enabled
  @Test
  public void testDeleteDocumentClassifierWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteDocumentClassifierWOptions();

    discoveryService.disableRetries();
    testDeleteDocumentClassifierWOptions();
  }

  // Test the deleteDocumentClassifier operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDocumentClassifierNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteDocumentClassifier(null).execute();
  }

  // Test the listDocumentClassifierModels operation with a valid options model parameter
  @Test
  public void testListDocumentClassifierModelsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"models\": [{\"model_id\": \"modelId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"training_data_file\": \"trainingDataFile\", \"test_data_file\": \"testDataFile\", \"status\": \"training\", \"evaluation\": {\"micro_average\": {\"precision\": 0, \"recall\": 0, \"f1\": 0}, \"macro_average\": {\"precision\": 0, \"recall\": 0, \"f1\": 0}, \"per_class\": [{\"name\": \"name\", \"precision\": 0, \"recall\": 0, \"f1\": 0}]}, \"enrichment_id\": \"enrichmentId\", \"deployed_at\": \"2019-01-01T12:00:00.000Z\"}]}";
    String listDocumentClassifierModelsPath =
        "/v2/projects/testString/document_classifiers/testString/models";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListDocumentClassifierModelsOptions model
    ListDocumentClassifierModelsOptions listDocumentClassifierModelsOptionsModel =
        new ListDocumentClassifierModelsOptions.Builder()
            .projectId("testString")
            .classifierId("testString")
            .build();

    // Invoke listDocumentClassifierModels() with a valid options model and verify the result
    Response<DocumentClassifierModels> response =
        discoveryService
            .listDocumentClassifierModels(listDocumentClassifierModelsOptionsModel)
            .execute();
    assertNotNull(response);
    DocumentClassifierModels responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listDocumentClassifierModelsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the listDocumentClassifierModels operation with and without retries enabled
  @Test
  public void testListDocumentClassifierModelsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testListDocumentClassifierModelsWOptions();

    discoveryService.disableRetries();
    testListDocumentClassifierModelsWOptions();
  }

  // Test the listDocumentClassifierModels operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListDocumentClassifierModelsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.listDocumentClassifierModels(null).execute();
  }

  // Test the createDocumentClassifierModel operation with a valid options model parameter
  @Test
  public void testCreateDocumentClassifierModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"model_id\": \"modelId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"training_data_file\": \"trainingDataFile\", \"test_data_file\": \"testDataFile\", \"status\": \"training\", \"evaluation\": {\"micro_average\": {\"precision\": 0, \"recall\": 0, \"f1\": 0}, \"macro_average\": {\"precision\": 0, \"recall\": 0, \"f1\": 0}, \"per_class\": [{\"name\": \"name\", \"precision\": 0, \"recall\": 0, \"f1\": 0}]}, \"enrichment_id\": \"enrichmentId\", \"deployed_at\": \"2019-01-01T12:00:00.000Z\"}";
    String createDocumentClassifierModelPath =
        "/v2/projects/testString/document_classifiers/testString/models";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateDocumentClassifierModelOptions model
    CreateDocumentClassifierModelOptions createDocumentClassifierModelOptionsModel =
        new CreateDocumentClassifierModelOptions.Builder()
            .projectId("testString")
            .classifierId("testString")
            .name("testString")
            .description("testString")
            .learningRate(Double.valueOf("0"))
            .l1RegularizationStrengths(java.util.Arrays.asList(Double.valueOf("1.0E-6")))
            .l2RegularizationStrengths(java.util.Arrays.asList(Double.valueOf("1.0E-6")))
            .trainingMaxSteps(Long.valueOf("0"))
            .improvementRatio(Double.valueOf("0"))
            .build();

    // Invoke createDocumentClassifierModel() with a valid options model and verify the result
    Response<DocumentClassifierModel> response =
        discoveryService
            .createDocumentClassifierModel(createDocumentClassifierModelOptionsModel)
            .execute();
    assertNotNull(response);
    DocumentClassifierModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createDocumentClassifierModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createDocumentClassifierModel operation with and without retries enabled
  @Test
  public void testCreateDocumentClassifierModelWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testCreateDocumentClassifierModelWOptions();

    discoveryService.disableRetries();
    testCreateDocumentClassifierModelWOptions();
  }

  // Test the createDocumentClassifierModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateDocumentClassifierModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.createDocumentClassifierModel(null).execute();
  }

  // Test the getDocumentClassifierModel operation with a valid options model parameter
  @Test
  public void testGetDocumentClassifierModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"model_id\": \"modelId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"training_data_file\": \"trainingDataFile\", \"test_data_file\": \"testDataFile\", \"status\": \"training\", \"evaluation\": {\"micro_average\": {\"precision\": 0, \"recall\": 0, \"f1\": 0}, \"macro_average\": {\"precision\": 0, \"recall\": 0, \"f1\": 0}, \"per_class\": [{\"name\": \"name\", \"precision\": 0, \"recall\": 0, \"f1\": 0}]}, \"enrichment_id\": \"enrichmentId\", \"deployed_at\": \"2019-01-01T12:00:00.000Z\"}";
    String getDocumentClassifierModelPath =
        "/v2/projects/testString/document_classifiers/testString/models/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetDocumentClassifierModelOptions model
    GetDocumentClassifierModelOptions getDocumentClassifierModelOptionsModel =
        new GetDocumentClassifierModelOptions.Builder()
            .projectId("testString")
            .classifierId("testString")
            .modelId("testString")
            .build();

    // Invoke getDocumentClassifierModel() with a valid options model and verify the result
    Response<DocumentClassifierModel> response =
        discoveryService
            .getDocumentClassifierModel(getDocumentClassifierModelOptionsModel)
            .execute();
    assertNotNull(response);
    DocumentClassifierModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getDocumentClassifierModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getDocumentClassifierModel operation with and without retries enabled
  @Test
  public void testGetDocumentClassifierModelWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetDocumentClassifierModelWOptions();

    discoveryService.disableRetries();
    testGetDocumentClassifierModelWOptions();
  }

  // Test the getDocumentClassifierModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentClassifierModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getDocumentClassifierModel(null).execute();
  }

  // Test the updateDocumentClassifierModel operation with a valid options model parameter
  @Test
  public void testUpdateDocumentClassifierModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"model_id\": \"modelId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"training_data_file\": \"trainingDataFile\", \"test_data_file\": \"testDataFile\", \"status\": \"training\", \"evaluation\": {\"micro_average\": {\"precision\": 0, \"recall\": 0, \"f1\": 0}, \"macro_average\": {\"precision\": 0, \"recall\": 0, \"f1\": 0}, \"per_class\": [{\"name\": \"name\", \"precision\": 0, \"recall\": 0, \"f1\": 0}]}, \"enrichment_id\": \"enrichmentId\", \"deployed_at\": \"2019-01-01T12:00:00.000Z\"}";
    String updateDocumentClassifierModelPath =
        "/v2/projects/testString/document_classifiers/testString/models/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the UpdateDocumentClassifierModelOptions model
    UpdateDocumentClassifierModelOptions updateDocumentClassifierModelOptionsModel =
        new UpdateDocumentClassifierModelOptions.Builder()
            .projectId("testString")
            .classifierId("testString")
            .modelId("testString")
            .name("testString")
            .description("testString")
            .build();

    // Invoke updateDocumentClassifierModel() with a valid options model and verify the result
    Response<DocumentClassifierModel> response =
        discoveryService
            .updateDocumentClassifierModel(updateDocumentClassifierModelOptionsModel)
            .execute();
    assertNotNull(response);
    DocumentClassifierModel responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateDocumentClassifierModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the updateDocumentClassifierModel operation with and without retries enabled
  @Test
  public void testUpdateDocumentClassifierModelWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testUpdateDocumentClassifierModelWOptions();

    discoveryService.disableRetries();
    testUpdateDocumentClassifierModelWOptions();
  }

  // Test the updateDocumentClassifierModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateDocumentClassifierModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.updateDocumentClassifierModel(null).execute();
  }

  // Test the deleteDocumentClassifierModel operation with a valid options model parameter
  @Test
  public void testDeleteDocumentClassifierModelWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteDocumentClassifierModelPath =
        "/v2/projects/testString/document_classifiers/testString/models/testString";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteDocumentClassifierModelOptions model
    DeleteDocumentClassifierModelOptions deleteDocumentClassifierModelOptionsModel =
        new DeleteDocumentClassifierModelOptions.Builder()
            .projectId("testString")
            .classifierId("testString")
            .modelId("testString")
            .build();

    // Invoke deleteDocumentClassifierModel() with a valid options model and verify the result
    Response<Void> response =
        discoveryService
            .deleteDocumentClassifierModel(deleteDocumentClassifierModelOptionsModel)
            .execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteDocumentClassifierModelPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteDocumentClassifierModel operation with and without retries enabled
  @Test
  public void testDeleteDocumentClassifierModelWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteDocumentClassifierModelWOptions();

    discoveryService.disableRetries();
    testDeleteDocumentClassifierModelWOptions();
  }

  // Test the deleteDocumentClassifierModel operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDocumentClassifierModelNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteDocumentClassifierModel(null).execute();
  }

  // Test the analyzeDocument operation with a valid options model parameter
  @Test
  public void testAnalyzeDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}], \"result\": {\"metadata\": {\"anyKey\": \"anyValue\"}}}";
    String analyzeDocumentPath = "/v2/projects/testString/collections/testString/analyze";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the AnalyzeDocumentOptions model
    AnalyzeDocumentOptions analyzeDocumentOptionsModel =
        new AnalyzeDocumentOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .file(TestUtilities.createMockStream("This is a mock file."))
            .filename("testString")
            .fileContentType("application/json")
            .metadata("testString")
            .build();

    // Invoke analyzeDocument() with a valid options model and verify the result
    Response<AnalyzedDocument> response =
        discoveryService.analyzeDocument(analyzeDocumentOptionsModel).execute();
    assertNotNull(response);
    AnalyzedDocument responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, analyzeDocumentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the analyzeDocument operation with and without retries enabled
  @Test
  public void testAnalyzeDocumentWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testAnalyzeDocumentWOptions();

    discoveryService.disableRetries();
    testAnalyzeDocumentWOptions();
  }

  // Test the analyzeDocument operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAnalyzeDocumentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.analyzeDocument(null).execute();
  }

  // Test the deleteUserData operation with a valid options model parameter
  @Test
  public void testDeleteUserDataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteUserDataPath = "/v2/user_data";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteUserDataOptions model
    DeleteUserDataOptions deleteUserDataOptionsModel =
        new DeleteUserDataOptions.Builder().customerId("testString").build();

    // Invoke deleteUserData() with a valid options model and verify the result
    Response<Void> response = discoveryService.deleteUserData(deleteUserDataOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteUserDataPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("customer_id"), "testString");
  }

  // Test the deleteUserData operation with and without retries enabled
  @Test
  public void testDeleteUserDataWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteUserDataWOptions();

    discoveryService.disableRetries();
    testDeleteUserDataWOptions();
  }

  // Test the deleteUserData operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteUserDataNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteUserData(null).execute();
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
    discoveryService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    final Authenticator authenticator = new NoAuthAuthenticator();
    discoveryService = new Discovery(version, serviceName, authenticator);
    String url = server.url("/").toString();
    discoveryService.setServiceUrl(url);
  }
}

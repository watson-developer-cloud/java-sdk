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
import com.ibm.watson.discovery.v2.model.CollectionDetails;
import com.ibm.watson.discovery.v2.model.CollectionEnrichment;
import com.ibm.watson.discovery.v2.model.Completions;
import com.ibm.watson.discovery.v2.model.ComponentSettingsResponse;
import com.ibm.watson.discovery.v2.model.CreateCollectionOptions;
import com.ibm.watson.discovery.v2.model.CreateEnrichment;
import com.ibm.watson.discovery.v2.model.CreateEnrichmentOptions;
import com.ibm.watson.discovery.v2.model.CreateProjectOptions;
import com.ibm.watson.discovery.v2.model.CreateTrainingQueryOptions;
import com.ibm.watson.discovery.v2.model.DefaultQueryParams;
import com.ibm.watson.discovery.v2.model.DefaultQueryParamsPassages;
import com.ibm.watson.discovery.v2.model.DefaultQueryParamsSuggestedRefinements;
import com.ibm.watson.discovery.v2.model.DefaultQueryParamsTableResults;
import com.ibm.watson.discovery.v2.model.DeleteCollectionOptions;
import com.ibm.watson.discovery.v2.model.DeleteDocumentOptions;
import com.ibm.watson.discovery.v2.model.DeleteDocumentResponse;
import com.ibm.watson.discovery.v2.model.DeleteEnrichmentOptions;
import com.ibm.watson.discovery.v2.model.DeleteProjectOptions;
import com.ibm.watson.discovery.v2.model.DeleteTrainingQueriesOptions;
import com.ibm.watson.discovery.v2.model.DeleteUserDataOptions;
import com.ibm.watson.discovery.v2.model.DocumentAccepted;
import com.ibm.watson.discovery.v2.model.Enrichment;
import com.ibm.watson.discovery.v2.model.EnrichmentOptions;
import com.ibm.watson.discovery.v2.model.Enrichments;
import com.ibm.watson.discovery.v2.model.GetAutocompletionOptions;
import com.ibm.watson.discovery.v2.model.GetCollectionOptions;
import com.ibm.watson.discovery.v2.model.GetComponentSettingsOptions;
import com.ibm.watson.discovery.v2.model.GetEnrichmentOptions;
import com.ibm.watson.discovery.v2.model.GetProjectOptions;
import com.ibm.watson.discovery.v2.model.GetTrainingQueryOptions;
import com.ibm.watson.discovery.v2.model.ListCollectionsOptions;
import com.ibm.watson.discovery.v2.model.ListCollectionsResponse;
import com.ibm.watson.discovery.v2.model.ListEnrichmentsOptions;
import com.ibm.watson.discovery.v2.model.ListFieldsOptions;
import com.ibm.watson.discovery.v2.model.ListFieldsResponse;
import com.ibm.watson.discovery.v2.model.ListProjectsOptions;
import com.ibm.watson.discovery.v2.model.ListProjectsResponse;
import com.ibm.watson.discovery.v2.model.ListTrainingQueriesOptions;
import com.ibm.watson.discovery.v2.model.ProjectDetails;
import com.ibm.watson.discovery.v2.model.QueryLargePassages;
import com.ibm.watson.discovery.v2.model.QueryLargeSuggestedRefinements;
import com.ibm.watson.discovery.v2.model.QueryLargeTableResults;
import com.ibm.watson.discovery.v2.model.QueryNoticesOptions;
import com.ibm.watson.discovery.v2.model.QueryNoticesResponse;
import com.ibm.watson.discovery.v2.model.QueryOptions;
import com.ibm.watson.discovery.v2.model.QueryResponse;
import com.ibm.watson.discovery.v2.model.TrainingExample;
import com.ibm.watson.discovery.v2.model.TrainingQuery;
import com.ibm.watson.discovery.v2.model.TrainingQuerySet;
import com.ibm.watson.discovery.v2.model.UpdateCollectionOptions;
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

  public void constructClientService() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    final Authenticator authenticator = new NoAuthAuthenticator();

    discoveryService = new Discovery(version, serviceName, authenticator);
    String url = server.url("/").toString();
    discoveryService.setServiceUrl(url);
  }

  /** Negative Test - construct the service with a null authenticator. */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    new Discovery(version, serviceName, null);
  }

  @Test
  public void testGetVersion() throws Throwable {
    constructClientService();
    assertEquals(discoveryService.getVersion(), "testString");
  }

  @Test
  public void testListCollectionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"collections\": [{\"collection_id\": \"collectionId\", \"name\": \"name\"}]}";
    String listCollectionsPath = "/v2/projects/testString/collections";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListCollectionsOptions model
    ListCollectionsOptions listCollectionsOptionsModel =
        new ListCollectionsOptions.Builder().projectId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<ListCollectionsResponse> response =
        discoveryService.listCollections(listCollectionsOptionsModel).execute();
    assertNotNull(response);
    ListCollectionsResponse responseObj = response.getResult();
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

  // Test the listCollections operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListCollectionsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.listCollections(null).execute();
  }

  @Test
  public void testCreateCollectionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00\", \"language\": \"language\", \"enrichments\": [{\"enrichment_id\": \"enrichmentId\", \"fields\": [\"fields\"]}]}";
    String createCollectionPath = "/v2/projects/testString/collections";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CollectionEnrichment model
    CollectionEnrichment collectionEnrichmentModel =
        new CollectionEnrichment.Builder()
            .enrichmentId("testString")
            .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the CreateCollectionOptions model
    CreateCollectionOptions createCollectionOptionsModel =
        new CreateCollectionOptions.Builder()
            .projectId("testString")
            .name("testString")
            .description("testString")
            .language("testString")
            .enrichments(
                new java.util.ArrayList<CollectionEnrichment>(
                    java.util.Arrays.asList(collectionEnrichmentModel)))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<CollectionDetails> response =
        discoveryService.createCollection(createCollectionOptionsModel).execute();
    assertNotNull(response);
    CollectionDetails responseObj = response.getResult();
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

  // Test the createCollection operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCollectionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.createCollection(null).execute();
  }

  @Test
  public void testGetCollectionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00\", \"language\": \"language\", \"enrichments\": [{\"enrichment_id\": \"enrichmentId\", \"fields\": [\"fields\"]}]}";
    String getCollectionPath = "/v2/projects/testString/collections/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCollectionOptions model
    GetCollectionOptions getCollectionOptionsModel =
        new GetCollectionOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<CollectionDetails> response =
        discoveryService.getCollection(getCollectionOptionsModel).execute();
    assertNotNull(response);
    CollectionDetails responseObj = response.getResult();
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
    discoveryService.getCollection(null).execute();
  }

  @Test
  public void testUpdateCollectionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00\", \"language\": \"language\", \"enrichments\": [{\"enrichment_id\": \"enrichmentId\", \"fields\": [\"fields\"]}]}";
    String updateCollectionPath = "/v2/projects/testString/collections/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CollectionEnrichment model
    CollectionEnrichment collectionEnrichmentModel =
        new CollectionEnrichment.Builder()
            .enrichmentId("testString")
            .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the UpdateCollectionOptions model
    UpdateCollectionOptions updateCollectionOptionsModel =
        new UpdateCollectionOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .name("testString")
            .description("testString")
            .enrichments(
                new java.util.ArrayList<CollectionEnrichment>(
                    java.util.Arrays.asList(collectionEnrichmentModel)))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<CollectionDetails> response =
        discoveryService.updateCollection(updateCollectionOptionsModel).execute();
    assertNotNull(response);
    CollectionDetails responseObj = response.getResult();
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
    discoveryService.updateCollection(null).execute();
  }

  @Test
  public void testDeleteCollectionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteCollectionPath = "/v2/projects/testString/collections/testString";

    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteCollectionOptions model
    DeleteCollectionOptions deleteCollectionOptionsModel =
        new DeleteCollectionOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        discoveryService.deleteCollection(deleteCollectionOptionsModel).execute();
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
    discoveryService.deleteCollection(null).execute();
  }

  @Test
  public void testQueryWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"matching_results\": 15, \"results\": [{\"document_id\": \"documentId\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"result_metadata\": {\"document_retrieval_source\": \"search\", \"collection_id\": \"collectionId\", \"confidence\": 10}, \"document_passages\": [{\"passage_text\": \"passageText\", \"start_offset\": 11, \"end_offset\": 9, \"field\": \"field\"}]}], \"aggregations\": [{\"type\": \"filter\", \"match\": \"match\", \"matching_results\": 15}], \"retrieval_details\": {\"document_retrieval_strategy\": \"untrained\"}, \"suggested_query\": \"suggestedQuery\", \"suggested_refinements\": [{\"text\": \"text\"}], \"table_results\": [{\"table_id\": \"tableId\", \"source_document_id\": \"sourceDocumentId\", \"collection_id\": \"collectionId\", \"table_html\": \"tableHtml\", \"table_html_offset\": 15, \"table\": {\"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"section_title\": {\"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}, \"title\": {\"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}, \"table_headers\": [{\"cell_id\": \"cellId\", \"location\": {\"mapKey\": \"anyValue\"}, \"text\": \"text\", \"row_index_begin\": 13, \"row_index_end\": 11, \"column_index_begin\": 16, \"column_index_end\": 14}], \"row_headers\": [{\"cell_id\": \"cellId\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"text_normalized\": \"textNormalized\", \"row_index_begin\": 13, \"row_index_end\": 11, \"column_index_begin\": 16, \"column_index_end\": 14}], \"column_headers\": [{\"cell_id\": \"cellId\", \"location\": {\"mapKey\": \"anyValue\"}, \"text\": \"text\", \"text_normalized\": \"textNormalized\", \"row_index_begin\": 13, \"row_index_end\": 11, \"column_index_begin\": 16, \"column_index_end\": 14}], \"key_value_pairs\": [{\"key\": {\"cell_id\": \"cellId\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\"}, \"value\": [{\"cell_id\": \"cellId\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\"}]}], \"body_cells\": [{\"cell_id\": \"cellId\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"row_index_begin\": 13, \"row_index_end\": 11, \"column_index_begin\": 16, \"column_index_end\": 14, \"row_header_ids\": [{\"id\": \"id\"}], \"row_header_texts\": [{\"text\": \"text\"}], \"row_header_texts_normalized\": [{\"text_normalized\": \"textNormalized\"}], \"column_header_ids\": [{\"id\": \"id\"}], \"column_header_texts\": [{\"text\": \"text\"}], \"column_header_texts_normalized\": [{\"text_normalized\": \"textNormalized\"}], \"attributes\": [{\"type\": \"type\", \"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}]}], \"contexts\": [{\"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}]}}], \"passages\": [{\"passage_text\": \"passageText\", \"passage_score\": 12, \"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"start_offset\": 11, \"end_offset\": 9, \"field\": \"field\"}]}";
    String queryPath = "/v2/projects/testString/query";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

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
            .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .count(Long.valueOf("100"))
            .characters(Long.valueOf("50"))
            .build();

    // Construct an instance of the QueryOptions model
    QueryOptions queryOptionsModel =
        new QueryOptions.Builder()
            .projectId("testString")
            .collectionIds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .filter("testString")
            .query("testString")
            .naturalLanguageQuery("testString")
            .aggregation("testString")
            .count(Long.valueOf("26"))
            .xReturn(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .offset(Long.valueOf("26"))
            .sort("testString")
            .highlight(true)
            .spellingSuggestions(true)
            .tableResults(queryLargeTableResultsModel)
            .suggestedRefinements(queryLargeSuggestedRefinementsModel)
            .passages(queryLargePassagesModel)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<QueryResponse> response = discoveryService.query(queryOptionsModel).execute();
    assertNotNull(response);
    QueryResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, queryPath);
  }

  // Test the query operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testQueryNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.query(null).execute();
  }

  @Test
  public void testGetAutocompletionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"completions\": [\"completions\"]}";
    String getAutocompletionPath = "/v2/projects/testString/autocompletion";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAutocompletionOptions model
    GetAutocompletionOptions getAutocompletionOptionsModel =
        new GetAutocompletionOptions.Builder()
            .projectId("testString")
            .prefix("testString")
            .collectionIds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .field("testString")
            .count(Long.valueOf("26"))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Completions> response =
        discoveryService.getAutocompletion(getAutocompletionOptionsModel).execute();
    assertNotNull(response);
    Completions responseObj = response.getResult();
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
    assertEquals(query.get("prefix"), "testString");
    assertEquals(
        query.get("collection_ids"),
        RequestUtils.join(
            new java.util.ArrayList<String>(java.util.Arrays.asList("testString")), ","));
    assertEquals(query.get("field"), "testString");
    assertEquals(Long.valueOf(query.get("count")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAutocompletionPath);
  }

  // Test the getAutocompletion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAutocompletionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.getAutocompletion(null).execute();
  }

  @Test
  public void testQueryNoticesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"matching_results\": 15, \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00\", \"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}]}";
    String queryNoticesPath = "/v2/projects/testString/notices";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

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

    // Invoke operation with valid options model (positive test)
    Response<QueryNoticesResponse> response =
        discoveryService.queryNotices(queryNoticesOptionsModel).execute();
    assertNotNull(response);
    QueryNoticesResponse responseObj = response.getResult();
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
    assertEquals(query.get("filter"), "testString");
    assertEquals(query.get("query"), "testString");
    assertEquals(query.get("natural_language_query"), "testString");
    assertEquals(Long.valueOf(query.get("count")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, queryNoticesPath);
  }

  // Test the queryNotices operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testQueryNoticesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.queryNotices(null).execute();
  }

  @Test
  public void testListFieldsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"fields\": [{\"field\": \"field\", \"type\": \"nested\", \"collection_id\": \"collectionId\"}]}";
    String listFieldsPath = "/v2/projects/testString/fields";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListFieldsOptions model
    ListFieldsOptions listFieldsOptionsModel =
        new ListFieldsOptions.Builder()
            .projectId("testString")
            .collectionIds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ListFieldsResponse> response =
        discoveryService.listFields(listFieldsOptionsModel).execute();
    assertNotNull(response);
    ListFieldsResponse responseObj = response.getResult();
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
    assertEquals(
        query.get("collection_ids"),
        RequestUtils.join(
            new java.util.ArrayList<String>(java.util.Arrays.asList("testString")), ","));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listFieldsPath);
  }

  // Test the listFields operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListFieldsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.listFields(null).execute();
  }

  @Test
  public void testGetComponentSettingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"fields_shown\": {\"body\": {\"use_passage\": true, \"field\": \"field\"}, \"title\": {\"field\": \"field\"}}, \"autocomplete\": true, \"structured_search\": true, \"results_per_page\": 14, \"aggregations\": [{\"name\": \"name\", \"label\": \"label\", \"multiple_selections_allowed\": false, \"visualization_type\": \"auto\"}]}";
    String getComponentSettingsPath = "/v2/projects/testString/component_settings";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetComponentSettingsOptions model
    GetComponentSettingsOptions getComponentSettingsOptionsModel =
        new GetComponentSettingsOptions.Builder().projectId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<ComponentSettingsResponse> response =
        discoveryService.getComponentSettings(getComponentSettingsOptionsModel).execute();
    assertNotNull(response);
    ComponentSettingsResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, getComponentSettingsPath);
  }

  // Test the getComponentSettings operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetComponentSettingsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.getComponentSettings(null).execute();
  }

  @Test
  public void testAddDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"document_id\": \"documentId\", \"status\": \"processing\"}";
    String addDocumentPath = "/v2/projects/testString/collections/testString/documents";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AddDocumentOptions model
    AddDocumentOptions addDocumentOptionsModel =
        new AddDocumentOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .file(TestUtilities.createMockStream("This is a mock file."))
            .filename("testString")
            .fileContentType("application/json")
            .metadata("testString")
            .xWatsonDiscoveryForce(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentAccepted> response =
        discoveryService.addDocument(addDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentAccepted responseObj = response.getResult();
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
    assertEquals(parsedPath, addDocumentPath);
  }

  // Test the addDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.addDocument(null).execute();
  }

  @Test
  public void testUpdateDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"document_id\": \"documentId\", \"status\": \"processing\"}";
    String updateDocumentPath =
        "/v2/projects/testString/collections/testString/documents/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    constructClientService();

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
            .xWatsonDiscoveryForce(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentAccepted> response =
        discoveryService.updateDocument(updateDocumentOptionsModel).execute();
    assertNotNull(response);
    DocumentAccepted responseObj = response.getResult();
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
    assertEquals(parsedPath, updateDocumentPath);
  }

  // Test the updateDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.updateDocument(null).execute();
  }

  @Test
  public void testDeleteDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"document_id\": \"documentId\", \"status\": \"deleted\"}";
    String deleteDocumentPath =
        "/v2/projects/testString/collections/testString/documents/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteDocumentOptions model
    DeleteDocumentOptions deleteDocumentOptionsModel =
        new DeleteDocumentOptions.Builder()
            .projectId("testString")
            .collectionId("testString")
            .documentId("testString")
            .xWatsonDiscoveryForce(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteDocumentResponse> response =
        discoveryService.deleteDocument(deleteDocumentOptionsModel).execute();
    assertNotNull(response);
    DeleteDocumentResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, deleteDocumentPath);
  }

  // Test the deleteDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.deleteDocument(null).execute();
  }

  @Test
  public void testListTrainingQueriesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"queries\": [{\"query_id\": \"queryId\", \"natural_language_query\": \"naturalLanguageQuery\", \"filter\": \"filter\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"examples\": [{\"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"relevance\": 9, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}]}";
    String listTrainingQueriesPath = "/v2/projects/testString/training_data/queries";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListTrainingQueriesOptions model
    ListTrainingQueriesOptions listTrainingQueriesOptionsModel =
        new ListTrainingQueriesOptions.Builder().projectId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<TrainingQuerySet> response =
        discoveryService.listTrainingQueries(listTrainingQueriesOptionsModel).execute();
    assertNotNull(response);
    TrainingQuerySet responseObj = response.getResult();
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
    assertEquals(parsedPath, listTrainingQueriesPath);
  }

  // Test the listTrainingQueries operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTrainingQueriesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.listTrainingQueries(null).execute();
  }

  @Test
  public void testDeleteTrainingQueriesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteTrainingQueriesPath = "/v2/projects/testString/training_data/queries";

    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteTrainingQueriesOptions model
    DeleteTrainingQueriesOptions deleteTrainingQueriesOptionsModel =
        new DeleteTrainingQueriesOptions.Builder().projectId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        discoveryService.deleteTrainingQueries(deleteTrainingQueriesOptionsModel).execute();
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
    assertEquals(parsedPath, deleteTrainingQueriesPath);
  }

  // Test the deleteTrainingQueries operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTrainingQueriesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.deleteTrainingQueries(null).execute();
  }

  @Test
  public void testCreateTrainingQueryWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"query_id\": \"queryId\", \"natural_language_query\": \"naturalLanguageQuery\", \"filter\": \"filter\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"examples\": [{\"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"relevance\": 9, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}";
    String createTrainingQueryPath = "/v2/projects/testString/training_data/queries";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

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
            .examples(
                new java.util.ArrayList<TrainingExample>(
                    java.util.Arrays.asList(trainingExampleModel)))
            .filter("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TrainingQuery> response =
        discoveryService.createTrainingQuery(createTrainingQueryOptionsModel).execute();
    assertNotNull(response);
    TrainingQuery responseObj = response.getResult();
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
    assertEquals(parsedPath, createTrainingQueryPath);
  }

  // Test the createTrainingQuery operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTrainingQueryNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.createTrainingQuery(null).execute();
  }

  @Test
  public void testGetTrainingQueryWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"query_id\": \"queryId\", \"natural_language_query\": \"naturalLanguageQuery\", \"filter\": \"filter\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"examples\": [{\"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"relevance\": 9, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}";
    String getTrainingQueryPath = "/v2/projects/testString/training_data/queries/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetTrainingQueryOptions model
    GetTrainingQueryOptions getTrainingQueryOptionsModel =
        new GetTrainingQueryOptions.Builder().projectId("testString").queryId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<TrainingQuery> response =
        discoveryService.getTrainingQuery(getTrainingQueryOptionsModel).execute();
    assertNotNull(response);
    TrainingQuery responseObj = response.getResult();
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
    assertEquals(parsedPath, getTrainingQueryPath);
  }

  // Test the getTrainingQuery operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTrainingQueryNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.getTrainingQuery(null).execute();
  }

  @Test
  public void testUpdateTrainingQueryWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"query_id\": \"queryId\", \"natural_language_query\": \"naturalLanguageQuery\", \"filter\": \"filter\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"examples\": [{\"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"relevance\": 9, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}";
    String updateTrainingQueryPath = "/v2/projects/testString/training_data/queries/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

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
            .examples(
                new java.util.ArrayList<TrainingExample>(
                    java.util.Arrays.asList(trainingExampleModel)))
            .filter("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TrainingQuery> response =
        discoveryService.updateTrainingQuery(updateTrainingQueryOptionsModel).execute();
    assertNotNull(response);
    TrainingQuery responseObj = response.getResult();
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
    assertEquals(parsedPath, updateTrainingQueryPath);
  }

  // Test the updateTrainingQuery operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateTrainingQueryNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.updateTrainingQuery(null).execute();
  }

  @Test
  public void testAnalyzeDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00\", \"document_id\": \"documentId\", \"collection_id\": \"collectionId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}], \"result\": {\"metadata\": {\"mapKey\": \"anyValue\"}}}";
    String analyzeDocumentPath = "/v2/projects/testString/collections/testString/analyze";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

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

    // Invoke operation with valid options model (positive test)
    Response<AnalyzedDocument> response =
        discoveryService.analyzeDocument(analyzeDocumentOptionsModel).execute();
    assertNotNull(response);
    AnalyzedDocument responseObj = response.getResult();
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
    assertEquals(parsedPath, analyzeDocumentPath);
  }

  // Test the analyzeDocument operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAnalyzeDocumentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.analyzeDocument(null).execute();
  }

  @Test
  public void testListEnrichmentsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"enrichments\": [{\"enrichment_id\": \"enrichmentId\", \"name\": \"name\", \"description\": \"description\", \"type\": \"part_of_speech\", \"options\": {\"languages\": [\"languages\"], \"entity_type\": \"entityType\", \"regular_expression\": \"regularExpression\", \"result_field\": \"resultField\"}}]}";
    String listEnrichmentsPath = "/v2/projects/testString/enrichments";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListEnrichmentsOptions model
    ListEnrichmentsOptions listEnrichmentsOptionsModel =
        new ListEnrichmentsOptions.Builder().projectId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Enrichments> response =
        discoveryService.listEnrichments(listEnrichmentsOptionsModel).execute();
    assertNotNull(response);
    Enrichments responseObj = response.getResult();
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
    assertEquals(parsedPath, listEnrichmentsPath);
  }

  // Test the listEnrichments operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListEnrichmentsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.listEnrichments(null).execute();
  }

  @Test
  public void testCreateEnrichmentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"enrichment_id\": \"enrichmentId\", \"name\": \"name\", \"description\": \"description\", \"type\": \"part_of_speech\", \"options\": {\"languages\": [\"languages\"], \"entity_type\": \"entityType\", \"regular_expression\": \"regularExpression\", \"result_field\": \"resultField\"}}";
    String createEnrichmentPath = "/v2/projects/testString/enrichments";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the EnrichmentOptions model
    EnrichmentOptions enrichmentOptionsModel =
        new EnrichmentOptions.Builder()
            .languages(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .entityType("testString")
            .regularExpression("testString")
            .resultField("testString")
            .build();

    // Construct an instance of the CreateEnrichment model
    CreateEnrichment createEnrichmentModel =
        new CreateEnrichment.Builder()
            .name("testString")
            .description("testString")
            .type("dictionary")
            .options(enrichmentOptionsModel)
            .build();

    // Construct an instance of the CreateEnrichmentOptions model
    CreateEnrichmentOptions createEnrichmentOptionsModel =
        new CreateEnrichmentOptions.Builder()
            .projectId("testString")
            .enrichment(createEnrichmentModel)
            .file(TestUtilities.createMockStream("This is a mock file."))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Enrichment> response =
        discoveryService.createEnrichment(createEnrichmentOptionsModel).execute();
    assertNotNull(response);
    Enrichment responseObj = response.getResult();
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
    assertEquals(parsedPath, createEnrichmentPath);
  }

  // Test the createEnrichment operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateEnrichmentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.createEnrichment(null).execute();
  }

  @Test
  public void testGetEnrichmentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"enrichment_id\": \"enrichmentId\", \"name\": \"name\", \"description\": \"description\", \"type\": \"part_of_speech\", \"options\": {\"languages\": [\"languages\"], \"entity_type\": \"entityType\", \"regular_expression\": \"regularExpression\", \"result_field\": \"resultField\"}}";
    String getEnrichmentPath = "/v2/projects/testString/enrichments/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetEnrichmentOptions model
    GetEnrichmentOptions getEnrichmentOptionsModel =
        new GetEnrichmentOptions.Builder()
            .projectId("testString")
            .enrichmentId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Enrichment> response =
        discoveryService.getEnrichment(getEnrichmentOptionsModel).execute();
    assertNotNull(response);
    Enrichment responseObj = response.getResult();
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
    assertEquals(parsedPath, getEnrichmentPath);
  }

  // Test the getEnrichment operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetEnrichmentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.getEnrichment(null).execute();
  }

  @Test
  public void testUpdateEnrichmentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"enrichment_id\": \"enrichmentId\", \"name\": \"name\", \"description\": \"description\", \"type\": \"part_of_speech\", \"options\": {\"languages\": [\"languages\"], \"entity_type\": \"entityType\", \"regular_expression\": \"regularExpression\", \"result_field\": \"resultField\"}}";
    String updateEnrichmentPath = "/v2/projects/testString/enrichments/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateEnrichmentOptions model
    UpdateEnrichmentOptions updateEnrichmentOptionsModel =
        new UpdateEnrichmentOptions.Builder()
            .projectId("testString")
            .enrichmentId("testString")
            .name("testString")
            .description("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Enrichment> response =
        discoveryService.updateEnrichment(updateEnrichmentOptionsModel).execute();
    assertNotNull(response);
    Enrichment responseObj = response.getResult();
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
    assertEquals(parsedPath, updateEnrichmentPath);
  }

  // Test the updateEnrichment operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateEnrichmentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.updateEnrichment(null).execute();
  }

  @Test
  public void testDeleteEnrichmentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteEnrichmentPath = "/v2/projects/testString/enrichments/testString";

    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteEnrichmentOptions model
    DeleteEnrichmentOptions deleteEnrichmentOptionsModel =
        new DeleteEnrichmentOptions.Builder()
            .projectId("testString")
            .enrichmentId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        discoveryService.deleteEnrichment(deleteEnrichmentOptionsModel).execute();
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
    assertEquals(parsedPath, deleteEnrichmentPath);
  }

  // Test the deleteEnrichment operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteEnrichmentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.deleteEnrichment(null).execute();
  }

  @Test
  public void testListProjectsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"projects\": [{\"project_id\": \"projectId\", \"name\": \"name\", \"type\": \"document_retrieval\", \"relevancy_training_status\": {\"data_updated\": \"dataUpdated\", \"total_examples\": 13, \"sufficient_label_diversity\": true, \"processing\": true, \"minimum_examples_added\": true, \"successfully_trained\": \"successfullyTrained\", \"available\": false, \"notices\": 7, \"minimum_queries_added\": false}, \"collection_count\": 15}]}";
    String listProjectsPath = "/v2/projects";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListProjectsOptions model
    ListProjectsOptions listProjectsOptionsModel = new ListProjectsOptions();

    // Invoke operation with valid options model (positive test)
    Response<ListProjectsResponse> response =
        discoveryService.listProjects(listProjectsOptionsModel).execute();
    assertNotNull(response);
    ListProjectsResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, listProjectsPath);
  }

  @Test
  public void testCreateProjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"project_id\": \"projectId\", \"name\": \"name\", \"type\": \"document_retrieval\", \"relevancy_training_status\": {\"data_updated\": \"dataUpdated\", \"total_examples\": 13, \"sufficient_label_diversity\": true, \"processing\": true, \"minimum_examples_added\": true, \"successfully_trained\": \"successfullyTrained\", \"available\": false, \"notices\": 7, \"minimum_queries_added\": false}, \"collection_count\": 15, \"default_query_parameters\": {\"collection_ids\": [\"collectionIds\"], \"passages\": {\"enabled\": false, \"count\": 5, \"fields\": [\"fields\"], \"characters\": 10, \"per_document\": false, \"max_per_document\": 14}, \"table_results\": {\"enabled\": false, \"count\": 5, \"per_document\": 11}, \"aggregation\": \"aggregation\", \"suggested_refinements\": {\"enabled\": false, \"count\": 5}, \"spelling_suggestions\": false, \"highlight\": false, \"count\": 5, \"sort\": \"sort\", \"return\": [\"xReturn\"]}}";
    String createProjectPath = "/v2/projects";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DefaultQueryParamsPassages model
    DefaultQueryParamsPassages defaultQueryParamsPassagesModel =
        new DefaultQueryParamsPassages.Builder()
            .enabled(true)
            .count(Long.valueOf("26"))
            .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
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
            .collectionIds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .passages(defaultQueryParamsPassagesModel)
            .tableResults(defaultQueryParamsTableResultsModel)
            .aggregation("testString")
            .suggestedRefinements(defaultQueryParamsSuggestedRefinementsModel)
            .spellingSuggestions(true)
            .highlight(true)
            .count(Long.valueOf("26"))
            .sort("testString")
            .xReturn(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the CreateProjectOptions model
    CreateProjectOptions createProjectOptionsModel =
        new CreateProjectOptions.Builder()
            .name("testString")
            .type("document_retrieval")
            .defaultQueryParameters(defaultQueryParamsModel)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ProjectDetails> response =
        discoveryService.createProject(createProjectOptionsModel).execute();
    assertNotNull(response);
    ProjectDetails responseObj = response.getResult();
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
    assertEquals(parsedPath, createProjectPath);
  }

  // Test the createProject operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateProjectNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.createProject(null).execute();
  }

  @Test
  public void testGetProjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"project_id\": \"projectId\", \"name\": \"name\", \"type\": \"document_retrieval\", \"relevancy_training_status\": {\"data_updated\": \"dataUpdated\", \"total_examples\": 13, \"sufficient_label_diversity\": true, \"processing\": true, \"minimum_examples_added\": true, \"successfully_trained\": \"successfullyTrained\", \"available\": false, \"notices\": 7, \"minimum_queries_added\": false}, \"collection_count\": 15, \"default_query_parameters\": {\"collection_ids\": [\"collectionIds\"], \"passages\": {\"enabled\": false, \"count\": 5, \"fields\": [\"fields\"], \"characters\": 10, \"per_document\": false, \"max_per_document\": 14}, \"table_results\": {\"enabled\": false, \"count\": 5, \"per_document\": 11}, \"aggregation\": \"aggregation\", \"suggested_refinements\": {\"enabled\": false, \"count\": 5}, \"spelling_suggestions\": false, \"highlight\": false, \"count\": 5, \"sort\": \"sort\", \"return\": [\"xReturn\"]}}";
    String getProjectPath = "/v2/projects/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetProjectOptions model
    GetProjectOptions getProjectOptionsModel =
        new GetProjectOptions.Builder().projectId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<ProjectDetails> response =
        discoveryService.getProject(getProjectOptionsModel).execute();
    assertNotNull(response);
    ProjectDetails responseObj = response.getResult();
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
    assertEquals(parsedPath, getProjectPath);
  }

  // Test the getProject operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetProjectNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.getProject(null).execute();
  }

  @Test
  public void testUpdateProjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"project_id\": \"projectId\", \"name\": \"name\", \"type\": \"document_retrieval\", \"relevancy_training_status\": {\"data_updated\": \"dataUpdated\", \"total_examples\": 13, \"sufficient_label_diversity\": true, \"processing\": true, \"minimum_examples_added\": true, \"successfully_trained\": \"successfullyTrained\", \"available\": false, \"notices\": 7, \"minimum_queries_added\": false}, \"collection_count\": 15, \"default_query_parameters\": {\"collection_ids\": [\"collectionIds\"], \"passages\": {\"enabled\": false, \"count\": 5, \"fields\": [\"fields\"], \"characters\": 10, \"per_document\": false, \"max_per_document\": 14}, \"table_results\": {\"enabled\": false, \"count\": 5, \"per_document\": 11}, \"aggregation\": \"aggregation\", \"suggested_refinements\": {\"enabled\": false, \"count\": 5}, \"spelling_suggestions\": false, \"highlight\": false, \"count\": 5, \"sort\": \"sort\", \"return\": [\"xReturn\"]}}";
    String updateProjectPath = "/v2/projects/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateProjectOptions model
    UpdateProjectOptions updateProjectOptionsModel =
        new UpdateProjectOptions.Builder().projectId("testString").name("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<ProjectDetails> response =
        discoveryService.updateProject(updateProjectOptionsModel).execute();
    assertNotNull(response);
    ProjectDetails responseObj = response.getResult();
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
    assertEquals(parsedPath, updateProjectPath);
  }

  // Test the updateProject operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateProjectNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.updateProject(null).execute();
  }

  @Test
  public void testDeleteProjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteProjectPath = "/v2/projects/testString";

    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteProjectOptions model
    DeleteProjectOptions deleteProjectOptionsModel =
        new DeleteProjectOptions.Builder().projectId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = discoveryService.deleteProject(deleteProjectOptionsModel).execute();
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
    assertEquals(parsedPath, deleteProjectPath);
  }

  // Test the deleteProject operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteProjectNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.deleteProject(null).execute();
  }

  @Test
  public void testDeleteUserDataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteUserDataPath = "/v2/user_data";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteUserDataOptions model
    DeleteUserDataOptions deleteUserDataOptionsModel =
        new DeleteUserDataOptions.Builder().customerId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = discoveryService.deleteUserData(deleteUserDataOptionsModel).execute();
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
    discoveryService.deleteUserData(null).execute();
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
    discoveryService = null;
  }
}

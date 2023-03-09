/*
 * (C) Copyright IBM Corp. 2020, 2023.
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
package com.ibm.watson.discovery.v1;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.watson.discovery.v1.model.AddDocumentOptions;
import com.ibm.watson.discovery.v1.model.AddTrainingDataOptions;
import com.ibm.watson.discovery.v1.model.Collection;
import com.ibm.watson.discovery.v1.model.Completions;
import com.ibm.watson.discovery.v1.model.Configuration;
import com.ibm.watson.discovery.v1.model.Conversions;
import com.ibm.watson.discovery.v1.model.CreateCollectionOptions;
import com.ibm.watson.discovery.v1.model.CreateConfigurationOptions;
import com.ibm.watson.discovery.v1.model.CreateCredentialsOptions;
import com.ibm.watson.discovery.v1.model.CreateEnvironmentOptions;
import com.ibm.watson.discovery.v1.model.CreateEventOptions;
import com.ibm.watson.discovery.v1.model.CreateEventResponse;
import com.ibm.watson.discovery.v1.model.CreateExpansionsOptions;
import com.ibm.watson.discovery.v1.model.CreateGatewayOptions;
import com.ibm.watson.discovery.v1.model.CreateStopwordListOptions;
import com.ibm.watson.discovery.v1.model.CreateTokenizationDictionaryOptions;
import com.ibm.watson.discovery.v1.model.CreateTrainingExampleOptions;
import com.ibm.watson.discovery.v1.model.CredentialDetails;
import com.ibm.watson.discovery.v1.model.Credentials;
import com.ibm.watson.discovery.v1.model.CredentialsList;
import com.ibm.watson.discovery.v1.model.DeleteAllTrainingDataOptions;
import com.ibm.watson.discovery.v1.model.DeleteCollectionOptions;
import com.ibm.watson.discovery.v1.model.DeleteCollectionResponse;
import com.ibm.watson.discovery.v1.model.DeleteConfigurationOptions;
import com.ibm.watson.discovery.v1.model.DeleteConfigurationResponse;
import com.ibm.watson.discovery.v1.model.DeleteCredentials;
import com.ibm.watson.discovery.v1.model.DeleteCredentialsOptions;
import com.ibm.watson.discovery.v1.model.DeleteDocumentOptions;
import com.ibm.watson.discovery.v1.model.DeleteDocumentResponse;
import com.ibm.watson.discovery.v1.model.DeleteEnvironmentOptions;
import com.ibm.watson.discovery.v1.model.DeleteEnvironmentResponse;
import com.ibm.watson.discovery.v1.model.DeleteExpansionsOptions;
import com.ibm.watson.discovery.v1.model.DeleteGatewayOptions;
import com.ibm.watson.discovery.v1.model.DeleteStopwordListOptions;
import com.ibm.watson.discovery.v1.model.DeleteTokenizationDictionaryOptions;
import com.ibm.watson.discovery.v1.model.DeleteTrainingDataOptions;
import com.ibm.watson.discovery.v1.model.DeleteTrainingExampleOptions;
import com.ibm.watson.discovery.v1.model.DeleteUserDataOptions;
import com.ibm.watson.discovery.v1.model.DocumentAccepted;
import com.ibm.watson.discovery.v1.model.DocumentStatus;
import com.ibm.watson.discovery.v1.model.Enrichment;
import com.ibm.watson.discovery.v1.model.EnrichmentOptions;
import com.ibm.watson.discovery.v1.model.Environment;
import com.ibm.watson.discovery.v1.model.EventData;
import com.ibm.watson.discovery.v1.model.Expansion;
import com.ibm.watson.discovery.v1.model.Expansions;
import com.ibm.watson.discovery.v1.model.FederatedQueryNoticesOptions;
import com.ibm.watson.discovery.v1.model.FederatedQueryOptions;
import com.ibm.watson.discovery.v1.model.FontSetting;
import com.ibm.watson.discovery.v1.model.Gateway;
import com.ibm.watson.discovery.v1.model.GatewayDelete;
import com.ibm.watson.discovery.v1.model.GatewayList;
import com.ibm.watson.discovery.v1.model.GetAutocompletionOptions;
import com.ibm.watson.discovery.v1.model.GetCollectionOptions;
import com.ibm.watson.discovery.v1.model.GetConfigurationOptions;
import com.ibm.watson.discovery.v1.model.GetCredentialsOptions;
import com.ibm.watson.discovery.v1.model.GetDocumentStatusOptions;
import com.ibm.watson.discovery.v1.model.GetEnvironmentOptions;
import com.ibm.watson.discovery.v1.model.GetGatewayOptions;
import com.ibm.watson.discovery.v1.model.GetMetricsEventRateOptions;
import com.ibm.watson.discovery.v1.model.GetMetricsQueryEventOptions;
import com.ibm.watson.discovery.v1.model.GetMetricsQueryNoResultsOptions;
import com.ibm.watson.discovery.v1.model.GetMetricsQueryOptions;
import com.ibm.watson.discovery.v1.model.GetMetricsQueryTokenEventOptions;
import com.ibm.watson.discovery.v1.model.GetStopwordListStatusOptions;
import com.ibm.watson.discovery.v1.model.GetTokenizationDictionaryStatusOptions;
import com.ibm.watson.discovery.v1.model.GetTrainingDataOptions;
import com.ibm.watson.discovery.v1.model.GetTrainingExampleOptions;
import com.ibm.watson.discovery.v1.model.HtmlSettings;
import com.ibm.watson.discovery.v1.model.ListCollectionFieldsOptions;
import com.ibm.watson.discovery.v1.model.ListCollectionFieldsResponse;
import com.ibm.watson.discovery.v1.model.ListCollectionsOptions;
import com.ibm.watson.discovery.v1.model.ListCollectionsResponse;
import com.ibm.watson.discovery.v1.model.ListConfigurationsOptions;
import com.ibm.watson.discovery.v1.model.ListConfigurationsResponse;
import com.ibm.watson.discovery.v1.model.ListCredentialsOptions;
import com.ibm.watson.discovery.v1.model.ListEnvironmentsOptions;
import com.ibm.watson.discovery.v1.model.ListEnvironmentsResponse;
import com.ibm.watson.discovery.v1.model.ListExpansionsOptions;
import com.ibm.watson.discovery.v1.model.ListFieldsOptions;
import com.ibm.watson.discovery.v1.model.ListGatewaysOptions;
import com.ibm.watson.discovery.v1.model.ListTrainingDataOptions;
import com.ibm.watson.discovery.v1.model.ListTrainingExamplesOptions;
import com.ibm.watson.discovery.v1.model.LogQueryResponse;
import com.ibm.watson.discovery.v1.model.MetricResponse;
import com.ibm.watson.discovery.v1.model.MetricTokenResponse;
import com.ibm.watson.discovery.v1.model.NluEnrichmentConcepts;
import com.ibm.watson.discovery.v1.model.NluEnrichmentEmotion;
import com.ibm.watson.discovery.v1.model.NluEnrichmentEntities;
import com.ibm.watson.discovery.v1.model.NluEnrichmentFeatures;
import com.ibm.watson.discovery.v1.model.NluEnrichmentKeywords;
import com.ibm.watson.discovery.v1.model.NluEnrichmentRelations;
import com.ibm.watson.discovery.v1.model.NluEnrichmentSemanticRoles;
import com.ibm.watson.discovery.v1.model.NluEnrichmentSentiment;
import com.ibm.watson.discovery.v1.model.NormalizationOperation;
import com.ibm.watson.discovery.v1.model.PdfHeadingDetection;
import com.ibm.watson.discovery.v1.model.PdfSettings;
import com.ibm.watson.discovery.v1.model.QueryLogOptions;
import com.ibm.watson.discovery.v1.model.QueryNoticesOptions;
import com.ibm.watson.discovery.v1.model.QueryNoticesResponse;
import com.ibm.watson.discovery.v1.model.QueryOptions;
import com.ibm.watson.discovery.v1.model.QueryResponse;
import com.ibm.watson.discovery.v1.model.SegmentSettings;
import com.ibm.watson.discovery.v1.model.Source;
import com.ibm.watson.discovery.v1.model.SourceOptions;
import com.ibm.watson.discovery.v1.model.SourceOptionsBuckets;
import com.ibm.watson.discovery.v1.model.SourceOptionsFolder;
import com.ibm.watson.discovery.v1.model.SourceOptionsObject;
import com.ibm.watson.discovery.v1.model.SourceOptionsSiteColl;
import com.ibm.watson.discovery.v1.model.SourceOptionsWebCrawl;
import com.ibm.watson.discovery.v1.model.SourceSchedule;
import com.ibm.watson.discovery.v1.model.StatusDetails;
import com.ibm.watson.discovery.v1.model.TokenDictRule;
import com.ibm.watson.discovery.v1.model.TokenDictStatusResponse;
import com.ibm.watson.discovery.v1.model.TrainingDataSet;
import com.ibm.watson.discovery.v1.model.TrainingExample;
import com.ibm.watson.discovery.v1.model.TrainingExampleList;
import com.ibm.watson.discovery.v1.model.TrainingQuery;
import com.ibm.watson.discovery.v1.model.UpdateCollectionOptions;
import com.ibm.watson.discovery.v1.model.UpdateConfigurationOptions;
import com.ibm.watson.discovery.v1.model.UpdateCredentialsOptions;
import com.ibm.watson.discovery.v1.model.UpdateDocumentOptions;
import com.ibm.watson.discovery.v1.model.UpdateEnvironmentOptions;
import com.ibm.watson.discovery.v1.model.UpdateTrainingExampleOptions;
import com.ibm.watson.discovery.v1.model.WordHeadingDetection;
import com.ibm.watson.discovery.v1.model.WordSettings;
import com.ibm.watson.discovery.v1.model.WordStyle;
import com.ibm.watson.discovery.v1.model.XPathPatterns;
import com.ibm.watson.discovery.v1.utils.TestUtilities;
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

  // Test the createEnvironment operation with a valid options model parameter
  @Test
  public void testCreateEnvironmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"environment_id\": \"environmentId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"active\", \"read_only\": true, \"size\": \"LT\", \"requested_size\": \"requestedSize\", \"index_capacity\": {\"documents\": {\"available\": 9, \"maximum_allowed\": 14}, \"disk_usage\": {\"used_bytes\": 9, \"maximum_allowed_bytes\": 19}, \"collections\": {\"available\": 9, \"maximum_allowed\": 14}}, \"search_status\": {\"scope\": \"scope\", \"status\": \"NO_DATA\", \"status_description\": \"statusDescription\", \"last_trained\": \"2019-01-01\"}}";
    String createEnvironmentPath = "/v1/environments";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateEnvironmentOptions model
    CreateEnvironmentOptions createEnvironmentOptionsModel =
        new CreateEnvironmentOptions.Builder()
            .name("testString")
            .description("testString")
            .size("LT")
            .build();

    // Invoke createEnvironment() with a valid options model and verify the result
    Response<Environment> response =
        discoveryService.createEnvironment(createEnvironmentOptionsModel).execute();
    assertNotNull(response);
    Environment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createEnvironmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createEnvironment operation with and without retries enabled
  @Test
  public void testCreateEnvironmentWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testCreateEnvironmentWOptions();

    discoveryService.disableRetries();
    testCreateEnvironmentWOptions();
  }

  // Test the createEnvironment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateEnvironmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.createEnvironment(null).execute();
  }

  // Test the listEnvironments operation with a valid options model parameter
  @Test
  public void testListEnvironmentsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"environments\": [{\"environment_id\": \"environmentId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"active\", \"read_only\": true, \"size\": \"LT\", \"requested_size\": \"requestedSize\", \"index_capacity\": {\"documents\": {\"available\": 9, \"maximum_allowed\": 14}, \"disk_usage\": {\"used_bytes\": 9, \"maximum_allowed_bytes\": 19}, \"collections\": {\"available\": 9, \"maximum_allowed\": 14}}, \"search_status\": {\"scope\": \"scope\", \"status\": \"NO_DATA\", \"status_description\": \"statusDescription\", \"last_trained\": \"2019-01-01\"}}]}";
    String listEnvironmentsPath = "/v1/environments";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListEnvironmentsOptions model
    ListEnvironmentsOptions listEnvironmentsOptionsModel =
        new ListEnvironmentsOptions.Builder().name("testString").build();

    // Invoke listEnvironments() with a valid options model and verify the result
    Response<ListEnvironmentsResponse> response =
        discoveryService.listEnvironments(listEnvironmentsOptionsModel).execute();
    assertNotNull(response);
    ListEnvironmentsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listEnvironmentsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("name"), "testString");
  }

  // Test the listEnvironments operation with and without retries enabled
  @Test
  public void testListEnvironmentsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testListEnvironmentsWOptions();

    discoveryService.disableRetries();
    testListEnvironmentsWOptions();
  }

  // Test the getEnvironment operation with a valid options model parameter
  @Test
  public void testGetEnvironmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"environment_id\": \"environmentId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"active\", \"read_only\": true, \"size\": \"LT\", \"requested_size\": \"requestedSize\", \"index_capacity\": {\"documents\": {\"available\": 9, \"maximum_allowed\": 14}, \"disk_usage\": {\"used_bytes\": 9, \"maximum_allowed_bytes\": 19}, \"collections\": {\"available\": 9, \"maximum_allowed\": 14}}, \"search_status\": {\"scope\": \"scope\", \"status\": \"NO_DATA\", \"status_description\": \"statusDescription\", \"last_trained\": \"2019-01-01\"}}";
    String getEnvironmentPath = "/v1/environments/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetEnvironmentOptions model
    GetEnvironmentOptions getEnvironmentOptionsModel =
        new GetEnvironmentOptions.Builder().environmentId("testString").build();

    // Invoke getEnvironment() with a valid options model and verify the result
    Response<Environment> response =
        discoveryService.getEnvironment(getEnvironmentOptionsModel).execute();
    assertNotNull(response);
    Environment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getEnvironmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getEnvironment operation with and without retries enabled
  @Test
  public void testGetEnvironmentWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetEnvironmentWOptions();

    discoveryService.disableRetries();
    testGetEnvironmentWOptions();
  }

  // Test the getEnvironment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetEnvironmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getEnvironment(null).execute();
  }

  // Test the updateEnvironment operation with a valid options model parameter
  @Test
  public void testUpdateEnvironmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"environment_id\": \"environmentId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"active\", \"read_only\": true, \"size\": \"LT\", \"requested_size\": \"requestedSize\", \"index_capacity\": {\"documents\": {\"available\": 9, \"maximum_allowed\": 14}, \"disk_usage\": {\"used_bytes\": 9, \"maximum_allowed_bytes\": 19}, \"collections\": {\"available\": 9, \"maximum_allowed\": 14}}, \"search_status\": {\"scope\": \"scope\", \"status\": \"NO_DATA\", \"status_description\": \"statusDescription\", \"last_trained\": \"2019-01-01\"}}";
    String updateEnvironmentPath = "/v1/environments/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the UpdateEnvironmentOptions model
    UpdateEnvironmentOptions updateEnvironmentOptionsModel =
        new UpdateEnvironmentOptions.Builder()
            .environmentId("testString")
            .name("testString")
            .description("testString")
            .size("S")
            .build();

    // Invoke updateEnvironment() with a valid options model and verify the result
    Response<Environment> response =
        discoveryService.updateEnvironment(updateEnvironmentOptionsModel).execute();
    assertNotNull(response);
    Environment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateEnvironmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the updateEnvironment operation with and without retries enabled
  @Test
  public void testUpdateEnvironmentWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testUpdateEnvironmentWOptions();

    discoveryService.disableRetries();
    testUpdateEnvironmentWOptions();
  }

  // Test the updateEnvironment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateEnvironmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.updateEnvironment(null).execute();
  }

  // Test the deleteEnvironment operation with a valid options model parameter
  @Test
  public void testDeleteEnvironmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"environment_id\": \"environmentId\", \"status\": \"deleted\"}";
    String deleteEnvironmentPath = "/v1/environments/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the DeleteEnvironmentOptions model
    DeleteEnvironmentOptions deleteEnvironmentOptionsModel =
        new DeleteEnvironmentOptions.Builder().environmentId("testString").build();

    // Invoke deleteEnvironment() with a valid options model and verify the result
    Response<DeleteEnvironmentResponse> response =
        discoveryService.deleteEnvironment(deleteEnvironmentOptionsModel).execute();
    assertNotNull(response);
    DeleteEnvironmentResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteEnvironmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteEnvironment operation with and without retries enabled
  @Test
  public void testDeleteEnvironmentWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteEnvironmentWOptions();

    discoveryService.disableRetries();
    testDeleteEnvironmentWOptions();
  }

  // Test the deleteEnvironment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteEnvironmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteEnvironment(null).execute();
  }

  // Test the listFields operation with a valid options model parameter
  @Test
  public void testListFieldsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"fields\": [{\"field\": \"field\", \"type\": \"nested\"}]}";
    String listFieldsPath = "/v1/environments/testString/fields";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListFieldsOptions model
    ListFieldsOptions listFieldsOptionsModel =
        new ListFieldsOptions.Builder()
            .environmentId("testString")
            .collectionIds(java.util.Arrays.asList("testString"))
            .build();

    // Invoke listFields() with a valid options model and verify the result
    Response<ListCollectionFieldsResponse> response =
        discoveryService.listFields(listFieldsOptionsModel).execute();
    assertNotNull(response);
    ListCollectionFieldsResponse responseObj = response.getResult();
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

  // Test the createConfiguration operation with a valid options model parameter
  @Test
  public void testCreateConfigurationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"configuration_id\": \"configurationId\", \"name\": \"name\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"description\": \"description\", \"conversions\": {\"pdf\": {\"heading\": {\"fonts\": [{\"level\": 5, \"min_size\": 7, \"max_size\": 7, \"bold\": true, \"italic\": true, \"name\": \"name\"}]}}, \"word\": {\"heading\": {\"fonts\": [{\"level\": 5, \"min_size\": 7, \"max_size\": 7, \"bold\": true, \"italic\": true, \"name\": \"name\"}], \"styles\": [{\"level\": 5, \"names\": [\"names\"]}]}}, \"html\": {\"exclude_tags_completely\": [\"excludeTagsCompletely\"], \"exclude_tags_keep_content\": [\"excludeTagsKeepContent\"], \"keep_content\": {\"xpaths\": [\"xpaths\"]}, \"exclude_content\": {\"xpaths\": [\"xpaths\"]}, \"keep_tag_attributes\": [\"keepTagAttributes\"], \"exclude_tag_attributes\": [\"excludeTagAttributes\"]}, \"segment\": {\"enabled\": false, \"selector_tags\": [\"selectorTags\"], \"annotated_fields\": [\"annotatedFields\"]}, \"json_normalizations\": [{\"operation\": \"copy\", \"source_field\": \"sourceField\", \"destination_field\": \"destinationField\"}], \"image_text_recognition\": true}, \"enrichments\": [{\"description\": \"description\", \"destination_field\": \"destinationField\", \"source_field\": \"sourceField\", \"overwrite\": false, \"enrichment\": \"enrichment\", \"ignore_downstream_errors\": false, \"options\": {\"features\": {\"keywords\": {\"sentiment\": false, \"emotion\": false, \"limit\": 5}, \"entities\": {\"sentiment\": false, \"emotion\": false, \"limit\": 5, \"mentions\": true, \"mention_types\": true, \"sentence_locations\": false, \"model\": \"model\"}, \"sentiment\": {\"document\": true, \"targets\": [\"target\"]}, \"emotion\": {\"document\": true, \"targets\": [\"target\"]}, \"categories\": {\"anyKey\": \"anyValue\"}, \"semantic_roles\": {\"entities\": true, \"keywords\": true, \"limit\": 5}, \"relations\": {\"model\": \"model\"}, \"concepts\": {\"limit\": 5}}, \"language\": \"ar\", \"model\": \"model\"}}], \"normalizations\": [{\"operation\": \"copy\", \"source_field\": \"sourceField\", \"destination_field\": \"destinationField\"}], \"source\": {\"type\": \"box\", \"credential_id\": \"credentialId\", \"schedule\": {\"enabled\": true, \"time_zone\": \"America/New_York\", \"frequency\": \"daily\"}, \"options\": {\"folders\": [{\"owner_user_id\": \"ownerUserId\", \"folder_id\": \"folderId\", \"limit\": 5}], \"objects\": [{\"name\": \"name\", \"limit\": 5}], \"site_collections\": [{\"site_collection_path\": \"siteCollectionPath\", \"limit\": 5}], \"urls\": [{\"url\": \"url\", \"limit_to_starting_hosts\": true, \"crawl_speed\": \"normal\", \"allow_untrusted_certificate\": false, \"maximum_hops\": 11, \"request_timeout\": 14, \"override_robots_txt\": false, \"blacklist\": [\"blacklist\"]}], \"buckets\": [{\"name\": \"name\", \"limit\": 5}], \"crawl_all_buckets\": false}}}";
    String createConfigurationPath = "/v1/environments/testString/configurations";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the FontSetting model
    FontSetting fontSettingModel =
        new FontSetting.Builder()
            .level(Long.valueOf("26"))
            .minSize(Long.valueOf("26"))
            .maxSize(Long.valueOf("26"))
            .bold(true)
            .italic(true)
            .name("testString")
            .build();

    // Construct an instance of the PdfHeadingDetection model
    PdfHeadingDetection pdfHeadingDetectionModel =
        new PdfHeadingDetection.Builder().fonts(java.util.Arrays.asList(fontSettingModel)).build();

    // Construct an instance of the PdfSettings model
    PdfSettings pdfSettingsModel =
        new PdfSettings.Builder().heading(pdfHeadingDetectionModel).build();

    // Construct an instance of the WordStyle model
    WordStyle wordStyleModel =
        new WordStyle.Builder()
            .level(Long.valueOf("26"))
            .names(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the WordHeadingDetection model
    WordHeadingDetection wordHeadingDetectionModel =
        new WordHeadingDetection.Builder()
            .fonts(java.util.Arrays.asList(fontSettingModel))
            .styles(java.util.Arrays.asList(wordStyleModel))
            .build();

    // Construct an instance of the WordSettings model
    WordSettings wordSettingsModel =
        new WordSettings.Builder().heading(wordHeadingDetectionModel).build();

    // Construct an instance of the XPathPatterns model
    XPathPatterns xPathPatternsModel =
        new XPathPatterns.Builder().xpaths(java.util.Arrays.asList("testString")).build();

    // Construct an instance of the HtmlSettings model
    HtmlSettings htmlSettingsModel =
        new HtmlSettings.Builder()
            .excludeTagsCompletely(java.util.Arrays.asList("testString"))
            .excludeTagsKeepContent(java.util.Arrays.asList("testString"))
            .keepContent(xPathPatternsModel)
            .excludeContent(xPathPatternsModel)
            .keepTagAttributes(java.util.Arrays.asList("testString"))
            .excludeTagAttributes(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the SegmentSettings model
    SegmentSettings segmentSettingsModel =
        new SegmentSettings.Builder()
            .enabled(false)
            .selectorTags(java.util.Arrays.asList("h1", "h2"))
            .annotatedFields(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the NormalizationOperation model
    NormalizationOperation normalizationOperationModel =
        new NormalizationOperation.Builder()
            .operation("copy")
            .sourceField("testString")
            .destinationField("testString")
            .build();

    // Construct an instance of the Conversions model
    Conversions conversionsModel =
        new Conversions.Builder()
            .pdf(pdfSettingsModel)
            .word(wordSettingsModel)
            .html(htmlSettingsModel)
            .segment(segmentSettingsModel)
            .jsonNormalizations(java.util.Arrays.asList(normalizationOperationModel))
            .imageTextRecognition(true)
            .build();

    // Construct an instance of the NluEnrichmentKeywords model
    NluEnrichmentKeywords nluEnrichmentKeywordsModel =
        new NluEnrichmentKeywords.Builder()
            .sentiment(true)
            .emotion(true)
            .limit(Long.valueOf("26"))
            .build();

    // Construct an instance of the NluEnrichmentEntities model
    NluEnrichmentEntities nluEnrichmentEntitiesModel =
        new NluEnrichmentEntities.Builder()
            .sentiment(true)
            .emotion(true)
            .limit(Long.valueOf("26"))
            .mentions(true)
            .mentionTypes(true)
            .sentenceLocations(true)
            .model("testString")
            .build();

    // Construct an instance of the NluEnrichmentSentiment model
    NluEnrichmentSentiment nluEnrichmentSentimentModel =
        new NluEnrichmentSentiment.Builder()
            .document(true)
            .targets(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the NluEnrichmentEmotion model
    NluEnrichmentEmotion nluEnrichmentEmotionModel =
        new NluEnrichmentEmotion.Builder()
            .document(true)
            .targets(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the NluEnrichmentSemanticRoles model
    NluEnrichmentSemanticRoles nluEnrichmentSemanticRolesModel =
        new NluEnrichmentSemanticRoles.Builder()
            .entities(true)
            .keywords(true)
            .limit(Long.valueOf("26"))
            .build();

    // Construct an instance of the NluEnrichmentRelations model
    NluEnrichmentRelations nluEnrichmentRelationsModel =
        new NluEnrichmentRelations.Builder().model("testString").build();

    // Construct an instance of the NluEnrichmentConcepts model
    NluEnrichmentConcepts nluEnrichmentConceptsModel =
        new NluEnrichmentConcepts.Builder().limit(Long.valueOf("26")).build();

    // Construct an instance of the NluEnrichmentFeatures model
    NluEnrichmentFeatures nluEnrichmentFeaturesModel =
        new NluEnrichmentFeatures.Builder()
            .keywords(nluEnrichmentKeywordsModel)
            .entities(nluEnrichmentEntitiesModel)
            .sentiment(nluEnrichmentSentimentModel)
            .emotion(nluEnrichmentEmotionModel)
            .categories(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .semanticRoles(nluEnrichmentSemanticRolesModel)
            .relations(nluEnrichmentRelationsModel)
            .concepts(nluEnrichmentConceptsModel)
            .build();

    // Construct an instance of the EnrichmentOptions model
    EnrichmentOptions enrichmentOptionsModel =
        new EnrichmentOptions.Builder()
            .features(nluEnrichmentFeaturesModel)
            .language("ar")
            .model("testString")
            .build();

    // Construct an instance of the Enrichment model
    Enrichment enrichmentModel =
        new Enrichment.Builder()
            .description("testString")
            .destinationField("testString")
            .sourceField("testString")
            .overwrite(false)
            .enrichment("testString")
            .ignoreDownstreamErrors(false)
            .options(enrichmentOptionsModel)
            .build();

    // Construct an instance of the SourceSchedule model
    SourceSchedule sourceScheduleModel =
        new SourceSchedule.Builder()
            .enabled(true)
            .timeZone("America/New_York")
            .frequency("daily")
            .build();

    // Construct an instance of the SourceOptionsFolder model
    SourceOptionsFolder sourceOptionsFolderModel =
        new SourceOptionsFolder.Builder()
            .ownerUserId("testString")
            .folderId("testString")
            .limit(Long.valueOf("26"))
            .build();

    // Construct an instance of the SourceOptionsObject model
    SourceOptionsObject sourceOptionsObjectModel =
        new SourceOptionsObject.Builder().name("testString").limit(Long.valueOf("26")).build();

    // Construct an instance of the SourceOptionsSiteColl model
    SourceOptionsSiteColl sourceOptionsSiteCollModel =
        new SourceOptionsSiteColl.Builder()
            .siteCollectionPath("testString")
            .limit(Long.valueOf("26"))
            .build();

    // Construct an instance of the SourceOptionsWebCrawl model
    SourceOptionsWebCrawl sourceOptionsWebCrawlModel =
        new SourceOptionsWebCrawl.Builder()
            .url("testString")
            .limitToStartingHosts(true)
            .crawlSpeed("normal")
            .allowUntrustedCertificate(false)
            .maximumHops(Long.valueOf("26"))
            .requestTimeout(Long.valueOf("26"))
            .overrideRobotsTxt(false)
            .blacklist(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the SourceOptionsBuckets model
    SourceOptionsBuckets sourceOptionsBucketsModel =
        new SourceOptionsBuckets.Builder().name("testString").limit(Long.valueOf("26")).build();

    // Construct an instance of the SourceOptions model
    SourceOptions sourceOptionsModel =
        new SourceOptions.Builder()
            .folders(java.util.Arrays.asList(sourceOptionsFolderModel))
            .objects(java.util.Arrays.asList(sourceOptionsObjectModel))
            .siteCollections(java.util.Arrays.asList(sourceOptionsSiteCollModel))
            .urls(java.util.Arrays.asList(sourceOptionsWebCrawlModel))
            .buckets(java.util.Arrays.asList(sourceOptionsBucketsModel))
            .crawlAllBuckets(true)
            .build();

    // Construct an instance of the Source model
    Source sourceModel =
        new Source.Builder()
            .type("box")
            .credentialId("testString")
            .schedule(sourceScheduleModel)
            .options(sourceOptionsModel)
            .build();

    // Construct an instance of the CreateConfigurationOptions model
    CreateConfigurationOptions createConfigurationOptionsModel =
        new CreateConfigurationOptions.Builder()
            .environmentId("testString")
            .name("testString")
            .description("testString")
            .conversions(conversionsModel)
            .enrichments(java.util.Arrays.asList(enrichmentModel))
            .normalizations(java.util.Arrays.asList(normalizationOperationModel))
            .source(sourceModel)
            .build();

    // Invoke createConfiguration() with a valid options model and verify the result
    Response<Configuration> response =
        discoveryService.createConfiguration(createConfigurationOptionsModel).execute();
    assertNotNull(response);
    Configuration responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createConfigurationPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createConfiguration operation with and without retries enabled
  @Test
  public void testCreateConfigurationWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testCreateConfigurationWOptions();

    discoveryService.disableRetries();
    testCreateConfigurationWOptions();
  }

  // Test the createConfiguration operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateConfigurationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.createConfiguration(null).execute();
  }

  // Test the listConfigurations operation with a valid options model parameter
  @Test
  public void testListConfigurationsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"configurations\": [{\"configuration_id\": \"configurationId\", \"name\": \"name\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"description\": \"description\", \"conversions\": {\"pdf\": {\"heading\": {\"fonts\": [{\"level\": 5, \"min_size\": 7, \"max_size\": 7, \"bold\": true, \"italic\": true, \"name\": \"name\"}]}}, \"word\": {\"heading\": {\"fonts\": [{\"level\": 5, \"min_size\": 7, \"max_size\": 7, \"bold\": true, \"italic\": true, \"name\": \"name\"}], \"styles\": [{\"level\": 5, \"names\": [\"names\"]}]}}, \"html\": {\"exclude_tags_completely\": [\"excludeTagsCompletely\"], \"exclude_tags_keep_content\": [\"excludeTagsKeepContent\"], \"keep_content\": {\"xpaths\": [\"xpaths\"]}, \"exclude_content\": {\"xpaths\": [\"xpaths\"]}, \"keep_tag_attributes\": [\"keepTagAttributes\"], \"exclude_tag_attributes\": [\"excludeTagAttributes\"]}, \"segment\": {\"enabled\": false, \"selector_tags\": [\"selectorTags\"], \"annotated_fields\": [\"annotatedFields\"]}, \"json_normalizations\": [{\"operation\": \"copy\", \"source_field\": \"sourceField\", \"destination_field\": \"destinationField\"}], \"image_text_recognition\": true}, \"enrichments\": [{\"description\": \"description\", \"destination_field\": \"destinationField\", \"source_field\": \"sourceField\", \"overwrite\": false, \"enrichment\": \"enrichment\", \"ignore_downstream_errors\": false, \"options\": {\"features\": {\"keywords\": {\"sentiment\": false, \"emotion\": false, \"limit\": 5}, \"entities\": {\"sentiment\": false, \"emotion\": false, \"limit\": 5, \"mentions\": true, \"mention_types\": true, \"sentence_locations\": false, \"model\": \"model\"}, \"sentiment\": {\"document\": true, \"targets\": [\"target\"]}, \"emotion\": {\"document\": true, \"targets\": [\"target\"]}, \"categories\": {\"anyKey\": \"anyValue\"}, \"semantic_roles\": {\"entities\": true, \"keywords\": true, \"limit\": 5}, \"relations\": {\"model\": \"model\"}, \"concepts\": {\"limit\": 5}}, \"language\": \"ar\", \"model\": \"model\"}}], \"normalizations\": [{\"operation\": \"copy\", \"source_field\": \"sourceField\", \"destination_field\": \"destinationField\"}], \"source\": {\"type\": \"box\", \"credential_id\": \"credentialId\", \"schedule\": {\"enabled\": true, \"time_zone\": \"America/New_York\", \"frequency\": \"daily\"}, \"options\": {\"folders\": [{\"owner_user_id\": \"ownerUserId\", \"folder_id\": \"folderId\", \"limit\": 5}], \"objects\": [{\"name\": \"name\", \"limit\": 5}], \"site_collections\": [{\"site_collection_path\": \"siteCollectionPath\", \"limit\": 5}], \"urls\": [{\"url\": \"url\", \"limit_to_starting_hosts\": true, \"crawl_speed\": \"normal\", \"allow_untrusted_certificate\": false, \"maximum_hops\": 11, \"request_timeout\": 14, \"override_robots_txt\": false, \"blacklist\": [\"blacklist\"]}], \"buckets\": [{\"name\": \"name\", \"limit\": 5}], \"crawl_all_buckets\": false}}}]}";
    String listConfigurationsPath = "/v1/environments/testString/configurations";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListConfigurationsOptions model
    ListConfigurationsOptions listConfigurationsOptionsModel =
        new ListConfigurationsOptions.Builder()
            .environmentId("testString")
            .name("testString")
            .build();

    // Invoke listConfigurations() with a valid options model and verify the result
    Response<ListConfigurationsResponse> response =
        discoveryService.listConfigurations(listConfigurationsOptionsModel).execute();
    assertNotNull(response);
    ListConfigurationsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listConfigurationsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("name"), "testString");
  }

  // Test the listConfigurations operation with and without retries enabled
  @Test
  public void testListConfigurationsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testListConfigurationsWOptions();

    discoveryService.disableRetries();
    testListConfigurationsWOptions();
  }

  // Test the listConfigurations operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListConfigurationsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.listConfigurations(null).execute();
  }

  // Test the getConfiguration operation with a valid options model parameter
  @Test
  public void testGetConfigurationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"configuration_id\": \"configurationId\", \"name\": \"name\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"description\": \"description\", \"conversions\": {\"pdf\": {\"heading\": {\"fonts\": [{\"level\": 5, \"min_size\": 7, \"max_size\": 7, \"bold\": true, \"italic\": true, \"name\": \"name\"}]}}, \"word\": {\"heading\": {\"fonts\": [{\"level\": 5, \"min_size\": 7, \"max_size\": 7, \"bold\": true, \"italic\": true, \"name\": \"name\"}], \"styles\": [{\"level\": 5, \"names\": [\"names\"]}]}}, \"html\": {\"exclude_tags_completely\": [\"excludeTagsCompletely\"], \"exclude_tags_keep_content\": [\"excludeTagsKeepContent\"], \"keep_content\": {\"xpaths\": [\"xpaths\"]}, \"exclude_content\": {\"xpaths\": [\"xpaths\"]}, \"keep_tag_attributes\": [\"keepTagAttributes\"], \"exclude_tag_attributes\": [\"excludeTagAttributes\"]}, \"segment\": {\"enabled\": false, \"selector_tags\": [\"selectorTags\"], \"annotated_fields\": [\"annotatedFields\"]}, \"json_normalizations\": [{\"operation\": \"copy\", \"source_field\": \"sourceField\", \"destination_field\": \"destinationField\"}], \"image_text_recognition\": true}, \"enrichments\": [{\"description\": \"description\", \"destination_field\": \"destinationField\", \"source_field\": \"sourceField\", \"overwrite\": false, \"enrichment\": \"enrichment\", \"ignore_downstream_errors\": false, \"options\": {\"features\": {\"keywords\": {\"sentiment\": false, \"emotion\": false, \"limit\": 5}, \"entities\": {\"sentiment\": false, \"emotion\": false, \"limit\": 5, \"mentions\": true, \"mention_types\": true, \"sentence_locations\": false, \"model\": \"model\"}, \"sentiment\": {\"document\": true, \"targets\": [\"target\"]}, \"emotion\": {\"document\": true, \"targets\": [\"target\"]}, \"categories\": {\"anyKey\": \"anyValue\"}, \"semantic_roles\": {\"entities\": true, \"keywords\": true, \"limit\": 5}, \"relations\": {\"model\": \"model\"}, \"concepts\": {\"limit\": 5}}, \"language\": \"ar\", \"model\": \"model\"}}], \"normalizations\": [{\"operation\": \"copy\", \"source_field\": \"sourceField\", \"destination_field\": \"destinationField\"}], \"source\": {\"type\": \"box\", \"credential_id\": \"credentialId\", \"schedule\": {\"enabled\": true, \"time_zone\": \"America/New_York\", \"frequency\": \"daily\"}, \"options\": {\"folders\": [{\"owner_user_id\": \"ownerUserId\", \"folder_id\": \"folderId\", \"limit\": 5}], \"objects\": [{\"name\": \"name\", \"limit\": 5}], \"site_collections\": [{\"site_collection_path\": \"siteCollectionPath\", \"limit\": 5}], \"urls\": [{\"url\": \"url\", \"limit_to_starting_hosts\": true, \"crawl_speed\": \"normal\", \"allow_untrusted_certificate\": false, \"maximum_hops\": 11, \"request_timeout\": 14, \"override_robots_txt\": false, \"blacklist\": [\"blacklist\"]}], \"buckets\": [{\"name\": \"name\", \"limit\": 5}], \"crawl_all_buckets\": false}}}";
    String getConfigurationPath = "/v1/environments/testString/configurations/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetConfigurationOptions model
    GetConfigurationOptions getConfigurationOptionsModel =
        new GetConfigurationOptions.Builder()
            .environmentId("testString")
            .configurationId("testString")
            .build();

    // Invoke getConfiguration() with a valid options model and verify the result
    Response<Configuration> response =
        discoveryService.getConfiguration(getConfigurationOptionsModel).execute();
    assertNotNull(response);
    Configuration responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getConfigurationPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getConfiguration operation with and without retries enabled
  @Test
  public void testGetConfigurationWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetConfigurationWOptions();

    discoveryService.disableRetries();
    testGetConfigurationWOptions();
  }

  // Test the getConfiguration operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetConfigurationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getConfiguration(null).execute();
  }

  // Test the updateConfiguration operation with a valid options model parameter
  @Test
  public void testUpdateConfigurationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"configuration_id\": \"configurationId\", \"name\": \"name\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"description\": \"description\", \"conversions\": {\"pdf\": {\"heading\": {\"fonts\": [{\"level\": 5, \"min_size\": 7, \"max_size\": 7, \"bold\": true, \"italic\": true, \"name\": \"name\"}]}}, \"word\": {\"heading\": {\"fonts\": [{\"level\": 5, \"min_size\": 7, \"max_size\": 7, \"bold\": true, \"italic\": true, \"name\": \"name\"}], \"styles\": [{\"level\": 5, \"names\": [\"names\"]}]}}, \"html\": {\"exclude_tags_completely\": [\"excludeTagsCompletely\"], \"exclude_tags_keep_content\": [\"excludeTagsKeepContent\"], \"keep_content\": {\"xpaths\": [\"xpaths\"]}, \"exclude_content\": {\"xpaths\": [\"xpaths\"]}, \"keep_tag_attributes\": [\"keepTagAttributes\"], \"exclude_tag_attributes\": [\"excludeTagAttributes\"]}, \"segment\": {\"enabled\": false, \"selector_tags\": [\"selectorTags\"], \"annotated_fields\": [\"annotatedFields\"]}, \"json_normalizations\": [{\"operation\": \"copy\", \"source_field\": \"sourceField\", \"destination_field\": \"destinationField\"}], \"image_text_recognition\": true}, \"enrichments\": [{\"description\": \"description\", \"destination_field\": \"destinationField\", \"source_field\": \"sourceField\", \"overwrite\": false, \"enrichment\": \"enrichment\", \"ignore_downstream_errors\": false, \"options\": {\"features\": {\"keywords\": {\"sentiment\": false, \"emotion\": false, \"limit\": 5}, \"entities\": {\"sentiment\": false, \"emotion\": false, \"limit\": 5, \"mentions\": true, \"mention_types\": true, \"sentence_locations\": false, \"model\": \"model\"}, \"sentiment\": {\"document\": true, \"targets\": [\"target\"]}, \"emotion\": {\"document\": true, \"targets\": [\"target\"]}, \"categories\": {\"anyKey\": \"anyValue\"}, \"semantic_roles\": {\"entities\": true, \"keywords\": true, \"limit\": 5}, \"relations\": {\"model\": \"model\"}, \"concepts\": {\"limit\": 5}}, \"language\": \"ar\", \"model\": \"model\"}}], \"normalizations\": [{\"operation\": \"copy\", \"source_field\": \"sourceField\", \"destination_field\": \"destinationField\"}], \"source\": {\"type\": \"box\", \"credential_id\": \"credentialId\", \"schedule\": {\"enabled\": true, \"time_zone\": \"America/New_York\", \"frequency\": \"daily\"}, \"options\": {\"folders\": [{\"owner_user_id\": \"ownerUserId\", \"folder_id\": \"folderId\", \"limit\": 5}], \"objects\": [{\"name\": \"name\", \"limit\": 5}], \"site_collections\": [{\"site_collection_path\": \"siteCollectionPath\", \"limit\": 5}], \"urls\": [{\"url\": \"url\", \"limit_to_starting_hosts\": true, \"crawl_speed\": \"normal\", \"allow_untrusted_certificate\": false, \"maximum_hops\": 11, \"request_timeout\": 14, \"override_robots_txt\": false, \"blacklist\": [\"blacklist\"]}], \"buckets\": [{\"name\": \"name\", \"limit\": 5}], \"crawl_all_buckets\": false}}}";
    String updateConfigurationPath = "/v1/environments/testString/configurations/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the FontSetting model
    FontSetting fontSettingModel =
        new FontSetting.Builder()
            .level(Long.valueOf("26"))
            .minSize(Long.valueOf("26"))
            .maxSize(Long.valueOf("26"))
            .bold(true)
            .italic(true)
            .name("testString")
            .build();

    // Construct an instance of the PdfHeadingDetection model
    PdfHeadingDetection pdfHeadingDetectionModel =
        new PdfHeadingDetection.Builder().fonts(java.util.Arrays.asList(fontSettingModel)).build();

    // Construct an instance of the PdfSettings model
    PdfSettings pdfSettingsModel =
        new PdfSettings.Builder().heading(pdfHeadingDetectionModel).build();

    // Construct an instance of the WordStyle model
    WordStyle wordStyleModel =
        new WordStyle.Builder()
            .level(Long.valueOf("26"))
            .names(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the WordHeadingDetection model
    WordHeadingDetection wordHeadingDetectionModel =
        new WordHeadingDetection.Builder()
            .fonts(java.util.Arrays.asList(fontSettingModel))
            .styles(java.util.Arrays.asList(wordStyleModel))
            .build();

    // Construct an instance of the WordSettings model
    WordSettings wordSettingsModel =
        new WordSettings.Builder().heading(wordHeadingDetectionModel).build();

    // Construct an instance of the XPathPatterns model
    XPathPatterns xPathPatternsModel =
        new XPathPatterns.Builder().xpaths(java.util.Arrays.asList("testString")).build();

    // Construct an instance of the HtmlSettings model
    HtmlSettings htmlSettingsModel =
        new HtmlSettings.Builder()
            .excludeTagsCompletely(java.util.Arrays.asList("testString"))
            .excludeTagsKeepContent(java.util.Arrays.asList("testString"))
            .keepContent(xPathPatternsModel)
            .excludeContent(xPathPatternsModel)
            .keepTagAttributes(java.util.Arrays.asList("testString"))
            .excludeTagAttributes(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the SegmentSettings model
    SegmentSettings segmentSettingsModel =
        new SegmentSettings.Builder()
            .enabled(false)
            .selectorTags(java.util.Arrays.asList("h1", "h2"))
            .annotatedFields(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the NormalizationOperation model
    NormalizationOperation normalizationOperationModel =
        new NormalizationOperation.Builder()
            .operation("copy")
            .sourceField("testString")
            .destinationField("testString")
            .build();

    // Construct an instance of the Conversions model
    Conversions conversionsModel =
        new Conversions.Builder()
            .pdf(pdfSettingsModel)
            .word(wordSettingsModel)
            .html(htmlSettingsModel)
            .segment(segmentSettingsModel)
            .jsonNormalizations(java.util.Arrays.asList(normalizationOperationModel))
            .imageTextRecognition(true)
            .build();

    // Construct an instance of the NluEnrichmentKeywords model
    NluEnrichmentKeywords nluEnrichmentKeywordsModel =
        new NluEnrichmentKeywords.Builder()
            .sentiment(true)
            .emotion(true)
            .limit(Long.valueOf("26"))
            .build();

    // Construct an instance of the NluEnrichmentEntities model
    NluEnrichmentEntities nluEnrichmentEntitiesModel =
        new NluEnrichmentEntities.Builder()
            .sentiment(true)
            .emotion(true)
            .limit(Long.valueOf("26"))
            .mentions(true)
            .mentionTypes(true)
            .sentenceLocations(true)
            .model("testString")
            .build();

    // Construct an instance of the NluEnrichmentSentiment model
    NluEnrichmentSentiment nluEnrichmentSentimentModel =
        new NluEnrichmentSentiment.Builder()
            .document(true)
            .targets(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the NluEnrichmentEmotion model
    NluEnrichmentEmotion nluEnrichmentEmotionModel =
        new NluEnrichmentEmotion.Builder()
            .document(true)
            .targets(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the NluEnrichmentSemanticRoles model
    NluEnrichmentSemanticRoles nluEnrichmentSemanticRolesModel =
        new NluEnrichmentSemanticRoles.Builder()
            .entities(true)
            .keywords(true)
            .limit(Long.valueOf("26"))
            .build();

    // Construct an instance of the NluEnrichmentRelations model
    NluEnrichmentRelations nluEnrichmentRelationsModel =
        new NluEnrichmentRelations.Builder().model("testString").build();

    // Construct an instance of the NluEnrichmentConcepts model
    NluEnrichmentConcepts nluEnrichmentConceptsModel =
        new NluEnrichmentConcepts.Builder().limit(Long.valueOf("26")).build();

    // Construct an instance of the NluEnrichmentFeatures model
    NluEnrichmentFeatures nluEnrichmentFeaturesModel =
        new NluEnrichmentFeatures.Builder()
            .keywords(nluEnrichmentKeywordsModel)
            .entities(nluEnrichmentEntitiesModel)
            .sentiment(nluEnrichmentSentimentModel)
            .emotion(nluEnrichmentEmotionModel)
            .categories(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .semanticRoles(nluEnrichmentSemanticRolesModel)
            .relations(nluEnrichmentRelationsModel)
            .concepts(nluEnrichmentConceptsModel)
            .build();

    // Construct an instance of the EnrichmentOptions model
    EnrichmentOptions enrichmentOptionsModel =
        new EnrichmentOptions.Builder()
            .features(nluEnrichmentFeaturesModel)
            .language("ar")
            .model("testString")
            .build();

    // Construct an instance of the Enrichment model
    Enrichment enrichmentModel =
        new Enrichment.Builder()
            .description("testString")
            .destinationField("testString")
            .sourceField("testString")
            .overwrite(false)
            .enrichment("testString")
            .ignoreDownstreamErrors(false)
            .options(enrichmentOptionsModel)
            .build();

    // Construct an instance of the SourceSchedule model
    SourceSchedule sourceScheduleModel =
        new SourceSchedule.Builder()
            .enabled(true)
            .timeZone("America/New_York")
            .frequency("daily")
            .build();

    // Construct an instance of the SourceOptionsFolder model
    SourceOptionsFolder sourceOptionsFolderModel =
        new SourceOptionsFolder.Builder()
            .ownerUserId("testString")
            .folderId("testString")
            .limit(Long.valueOf("26"))
            .build();

    // Construct an instance of the SourceOptionsObject model
    SourceOptionsObject sourceOptionsObjectModel =
        new SourceOptionsObject.Builder().name("testString").limit(Long.valueOf("26")).build();

    // Construct an instance of the SourceOptionsSiteColl model
    SourceOptionsSiteColl sourceOptionsSiteCollModel =
        new SourceOptionsSiteColl.Builder()
            .siteCollectionPath("testString")
            .limit(Long.valueOf("26"))
            .build();

    // Construct an instance of the SourceOptionsWebCrawl model
    SourceOptionsWebCrawl sourceOptionsWebCrawlModel =
        new SourceOptionsWebCrawl.Builder()
            .url("testString")
            .limitToStartingHosts(true)
            .crawlSpeed("normal")
            .allowUntrustedCertificate(false)
            .maximumHops(Long.valueOf("26"))
            .requestTimeout(Long.valueOf("26"))
            .overrideRobotsTxt(false)
            .blacklist(java.util.Arrays.asList("testString"))
            .build();

    // Construct an instance of the SourceOptionsBuckets model
    SourceOptionsBuckets sourceOptionsBucketsModel =
        new SourceOptionsBuckets.Builder().name("testString").limit(Long.valueOf("26")).build();

    // Construct an instance of the SourceOptions model
    SourceOptions sourceOptionsModel =
        new SourceOptions.Builder()
            .folders(java.util.Arrays.asList(sourceOptionsFolderModel))
            .objects(java.util.Arrays.asList(sourceOptionsObjectModel))
            .siteCollections(java.util.Arrays.asList(sourceOptionsSiteCollModel))
            .urls(java.util.Arrays.asList(sourceOptionsWebCrawlModel))
            .buckets(java.util.Arrays.asList(sourceOptionsBucketsModel))
            .crawlAllBuckets(true)
            .build();

    // Construct an instance of the Source model
    Source sourceModel =
        new Source.Builder()
            .type("box")
            .credentialId("testString")
            .schedule(sourceScheduleModel)
            .options(sourceOptionsModel)
            .build();

    // Construct an instance of the UpdateConfigurationOptions model
    UpdateConfigurationOptions updateConfigurationOptionsModel =
        new UpdateConfigurationOptions.Builder()
            .environmentId("testString")
            .configurationId("testString")
            .name("testString")
            .description("testString")
            .conversions(conversionsModel)
            .enrichments(java.util.Arrays.asList(enrichmentModel))
            .normalizations(java.util.Arrays.asList(normalizationOperationModel))
            .source(sourceModel)
            .build();

    // Invoke updateConfiguration() with a valid options model and verify the result
    Response<Configuration> response =
        discoveryService.updateConfiguration(updateConfigurationOptionsModel).execute();
    assertNotNull(response);
    Configuration responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateConfigurationPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the updateConfiguration operation with and without retries enabled
  @Test
  public void testUpdateConfigurationWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testUpdateConfigurationWOptions();

    discoveryService.disableRetries();
    testUpdateConfigurationWOptions();
  }

  // Test the updateConfiguration operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateConfigurationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.updateConfiguration(null).execute();
  }

  // Test the deleteConfiguration operation with a valid options model parameter
  @Test
  public void testDeleteConfigurationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"configuration_id\": \"configurationId\", \"status\": \"deleted\", \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}]}";
    String deleteConfigurationPath = "/v1/environments/testString/configurations/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the DeleteConfigurationOptions model
    DeleteConfigurationOptions deleteConfigurationOptionsModel =
        new DeleteConfigurationOptions.Builder()
            .environmentId("testString")
            .configurationId("testString")
            .build();

    // Invoke deleteConfiguration() with a valid options model and verify the result
    Response<DeleteConfigurationResponse> response =
        discoveryService.deleteConfiguration(deleteConfigurationOptionsModel).execute();
    assertNotNull(response);
    DeleteConfigurationResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteConfigurationPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteConfiguration operation with and without retries enabled
  @Test
  public void testDeleteConfigurationWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteConfigurationWOptions();

    discoveryService.disableRetries();
    testDeleteConfigurationWOptions();
  }

  // Test the deleteConfiguration operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteConfigurationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteConfiguration(null).execute();
  }

  // Test the createCollection operation with a valid options model parameter
  @Test
  public void testCreateCollectionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"active\", \"configuration_id\": \"configurationId\", \"language\": \"language\", \"document_counts\": {\"available\": 9, \"processing\": 10, \"failed\": 6, \"pending\": 7}, \"disk_usage\": {\"used_bytes\": 9}, \"training_status\": {\"total_examples\": 13, \"available\": false, \"processing\": true, \"minimum_queries_added\": false, \"minimum_examples_added\": true, \"sufficient_label_diversity\": true, \"notices\": 7, \"successfully_trained\": \"2019-01-01T12:00:00.000Z\", \"data_updated\": \"2019-01-01T12:00:00.000Z\"}, \"crawl_status\": {\"source_crawl\": {\"status\": \"running\", \"next_crawl\": \"2019-01-01T12:00:00.000Z\"}}, \"smart_document_understanding\": {\"enabled\": true, \"total_annotated_pages\": 19, \"total_pages\": 10, \"total_documents\": 14, \"custom_fields\": {\"defined\": 7, \"maximum_allowed\": 14}}}";
    String createCollectionPath = "/v1/environments/testString/collections";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateCollectionOptions model
    CreateCollectionOptions createCollectionOptionsModel =
        new CreateCollectionOptions.Builder()
            .environmentId("testString")
            .name("testString")
            .description("testString")
            .configurationId("testString")
            .language("en")
            .build();

    // Invoke createCollection() with a valid options model and verify the result
    Response<Collection> response =
        discoveryService.createCollection(createCollectionOptionsModel).execute();
    assertNotNull(response);
    Collection responseObj = response.getResult();
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

  // Test the listCollections operation with a valid options model parameter
  @Test
  public void testListCollectionsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"collections\": [{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"active\", \"configuration_id\": \"configurationId\", \"language\": \"language\", \"document_counts\": {\"available\": 9, \"processing\": 10, \"failed\": 6, \"pending\": 7}, \"disk_usage\": {\"used_bytes\": 9}, \"training_status\": {\"total_examples\": 13, \"available\": false, \"processing\": true, \"minimum_queries_added\": false, \"minimum_examples_added\": true, \"sufficient_label_diversity\": true, \"notices\": 7, \"successfully_trained\": \"2019-01-01T12:00:00.000Z\", \"data_updated\": \"2019-01-01T12:00:00.000Z\"}, \"crawl_status\": {\"source_crawl\": {\"status\": \"running\", \"next_crawl\": \"2019-01-01T12:00:00.000Z\"}}, \"smart_document_understanding\": {\"enabled\": true, \"total_annotated_pages\": 19, \"total_pages\": 10, \"total_documents\": 14, \"custom_fields\": {\"defined\": 7, \"maximum_allowed\": 14}}}]}";
    String listCollectionsPath = "/v1/environments/testString/collections";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListCollectionsOptions model
    ListCollectionsOptions listCollectionsOptionsModel =
        new ListCollectionsOptions.Builder().environmentId("testString").name("testString").build();

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
    assertEquals(query.get("name"), "testString");
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

  // Test the getCollection operation with a valid options model parameter
  @Test
  public void testGetCollectionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"active\", \"configuration_id\": \"configurationId\", \"language\": \"language\", \"document_counts\": {\"available\": 9, \"processing\": 10, \"failed\": 6, \"pending\": 7}, \"disk_usage\": {\"used_bytes\": 9}, \"training_status\": {\"total_examples\": 13, \"available\": false, \"processing\": true, \"minimum_queries_added\": false, \"minimum_examples_added\": true, \"sufficient_label_diversity\": true, \"notices\": 7, \"successfully_trained\": \"2019-01-01T12:00:00.000Z\", \"data_updated\": \"2019-01-01T12:00:00.000Z\"}, \"crawl_status\": {\"source_crawl\": {\"status\": \"running\", \"next_crawl\": \"2019-01-01T12:00:00.000Z\"}}, \"smart_document_understanding\": {\"enabled\": true, \"total_annotated_pages\": 19, \"total_pages\": 10, \"total_documents\": 14, \"custom_fields\": {\"defined\": 7, \"maximum_allowed\": 14}}}";
    String getCollectionPath = "/v1/environments/testString/collections/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetCollectionOptions model
    GetCollectionOptions getCollectionOptionsModel =
        new GetCollectionOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke getCollection() with a valid options model and verify the result
    Response<Collection> response =
        discoveryService.getCollection(getCollectionOptionsModel).execute();
    assertNotNull(response);
    Collection responseObj = response.getResult();
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
        "{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"active\", \"configuration_id\": \"configurationId\", \"language\": \"language\", \"document_counts\": {\"available\": 9, \"processing\": 10, \"failed\": 6, \"pending\": 7}, \"disk_usage\": {\"used_bytes\": 9}, \"training_status\": {\"total_examples\": 13, \"available\": false, \"processing\": true, \"minimum_queries_added\": false, \"minimum_examples_added\": true, \"sufficient_label_diversity\": true, \"notices\": 7, \"successfully_trained\": \"2019-01-01T12:00:00.000Z\", \"data_updated\": \"2019-01-01T12:00:00.000Z\"}, \"crawl_status\": {\"source_crawl\": {\"status\": \"running\", \"next_crawl\": \"2019-01-01T12:00:00.000Z\"}}, \"smart_document_understanding\": {\"enabled\": true, \"total_annotated_pages\": 19, \"total_pages\": 10, \"total_documents\": 14, \"custom_fields\": {\"defined\": 7, \"maximum_allowed\": 14}}}";
    String updateCollectionPath = "/v1/environments/testString/collections/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the UpdateCollectionOptions model
    UpdateCollectionOptions updateCollectionOptionsModel =
        new UpdateCollectionOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .name("testString")
            .description("testString")
            .configurationId("testString")
            .build();

    // Invoke updateCollection() with a valid options model and verify the result
    Response<Collection> response =
        discoveryService.updateCollection(updateCollectionOptionsModel).execute();
    assertNotNull(response);
    Collection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
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
    String mockResponseBody = "{\"collection_id\": \"collectionId\", \"status\": \"deleted\"}";
    String deleteCollectionPath = "/v1/environments/testString/collections/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the DeleteCollectionOptions model
    DeleteCollectionOptions deleteCollectionOptionsModel =
        new DeleteCollectionOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke deleteCollection() with a valid options model and verify the result
    Response<DeleteCollectionResponse> response =
        discoveryService.deleteCollection(deleteCollectionOptionsModel).execute();
    assertNotNull(response);
    DeleteCollectionResponse responseObj = response.getResult();
    assertNotNull(responseObj);

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

  // Test the listCollectionFields operation with a valid options model parameter
  @Test
  public void testListCollectionFieldsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"fields\": [{\"field\": \"field\", \"type\": \"nested\"}]}";
    String listCollectionFieldsPath = "/v1/environments/testString/collections/testString/fields";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListCollectionFieldsOptions model
    ListCollectionFieldsOptions listCollectionFieldsOptionsModel =
        new ListCollectionFieldsOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke listCollectionFields() with a valid options model and verify the result
    Response<ListCollectionFieldsResponse> response =
        discoveryService.listCollectionFields(listCollectionFieldsOptionsModel).execute();
    assertNotNull(response);
    ListCollectionFieldsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listCollectionFieldsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the listCollectionFields operation with and without retries enabled
  @Test
  public void testListCollectionFieldsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testListCollectionFieldsWOptions();

    discoveryService.disableRetries();
    testListCollectionFieldsWOptions();
  }

  // Test the listCollectionFields operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListCollectionFieldsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.listCollectionFields(null).execute();
  }

  // Test the listExpansions operation with a valid options model parameter
  @Test
  public void testListExpansionsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"expansions\": [{\"input_terms\": [\"inputTerms\"], \"expanded_terms\": [\"expandedTerms\"]}]}";
    String listExpansionsPath = "/v1/environments/testString/collections/testString/expansions";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListExpansionsOptions model
    ListExpansionsOptions listExpansionsOptionsModel =
        new ListExpansionsOptions.Builder()
            .environmentId("testString")
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
    String createExpansionsPath = "/v1/environments/testString/collections/testString/expansions";
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
            .environmentId("testString")
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
    String deleteExpansionsPath = "/v1/environments/testString/collections/testString/expansions";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteExpansionsOptions model
    DeleteExpansionsOptions deleteExpansionsOptionsModel =
        new DeleteExpansionsOptions.Builder()
            .environmentId("testString")
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

  // Test the getTokenizationDictionaryStatus operation with a valid options model parameter
  @Test
  public void testGetTokenizationDictionaryStatusWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"status\": \"active\", \"type\": \"type\"}";
    String getTokenizationDictionaryStatusPath =
        "/v1/environments/testString/collections/testString/word_lists/tokenization_dictionary";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetTokenizationDictionaryStatusOptions model
    GetTokenizationDictionaryStatusOptions getTokenizationDictionaryStatusOptionsModel =
        new GetTokenizationDictionaryStatusOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke getTokenizationDictionaryStatus() with a valid options model and verify the result
    Response<TokenDictStatusResponse> response =
        discoveryService
            .getTokenizationDictionaryStatus(getTokenizationDictionaryStatusOptionsModel)
            .execute();
    assertNotNull(response);
    TokenDictStatusResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTokenizationDictionaryStatusPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getTokenizationDictionaryStatus operation with and without retries enabled
  @Test
  public void testGetTokenizationDictionaryStatusWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetTokenizationDictionaryStatusWOptions();

    discoveryService.disableRetries();
    testGetTokenizationDictionaryStatusWOptions();
  }

  // Test the getTokenizationDictionaryStatus operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTokenizationDictionaryStatusNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getTokenizationDictionaryStatus(null).execute();
  }

  // Test the createTokenizationDictionary operation with a valid options model parameter
  @Test
  public void testCreateTokenizationDictionaryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"status\": \"active\", \"type\": \"type\"}";
    String createTokenizationDictionaryPath =
        "/v1/environments/testString/collections/testString/word_lists/tokenization_dictionary";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    // Construct an instance of the TokenDictRule model
    TokenDictRule tokenDictRuleModel =
        new TokenDictRule.Builder()
            .text("testString")
            .tokens(java.util.Arrays.asList("testString"))
            .readings(java.util.Arrays.asList("testString"))
            .partOfSpeech("testString")
            .build();

    // Construct an instance of the CreateTokenizationDictionaryOptions model
    CreateTokenizationDictionaryOptions createTokenizationDictionaryOptionsModel =
        new CreateTokenizationDictionaryOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .tokenizationRules(java.util.Arrays.asList(tokenDictRuleModel))
            .build();

    // Invoke createTokenizationDictionary() with a valid options model and verify the result
    Response<TokenDictStatusResponse> response =
        discoveryService
            .createTokenizationDictionary(createTokenizationDictionaryOptionsModel)
            .execute();
    assertNotNull(response);
    TokenDictStatusResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createTokenizationDictionaryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createTokenizationDictionary operation with and without retries enabled
  @Test
  public void testCreateTokenizationDictionaryWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testCreateTokenizationDictionaryWOptions();

    discoveryService.disableRetries();
    testCreateTokenizationDictionaryWOptions();
  }

  // Test the createTokenizationDictionary operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTokenizationDictionaryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.createTokenizationDictionary(null).execute();
  }

  // Test the deleteTokenizationDictionary operation with a valid options model parameter
  @Test
  public void testDeleteTokenizationDictionaryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteTokenizationDictionaryPath =
        "/v1/environments/testString/collections/testString/word_lists/tokenization_dictionary";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteTokenizationDictionaryOptions model
    DeleteTokenizationDictionaryOptions deleteTokenizationDictionaryOptionsModel =
        new DeleteTokenizationDictionaryOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke deleteTokenizationDictionary() with a valid options model and verify the result
    Response<Void> response =
        discoveryService
            .deleteTokenizationDictionary(deleteTokenizationDictionaryOptionsModel)
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
    assertEquals(parsedPath, deleteTokenizationDictionaryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteTokenizationDictionary operation with and without retries enabled
  @Test
  public void testDeleteTokenizationDictionaryWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteTokenizationDictionaryWOptions();

    discoveryService.disableRetries();
    testDeleteTokenizationDictionaryWOptions();
  }

  // Test the deleteTokenizationDictionary operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTokenizationDictionaryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteTokenizationDictionary(null).execute();
  }

  // Test the getStopwordListStatus operation with a valid options model parameter
  @Test
  public void testGetStopwordListStatusWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"status\": \"active\", \"type\": \"type\"}";
    String getStopwordListStatusPath =
        "/v1/environments/testString/collections/testString/word_lists/stopwords";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetStopwordListStatusOptions model
    GetStopwordListStatusOptions getStopwordListStatusOptionsModel =
        new GetStopwordListStatusOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke getStopwordListStatus() with a valid options model and verify the result
    Response<TokenDictStatusResponse> response =
        discoveryService.getStopwordListStatus(getStopwordListStatusOptionsModel).execute();
    assertNotNull(response);
    TokenDictStatusResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getStopwordListStatusPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getStopwordListStatus operation with and without retries enabled
  @Test
  public void testGetStopwordListStatusWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetStopwordListStatusWOptions();

    discoveryService.disableRetries();
    testGetStopwordListStatusWOptions();
  }

  // Test the getStopwordListStatus operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetStopwordListStatusNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getStopwordListStatus(null).execute();
  }

  // Test the createStopwordList operation with a valid options model parameter
  @Test
  public void testCreateStopwordListWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"status\": \"active\", \"type\": \"type\"}";
    String createStopwordListPath =
        "/v1/environments/testString/collections/testString/word_lists/stopwords";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateStopwordListOptions model
    CreateStopwordListOptions createStopwordListOptionsModel =
        new CreateStopwordListOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .stopwordFile(TestUtilities.createMockStream("This is a mock file."))
            .stopwordFilename("testString")
            .build();

    // Invoke createStopwordList() with a valid options model and verify the result
    Response<TokenDictStatusResponse> response =
        discoveryService.createStopwordList(createStopwordListOptionsModel).execute();
    assertNotNull(response);
    TokenDictStatusResponse responseObj = response.getResult();
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
    String deleteStopwordListPath =
        "/v1/environments/testString/collections/testString/word_lists/stopwords";
    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    // Construct an instance of the DeleteStopwordListOptions model
    DeleteStopwordListOptions deleteStopwordListOptionsModel =
        new DeleteStopwordListOptions.Builder()
            .environmentId("testString")
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

  // Test the addDocument operation with a valid options model parameter
  @Test
  public void testAddDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"status\": \"processing\", \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}]}";
    String addDocumentPath = "/v1/environments/testString/collections/testString/documents";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    // Construct an instance of the AddDocumentOptions model
    AddDocumentOptions addDocumentOptionsModel =
        new AddDocumentOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .file(TestUtilities.createMockStream("This is a mock file."))
            .filename("testString")
            .fileContentType("application/json")
            .metadata("testString")
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

  // Test the getDocumentStatus operation with a valid options model parameter
  @Test
  public void testGetDocumentStatusWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"configuration_id\": \"configurationId\", \"status\": \"available\", \"status_description\": \"statusDescription\", \"filename\": \"filename\", \"file_type\": \"pdf\", \"sha1\": \"sha1\", \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}]}";
    String getDocumentStatusPath =
        "/v1/environments/testString/collections/testString/documents/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetDocumentStatusOptions model
    GetDocumentStatusOptions getDocumentStatusOptionsModel =
        new GetDocumentStatusOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .documentId("testString")
            .build();

    // Invoke getDocumentStatus() with a valid options model and verify the result
    Response<DocumentStatus> response =
        discoveryService.getDocumentStatus(getDocumentStatusOptionsModel).execute();
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
    assertEquals(query.get("version"), "testString");
  }

  // Test the getDocumentStatus operation with and without retries enabled
  @Test
  public void testGetDocumentStatusWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetDocumentStatusWOptions();

    discoveryService.disableRetries();
    testGetDocumentStatusWOptions();
  }

  // Test the getDocumentStatus operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetDocumentStatusNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getDocumentStatus(null).execute();
  }

  // Test the updateDocument operation with a valid options model parameter
  @Test
  public void testUpdateDocumentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"status\": \"processing\", \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}]}";
    String updateDocumentPath =
        "/v1/environments/testString/collections/testString/documents/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    // Construct an instance of the UpdateDocumentOptions model
    UpdateDocumentOptions updateDocumentOptionsModel =
        new UpdateDocumentOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .documentId("testString")
            .file(TestUtilities.createMockStream("This is a mock file."))
            .filename("testString")
            .fileContentType("application/json")
            .metadata("testString")
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
        "/v1/environments/testString/collections/testString/documents/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the DeleteDocumentOptions model
    DeleteDocumentOptions deleteDocumentOptionsModel =
        new DeleteDocumentOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .documentId("testString")
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
        "{\"matching_results\": 15, \"results\": [{\"id\": \"id\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"collection_id\": \"collectionId\", \"result_metadata\": {\"score\": 5, \"confidence\": 10}}], \"aggregations\": [{\"type\": \"filter\", \"match\": \"match\", \"matching_results\": 15}], \"passages\": [{\"document_id\": \"documentId\", \"passage_score\": 12, \"passage_text\": \"passageText\", \"start_offset\": 11, \"end_offset\": 9, \"field\": \"field\"}], \"duplicates_removed\": 17, \"session_token\": \"sessionToken\", \"retrieval_details\": {\"document_retrieval_strategy\": \"untrained\"}, \"suggested_query\": \"suggestedQuery\"}";
    String queryPath = "/v1/environments/testString/collections/testString/query";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the QueryOptions model
    QueryOptions queryOptionsModel =
        new QueryOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .filter("testString")
            .query("testString")
            .naturalLanguageQuery("testString")
            .passages(true)
            .aggregation("testString")
            .count(Long.valueOf("26"))
            .xReturn("testString")
            .offset(Long.valueOf("26"))
            .sort("testString")
            .highlight(false)
            .passagesFields("testString")
            .passagesCount(Long.valueOf("100"))
            .passagesCharacters(Long.valueOf("50"))
            .deduplicate(false)
            .deduplicateField("testString")
            .similar(false)
            .similarDocumentIds("testString")
            .similarFields("testString")
            .bias("testString")
            .spellingSuggestions(false)
            .xWatsonLoggingOptOut(false)
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

  // Test the queryNotices operation with a valid options model parameter
  @Test
  public void testQueryNoticesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"matching_results\": 15, \"results\": [{\"id\": \"id\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"collection_id\": \"collectionId\", \"result_metadata\": {\"score\": 5, \"confidence\": 10}, \"code\": 4, \"filename\": \"filename\", \"file_type\": \"pdf\", \"sha1\": \"sha1\", \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}]}], \"aggregations\": [{\"type\": \"filter\", \"match\": \"match\", \"matching_results\": 15}], \"passages\": [{\"document_id\": \"documentId\", \"passage_score\": 12, \"passage_text\": \"passageText\", \"start_offset\": 11, \"end_offset\": 9, \"field\": \"field\"}], \"duplicates_removed\": 17}";
    String queryNoticesPath = "/v1/environments/testString/collections/testString/notices";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the QueryNoticesOptions model
    QueryNoticesOptions queryNoticesOptionsModel =
        new QueryNoticesOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .filter("testString")
            .query("testString")
            .naturalLanguageQuery("testString")
            .passages(true)
            .aggregation("testString")
            .count(Long.valueOf("26"))
            .xReturn(java.util.Arrays.asList("testString"))
            .offset(Long.valueOf("26"))
            .sort(java.util.Arrays.asList("testString"))
            .highlight(false)
            .passagesFields(java.util.Arrays.asList("testString"))
            .passagesCount(Long.valueOf("100"))
            .passagesCharacters(Long.valueOf("50"))
            .deduplicateField("testString")
            .similar(false)
            .similarDocumentIds(java.util.Arrays.asList("testString"))
            .similarFields(java.util.Arrays.asList("testString"))
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
    assertEquals(Boolean.valueOf(query.get("passages")), Boolean.valueOf(true));
    assertEquals(query.get("aggregation"), "testString");
    assertEquals(Long.valueOf(query.get("count")), Long.valueOf("26"));
    assertEquals(
        query.get("return"), RequestUtils.join(java.util.Arrays.asList("testString"), ","));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(query.get("sort"), RequestUtils.join(java.util.Arrays.asList("testString"), ","));
    assertEquals(Boolean.valueOf(query.get("highlight")), Boolean.valueOf(false));
    assertEquals(
        query.get("passages.fields"),
        RequestUtils.join(java.util.Arrays.asList("testString"), ","));
    assertEquals(Long.valueOf(query.get("passages.count")), Long.valueOf("100"));
    assertEquals(Long.valueOf(query.get("passages.characters")), Long.valueOf("50"));
    assertEquals(query.get("deduplicate.field"), "testString");
    assertEquals(Boolean.valueOf(query.get("similar")), Boolean.valueOf(false));
    assertEquals(
        query.get("similar.document_ids"),
        RequestUtils.join(java.util.Arrays.asList("testString"), ","));
    assertEquals(
        query.get("similar.fields"), RequestUtils.join(java.util.Arrays.asList("testString"), ","));
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

  // Test the federatedQuery operation with a valid options model parameter
  @Test
  public void testFederatedQueryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"matching_results\": 15, \"results\": [{\"id\": \"id\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"collection_id\": \"collectionId\", \"result_metadata\": {\"score\": 5, \"confidence\": 10}}], \"aggregations\": [{\"type\": \"filter\", \"match\": \"match\", \"matching_results\": 15}], \"passages\": [{\"document_id\": \"documentId\", \"passage_score\": 12, \"passage_text\": \"passageText\", \"start_offset\": 11, \"end_offset\": 9, \"field\": \"field\"}], \"duplicates_removed\": 17, \"session_token\": \"sessionToken\", \"retrieval_details\": {\"document_retrieval_strategy\": \"untrained\"}, \"suggested_query\": \"suggestedQuery\"}";
    String federatedQueryPath = "/v1/environments/testString/query";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the FederatedQueryOptions model
    FederatedQueryOptions federatedQueryOptionsModel =
        new FederatedQueryOptions.Builder()
            .environmentId("testString")
            .collectionIds("testString")
            .filter("testString")
            .query("testString")
            .naturalLanguageQuery("testString")
            .passages(true)
            .aggregation("testString")
            .count(Long.valueOf("26"))
            .xReturn("testString")
            .offset(Long.valueOf("26"))
            .sort("testString")
            .highlight(false)
            .passagesFields("testString")
            .passagesCount(Long.valueOf("100"))
            .passagesCharacters(Long.valueOf("50"))
            .deduplicate(false)
            .deduplicateField("testString")
            .similar(false)
            .similarDocumentIds("testString")
            .similarFields("testString")
            .bias("testString")
            .xWatsonLoggingOptOut(false)
            .build();

    // Invoke federatedQuery() with a valid options model and verify the result
    Response<QueryResponse> response =
        discoveryService.federatedQuery(federatedQueryOptionsModel).execute();
    assertNotNull(response);
    QueryResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, federatedQueryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the federatedQuery operation with and without retries enabled
  @Test
  public void testFederatedQueryWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testFederatedQueryWOptions();

    discoveryService.disableRetries();
    testFederatedQueryWOptions();
  }

  // Test the federatedQuery operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testFederatedQueryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.federatedQuery(null).execute();
  }

  // Test the federatedQueryNotices operation with a valid options model parameter
  @Test
  public void testFederatedQueryNoticesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"matching_results\": 15, \"results\": [{\"id\": \"id\", \"metadata\": {\"anyKey\": \"anyValue\"}, \"collection_id\": \"collectionId\", \"result_metadata\": {\"score\": 5, \"confidence\": 10}, \"code\": 4, \"filename\": \"filename\", \"file_type\": \"pdf\", \"sha1\": \"sha1\", \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}]}], \"aggregations\": [{\"type\": \"filter\", \"match\": \"match\", \"matching_results\": 15}], \"passages\": [{\"document_id\": \"documentId\", \"passage_score\": 12, \"passage_text\": \"passageText\", \"start_offset\": 11, \"end_offset\": 9, \"field\": \"field\"}], \"duplicates_removed\": 17}";
    String federatedQueryNoticesPath = "/v1/environments/testString/notices";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the FederatedQueryNoticesOptions model
    FederatedQueryNoticesOptions federatedQueryNoticesOptionsModel =
        new FederatedQueryNoticesOptions.Builder()
            .environmentId("testString")
            .collectionIds(java.util.Arrays.asList("testString"))
            .filter("testString")
            .query("testString")
            .naturalLanguageQuery("testString")
            .aggregation("testString")
            .count(Long.valueOf("26"))
            .xReturn(java.util.Arrays.asList("testString"))
            .offset(Long.valueOf("26"))
            .sort(java.util.Arrays.asList("testString"))
            .highlight(false)
            .deduplicateField("testString")
            .similar(false)
            .similarDocumentIds(java.util.Arrays.asList("testString"))
            .similarFields(java.util.Arrays.asList("testString"))
            .build();

    // Invoke federatedQueryNotices() with a valid options model and verify the result
    Response<QueryNoticesResponse> response =
        discoveryService.federatedQueryNotices(federatedQueryNoticesOptionsModel).execute();
    assertNotNull(response);
    QueryNoticesResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, federatedQueryNoticesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(
        query.get("collection_ids"), RequestUtils.join(java.util.Arrays.asList("testString"), ","));
    assertEquals(query.get("filter"), "testString");
    assertEquals(query.get("query"), "testString");
    assertEquals(query.get("natural_language_query"), "testString");
    assertEquals(query.get("aggregation"), "testString");
    assertEquals(Long.valueOf(query.get("count")), Long.valueOf("26"));
    assertEquals(
        query.get("return"), RequestUtils.join(java.util.Arrays.asList("testString"), ","));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(query.get("sort"), RequestUtils.join(java.util.Arrays.asList("testString"), ","));
    assertEquals(Boolean.valueOf(query.get("highlight")), Boolean.valueOf(false));
    assertEquals(query.get("deduplicate.field"), "testString");
    assertEquals(Boolean.valueOf(query.get("similar")), Boolean.valueOf(false));
    assertEquals(
        query.get("similar.document_ids"),
        RequestUtils.join(java.util.Arrays.asList("testString"), ","));
    assertEquals(
        query.get("similar.fields"), RequestUtils.join(java.util.Arrays.asList("testString"), ","));
  }

  // Test the federatedQueryNotices operation with and without retries enabled
  @Test
  public void testFederatedQueryNoticesWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testFederatedQueryNoticesWOptions();

    discoveryService.disableRetries();
    testFederatedQueryNoticesWOptions();
  }

  // Test the federatedQueryNotices operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testFederatedQueryNoticesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.federatedQueryNotices(null).execute();
  }

  // Test the getAutocompletion operation with a valid options model parameter
  @Test
  public void testGetAutocompletionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"completions\": [\"completions\"]}";
    String getAutocompletionPath =
        "/v1/environments/testString/collections/testString/autocompletion";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetAutocompletionOptions model
    GetAutocompletionOptions getAutocompletionOptionsModel =
        new GetAutocompletionOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .prefix("testString")
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

  // Test the listTrainingData operation with a valid options model parameter
  @Test
  public void testListTrainingDataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"environment_id\": \"environmentId\", \"collection_id\": \"collectionId\", \"queries\": [{\"query_id\": \"queryId\", \"natural_language_query\": \"naturalLanguageQuery\", \"filter\": \"filter\", \"examples\": [{\"document_id\": \"documentId\", \"cross_reference\": \"crossReference\", \"relevance\": 9}]}]}";
    String listTrainingDataPath =
        "/v1/environments/testString/collections/testString/training_data";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListTrainingDataOptions model
    ListTrainingDataOptions listTrainingDataOptionsModel =
        new ListTrainingDataOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke listTrainingData() with a valid options model and verify the result
    Response<TrainingDataSet> response =
        discoveryService.listTrainingData(listTrainingDataOptionsModel).execute();
    assertNotNull(response);
    TrainingDataSet responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listTrainingDataPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the listTrainingData operation with and without retries enabled
  @Test
  public void testListTrainingDataWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testListTrainingDataWOptions();

    discoveryService.disableRetries();
    testListTrainingDataWOptions();
  }

  // Test the listTrainingData operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTrainingDataNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.listTrainingData(null).execute();
  }

  // Test the addTrainingData operation with a valid options model parameter
  @Test
  public void testAddTrainingDataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"query_id\": \"queryId\", \"natural_language_query\": \"naturalLanguageQuery\", \"filter\": \"filter\", \"examples\": [{\"document_id\": \"documentId\", \"cross_reference\": \"crossReference\", \"relevance\": 9}]}";
    String addTrainingDataPath = "/v1/environments/testString/collections/testString/training_data";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the TrainingExample model
    TrainingExample trainingExampleModel =
        new TrainingExample.Builder()
            .documentId("testString")
            .crossReference("testString")
            .relevance(Long.valueOf("26"))
            .build();

    // Construct an instance of the AddTrainingDataOptions model
    AddTrainingDataOptions addTrainingDataOptionsModel =
        new AddTrainingDataOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .naturalLanguageQuery("testString")
            .filter("testString")
            .examples(java.util.Arrays.asList(trainingExampleModel))
            .build();

    // Invoke addTrainingData() with a valid options model and verify the result
    Response<TrainingQuery> response =
        discoveryService.addTrainingData(addTrainingDataOptionsModel).execute();
    assertNotNull(response);
    TrainingQuery responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addTrainingDataPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the addTrainingData operation with and without retries enabled
  @Test
  public void testAddTrainingDataWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testAddTrainingDataWOptions();

    discoveryService.disableRetries();
    testAddTrainingDataWOptions();
  }

  // Test the addTrainingData operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddTrainingDataNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.addTrainingData(null).execute();
  }

  // Test the deleteAllTrainingData operation with a valid options model parameter
  @Test
  public void testDeleteAllTrainingDataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteAllTrainingDataPath =
        "/v1/environments/testString/collections/testString/training_data";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteAllTrainingDataOptions model
    DeleteAllTrainingDataOptions deleteAllTrainingDataOptionsModel =
        new DeleteAllTrainingDataOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke deleteAllTrainingData() with a valid options model and verify the result
    Response<Void> response =
        discoveryService.deleteAllTrainingData(deleteAllTrainingDataOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAllTrainingDataPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteAllTrainingData operation with and without retries enabled
  @Test
  public void testDeleteAllTrainingDataWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteAllTrainingDataWOptions();

    discoveryService.disableRetries();
    testDeleteAllTrainingDataWOptions();
  }

  // Test the deleteAllTrainingData operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAllTrainingDataNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteAllTrainingData(null).execute();
  }

  // Test the getTrainingData operation with a valid options model parameter
  @Test
  public void testGetTrainingDataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"query_id\": \"queryId\", \"natural_language_query\": \"naturalLanguageQuery\", \"filter\": \"filter\", \"examples\": [{\"document_id\": \"documentId\", \"cross_reference\": \"crossReference\", \"relevance\": 9}]}";
    String getTrainingDataPath =
        "/v1/environments/testString/collections/testString/training_data/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetTrainingDataOptions model
    GetTrainingDataOptions getTrainingDataOptionsModel =
        new GetTrainingDataOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .queryId("testString")
            .build();

    // Invoke getTrainingData() with a valid options model and verify the result
    Response<TrainingQuery> response =
        discoveryService.getTrainingData(getTrainingDataOptionsModel).execute();
    assertNotNull(response);
    TrainingQuery responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTrainingDataPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getTrainingData operation with and without retries enabled
  @Test
  public void testGetTrainingDataWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetTrainingDataWOptions();

    discoveryService.disableRetries();
    testGetTrainingDataWOptions();
  }

  // Test the getTrainingData operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTrainingDataNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getTrainingData(null).execute();
  }

  // Test the deleteTrainingData operation with a valid options model parameter
  @Test
  public void testDeleteTrainingDataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteTrainingDataPath =
        "/v1/environments/testString/collections/testString/training_data/testString";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteTrainingDataOptions model
    DeleteTrainingDataOptions deleteTrainingDataOptionsModel =
        new DeleteTrainingDataOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .queryId("testString")
            .build();

    // Invoke deleteTrainingData() with a valid options model and verify the result
    Response<Void> response =
        discoveryService.deleteTrainingData(deleteTrainingDataOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTrainingDataPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteTrainingData operation with and without retries enabled
  @Test
  public void testDeleteTrainingDataWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteTrainingDataWOptions();

    discoveryService.disableRetries();
    testDeleteTrainingDataWOptions();
  }

  // Test the deleteTrainingData operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTrainingDataNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteTrainingData(null).execute();
  }

  // Test the listTrainingExamples operation with a valid options model parameter
  @Test
  public void testListTrainingExamplesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"examples\": [{\"document_id\": \"documentId\", \"cross_reference\": \"crossReference\", \"relevance\": 9}]}";
    String listTrainingExamplesPath =
        "/v1/environments/testString/collections/testString/training_data/testString/examples";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListTrainingExamplesOptions model
    ListTrainingExamplesOptions listTrainingExamplesOptionsModel =
        new ListTrainingExamplesOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .queryId("testString")
            .build();

    // Invoke listTrainingExamples() with a valid options model and verify the result
    Response<TrainingExampleList> response =
        discoveryService.listTrainingExamples(listTrainingExamplesOptionsModel).execute();
    assertNotNull(response);
    TrainingExampleList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listTrainingExamplesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the listTrainingExamples operation with and without retries enabled
  @Test
  public void testListTrainingExamplesWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testListTrainingExamplesWOptions();

    discoveryService.disableRetries();
    testListTrainingExamplesWOptions();
  }

  // Test the listTrainingExamples operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTrainingExamplesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.listTrainingExamples(null).execute();
  }

  // Test the createTrainingExample operation with a valid options model parameter
  @Test
  public void testCreateTrainingExampleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"cross_reference\": \"crossReference\", \"relevance\": 9}";
    String createTrainingExamplePath =
        "/v1/environments/testString/collections/testString/training_data/testString/examples";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateTrainingExampleOptions model
    CreateTrainingExampleOptions createTrainingExampleOptionsModel =
        new CreateTrainingExampleOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .queryId("testString")
            .documentId("testString")
            .crossReference("testString")
            .relevance(Long.valueOf("26"))
            .build();

    // Invoke createTrainingExample() with a valid options model and verify the result
    Response<TrainingExample> response =
        discoveryService.createTrainingExample(createTrainingExampleOptionsModel).execute();
    assertNotNull(response);
    TrainingExample responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createTrainingExamplePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createTrainingExample operation with and without retries enabled
  @Test
  public void testCreateTrainingExampleWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testCreateTrainingExampleWOptions();

    discoveryService.disableRetries();
    testCreateTrainingExampleWOptions();
  }

  // Test the createTrainingExample operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTrainingExampleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.createTrainingExample(null).execute();
  }

  // Test the deleteTrainingExample operation with a valid options model parameter
  @Test
  public void testDeleteTrainingExampleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteTrainingExamplePath =
        "/v1/environments/testString/collections/testString/training_data/testString/examples/testString";
    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    // Construct an instance of the DeleteTrainingExampleOptions model
    DeleteTrainingExampleOptions deleteTrainingExampleOptionsModel =
        new DeleteTrainingExampleOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .queryId("testString")
            .exampleId("testString")
            .build();

    // Invoke deleteTrainingExample() with a valid options model and verify the result
    Response<Void> response =
        discoveryService.deleteTrainingExample(deleteTrainingExampleOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTrainingExamplePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteTrainingExample operation with and without retries enabled
  @Test
  public void testDeleteTrainingExampleWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteTrainingExampleWOptions();

    discoveryService.disableRetries();
    testDeleteTrainingExampleWOptions();
  }

  // Test the deleteTrainingExample operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTrainingExampleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteTrainingExample(null).execute();
  }

  // Test the updateTrainingExample operation with a valid options model parameter
  @Test
  public void testUpdateTrainingExampleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"cross_reference\": \"crossReference\", \"relevance\": 9}";
    String updateTrainingExamplePath =
        "/v1/environments/testString/collections/testString/training_data/testString/examples/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the UpdateTrainingExampleOptions model
    UpdateTrainingExampleOptions updateTrainingExampleOptionsModel =
        new UpdateTrainingExampleOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .queryId("testString")
            .exampleId("testString")
            .crossReference("testString")
            .relevance(Long.valueOf("26"))
            .build();

    // Invoke updateTrainingExample() with a valid options model and verify the result
    Response<TrainingExample> response =
        discoveryService.updateTrainingExample(updateTrainingExampleOptionsModel).execute();
    assertNotNull(response);
    TrainingExample responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateTrainingExamplePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the updateTrainingExample operation with and without retries enabled
  @Test
  public void testUpdateTrainingExampleWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testUpdateTrainingExampleWOptions();

    discoveryService.disableRetries();
    testUpdateTrainingExampleWOptions();
  }

  // Test the updateTrainingExample operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateTrainingExampleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.updateTrainingExample(null).execute();
  }

  // Test the getTrainingExample operation with a valid options model parameter
  @Test
  public void testGetTrainingExampleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"cross_reference\": \"crossReference\", \"relevance\": 9}";
    String getTrainingExamplePath =
        "/v1/environments/testString/collections/testString/training_data/testString/examples/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetTrainingExampleOptions model
    GetTrainingExampleOptions getTrainingExampleOptionsModel =
        new GetTrainingExampleOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .queryId("testString")
            .exampleId("testString")
            .build();

    // Invoke getTrainingExample() with a valid options model and verify the result
    Response<TrainingExample> response =
        discoveryService.getTrainingExample(getTrainingExampleOptionsModel).execute();
    assertNotNull(response);
    TrainingExample responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTrainingExamplePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getTrainingExample operation with and without retries enabled
  @Test
  public void testGetTrainingExampleWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetTrainingExampleWOptions();

    discoveryService.disableRetries();
    testGetTrainingExampleWOptions();
  }

  // Test the getTrainingExample operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTrainingExampleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getTrainingExample(null).execute();
  }

  // Test the deleteUserData operation with a valid options model parameter
  @Test
  public void testDeleteUserDataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteUserDataPath = "/v1/user_data";
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

  // Test the createEvent operation with a valid options model parameter
  @Test
  public void testCreateEventWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"type\": \"click\", \"data\": {\"environment_id\": \"environmentId\", \"session_token\": \"sessionToken\", \"client_timestamp\": \"2019-01-01T12:00:00.000Z\", \"display_rank\": 11, \"collection_id\": \"collectionId\", \"document_id\": \"documentId\", \"query_id\": \"queryId\"}}";
    String createEventPath = "/v1/events";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    // Construct an instance of the EventData model
    EventData eventDataModel =
        new EventData.Builder()
            .environmentId("testString")
            .sessionToken("testString")
            .clientTimestamp(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .displayRank(Long.valueOf("26"))
            .collectionId("testString")
            .documentId("testString")
            .build();

    // Construct an instance of the CreateEventOptions model
    CreateEventOptions createEventOptionsModel =
        new CreateEventOptions.Builder().type("click").data(eventDataModel).build();

    // Invoke createEvent() with a valid options model and verify the result
    Response<CreateEventResponse> response =
        discoveryService.createEvent(createEventOptionsModel).execute();
    assertNotNull(response);
    CreateEventResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createEventPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createEvent operation with and without retries enabled
  @Test
  public void testCreateEventWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testCreateEventWOptions();

    discoveryService.disableRetries();
    testCreateEventWOptions();
  }

  // Test the createEvent operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateEventNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.createEvent(null).execute();
  }

  // Test the queryLog operation with a valid options model parameter
  @Test
  public void testQueryLogWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"matching_results\": 15, \"results\": [{\"environment_id\": \"environmentId\", \"customer_id\": \"customerId\", \"document_type\": \"query\", \"natural_language_query\": \"naturalLanguageQuery\", \"document_results\": {\"results\": [{\"position\": 8, \"document_id\": \"documentId\", \"score\": 5, \"confidence\": 10, \"collection_id\": \"collectionId\"}], \"count\": 5}, \"created_timestamp\": \"2019-01-01T12:00:00.000Z\", \"client_timestamp\": \"2019-01-01T12:00:00.000Z\", \"query_id\": \"queryId\", \"session_token\": \"sessionToken\", \"collection_id\": \"collectionId\", \"display_rank\": 11, \"document_id\": \"documentId\", \"event_type\": \"click\", \"result_type\": \"document\"}]}";
    String queryLogPath = "/v1/logs";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the QueryLogOptions model
    QueryLogOptions queryLogOptionsModel =
        new QueryLogOptions.Builder()
            .filter("testString")
            .query("testString")
            .count(Long.valueOf("26"))
            .offset(Long.valueOf("26"))
            .sort(java.util.Arrays.asList("testString"))
            .build();

    // Invoke queryLog() with a valid options model and verify the result
    Response<LogQueryResponse> response = discoveryService.queryLog(queryLogOptionsModel).execute();
    assertNotNull(response);
    LogQueryResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, queryLogPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("filter"), "testString");
    assertEquals(query.get("query"), "testString");
    assertEquals(Long.valueOf(query.get("count")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(query.get("sort"), RequestUtils.join(java.util.Arrays.asList("testString"), ","));
  }

  // Test the queryLog operation with and without retries enabled
  @Test
  public void testQueryLogWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testQueryLogWOptions();

    discoveryService.disableRetries();
    testQueryLogWOptions();
  }

  // Test the getMetricsQuery operation with a valid options model parameter
  @Test
  public void testGetMetricsQueryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"aggregations\": [{\"interval\": \"interval\", \"event_type\": \"eventType\", \"results\": [{\"key_as_string\": \"2019-01-01T12:00:00.000Z\", \"key\": 3, \"matching_results\": 15, \"event_rate\": 9}]}]}";
    String getMetricsQueryPath = "/v1/metrics/number_of_queries";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetMetricsQueryOptions model
    GetMetricsQueryOptions getMetricsQueryOptionsModel =
        new GetMetricsQueryOptions.Builder()
            .startTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .endTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .resultType("document")
            .build();

    // Invoke getMetricsQuery() with a valid options model and verify the result
    Response<MetricResponse> response =
        discoveryService.getMetricsQuery(getMetricsQueryOptionsModel).execute();
    assertNotNull(response);
    MetricResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getMetricsQueryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("result_type"), "document");
  }

  // Test the getMetricsQuery operation with and without retries enabled
  @Test
  public void testGetMetricsQueryWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetMetricsQueryWOptions();

    discoveryService.disableRetries();
    testGetMetricsQueryWOptions();
  }

  // Test the getMetricsQueryEvent operation with a valid options model parameter
  @Test
  public void testGetMetricsQueryEventWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"aggregations\": [{\"interval\": \"interval\", \"event_type\": \"eventType\", \"results\": [{\"key_as_string\": \"2019-01-01T12:00:00.000Z\", \"key\": 3, \"matching_results\": 15, \"event_rate\": 9}]}]}";
    String getMetricsQueryEventPath = "/v1/metrics/number_of_queries_with_event";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetMetricsQueryEventOptions model
    GetMetricsQueryEventOptions getMetricsQueryEventOptionsModel =
        new GetMetricsQueryEventOptions.Builder()
            .startTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .endTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .resultType("document")
            .build();

    // Invoke getMetricsQueryEvent() with a valid options model and verify the result
    Response<MetricResponse> response =
        discoveryService.getMetricsQueryEvent(getMetricsQueryEventOptionsModel).execute();
    assertNotNull(response);
    MetricResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getMetricsQueryEventPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("result_type"), "document");
  }

  // Test the getMetricsQueryEvent operation with and without retries enabled
  @Test
  public void testGetMetricsQueryEventWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetMetricsQueryEventWOptions();

    discoveryService.disableRetries();
    testGetMetricsQueryEventWOptions();
  }

  // Test the getMetricsQueryNoResults operation with a valid options model parameter
  @Test
  public void testGetMetricsQueryNoResultsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"aggregations\": [{\"interval\": \"interval\", \"event_type\": \"eventType\", \"results\": [{\"key_as_string\": \"2019-01-01T12:00:00.000Z\", \"key\": 3, \"matching_results\": 15, \"event_rate\": 9}]}]}";
    String getMetricsQueryNoResultsPath = "/v1/metrics/number_of_queries_with_no_search_results";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetMetricsQueryNoResultsOptions model
    GetMetricsQueryNoResultsOptions getMetricsQueryNoResultsOptionsModel =
        new GetMetricsQueryNoResultsOptions.Builder()
            .startTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .endTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .resultType("document")
            .build();

    // Invoke getMetricsQueryNoResults() with a valid options model and verify the result
    Response<MetricResponse> response =
        discoveryService.getMetricsQueryNoResults(getMetricsQueryNoResultsOptionsModel).execute();
    assertNotNull(response);
    MetricResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getMetricsQueryNoResultsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("result_type"), "document");
  }

  // Test the getMetricsQueryNoResults operation with and without retries enabled
  @Test
  public void testGetMetricsQueryNoResultsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetMetricsQueryNoResultsWOptions();

    discoveryService.disableRetries();
    testGetMetricsQueryNoResultsWOptions();
  }

  // Test the getMetricsEventRate operation with a valid options model parameter
  @Test
  public void testGetMetricsEventRateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"aggregations\": [{\"interval\": \"interval\", \"event_type\": \"eventType\", \"results\": [{\"key_as_string\": \"2019-01-01T12:00:00.000Z\", \"key\": 3, \"matching_results\": 15, \"event_rate\": 9}]}]}";
    String getMetricsEventRatePath = "/v1/metrics/event_rate";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetMetricsEventRateOptions model
    GetMetricsEventRateOptions getMetricsEventRateOptionsModel =
        new GetMetricsEventRateOptions.Builder()
            .startTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .endTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .resultType("document")
            .build();

    // Invoke getMetricsEventRate() with a valid options model and verify the result
    Response<MetricResponse> response =
        discoveryService.getMetricsEventRate(getMetricsEventRateOptionsModel).execute();
    assertNotNull(response);
    MetricResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getMetricsEventRatePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("result_type"), "document");
  }

  // Test the getMetricsEventRate operation with and without retries enabled
  @Test
  public void testGetMetricsEventRateWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetMetricsEventRateWOptions();

    discoveryService.disableRetries();
    testGetMetricsEventRateWOptions();
  }

  // Test the getMetricsQueryTokenEvent operation with a valid options model parameter
  @Test
  public void testGetMetricsQueryTokenEventWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"aggregations\": [{\"event_type\": \"eventType\", \"results\": [{\"key\": \"key\", \"matching_results\": 15, \"event_rate\": 9}]}]}";
    String getMetricsQueryTokenEventPath = "/v1/metrics/top_query_tokens_with_event_rate";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetMetricsQueryTokenEventOptions model
    GetMetricsQueryTokenEventOptions getMetricsQueryTokenEventOptionsModel =
        new GetMetricsQueryTokenEventOptions.Builder().count(Long.valueOf("26")).build();

    // Invoke getMetricsQueryTokenEvent() with a valid options model and verify the result
    Response<MetricTokenResponse> response =
        discoveryService.getMetricsQueryTokenEvent(getMetricsQueryTokenEventOptionsModel).execute();
    assertNotNull(response);
    MetricTokenResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getMetricsQueryTokenEventPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
    assertEquals(Long.valueOf(query.get("count")), Long.valueOf("26"));
  }

  // Test the getMetricsQueryTokenEvent operation with and without retries enabled
  @Test
  public void testGetMetricsQueryTokenEventWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetMetricsQueryTokenEventWOptions();

    discoveryService.disableRetries();
    testGetMetricsQueryTokenEventWOptions();
  }

  // Test the listCredentials operation with a valid options model parameter
  @Test
  public void testListCredentialsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"credentials\": [{\"credential_id\": \"credentialId\", \"source_type\": \"box\", \"credential_details\": {\"credential_type\": \"oauth2\", \"client_id\": \"clientId\", \"enterprise_id\": \"enterpriseId\", \"url\": \"url\", \"username\": \"username\", \"organization_url\": \"organizationUrl\", \"site_collection.path\": \"siteCollectionPath\", \"client_secret\": \"clientSecret\", \"public_key_id\": \"publicKeyId\", \"private_key\": \"privateKey\", \"passphrase\": \"passphrase\", \"password\": \"password\", \"gateway_id\": \"gatewayId\", \"source_version\": \"online\", \"web_application_url\": \"webApplicationUrl\", \"domain\": \"domain\", \"endpoint\": \"endpoint\", \"access_key_id\": \"accessKeyId\", \"secret_access_key\": \"secretAccessKey\"}, \"status\": {\"authenticated\": false, \"error_message\": \"errorMessage\"}}]}";
    String listCredentialsPath = "/v1/environments/testString/credentials";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListCredentialsOptions model
    ListCredentialsOptions listCredentialsOptionsModel =
        new ListCredentialsOptions.Builder().environmentId("testString").build();

    // Invoke listCredentials() with a valid options model and verify the result
    Response<CredentialsList> response =
        discoveryService.listCredentials(listCredentialsOptionsModel).execute();
    assertNotNull(response);
    CredentialsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listCredentialsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the listCredentials operation with and without retries enabled
  @Test
  public void testListCredentialsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testListCredentialsWOptions();

    discoveryService.disableRetries();
    testListCredentialsWOptions();
  }

  // Test the listCredentials operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListCredentialsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.listCredentials(null).execute();
  }

  // Test the createCredentials operation with a valid options model parameter
  @Test
  public void testCreateCredentialsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"credential_id\": \"credentialId\", \"source_type\": \"box\", \"credential_details\": {\"credential_type\": \"oauth2\", \"client_id\": \"clientId\", \"enterprise_id\": \"enterpriseId\", \"url\": \"url\", \"username\": \"username\", \"organization_url\": \"organizationUrl\", \"site_collection.path\": \"siteCollectionPath\", \"client_secret\": \"clientSecret\", \"public_key_id\": \"publicKeyId\", \"private_key\": \"privateKey\", \"passphrase\": \"passphrase\", \"password\": \"password\", \"gateway_id\": \"gatewayId\", \"source_version\": \"online\", \"web_application_url\": \"webApplicationUrl\", \"domain\": \"domain\", \"endpoint\": \"endpoint\", \"access_key_id\": \"accessKeyId\", \"secret_access_key\": \"secretAccessKey\"}, \"status\": {\"authenticated\": false, \"error_message\": \"errorMessage\"}}";
    String createCredentialsPath = "/v1/environments/testString/credentials";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the CredentialDetails model
    CredentialDetails credentialDetailsModel =
        new CredentialDetails.Builder()
            .credentialType("oauth2")
            .clientId("testString")
            .enterpriseId("testString")
            .url("testString")
            .username("testString")
            .organizationUrl("testString")
            .siteCollectionPath("testString")
            .clientSecret("testString")
            .publicKeyId("testString")
            .privateKey("testString")
            .passphrase("testString")
            .password("testString")
            .gatewayId("testString")
            .sourceVersion("online")
            .webApplicationUrl("testString")
            .domain("testString")
            .endpoint("testString")
            .accessKeyId("testString")
            .secretAccessKey("testString")
            .build();

    // Construct an instance of the StatusDetails model
    StatusDetails statusDetailsModel =
        new StatusDetails.Builder().authenticated(true).errorMessage("testString").build();

    // Construct an instance of the CreateCredentialsOptions model
    CreateCredentialsOptions createCredentialsOptionsModel =
        new CreateCredentialsOptions.Builder()
            .environmentId("testString")
            .sourceType("box")
            .credentialDetails(credentialDetailsModel)
            .status(statusDetailsModel)
            .build();

    // Invoke createCredentials() with a valid options model and verify the result
    Response<Credentials> response =
        discoveryService.createCredentials(createCredentialsOptionsModel).execute();
    assertNotNull(response);
    Credentials responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createCredentialsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createCredentials operation with and without retries enabled
  @Test
  public void testCreateCredentialsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testCreateCredentialsWOptions();

    discoveryService.disableRetries();
    testCreateCredentialsWOptions();
  }

  // Test the createCredentials operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCredentialsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.createCredentials(null).execute();
  }

  // Test the getCredentials operation with a valid options model parameter
  @Test
  public void testGetCredentialsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"credential_id\": \"credentialId\", \"source_type\": \"box\", \"credential_details\": {\"credential_type\": \"oauth2\", \"client_id\": \"clientId\", \"enterprise_id\": \"enterpriseId\", \"url\": \"url\", \"username\": \"username\", \"organization_url\": \"organizationUrl\", \"site_collection.path\": \"siteCollectionPath\", \"client_secret\": \"clientSecret\", \"public_key_id\": \"publicKeyId\", \"private_key\": \"privateKey\", \"passphrase\": \"passphrase\", \"password\": \"password\", \"gateway_id\": \"gatewayId\", \"source_version\": \"online\", \"web_application_url\": \"webApplicationUrl\", \"domain\": \"domain\", \"endpoint\": \"endpoint\", \"access_key_id\": \"accessKeyId\", \"secret_access_key\": \"secretAccessKey\"}, \"status\": {\"authenticated\": false, \"error_message\": \"errorMessage\"}}";
    String getCredentialsPath = "/v1/environments/testString/credentials/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetCredentialsOptions model
    GetCredentialsOptions getCredentialsOptionsModel =
        new GetCredentialsOptions.Builder()
            .environmentId("testString")
            .credentialId("testString")
            .build();

    // Invoke getCredentials() with a valid options model and verify the result
    Response<Credentials> response =
        discoveryService.getCredentials(getCredentialsOptionsModel).execute();
    assertNotNull(response);
    Credentials responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCredentialsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getCredentials operation with and without retries enabled
  @Test
  public void testGetCredentialsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetCredentialsWOptions();

    discoveryService.disableRetries();
    testGetCredentialsWOptions();
  }

  // Test the getCredentials operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCredentialsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getCredentials(null).execute();
  }

  // Test the updateCredentials operation with a valid options model parameter
  @Test
  public void testUpdateCredentialsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"credential_id\": \"credentialId\", \"source_type\": \"box\", \"credential_details\": {\"credential_type\": \"oauth2\", \"client_id\": \"clientId\", \"enterprise_id\": \"enterpriseId\", \"url\": \"url\", \"username\": \"username\", \"organization_url\": \"organizationUrl\", \"site_collection.path\": \"siteCollectionPath\", \"client_secret\": \"clientSecret\", \"public_key_id\": \"publicKeyId\", \"private_key\": \"privateKey\", \"passphrase\": \"passphrase\", \"password\": \"password\", \"gateway_id\": \"gatewayId\", \"source_version\": \"online\", \"web_application_url\": \"webApplicationUrl\", \"domain\": \"domain\", \"endpoint\": \"endpoint\", \"access_key_id\": \"accessKeyId\", \"secret_access_key\": \"secretAccessKey\"}, \"status\": {\"authenticated\": false, \"error_message\": \"errorMessage\"}}";
    String updateCredentialsPath = "/v1/environments/testString/credentials/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the CredentialDetails model
    CredentialDetails credentialDetailsModel =
        new CredentialDetails.Builder()
            .credentialType("oauth2")
            .clientId("testString")
            .enterpriseId("testString")
            .url("testString")
            .username("testString")
            .organizationUrl("testString")
            .siteCollectionPath("testString")
            .clientSecret("testString")
            .publicKeyId("testString")
            .privateKey("testString")
            .passphrase("testString")
            .password("testString")
            .gatewayId("testString")
            .sourceVersion("online")
            .webApplicationUrl("testString")
            .domain("testString")
            .endpoint("testString")
            .accessKeyId("testString")
            .secretAccessKey("testString")
            .build();

    // Construct an instance of the StatusDetails model
    StatusDetails statusDetailsModel =
        new StatusDetails.Builder().authenticated(true).errorMessage("testString").build();

    // Construct an instance of the UpdateCredentialsOptions model
    UpdateCredentialsOptions updateCredentialsOptionsModel =
        new UpdateCredentialsOptions.Builder()
            .environmentId("testString")
            .credentialId("testString")
            .sourceType("box")
            .credentialDetails(credentialDetailsModel)
            .status(statusDetailsModel)
            .build();

    // Invoke updateCredentials() with a valid options model and verify the result
    Response<Credentials> response =
        discoveryService.updateCredentials(updateCredentialsOptionsModel).execute();
    assertNotNull(response);
    Credentials responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateCredentialsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the updateCredentials operation with and without retries enabled
  @Test
  public void testUpdateCredentialsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testUpdateCredentialsWOptions();

    discoveryService.disableRetries();
    testUpdateCredentialsWOptions();
  }

  // Test the updateCredentials operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCredentialsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.updateCredentials(null).execute();
  }

  // Test the deleteCredentials operation with a valid options model parameter
  @Test
  public void testDeleteCredentialsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"credential_id\": \"credentialId\", \"status\": \"deleted\"}";
    String deleteCredentialsPath = "/v1/environments/testString/credentials/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the DeleteCredentialsOptions model
    DeleteCredentialsOptions deleteCredentialsOptionsModel =
        new DeleteCredentialsOptions.Builder()
            .environmentId("testString")
            .credentialId("testString")
            .build();

    // Invoke deleteCredentials() with a valid options model and verify the result
    Response<DeleteCredentials> response =
        discoveryService.deleteCredentials(deleteCredentialsOptionsModel).execute();
    assertNotNull(response);
    DeleteCredentials responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCredentialsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteCredentials operation with and without retries enabled
  @Test
  public void testDeleteCredentialsWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteCredentialsWOptions();

    discoveryService.disableRetries();
    testDeleteCredentialsWOptions();
  }

  // Test the deleteCredentials operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCredentialsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteCredentials(null).execute();
  }

  // Test the listGateways operation with a valid options model parameter
  @Test
  public void testListGatewaysWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"gateways\": [{\"gateway_id\": \"gatewayId\", \"name\": \"name\", \"status\": \"connected\", \"token\": \"token\", \"token_id\": \"tokenId\"}]}";
    String listGatewaysPath = "/v1/environments/testString/gateways";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the ListGatewaysOptions model
    ListGatewaysOptions listGatewaysOptionsModel =
        new ListGatewaysOptions.Builder().environmentId("testString").build();

    // Invoke listGateways() with a valid options model and verify the result
    Response<GatewayList> response =
        discoveryService.listGateways(listGatewaysOptionsModel).execute();
    assertNotNull(response);
    GatewayList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listGatewaysPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the listGateways operation with and without retries enabled
  @Test
  public void testListGatewaysWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testListGatewaysWOptions();

    discoveryService.disableRetries();
    testListGatewaysWOptions();
  }

  // Test the listGateways operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListGatewaysNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.listGateways(null).execute();
  }

  // Test the createGateway operation with a valid options model parameter
  @Test
  public void testCreateGatewayWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"gateway_id\": \"gatewayId\", \"name\": \"name\", \"status\": \"connected\", \"token\": \"token\", \"token_id\": \"tokenId\"}";
    String createGatewayPath = "/v1/environments/testString/gateways";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the CreateGatewayOptions model
    CreateGatewayOptions createGatewayOptionsModel =
        new CreateGatewayOptions.Builder().environmentId("testString").name("testString").build();

    // Invoke createGateway() with a valid options model and verify the result
    Response<Gateway> response =
        discoveryService.createGateway(createGatewayOptionsModel).execute();
    assertNotNull(response);
    Gateway responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createGatewayPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the createGateway operation with and without retries enabled
  @Test
  public void testCreateGatewayWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testCreateGatewayWOptions();

    discoveryService.disableRetries();
    testCreateGatewayWOptions();
  }

  // Test the createGateway operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateGatewayNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.createGateway(null).execute();
  }

  // Test the getGateway operation with a valid options model parameter
  @Test
  public void testGetGatewayWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody =
        "{\"gateway_id\": \"gatewayId\", \"name\": \"name\", \"status\": \"connected\", \"token\": \"token\", \"token_id\": \"tokenId\"}";
    String getGatewayPath = "/v1/environments/testString/gateways/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the GetGatewayOptions model
    GetGatewayOptions getGatewayOptionsModel =
        new GetGatewayOptions.Builder().environmentId("testString").gatewayId("testString").build();

    // Invoke getGateway() with a valid options model and verify the result
    Response<Gateway> response = discoveryService.getGateway(getGatewayOptionsModel).execute();
    assertNotNull(response);
    Gateway responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getGatewayPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the getGateway operation with and without retries enabled
  @Test
  public void testGetGatewayWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testGetGatewayWOptions();

    discoveryService.disableRetries();
    testGetGatewayWOptions();
  }

  // Test the getGateway operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetGatewayNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.getGateway(null).execute();
  }

  // Test the deleteGateway operation with a valid options model parameter
  @Test
  public void testDeleteGatewayWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"gateway_id\": \"gatewayId\", \"status\": \"status\"}";
    String deleteGatewayPath = "/v1/environments/testString/gateways/testString";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    // Construct an instance of the DeleteGatewayOptions model
    DeleteGatewayOptions deleteGatewayOptionsModel =
        new DeleteGatewayOptions.Builder()
            .environmentId("testString")
            .gatewayId("testString")
            .build();

    // Invoke deleteGateway() with a valid options model and verify the result
    Response<GatewayDelete> response =
        discoveryService.deleteGateway(deleteGatewayOptionsModel).execute();
    assertNotNull(response);
    GatewayDelete responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteGatewayPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("version"), "testString");
  }

  // Test the deleteGateway operation with and without retries enabled
  @Test
  public void testDeleteGatewayWRetries() throws Throwable {
    discoveryService.enableRetries(4, 30);
    testDeleteGatewayWOptions();

    discoveryService.disableRetries();
    testDeleteGatewayWOptions();
  }

  // Test the deleteGateway operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteGatewayNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    discoveryService.deleteGateway(null).execute();
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

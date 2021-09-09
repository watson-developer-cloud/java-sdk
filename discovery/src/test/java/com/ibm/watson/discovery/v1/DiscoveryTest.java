/*
 * (C) Copyright IBM Corp. 2020, 2021.
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
  public void testCreateEnvironmentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"environment_id\": \"environmentId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"active\", \"read_only\": true, \"size\": \"LT\", \"requested_size\": \"requestedSize\", \"index_capacity\": {\"documents\": {\"available\": 9, \"maximum_allowed\": 14}, \"disk_usage\": {\"used_bytes\": 9, \"maximum_allowed_bytes\": 19}, \"collections\": {\"available\": 9, \"maximum_allowed\": 14}}, \"search_status\": {\"scope\": \"scope\", \"status\": \"NO_DATA\", \"status_description\": \"statusDescription\", \"last_trained\": \"2019-01-01\"}}";
    String createEnvironmentPath = "/v1/environments";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateEnvironmentOptions model
    CreateEnvironmentOptions createEnvironmentOptionsModel =
        new CreateEnvironmentOptions.Builder()
            .name("testString")
            .description("testString")
            .size("LT")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Environment> response =
        discoveryService.createEnvironment(createEnvironmentOptionsModel).execute();
    assertNotNull(response);
    Environment responseObj = response.getResult();
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
    assertEquals(parsedPath, createEnvironmentPath);
  }

  // Test the createEnvironment operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateEnvironmentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.createEnvironment(null).execute();
  }

  @Test
  public void testListEnvironmentsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"environments\": [{\"environment_id\": \"environmentId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"active\", \"read_only\": true, \"size\": \"LT\", \"requested_size\": \"requestedSize\", \"index_capacity\": {\"documents\": {\"available\": 9, \"maximum_allowed\": 14}, \"disk_usage\": {\"used_bytes\": 9, \"maximum_allowed_bytes\": 19}, \"collections\": {\"available\": 9, \"maximum_allowed\": 14}}, \"search_status\": {\"scope\": \"scope\", \"status\": \"NO_DATA\", \"status_description\": \"statusDescription\", \"last_trained\": \"2019-01-01\"}}]}";
    String listEnvironmentsPath = "/v1/environments";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListEnvironmentsOptions model
    ListEnvironmentsOptions listEnvironmentsOptionsModel =
        new ListEnvironmentsOptions.Builder().name("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<ListEnvironmentsResponse> response =
        discoveryService.listEnvironments(listEnvironmentsOptionsModel).execute();
    assertNotNull(response);
    ListEnvironmentsResponse responseObj = response.getResult();
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
    assertEquals(query.get("name"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listEnvironmentsPath);
  }

  @Test
  public void testGetEnvironmentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"environment_id\": \"environmentId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"active\", \"read_only\": true, \"size\": \"LT\", \"requested_size\": \"requestedSize\", \"index_capacity\": {\"documents\": {\"available\": 9, \"maximum_allowed\": 14}, \"disk_usage\": {\"used_bytes\": 9, \"maximum_allowed_bytes\": 19}, \"collections\": {\"available\": 9, \"maximum_allowed\": 14}}, \"search_status\": {\"scope\": \"scope\", \"status\": \"NO_DATA\", \"status_description\": \"statusDescription\", \"last_trained\": \"2019-01-01\"}}";
    String getEnvironmentPath = "/v1/environments/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetEnvironmentOptions model
    GetEnvironmentOptions getEnvironmentOptionsModel =
        new GetEnvironmentOptions.Builder().environmentId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Environment> response =
        discoveryService.getEnvironment(getEnvironmentOptionsModel).execute();
    assertNotNull(response);
    Environment responseObj = response.getResult();
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
    assertEquals(parsedPath, getEnvironmentPath);
  }

  // Test the getEnvironment operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetEnvironmentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.getEnvironment(null).execute();
  }

  @Test
  public void testUpdateEnvironmentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"environment_id\": \"environmentId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"active\", \"read_only\": true, \"size\": \"LT\", \"requested_size\": \"requestedSize\", \"index_capacity\": {\"documents\": {\"available\": 9, \"maximum_allowed\": 14}, \"disk_usage\": {\"used_bytes\": 9, \"maximum_allowed_bytes\": 19}, \"collections\": {\"available\": 9, \"maximum_allowed\": 14}}, \"search_status\": {\"scope\": \"scope\", \"status\": \"NO_DATA\", \"status_description\": \"statusDescription\", \"last_trained\": \"2019-01-01\"}}";
    String updateEnvironmentPath = "/v1/environments/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateEnvironmentOptions model
    UpdateEnvironmentOptions updateEnvironmentOptionsModel =
        new UpdateEnvironmentOptions.Builder()
            .environmentId("testString")
            .name("testString")
            .description("testString")
            .size("S")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Environment> response =
        discoveryService.updateEnvironment(updateEnvironmentOptionsModel).execute();
    assertNotNull(response);
    Environment responseObj = response.getResult();
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
    assertEquals(parsedPath, updateEnvironmentPath);
  }

  // Test the updateEnvironment operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateEnvironmentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.updateEnvironment(null).execute();
  }

  @Test
  public void testDeleteEnvironmentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"environment_id\": \"environmentId\", \"status\": \"deleted\"}";
    String deleteEnvironmentPath = "/v1/environments/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteEnvironmentOptions model
    DeleteEnvironmentOptions deleteEnvironmentOptionsModel =
        new DeleteEnvironmentOptions.Builder().environmentId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteEnvironmentResponse> response =
        discoveryService.deleteEnvironment(deleteEnvironmentOptionsModel).execute();
    assertNotNull(response);
    DeleteEnvironmentResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, deleteEnvironmentPath);
  }

  // Test the deleteEnvironment operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteEnvironmentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.deleteEnvironment(null).execute();
  }

  @Test
  public void testListFieldsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"fields\": [{\"field\": \"field\", \"type\": \"nested\"}]}";
    String listFieldsPath = "/v1/environments/testString/fields";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListFieldsOptions model
    ListFieldsOptions listFieldsOptionsModel =
        new ListFieldsOptions.Builder()
            .environmentId("testString")
            .collectionIds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ListCollectionFieldsResponse> response =
        discoveryService.listFields(listFieldsOptionsModel).execute();
    assertNotNull(response);
    ListCollectionFieldsResponse responseObj = response.getResult();
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
  public void testCreateConfigurationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"configuration_id\": \"configurationId\", \"name\": \"name\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"description\": \"description\", \"conversions\": {\"pdf\": {\"heading\": {\"fonts\": [{\"level\": 5, \"min_size\": 7, \"max_size\": 7, \"bold\": true, \"italic\": true, \"name\": \"name\"}]}}, \"word\": {\"heading\": {\"fonts\": [{\"level\": 5, \"min_size\": 7, \"max_size\": 7, \"bold\": true, \"italic\": true, \"name\": \"name\"}], \"styles\": [{\"level\": 5, \"names\": [\"names\"]}]}}, \"html\": {\"exclude_tags_completely\": [\"excludeTagsCompletely\"], \"exclude_tags_keep_content\": [\"excludeTagsKeepContent\"], \"keep_content\": {\"xpaths\": [\"xpaths\"]}, \"exclude_content\": {\"xpaths\": [\"xpaths\"]}, \"keep_tag_attributes\": [\"keepTagAttributes\"], \"exclude_tag_attributes\": [\"excludeTagAttributes\"]}, \"segment\": {\"enabled\": false, \"selector_tags\": [\"selectorTags\"], \"annotated_fields\": [\"annotatedFields\"]}, \"json_normalizations\": [{\"operation\": \"copy\", \"source_field\": \"sourceField\", \"destination_field\": \"destinationField\"}], \"image_text_recognition\": true}, \"enrichments\": [{\"description\": \"description\", \"destination_field\": \"destinationField\", \"source_field\": \"sourceField\", \"overwrite\": false, \"enrichment\": \"enrichment\", \"ignore_downstream_errors\": false, \"options\": {\"features\": {\"keywords\": {\"sentiment\": false, \"emotion\": false, \"limit\": 5}, \"entities\": {\"sentiment\": false, \"emotion\": false, \"limit\": 5, \"mentions\": true, \"mention_types\": true, \"sentence_locations\": false, \"model\": \"model\"}, \"sentiment\": {\"document\": true, \"targets\": [\"target\"]}, \"emotion\": {\"document\": true, \"targets\": [\"target\"]}, \"categories\": {\"mapKey\": \"anyValue\"}, \"semantic_roles\": {\"entities\": true, \"keywords\": true, \"limit\": 5}, \"relations\": {\"model\": \"model\"}, \"concepts\": {\"limit\": 5}}, \"language\": \"ar\", \"model\": \"model\"}}], \"normalizations\": [{\"operation\": \"copy\", \"source_field\": \"sourceField\", \"destination_field\": \"destinationField\"}], \"source\": {\"type\": \"box\", \"credential_id\": \"credentialId\", \"schedule\": {\"enabled\": true, \"time_zone\": \"America/New_York\", \"frequency\": \"daily\"}, \"options\": {\"folders\": [{\"owner_user_id\": \"ownerUserId\", \"folder_id\": \"folderId\", \"limit\": 5}], \"objects\": [{\"name\": \"name\", \"limit\": 5}], \"site_collections\": [{\"site_collection_path\": \"siteCollectionPath\", \"limit\": 5}], \"urls\": [{\"url\": \"url\", \"limit_to_starting_hosts\": true, \"crawl_speed\": \"normal\", \"allow_untrusted_certificate\": false, \"maximum_hops\": 11, \"request_timeout\": 14, \"override_robots_txt\": false, \"blacklist\": [\"blacklist\"]}], \"buckets\": [{\"name\": \"name\", \"limit\": 5}], \"crawl_all_buckets\": false}}}";
    String createConfigurationPath = "/v1/environments/testString/configurations";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

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
        new PdfHeadingDetection.Builder()
            .fonts(new java.util.ArrayList<FontSetting>(java.util.Arrays.asList(fontSettingModel)))
            .build();

    // Construct an instance of the PdfSettings model
    PdfSettings pdfSettingsModel =
        new PdfSettings.Builder().heading(pdfHeadingDetectionModel).build();

    // Construct an instance of the WordStyle model
    WordStyle wordStyleModel =
        new WordStyle.Builder()
            .level(Long.valueOf("26"))
            .names(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the WordHeadingDetection model
    WordHeadingDetection wordHeadingDetectionModel =
        new WordHeadingDetection.Builder()
            .fonts(new java.util.ArrayList<FontSetting>(java.util.Arrays.asList(fontSettingModel)))
            .styles(new java.util.ArrayList<WordStyle>(java.util.Arrays.asList(wordStyleModel)))
            .build();

    // Construct an instance of the WordSettings model
    WordSettings wordSettingsModel =
        new WordSettings.Builder().heading(wordHeadingDetectionModel).build();

    // Construct an instance of the XPathPatterns model
    XPathPatterns xPathPatternsModel =
        new XPathPatterns.Builder()
            .xpaths(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the HtmlSettings model
    HtmlSettings htmlSettingsModel =
        new HtmlSettings.Builder()
            .excludeTagsCompletely(
                new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .excludeTagsKeepContent(
                new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .keepContent(xPathPatternsModel)
            .excludeContent(xPathPatternsModel)
            .keepTagAttributes(
                new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .excludeTagAttributes(
                new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the SegmentSettings model
    SegmentSettings segmentSettingsModel =
        new SegmentSettings.Builder()
            .enabled(false)
            .selectorTags(new java.util.ArrayList<String>(java.util.Arrays.asList("h1", "h2")))
            .annotatedFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
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
            .jsonNormalizations(
                new java.util.ArrayList<NormalizationOperation>(
                    java.util.Arrays.asList(normalizationOperationModel)))
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
            .targets(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the NluEnrichmentEmotion model
    NluEnrichmentEmotion nluEnrichmentEmotionModel =
        new NluEnrichmentEmotion.Builder()
            .document(true)
            .targets(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
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
            .categories(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
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
            .blacklist(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the SourceOptionsBuckets model
    SourceOptionsBuckets sourceOptionsBucketsModel =
        new SourceOptionsBuckets.Builder().name("testString").limit(Long.valueOf("26")).build();

    // Construct an instance of the SourceOptions model
    SourceOptions sourceOptionsModel =
        new SourceOptions.Builder()
            .folders(
                new java.util.ArrayList<SourceOptionsFolder>(
                    java.util.Arrays.asList(sourceOptionsFolderModel)))
            .objects(
                new java.util.ArrayList<SourceOptionsObject>(
                    java.util.Arrays.asList(sourceOptionsObjectModel)))
            .siteCollections(
                new java.util.ArrayList<SourceOptionsSiteColl>(
                    java.util.Arrays.asList(sourceOptionsSiteCollModel)))
            .urls(
                new java.util.ArrayList<SourceOptionsWebCrawl>(
                    java.util.Arrays.asList(sourceOptionsWebCrawlModel)))
            .buckets(
                new java.util.ArrayList<SourceOptionsBuckets>(
                    java.util.Arrays.asList(sourceOptionsBucketsModel)))
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
            .enrichments(
                new java.util.ArrayList<Enrichment>(java.util.Arrays.asList(enrichmentModel)))
            .normalizations(
                new java.util.ArrayList<NormalizationOperation>(
                    java.util.Arrays.asList(normalizationOperationModel)))
            .source(sourceModel)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Configuration> response =
        discoveryService.createConfiguration(createConfigurationOptionsModel).execute();
    assertNotNull(response);
    Configuration responseObj = response.getResult();
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
    assertEquals(parsedPath, createConfigurationPath);
  }

  // Test the createConfiguration operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateConfigurationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.createConfiguration(null).execute();
  }

  @Test
  public void testListConfigurationsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"configurations\": [{\"configuration_id\": \"configurationId\", \"name\": \"name\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"description\": \"description\", \"conversions\": {\"pdf\": {\"heading\": {\"fonts\": [{\"level\": 5, \"min_size\": 7, \"max_size\": 7, \"bold\": true, \"italic\": true, \"name\": \"name\"}]}}, \"word\": {\"heading\": {\"fonts\": [{\"level\": 5, \"min_size\": 7, \"max_size\": 7, \"bold\": true, \"italic\": true, \"name\": \"name\"}], \"styles\": [{\"level\": 5, \"names\": [\"names\"]}]}}, \"html\": {\"exclude_tags_completely\": [\"excludeTagsCompletely\"], \"exclude_tags_keep_content\": [\"excludeTagsKeepContent\"], \"keep_content\": {\"xpaths\": [\"xpaths\"]}, \"exclude_content\": {\"xpaths\": [\"xpaths\"]}, \"keep_tag_attributes\": [\"keepTagAttributes\"], \"exclude_tag_attributes\": [\"excludeTagAttributes\"]}, \"segment\": {\"enabled\": false, \"selector_tags\": [\"selectorTags\"], \"annotated_fields\": [\"annotatedFields\"]}, \"json_normalizations\": [{\"operation\": \"copy\", \"source_field\": \"sourceField\", \"destination_field\": \"destinationField\"}], \"image_text_recognition\": true}, \"enrichments\": [{\"description\": \"description\", \"destination_field\": \"destinationField\", \"source_field\": \"sourceField\", \"overwrite\": false, \"enrichment\": \"enrichment\", \"ignore_downstream_errors\": false, \"options\": {\"features\": {\"keywords\": {\"sentiment\": false, \"emotion\": false, \"limit\": 5}, \"entities\": {\"sentiment\": false, \"emotion\": false, \"limit\": 5, \"mentions\": true, \"mention_types\": true, \"sentence_locations\": false, \"model\": \"model\"}, \"sentiment\": {\"document\": true, \"targets\": [\"target\"]}, \"emotion\": {\"document\": true, \"targets\": [\"target\"]}, \"categories\": {\"mapKey\": \"anyValue\"}, \"semantic_roles\": {\"entities\": true, \"keywords\": true, \"limit\": 5}, \"relations\": {\"model\": \"model\"}, \"concepts\": {\"limit\": 5}}, \"language\": \"ar\", \"model\": \"model\"}}], \"normalizations\": [{\"operation\": \"copy\", \"source_field\": \"sourceField\", \"destination_field\": \"destinationField\"}], \"source\": {\"type\": \"box\", \"credential_id\": \"credentialId\", \"schedule\": {\"enabled\": true, \"time_zone\": \"America/New_York\", \"frequency\": \"daily\"}, \"options\": {\"folders\": [{\"owner_user_id\": \"ownerUserId\", \"folder_id\": \"folderId\", \"limit\": 5}], \"objects\": [{\"name\": \"name\", \"limit\": 5}], \"site_collections\": [{\"site_collection_path\": \"siteCollectionPath\", \"limit\": 5}], \"urls\": [{\"url\": \"url\", \"limit_to_starting_hosts\": true, \"crawl_speed\": \"normal\", \"allow_untrusted_certificate\": false, \"maximum_hops\": 11, \"request_timeout\": 14, \"override_robots_txt\": false, \"blacklist\": [\"blacklist\"]}], \"buckets\": [{\"name\": \"name\", \"limit\": 5}], \"crawl_all_buckets\": false}}}]}";
    String listConfigurationsPath = "/v1/environments/testString/configurations";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListConfigurationsOptions model
    ListConfigurationsOptions listConfigurationsOptionsModel =
        new ListConfigurationsOptions.Builder()
            .environmentId("testString")
            .name("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ListConfigurationsResponse> response =
        discoveryService.listConfigurations(listConfigurationsOptionsModel).execute();
    assertNotNull(response);
    ListConfigurationsResponse responseObj = response.getResult();
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
    assertEquals(query.get("name"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listConfigurationsPath);
  }

  // Test the listConfigurations operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListConfigurationsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.listConfigurations(null).execute();
  }

  @Test
  public void testGetConfigurationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"configuration_id\": \"configurationId\", \"name\": \"name\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"description\": \"description\", \"conversions\": {\"pdf\": {\"heading\": {\"fonts\": [{\"level\": 5, \"min_size\": 7, \"max_size\": 7, \"bold\": true, \"italic\": true, \"name\": \"name\"}]}}, \"word\": {\"heading\": {\"fonts\": [{\"level\": 5, \"min_size\": 7, \"max_size\": 7, \"bold\": true, \"italic\": true, \"name\": \"name\"}], \"styles\": [{\"level\": 5, \"names\": [\"names\"]}]}}, \"html\": {\"exclude_tags_completely\": [\"excludeTagsCompletely\"], \"exclude_tags_keep_content\": [\"excludeTagsKeepContent\"], \"keep_content\": {\"xpaths\": [\"xpaths\"]}, \"exclude_content\": {\"xpaths\": [\"xpaths\"]}, \"keep_tag_attributes\": [\"keepTagAttributes\"], \"exclude_tag_attributes\": [\"excludeTagAttributes\"]}, \"segment\": {\"enabled\": false, \"selector_tags\": [\"selectorTags\"], \"annotated_fields\": [\"annotatedFields\"]}, \"json_normalizations\": [{\"operation\": \"copy\", \"source_field\": \"sourceField\", \"destination_field\": \"destinationField\"}], \"image_text_recognition\": true}, \"enrichments\": [{\"description\": \"description\", \"destination_field\": \"destinationField\", \"source_field\": \"sourceField\", \"overwrite\": false, \"enrichment\": \"enrichment\", \"ignore_downstream_errors\": false, \"options\": {\"features\": {\"keywords\": {\"sentiment\": false, \"emotion\": false, \"limit\": 5}, \"entities\": {\"sentiment\": false, \"emotion\": false, \"limit\": 5, \"mentions\": true, \"mention_types\": true, \"sentence_locations\": false, \"model\": \"model\"}, \"sentiment\": {\"document\": true, \"targets\": [\"target\"]}, \"emotion\": {\"document\": true, \"targets\": [\"target\"]}, \"categories\": {\"mapKey\": \"anyValue\"}, \"semantic_roles\": {\"entities\": true, \"keywords\": true, \"limit\": 5}, \"relations\": {\"model\": \"model\"}, \"concepts\": {\"limit\": 5}}, \"language\": \"ar\", \"model\": \"model\"}}], \"normalizations\": [{\"operation\": \"copy\", \"source_field\": \"sourceField\", \"destination_field\": \"destinationField\"}], \"source\": {\"type\": \"box\", \"credential_id\": \"credentialId\", \"schedule\": {\"enabled\": true, \"time_zone\": \"America/New_York\", \"frequency\": \"daily\"}, \"options\": {\"folders\": [{\"owner_user_id\": \"ownerUserId\", \"folder_id\": \"folderId\", \"limit\": 5}], \"objects\": [{\"name\": \"name\", \"limit\": 5}], \"site_collections\": [{\"site_collection_path\": \"siteCollectionPath\", \"limit\": 5}], \"urls\": [{\"url\": \"url\", \"limit_to_starting_hosts\": true, \"crawl_speed\": \"normal\", \"allow_untrusted_certificate\": false, \"maximum_hops\": 11, \"request_timeout\": 14, \"override_robots_txt\": false, \"blacklist\": [\"blacklist\"]}], \"buckets\": [{\"name\": \"name\", \"limit\": 5}], \"crawl_all_buckets\": false}}}";
    String getConfigurationPath = "/v1/environments/testString/configurations/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetConfigurationOptions model
    GetConfigurationOptions getConfigurationOptionsModel =
        new GetConfigurationOptions.Builder()
            .environmentId("testString")
            .configurationId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Configuration> response =
        discoveryService.getConfiguration(getConfigurationOptionsModel).execute();
    assertNotNull(response);
    Configuration responseObj = response.getResult();
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
    assertEquals(parsedPath, getConfigurationPath);
  }

  // Test the getConfiguration operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetConfigurationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.getConfiguration(null).execute();
  }

  @Test
  public void testUpdateConfigurationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"configuration_id\": \"configurationId\", \"name\": \"name\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"description\": \"description\", \"conversions\": {\"pdf\": {\"heading\": {\"fonts\": [{\"level\": 5, \"min_size\": 7, \"max_size\": 7, \"bold\": true, \"italic\": true, \"name\": \"name\"}]}}, \"word\": {\"heading\": {\"fonts\": [{\"level\": 5, \"min_size\": 7, \"max_size\": 7, \"bold\": true, \"italic\": true, \"name\": \"name\"}], \"styles\": [{\"level\": 5, \"names\": [\"names\"]}]}}, \"html\": {\"exclude_tags_completely\": [\"excludeTagsCompletely\"], \"exclude_tags_keep_content\": [\"excludeTagsKeepContent\"], \"keep_content\": {\"xpaths\": [\"xpaths\"]}, \"exclude_content\": {\"xpaths\": [\"xpaths\"]}, \"keep_tag_attributes\": [\"keepTagAttributes\"], \"exclude_tag_attributes\": [\"excludeTagAttributes\"]}, \"segment\": {\"enabled\": false, \"selector_tags\": [\"selectorTags\"], \"annotated_fields\": [\"annotatedFields\"]}, \"json_normalizations\": [{\"operation\": \"copy\", \"source_field\": \"sourceField\", \"destination_field\": \"destinationField\"}], \"image_text_recognition\": true}, \"enrichments\": [{\"description\": \"description\", \"destination_field\": \"destinationField\", \"source_field\": \"sourceField\", \"overwrite\": false, \"enrichment\": \"enrichment\", \"ignore_downstream_errors\": false, \"options\": {\"features\": {\"keywords\": {\"sentiment\": false, \"emotion\": false, \"limit\": 5}, \"entities\": {\"sentiment\": false, \"emotion\": false, \"limit\": 5, \"mentions\": true, \"mention_types\": true, \"sentence_locations\": false, \"model\": \"model\"}, \"sentiment\": {\"document\": true, \"targets\": [\"target\"]}, \"emotion\": {\"document\": true, \"targets\": [\"target\"]}, \"categories\": {\"mapKey\": \"anyValue\"}, \"semantic_roles\": {\"entities\": true, \"keywords\": true, \"limit\": 5}, \"relations\": {\"model\": \"model\"}, \"concepts\": {\"limit\": 5}}, \"language\": \"ar\", \"model\": \"model\"}}], \"normalizations\": [{\"operation\": \"copy\", \"source_field\": \"sourceField\", \"destination_field\": \"destinationField\"}], \"source\": {\"type\": \"box\", \"credential_id\": \"credentialId\", \"schedule\": {\"enabled\": true, \"time_zone\": \"America/New_York\", \"frequency\": \"daily\"}, \"options\": {\"folders\": [{\"owner_user_id\": \"ownerUserId\", \"folder_id\": \"folderId\", \"limit\": 5}], \"objects\": [{\"name\": \"name\", \"limit\": 5}], \"site_collections\": [{\"site_collection_path\": \"siteCollectionPath\", \"limit\": 5}], \"urls\": [{\"url\": \"url\", \"limit_to_starting_hosts\": true, \"crawl_speed\": \"normal\", \"allow_untrusted_certificate\": false, \"maximum_hops\": 11, \"request_timeout\": 14, \"override_robots_txt\": false, \"blacklist\": [\"blacklist\"]}], \"buckets\": [{\"name\": \"name\", \"limit\": 5}], \"crawl_all_buckets\": false}}}";
    String updateConfigurationPath = "/v1/environments/testString/configurations/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

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
        new PdfHeadingDetection.Builder()
            .fonts(new java.util.ArrayList<FontSetting>(java.util.Arrays.asList(fontSettingModel)))
            .build();

    // Construct an instance of the PdfSettings model
    PdfSettings pdfSettingsModel =
        new PdfSettings.Builder().heading(pdfHeadingDetectionModel).build();

    // Construct an instance of the WordStyle model
    WordStyle wordStyleModel =
        new WordStyle.Builder()
            .level(Long.valueOf("26"))
            .names(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the WordHeadingDetection model
    WordHeadingDetection wordHeadingDetectionModel =
        new WordHeadingDetection.Builder()
            .fonts(new java.util.ArrayList<FontSetting>(java.util.Arrays.asList(fontSettingModel)))
            .styles(new java.util.ArrayList<WordStyle>(java.util.Arrays.asList(wordStyleModel)))
            .build();

    // Construct an instance of the WordSettings model
    WordSettings wordSettingsModel =
        new WordSettings.Builder().heading(wordHeadingDetectionModel).build();

    // Construct an instance of the XPathPatterns model
    XPathPatterns xPathPatternsModel =
        new XPathPatterns.Builder()
            .xpaths(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the HtmlSettings model
    HtmlSettings htmlSettingsModel =
        new HtmlSettings.Builder()
            .excludeTagsCompletely(
                new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .excludeTagsKeepContent(
                new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .keepContent(xPathPatternsModel)
            .excludeContent(xPathPatternsModel)
            .keepTagAttributes(
                new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .excludeTagAttributes(
                new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the SegmentSettings model
    SegmentSettings segmentSettingsModel =
        new SegmentSettings.Builder()
            .enabled(false)
            .selectorTags(new java.util.ArrayList<String>(java.util.Arrays.asList("h1", "h2")))
            .annotatedFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
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
            .jsonNormalizations(
                new java.util.ArrayList<NormalizationOperation>(
                    java.util.Arrays.asList(normalizationOperationModel)))
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
            .targets(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the NluEnrichmentEmotion model
    NluEnrichmentEmotion nluEnrichmentEmotionModel =
        new NluEnrichmentEmotion.Builder()
            .document(true)
            .targets(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
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
            .categories(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
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
            .blacklist(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the SourceOptionsBuckets model
    SourceOptionsBuckets sourceOptionsBucketsModel =
        new SourceOptionsBuckets.Builder().name("testString").limit(Long.valueOf("26")).build();

    // Construct an instance of the SourceOptions model
    SourceOptions sourceOptionsModel =
        new SourceOptions.Builder()
            .folders(
                new java.util.ArrayList<SourceOptionsFolder>(
                    java.util.Arrays.asList(sourceOptionsFolderModel)))
            .objects(
                new java.util.ArrayList<SourceOptionsObject>(
                    java.util.Arrays.asList(sourceOptionsObjectModel)))
            .siteCollections(
                new java.util.ArrayList<SourceOptionsSiteColl>(
                    java.util.Arrays.asList(sourceOptionsSiteCollModel)))
            .urls(
                new java.util.ArrayList<SourceOptionsWebCrawl>(
                    java.util.Arrays.asList(sourceOptionsWebCrawlModel)))
            .buckets(
                new java.util.ArrayList<SourceOptionsBuckets>(
                    java.util.Arrays.asList(sourceOptionsBucketsModel)))
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
            .enrichments(
                new java.util.ArrayList<Enrichment>(java.util.Arrays.asList(enrichmentModel)))
            .normalizations(
                new java.util.ArrayList<NormalizationOperation>(
                    java.util.Arrays.asList(normalizationOperationModel)))
            .source(sourceModel)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Configuration> response =
        discoveryService.updateConfiguration(updateConfigurationOptionsModel).execute();
    assertNotNull(response);
    Configuration responseObj = response.getResult();
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
    assertEquals(parsedPath, updateConfigurationPath);
  }

  // Test the updateConfiguration operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateConfigurationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.updateConfiguration(null).execute();
  }

  @Test
  public void testDeleteConfigurationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"configuration_id\": \"configurationId\", \"status\": \"deleted\", \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}]}";
    String deleteConfigurationPath = "/v1/environments/testString/configurations/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteConfigurationOptions model
    DeleteConfigurationOptions deleteConfigurationOptionsModel =
        new DeleteConfigurationOptions.Builder()
            .environmentId("testString")
            .configurationId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteConfigurationResponse> response =
        discoveryService.deleteConfiguration(deleteConfigurationOptionsModel).execute();
    assertNotNull(response);
    DeleteConfigurationResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, deleteConfigurationPath);
  }

  // Test the deleteConfiguration operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteConfigurationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.deleteConfiguration(null).execute();
  }

  @Test
  public void testCreateCollectionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"active\", \"configuration_id\": \"configurationId\", \"language\": \"language\", \"document_counts\": {\"available\": 9, \"processing\": 10, \"failed\": 6, \"pending\": 7}, \"disk_usage\": {\"used_bytes\": 9}, \"training_status\": {\"total_examples\": 13, \"available\": false, \"processing\": true, \"minimum_queries_added\": false, \"minimum_examples_added\": true, \"sufficient_label_diversity\": true, \"notices\": 7, \"successfully_trained\": \"2019-01-01T12:00:00.000Z\", \"data_updated\": \"2019-01-01T12:00:00.000Z\"}, \"crawl_status\": {\"source_crawl\": {\"status\": \"running\", \"next_crawl\": \"2019-01-01T12:00:00.000Z\"}}, \"smart_document_understanding\": {\"enabled\": true, \"total_annotated_pages\": 19, \"total_pages\": 10, \"total_documents\": 14, \"custom_fields\": {\"defined\": 7, \"maximum_allowed\": 14}}}";
    String createCollectionPath = "/v1/environments/testString/collections";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateCollectionOptions model
    CreateCollectionOptions createCollectionOptionsModel =
        new CreateCollectionOptions.Builder()
            .environmentId("testString")
            .name("testString")
            .description("testString")
            .configurationId("testString")
            .language("en")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Collection> response =
        discoveryService.createCollection(createCollectionOptionsModel).execute();
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
  public void testListCollectionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"collections\": [{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"active\", \"configuration_id\": \"configurationId\", \"language\": \"language\", \"document_counts\": {\"available\": 9, \"processing\": 10, \"failed\": 6, \"pending\": 7}, \"disk_usage\": {\"used_bytes\": 9}, \"training_status\": {\"total_examples\": 13, \"available\": false, \"processing\": true, \"minimum_queries_added\": false, \"minimum_examples_added\": true, \"sufficient_label_diversity\": true, \"notices\": 7, \"successfully_trained\": \"2019-01-01T12:00:00.000Z\", \"data_updated\": \"2019-01-01T12:00:00.000Z\"}, \"crawl_status\": {\"source_crawl\": {\"status\": \"running\", \"next_crawl\": \"2019-01-01T12:00:00.000Z\"}}, \"smart_document_understanding\": {\"enabled\": true, \"total_annotated_pages\": 19, \"total_pages\": 10, \"total_documents\": 14, \"custom_fields\": {\"defined\": 7, \"maximum_allowed\": 14}}}]}";
    String listCollectionsPath = "/v1/environments/testString/collections";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListCollectionsOptions model
    ListCollectionsOptions listCollectionsOptionsModel =
        new ListCollectionsOptions.Builder().environmentId("testString").name("testString").build();

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
    assertEquals(query.get("name"), "testString");
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
  public void testGetCollectionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"active\", \"configuration_id\": \"configurationId\", \"language\": \"language\", \"document_counts\": {\"available\": 9, \"processing\": 10, \"failed\": 6, \"pending\": 7}, \"disk_usage\": {\"used_bytes\": 9}, \"training_status\": {\"total_examples\": 13, \"available\": false, \"processing\": true, \"minimum_queries_added\": false, \"minimum_examples_added\": true, \"sufficient_label_diversity\": true, \"notices\": 7, \"successfully_trained\": \"2019-01-01T12:00:00.000Z\", \"data_updated\": \"2019-01-01T12:00:00.000Z\"}, \"crawl_status\": {\"source_crawl\": {\"status\": \"running\", \"next_crawl\": \"2019-01-01T12:00:00.000Z\"}}, \"smart_document_understanding\": {\"enabled\": true, \"total_annotated_pages\": 19, \"total_pages\": 10, \"total_documents\": 14, \"custom_fields\": {\"defined\": 7, \"maximum_allowed\": 14}}}";
    String getCollectionPath = "/v1/environments/testString/collections/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCollectionOptions model
    GetCollectionOptions getCollectionOptionsModel =
        new GetCollectionOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Collection> response =
        discoveryService.getCollection(getCollectionOptionsModel).execute();
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
    discoveryService.getCollection(null).execute();
  }

  @Test
  public void testUpdateCollectionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"collection_id\": \"collectionId\", \"name\": \"name\", \"description\": \"description\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"status\": \"active\", \"configuration_id\": \"configurationId\", \"language\": \"language\", \"document_counts\": {\"available\": 9, \"processing\": 10, \"failed\": 6, \"pending\": 7}, \"disk_usage\": {\"used_bytes\": 9}, \"training_status\": {\"total_examples\": 13, \"available\": false, \"processing\": true, \"minimum_queries_added\": false, \"minimum_examples_added\": true, \"sufficient_label_diversity\": true, \"notices\": 7, \"successfully_trained\": \"2019-01-01T12:00:00.000Z\", \"data_updated\": \"2019-01-01T12:00:00.000Z\"}, \"crawl_status\": {\"source_crawl\": {\"status\": \"running\", \"next_crawl\": \"2019-01-01T12:00:00.000Z\"}}, \"smart_document_understanding\": {\"enabled\": true, \"total_annotated_pages\": 19, \"total_pages\": 10, \"total_documents\": 14, \"custom_fields\": {\"defined\": 7, \"maximum_allowed\": 14}}}";
    String updateCollectionPath = "/v1/environments/testString/collections/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateCollectionOptions model
    UpdateCollectionOptions updateCollectionOptionsModel =
        new UpdateCollectionOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .name("testString")
            .description("testString")
            .configurationId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Collection> response =
        discoveryService.updateCollection(updateCollectionOptionsModel).execute();
    assertNotNull(response);
    Collection responseObj = response.getResult();
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
    String mockResponseBody = "{\"collection_id\": \"collectionId\", \"status\": \"deleted\"}";
    String deleteCollectionPath = "/v1/environments/testString/collections/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteCollectionOptions model
    DeleteCollectionOptions deleteCollectionOptionsModel =
        new DeleteCollectionOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteCollectionResponse> response =
        discoveryService.deleteCollection(deleteCollectionOptionsModel).execute();
    assertNotNull(response);
    DeleteCollectionResponse responseObj = response.getResult();
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
  public void testListCollectionFieldsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"fields\": [{\"field\": \"field\", \"type\": \"nested\"}]}";
    String listCollectionFieldsPath = "/v1/environments/testString/collections/testString/fields";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListCollectionFieldsOptions model
    ListCollectionFieldsOptions listCollectionFieldsOptionsModel =
        new ListCollectionFieldsOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ListCollectionFieldsResponse> response =
        discoveryService.listCollectionFields(listCollectionFieldsOptionsModel).execute();
    assertNotNull(response);
    ListCollectionFieldsResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, listCollectionFieldsPath);
  }

  // Test the listCollectionFields operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListCollectionFieldsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.listCollectionFields(null).execute();
  }

  @Test
  public void testListExpansionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"expansions\": [{\"input_terms\": [\"inputTerms\"], \"expanded_terms\": [\"expandedTerms\"]}]}";
    String listExpansionsPath = "/v1/environments/testString/collections/testString/expansions";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListExpansionsOptions model
    ListExpansionsOptions listExpansionsOptionsModel =
        new ListExpansionsOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Expansions> response =
        discoveryService.listExpansions(listExpansionsOptionsModel).execute();
    assertNotNull(response);
    Expansions responseObj = response.getResult();
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
    assertEquals(parsedPath, listExpansionsPath);
  }

  // Test the listExpansions operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListExpansionsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.listExpansions(null).execute();
  }

  @Test
  public void testCreateExpansionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"expansions\": [{\"input_terms\": [\"inputTerms\"], \"expanded_terms\": [\"expandedTerms\"]}]}";
    String createExpansionsPath = "/v1/environments/testString/collections/testString/expansions";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Expansion model
    Expansion expansionModel =
        new Expansion.Builder()
            .inputTerms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .expandedTerms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Construct an instance of the CreateExpansionsOptions model
    CreateExpansionsOptions createExpansionsOptionsModel =
        new CreateExpansionsOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .expansions(new java.util.ArrayList<Expansion>(java.util.Arrays.asList(expansionModel)))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Expansions> response =
        discoveryService.createExpansions(createExpansionsOptionsModel).execute();
    assertNotNull(response);
    Expansions responseObj = response.getResult();
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
    assertEquals(parsedPath, createExpansionsPath);
  }

  // Test the createExpansions operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateExpansionsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.createExpansions(null).execute();
  }

  @Test
  public void testDeleteExpansionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteExpansionsPath = "/v1/environments/testString/collections/testString/expansions";

    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteExpansionsOptions model
    DeleteExpansionsOptions deleteExpansionsOptionsModel =
        new DeleteExpansionsOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        discoveryService.deleteExpansions(deleteExpansionsOptionsModel).execute();
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
    assertEquals(parsedPath, deleteExpansionsPath);
  }

  // Test the deleteExpansions operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteExpansionsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.deleteExpansions(null).execute();
  }

  @Test
  public void testGetTokenizationDictionaryStatusWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"status\": \"active\", \"type\": \"type\"}";
    String getTokenizationDictionaryStatusPath =
        "/v1/environments/testString/collections/testString/word_lists/tokenization_dictionary";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetTokenizationDictionaryStatusOptions model
    GetTokenizationDictionaryStatusOptions getTokenizationDictionaryStatusOptionsModel =
        new GetTokenizationDictionaryStatusOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TokenDictStatusResponse> response =
        discoveryService
            .getTokenizationDictionaryStatus(getTokenizationDictionaryStatusOptionsModel)
            .execute();
    assertNotNull(response);
    TokenDictStatusResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, getTokenizationDictionaryStatusPath);
  }

  // Test the getTokenizationDictionaryStatus operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTokenizationDictionaryStatusNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.getTokenizationDictionaryStatus(null).execute();
  }

  @Test
  public void testCreateTokenizationDictionaryWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"status\": \"active\", \"type\": \"type\"}";
    String createTokenizationDictionaryPath =
        "/v1/environments/testString/collections/testString/word_lists/tokenization_dictionary";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the TokenDictRule model
    TokenDictRule tokenDictRuleModel =
        new TokenDictRule.Builder()
            .text("testString")
            .tokens(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .readings(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .partOfSpeech("testString")
            .build();

    // Construct an instance of the CreateTokenizationDictionaryOptions model
    CreateTokenizationDictionaryOptions createTokenizationDictionaryOptionsModel =
        new CreateTokenizationDictionaryOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .tokenizationRules(
                new java.util.ArrayList<TokenDictRule>(java.util.Arrays.asList(tokenDictRuleModel)))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TokenDictStatusResponse> response =
        discoveryService
            .createTokenizationDictionary(createTokenizationDictionaryOptionsModel)
            .execute();
    assertNotNull(response);
    TokenDictStatusResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, createTokenizationDictionaryPath);
  }

  // Test the createTokenizationDictionary operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTokenizationDictionaryNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.createTokenizationDictionary(null).execute();
  }

  @Test
  public void testDeleteTokenizationDictionaryWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteTokenizationDictionaryPath =
        "/v1/environments/testString/collections/testString/word_lists/tokenization_dictionary";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteTokenizationDictionaryOptions model
    DeleteTokenizationDictionaryOptions deleteTokenizationDictionaryOptionsModel =
        new DeleteTokenizationDictionaryOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        discoveryService
            .deleteTokenizationDictionary(deleteTokenizationDictionaryOptionsModel)
            .execute();
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
    assertEquals(parsedPath, deleteTokenizationDictionaryPath);
  }

  // Test the deleteTokenizationDictionary operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTokenizationDictionaryNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.deleteTokenizationDictionary(null).execute();
  }

  @Test
  public void testGetStopwordListStatusWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"status\": \"active\", \"type\": \"type\"}";
    String getStopwordListStatusPath =
        "/v1/environments/testString/collections/testString/word_lists/stopwords";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetStopwordListStatusOptions model
    GetStopwordListStatusOptions getStopwordListStatusOptionsModel =
        new GetStopwordListStatusOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TokenDictStatusResponse> response =
        discoveryService.getStopwordListStatus(getStopwordListStatusOptionsModel).execute();
    assertNotNull(response);
    TokenDictStatusResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, getStopwordListStatusPath);
  }

  // Test the getStopwordListStatus operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetStopwordListStatusNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.getStopwordListStatus(null).execute();
  }

  @Test
  public void testCreateStopwordListWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"status\": \"active\", \"type\": \"type\"}";
    String createStopwordListPath =
        "/v1/environments/testString/collections/testString/word_lists/stopwords";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateStopwordListOptions model
    CreateStopwordListOptions createStopwordListOptionsModel =
        new CreateStopwordListOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .stopwordFile(TestUtilities.createMockStream("This is a mock file."))
            .stopwordFilename("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TokenDictStatusResponse> response =
        discoveryService.createStopwordList(createStopwordListOptionsModel).execute();
    assertNotNull(response);
    TokenDictStatusResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, createStopwordListPath);
  }

  // Test the createStopwordList operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateStopwordListNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.createStopwordList(null).execute();
  }

  @Test
  public void testDeleteStopwordListWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteStopwordListPath =
        "/v1/environments/testString/collections/testString/word_lists/stopwords";

    server.enqueue(new MockResponse().setResponseCode(200).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteStopwordListOptions model
    DeleteStopwordListOptions deleteStopwordListOptionsModel =
        new DeleteStopwordListOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        discoveryService.deleteStopwordList(deleteStopwordListOptionsModel).execute();
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
    assertEquals(parsedPath, deleteStopwordListPath);
  }

  // Test the deleteStopwordList operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteStopwordListNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.deleteStopwordList(null).execute();
  }

  @Test
  public void testAddDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"status\": \"processing\", \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}]}";
    String addDocumentPath = "/v1/environments/testString/collections/testString/documents";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    constructClientService();

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
  public void testGetDocumentStatusWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"configuration_id\": \"configurationId\", \"status\": \"available\", \"status_description\": \"statusDescription\", \"filename\": \"filename\", \"file_type\": \"pdf\", \"sha1\": \"sha1\", \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}]}";
    String getDocumentStatusPath =
        "/v1/environments/testString/collections/testString/documents/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetDocumentStatusOptions model
    GetDocumentStatusOptions getDocumentStatusOptionsModel =
        new GetDocumentStatusOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .documentId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<DocumentStatus> response =
        discoveryService.getDocumentStatus(getDocumentStatusOptionsModel).execute();
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
    discoveryService.getDocumentStatus(null).execute();
  }

  @Test
  public void testUpdateDocumentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"status\": \"processing\", \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}]}";
    String updateDocumentPath =
        "/v1/environments/testString/collections/testString/documents/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(202)
            .setBody(mockResponseBody));

    constructClientService();

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
        "/v1/environments/testString/collections/testString/documents/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteDocumentOptions model
    DeleteDocumentOptions deleteDocumentOptionsModel =
        new DeleteDocumentOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .documentId("testString")
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
  public void testQueryWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"matching_results\": 15, \"results\": [{\"id\": \"id\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"collection_id\": \"collectionId\", \"result_metadata\": {\"score\": 5, \"confidence\": 10}}], \"aggregations\": [{\"type\": \"histogram\", \"matching_results\": 15, \"field\": \"field\", \"interval\": 8}], \"passages\": [{\"document_id\": \"documentId\", \"passage_score\": 12, \"passage_text\": \"passageText\", \"start_offset\": 11, \"end_offset\": 9, \"field\": \"field\"}], \"duplicates_removed\": 17, \"session_token\": \"sessionToken\", \"retrieval_details\": {\"document_retrieval_strategy\": \"untrained\"}, \"suggested_query\": \"suggestedQuery\"}";
    String queryPath = "/v1/environments/testString/collections/testString/query";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

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
  public void testQueryNoticesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"matching_results\": 15, \"results\": [{\"id\": \"id\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"collection_id\": \"collectionId\", \"result_metadata\": {\"score\": 5, \"confidence\": 10}, \"code\": 4, \"filename\": \"filename\", \"file_type\": \"pdf\", \"sha1\": \"sha1\", \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}]}], \"aggregations\": [{\"type\": \"histogram\", \"matching_results\": 15, \"field\": \"field\", \"interval\": 8}], \"passages\": [{\"document_id\": \"documentId\", \"passage_score\": 12, \"passage_text\": \"passageText\", \"start_offset\": 11, \"end_offset\": 9, \"field\": \"field\"}], \"duplicates_removed\": 17}";
    String queryNoticesPath = "/v1/environments/testString/collections/testString/notices";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

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
            .xReturn(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .offset(Long.valueOf("26"))
            .sort(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .highlight(false)
            .passagesFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .passagesCount(Long.valueOf("100"))
            .passagesCharacters(Long.valueOf("50"))
            .deduplicateField("testString")
            .similar(false)
            .similarDocumentIds(
                new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .similarFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
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
    assertEquals(Boolean.valueOf(query.get("passages")), Boolean.valueOf(true));
    assertEquals(query.get("aggregation"), "testString");
    assertEquals(Long.valueOf(query.get("count")), Long.valueOf("26"));
    assertEquals(
        query.get("return"),
        RequestUtils.join(
            new java.util.ArrayList<String>(java.util.Arrays.asList("testString")), ","));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(
        query.get("sort"),
        RequestUtils.join(
            new java.util.ArrayList<String>(java.util.Arrays.asList("testString")), ","));
    assertEquals(Boolean.valueOf(query.get("highlight")), Boolean.valueOf(false));
    assertEquals(
        query.get("passages.fields"),
        RequestUtils.join(
            new java.util.ArrayList<String>(java.util.Arrays.asList("testString")), ","));
    assertEquals(Long.valueOf(query.get("passages.count")), Long.valueOf("100"));
    assertEquals(Long.valueOf(query.get("passages.characters")), Long.valueOf("50"));
    assertEquals(query.get("deduplicate.field"), "testString");
    assertEquals(Boolean.valueOf(query.get("similar")), Boolean.valueOf(false));
    assertEquals(
        query.get("similar.document_ids"),
        RequestUtils.join(
            new java.util.ArrayList<String>(java.util.Arrays.asList("testString")), ","));
    assertEquals(
        query.get("similar.fields"),
        RequestUtils.join(
            new java.util.ArrayList<String>(java.util.Arrays.asList("testString")), ","));
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
  public void testFederatedQueryWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"matching_results\": 15, \"results\": [{\"id\": \"id\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"collection_id\": \"collectionId\", \"result_metadata\": {\"score\": 5, \"confidence\": 10}}], \"aggregations\": [{\"type\": \"histogram\", \"matching_results\": 15, \"field\": \"field\", \"interval\": 8}], \"passages\": [{\"document_id\": \"documentId\", \"passage_score\": 12, \"passage_text\": \"passageText\", \"start_offset\": 11, \"end_offset\": 9, \"field\": \"field\"}], \"duplicates_removed\": 17, \"session_token\": \"sessionToken\", \"retrieval_details\": {\"document_retrieval_strategy\": \"untrained\"}, \"suggested_query\": \"suggestedQuery\"}";
    String federatedQueryPath = "/v1/environments/testString/query";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

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

    // Invoke operation with valid options model (positive test)
    Response<QueryResponse> response =
        discoveryService.federatedQuery(federatedQueryOptionsModel).execute();
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
    assertEquals(parsedPath, federatedQueryPath);
  }

  // Test the federatedQuery operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testFederatedQueryNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.federatedQuery(null).execute();
  }

  @Test
  public void testFederatedQueryNoticesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"matching_results\": 15, \"results\": [{\"id\": \"id\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"collection_id\": \"collectionId\", \"result_metadata\": {\"score\": 5, \"confidence\": 10}, \"code\": 4, \"filename\": \"filename\", \"file_type\": \"pdf\", \"sha1\": \"sha1\", \"notices\": [{\"notice_id\": \"noticeId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"document_id\": \"documentId\", \"query_id\": \"queryId\", \"severity\": \"warning\", \"step\": \"step\", \"description\": \"description\"}]}], \"aggregations\": [{\"type\": \"histogram\", \"matching_results\": 15, \"field\": \"field\", \"interval\": 8}], \"passages\": [{\"document_id\": \"documentId\", \"passage_score\": 12, \"passage_text\": \"passageText\", \"start_offset\": 11, \"end_offset\": 9, \"field\": \"field\"}], \"duplicates_removed\": 17}";
    String federatedQueryNoticesPath = "/v1/environments/testString/notices";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the FederatedQueryNoticesOptions model
    FederatedQueryNoticesOptions federatedQueryNoticesOptionsModel =
        new FederatedQueryNoticesOptions.Builder()
            .environmentId("testString")
            .collectionIds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .filter("testString")
            .query("testString")
            .naturalLanguageQuery("testString")
            .aggregation("testString")
            .count(Long.valueOf("26"))
            .xReturn(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .offset(Long.valueOf("26"))
            .sort(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .highlight(false)
            .deduplicateField("testString")
            .similar(false)
            .similarDocumentIds(
                new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .similarFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<QueryNoticesResponse> response =
        discoveryService.federatedQueryNotices(federatedQueryNoticesOptionsModel).execute();
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
    assertEquals(
        query.get("collection_ids"),
        RequestUtils.join(
            new java.util.ArrayList<String>(java.util.Arrays.asList("testString")), ","));
    assertEquals(query.get("filter"), "testString");
    assertEquals(query.get("query"), "testString");
    assertEquals(query.get("natural_language_query"), "testString");
    assertEquals(query.get("aggregation"), "testString");
    assertEquals(Long.valueOf(query.get("count")), Long.valueOf("26"));
    assertEquals(
        query.get("return"),
        RequestUtils.join(
            new java.util.ArrayList<String>(java.util.Arrays.asList("testString")), ","));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(
        query.get("sort"),
        RequestUtils.join(
            new java.util.ArrayList<String>(java.util.Arrays.asList("testString")), ","));
    assertEquals(Boolean.valueOf(query.get("highlight")), Boolean.valueOf(false));
    assertEquals(query.get("deduplicate.field"), "testString");
    assertEquals(Boolean.valueOf(query.get("similar")), Boolean.valueOf(false));
    assertEquals(
        query.get("similar.document_ids"),
        RequestUtils.join(
            new java.util.ArrayList<String>(java.util.Arrays.asList("testString")), ","));
    assertEquals(
        query.get("similar.fields"),
        RequestUtils.join(
            new java.util.ArrayList<String>(java.util.Arrays.asList("testString")), ","));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, federatedQueryNoticesPath);
  }

  // Test the federatedQueryNotices operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testFederatedQueryNoticesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.federatedQueryNotices(null).execute();
  }

  @Test
  public void testGetAutocompletionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"completions\": [\"completions\"]}";
    String getAutocompletionPath =
        "/v1/environments/testString/collections/testString/autocompletion";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAutocompletionOptions model
    GetAutocompletionOptions getAutocompletionOptionsModel =
        new GetAutocompletionOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .prefix("testString")
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
  public void testListTrainingDataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"environment_id\": \"environmentId\", \"collection_id\": \"collectionId\", \"queries\": [{\"query_id\": \"queryId\", \"natural_language_query\": \"naturalLanguageQuery\", \"filter\": \"filter\", \"examples\": [{\"document_id\": \"documentId\", \"cross_reference\": \"crossReference\", \"relevance\": 9}]}]}";
    String listTrainingDataPath =
        "/v1/environments/testString/collections/testString/training_data";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListTrainingDataOptions model
    ListTrainingDataOptions listTrainingDataOptionsModel =
        new ListTrainingDataOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TrainingDataSet> response =
        discoveryService.listTrainingData(listTrainingDataOptionsModel).execute();
    assertNotNull(response);
    TrainingDataSet responseObj = response.getResult();
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
    assertEquals(parsedPath, listTrainingDataPath);
  }

  // Test the listTrainingData operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTrainingDataNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.listTrainingData(null).execute();
  }

  @Test
  public void testAddTrainingDataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"query_id\": \"queryId\", \"natural_language_query\": \"naturalLanguageQuery\", \"filter\": \"filter\", \"examples\": [{\"document_id\": \"documentId\", \"cross_reference\": \"crossReference\", \"relevance\": 9}]}";
    String addTrainingDataPath = "/v1/environments/testString/collections/testString/training_data";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

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
            .examples(
                new java.util.ArrayList<TrainingExample>(
                    java.util.Arrays.asList(trainingExampleModel)))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TrainingQuery> response =
        discoveryService.addTrainingData(addTrainingDataOptionsModel).execute();
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
    assertEquals(parsedPath, addTrainingDataPath);
  }

  // Test the addTrainingData operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddTrainingDataNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.addTrainingData(null).execute();
  }

  @Test
  public void testDeleteAllTrainingDataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteAllTrainingDataPath =
        "/v1/environments/testString/collections/testString/training_data";

    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteAllTrainingDataOptions model
    DeleteAllTrainingDataOptions deleteAllTrainingDataOptionsModel =
        new DeleteAllTrainingDataOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        discoveryService.deleteAllTrainingData(deleteAllTrainingDataOptionsModel).execute();
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
    assertEquals(parsedPath, deleteAllTrainingDataPath);
  }

  // Test the deleteAllTrainingData operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAllTrainingDataNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.deleteAllTrainingData(null).execute();
  }

  @Test
  public void testGetTrainingDataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"query_id\": \"queryId\", \"natural_language_query\": \"naturalLanguageQuery\", \"filter\": \"filter\", \"examples\": [{\"document_id\": \"documentId\", \"cross_reference\": \"crossReference\", \"relevance\": 9}]}";
    String getTrainingDataPath =
        "/v1/environments/testString/collections/testString/training_data/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetTrainingDataOptions model
    GetTrainingDataOptions getTrainingDataOptionsModel =
        new GetTrainingDataOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .queryId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TrainingQuery> response =
        discoveryService.getTrainingData(getTrainingDataOptionsModel).execute();
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
    assertEquals(parsedPath, getTrainingDataPath);
  }

  // Test the getTrainingData operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTrainingDataNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.getTrainingData(null).execute();
  }

  @Test
  public void testDeleteTrainingDataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteTrainingDataPath =
        "/v1/environments/testString/collections/testString/training_data/testString";

    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteTrainingDataOptions model
    DeleteTrainingDataOptions deleteTrainingDataOptionsModel =
        new DeleteTrainingDataOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .queryId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        discoveryService.deleteTrainingData(deleteTrainingDataOptionsModel).execute();
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
    assertEquals(parsedPath, deleteTrainingDataPath);
  }

  // Test the deleteTrainingData operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTrainingDataNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.deleteTrainingData(null).execute();
  }

  @Test
  public void testListTrainingExamplesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"examples\": [{\"document_id\": \"documentId\", \"cross_reference\": \"crossReference\", \"relevance\": 9}]}";
    String listTrainingExamplesPath =
        "/v1/environments/testString/collections/testString/training_data/testString/examples";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListTrainingExamplesOptions model
    ListTrainingExamplesOptions listTrainingExamplesOptionsModel =
        new ListTrainingExamplesOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .queryId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TrainingExampleList> response =
        discoveryService.listTrainingExamples(listTrainingExamplesOptionsModel).execute();
    assertNotNull(response);
    TrainingExampleList responseObj = response.getResult();
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
    assertEquals(parsedPath, listTrainingExamplesPath);
  }

  // Test the listTrainingExamples operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTrainingExamplesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.listTrainingExamples(null).execute();
  }

  @Test
  public void testCreateTrainingExampleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"cross_reference\": \"crossReference\", \"relevance\": 9}";
    String createTrainingExamplePath =
        "/v1/environments/testString/collections/testString/training_data/testString/examples";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

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

    // Invoke operation with valid options model (positive test)
    Response<TrainingExample> response =
        discoveryService.createTrainingExample(createTrainingExampleOptionsModel).execute();
    assertNotNull(response);
    TrainingExample responseObj = response.getResult();
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
    assertEquals(parsedPath, createTrainingExamplePath);
  }

  // Test the createTrainingExample operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTrainingExampleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.createTrainingExample(null).execute();
  }

  @Test
  public void testDeleteTrainingExampleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteTrainingExamplePath =
        "/v1/environments/testString/collections/testString/training_data/testString/examples/testString";

    server.enqueue(new MockResponse().setResponseCode(204).setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteTrainingExampleOptions model
    DeleteTrainingExampleOptions deleteTrainingExampleOptionsModel =
        new DeleteTrainingExampleOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .queryId("testString")
            .exampleId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response =
        discoveryService.deleteTrainingExample(deleteTrainingExampleOptionsModel).execute();
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
    assertEquals(parsedPath, deleteTrainingExamplePath);
  }

  // Test the deleteTrainingExample operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTrainingExampleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.deleteTrainingExample(null).execute();
  }

  @Test
  public void testUpdateTrainingExampleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"cross_reference\": \"crossReference\", \"relevance\": 9}";
    String updateTrainingExamplePath =
        "/v1/environments/testString/collections/testString/training_data/testString/examples/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

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

    // Invoke operation with valid options model (positive test)
    Response<TrainingExample> response =
        discoveryService.updateTrainingExample(updateTrainingExampleOptionsModel).execute();
    assertNotNull(response);
    TrainingExample responseObj = response.getResult();
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
    assertEquals(parsedPath, updateTrainingExamplePath);
  }

  // Test the updateTrainingExample operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateTrainingExampleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.updateTrainingExample(null).execute();
  }

  @Test
  public void testGetTrainingExampleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"document_id\": \"documentId\", \"cross_reference\": \"crossReference\", \"relevance\": 9}";
    String getTrainingExamplePath =
        "/v1/environments/testString/collections/testString/training_data/testString/examples/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetTrainingExampleOptions model
    GetTrainingExampleOptions getTrainingExampleOptionsModel =
        new GetTrainingExampleOptions.Builder()
            .environmentId("testString")
            .collectionId("testString")
            .queryId("testString")
            .exampleId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TrainingExample> response =
        discoveryService.getTrainingExample(getTrainingExampleOptionsModel).execute();
    assertNotNull(response);
    TrainingExample responseObj = response.getResult();
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
    assertEquals(parsedPath, getTrainingExamplePath);
  }

  // Test the getTrainingExample operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTrainingExampleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.getTrainingExample(null).execute();
  }

  @Test
  public void testDeleteUserDataWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteUserDataPath = "/v1/user_data";

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

  @Test
  public void testCreateEventWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"type\": \"click\", \"data\": {\"environment_id\": \"environmentId\", \"session_token\": \"sessionToken\", \"client_timestamp\": \"2019-01-01T12:00:00.000Z\", \"display_rank\": 11, \"collection_id\": \"collectionId\", \"document_id\": \"documentId\", \"query_id\": \"queryId\"}}";
    String createEventPath = "/v1/events";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(201)
            .setBody(mockResponseBody));

    constructClientService();

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

    // Invoke operation with valid options model (positive test)
    Response<CreateEventResponse> response =
        discoveryService.createEvent(createEventOptionsModel).execute();
    assertNotNull(response);
    CreateEventResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, createEventPath);
  }

  // Test the createEvent operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateEventNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.createEvent(null).execute();
  }

  @Test
  public void testQueryLogWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"matching_results\": 15, \"results\": [{\"environment_id\": \"environmentId\", \"customer_id\": \"customerId\", \"document_type\": \"query\", \"natural_language_query\": \"naturalLanguageQuery\", \"document_results\": {\"results\": [{\"position\": 8, \"document_id\": \"documentId\", \"score\": 5, \"confidence\": 10, \"collection_id\": \"collectionId\"}], \"count\": 5}, \"created_timestamp\": \"2019-01-01T12:00:00.000Z\", \"client_timestamp\": \"2019-01-01T12:00:00.000Z\", \"query_id\": \"queryId\", \"session_token\": \"sessionToken\", \"collection_id\": \"collectionId\", \"display_rank\": 11, \"document_id\": \"documentId\", \"event_type\": \"click\", \"result_type\": \"document\"}]}";
    String queryLogPath = "/v1/logs";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the QueryLogOptions model
    QueryLogOptions queryLogOptionsModel =
        new QueryLogOptions.Builder()
            .filter("testString")
            .query("testString")
            .count(Long.valueOf("26"))
            .offset(Long.valueOf("26"))
            .sort(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();

    // Invoke operation with valid options model (positive test)
    Response<LogQueryResponse> response = discoveryService.queryLog(queryLogOptionsModel).execute();
    assertNotNull(response);
    LogQueryResponse responseObj = response.getResult();
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
    assertEquals(Long.valueOf(query.get("count")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(
        query.get("sort"),
        RequestUtils.join(
            new java.util.ArrayList<String>(java.util.Arrays.asList("testString")), ","));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, queryLogPath);
  }

  @Test
  public void testGetMetricsQueryWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"aggregations\": [{\"interval\": \"interval\", \"event_type\": \"eventType\", \"results\": [{\"key_as_string\": \"2019-01-01T12:00:00.000Z\", \"key\": 3, \"matching_results\": 15, \"event_rate\": 9}]}]}";
    String getMetricsQueryPath = "/v1/metrics/number_of_queries";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetMetricsQueryOptions model
    GetMetricsQueryOptions getMetricsQueryOptionsModel =
        new GetMetricsQueryOptions.Builder()
            .startTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .endTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .resultType("document")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<MetricResponse> response =
        discoveryService.getMetricsQuery(getMetricsQueryOptionsModel).execute();
    assertNotNull(response);
    MetricResponse responseObj = response.getResult();
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
    assertEquals(query.get("result_type"), "document");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getMetricsQueryPath);
  }

  @Test
  public void testGetMetricsQueryEventWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"aggregations\": [{\"interval\": \"interval\", \"event_type\": \"eventType\", \"results\": [{\"key_as_string\": \"2019-01-01T12:00:00.000Z\", \"key\": 3, \"matching_results\": 15, \"event_rate\": 9}]}]}";
    String getMetricsQueryEventPath = "/v1/metrics/number_of_queries_with_event";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetMetricsQueryEventOptions model
    GetMetricsQueryEventOptions getMetricsQueryEventOptionsModel =
        new GetMetricsQueryEventOptions.Builder()
            .startTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .endTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .resultType("document")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<MetricResponse> response =
        discoveryService.getMetricsQueryEvent(getMetricsQueryEventOptionsModel).execute();
    assertNotNull(response);
    MetricResponse responseObj = response.getResult();
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
    assertEquals(query.get("result_type"), "document");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getMetricsQueryEventPath);
  }

  @Test
  public void testGetMetricsQueryNoResultsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"aggregations\": [{\"interval\": \"interval\", \"event_type\": \"eventType\", \"results\": [{\"key_as_string\": \"2019-01-01T12:00:00.000Z\", \"key\": 3, \"matching_results\": 15, \"event_rate\": 9}]}]}";
    String getMetricsQueryNoResultsPath = "/v1/metrics/number_of_queries_with_no_search_results";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetMetricsQueryNoResultsOptions model
    GetMetricsQueryNoResultsOptions getMetricsQueryNoResultsOptionsModel =
        new GetMetricsQueryNoResultsOptions.Builder()
            .startTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .endTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .resultType("document")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<MetricResponse> response =
        discoveryService.getMetricsQueryNoResults(getMetricsQueryNoResultsOptionsModel).execute();
    assertNotNull(response);
    MetricResponse responseObj = response.getResult();
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
    assertEquals(query.get("result_type"), "document");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getMetricsQueryNoResultsPath);
  }

  @Test
  public void testGetMetricsEventRateWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"aggregations\": [{\"interval\": \"interval\", \"event_type\": \"eventType\", \"results\": [{\"key_as_string\": \"2019-01-01T12:00:00.000Z\", \"key\": 3, \"matching_results\": 15, \"event_rate\": 9}]}]}";
    String getMetricsEventRatePath = "/v1/metrics/event_rate";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetMetricsEventRateOptions model
    GetMetricsEventRateOptions getMetricsEventRateOptionsModel =
        new GetMetricsEventRateOptions.Builder()
            .startTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .endTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .resultType("document")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<MetricResponse> response =
        discoveryService.getMetricsEventRate(getMetricsEventRateOptionsModel).execute();
    assertNotNull(response);
    MetricResponse responseObj = response.getResult();
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
    assertEquals(query.get("result_type"), "document");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getMetricsEventRatePath);
  }

  @Test
  public void testGetMetricsQueryTokenEventWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"aggregations\": [{\"event_type\": \"eventType\", \"results\": [{\"key\": \"key\", \"matching_results\": 15, \"event_rate\": 9}]}]}";
    String getMetricsQueryTokenEventPath = "/v1/metrics/top_query_tokens_with_event_rate";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetMetricsQueryTokenEventOptions model
    GetMetricsQueryTokenEventOptions getMetricsQueryTokenEventOptionsModel =
        new GetMetricsQueryTokenEventOptions.Builder().count(Long.valueOf("26")).build();

    // Invoke operation with valid options model (positive test)
    Response<MetricTokenResponse> response =
        discoveryService.getMetricsQueryTokenEvent(getMetricsQueryTokenEventOptionsModel).execute();
    assertNotNull(response);
    MetricTokenResponse responseObj = response.getResult();
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
    assertEquals(Long.valueOf(query.get("count")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getMetricsQueryTokenEventPath);
  }

  @Test
  public void testListCredentialsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"credentials\": [{\"credential_id\": \"credentialId\", \"source_type\": \"box\", \"credential_details\": {\"credential_type\": \"oauth2\", \"client_id\": \"clientId\", \"enterprise_id\": \"enterpriseId\", \"url\": \"url\", \"username\": \"username\", \"organization_url\": \"organizationUrl\", \"site_collection.path\": \"siteCollectionPath\", \"client_secret\": \"clientSecret\", \"public_key_id\": \"publicKeyId\", \"private_key\": \"privateKey\", \"passphrase\": \"passphrase\", \"password\": \"password\", \"gateway_id\": \"gatewayId\", \"source_version\": \"online\", \"web_application_url\": \"webApplicationUrl\", \"domain\": \"domain\", \"endpoint\": \"endpoint\", \"access_key_id\": \"accessKeyId\", \"secret_access_key\": \"secretAccessKey\"}, \"status\": \"connected\"}]}";
    String listCredentialsPath = "/v1/environments/testString/credentials";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListCredentialsOptions model
    ListCredentialsOptions listCredentialsOptionsModel =
        new ListCredentialsOptions.Builder().environmentId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<CredentialsList> response =
        discoveryService.listCredentials(listCredentialsOptionsModel).execute();
    assertNotNull(response);
    CredentialsList responseObj = response.getResult();
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
    assertEquals(parsedPath, listCredentialsPath);
  }

  // Test the listCredentials operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListCredentialsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.listCredentials(null).execute();
  }

  @Test
  public void testCreateCredentialsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"credential_id\": \"credentialId\", \"source_type\": \"box\", \"credential_details\": {\"credential_type\": \"oauth2\", \"client_id\": \"clientId\", \"enterprise_id\": \"enterpriseId\", \"url\": \"url\", \"username\": \"username\", \"organization_url\": \"organizationUrl\", \"site_collection.path\": \"siteCollectionPath\", \"client_secret\": \"clientSecret\", \"public_key_id\": \"publicKeyId\", \"private_key\": \"privateKey\", \"passphrase\": \"passphrase\", \"password\": \"password\", \"gateway_id\": \"gatewayId\", \"source_version\": \"online\", \"web_application_url\": \"webApplicationUrl\", \"domain\": \"domain\", \"endpoint\": \"endpoint\", \"access_key_id\": \"accessKeyId\", \"secret_access_key\": \"secretAccessKey\"}, \"status\": \"connected\"}";
    String createCredentialsPath = "/v1/environments/testString/credentials";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

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

    // Construct an instance of the CreateCredentialsOptions model
    CreateCredentialsOptions createCredentialsOptionsModel =
        new CreateCredentialsOptions.Builder()
            .environmentId("testString")
            .sourceType("box")
            .credentialDetails(credentialDetailsModel)
            .status("connected")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Credentials> response =
        discoveryService.createCredentials(createCredentialsOptionsModel).execute();
    assertNotNull(response);
    Credentials responseObj = response.getResult();
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
    assertEquals(parsedPath, createCredentialsPath);
  }

  // Test the createCredentials operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCredentialsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.createCredentials(null).execute();
  }

  @Test
  public void testGetCredentialsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"credential_id\": \"credentialId\", \"source_type\": \"box\", \"credential_details\": {\"credential_type\": \"oauth2\", \"client_id\": \"clientId\", \"enterprise_id\": \"enterpriseId\", \"url\": \"url\", \"username\": \"username\", \"organization_url\": \"organizationUrl\", \"site_collection.path\": \"siteCollectionPath\", \"client_secret\": \"clientSecret\", \"public_key_id\": \"publicKeyId\", \"private_key\": \"privateKey\", \"passphrase\": \"passphrase\", \"password\": \"password\", \"gateway_id\": \"gatewayId\", \"source_version\": \"online\", \"web_application_url\": \"webApplicationUrl\", \"domain\": \"domain\", \"endpoint\": \"endpoint\", \"access_key_id\": \"accessKeyId\", \"secret_access_key\": \"secretAccessKey\"}, \"status\": \"connected\"}";
    String getCredentialsPath = "/v1/environments/testString/credentials/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCredentialsOptions model
    GetCredentialsOptions getCredentialsOptionsModel =
        new GetCredentialsOptions.Builder()
            .environmentId("testString")
            .credentialId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Credentials> response =
        discoveryService.getCredentials(getCredentialsOptionsModel).execute();
    assertNotNull(response);
    Credentials responseObj = response.getResult();
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
    assertEquals(parsedPath, getCredentialsPath);
  }

  // Test the getCredentials operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCredentialsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.getCredentials(null).execute();
  }

  @Test
  public void testUpdateCredentialsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"credential_id\": \"credentialId\", \"source_type\": \"box\", \"credential_details\": {\"credential_type\": \"oauth2\", \"client_id\": \"clientId\", \"enterprise_id\": \"enterpriseId\", \"url\": \"url\", \"username\": \"username\", \"organization_url\": \"organizationUrl\", \"site_collection.path\": \"siteCollectionPath\", \"client_secret\": \"clientSecret\", \"public_key_id\": \"publicKeyId\", \"private_key\": \"privateKey\", \"passphrase\": \"passphrase\", \"password\": \"password\", \"gateway_id\": \"gatewayId\", \"source_version\": \"online\", \"web_application_url\": \"webApplicationUrl\", \"domain\": \"domain\", \"endpoint\": \"endpoint\", \"access_key_id\": \"accessKeyId\", \"secret_access_key\": \"secretAccessKey\"}, \"status\": \"connected\"}";
    String updateCredentialsPath = "/v1/environments/testString/credentials/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

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

    // Construct an instance of the UpdateCredentialsOptions model
    UpdateCredentialsOptions updateCredentialsOptionsModel =
        new UpdateCredentialsOptions.Builder()
            .environmentId("testString")
            .credentialId("testString")
            .sourceType("box")
            .credentialDetails(credentialDetailsModel)
            .status("connected")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<Credentials> response =
        discoveryService.updateCredentials(updateCredentialsOptionsModel).execute();
    assertNotNull(response);
    Credentials responseObj = response.getResult();
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
    assertEquals(parsedPath, updateCredentialsPath);
  }

  // Test the updateCredentials operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCredentialsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.updateCredentials(null).execute();
  }

  @Test
  public void testDeleteCredentialsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"credential_id\": \"credentialId\", \"status\": \"deleted\"}";
    String deleteCredentialsPath = "/v1/environments/testString/credentials/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteCredentialsOptions model
    DeleteCredentialsOptions deleteCredentialsOptionsModel =
        new DeleteCredentialsOptions.Builder()
            .environmentId("testString")
            .credentialId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteCredentials> response =
        discoveryService.deleteCredentials(deleteCredentialsOptionsModel).execute();
    assertNotNull(response);
    DeleteCredentials responseObj = response.getResult();
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
    assertEquals(parsedPath, deleteCredentialsPath);
  }

  // Test the deleteCredentials operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCredentialsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.deleteCredentials(null).execute();
  }

  @Test
  public void testListGatewaysWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"gateways\": [{\"gateway_id\": \"gatewayId\", \"name\": \"name\", \"status\": \"connected\", \"token\": \"token\", \"token_id\": \"tokenId\"}]}";
    String listGatewaysPath = "/v1/environments/testString/gateways";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListGatewaysOptions model
    ListGatewaysOptions listGatewaysOptionsModel =
        new ListGatewaysOptions.Builder().environmentId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<GatewayList> response =
        discoveryService.listGateways(listGatewaysOptionsModel).execute();
    assertNotNull(response);
    GatewayList responseObj = response.getResult();
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
    assertEquals(parsedPath, listGatewaysPath);
  }

  // Test the listGateways operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListGatewaysNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.listGateways(null).execute();
  }

  @Test
  public void testCreateGatewayWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"gateway_id\": \"gatewayId\", \"name\": \"name\", \"status\": \"connected\", \"token\": \"token\", \"token_id\": \"tokenId\"}";
    String createGatewayPath = "/v1/environments/testString/gateways";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateGatewayOptions model
    CreateGatewayOptions createGatewayOptionsModel =
        new CreateGatewayOptions.Builder().environmentId("testString").name("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Gateway> response =
        discoveryService.createGateway(createGatewayOptionsModel).execute();
    assertNotNull(response);
    Gateway responseObj = response.getResult();
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
    assertEquals(parsedPath, createGatewayPath);
  }

  // Test the createGateway operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateGatewayNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.createGateway(null).execute();
  }

  @Test
  public void testGetGatewayWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"gateway_id\": \"gatewayId\", \"name\": \"name\", \"status\": \"connected\", \"token\": \"token\", \"token_id\": \"tokenId\"}";
    String getGatewayPath = "/v1/environments/testString/gateways/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetGatewayOptions model
    GetGatewayOptions getGatewayOptionsModel =
        new GetGatewayOptions.Builder().environmentId("testString").gatewayId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<Gateway> response = discoveryService.getGateway(getGatewayOptionsModel).execute();
    assertNotNull(response);
    Gateway responseObj = response.getResult();
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
    assertEquals(parsedPath, getGatewayPath);
  }

  // Test the getGateway operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetGatewayNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.getGateway(null).execute();
  }

  @Test
  public void testDeleteGatewayWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"gateway_id\": \"gatewayId\", \"status\": \"status\"}";
    String deleteGatewayPath = "/v1/environments/testString/gateways/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteGatewayOptions model
    DeleteGatewayOptions deleteGatewayOptionsModel =
        new DeleteGatewayOptions.Builder()
            .environmentId("testString")
            .gatewayId("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<GatewayDelete> response =
        discoveryService.deleteGateway(deleteGatewayOptionsModel).execute();
    assertNotNull(response);
    GatewayDelete responseObj = response.getResult();
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
    assertEquals(parsedPath, deleteGatewayPath);
  }

  // Test the deleteGateway operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteGatewayNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    discoveryService.deleteGateway(null).execute();
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

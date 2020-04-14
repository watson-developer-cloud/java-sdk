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
package com.ibm.watson.discovery.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.watson.common.WatsonServiceUnitTest;
import com.ibm.watson.discovery.v1.model.*;
import com.ibm.watson.discovery.v1.query.AggregationType;
import com.ibm.watson.discovery.v1.query.Operator;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/** Unit tests for {@link Discovery}. */
@SuppressWarnings("deprecation")
public class DiscoveryServiceTest extends WatsonServiceUnitTest {
  private Discovery discoveryService;

  private static final String VERSION = "2019-04-30";

  private static final String RESOURCE = "src/test/resources/discovery/v1/";
  private static final String DISCOVERY_TEST_CONFIG_FILE = RESOURCE + "test-config.json";
  private static final String ENV1_PATH = "/v1/environments/mock_envid?version=" + VERSION;
  private static final String ENV2_PATH = "/v1/environments?version=" + VERSION;
  private static final String CONF1_PATH =
      "/v1/environments/mock_envid/configurations?version=" + VERSION;
  private static final String CONF2_PATH =
      "/v1/environments/mock_envid/configurations/mock_confid?version=" + VERSION;
  private static final String COLL1_PATH =
      "/v1/environments/mock_envid/collections?version=" + VERSION;
  private static final String COLL2_PATH =
      "/v1/environments/mock_envid/collections/mock_collid?version=" + VERSION;
  private static final String COLL3_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/fields?version=" + VERSION;
  private static final String DOCS1_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/documents?version=" + VERSION;
  private static final String DOCS2_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/documents/mock_docid?version=" + VERSION;
  private static final String Q1_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/query?version=" + VERSION;
  private static final String Q2_PATH = "/v1/environments/mock_envid/query?version=" + VERSION;
  private static final String Q3_PATH =
      "/v1/environments/mock_envid/notices?version=" + VERSION + "&collection_ids=mock_collid";
  private static final String Q4_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/notices?version=" + VERSION;
  private static final String TRAINING1_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/training_data?version=" + VERSION;
  private static final String TRAINING2_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/training_data/mock_queryid/examples?version="
          + VERSION;
  private static final String TRAINING3_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/training_data/mock_queryid?version="
          + VERSION;
  private static final String TRAINING4_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/training_data/mock_queryid/examples/mock_docid?version="
          + VERSION;
  private static final String FIELD_PATH =
      "/v1/environments/mock_envid/fields?version=" + VERSION + "&collection_ids=mock_collid";
  private static final String EXPANSIONS_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/expansions?version=" + VERSION;
  private static final String DELETE_USER_DATA_PATH =
      "/v1/user_data?version=" + VERSION + "&customer_id=java_sdk_test_id";
  private static final String CREATE_CREDENTIALS_PATH =
      "/v1/environments/mock_envid/credentials?version=" + VERSION;
  private static final String DELETE_CREDENTIALS_PATH =
      "/v1/environments/mock_envid/credentials/credential_id?version=" + VERSION;
  private static final String GET_CREDENTIALS_PATH =
      "/v1/environments/mock_envid/credentials/credential_id?version=" + VERSION;
  private static final String LIST_CREDENTIALS_PATH =
      "/v1/environments/mock_envid/credentials?version=" + VERSION;
  private static final String UPDATE_CREDENTIALS_PATH =
      "/v1/environments/mock_envid/credentials/new_credential_id?version=" + VERSION;
  private static final String CREATE_EVENT_PATH = "/v1/events?version=" + VERSION;
  private static final String GET_METRICS_EVENT_RATE_PATH =
      "/v1/metrics/event_rate?version=" + VERSION;
  private static final String GET_METRICS_QUERY_PATH =
      "/v1/metrics/number_of_queries?version=" + VERSION;
  private static final String GET_METRICS_QUERY_EVENT_PATH =
      "/v1/metrics/number_of_queries_with_event?version=" + VERSION;
  private static final String GET_METRICS_QUERY_NO_RESULTS_PATH =
      "/v1/metrics/number_of_queries_with_no_search_results?version=" + VERSION;
  private static final String GET_METRICS_QUERY_TOKEN_EVENT_PATH =
      "/v1/metrics/top_query_tokens_with_event_rate?version=" + VERSION;
  private static final String QUERY_LOG_PATH = "/v1/logs?version=" + VERSION;

  private String environmentId;
  private String environmentName;
  private String environmentDesc;
  private String uniqueConfigName;
  private String configurationId;
  private String uniqueCollectionName;
  private String collectionId;
  private String documentId;
  private String queryId;
  private Date date;
  private InputStream testStream;

  private Environment envResp;
  private ListEnvironmentsResponse envsResp;
  private Environment createEnvResp;
  private DeleteEnvironmentResponse deleteEnvResp;
  private Environment updateEnvResp;
  private Configuration createConfResp;
  private ListConfigurationsResponse getConfsResp;
  private Configuration getConfResp;
  private DeleteConfigurationResponse deleteConfResp;
  private Configuration updateConfResp;
  private Collection createCollResp;
  private ListCollectionsResponse getCollsResp;
  private Collection getCollResp;
  private DeleteCollectionResponse deleteCollResp;
  private ListCollectionFieldsResponse listfieldsCollResp;
  private DocumentAccepted createDocResp;
  private DocumentAccepted updateDocResp;
  private DocumentStatus getDocResp;
  private DeleteDocumentResponse deleteDocResp;
  private QueryResponse queryResp;
  private QueryNoticesResponse queryNoticesResp;
  private TrainingQuery addTrainingQueryResp;
  private TrainingDataSet listTrainingDataResp;
  private TrainingExample createTrainingExampleResp;
  private TrainingQuery getTrainingDataResp;
  private TrainingExample getTrainingExampleResp;
  private TrainingExample updateTrainingExampleResp;
  private TrainingExampleList listTrainingExamplesResp;
  private ListCollectionFieldsResponse listFieldsResp;
  private Expansions expansionsResp;
  private Credentials credentialsResp;
  private CredentialsList listCredentialsResp;
  private DeleteCredentials deleteCredentialsResp;
  private CreateEventResponse createEventResp;
  private MetricResponse metricResp;
  private MetricTokenResponse metricTokenResp;
  private LogQueryResponse logQueryResp;
  private TokenDictStatusResponse tokenDictStatusResponse;
  private TokenDictStatusResponse tokenDictStatusResponseStopwords;
  private Gateway gatewayResponse;
  private GatewayList listGatewaysResponse;
  private GatewayDelete deleteGatewayResponse;

  @BeforeClass
  public static void setupClass() {}

  @Before
  public void setup() throws Exception {
    super.setUp();
    discoveryService = new Discovery(VERSION, new NoAuthAuthenticator());
    discoveryService.setServiceUrl(getMockWebServerUrl());

    environmentId = "mock_envid";
    environmentName = "my_environment";
    environmentDesc = "My environment";
    uniqueConfigName = "my-config";
    configurationId = "mock_confid";
    uniqueCollectionName = "mock_collname";
    collectionId = "mock_collid";
    documentId = "mock_docid";
    queryId = "mock_queryid";
    date = new Date();
    testStream = new FileInputStream(RESOURCE + "get_env_resp.json");

    envResp = loadFixture(RESOURCE + "get_env_resp.json", Environment.class);
    envsResp = loadFixture(RESOURCE + "get_envs_resp.json", ListEnvironmentsResponse.class);
    createEnvResp = loadFixture(RESOURCE + "create_env_resp.json", Environment.class);
    deleteEnvResp = loadFixture(RESOURCE + "delete_env_resp.json", DeleteEnvironmentResponse.class);
    updateEnvResp = loadFixture(RESOURCE + "update_env_resp.json", Environment.class);
    createConfResp = loadFixture(RESOURCE + "create_conf_resp.json", Configuration.class);
    getConfsResp = loadFixture(RESOURCE + "get_confs_resp.json", ListConfigurationsResponse.class);
    getConfResp = loadFixture(RESOURCE + "get_conf_resp.json", Configuration.class);
    deleteConfResp =
        loadFixture(RESOURCE + "delete_conf_resp.json", DeleteConfigurationResponse.class);
    updateConfResp = loadFixture(RESOURCE + "update_conf_resp.json", Configuration.class);
    createCollResp = loadFixture(RESOURCE + "create_coll_resp.json", Collection.class);
    getCollsResp = loadFixture(RESOURCE + "get_coll_resp.json", ListCollectionsResponse.class);
    getCollResp = loadFixture(RESOURCE + "get_coll1_resp.json", Collection.class);
    deleteCollResp =
        loadFixture(RESOURCE + "delete_coll_resp.json", DeleteCollectionResponse.class);
    listfieldsCollResp =
        loadFixture(RESOURCE + "listfields_coll_resp.json", ListCollectionFieldsResponse.class);
    createDocResp = loadFixture(RESOURCE + "create_doc_resp.json", DocumentAccepted.class);
    updateDocResp = loadFixture(RESOURCE + "update_doc_resp.json", DocumentAccepted.class);
    getDocResp = loadFixture(RESOURCE + "get_doc_resp.json", DocumentStatus.class);
    deleteDocResp = loadFixture(RESOURCE + "delete_doc_resp.json", DeleteDocumentResponse.class);
    queryResp = loadFixture(RESOURCE + "query1_resp.json", QueryResponse.class);
    queryNoticesResp = loadFixture(RESOURCE + "query1_resp.json", QueryNoticesResponse.class);
    addTrainingQueryResp =
        loadFixture(RESOURCE + "add_training_query_resp.json", TrainingQuery.class);
    listTrainingDataResp =
        loadFixture(RESOURCE + "list_training_data_resp.json", TrainingDataSet.class);
    createTrainingExampleResp =
        loadFixture(RESOURCE + "add_training_example_resp.json", TrainingExample.class);
    getTrainingDataResp =
        loadFixture(RESOURCE + "get_training_data_resp.json", TrainingQuery.class);
    getTrainingExampleResp =
        loadFixture(RESOURCE + "get_training_example_resp.json", TrainingExample.class);
    updateTrainingExampleResp =
        loadFixture(RESOURCE + "update_training_example_resp.json", TrainingExample.class);
    listTrainingExamplesResp =
        loadFixture(RESOURCE + "list_training_examples_resp.json", TrainingExampleList.class);
    listFieldsResp =
        loadFixture(RESOURCE + "list_fields_resp.json", ListCollectionFieldsResponse.class);
    expansionsResp = loadFixture(RESOURCE + "expansions_resp.json", Expansions.class);
    credentialsResp = loadFixture(RESOURCE + "credentials_resp.json", Credentials.class);
    listCredentialsResp =
        loadFixture(RESOURCE + "list_credentials_resp.json", CredentialsList.class);
    deleteCredentialsResp =
        loadFixture(RESOURCE + "delete_credentials_resp.json", DeleteCredentials.class);
    createEventResp = loadFixture(RESOURCE + "create_event_resp.json", CreateEventResponse.class);
    metricResp = loadFixture(RESOURCE + "metric_resp.json", MetricResponse.class);
    metricTokenResp = loadFixture(RESOURCE + "metric_token_resp.json", MetricTokenResponse.class);
    logQueryResp = loadFixture(RESOURCE + "log_query_resp.json", LogQueryResponse.class);
    tokenDictStatusResponse =
        loadFixture(RESOURCE + "token_dict_status_resp.json", TokenDictStatusResponse.class);
    tokenDictStatusResponseStopwords =
        loadFixture(
            RESOURCE + "token_dict_status_resp_stopwords.json", TokenDictStatusResponse.class);
    gatewayResponse = loadFixture(RESOURCE + "gateway_resp.json", Gateway.class);
    listGatewaysResponse = loadFixture(RESOURCE + "list_gateways_resp.json", GatewayList.class);
    deleteGatewayResponse = loadFixture(RESOURCE + "delete_gateway_resp.json", GatewayDelete.class);
  }

  @After
  public void cleanup() {}

  /** Negative - Test constructor with null version date. */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullVersionDate() {
    new Discovery(null, new NoAuthAuthenticator());
  }

  /** Negative - Test constructor with empty version date. */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithEmptyVersionDate() {
    new Discovery("", new NoAuthAuthenticator());
  }

  // Environment tests
  @Test
  public void getEnvironmentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(envResp));
    GetEnvironmentOptions getRequest = new GetEnvironmentOptions.Builder(environmentId).build();
    Environment response = discoveryService.getEnvironment(getRequest).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals(ENV1_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(envResp, response);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getEnvironmentFails1() {
    GetEnvironmentOptions getRequest = new GetEnvironmentOptions.Builder().build();
    @SuppressWarnings("unused")
    Environment response = discoveryService.getEnvironment(getRequest).execute().getResult();
  }

  @Test(expected = IllegalArgumentException.class)
  public void getEnvironmentFails2() {
    @SuppressWarnings("unused")
    Environment response = discoveryService.getEnvironment(null).execute().getResult();
  }

  @Test
  public void listEnvironmentsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(envsResp));
    ListEnvironmentsResponse response =
        discoveryService.listEnvironments(null).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals(ENV2_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(envsResp, response);
  }

  // Deleted test for listEnvironments with null name as this does not fail in the current SDK

  @Test
  public void createEnvironmentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createEnvResp));
    CreateEnvironmentOptions.Builder createRequestBuilder =
        new CreateEnvironmentOptions.Builder()
            .name(environmentName)
            .size(CreateEnvironmentOptions.Size.XS);
    createRequestBuilder.description(environmentDesc);
    Environment response =
        discoveryService.createEnvironment(createRequestBuilder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(ENV2_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createEnvResp, response);
  }

  // Deleted test for createEnvironment with null name as this does not fail in the current SDK

  @Test
  public void deleteEnvironmentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(deleteEnvResp));
    DeleteEnvironmentOptions deleteRequest =
        new DeleteEnvironmentOptions.Builder(environmentId).build();
    DeleteEnvironmentResponse response =
        discoveryService.deleteEnvironment(deleteRequest).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(ENV1_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
    assertEquals(deleteEnvResp.getEnvironmentId(), response.getEnvironmentId());
    assertEquals(deleteEnvResp.getStatus(), response.getStatus());
  }

  @Test(expected = IllegalArgumentException.class)
  public void deleteEnvironmentFails() {
    discoveryService.deleteEnvironment(null).execute().getResult();
  }

  @Test
  public void updateEnvironmentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(updateEnvResp));
    UpdateEnvironmentOptions updateOptions =
        new UpdateEnvironmentOptions.Builder(environmentId)
            .name(environmentName)
            .description(environmentDesc)
            .size(UpdateEnvironmentOptions.Size.L)
            .build();

    assertEquals(environmentId, updateOptions.environmentId());
    assertEquals(environmentName, updateOptions.name());
    assertEquals(environmentDesc, updateOptions.description());
    assertEquals(UpdateEnvironmentOptions.Size.L, updateOptions.size());

    Environment response = discoveryService.updateEnvironment(updateOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(ENV1_PATH, request.getPath());
    assertEquals(PUT, request.getMethod());
    assertEquals(updateEnvResp, response);
  }

  @Test
  public void testSourceOptions() {
    String folderOwnerUserId = "folder_owner_user_id";
    String folderId = "folder_id";
    Long limit = 10L;
    String objectName = "object_name";
    String siteCollectionPath = "site_collection_path";
    String url = "url";
    Long maximumHops = 5L;
    Long requestTimeout = 2L;
    String bucketName = "bucket_name";

    SourceOptionsFolder folder =
        new SourceOptionsFolder.Builder()
            .ownerUserId(folderOwnerUserId)
            .folderId(folderId)
            .limit(limit)
            .build();
    SourceOptionsObject object =
        new SourceOptionsObject.Builder().name(objectName).limit(limit).build();
    SourceOptionsSiteColl siteColl =
        new SourceOptionsSiteColl.Builder()
            .siteCollectionPath(siteCollectionPath)
            .limit(limit)
            .build();
    SourceOptionsWebCrawl webCrawl =
        new SourceOptionsWebCrawl.Builder()
            .url(url)
            .limitToStartingHosts(true)
            .crawlSpeed(SourceOptionsWebCrawl.CrawlSpeed.AGGRESSIVE)
            .allowUntrustedCertificate(true)
            .maximumHops(maximumHops)
            .requestTimeout(requestTimeout)
            .overrideRobotsTxt(true)
            .build();
    SourceOptionsBuckets buckets =
        new SourceOptionsBuckets.Builder().name(bucketName).limit(limit).build();
    SourceOptions sourceOptions =
        new SourceOptions.Builder()
            .folders(Collections.singletonList(folder))
            .objects(Collections.singletonList(object))
            .siteCollections(Collections.singletonList(siteColl))
            .urls(Collections.singletonList(webCrawl))
            .buckets(Collections.singletonList(buckets))
            .crawlAllBuckets(true)
            .build();

    assertEquals(folderOwnerUserId, sourceOptions.folders().get(0).ownerUserId());
    assertEquals(folderId, sourceOptions.folders().get(0).folderId());
    assertEquals(limit, sourceOptions.folders().get(0).limit());
    assertEquals(objectName, sourceOptions.objects().get(0).name());
    assertEquals(limit, sourceOptions.objects().get(0).limit());
    assertEquals(siteCollectionPath, sourceOptions.siteCollections().get(0).siteCollectionPath());
    assertEquals(limit, sourceOptions.siteCollections().get(0).limit());
    assertEquals(url, sourceOptions.urls().get(0).url());
    assertTrue(sourceOptions.urls().get(0).limitToStartingHosts());
    assertEquals(
        SourceOptionsWebCrawl.CrawlSpeed.AGGRESSIVE, sourceOptions.urls().get(0).crawlSpeed());
    assertTrue(sourceOptions.urls().get(0).allowUntrustedCertificate());
    assertEquals(maximumHops, sourceOptions.urls().get(0).maximumHops());
    assertEquals(requestTimeout, sourceOptions.urls().get(0).requestTimeout());
    assertTrue(sourceOptions.urls().get(0).overrideRobotsTxt());
    assertEquals(bucketName, sourceOptions.buckets().get(0).name());
    assertEquals(limit, sourceOptions.buckets().get(0).limit());
    assertTrue(sourceOptions.crawlAllBuckets());
  }

  // Configuration tests
  @Test
  public void testCreateConfigurationOptions() {
    String name = "name";
    String description = "description";
    Conversions conversions = new Conversions.Builder().build();
    String firstEnrichmentName = "first";
    String secondEnrichmentName = "second";
    String sourceField = "source_field";
    String destinationField = "destination_field";
    List<Enrichment> enrichments = new ArrayList<>();
    Enrichment firstEnrichment =
        new Enrichment.Builder()
            .enrichment(firstEnrichmentName)
            .sourceField(sourceField)
            .destinationField(destinationField)
            .build();
    enrichments.add(firstEnrichment);
    Enrichment secondEnrichment =
        new Enrichment.Builder()
            .enrichment(secondEnrichmentName)
            .sourceField(sourceField)
            .destinationField(destinationField)
            .build();
    List<NormalizationOperation> normalizationOperations = new ArrayList<>();
    NormalizationOperation firstOp =
        new NormalizationOperation.Builder()
            .operation(NormalizationOperation.Operation.MERGE)
            .build();
    NormalizationOperation secondOp =
        new NormalizationOperation.Builder()
            .operation(NormalizationOperation.Operation.COPY)
            .build();
    normalizationOperations.add(firstOp);
    Source source = new Source.Builder().build();

    CreateConfigurationOptions createConfigurationOptions =
        new CreateConfigurationOptions.Builder()
            .environmentId(environmentId)
            .name(name)
            .description(description)
            .conversions(conversions)
            .enrichments(enrichments)
            .addEnrichment(secondEnrichment)
            .normalizations(normalizationOperations)
            .addNormalization(secondOp)
            .source(source)
            .build();
    createConfigurationOptions = createConfigurationOptions.newBuilder().build();

    enrichments.add(secondEnrichment);
    normalizationOperations.add(secondOp);

    assertEquals(environmentId, createConfigurationOptions.environmentId());
    assertEquals(name, createConfigurationOptions.name());
    assertEquals(description, createConfigurationOptions.description());
    assertEquals(conversions, createConfigurationOptions.conversions());
    assertEquals(enrichments, createConfigurationOptions.enrichments());
    assertEquals(normalizationOperations, createConfigurationOptions.normalizations());
    assertEquals(source, createConfigurationOptions.source());
  }

  @Test
  public void createConfigurationIsSuccessful()
      throws JsonSyntaxException, JsonIOException, FileNotFoundException, InterruptedException {
    server.enqueue(jsonResponse(createConfResp));
    CreateConfigurationOptions.Builder createBuilder = new CreateConfigurationOptions.Builder();
    Configuration configuration =
        GsonSingleton.getGson()
            .fromJson(new FileReader(DISCOVERY_TEST_CONFIG_FILE), Configuration.class);
    createBuilder.configuration(configuration);
    createBuilder.environmentId(environmentId);
    createBuilder.name(uniqueConfigName);
    Configuration response =
        discoveryService.createConfiguration(createBuilder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createConfResp, response);
  }

  @Test
  public void getConfigurationIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getConfResp));

    GetConfigurationOptions getRequest =
        new GetConfigurationOptions.Builder(environmentId, configurationId).build();
    Configuration response = discoveryService.getConfiguration(getRequest).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF2_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getConfResp, response);
  }

  @Test
  public void getConfigurationsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getConfsResp));
    ListConfigurationsOptions getRequest =
        new ListConfigurationsOptions.Builder(environmentId).build();
    ListConfigurationsResponse response =
        discoveryService.listConfigurations(getRequest).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF1_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getConfsResp, response);
  }

  @Test
  public void deleteConfigurationIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(deleteConfResp));
    DeleteConfigurationOptions deleteRequest =
        new DeleteConfigurationOptions.Builder(environmentId, configurationId).build();
    DeleteConfigurationResponse response =
        discoveryService.deleteConfiguration(deleteRequest).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF2_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
    assertEquals(deleteConfResp.getConfigurationId(), response.getConfigurationId());
    assertEquals(DeleteConfigurationResponse.Status.DELETED, response.getStatus());
    assertNotNull(response.getNotices());
  }

  @Test
  public void updateConfigurationIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(updateConfResp));
    UpdateConfigurationOptions.Builder updateBuilder = new UpdateConfigurationOptions.Builder();
    updateBuilder.configurationId(configurationId);
    updateBuilder.environmentId(environmentId);
    Configuration newConf = new Configuration.Builder().name("newName").build();
    updateBuilder.configuration(newConf);

    Configuration response =
        discoveryService.updateConfiguration(updateBuilder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF2_PATH, request.getPath());
    assertEquals(PUT, request.getMethod());
    assertEquals(updateConfResp, response);
  }

  // Collection tests
  @Test
  public void createCollectionIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createCollResp));
    CreateCollectionOptions.Builder createCollectionBuilder =
        new CreateCollectionOptions.Builder(environmentId, uniqueCollectionName)
            .configurationId(configurationId);
    Collection response =
        discoveryService.createCollection(createCollectionBuilder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createCollResp, response);
  }

  @Test
  public void getCollectionsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getCollsResp));
    ListCollectionsOptions getRequest = new ListCollectionsOptions.Builder(environmentId).build();
    ListCollectionsResponse response =
        discoveryService.listCollections(getRequest).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL1_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getCollsResp, response);
  }

  @Test
  public void getCollectionIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getCollResp));
    GetCollectionOptions getRequest =
        new GetCollectionOptions.Builder(environmentId, collectionId).build();
    Collection response = discoveryService.getCollection(getRequest).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL2_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getCollResp, response);
  }

  // no updateCollection yet?

  @Test
  public void listfieldsCollectionIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(listfieldsCollResp));
    ListCollectionFieldsOptions getRequest =
        new ListCollectionFieldsOptions.Builder(environmentId, collectionId).build();
    ListCollectionFieldsResponse response =
        discoveryService.listCollectionFields(getRequest).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL3_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(listfieldsCollResp, response);
  }

  @Test
  public void deleteCollectionIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(deleteCollResp));
    DeleteCollectionOptions deleteRequest =
        new DeleteCollectionOptions.Builder(environmentId, collectionId).build();
    DeleteCollectionResponse response =
        discoveryService.deleteCollection(deleteRequest).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL2_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
    assertEquals(DeleteCollectionResponse.Status.DELETED, response.getStatus());
    assertEquals(deleteCollResp.getCollectionId(), response.getCollectionId());
  }

  // Document tests
  @Test
  public void addDocumentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createDocResp));
    String myDocumentJson = "{\"field\":\"value\"}";
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    AddDocumentOptions.Builder builder =
        new AddDocumentOptions.Builder(environmentId, collectionId);
    builder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    builder.filename("test_file");
    builder.metadata(myMetadata.toString());
    DocumentAccepted response = discoveryService.addDocument(builder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createDocResp, response);
  }

  @Test
  public void addDocumentFromInputStreamIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createDocResp));
    String myDocumentJson = "{\"field\":\"value\"}";
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    AddDocumentOptions.Builder builder =
        new AddDocumentOptions.Builder(environmentId, collectionId);
    builder.file(documentStream);
    builder.filename("test_file");
    builder.metadata(myMetadata.toString());
    DocumentAccepted response = discoveryService.addDocument(builder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createDocResp, response);
  }

  @Test
  public void addDocumentFromInputStreamWithMediaTypeIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createDocResp));
    String myDocumentJson = "{\"field\":\"value\"}";
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    AddDocumentOptions.Builder builder =
        new AddDocumentOptions.Builder(environmentId, collectionId);
    builder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    builder.filename("test_file");
    builder.metadata(myMetadata.toString());
    DocumentAccepted response = discoveryService.addDocument(builder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createDocResp, response);
  }

  @Test(expected = IllegalArgumentException.class)
  public void addDocumentWithoutRequiredParametersFails() {
    AddDocumentOptions options =
        new AddDocumentOptions.Builder(environmentId, collectionId).build();
    discoveryService.addDocument(options).execute().getResult();
  }

  @Test
  public void addDocumentFromInputStreamWithFileNameAndMediaTypeIsSuccessful()
      throws InterruptedException {
    server.enqueue(jsonResponse(createDocResp));
    String myDocumentJson = "{\"field\":\"value\"}";
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    AddDocumentOptions.Builder builder =
        new AddDocumentOptions.Builder(environmentId, collectionId);
    builder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    builder.filename("test_file");
    builder.metadata(myMetadata.toString());
    DocumentAccepted response = discoveryService.addDocument(builder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createDocResp, response);
  }

  // Deleted tests for (create)addDocument with file parameter as this is deprecated

  @Test
  public void updateDocumentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(updateDocResp));
    UpdateDocumentOptions.Builder updateBuilder =
        new UpdateDocumentOptions.Builder(environmentId, collectionId, documentId);
    String myDocumentJson = "{\"field\":\"value2\"}";
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());
    updateBuilder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    updateBuilder.filename("test_file");
    updateBuilder.metadata(myMetadata.toString());
    DocumentAccepted response =
        discoveryService.updateDocument(updateBuilder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS2_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(updateDocResp, response);
  }

  @Test(expected = IllegalArgumentException.class)
  public void updateDocumentWithoutRequiredParametersFails() {
    UpdateDocumentOptions options =
        new UpdateDocumentOptions.Builder(environmentId, collectionId, documentId).build();
    discoveryService.updateDocument(options).execute().getResult();
  }

  @Test
  public void getDocumentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getDocResp));
    GetDocumentStatusOptions getRequest =
        new GetDocumentStatusOptions.Builder(environmentId, collectionId, documentId).build();
    DocumentStatus response = discoveryService.getDocumentStatus(getRequest).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS2_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getDocResp, response);
  }

  @Test
  public void deleteDocumentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(deleteDocResp));
    DeleteDocumentOptions deleteRequest =
        new DeleteDocumentOptions.Builder(environmentId, collectionId, documentId).build();
    DeleteDocumentResponse response =
        discoveryService.deleteDocument(deleteRequest).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS2_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
    assertEquals(deleteDocResp.getDocumentId(), response.getDocumentId());
    assertEquals(deleteDocResp.getStatus(), response.getStatus());
  }

  // Query tests
  @Test
  public void queryIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(queryResp));
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    queryBuilder.count(5L);
    queryBuilder.offset(5L);
    String fieldNames = "field";
    queryBuilder.xReturn(fieldNames);
    queryBuilder.query("field" + Operator.CONTAINS + 1);
    queryBuilder.filter("field" + Operator.CONTAINS + 1);
    queryBuilder.similar(true);
    String similarDocumentIds = "doc1, doc2";
    queryBuilder.similarDocumentIds(similarDocumentIds);
    String similarFields = "field1, field2";
    queryBuilder.similarFields(similarFields);
    queryBuilder.xWatsonLoggingOptOut(true);
    queryBuilder.bias("bias");
    QueryResponse response = discoveryService.query(queryBuilder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(Q1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(
        GsonSingleton.getGson().toJsonTree(queryResp),
        GsonSingleton.getGson().toJsonTree(response));
  }

  @Test
  public void queryWithAggregationTermIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(queryResp));
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.TERM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse response = discoveryService.query(queryBuilder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(Q1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(
        GsonSingleton.getGson().toJsonTree(queryResp),
        GsonSingleton.getGson().toJsonTree(response));
  }

  // Training data tests
  @Test
  public void addTrainingDataIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(addTrainingQueryResp));
    AddTrainingDataOptions.Builder builder =
        new AddTrainingDataOptions.Builder(environmentId, collectionId);
    builder.naturalLanguageQuery("Example query");
    TrainingExample example =
        new TrainingExample.Builder().documentId(documentId).relevance(0).build();
    builder.addExamples(example);
    TrainingQuery response =
        discoveryService.addTrainingData(builder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(TRAINING1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(addTrainingQueryResp, response);
  }

  @Test
  public void listTrainingDataIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(listTrainingDataResp));
    ListTrainingDataOptions getRequest =
        new ListTrainingDataOptions.Builder(environmentId, collectionId).build();
    TrainingDataSet response = discoveryService.listTrainingData(getRequest).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(TRAINING1_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(listTrainingDataResp, response);
  }

  @Test
  public void deleteAllCollectionTrainingDataIsSuccessful() throws InterruptedException {
    MockResponse desiredResponse = new MockResponse().setResponseCode(204);
    server.enqueue(desiredResponse);
    DeleteAllTrainingDataOptions deleteRequest =
        new DeleteAllTrainingDataOptions.Builder(environmentId, collectionId).build();
    discoveryService.deleteAllTrainingData(deleteRequest).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(TRAINING1_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
  }

  @Test
  public void createTrainingExampleIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createTrainingExampleResp));
    CreateTrainingExampleOptions.Builder builder =
        new CreateTrainingExampleOptions.Builder(environmentId, collectionId, queryId);
    builder.documentId(documentId);
    builder.relevance(0);
    TrainingExample response =
        discoveryService.createTrainingExample(builder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(TRAINING2_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createTrainingExampleResp, response);
  }

  @Test
  public void getTrainingDataIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getTrainingDataResp));
    GetTrainingDataOptions.Builder builder =
        new GetTrainingDataOptions.Builder(environmentId, collectionId, queryId);
    TrainingQuery response =
        discoveryService.getTrainingData(builder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(TRAINING3_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getTrainingDataResp, response);
  }

  @Test
  public void getTrainingExampleIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getTrainingExampleResp));
    GetTrainingExampleOptions.Builder builder =
        new GetTrainingExampleOptions.Builder(environmentId, collectionId, queryId, documentId);
    TrainingExample response =
        discoveryService.getTrainingExample(builder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(TRAINING4_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getTrainingExampleResp, response);
  }

  @Test
  public void deleteTrainingDataIsSuccessful() throws InterruptedException {
    MockResponse desiredResponse = new MockResponse().setResponseCode(204);
    server.enqueue(desiredResponse);
    DeleteTrainingDataOptions.Builder builder =
        new DeleteTrainingDataOptions.Builder(environmentId, collectionId, queryId);
    discoveryService.deleteTrainingData(builder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(TRAINING3_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
  }

  @Test
  public void deleteTrainingExampleIsSuccessful() throws InterruptedException {
    MockResponse desiredResponse = new MockResponse().setResponseCode(204);
    server.enqueue(desiredResponse);
    DeleteTrainingExampleOptions.Builder builder =
        new DeleteTrainingExampleOptions.Builder(environmentId, collectionId, queryId, documentId);
    discoveryService.deleteTrainingExample(builder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(TRAINING4_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
  }

  @Test
  public void updateTrainingExampleIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(updateTrainingExampleResp));
    UpdateTrainingExampleOptions.Builder builder =
        new UpdateTrainingExampleOptions.Builder(environmentId, collectionId, queryId, documentId);
    builder.relevance(100);
    TrainingExample response =
        discoveryService.updateTrainingExample(builder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(TRAINING4_PATH, request.getPath());
    assertEquals(PUT, request.getMethod());
    assertEquals(updateTrainingExampleResp, response);
  }

  @Test
  public void listTrainingExamplesIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(listTrainingExamplesResp));
    ListTrainingExamplesOptions.Builder builder =
        new ListTrainingExamplesOptions.Builder(environmentId, collectionId, queryId);
    TrainingExampleList response =
        discoveryService.listTrainingExamples(builder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(TRAINING2_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(listTrainingExamplesResp, response);
  }

  @Test
  public void listFieldsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(listFieldsResp));
    ListFieldsOptions.Builder builder =
        new ListFieldsOptions.Builder(environmentId, new ArrayList<>(Arrays.asList(collectionId)));
    ListCollectionFieldsResponse response =
        discoveryService.listFields(builder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(FIELD_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(listFieldsResp, response);
  }

  @Test
  public void queryNoticesIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(queryNoticesResp));
    QueryNoticesOptions.Builder builder =
        new QueryNoticesOptions.Builder(environmentId, collectionId);
    discoveryService.queryNotices(builder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(Q4_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
  }

  @Test
  public void federatedQueryIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(queryResp));
    FederatedQueryOptions.Builder builder =
        new FederatedQueryOptions.Builder()
            .environmentId(environmentId)
            .collectionIds(collectionId)
            .bias("bias")
            .xWatsonLoggingOptOut(true);
    discoveryService.federatedQuery(builder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(Q2_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
  }

  @Test
  public void federatedQueryNoticesIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(queryNoticesResp));
    FederatedQueryNoticesOptions.Builder builder =
        new FederatedQueryNoticesOptions.Builder(
            environmentId, new ArrayList<>(Arrays.asList(collectionId)));
    discoveryService.federatedQueryNotices(builder.build()).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(Q3_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
  }

  @Test
  public void createExpansionsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(expansionsResp));

    List<String> expansion1InputTerms = Arrays.asList("weekday", "week day");
    List<String> expansion1ExpandedTerms =
        Arrays.asList("monday", "tuesday", "wednesday", "thursday", "friday");
    List<String> expansion2InputTerms = Arrays.asList("weekend", "week end");
    List<String> expansion2ExpandedTerms = Arrays.asList("saturday", "sunday");
    Expansion expansion1 =
        new Expansion.Builder()
            .inputTerms(expansion1InputTerms)
            .expandedTerms(expansion1ExpandedTerms)
            .build();
    Expansion expansion2 =
        new Expansion.Builder()
            .inputTerms(expansion2InputTerms)
            .expandedTerms(expansion2ExpandedTerms)
            .build();
    Expansions expansions =
        new Expansions.Builder().expansions(Arrays.asList(expansion1, expansion2)).build();

    CreateExpansionsOptions createOptions =
        new CreateExpansionsOptions.Builder()
            .environmentId(environmentId)
            .collectionId(collectionId)
            .expansions(expansions)
            .build();
    Expansions createResults =
        discoveryService.createExpansions(createOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(EXPANSIONS_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(expansion1, createResults.expansions().get(0));
    assertEquals(expansion2, createResults.expansions().get(1));
  }

  @Test
  public void listExpansionsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(expansionsResp));

    List<String> expansion1InputTerms = Arrays.asList("weekday", "week day");
    List<String> expansion1ExpandedTerms =
        Arrays.asList("monday", "tuesday", "wednesday", "thursday", "friday");
    List<String> expansion2InputTerms = Arrays.asList("weekend", "week end");
    List<String> expansion2ExpandedTerms = Arrays.asList("saturday", "sunday");
    Expansion expansion1 =
        new Expansion.Builder()
            .inputTerms(expansion1InputTerms)
            .expandedTerms(expansion1ExpandedTerms)
            .build();
    Expansion expansion2 =
        new Expansion.Builder()
            .inputTerms(expansion2InputTerms)
            .expandedTerms(expansion2ExpandedTerms)
            .build();

    ListExpansionsOptions listOptions =
        new ListExpansionsOptions.Builder()
            .environmentId(environmentId)
            .collectionId(collectionId)
            .build();
    Expansions listResults = discoveryService.listExpansions(listOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(EXPANSIONS_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(expansion1, listResults.expansions().get(0));
    assertEquals(expansion2, listResults.expansions().get(1));
  }

  @Test
  public void deleteExpansionsIsSuccessful() throws InterruptedException {
    MockResponse desiredResponse = new MockResponse().setResponseCode(200);
    server.enqueue(desiredResponse);

    DeleteExpansionsOptions deleteOptions =
        new DeleteExpansionsOptions.Builder()
            .environmentId(environmentId)
            .collectionId(collectionId)
            .build();
    discoveryService.deleteExpansions(deleteOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(EXPANSIONS_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
  }

  @Test
  public void deleteUserDataIsSuccessful() throws InterruptedException {
    MockResponse desiredResponse = new MockResponse().setResponseCode(200);
    server.enqueue(desiredResponse);

    String customerId = "java_sdk_test_id";

    DeleteUserDataOptions deleteOptions =
        new DeleteUserDataOptions.Builder().customerId(customerId).build();
    discoveryService.deleteUserData(deleteOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(DELETE_USER_DATA_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
  }

  @Test
  public void testCredentialDetails() {
    String clientId = "client_id";
    String clientSecret = "client_secret"; // pragma: whitelist secret
    String enterpriseId = "enterprise_id";
    String organizationUrl = "organization_url";
    String passphrase = "passphrase";
    String password = "password"; // pragma: whitelist secret
    String privateKey = "private_key";
    String publicKeyId = "public_key_id";
    String siteCollectionPath = "site_collection_path";
    String url = "url";
    String username = "username";
    String gatewayId = "gateway_id";
    String sourceVersion = "source_version";
    String webApplicationUrl = "web_application_url";
    String domain = "domain";
    String endpoint = "endpoint";
    String accessKeyId = "access_key";
    String secretAccessKey = "secret_access_key";

    CredentialDetails details =
        new CredentialDetails.Builder()
            .clientId(clientId)
            .clientSecret(clientSecret)
            .credentialType(CredentialDetails.CredentialType.USERNAME_PASSWORD)
            .enterpriseId(enterpriseId)
            .organizationUrl(organizationUrl)
            .passphrase(passphrase)
            .password(password)
            .privateKey(privateKey)
            .publicKeyId(publicKeyId)
            .siteCollectionPath(siteCollectionPath)
            .url(url)
            .username(username)
            .gatewayId(gatewayId)
            .sourceVersion(sourceVersion)
            .webApplicationUrl(webApplicationUrl)
            .domain(domain)
            .endpoint(endpoint)
            .accessKeyId(accessKeyId)
            .secretAccessKey(secretAccessKey)
            .build();

    assertEquals(clientId, details.clientId());
    assertEquals(clientSecret, details.clientSecret());
    assertEquals(CredentialDetails.CredentialType.USERNAME_PASSWORD, details.credentialType());
    assertEquals(enterpriseId, details.enterpriseId());
    assertEquals(organizationUrl, details.organizationUrl());
    assertEquals(passphrase, details.passphrase());
    assertEquals(password, details.password());
    assertEquals(privateKey, details.privateKey());
    assertEquals(publicKeyId, details.publicKeyId());
    assertEquals(siteCollectionPath, details.siteCollectionPath());
    assertEquals(url, details.url());
    assertEquals(username, details.username());
    assertEquals(gatewayId, details.gatewayId());
    assertEquals(sourceVersion, details.sourceVersion());
    assertEquals(webApplicationUrl, details.webApplicationUrl());
    assertEquals(domain, details.domain());
    assertEquals(accessKeyId, details.accessKeyId());
    assertEquals(secretAccessKey, details.secretAccessKey());
  }

  @Test
  public void createCredentialsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(credentialsResp));

    CredentialDetails details =
        new CredentialDetails.Builder()
            .credentialType(CredentialDetails.CredentialType.USERNAME_PASSWORD)
            .url("url")
            .username("username")
            .build();
    Credentials credentials =
        new Credentials.Builder()
            .sourceType(Credentials.SourceType.SALESFORCE)
            .credentialDetails(details)
            .build();

    CreateCredentialsOptions options =
        new CreateCredentialsOptions.Builder()
            .environmentId(environmentId)
            .sourceType(Credentials.SourceType.SALESFORCE)
            .credentials(credentials)
            .credentialDetails(details)
            .build();
    Credentials credentialsResponse =
        discoveryService.createCredentials(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(CREATE_CREDENTIALS_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(credentialsResp, credentialsResponse);
    assertEquals(credentialsResp.credentialDetails(), credentialsResponse.credentialDetails());
  }

  @Test
  public void deleteCredentialsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(deleteCredentialsResp));

    DeleteCredentialsOptions options =
        new DeleteCredentialsOptions.Builder()
            .environmentId(environmentId)
            .credentialId("credential_id")
            .build();
    DeleteCredentials response = discoveryService.deleteCredentials(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(DELETE_CREDENTIALS_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
    assertEquals(deleteCredentialsResp.getCredentialId(), response.getCredentialId());
    assertEquals(deleteCredentialsResp.getStatus(), response.getStatus());
  }

  @Test
  public void getCredentialsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(credentialsResp));

    GetCredentialsOptions options =
        new GetCredentialsOptions.Builder()
            .environmentId(environmentId)
            .credentialId("credential_id")
            .build();
    Credentials credentialsResponse =
        discoveryService.getCredentials(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET_CREDENTIALS_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(credentialsResp, credentialsResponse);
  }

  @Test
  public void listCredentialsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(listCredentialsResp));

    ListCredentialsOptions options =
        new ListCredentialsOptions.Builder().environmentId(environmentId).build();
    CredentialsList response = discoveryService.listCredentials(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(LIST_CREDENTIALS_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(listCredentialsResp, response);
    assertTrue(response.getCredentials().size() == 3);
  }

  @Test
  public void updateCredentialsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(credentialsResp));

    CredentialDetails newDetails =
        new CredentialDetails.Builder()
            .clientId("new_client_id")
            .clientSecret("new_client_secret")
            .credentialType(CredentialDetails.CredentialType.USERNAME_PASSWORD)
            .enterpriseId("new_enterprise_id")
            .organizationUrl("new_organization_url")
            .passphrase("new_passphrase")
            .password("new_password")
            .privateKey("new_private_key")
            .publicKeyId("new_public_key_id")
            .siteCollectionPath("new_site_collection_path")
            .url("new_url")
            .username("new_username")
            .build();
    Credentials newCredentials =
        new Credentials.Builder()
            .sourceType(Credentials.SourceType.SALESFORCE)
            .credentialDetails(newDetails)
            .build();

    UpdateCredentialsOptions options =
        new UpdateCredentialsOptions.Builder()
            .environmentId(environmentId)
            .credentialId("new_credential_id")
            .sourceType(Credentials.SourceType.SALESFORCE)
            .credentials(newCredentials)
            .credentialDetails(newDetails)
            .build();
    Credentials response = discoveryService.updateCredentials(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(UPDATE_CREDENTIALS_PATH, request.getPath());
    assertEquals(PUT, request.getMethod());
    assertEquals(credentialsResp, response);
  }

  @Test
  public void createEventIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createEventResp));

    Long displayRank = 1L;
    String sessionToken = "mock_session_token";

    EventData eventData =
        new EventData.Builder()
            .environmentId(environmentId)
            .collectionId(collectionId)
            .documentId(documentId)
            .displayRank(displayRank)
            .sessionToken(sessionToken)
            .clientTimestamp(date)
            .build();
    CreateEventOptions createEventOptions =
        new CreateEventOptions.Builder()
            .type(CreateEventOptions.Type.CLICK)
            .data(eventData)
            .build();

    CreateEventResponse response =
        discoveryService.createEvent(createEventOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(CREATE_EVENT_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(CreateEventOptions.Type.CLICK, response.getType());
    assertEquals(environmentId, response.getData().environmentId());
    assertEquals(collectionId, response.getData().collectionId());
    assertEquals(documentId, response.getData().documentId());
    assertNotNull(response.getData().clientTimestamp());
    assertEquals(displayRank, response.getData().displayRank());
    assertEquals(queryId, response.getData().queryId());
    assertEquals(sessionToken, response.getData().sessionToken());
  }

  @Test
  public void getMetricsEventRateIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(metricResp));

    String interval = "1d";
    Long key = 1533513600000L;
    Double eventRate = 0.0;

    GetMetricsEventRateOptions options =
        new GetMetricsEventRateOptions.Builder()
            .startTime(date)
            .endTime(date)
            .resultType(GetMetricsEventRateOptions.ResultType.DOCUMENT)
            .build();

    MetricResponse response = discoveryService.getMetricsEventRate(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET, request.getMethod());
    assertTrue(!response.getAggregations().isEmpty());
    assertEquals(interval, response.getAggregations().get(0).getInterval());
    assertEquals(CreateEventOptions.Type.CLICK, response.getAggregations().get(0).getEventType());
    assertTrue(!response.getAggregations().get(0).getResults().isEmpty());
    assertEquals(key, response.getAggregations().get(0).getResults().get(0).getKey());
    assertNotNull(response.getAggregations().get(0).getResults().get(0).getKeyAsString());
    assertEquals(eventRate, response.getAggregations().get(0).getResults().get(0).getEventRate());
  }

  @Test
  public void getMetricsEventRateNoArgsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(metricResp));

    String interval = "1d";
    Long key = 1533513600000L;
    Double eventRate = 0.0;

    MetricResponse response = discoveryService.getMetricsEventRate().execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET_METRICS_EVENT_RATE_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertTrue(!response.getAggregations().isEmpty());
    assertEquals(interval, response.getAggregations().get(0).getInterval());
    assertEquals(CreateEventOptions.Type.CLICK, response.getAggregations().get(0).getEventType());
    assertTrue(!response.getAggregations().get(0).getResults().isEmpty());
    assertEquals(key, response.getAggregations().get(0).getResults().get(0).getKey());
    assertNotNull(response.getAggregations().get(0).getResults().get(0).getKeyAsString());
    assertEquals(eventRate, response.getAggregations().get(0).getResults().get(0).getEventRate());
  }

  @Test
  public void getMetricsQueryIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(metricResp));

    String interval = "1d";
    Long key = 1533513600000L;
    Double eventRate = 0.0;

    GetMetricsQueryOptions options =
        new GetMetricsQueryOptions.Builder()
            .startTime(date)
            .endTime(date)
            .resultType(GetMetricsQueryOptions.ResultType.DOCUMENT)
            .build();

    MetricResponse response = discoveryService.getMetricsQuery(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET, request.getMethod());
    assertTrue(!response.getAggregations().isEmpty());
    assertEquals(interval, response.getAggregations().get(0).getInterval());
    assertEquals(CreateEventOptions.Type.CLICK, response.getAggregations().get(0).getEventType());
    assertTrue(!response.getAggregations().get(0).getResults().isEmpty());
    assertEquals(key, response.getAggregations().get(0).getResults().get(0).getKey());
    assertNotNull(response.getAggregations().get(0).getResults().get(0).getKeyAsString());
    assertEquals(eventRate, response.getAggregations().get(0).getResults().get(0).getEventRate());
  }

  @Test
  public void getMetricsQueryNoArgsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(metricResp));

    String interval = "1d";
    Long key = 1533513600000L;
    Double eventRate = 0.0;

    MetricResponse response = discoveryService.getMetricsQuery().execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET_METRICS_QUERY_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertTrue(!response.getAggregations().isEmpty());
    assertEquals(interval, response.getAggregations().get(0).getInterval());
    assertEquals(CreateEventOptions.Type.CLICK, response.getAggregations().get(0).getEventType());
    assertTrue(!response.getAggregations().get(0).getResults().isEmpty());
    assertEquals(key, response.getAggregations().get(0).getResults().get(0).getKey());
    assertNotNull(response.getAggregations().get(0).getResults().get(0).getKeyAsString());
    assertEquals(eventRate, response.getAggregations().get(0).getResults().get(0).getEventRate());
  }

  @Test
  public void getMetricsQueryEventIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(metricResp));

    String interval = "1d";
    Long key = 1533513600000L;
    Double eventRate = 0.0;

    GetMetricsQueryEventOptions options =
        new GetMetricsQueryEventOptions.Builder()
            .startTime(date)
            .endTime(date)
            .resultType(GetMetricsQueryEventOptions.ResultType.DOCUMENT)
            .build();

    MetricResponse response = discoveryService.getMetricsQueryEvent(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET, request.getMethod());
    assertTrue(!response.getAggregations().isEmpty());
    assertEquals(interval, response.getAggregations().get(0).getInterval());
    assertEquals(CreateEventOptions.Type.CLICK, response.getAggregations().get(0).getEventType());
    assertTrue(!response.getAggregations().get(0).getResults().isEmpty());
    assertEquals(key, response.getAggregations().get(0).getResults().get(0).getKey());
    assertNotNull(response.getAggregations().get(0).getResults().get(0).getKeyAsString());
    assertEquals(eventRate, response.getAggregations().get(0).getResults().get(0).getEventRate());
  }

  @Test
  public void getMetricsQueryEventNoArgsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(metricResp));

    String interval = "1d";
    Long key = 1533513600000L;
    Double eventRate = 0.0;

    MetricResponse response = discoveryService.getMetricsQueryEvent().execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET_METRICS_QUERY_EVENT_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertTrue(!response.getAggregations().isEmpty());
    assertEquals(interval, response.getAggregations().get(0).getInterval());
    assertEquals(CreateEventOptions.Type.CLICK, response.getAggregations().get(0).getEventType());
    assertTrue(!response.getAggregations().get(0).getResults().isEmpty());
    assertEquals(key, response.getAggregations().get(0).getResults().get(0).getKey());
    assertNotNull(response.getAggregations().get(0).getResults().get(0).getKeyAsString());
    assertEquals(eventRate, response.getAggregations().get(0).getResults().get(0).getEventRate());
  }

  @Test
  public void getMetricsQueryNoResultsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(metricResp));

    String interval = "1d";
    Long key = 1533513600000L;
    Double eventRate = 0.0;

    GetMetricsQueryNoResultsOptions options =
        new GetMetricsQueryNoResultsOptions.Builder()
            .startTime(date)
            .endTime(date)
            .resultType(GetMetricsQueryEventOptions.ResultType.DOCUMENT)
            .build();

    MetricResponse response =
        discoveryService.getMetricsQueryNoResults(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET, request.getMethod());
    assertTrue(!response.getAggregations().isEmpty());
    assertEquals(interval, response.getAggregations().get(0).getInterval());
    assertEquals(CreateEventOptions.Type.CLICK, response.getAggregations().get(0).getEventType());
    assertTrue(!response.getAggregations().get(0).getResults().isEmpty());
    assertEquals(key, response.getAggregations().get(0).getResults().get(0).getKey());
    assertNotNull(response.getAggregations().get(0).getResults().get(0).getKeyAsString());
    assertEquals(eventRate, response.getAggregations().get(0).getResults().get(0).getEventRate());
  }

  @Test
  public void getMetricsQueryNoResultsNoArgsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(metricResp));

    String interval = "1d";
    Long key = 1533513600000L;
    Double eventRate = 0.0;

    MetricResponse response = discoveryService.getMetricsQueryNoResults().execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET_METRICS_QUERY_NO_RESULTS_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertTrue(!response.getAggregations().isEmpty());
    assertEquals(interval, response.getAggregations().get(0).getInterval());
    assertEquals(CreateEventOptions.Type.CLICK, response.getAggregations().get(0).getEventType());
    assertTrue(!response.getAggregations().get(0).getResults().isEmpty());
    assertEquals(key, response.getAggregations().get(0).getResults().get(0).getKey());
    assertNotNull(response.getAggregations().get(0).getResults().get(0).getKeyAsString());
    assertEquals(eventRate, response.getAggregations().get(0).getResults().get(0).getEventRate());
  }

  @Test
  public void getMetricsQueryTokenEventIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(metricTokenResp));

    Long count = 10L;
    String key = "beat";
    Long matchingResults = 117L;
    Double eventRate = 0.0;

    GetMetricsQueryTokenEventOptions options =
        new GetMetricsQueryTokenEventOptions.Builder().count(count).build();

    MetricTokenResponse response =
        discoveryService.getMetricsQueryTokenEvent(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET, request.getMethod());
    assertTrue(!response.getAggregations().isEmpty());
    assertEquals(CreateEventOptions.Type.CLICK, response.getAggregations().get(0).getEventType());
    assertTrue(!response.getAggregations().get(0).getResults().isEmpty());
    assertEquals(key, response.getAggregations().get(0).getResults().get(0).getKey());
    assertEquals(
        matchingResults,
        response.getAggregations().get(0).getResults().get(0).getMatchingResults());
    assertEquals(eventRate, response.getAggregations().get(0).getResults().get(0).getEventRate());
  }

  @Test
  public void getMetricsQueryTokenEventNoArgsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(metricTokenResp));

    String key = "beat";
    Long matchingResults = 117L;
    Double eventRate = 0.0;

    MetricTokenResponse response =
        discoveryService.getMetricsQueryTokenEvent().execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET_METRICS_QUERY_TOKEN_EVENT_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertTrue(!response.getAggregations().isEmpty());
    assertEquals(CreateEventOptions.Type.CLICK, response.getAggregations().get(0).getEventType());
    assertTrue(!response.getAggregations().get(0).getResults().isEmpty());
    assertEquals(key, response.getAggregations().get(0).getResults().get(0).getKey());
    assertEquals(
        matchingResults,
        response.getAggregations().get(0).getResults().get(0).getMatchingResults());
    assertEquals(eventRate, response.getAggregations().get(0).getResults().get(0).getEventRate());
  }

  @Test
  public void queryLogIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(logQueryResp));

    List<String> sortList = new ArrayList<>();
    sortList.add("field_a");
    String extraSort = "field_b";
    String filter = "filter";
    String naturalLanguageQuery = "Who beat Ken Jennings in Jeopardy!";
    Long count = 5L;
    Long offset = 5L;
    Long matchingResults = 2L;
    String customerId = "";
    String sessionToken = "mock_session_token";
    String eventType = "query";
    Long resultCount = 0L;

    QueryLogOptions options =
        new QueryLogOptions.Builder()
            .sort(sortList)
            .addSort(extraSort)
            .count(count)
            .filter(filter)
            .offset(offset)
            .query(naturalLanguageQuery)
            .build();

    LogQueryResponse response = discoveryService.queryLog(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET, request.getMethod());
    assertEquals(matchingResults, response.getMatchingResults());
    assertTrue(!response.getResults().isEmpty());
    assertEquals(environmentId, response.getResults().get(0).getEnvironmentId());
    assertEquals(customerId, response.getResults().get(0).getCustomerId());
    assertNotNull(response.getResults().get(0).getCreatedTimestamp());
    assertEquals(queryId, response.getResults().get(0).getQueryId());
    assertEquals(sessionToken, response.getResults().get(0).getSessionToken());
    assertEquals(eventType, response.getResults().get(0).getEventType());
    assertNotNull(response.getResults().get(0).getDocumentResults().getResults());
    assertEquals(resultCount, response.getResults().get(0).getDocumentResults().getCount());
  }

  @Test
  public void queryLogNoArgsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(logQueryResp));

    List<String> sortList = new ArrayList<>();
    sortList.add("field_a");
    Long matchingResults = 2L;
    String customerId = "";
    String sessionToken = "mock_session_token";
    String eventType = "query";
    Long resultCount = 0L;

    LogQueryResponse response = discoveryService.queryLog().execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(QUERY_LOG_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(matchingResults, response.getMatchingResults());
    assertTrue(!response.getResults().isEmpty());
    assertEquals(environmentId, response.getResults().get(0).getEnvironmentId());
    assertEquals(customerId, response.getResults().get(0).getCustomerId());
    assertNotNull(response.getResults().get(0).getCreatedTimestamp());
    assertEquals(queryId, response.getResults().get(0).getQueryId());
    assertEquals(sessionToken, response.getResults().get(0).getSessionToken());
    assertEquals(eventType, response.getResults().get(0).getEventType());
    assertNotNull(response.getResults().get(0).getDocumentResults().getResults());
    assertEquals(resultCount, response.getResults().get(0).getDocumentResults().getCount());
  }

  @Test
  public void testTokenDictRule() {
    String text = "text";
    String partOfSpeech = "noun";
    List<String> readings = Arrays.asList("reading 1", "reading 2");
    List<String> tokens = Arrays.asList("token 1", "token 2");

    TokenDictRule tokenDictRule =
        new TokenDictRule.Builder()
            .text(text)
            .partOfSpeech(partOfSpeech)
            .readings(readings)
            .tokens(tokens)
            .build();

    assertEquals(text, tokenDictRule.text());
    assertEquals(partOfSpeech, tokenDictRule.partOfSpeech());
    assertEquals(readings, tokenDictRule.readings());
    assertEquals(tokens, tokenDictRule.tokens());
  }

  @Test
  public void testCreateTokenizationDictionaryOptions() {
    String text = "text";
    String partOfSpeech = "noun";
    List<String> tokens = Arrays.asList("token 1", "token 2");

    TokenDictRule firstTokenDictRule =
        new TokenDictRule.Builder().text(text).partOfSpeech(partOfSpeech).tokens(tokens).build();
    TokenDictRule secondTokenDictRule =
        new TokenDictRule.Builder().text(text).partOfSpeech(partOfSpeech).tokens(tokens).build();
    List<TokenDictRule> tokenDictRuleList = new ArrayList<>();
    tokenDictRuleList.add(firstTokenDictRule);

    CreateTokenizationDictionaryOptions createOptions =
        new CreateTokenizationDictionaryOptions.Builder()
            .environmentId(environmentId)
            .collectionId(collectionId)
            .tokenizationRules(tokenDictRuleList)
            .addTokenizationRules(secondTokenDictRule)
            .build();

    tokenDictRuleList.add(secondTokenDictRule);

    assertEquals(environmentId, createOptions.environmentId());
    assertEquals(collectionId, createOptions.collectionId());
    assertEquals(tokenDictRuleList, createOptions.tokenizationRules());
  }

  @Test
  public void testGetTokenizationDictionaryStatusOptions() {
    GetTokenizationDictionaryStatusOptions getOptions =
        new GetTokenizationDictionaryStatusOptions.Builder()
            .environmentId(environmentId)
            .collectionId(collectionId)
            .build();

    assertEquals(environmentId, getOptions.environmentId());
    assertEquals(collectionId, getOptions.collectionId());
  }

  @Test
  public void testDeleteTokenizationDictionaryOptions() {
    DeleteTokenizationDictionaryOptions deleteOptions =
        new DeleteTokenizationDictionaryOptions.Builder()
            .environmentId(environmentId)
            .collectionId(collectionId)
            .build();

    assertEquals(environmentId, deleteOptions.environmentId());
    assertEquals(collectionId, deleteOptions.collectionId());
  }

  @Test
  public void testCreateTokenizationDictionary() throws InterruptedException {
    server.enqueue(jsonResponse(tokenDictStatusResponse));

    String text = "text";
    String partOfSpeech = "noun";
    List<String> tokens = Arrays.asList("token 1", "token 2");
    TokenDictRule tokenDictRule =
        new TokenDictRule.Builder().text(text).tokens(tokens).partOfSpeech(partOfSpeech).build();
    CreateTokenizationDictionaryOptions createOptions =
        new CreateTokenizationDictionaryOptions.Builder()
            .environmentId(environmentId)
            .collectionId(collectionId)
            .tokenizationRules(Collections.singletonList(tokenDictRule))
            .build();
    TokenDictStatusResponse response =
        discoveryService.createTokenizationDictionary(createOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(POST, request.getMethod());
    assertEquals(tokenDictStatusResponse, response);
  }

  @Test
  public void testGetTokenizationDictionaryStatus() throws InterruptedException {
    server.enqueue(jsonResponse(tokenDictStatusResponse));

    GetTokenizationDictionaryStatusOptions getOptions =
        new GetTokenizationDictionaryStatusOptions.Builder()
            .environmentId(environmentId)
            .collectionId(collectionId)
            .build();
    TokenDictStatusResponse response =
        discoveryService.getTokenizationDictionaryStatus(getOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET, request.getMethod());
    assertEquals(tokenDictStatusResponse, response);
  }

  @Test
  public void testDeleteTokenizationDictionary() throws InterruptedException {
    MockResponse desiredResponse = new MockResponse().setResponseCode(200);
    server.enqueue(desiredResponse);

    DeleteTokenizationDictionaryOptions deleteOptions =
        new DeleteTokenizationDictionaryOptions.Builder()
            .environmentId(environmentId)
            .collectionId(collectionId)
            .build();
    discoveryService.deleteTokenizationDictionary(deleteOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(DELETE, request.getMethod());
  }

  @Test
  public void testCreateStopwordListOptions() {
    String testFilename = "test_filename";

    CreateStopwordListOptions createStopwordListOptions =
        new CreateStopwordListOptions.Builder()
            .environmentId(environmentId)
            .collectionId(collectionId)
            .stopwordFile(testStream)
            .stopwordFilename(testFilename)
            .build();

    assertEquals(environmentId, createStopwordListOptions.environmentId());
    assertEquals(collectionId, createStopwordListOptions.collectionId());
    assertEquals(testStream, createStopwordListOptions.stopwordFile());
    assertEquals(testFilename, createStopwordListOptions.stopwordFilename());
  }

  @Test
  public void testCreateStopwordList() throws InterruptedException {
    server.enqueue(jsonResponse(tokenDictStatusResponse));

    String testFilename = "test_filename";

    CreateStopwordListOptions createStopwordListOptions =
        new CreateStopwordListOptions.Builder()
            .environmentId(environmentId)
            .collectionId(collectionId)
            .stopwordFile(testStream)
            .stopwordFilename(testFilename)
            .build();
    TokenDictStatusResponse response =
        discoveryService.createStopwordList(createStopwordListOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(POST, request.getMethod());
    assertEquals(tokenDictStatusResponse, response);
  }

  @Test
  public void testDeleteStopwordListOptions() {
    DeleteStopwordListOptions deleteStopwordListOptions =
        new DeleteStopwordListOptions.Builder()
            .environmentId(environmentId)
            .collectionId(collectionId)
            .build();

    assertEquals(environmentId, deleteStopwordListOptions.environmentId());
    assertEquals(collectionId, deleteStopwordListOptions.collectionId());
  }

  @Test
  public void testDeleteStopwordList() throws InterruptedException {
    MockResponse desiredResponse = new MockResponse().setResponseCode(200);
    server.enqueue(desiredResponse);

    DeleteStopwordListOptions deleteStopwordListOptions =
        new DeleteStopwordListOptions.Builder()
            .environmentId(environmentId)
            .collectionId(collectionId)
            .build();
    discoveryService.deleteStopwordList(deleteStopwordListOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(DELETE, request.getMethod());
  }

  @Test
  public void testGetStopwordListStatusOptions() {
    GetStopwordListStatusOptions getStopwordListStatusOptions =
        new GetStopwordListStatusOptions.Builder()
            .environmentId(environmentId)
            .collectionId(collectionId)
            .build();

    assertEquals(environmentId, getStopwordListStatusOptions.environmentId());
    assertEquals(collectionId, getStopwordListStatusOptions.collectionId());
  }

  @Test
  public void testGetStopwordListStatus() throws InterruptedException {
    server.enqueue(jsonResponse(tokenDictStatusResponseStopwords));

    String type = "stopwords";

    GetStopwordListStatusOptions getStopwordListStatusOptions =
        new GetStopwordListStatusOptions.Builder()
            .environmentId(environmentId)
            .collectionId(collectionId)
            .build();
    TokenDictStatusResponse response =
        discoveryService.getStopwordListStatus(getStopwordListStatusOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET, request.getMethod());
    assertEquals(TokenDictStatusResponse.Status.ACTIVE, response.getStatus());
    assertEquals(type, response.getType());
  }

  @Test
  public void testCreateGatewayOptions() {
    String name = "name";

    CreateGatewayOptions createGatewayOptions =
        new CreateGatewayOptions.Builder().environmentId(environmentId).name(name).build();

    assertEquals(environmentId, createGatewayOptions.environmentId());
    assertEquals(name, createGatewayOptions.name());
  }

  @Test
  public void testCreateGateway() throws InterruptedException {
    server.enqueue(jsonResponse(gatewayResponse));

    String name = "name";

    CreateGatewayOptions createGatewayOptions =
        new CreateGatewayOptions.Builder().environmentId(environmentId).name(name).build();
    Gateway response = discoveryService.createGateway(createGatewayOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(POST, request.getMethod());
    assertEquals(gatewayResponse, response);
  }

  @Test
  public void testDeleteGatewayOptions() {
    String gatewayId = "gateway_id";

    DeleteGatewayOptions deleteGatewayOptions =
        new DeleteGatewayOptions.Builder()
            .environmentId(environmentId)
            .gatewayId(gatewayId)
            .build();

    assertEquals(environmentId, deleteGatewayOptions.environmentId());
    assertEquals(gatewayId, deleteGatewayOptions.gatewayId());
  }

  @Test
  public void testDeleteGateway() throws InterruptedException {
    server.enqueue(jsonResponse(deleteGatewayResponse));

    String gatewayId = "gateway_id";

    DeleteGatewayOptions deleteGatewayOptions =
        new DeleteGatewayOptions.Builder()
            .environmentId(environmentId)
            .gatewayId(gatewayId)
            .build();
    GatewayDelete response =
        discoveryService.deleteGateway(deleteGatewayOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(DELETE, request.getMethod());
    assertEquals(deleteGatewayResponse.getGatewayId(), response.getGatewayId());
    assertEquals(deleteGatewayResponse.getStatus(), response.getStatus());
  }

  @Test
  public void testGetGatewayOptions() {
    String gatewayId = "gateway_id";

    GetGatewayOptions getGatewayOptions =
        new GetGatewayOptions.Builder().environmentId(environmentId).gatewayId(gatewayId).build();

    assertEquals(environmentId, getGatewayOptions.environmentId());
    assertEquals(gatewayId, getGatewayOptions.gatewayId());
  }

  @Test
  public void testGetGateway() throws InterruptedException {
    server.enqueue(jsonResponse(gatewayResponse));

    String gatewayId = "gateway_id";

    GetGatewayOptions getGatewayOptions =
        new GetGatewayOptions.Builder().environmentId(environmentId).gatewayId(gatewayId).build();
    Gateway response = discoveryService.getGateway(getGatewayOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET, request.getMethod());
    assertEquals(gatewayResponse, response);
  }

  @Test
  public void testListGatewaysOptions() {
    ListGatewaysOptions listGatewaysOptions =
        new ListGatewaysOptions.Builder().environmentId(environmentId).build();

    assertEquals(environmentId, listGatewaysOptions.environmentId());
  }

  @Test
  public void testListGateways() throws InterruptedException {
    server.enqueue(jsonResponse(listGatewaysResponse));

    ListGatewaysOptions listGatewaysOptions =
        new ListGatewaysOptions.Builder().environmentId(environmentId).build();
    GatewayList response = discoveryService.listGateways(listGatewaysOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET, request.getMethod());
    assertEquals(listGatewaysResponse, response);
  }

  @Test
  public void testSourceOptionsWebCrawl() {
    String url = "url";
    String crawlSpeed = "crawl_speed";
    Long maximumHops = 1L;
    Long requestTimeout = 2000L;

    SourceOptionsWebCrawl sourceOptionsWebCrawl =
        new SourceOptionsWebCrawl.Builder()
            .url(url)
            .limitToStartingHosts(true)
            .crawlSpeed(crawlSpeed)
            .allowUntrustedCertificate(true)
            .maximumHops(maximumHops)
            .requestTimeout(requestTimeout)
            .overrideRobotsTxt(true)
            .build();

    assertEquals(url, sourceOptionsWebCrawl.url());
    assertTrue(sourceOptionsWebCrawl.limitToStartingHosts());
    assertEquals(crawlSpeed, sourceOptionsWebCrawl.crawlSpeed());
    assertTrue(sourceOptionsWebCrawl.allowUntrustedCertificate());
    assertEquals(maximumHops, sourceOptionsWebCrawl.maximumHops());
    assertEquals(requestTimeout, sourceOptionsWebCrawl.requestTimeout());
    assertTrue(sourceOptionsWebCrawl.overrideRobotsTxt());
  }
}

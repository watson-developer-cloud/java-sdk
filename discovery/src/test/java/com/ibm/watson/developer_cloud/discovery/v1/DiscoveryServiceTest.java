/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
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

package com.ibm.watson.developer_cloud.discovery.v1;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.discovery.v1.model.AddDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.AddTrainingDataOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.Collection;
import com.ibm.watson.developer_cloud.discovery.v1.model.Configuration;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateCollectionOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateTrainingExampleOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteAllTrainingDataOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteCollectionOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteTrainingDataOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteTrainingExampleOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DocumentAccepted;
import com.ibm.watson.developer_cloud.discovery.v1.model.DocumentStatus;
import com.ibm.watson.developer_cloud.discovery.v1.model.Environment;
import com.ibm.watson.developer_cloud.discovery.v1.model.FederatedQueryNoticesOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.FederatedQueryOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetCollectionOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetDocumentStatusOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetTrainingDataOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetTrainingExampleOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionFieldsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionFieldsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListConfigurationsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListConfigurationsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListEnvironmentsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListFieldsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListTrainingDataOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListTrainingExamplesOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryNoticesOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryNoticesResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.TrainingDataSet;
import com.ibm.watson.developer_cloud.discovery.v1.model.TrainingExample;
import com.ibm.watson.developer_cloud.discovery.v1.model.TrainingExampleList;
import com.ibm.watson.developer_cloud.discovery.v1.model.TrainingQuery;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateTrainingExampleOptions;
import com.ibm.watson.developer_cloud.discovery.v1.query.AggregationType;
import com.ibm.watson.developer_cloud.discovery.v1.query.Operator;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for {@link Discovery}.
 */
public class DiscoveryServiceTest extends WatsonServiceUnitTest {
  private Discovery discoveryService;

  private static final Long THREE = 3L;
  private static final String VERSION = Discovery.VERSION_DATE_2017_09_01;

  private static final String DISCOVERY_TEST_CONFIG_FILE = "src/test/resources/discovery/test-config.json";
  private static final String RESOURCE = "src/test/resources/discovery/";
  private static final String ENV1_PATH = "/v1/environments/mock_envid?version=" + VERSION;
  private static final String ENV2_PATH = "/v1/environments?version=" + VERSION;
  private static final String CONF1_PATH = "/v1/environments/mock_envid/configurations?version=" + VERSION;
  private static final String CONF2_PATH = "/v1/environments/mock_envid/configurations/mock_confid?version=" + VERSION;
  private static final String COLL1_PATH = "/v1/environments/mock_envid/collections?version=" + VERSION;
  private static final String COLL2_PATH = "/v1/environments/mock_envid/collections/mock_collid?version=" + VERSION;
  private static final String COLL3_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/fields?version=" + VERSION;
  private static final String DOCS1_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/documents?version=" + VERSION;
  private static final String DOCS2_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/documents/mock_docid?version=" + VERSION;
  private static final String Q1_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/query?version="
          + VERSION
          + "&filter=field:1"
          + "&query=field:1&count=5&return=field&offset=5";
  private static final String Q2_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/query?version="
          + VERSION
          + "&aggregation=term(field)";
  private static final String Q3_PATH = "/v1/environments/mock_envid/query?version="
      + VERSION + "&collection_ids=mock_collid";
  private static final String Q4_PATH = "/v1/environments/mock_envid/notices?version="
      + VERSION + "&collection_ids=mock_collid";
  private static final String Q5_PATH = "/v1/environments/mock_envid/collections/mock_collid/notices?version="
      + VERSION;
  private static final String TRAINING1_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/training_data?version=" + VERSION;
  private static final String TRAINING2_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/training_data/mock_queryid/examples?version=" + VERSION;
  private static final String TRAINING3_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/training_data/mock_queryid?version=" + VERSION;
  private static final String TRAINING4_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/training_data/mock_queryid/examples/mock_docid?version="
          + VERSION;
  private static final String FIELD_PATH = "/v1/environments/mock_envid/fields?version="
      + VERSION + "&collection_ids=mock_collid";

  private String environmentId;
  private String environmentName;
  private String environmentDesc;
  private String uniqueConfigName;
  private String configurationId;
  private String uniqueCollectionName;
  private String collectionId;
  private String documentId;
  private String queryId;

  private Environment envResp;
  private ListEnvironmentsResponse envsResp;
  private Environment createEnvResp;
  private Map<String, Object> deleteEnvResp;
  private Environment updateEnvResp;
  private Configuration createConfResp;
  private ListConfigurationsResponse getConfsResp;
  private Configuration getConfResp;
  private Map<String, Object> deleteConfResp;
  private Configuration updateConfResp;
  private Collection createCollResp;
  private ListCollectionsResponse getCollsResp;
  private Collection getCollResp;
  private Map<String, Object> deleteCollResp;
  private ListCollectionFieldsResponse listfieldsCollResp;
  private DocumentAccepted createDocResp;
  private DocumentAccepted updateDocResp;
  private DocumentStatus getDocResp;
  private Map<String, Object> deleteDocResp;
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

  @BeforeClass
  public static void setupClass() {
  }

  @Before
  public void setup() throws Exception {
    super.setUp();
    discoveryService = new Discovery(Discovery.VERSION_DATE_2017_09_01);
    discoveryService.setApiKey("");
    discoveryService.setEndPoint(getMockWebServerUrl());

    environmentId = "mock_envid";
    environmentName = "my_environment";
    environmentDesc = "My environment";
    uniqueConfigName = "my-config";
    configurationId = "mock_confid";
    uniqueCollectionName = "mock_collname";
    collectionId = "mock_collid";
    documentId = "mock_docid";
    queryId = "mock_queryid";

    envResp = loadFixture(RESOURCE + "get_env_resp.json", Environment.class);
    envsResp = loadFixture(RESOURCE + "get_envs_resp.json", ListEnvironmentsResponse.class);
    createEnvResp = loadFixture(RESOURCE + "create_env_resp.json", Environment.class);
    deleteEnvResp = loadFixture(RESOURCE + "delete_env_resp.json", Map.class);
    updateEnvResp = loadFixture(RESOURCE + "update_env_resp.json", Environment.class);
    createConfResp = loadFixture(RESOURCE + "create_conf_resp.json", Configuration.class);
    getConfsResp = loadFixture(RESOURCE + "get_confs_resp.json", ListConfigurationsResponse.class);
    getConfResp = loadFixture(RESOURCE + "get_conf_resp.json", Configuration.class);
    deleteConfResp = loadFixture(RESOURCE + "delete_conf_resp.json", Map.class);
    updateConfResp = loadFixture(RESOURCE + "update_conf_resp.json", Configuration.class);
    createCollResp = loadFixture(RESOURCE + "create_coll_resp.json", Collection.class);
    getCollsResp = loadFixture(RESOURCE + "get_coll_resp.json", ListCollectionsResponse.class);
    getCollResp = loadFixture(RESOURCE + "get_coll1_resp.json", Collection.class);
    deleteCollResp = loadFixture(RESOURCE + "delete_coll_resp.json", Map.class);
    listfieldsCollResp = loadFixture(RESOURCE + "listfields_coll_resp.json", ListCollectionFieldsResponse.class);
    createDocResp = loadFixture(RESOURCE + "create_doc_resp.json", DocumentAccepted.class);
    updateDocResp = loadFixture(RESOURCE + "update_doc_resp.json", DocumentAccepted.class);
    getDocResp = loadFixture(RESOURCE + "get_doc_resp.json", DocumentStatus.class);
    deleteDocResp = loadFixture(RESOURCE + "delete_doc_resp.json", Map.class);
    queryResp = loadFixture(RESOURCE + "query1_resp.json", QueryResponse.class);
    queryNoticesResp = loadFixture(RESOURCE + "query1_resp.json", QueryNoticesResponse.class);
    addTrainingQueryResp = loadFixture(RESOURCE + "add_training_query_resp.json", TrainingQuery.class);
    listTrainingDataResp = loadFixture(RESOURCE + "list_training_data_resp.json", TrainingDataSet.class);
    createTrainingExampleResp = loadFixture(RESOURCE + "add_training_example_resp.json", TrainingExample.class);
    getTrainingDataResp = loadFixture(RESOURCE + "get_training_data_resp.json", TrainingQuery.class);
    getTrainingExampleResp = loadFixture(RESOURCE + "get_training_example_resp.json", TrainingExample.class);
    updateTrainingExampleResp = loadFixture(RESOURCE + "update_training_example_resp.json", TrainingExample.class);
    listTrainingExamplesResp = loadFixture(RESOURCE + "list_training_examples_resp.json", TrainingExampleList.class);
    listFieldsResp = loadFixture(RESOURCE + "list_fields_resp.json", ListCollectionFieldsResponse.class);
  }

  @After
  public void cleanup() {
  }

  /**
   * Negative - Test constructor with null version date.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullVersionDate() {
    new Discovery(null);
  }

  /**
   * Negative - Test constructor with empty version date.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithEmptyVersionDate() {
    new Discovery("");
  }

  // Environment tests
  @Test
  public void getEnvironmentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(envResp));
    GetEnvironmentOptions getRequest = new GetEnvironmentOptions.Builder(environmentId).build();
    Environment response = discoveryService.getEnvironment(getRequest).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(ENV1_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(envResp, response);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getEnvironmentFails1() {
    GetEnvironmentOptions getRequest = new GetEnvironmentOptions.Builder().build();
    @SuppressWarnings("unused")
    Environment response = discoveryService.getEnvironment(getRequest).execute();
  }

  @Test(expected = IllegalArgumentException.class)
  public void getEnvironmentFails2() {
    @SuppressWarnings("unused")
    Environment response = discoveryService.getEnvironment(null).execute();
  }

  @Test
  public void listEnvironmentsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(envsResp));
    ListEnvironmentsResponse response = discoveryService.listEnvironments(null).execute();
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
        new CreateEnvironmentOptions.Builder().name(environmentName).size(THREE);
    createRequestBuilder.description(environmentDesc);
    Environment response = discoveryService.createEnvironment(createRequestBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(ENV2_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createEnvResp, response);
  }

  // Deleted test for createEnvironment with null name as this does not fail in the current SDK

  @Test
  public void deleteEnvironmentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(deleteEnvResp));
    DeleteEnvironmentOptions deleteRequest = new DeleteEnvironmentOptions.Builder(environmentId).build();
    discoveryService.deleteEnvironment(deleteRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(ENV1_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
  }

  @Test(expected = IllegalArgumentException.class)
  public void deleteEnvironmentFails() {
    discoveryService.deleteEnvironment(null).execute();
  }

  @Test
  public void updateEnvironmentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(updateEnvResp));
    UpdateEnvironmentOptions.Builder updateBuilder =
        new UpdateEnvironmentOptions.Builder(environmentId).name(environmentName);
    updateBuilder.description(environmentDesc);
    Environment response = discoveryService.updateEnvironment(updateBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(ENV1_PATH, request.getPath());
    assertEquals(PUT, request.getMethod());
    assertEquals(updateEnvResp, response);
  }

  // Configuration tests
  @Test
  public void createConfigurationIsSuccessful() throws JsonSyntaxException, JsonIOException,
      FileNotFoundException, InterruptedException {
    server.enqueue(jsonResponse(createConfResp));
    CreateConfigurationOptions.Builder createBuilder = new CreateConfigurationOptions.Builder(environmentId);
    Configuration configuration =
        GsonSingleton.getGson().fromJson(new FileReader(DISCOVERY_TEST_CONFIG_FILE), Configuration.class);
    createBuilder.configuration(configuration);
    createBuilder.name(uniqueConfigName);
    Configuration response = discoveryService.createConfiguration(createBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createConfResp, response);
  }

  @Test
  public void getConfigurationIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getConfResp));
    GetConfigurationOptions getRequest = new GetConfigurationOptions.Builder(environmentId, configurationId).build();
    Configuration response = discoveryService.getConfiguration(getRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF2_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getConfResp, response);
  }

  @Test
  public void getConfigurationsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getConfsResp));
    ListConfigurationsOptions getRequest = new ListConfigurationsOptions.Builder(environmentId).build();
    ListConfigurationsResponse response = discoveryService.listConfigurations(getRequest).execute();
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
    discoveryService.deleteConfiguration(deleteRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF2_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
  }

  @Test
  public void updateConfigurationIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(updateConfResp));
    UpdateConfigurationOptions.Builder updateBuilder =
        new UpdateConfigurationOptions.Builder(environmentId, configurationId);

    Configuration newConf = new Configuration();
    newConf.setName("newName");
    updateBuilder.configuration(newConf);

    Configuration response = discoveryService.updateConfiguration(updateBuilder.build()).execute();
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
        new CreateCollectionOptions.Builder(environmentId, uniqueCollectionName).configurationId(configurationId);
    Collection response = discoveryService.createCollection(createCollectionBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createCollResp, response);
  }

  @Test
  public void getCollectionsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getCollsResp));
    ListCollectionsOptions getRequest = new ListCollectionsOptions.Builder(environmentId).build();
    ListCollectionsResponse response = discoveryService.listCollections(getRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL1_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getCollsResp, response);
  }

  @Test
  public void getCollectionIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getCollResp));
    GetCollectionOptions getRequest = new GetCollectionOptions.Builder(environmentId, collectionId).build();
    Collection response = discoveryService.getCollection(getRequest).execute();
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
    ListCollectionFieldsResponse response = discoveryService.listCollectionFields(getRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL3_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(listfieldsCollResp, response);
  }

  @Test
  public void deleteCollectionIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(deleteCollResp));
    DeleteCollectionOptions deleteRequest = new DeleteCollectionOptions.Builder(environmentId, collectionId).build();
    discoveryService.deleteCollection(deleteRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL2_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
  }

  // Document tests
  @Test
  public void addDocumentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createDocResp));
    String myDocumentJson = "{\"field\":\"value\"}";
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    AddDocumentOptions.Builder builder = new AddDocumentOptions.Builder(environmentId, collectionId);
    builder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    builder.filename("test_file");
    builder.metadata(myMetadata.toString());
    DocumentAccepted response = discoveryService.addDocument(builder.build()).execute();
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

    AddDocumentOptions.Builder builder = new AddDocumentOptions.Builder(environmentId, collectionId);
    builder.file(documentStream);
    builder.filename("test_file");
    builder.metadata(myMetadata.toString());
    DocumentAccepted response = discoveryService.addDocument(builder.build()).execute();
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

    AddDocumentOptions.Builder builder = new AddDocumentOptions.Builder(environmentId, collectionId);
    builder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    builder.filename("test_file");
    builder.metadata(myMetadata.toString());
    DocumentAccepted response = discoveryService.addDocument(builder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createDocResp, response);
  }

  @Test(expected = IllegalArgumentException.class)
  public void addDocumentWithoutRequiredParametersFails() {
    AddDocumentOptions options = new AddDocumentOptions.Builder(environmentId, collectionId).build();
    DocumentAccepted response = discoveryService.addDocument(options).execute();
  }

  @Test
  public void addDocumentFromInputStreamWithFileNameAndMediaTypeIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createDocResp));
    String fileName = "MyFileName";
    String myDocumentJson = "{\"field\":\"value\"}";
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    AddDocumentOptions.Builder builder = new AddDocumentOptions.Builder(environmentId, collectionId);
    builder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    builder.filename("test_file");
    builder.metadata(myMetadata.toString());
    DocumentAccepted response = discoveryService.addDocument(builder.build()).execute();
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
    DocumentAccepted response = discoveryService.updateDocument(updateBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS2_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(updateDocResp, response);
  }

  @Test(expected = IllegalArgumentException.class)
  public void updateDocumentWithoutRequiredParametersFails() {
    UpdateDocumentOptions options =
        new UpdateDocumentOptions.Builder(environmentId, collectionId, documentId).build();
    DocumentAccepted response = discoveryService.updateDocument(options).execute();
  }

  @Test
  public void getDocumentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getDocResp));
    GetDocumentStatusOptions getRequest =
        new GetDocumentStatusOptions.Builder(environmentId, collectionId, documentId).build();
    DocumentStatus response = discoveryService.getDocumentStatus(getRequest).execute();
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
    discoveryService.deleteDocument(deleteRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS2_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
  }

  // Query tests
  @Test
  public void queryIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(queryResp));
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    queryBuilder.count(5L);
    queryBuilder.offset(5L);
    List<String> fieldNames = new ArrayList<>();
    fieldNames.add("field");
    queryBuilder.returnFields(fieldNames);
    queryBuilder.query("field" + Operator.CONTAINS + 1);
    queryBuilder.filter("field" + Operator.CONTAINS + 1);
    QueryResponse response = discoveryService.query(queryBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(Q1_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(GsonSingleton.getGson().toJsonTree(queryResp), GsonSingleton.getGson().toJsonTree(response));
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
    QueryResponse response = discoveryService.query(queryBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(Q2_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(GsonSingleton.getGson().toJsonTree(queryResp), GsonSingleton.getGson().toJsonTree(response));
  }

  // Training data tests
  @Test
  public void addTrainingDataIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(addTrainingQueryResp));
    AddTrainingDataOptions.Builder builder = new AddTrainingDataOptions.Builder(environmentId, collectionId);
    builder.naturalLanguageQuery("Example query");
    TrainingExample example = new TrainingExample();
    example.setDocumentId(documentId);
    example.setRelevance(0);
    builder.addExamples(example);
    TrainingQuery response = discoveryService.addTrainingData(builder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(TRAINING1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(addTrainingQueryResp, response);
  }

  @Test
  public void listTrainingDataIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(listTrainingDataResp));
    ListTrainingDataOptions getRequest = new ListTrainingDataOptions.Builder(environmentId, collectionId).build();
    TrainingDataSet response = discoveryService.listTrainingData(getRequest).execute();
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
    discoveryService.deleteAllTrainingData(deleteRequest).execute();
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
    TrainingExample response = discoveryService.createTrainingExample(builder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(TRAINING2_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createTrainingExampleResp, response);
  }

  @Test
  public void getTrainingDataIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getTrainingDataResp));
    GetTrainingDataOptions.Builder builder = new GetTrainingDataOptions.Builder(environmentId, collectionId, queryId);
    TrainingQuery response = discoveryService.getTrainingData(builder.build()).execute();
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
    TrainingExample response = discoveryService.getTrainingExample(builder.build()).execute();
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
    discoveryService.deleteTrainingData(builder.build()).execute();
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
    discoveryService.deleteTrainingExample(builder.build()).execute();
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
    TrainingExample response = discoveryService.updateTrainingExample(builder.build()).execute();
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
    TrainingExampleList response = discoveryService.listTrainingExamples(builder.build()).execute();
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
    ListCollectionFieldsResponse response = discoveryService.listFields(builder.build()).execute();
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
    QueryNoticesResponse response = discoveryService.queryNotices(builder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(Q5_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
  }

  @Test
  public void federatedQueryIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(queryResp));
    FederatedQueryOptions.Builder builder =
        new FederatedQueryOptions.Builder(environmentId, new ArrayList<>(Arrays.asList(collectionId)));
    QueryResponse response = discoveryService.federatedQuery(builder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(Q3_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
  }

  @Test
  public void federatedQueryNoticesIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(queryNoticesResp));
    FederatedQueryNoticesOptions.Builder builder =
        new FederatedQueryNoticesOptions.Builder(environmentId, new ArrayList<>(Arrays.asList(collectionId)));
    QueryNoticesResponse response = discoveryService.federatedQueryNotices(builder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(Q4_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
  }
}

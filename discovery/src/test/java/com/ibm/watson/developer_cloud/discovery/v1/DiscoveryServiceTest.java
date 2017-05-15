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
import com.ibm.watson.developer_cloud.discovery.v1.model.Collection;
import com.ibm.watson.developer_cloud.discovery.v1.model.Configuration;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateCollectionOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteCollectionOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteCollectionResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DocumentAccepted;
import com.ibm.watson.developer_cloud.discovery.v1.model.DocumentStatus;
import com.ibm.watson.developer_cloud.discovery.v1.model.Environment;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetCollectionOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionFieldsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionFieldsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListConfigurationsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListConfigurationsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListEnvironmentsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.query.AggregationType;
import com.ibm.watson.developer_cloud.discovery.v1.query.Operator;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
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
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for {@link Discovery}.
 */
public class DiscoveryServiceTest extends WatsonServiceUnitTest {
  private Discovery discoveryService;

  private static final String DISCOVERY_TEST_CONFIG_FILE = "src/test/resources/discovery/test-config.json";
  private static final String RESOURCE = "src/test/resources/discovery/";
  private static final String ENV1_PATH = "/v1/environments/mock_envid?version=2016-12-16";
  private static final String ENV2_PATH = "/v1/environments?version=2016-12-16";
  private static final String CONF1_PATH = "/v1/environments/mock_envid/configurations?version=2016-12-16";
  private static final String CONF2_PATH = "/v1/environments/mock_envid/configurations/mock_confid?version=2016-12-16";
  private static final String COLL1_PATH = "/v1/environments/mock_envid/collections?version=2016-12-16";
  private static final String COLL2_PATH = "/v1/environments/mock_envid/collections/mock_collid?version=2016-12-16";
  private static final String COLL3_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/fields?version=2016-12-16";
  private static final String DOCS1_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/documents?version=2016-12-16";
  private static final String DOCS2_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/documents/mock_docid?version=2016-12-16";
  private static final String Q1_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/query?version=2016-12-16&filter=field:1"
          + "&query=field:1&count=5&return=field&offset=5";
  private static final String Q2_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/query?version=2016-12-16&aggregation=term(field)";

  private static final Long FREE = 0L;
  private static final Long THREE = 3L;

  private String environmentId;
  private String environmentName;
  private String environmentDesc;
  private String uniqueConfigName;
  private String configurationId;
  private String uniqueCollectionName;
  private String collectionId;
  private String documentId;

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

  @BeforeClass
  public static void setupClass() {
  }

  @Before
  public void setup() throws Exception {
    super.setUp();
    discoveryService = new Discovery("2016-12-16");
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

    envResp = loadFixture(RESOURCE + "get_env_resp.json", Environment.class);
    envsResp = loadFixture(RESOURCE + "get_envs_resp.json", ListEnvironmentsResponse.class);
    createEnvResp = loadFixture(RESOURCE + "create_env_resp.json", Environment.class);
    deleteEnvResp = loadFixture(RESOURCE + "delete_env_resp.json", DeleteEnvironmentResponse.class);
    updateEnvResp = loadFixture(RESOURCE + "update_env_resp.json", Environment.class);
    createConfResp = loadFixture(RESOURCE + "create_conf_resp.json", Configuration.class);
    getConfsResp = loadFixture(RESOURCE + "get_confs_resp.json", ListConfigurationsResponse.class);
    getConfResp = loadFixture(RESOURCE + "get_conf_resp.json", Configuration.class);
    deleteConfResp = loadFixture(RESOURCE + "delete_conf_resp.json", DeleteConfigurationResponse.class);
    updateConfResp = loadFixture(RESOURCE + "update_conf_resp.json", Configuration.class);
    createCollResp = loadFixture(RESOURCE + "create_coll_resp.json", Collection.class);
    getCollsResp = loadFixture(RESOURCE + "get_coll_resp.json", ListCollectionsResponse.class);
    getCollResp = loadFixture(RESOURCE + "get_coll1_resp.json", Collection.class);
    deleteCollResp = loadFixture(RESOURCE + "delete_coll_resp.json", DeleteCollectionResponse.class);
    listfieldsCollResp = loadFixture(RESOURCE + "listfields_coll_resp.json", ListCollectionFieldsResponse.class);
    createDocResp = loadFixture(RESOURCE + "create_doc_resp.json", DocumentAccepted.class);
    updateDocResp = loadFixture(RESOURCE + "update_doc_resp.json", DocumentAccepted.class);
    getDocResp = loadFixture(RESOURCE + "get_doc_resp.json", DocumentStatus.class);
    deleteDocResp = loadFixture(RESOURCE + "delete_doc_resp.json", DeleteDocumentResponse.class);
    queryResp = loadFixture(RESOURCE + "query1_resp.json", QueryResponse.class);
  }

  @After
  public void cleanup() {
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
    DeleteEnvironmentResponse response = discoveryService.deleteEnvironment(deleteRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(ENV1_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
    assertEquals(deleteEnvResp, response);
  }

  @Test(expected = IllegalArgumentException.class)
  public void deleteEnvironmentFails() {
    @SuppressWarnings("unused")
    DeleteEnvironmentResponse response = discoveryService.deleteEnvironment(null).execute();
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
    DeleteConfigurationResponse response = discoveryService.deleteConfiguration(deleteRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF2_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
    assertEquals(deleteConfResp, response);
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
        new CreateCollectionOptions.Builder(environmentId).name(uniqueCollectionName).configurationId(configurationId);
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
    DeleteCollectionResponse response = discoveryService.deleteCollection(deleteRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL2_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
    assertEquals(deleteCollResp, response);
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
    builder.file(documentStream).fileMediaType(HttpMediaType.APPLICATION_JSON);
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
    builder.file(documentStream).fileMediaType(HttpMediaType.APPLICATION_JSON);
    builder.metadata(myMetadata.toString());
    DocumentAccepted response = discoveryService.addDocument(builder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createDocResp, response);
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
    builder.file(documentStream).fileMediaType(HttpMediaType.APPLICATION_JSON);
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
    updateBuilder.file(documentStream).fileMediaType(HttpMediaType.APPLICATION_JSON);
    updateBuilder.metadata(myMetadata.toString());
    DocumentAccepted response = discoveryService.updateDocument(updateBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS2_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(updateDocResp, response);
  }

  @Test
  public void getDocumentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getDocResp));
    GetDocumentOptions getRequest = new GetDocumentOptions.Builder(environmentId, collectionId, documentId).build();
    DocumentStatus response = discoveryService.getDocument(getRequest).execute();
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
    DeleteDocumentResponse response = discoveryService.deleteDocument(deleteRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS2_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
    assertEquals(deleteDocResp, response);
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
    assertEquals(queryResp, response);
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
    assertEquals(queryResp, response);
  }

}

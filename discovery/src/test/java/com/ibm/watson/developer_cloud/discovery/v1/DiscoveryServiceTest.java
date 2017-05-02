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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ibm.watson.developer_cloud.discovery.v1.model.DocumentStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateCollectionRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.Collection;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteCollectionResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetCollectionsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetCollectionFieldsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.Configuration;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetConfigurationsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DocumentAccepted;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DocumentAccepted;
import com.ibm.watson.developer_cloud.discovery.v1.model.DocumentAccepted;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.Environment;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.Environment;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetEnvironmentsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.query.AggregationType;
import com.ibm.watson.developer_cloud.discovery.v1.query.Operator;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryResponse;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import okhttp3.mockwebserver.RecordedRequest;

/**
 * Unit tests for {@link Discovery}.
 *
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
      "/v1/environments/mock_envid/collections/mock_collid/query?version=2016-12-16&filter=field%253A1&offset=5"
          + "&query=field%253A1&count=5&return=field";
  private static final String Q2_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/query?version=2016-12-16&aggregation=term%2528field%2529";

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
  private GetEnvironmentsResponse envsResp;
  private Environment createEnvResp;
  private DeleteEnvironmentResponse deleteEnvResp;
  private Environment updateEnvResp;
  private Configuration createConfResp;
  private GetConfigurationsResponse getConfsResp;
  private Configuration getConfResp;
  private DeleteConfigurationResponse deleteConfResp;
  private Configuration updateConfResp;
  private Collection createCollResp;
  private GetCollectionsResponse getCollsResp;
  private Collection getCollResp;
  private DeleteCollectionResponse deleteCollResp;
  private GetCollectionFieldsResponse listfieldsCollResp;
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
    envsResp = loadFixture(RESOURCE + "get_envs_resp.json", GetEnvironmentsResponse.class);
    createEnvResp = loadFixture(RESOURCE + "create_env_resp.json", Environment.class);
    deleteEnvResp = loadFixture(RESOURCE + "delete_env_resp.json", DeleteEnvironmentResponse.class);
    updateEnvResp = loadFixture(RESOURCE + "update_env_resp.json", Environment.class);
    createConfResp = loadFixture(RESOURCE + "create_conf_resp.json", Configuration.class);
    getConfsResp = loadFixture(RESOURCE + "get_confs_resp.json", GetConfigurationsResponse.class);
    getConfResp = loadFixture(RESOURCE + "get_conf_resp.json", Configuration.class);
    deleteConfResp = loadFixture(RESOURCE + "delete_conf_resp.json", DeleteConfigurationResponse.class);
    updateConfResp = loadFixture(RESOURCE + "update_conf_resp.json", Configuration.class);
    createCollResp = loadFixture(RESOURCE + "create_coll_resp.json", Collection.class);
    getCollsResp = loadFixture(RESOURCE + "get_coll_resp.json", GetCollectionsResponse.class);
    getCollResp = loadFixture(RESOURCE + "get_coll1_resp.json", Collection.class);
    deleteCollResp = loadFixture(RESOURCE + "delete_coll_resp.json", DeleteCollectionResponse.class);
    listfieldsCollResp = loadFixture(RESOURCE + "listfields_coll_resp.json", GetCollectionFieldsResponse.class);
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
    Environment response = discoveryService.getEnvironment(environmentId).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(ENV1_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(envResp, response);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getEnvironmentFails1() {
    @SuppressWarnings("unused")
    Environment response = discoveryService.getEnvironment("").execute();
  }

  @Test(expected = IllegalArgumentException.class)
  public void getEnvironmentFails2() {
    @SuppressWarnings("unused")
    Environment response = discoveryService.getEnvironment(null).execute();
  }

  @Test
  public void getEnvironmentsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(envsResp));
    GetEnvironmentsResponse response = discoveryService.getEnvironments(null).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(ENV2_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(envsResp, response);
  }

  // Deleted test for getEnvironments with null name as this does not fail in the current SDK

  @Test
  public void createEnvironmentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createEnvResp));
    CreateEnvironmentRequest.Builder createRequestBuilder =
        new CreateEnvironmentRequest.Builder().name(environmentName).size(THREE);
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
    DeleteEnvironmentResponse response = discoveryService.deleteEnvironment(environmentId).execute();
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
    UpdateEnvironmentRequest.Builder updateBuilder = new UpdateEnvironmentRequest.Builder();
    updateBuilder.description(environmentDesc);
    Environment response = discoveryService.updateEnvironment(environmentId, updateBuilder.build()).execute();
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
    Configuration configuration =
        GsonSingleton.getGson().fromJson(new FileReader(DISCOVERY_TEST_CONFIG_FILE), Configuration.class);
    configuration.setName(uniqueConfigName);
    Configuration response = discoveryService.createConfiguration(environmentId, configuration).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createConfResp, response);
  }

  @Test
  public void getConfigurationIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getConfResp));
    Configuration response = discoveryService.getConfiguration(environmentId, configurationId).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF2_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getConfResp, response);
  }

  @Test
  public void getConfigurationsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getConfsResp));
    GetConfigurationsResponse response = discoveryService.getConfigurations(environmentId, null).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF1_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getConfsResp, response);
  }

  @Test
  public void deleteConfigurationIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(deleteConfResp));
    DeleteConfigurationResponse response = discoveryService.deleteConfiguration(environmentId, configurationId).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF2_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
    assertEquals(deleteConfResp, response);
  }

  @Test
  public void updateConfigurationIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(updateConfResp));

    Configuration newConf = new Configuration();
    newConf.setName("newName");

    Configuration response = discoveryService.updateConfiguration(environmentId, configurationId, newConf).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF2_PATH, request.getPath());
    assertEquals(PUT, request.getMethod());
    assertEquals(updateConfResp, response);
  }

  // Collection tests
  @Test
  public void createCollectionIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createCollResp));
    CreateCollectionRequest.Builder createCollectionBuilder =
        new CreateCollectionRequest.Builder().name(uniqueCollectionName).configurationId(configurationId);
    Collection response = discoveryService.createCollection(environmentId, createCollectionBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createCollResp, response);
  }

  @Test
  public void getCollectionsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getCollsResp));
    GetCollectionsResponse response = discoveryService.getCollections(environmentId, null).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL1_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getCollsResp, response);
  }

  @Test
  public void getCollectionIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getCollResp));
    Collection response = discoveryService.getCollection(environmentId, collectionId).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL2_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getCollResp, response);
  }

  // no updateCollection yet?

  @Test
  public void listfieldsCollectionIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(listfieldsCollResp));
    GetCollectionFieldsResponse response = discoveryService.getCollectionFields(environmentId, collectionId).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL3_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(listfieldsCollResp, response);
  }

  @Test
  public void deleteCollectionIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(deleteCollResp));;
    DeleteCollectionResponse response = discoveryService.deleteCollection(environmentId, collectionId).execute();
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

    DocumentAccepted response = discoveryService.addDocument(environmentId,collectionId, null, documentStream,
        HttpMediaType.APPLICATION_JSON, myMetadata.toString(), null).execute();
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

    DocumentAccepted response = discoveryService.addDocument(environmentId, collectionId, null, documentStream,
        null, myMetadata.toString(), null).execute();
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

    DocumentAccepted response = discoveryService.addDocument(environmentId, collectionId, null, documentStream,
        HttpMediaType.APPLICATION_JSON, myMetadata.toString(), null).execute();
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

    DocumentAccepted response = discoveryService.addDocument(environmentId, collectionId, null, documentStream,
        HttpMediaType.APPLICATION_JSON, myMetadata.toString(), null).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createDocResp, response);
  }

  // Deleted tests for (create)addDocument with file parameter as this is deprecated

  @Test
  public void updateDocumentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(updateDocResp));
    String myDocumentJson = "{\"field\":\"value2\"}";
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());
    DocumentAccepted response = discoveryService.updateDocument(environmentId, collectionId, documentId, null, documentStream,
        HttpMediaType.APPLICATION_JSON, myMetadata.toString(), null).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS2_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(updateDocResp, response);
  }

  @Test
  public void getDocumentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getDocResp));
    DocumentStatus response = discoveryService.getDocument(environmentId, collectionId, documentId).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS2_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getDocResp, response);
  }

  @Test
  public void deleteDocumentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(deleteDocResp));
    DeleteDocumentResponse response = discoveryService.deleteDocument(environmentId, collectionId, documentId).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS2_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
    assertEquals(deleteDocResp, response);
  }

  // Query tests
  @Test
  public void queryIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(queryResp));
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder();
    queryBuilder.count(5L);
    queryBuilder.offset(5L);
    List<String> fieldNames = new ArrayList<>();
    fieldNames.add("field");
    queryBuilder.returnFields(fieldNames);
    queryBuilder.query("field" + Operator.CONTAINS + 1);
    queryBuilder.filter("field" + Operator.CONTAINS + 1);
    QueryResponse response  = discoveryService.query(environmentId, collectionId, queryBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(Q1_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(queryResp, response);
  }

  @Test
  public void queryWithAggregationTermIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(queryResp));
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder();
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.TERM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse response = discoveryService.query(environmentId, collectionId, queryBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(Q2_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(queryResp, response);
  }

}

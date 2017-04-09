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

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.CreateCollectionRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.CreateCollectionResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.DeleteCollectionRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.DeleteCollectionResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.GetCollectionRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.GetCollectionResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.GetCollectionsRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.GetCollectionsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.field.GetCollectionFieldsRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.field.GetCollectionFieldsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.Configuration;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.CreateConfigurationRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.CreateConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.DeleteConfigurationRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.DeleteConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.GetConfigurationRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.GetConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.GetConfigurationsRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.GetConfigurationsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.UpdateConfigurationRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.UpdateConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.CreateDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.CreateDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.DeleteDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.DeleteDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.GetDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.GetDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.UpdateDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.UpdateDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.CreateEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.CreateEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.DeleteEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.DeleteEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentsRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.UpdateEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.UpdateEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.AggregationType;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.Operator;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryResponse;
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
      "/v1/environments/mock_envid/collections/mock_collid/query?filter=field:1&query=field:1"
          + "&count=5&offset=5&return=field&version=2016-12-16";
  private static final String Q2_PATH =
      "/v1/environments/mock_envid/collections/mock_collid/query?aggregation=term(field)"
          + "&count=10&offset=0&version=2016-12-16";

  private String environmentId;
  private String environmentName;
  private String environmentDesc;
  private String uniqueConfigName;
  private String configurationId;
  private String uniqueCollectionName;
  private String collectionId;
  private String documentId;

  private GetEnvironmentResponse envResp;
  private GetEnvironmentsResponse envsResp;
  private CreateEnvironmentResponse createEnvResp;
  private DeleteEnvironmentResponse deleteEnvResp;
  private UpdateEnvironmentResponse updateEnvResp;
  private CreateConfigurationResponse createConfResp;
  private GetConfigurationsResponse getConfsResp;
  private GetConfigurationResponse getConfResp;
  private DeleteConfigurationResponse deleteConfResp;
  private UpdateConfigurationResponse updateConfResp;
  private CreateCollectionResponse createCollResp;
  private GetCollectionsResponse getCollsResp;
  private GetCollectionResponse getCollResp;
  private DeleteCollectionResponse deleteCollResp;
  private GetCollectionFieldsResponse listfieldsCollResp;
  private CreateDocumentResponse createDocResp;
  private UpdateDocumentResponse updateDocResp;
  private GetDocumentResponse getDocResp;
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

    envResp = loadFixture(RESOURCE + "get_env_resp.json", GetEnvironmentResponse.class);
    envsResp = loadFixture(RESOURCE + "get_envs_resp.json", GetEnvironmentsResponse.class);
    createEnvResp = loadFixture(RESOURCE + "create_env_resp.json", CreateEnvironmentResponse.class);
    deleteEnvResp = loadFixture(RESOURCE + "delete_env_resp.json", DeleteEnvironmentResponse.class);
    updateEnvResp = loadFixture(RESOURCE + "update_env_resp.json", UpdateEnvironmentResponse.class);
    createConfResp = loadFixture(RESOURCE + "create_conf_resp.json", CreateConfigurationResponse.class);
    getConfsResp = loadFixture(RESOURCE + "get_confs_resp.json", GetConfigurationsResponse.class);
    getConfResp = loadFixture(RESOURCE + "get_conf_resp.json", GetConfigurationResponse.class);
    deleteConfResp = loadFixture(RESOURCE + "delete_conf_resp.json", DeleteConfigurationResponse.class);
    updateConfResp = loadFixture(RESOURCE + "update_conf_resp.json", UpdateConfigurationResponse.class);
    createCollResp = loadFixture(RESOURCE + "create_coll_resp.json", CreateCollectionResponse.class);
    getCollsResp = loadFixture(RESOURCE + "get_coll_resp.json", GetCollectionsResponse.class);
    getCollResp = loadFixture(RESOURCE + "get_coll1_resp.json", GetCollectionResponse.class);
    deleteCollResp = loadFixture(RESOURCE + "delete_coll_resp.json", DeleteCollectionResponse.class);
    listfieldsCollResp = loadFixture(RESOURCE + "listfields_coll_resp.json", GetCollectionFieldsResponse.class);
    createDocResp = loadFixture(RESOURCE + "create_doc_resp.json", CreateDocumentResponse.class);
    updateDocResp = loadFixture(RESOURCE + "update_doc_resp.json", UpdateDocumentResponse.class);
    getDocResp = loadFixture(RESOURCE + "get_doc_resp.json", GetDocumentResponse.class);
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
    GetEnvironmentRequest getRequest = new GetEnvironmentRequest.Builder(environmentId).build();
    GetEnvironmentResponse response = discoveryService.getEnvironment(getRequest).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(ENV1_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(envResp, response);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getEnvironmentFails1() {
    GetEnvironmentRequest getRequest = new GetEnvironmentRequest.Builder("").build();
    @SuppressWarnings("unused")
    GetEnvironmentResponse response = discoveryService.getEnvironment(getRequest).execute();
  }

  @Test(expected = NullPointerException.class)
  public void getEnvironmentFails2() {
    @SuppressWarnings("unused")
    GetEnvironmentResponse response = discoveryService.getEnvironment(null).execute();
  }

  @Test
  public void getEnvironmentsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(envsResp));
    GetEnvironmentsRequest getRequest = new GetEnvironmentsRequest.Builder().build();
    GetEnvironmentsResponse response = discoveryService.getEnvironments(getRequest).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(ENV2_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(envsResp, response);
  }

  @Test(expected = NullPointerException.class)
  public void getEnvironmentsFails() {
    @SuppressWarnings("unused")
    GetEnvironmentsResponse response = discoveryService.getEnvironments(null).execute();
  }

  @Test
  public void createEnvironmentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createEnvResp));
    CreateEnvironmentRequest.Builder createRequestBuilder =
        new CreateEnvironmentRequest.Builder(environmentName, CreateEnvironmentRequest.Size.THREE);
    createRequestBuilder.description(environmentDesc);
    CreateEnvironmentResponse response = discoveryService.createEnvironment(createRequestBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(ENV2_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createEnvResp, response);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createEnvironmentFails() {
    CreateEnvironmentRequest.Builder createRequestBuilder =
        new CreateEnvironmentRequest.Builder(null, CreateEnvironmentRequest.Size.FREE);
    createRequestBuilder.description(null);
    @SuppressWarnings("unused")
    CreateEnvironmentResponse response = discoveryService.createEnvironment(createRequestBuilder.build()).execute();
  }

  @Test
  public void deleteEnvironmentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(deleteEnvResp));
    DeleteEnvironmentRequest deleteRequest = new DeleteEnvironmentRequest.Builder(environmentId).build();
    DeleteEnvironmentResponse response = discoveryService.deleteEnvironment(deleteRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(ENV1_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
    assertEquals(deleteEnvResp, response);
  }

  @Test(expected = NullPointerException.class)
  public void deleteEnvironmentFails() {
    @SuppressWarnings("unused")
    DeleteEnvironmentResponse response = discoveryService.deleteEnvironment(null).execute();
  }

  @Test
  public void updateEnvironmentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(updateEnvResp));
    UpdateEnvironmentRequest.Builder updateBuilder =
        new UpdateEnvironmentRequest.Builder(environmentId, environmentName);
    updateBuilder.description(environmentDesc);
    UpdateEnvironmentResponse response = discoveryService.updateEnvironment(updateBuilder.build()).execute();
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
    CreateConfigurationRequest.Builder createBuilder = new CreateConfigurationRequest.Builder(environmentId);
    Configuration configuration =
        GsonSingleton.getGson().fromJson(new FileReader(DISCOVERY_TEST_CONFIG_FILE), Configuration.class);
    configuration.setName(uniqueConfigName);
    createBuilder.configuration(configuration);
    CreateConfigurationResponse response = discoveryService.createConfiguration(createBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createConfResp, response);
  }

  @Test
  public void getConfigurationIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getConfResp));
    GetConfigurationRequest getRequest = new GetConfigurationRequest.Builder(environmentId, configurationId).build();
    GetConfigurationResponse response = discoveryService.getConfiguration(getRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF2_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getConfResp, response);
  }

  @Test
  public void getConfigurationsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getConfsResp));
    GetConfigurationsRequest getRequest = new GetConfigurationsRequest.Builder(environmentId).build();
    GetConfigurationsResponse response = discoveryService.getConfigurations(getRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF1_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getConfsResp, response);
  }

  @Test
  public void deleteConfigurationIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(deleteConfResp));
    DeleteConfigurationRequest deleteRequest =
        new DeleteConfigurationRequest.Builder(environmentId, configurationId).build();
    DeleteConfigurationResponse response = discoveryService.deleteConfiguration(deleteRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF2_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
    assertEquals(deleteConfResp, response);
  }

  @Test
  public void updateConfigurationIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(updateConfResp));
    UpdateConfigurationRequest.Builder updateBuilder =
        new UpdateConfigurationRequest.Builder(environmentId, configurationId);

    Configuration newConf = new Configuration();
    newConf.setName("newName");
    updateBuilder.configuration(newConf);

    UpdateConfigurationResponse response = discoveryService.updateConfiguration(updateBuilder.build()).execute();
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
        new CreateCollectionRequest.Builder(environmentId, configurationId, uniqueCollectionName);
    CreateCollectionResponse response = discoveryService.createCollection(createCollectionBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createCollResp, response);
  }

  @Test
  public void getCollectionsIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getCollsResp));
    GetCollectionsRequest getRequest = new GetCollectionsRequest.Builder(environmentId).build();
    GetCollectionsResponse response = discoveryService.getCollections(getRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL1_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getCollsResp, response);
  }

  @Test
  public void getCollectionIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getCollResp));
    GetCollectionRequest getRequest = new GetCollectionRequest.Builder(environmentId, collectionId).build();
    GetCollectionResponse response = discoveryService.getCollection(getRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL2_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getCollResp, response);
  }

  // no updateCollection yet?

  @Test
  public void listfieldsCollectionIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(listfieldsCollResp));
    GetCollectionFieldsRequest getRequest = new GetCollectionFieldsRequest.Builder(environmentId, collectionId).build();
    GetCollectionFieldsResponse response = discoveryService.getCollectionFields(getRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL3_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(listfieldsCollResp, response);
  }

  @Test
  public void deleteCollectionIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(deleteCollResp));
    DeleteCollectionRequest deleteRequest = new DeleteCollectionRequest.Builder(environmentId, collectionId).build();
    DeleteCollectionResponse response = discoveryService.deleteCollection(deleteRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL2_PATH, request.getPath());
    assertEquals(DELETE, request.getMethod());
    assertEquals(deleteCollResp, response);
  }

  // Document tests
  @Test
  public void createDocumentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createDocResp));
    String myDocumentJson = "{\"field\":\"value\"}";
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    CreateDocumentRequest.Builder builder = new CreateDocumentRequest.Builder(environmentId, collectionId);
    builder.inputStream(documentStream, HttpMediaType.APPLICATION_JSON);
    builder.metadata(myMetadata);
    CreateDocumentResponse response = discoveryService.createDocument(builder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createDocResp, response);
  }

  @Test
  public void createDocumentFromInputStreamIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createDocResp));
    String myDocumentJson = "{\"field\":\"value\"}";
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    CreateDocumentRequest.Builder builder = new CreateDocumentRequest.Builder(environmentId, collectionId);
    builder.file(documentStream);
    builder.metadata(myMetadata);
    CreateDocumentResponse response = discoveryService.createDocument(builder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createDocResp, response);
  }

  @Test
  public void createDocumentFromInputStreamWithMediaTypeIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createDocResp));
    String myDocumentJson = "{\"field\":\"value\"}";
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    CreateDocumentRequest.Builder builder = new CreateDocumentRequest.Builder(environmentId, collectionId);
    builder.file(documentStream, HttpMediaType.APPLICATION_JSON);
    builder.metadata(myMetadata);
    CreateDocumentResponse response = discoveryService.createDocument(builder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createDocResp, response);
  }

  @Test
  public void createDocumentFromInputStreamWithFileNameAndMediaTypeIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createDocResp));
    String fileName = "MyFileName";
    String myDocumentJson = "{\"field\":\"value\"}";
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    CreateDocumentRequest.Builder builder = new CreateDocumentRequest.Builder(environmentId, collectionId);
    builder.file(documentStream, fileName, HttpMediaType.APPLICATION_JSON);
    builder.metadata(myMetadata);
    CreateDocumentResponse response = discoveryService.createDocument(builder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS1_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(createDocResp, response);
  }

  @Test
  public void createDocumentFromFileWithMediaTypeIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createDocResp));
    String myDocumentJson = "{\"field\":\"value\"}";
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    CreateDocumentRequest.Builder builder = new CreateDocumentRequest.Builder(environmentId, collectionId);

    try {
      File tempFile = File.createTempFile("CreateDocTest1", ".json");
      tempFile.deleteOnExit();
      BufferedWriter out = new BufferedWriter(new FileWriter(tempFile));
      out.write(myDocumentJson);
      out.close();

      builder.file(tempFile, HttpMediaType.APPLICATION_JSON);
      builder.metadata(myMetadata);
      CreateDocumentResponse response = discoveryService.createDocument(builder.build()).execute();
      RecordedRequest request = server.takeRequest();

      assertEquals(DOCS1_PATH, request.getPath());
      assertEquals(POST, request.getMethod());
      assertEquals(createDocResp, response);
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void createDocumentFromFileIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createDocResp));
    String myDocumentJson = "{\"field\":\"value\"}";
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    CreateDocumentRequest.Builder builder = new CreateDocumentRequest.Builder(environmentId, collectionId);
    try {
      File tempFile = File.createTempFile("CreateDocTest2", ".json");
      tempFile.deleteOnExit();
      BufferedWriter out = new BufferedWriter(new FileWriter(tempFile));
      out.write(myDocumentJson);
      out.close();

      builder.file(tempFile);
      builder.metadata(myMetadata);
      CreateDocumentResponse response = discoveryService.createDocument(builder.build()).execute();
      RecordedRequest request = server.takeRequest();

      assertEquals(DOCS1_PATH, request.getPath());
      assertEquals(POST, request.getMethod());
      assertEquals(createDocResp, response);
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void createDocumentFromFileWithGivenIdIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(createDocResp));
    String myDocumentJson = "{\"field\":\"value\"}";
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    CreateDocumentRequest.Builder builder = new CreateDocumentRequest.Builder(environmentId, collectionId);
    try {
      File tempFile = File.createTempFile("CreateDocTest3", ".json");
      tempFile.deleteOnExit();
      BufferedWriter out = new BufferedWriter(new FileWriter(tempFile));
      out.write(myDocumentJson);
      out.close();

      builder.file(tempFile);
      builder.metadata(myMetadata);
      builder.documentId(documentId);
      CreateDocumentResponse response = discoveryService.createDocument(builder.build()).execute();
      RecordedRequest request = server.takeRequest();

      assertEquals(DOCS2_PATH, request.getPath());
      assertEquals(POST, request.getMethod());
      assertEquals(createDocResp, response);
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void updateDocumentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(updateDocResp));
    UpdateDocumentRequest.Builder updateBuilder =
        new UpdateDocumentRequest.Builder(environmentId, collectionId, documentId);
    String myDocumentJson = "{\"field\":\"value2\"}";
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());
    updateBuilder.inputStream(documentStream, HttpMediaType.APPLICATION_JSON);
    updateBuilder.metadata(myMetadata);
    UpdateDocumentResponse response = discoveryService.updateDocument(updateBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS2_PATH, request.getPath());
    assertEquals(POST, request.getMethod());
    assertEquals(updateDocResp, response);
  }

  @Test
  public void getDocumentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(getDocResp));
    GetDocumentRequest getRequest = new GetDocumentRequest.Builder(environmentId, collectionId, documentId).build();
    GetDocumentResponse response = discoveryService.getDocument(getRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS2_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(getDocResp, response);
  }

  @Test
  public void deleteDocumentIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(deleteDocResp));
    DeleteDocumentRequest deleteRequest =
        new DeleteDocumentRequest.Builder(environmentId, collectionId, documentId).build();
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
    QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
    queryBuilder.count(5);
    queryBuilder.offset(5);
    Set<String> fieldNames = new HashSet<String>();
    fieldNames.add("field");
    queryBuilder.returnFields(fieldNames);
    queryBuilder.query("field" + Operator.CONTAINS + 1);
    queryBuilder.filter("field" + Operator.CONTAINS + 1);
    QueryResponse response  = discoveryService.query(queryBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(Q1_PATH, request.getPath());
    assertEquals(GET, request.getMethod());
    assertEquals(queryResp, response);
  }

  @Test
  public void queryWithAggregationTermIsSuccessful() throws InterruptedException {
    server.enqueue(jsonResponse(queryResp));
    QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
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

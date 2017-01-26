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

import static org.junit.Assert.*;

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

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * Unit tests for {@link Discovery}
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
  private static final String COLL3_PATH = "/v1/environments/mock_envid/collections/mock_collid/fields?version=2016-12-16";
  private static final String DOCS1_PATH = "/v1/environments/mock_envid/collections/mock_collid/documents?version=2016-12-16";
  private static final String DOCS2_PATH = "/v1/environments/mock_envid/collections/mock_collid/documents/mock_docid?version=2016-12-16";
  private static final String Q1_PATH = "/v1/environments/mock_envid/collections/mock_collid/query?filter=field:1&query=field:1&count=5&offset=5&return=field&version=2016-12-16";
  private static final String Q2_PATH = "/v1/environments/mock_envid/collections/mock_collid/query?aggregation=term(field)&count=10&offset=0&version=2016-12-16";

  private String environmentId;
  private String environmentName;
  private String environmentDesc;
  private String uniqueConfigName;
  private String configurationId;
  private String uniqueCollectionName;
  private String collectionId;
  private String documentId;

  private GetEnvironmentResponse env_resp;
  private GetEnvironmentsResponse envs_resp;
  private CreateEnvironmentResponse create_env_resp;
  private DeleteEnvironmentResponse delete_env_resp;
  private UpdateEnvironmentResponse update_env_resp;
  private CreateConfigurationResponse create_conf_resp;
  private GetConfigurationsResponse get_confs_resp;
  private GetConfigurationResponse get_conf_resp;
  private DeleteConfigurationResponse delete_conf_resp;
  private UpdateConfigurationResponse update_conf_resp;
  private CreateCollectionResponse create_coll_resp;
  private GetCollectionsResponse get_colls_resp;
  private GetCollectionResponse get_coll_resp;
  private DeleteCollectionResponse delete_coll_resp;
  private GetCollectionFieldsResponse listfields_coll_resp;
  private CreateDocumentResponse create_doc_resp;
  private UpdateDocumentResponse update_doc_resp;
  private GetDocumentResponse get_doc_resp;
  private DeleteDocumentResponse delete_doc_resp;
  private QueryResponse query_resp;

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

    env_resp = loadFixture(RESOURCE + "get_env_resp.json", GetEnvironmentResponse.class);
    envs_resp = loadFixture(RESOURCE + "get_envs_resp.json", GetEnvironmentsResponse.class);
    create_env_resp = loadFixture(RESOURCE + "create_env_resp.json", CreateEnvironmentResponse.class);
    delete_env_resp = loadFixture(RESOURCE + "delete_env_resp.json", DeleteEnvironmentResponse.class);
    update_env_resp = loadFixture(RESOURCE + "update_env_resp.json", UpdateEnvironmentResponse.class);
    // issue with the create_conf json which was copied from the API documentation.  Use create_env for now  bug #528
    create_conf_resp = loadFixture(RESOURCE + "create_env_resp.json", CreateConfigurationResponse.class);
    get_confs_resp = loadFixture(RESOURCE + "get_confs_resp.json", GetConfigurationsResponse.class);
    // #528 - should be get_conf_resp
    get_conf_resp = loadFixture(RESOURCE + "get_confs_resp.json", GetConfigurationResponse.class);
    delete_conf_resp = loadFixture(RESOURCE + "delete_conf_resp.json", DeleteConfigurationResponse.class);
    // #528 - should be update_conf_resp
    update_conf_resp = loadFixture(RESOURCE + "delete_conf_resp.json", UpdateConfigurationResponse.class);
    create_coll_resp = loadFixture(RESOURCE + "create_coll_resp.json", CreateCollectionResponse.class);
    get_colls_resp = loadFixture(RESOURCE + "get_coll_resp.json", GetCollectionsResponse.class);
    get_coll_resp = loadFixture(RESOURCE + "get_coll1_resp.json", GetCollectionResponse.class);
    delete_coll_resp = loadFixture(RESOURCE + "delete_coll_resp.json", DeleteCollectionResponse.class);
    listfields_coll_resp = loadFixture(RESOURCE + "listfields_coll_resp.json", GetCollectionFieldsResponse.class);
    create_doc_resp = loadFixture(RESOURCE + "create_doc_resp.json", CreateDocumentResponse.class);
    update_doc_resp = loadFixture(RESOURCE + "update_doc_resp.json", UpdateDocumentResponse.class);
    get_doc_resp = loadFixture(RESOURCE + "get_doc_resp.json", GetDocumentResponse.class);
    delete_doc_resp = loadFixture(RESOURCE + "delete_doc_resp.json", DeleteDocumentResponse.class);
    query_resp = loadFixture(RESOURCE + "query1_resp.json", QueryResponse.class);
  }

  @After
  public void cleanup() {
  }

  // Environment tests
  @Test
  public void get_environment_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(env_resp));
    GetEnvironmentRequest getRequest = new GetEnvironmentRequest.Builder(environmentId).build();
    GetEnvironmentResponse response = discoveryService.getEnvironment(getRequest).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(ENV1_PATH, request.getPath()); 
    assertEquals(GET, request.getMethod());
    assertEquals(env_resp, response);
  }

  @Test(expected = IllegalArgumentException.class)
  public void get_environment_fails1() {
    GetEnvironmentRequest getRequest = new GetEnvironmentRequest.Builder("").build();
    @SuppressWarnings("unused")
    GetEnvironmentResponse response = discoveryService.getEnvironment(getRequest).execute();
  }

  @Test(expected = NullPointerException.class)
  public void get_environment_fails2() {
    @SuppressWarnings("unused")
    GetEnvironmentResponse response = discoveryService.getEnvironment(null).execute();
  }

  @Test
  public void get_environments_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(envs_resp));
    GetEnvironmentsRequest getRequest = new GetEnvironmentsRequest.Builder().build();
    GetEnvironmentsResponse response = discoveryService.getEnvironments(getRequest).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(ENV2_PATH, request.getPath()); 
    assertEquals(GET, request.getMethod());
    assertEquals(envs_resp, response);
  }

  @Test(expected = NullPointerException.class)
  public void get_environments_fails() {
    @SuppressWarnings("unused")
    GetEnvironmentsResponse response = discoveryService.getEnvironments(null).execute();
  }

  @Test
  public void create_environment_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(create_env_resp));
    CreateEnvironmentRequest.Builder createRequestBuilder = new CreateEnvironmentRequest.Builder(environmentName, CreateEnvironmentRequest.Size.THREE);
    createRequestBuilder.description(environmentDesc);
    CreateEnvironmentResponse response = discoveryService.createEnvironment(createRequestBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(ENV2_PATH, request.getPath()); 
    assertEquals(POST, request.getMethod());
    assertEquals(create_env_resp, response);
  }

  @Test(expected = IllegalArgumentException.class)
  public void create_environment_fails() {
    CreateEnvironmentRequest.Builder createRequestBuilder = new CreateEnvironmentRequest.Builder(null, CreateEnvironmentRequest.Size.FREE);
    createRequestBuilder.description(null);
    @SuppressWarnings("unused")
    CreateEnvironmentResponse response = discoveryService.createEnvironment(createRequestBuilder.build()).execute();
  }

  @Test
  public void delete_environment_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(delete_env_resp));
    DeleteEnvironmentRequest deleteRequest = new DeleteEnvironmentRequest.Builder(environmentId).build();
    DeleteEnvironmentResponse response = discoveryService.deleteEnvironment(deleteRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(ENV1_PATH, request.getPath()); 
    assertEquals(DELETE, request.getMethod());
    assertEquals(delete_env_resp, response);
  }

  @Test(expected = NullPointerException.class)
  public void delete_environment_fails() {
    @SuppressWarnings("unused")
    DeleteEnvironmentResponse response = discoveryService.deleteEnvironment(null).execute();
  }

  @Test
  public void update_environment_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(update_env_resp));
    UpdateEnvironmentRequest.Builder updateBuilder = new UpdateEnvironmentRequest.Builder(environmentId, environmentName);
    updateBuilder.description(environmentDesc);
    UpdateEnvironmentResponse response = discoveryService.updateEnvironment(updateBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(ENV1_PATH, request.getPath()); 
    assertEquals(PUT, request.getMethod());
    assertEquals(update_env_resp, response);
  }

  // Configuration tests
  @Test
  public void create_configuration_is_successful() throws JsonSyntaxException, JsonIOException, FileNotFoundException, InterruptedException {
    server.enqueue(jsonResponse(create_conf_resp));
    CreateConfigurationRequest.Builder createBuilder = new CreateConfigurationRequest.Builder(environmentId);
    Configuration configuration = GsonSingleton.getGson().fromJson(new FileReader(DISCOVERY_TEST_CONFIG_FILE), Configuration.class);
    configuration.setName(uniqueConfigName);
    createBuilder.configuration(configuration);
    CreateConfigurationResponse response = discoveryService.createConfiguration(createBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF1_PATH, request.getPath()); 
    assertEquals(POST, request.getMethod());
    assertEquals(create_conf_resp, response);
  }

  @Test
  public void get_configuration_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(get_conf_resp));
    GetConfigurationRequest getRequest = new GetConfigurationRequest.Builder(environmentId, configurationId).build();
    GetConfigurationResponse response = discoveryService.getConfiguration(getRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF2_PATH, request.getPath()); 
    assertEquals(GET, request.getMethod());
    assertEquals(get_conf_resp, response);
  }

  @Test
  public void get_configurations_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(get_confs_resp));
    GetConfigurationsRequest getRequest = new GetConfigurationsRequest.Builder(environmentId).build();
    GetConfigurationsResponse response = discoveryService.getConfigurations(getRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF1_PATH, request.getPath()); 
    assertEquals(GET, request.getMethod());
    assertEquals(get_confs_resp, response);
  }

  @Test
  public void delete_configuration_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(delete_conf_resp));
    DeleteConfigurationRequest deleteRequest = new DeleteConfigurationRequest.Builder(environmentId, configurationId).build();
    DeleteConfigurationResponse response = discoveryService.deleteConfiguration(deleteRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF2_PATH, request.getPath()); 
    assertEquals(DELETE, request.getMethod());
    assertEquals(delete_conf_resp, response);
  }

  @Test
  public void update_configuration_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(update_conf_resp));
    UpdateConfigurationRequest.Builder updateBuilder = new UpdateConfigurationRequest.Builder(environmentId, configurationId);

    Configuration new_conf = new Configuration();
    new_conf.setName("newName");
    updateBuilder.configuration(new_conf);

    UpdateConfigurationResponse response = discoveryService.updateConfiguration(updateBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONF2_PATH, request.getPath()); 
    assertEquals(PUT, request.getMethod());
    assertEquals(update_conf_resp, response);
  }

  // Collection tests
  @Test
  public void create_collection_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(create_coll_resp));
    CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder(environmentId, configurationId, uniqueCollectionName);
    CreateCollectionResponse response = discoveryService.createCollection(createCollectionBuilder.build()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL1_PATH, request.getPath()); 
    assertEquals(POST, request.getMethod());
    assertEquals(create_coll_resp, response);
  }

  @Test
  public void get_collections_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(get_colls_resp));
    GetCollectionsRequest getRequest = new GetCollectionsRequest.Builder(environmentId).build();
    GetCollectionsResponse response = discoveryService.getCollections(getRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL1_PATH, request.getPath()); 
    assertEquals(GET, request.getMethod());
    assertEquals(get_colls_resp, response);
  }

  @Test
  public void get_collection_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(get_coll_resp));
    GetCollectionRequest getRequest = new GetCollectionRequest.Builder(environmentId, collectionId).build();
    GetCollectionResponse response = discoveryService.getCollection(getRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL2_PATH, request.getPath()); 
    assertEquals(GET, request.getMethod());
    assertEquals(get_coll_resp, response);
  }

  // no updateCollection yet?

  @Test
  public void listfields_collection_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(listfields_coll_resp));
    GetCollectionFieldsRequest getRequest = new GetCollectionFieldsRequest.Builder(environmentId, collectionId).build();
    GetCollectionFieldsResponse response = discoveryService.getCollectionFields(getRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL3_PATH, request.getPath()); 
    assertEquals(GET, request.getMethod());
    assertEquals(listfields_coll_resp, response);
  }

  @Test
  public void delete_collection_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(delete_coll_resp));
    DeleteCollectionRequest deleteRequest = new DeleteCollectionRequest.Builder(environmentId, collectionId).build();
    DeleteCollectionResponse response = discoveryService.deleteCollection(deleteRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COLL2_PATH, request.getPath()); 
    assertEquals(DELETE, request.getMethod());
    assertEquals(delete_coll_resp, response);
  }

  // Document tests
  @Test
  public void create_document_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(create_doc_resp));
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
    assertEquals(create_doc_resp, response);
  }

  @Test
  public void update_document_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(update_doc_resp));
    UpdateDocumentRequest.Builder updateBuilder = new UpdateDocumentRequest.Builder(environmentId, collectionId, documentId);
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
    assertEquals(update_doc_resp, response);
  }

  @Test
  public void get_document_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(get_doc_resp));
    GetDocumentRequest getRequest = new GetDocumentRequest.Builder(environmentId, collectionId, documentId).build();
    GetDocumentResponse response = discoveryService.getDocument(getRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS2_PATH, request.getPath()); 
    assertEquals(GET, request.getMethod());
    assertEquals(get_doc_resp, response);
  }

  @Test
  public void delete_document_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(delete_doc_resp));
    DeleteDocumentRequest deleteRequest = new DeleteDocumentRequest.Builder(environmentId, collectionId, documentId).build();
    DeleteDocumentResponse response = discoveryService.deleteDocument(deleteRequest).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(DOCS2_PATH, request.getPath()); 
    assertEquals(DELETE, request.getMethod());
    assertEquals(delete_doc_resp, response);
  }

  // Query tests
  @Test
  public void query_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(query_resp));
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
    assertEquals(query_resp, response);
  }

  @Test
  public void query_with_aggregation_term_is_successful() throws InterruptedException {
    server.enqueue(jsonResponse(query_resp));
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
    assertEquals(query_resp, response);
  }

}

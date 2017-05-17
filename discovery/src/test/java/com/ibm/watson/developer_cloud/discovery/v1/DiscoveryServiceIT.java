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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ibm.watson.developer_cloud.WatsonServiceTest;
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
import com.ibm.watson.developer_cloud.discovery.v1.model.common.Status;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.Configuration;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.CreateConfigurationRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.CreateConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.DeleteConfigurationRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.DeleteConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.GetConfigurationRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.GetConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.GetConfigurationsRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.GetConfigurationsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.NormalizationOperation;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.NormalizationOperation.Operation;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.UpdateConfigurationRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.UpdateConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.CreateDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.CreateDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.DeleteDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.DeleteDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.Document;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.DocumentManager;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.GetDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.GetDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.UpdateDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.UpdateDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.CreateEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.CreateEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.DeleteEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.DeleteEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.Environment;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentsRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.UpdateEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.UpdateEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.AggregationType;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.Calculation;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.Histogram;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.Operator;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.Term;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.service.exception.ForbiddenException;
import com.ibm.watson.developer_cloud.service.exception.UnauthorizedException;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.RetryRunner;
import com.ibm.watson.developer_cloud.util.WaitFor;

/**
 * Integration tests for {@link Discovery}.
 *
 */
@RunWith(RetryRunner.class)
public class DiscoveryServiceIT extends WatsonServiceTest {
  private static final String DISCOVERY_TEST_CONFIG_FILE = "src/test/resources/discovery/test-config.json";
  private static final String DISCOVERY1_TEST_CONFIG_FILE = "src/test/resources/discovery/issue517.json";
  private static final String DISCOVERY2_TEST_CONFIG_FILE = "src/test/resources/discovery/issue518.json";
  private static String environmentId;
  private Discovery discovery;
  private String uniqueName;

  private Set<String> configurationIds = new HashSet<String>();
  private Set<String> collectionIds = new HashSet<String>();

  @BeforeClass
  public static void setupClass() {
    // get the properties
    DiscoveryServiceIT dummyTest = new DiscoveryServiceIT();
    String username = dummyTest.getProperty("discovery.username");
    String password = dummyTest.getProperty("discovery.password");
    String url = dummyTest.getProperty("discovery.url");
    Discovery discovery = new Discovery("2016-12-16");
    discovery.setEndPoint(url);
    discovery.setUsernameAndPassword(username, password);

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    GetEnvironmentsRequest getRequest = new GetEnvironmentsRequest.Builder().build();
    GetEnvironmentsResponse getResponse = discovery.getEnvironments(getRequest).execute();
    for (Environment environment : getResponse.getEnvironments()) {
      // look for an existing environment that isn't read only
      if (!environment.isReadOnly()) {
        environmentId = environment.getEnvironmentId();
        break;
      }
    }

    if (environmentId == null) {
      // no environment found, create a new one (assuming we are a FREE plan)
      String environmentName = "watson_developer_cloud_test_environment";
      CreateEnvironmentRequest.Size size = CreateEnvironmentRequest.Size.FREE;
      CreateEnvironmentRequest createRequest = new CreateEnvironmentRequest.Builder(environmentName, size).build();
      CreateEnvironmentResponse createResponse = discovery.createEnvironment(createRequest).execute();
      environmentId = createResponse.getEnvironmentId();
      WaitFor.Condition environmentReady = new EnvironmentReady(discovery, environmentId);
      WaitFor.waitFor(environmentReady, 30, TimeUnit.SECONDS, 500);
    }
  }

  @Before
  public void setup() throws Exception {
    super.setUp();
    String username = getProperty("discovery.username");
    String password = getProperty("discovery.password");
    String url = getProperty("discovery.url");
    discovery = new Discovery("2016-12-16");
    discovery.setEndPoint(url);
    discovery.setUsernameAndPassword(username, password);

    uniqueName = UUID.randomUUID().toString();
  }

  @After
  public void cleanup() {
    for (String collectionId : collectionIds) {
      DeleteCollectionRequest deleteRequest = new DeleteCollectionRequest.Builder(environmentId, collectionId).build();
      discovery.deleteCollection(deleteRequest).execute();
    }

    for (String configurationId : configurationIds) {
      DeleteConfigurationRequest deleteRequest =
          new DeleteConfigurationRequest.Builder(environmentId, configurationId).build();
      discovery.deleteConfiguration(deleteRequest).execute();
    }
  }

  @Test
  public void pingIsSuccessful() {
    assertTrue(discovery.ping());
  }

  @Test(expected = UnauthorizedException.class)
  public void pingBadCredentialsThrowsException() {
    discovery.setUsernameAndPassword("foo", "bar");
    discovery.ping();
  }

  @Test(expected = ForbiddenException.class)
  public void pingBadUrlThrowsException() {
    discovery.setEndPoint("https://gateway.watsonplatform.net/discovery-foo/api");
    discovery.ping();
  }

  @Test
  public void getEnvironmentIsSuccessful() {
    GetEnvironmentRequest getRequest = new GetEnvironmentRequest.Builder(environmentId).build();
    GetEnvironmentResponse getResponse = discovery.getEnvironment(getRequest).execute();

    assertEquals(environmentId, getResponse.getEnvironmentId());
  }

  @Test
  public void getEnvironmentsIsSuccessful() {
    GetEnvironmentsRequest getRequest = new GetEnvironmentsRequest.Builder().build();
    GetEnvironmentsResponse getResponse = discovery.getEnvironments(getRequest).execute();

    assertFalse(getResponse.getEnvironments().isEmpty());
  }

  @Test
  public void getEnvironmentsHasNewsEnvironment() {
    GetEnvironmentsRequest getRequest = new GetEnvironmentsRequest.Builder().build();
    GetEnvironmentsResponse getResponse = discovery.getEnvironments(getRequest).execute();

    boolean foundNews = false;
    for (Environment environment : getResponse.getEnvironments()) {
      if (environment.isReadOnly()) {
        foundNews = true;
        break;
      }
    }
    assertTrue(foundNews);
  }

  @Test
  public void getEnvironmentsByNameIsSuccessful() {
    GetEnvironmentRequest getRequest = new GetEnvironmentRequest.Builder(environmentId).build();
    GetEnvironmentResponse getResponse = discovery.getEnvironment(getRequest).execute();

    GetEnvironmentsRequest.Builder getBuilder = new GetEnvironmentsRequest.Builder();
    getBuilder.name(getResponse.getName());
    GetEnvironmentsResponse getsResponse = discovery.getEnvironments(getBuilder.build()).execute();

    assertEquals(1, getsResponse.getEnvironments().size());
  }

  @Test
  @Ignore("Only 1 BYOD environment allowed per service instance, so we cannot create more")
  public void createEnvironmentIsSuccessful() {
    String environmentName = uniqueName + "-environment";
    CreateEnvironmentRequest createRequest =
        new CreateEnvironmentRequest.Builder(environmentName, CreateEnvironmentRequest.Size.FREE).build();
    CreateEnvironmentResponse createResponse = createEnvironment(createRequest);

    assertEquals(environmentName, createResponse.getName());
  }

  @Test
  @Ignore("Only 1 BYOD environment allowed per service instance, so do not delete it")
  public void deleteEnvironmentIsSuccessful() {
    String environmentName = uniqueName + "-environment";
    CreateEnvironmentRequest createRequest =
        new CreateEnvironmentRequest.Builder(environmentName, CreateEnvironmentRequest.Size.FREE).build();
    CreateEnvironmentResponse createResponse = createEnvironment(createRequest);

    DeleteEnvironmentRequest deleteRequest =
        new DeleteEnvironmentRequest.Builder(createResponse.getEnvironmentId()).build();
    DeleteEnvironmentResponse deleteRepsonse = deleteEnvironment(deleteRequest);

    assertEquals(createResponse.getEnvironmentId(), deleteRepsonse.getEnvironmentId());
  }

  @Test
  @Ignore("Only 1 BYOD environment allowed per service instance, so we cannot create more")
  public void updateEnvironmentIsSuccessful() {
    String environmentName = uniqueName + "-environment";
    CreateEnvironmentRequest createRequest =
        new CreateEnvironmentRequest.Builder(environmentName, CreateEnvironmentRequest.Size.FREE).build();
    CreateEnvironmentResponse createResponse = createEnvironment(createRequest);

    String randomDescription = UUID.randomUUID().toString() + " appbuilder tests";
    UpdateEnvironmentRequest.Builder updateBuilder =
        new UpdateEnvironmentRequest.Builder(createResponse.getEnvironmentId(), environmentName);
    updateBuilder.description(randomDescription);
    UpdateEnvironmentResponse updateResponse = discovery.updateEnvironment(updateBuilder.build()).execute();

    assertEquals(randomDescription, updateResponse.getDescription());
  }

  @Test
  public void getConfigurationsIsSuccessful() {
    GetConfigurationsRequest getRequest = new GetConfigurationsRequest.Builder(environmentId).build();
    GetConfigurationsResponse getResponse = discovery.getConfigurations(getRequest).execute();

    assertFalse(getResponse.getConfigurations().isEmpty());
  }

  @Test
  public void createConfigurationIsSuccessful() {
    String uniqueConfigName = uniqueName + "-config";
    CreateConfigurationRequest.Builder createBuilder = new CreateConfigurationRequest.Builder(environmentId);
    Configuration configuration = getTestConfiguration(DISCOVERY_TEST_CONFIG_FILE);
    configuration.setName(uniqueConfigName);
    createBuilder.configuration(configuration);
    CreateConfigurationResponse createResponse = createConfiguration(createBuilder.build());

    assertEquals(uniqueConfigName, createResponse.getName());
  }

  @Test
  public void deleteConfigurationIsSuccessful() {
    CreateConfigurationResponse createResponse = createTestConfig();

    DeleteConfigurationRequest deleteRequest =
        new DeleteConfigurationRequest.Builder(environmentId, createResponse.getConfigurationId()).build();
    DeleteConfigurationResponse deleteResponse = deleteConfiguration(deleteRequest);

    assertEquals(createResponse.getConfigurationId(), deleteResponse.getConfigurationId());
  }

  @Test
  public void getConfigurationIsSuccessful() {
    CreateConfigurationResponse createResponse = createTestConfig();

    GetConfigurationRequest getRequest =
        new GetConfigurationRequest.Builder(environmentId, createResponse.getConfigurationId()).build();
    GetConfigurationResponse getResponse = discovery.getConfiguration(getRequest).execute();

    assertEquals(createResponse.getName(), getResponse.getName());
  }

  @Test
  public void getConfigurationsByNameIsSuccessful() {
    CreateConfigurationResponse createResponse = createTestConfig();

    GetConfigurationsRequest.Builder getBuilder = new GetConfigurationsRequest.Builder(environmentId);
    getBuilder.name(createResponse.getName());
    GetConfigurationsResponse getResponse = discovery.getConfigurations(getBuilder.build()).execute();

    assertEquals(1, getResponse.getConfigurations().size());
    assertEquals(createResponse.getName(), getResponse.getConfigurations().get(0).getName());
  }

  @Test
  public void getConfigurationsWithFunkyNameIsSuccessful() {
    String uniqueConfigName = uniqueName + " with \"funky\" ?x=y&foo=bar ,[x](y) ~!@#$%^&*()-+ {} | ;:<>\\/ chars";

    CreateConfigurationRequest.Builder createBuilder = new CreateConfigurationRequest.Builder(environmentId);
    Configuration configuration = getTestConfiguration(DISCOVERY_TEST_CONFIG_FILE);
    configuration.setName(uniqueConfigName);
    createBuilder.configuration(configuration);
    CreateConfigurationResponse createResponse = createConfiguration(createBuilder.build());

    GetConfigurationsRequest.Builder getBuilder = new GetConfigurationsRequest.Builder(environmentId);
    getBuilder.name(uniqueConfigName);
    GetConfigurationsResponse getResponse = discovery.getConfigurations(getBuilder.build()).execute();

    assertEquals(1, getResponse.getConfigurations().size());
    assertEquals(uniqueConfigName, getResponse.getConfigurations().get(0).getName());
  }

  @Test
  public void updateConfigurationIsSuccessful() {
    CreateConfigurationResponse createResponse = createTestConfig();

    String newUniqueName = createResponse.getName() + UUID.randomUUID().toString();
    UpdateConfigurationRequest.Builder updateBuilder =
        new UpdateConfigurationRequest.Builder(environmentId, createResponse.getConfigurationId());
    createResponse.setName(newUniqueName);
    updateBuilder.configuration(createResponse);
    UpdateConfigurationResponse updateResponse = discovery.updateConfiguration(updateBuilder.build()).execute();

    assertEquals(newUniqueName, updateResponse.getName());
  }

  @Test
  public void getCollectionsIsSuccessful() {
    createTestCollection();
    GetCollectionsRequest getRequest = new GetCollectionsRequest.Builder(environmentId).build();
    GetCollectionsResponse getResponse = discovery.getCollections(getRequest).execute();

    assertFalse(getResponse.getCollections().isEmpty());
  }

  @Test
  public void createCollectionIsSuccessful() {
    CreateConfigurationResponse createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder(environmentId,
        createConfigResponse.getConfigurationId(), uniqueCollectionName);
    CreateCollectionResponse createResponse = createCollection(createCollectionBuilder.build());

    assertEquals(uniqueCollectionName, createResponse.getName());
  }

  @Test
  public void setConfigurationIsSuccessful() {
    GetConfigurationsRequest getRequest = new GetConfigurationsRequest.Builder(environmentId).build();
    GetConfigurationsResponse getResponse = discovery.getConfigurations(getRequest).execute();
    String configurationId = getResponse.getConfigurations().get(0).getConfigurationId().toString();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder(environmentId,
           configurationId , uniqueCollectionName);
    CreateCollectionResponse createResponse = createCollection(createCollectionBuilder.build());

    assertEquals(configurationId, createResponse.getConfigurationId());
  }

  @Test
  public void deleteCollectionIsSuccessful() {
    CreateConfigurationResponse createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder(environmentId,
        createConfigResponse.getConfigurationId(), uniqueCollectionName);
    CreateCollectionResponse createResponse = createCollection(createCollectionBuilder.build());

    // need to wait for collection to be ready

    DeleteCollectionRequest deleteRequest =
        new DeleteCollectionRequest.Builder(environmentId, createResponse.getCollectionId()).build();
    DeleteCollectionResponse deleteResponse = deleteCollection(deleteRequest);

    assertEquals(Status.DELETED, deleteResponse.getStatus());
  }

  @Test
  public void getCollectionIsSuccessful() {
    CreateConfigurationResponse createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder(environmentId,
        createConfigResponse.getConfigurationId(), uniqueCollectionName);
    CreateCollectionResponse createResponse = createCollection(createCollectionBuilder.build());

    GetCollectionRequest getRequest =
        new GetCollectionRequest.Builder(environmentId, createResponse.getCollectionId()).build();

    // need to wait for collection to be ready

    GetCollectionResponse getResponse = discovery.getCollection(getRequest).execute();

    assertEquals(createResponse.getName(), getResponse.getName());
  }

  @Test
  public void getCollectionsByNameIsSuccessful() {
    CreateConfigurationResponse createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder(environmentId,
        createConfigResponse.getConfigurationId(), uniqueCollectionName);
    createCollection(createCollectionBuilder.build());

    GetCollectionsRequest.Builder getBuilder = new GetCollectionsRequest.Builder(environmentId);
    getBuilder.name(uniqueCollectionName);
    GetCollectionsResponse getResponse = discovery.getCollections(getBuilder.build()).execute();

    assertEquals(1, getResponse.getCollections().size());
    assertEquals(uniqueCollectionName, getResponse.getCollections().get(0).getName());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void createDocumentIsSuccessful() {
    CreateCollectionResponse createCollectionResponse = createTestCollection();

    String myDocumentJson = "{\"field\":\"value\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    CreateDocumentRequest.Builder builder =
        new CreateDocumentRequest.Builder(environmentId, createCollectionResponse.getCollectionId());
    builder.inputStream(documentStream, HttpMediaType.APPLICATION_JSON);

    CreateDocumentResponse createResponse = discovery.createDocument(builder.build()).execute();
    assertFalse(createResponse.getDocumentId().isEmpty());
    assertNull(createResponse.getNotices());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void createDocumentWithMetadataIsSuccessful() {
    CreateCollectionResponse createCollectionResponse = createTestCollection();
    String collectionId = createCollectionResponse.getCollectionId();

    String myDocumentJson = "{\"field\":\"value\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    CreateDocumentRequest.Builder builder = new CreateDocumentRequest.Builder(environmentId, collectionId);
    builder.inputStream(documentStream, HttpMediaType.APPLICATION_JSON);
    builder.metadata(myMetadata);

    CreateDocumentResponse createResponse = discovery.createDocument(builder.build()).execute();

    WaitFor.Condition documentAccepted =
        new DocumentAccepted(environmentId, collectionId, createResponse.getDocumentId());
    WaitFor.waitFor(documentAccepted, 5, TimeUnit.SECONDS, 500);

    QueryRequest queryRequest = new QueryRequest.Builder(environmentId, collectionId).build();
    QueryResponse queryResponse = discovery.query(queryRequest).execute();

    assertTrue(queryResponse.getResults().get(0).containsKey(DocumentManager.METADATA));
  }

  @Test
  public void deleteDocumentIsSuccessful() {
    CreateCollectionResponse createCollectionResponse = createTestCollection();
    String collectionId = createCollectionResponse.getCollectionId();
    CreateDocumentResponse createDocumentResponse = createTestDocument(collectionId);

    DeleteDocumentRequest deleteRequest =
        new DeleteDocumentRequest.Builder(environmentId, collectionId, createDocumentResponse.getDocumentId()).build();
    DeleteDocumentResponse deleteResponse = discovery.deleteDocument(deleteRequest).execute();
    assertEquals(Status.DELETED, deleteResponse.getStatus());
  }

  @Test
  public void getDocumentIsSuccessful() {
    CreateCollectionResponse createCollectionResponse = createTestCollection();
    String collectionId = createCollectionResponse.getCollectionId();
    CreateDocumentResponse createDocumentResponse = createTestDocument(collectionId);

    GetDocumentRequest getRequest =
        new GetDocumentRequest.Builder(environmentId, collectionId, createDocumentResponse.getDocumentId()).build();
    GetDocumentResponse getResponse = discovery.getDocument(getRequest).execute();

    assertEquals(Document.Status.AVAILABLE, getResponse.getStatus());
  }

  @Test
  public void updateDocumentIsSuccessful() {
    CreateCollectionResponse createCollectionResponse = createTestCollection();
    String collectionId = createCollectionResponse.getCollectionId();
    CreateDocumentResponse createDocumentResponse = createTestDocument(collectionId);

    UpdateDocumentRequest.Builder updateBuilder =
        new UpdateDocumentRequest.Builder(environmentId, collectionId, createDocumentResponse.getDocumentId());
    String myDocumentJson = "{\"field\":\"value2\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());
    updateBuilder.inputStream(documentStream, HttpMediaType.APPLICATION_JSON);
    UpdateDocumentResponse updateResponse = discovery.updateDocument(updateBuilder.build()).execute();

    WaitFor.Condition documentAccepted =
        new DocumentAccepted(environmentId, collectionId, createDocumentResponse.getDocumentId());
    WaitFor.waitFor(documentAccepted, 5, TimeUnit.SECONDS, 500);

    GetDocumentRequest getRequest =
        new GetDocumentRequest.Builder(environmentId, collectionId, updateResponse.getDocumentId()).build();
    GetDocumentResponse getResponse = discovery.getDocument(getRequest).execute();

    assertEquals(Document.Status.AVAILABLE, getResponse.getStatus());
  }

  @Test
  @Ignore("Pending implementation of 'processing' after document update")
  public void updateDocumentWithMetadataIsSuccessful() {
    CreateCollectionResponse createCollectionResponse = createTestCollection();
    String collectionId = createCollectionResponse.getCollectionId();
    CreateDocumentResponse createDocumentResponse = createTestDocument(collectionId);

    String myDocumentJson = "{\"field\":\"value2\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    UpdateDocumentRequest.Builder updateBuilder =
        new UpdateDocumentRequest.Builder(environmentId, collectionId, createDocumentResponse.getDocumentId());
    updateBuilder.inputStream(documentStream, HttpMediaType.APPLICATION_JSON);
    updateBuilder.metadata(myMetadata);
    UpdateDocumentResponse updateResponse = discovery.updateDocument(updateBuilder.build()).execute();

    WaitFor.Condition documentAccepted =
        new DocumentAccepted(environmentId, collectionId, updateResponse.getDocumentId());
    WaitFor.waitFor(documentAccepted, 5, TimeUnit.SECONDS, 500);

    QueryRequest queryRequest = new QueryRequest.Builder(environmentId, collectionId).build();
    QueryResponse queryResponse = discovery.query(queryRequest).execute();

    assertTrue(queryResponse.getResults().get(0).containsKey(DocumentManager.METADATA));
  }

  @Test
  public void getCollectionFieldsIsSuccessful() {
    CreateCollectionResponse createCollectionResponse = createTestCollection();
    String collectionId = createCollectionResponse.getCollectionId();
    createTestDocument(collectionId);

    GetCollectionFieldsRequest getRequest = new GetCollectionFieldsRequest.Builder(environmentId, collectionId).build();
    GetCollectionFieldsResponse getResponse = discovery.getCollectionFields(getRequest).execute();

    assertFalse(getResponse.getFields().isEmpty());
  }

  @Test
  public void queryWithCountIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
    queryBuilder.count(5);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    assertEquals(new Long(10), queryResponse.getMatchingResults());
    assertEquals(5, queryResponse.getResults().size());
  }

  @Test
  public void queryWithOffsetIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
    queryBuilder.offset(5);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    assertEquals(new Long(10), queryResponse.getMatchingResults());
    assertEquals(5, queryResponse.getResults().size());
  }

  @Test
  public void queryWithReturnFieldsIsSuccessful() {
    String collectionId = setupTestDocuments();
    createTestDocument("{\"field_2\":\"value_2\"}", collectionId);

    QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
    Set<String> fieldNames = new HashSet<String>();
    fieldNames.add("field");
    queryBuilder.returnFields(fieldNames);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    String[] expected = new String[] { "id", "score", "field" };
    assertArrayEquals(expected, queryResponse.getResults().get(0).keySet().toArray());
  }

  @Test
  public void queryWithQueryIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
    queryBuilder.query("field" + Operator.CONTAINS + 1);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    assertEquals(new Long(1), queryResponse.getMatchingResults());
    assertEquals(1, queryResponse.getResults().size());
    assertTrue((Double) queryResponse.getResults().get(0).get("score") > 1.0);
  }

  @Test
  public void queryWithFilterIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
    queryBuilder.filter("field" + Operator.CONTAINS + 1);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    assertEquals(new Long(1), queryResponse.getMatchingResults());
    assertEquals(1, queryResponse.getResults().size());
  }

  @Test
  public void queryWithAggregationTermIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.TERM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    assertEquals(1, queryResponse.getAggregations().size());
  }

  @Test
  public void queryWithNestedAggregationTermIsSuccessful() {
    CreateCollectionResponse createCollectionResponse = createTestCollection();
    String collectionId = createCollectionResponse.getCollectionId();
    createTestDocument(collectionId);
    createTestDocument(collectionId);

    QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.TERM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    sb.append(Operator.NEST_AGGREGATION);
    sb.append(AggregationType.TERM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    Term term = (Term) queryResponse.getAggregations().get(0);
    assertFalse(term.getResults().get(0).getAggregations().isEmpty());
  }

  @Test
  public void queryWithAggregationHistogramIsSuccessful() throws InterruptedException {
    String collectionName = setupTestDocuments();

    QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionName);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.HISTOGRAM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.AND);
    sb.append(5);
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    Histogram histogram = (Histogram) queryResponse.getAggregations().get(0);
    assertEquals(new Long(5), histogram.getInterval());
    assertEquals(2, histogram.getResults().size());
  }

  @Test
  public void queryWithAggregationMaximumIsSuccessful() throws InterruptedException {
    String collectionName = setupTestDocuments();

    QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionName);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.MAX);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    Calculation max = (Calculation) queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.MAX.getName(), max.getType());
    assertEquals(new Double(9), max.getValue());
  }

  @Test
  public void queryWithAggregationMinimumIsSuccessful() throws InterruptedException {
    String collectionName = setupTestDocuments();

    QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionName);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.MIN);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    Calculation min = (Calculation) queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.MIN.getName(), min.getType());
    assertEquals(new Double(0), min.getValue());
  }

  @Test
  public void queryWithAggregationSummationIsSuccessful() throws InterruptedException {
    String collectionName = setupTestDocuments();

    QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionName);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.SUM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    Calculation sum = (Calculation) queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.SUM.getName(), sum.getType());
    assertEquals(new Double(45), sum.getValue());
  }

  @Test
  public void queryWithAggregationAverageIsSuccessful() throws InterruptedException {
    String collectionName = setupTestDocuments();

    QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionName);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.AVERAGE);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    Calculation avg = (Calculation) queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.AVERAGE.getName(), avg.getType());
    assertEquals(new Double(4.5), avg.getValue());
  }

  @Test
  public void issueNumber517() {
    String uniqueConfigName = uniqueName + "-config";
    CreateConfigurationRequest.Builder createBuilder = new CreateConfigurationRequest.Builder(environmentId);
    Configuration configuration = getTestConfiguration(DISCOVERY1_TEST_CONFIG_FILE);

    configuration.setName(uniqueConfigName);
    createBuilder.configuration(configuration);
    CreateConfigurationResponse createResponse = createConfiguration(createBuilder.build());

    GetConfigurationRequest getRequest =
        new GetConfigurationRequest.Builder(environmentId, createResponse.getConfigurationId()).build();
    GetConfigurationResponse getResponse = discovery.getConfiguration(getRequest).execute();

    // returned config should have some json data
    assertEquals(1, getResponse.getConversions().getJson().size());
  }

  @Test
  public void issueNumber518() {
    String[] operations = new String[] { "MOVE", "COPY", "MERGE", "REMOVE", "REMOVE_NULLS" };

    String uniqueConfigName = uniqueName + "-config";
    CreateConfigurationRequest.Builder createBuilder = new CreateConfigurationRequest.Builder(environmentId);
    Configuration configuration = getTestConfiguration(DISCOVERY2_TEST_CONFIG_FILE);

    configuration.setName(uniqueConfigName);
    createBuilder.configuration(configuration);
    CreateConfigurationResponse createResponse = createConfiguration(createBuilder.build());

    GetConfigurationRequest getRequest =
        new GetConfigurationRequest.Builder(environmentId, createResponse.getConfigurationId()).build();
    GetConfigurationResponse getResponse = discovery.getConfiguration(getRequest).execute();

    // verify getResponse deserializes the operations appropriately
    for (NormalizationOperation normalization : getResponse.getNormalizations()) {
      Operation operation = normalization.getOperation();
      assertEquals(true, Arrays.asList(operations).contains(operation.name()));
    }
  }

  @Test
  public void issueNumber654() {
    String collectionId = setupTestDocuments();
    QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
    queryBuilder.query("field:1|3");
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();

    assertEquals(new Long(2), queryResponse.getMatchingResults());
    assertEquals(2, queryResponse.getResults().size());
  }

  private CreateEnvironmentResponse createEnvironment(CreateEnvironmentRequest createRequest) {
    CreateEnvironmentResponse createResponse = discovery.createEnvironment(createRequest).execute();
    return createResponse;
  }

  private DeleteEnvironmentResponse deleteEnvironment(DeleteEnvironmentRequest deleteRequest) {
    DeleteEnvironmentResponse deleteResponse = discovery.deleteEnvironment(deleteRequest).execute();
    return deleteResponse;
  }

  private CreateConfigurationResponse createConfiguration(CreateConfigurationRequest createRequest) {
    CreateConfigurationResponse createResponse = discovery.createConfiguration(createRequest).execute();
    configurationIds.add(createResponse.getConfigurationId());
    return createResponse;
  }

  private DeleteConfigurationResponse deleteConfiguration(DeleteConfigurationRequest deleteRequest) {
    DeleteConfigurationResponse deleteResponse = discovery.deleteConfiguration(deleteRequest).execute();
    configurationIds.remove(deleteResponse.getConfigurationId());
    return deleteResponse;
  }

  private CreateConfigurationResponse createTestConfig() {
    String uniqueConfigName = uniqueName + "-config";
    CreateConfigurationRequest.Builder createBuilder = new CreateConfigurationRequest.Builder(environmentId);
    Configuration configuration = getTestConfiguration(DISCOVERY_TEST_CONFIG_FILE);
    configuration.setName(uniqueConfigName);
    createBuilder.configuration(configuration);
    return createConfiguration(createBuilder.build());
  }

  private CreateCollectionResponse createCollection(CreateCollectionRequest createRequest) {
    CreateCollectionResponse createResponse = discovery.createCollection(createRequest).execute();
    collectionIds.add(createResponse.getCollectionId());
    return createResponse;
  }

  private DeleteCollectionResponse deleteCollection(DeleteCollectionRequest deleteRequest) {
    DeleteCollectionResponse deleteResponse = discovery.deleteCollection(deleteRequest).execute();
    collectionIds.remove(deleteResponse.getCollectionId());
    return deleteResponse;
  }

  private CreateCollectionResponse createTestCollection() {
    CreateConfigurationResponse createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder(environmentId,
        createConfigResponse.getConfigurationId(), uniqueCollectionName);
    CreateCollectionResponse createResponse = createCollection(createCollectionBuilder.build());
    return createResponse;
  }

  private CreateDocumentResponse createTestDocument(String collectionId) {
    String myDocumentJson = "{\"field\":\"value\"}";
    return createTestDocument(myDocumentJson, collectionId);
  }

  @SuppressWarnings("deprecation")
  private CreateDocumentResponse createTestDocument(String json, String collectionId) {
    InputStream documentStream = new ByteArrayInputStream(json.getBytes());
    CreateDocumentRequest.Builder builder = new CreateDocumentRequest.Builder(environmentId, collectionId);
    builder.inputStream(documentStream, HttpMediaType.APPLICATION_JSON);
    CreateDocumentResponse createResponse = discovery.createDocument(builder.build()).execute();
    WaitFor.Condition documentAccepted =
        new DocumentAccepted(environmentId, collectionId, createResponse.getDocumentId());
    WaitFor.waitFor(documentAccepted, 5, TimeUnit.SECONDS, 500);
    return createResponse;
  }

  private List<CreateDocumentResponse> createTestDocuments(String collectionId, int totalDocuments) {
    List<CreateDocumentResponse> responses = new ArrayList<CreateDocumentResponse>();
    String baseDocumentJson = "{\"field\":";
    for (int i = 0; i < totalDocuments; i++) {
      String json = baseDocumentJson + i + "}";
      responses.add(createTestDocument(json, collectionId));
    }
    return responses;
  }

  private String setupTestDocuments() {
    CreateCollectionResponse createCollectionResponse = createTestCollection();
    String collectionId = createCollectionResponse.getCollectionId();
    @SuppressWarnings("unused")
    List<CreateDocumentResponse> createDocumentResponses = createTestDocuments(collectionId, 10);
    return collectionId;
  }

  public static Configuration getTestConfiguration(String jsonFile) {
    try {
      return GsonSingleton.getGson().fromJson(new FileReader(jsonFile), Configuration.class);
    } catch (FileNotFoundException e) {
      return null;
    }
  }

  private static class EnvironmentReady implements WaitFor.Condition {
    private final Discovery discovery;
    private final String environmentId;

    private EnvironmentReady(Discovery discovery, String environmentId) {
      this.discovery = discovery;
      this.environmentId = environmentId;
    }

    @Override
    public boolean isSatisfied() {
      GetEnvironmentRequest getRequest = new GetEnvironmentRequest.Builder(environmentId).build();
      Status status = discovery.getEnvironment(getRequest).execute().getStatus();
      return status.equals(Status.ACTIVE);
    }
  }

  private class DocumentAccepted implements WaitFor.Condition {
    DocumentAccepted(String environmentId, String collectionId, String documentId) {
      this.environmentId = environmentId;
      this.collectionId = collectionId;
      this.documentId = documentId;
    }

    @Override
    public boolean isSatisfied() {
      GetDocumentRequest getRequest = new GetDocumentRequest.Builder(environmentId, collectionId, documentId).build();
      Document.Status status = discovery.getDocument(getRequest).execute().getStatus();
      return status.equals(Document.Status.AVAILABLE);
    }

    private final String environmentId;
    private final String collectionId;
    private final String documentId;

  }

}

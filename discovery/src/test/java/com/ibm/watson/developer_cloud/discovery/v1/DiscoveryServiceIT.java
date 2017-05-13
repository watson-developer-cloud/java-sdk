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
import com.ibm.watson.developer_cloud.discovery.v1.model.ListEnvironmentsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListEnvironmentsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.NormalizationOperation.Operation;
import com.ibm.watson.developer_cloud.discovery.v1.model.NormalizationOperation;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryAggregation;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.query.AggregationType;
import com.ibm.watson.developer_cloud.discovery.v1.query.Operator;
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

  // Constants for enum fields
  private static final Long FREE = 0L;

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

    ListEnvironmentsOptions listOptions = new ListEnvironmentsOptions.Builder().build();
    ListEnvironmentsResponse listResponse = discovery.listEnvironments(listOptions).execute();
    for (Environment environment : listResponse.getEnvironments()) {
      // look for an existing environment that isn't read only
      if (!environment.isReadOnly()) {
        environmentId = environment.getEnvironmentId();
        break;
      }
    }

    if (environmentId == null) {
      // no environment found, create a new one (assuming we are a FREE plan)
      String environmentName = "watson_developer_cloud_test_environment";
      CreateEnvironmentOptions createOptions = new CreateEnvironmentOptions.Builder()
          .name(environmentName).size(FREE).build();
      Environment createResponse = discovery.createEnvironment(createOptions).execute();
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
      DeleteCollectionOptions deleteOptions = new DeleteCollectionOptions.Builder(environmentId, collectionId).build();
      discovery.deleteCollection(deleteOptions).execute();
    }

    for (String configurationId : configurationIds) {
      DeleteConfigurationOptions deleteOptions =
          new DeleteConfigurationOptions.Builder(environmentId, configurationId).build();
      discovery.deleteConfiguration(deleteOptions).execute();
    }
  }

  public boolean ping() throws RuntimeException {
    discovery.listEnvironments(null).execute();
    return true;
  }

  @Test
  public void pingIsSuccessful() {
    assertTrue(ping());
  }

  @Test(expected = UnauthorizedException.class)
  public void pingBadCredentialsThrowsException() {
    discovery.setUsernameAndPassword("foo", "bar");
    ping();
  }

  @Test(expected = ForbiddenException.class)
  public void pingBadUrlThrowsException() {
    discovery.setEndPoint("https://gateway.watsonplatform.net/discovery-foo/api");
    ping();
  }

  @Test
  public void getEnvironmentIsSuccessful() {
    GetEnvironmentOptions getOptions = new GetEnvironmentOptions.Builder(environmentId).build();
    Environment getResponse = discovery.getEnvironment(getOptions).execute();

    assertEquals(environmentId, getResponse.getEnvironmentId());
  }

  @Test
  public void listEnvironmentsIsSuccessful() {
    ListEnvironmentsOptions listOptions = new ListEnvironmentsOptions.Builder().build();
    ListEnvironmentsResponse listResponse = discovery.listEnvironments(listOptions).execute();

    assertFalse(listResponse.getEnvironments().isEmpty());
  }

  @Test
  public void listEnvironmentsHasNewsEnvironment() {
    ListEnvironmentsOptions listOptions = new ListEnvironmentsOptions.Builder().build();
    ListEnvironmentsResponse listResponse = discovery.listEnvironments(listOptions).execute();

    boolean foundNews = false;
    for (Environment environment : listResponse.getEnvironments()) {
      if (environment.isReadOnly()) {
        foundNews = true;
        break;
      }
    }
    assertTrue(foundNews);
  }

  @Test
  public void listEnvironmentsByNameIsSuccessful() {
    GetEnvironmentOptions getOptions = new GetEnvironmentOptions.Builder(environmentId).build();
    Environment getResponse = discovery.getEnvironment(getOptions).execute();

    ListEnvironmentsOptions.Builder getBuilder = new ListEnvironmentsOptions.Builder();
    getBuilder.name(getResponse.getName());
    ListEnvironmentsResponse listResponse = discovery.listEnvironments(getBuilder.build()).execute();

    assertEquals(1, listResponse.getEnvironments().size());
  }

  @Test
  @Ignore("Only 1 BYOD environment allowed per service instance, so we cannot create more")
  public void createEnvironmentIsSuccessful() {
    String environmentName = uniqueName + "-environment";
    CreateEnvironmentOptions createOptions =
        new CreateEnvironmentOptions.Builder().name(environmentName).size(FREE).build();
    Environment createResponse = createEnvironment(createOptions);

    assertEquals(environmentName, createResponse.getName());
  }

  @Test
  @Ignore("Only 1 BYOD environment allowed per service instance, so do not delete it")
  public void deleteEnvironmentIsSuccessful() {
    String environmentName = uniqueName + "-environment";
    CreateEnvironmentOptions createOptions =
        new CreateEnvironmentOptions.Builder().name(environmentName).size(FREE).build();
    Environment createResponse = createEnvironment(createOptions);

    DeleteEnvironmentOptions deleteOptions =
        new DeleteEnvironmentOptions.Builder(createResponse.getEnvironmentId()).build();
    DeleteEnvironmentResponse deleteRepsonse = deleteEnvironment(deleteOptions);

    assertEquals(createResponse.getEnvironmentId(), deleteRepsonse.getEnvironmentId());
  }

  @Test
  @Ignore("Only 1 BYOD environment allowed per service instance, so we cannot create more")
  public void updateEnvironmentIsSuccessful() {
    String environmentName = uniqueName + "-environment";
    CreateEnvironmentOptions createOptions =
        new CreateEnvironmentOptions.Builder().name(environmentName).size(FREE).build();
    Environment createResponse = createEnvironment(createOptions);

    String randomDescription = UUID.randomUUID().toString() + " appbuilder tests";
    UpdateEnvironmentOptions.Builder updateBuilder =
        new UpdateEnvironmentOptions.Builder(createResponse.getEnvironmentId()).name(environmentName);
    updateBuilder.description(randomDescription);
    Environment updateResponse = discovery.updateEnvironment(updateBuilder.build()).execute();

    assertEquals(randomDescription, updateResponse.getDescription());
  }

  @Test
  public void getConfigurationsIsSuccessful() {
    ListConfigurationsOptions getOptions = new ListConfigurationsOptions.Builder(environmentId).build();
    ListConfigurationsResponse getResponse = discovery.listConfigurations(getOptions).execute();

    assertFalse(getResponse.getConfigurations().isEmpty());
  }

  @Test
  public void createConfigurationIsSuccessful() {
    String uniqueConfigName = uniqueName + "-config";
    CreateConfigurationOptions.Builder createBuilder =
        new CreateConfigurationOptions.Builder().environmentId(environmentId);
    Configuration configuration = getTestConfiguration(DISCOVERY_TEST_CONFIG_FILE);
    configuration.setName(uniqueConfigName);
    createBuilder.name(configuration.getName());
    createBuilder.configuration(configuration);
    Configuration createResponse = createConfiguration(createBuilder.build());

    assertEquals(uniqueConfigName, createResponse.getName());
  }

  @Test
  public void deleteConfigurationIsSuccessful() {
    Configuration createResponse = createTestConfig();

    DeleteConfigurationOptions deleteOptions =
        new DeleteConfigurationOptions.Builder(environmentId, createResponse.getConfigurationId()).build();
    DeleteConfigurationResponse deleteResponse = deleteConfiguration(deleteOptions);

    assertEquals(createResponse.getConfigurationId(), deleteResponse.getConfigurationId());
  }

  @Test
  public void getConfigurationIsSuccessful() {
    Configuration createResponse = createTestConfig();

    GetConfigurationOptions getOptions =
        new GetConfigurationOptions.Builder(environmentId, createResponse.getConfigurationId()).build();
    Configuration getResponse = discovery.getConfiguration(getOptions).execute();

    assertEquals(createResponse.getName(), getResponse.getName());
  }

  @Test
  public void getConfigurationsByNameIsSuccessful() {
    Configuration createResponse = createTestConfig();

    ListConfigurationsOptions.Builder getBuilder = new ListConfigurationsOptions.Builder(environmentId);
    getBuilder.name(createResponse.getName());
    ListConfigurationsResponse getResponse = discovery.listConfigurations(getBuilder.build()).execute();

    assertEquals(1, getResponse.getConfigurations().size());
    assertEquals(createResponse.getName(), getResponse.getConfigurations().get(0).getName());
  }

  @Test
  public void getConfigurationsWithFunkyNameIsSuccessful() {
    String uniqueConfigName = uniqueName + " with \"funky\" ?x=y&foo=bar ,[x](y) ~!@#$%^&*()-+ {} | ;:<>\\/ chars";

    CreateConfigurationOptions.Builder createBuilder = new CreateConfigurationOptions.Builder(environmentId);
    Configuration configuration = getTestConfiguration(DISCOVERY_TEST_CONFIG_FILE);
    createBuilder.configuration(configuration);
    createBuilder.name(uniqueConfigName);
    Configuration createResponse = createConfiguration(createBuilder.build());

    ListConfigurationsOptions.Builder getBuilder = new ListConfigurationsOptions.Builder(environmentId);
    getBuilder.name(uniqueConfigName);
    ListConfigurationsResponse getResponse = discovery.listConfigurations(getBuilder.build()).execute();

    assertEquals(1, getResponse.getConfigurations().size());
    assertEquals(uniqueConfigName, getResponse.getConfigurations().get(0).getName());
  }

  @Test
  public void updateConfigurationIsSuccessful() {
    Configuration createResponse = createTestConfig();

    String newUniqueName = createResponse.getName() + UUID.randomUUID().toString();
    UpdateConfigurationOptions.Builder updateBuilder =
        new UpdateConfigurationOptions.Builder(environmentId, createResponse.getConfigurationId());
    createResponse.setName(newUniqueName);
    updateBuilder.configuration(createResponse);
    Configuration updateResponse = discovery.updateConfiguration(updateBuilder.build()).execute();

    assertEquals(newUniqueName, updateResponse.getName());
  }

  @Test
  public void getCollectionsIsSuccessful() {
    createTestCollection();
    ListCollectionsOptions listOptions = new ListCollectionsOptions.Builder(environmentId).build();
    ListCollectionsResponse listResponse = discovery.listCollections(listOptions).execute();

    assertFalse(listResponse.getCollections().isEmpty());
  }

  @Test
  public void createCollectionIsSuccessful() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionOptions.Builder createCollectionBuilder = new CreateCollectionOptions.Builder(environmentId)
        .configurationId(createConfigResponse.getConfigurationId()).name(uniqueCollectionName);
    Collection createResponse = createCollection(createCollectionBuilder.build());

    assertEquals(uniqueCollectionName, createResponse.getName());
  }

  @Test
  public void setConfigurationIsSuccessful() {
    ListConfigurationsOptions getOptions = new ListConfigurationsOptions.Builder(environmentId).build();
    ListConfigurationsResponse getResponse = discovery.listConfigurations(getOptions).execute();
    String configurationId = getResponse.getConfigurations().get(0).getConfigurationId().toString();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionOptions.Builder createCollectionBuilder = new CreateCollectionOptions.Builder(environmentId)
           .configurationId(configurationId).name(uniqueCollectionName);
    Collection createResponse = createCollection(createCollectionBuilder.build());

    assertEquals(configurationId, createResponse.getConfigurationId());
  }

  @Test
  public void deleteCollectionIsSuccessful() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionOptions.Builder createCollectionBuilder = new CreateCollectionOptions.Builder(environmentId)
        .configurationId(createConfigResponse.getConfigurationId()).name(uniqueCollectionName);
    Collection createResponse = createCollection(createCollectionBuilder.build());

    // need to wait for collection to be ready

    DeleteCollectionOptions deleteOptions =
        new DeleteCollectionOptions.Builder(environmentId, createResponse.getCollectionId()).build();
    DeleteCollectionResponse deleteResponse = deleteCollection(deleteOptions);

    assertEquals(DeleteCollectionResponse.Status.DELETED, deleteResponse.getStatus());
  }

  @Test
  public void getCollectionIsSuccessful() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionOptions.Builder createCollectionBuilder = new CreateCollectionOptions.Builder(environmentId)
        .configurationId(createConfigResponse.getConfigurationId()).name(uniqueCollectionName);
    Collection createResponse = createCollection(createCollectionBuilder.build());

    GetCollectionOptions getOptions =
        new GetCollectionOptions.Builder(environmentId, createResponse.getCollectionId()).build();

    // need to wait for collection to be ready

    Collection getResponse = discovery.getCollection(getOptions).execute();

    assertEquals(createResponse.getName(), getResponse.getName());
  }

  @Test
  public void getCollectionsByNameIsSuccessful() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionOptions.Builder createCollectionBuilder = new CreateCollectionOptions.Builder(environmentId)
        .configurationId(createConfigResponse.getConfigurationId()).name(uniqueCollectionName);
    createCollection(createCollectionBuilder.build());

    ListCollectionsOptions.Builder getBuilder = new ListCollectionsOptions.Builder(environmentId);
    getBuilder.name(uniqueCollectionName);
    ListCollectionsResponse getResponse = discovery.listCollections(getBuilder.build()).execute();

    assertEquals(1, getResponse.getCollections().size());
    assertEquals(uniqueCollectionName, getResponse.getCollections().get(0).getName());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void createDocumentIsSuccessful() {
    Collection collection = createTestCollection();

    String myDocumentJson = "{\"field\":\"value\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    AddDocumentOptions.Builder builder =
        new AddDocumentOptions.Builder(environmentId, collection.getCollectionId());
    builder.file(documentStream).fileMediaType(HttpMediaType.APPLICATION_JSON);

    DocumentAccepted createResponse = discovery.addDocument(builder.build()).execute();
    assertFalse(createResponse.getDocumentId().isEmpty());
    assertNull(createResponse.getNotices());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void createDocumentWithMetadataIsSuccessful() {
    Collection collection = createTestCollection();
    String collectionId = collection.getCollectionId();

    String myDocumentJson = "{\"field\":\"value\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    AddDocumentOptions.Builder builder = new AddDocumentOptions.Builder(environmentId, collectionId);
    builder.file(documentStream).fileMediaType(HttpMediaType.APPLICATION_JSON);
    builder.metadata(myMetadata.toString());

    DocumentAccepted createResponse = discovery.addDocument(builder.build()).execute();

    WaitFor.Condition documentAccepted =
        new WaitForDocumentAccepted(environmentId, collectionId, createResponse.getDocumentId());
    WaitFor.waitFor(documentAccepted, 5, TimeUnit.SECONDS, 500);

    QueryOptions queryOptions = new QueryOptions.Builder(environmentId, collectionId).build();
    QueryResponse queryResponse = discovery.query(queryOptions).execute();

    assertTrue(queryResponse.getResults().get(0).getMetadata() != null);
  }

  @Test
  public void deleteDocumentIsSuccessful() {
    Collection collection = createTestCollection();
    String collectionId = collection.getCollectionId();
    DocumentAccepted documentAccepted = createTestDocument(collectionId);

    DeleteDocumentOptions deleteOptions =
        new DeleteDocumentOptions.Builder(environmentId, collectionId, documentAccepted.getDocumentId()).build();
    DeleteDocumentResponse deleteResponse = discovery.deleteDocument(deleteOptions).execute();
    assertEquals(DeleteDocumentResponse.Status.DELETED, deleteResponse.getStatus());
  }

  @Test
  public void getDocumentIsSuccessful() {
    Collection collection = createTestCollection();
    String collectionId = collection.getCollectionId();
    DocumentAccepted documentAccepted = createTestDocument(collectionId);

    GetDocumentOptions getOptions =
        new GetDocumentOptions.Builder(environmentId, collectionId, documentAccepted.getDocumentId()).build();
    DocumentStatus getResponse = discovery.getDocument(getOptions).execute();

    assertEquals(DocumentStatus.Status.AVAILABLE, getResponse.getStatus());
  }

  @Test
  public void updateDocumentIsSuccessful() {
    Collection collection = createTestCollection();
    String collectionId = collection.getCollectionId();
    DocumentAccepted documentAccepted = createTestDocument(collectionId);

    UpdateDocumentOptions.Builder updateBuilder =
        new UpdateDocumentOptions.Builder(environmentId, collectionId, documentAccepted.getDocumentId());
    String myDocumentJson = "{\"field\":\"value2\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());
    updateBuilder.file(documentStream).fileMediaType(HttpMediaType.APPLICATION_JSON);
    DocumentAccepted updateResponse = discovery.updateDocument(updateBuilder.build()).execute();

    GetDocumentOptions getOptions =
        new GetDocumentOptions.Builder(environmentId, collectionId, updateResponse.getDocumentId()).build();
    DocumentStatus getResponse = discovery.getDocument(getOptions).execute();

    assertTrue(getResponse.getStatus().equals(DocumentStatus.Status.AVAILABLE)
        || getResponse.getStatus().equals(DocumentStatus.Status.PROCESSING));
  }

  @Test
  @Ignore("Pending implementation of 'processing' after document update")
  public void updateDocumentWithMetadataIsSuccessful() {
    Collection collection = createTestCollection();
    String collectionId = collection.getCollectionId();
    DocumentAccepted documentAccepted = createTestDocument(collectionId);

    String myDocumentJson = "{\"field\":\"value2\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    UpdateDocumentOptions.Builder updateBuilder =
        new UpdateDocumentOptions.Builder(environmentId, collectionId, documentAccepted.getDocumentId());
    updateBuilder.file(documentStream).fileMediaType(HttpMediaType.APPLICATION_JSON);
    updateBuilder.metadata(myMetadata.toString());
    DocumentAccepted updateResponse = discovery.updateDocument(updateBuilder.build()).execute();

    WaitFor.Condition waitForDocumentAccepted =
        new WaitForDocumentAccepted(environmentId, collectionId, updateResponse.getDocumentId());
    WaitFor.waitFor(waitForDocumentAccepted, 5, TimeUnit.SECONDS, 500);

    QueryOptions queryOptions = new QueryOptions.Builder(environmentId, collectionId).build();
    QueryResponse queryResponse = discovery.query(queryOptions).execute();

    assertTrue(queryResponse.getResults().get(0).getMetadata() != null);
  }

  @Test
  public void getCollectionFieldsIsSuccessful() {
    Collection collection = createTestCollection();
    String collectionId = collection.getCollectionId();
    createTestDocument(collectionId);

    ListCollectionFieldsOptions getOptions =
        new ListCollectionFieldsOptions.Builder(environmentId, collectionId).build();
    ListCollectionFieldsResponse getResponse = discovery.listCollectionFields(getOptions).execute();

    assertFalse(getResponse.getFields().isEmpty());
  }

  @Test
  public void queryWithCountIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    queryBuilder.count(5L);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    assertEquals(new Long(10), queryResponse.getMatchingResults());
    assertEquals(5, queryResponse.getResults().size());
  }

  @Test
  public void queryWithOffsetIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    queryBuilder.offset(5L);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    assertEquals(new Long(10), queryResponse.getMatchingResults());
    assertEquals(5, queryResponse.getResults().size());
  }

  @Test
  public void queryWithReturnFieldsIsSuccessful() {
    String collectionId = setupTestDocuments();
    createTestDocument("{\"field_2\":\"value_2\"}", collectionId);

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    List<String> fieldNames = new ArrayList<>();
    fieldNames.add("field");
    queryBuilder.returnFields(fieldNames);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    String[] expected = new String[] { "id", "score", "field" };
    assertTrue(queryResponse.getResults().get(0).keySet().containsAll(Arrays.asList(expected)));
  }

  @Test
  public void queryWithQueryIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    queryBuilder.query("field" + Operator.CONTAINS + 1);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    assertEquals(new Long(1), queryResponse.getMatchingResults());
    assertEquals(1, queryResponse.getResults().size());
    assertTrue((Double) queryResponse.getResults().get(0).getScore() > 1.0);
  }

  @Test
  public void queryWithFilterIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    queryBuilder.filter("field" + Operator.CONTAINS + 1);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    assertEquals(new Long(1), queryResponse.getMatchingResults());
    assertEquals(1, queryResponse.getResults().size());
  }

  @Test
  public void queryWithAggregationTermIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
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
    Collection collection = createTestCollection();
    String collectionId = collection.getCollectionId();
    createTestDocument(collectionId);
    createTestDocument(collectionId);

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
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
    QueryAggregation term = (QueryAggregation) queryResponse.getAggregations().get(0);
    assertFalse(term.getResults().get(0).getAggregations().isEmpty());
  }

  @Test
  public void queryWithAggregationHistogramIsSuccessful() throws InterruptedException {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
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
    QueryAggregation histogram = (QueryAggregation) queryResponse.getAggregations().get(0);
    assertEquals(new Long(5), histogram.getInterval());
    assertEquals(2, histogram.getResults().size());
  }

  @Test
  public void queryWithAggregationMaximumIsSuccessful() throws InterruptedException {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.MAX);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    QueryAggregation max = (QueryAggregation) queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.MAX.getName(), max.getType());
    assertEquals(new Double(9), max.getValue());
  }

  @Test
  public void queryWithAggregationMinimumIsSuccessful() throws InterruptedException {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.MIN);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    QueryAggregation min = (QueryAggregation) queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.MIN.getName(), min.getType());
    assertEquals(new Double(0), min.getValue());
  }

  @Test
  public void queryWithAggregationSummationIsSuccessful() throws InterruptedException {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.SUM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    QueryAggregation sum = (QueryAggregation) queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.SUM.getName(), sum.getType());
    assertEquals(new Double(45), sum.getValue());
  }

  @Test
  public void queryWithAggregationAverageIsSuccessful() throws InterruptedException {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.AVERAGE);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    QueryAggregation avg = (QueryAggregation) queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.AVERAGE.getName(), avg.getType());
    assertEquals(new Double(4.5), avg.getValue());
  }

  @Test
  public void issueNumber517() {
    String uniqueConfigName = uniqueName + "-config";
    CreateConfigurationOptions.Builder createBuilder = new CreateConfigurationOptions.Builder(environmentId);
    Configuration configuration = getTestConfiguration(DISCOVERY1_TEST_CONFIG_FILE);

    configuration.setName(uniqueConfigName);
    createBuilder.configuration(configuration);
    Configuration createResponse = createConfiguration(createBuilder.build());

    GetConfigurationOptions getOptions =
        new GetConfigurationOptions.Builder(environmentId, createResponse.getConfigurationId()).build();
    Configuration getResponse = discovery.getConfiguration(getOptions).execute();

    // returned config should have some json data
    assertEquals(1, getResponse.getConversions().getJsonNormalizations().size());
  }

  @Test
  public void issueNumber518() {
    String[] operations = new String[] { Operation.MOVE, Operation.COPY, Operation.MERGE, Operation.REMOVE,
        Operation.REMOVE_NULLS};

    String uniqueConfigName = uniqueName + "-config";
    CreateConfigurationOptions.Builder createBuilder = new CreateConfigurationOptions.Builder(environmentId);
    Configuration configuration = getTestConfiguration(DISCOVERY2_TEST_CONFIG_FILE);

    configuration.setName(uniqueConfigName);
    createBuilder.configuration(configuration);
    Configuration createResponse = createConfiguration(createBuilder.build());

    GetConfigurationOptions getOptions =
        new GetConfigurationOptions.Builder(environmentId, createResponse.getConfigurationId()).build();
    Configuration getResponse = discovery.getConfiguration(getOptions).execute();

    // verify getResponse deserializes the operations appropriately
    for (NormalizationOperation normalization : getResponse.getNormalizations()) {
      String operation = normalization.getOperation();
      assertEquals(true, Arrays.asList(operations).contains(operation));
    }
  }

  @Test
  public void issueNumber654() {
    String collectionId = setupTestDocuments();
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    queryBuilder.query("field:1|3");
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();

    assertEquals(new Long(2), queryResponse.getMatchingResults());
    assertEquals(2, queryResponse.getResults().size());
  }

  private Environment createEnvironment(CreateEnvironmentOptions createOptions) {
    Environment createResponse = discovery.createEnvironment(createOptions).execute();
    return createResponse;
  }

  private DeleteEnvironmentResponse deleteEnvironment(DeleteEnvironmentOptions deleteOptions) {
    DeleteEnvironmentResponse deleteResponse = discovery.deleteEnvironment(deleteOptions).execute();
    return deleteResponse;
  }

  private Configuration createConfiguration(CreateConfigurationOptions createOptions) {
    Configuration createResponse = discovery.createConfiguration(createOptions).execute();
    configurationIds.add(createResponse.getConfigurationId());
    return createResponse;
  }

  private DeleteConfigurationResponse deleteConfiguration(DeleteConfigurationOptions deleteOptions) {
    DeleteConfigurationResponse deleteResponse = discovery.deleteConfiguration(deleteOptions).execute();
    configurationIds.remove(deleteResponse.getConfigurationId());
    return deleteResponse;
  }

  private Configuration createTestConfig() {
    String uniqueConfigName = uniqueName + "-config";
    CreateConfigurationOptions.Builder createBuilder = new CreateConfigurationOptions.Builder(environmentId);
    Configuration configuration = getTestConfiguration(DISCOVERY_TEST_CONFIG_FILE);
    configuration.setName(uniqueConfigName);
    createBuilder.configuration(configuration);
    return createConfiguration(createBuilder.build());
  }

  private Collection createCollection(CreateCollectionOptions createOptions) {
    Collection createResponse = discovery.createCollection(createOptions).execute();
    collectionIds.add(createResponse.getCollectionId());
    return createResponse;
  }

  private DeleteCollectionResponse deleteCollection(DeleteCollectionOptions deleteOptions) {
    DeleteCollectionResponse deleteResponse = discovery.deleteCollection(deleteOptions).execute();
    collectionIds.remove(deleteResponse.getCollectionId());
    return deleteResponse;
  }

  private Collection createTestCollection() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionOptions.Builder createCollectionBuilder =
        new CreateCollectionOptions.Builder(environmentId)
            .configurationId(createConfigResponse.getConfigurationId()).name(uniqueCollectionName);
    Collection createResponse = createCollection(createCollectionBuilder.build());
    return createResponse;
  }

  private DocumentAccepted createTestDocument(String collectionId) {
    String myDocumentJson = "{\"field\":\"value\"}";
    return createTestDocument(myDocumentJson, collectionId);
  }

  @SuppressWarnings("deprecation")
  private DocumentAccepted createTestDocument(String json, String collectionId) {
    InputStream documentStream = new ByteArrayInputStream(json.getBytes());
    AddDocumentOptions.Builder builder = new AddDocumentOptions.Builder(environmentId, collectionId);
    builder.file(documentStream).fileMediaType(HttpMediaType.APPLICATION_JSON);
    DocumentAccepted createResponse = discovery.addDocument(builder.build()).execute();
    WaitFor.Condition documentAccepted =
        new WaitForDocumentAccepted(environmentId, collectionId, createResponse.getDocumentId());
    WaitFor.waitFor(documentAccepted, 5, TimeUnit.SECONDS, 500);
    return createResponse;
  }

  private List<DocumentAccepted> createTestDocuments(String collectionId, int totalDocuments) {
    List<DocumentAccepted> responses = new ArrayList<DocumentAccepted>();
    String baseDocumentJson = "{\"field\":";
    for (int i = 0; i < totalDocuments; i++) {
      String json = baseDocumentJson + i + "}";
      responses.add(createTestDocument(json, collectionId));
    }
    return responses;
  }

  private String setupTestDocuments() {
    Collection collection = createTestCollection();
    String collectionId = collection.getCollectionId();
    @SuppressWarnings("unused")
    List<DocumentAccepted> documentAccepted = createTestDocuments(collectionId, 10);

    WaitFor.Condition collectionAvailable =
        new WaitForCollectionAvailable(environmentId, collectionId);
    WaitFor.waitFor(collectionAvailable, 5, TimeUnit.SECONDS, 500);

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
      GetEnvironmentOptions getOptions = new GetEnvironmentOptions.Builder(environmentId).build();
      String status = discovery.getEnvironment(getOptions).execute().getStatus();
      return status.equals(Environment.Status.ACTIVE);
    }
  }

  private class WaitForDocumentAccepted implements WaitFor.Condition {
    WaitForDocumentAccepted(String environmentId, String collectionId, String documentId) {
      this.environmentId = environmentId;
      this.collectionId = collectionId;
      this.documentId = documentId;
    }

    @Override
    public boolean isSatisfied() {
      GetDocumentOptions getOptions = new GetDocumentOptions.Builder(environmentId, collectionId, documentId).build();
      String status = discovery.getDocument(getOptions).execute().getStatus();
      return status.equals(DocumentStatus.Status.AVAILABLE);
    }

    private final String environmentId;
    private final String collectionId;
    private final String documentId;

  }

  private class WaitForCollectionAvailable implements WaitFor.Condition {
    WaitForCollectionAvailable(String environmentId, String collectionId) {
      this.environmentId = environmentId;
      this.collectionId = collectionId;
    }

    @Override
    public boolean isSatisfied() {
      GetCollectionOptions getOptions = new GetCollectionOptions.Builder(environmentId, collectionId).build();
      String status = discovery.getCollection(getOptions).execute().getStatus();
      return status.equals(Collection.Status.ACTIVE);
    }

    private final String environmentId;
    private final String collectionId;

  }

}

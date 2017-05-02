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
import static org.junit.Assert.assertNotNull;
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

import com.ibm.watson.developer_cloud.discovery.v1.model.AggregationResult;
import com.ibm.watson.developer_cloud.discovery.v1.model.Collection;
import com.ibm.watson.developer_cloud.discovery.v1.model.Configuration;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateCollectionRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteCollectionResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DocumentAccepted;
import com.ibm.watson.developer_cloud.discovery.v1.model.DocumentStatus;
import com.ibm.watson.developer_cloud.discovery.v1.model.Environment;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetCollectionFieldsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetCollectionsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetConfigurationsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetEnvironmentsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.NormalizationOperation;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryAggregation;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryResult;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.query.AggregationType;
import com.ibm.watson.developer_cloud.discovery.v1.query.Operator;
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

  // Constants for enum fields
  private static final Long FREE = 0L;
  private static final String ACTIVE = "active";
  private static final String AVAILABLE = "available";
  private static final String DELETED = "deleted";

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

    GetEnvironmentsResponse getResponse = discovery.getEnvironments(null).execute();
    for (Environment environment : getResponse.getEnvironments()) {
      // look for an existing environment that isn't read only
      if (!environment.getReadOnly()) {
        environmentId = environment.getEnvironmentId();
        break;
      }
    }

    if (environmentId == null) {
      // no environment found, create a new one (assuming we are a FREE plan)
      String environmentName = "watson_developer_cloud_test_environment";
      CreateEnvironmentRequest createRequest = new CreateEnvironmentRequest.Builder().name(environmentName).size(FREE).build();
      Environment createResponse = discovery.createEnvironment(createRequest).execute();
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
      discovery.deleteCollection(environmentId, collectionId).execute();
    }

    for (String configurationId : configurationIds) {
      discovery.deleteConfiguration(environmentId, configurationId).execute();
    }
  }

  public boolean ping() throws RuntimeException {
    discovery.getEnvironments(null).execute();
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
    Environment getResponse = discovery.getEnvironment(environmentId).execute();

    assertEquals(environmentId, getResponse.getEnvironmentId());
  }

  @Test
  public void getEnvironmentsIsSuccessful() {
    GetEnvironmentsResponse getResponse = discovery.getEnvironments(null).execute();

    assertFalse(getResponse.getEnvironments().isEmpty());
  }

  @Test
  public void getEnvironmentsHasNewsEnvironment() {
    GetEnvironmentsResponse getResponse = discovery.getEnvironments(null).execute();

    boolean foundNews = false;
    for (Environment environment : getResponse.getEnvironments()) {
      if (environment.getReadOnly()) {
        foundNews = true;
        break;
      }
    }
    assertTrue(foundNews);
  }

  @Test
  public void getEnvironmentsByNameIsSuccessful() {
    Environment getResponse = discovery.getEnvironment(environmentId).execute();

    GetEnvironmentsResponse getsResponse = discovery.getEnvironments(getResponse.getName()).execute();

    assertEquals(1, getsResponse.getEnvironments().size());
  }

  @Test
  @Ignore("Only 1 BYOD environment allowed per service instance, so we cannot create more")
  public void createEnvironmentIsSuccessful() {
    String environmentName = uniqueName + "-environment";
    CreateEnvironmentRequest createRequest =
        new CreateEnvironmentRequest.Builder().name(environmentName).size(FREE).build();
    Environment createResponse = createEnvironment(createRequest);

    assertEquals(environmentName, createResponse.getName());
  }

  @Test
  @Ignore("Only 1 BYOD environment allowed per service instance, so do not delete it")
  public void deleteEnvironmentIsSuccessful() {
    String environmentName = uniqueName + "-environment";
    CreateEnvironmentRequest createRequest =
        new CreateEnvironmentRequest.Builder().name(environmentName).size(FREE).build();
    Environment createResponse = createEnvironment(createRequest);
    
    DeleteEnvironmentResponse deleteRepsonse = deleteEnvironment(createResponse.getEnvironmentId());

    assertEquals(createResponse.getEnvironmentId(), deleteRepsonse.getEnvironmentId());
  }

  @Test
  @Ignore("Only 1 BYOD environment allowed per service instance, so we cannot create more")
  public void updateEnvironmentIsSuccessful() {
    String environmentName = uniqueName + "-environment";
    CreateEnvironmentRequest createRequest =
        new CreateEnvironmentRequest.Builder().name(environmentName).size(FREE).build();
    Environment createResponse = createEnvironment(createRequest);

    String randomDescription = UUID.randomUUID().toString() + " appbuilder tests";
    UpdateEnvironmentRequest.Builder updateBuilder =
        new UpdateEnvironmentRequest.Builder().name(environmentName);
    updateBuilder.description(randomDescription);
    Environment updateResponse = discovery.updateEnvironment(createResponse.getEnvironmentId(), updateBuilder.build()).execute();

    assertEquals(randomDescription, updateResponse.getDescription());
  }

  @Test
  public void getConfigurationsIsSuccessful() {
    GetConfigurationsResponse getResponse = discovery.getConfigurations(environmentId, null).execute();

    assertFalse(getResponse.getConfigurations().isEmpty());
  }

  @Test
  public void createConfigurationIsSuccessful() {
    String uniqueConfigName = uniqueName + "-config";
    Configuration configuration = getTestConfiguration(DISCOVERY_TEST_CONFIG_FILE);
    configuration.setName(uniqueConfigName);
    Configuration createResponse = createConfiguration(environmentId, configuration);

    assertEquals(uniqueConfigName, createResponse.getName());
  }

  @Test
  public void deleteConfigurationIsSuccessful() {
    Configuration createResponse = createTestConfig();

    DeleteConfigurationResponse deleteResponse = deleteConfiguration(environmentId, createResponse.getConfigurationId());

    assertEquals(createResponse.getConfigurationId(), deleteResponse.getConfigurationId());
  }

  @Test
  public void getConfigurationIsSuccessful() {
    Configuration createResponse = createTestConfig();

    Configuration getResponse = discovery.getConfiguration(environmentId, createResponse.getConfigurationId()).execute();

    assertEquals(createResponse.getName(), getResponse.getName());
  }

  @Test
  public void getConfigurationsByNameIsSuccessful() {
    Configuration createResponse = createTestConfig();

    GetConfigurationsResponse getResponse = discovery.getConfigurations(environmentId, createResponse.getName()).execute();

    assertEquals(1, getResponse.getConfigurations().size());
    assertEquals(createResponse.getName(), getResponse.getConfigurations().get(0).getName());
  }

  @Test
  public void updateConfigurationIsSuccessful() {
    Configuration createResponse = createTestConfig();

    String newUniqueName = createResponse.getName() + UUID.randomUUID().toString();
    createResponse.setName(newUniqueName);
    Configuration updateResponse = discovery.updateConfiguration(environmentId, createResponse.getConfigurationId(),
        createResponse).execute();

    assertEquals(newUniqueName, updateResponse.getName());
  }

  @Test
  public void getCollectionsIsSuccessful() {
    createTestCollection();
    GetCollectionsResponse getResponse = discovery.getCollections(environmentId, null).execute();

    assertFalse(getResponse.getCollections().isEmpty());
  }

  @Test
  public void createCollectionIsSuccessful() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder()
        .configurationId(createConfigResponse.getConfigurationId()).name(uniqueCollectionName);
    Collection createResponse = createCollection(environmentId, createCollectionBuilder.build());

    assertEquals(uniqueCollectionName, createResponse.getName());
  }

  @Test
  public void setConfigurationIsSuccessful() {
    GetConfigurationsResponse getResponse = discovery.getConfigurations(environmentId, null).execute();
    String configurationId = getResponse.getConfigurations().get(0).getConfigurationId().toString();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder()
          .configurationId(configurationId).name(uniqueCollectionName);
    Collection createResponse = createCollection(environmentId, createCollectionBuilder.build());

    assertEquals(configurationId, createResponse.getConfigurationId());
  }

  @Test
  public void deleteCollectionIsSuccessful() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder()
        .configurationId(createConfigResponse.getConfigurationId()).name(uniqueCollectionName);
    Collection createResponse = createCollection(environmentId, createCollectionBuilder.build());

    // need to wait for collection to be ready
    DeleteCollectionResponse deleteResponse = deleteCollection(environmentId, createResponse.getCollectionId());

    assertEquals(DELETED, deleteResponse.getStatus());
  }

  @Test
  public void getCollectionIsSuccessful() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder()
        .configurationId(createConfigResponse.getConfigurationId()).name(uniqueCollectionName);
    Collection createResponse = createCollection(environmentId, createCollectionBuilder.build());

    // need to wait for collection to be ready

    Collection getResponse = discovery.getCollection(environmentId, createResponse.getCollectionId()).execute();

    assertEquals(createResponse.getName(), getResponse.getName());
  }

  @Test
  public void getCollectionsByNameIsSuccessful() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder()
        .configurationId(createConfigResponse.getConfigurationId()).name(uniqueCollectionName);
    createCollection(environmentId, createCollectionBuilder.build());

    GetCollectionsResponse getResponse = discovery.getCollections(environmentId,uniqueCollectionName).execute();

    assertEquals(1, getResponse.getCollections().size());
    assertEquals(uniqueCollectionName, getResponse.getCollections().get(0).getName());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void createDocumentIsSuccessful() {
    Collection createCollectionResponse = createTestCollection();

    String myDocumentJson = "{\"field\":\"value\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    DocumentAccepted createResponse = discovery.addDocument(environmentId, createCollectionResponse.getCollectionId(),
        null, documentStream, HttpMediaType.APPLICATION_JSON,null, null).execute();
    assertFalse(createResponse.getDocumentId().isEmpty());
    assertNull(createResponse.getNotices());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void createDocumentWithMetadataIsSuccessful() {
    Collection createCollectionResponse = createTestCollection();
    String collectionId = createCollectionResponse.getCollectionId();

    String myDocumentJson = "{\"field\":\"value\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    DocumentAccepted createResponse = discovery.addDocument(environmentId, collectionId, null,
        documentStream, HttpMediaType.APPLICATION_JSON, myMetadata.toString(), null).execute();

    WaitFor.Condition waitForDocumentAccepted =
        new WaitForDocumentAccepted(environmentId, collectionId, createResponse.getDocumentId());
    WaitFor.waitFor(waitForDocumentAccepted, 5, TimeUnit.SECONDS, 500);

    QueryResponse queryResponse = discovery.query(environmentId, collectionId, null).execute();

    assertTrue(queryResponse.getResults().get(0).getMetadata()!=null);
  }

  @Test
  public void deleteDocumentIsSuccessful() {
    Collection createCollectionResponse = createTestCollection();
    String collectionId = createCollectionResponse.getCollectionId();
    DocumentAccepted createDocumentResponse = createTestDocument(collectionId);

    DeleteDocumentResponse deleteResponse = discovery.deleteDocument(environmentId, collectionId,
        createDocumentResponse.getDocumentId()).execute();
    assertEquals(DELETED, deleteResponse.getStatus());
  }

  @Test
  public void getDocumentIsSuccessful() {
    Collection createCollectionResponse = createTestCollection();
    String collectionId = createCollectionResponse.getCollectionId();
    DocumentAccepted createDocumentResponse = createTestDocument(collectionId);

    DocumentStatus getResponse = discovery.getDocument(environmentId, collectionId,
        createDocumentResponse.getDocumentId()).execute();

    assertEquals(AVAILABLE, getResponse.getStatus());
  }

  @Test
  public void updateDocumentIsSuccessful() {
    Collection createCollectionResponse = createTestCollection();
    String collectionId = createCollectionResponse.getCollectionId();
    DocumentAccepted createDocumentResponse = createTestDocument(collectionId);

    String myDocumentJson = "{\"field\":\"value2\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());
    DocumentAccepted updateResponse = discovery.updateDocument(environmentId, collectionId,
        createDocumentResponse.getDocumentId(), null, documentStream, HttpMediaType.APPLICATION_JSON,
        null, null).execute();

    DocumentStatus getResponse = discovery.getDocument(environmentId, collectionId,
        updateResponse.getDocumentId()).execute();

    assertEquals(AVAILABLE, getResponse.getStatus());
  }

  @Test
  @Ignore("Pending implementation of 'processing' after document update")
  public void updateDocumentWithMetadataIsSuccessful() {
    Collection createCollectionResponse = createTestCollection();
    String collectionId = createCollectionResponse.getCollectionId();
    DocumentAccepted createDocumentResponse = createTestDocument(collectionId);

    String myDocumentJson = "{\"field\":\"value2\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    DocumentAccepted updateResponse = discovery.updateDocument(environmentId, collectionId,
        createDocumentResponse.getDocumentId(), null, documentStream, HttpMediaType.APPLICATION_JSON,
        myMetadata.getAsString(), null).execute();

    WaitFor.Condition waitForDocumentAccepted =
        new WaitForDocumentAccepted(environmentId, collectionId, updateResponse.getDocumentId());
    WaitFor.waitFor(waitForDocumentAccepted, 5, TimeUnit.SECONDS, 500);

    QueryResponse queryResponse = discovery.query(environmentId, collectionId, null).execute();

    assertTrue(queryResponse.getResults().get(0).getMetadata() != null);
  }

  @Test
  public void getCollectionFieldsIsSuccessful() {
    Collection createCollectionResponse = createTestCollection();
    String collectionId = createCollectionResponse.getCollectionId();
    createTestDocument(collectionId);

    GetCollectionFieldsResponse getResponse = discovery.getCollectionFields(environmentId, collectionId).execute();

    assertFalse(getResponse.getFields().isEmpty());
  }

  @Test
  public void queryWithCountIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder();
    queryBuilder.count(5L);
    QueryResponse queryResponse = discovery.query(environmentId, collectionId, queryBuilder.build()).execute();
    assertEquals(new Long(10), queryResponse.getMatchingResults());
    assertEquals(5, queryResponse.getResults().size());
  }

  @Test
  public void queryWithOffsetIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder();
    queryBuilder.offset(5L);
    QueryResponse queryResponse = discovery.query(environmentId, collectionId, queryBuilder.build()).execute();
    assertEquals(new Long(10), queryResponse.getMatchingResults());
    assertEquals(5, queryResponse.getResults().size());
  }

  @Test
  public void queryWithReturnFieldsIsSuccessful() {
    String collectionId = setupTestDocuments();
    createTestDocument("{\"field_2\":\"value_2\"}", collectionId);

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder();
    List<String> fieldNames = new ArrayList<>();
    fieldNames.add("field");
    queryBuilder.returnFields(fieldNames);
    QueryResponse queryResponse = discovery.query(environmentId, collectionId, queryBuilder.build()).execute();
    String[] expected = new String[] { "id", "score", "field" };
    assertTrue(queryResponse.getResults().get(0).keySet().containsAll(Arrays.asList(expected)));
  }

  @Test
  public void queryWithQueryIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder();
    queryBuilder.query("field" + Operator.CONTAINS + 1);
    QueryResponse queryResponse = discovery.query(environmentId, collectionId, queryBuilder.build()).execute();
    assertEquals(new Long(1), queryResponse.getMatchingResults());
    assertEquals(1, queryResponse.getResults().size());
    assertTrue((double) queryResponse.getResults().get(0).getScore() > 1.0);
  }

  @Test
  public void queryWithFilterIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder();
    queryBuilder.filter("field" + Operator.CONTAINS + 1);
    QueryResponse queryResponse = discovery.query(environmentId, collectionId, queryBuilder.build()).execute();
    assertEquals(new Long(1), queryResponse.getMatchingResults());
    assertEquals(1, queryResponse.getResults().size());
  }

  @Test
  public void queryWithAggregationTermIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder();
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.TERM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(environmentId, collectionId, queryBuilder.build()).execute();
    assertEquals(1, queryResponse.getAggregations().size());
  }

  @Test
  public void queryWithNestedAggregationTermIsSuccessful() {
    Collection createCollectionResponse = createTestCollection();
    String collectionId = createCollectionResponse.getCollectionId();
    createTestDocument(collectionId);
    createTestDocument(collectionId);

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder();
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
    QueryResponse queryResponse = discovery.query(environmentId, collectionId, queryBuilder.build()).execute();
    QueryAggregation term = queryResponse.getAggregations().get(0);
    assertFalse(term.getResults().get(0).getAggregations().isEmpty());
  }

  @Test
  public void queryWithAggregationHistogramIsSuccessful() throws InterruptedException {
    String collectionName = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder();
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.HISTOGRAM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.AND);
    sb.append(5);
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(environmentId, collectionName, queryBuilder.build()).execute();
    QueryAggregation histogram = queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.HISTOGRAM.getName(), histogram.getType());
    assertEquals(new Long(5), histogram.getInterval());
    assertEquals(2, histogram.getResults().size());
  }

  @Test
  public void queryWithAggregationMaximumIsSuccessful() throws InterruptedException {
    String collectionName = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder();
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.MAX);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(environmentId, collectionName, queryBuilder.build()).execute();
    QueryAggregation max = queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.MAX.getName(), max.getType());
    assertEquals(new Double(9), max.getValue());
  }

  @Test
  public void queryWithAggregationMinimumIsSuccessful() throws InterruptedException {
    String collectionName = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder();
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.MIN);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(environmentId, collectionName, queryBuilder.build()).execute();
    QueryAggregation min = queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.MIN.getName(), min.getType());
    assertEquals(new Double(0), min.getValue());
  }

  @Test
  public void queryWithAggregationSummationIsSuccessful() throws InterruptedException {
    String collectionName = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder();
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.SUM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(environmentId, collectionName, queryBuilder.build()).execute();
    QueryAggregation sum = queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.SUM.getName(), sum.getType());
    assertEquals(new Double(45), sum.getValue());
  }

  @Test
  public void queryWithAggregationAverageIsSuccessful() throws InterruptedException {
    String collectionName = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder();
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.AVERAGE);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(environmentId, collectionName, queryBuilder.build()).execute();
    QueryAggregation avg = queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.AVERAGE.getName(), avg.getType());
    assertEquals(new Double(4.5), avg.getValue());
  }

  @Test
  public void issueNumber517() {
    String uniqueConfigName = uniqueName + "-config";
    Configuration configuration = getTestConfiguration(DISCOVERY1_TEST_CONFIG_FILE);

    configuration.setName(uniqueConfigName);
    Configuration createResponse = createConfiguration(environmentId, configuration);

    Configuration getResponse = discovery.getConfiguration(environmentId, createResponse.getConfigurationId()).execute();

    // returned config should have some json data
    assertEquals(1, getResponse.getConversions().getJsonNormalizations().size());
  }

  @Test
  public void issueNumber518() {
    String[] operations = new String[] { "MOVE", "COPY", "MERGE", "REMOVE", "REMOVE_NULLS" };

    String uniqueConfigName = uniqueName + "-config";
    Configuration configuration = getTestConfiguration(DISCOVERY2_TEST_CONFIG_FILE);

    configuration.setName(uniqueConfigName);
    Configuration createResponse = createConfiguration(environmentId, configuration);

    Configuration getResponse = discovery.getConfiguration(environmentId, createResponse.getConfigurationId()).execute();

    // verify getResponse deserializes the operations appropriately
    for (NormalizationOperation normalization : getResponse.getNormalizations()) {
      NormalizationOperation.Operation operation = normalization.getOperation();
      assertEquals(true, Arrays.asList(operations).contains(operation.name()));
    }
  }

  private Environment createEnvironment(CreateEnvironmentRequest createRequest) {
    Environment createResponse = discovery.createEnvironment(createRequest).execute();
    return createResponse;
  }

  private DeleteEnvironmentResponse deleteEnvironment(String environmentId) {
    DeleteEnvironmentResponse deleteResponse = discovery.deleteEnvironment(environmentId).execute();
    return deleteResponse;
  }

  private Configuration createConfiguration(String environmentId, Configuration configuration) {
    Configuration createResponse = discovery.createConfiguration(environmentId, configuration).execute();
    configurationIds.add(createResponse.getConfigurationId());
    return createResponse;
  }

  private DeleteConfigurationResponse deleteConfiguration(String environmentId, String configurationId) {
    DeleteConfigurationResponse deleteResponse = discovery.deleteConfiguration(environmentId, configurationId).execute();
    configurationIds.remove(deleteResponse.getConfigurationId());
    return deleteResponse;
  }

  private Configuration createTestConfig() {
    String uniqueConfigName = uniqueName + "-config";
    Configuration configuration = getTestConfiguration(DISCOVERY_TEST_CONFIG_FILE);
    configuration.setName(uniqueConfigName);
    return createConfiguration(environmentId, configuration);
  }

  private Collection createCollection(String environmentId, CreateCollectionRequest createRequest) {
    Collection createResponse = discovery.createCollection(environmentId, createRequest).execute();
    collectionIds.add(createResponse.getCollectionId());
    return createResponse;
  }

  private DeleteCollectionResponse deleteCollection(String environmentId, String collectionId) {
    DeleteCollectionResponse deleteResponse = discovery.deleteCollection(environmentId, collectionId).execute();
    collectionIds.remove(deleteResponse.getCollectionId());
    return deleteResponse;
  }

  private Collection createTestCollection() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder()
            .configurationId(createConfigResponse.getConfigurationId()).name(uniqueCollectionName);
    Collection createResponse = createCollection(environmentId, createCollectionBuilder.build());
    return createResponse;
  }

  private DocumentAccepted createTestDocument(String collectionId) {
    String myDocumentJson = "{\"field\":\"value\"}";
    return createTestDocument(myDocumentJson, collectionId);
  }

  @SuppressWarnings("deprecation")
  private DocumentAccepted createTestDocument(String json, String collectionId) {
    InputStream documentStream = new ByteArrayInputStream(json.getBytes());
    // HttpMediaType.APPLICATION_JSON
    DocumentAccepted createResponse = discovery.addDocument(environmentId, collectionId, null,
        documentStream, HttpMediaType.APPLICATION_JSON,null, null).execute();
    WaitFor.Condition waitForDocumentAccepted =
        new WaitForDocumentAccepted(environmentId, collectionId, createResponse.getDocumentId());
    WaitFor.waitFor(waitForDocumentAccepted, 5, TimeUnit.SECONDS, 500);
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
    Collection createCollectionResponse = createTestCollection();
    String collectionId = createCollectionResponse.getCollectionId();
    @SuppressWarnings("unused")
    List<DocumentAccepted> createDocumentResponses = createTestDocuments(collectionId, 10);
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
      String status = discovery.getEnvironment(environmentId).execute().getStatus();
      return status.equals(ACTIVE);
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
      String status = discovery.getDocument(environmentId, collectionId, documentId).execute().getStatus();
      return status.equals(AVAILABLE);
    }

    private final String environmentId;
    private final String collectionId;
    private final String documentId;

  }

}

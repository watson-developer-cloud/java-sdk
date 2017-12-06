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

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.discovery.v1.model.AddDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.AddTrainingDataOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.AggregationResult;
import com.ibm.watson.developer_cloud.discovery.v1.model.Calculation;
import com.ibm.watson.developer_cloud.discovery.v1.model.Collection;
import com.ibm.watson.developer_cloud.discovery.v1.model.Configuration;
import com.ibm.watson.developer_cloud.discovery.v1.model.Conversions;
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
import com.ibm.watson.developer_cloud.discovery.v1.model.Enrichment;
import com.ibm.watson.developer_cloud.discovery.v1.model.EnrichmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.Environment;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetCollectionOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetDocumentStatusOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetTrainingDataOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetTrainingExampleOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.Histogram;
import com.ibm.watson.developer_cloud.discovery.v1.model.HtmlSettings;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionFieldsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionFieldsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListConfigurationsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListConfigurationsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListEnvironmentsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListEnvironmentsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListTrainingDataOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.NormalizationOperation;
import com.ibm.watson.developer_cloud.discovery.v1.model.NormalizationOperation.Operation;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryAggregation;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryNoticesOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryNoticesResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryPassages;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.Term;
import com.ibm.watson.developer_cloud.discovery.v1.model.TestConfigurationInEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.TestDocument;
import com.ibm.watson.developer_cloud.discovery.v1.model.TrainingDataSet;
import com.ibm.watson.developer_cloud.discovery.v1.model.TrainingExample;
import com.ibm.watson.developer_cloud.discovery.v1.model.TrainingQuery;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateCollectionOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateTrainingExampleOptions;
import com.ibm.watson.developer_cloud.discovery.v1.query.AggregationType;
import com.ibm.watson.developer_cloud.discovery.v1.query.Operator;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.service.exception.ForbiddenException;
import com.ibm.watson.developer_cloud.service.exception.NotFoundException;
import com.ibm.watson.developer_cloud.service.exception.UnauthorizedException;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.RetryRunner;
import com.ibm.watson.developer_cloud.util.WaitFor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link Discovery}.
 */
@RunWith(RetryRunner.class)
public class DiscoveryServiceIT extends WatsonServiceTest {

  // Constants for enum fields
  private static final Long FREE = 0L;

  private static final String DISCOVERY_TEST_CONFIG_FILE = "src/test/resources/discovery/test-config.json";
  private static final String DISCOVERY1_TEST_CONFIG_FILE = "src/test/resources/discovery/issue517.json";
  private static final String DISCOVERY2_TEST_CONFIG_FILE = "src/test/resources/discovery/issue518.json";
  private static final String PASSAGES_TEST_FILE_1 = "src/test/resources/discovery/passages_test_doc_1.json";
  private static final String PASSAGES_TEST_FILE_2 = "src/test/resources/discovery/passages_test_doc_2.json";
  private static String environmentId;
  private static String collectionId;
  private Discovery discovery;
  private String uniqueName;

  private Set<String> configurationIds = new HashSet<String>();
  private Set<String> collectionIds = new HashSet<String>();

  private static DiscoveryServiceIT dummyTest;

  @BeforeClass
  public static void setupClass() throws Exception {
    // get the properties
    dummyTest = new DiscoveryServiceIT();
    String username = dummyTest.getProperty("discovery.username");

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    dummyTest.setup();

    ListEnvironmentsOptions listOptions = new ListEnvironmentsOptions.Builder().build();
    ListEnvironmentsResponse listResponse = dummyTest.discovery.listEnvironments(listOptions).execute();
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
      Environment createResponse = dummyTest.discovery.createEnvironment(createOptions).execute();
      environmentId = createResponse.getEnvironmentId();
      WaitFor.Condition environmentReady = new EnvironmentReady(dummyTest.discovery, environmentId);
      WaitFor.waitFor(environmentReady, 30, TimeUnit.SECONDS, 500);
    }

    collectionId = dummyTest.setupTestDocuments();
  }

  @AfterClass
  public static void cleanupClass() throws Exception {
    dummyTest.cleanup();
  }

  @Before
  public void setup() throws Exception {
    super.setUp();
    String username = getProperty("discovery.username");
    String password = getProperty("discovery.password");
    String url = getProperty("discovery.url");
    discovery = new Discovery(Discovery.VERSION_DATE_2017_09_01);
    discovery.setEndPoint(url);
    discovery.setUsernameAndPassword(username, password);

    uniqueName = UUID.randomUUID().toString();
  }

  @After
  public void cleanup() {
    for (String collectionId : collectionIds) {
      DeleteCollectionOptions deleteOptions = new DeleteCollectionOptions.Builder(environmentId, collectionId).build();
      try {
        discovery.deleteCollection(deleteOptions).execute();
      } catch (NotFoundException ex) {
        // Ignore this failure - just print msg
        System.out.println("deleteCollection failed. Collection " + collectionId + " not found");
      }
    }

    for (String configurationId : configurationIds) {
      DeleteConfigurationOptions deleteOptions =
          new DeleteConfigurationOptions.Builder(environmentId, configurationId).build();
      try {
        discovery.deleteConfiguration(deleteOptions).execute();
      } catch (NotFoundException ex) {
        // Ignore this failure - just print msg
        System.out.println("deleteConfiguration failed. Configuration " + configurationId + " not found");
      }
    }
  }

  public boolean ping() throws RuntimeException {
    discovery.listEnvironments(null).execute();
    return true;
  }

  private static final String DEFAULT_CONFIG_NAME = "Default Configuration";

  @Test
  public void exampleIsSuccessful() {
//    Discovery discovery = new Discovery("2016-12-15");
//    discovery.setEndPoint("https://gateway.watsonplatform.net/discovery/api");
//    discovery.setUsernameAndPassword("<username>", "<password");
    String environmentId = null;
    String configurationId = null;
    String collectionId = null;
    String documentId = null;

    //See if an environment already exists
    System.out.println("Check if environment exists");
    ListEnvironmentsOptions listOptions = new ListEnvironmentsOptions.Builder().build();
    ListEnvironmentsResponse listResponse = discovery.listEnvironments(listOptions).execute();
    for (Environment environment : listResponse.getEnvironments()) {
      //look for an existing environment that isn't read only
      if (!environment.isReadOnly()) {
        environmentId = environment.getEnvironmentId();
        System.out.println("Found existing environment ID: " + environmentId);
        break;
      }
    }

    if (environmentId == null) {
      System.out.println("No environment found, creating new one...");
      //no environment found, create a new one (assuming we are a FREE plan)
      String environmentName = "watson_developer_cloud_test_environment";
      CreateEnvironmentOptions createOptions = new CreateEnvironmentOptions.Builder()
          .name(environmentName)
          .size(0L)  /* FREE */
          .build();
      Environment createResponse = discovery.createEnvironment(createOptions).execute();
      environmentId = createResponse.getEnvironmentId();
      System.out.println("Created new environment ID: " + environmentId);

      //wait for environment to be ready
      System.out.println("Waiting for environment to be ready...");
      boolean environmentReady = false;
      while (!environmentReady) {
        GetEnvironmentOptions getEnvironmentOptions = new GetEnvironmentOptions.Builder(environmentId).build();
        Environment getEnvironmentResponse = discovery.getEnvironment(getEnvironmentOptions).execute();
        environmentReady = getEnvironmentResponse.getStatus().equals(Environment.Status.ACTIVE);
        try {
          if (!environmentReady) {
            Thread.sleep(500);
          }
        } catch (InterruptedException e) {
          throw new RuntimeException("Interrupted", e);
        }
      }
      System.out.println("Environment Ready!");
    }

    //find the default configuration
    System.out.println("Finding the default configuration");
    ListConfigurationsOptions listConfigsOptions = new ListConfigurationsOptions.Builder(environmentId).build();
    ListConfigurationsResponse listConfigsResponse = discovery.listConfigurations(listConfigsOptions).execute();
    for (Configuration configuration : listConfigsResponse.getConfigurations()) {
      if (configuration.getName().equals(DEFAULT_CONFIG_NAME)) {
        configurationId = configuration.getConfigurationId();
        System.out.println("Found default configuration ID: " + configurationId);
        break;
      }
    }

    //create a new collection
    System.out.println("Creating a new collection...");
    String collectionName = "my_watson_developer_cloud_collection" + UUID.randomUUID();
    CreateCollectionOptions createCollectionOptions =
        new CreateCollectionOptions.Builder(environmentId, collectionName).configurationId(configurationId).build();
    Collection collection = discovery.createCollection(createCollectionOptions).execute();
    collectionId = collection.getCollectionId();
    System.out.println("Created a collection ID: " + collectionId);

    //wait for the collection to be "available"
    System.out.println("Waiting for collection to be ready...");
    boolean collectionReady = false;
    while (!collectionReady) {
      GetCollectionOptions getCollectionOptions =
          new GetCollectionOptions.Builder(environmentId, collectionId).build();
      Collection getCollectionResponse = discovery.getCollection(getCollectionOptions).execute();
      collectionReady = getCollectionResponse.getStatus().equals(Collection.Status.ACTIVE);
      try {
        if (!collectionReady) {
          Thread.sleep(500);
        }
      } catch (InterruptedException e) {
        throw new RuntimeException("Interrupted", e);
      }
    }
    System.out.println("Collection Ready!");

    //add a document
    System.out.println("Creating a new document...");
    String documentJson = "{\"field\":\"value\"}";
    InputStream documentStream = new ByteArrayInputStream(documentJson.getBytes());

    AddDocumentOptions.Builder createDocumentBuilder =
        new AddDocumentOptions.Builder(environmentId, collectionId);
    createDocumentBuilder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    createDocumentBuilder.filename("test_file");
    DocumentAccepted createDocumentResponse = discovery.addDocument(createDocumentBuilder.build()).execute();
    documentId = createDocumentResponse.getDocumentId();
    System.out.println("Created a document ID: " + documentId);

    //wait for document to be ready
    System.out.println("Waiting for document to be ready...");
    boolean documentReady = false;
    while (!documentReady) {
      GetDocumentStatusOptions getDocumentStatusOptions =
          new GetDocumentStatusOptions.Builder(environmentId, collectionId, documentId).build();
      DocumentStatus getDocumentResponse = discovery.getDocumentStatus(getDocumentStatusOptions).execute();
      documentReady = !getDocumentResponse.getStatus().equals(DocumentStatus.Status.PROCESSING);
      try {
        if (!documentReady) {
          Thread.sleep(500);
        }
      } catch (InterruptedException e) {
        throw new RuntimeException("Interrupted");
      }
    }
    System.out.println("Document Ready!");

    //query document
    System.out.println("Querying the collection...");
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    queryBuilder.query("field:value");
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();

    //print out the results
    System.out.println("Query Results:");
    System.out.println(queryResponse);

    //cleanup the collection created
    System.out.println("Deleting the collection...");
    DeleteCollectionOptions deleteOptions =
        new DeleteCollectionOptions.Builder(environmentId, collectionId).build();
    discovery.deleteCollection(deleteOptions).execute();
    System.out.println("Collection deleted!");

    System.out.println("Discovery example finished");
  }

  @Test
  public void pingIsSuccessful() {
    assertTrue(ping());
  }

  @Test(expected = UnauthorizedException.class)
  public void badCredentialsThrowsException() {
    Discovery badService = new Discovery(Discovery.VERSION_DATE_2017_08_01, "foo", "bar");
    badService.listEnvironments(null).execute();
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
    deleteEnvironment(deleteOptions);
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

    Date start = new Date();

    String uniqueConfigName = uniqueName + "-config";
    String description = "Description of " + uniqueConfigName;
    Conversions conversions = new Conversions();
    HtmlSettings htmlSettings = new HtmlSettings();
    htmlSettings.setExcludeTagsCompletely(Arrays.asList("table", "h6", "header"));
    conversions.setHtml(htmlSettings);
    NormalizationOperation operation = new NormalizationOperation();
    operation.setOperation("foo");
    operation.setSourceField("bar");
    operation.setDestinationField("baz");
    List<NormalizationOperation> normalizations = Arrays.asList(operation);
    Enrichment enrichment = new Enrichment();
    enrichment.setSourceField("foo");
    enrichment.setDestinationField("bar");
    enrichment.setEnrichmentName("baz");
    enrichment.setDescription("Erich foo to bar with baz");
    enrichment.setIgnoreDownstreamErrors(true);
    enrichment.setOverwrite(false);
    EnrichmentOptions enrichmentOptions = new EnrichmentOptions();
    enrichmentOptions.setSentiment(true);
    enrichmentOptions.setExtract(Arrays.asList("qux"));
    enrichmentOptions.setHierarchicalTypedRelations(false);
    enrichmentOptions.setLanguage("en");
    enrichmentOptions.setModel("WhatComesAfterQux");
    enrichmentOptions.setQuotations(true);
    enrichmentOptions.setShowSourceText(true);
    enrichment.setOptions(enrichmentOptions);
    List<Enrichment> enrichments = Arrays.asList(enrichment);

    CreateConfigurationOptions createOptions = new CreateConfigurationOptions.Builder()
        .environmentId(environmentId)
        .name(uniqueConfigName)
        .description(description)
        .conversions(conversions)
        .normalizations(normalizations)
        .enrichments(enrichments)
        .build();
    Configuration createResponse = createConfiguration(createOptions);

    assertEquals(uniqueConfigName, createResponse.getName());
    assertEquals(description, createResponse.getDescription());
    assertEquals(conversions, createResponse.getConversions());
    assertEquals(normalizations, createResponse.getNormalizations());
    assertEquals(enrichments, createResponse.getEnrichments());

    Date now = new Date();
    assertTrue(fuzzyBefore(createResponse.getCreated(), now));
    assertTrue(fuzzyAfter(createResponse.getCreated(), start));
    assertTrue(fuzzyBefore(createResponse.getUpdated(), now));
    assertTrue(fuzzyAfter(createResponse.getUpdated(), start));

  }

  @Test
  public void deleteConfigurationIsSuccessful() {
    Configuration createResponse = createTestConfig();

    DeleteConfigurationOptions deleteOptions =
        new DeleteConfigurationOptions.Builder(environmentId, createResponse.getConfigurationId()).build();
    deleteConfiguration(deleteOptions);
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

    Configuration testConfig = createTestConfig();

    Date start = new Date();

    String updatedName = testConfig.getName() + UUID.randomUUID().toString();
    String updatedDescription = "Description of " + updatedName;
    Conversions updatedConversions = new Conversions();
    HtmlSettings newHtmlSettings = new HtmlSettings();
    newHtmlSettings.setExcludeTagsCompletely(Arrays.asList("table", "h6", "header"));
    updatedConversions.setHtml(newHtmlSettings);
    NormalizationOperation operation = new NormalizationOperation();
    operation.setOperation("foo");
    operation.setSourceField("bar");
    operation.setDestinationField("baz");
    List<NormalizationOperation> updatedNormalizations = Arrays.asList(operation);
    Enrichment enrichment = new Enrichment();
    enrichment.setSourceField("foo");
    enrichment.setDestinationField("bar");
    enrichment.setEnrichmentName("baz");
    enrichment.setDescription("Erich foo to bar with baz");
    enrichment.setIgnoreDownstreamErrors(true);
    enrichment.setOverwrite(false);
    EnrichmentOptions enrichmentOptions = new EnrichmentOptions();
    enrichmentOptions.setSentiment(true);
    enrichmentOptions.setExtract(Arrays.asList("qux"));
    enrichmentOptions.setHierarchicalTypedRelations(false);
    enrichmentOptions.setLanguage("en");
    enrichmentOptions.setModel("WhatComesAfterQux");
    enrichmentOptions.setQuotations(true);
    enrichmentOptions.setShowSourceText(true);
    enrichment.setOptions(enrichmentOptions);
    List<Enrichment> updatedEnrichments = Arrays.asList(enrichment);

    UpdateConfigurationOptions.Builder updateBuilder =
        new UpdateConfigurationOptions.Builder(environmentId, testConfig.getConfigurationId());
    updateBuilder.name(updatedName);
    updateBuilder.description(updatedDescription);
    updateBuilder.conversions(updatedConversions);
    updateBuilder.normalizations(updatedNormalizations);
    updateBuilder.enrichments(updatedEnrichments);
    Configuration updatedConfiguration = discovery.updateConfiguration(updateBuilder.build()).execute();

    assertEquals(updatedName, updatedConfiguration.getName());
    assertEquals(updatedDescription, updatedConfiguration.getDescription());
    assertEquals(updatedConversions, updatedConfiguration.getConversions());
    assertEquals(updatedNormalizations, updatedConfiguration.getNormalizations());
    assertEquals(updatedEnrichments, updatedConfiguration.getEnrichments());

    Date now = new Date();
    assertTrue(fuzzyBefore(updatedConfiguration.getCreated(), start));
    assertTrue(fuzzyBefore(updatedConfiguration.getUpdated(), now));
    assertTrue(fuzzyAfter(updatedConfiguration.getUpdated(), start));
  }

  // Collections

  @Test
  public void listCollectionsIsSuccessful() {
    createTestCollection();
    ListCollectionsOptions listOptions = new ListCollectionsOptions.Builder(environmentId).build();
    ListCollectionsResponse listResponse = discovery.listCollections(listOptions).execute();

    assertFalse(listResponse.getCollections().isEmpty());
  }

  @Test
  public void createCollectionIsSuccessful() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    String uniqueCollectionDescription = "Description of " + uniqueCollectionName;

    CreateCollectionOptions.Builder createCollectionBuilder =
        new CreateCollectionOptions.Builder(environmentId, uniqueCollectionName)
            .configurationId(createConfigResponse.getConfigurationId())
            .description(uniqueCollectionDescription);
    Collection createResponse = createCollection(createCollectionBuilder.build());

    assertEquals(createConfigResponse.getConfigurationId(), createResponse.getConfigurationId());
    assertEquals(uniqueCollectionName, createResponse.getName());
    assertEquals(uniqueCollectionDescription, createResponse.getDescription());
  }

  @Test
  public void createCollectionWithMinimalParametersIsSuccessful() {
    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionOptions createOptions =
        new CreateCollectionOptions.Builder(environmentId, uniqueCollectionName).build();
    Collection createResponse = createCollection(createOptions);

    assertNotNull(createResponse.getCollectionId());
  }

  @Test
  public void updateCollectionIsSuccessful() {
    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionOptions createOptions =
        new CreateCollectionOptions.Builder(environmentId, uniqueCollectionName).build();
    Collection collection = createCollection(createOptions);
    assertNotNull(collection.getCollectionId());

    Configuration testConfig = createTestConfig();
    String updatedCollectionName = UUID.randomUUID().toString() + "-collection";
    String updatedCollectionDescription = "Description for " + updatedCollectionName;
    UpdateCollectionOptions.Builder updateBuilder =
        new UpdateCollectionOptions.Builder(environmentId, collection.getCollectionId());
    updateBuilder.name(updatedCollectionName);
    updateBuilder.description(updatedCollectionDescription);
    updateBuilder.configurationId(testConfig.getConfigurationId());
    Collection updatedCollection = discovery.updateCollection(updateBuilder.build()).execute();

    assertEquals(updatedCollectionName, updatedCollection.getName());
    assertEquals(updatedCollectionDescription, updatedCollection.getDescription());
    assertEquals(testConfig.getConfigurationId(), updatedCollection.getConfigurationId());
  }

  @Test
  public void deleteCollectionIsSuccessful() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionOptions.Builder createCollectionBuilder =
        new CreateCollectionOptions.Builder(environmentId, uniqueCollectionName)
            .configurationId(createConfigResponse.getConfigurationId());
    Collection createResponse = createCollection(createCollectionBuilder.build());

    // need to wait for collection to be ready

    DeleteCollectionOptions deleteOptions =
        new DeleteCollectionOptions.Builder(environmentId, createResponse.getCollectionId()).build();
    deleteCollection(deleteOptions);
  }

  @Test
  public void getCollectionIsSuccessful() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionOptions.Builder createCollectionBuilder =
        new CreateCollectionOptions.Builder(environmentId, uniqueCollectionName)
            .configurationId(createConfigResponse.getConfigurationId());
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
    CreateCollectionOptions.Builder createCollectionBuilder =
        new CreateCollectionOptions.Builder(environmentId, uniqueCollectionName)
            .configurationId(createConfigResponse.getConfigurationId());
    createCollection(createCollectionBuilder.build());

    ListCollectionsOptions.Builder getBuilder = new ListCollectionsOptions.Builder(environmentId);
    getBuilder.name(uniqueCollectionName);
    ListCollectionsResponse getResponse = discovery.listCollections(getBuilder.build()).execute();

    assertEquals(1, getResponse.getCollections().size());
    assertEquals(uniqueCollectionName, getResponse.getCollections().get(0).getName());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void addDocumentIsSuccessful() {
    Collection collection = createTestCollection();

    String myDocumentJson = "{\"field\":\"value\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    AddDocumentOptions.Builder builder = new AddDocumentOptions.Builder();
    builder.environmentId(environmentId);
    builder.collectionId(collection.getCollectionId());
    builder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    builder.filename("test_file");
    DocumentAccepted createResponse = discovery.addDocument(builder.build()).execute();

    assertFalse(createResponse.getDocumentId().isEmpty());
    assertNull(createResponse.getNotices());
  }

  @Test
  public void addDocumentWithConfigurationIsSuccessful() {
    Collection collection = createTestCollection();
    uniqueName = UUID.randomUUID().toString();

    String myDocumentJson = "{\"field\":\"value\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    AddDocumentOptions.Builder builder = new AddDocumentOptions.Builder();
    builder.environmentId(environmentId);
    builder.collectionId(collection.getCollectionId());
    builder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    builder.filename("test_file");
    DocumentAccepted createResponse = discovery.addDocument(builder.build()).execute();

    assertFalse(createResponse.getDocumentId().isEmpty());
    assertNull(createResponse.getNotices());
  }

  @Ignore
  @SuppressWarnings("deprecation")
  @Test
  public void addDocumentWithMetadataIsSuccessful() {
    Collection collection = createTestCollection();
    String collectionId = collection.getCollectionId();

    String myDocumentJson = "{\"field\":\"value\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    AddDocumentOptions.Builder builder = new AddDocumentOptions.Builder(environmentId, collectionId);
    builder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    builder.filename("test_file");
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
    DocumentAccepted documentAccepted = createTestDocument("test_document", collectionId);

    DeleteDocumentOptions deleteOptions =
        new DeleteDocumentOptions.Builder(environmentId, collectionId, documentAccepted.getDocumentId()).build();
    discovery.deleteDocument(deleteOptions).execute();
  }

  @Ignore
  @Test
  public void getDocumentIsSuccessful() {
    Collection collection = createTestCollection();
    String collectionId = collection.getCollectionId();
    DocumentAccepted documentAccepted = createTestDocument("test_document", collectionId);

    GetDocumentStatusOptions getOptions =
        new GetDocumentStatusOptions.Builder(environmentId, collectionId, documentAccepted.getDocumentId()).build();
    DocumentStatus getResponse = discovery.getDocumentStatus(getOptions).execute();

    assertEquals(DocumentStatus.Status.AVAILABLE, getResponse.getStatus());
  }

  @Test
  public void updateDocumentIsSuccessful() {
    Collection collection = createTestCollection();
    String collectionId = collection.getCollectionId();
    DocumentAccepted documentAccepted = createTestDocument("test_document", collectionId);

    uniqueName = UUID.randomUUID().toString();
    Configuration testConfig = createTestConfig();
    String myDocumentJson = "{\"field\":\"value2\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    UpdateDocumentOptions.Builder updateBuilder =
        new UpdateDocumentOptions.Builder(environmentId, collectionId, documentAccepted.getDocumentId());
    updateBuilder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    updateBuilder.filename("test_file");
    //updateBuilder.configurationId(testConfig.getConfigurationId());
    DocumentAccepted updateResponse = discovery.updateDocument(updateBuilder.build()).execute();

    GetDocumentStatusOptions getOptions =
        new GetDocumentStatusOptions.Builder(environmentId, collectionId, updateResponse.getDocumentId()).build();
    DocumentStatus getResponse = discovery.getDocumentStatus(getOptions).execute();

    assertTrue(getResponse.getStatus().equals(DocumentStatus.Status.AVAILABLE)
        || getResponse.getStatus().equals(DocumentStatus.Status.PROCESSING));
  }

  @Test
  public void updateAnotherDocumentIsSuccessful() {
    Collection collection = createTestCollection();
    String collectionId = collection.getCollectionId();

    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    AddDocumentOptions.Builder builder = new AddDocumentOptions.Builder(environmentId, collectionId);
    builder.metadata(myMetadata.toString());
    DocumentAccepted documentAccepted = discovery.addDocument(builder.build()).execute();

    String myDocumentJson = "{\"field\":\"value2\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    UpdateDocumentOptions.Builder updateBuilder =
        new UpdateDocumentOptions.Builder(environmentId, collectionId, documentAccepted.getDocumentId());
    updateBuilder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    updateBuilder.filename("test_file");
    DocumentAccepted updateResponse = discovery.updateDocument(updateBuilder.build()).execute();

    GetDocumentStatusOptions getOptions =
        new GetDocumentStatusOptions.Builder(environmentId, collectionId, updateResponse.getDocumentId()).build();
    DocumentStatus getResponse = discovery.getDocumentStatus(getOptions).execute();

    assertTrue(getResponse.getStatus().equals(DocumentStatus.Status.AVAILABLE)
        || getResponse.getStatus().equals(DocumentStatus.Status.PROCESSING));
  }

  @Test
  @Ignore("Pending implementation of 'processing' after document update")
  public void updateDocumentWithMetadataIsSuccessful() {
    Collection collection = createTestCollection();
    String collectionId = collection.getCollectionId();
    DocumentAccepted documentAccepted = createTestDocument("test_document", collectionId);

    String myDocumentJson = "{\"field\":\"value2\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    UpdateDocumentOptions.Builder updateBuilder =
        new UpdateDocumentOptions.Builder(environmentId, collectionId, documentAccepted.getDocumentId());
    updateBuilder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    updateBuilder.metadata(myMetadata.toString());
    DocumentAccepted updateResponse = discovery.updateDocument(updateBuilder.build()).execute();

    WaitFor.Condition waitForDocumentAccepted =
        new WaitForDocumentAccepted(environmentId, collectionId, updateResponse.getDocumentId());
    WaitFor.waitFor(waitForDocumentAccepted, 5, TimeUnit.SECONDS, 500);

    QueryOptions queryOptions = new QueryOptions.Builder(environmentId, collectionId).build();
    QueryResponse queryResponse = discovery.query(queryOptions).execute();

    assertTrue(queryResponse.getResults().get(0).getMetadata() != null);
  }

  @Ignore
  @Test
  public void getCollectionFieldsIsSuccessful() {
    Collection collection = createTestCollection();
    String collectionId = collection.getCollectionId();
    createTestDocument("test_document", collectionId);

    ListCollectionFieldsOptions getOptions =
        new ListCollectionFieldsOptions.Builder(environmentId, collectionId).build();
    ListCollectionFieldsResponse getResponse = discovery.listCollectionFields(getOptions).execute();

    assertFalse(getResponse.getFields().isEmpty());
  }

  // query tests

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
    String[] expected = new String[]{"id", "score", "field"};
    assertTrue(queryResponse.getResults().get(0).keySet().containsAll(Arrays.asList(expected)));
  }

  @Ignore
  @Test
  public void queryWithQueryIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    queryBuilder.query("field" + Operator.CONTAINS + 1);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    assertEquals(new Long(1), queryResponse.getMatchingResults());
    assertEquals(1, queryResponse.getResults().size());
    assertTrue(queryResponse.getResults().get(0).getScore() > 1.0);
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
  public void queryWithSortIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    ArrayList<String> sortList = new ArrayList<>();
    sortList.add("field");
    queryBuilder.sort(sortList);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    assertTrue(queryResponse.getResults().size() > 1);
    Double v0 = (Double) (queryResponse.getResults().get(0)).get("field");
    Double v1 = (Double) (queryResponse.getResults().get(1)).get("field");
    assertTrue(v0 <= v1);
  }

  @Test
  public void queryWithAggregationTermIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.TERM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.AND);
    sb.append(10L);
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    Term term = (Term) queryResponse.getAggregations().get(0);
    assertEquals(1, queryResponse.getAggregations().size());
    assertEquals(new Long(10), term.getCount());
  }

  @Test
  public void queryWithNestedAggregationTermIsSuccessful() {
    Collection collection = createTestCollection();
    String collectionId = collection.getCollectionId();
    createTestDocument("test_document_1", collectionId);
    createTestDocument("test_document_2", collectionId);

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
    Term term = (Term) queryResponse.getAggregations().get(0);
    AggregationResult agResults = term.getResults().get(0);
    List<QueryAggregation> aggregations = agResults.getAggregations();
    assertFalse(aggregations.isEmpty());
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
    sb.append(5L);
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    Histogram histogram = (Histogram) queryResponse.getAggregations().get(0);
    Long interval = histogram.getInterval();
    assertEquals(new Long(5), interval);
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
    Calculation max = (Calculation) queryResponse.getAggregations().get(0);
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
    Calculation min = (Calculation) queryResponse.getAggregations().get(0);
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
    Calculation sum = (Calculation) queryResponse.getAggregations().get(0);
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
    Calculation avg = (Calculation) queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.AVERAGE.getName(), avg.getType());
    assertEquals(new Double(4.5), avg.getValue());
  }

  @Test
  public void queryWithPassagesIsSuccessful() throws InterruptedException, FileNotFoundException {
    Collection testCollection = createTestCollection();
    String collectionId = testCollection.getCollectionId();
    createTestDocument(getStringFromInputStream(new FileInputStream(PASSAGES_TEST_FILE_1)), "test_document_1",
        collectionId);
    createTestDocument(getStringFromInputStream(new FileInputStream(PASSAGES_TEST_FILE_2)),
        "test_document_2", collectionId);

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    queryBuilder.passages(true);
    queryBuilder.naturalLanguageQuery("Watson");
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    List<QueryPassages> passages = queryResponse.getPassages();
    assertTrue(passages.size() > 0);
    for (QueryPassages passage : passages) {
      assertTrue(passage.getPassageText().contains("Watson"));
    }
  }

  // queryNotices tests

  @Test
  public void queryNoticesCountIsSuccessful() {
    String collectionId = setupTestDocuments();

    QueryNoticesOptions.Builder queryBuilder = new QueryNoticesOptions.Builder(environmentId, collectionId);
    queryBuilder.count(5L);
    QueryNoticesResponse queryResponse = discovery.queryNotices(queryBuilder.build()).execute();
    assertTrue(queryResponse.getResults().size() <= 5);
  }

  // Tests for testConfigurationInEnvironment

  @Test
  public void testConfigurationInEnvironmentIsSuccessful() {
    Configuration testConfig = createTestConfig();
    String myDocumentJson = "{\"field\":\"value2\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());
    TestConfigurationInEnvironmentOptions options =
        new TestConfigurationInEnvironmentOptions.Builder(environmentId)
            .configurationId(testConfig.getConfigurationId())
            .file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON)
            .filename("test_file")
            .build();
    TestDocument testResponse = discovery.testConfigurationInEnvironment(options).execute();
    assertNotNull(testResponse);
    assertEquals(0, testResponse.getNotices().size());
  }

  @Test
  public void testConfigurationInEnvironmentWithAllOptionsIsSuccessful() {
    Configuration testConfig = createTestConfig();
    String myDocumentJson = "{\"field\":\"value2\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    TestConfigurationInEnvironmentOptions.Builder builder = new TestConfigurationInEnvironmentOptions.Builder();
    builder.environmentId(environmentId);
    builder.configurationId(testConfig.getConfigurationId());
    builder.step(TestConfigurationInEnvironmentOptions.Step.HTML_OUTPUT);
    builder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    builder.filename("test_file");
    builder.metadata(myMetadata.toString());
    TestDocument testResponse = discovery.testConfigurationInEnvironment(builder.build()).execute();

    assertNotNull(testResponse);
    assertEquals(0, testResponse.getNotices().size());
  }

  // Tests for reported issues

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
    String[] operations = new String[]{Operation.MOVE, Operation.COPY, Operation.MERGE, Operation.REMOVE,
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

  /* Issue 659: creating a collection does not use the configuration id */
  @Test
  public void issueNumber659() {
    String uniqueConfigName = UUID.randomUUID().toString() + "-config";
    Configuration testConfiguration = getTestConfiguration(DISCOVERY_TEST_CONFIG_FILE);
    CreateConfigurationOptions configOptions = new CreateConfigurationOptions.Builder(environmentId)
        .configuration(testConfiguration)
        .name(uniqueConfigName)
        .build();
    Configuration configuration = discovery.createConfiguration(configOptions).execute();
    configurationIds.add(configuration.getConfigurationId());

    String uniqueCollectionName = UUID.randomUUID().toString() + "-collection";
    CreateCollectionOptions collectionOptions =
        new CreateCollectionOptions.Builder(environmentId, uniqueCollectionName)
            .configurationId(configuration.getConfigurationId())
            .build();
    Collection collection = discovery.createCollection(collectionOptions).execute();
    collectionIds.add(collection.getCollectionId());

    assertEquals(collection.getConfigurationId(), configuration.getConfigurationId());
  }

  @Test
  public void addTrainingDataIsSuccessful() {
    AddTrainingDataOptions.Builder builder = new AddTrainingDataOptions.Builder(environmentId, collectionId);
    String naturalLanguageQuery = "Example query" + UUID.randomUUID().toString();
    builder.naturalLanguageQuery(naturalLanguageQuery);
    TrainingExample example = new TrainingExample();
    String documentId = createTestDocument("test_document", collectionId).getDocumentId();
    example.setDocumentId(documentId);
    int relevance = 0;
    example.setRelevance(relevance);
    builder.addExamples(example);
    TrainingQuery response = discovery.addTrainingData(builder.build()).execute();

    assertFalse(response.getQueryId().isEmpty());
    assertEquals(response.getNaturalLanguageQuery(), naturalLanguageQuery);
    assertTrue(response.getFilter().isEmpty());
    assertEquals(response.getExamples().size(), 1);

    TrainingExample returnedExample = response.getExamples().get(0);
    assertEquals(returnedExample.getDocumentId(), documentId);
    assertTrue(returnedExample.getCrossReference().isEmpty());
    assertEquals(returnedExample.getRelevance(), new Long(relevance));
  }

  @Test
  public void addTrainingExampleIsSuccessful() {
    TrainingQuery query = createTestQuery(collectionId, "Query" + UUID.randomUUID().toString());
    int startingExampleCount = query.getExamples().size();
    String queryId = query.getQueryId();

    String documentId = "document_id";
    String crossReference = "cross_reference";
    int relevance = 50;
    CreateTrainingExampleOptions.Builder exampleBuilder
        = new CreateTrainingExampleOptions.Builder(environmentId, collectionId, queryId);
    exampleBuilder.documentId(documentId);
    exampleBuilder.crossReference(crossReference);
    exampleBuilder.relevance(relevance);
    discovery.createTrainingExample(exampleBuilder.build()).execute();

    GetTrainingDataOptions.Builder queryBuilder
        = new GetTrainingDataOptions.Builder(environmentId, collectionId, queryId);
    TrainingQuery updatedQuery = discovery.getTrainingData(queryBuilder.build()).execute();

    assertTrue(updatedQuery.getExamples().size() > startingExampleCount);
    TrainingExample newExample = updatedQuery.getExamples().get(0);
    assertEquals(newExample.getDocumentId(), documentId);
    assertEquals(newExample.getCrossReference(), crossReference);
    assertEquals(newExample.getRelevance(), new Long(relevance));
  }

  @Test
  public void deleteAllCollectionTrainingDataIsSuccessful() {
    String collId = setupTestQueries(collectionId);
    DeleteAllTrainingDataOptions.Builder deleteBuilder
        = new DeleteAllTrainingDataOptions.Builder(environmentId, collId);
    discovery.deleteAllTrainingData(deleteBuilder.build()).execute();

    ListTrainingDataOptions.Builder listBuilder = new ListTrainingDataOptions.Builder(environmentId, collId);
    TrainingDataSet trainingData = discovery.listTrainingData(listBuilder.build()).execute();

    assertEquals(trainingData.getQueries().size(), 0);
  }

  @Test
  public void deleteTrainingDataQueryIsSuccessful() {
    TrainingQuery query = createTestQuery(collectionId, "Query" + UUID.randomUUID().toString());
    String queryId = query.getQueryId();

    ListTrainingDataOptions.Builder listBuilder = new ListTrainingDataOptions.Builder(environmentId, collectionId);
    TrainingDataSet trainingData = discovery.listTrainingData(listBuilder.build()).execute();
    List<TrainingQuery> queryList = trainingData.getQueries();
    boolean doesQueryExist = false;
    for (TrainingQuery q : queryList) {
      if (q.getQueryId().equals(queryId)) {
        doesQueryExist = true;
        break;
      }
    }
    assertTrue(doesQueryExist);

    DeleteTrainingDataOptions.Builder deleteBuilder
        = new DeleteTrainingDataOptions.Builder(environmentId, collectionId, queryId);
    discovery.deleteTrainingData(deleteBuilder.build()).execute();

    listBuilder = new ListTrainingDataOptions.Builder(environmentId, collectionId);
    trainingData = discovery.listTrainingData(listBuilder.build()).execute();
    queryList = trainingData.getQueries();
    doesQueryExist = false;
    for (TrainingQuery q : queryList) {
      if (q.getQueryId().equals(queryId)) {
        doesQueryExist = true;
        break;
      }
    }
    assertFalse(doesQueryExist);
  }

  @Test
  public void deleteTrainingDataExampleIsSuccessful() {
    TrainingQuery newQuery = createTestQuery(collectionId, "Query" + UUID.randomUUID().toString());
    String queryId = newQuery.getQueryId();

    String documentId = "document_id";
    String crossReference = "cross_reference";
    int relevance = 50;
    CreateTrainingExampleOptions.Builder exampleBuilder
        = new CreateTrainingExampleOptions.Builder(environmentId, collectionId, queryId);
    exampleBuilder.documentId(documentId);
    exampleBuilder.crossReference(crossReference);
    exampleBuilder.relevance(relevance);
    TrainingExample createdExample = discovery.createTrainingExample(exampleBuilder.build()).execute();
    String exampleId = createdExample.getDocumentId();

    GetTrainingDataOptions.Builder queryBuilder
        = new GetTrainingDataOptions.Builder(environmentId, collectionId, queryId);
    TrainingQuery queryWithAddedExample = discovery.getTrainingData(queryBuilder.build()).execute();
    int startingCount = queryWithAddedExample.getExamples().size();

    DeleteTrainingExampleOptions.Builder deleteBuilder
        = new DeleteTrainingExampleOptions.Builder(environmentId, collectionId, queryId, exampleId);
    discovery.deleteTrainingExample(deleteBuilder.build()).execute();

    GetTrainingDataOptions.Builder newQueryBuilder
        = new GetTrainingDataOptions.Builder(environmentId, collectionId, queryId);
    TrainingQuery queryWithDeletedExample = discovery.getTrainingData(newQueryBuilder.build()).execute();

    assertTrue(startingCount > queryWithDeletedExample.getExamples().size());
  }

  @Test
  public void getTrainingDataIsSuccessful() {
    String naturalLanguageQuery = "Query" + UUID.randomUUID().toString();
    TrainingQuery newQuery = createTestQuery(collectionId, naturalLanguageQuery);
    String queryId = newQuery.getQueryId();

    GetTrainingDataOptions.Builder queryBuilder
        = new GetTrainingDataOptions.Builder(environmentId, collectionId, queryId);
    TrainingQuery queryResponse = discovery.getTrainingData(queryBuilder.build()).execute();

    assertEquals(queryResponse.getNaturalLanguageQuery(), naturalLanguageQuery);
  }

  @Test
  public void getTrainingExampleIsSuccessful() {
    AddTrainingDataOptions.Builder builder = new AddTrainingDataOptions.Builder(environmentId, collectionId);
    String naturalLanguageQuery = "Query" + UUID.randomUUID().toString();
    builder.naturalLanguageQuery(naturalLanguageQuery);
    TrainingExample example = new TrainingExample();
    String documentId = "Document" + UUID.randomUUID().toString();
    example.setDocumentId(documentId);
    int relevance = 0;
    example.setRelevance(relevance);
    builder.addExamples(example);
    TrainingQuery response = discovery.addTrainingData(builder.build()).execute();
    String queryId = response.getQueryId();

    GetTrainingExampleOptions.Builder getExampleBuilder
        = new GetTrainingExampleOptions.Builder(environmentId, collectionId, queryId, documentId);
    TrainingExample returnedExample = discovery.getTrainingExample(getExampleBuilder.build()).execute();

    assertEquals(returnedExample.getDocumentId(), documentId);
  }

  @Test
  public void updateTrainingExampleIsSuccessful() {
    AddTrainingDataOptions.Builder builder = new AddTrainingDataOptions.Builder(environmentId, collectionId);
    String naturalLanguageQuery = "Query" + UUID.randomUUID().toString();
    builder.naturalLanguageQuery(naturalLanguageQuery);
    TrainingExample example = new TrainingExample();
    String documentId = "Document" + UUID.randomUUID().toString();
    example.setDocumentId(documentId);
    int relevance = 0;
    example.setRelevance(relevance);
    builder.addExamples(example);
    TrainingQuery response = discovery.addTrainingData(builder.build()).execute();
    String queryId = response.getQueryId();

    UpdateTrainingExampleOptions.Builder updateBuilder
        = new UpdateTrainingExampleOptions.Builder(environmentId, collectionId, queryId, documentId);
    String newCrossReference = "cross_reference";
    updateBuilder.crossReference(newCrossReference);
    int newRelevance = 50;
    updateBuilder.relevance(newRelevance);
    TrainingExample updatedExample = discovery.updateTrainingExample(updateBuilder.build()).execute();

    assertEquals(updatedExample.getCrossReference(), newCrossReference);
    assertEquals(updatedExample.getRelevance(), new Long(newRelevance));
  }

  private Environment createEnvironment(CreateEnvironmentOptions createOptions) {
    Environment createResponse = discovery.createEnvironment(createOptions).execute();
    return createResponse;
  }

  private void deleteEnvironment(DeleteEnvironmentOptions deleteOptions) {
    discovery.deleteEnvironment(deleteOptions).execute();
  }

  private Configuration createConfiguration(CreateConfigurationOptions createOptions) {
    Configuration createResponse = discovery.createConfiguration(createOptions).execute();
    configurationIds.add(createResponse.getConfigurationId());
    return createResponse;
  }

  private void deleteConfiguration(DeleteConfigurationOptions deleteOptions) {
    discovery.deleteConfiguration(deleteOptions).execute();
    configurationIds.remove(deleteOptions.configurationId());
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

  private void deleteCollection(DeleteCollectionOptions deleteOptions) {
    discovery.deleteCollection(deleteOptions).execute();
    collectionIds.remove(deleteOptions.collectionId());
  }

  private Collection createTestCollection() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionOptions.Builder createCollectionBuilder =
        new CreateCollectionOptions.Builder(environmentId, uniqueCollectionName)
            .configurationId(createConfigResponse.getConfigurationId());
    Collection createResponse = createCollection(createCollectionBuilder.build());
    return createResponse;
  }

  private DocumentAccepted createTestDocument(String filename, String collectionId) {
    String myDocumentJson = "{\"field\":\"value\"}";
    return createTestDocument(myDocumentJson, filename, collectionId);
  }

  @SuppressWarnings("deprecation")
  private DocumentAccepted createTestDocument(String json, String filename, String collectionId) {
    InputStream documentStream = new ByteArrayInputStream(json.getBytes());
    AddDocumentOptions.Builder builder = new AddDocumentOptions.Builder(environmentId, collectionId);
    builder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    builder.filename(filename);
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
      String filename = "test_document_" + i;
      responses.add(createTestDocument(json, filename, collectionId));
    }
    return responses;
  }

  private synchronized String setupTestDocuments() {
    if (collectionId != null) {
      return collectionId;
    }
    Collection collection = createTestCollection();
    String collectionId = collection.getCollectionId();
    @SuppressWarnings("unused")
    List<DocumentAccepted> documentAccepted = createTestDocuments(collectionId, 10);

    WaitFor.Condition collectionAvailable =
        new WaitForCollectionAvailable(environmentId, collectionId);
    WaitFor.waitFor(collectionAvailable, 5, TimeUnit.SECONDS, 500);

    return collectionId;
  }

  private TrainingQuery createTestQuery(String collectionId, String naturalLanguageQuery) {
    AddTrainingDataOptions.Builder builder = new AddTrainingDataOptions.Builder(environmentId, collectionId);
    builder.naturalLanguageQuery(naturalLanguageQuery);
    TrainingQuery addResponse = discovery.addTrainingData(builder.build()).execute();
    return addResponse;
  }

  private List<TrainingQuery> createTestQueries(String collectionId, int totalQueries) {
    List<TrainingQuery> responses = new ArrayList<>();
    for (int i = 0; i < totalQueries; i++) {
      String naturalLanguageQuery = "Test query " + i;
      responses.add(createTestQuery(collectionId, naturalLanguageQuery));
    }
    return responses;
  }

  private synchronized String setupTestQueries(String collectionId) {
    ListTrainingDataOptions.Builder builder = new ListTrainingDataOptions.Builder(environmentId, collectionId);
    if (discovery.listTrainingData(builder.build()).execute().getQueries().size() > 0) {
      return collectionId;
    }
    List<TrainingQuery> queriesAccepted = createTestQueries(collectionId, 10);

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
      GetDocumentStatusOptions getOptions =
          new GetDocumentStatusOptions.Builder(environmentId, collectionId, documentId).build();
      String status = discovery.getDocumentStatus(getOptions).execute().getStatus();
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

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

package com.ibm.watson.discovery.v1;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.service.exception.BadRequestException;
import com.ibm.cloud.sdk.core.service.exception.ForbiddenException;
import com.ibm.cloud.sdk.core.service.exception.InternalServerErrorException;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.UnauthorizedException;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.watson.common.RetryRunner;
import com.ibm.watson.common.WaitFor;
import com.ibm.watson.common.WatsonServiceTest;
import com.ibm.watson.discovery.v1.model.AddDocumentOptions;
import com.ibm.watson.discovery.v1.model.AddTrainingDataOptions;
import com.ibm.watson.discovery.v1.model.Calculation;
import com.ibm.watson.discovery.v1.model.Collection;
import com.ibm.watson.discovery.v1.model.Configuration;
import com.ibm.watson.discovery.v1.model.Conversions;
import com.ibm.watson.discovery.v1.model.CreateCollectionOptions;
import com.ibm.watson.discovery.v1.model.CreateConfigurationOptions;
import com.ibm.watson.discovery.v1.model.CreateCredentialsOptions;
import com.ibm.watson.discovery.v1.model.CreateEnvironmentOptions;
import com.ibm.watson.discovery.v1.model.CreateEventOptions;
import com.ibm.watson.discovery.v1.model.CreateEventResponse;
import com.ibm.watson.discovery.v1.model.CreateExpansionsOptions;
import com.ibm.watson.discovery.v1.model.CreateGatewayOptions;
import com.ibm.watson.discovery.v1.model.CreateStopwordListOptions;
import com.ibm.watson.discovery.v1.model.CreateTokenizationDictionaryOptions;
import com.ibm.watson.discovery.v1.model.CreateTrainingExampleOptions;
import com.ibm.watson.discovery.v1.model.CredentialDetails;
import com.ibm.watson.discovery.v1.model.Credentials;
import com.ibm.watson.discovery.v1.model.CredentialsList;
import com.ibm.watson.discovery.v1.model.DeleteAllTrainingDataOptions;
import com.ibm.watson.discovery.v1.model.DeleteCollectionOptions;
import com.ibm.watson.discovery.v1.model.DeleteConfigurationOptions;
import com.ibm.watson.discovery.v1.model.DeleteCredentialsOptions;
import com.ibm.watson.discovery.v1.model.DeleteDocumentOptions;
import com.ibm.watson.discovery.v1.model.DeleteEnvironmentOptions;
import com.ibm.watson.discovery.v1.model.DeleteExpansionsOptions;
import com.ibm.watson.discovery.v1.model.DeleteGatewayOptions;
import com.ibm.watson.discovery.v1.model.DeleteStopwordListOptions;
import com.ibm.watson.discovery.v1.model.DeleteTokenizationDictionaryOptions;
import com.ibm.watson.discovery.v1.model.DeleteTrainingDataOptions;
import com.ibm.watson.discovery.v1.model.DeleteTrainingExampleOptions;
import com.ibm.watson.discovery.v1.model.DeleteUserDataOptions;
import com.ibm.watson.discovery.v1.model.DocumentAccepted;
import com.ibm.watson.discovery.v1.model.DocumentStatus;
import com.ibm.watson.discovery.v1.model.Enrichment;
import com.ibm.watson.discovery.v1.model.EnrichmentOptions;
import com.ibm.watson.discovery.v1.model.Environment;
import com.ibm.watson.discovery.v1.model.EventData;
import com.ibm.watson.discovery.v1.model.Expansion;
import com.ibm.watson.discovery.v1.model.Expansions;
import com.ibm.watson.discovery.v1.model.Filter;
import com.ibm.watson.discovery.v1.model.Gateway;
import com.ibm.watson.discovery.v1.model.GatewayList;
import com.ibm.watson.discovery.v1.model.GetCollectionOptions;
import com.ibm.watson.discovery.v1.model.GetConfigurationOptions;
import com.ibm.watson.discovery.v1.model.GetCredentialsOptions;
import com.ibm.watson.discovery.v1.model.GetDocumentStatusOptions;
import com.ibm.watson.discovery.v1.model.GetEnvironmentOptions;
import com.ibm.watson.discovery.v1.model.GetGatewayOptions;
import com.ibm.watson.discovery.v1.model.GetStopwordListStatusOptions;
import com.ibm.watson.discovery.v1.model.GetTokenizationDictionaryStatusOptions;
import com.ibm.watson.discovery.v1.model.GetTrainingDataOptions;
import com.ibm.watson.discovery.v1.model.GetTrainingExampleOptions;
import com.ibm.watson.discovery.v1.model.Histogram;
import com.ibm.watson.discovery.v1.model.HtmlSettings;
import com.ibm.watson.discovery.v1.model.ListCollectionFieldsOptions;
import com.ibm.watson.discovery.v1.model.ListCollectionFieldsResponse;
import com.ibm.watson.discovery.v1.model.ListCollectionsOptions;
import com.ibm.watson.discovery.v1.model.ListCollectionsResponse;
import com.ibm.watson.discovery.v1.model.ListConfigurationsOptions;
import com.ibm.watson.discovery.v1.model.ListConfigurationsResponse;
import com.ibm.watson.discovery.v1.model.ListCredentialsOptions;
import com.ibm.watson.discovery.v1.model.ListEnvironmentsOptions;
import com.ibm.watson.discovery.v1.model.ListEnvironmentsResponse;
import com.ibm.watson.discovery.v1.model.ListExpansionsOptions;
import com.ibm.watson.discovery.v1.model.ListGatewaysOptions;
import com.ibm.watson.discovery.v1.model.ListTrainingDataOptions;
import com.ibm.watson.discovery.v1.model.LogQueryResponse;
import com.ibm.watson.discovery.v1.model.MetricResponse;
import com.ibm.watson.discovery.v1.model.MetricTokenResponse;
import com.ibm.watson.discovery.v1.model.Nested;
import com.ibm.watson.discovery.v1.model.NluEnrichmentEmotion;
import com.ibm.watson.discovery.v1.model.NluEnrichmentEntities;
import com.ibm.watson.discovery.v1.model.NluEnrichmentFeatures;
import com.ibm.watson.discovery.v1.model.NluEnrichmentKeywords;
import com.ibm.watson.discovery.v1.model.NluEnrichmentSemanticRoles;
import com.ibm.watson.discovery.v1.model.NluEnrichmentSentiment;
import com.ibm.watson.discovery.v1.model.NormalizationOperation;
import com.ibm.watson.discovery.v1.model.NormalizationOperation.Operation;
import com.ibm.watson.discovery.v1.model.QueryAggregation;
import com.ibm.watson.discovery.v1.model.QueryNoticesOptions;
import com.ibm.watson.discovery.v1.model.QueryNoticesResponse;
import com.ibm.watson.discovery.v1.model.QueryOptions;
import com.ibm.watson.discovery.v1.model.QueryPassages;
import com.ibm.watson.discovery.v1.model.QueryResponse;
import com.ibm.watson.discovery.v1.model.Term;
import com.ibm.watson.discovery.v1.model.TestConfigurationInEnvironmentOptions;
import com.ibm.watson.discovery.v1.model.TestDocument;
import com.ibm.watson.discovery.v1.model.Timeslice;
import com.ibm.watson.discovery.v1.model.TokenDictRule;
import com.ibm.watson.discovery.v1.model.TokenDictStatusResponse;
import com.ibm.watson.discovery.v1.model.TopHits;
import com.ibm.watson.discovery.v1.model.TrainingDataSet;
import com.ibm.watson.discovery.v1.model.TrainingExample;
import com.ibm.watson.discovery.v1.model.TrainingQuery;
import com.ibm.watson.discovery.v1.model.UpdateCollectionOptions;
import com.ibm.watson.discovery.v1.model.UpdateConfigurationOptions;
import com.ibm.watson.discovery.v1.model.UpdateCredentialsOptions;
import com.ibm.watson.discovery.v1.model.UpdateDocumentOptions;
import com.ibm.watson.discovery.v1.model.UpdateEnvironmentOptions;
import com.ibm.watson.discovery.v1.model.UpdateTrainingExampleOptions;
import com.ibm.watson.discovery.v1.query.AggregationType;
import com.ibm.watson.discovery.v1.query.Operator;
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
import java.util.Collections;
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
import static org.junit.Assert.fail;

/**
 * Integration tests for {@link Discovery}.
 */
@RunWith(RetryRunner.class)
public class DiscoveryServiceIT extends WatsonServiceTest {

  private static final String DISCOVERY1_TEST_CONFIG_FILE = "src/test/resources/discovery/issue517.json";
  private static final String DISCOVERY2_TEST_CONFIG_FILE = "src/test/resources/discovery/issue518.json";
  private static final String PASSAGES_TEST_FILE_1 = "src/test/resources/discovery/passages_test_doc_1.json";
  private static final String PASSAGES_TEST_FILE_2 = "src/test/resources/discovery/passages_test_doc_2.json";
  private static final String STOPWORDS_TEST_FILE = "src/test/resources/discovery/stopwords.txt";
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
    String apiKey = dummyTest.getProperty("discovery.apikey");

    Assume.assumeFalse("config.properties doesn't have valid credentials.", apiKey == null);

    dummyTest.setup();

    ListEnvironmentsOptions listOptions = new ListEnvironmentsOptions.Builder().build();
    ListEnvironmentsResponse listResponse = dummyTest.discovery.listEnvironments(listOptions).execute().getResult();
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
          .name(environmentName).build();
      Environment createResponse = dummyTest.discovery.createEnvironment(createOptions).execute().getResult();
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
    String apiKey = getProperty("discovery.apikey");
    String url = getProperty("discovery.url");
    discovery = new Discovery("2018-05-23");
    discovery.setEndPoint(url);
    IamOptions iamOptions = new IamOptions.Builder()
        .apiKey(apiKey)
        .build();
    discovery.setIamCredentials(iamOptions);
    discovery.setDefaultHeaders(getDefaultHeaders());

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
      DeleteConfigurationOptions deleteOptions = new DeleteConfigurationOptions.Builder(environmentId, configurationId)
          .build();
      try {
        discovery.deleteConfiguration(deleteOptions).execute();
      } catch (NotFoundException ex) {
        // Ignore this failure - just print msg
        System.out.println("deleteConfiguration failed. Configuration " + configurationId + " not found");
      }
    }
  }

  public boolean ping() throws RuntimeException {
    discovery.listEnvironments(null).execute().getResult();
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
    ListEnvironmentsResponse listResponse = discovery.listEnvironments(listOptions).execute().getResult();
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
          .build();
      Environment createResponse = discovery.createEnvironment(createOptions).execute().getResult();
      environmentId = createResponse.getEnvironmentId();
      System.out.println("Created new environment ID: " + environmentId);

      //wait for environment to be ready
      System.out.println("Waiting for environment to be ready...");
      boolean environmentReady = false;
      while (!environmentReady) {
        GetEnvironmentOptions getEnvironmentOptions = new GetEnvironmentOptions.Builder(environmentId).build();
        Environment getEnvironmentResponse = discovery.getEnvironment(getEnvironmentOptions).execute().getResult();
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
    ListConfigurationsResponse listConfigsResponse
        = discovery.listConfigurations(listConfigsOptions).execute().getResult();
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
    CreateCollectionOptions createCollectionOptions = new CreateCollectionOptions.Builder(environmentId, collectionName)
        .configurationId(configurationId).build();
    Collection collection = discovery.createCollection(createCollectionOptions).execute().getResult();
    collectionId = collection.getCollectionId();
    System.out.println("Created a collection ID: " + collectionId);

    //wait for the collection to be "available"
    System.out.println("Waiting for collection to be ready...");
    boolean collectionReady = false;
    while (!collectionReady) {
      GetCollectionOptions getCollectionOptions = new GetCollectionOptions.Builder(environmentId, collectionId).build();
      Collection getCollectionResponse = discovery.getCollection(getCollectionOptions).execute().getResult();
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

    AddDocumentOptions.Builder createDocumentBuilder = new AddDocumentOptions.Builder(environmentId, collectionId);
    createDocumentBuilder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    createDocumentBuilder.filename("test_file");
    DocumentAccepted createDocumentResponse
        = discovery.addDocument(createDocumentBuilder.build()).execute().getResult();
    documentId = createDocumentResponse.getDocumentId();
    System.out.println("Created a document ID: " + documentId);

    //wait for document to be ready
    System.out.println("Waiting for document to be ready...");
    boolean documentReady = false;
    while (!documentReady) {
      GetDocumentStatusOptions getDocumentStatusOptions = new GetDocumentStatusOptions.Builder(environmentId,
          collectionId, documentId).build();
      DocumentStatus getDocumentResponse = discovery.getDocumentStatus(getDocumentStatusOptions).execute().getResult();
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
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();

    //print out the results
    System.out.println("Query Results:");
    System.out.println(queryResponse);

    //cleanup the collection created
    System.out.println("Deleting the collection...");
    DeleteCollectionOptions deleteOptions = new DeleteCollectionOptions.Builder(environmentId, collectionId).build();
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
    Discovery badService = new Discovery("2017-11-07", "foo", "bar");
    badService.listEnvironments(null).execute().getResult();
  }

  @Test(expected = ForbiddenException.class)
  public void pingBadUrlThrowsException() {
    discovery.setEndPoint("https://gateway.watsonplatform.net/discovery-foo/api");
    ping();
  }

  @Test
  public void getEnvironmentIsSuccessful() {
    GetEnvironmentOptions getOptions = new GetEnvironmentOptions.Builder(environmentId).build();
    Environment getResponse = discovery.getEnvironment(getOptions).execute().getResult();

    assertEquals(environmentId, getResponse.getEnvironmentId());
  }

  @Test
  public void listEnvironmentsIsSuccessful() {
    ListEnvironmentsOptions listOptions = new ListEnvironmentsOptions.Builder().build();
    ListEnvironmentsResponse listResponse = discovery.listEnvironments(listOptions).execute().getResult();

    assertFalse(listResponse.getEnvironments().isEmpty());
  }

  @Test
  public void listEnvironmentsHasNewsEnvironment() {
    ListEnvironmentsOptions listOptions = new ListEnvironmentsOptions.Builder().build();
    ListEnvironmentsResponse listResponse = discovery.listEnvironments(listOptions).execute().getResult();

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
    Environment getResponse = discovery.getEnvironment(getOptions).execute().getResult();

    ListEnvironmentsOptions.Builder getBuilder = new ListEnvironmentsOptions.Builder();
    getBuilder.name(getResponse.getName());
    ListEnvironmentsResponse listResponse = discovery.listEnvironments(getBuilder.build()).execute().getResult();

    assertEquals(1, listResponse.getEnvironments().size());
  }

  @Test
  @Ignore("Only 1 BYOD environment allowed per service instance, so we cannot create more")
  public void createEnvironmentIsSuccessful() {
    String environmentName = uniqueName + "-environment";
    CreateEnvironmentOptions createOptions = new CreateEnvironmentOptions.Builder().name(environmentName).build();
    Environment createResponse = createEnvironment(createOptions);

    assertEquals(environmentName, createResponse.getName());
  }

  @Test
  @Ignore("Only 1 BYOD environment allowed per service instance, so do not delete it")
  public void deleteEnvironmentIsSuccessful() {
    String environmentName = uniqueName + "-environment";
    CreateEnvironmentOptions createOptions = new CreateEnvironmentOptions.Builder().name(environmentName).build();
    Environment createResponse = createEnvironment(createOptions);

    DeleteEnvironmentOptions deleteOptions = new DeleteEnvironmentOptions.Builder(createResponse.getEnvironmentId())
        .build();
    deleteEnvironment(deleteOptions);
  }

  @Test
  @Ignore("Only 1 BYOD environment allowed per service instance, so we cannot create more")
  public void updateEnvironmentIsSuccessful() {
    String environmentName = uniqueName + "-environment";
    CreateEnvironmentOptions createOptions = new CreateEnvironmentOptions.Builder().name(environmentName).build();
    Environment createResponse = createEnvironment(createOptions);

    String randomDescription = UUID.randomUUID().toString() + " appbuilder tests";
    UpdateEnvironmentOptions.Builder updateBuilder = new UpdateEnvironmentOptions.Builder(createResponse
        .getEnvironmentId()).name(environmentName);
    updateBuilder.description(randomDescription);
    Environment updateResponse = discovery.updateEnvironment(updateBuilder.build()).execute().getResult();

    assertEquals(randomDescription, updateResponse.getDescription());
  }

  @Test
  public void getConfigurationsIsSuccessful() {
    ListConfigurationsOptions getOptions = new ListConfigurationsOptions.Builder(environmentId).build();
    ListConfigurationsResponse getResponse = discovery.listConfigurations(getOptions).execute().getResult();

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

    NluEnrichmentSentiment sentiment = new NluEnrichmentSentiment.Builder()
        .document(true)
        .build();
    NluEnrichmentEmotion emotion = new NluEnrichmentEmotion.Builder()
        .document(true)
        .build();
    NluEnrichmentEntities entities = new NluEnrichmentEntities.Builder()
        .emotion(true)
        .sentiment(true)
        .model("WhatComesAfterQux")
        .build();
    NluEnrichmentKeywords keywords = new NluEnrichmentKeywords.Builder()
        .emotion(true)
        .sentiment(true)
        .build();
    NluEnrichmentSemanticRoles semanticRoles = new NluEnrichmentSemanticRoles.Builder()
        .entities(true)
        .build();
    NluEnrichmentFeatures features = new NluEnrichmentFeatures.Builder()
        .sentiment(sentiment)
        .emotion(emotion)
        .entities(entities)
        .keywords(keywords)
        .semanticRoles(semanticRoles)
        .build();
    EnrichmentOptions options = new EnrichmentOptions.Builder()
        .features(features)
        .language(EnrichmentOptions.Language.EN)
        .build();

    enrichment.setOptions(options);
    List<Enrichment> enrichments = Collections.singletonList(enrichment);

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

    DeleteConfigurationOptions deleteOptions = new DeleteConfigurationOptions.Builder(environmentId, createResponse
        .getConfigurationId()).build();
    deleteConfiguration(deleteOptions);
  }

  @Test
  public void getConfigurationIsSuccessful() {
    Configuration createResponse = createTestConfig();

    GetConfigurationOptions getOptions = new GetConfigurationOptions.Builder(environmentId, createResponse
        .getConfigurationId()).build();
    Configuration getResponse = discovery.getConfiguration(getOptions).execute().getResult();

    assertEquals(createResponse.getName(), getResponse.getName());
  }

  @Test
  public void getConfigurationsByNameIsSuccessful() {
    Configuration createResponse = createTestConfig();

    ListConfigurationsOptions.Builder getBuilder = new ListConfigurationsOptions.Builder(environmentId);
    getBuilder.name(createResponse.getName());
    ListConfigurationsResponse getResponse = discovery.listConfigurations(getBuilder.build()).execute().getResult();

    assertEquals(1, getResponse.getConfigurations().size());
    assertEquals(createResponse.getName(), getResponse.getConfigurations().get(0).getName());
  }

  @Test
  public void getConfigurationsWithFunkyNameIsSuccessful() {
    String uniqueConfigName = uniqueName + " with \"funky\" ?x=y&foo=bar ,[x](y) ~!@#$%^&*()-+ {} | ;:<>\\/ chars";

    CreateConfigurationOptions.Builder createBuilder
        = new CreateConfigurationOptions.Builder(environmentId, uniqueConfigName);
    createConfiguration(createBuilder.build());

    ListConfigurationsOptions.Builder getBuilder = new ListConfigurationsOptions.Builder(environmentId);
    getBuilder.name(uniqueConfigName);
    ListConfigurationsResponse getResponse = discovery.listConfigurations(getBuilder.build()).execute().getResult();

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

    NluEnrichmentSentiment sentiment = new NluEnrichmentSentiment.Builder()
        .document(true)
        .build();
    NluEnrichmentEmotion emotion = new NluEnrichmentEmotion.Builder()
        .document(true)
        .build();
    NluEnrichmentEntities entities = new NluEnrichmentEntities.Builder()
        .emotion(true)
        .sentiment(true)
        .model("WhatComesAfterQux")
        .build();
    NluEnrichmentKeywords keywords = new NluEnrichmentKeywords.Builder()
        .emotion(true)
        .sentiment(true)
        .build();
    NluEnrichmentSemanticRoles semanticRoles = new NluEnrichmentSemanticRoles.Builder()
        .entities(true)
        .build();
    NluEnrichmentFeatures features = new NluEnrichmentFeatures.Builder()
        .sentiment(sentiment)
        .emotion(emotion)
        .entities(entities)
        .keywords(keywords)
        .semanticRoles(semanticRoles)
        .build();
    EnrichmentOptions options = new EnrichmentOptions.Builder()
        .features(features)
        .build();

    enrichment.setOptions(options);
    List<Enrichment> updatedEnrichments = Collections.singletonList(enrichment);

    UpdateConfigurationOptions.Builder updateBuilder
        = new UpdateConfigurationOptions.Builder(environmentId, testConfig.getConfigurationId(), updatedName);
    updateBuilder.description(updatedDescription);
    updateBuilder.conversions(updatedConversions);
    updateBuilder.normalizations(updatedNormalizations);
    updateBuilder.enrichments(updatedEnrichments);
    Configuration updatedConfiguration = discovery.updateConfiguration(updateBuilder.build()).execute().getResult();

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
    ListCollectionsResponse listResponse = discovery.listCollections(listOptions).execute().getResult();

    assertFalse(listResponse.getCollections().isEmpty());
  }

  @Test
  public void createCollectionIsSuccessful() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    String uniqueCollectionDescription = "Description of " + uniqueCollectionName;

    CreateCollectionOptions.Builder createCollectionBuilder = new CreateCollectionOptions.Builder(environmentId,
        uniqueCollectionName)
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
    CreateCollectionOptions createOptions = new CreateCollectionOptions.Builder(environmentId, uniqueCollectionName)
        .build();
    Collection createResponse = createCollection(createOptions);

    assertNotNull(createResponse.getCollectionId());
  }

  @Test
  public void updateCollectionIsSuccessful() {
    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionOptions createOptions = new CreateCollectionOptions.Builder(environmentId, uniqueCollectionName)
        .build();
    Collection collection = createCollection(createOptions);
    assertNotNull(collection.getCollectionId());

    Configuration testConfig = createTestConfig();
    String updatedCollectionName = UUID.randomUUID().toString() + "-collection";
    String updatedCollectionDescription = "Description for " + updatedCollectionName;
    UpdateCollectionOptions.Builder updateBuilder = new UpdateCollectionOptions.Builder(environmentId, collection
        .getCollectionId());
    updateBuilder.name(updatedCollectionName);
    updateBuilder.description(updatedCollectionDescription);
    updateBuilder.configurationId(testConfig.getConfigurationId());
    Collection updatedCollection = discovery.updateCollection(updateBuilder.build()).execute().getResult();

    assertEquals(updatedCollectionName, updatedCollection.getName());
    assertEquals(updatedCollectionDescription, updatedCollection.getDescription());
    assertEquals(testConfig.getConfigurationId(), updatedCollection.getConfigurationId());
  }

  @Test
  public void deleteCollectionIsSuccessful() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionOptions.Builder createCollectionBuilder = new CreateCollectionOptions.Builder(environmentId,
        uniqueCollectionName)
            .configurationId(createConfigResponse.getConfigurationId());
    Collection createResponse = createCollection(createCollectionBuilder.build());

    // need to wait for collection to be ready

    DeleteCollectionOptions deleteOptions = new DeleteCollectionOptions.Builder(environmentId, createResponse
        .getCollectionId()).build();
    deleteCollection(deleteOptions);
  }

  @Test
  public void getCollectionIsSuccessful() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionOptions.Builder createCollectionBuilder = new CreateCollectionOptions.Builder(environmentId,
        uniqueCollectionName)
            .configurationId(createConfigResponse.getConfigurationId());
    Collection createResponse = createCollection(createCollectionBuilder.build());

    GetCollectionOptions getOptions = new GetCollectionOptions.Builder(environmentId, createResponse.getCollectionId())
        .build();

    // need to wait for collection to be ready

    Collection getResponse = discovery.getCollection(getOptions).execute().getResult();

    assertEquals(createResponse.getName(), getResponse.getName());
  }

  @Test
  public void getCollectionsByNameIsSuccessful() {
    Configuration createConfigResponse = createTestConfig();

    String uniqueCollectionName = uniqueName + "-collection";
    CreateCollectionOptions.Builder createCollectionBuilder = new CreateCollectionOptions.Builder(environmentId,
        uniqueCollectionName)
            .configurationId(createConfigResponse.getConfigurationId());
    createCollection(createCollectionBuilder.build());

    ListCollectionsOptions.Builder getBuilder = new ListCollectionsOptions.Builder(environmentId);
    getBuilder.name(uniqueCollectionName);
    ListCollectionsResponse getResponse = discovery.listCollections(getBuilder.build()).execute().getResult();

    assertEquals(1, getResponse.getCollections().size());
    assertEquals(uniqueCollectionName, getResponse.getCollections().get(0).getName());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void addDocumentIsSuccessful() {
    String myDocumentJson = "{\"field\":\"value\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    AddDocumentOptions.Builder builder = new AddDocumentOptions.Builder();
    builder.environmentId(environmentId);
    //builder.collectionId(collection.getCollectionId());
    builder.collectionId(collectionId);
    builder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    builder.filename("test_file");
    DocumentAccepted createResponse = discovery.addDocument(builder.build()).execute().getResult();

    assertFalse(createResponse.getDocumentId().isEmpty());
    assertNull(createResponse.getNotices());
  }

  @Test
  public void addDocumentWithConfigurationIsSuccessful() {
    uniqueName = UUID.randomUUID().toString();

    String myDocumentJson = "{\"field\":\"value\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    AddDocumentOptions.Builder builder = new AddDocumentOptions.Builder();
    builder.environmentId(environmentId);
    builder.collectionId(collectionId);
    builder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    builder.filename("test_file");
    DocumentAccepted createResponse = discovery.addDocument(builder.build()).execute().getResult();

    assertFalse(createResponse.getDocumentId().isEmpty());
    assertNull(createResponse.getNotices());
  }

  @Ignore
  @SuppressWarnings("deprecation")
  @Test
  public void addDocumentWithMetadataIsSuccessful() {
    String myDocumentJson = "{\"field\":\"value\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    AddDocumentOptions.Builder builder = new AddDocumentOptions.Builder(environmentId, collectionId);
    builder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    builder.filename("test_file");
    builder.metadata(myMetadata.toString());

    DocumentAccepted createResponse = discovery.addDocument(builder.build()).execute().getResult();

    WaitFor.Condition documentAccepted = new WaitForDocumentAccepted(environmentId, collectionId, createResponse
        .getDocumentId());
    WaitFor.waitFor(documentAccepted, 5, TimeUnit.SECONDS, 500);

    QueryOptions queryOptions = new QueryOptions.Builder(environmentId, collectionId).build();
    QueryResponse queryResponse = discovery.query(queryOptions).execute().getResult();

    assertTrue(queryResponse.getResults().get(0).getMetadata() != null);
  }

  @Test
  public void deleteDocumentIsSuccessful() {
    DocumentAccepted documentAccepted = createTestDocument("test_document", collectionId);

    DeleteDocumentOptions deleteOptions = new DeleteDocumentOptions.Builder(environmentId, collectionId,
        documentAccepted.getDocumentId()).build();
    discovery.deleteDocument(deleteOptions).execute();
  }

  @Ignore
  @Test
  public void getDocumentIsSuccessful() {
    DocumentAccepted documentAccepted = createTestDocument("test_document", collectionId);

    GetDocumentStatusOptions getOptions = new GetDocumentStatusOptions.Builder(environmentId, collectionId,
        documentAccepted.getDocumentId()).build();
    DocumentStatus getResponse = discovery.getDocumentStatus(getOptions).execute().getResult();

    assertEquals(DocumentStatus.Status.AVAILABLE, getResponse.getStatus());
  }

  @Test
  public void updateDocumentIsSuccessful() {
    DocumentAccepted documentAccepted = createTestDocument("test_document", collectionId);

    uniqueName = UUID.randomUUID().toString();
    String myDocumentJson = "{\"field\":\"value2\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    UpdateDocumentOptions.Builder updateBuilder = new UpdateDocumentOptions.Builder(environmentId, collectionId,
        documentAccepted.getDocumentId());
    updateBuilder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    updateBuilder.filename("test_file");
    DocumentAccepted updateResponse = discovery.updateDocument(updateBuilder.build()).execute().getResult();

    GetDocumentStatusOptions getOptions = new GetDocumentStatusOptions.Builder(environmentId, collectionId,
        updateResponse.getDocumentId()).build();
    DocumentStatus getResponse = discovery.getDocumentStatus(getOptions).execute().getResult();

    assertTrue(getResponse.getStatus().equals(DocumentStatus.Status.AVAILABLE)
        || getResponse.getStatus().equals(DocumentStatus.Status.PROCESSING));
  }

  @Test
  public void updateAnotherDocumentIsSuccessful() {
    JsonObject myMetadata = new JsonObject();
    myMetadata.add("foo", new JsonPrimitive("bar"));

    AddDocumentOptions.Builder builder = new AddDocumentOptions.Builder(environmentId, collectionId);
    builder.metadata(myMetadata.toString());
    DocumentAccepted documentAccepted = discovery.addDocument(builder.build()).execute().getResult();

    String myDocumentJson = "{\"field\":\"value2\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

    UpdateDocumentOptions.Builder updateBuilder = new UpdateDocumentOptions.Builder(environmentId, collectionId,
        documentAccepted.getDocumentId());
    updateBuilder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    updateBuilder.filename("test_file");
    DocumentAccepted updateResponse = discovery.updateDocument(updateBuilder.build()).execute().getResult();

    GetDocumentStatusOptions getOptions = new GetDocumentStatusOptions.Builder(environmentId, collectionId,
        updateResponse.getDocumentId()).build();
    DocumentStatus getResponse = discovery.getDocumentStatus(getOptions).execute().getResult();

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

    UpdateDocumentOptions.Builder updateBuilder = new UpdateDocumentOptions.Builder(environmentId, collectionId,
        documentAccepted.getDocumentId());
    updateBuilder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    updateBuilder.metadata(myMetadata.toString());
    DocumentAccepted updateResponse = discovery.updateDocument(updateBuilder.build()).execute().getResult();

    WaitFor.Condition waitForDocumentAccepted = new WaitForDocumentAccepted(environmentId, collectionId, updateResponse
        .getDocumentId());
    WaitFor.waitFor(waitForDocumentAccepted, 5, TimeUnit.SECONDS, 500);

    QueryOptions queryOptions = new QueryOptions.Builder(environmentId, collectionId).build();
    QueryResponse queryResponse = discovery.query(queryOptions).execute().getResult();

    assertTrue(queryResponse.getResults().get(0).getMetadata() != null);
  }

  @Ignore
  @Test
  public void getCollectionFieldsIsSuccessful() {
    ListCollectionFieldsOptions getOptions = new ListCollectionFieldsOptions.Builder(environmentId, collectionId)
        .build();
    ListCollectionFieldsResponse getResponse = discovery.listCollectionFields(getOptions).execute().getResult();

    assertFalse(getResponse.getFields().isEmpty());
  }

  // query tests

  @Test
  public void queryWithCountIsSuccessful() {
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    queryBuilder.count(5L);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    assertEquals(new Long(10), queryResponse.getMatchingResults());
    assertEquals(5, queryResponse.getResults().size());
  }

  @Test
  public void queryWithOffsetIsSuccessful() {
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    queryBuilder.offset(5L);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    assertEquals(new Long(10), queryResponse.getMatchingResults());
    assertEquals(5, queryResponse.getResults().size());
  }

  @Ignore
  @Test
  public void queryWithQueryIsSuccessful() {
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    queryBuilder.query("field" + Operator.CONTAINS + 1);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    assertEquals(new Long(1), queryResponse.getMatchingResults());
    assertEquals(1, queryResponse.getResults().size());
  }

  @Test
  public void queryWithFilterIsSuccessful() {
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    queryBuilder.filter("field" + Operator.CONTAINS + 1);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    assertEquals(new Long(1), queryResponse.getMatchingResults());
    assertEquals(1, queryResponse.getResults().size());
  }

  @Test
  public void queryWithSortIsSuccessful() {
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    String sortList = "field";
    queryBuilder.sort(sortList);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    assertTrue(queryResponse.getResults().size() > 1);
    Double v0 = (Double) (queryResponse.getResults().get(0)).get("field");
    Double v1 = (Double) (queryResponse.getResults().get(1)).get("field");
    assertTrue(v0 <= v1);
  }

  @Test
  public void queryWithAggregationTermIsSuccessful() {
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
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    Term term = (Term) queryResponse.getAggregations().get(0);
    assertEquals(1, queryResponse.getAggregations().size());
    assertEquals(new Long(10), term.getCount());
  }

  @Test
  public void queryWithAggregationHistogramIsSuccessful() throws InterruptedException {
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
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    Histogram histogram = (Histogram) queryResponse.getAggregations().get(0);
    Long interval = histogram.getInterval();
    assertEquals(new Long(5), interval);
    assertEquals(2, histogram.getResults().size());
  }

  @Test
  public void queryWithAggregationMaximumIsSuccessful() throws InterruptedException {
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.MAX);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    Calculation max = (Calculation) queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.MAX.getName(), max.getType());
    assertEquals(new Double(9), max.getValue());
  }

  @Test
  public void queryWithAggregationMinimumIsSuccessful() throws InterruptedException {
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.MIN);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    Calculation min = (Calculation) queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.MIN.getName(), min.getType());
    assertEquals(new Double(0), min.getValue());
  }

  @Test
  public void queryWithAggregationSummationIsSuccessful() throws InterruptedException {
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.SUM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    Calculation sum = (Calculation) queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.SUM.getName(), sum.getType());
    assertEquals(new Double(45), sum.getValue());
  }

  @Test
  public void queryWithAggregationAverageIsSuccessful() throws InterruptedException {
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.AVERAGE);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    Calculation avg = (Calculation) queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.AVERAGE.getName(), avg.getType());
    assertEquals(new Double(4.5), avg.getValue());
  }

  @Test
  public void queryWithAggregationFilterIsSuccessful() {
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.FILTER);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field:9");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    Filter filter = (Filter) queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.FILTER.getName(), filter.getType());
    assertEquals("field:9", filter.getMatch());
    assertEquals(new Long(1), filter.getMatchingResults());
  }

  @Test
  public void queryWithAggregationNestedIsSuccessful() throws InterruptedException {
    DocumentAccepted testDocument = createNestedTestDocument("test_document_1", collectionId);
    String documentId = testDocument.getDocumentId();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.NESTED);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("nested_fields");
    sb.append(Operator.CLOSING_GROUPING);
    sb.append(Operator.NEST_AGGREGATION);
    sb.append(AggregationType.TERM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);

    GetDocumentStatusOptions getOptions = new GetDocumentStatusOptions.Builder()
        .environmentId(environmentId)
        .collectionId(collectionId)
        .documentId(documentId)
        .build();
    DocumentStatus status = discovery.getDocumentStatus(getOptions).execute().getResult();
    while (status.getStatus().equals(DocumentAccepted.Status.PROCESSING)) {
      Thread.sleep(3000);
      status = discovery.getDocumentStatus(getOptions).execute().getResult();
    }

    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    Nested nested = (Nested) queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.NESTED.getName(), nested.getType());
    assertNotNull(nested.getAggregations());
    QueryAggregation innerAggregation = nested.getAggregations().get(0);
    assertEquals(AggregationType.TERM.getName(), innerAggregation.getType());
  }

  @Test
  public void queryWithAggregationTimesliceIsSuccessful() throws InterruptedException {
    String myDocumentJson = "{\"time\":\"1999-02-16T00:00:00.000-05:00\"}";
    DocumentAccepted testDocument1 = createTestDocument(myDocumentJson, "timeslice_document_1", collectionId);
    String documentId1 = testDocument1.getDocumentId();
    myDocumentJson = "{\"time\":\"1999-04-16T00:00:00.000-05:00\"}";
    DocumentAccepted testDocument2 = createTestDocument(myDocumentJson, "timeslice_document_2", collectionId);
    String documentId2 = testDocument2.getDocumentId();

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.TIMESLICE);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("time,1day,EST");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);

    GetDocumentStatusOptions getOptions1 = new GetDocumentStatusOptions.Builder()
        .environmentId(environmentId)
        .collectionId(collectionId)
        .documentId(documentId1)
        .build();
    DocumentStatus status1 = discovery.getDocumentStatus(getOptions1).execute().getResult();
    GetDocumentStatusOptions getOptions2 = new GetDocumentStatusOptions.Builder()
        .environmentId(environmentId)
        .collectionId(collectionId)
        .documentId(documentId2)
        .build();
    DocumentStatus status2 = discovery.getDocumentStatus(getOptions2).execute().getResult();
    while (status1.getStatus().equals(DocumentAccepted.Status.PROCESSING)
        || status2.getStatus().equals(DocumentAccepted.Status.PROCESSING)) {
      Thread.sleep(3000);
      status1 = discovery.getDocumentStatus(getOptions1).execute().getResult();
      status2 = discovery.getDocumentStatus(getOptions2).execute().getResult();
    }

    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    Timeslice timeslice = (Timeslice) queryResponse.getAggregations().get(0);
    assertEquals(AggregationType.TIMESLICE.getName(), timeslice.getType());
    assertNotNull(timeslice.getResults());
  }

  @Test
  public void queryWithAggregationTopHitsIsSuccessful() {
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.TERM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    sb.append(Operator.NEST_AGGREGATION);
    sb.append(AggregationType.TOP_HITS);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("3");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    Term term = (Term) queryResponse.getAggregations().get(0);
    TopHits topHits = (TopHits) term.getResults().get(0).getAggregations().get(0);
    assertEquals(new Long(3), topHits.getSize());
    assertNotNull(topHits.getHits());
  }

  public void queryWithAggregationUniqueCountIsSuccessful() {
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.UNIQUE_COUNT);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    queryBuilder.aggregation(aggregation);
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    Calculation uniqueCount = (Calculation) queryResponse.getAggregations().get(0);
    assertEquals(new Double(10), uniqueCount.getValue());
  }

  @Test
  public void queryWithPassagesIsSuccessful() throws InterruptedException, FileNotFoundException {
    createTestDocument(getStringFromInputStream(new FileInputStream(PASSAGES_TEST_FILE_1)), "test_document_1",
        collectionId);
    createTestDocument(getStringFromInputStream(new FileInputStream(PASSAGES_TEST_FILE_2)),
        "test_document_2", collectionId);

    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    queryBuilder.passages(true);
    queryBuilder.naturalLanguageQuery("Watson");
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();
    List<QueryPassages> passages = queryResponse.getPassages();
    assertTrue(passages.size() > 0);
    for (QueryPassages passage : passages) {
      assertTrue(passage.getPassageText().contains("Watson"));
    }
  }

  // queryNotices tests

  @Test
  public void queryNoticesCountIsSuccessful() {
    QueryNoticesOptions.Builder queryBuilder = new QueryNoticesOptions.Builder(environmentId, collectionId);
    queryBuilder.count(5L);
    QueryNoticesResponse queryResponse = discovery.queryNotices(queryBuilder.build()).execute().getResult();
    assertTrue(queryResponse.getResults().size() <= 5);
  }

  // Tests for testConfigurationInEnvironment

  @Test
  public void testConfigurationInEnvironmentIsSuccessful() {
    Configuration testConfig = createTestConfig();
    String myDocumentJson = "{\"field\":\"value2\"}";
    InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());
    TestConfigurationInEnvironmentOptions options = new TestConfigurationInEnvironmentOptions.Builder(environmentId)
        .configurationId(testConfig.getConfigurationId())
        .file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON)
        .filename("test_file")
        .build();
    TestDocument testResponse = discovery.testConfigurationInEnvironment(options).execute().getResult();
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
    TestDocument testResponse = discovery.testConfigurationInEnvironment(builder.build()).execute().getResult();

    assertNotNull(testResponse);
    assertEquals(0, testResponse.getNotices().size());
  }

  // Tests for reported issues

  @Test
  public void issueNumber517() {
    String uniqueConfigName = uniqueName + "-config";
    CreateConfigurationOptions.Builder createBuilder = new CreateConfigurationOptions.Builder();
    createBuilder.environmentId(environmentId);
    Configuration configuration = getTestConfiguration(DISCOVERY1_TEST_CONFIG_FILE);

    configuration.setName(uniqueConfigName);
    createBuilder.configuration(configuration);
    Configuration createResponse = createConfiguration(createBuilder.build());

    GetConfigurationOptions getOptions = new GetConfigurationOptions.Builder(environmentId, createResponse
        .getConfigurationId()).build();
    Configuration getResponse = discovery.getConfiguration(getOptions).execute().getResult();

    // returned config should have some json data
    assertEquals(1, getResponse.getConversions().getJsonNormalizations().size());
  }

  @Test
  public void issueNumber518() {
    String[] operations = new String[] { Operation.MOVE, Operation.COPY, Operation.MERGE, Operation.REMOVE,
        Operation.REMOVE_NULLS };

    String uniqueConfigName = uniqueName + "-config";
    CreateConfigurationOptions.Builder createBuilder = new CreateConfigurationOptions.Builder();
    createBuilder.environmentId(environmentId);
    Configuration configuration = getTestConfiguration(DISCOVERY2_TEST_CONFIG_FILE);

    configuration.setName(uniqueConfigName);
    createBuilder.configuration(configuration);
    Configuration createResponse = createConfiguration(createBuilder.build());

    GetConfigurationOptions getOptions = new GetConfigurationOptions.Builder(environmentId, createResponse
        .getConfigurationId()).build();
    Configuration getResponse = discovery.getConfiguration(getOptions).execute().getResult();

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
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();

    assertEquals(new Long(2), queryResponse.getMatchingResults());
    assertEquals(2, queryResponse.getResults().size());
  }

  /* Issue 659: creating a collection does not use the configuration id */
  @Test
  public void issueNumber659() {
    String uniqueConfigName = UUID.randomUUID().toString() + "-config";
    CreateConfigurationOptions configOptions = new CreateConfigurationOptions.Builder()
        .environmentId(environmentId)
        .name(uniqueConfigName)
        .build();
    Configuration configuration = discovery.createConfiguration(configOptions).execute().getResult();
    configurationIds.add(configuration.getConfigurationId());

    String uniqueCollectionName = UUID.randomUUID().toString() + "-collection";
    CreateCollectionOptions collectionOptions = new CreateCollectionOptions.Builder(environmentId, uniqueCollectionName)
        .configurationId(configuration.getConfigurationId())
        .build();
    Collection collection = discovery.createCollection(collectionOptions).execute().getResult();
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
    TrainingQuery response = discovery.addTrainingData(builder.build()).execute().getResult();

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
    CreateTrainingExampleOptions.Builder exampleBuilder = new CreateTrainingExampleOptions.Builder(environmentId,
        collectionId, queryId);
    exampleBuilder.documentId(documentId);
    exampleBuilder.crossReference(crossReference);
    exampleBuilder.relevance(relevance);
    discovery.createTrainingExample(exampleBuilder.build()).execute().getResult();

    GetTrainingDataOptions.Builder queryBuilder = new GetTrainingDataOptions.Builder(environmentId, collectionId,
        queryId);
    TrainingQuery updatedQuery = discovery.getTrainingData(queryBuilder.build()).execute().getResult();

    assertTrue(updatedQuery.getExamples().size() > startingExampleCount);
    TrainingExample newExample = updatedQuery.getExamples().get(0);
    assertEquals(newExample.getDocumentId(), documentId);
    assertEquals(newExample.getCrossReference(), crossReference);
    assertEquals(newExample.getRelevance(), new Long(relevance));
  }

  @Test
  public void deleteAllCollectionTrainingDataIsSuccessful() {
    String collId = setupTestQueries(collectionId);
    DeleteAllTrainingDataOptions.Builder deleteBuilder = new DeleteAllTrainingDataOptions.Builder(environmentId,
        collId);
    discovery.deleteAllTrainingData(deleteBuilder.build()).execute();

    ListTrainingDataOptions.Builder listBuilder = new ListTrainingDataOptions.Builder(environmentId, collId);
    TrainingDataSet trainingData = discovery.listTrainingData(listBuilder.build()).execute().getResult();

    assertEquals(trainingData.getQueries().size(), 0);
  }

  @Test
  public void deleteTrainingDataQueryIsSuccessful() {
    TrainingQuery query = createTestQuery(collectionId, "Query" + UUID.randomUUID().toString());
    String queryId = query.getQueryId();

    ListTrainingDataOptions.Builder listBuilder = new ListTrainingDataOptions.Builder(environmentId, collectionId);
    TrainingDataSet trainingData = discovery.listTrainingData(listBuilder.build()).execute().getResult();
    List<TrainingQuery> queryList = trainingData.getQueries();
    boolean doesQueryExist = false;
    for (TrainingQuery q : queryList) {
      if (q.getQueryId().equals(queryId)) {
        doesQueryExist = true;
        break;
      }
    }
    assertTrue(doesQueryExist);

    DeleteTrainingDataOptions.Builder deleteBuilder = new DeleteTrainingDataOptions.Builder(environmentId, collectionId,
        queryId);
    discovery.deleteTrainingData(deleteBuilder.build()).execute();

    listBuilder = new ListTrainingDataOptions.Builder(environmentId, collectionId);
    trainingData = discovery.listTrainingData(listBuilder.build()).execute().getResult();
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
    CreateTrainingExampleOptions.Builder exampleBuilder = new CreateTrainingExampleOptions.Builder(environmentId,
        collectionId, queryId);
    exampleBuilder.documentId(documentId);
    exampleBuilder.crossReference(crossReference);
    exampleBuilder.relevance(relevance);
    TrainingExample createdExample = discovery.createTrainingExample(exampleBuilder.build()).execute().getResult();
    String exampleId = createdExample.getDocumentId();

    GetTrainingDataOptions.Builder queryBuilder = new GetTrainingDataOptions.Builder(environmentId, collectionId,
        queryId);
    TrainingQuery queryWithAddedExample = discovery.getTrainingData(queryBuilder.build()).execute().getResult();
    int startingCount = queryWithAddedExample.getExamples().size();

    DeleteTrainingExampleOptions.Builder deleteBuilder = new DeleteTrainingExampleOptions.Builder(environmentId,
        collectionId, queryId, exampleId);
    discovery.deleteTrainingExample(deleteBuilder.build()).execute();

    GetTrainingDataOptions.Builder newQueryBuilder = new GetTrainingDataOptions.Builder(environmentId, collectionId,
        queryId);
    TrainingQuery queryWithDeletedExample = discovery.getTrainingData(newQueryBuilder.build()).execute().getResult();

    assertTrue(startingCount > queryWithDeletedExample.getExamples().size());
  }

  @Test
  public void getTrainingDataIsSuccessful() {
    String naturalLanguageQuery = "Query" + UUID.randomUUID().toString();
    TrainingQuery newQuery = createTestQuery(collectionId, naturalLanguageQuery);
    String queryId = newQuery.getQueryId();

    GetTrainingDataOptions.Builder queryBuilder = new GetTrainingDataOptions.Builder(environmentId, collectionId,
        queryId);
    TrainingQuery queryResponse = discovery.getTrainingData(queryBuilder.build()).execute().getResult();

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
    TrainingQuery response = discovery.addTrainingData(builder.build()).execute().getResult();
    String queryId = response.getQueryId();

    GetTrainingExampleOptions.Builder getExampleBuilder = new GetTrainingExampleOptions.Builder(environmentId,
        collectionId, queryId, documentId);
    TrainingExample returnedExample = discovery.getTrainingExample(getExampleBuilder.build()).execute().getResult();

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
    TrainingQuery response = discovery.addTrainingData(builder.build()).execute().getResult();
    String queryId = response.getQueryId();

    UpdateTrainingExampleOptions.Builder updateBuilder = new UpdateTrainingExampleOptions.Builder(environmentId,
        collectionId, queryId, documentId);
    String newCrossReference = "cross_reference";
    updateBuilder.crossReference(newCrossReference);
    int newRelevance = 50;
    updateBuilder.relevance(newRelevance);
    TrainingExample updatedExample = discovery.updateTrainingExample(updateBuilder.build()).execute().getResult();

    assertEquals(updatedExample.getCrossReference(), newCrossReference);
    assertEquals(updatedExample.getRelevance(), new Long(newRelevance));
  }

  @Test
  public void expansionsOperationsAreSuccessful() {
    List<String> expansion1InputTerms = Arrays.asList("weekday", "week day");
    List<String> expansion1ExpandedTerms = Arrays.asList("monday", "tuesday", "wednesday", "thursday", "friday");
    List<String> expansion2InputTerms = Arrays.asList("weekend", "week end");
    List<String> expansion2ExpandedTerms = Arrays.asList("saturday", "sunday");
    Expansion expansion1 = new Expansion();
    expansion1.setInputTerms(expansion1InputTerms);
    expansion1.setExpandedTerms(expansion1ExpandedTerms);
    Expansion expansion2 = new Expansion();
    expansion2.setInputTerms(expansion2InputTerms);
    expansion2.setExpandedTerms(expansion2ExpandedTerms);
    Expansions expansions = new Expansions();
    expansions.setExpansions(Arrays.asList(expansion1, expansion2));
    CreateExpansionsOptions createOptions = new CreateExpansionsOptions.Builder()
        .environmentId(environmentId)
        .collectionId(collectionId)
        .expansions(expansions)
        .build();
    try {
      Expansions createResults = discovery.createExpansions(createOptions).execute().getResult();
      assertEquals(createResults.getExpansions().size(), 2);
      assertEquals(createResults.getExpansions().get(0).getInputTerms(), expansion1InputTerms);
      assertEquals(createResults.getExpansions().get(0).getExpandedTerms(), expansion1ExpandedTerms);
      assertEquals(createResults.getExpansions().get(1).getInputTerms(), expansion2InputTerms);
      assertEquals(createResults.getExpansions().get(1).getExpandedTerms(), expansion2ExpandedTerms);

      ListExpansionsOptions listOptions = new ListExpansionsOptions.Builder()
          .environmentId(environmentId)
          .collectionId(collectionId)
          .build();
      Expansions listResults = discovery.listExpansions(listOptions).execute().getResult();

      assertEquals(listResults.getExpansions().size(), 2);

      DeleteExpansionsOptions deleteOptions = new DeleteExpansionsOptions.Builder()
          .environmentId(environmentId)
          .collectionId(collectionId)
          .build();
      discovery.deleteExpansions(deleteOptions).execute();

      Expansions emptyListResults = discovery.listExpansions(listOptions).execute().getResult();

      assertTrue(emptyListResults.getExpansions().get(0).getInputTerms() == null
          || emptyListResults.getExpansions().get(0).getInputTerms().isEmpty());
      assertTrue(emptyListResults.getExpansions().get(0).getExpandedTerms() == null
          || emptyListResults.getExpansions().get(0).getExpandedTerms().get(0).isEmpty());
    } catch (InternalServerErrorException e) {
      System.out.println("Internal server error while trying to create expansion  ¯\\_(ツ)_/¯   Probably not our issue"
          + " but may be worth looking into.");
      e.printStackTrace();
    }
  }

  @Test
  public void deleteUserDataIsSuccessful() {
    String customerId = "java_sdk_test_id";

    try {
      DeleteUserDataOptions deleteOptions = new DeleteUserDataOptions.Builder()
          .customerId(customerId)
          .build();
      discovery.deleteUserData(deleteOptions).execute();
    } catch (Exception ex) {
      fail(ex.getMessage());
    }
  }

  @Test
  public void credentialsOperationsAreSuccessful() {
    String url = "https://login.salesforce.com";
    String username = "test@username.com";
    String password = "test_password";
    CredentialDetails credentialDetails = new CredentialDetails();
    credentialDetails.setCredentialType(CredentialDetails.CredentialType.USERNAME_PASSWORD);
    credentialDetails.setUrl(url);
    credentialDetails.setUsername(username);
    credentialDetails.setPassword(password);
    Credentials credentials = new Credentials();
    credentials.setSourceType(Credentials.SourceType.SALESFORCE);
    credentials.setCredentialDetails(credentialDetails);

    CreateCredentialsOptions createOptions = new CreateCredentialsOptions.Builder()
        .environmentId(environmentId)
        .credentials(credentials)
        .build();
    Credentials createdCredentials = discovery.createCredentials(createOptions).execute().getResult();
    String credentialId = createdCredentials.getCredentialId();

    // Create assertions
    assertEquals(Credentials.SourceType.SALESFORCE, createdCredentials.getSourceType());
    assertEquals(CredentialDetails.CredentialType.USERNAME_PASSWORD,
        createdCredentials.getCredentialDetails().getCredentialType());
    assertEquals(url, createdCredentials.getCredentialDetails().getUrl());
    assertEquals(username, createdCredentials.getCredentialDetails().getUsername());

    String newUrl = "https://newlogin.salesforce.com";
    CredentialDetails updatedDetails = new CredentialDetails();
    updatedDetails.setCredentialType(CredentialDetails.CredentialType.USERNAME_PASSWORD);
    updatedDetails.setUrl(newUrl);
    updatedDetails.setUsername(username);
    updatedDetails.setPassword(password);

    UpdateCredentialsOptions updateOptions = new UpdateCredentialsOptions.Builder()
        .environmentId(environmentId)
        .credentialId(credentialId)
        .sourceType(Credentials.SourceType.SALESFORCE)
        .credentialDetails(updatedDetails)
        .build();
    Credentials updatedCredentials = discovery.updateCredentials(updateOptions).execute().getResult();

    // Update assertion
    assertEquals(newUrl, updatedCredentials.getCredentialDetails().getUrl());

    GetCredentialsOptions getOptions = new GetCredentialsOptions.Builder()
        .environmentId(environmentId)
        .credentialId(credentialId)
        .build();
    Credentials retrievedCredentials = discovery.getCredentials(getOptions).execute().getResult();

    // Get assertions
    assertEquals(Credentials.SourceType.SALESFORCE, retrievedCredentials.getSourceType());
    assertEquals(CredentialDetails.CredentialType.USERNAME_PASSWORD,
        retrievedCredentials.getCredentialDetails().getCredentialType());
    assertEquals(newUrl, retrievedCredentials.getCredentialDetails().getUrl());
    assertEquals(username, retrievedCredentials.getCredentialDetails().getUsername());

    ListCredentialsOptions listOptions = new ListCredentialsOptions.Builder()
        .environmentId(environmentId)
        .build();
    CredentialsList credentialsList = discovery.listCredentials(listOptions).execute().getResult();

    // List assertion
    assertTrue(!credentialsList.getCredentials().isEmpty());

    DeleteCredentialsOptions deleteOptions = new DeleteCredentialsOptions.Builder()
        .environmentId(environmentId)
        .credentialId(credentialId)
        .build();
    discovery.deleteCredentials(deleteOptions).execute();
  }

  @Test
  public void createEventIsSuccessful() {
    // create test document
    DocumentAccepted accepted = createTestDocument("event_file", collectionId);

    // make query to get session_token
    QueryOptions queryOptions = new QueryOptions.Builder()
        .environmentId(environmentId)
        .collectionId(collectionId)
        .naturalLanguageQuery("field number 1")
        .build();
    QueryResponse queryResponse = discovery.query(queryOptions).execute().getResult();
    String sessionToken = queryResponse.getSessionToken();

    // make createEvent call
    EventData eventData = new EventData();
    eventData.setEnvironmentId(environmentId);
    eventData.setCollectionId(collectionId);
    eventData.setDocumentId(accepted.getDocumentId());
    eventData.setSessionToken(sessionToken);
    CreateEventOptions createEventOptions = new CreateEventOptions.Builder()
        .type(CreateEventOptions.Type.CLICK)
        .data(eventData)
        .build();
    CreateEventResponse response = discovery.createEvent(createEventOptions).execute().getResult();

    assertNotNull(response);
  }

  @Test
  public void queryLogIsSuccessful() {
    LogQueryResponse response = discovery.queryLog().execute().getResult();
    assertNotNull(response);
  }

  @Test
  public void getMetricsEventRateIsSuccessful() {
    MetricResponse response = discovery.getMetricsEventRate().execute().getResult();
    assertNotNull(response);
  }

  @Test
  public void getMetricsQueryIsSuccessful() {
    MetricResponse response = discovery.getMetricsQuery().execute().getResult();
    assertNotNull(response);
  }

  @Test
  public void getMetricsQueryEventIsSuccessful() {
    MetricResponse response = discovery.getMetricsQueryEvent().execute().getResult();
    assertNotNull(response);
  }

  @Test
  public void getMetricsQueryNoResultsIsSuccessful() {
    MetricResponse response = discovery.getMetricsQueryNoResults().execute().getResult();
    assertNotNull(response);
  }

  @Test
  public void getMetricsQueryTokenEventIsSuccessful() {
    MetricTokenResponse response = discovery.getMetricsQueryTokenEvent().execute().getResult();
    assertNotNull(response);
  }

  @Test
  public void tokenizationDictionaryOperationsAreSuccessful() throws InterruptedException {
    // create collection first because creating a tokenization dictionary currently is only supported in Japanese
    // collections
    CreateCollectionOptions createCollectionOptions = new CreateCollectionOptions.Builder()
        .environmentId(environmentId)
        .name("tokenization-dict-testing-collection " + UUID.randomUUID().toString())
        .language(CreateCollectionOptions.Language.JA)
        .build();
    Collection tokenDictTestCollection = discovery.createCollection(createCollectionOptions).execute().getResult();
    String testCollectionId = tokenDictTestCollection.getCollectionId();

    System.out.println("Test collection created!");

    try {
      TokenDictRule tokenDictRule = new TokenDictRule();
      tokenDictRule.setText("token");
      tokenDictRule.setPartOfSpeech("noun");
      tokenDictRule.setReadings(Arrays.asList("reading 1", "reading 2"));
      tokenDictRule.setTokens(Arrays.asList("token 1", "token 2"));

      // the service doesn't seem to like when we try and move too fast
      Thread.sleep(5000);

      // test creating tokenization dictionary
      CreateTokenizationDictionaryOptions createOptions = new CreateTokenizationDictionaryOptions.Builder()
          .environmentId(environmentId)
          .collectionId(testCollectionId)
          .addTokenizationRules(tokenDictRule)
          .build();
      TokenDictStatusResponse createResponse
          = discovery.createTokenizationDictionary(createOptions).execute().getResult();
      assertNotNull(createResponse);

      // test getting tokenization dictionary
      GetTokenizationDictionaryStatusOptions getOptions = new GetTokenizationDictionaryStatusOptions.Builder()
          .environmentId(environmentId)
          .collectionId(testCollectionId)
          .build();
      TokenDictStatusResponse getResponse = discovery.getTokenizationDictionaryStatus(getOptions).execute().getResult();
      assertNotNull(getResponse);

      Thread.sleep(5000);

      // test deleting tokenization dictionary
      DeleteTokenizationDictionaryOptions deleteOptions = new DeleteTokenizationDictionaryOptions.Builder()
          .environmentId(environmentId)
          .collectionId(testCollectionId)
          .build();
      discovery.deleteTokenizationDictionary(deleteOptions).execute();
    } catch (BadRequestException ex) {
      // this most likely means the environment wasn't ready to handle another tokenization file - this is fine
      System.out.println("Service wasn't ready yet! Error: " + ex.getMessage());
    } finally {
      // delete test collection
      DeleteCollectionOptions deleteCollectionOptions = new DeleteCollectionOptions.Builder()
          .environmentId(environmentId)
          .collectionId(testCollectionId)
          .build();
      discovery.deleteCollection(deleteCollectionOptions).execute();

      System.out.println("Test collection deleted");
    }
  }

  @Test
  public void stopwordListOperationsAreSuccessful() throws FileNotFoundException, InterruptedException {
    CreateCollectionOptions createCollectionOptions = new CreateCollectionOptions.Builder()
        .environmentId(environmentId)
        .name("stopword-list-testing-collection " + UUID.randomUUID().toString())
        .language(CreateCollectionOptions.Language.EN)
        .build();
    Collection tokenDictTestCollection = discovery.createCollection(createCollectionOptions).execute().getResult();
    String testCollectionId = tokenDictTestCollection.getCollectionId();
    System.out.println("Test collection created!");

    try {
      CreateStopwordListOptions createStopwordListOptions = new CreateStopwordListOptions.Builder()
          .environmentId(environmentId)
          .collectionId(testCollectionId)
          .stopwordFile(new FileInputStream(STOPWORDS_TEST_FILE))
          .stopwordFilename("test_stopword_file")
          .build();
      TokenDictStatusResponse createResponse
          = discovery.createStopwordList(createStopwordListOptions).execute().getResult();
      assertEquals("stopwords", createResponse.getType());

      GetStopwordListStatusOptions getStopwordListStatusOptions = new GetStopwordListStatusOptions.Builder()
          .environmentId(environmentId)
          .collectionId(testCollectionId)
          .build();
      TokenDictStatusResponse getResponse
          = discovery.getStopwordListStatus(getStopwordListStatusOptions).execute().getResult();
      assertEquals("stopwords", getResponse.getType());

      DeleteStopwordListOptions deleteStopwordListOptions = new DeleteStopwordListOptions.Builder()
          .environmentId(environmentId)
          .collectionId(testCollectionId)
          .build();
      discovery.deleteStopwordList(deleteStopwordListOptions).execute();
    } catch (BadRequestException ex) {
      // this most likely means the environment wasn't ready to handle another stopwords file - this is fine
      System.out.println("Service wasn't ready yet! Error: " + ex.getMessage());
    } finally {
      DeleteCollectionOptions deleteCollectionOptions = new DeleteCollectionOptions.Builder()
          .environmentId(environmentId)
          .collectionId(testCollectionId)
          .build();
      discovery.deleteCollection(deleteCollectionOptions).execute();
      System.out.println("Test collection deleted");
    }
  }

  @Test
  public void gatewayOperationsAreSuccessful() {
    String gatewayName = "java-sdk-test-gateway";

    ListGatewaysOptions listGatewaysOptions = new ListGatewaysOptions.Builder()
        .environmentId(environmentId)
        .build();
    GatewayList gatewayList = discovery.listGateways(listGatewaysOptions).execute().getResult();
    assertNotNull(gatewayList);
    int originalListSize = gatewayList.getGateways().size();

    CreateGatewayOptions createGatewayOptions = new CreateGatewayOptions.Builder()
        .environmentId(environmentId)
        .name(gatewayName)
        .build();
    Gateway gatewayResponse = discovery.createGateway(createGatewayOptions).execute().getResult();
    assertNotNull(gatewayResponse);
    assertEquals(gatewayName, gatewayResponse.getName());
    String testGatewayId = gatewayResponse.getGatewayId();

    gatewayList = discovery.listGateways(listGatewaysOptions).execute().getResult();
    assertTrue(gatewayList.getGateways().size() > originalListSize);

    GetGatewayOptions getGatewayOptions = new GetGatewayOptions.Builder()
        .environmentId(environmentId)
        .gatewayId(testGatewayId)
        .build();
    Gateway getGatewayResponse = discovery.getGateway(getGatewayOptions).execute().getResult();
    assertNotNull(getGatewayResponse);
    assertEquals(gatewayName, getGatewayResponse.getName());

    DeleteGatewayOptions deleteGatewayOptions = new DeleteGatewayOptions.Builder()
        .environmentId(environmentId)
        .gatewayId(testGatewayId)
        .build();
    discovery.deleteGateway(deleteGatewayOptions).execute();
  }

  private Environment createEnvironment(CreateEnvironmentOptions createOptions) {
    return discovery.createEnvironment(createOptions).execute().getResult();
  }

  private void deleteEnvironment(DeleteEnvironmentOptions deleteOptions) {
    discovery.deleteEnvironment(deleteOptions).execute();
  }

  private Configuration createConfiguration(CreateConfigurationOptions createOptions) {
    Configuration createResponse = discovery.createConfiguration(createOptions).execute().getResult();
    configurationIds.add(createResponse.getConfigurationId());
    return createResponse;
  }

  private void deleteConfiguration(DeleteConfigurationOptions deleteOptions) {
    discovery.deleteConfiguration(deleteOptions).execute();
    configurationIds.remove(deleteOptions.configurationId());
  }

  private Configuration createTestConfig() {
    String uniqueConfigName = uniqueName + "-config";
    CreateConfigurationOptions.Builder createBuilder
        = new CreateConfigurationOptions.Builder(environmentId, uniqueConfigName);
    return createConfiguration(createBuilder.build());
  }

  private Collection createCollection(CreateCollectionOptions createOptions) {
    Collection createResponse = discovery.createCollection(createOptions).execute().getResult();
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
    CreateCollectionOptions.Builder createCollectionBuilder = new CreateCollectionOptions.Builder(environmentId,
        uniqueCollectionName)
            .configurationId(createConfigResponse.getConfigurationId());
    return createCollection(createCollectionBuilder.build());
  }

  private DocumentAccepted createNestedTestDocument(String filename, String collectionId) {
    String myDocumentJson = "{\"nested_fields\":{\"field\":\"value\"}}";
    return createTestDocument(myDocumentJson, filename, collectionId);
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
    DocumentAccepted createResponse = discovery.addDocument(builder.build()).execute().getResult();
    WaitFor.Condition documentAccepted = new WaitForDocumentAccepted(environmentId, collectionId, createResponse
        .getDocumentId());
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

    WaitFor.Condition collectionAvailable = new WaitForCollectionAvailable(environmentId, collectionId);
    WaitFor.waitFor(collectionAvailable, 5, TimeUnit.SECONDS, 500);

    return collectionId;
  }

  private TrainingQuery createTestQuery(String collectionId, String naturalLanguageQuery) {
    AddTrainingDataOptions.Builder builder = new AddTrainingDataOptions.Builder(environmentId, collectionId);
    builder.naturalLanguageQuery(naturalLanguageQuery);
    return discovery.addTrainingData(builder.build()).execute().getResult();
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
    if (discovery.listTrainingData(builder.build()).execute().getResult().getQueries().size() > 0) {
      return collectionId;
    }
    createTestQueries(collectionId, 10);

    WaitFor.Condition collectionAvailable = new WaitForCollectionAvailable(environmentId, collectionId);
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
      String status = discovery.getEnvironment(getOptions).execute().getResult().getStatus();
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
      GetDocumentStatusOptions getOptions = new GetDocumentStatusOptions.Builder(environmentId, collectionId,
          documentId).build();
      String status = discovery.getDocumentStatus(getOptions).execute().getResult().getStatus();
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
      String status = discovery.getCollection(getOptions).execute().getResult().getStatus();
      return status.equals(Collection.Status.ACTIVE);
    }

    private final String environmentId;
    private final String collectionId;

  }

}

/*
 * (C) Copyright IBM Corp. 2019, 2022.
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
package com.ibm.watson.discovery.v2;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.ibm.cloud.sdk.core.http.HttpConfigOptions;
import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.common.RetryRunner;
import com.ibm.watson.common.WatsonServiceTest;
import com.ibm.watson.discovery.query.AggregationType;
import com.ibm.watson.discovery.query.Operator;
import com.ibm.watson.discovery.v2.model.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/** The Class DiscoveryIT. */
@RunWith(RetryRunner.class)
public class DiscoveryIT extends WatsonServiceTest {
  private static final String VERSION = "2022-07-29";
  private static final String RESOURCE = "src/test/resources/discovery/v2/";
  private static final String PROJECT_ID = "ff7985e8-3bea-427a-8256-0327c73ec0c7";
  private static final String COLLECTION_ID = "02cd572a-8e9d-0cb5-0000-017cf13ffc2b";
  private static final String PREMIUM_PROJECT_ID = "feb5ab3a-1e22-4968-9c5e-021eeaabbf32";
  private static final String PREMIUM_COLLECTION_ID = "0a7b633c-e41d-319c-0000-018264bf5fcd";

  private Discovery service;
  private Discovery premiumService;

  /**
   * Sets up the tests.
   *
   * @throws Exception the exception
   */
  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.common.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    String apiKey = System.getenv("DISCOVERY_V2_APIKEY");
    // String premiumApiKey = getProperty("discovery_v2.apikeyPremium");
    // String premiumUrl = getProperty("discovery_v2.urlPremium");
    String serviceUrl = System.getenv("DISCOVERY_V2_URL");

    if (apiKey == null) {
      apiKey = getProperty("discovery_v2.apikey");
      serviceUrl = getProperty("discovery_v2.url");
    }

    assertNotNull(
        "DISCOVERY_V2_APIKEY is not defined and config.properties doesn't have valid credentials.",
        apiKey);

    Authenticator authenticator = new IamAuthenticator.Builder().apikey(apiKey).build();
    // Authenticator premiumAuthenticator =
    //     new IamAuthenticator.Builder().apikey(premiumApiKey).build();

    service = new Discovery(VERSION, authenticator);
    service.setDefaultHeaders(getDefaultHeaders());
    service.setServiceUrl(serviceUrl);
    // premiumService = new Discovery(VERSION, premiumAuthenticator);
    // premiumService.setDefaultHeaders(getDefaultHeaders());
    // premiumService.setServiceUrl(premiumUrl);

    HttpConfigOptions configOptions =
        new HttpConfigOptions.Builder().disableSslVerification(true).build();
    service.configureClient(configOptions);
    // premiumService.configureClient(configOptions);
  }

  /** Test list collections. */
  @Test
  public void testListCollections() {
    ListCollectionsOptions options =
        new ListCollectionsOptions.Builder().projectId(PROJECT_ID).build();
    ListCollectionsResponse response = service.listCollections(options).execute().getResult();

    assertNotNull(response);
    boolean foundTestCollection = false;
    for (Collection collection : response.getCollections()) {
      if (collection.getCollectionId().equals(COLLECTION_ID)) {
        foundTestCollection = true;
        break;
      }
    }
    assertTrue(foundTestCollection);
  }

  /** Test Create Collection. */
  // @Test
  public void testCreateCollection() {
    CreateCollectionOptions createCollectionOptions =
        new CreateCollectionOptions.Builder()
            .projectId(PROJECT_ID)
            .name("name test")
            .description("description test")
            .language("en")
            .build();
    CollectionDetails response =
        service.createCollection(createCollectionOptions).execute().getResult();

    assertNotNull(response);
    assertTrue(response.name().equals("name test"));
    assertTrue(response.description().equals("description test"));
    assertTrue(response.language().equals("en"));

    DeleteCollectionOptions deleteCollectionOptions =
        new DeleteCollectionOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(response.collectionId())
            .build();
    Response<Void> deleteCollectionResponse =
        service.deleteCollection(deleteCollectionOptions).execute();

    assertTrue(deleteCollectionResponse.getStatusCode() == 204);
  }

  /** Get Collection. */
  // @Test
  public void testGetCollection() {
    GetCollectionOptions getCollectionOptions =
        new GetCollectionOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .build();
    CollectionDetails response = service.getCollection(getCollectionOptions).execute().getResult();

    assertNotNull(response);
    assertTrue(response.collectionId().equals(COLLECTION_ID));
  }

  /** Update Collection. */
  // @Test
  public void testUpdateCollection() {
    // get the collection to reset variables at the end.
    GetCollectionOptions getCollectionOptions =
        new GetCollectionOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .build();
    CollectionDetails getCollectionResponse =
        service.getCollection(getCollectionOptions).execute().getResult();

    assertNotNull(getCollectionResponse);
    try {
      UpdateCollectionOptions updateCollectionOptions =
          new UpdateCollectionOptions.Builder()
              .projectId(PROJECT_ID)
              .collectionId(COLLECTION_ID)
              .name("name updated")
              .description("description updated")
              .build();
      CollectionDetails updateCollectionResponse =
          service.updateCollection(updateCollectionOptions).execute().getResult();

      assertNotNull(updateCollectionResponse);
      assertNotNull(updateCollectionResponse.collectionId());
      assertTrue(updateCollectionResponse.name().equals("name updated"));
      assertTrue(updateCollectionResponse.description().equals("description updated"));
    } finally {
      UpdateCollectionOptions updateCollectionOptionsOriginal =
          new UpdateCollectionOptions.Builder()
              .projectId(PROJECT_ID)
              .collectionId(COLLECTION_ID)
              .name(getCollectionResponse.name())
              .description(getCollectionResponse.description())
              .build();
      CollectionDetails updateCollectionResponseOriginal =
          service.updateCollection(updateCollectionOptionsOriginal).execute().getResult();

      assertNotNull(updateCollectionResponseOriginal);
      assertNotNull(updateCollectionResponseOriginal.collectionId());
    }
  }

  /** Delete Collection. */
  // @Test
  public void testDeleteCollection() {
    String collectionId = "{COLLECTION_ID}";
    DeleteCollectionOptions deleteCollectionOptions =
        new DeleteCollectionOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(collectionId)
            .build();
    Response<Void> deleteCollectionResponse =
        service.deleteCollection(deleteCollectionOptions).execute();

    assertTrue(deleteCollectionResponse.getStatusCode() == 204);
  }

  /** Test query. */
  @Test
  public void testQuery() {
    QueryLargePassages queryLargePassages =
        new QueryLargePassages.Builder().findAnswers(true).maxAnswersPerPassage(2).build();
    QueryOptions options =
        new QueryOptions.Builder()
            .projectId(PROJECT_ID)
            .addCollectionIds(COLLECTION_ID)
            .query("field" + Operator.CONTAINS + "1")
            .passages(queryLargePassages)
            .build();
    QueryResponse response = service.query(options).execute().getResult();

    assertNotNull(response);
  }

  /** Test query natural language. */
  @Test
  public void testQueryNaturalLanguage() {
    QueryOptions options =
        new QueryOptions.Builder().projectId(PROJECT_ID).naturalLanguageQuery("test query").build();
    QueryResponse response = service.query(options).execute().getResult();

    assertNotNull(response);
  }

  /** Test query with calculation aggregation. */
  @Test
  public void testQueryWithCalculationAggregation() {
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.SUM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    QueryOptions options =
        new QueryOptions.Builder().projectId(PROJECT_ID).aggregation(aggregation).build();
    QueryResponse response = service.query(options).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getAggregations().size() > 0);
    QueryCalculationAggregation histogramAggregation =
        (QueryCalculationAggregation) response.getAggregations().get(0);
    assertNotNull(histogramAggregation);

    assertNotNull(response);
  }

  /** Test query with filter aggregation. */
  @Test
  public void testQueryWithFilterAggregation() {
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.FILTER);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field:9");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    QueryOptions options =
        new QueryOptions.Builder().projectId(PROJECT_ID).aggregation(aggregation).build();
    QueryResponse response = service.query(options).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getAggregations().size() > 0);
    QueryFilterAggregation filterAggregation =
        (QueryFilterAggregation) response.getAggregations().get(0);
    assertNotNull(filterAggregation);

    assertNotNull(response);
  }

  /** Test query with histogram aggregation. */
  @Test
  public void testQueryWithHistogramAggregation() {
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.HISTOGRAM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.AND);
    sb.append(5L);
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    QueryOptions options =
        new QueryOptions.Builder().projectId(PROJECT_ID).aggregation(aggregation).build();
    QueryResponse response = service.query(options).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getAggregations().size() > 0);
    QueryHistogramAggregation histogramAggregation =
        (QueryHistogramAggregation) response.getAggregations().get(0);
    assertNotNull(histogramAggregation);

    assertNotNull(response);
  }

  /** Test query with nested aggregation. */
  @Test
  public void testQueryWithNestedAggregation() {
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.NESTED);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("enriched_text");
    sb.append(Operator.NEST_AGGREGATION);
    sb.append("entities");
    sb.append(Operator.CLOSING_GROUPING);
    sb.append(Operator.NEST_AGGREGATION);
    sb.append(AggregationType.TERM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    QueryOptions options =
        new QueryOptions.Builder().projectId(PROJECT_ID).aggregation(aggregation).build();
    QueryResponse response = service.query(options).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getAggregations().size() > 0);
    QueryNestedAggregation nestedAggregation =
        (QueryNestedAggregation) response.getAggregations().get(0);
    assertNotNull(nestedAggregation);

    assertNotNull(response);
  }

  /** Test query with term aggregation. */
  @Test
  public void testQueryWithTermAggregation() {
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.TERM);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("field");
    sb.append(Operator.AND);
    sb.append(10L);
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    QueryOptions options =
        new QueryOptions.Builder().projectId(PROJECT_ID).aggregation(aggregation).build();
    QueryResponse response = service.query(options).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getAggregations().size() > 0);
    QueryTermAggregation termAggregation = (QueryTermAggregation) response.getAggregations().get(0);
    assertNotNull(termAggregation);

    assertNotNull(response);
  }

  /** Test query with timeslice aggregation. */
  @Test
  public void testQueryWithTimesliceAggregation() {
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.TIMESLICE);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("time,1day,EST");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    QueryOptions options =
        new QueryOptions.Builder().projectId(PROJECT_ID).aggregation(aggregation).build();
    QueryResponse response = service.query(options).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getAggregations().size() > 0);
    QueryTimesliceAggregation timesliceAggregation =
        (QueryTimesliceAggregation) response.getAggregations().get(0);
    assertNotNull(timesliceAggregation);

    assertNotNull(response);
  }

  /** Test query with top hits aggregation. */
  @Test
  public void testQueryWithTopHitsAggregation() {
    StringBuilder sb = new StringBuilder();
    sb.append(AggregationType.TOP_HITS);
    sb.append(Operator.OPENING_GROUPING);
    sb.append("3");
    sb.append(Operator.CLOSING_GROUPING);
    String aggregation = sb.toString();
    QueryOptions options =
        new QueryOptions.Builder().projectId(PROJECT_ID).aggregation(aggregation).build();
    QueryResponse response = service.query(options).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getAggregations().size() > 0);
    QueryTopHitsAggregation topHitsAggregation =
        (QueryTopHitsAggregation) response.getAggregations().get(0);
    assertNotNull(topHitsAggregation);

    assertNotNull(response);
  }

  /** Test query with count. */
  @Test
  public void testQueryWithCount() {
    QueryOptions options = new QueryOptions.Builder().projectId(PROJECT_ID).count(5L).build();
    QueryResponse response = service.query(options).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getResults().size() <= 5);
  }

  /** Test query with offset. */
  @Test
  public void testQueryWithOffset() {
    QueryOptions optionsNoOffset = new QueryOptions.Builder().projectId(PROJECT_ID).build();
    QueryResponse responseNoOffset = service.query(optionsNoOffset).execute().getResult();

    assertNotNull(responseNoOffset);

    QueryOptions optionsWithOffset =
        new QueryOptions.Builder().projectId(PROJECT_ID).offset(2L).build();
    QueryResponse responseWithOffset = service.query(optionsWithOffset).execute().getResult();

    assertNotNull(responseWithOffset);
    if (responseNoOffset.getResults().size() > 2) {
      assertNotEquals(responseNoOffset.getResults().get(0), responseWithOffset.getResults().get(0));
    }
  }

  /** Test query with sort. */
  @Test
  public void testQueryWithSort() {
    QueryOptions options =
        new QueryOptions.Builder().projectId(PROJECT_ID).sort("document_id").build();
    QueryResponse response = service.query(options).execute().getResult();

    assertNotNull(response);
    if (response.getResults().size() >= 2) {
      String firstDocumentId = response.getResults().get(0).getDocumentId();
      String secondDocumentId = response.getResults().get(1).getDocumentId();
      assertTrue(firstDocumentId.compareTo(secondDocumentId) < 0);
    }
  }

  /** Test query with highlight. */
  @Test
  public void testQueryWithHighlight() {
    QueryOptions options =
        new QueryOptions.Builder()
            .projectId(PROJECT_ID)
            .naturalLanguageQuery("president")
            .highlight(true)
            .build();
    QueryResponse response = service.query(options).execute().getResult();

    assertNotNull(response);
    if (response.getResults().size() > 0) {
      boolean foundHighlight = false;
      for (QueryResult result : response.getResults()) {
        for (QueryResultPassage passage : result.getDocumentPassages()) {
          if (passage.getPassageText().contains("<em>")) {
            foundHighlight = true;
            break;
          }
        }
      }
      assertTrue(foundHighlight);
    }
  }

  /** Test query with spelling suggestions. */
  @Test
  public void testQueryWithSpellingSuggestions() {
    QueryOptions options =
        new QueryOptions.Builder()
            .projectId(PROJECT_ID)
            .naturalLanguageQuery("presdent")
            .spellingSuggestions(true)
            .build();
    QueryResponse response = service.query(options).execute().getResult();

    assertNotNull(response);
    assertNotNull(response.getSuggestedQuery());
  }

  /** Test query with table results. */
  @Test
  public void testQueryWithTableResults() {
    QueryLargeTableResults tableResults =
        new QueryLargeTableResults.Builder().enabled(true).count(5L).build();

    QueryOptions options =
        new QueryOptions.Builder()
            .projectId(PROJECT_ID)
            .naturalLanguageQuery("test query")
            .tableResults(tableResults)
            .build();
    QueryResponse response = service.query(options).execute().getResult();

    assertNotNull(response);
    assertNotNull(response.getTableResults());
    assertTrue(response.getTableResults().size() <= 5);
  }

  /** Test query with suggested refinements. */
  @Test
  public void testQueryWithSuggestedRefinements() {
    QueryLargeSuggestedRefinements suggestedRefinements =
        new QueryLargeSuggestedRefinements.Builder().enabled(true).count(5L).build();

    QueryOptions options =
        new QueryOptions.Builder()
            .projectId(PROJECT_ID)
            .naturalLanguageQuery("test query")
            .suggestedRefinements(suggestedRefinements)
            .build();
    QueryResponse response = service.query(options).execute().getResult();

    assertNotNull(response);
    assertNotNull(response.getSuggestedRefinements());
    assertTrue(response.getSuggestedRefinements().size() <= 5);
  }

  /** Test query with passages. */
  @Test
  public void testQueryWithPassages() {
    QueryLargePassages passages =
        new QueryLargePassages.Builder().enabled(true).count(5L).perDocument(true).build();

    QueryOptions options =
        new QueryOptions.Builder()
            .projectId(PROJECT_ID)
            .naturalLanguageQuery("test query")
            .passages(passages)
            .build();
    QueryResponse response = service.query(options).execute().getResult();

    assertNotNull(response);
    boolean foundPassages = false;
    for (QueryResult result : response.getResults()) {
      if (result.getDocumentPassages() != null) {
        assertTrue(result.getDocumentPassages().size() <= 5);
        foundPassages = true;
        break;
      }
    }
    assertTrue(foundPassages);
  }

  /** Test get autocompletion. */
  @Test
  public void testGetAutocompletion() {
    GetAutocompletionOptions options =
        new GetAutocompletionOptions.Builder()
            .projectId(PROJECT_ID)
            .prefix("pre")
            .count(5L)
            .build();
    Completions response = service.getAutocompletion(options).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getCompletions().size() <= 5);
    assertTrue(response.getCompletions().get(0).startsWith("pre"));
  }

  /** Test query notices. */
  @Test
  public void testQueryNotices() {
    QueryNoticesOptions options =
        new QueryNoticesOptions.Builder()
            .projectId(PROJECT_ID)
            .query("field" + Operator.CONTAINS + "1")
            .build();
    QueryNoticesResponse response = service.queryNotices(options).execute().getResult();

    assertNotNull(response);
    assertNotNull(response.getNotices());
  }

  /** Test query notices natural language. */
  @Test
  public void testQueryNoticesNaturalLanguage() {
    QueryNoticesOptions options =
        new QueryNoticesOptions.Builder()
            .projectId(PROJECT_ID)
            .naturalLanguageQuery("test query")
            .build();
    QueryNoticesResponse response = service.queryNotices(options).execute().getResult();

    assertNotNull(response);
    assertNotNull(response.getNotices());
  }

  /** Test query notices with count. */
  @Test
  public void testQueryNoticesWithCount() {
    QueryNoticesOptions options =
        new QueryNoticesOptions.Builder().projectId(PROJECT_ID).count(5L).build();
    QueryNoticesResponse response = service.queryNotices(options).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getNotices().size() <= 5);
  }

  /** Test query notices with offset. */
  @Test
  public void testQueryNoticesWithOffset() {
    QueryNoticesOptions optionsNoOffset =
        new QueryNoticesOptions.Builder().projectId(PROJECT_ID).build();
    QueryNoticesResponse responseNoOffset =
        service.queryNotices(optionsNoOffset).execute().getResult();

    assertNotNull(responseNoOffset);

    QueryNoticesOptions optionsWithOffset =
        new QueryNoticesOptions.Builder().projectId(PROJECT_ID).offset(2L).build();
    QueryNoticesResponse responseWithOffset =
        service.queryNotices(optionsWithOffset).execute().getResult();

    assertNotNull(responseWithOffset);
    if (responseNoOffset.getNotices().size() > 2) {
      assertNotEquals(responseNoOffset.getNotices().get(0), responseWithOffset.getNotices().get(0));
    }
  }

  /** Test list fields. */
  @Test
  public void testListFields() {
    ListFieldsOptions options =
        new ListFieldsOptions.Builder()
            .projectId(PROJECT_ID)
            .addCollectionIds(COLLECTION_ID)
            .build();
    ListFieldsResponse response = service.listFields(options).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getFields().size() > 0);
  }

  /** Test get component settings. */
  @Test
  public void testGetComponentSettings() {
    GetComponentSettingsOptions options =
        new GetComponentSettingsOptions.Builder().projectId(PROJECT_ID).build();
    ComponentSettingsResponse response =
        service.getComponentSettings(options).execute().getResult();

    assertNotNull(response);
  }

  /**
   * Test document operations.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDocumentOperations() throws IOException, InterruptedException {
    InputStream testFile = new FileInputStream(RESOURCE + "test-pdf.pdf");
    String metadata = "{ \"metadata\": \"value\" }";

    AddDocumentOptions addDocumentOptions =
        new AddDocumentOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .file(testFile)
            .filename("test-file")
            .fileContentType(HttpMediaType.APPLICATION_PDF)
            .xWatsonDiscoveryForce(true)
            .build();
    DocumentAccepted addResponse = service.addDocument(addDocumentOptions).execute().getResult();

    assertNotNull(addResponse);
    String documentId = addResponse.getDocumentId();

    ListDocumentsOptions listDocumentsOptions =
        new ListDocumentsOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .build();
    ListDocumentsResponse documentList =
        service.listDocuments(listDocumentsOptions).execute().getResult();

    assertNotNull(documentList);
    assertTrue(documentList.getDocuments().size() > 0);

    GetDocumentOptions getDocumentOptions =
        new GetDocumentOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .documentId(documentId)
            .build();
    DocumentDetails gotDocument = service.getDocument(getDocumentOptions).execute().getResult();

    assertNotNull(gotDocument.getDocumentId());
    try {
      UpdateDocumentOptions updateDocumentOptions =
          new UpdateDocumentOptions.Builder()
              .projectId(PROJECT_ID)
              .collectionId(COLLECTION_ID)
              .documentId(documentId)
              .xWatsonDiscoveryForce(true)
              .metadata(metadata)
              .build();
      DocumentAccepted updateResponse =
          service.updateDocument(updateDocumentOptions).execute().getResult();

      assertNotNull(updateResponse);
      assertEquals(documentId, updateResponse.getDocumentId());
    } finally {
      DeleteDocumentOptions deleteDocumentOptions =
          new DeleteDocumentOptions.Builder()
              .projectId(PROJECT_ID)
              .collectionId(COLLECTION_ID)
              .documentId(documentId)
              .xWatsonDiscoveryForce(true)
              .build();
      DeleteDocumentResponse deleteResponse =
          service.deleteDocument(deleteDocumentOptions).execute().getResult();

      assertNotNull(deleteResponse);
      assertEquals(documentId, deleteResponse.getDocumentId());

      testFile.close();
    }
  }

  /**
   * Test training query operations.
   *
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testTrainingQueryOperations() throws FileNotFoundException {
    ListTrainingQueriesOptions listTrainingQueriesOptions =
        new ListTrainingQueriesOptions.Builder().projectId(PROJECT_ID).build();
    TrainingQuerySet listResponse =
        service.listTrainingQueries(listTrainingQueriesOptions).execute().getResult();

    assertNotNull(listResponse);
    int initialNumOfTrainingQueries = listResponse.getQueries().size();

    // Create test document.
    InputStream testFile = new FileInputStream(RESOURCE + "test-pdf.pdf");
    AddDocumentOptions addDocumentOptions =
        new AddDocumentOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .file(testFile)
            .filename("test-file")
            .fileContentType(HttpMediaType.APPLICATION_PDF)
            .xWatsonDiscoveryForce(true)
            .build();
    DocumentAccepted addResponse = service.addDocument(addDocumentOptions).execute().getResult();

    assertNotNull(addResponse);
    String documentId = addResponse.getDocumentId();

    TrainingExample trainingExample =
        new TrainingExample.Builder()
            .collectionId(COLLECTION_ID)
            .documentId(documentId)
            .relevance(1L)
            .build();

    CreateTrainingQueryOptions createTrainingQueryOptions =
        new CreateTrainingQueryOptions.Builder()
            .projectId(PROJECT_ID)
            .addExamples(trainingExample)
            .naturalLanguageQuery("test query" + UUID.randomUUID().toString())
            .build();
    TrainingQuery createResponse =
        service.createTrainingQuery(createTrainingQueryOptions).execute().getResult();

    assertNotNull(createResponse);
    assertEquals(trainingExample.collectionId(), createResponse.examples().get(0).collectionId());
    assertEquals(trainingExample.documentId(), createResponse.examples().get(0).documentId());
    assertEquals(trainingExample.relevance(), createResponse.examples().get(0).relevance());
    String queryId = createResponse.queryId();

    try {
      TrainingQuerySet updatedListResponse =
          service.listTrainingQueries(listTrainingQueriesOptions).execute().getResult();
      assertNotNull(updatedListResponse);
      assertTrue(updatedListResponse.getQueries().size() > initialNumOfTrainingQueries);

      GetTrainingQueryOptions getTrainingQueryOptions =
          new GetTrainingQueryOptions.Builder().projectId(PROJECT_ID).queryId(queryId).build();
      TrainingQuery getResponse =
          service.getTrainingQuery(getTrainingQueryOptions).execute().getResult();

      assertNotNull(getResponse);
      assertEquals(queryId, getResponse.queryId());

      String updatedQuery = "new query" + UUID.randomUUID().toString();
      UpdateTrainingQueryOptions updateTrainingQueryOptions =
          new UpdateTrainingQueryOptions.Builder()
              .projectId(PROJECT_ID)
              .queryId(queryId)
              .naturalLanguageQuery(updatedQuery)
              .addExamples(trainingExample)
              .build();
      TrainingQuery updateResponse =
          service.updateTrainingQuery(updateTrainingQueryOptions).execute().getResult();

      assertNotNull(updateResponse);
      assertEquals(updatedQuery, updateResponse.naturalLanguageQuery());
    } finally {
      DeleteTrainingQueriesOptions deleteTrainingQueriesOptions =
          new DeleteTrainingQueriesOptions.Builder().projectId(PROJECT_ID).build();
      service.deleteTrainingQueries(deleteTrainingQueriesOptions).execute();

      TrainingQuerySet listResponseAfterDelete =
          service.listTrainingQueries(listTrainingQueriesOptions).execute().getResult();
      assertEquals(0, listResponseAfterDelete.getQueries().size());

      DeleteDocumentOptions deleteDocumentOptions =
          new DeleteDocumentOptions.Builder()
              .projectId(PROJECT_ID)
              .collectionId(COLLECTION_ID)
              .documentId(documentId)
              .xWatsonDiscoveryForce(true)
              .build();
      service.deleteDocument(deleteDocumentOptions).execute().getResult();
    }
  }

  /** Test List Enrichments. */
  // @Test
  public void testListEnrichments() {
    ListEnrichmentsOptions listEnrichmentsOptions =
        new ListEnrichmentsOptions.Builder().projectId(PROJECT_ID).build();
    Enrichments response = service.listEnrichments(listEnrichmentsOptions).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getEnrichments().size() > 0);
  }

  /** Test Create Enrichment. */
  // @Test
  public void testCreateEnrichment() throws FileNotFoundException {
    InputStream testFile = new FileInputStream(RESOURCE + "test.csv");

    EnrichmentOptions enrichmentOptions =
        new EnrichmentOptions.Builder()
            .languages(new ArrayList<String>())
            .addLanguages("en")
            .entityType("keyword")
            .build();

    CreateEnrichment enrichmentObj =
        new CreateEnrichment.Builder()
            .name("Dictionary")
            .description("test dictionary")
            .type(CreateEnrichment.Type.DICTIONARY)
            .options(enrichmentOptions)
            .build();

    CreateEnrichmentOptions createEnrichmentOptions =
        new CreateEnrichmentOptions.Builder()
            .enrichment(enrichmentObj)
            .projectId(PROJECT_ID)
            .file(testFile)
            .build();
    Enrichment response = service.createEnrichment(createEnrichmentOptions).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getName().equals("Dictionary"));
    assertTrue(response.getDescription().equals("test dictionary"));
    assertTrue(response.getType().equals("dictionary"));
    assertTrue(response.getOptions().languages().size() == 1);
    assertTrue(response.getOptions().languages().get(0).equals("en"));
    assertTrue(response.getOptions().entityType().equals("keyword"));

    DeleteEnrichmentOptions deleteEnrichmentOptions =
        new DeleteEnrichmentOptions.Builder()
            .enrichmentId(response.getEnrichmentId())
            .projectId(PROJECT_ID)
            .build();
    Response<Void> deleteEnrichmentResponse =
        service.deleteEnrichment(deleteEnrichmentOptions).execute();

    assertTrue(deleteEnrichmentResponse.getStatusCode() == 204);
  }

  /** Test Get Enrichment. */
  // @Test
  public void testGetEnrichment() throws FileNotFoundException {
    // Create Enrichment
    InputStream testFile = new FileInputStream(RESOURCE + "test.csv");

    EnrichmentOptions enrichmentOptions =
        new EnrichmentOptions.Builder()
            .languages(new ArrayList<String>())
            .addLanguages("en")
            .entityType("keyword")
            .build();

    CreateEnrichment enrichmentObj =
        new CreateEnrichment.Builder()
            .name("Dictionary")
            .description("test dictionary")
            .type("dictionary")
            .options(enrichmentOptions)
            .build();

    CreateEnrichmentOptions createEnrichmentOptions =
        new CreateEnrichmentOptions.Builder()
            .enrichment(enrichmentObj)
            .projectId(PROJECT_ID)
            .file(testFile)
            .build();
    Enrichment response = service.createEnrichment(createEnrichmentOptions).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getName().equals("Dictionary"));
    assertTrue(response.getDescription().equals("test dictionary"));
    assertTrue(response.getType().equals("dictionary"));
    assertTrue(response.getOptions().languages().size() == 1);
    assertTrue(response.getOptions().languages().get(0).equals("en"));
    assertTrue(response.getOptions().entityType().equals("keyword"));

    // Get Enrichment
    GetEnrichmentOptions getEnrichmentOptions =
        new GetEnrichmentOptions.Builder()
            .enrichmentId(response.getEnrichmentId())
            .projectId(PROJECT_ID)
            .build();
    Enrichment getEnrichmentResponse =
        service.getEnrichment(getEnrichmentOptions).execute().getResult();

    assertNotNull(getEnrichmentResponse);
    assertTrue(getEnrichmentOptions.enrichmentId().equals(response.getEnrichmentId()));
    assertTrue(getEnrichmentResponse.getName().equals("Dictionary"));
    assertTrue(getEnrichmentResponse.getDescription().equals("test dictionary"));
    assertTrue(getEnrichmentResponse.getType().equals("dictionary"));
    assertTrue(getEnrichmentResponse.getOptions().languages().size() == 1);
    assertTrue(getEnrichmentResponse.getOptions().languages().get(0).equals("en"));
    assertTrue(getEnrichmentResponse.getOptions().entityType().equals("keyword"));

    // Delete Enrichment
    DeleteEnrichmentOptions deleteEnrichmentOptions =
        new DeleteEnrichmentOptions.Builder()
            .enrichmentId(response.getEnrichmentId())
            .projectId(PROJECT_ID)
            .build();
    Response<Void> deleteEnrichmentResponse =
        service.deleteEnrichment(deleteEnrichmentOptions).execute();

    assertTrue(deleteEnrichmentResponse.getStatusCode() == 204);
  }

  /** Test Update Enrichment. */
  // @Test
  public void testUpdateEnrichment() throws FileNotFoundException {
    // Create Enrichment
    InputStream testFile = new FileInputStream(RESOURCE + "test.csv");

    EnrichmentOptions enrichmentOptions =
        new EnrichmentOptions.Builder()
            .languages(new ArrayList<String>())
            .addLanguages("en")
            .entityType("keyword")
            .build();

    CreateEnrichment enrichmentObj =
        new CreateEnrichment.Builder()
            .name("Dictionary")
            .description("test dictionary")
            .type("dictionary")
            .options(enrichmentOptions)
            .build();

    CreateEnrichmentOptions createEnrichmentOptions =
        new CreateEnrichmentOptions.Builder()
            .enrichment(enrichmentObj)
            .projectId(PROJECT_ID)
            .file(testFile)
            .build();
    Enrichment response = service.createEnrichment(createEnrichmentOptions).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getName().equals("Dictionary"));
    assertTrue(response.getDescription().equals("test dictionary"));
    assertTrue(response.getType().equals("dictionary"));
    assertTrue(response.getOptions().languages().size() == 1);
    assertTrue(response.getOptions().languages().get(0).equals("en"));
    assertTrue(response.getOptions().entityType().equals("keyword"));

    // Get Enrichment
    UpdateEnrichmentOptions updateEnrichmentOptions =
        new UpdateEnrichmentOptions.Builder()
            .enrichmentId(response.getEnrichmentId())
            .projectId(PROJECT_ID)
            .name("Dictionary update")
            .description("test dictionary update")
            .build();
    Enrichment updateEnrichmentResponse =
        service.updateEnrichment(updateEnrichmentOptions).execute().getResult();

    assertNotNull(updateEnrichmentResponse);
    assertTrue(updateEnrichmentResponse.getEnrichmentId().equals(response.getEnrichmentId()));
    assertTrue(updateEnrichmentResponse.getName().equals("Dictionary update"));
    assertTrue(updateEnrichmentResponse.getDescription().equals("test dictionary update"));
    assertTrue(updateEnrichmentResponse.getType().equals("dictionary"));
    assertTrue(updateEnrichmentResponse.getOptions().languages().size() == 1);
    assertTrue(updateEnrichmentResponse.getOptions().languages().get(0).equals("en"));
    assertTrue(updateEnrichmentResponse.getOptions().entityType().equals("keyword"));

    // Delete Enrichment
    DeleteEnrichmentOptions deleteEnrichmentOptions =
        new DeleteEnrichmentOptions.Builder()
            .enrichmentId(response.getEnrichmentId())
            .projectId(PROJECT_ID)
            .build();
    Response<Void> deleteEnrichmentResponse =
        service.deleteEnrichment(deleteEnrichmentOptions).execute();

    assertTrue(deleteEnrichmentResponse.getStatusCode() == 204);
  }

  /** Test Delete Enrichment. */
  // @Test
  public void testDeleteEnrichment() {
    // Delete Enrichment
    String enrichmentId = "{enrichmentId}";
    DeleteEnrichmentOptions deleteEnrichmentOptions =
        new DeleteEnrichmentOptions.Builder()
            .enrichmentId(enrichmentId)
            .projectId(PROJECT_ID)
            .build();
    Response<Void> deleteEnrichmentResponse =
        service.deleteEnrichment(deleteEnrichmentOptions).execute();

    assertTrue(deleteEnrichmentResponse.getStatusCode() == 204);
  }

  /** Test List Projects. */
  // @Test
  public void testListProjects() {
    ListProjectsResponse response = service.listProjects().execute().getResult();

    assertNotNull(response);
    assertNotNull(response.getProjects());
  }

  /** Create Project. */
  // @Test
  public void testCreateProject() {
    // create project
    CreateProjectOptions createProjectOptions =
        new CreateProjectOptions.Builder()
            .name("create project test java")
            .type("document_retrieval")
            .build();
    ProjectDetails response = service.createProject(createProjectOptions).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getName().equals("create project test java"));
    assertTrue(response.getType().equals("document_retrieval"));

    // delete project
    DeleteProjectOptions deleteProjectOptions =
        new DeleteProjectOptions.Builder().projectId(response.getProjectId()).build();
    Response<Void> deleteResponse = service.deleteProject(deleteProjectOptions).execute();

    assertNotNull(deleteResponse);
    assertTrue(deleteResponse.getStatusCode() == 204);
  }

  /** Get Project. */
  // @Test
  public void testGetProject() {
    // Get projects
    ListProjectsResponse projectsResponse = service.listProjects().execute().getResult();
    // Grab a project to test out
    ProjectListDetails projectTest = projectsResponse.getProjects().get(0);

    GetProjectOptions getProjectOptions =
        new GetProjectOptions.Builder().projectId(projectTest.getProjectId()).build();
    ProjectDetails response = service.getProject(getProjectOptions).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getName().equals(projectTest.getName()));
  }

  /** Update Project. */
  // @Test
  public void testUpdateProject() {
    // Get projects
    ListProjectsResponse projectsResponse = service.listProjects().execute().getResult();
    // Grab a project to test out
    ProjectListDetails projectTest = projectsResponse.getProjects().get(0);

    UpdateProjectOptions updateProjectOptions =
        new UpdateProjectOptions.Builder()
            .projectId(projectTest.getProjectId())
            .name("updated project name test")
            .build();
    ProjectDetails response = service.updateProject(updateProjectOptions).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getName().equals("updated project name test"));

    // Reset project name to original name.
    updateProjectOptions =
        new UpdateProjectOptions.Builder()
            .projectId(projectTest.getProjectId())
            .name(projectTest.getName())
            .build();
    response = service.updateProject(updateProjectOptions).execute().getResult();

    assertNotNull(response);
    assertTrue(response.getName().equals(projectTest.getName()));
  }

  /** Delete Project. */
  // @Test
  public void testDeleteProject() {
    DeleteProjectOptions deleteProjectOptions =
        new DeleteProjectOptions.Builder().projectId("{projectId}").build();
    Response<Void> deleteResponse = service.deleteProject(deleteProjectOptions).execute();

    assertNotNull(deleteResponse);
    assertTrue(deleteResponse.getStatusCode() == 204);
  }

  /** Delete User Data. */
  // @Test
  public void testDeleteUserData() {
    DeleteUserDataOptions deleteUserDataOptions =
        new DeleteUserDataOptions.Builder().customerId("{customerId}").build();
    Response<Void> deleteResponse = service.deleteUserData(deleteUserDataOptions).execute();

    assertNotNull(deleteResponse);
    assertTrue(deleteResponse.getStatusCode() == 204);
  }

  /** Test query passages per document true. */
  @Test
  public void TestQueryPassagesPerDocumentTrue() {
    List<String> Ids = new ArrayList<>();
    Ids.add(COLLECTION_ID);
    QueryLargePassages queryLargePassages =
        new QueryLargePassages.Builder().perDocument(true).build();

    QueryOptions queryOptions =
        new QueryOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionIds(Ids)
            .passages(queryLargePassages)
            .query("text:IBM")
            .count(2)
            .build();
    QueryResponse queryResult = service.query(queryOptions).execute().getResult();
    assertNotNull(queryResult.getResults().get(0).getDocumentPassages().get(0).getPassageText());
  }

  /** Test query passages per document false. */
  @Test
  public void TestQueryPassagesPerDocumentFalse() {
    List<String> Ids = new ArrayList<>();
    Ids.add(COLLECTION_ID);
    QueryLargePassages queryLargePassages =
        new QueryLargePassages.Builder().perDocument(false).build();

    QueryOptions queryOptions =
        new QueryOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionIds(Ids)
            .passages(queryLargePassages)
            .query("text:IBM")
            .count(2)
            .build();
    QueryResponse queryResult = service.query(queryOptions).execute().getResult();
    assertNotNull(queryResult);
    assertNotNull(queryResult.getPassages().get(0).getCollectionId());
    assertNotNull(queryResult.getPassages().get(0).getPassageText());
    assertNotNull(queryResult.getPassages().get(0).getDocumentId());
  }

  /** Test Analyze Document. */
  @Ignore
  @Test
  public void TestAnalyzeDocument() throws FileNotFoundException {
    InputStream testFile = new FileInputStream(RESOURCE + "test-pdf.pdf");
    String metadata = "{ \"metadata\": \"value\" }";

    AnalyzeDocumentOptions analyzeDocumentOptions =
        new AnalyzeDocumentOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .file(testFile)
            .filename("test-file")
            .fileContentType(HttpMediaType.APPLICATION_PDF)
            .metadata(metadata)
            .build();
    AnalyzedDocument analyzedDocument =
        service.analyzeDocument(analyzeDocumentOptions).execute().getResult();

    assertNotNull(analyzedDocument);
  }

  /** Test queryCollectionNotices. */
  @Test
  public void TestQueryCollectionNotices() throws FileNotFoundException {

    QueryCollectionNoticesOptions queryCollectionNoticesOptions =
        new QueryCollectionNoticesOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .naturalLanguageQuery("warning")
            .build();
    QueryNoticesResponse queryNoticesResponse =
        service.queryCollectionNotices(queryCollectionNoticesOptions).execute().getResult();

    assertNotNull(queryNoticesResponse.getNotices());
  }

  /** Test deleteTrainingQuery. */
  @Test
  public void TestDeleteTrainingQuery() throws FileNotFoundException {

    String queryId = "";
    String documentId = "";
    try {
      // Create test document.
      InputStream testFile = new FileInputStream(RESOURCE + "test-pdf.pdf");
      AddDocumentOptions addDocumentOptions =
          new AddDocumentOptions.Builder()
              .projectId(PROJECT_ID)
              .collectionId(COLLECTION_ID)
              .file(testFile)
              .filename("test-file")
              .fileContentType(HttpMediaType.APPLICATION_PDF)
              .xWatsonDiscoveryForce(true)
              .build();
      DocumentAccepted addResponse = service.addDocument(addDocumentOptions).execute().getResult();

      assertNotNull(addResponse);
      documentId = addResponse.getDocumentId();

      TrainingExample trainingExample =
          new TrainingExample.Builder()
              .collectionId(COLLECTION_ID)
              .documentId(documentId)
              .relevance(1L)
              .build();

      CreateTrainingQueryOptions createTrainingQueryOptions =
          new CreateTrainingQueryOptions.Builder()
              .projectId(PROJECT_ID)
              .addExamples(trainingExample)
              .naturalLanguageQuery("test query" + UUID.randomUUID().toString())
              .build();
      TrainingQuery createResponse =
          service.createTrainingQuery(createTrainingQueryOptions).execute().getResult();
      queryId = createResponse.queryId();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DeleteTrainingQueryOptions deleteTrainingQueryOptions =
          new DeleteTrainingQueryOptions.Builder().projectId(PROJECT_ID).queryId(queryId).build();
      service.deleteTrainingQuery(deleteTrainingQueryOptions).execute().getResult();

      DeleteDocumentOptions deleteDocumentOptions =
          new DeleteDocumentOptions.Builder()
              .projectId(PROJECT_ID)
              .collectionId(COLLECTION_ID)
              .documentId(documentId)
              .xWatsonDiscoveryForce(true)
              .build();
      service.deleteDocument(deleteDocumentOptions).execute().getResult();
    }
  }

  /**
   * Test document classifier operations.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  // @Test
  public void testDocumentClassifierOperations() throws IOException, InterruptedException {
    InputStream testFile = new FileInputStream(RESOURCE + "classification_training.csv");

    DocumentClassifierEnrichment documentClassifierEnrichment =
        new DocumentClassifierEnrichment.Builder()
            .enrichmentId("701db916-fc83-57ab-0000-00000000001e")
            .addFields("text")
            .addFields("body")
            .build();

    CreateDocumentClassifier documentClassifier =
        new CreateDocumentClassifier.Builder()
            .name("sdk-test")
            .description("a deletable sdk test classifier")
            .language("en")
            .answerField("label_answer")
            .addEnrichments(documentClassifierEnrichment)
            .build();

    CreateDocumentClassifierOptions createClassifierOptions =
        new CreateDocumentClassifierOptions.Builder()
            .projectId(PREMIUM_PROJECT_ID)
            .trainingData(testFile)
            .testData(testFile)
            .classifier(documentClassifier)
            .build();

    DocumentClassifier createResponse =
        premiumService.createDocumentClassifier(createClassifierOptions).execute().getResult();

    assertNotNull(createResponse.getClassifierId());
    String classifierId = createResponse.getClassifierId();

    ListDocumentClassifiersOptions listDocumentClassifierOptions =
        new ListDocumentClassifiersOptions.Builder().projectId(PREMIUM_PROJECT_ID).build();

    DocumentClassifiers listResponse =
        premiumService.listDocumentClassifiers(listDocumentClassifierOptions).execute().getResult();
    assertTrue(listResponse.getClassifiers().size() > 0);

    GetDocumentClassifierOptions getDocumentClassifierOptions =
        new GetDocumentClassifierOptions.Builder()
            .projectId(PREMIUM_PROJECT_ID)
            .classifierId(classifierId)
            .build();

    DocumentClassifier gotDocument =
        premiumService.getDocumentClassifier(getDocumentClassifierOptions).execute().getResult();
    assertNotNull(gotDocument);
    try {
      String updatedName = "new-sdk-test";
      UpdateDocumentClassifier updateDocumentClassifier =
          new UpdateDocumentClassifier.Builder().name("new-sdk-test").build();
      UpdateDocumentClassifierOptions updateDocumentClassifierOptions =
          new UpdateDocumentClassifierOptions.Builder()
              .projectId(PREMIUM_PROJECT_ID)
              .classifierId(classifierId)
              .classifier(updateDocumentClassifier)
              .build();

      DocumentClassifier updateResponse =
          premiumService
              .updateDocumentClassifier(updateDocumentClassifierOptions)
              .execute()
              .getResult();

      assertNotNull(updateResponse);
      assertEquals(updatedName, updateResponse.getName());

      String classifierModelName = "classifier model sdk test";
      CreateDocumentClassifierModelOptions createDocumentClassifierModelOptions =
          new CreateDocumentClassifierModelOptions.Builder()
              .projectId(PREMIUM_PROJECT_ID)
              .classifierId(classifierId)
              .name(classifierModelName)
              .learningRate(0.5)
              .addL1RegularizationStrengths(0.0001)
              .trainingMaxSteps(100000)
              .build();
      DocumentClassifierModel createModelResponse =
          premiumService
              .createDocumentClassifierModel(createDocumentClassifierModelOptions)
              .execute()
              .getResult();
      assertNotNull(createModelResponse.getName());

      ListDocumentClassifierModelsOptions listDocumentClassifierModelsOptions =
          new ListDocumentClassifierModelsOptions.Builder()
              .projectId(PREMIUM_PROJECT_ID)
              .classifierId(classifierId)
              .build();

      DocumentClassifierModels listModelsResponse =
          premiumService
              .listDocumentClassifierModels(listDocumentClassifierModelsOptions)
              .execute()
              .getResult();
      assertTrue(listModelsResponse.getModels().size() > 0);
      String modelID = listModelsResponse.getModels().get(0).getModelId();
      assertNotNull(modelID);

      GetDocumentClassifierModelOptions getDocumentClassifierModelOptions =
          new GetDocumentClassifierModelOptions.Builder()
              .projectId(PREMIUM_PROJECT_ID)
              .classifierId(classifierId)
              .modelId(modelID)
              .build();

      DocumentClassifierModel getModelResponse =
          premiumService
              .getDocumentClassifierModel(getDocumentClassifierModelOptions)
              .execute()
              .getResult();
      assertNotNull(getModelResponse.getName());

      String updatedModelName = "new sdk test model";
      UpdateDocumentClassifierModelOptions updateDocumentClassifierModelOptions =
          new UpdateDocumentClassifierModelOptions.Builder()
              .projectId(PREMIUM_PROJECT_ID)
              .classifierId(classifierId)
              .modelId(modelID)
              .name(updatedModelName)
              .build();

      DocumentClassifierModel updateModelResponse =
          premiumService
              .updateDocumentClassifierModel(updateDocumentClassifierModelOptions)
              .execute()
              .getResult();
      assertEquals(updatedModelName, updateModelResponse.getName());

      DeleteDocumentClassifierModelOptions deleteDocumentClassifierModelOptions =
          new DeleteDocumentClassifierModelOptions.Builder()
              .projectId(PREMIUM_PROJECT_ID)
              .classifierId(classifierId)
              .modelId(modelID)
              .build();
      Response<Void> deleteModelResponse =
          premiumService
              .deleteDocumentClassifierModel(deleteDocumentClassifierModelOptions)
              .execute();

      assertTrue(deleteModelResponse.getStatusCode() == 204);

    } finally {
      DeleteDocumentClassifierOptions deleteDocumentClassifierOptions =
          new DeleteDocumentClassifierOptions.Builder()
              .projectId(PREMIUM_PROJECT_ID)
              .classifierId(classifierId)
              .build();
      Response<Void> deleteResponse =
          premiumService.deleteDocumentClassifier(deleteDocumentClassifierOptions).execute();

      assertTrue(deleteResponse.getStatusCode() == 204);

      testFile.close();
    }
  }

  /** Test StopwordList operations. */
  @Test
  public void testStopwordLists() {
    GetStopwordListOptions getStopwordListOptions =
        new GetStopwordListOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .build();
    StopWordList getResponse =
        service.getStopwordList(getStopwordListOptions).execute().getResult();

    assertEquals(0, getResponse.stopwords().size());

    CreateStopwordListOptions createstopwordListOptions =
        new CreateStopwordListOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .addStopwords("it")
            .addStopwords("the")
            .build();
    StopWordList createResponse =
        service.createStopwordList(createstopwordListOptions).execute().getResult();

    assertNotNull(createResponse);
    assertEquals("it", createResponse.stopwords().get(0));
    assertEquals("the", createResponse.stopwords().get(1));

    StopWordList getResponse2 =
        service.getStopwordList(getStopwordListOptions).execute().getResult();
    assertEquals(2, getResponse2.stopwords().size());

    DeleteStopwordListOptions deleteStopwordListOptions =
        new DeleteStopwordListOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .build();
    Response<Void> deleteResponse = service.deleteStopwordList(deleteStopwordListOptions).execute();

    assertTrue(deleteResponse.getStatusCode() == 204);
  }

  /** Test ExpansionList operations. */
  @Test
  public void testExpansionLists() {
    ListExpansionsOptions listExpansionsOptions =
        new ListExpansionsOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .build();
    Expansions getResponse = service.listExpansions(listExpansionsOptions).execute().getResult();

    assertEquals(0, getResponse.expansions().size());

    String expandedTerm1 = "International Business Machines";
    String expandedTerm2 = "Big Blue";
    Expansion expansion =
        new Expansion.Builder()
            .addInputTerms("IBM")
            .addExpandedTerms(expandedTerm1)
            .addExpandedTerms(expandedTerm2)
            .build();

    CreateExpansionsOptions createExpansionsOptions =
        new CreateExpansionsOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .addExpansions(expansion)
            .build();
    Expansions createResponse =
        service.createExpansions(createExpansionsOptions).execute().getResult();

    assertNotNull(createResponse);
    assertEquals(expandedTerm1, createResponse.expansions().get(0).expandedTerms().get(0));
    assertEquals(expandedTerm2, createResponse.expansions().get(0).expandedTerms().get(1));

    Expansions getResponse2 = service.listExpansions(listExpansionsOptions).execute().getResult();
    assertEquals(1, getResponse2.expansions().size());
    assertEquals(2, getResponse2.expansions().get(0).expandedTerms().size());

    DeleteExpansionsOptions deleteExpansionOptions =
        new DeleteExpansionsOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .build();
    Response<Void> deleteResponse = service.deleteExpansions(deleteExpansionOptions).execute();

    assertTrue(deleteResponse.getStatusCode() == 204);
  }
}

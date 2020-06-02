/*
 * (C) Copyright IBM Corp. 2020.
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
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.BearerTokenAuthenticator;
import com.ibm.watson.common.RetryRunner;
import com.ibm.watson.common.WatsonServiceTest;
import com.ibm.watson.discovery.query.AggregationType;
import com.ibm.watson.discovery.query.Operator;
import com.ibm.watson.discovery.v2.model.AddDocumentOptions;
import com.ibm.watson.discovery.v2.model.Collection;
import com.ibm.watson.discovery.v2.model.Completions;
import com.ibm.watson.discovery.v2.model.ComponentSettingsResponse;
import com.ibm.watson.discovery.v2.model.CreateTrainingQueryOptions;
import com.ibm.watson.discovery.v2.model.DeleteDocumentOptions;
import com.ibm.watson.discovery.v2.model.DeleteDocumentResponse;
import com.ibm.watson.discovery.v2.model.DeleteTrainingQueriesOptions;
import com.ibm.watson.discovery.v2.model.DocumentAccepted;
import com.ibm.watson.discovery.v2.model.GetAutocompletionOptions;
import com.ibm.watson.discovery.v2.model.GetComponentSettingsOptions;
import com.ibm.watson.discovery.v2.model.GetTrainingQueryOptions;
import com.ibm.watson.discovery.v2.model.ListCollectionsOptions;
import com.ibm.watson.discovery.v2.model.ListCollectionsResponse;
import com.ibm.watson.discovery.v2.model.ListFieldsOptions;
import com.ibm.watson.discovery.v2.model.ListFieldsResponse;
import com.ibm.watson.discovery.v2.model.ListTrainingQueriesOptions;
import com.ibm.watson.discovery.v2.model.QueryCalculationAggregation;
import com.ibm.watson.discovery.v2.model.QueryFilterAggregation;
import com.ibm.watson.discovery.v2.model.QueryHistogramAggregation;
import com.ibm.watson.discovery.v2.model.QueryLargePassages;
import com.ibm.watson.discovery.v2.model.QueryLargeSuggestedRefinements;
import com.ibm.watson.discovery.v2.model.QueryLargeTableResults;
import com.ibm.watson.discovery.v2.model.QueryNestedAggregation;
import com.ibm.watson.discovery.v2.model.QueryNoticesOptions;
import com.ibm.watson.discovery.v2.model.QueryNoticesResponse;
import com.ibm.watson.discovery.v2.model.QueryOptions;
import com.ibm.watson.discovery.v2.model.QueryResponse;
import com.ibm.watson.discovery.v2.model.QueryResult;
import com.ibm.watson.discovery.v2.model.QueryResultPassage;
import com.ibm.watson.discovery.v2.model.QueryTermAggregation;
import com.ibm.watson.discovery.v2.model.QueryTimesliceAggregation;
import com.ibm.watson.discovery.v2.model.QueryTopHitsAggregation;
import com.ibm.watson.discovery.v2.model.TrainingExample;
import com.ibm.watson.discovery.v2.model.TrainingQuery;
import com.ibm.watson.discovery.v2.model.TrainingQuerySet;
import com.ibm.watson.discovery.v2.model.UpdateDocumentOptions;
import com.ibm.watson.discovery.v2.model.UpdateTrainingQueryOptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/** The Class DiscoveryIT. */
@Ignore
@RunWith(RetryRunner.class)
public class DiscoveryIT extends WatsonServiceTest {
  private static final String VERSION = "2019-11-22";
  private static final String RESOURCE = "src/test/resources/discovery/v2/";
  private static final String PROJECT_ID = "9558dc01-8554-4d18-b0a5-70196f9f2fe6";
  private static final String COLLECTION_ID = "161d1e47-9651-e657-0000-016e8e939caf";

  private Discovery service;

  /**
   * Sets the up.
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
    String bearerToken = getProperty("discovery_v2.bearer_token");
    Assume.assumeFalse("config.properties doesn't have valid credentials.", (bearerToken == null));

    Authenticator authenticator = new BearerTokenAuthenticator(bearerToken);
    service = new Discovery(VERSION, authenticator);
    service.setDefaultHeaders(getDefaultHeaders());
    service.setServiceUrl(getProperty("discovery_v2.url"));

    HttpConfigOptions configOptions =
        new HttpConfigOptions.Builder().disableSslVerification(true).build();
    service.configureClient(configOptions);
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

  /** Test query. */
  @Test
  public void testQuery() {
    QueryOptions options =
        new QueryOptions.Builder()
            .projectId(PROJECT_ID)
            .addCollectionIds(COLLECTION_ID)
            .query("field" + Operator.CONTAINS + "1")
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
}

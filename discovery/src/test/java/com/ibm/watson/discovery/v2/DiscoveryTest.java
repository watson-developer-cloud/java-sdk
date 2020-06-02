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

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.watson.common.WatsonServiceUnitTest;
import com.ibm.watson.discovery.v2.model.AddDocumentOptions;
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
import com.ibm.watson.discovery.v2.model.QueryLargePassages;
import com.ibm.watson.discovery.v2.model.QueryLargeSuggestedRefinements;
import com.ibm.watson.discovery.v2.model.QueryLargeTableResults;
import com.ibm.watson.discovery.v2.model.QueryNoticesOptions;
import com.ibm.watson.discovery.v2.model.QueryNoticesResponse;
import com.ibm.watson.discovery.v2.model.QueryOptions;
import com.ibm.watson.discovery.v2.model.QueryResponse;
import com.ibm.watson.discovery.v2.model.TrainingExample;
import com.ibm.watson.discovery.v2.model.TrainingQuery;
import com.ibm.watson.discovery.v2.model.TrainingQuerySet;
import com.ibm.watson.discovery.v2.model.UpdateDocumentOptions;
import com.ibm.watson.discovery.v2.model.UpdateTrainingQueryOptions;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

/** The Class DiscoveryTest. */
public class DiscoveryTest extends WatsonServiceUnitTest {
  private static final String VERSION = "2019-11-22";
  private static final String RESOURCE = "src/test/resources/discovery/v2/";

  private static final String PROJECT_ID = "project_id";
  private static final String COLLECTION_ID = "collection_id";
  private static final String FILENAME = "filename";
  private static final String FILE_CONTENT_TYPE = "application/pdf";
  private static final String METADATA = "metadata";
  private static final String NATURAL_LANGUAGE_QUERY = "natural_language_query";
  private static final String FILTER = "filter";
  private static final String DOCUMENT_ID = "document_id";
  private static final Long RELEVANCE = 1L;
  private static final String FIELD = "field";
  private static final String PREFIX = "prefix";
  private static final Long COUNT = 2L;
  private static final String QUERY_ID = "query_id";
  private static final Long MAX_PER_DOCUMENT = 3L;
  private static final Long CHARACTERS = 4L;
  private static final String QUERY = "query";
  private static final String AGGREGATION = "aggregation";
  private static final String RETURN = "return";
  private static final Long OFFSET = 5L;
  private static final String SORT = "sort";
  private static final String NAME = "name";
  private static final Long MATCHING_RESULTS = 6L;
  private static final String SUGGESTED_QUERY = "suggested_query";
  private static final String DOCUMENT_RETRIEVAL_SOURCE = "document_retrieval_source";
  private static final Double CONFIDENCE = 0.0;
  private static final String PASSAGE_TEXT = "passage_text";
  private static final Long START_OFFSET = 7L;
  private static final Long END_OFFSET = 8L;
  private static final String TYPE = "type";
  private static final String DOCUMENT_RETRIEVAL_STRATEGY = "document_retrieval_strategy";
  private static final String TEXT = "text";
  private static final String TABLE_ID = "table_id";
  private static final String SOURCE_DOCUMENT_ID = "source_document_id";
  private static final String TABLE_HTML = "table_html";
  private static final Long TABLE_HTML_OFFSET = 9L;
  private static final Long BEGIN = 10L;
  private static final Long END = 11L;
  private static final String CELL_ID = "cell_id";
  private static final Long ROW_INDEX_BEGIN = 12L;
  private static final Long ROW_INDEX_END = 13L;
  private static final Long COLUMN_INDEX_BEGIN = 14L;
  private static final Long COLUMN_INDEX_END = 15L;
  private static final String TEXT_NORMALIZED = "text_normalized";
  private static final String ID = "id";
  private static final String COMPLETION = "completion";
  private static final String NOTICE_ID = "notice_id";
  private static final String SEVERITY = "severity";
  private static final String STEP = "step";
  private static final String DESCRIPTION = "description";
  private static final Long RESULTS_PER_PAGE = 17L;
  private static final String LABEL = "label";
  private static final String VISUALIZATION_TYPE = "visualization_type";
  private static final String STATUS = "status";

  private InputStream testDocument;
  private Date testDate;
  private TrainingExample trainingExampleMock;
  private QueryLargeTableResults queryLargeTableResults;
  private QueryLargeSuggestedRefinements queryLargeSuggestedRefinements;
  private QueryLargePassages queryLargePassages;

  private ListCollectionsResponse listCollectionsResponse;
  private QueryResponse queryResponse;
  private Completions completions;
  private QueryNoticesResponse queryNoticesResponse;
  private ListFieldsResponse listFieldsResponse;
  private ComponentSettingsResponse componentSettingsResponse;
  private DocumentAccepted documentAccepted;
  private DeleteDocumentResponse deleteDocumentResponse;
  private TrainingQuerySet trainingQuerySet;
  private TrainingQuery trainingQuery;

  private Discovery service;

  /**
   * Sets the up.
   *
   * @throws Exception the exception
   */
  /*
   * (non-Javadoc)
   * @see com.ibm.watson.common.WatsonServiceUnitTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    service = new Discovery(VERSION, new NoAuthAuthenticator());
    service.setServiceUrl(getMockWebServerUrl());

    // Create test models.
    testDocument = new FileInputStream(RESOURCE + "test-pdf.pdf");
    String dateString = "1995-06-12T01:11:11.111+0000";
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
    testDate = dateFormat.parse(dateString);
    trainingExampleMock =
        new TrainingExample.Builder()
            .documentId(DOCUMENT_ID)
            .collectionId(COLLECTION_ID)
            .relevance(RELEVANCE)
            .build();
    queryLargeTableResults = new QueryLargeTableResults.Builder().build();
    queryLargeSuggestedRefinements = new QueryLargeSuggestedRefinements.Builder().build();
    queryLargePassages = new QueryLargePassages.Builder().build();

    // load mock responses
    listCollectionsResponse =
        loadFixture(RESOURCE + "list-collections-response.json", ListCollectionsResponse.class);
    queryResponse = loadFixture(RESOURCE + "query-response.json", QueryResponse.class);
    completions = loadFixture(RESOURCE + "completions.json", Completions.class);
    queryNoticesResponse =
        loadFixture(RESOURCE + "query-notices-response.json", QueryNoticesResponse.class);
    listFieldsResponse =
        loadFixture(RESOURCE + "list-fields-response.json", ListFieldsResponse.class);
    componentSettingsResponse =
        loadFixture(RESOURCE + "component-settings-response.json", ComponentSettingsResponse.class);
    documentAccepted = loadFixture(RESOURCE + "document-accepted.json", DocumentAccepted.class);
    deleteDocumentResponse =
        loadFixture(RESOURCE + "delete-document-response.json", DeleteDocumentResponse.class);
    trainingQuerySet = loadFixture(RESOURCE + "training-query-set.json", TrainingQuerySet.class);
    trainingQuery = loadFixture(RESOURCE + "training-query.json", TrainingQuery.class);
  }

  /** Test config based constructor. */
  @Test
  public void testConfigBasedConstructor() {
    Discovery service = new Discovery(VERSION);
    assertEquals(Authenticator.AUTHTYPE_BASIC, service.getAuthenticator().authenticationType());
  }

  /** Test add document options. */
  @Test
  public void testAddDocumentOptions() {
    AddDocumentOptions options =
        new AddDocumentOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .file(testDocument)
            .filename(FILENAME)
            .fileContentType(FILE_CONTENT_TYPE)
            .metadata(METADATA)
            .xWatsonDiscoveryForce(true)
            .build();
    options = options.newBuilder().build();

    assertEquals(PROJECT_ID, options.projectId());
    assertEquals(COLLECTION_ID, options.collectionId());
    assertEquals(testDocument, options.file());
    assertEquals(FILENAME, options.filename());
    assertEquals(FILE_CONTENT_TYPE, options.fileContentType());
    assertEquals(METADATA, options.metadata());
    assertTrue(options.xWatsonDiscoveryForce());
  }

  /** Test create training query options. */
  @Test
  public void testCreateTrainingQueryOptions() {
    List<TrainingExample> exampleList = new ArrayList<>();
    exampleList.add(trainingExampleMock);

    CreateTrainingQueryOptions options =
        new CreateTrainingQueryOptions.Builder()
            .projectId(PROJECT_ID)
            .naturalLanguageQuery(NATURAL_LANGUAGE_QUERY)
            .filter(FILTER)
            .examples(exampleList)
            .addExamples(trainingExampleMock)
            .build();
    options = options.newBuilder().build();

    assertEquals(PROJECT_ID, options.projectId());
    assertEquals(NATURAL_LANGUAGE_QUERY, options.naturalLanguageQuery());
    assertEquals(FILTER, options.filter());
    assertEquals(2, options.examples().size());
    assertEquals(trainingExampleMock, options.examples().get(0));
  }

  /** Test delete document options. */
  @Test
  public void testDeleteDocumentOptions() {
    DeleteDocumentOptions options =
        new DeleteDocumentOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .documentId(DOCUMENT_ID)
            .xWatsonDiscoveryForce(true)
            .build();
    options = options.newBuilder().build();

    assertEquals(PROJECT_ID, options.projectId());
    assertEquals(COLLECTION_ID, options.collectionId());
    assertEquals(DOCUMENT_ID, options.documentId());
    assertTrue(options.xWatsonDiscoveryForce());
  }

  /** Test delete training query options. */
  @Test
  public void testDeleteTrainingQueryOptions() {
    DeleteTrainingQueriesOptions options =
        new DeleteTrainingQueriesOptions.Builder().projectId(PROJECT_ID).build();
    options = options.newBuilder().build();

    assertEquals(PROJECT_ID, options.projectId());
  }

  /** Test get autocompletion options. */
  @Test
  public void testGetAutocompletionOptions() {
    List<String> collectionIds = new ArrayList<>();
    collectionIds.add(COLLECTION_ID);

    GetAutocompletionOptions options =
        new GetAutocompletionOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionIds(collectionIds)
            .addCollectionIds(COLLECTION_ID)
            .field(FIELD)
            .prefix(PREFIX)
            .count(COUNT)
            .build();
    options = options.newBuilder().build();

    assertEquals(PROJECT_ID, options.projectId());
    assertEquals(2, options.collectionIds().size());
    assertEquals(COLLECTION_ID, options.collectionIds().get(0));
    assertEquals(FIELD, options.field());
    assertEquals(PREFIX, options.prefix());
    assertEquals(COUNT, options.count());
  }

  /** Test get component settings options. */
  @Test
  public void testGetComponentSettingsOptions() {
    GetComponentSettingsOptions options =
        new GetComponentSettingsOptions.Builder().projectId(PROJECT_ID).build();
    options = options.newBuilder().build();

    assertEquals(PROJECT_ID, options.projectId());
  }

  /** Test get training query options. */
  @Test
  public void testGetTrainingQueryOptions() {
    GetTrainingQueryOptions options =
        new GetTrainingQueryOptions.Builder().projectId(PROJECT_ID).queryId(QUERY_ID).build();
    options = options.newBuilder().build();

    assertEquals(PROJECT_ID, options.projectId());
    assertEquals(QUERY_ID, options.queryId());
  }

  /** Test list collections options. */
  @Test
  public void testListCollectionsOptions() {
    ListCollectionsOptions options =
        new ListCollectionsOptions.Builder().projectId(PROJECT_ID).build();
    options = options.newBuilder().build();

    assertEquals(PROJECT_ID, options.projectId());
  }

  /** Test list fields options. */
  @Test
  public void testListFieldsOptions() {
    List<String> collectionIds = new ArrayList<>();
    collectionIds.add(COLLECTION_ID);

    ListFieldsOptions options =
        new ListFieldsOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionIds(collectionIds)
            .addCollectionIds(COLLECTION_ID)
            .build();
    options = options.newBuilder().build();

    assertEquals(PROJECT_ID, options.projectId());
    assertEquals(2, options.collectionIds().size());
    assertEquals(COLLECTION_ID, options.collectionIds().get(0));
  }

  /** Test list training queries options. */
  @Test
  public void testListTrainingQueriesOptions() {
    ListTrainingQueriesOptions options =
        new ListTrainingQueriesOptions.Builder().projectId(PROJECT_ID).build();
    options = options.newBuilder().build();

    assertEquals(PROJECT_ID, options.projectId());
  }

  /** Test query large passages. */
  @Test
  public void testQueryLargePassages() {
    List<String> fields = new ArrayList<>();
    fields.add(FIELD);

    QueryLargePassages queryLargePassages =
        new QueryLargePassages.Builder()
            .enabled(true)
            .perDocument(true)
            .maxPerDocument(MAX_PER_DOCUMENT)
            .fields(fields)
            .addFields(FIELD)
            .count(COUNT)
            .characters(CHARACTERS)
            .build();
    queryLargePassages = queryLargePassages.newBuilder().build();

    assertTrue(queryLargePassages.enabled());
    assertTrue(queryLargePassages.perDocument());
    assertEquals(MAX_PER_DOCUMENT, queryLargePassages.maxPerDocument());
    assertEquals(2, queryLargePassages.fields().size());
    assertEquals(FIELD, queryLargePassages.fields().get(0));
    assertEquals(COUNT, queryLargePassages.count());
    assertEquals(CHARACTERS, queryLargePassages.characters());
  }

  /** Test query large suggested refinements. */
  @Test
  public void testQueryLargeSuggestedRefinements() {
    QueryLargeSuggestedRefinements queryLargeSuggestedRefinements =
        new QueryLargeSuggestedRefinements.Builder().enabled(true).count(COUNT).build();
    queryLargeSuggestedRefinements = queryLargeSuggestedRefinements.newBuilder().build();

    assertTrue(queryLargeSuggestedRefinements.enabled());
    assertEquals(COUNT, queryLargeSuggestedRefinements.count());
  }

  /** Test query large table results. */
  @Test
  public void testQueryLargeTableResults() {
    QueryLargeTableResults queryLargeTableResults =
        new QueryLargeTableResults.Builder().enabled(true).count(COUNT).build();
    queryLargeTableResults = queryLargeTableResults.newBuilder().build();

    assertTrue(queryLargeTableResults.enabled());
    assertEquals(COUNT, queryLargeTableResults.count());
  }

  /** Test query notices options. */
  @Test
  public void testQueryNoticesOptions() {
    QueryNoticesOptions options =
        new QueryNoticesOptions.Builder()
            .projectId(PROJECT_ID)
            .filter(FILTER)
            .query(QUERY)
            .naturalLanguageQuery(NATURAL_LANGUAGE_QUERY)
            .count(COUNT)
            .offset(OFFSET)
            .build();
    options = options.newBuilder().build();

    assertEquals(PROJECT_ID, options.projectId());
    assertEquals(FILTER, options.filter());
    assertEquals(QUERY, options.query());
    assertEquals(NATURAL_LANGUAGE_QUERY, options.naturalLanguageQuery());
    assertEquals(COUNT, options.count());
    assertEquals(OFFSET, options.offset());
  }

  /** Test query options. */
  @Test
  public void testQueryOptions() {
    List<String> collectionIds = new ArrayList<>();
    collectionIds.add(COLLECTION_ID);
    List<String> returnList = new ArrayList<>();
    returnList.add(RETURN);

    QueryOptions options =
        new QueryOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionIds(collectionIds)
            .addCollectionIds(COLLECTION_ID)
            .filter(FILTER)
            .query(QUERY)
            .naturalLanguageQuery(NATURAL_LANGUAGE_QUERY)
            .aggregation(AGGREGATION)
            .count(COUNT)
            .xReturn(returnList)
            .addReturnField(RETURN)
            .offset(OFFSET)
            .sort(SORT)
            .highlight(true)
            .spellingSuggestions(true)
            .tableResults(queryLargeTableResults)
            .suggestedRefinements(queryLargeSuggestedRefinements)
            .passages(queryLargePassages)
            .build();
    options = options.newBuilder().build();

    assertEquals(PROJECT_ID, options.projectId());
    assertEquals(FILTER, options.filter());
    assertEquals(QUERY, options.query());
    assertEquals(NATURAL_LANGUAGE_QUERY, options.naturalLanguageQuery());
    assertEquals(AGGREGATION, options.aggregation());
    assertEquals(COUNT, options.count());
    assertEquals(2, options.xReturn().size());
    assertEquals(RETURN, options.xReturn().get(0));
    assertEquals(OFFSET, options.offset());
    assertEquals(SORT, options.sort());
    assertTrue(options.highlight());
    assertTrue(options.spellingSuggestions());
    assertEquals(queryLargeTableResults, options.tableResults());
    assertEquals(queryLargeSuggestedRefinements, options.suggestedRefinements());
    assertEquals(queryLargePassages, options.passages());
  }

  /** Test training example. */
  @Test
  public void testTrainingExample() {
    TrainingExample trainingExample =
        new TrainingExample.Builder()
            .documentId(DOCUMENT_ID)
            .collectionId(COLLECTION_ID)
            .relevance(RELEVANCE)
            .created(testDate)
            .updated(testDate)
            .build();
    trainingExample = trainingExample.newBuilder().build();

    assertEquals(DOCUMENT_ID, trainingExample.documentId());
    assertEquals(COLLECTION_ID, trainingExample.collectionId());
    assertEquals(RELEVANCE, trainingExample.relevance());
    assertEquals(testDate, trainingExample.created());
    assertEquals(testDate, trainingExample.updated());
  }

  /** Test training query. */
  @Test
  public void testTrainingQuery() {
    List<TrainingExample> exampleList = new ArrayList<>();
    exampleList.add(trainingExampleMock);

    TrainingQuery trainingQuery =
        new TrainingQuery.Builder()
            .queryId(QUERY_ID)
            .naturalLanguageQuery(NATURAL_LANGUAGE_QUERY)
            .filter(FILTER)
            .created(testDate)
            .updated(testDate)
            .examples(exampleList)
            .addExamples(trainingExampleMock)
            .build();
    trainingQuery = trainingQuery.newBuilder().build();

    assertEquals(QUERY_ID, trainingQuery.queryId());
    assertEquals(NATURAL_LANGUAGE_QUERY, trainingQuery.naturalLanguageQuery());
    assertEquals(FILTER, trainingQuery.filter());
    assertEquals(testDate, trainingQuery.created());
    assertEquals(testDate, trainingQuery.updated());
    assertEquals(2, trainingQuery.examples().size());
    assertEquals(trainingExampleMock, trainingQuery.examples().get(0));
  }

  /** Test update document options. */
  @Test
  public void testUpdateDocumentOptions() {
    UpdateDocumentOptions options =
        new UpdateDocumentOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .documentId(DOCUMENT_ID)
            .file(testDocument)
            .filename(FILENAME)
            .fileContentType(FILE_CONTENT_TYPE)
            .metadata(METADATA)
            .xWatsonDiscoveryForce(true)
            .build();
    options = options.newBuilder().build();

    assertEquals(PROJECT_ID, options.projectId());
    assertEquals(COLLECTION_ID, options.collectionId());
    assertEquals(testDocument, options.file());
    assertEquals(FILENAME, options.filename());
    assertEquals(FILE_CONTENT_TYPE, options.fileContentType());
    assertEquals(METADATA, options.metadata());
    assertTrue(options.xWatsonDiscoveryForce());
  }

  /** Test update training query options. */
  @Test
  public void testUpdateTrainingQueryOptions() {
    List<TrainingExample> exampleList = new ArrayList<>();
    exampleList.add(trainingExampleMock);

    UpdateTrainingQueryOptions options =
        new UpdateTrainingQueryOptions.Builder()
            .projectId(PROJECT_ID)
            .queryId(QUERY_ID)
            .naturalLanguageQuery(NATURAL_LANGUAGE_QUERY)
            .filter(FILTER)
            .examples(exampleList)
            .addExamples(trainingExampleMock)
            .build();
    options = options.newBuilder().build();

    assertEquals(PROJECT_ID, options.projectId());
    assertEquals(NATURAL_LANGUAGE_QUERY, options.naturalLanguageQuery());
    assertEquals(FILTER, options.filter());
    assertEquals(2, options.examples().size());
    assertEquals(trainingExampleMock, options.examples().get(0));
  }

  /** Test list collections. */
  @Test
  public void testListCollections() {
    server.enqueue(jsonResponse(listCollectionsResponse));

    ListCollectionsOptions options =
        new ListCollectionsOptions.Builder().projectId(PROJECT_ID).build();
    ListCollectionsResponse response = service.listCollections(options).execute().getResult();

    assertEquals(COLLECTION_ID, response.getCollections().get(0).getCollectionId());
    assertEquals(NAME, response.getCollections().get(0).getName());
  }

  /** Test query. */
  @Test
  public void testQuery() {
    server.enqueue(jsonResponse(queryResponse));

    QueryOptions options = new QueryOptions.Builder().projectId(PROJECT_ID).build();
    QueryResponse response = service.query(options).execute().getResult();

    assertEquals(MATCHING_RESULTS, response.getMatchingResults());
    assertEquals(DOCUMENT_ID, response.getResults().get(0).getDocumentId());
    assertEquals(
        DOCUMENT_RETRIEVAL_SOURCE,
        response.getResults().get(0).getResultMetadata().getDocumentRetrievalSource());
    assertEquals(COLLECTION_ID, response.getResults().get(0).getResultMetadata().getCollectionId());
    assertEquals(CONFIDENCE, response.getResults().get(0).getResultMetadata().getConfidence());
    assertEquals(
        PASSAGE_TEXT, response.getResults().get(0).getDocumentPassages().get(0).getPassageText());
    assertEquals(
        START_OFFSET, response.getResults().get(0).getDocumentPassages().get(0).getStartOffset());
    assertEquals(
        END_OFFSET, response.getResults().get(0).getDocumentPassages().get(0).getEndOffset());
    assertEquals(FIELD, response.getResults().get(0).getDocumentPassages().get(0).getField());
    assertEquals(
        DOCUMENT_RETRIEVAL_STRATEGY, response.getRetrievalDetails().getDocumentRetrievalStrategy());
    assertEquals(SUGGESTED_QUERY, response.getSuggestedQuery());
    assertEquals(TEXT, response.getSuggestedRefinements().get(0).getText());
    assertEquals(TABLE_ID, response.getTableResults().get(0).getTableId());
    assertEquals(SOURCE_DOCUMENT_ID, response.getTableResults().get(0).getSourceDocumentId());
    assertEquals(COLLECTION_ID, response.getTableResults().get(0).getCollectionId());
    assertEquals(TABLE_HTML, response.getTableResults().get(0).getTableHtml());
    assertEquals(TABLE_HTML_OFFSET, response.getTableResults().get(0).getTableHtmlOffset());
    assertEquals(BEGIN, response.getTableResults().get(0).getTable().getLocation().getBegin());
    assertEquals(END, response.getTableResults().get(0).getTable().getLocation().getEnd());
    assertEquals(TEXT, response.getTableResults().get(0).getTable().getText());
    assertEquals(TEXT, response.getTableResults().get(0).getTable().getSectionTitle().getText());
    assertEquals(
        BEGIN,
        response.getTableResults().get(0).getTable().getSectionTitle().getLocation().getBegin());
    assertEquals(
        END, response.getTableResults().get(0).getTable().getSectionTitle().getLocation().getEnd());
    assertEquals(TEXT, response.getTableResults().get(0).getTable().getTitle().getText());
    assertEquals(
        BEGIN, response.getTableResults().get(0).getTable().getTitle().getLocation().getBegin());
    assertEquals(
        END, response.getTableResults().get(0).getTable().getTitle().getLocation().getEnd());
    assertEquals(
        CELL_ID, response.getTableResults().get(0).getTable().getTableHeaders().get(0).getCellId());
    assertEquals(
        TEXT, response.getTableResults().get(0).getTable().getTableHeaders().get(0).getText());
    assertEquals(
        ROW_INDEX_BEGIN,
        response.getTableResults().get(0).getTable().getTableHeaders().get(0).getRowIndexBegin());
    assertEquals(
        ROW_INDEX_END,
        response.getTableResults().get(0).getTable().getTableHeaders().get(0).getRowIndexEnd());
    assertEquals(
        COLUMN_INDEX_BEGIN,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getTableHeaders()
            .get(0)
            .getColumnIndexBegin());
    assertEquals(
        COLUMN_INDEX_END,
        response.getTableResults().get(0).getTable().getTableHeaders().get(0).getColumnIndexEnd());
    assertEquals(
        CELL_ID, response.getTableResults().get(0).getTable().getRowHeaders().get(0).getCellId());
    assertEquals(
        BEGIN,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getRowHeaders()
            .get(0)
            .getLocation()
            .getBegin());
    assertEquals(
        END,
        response.getTableResults().get(0).getTable().getRowHeaders().get(0).getLocation().getEnd());
    assertEquals(
        TEXT, response.getTableResults().get(0).getTable().getRowHeaders().get(0).getText());
    assertEquals(
        ROW_INDEX_BEGIN,
        response.getTableResults().get(0).getTable().getRowHeaders().get(0).getRowIndexBegin());
    assertEquals(
        ROW_INDEX_END,
        response.getTableResults().get(0).getTable().getRowHeaders().get(0).getRowIndexEnd());
    assertEquals(
        COLUMN_INDEX_BEGIN,
        response.getTableResults().get(0).getTable().getRowHeaders().get(0).getColumnIndexBegin());
    assertEquals(
        COLUMN_INDEX_END,
        response.getTableResults().get(0).getTable().getRowHeaders().get(0).getColumnIndexEnd());
    assertEquals(
        CELL_ID,
        response.getTableResults().get(0).getTable().getColumnHeaders().get(0).getCellId());
    assertEquals(
        TEXT, response.getTableResults().get(0).getTable().getColumnHeaders().get(0).getText());
    assertEquals(
        ROW_INDEX_BEGIN,
        response.getTableResults().get(0).getTable().getColumnHeaders().get(0).getRowIndexBegin());
    assertEquals(
        ROW_INDEX_END,
        response.getTableResults().get(0).getTable().getColumnHeaders().get(0).getRowIndexEnd());
    assertEquals(
        COLUMN_INDEX_BEGIN,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getColumnHeaders()
            .get(0)
            .getColumnIndexBegin());
    assertEquals(
        COLUMN_INDEX_END,
        response.getTableResults().get(0).getTable().getColumnHeaders().get(0).getColumnIndexEnd());
    assertEquals(
        CELL_ID,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getKeyValuePairs()
            .get(0)
            .getKey()
            .getCellId());
    assertEquals(
        BEGIN,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getKeyValuePairs()
            .get(0)
            .getKey()
            .getLocation()
            .getBegin());
    assertEquals(
        END,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getKeyValuePairs()
            .get(0)
            .getKey()
            .getLocation()
            .getEnd());
    assertEquals(
        TEXT,
        response.getTableResults().get(0).getTable().getKeyValuePairs().get(0).getKey().getText());
    assertEquals(
        CELL_ID,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getKeyValuePairs()
            .get(0)
            .getValue()
            .get(0)
            .getCellId());
    assertEquals(
        BEGIN,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getKeyValuePairs()
            .get(0)
            .getValue()
            .get(0)
            .getLocation()
            .getBegin());
    assertEquals(
        END,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getKeyValuePairs()
            .get(0)
            .getValue()
            .get(0)
            .getLocation()
            .getEnd());
    assertEquals(
        TEXT,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getKeyValuePairs()
            .get(0)
            .getValue()
            .get(0)
            .getText());
    assertEquals(
        CELL_ID, response.getTableResults().get(0).getTable().getBodyCells().get(0).getCellId());
    assertEquals(
        BEGIN,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getBodyCells()
            .get(0)
            .getLocation()
            .getBegin());
    assertEquals(
        END,
        response.getTableResults().get(0).getTable().getBodyCells().get(0).getLocation().getEnd());
    assertEquals(
        TEXT, response.getTableResults().get(0).getTable().getBodyCells().get(0).getText());
    assertEquals(
        ROW_INDEX_BEGIN,
        response.getTableResults().get(0).getTable().getBodyCells().get(0).getRowIndexBegin());
    assertEquals(
        ROW_INDEX_END,
        response.getTableResults().get(0).getTable().getBodyCells().get(0).getRowIndexEnd());
    assertEquals(
        COLUMN_INDEX_BEGIN,
        response.getTableResults().get(0).getTable().getBodyCells().get(0).getColumnIndexBegin());
    assertEquals(
        COLUMN_INDEX_END,
        response.getTableResults().get(0).getTable().getBodyCells().get(0).getColumnIndexEnd());
    assertEquals(
        ID,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getBodyCells()
            .get(0)
            .getRowHeaderIds()
            .get(0)
            .getId());
    assertEquals(
        TEXT,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getBodyCells()
            .get(0)
            .getRowHeaderTexts()
            .get(0)
            .getText());
    assertEquals(
        TEXT_NORMALIZED,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getBodyCells()
            .get(0)
            .getRowHeaderTextsNormalized()
            .get(0)
            .getTextNormalized());
    assertEquals(
        ID,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getBodyCells()
            .get(0)
            .getColumnHeaderIds()
            .get(0)
            .getId());
    assertEquals(
        TEXT,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getBodyCells()
            .get(0)
            .getColumnHeaderTexts()
            .get(0)
            .getText());
    assertEquals(
        TEXT_NORMALIZED,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getBodyCells()
            .get(0)
            .getColumnHeaderTextsNormalized()
            .get(0)
            .getTextNormalized());
    assertEquals(
        TYPE,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getBodyCells()
            .get(0)
            .getAttributes()
            .get(0)
            .getType());
    assertEquals(
        TEXT,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getBodyCells()
            .get(0)
            .getAttributes()
            .get(0)
            .getText());
    assertEquals(
        BEGIN,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getBodyCells()
            .get(0)
            .getAttributes()
            .get(0)
            .getLocation()
            .getBegin());
    assertEquals(
        END,
        response
            .getTableResults()
            .get(0)
            .getTable()
            .getBodyCells()
            .get(0)
            .getAttributes()
            .get(0)
            .getLocation()
            .getEnd());
    assertEquals(TEXT, response.getTableResults().get(0).getTable().getContexts().get(0).getText());
    assertEquals(
        BEGIN,
        response.getTableResults().get(0).getTable().getContexts().get(0).getLocation().getBegin());
    assertEquals(
        END,
        response.getTableResults().get(0).getTable().getContexts().get(0).getLocation().getEnd());
  }

  /** Test get autocompletion. */
  @Test
  public void testGetAutocompletion() {
    server.enqueue(jsonResponse(completions));

    GetAutocompletionOptions options =
        new GetAutocompletionOptions.Builder().projectId(PROJECT_ID).prefix(PREFIX).build();
    Completions response = service.getAutocompletion(options).execute().getResult();

    assertEquals(COMPLETION, response.getCompletions().get(0));
  }

  /** Test query notices. */
  @Test
  public void testQueryNotices() {
    server.enqueue(jsonResponse(queryNoticesResponse));

    QueryNoticesOptions options = new QueryNoticesOptions.Builder().projectId(PROJECT_ID).build();
    QueryNoticesResponse response = service.queryNotices(options).execute().getResult();

    assertEquals(MATCHING_RESULTS, response.getMatchingResults());
    assertEquals(NOTICE_ID, response.getNotices().get(0).getNoticeId());
    assertEquals(testDate, response.getNotices().get(0).getCreated());
    assertEquals(DOCUMENT_ID, response.getNotices().get(0).getDocumentId());
    assertEquals(COLLECTION_ID, response.getNotices().get(0).getCollectionId());
    assertEquals(QUERY_ID, response.getNotices().get(0).getQueryId());
    assertEquals(SEVERITY, response.getNotices().get(0).getSeverity());
    assertEquals(STEP, response.getNotices().get(0).getStep());
    assertEquals(DESCRIPTION, response.getNotices().get(0).getDescription());
  }

  /** Test list fields. */
  @Test
  public void testListFields() {
    server.enqueue(jsonResponse(listFieldsResponse));

    ListFieldsOptions options = new ListFieldsOptions.Builder().projectId(PROJECT_ID).build();
    ListFieldsResponse response = service.listFields(options).execute().getResult();

    assertEquals(FIELD, response.getFields().get(0).getField());
    assertEquals(TYPE, response.getFields().get(0).getType());
    assertEquals(COLLECTION_ID, response.getFields().get(0).getCollectionId());
  }

  /** Test get component settings. */
  @Test
  public void testGetComponentSettings() {
    server.enqueue(jsonResponse(componentSettingsResponse));

    GetComponentSettingsOptions options =
        new GetComponentSettingsOptions.Builder().projectId(PROJECT_ID).build();
    ComponentSettingsResponse response =
        service.getComponentSettings(options).execute().getResult();

    assertTrue(response.getFieldsShown().getBody().isUsePassage());
    assertEquals(FIELD, response.getFieldsShown().getBody().getField());
    assertEquals(FIELD, response.getFieldsShown().getTitle().getField());
    assertTrue(response.isAutocomplete());
    assertTrue(response.isStructuredSearch());
    assertEquals(RESULTS_PER_PAGE, response.getResultsPerPage());
    assertEquals(NAME, response.getAggregations().get(0).getName());
    assertEquals(LABEL, response.getAggregations().get(0).getLabel());
    assertTrue(response.getAggregations().get(0).isMultipleSelectionsAllowed());
    assertEquals(VISUALIZATION_TYPE, response.getAggregations().get(0).getVisualizationType());
  }

  /** Test add document. */
  @Test
  public void testAddDocument() {
    server.enqueue(jsonResponse(documentAccepted));

    AddDocumentOptions options =
        new AddDocumentOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .file(testDocument)
            .filename(FILENAME)
            .build();
    DocumentAccepted response = service.addDocument(options).execute().getResult();

    assertEquals(DOCUMENT_ID, response.getDocumentId());
    assertEquals(STATUS, response.getStatus());
  }

  /** Test update document. */
  @Test
  public void testUpdateDocument() {
    server.enqueue(jsonResponse(documentAccepted));

    UpdateDocumentOptions options =
        new UpdateDocumentOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .documentId(DOCUMENT_ID)
            .file(testDocument)
            .filename(FILENAME)
            .build();
    DocumentAccepted response = service.updateDocument(options).execute().getResult();

    assertEquals(DOCUMENT_ID, response.getDocumentId());
    assertEquals(STATUS, response.getStatus());
  }

  /** Test delete document. */
  @Test
  public void testDeleteDocument() {
    server.enqueue(jsonResponse(deleteDocumentResponse));

    DeleteDocumentOptions options =
        new DeleteDocumentOptions.Builder()
            .projectId(PROJECT_ID)
            .collectionId(COLLECTION_ID)
            .documentId(DOCUMENT_ID)
            .build();
    DeleteDocumentResponse response = service.deleteDocument(options).execute().getResult();

    assertEquals(DOCUMENT_ID, response.getDocumentId());
    assertEquals(STATUS, response.getStatus());
  }

  /** Test list training queries. */
  @Test
  public void testListTrainingQueries() {
    server.enqueue(jsonResponse(trainingQuerySet));

    ListTrainingQueriesOptions options =
        new ListTrainingQueriesOptions.Builder().projectId(PROJECT_ID).build();
    TrainingQuerySet response = service.listTrainingQueries(options).execute().getResult();

    assertEquals(QUERY_ID, response.getQueries().get(0).queryId());
    assertEquals(NATURAL_LANGUAGE_QUERY, response.getQueries().get(0).naturalLanguageQuery());
    assertEquals(FILTER, response.getQueries().get(0).filter());
    assertEquals(testDate, response.getQueries().get(0).created());
    assertEquals(testDate, response.getQueries().get(0).updated());
    assertEquals(DOCUMENT_ID, response.getQueries().get(0).examples().get(0).documentId());
    assertEquals(COLLECTION_ID, response.getQueries().get(0).examples().get(0).collectionId());
    assertEquals(RELEVANCE, response.getQueries().get(0).examples().get(0).relevance());
    assertEquals(testDate, response.getQueries().get(0).examples().get(0).created());
    assertEquals(testDate, response.getQueries().get(0).examples().get(0).updated());
  }

  /**
   * Test delete training queries.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteTrainingQueries() throws InterruptedException {
    server.enqueue(new MockResponse());

    DeleteTrainingQueriesOptions options =
        new DeleteTrainingQueriesOptions.Builder().projectId(PROJECT_ID).build();
    service.deleteTrainingQueries(options).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals("DELETE", request.getMethod());
  }

  /** Test create training query. */
  @Test
  public void testCreateTrainingQuery() {
    server.enqueue(jsonResponse(trainingQuery));

    CreateTrainingQueryOptions options =
        new CreateTrainingQueryOptions.Builder()
            .projectId(PROJECT_ID)
            .naturalLanguageQuery(NATURAL_LANGUAGE_QUERY)
            .addExamples(trainingExampleMock)
            .build();
    TrainingQuery response = service.createTrainingQuery(options).execute().getResult();

    assertEquals(QUERY_ID, response.queryId());
    assertEquals(NATURAL_LANGUAGE_QUERY, response.naturalLanguageQuery());
    assertEquals(FILTER, response.filter());
    assertEquals(testDate, response.created());
    assertEquals(testDate, response.updated());
    assertEquals(DOCUMENT_ID, response.examples().get(0).documentId());
    assertEquals(COLLECTION_ID, response.examples().get(0).collectionId());
    assertEquals(RELEVANCE, response.examples().get(0).relevance());
    assertEquals(testDate, response.examples().get(0).created());
    assertEquals(testDate, response.examples().get(0).updated());
  }

  /** Test get training query. */
  @Test
  public void testGetTrainingQuery() {
    server.enqueue(jsonResponse(trainingQuery));

    GetTrainingQueryOptions options =
        new GetTrainingQueryOptions.Builder().projectId(PROJECT_ID).queryId(QUERY_ID).build();
    TrainingQuery response = service.getTrainingQuery(options).execute().getResult();

    assertEquals(QUERY_ID, response.queryId());
    assertEquals(NATURAL_LANGUAGE_QUERY, response.naturalLanguageQuery());
    assertEquals(FILTER, response.filter());
    assertEquals(testDate, response.created());
    assertEquals(testDate, response.updated());
    assertEquals(DOCUMENT_ID, response.examples().get(0).documentId());
    assertEquals(COLLECTION_ID, response.examples().get(0).collectionId());
    assertEquals(RELEVANCE, response.examples().get(0).relevance());
    assertEquals(testDate, response.examples().get(0).created());
    assertEquals(testDate, response.examples().get(0).updated());
  }

  /** Test update training query. */
  @Test
  public void testUpdateTrainingQuery() {
    server.enqueue(jsonResponse(trainingQuery));

    UpdateTrainingQueryOptions options =
        new UpdateTrainingQueryOptions.Builder()
            .projectId(PROJECT_ID)
            .queryId(QUERY_ID)
            .naturalLanguageQuery(NATURAL_LANGUAGE_QUERY)
            .addExamples(trainingExampleMock)
            .build();
    TrainingQuery response = service.updateTrainingQuery(options).execute().getResult();

    assertEquals(QUERY_ID, response.queryId());
    assertEquals(NATURAL_LANGUAGE_QUERY, response.naturalLanguageQuery());
    assertEquals(FILTER, response.filter());
    assertEquals(testDate, response.created());
    assertEquals(testDate, response.updated());
    assertEquals(DOCUMENT_ID, response.examples().get(0).documentId());
    assertEquals(COLLECTION_ID, response.examples().get(0).collectionId());
    assertEquals(RELEVANCE, response.examples().get(0).relevance());
    assertEquals(testDate, response.examples().get(0).created());
    assertEquals(testDate, response.examples().get(0).updated());
  }
}

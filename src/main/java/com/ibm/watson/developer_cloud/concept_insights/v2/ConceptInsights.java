/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.concept_insights.v2;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.*;
import com.ibm.watson.developer_cloud.concept_insights.v2.util.ConceptInsightsId;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingFormatArgumentException;

/**
 * The IBM Watson™ Concept Insights service provides APIs that enable you to work with
 * concepts and identify conceptual associations in the content that you provide as input
 * to the service. Input content is auto-tagged against a concept graph, which is a formal
 * representation of the relationship(s) between concepts. The concept graph used by the
 * Concept Insights service is based on content that has been ingested from the English
 * language Wikipedia.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 * @version v2
 * @see <a
 * href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/concept_insights.html">
 * Concept Insights</a>
 */
public class ConceptInsights extends WatsonService {

    /**
     * The Constant ACCOUNT_ID. (value is "account_id")
     */
    public static final String ACCOUNT_ID = "account_id";

    /**
     * The Constant CONCEPT_ID. (value is "concept_id")
     */
    public static final String CONCEPT_ID = "concept_id";

    /**
     * The ACCOUNTS_PATH. (value is "/v2/accounts")
     */
    private static final String ACCOUNTS_PATH = "/v2/accounts";

    /**
     * The Constant ANNOTATE_TEXT_PATH. (value is "annotate_text")
     */
    private static final String ANNOTATE_TEXT_PATH = "/annotate_text";

    /**
     * The ANNOTATIONS_PATH. (value is "annotations")
     */
    private static final String ANNOTATIONS_PATH = "/annotations";

    /**
     * The Constant CONCEPT. (value is "concept")
     */
    public static final String CONCEPT = "concept";

    /**
     * The Constant CONCEPT_FIELDS. (value is "concept_fields")
     */
    public static final String CONCEPT_FIELDS = "concept_fields";

    /**
     * The Constant CONCEPTS. (value is "concepts")
     */
    public static final String CONCEPTS = "concepts";

    /**
     * The Constant CONCEPTUAL_SEARCH_PATH. (value is "conceptual_search")
     */
    private static final String CONCEPTUAL_SEARCH_PATH = "/conceptual_search";

    /**
     * The CORPORA_PATH. (value is "/v2/corpora")
     */
    private static final String CORPORA_PATH = "/v2/corpora";

    /**
     * The Constant CORPUS. (value is "graph")
     */
    public static final String CORPUS = "corpus";

    /**
     * The Constant CURSOR. (value is "graph")
     */
    public static final String CURSOR = "cursor";

    /**
     * The Constant DOCUMENT. (value is "graph")
     */
    public static final String DOCUMENT = "document";

    /**
     * The Constant DOCUMENT_FIELDS. (value is "document_fields")
     */
    public static final String DOCUMENT_FIELDS = "document_fields";

    /**
     * The Constant DOCUMENTS. (value is "graph")
     */
    public static final String DOCUMENTS = "documents";

    /**
     * The Constant GRAPH NAME. (value is "graph")
     */
    public static final String GRAPH = "graph";

    /**
     * The GRAPHS_PATH. (value is "/v2/graphs")
     */
    private static final String GRAPHS_PATH = "/v2/graphs";

    /**
     * The GRAPHS_PATH. (value is "/v2/graphs")
     */
    private static final String version = "/v2";

    /**
     * The Constant IDS. (value is "ids")
     */
    public static final String IDS = "ids";

    /**
     * The LABEL_SEARCH_PATH. (value is "label_search")
     */
    private static final String LABEL_SEARCH_PATH = "/label_search";

    /**
     * The Constant LEVEL. (value is "level")
     */
    public static final String LEVEL = "level";

    /**
     * The Constant LIMIT. (value is "limit")
     */
    public static final String LIMIT = "limit";

    /**
     * The Constant PREFIX. (value is "prefix")
     */
    public static final String PREFIX = "prefix";

    /**
     * The Constant PROCESSING_STATE_PATH. (value is "processing_state")
     */
    private static final String PROCESSING_STATE_PATH = "/processing_state";

    /**
     * The Constant query. (value is "query")
     */
    public static final String QUERY = "query";

    /**
     * The RELATED_CONCEPTS_PATH. (value is "related_concepts")
     */
    private static final String RELATED_CONCEPTS_PATH = "/related_concepts";

    /**
     * The Constant RELATION_SCORES_PATH. (value is "graph")
     */
    private static final String RELATION_SCORES_PATH = "/relation_scores";

    /**
     * The Constant STATS_PATH. (value is "stats")
     */
    private static final String STATS_PATH = "/stats";

    /**
     * The Constant TEXT. (value is "text")
     */
    public static final String TEXT = "text";

    private String accountId = null;

    /**
     * The service url.
     * (value is "https://gateway.watsonplatform.net/concept-insights/api")
     */
    private static final String URL = "https://gateway.watsonplatform.net/concept-insights/api";

    /**
     * Instantiates a new Concept Insights service.
     */
    public ConceptInsights() {
        setEndPoint(URL);

    }

    private String getAccountId() {
        if (accountId == null) {
            Accounts accounts = getAccountsInfo();
            accountId = (accounts != null && accounts.getAccounts() != null && accounts.getAccounts().size() > 0) ? accounts.getAccounts().get(0).getId() : null;
        }
        return accountId;
    }

    /**
     * Identifies concepts in a piece of text.
     *
     * @param  graph - The graph object.
     * @param  text - The text to annotate.
     * @return {@link Annotations}
     */
    public Annotations annotateText(Graph graph, final String text) {
        ConceptInsightsId.validateGenarate(graph, getAccountId());
        Validate.notNull(text, "text can't be null");

        HttpRequestBase request = Request.Post(version + graph.getId() + ANNOTATE_TEXT_PATH)
                .withContent(text, MediaType.TEXT_PLAIN)
                .withHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).build();

        try {
            HttpResponse response = execute(request);
            Annotations annotations = GsonSingleton.getGson().fromJson(
                    ResponseUtil.getString(response), Annotations.class);
            return annotations;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Performs a conceptual search within a corpus.
     *
     * @param   corpus         Corpus the corpus object - Required field.
     * @param   ids            String JSON array of concept and/or document ids - Required field.
     * @param   conceptFields  RequestedFields concept_fields - Additional fields to be included in the concept objects.
     * @param   documentFields RequestedFields document_fields - Additional fields to be included in the document objects.
     * @param   cursor         Integer cursor - A number of items to skip.
     * @param   limit          Integer limit - The maximum number of concepts to be returned.
     * @return {@link QueryConcepts}
     */
    public QueryConcepts conceptualSearch(Corpus corpus, List<String> ids, RequestedFields conceptFields, RequestedFields documentFields, int cursor, int limit) {
        ConceptInsightsId.validateGenarate(corpus, getAccountId());
        Validate.notNull(ids, "ids can't be null");
        Map<String, Object> queryParams = new HashMap<String, Object>();
        if (cursor >= 0) {
            queryParams.put(CURSOR, cursor);
        }
        if (limit >= 0) {
            queryParams.put(LIMIT, limit);
        }
        JsonArray IdsJsonArray = new JsonArray();
        for (String value : ids) {
            IdsJsonArray.add(new JsonPrimitive(value));
        }
        queryParams.put(IDS, IdsJsonArray.toString());
        if (conceptFields != null) {
            if (conceptFields != null && conceptFields.getFields() != null && !conceptFields.getFields().isEmpty())
                queryParams.put(CONCEPT_FIELDS, conceptFields.toString());
        }

        if (documentFields != null) {
            if (documentFields != null && documentFields.getFields() != null && !documentFields.getFields().isEmpty())
                queryParams.put(DOCUMENT_FIELDS, documentFields.toString());
        }

        return executeRequest(version + corpus.getId() + CONCEPTUAL_SEARCH_PATH, queryParams, QueryConcepts.class);
    }

    /**
     * Creates an empty corpus.
     *
     * @param corpus    Corpus the corpus object.
     */
    public void createCorpus(Corpus corpus) {
        ConceptInsightsId.validateGenarate(corpus, getAccountId());
        HttpRequestBase request = Request.Put(version + corpus.getId())
                .withContent(GsonSingleton.getGson().toJson(corpus), MediaType.APPLICATION_JSON).build();
        executeWithoutResponse(request);
    }

    /**
     * Creates a document in a given corpus.
     *
     * @param corpusName String the corpus name.
     * @param document   {@link Document} The document to create.
     */
    public void createDocument(final Document document, final String corpusName) {
        ConceptInsightsId.validateGenarate(document, getAccountId(), corpusName);
        HttpRequestBase request = Request
                .Put(version + document.getId())
                .withContent(GsonSingleton.getGson().toJson(document), MediaType.APPLICATION_JSON)
                .build();

        executeWithoutResponse(request);
    }

    /**
     * Deletes a corpus by ID.
     *
     * @param corpus    Corpus the corpus object.
     */
    public void deleteCorpus(Corpus corpus) {
        ConceptInsightsId.validateGenarate(corpus, getAccountId());
        HttpRequestBase request = Request.Delete(version + corpus.getId()).build();
        executeWithoutResponse(request);
    }

    /**
     * Deletes a document in a given corpus.
     *
     * @param corpusName   String the corpus name.
     * @param document     Document the document.
     */

    public void deleteDocument(String corpusName,Document document) {
        ConceptInsightsId.validateGenarate(document, getAccountId(), corpusName);
        HttpRequestBase request = Request.Delete(version + document.getId())
                .build();
        executeWithoutResponse(request);
    }

    /**
     * Retrieves the account identifiers.
     *
     * @return the {@link Accounts}
     */
    public Accounts getAccountsInfo() {
        return executeRequest(ACCOUNTS_PATH, null, Accounts.class);
    }

    /**
     * Returns information for a specific concept node in a graph.
     *
     * @param concept  Concept the concept object.
     * @param graphName String the graph name.
     * @return {@link ConceptMetadata}
     */
    public ConceptMetadata getConcept(Concept concept,String graphName) {
        ConceptInsightsId.validateGenarate(concept, getAccountId(), graphName);
        return executeRequest(version + concept.getId(), null, ConceptMetadata.class);
    }

    /**
     * Retrieves corpus object to a list of individual concepts.
     *
     * @param corpus Corpus the corpus object.
     * @return the Corpus
     */
    public Corpus getCorpus(Corpus corpus) {
        ConceptInsightsId.validateGenarate(corpus, getAccountId());
        return executeRequest(version + corpus.getId(), null, Corpus.class);
    }

    /**
     * Gets processing state of a Corpus.
     *
     * @param corpus Corpus the corpus object.
     * @return {@link CorpusProcessingState} The processing state of a given corpus.
     */
    public CorpusProcessingState getCorpusProcessingState(Corpus corpus) {
        ConceptInsightsId.validateGenarate(corpus, getAccountId());
        return executeRequest(version + corpus.getId() + PROCESSING_STATE_PATH, null, CorpusProcessingState.class);
    }

    /**
     * Retrieves concepts that are related to an entire corpus.
     *
     * @param   corpus         The corpus object - Required field.
     * @param   conceptFields  RequestedFields concept_fields - Additional fields to be included in the concept objects.
     * @param   level          Integer level - A number in the range 0 - 3 that represents the level of popularity of related concepts.
     * @param   limit          Integer limit - The maximum number of concepts to be returned.
     * @return {@link Concepts}
     */
    public Concepts getCorpusRelatedConcepts(Corpus corpus, RequestedFields conceptFields, int level, int limit) {
        ConceptInsightsId.validateGenarate(corpus, getAccountId());
        Map<String, Object> queryParameters = new HashMap<String, Object>();
        if (level >= 0) {
            queryParameters.put(LEVEL, level);
        }
        if (limit >= 0) {
            queryParameters.put(LIMIT, limit);
        }
        if (conceptFields != null) {
            if (conceptFields != null && conceptFields.getFields() != null && !conceptFields.getFields().isEmpty())
                queryParameters.put(CONCEPT_FIELDS, conceptFields.toString());
        }
        return executeRequest(version + corpus.getId() + RELATED_CONCEPTS_PATH, queryParameters, Concepts.class);
    }

    /**
     * Returns a list of scores that denotes how related an entire corpus is to a list of individual concepts.
     *
     * @param corpus The corpus object
     * @param concepts Array of concept IDs, each identifying a concept
     * @return {@link Scores}
     */
    public Scores getCorpusRelationScores(Corpus corpus,List<String> concepts) {
        ConceptInsightsId.validateGenarate(corpus, getAccountId());
        Validate.notNull(concepts, "concepts can't be null");

        Map<String, Object> queryParameters = new HashMap<String, Object>();
        JsonObject contentJson = new JsonObject();
        JsonArray conceptsJson = new JsonArray();
        for (String value : concepts) {
            conceptsJson.add(new JsonPrimitive(value));
        }
        contentJson.add(CONCEPTS, conceptsJson);
        queryParameters.put(CONCEPTS, conceptsJson.toString());
        return executeRequest(version + corpus.getId() + RELATION_SCORES_PATH, queryParameters, Scores.class);
    }

    /**
     * Gets processing state of a Corpus.
     *
     * @param corpus The corpus object
     * @return the {@link CorpusStats}
     */
    public CorpusStats getCorpusStats(Corpus corpus) {
        ConceptInsightsId.validateGenarate(corpus, getAccountId());
        return executeRequest(version + corpus.getId() + STATS_PATH, null, CorpusStats.class);
    }

    /**
     * Retrieves a document from a corpus.
     *
     * @param document    Document the document object,
     * @param corpusName   String the corpus name.
     * @return {@link Document}
     */
    public Document getDocument(Document document,String corpusName) {
        ConceptInsightsId.validateGenarate(document, getAccountId(), corpusName);
        return executeRequest(version + document.getId(), null, Document.class);
    }

    /**
     * Retrieves conceptual view of document (including annotations).
     *
     * @param document    Document the document object,
     * @param corpusName   String the corpus name.
     * @return {@link DocumentAnnotations}
     */
    public DocumentAnnotations getDocumentAnnotations(Document document,String corpusName) {
        ConceptInsightsId.validateGenarate(document, getAccountId(), corpusName);
        return executeRequest(version + document.getId() + ANNOTATIONS_PATH, null, DocumentAnnotations.class);
    }

    /**
     * Retrieves processing state of document.
     *
     * @param document    Document the document object,
     * @param corpusName   String the corpus name.
     * @return {@link DocumentProcessingStatus}
     */
    public DocumentProcessingStatus getDocumentProcessingState(final Document document, final String corpusName) {
        ConceptInsightsId.validateGenarate(document, getAccountId(), corpusName);
        return executeRequest(version + document.getId() + PROCESSING_STATE_PATH, null, DocumentProcessingStatus.class);
    }

    /**
     * Retrieves concepts that are related (in conceptual sense) to a given document.
     *
     * @param   document       Document the document object,
     * @param   corpusName     String the corpus name.
     * @param   conceptFields  RequestedFields concept_fields - Additional fields to be included in the concept objects.
     * @param   level          Integer level - A number in the range 0 - 3 that represents the level of popularity of related concepts.
     * @param   limit          Integer limit - The maximum number of concepts to be returned.
     * @return {@link Concepts}
     */
    public Concepts getDocumentRelatedConcepts(Document document,String corpusName, RequestedFields conceptFields, int level, int limit) {
        ConceptInsightsId.validateGenarate(document, getAccountId(), corpusName);
        Map<String, Object> queryParams = new HashMap<String, Object>();
        if (level >= 0) {
            queryParams.put(LEVEL, level);
        }
        if (limit >= 0) {
            queryParams.put(LIMIT, limit);
        }
        if (conceptFields != null) {
            if (conceptFields != null && conceptFields.getFields() != null && !conceptFields.getFields().isEmpty())
                queryParams.put(CONCEPT_FIELDS, conceptFields.toString());
        }
        return executeRequest(version + document.getId() + RELATED_CONCEPTS_PATH, queryParams, Concepts.class);
    }

    /**
     * Retrieves concepts that are related (in conceptual sense) to a given document.
     *
     * @param document     Document the document object,
     * @param corpusName   String the corpus name.
     * @param corpusName   Array of concept IDs, each identifying a concept.
     * @return {@link Scores}
     */
    public Scores getDocumentRelationScores(Document document,String corpusName,List<String> concepts) {
        ConceptInsightsId.validateGenarate(document, getAccountId(), corpusName);
        Validate.notNull(concepts, "concepts can't be null");

        Map<String, Object> queryParams = new HashMap<String, Object>();
        JsonObject contentJson = new JsonObject();
        JsonArray conceptsJson = new JsonArray();

        for (String value : concepts) {
            conceptsJson.add(new JsonPrimitive(value));
        }
        contentJson.add(CONCEPTS, conceptsJson);
        queryParams.put(CONCEPTS, conceptsJson.toString());
        return executeRequest(version + document.getId() + RELATION_SCORES_PATH, queryParams, Scores.class);
    }

    /**
     * Searches for graph concepts by using partial matches.
     * @param   graphName      String the graph name.
     * @param   concepts       List&lt;String&gt; concepts - Array of concept IDs, each identifying a concept.
     * @param   conceptName        String the concept name.
     * @param   conceptFields  RequestedFields concept_fields - Additional fields to be included in the concept objects.
     * @param   level          Integer level - A number in the range 0 - 3 that represents the level of popularity of related concepts.
     * @param   limit          Integer limit - The maximum number of concepts to be returned.
     * @return {@link Concepts}
     */
    public Concepts getGraphsRelatedConcepts(String graphName, List<String> concepts, String conceptName, RequestedFields conceptFields, int level, int limit) {
        //TODO: we may need to divide this into 2 methods
        Validate.notNull(graphName, "graphName can't be null");
        if (concepts == null && conceptName == null)
            throw new MissingFormatArgumentException("conceptName or concepts should be identified");

        Graph graph = new Graph(getAccountId(), graphName);
        Map<String, Object> queryParameters = new HashMap<String, Object>();
        if (level >= 0) {
            queryParameters.put(LEVEL, level);
        }
        if (limit >= 0) {
            queryParameters.put(LIMIT, limit);
        }
        if (conceptFields != null) {
            if (conceptFields != null && conceptFields.getFields() != null && !conceptFields.getFields().isEmpty())
                queryParameters.put(CONCEPT_FIELDS, conceptFields);
        }
        if (concepts != null) {
            JsonObject contentJson = new JsonObject();
            JsonArray conceptsJson = new JsonArray();
            for (String value : concepts) {
                conceptsJson.add(new JsonPrimitive(value));
            }
            contentJson.add(CONCEPTS, conceptsJson);
            queryParameters.put(CONCEPTS, conceptsJson.toString());

            return executeRequest(version + graph.getId() + RELATED_CONCEPTS_PATH, queryParameters, Concepts.class);
        } else {
            Concept concept = new Concept(graph, conceptName);
            return executeRequest(version + concept.getId() + RELATED_CONCEPTS_PATH, queryParameters, Concepts.class);
        }
    }

    /**
     * Returns a list of scores that denotes how related a source concept is
     * to a list of individual concepts.
     *
     * @param concept     Concept the concept object,
     * @param graphName   String the graph name.
     * @param concepts    Array of concept IDs, each identifying a concept.
     *
     * @return {@link Scores}
     */
    public Scores getGraphsRelationScores(Concept concept,String graphName, List<String> concepts) {
        ConceptInsightsId.validateGenarate(concept, getAccountId(), graphName);
        Validate.notNull(concepts, "concepts can't be null");

        Map<String, Object> queryParameters = new HashMap<String, Object>();
        JsonObject contentJson = new JsonObject();
        JsonArray conceptsJson = new JsonArray();

        for (String value : concepts) {
            conceptsJson.add(new JsonPrimitive(value));
        }
        contentJson.add(CONCEPTS, conceptsJson);
        queryParameters.put(CONCEPTS, conceptsJson.toString());

        return executeRequest(version + concept.getId() + RELATION_SCORES_PATH, queryParameters, Scores.class);
    }

    /**
     * Retrieves the available corpus objects.
     *
     * @return {@link Corpora}
     */
    public Corpora listCorpora() {
        return executeRequest(CORPORA_PATH, null, Corpora.class);
    }

    /**
     * Retrieves the available corpus objects associated with an account identifier.
     *
     * @param accountId The account identifier.
     * @return {@link Corpora}
     */
    public Corpora listCorpora(String accountId) {
        Validate.notNull(accountId, "account_id can't be null");
        return executeRequest(CORPORA_PATH + FORWARD_SLASH + accountId, null, Corpora.class);
    }

    /**
     * Retrieves the document ids of a corpus.
     *
     * @param corpus Corpus the corpus object.
     * @param query  String query - For query syntax see <a href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/concept_insights.html">API Explorer</a>.<br> JSON object that allows to filter the list of documents.
     * Valid values are {"status":"error"}, {"status":"processing"},
     * and {"status":"ready"} which allow to filter documents by status.
     * @param limit  int limit - - The number of possible concepts to return.
     * @param cursor int cursor -  The number of possible items to return. Specify '0' to return the maximum value of 100,000...
     * @return {@link Documents}
     */
    public Documents listDocuments(Corpus corpus, String query, int limit, int cursor) {
        ConceptInsightsId.validateGenarate(corpus, getAccountId());
        Map<String, Object> queryParameters = new HashMap<String, Object>();
        if (cursor >= 0) {
            queryParameters.put(CURSOR, cursor);
        }
        if (limit >= 0) {
            queryParameters.put(LIMIT, limit);
        }
        if (query != null) {
            // TODO we may need to work in the query format,for now we do expect 
            // the query parameter String formatted as documented in Concept Insights.
            queryParameters.put(QUERY, query);
        }

        return executeRequest(version + corpus.getId() + DOCUMENTS, queryParameters, Documents.class);
    }

    /**
     * Retrieves the available {@link Graphs}.
     *
     * @return the {@link Graphs}
     */
    public Graphs listGraphs() {
        return executeRequest(GRAPHS_PATH, null, Graphs.class);
    }

    /**
     * Searches for documents and concepts by using partial matches on the label(s) fields.
     * @param corpus         Graph - the graph object is a required field.
     * @param query          String query - The query string is a required field.
     * @param conceptFields  RequestedFields concept_fields - Additional fields to be included in the concept objects.
     * @param documentFields RequestedFields document_fields - Additional fields to be included in the document objects.
     * @param concepts       boolean concepts - Whether to return concepts that have a label match..
     * @param prefix         boolean prefix - Whether the query string should be treated as a prefix.
     * @param limit          int limit - The maximum number of items to be returned.
     * @return {@link Matches}
     */
    public Matches searchCorpusByLabel(Corpus corpus, String query, RequestedFields conceptFields, RequestedFields documentFields, boolean concepts, boolean prefix, int limit) {
        ConceptInsightsId.validateGenarate(corpus, getAccountId());
        Validate.notNull(query, "query can't be null");

        Map<String, Object> queryParameters = new HashMap<String, Object>();
        queryParameters.put(QUERY, query);
        String[] queryParams = new String[]{QUERY, PREFIX, LIMIT, CONCEPTS};
        if (prefix) {
            queryParameters.put(PREFIX, prefix);
        }
        if (limit >= 0) {
            queryParameters.put(LIMIT, limit);
        }
        if (concepts) {
            queryParameters.put(CONCEPTS, concepts);
        }
        if (conceptFields != null) {
            if (conceptFields != null && conceptFields.getFields() != null && !conceptFields.getFields().isEmpty())
                queryParameters.put(CONCEPT_FIELDS, conceptFields.toString());
        }
        if (documentFields != null) {
            if (documentFields != null && documentFields.getFields() != null && !documentFields.getFields().isEmpty())
                queryParameters.put(DOCUMENT_FIELDS, documentFields.toString());
        }
        return executeRequest(version + corpus.getId() + LABEL_SEARCH_PATH, queryParameters, Matches.class);
    }

    /**
     * Searches for graph concepts by using partial matches.<br>
     *
     * @param graph         Graph - the graph object is a required field.
     * @param query         String query - The query string is a required field.
     * @param prefix        boolean prefix - Whether the query string should be treated as a prefix.
     * @param limit         int limit - The maximum number of items to be returned.
     * @param conceptFields RequestedFields concept_fields - An additional fields to include in the concept objects.
     * @return {@link Matches}
     */
    public Matches searchGraphsConceptByLabel(Graph graph, String query, boolean prefix, int limit, RequestedFields conceptFields) {
        ConceptInsightsId.validateGenarate(graph, getAccountId());
        Validate.notNull(query, "query can't be null");

        Map<String, Object> queryParameters = new HashMap<String, Object>();
        queryParameters.put(QUERY, query);
        if (prefix) {
            queryParameters.put(PREFIX, prefix);
        }
        if (limit >= 0) {
            queryParameters.put(LIMIT, limit);
        }

        if (conceptFields != null) {
            if (conceptFields != null && conceptFields.getFields() != null && !conceptFields.getFields().isEmpty())
                queryParameters.put(CONCEPT_FIELDS, conceptFields.toString());
        }
        return executeRequest(version + graph.getId() + LABEL_SEARCH_PATH, queryParameters, Matches.class);
    }

    /**
     * Updates existing corpus meta-data (access and permissions).
     *
     * @param corpus    {@link Corpus} the corpus to update.
     */
    public void updateCorpus(Corpus corpus) {
        ConceptInsightsId.validateGenarate(corpus, getAccountId());
        HttpRequestBase request = Request.Post(version + corpus.getId())
                .withContent(GsonSingleton.getGson().toJson(corpus), MediaType.APPLICATION_JSON).build();
        executeWithoutResponse(request);
    }

    /**
     * Updates a document in a given corpus.
     *
     * @param document   Document the document object,
     * @param corpusName String the corpus name.
     * @param document   {@link Document} The document to update.
     */
    public void updateDocument(Document document,String corpusName) {
        ConceptInsightsId.validateGenarate(document, getAccountId(), corpusName);
        HttpRequestBase request = Request.Post(version + document.getId())
                .withContent(GsonSingleton.getGson().toJson(document), MediaType.APPLICATION_JSON)
                .build();
        executeWithoutResponse(request);
    }

    /**
     * Execute the request and return the POJO that represent the response.
     *
     * @param <T>             The POJO that represents the response object
     * @param resourcePath    the resource path
     * @param params          the request parameters
     * @param returnType      the POJO class to be parsed from the response
     * @return the POJO object that represent the response
     */
    private <T> T executeRequest(String resourcePath, Map<String, Object> params, Class<T> returnType) {
        Request request = Request.Get(resourcePath);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                request.withQuery(entry.getKey(), entry.getValue());
            }
        }
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            return ResponseUtil.getObject(response, returnType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

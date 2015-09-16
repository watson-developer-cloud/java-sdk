/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
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
     * The ACCOUNTS_PATH. (value is "/v2/accounts")
     */
    private static final String ACCOUNTS_PATH = "/v2/accounts";

    /**
     * The Constant ANNOTATE_TEXT_PATH. (value is "annotate_text")
     */
    private static final String ANNOTATE_TEXT_PATH = "annotate_text";

    /**
     * The ANNOTATIONS_PATH. (value is "annotations")
     */
    private static final String ANNOTATIONS_PATH = "annotations";

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
    private static final String CONCEPTUAL_SEARCH_PATH = "conceptual_search";

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
     * The Constant IDS. (value is "ids")
     */
    public static final String IDS = "ids";

    /**
     * The LABEL_SEARCH_PATH. (value is "label_search")
     */
    private static final String LABEL_SEARCH_PATH = "label_search";

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
    private static final String PROCESSING_STATE_PATH = "processing_state";

    /**
     * The Constant query. (value is "query")
     */
    public static final String QUERY = "query";

    /**
     * The RELATED_CONCEPTS_PATH. (value is "related_concepts")
     */
    private static final String RELATED_CONCEPTS_PATH = "related_concepts";

    /**
     * The Constant RELATION_SCORES_PATH. (value is "graph")
     */
    private static final String RELATION_SCORES_PATH = "relation_scores";

    /**
     * The Constant STATS_PATH. (value is "stats")
     */
    private static final String STATS_PATH = "stats";

    /**
     * The Constant TEXT. (value is "text")
     */
    public static final String TEXT = "text";

    /**
     * The service url.
     * (value is "https://gateway.watsonplatform.net/concept-insights/api")
     */
    private static final String URL = "https://gateway.watsonplatform.net/concept-insights/api";

    /**
     * Creates the concept id path.
     *
     * @param accountId the account id
     * @param graph     the graph
     * @param concept   the concept
     * @return the string
     */
    private static String createConceptIdPath(final String accountId, final String graph, final String concept) {
        return String.format("%s/%s/%s/%s/%s/", GRAPHS_PATH, accountId, graph, CONCEPTS, concept);
    }

    /**
     * Creates the corpus id path.
     *
     * @param accountId the account id
     * @param corpus    the corpus
     * @return the string
     */
    private static String createCorpusIdPath(final String accountId, final String corpus) {
        return String.format("%s/%s/%s/", CORPORA_PATH, accountId, corpus);
    }

    /**
     * Creates the document id path.
     *
     * @param accountId the account id
     * @param corpus    the corpus
     * @param document  the document
     * @return the string
     */
    private static String createDocumentIdPath(final String accountId, final String corpus, final String document) {
        return String.format("%s/%s/%s/%s/%s/", CORPORA_PATH, accountId, corpus, DOCUMENTS, document);
    }

    /**
     * Creates the graph id path.
     *
     * @param accountId the account id
     * @param graph     the graph
     * @return the string
     */
    private static String createGraphIdPath(final String accountId, final String graph) {
        return String.format("%s/%s/%s/", GRAPHS_PATH, accountId, graph);
    }

    /**
     * Instantiates a new Concept Insights service.
     */
    public ConceptInsights() {
        setEndPoint(URL);
    }

    /**
     * Identifies concepts in a piece of text.
     *
     * @param parameters The parameters to be used in the service call, account_id,
     * graph and text are required.
     * <ul>
     * <li> String account_id - The account identifier.<br>
     * <li> String graph - The graph name.<br>
     * <li> String text - The text to annotate.<br>
     * </ul>
     * @return {@link Annotations}
     */
    public Annotations annotateText(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(GRAPH), "graph can't be null");
        Validate.notNull(parameters.get(TEXT), "text can't be null");
        String graphId = createGraphIdPath((String) parameters.get(ACCOUNT_ID), (String) parameters.get(GRAPH));

        HttpRequestBase request = Request.Post(graphId + ANNOTATE_TEXT_PATH)
                .withContent((String) parameters.get(TEXT), MediaType.TEXT_PLAIN)
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
	 * @param parameters The parameters to be used in the service call, account_id,
	 * corpus and ids are required.
	 * <ul>
	 * <li> String account_id - The account identifier.<br>
	 * <li> String corpus - The corpus name.<br>
     * <li> RequestedFields concept_fields - Additional fields to be included in the concept objects.<br>
     * <li> RequestedFields document_fields - Additional fields to be included in the document objects.<br>
     * <li> String ids - JSON array of concept and/or document ids.<br>
     * <li> Integer cursor - A number of items to skip.<br>
     * <li> Integer limit - The maximum number of concepts to be returned.<br>
   	 * </ul>
	 *
     * @return {@link QueryConcepts}
     */
    public QueryConcepts conceptualSearch(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(CORPUS), "corpus can't be null");
        Validate.notNull(parameters.get(IDS), "ids can't be null");

        String corpusId = createCorpusIdPath((String) parameters.get(ACCOUNT_ID), (String) parameters.get(CORPUS));
        Map<String,Object> queryParams = new HashMap<String, Object>();
        String[] queryParameters = new String[]{CURSOR, LIMIT};

        for (String param : queryParameters) {
            if (parameters.containsKey(param))
              queryParams.put(param, parameters.get(param));
        }

        JsonArray IdsJsonArray = new JsonArray();
        @SuppressWarnings("unchecked")
		List<String> ids = (List<String>) parameters.get(IDS);
		for (String value : ids) {
            IdsJsonArray.add(new JsonPrimitive(value));
        }
        queryParams.put(IDS, IdsJsonArray.toString());


        if (parameters.get(CONCEPT_FIELDS) != null) {
            RequestedFields fields = (RequestedFields) parameters.get(CONCEPT_FIELDS);
            if (fields != null && fields.getFields() != null && !fields.getFields().isEmpty())
                queryParams.put(CONCEPT_FIELDS, fields.toString());
        }

        if (parameters.get(DOCUMENT_FIELDS) != null) {
            RequestedFields fields = (RequestedFields) parameters.get(DOCUMENT_FIELDS);
            if (fields != null && fields.getFields() != null && !fields.getFields().isEmpty())
                queryParams.put(DOCUMENT_FIELDS, fields.toString());
        }

        return executeRequest(corpusId + CONCEPTUAL_SEARCH_PATH,queryParams,QueryConcepts.class);
    }

    /**
     * Creates an empty corpus.
     *
     * @param accountId String the Account identifier,
     * @param corpus    String the corpus name.
     */
    public void createCorpus(final String accountId, final Corpus corpus) {
        Validate.notNull(accountId, "account_id can't be null");
        Validate.notNull(corpus, "corpus can't be null");
        Validate.notNull(corpus.getId(), "corpus.id can't be null");

        HttpRequestBase request = Request.Put(createCorpusIdPath(accountId, corpus.getId()))
                .withContent(GsonSingleton.getGson().toJson(corpus), MediaType.APPLICATION_JSON).build();
        executeWithoutResponse(request);
    }

    /**
     * Creates a document in a given corpus.
     *
     * @param accountId  String the account identifier,
     * @param corpusName String the corpus name.
     * @param document   {@link Document} The document to create.
     */
    public void createDocument(final String accountId, final String corpusName, final Document document) {
        Validate.notNull(accountId, "accountId can't be null");
        Validate.notNull(corpusName, "corpusName can't be null");
        Validate.notNull(document, "document can't be null");
        Validate.notNull(document.getId(), "document.id can't be null");

        HttpRequestBase request = Request
                .Put(createDocumentIdPath(accountId, corpusName, document.getId()))
                .withContent(GsonSingleton.getGson().toJson(document), MediaType.APPLICATION_JSON)
                .build();

        executeWithoutResponse(request);
    }

    /**
     * Deletes a corpus by ID.
     *
     * @param accountId  String the Account identifier.
     * @param corpusName String the corpus name.
     */
    public void deleteCorpus(final String accountId, final String corpusName) {
        Validate.notNull(accountId, "accountId can't be null");
        Validate.notNull(corpusName, "corpusName can't be null");
        HttpRequestBase request = Request.Delete(createCorpusIdPath(accountId, corpusName)).build();
        executeWithoutResponse(request);
    }

    /**
     * Deletes a document in a given corpus.
     *
     * @param accountId    String the account identifier,
     * @param corpusName   String the corpus name.
     * @param documentName String the document name.
     */

    public void deleteDocument(final String accountId, final String corpusName, final String documentName) {
        Validate.notNull(accountId, "accountId can't be null");
        Validate.notNull(corpusName, "corpusName can't be null");
        Validate.notNull(documentName, "documentName can't be null");
        HttpRequestBase request = Request.Delete(createDocumentIdPath(accountId, corpusName, documentName))
                .build();
        executeWithoutResponse(request);
    }

    /**
     * Retrieves the account identifiers.
     *
     * @return the {@link Accounts}
     */
    public Accounts getAccountsInfo() {
       return executeRequest(ACCOUNTS_PATH,null,Accounts.class);
    }

    /**
     * Returns information for a specific concept node in a graph.
     *
     * @param parameters The parameters to be used in the service call, account_id,
     * graph and concept are required.
     * <ul>
     * <li> String account_id - The account identifier.<br>
     * <li> String graph - The graph name.<br>
     * <li> String concept - The concept name.<br>
     * </ul>
     * @return {@link ConceptMetadata}
     */
    public ConceptMetadata getConcept(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(GRAPH), "graph can't be null");
        Validate.notNull(parameters.get(CONCEPT), "concept can't be null");
        String conceptId = createConceptIdPath((String) parameters.get(ACCOUNT_ID), (String) parameters.get(GRAPH), (String) parameters.get(CONCEPT));
        return executeRequest(conceptId,null,ConceptMetadata.class);
    }

    /**
     * Retrieves corpus object to a list of individual concepts.
     *
     * @param accountId  String the Account identifier.
     * @param corpusName String the corpus name.
     * @return the Corpus
     */
    public Corpus getCorpus(final String accountId, final String corpusName) {
        Validate.notNull(accountId, "accountId can't be null");
        Validate.notNull(corpusName, "corpusName can't be null");
        return executeRequest(createCorpusIdPath(accountId, corpusName),null,Corpus.class);
    }

    /**
     * Gets processing state of a Corpus.
     *
     * @param accountId  String the account identifier,
     * @param corpusName String the corpus name.
     * @return {@link CorpusProcessingState} The processing state of a given corpus.
     */
    public CorpusProcessingState getCorpusProcessingState(final String accountId, final String corpusName) {
        Validate.notNull(accountId, "accountId can't be null");
        Validate.notNull(corpusName, "corpusName can't be null");
        return executeRequest(createCorpusIdPath(accountId, corpusName) + PROCESSING_STATE_PATH,null,CorpusProcessingState.class);
    }

    /**
     * Retrieves concepts that are related to an entire corpus.
     *
	 * @param parameters The parameters to be used in the service call, account_id,
	 * corpus and concepts are required.
	 * <ul>
	 * <li> String account_id - The account identifier.<br>
	 * <li> String corpus - The corpus name.<br>
     * <li> RequestedFields concept_fields - Additional fields to be included in the concept objects.<br>
     * <li> Integer level - A number in the range 0 - 3 that represents the level of popularity of related concepts.<br>
     * <li> Integer limit - The maximum number of concepts to be returned.<br>
  	 * </ul>
	 *
     * @return {@link Concepts}
     */
    public Concepts getCorpusRelatedConcepts(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(CORPUS), "corpus can't be null");

        String corpusId = createCorpusIdPath((String) parameters.get(ACCOUNT_ID), (String) parameters.get(CORPUS));

        Map<String, Object> queryParameters = new HashMap<String, Object>();
        String[] params = new String[]{LEVEL, LIMIT};
        for (String param : params) {
            if (parameters.containsKey(param))
                queryParameters.put(param, parameters.get(param));
        }
        if (parameters.get(CONCEPT_FIELDS) != null) {
            RequestedFields fields = (RequestedFields) parameters.get(CONCEPT_FIELDS);
            if (fields != null && fields.getFields() != null && !fields.getFields().isEmpty())
                queryParameters.put(CONCEPT_FIELDS, fields.toString());
        }
        return executeRequest(corpusId + RELATED_CONCEPTS_PATH, queryParameters, Concepts.class);
    }

    /**
     * Returns a list of scores that denotes how related an entire corpus is to a list of individual concepts.
     *
	 * @param parameters The parameters to be used in the service call, account_id,
	 * corpus and concepts are required.
	 * <ul>
	 * <li> String account_id - The account identifier.<br>
	 * <li> String corpus - The corpus name.<br>
 	 * <li> List&lt;String&gt; concepts - Array of concept IDs, each identifying a concept.<br>
  	 * </ul>
	 *
     * @return {@link Scores}
     */
    public Scores getCorpusRelationScores(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(CORPUS), "corpus can't be null");
        Validate.notNull(parameters.get(CONCEPTS), "concepts can't be null");

        String corpusId = createCorpusIdPath((String) parameters.get(ACCOUNT_ID), (String) parameters.get(CORPUS));

        Map<String, Object> queryParameters = new HashMap<String, Object>();
        JsonObject contentJson = new JsonObject();
        JsonArray conceptsJson = new JsonArray();
        @SuppressWarnings("unchecked")
        List<String> concepts = (List<String>) parameters.get(CONCEPTS);
        for (String value : concepts) {
            conceptsJson.add(new JsonPrimitive(value));
        }
        contentJson.add(CONCEPTS, conceptsJson);
        queryParameters.put(CONCEPTS, conceptsJson.toString());
        return executeRequest(corpusId + RELATION_SCORES_PATH, queryParameters, Scores.class);
    }

    /**
     * Gets processing state of a Corpus.
     *
     * @param accountId  String the account identifier,
     * @param corpusName String the corpus name.
     * @return the {@link CorpusStats}
     */
    public CorpusStats getCorpusStats(final String accountId, final String corpusName) {
        Validate.notNull(accountId, "accountId can't be null");
        Validate.notNull(corpusName, "corpusName can't be null");
        return executeRequest(createCorpusIdPath(accountId, corpusName) + STATS_PATH,null,CorpusStats.class);
    }

    /**
     * Retrieves a document from a corpus.
     *
     * @param accountId    String the account identifier,
     * @param corpusName   String the corpus name.
     * @param documentName String the document name.
     * @return {@link Document}
     */
    public Document getDocument(final String accountId, final String corpusName, final String documentName) {
        Validate.notNull(accountId, "accountId can't be null");
        Validate.notNull(corpusName, "corpusName can't be null");
        Validate.notNull(documentName, "documentName can't be null");

        return executeRequest(createDocumentIdPath(accountId, corpusName, documentName),null,Document.class);
    }

    /**
     * Retrieves conceptual view of document (including annotations).
     *
     * @param accountId    String the account identifier,
     * @param corpusName   String the corpus name,
     * @param documentName String the document name.
     * @return {@link DocumentAnnotations}
     */
    public DocumentAnnotations getDocumentAnnotations(final String accountId, final String corpusName, final String documentName) {
        Validate.notNull(accountId, "accountId can't be null");
        Validate.notNull(corpusName, "corpusName can't be null");
        Validate.notNull(documentName, "documentName can't be null");

        String documentId = createDocumentIdPath(accountId, corpusName, documentName);
        return executeRequest(documentId + ANNOTATIONS_PATH,null,DocumentAnnotations.class);
    }

    /**
     * Retrieves processing state of document.
     *
     * @param accountId    String the account identifier,
     * @param corpusName   String the corpus name,
     * @param documentName String the document name.
     * @return {@link DocumentProcessingStatus}
     */
    public DocumentProcessingStatus getDocumentProcessingState(final String accountId, final String corpusName, final String documentName) {
        Validate.notNull(accountId, "accountId can't be null");
        Validate.notNull(corpusName, "corpusName can't be null");
        Validate.notNull(documentName, "documentName can't be null");

        String documentId = createDocumentIdPath(accountId, corpusName, documentName);
        return executeRequest(documentId + PROCESSING_STATE_PATH,null,DocumentProcessingStatus.class);
    }

    /**
     * Retrieves concepts that are related (in conceptual sense) to a given document.
     *
	 * @param parameters The parameters to be used in the service call, account_id,
	 * corpus, document are required.
	 * <ul>
	 * <li> String account_id - The account identifier.<br>
	 * <li> String corpus - The corpus name.<br>
	 * <li> String document - The document name.<br>
     * <li> Integer level - A number in the range 0 - 3 that represents the level of popularity of related concepts.<br>
     * <li> Integer limit - The maximum number of concepts to be returned.<br>
     * <li> RequestedFields concept_fields - Additional fields to be included in the concept objects.<br>
   	 * </ul>
	 *
     * @return {@link Concepts}
     */
    public Concepts getDocumentRelatedConcepts(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(CORPUS), "corpus can't be null");
        Validate.notNull(parameters.get(DOCUMENT), "document can't be null");

        String documentId = createDocumentIdPath((String) parameters.get(ACCOUNT_ID), (String) parameters.get(CORPUS), (String) parameters.get(DOCUMENT));

        String[] queryParameters = new String[]{LEVEL, LIMIT};
        Map<String, Object> queryParams = new HashMap<String, Object>();
        for (String param : queryParameters) {
            if (parameters.containsKey(param))
                queryParams.put(param, parameters.get(param));
        }
        if (parameters.get(CONCEPT_FIELDS) != null) {
            RequestedFields fields = (RequestedFields) parameters.get(CONCEPT_FIELDS);
            if (fields != null && fields.getFields() != null && !fields.getFields().isEmpty())
                queryParams.put(CONCEPT_FIELDS, fields.toString());
        }
        return executeRequest(documentId + RELATED_CONCEPTS_PATH, queryParams, Concepts.class);
    }

    /**
     * Retrieves concepts that are related (in conceptual sense) to a given document.
     *
	 * @param parameters The parameters to be used in the service call, account_id,
	 * corpus, document and concepts are required.
	 * <ul>
	 * <li> String account_id - The account identifier.<br>
	 * <li> String corpus - The corpus name.<br>
	 * <li> String document - The document name.<br>
 	 * <li> List&lt;String&gt; concepts - Array of concept IDs, each identifying a concept.<br>
	 * </ul>
	 *
     * @return {@link Scores}
     */
    public Scores getDocumentRelationScores(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(CORPUS), "corpus can't be null");
        Validate.notNull(parameters.get(DOCUMENT), "document can't be null");
        Validate.notNull(parameters.get(CONCEPTS), "concepts can't be null");

        String documentId = createDocumentIdPath((String) parameters.get(ACCOUNT_ID), (String) parameters.get(CORPUS), (String) parameters.get(DOCUMENT));

        Map<String, Object> queryParams = new HashMap<String, Object>();
        JsonObject contentJson = new JsonObject();
        JsonArray conceptsJson = new JsonArray();
        @SuppressWarnings("unchecked")
        List<String> list = (List<String>) parameters.get(CONCEPTS);
        for (String value : list) {
            conceptsJson.add(new JsonPrimitive(value));
        }
        contentJson.add(CONCEPTS, conceptsJson);
        queryParams.put(CONCEPTS, conceptsJson.toString());
        return executeRequest(documentId + RELATION_SCORES_PATH, queryParams, Scores.class);
    }

    /**
     * Searches for graph concepts by using partial matches.
     *
     * @param parameters The parameters to be used in the service call, account_id,
     * graph are required.
     * <ul>
     * <li> String account_id - The account identifier.<br>
     * <li> String graph - The graph name.<br>
     * <li> List&lt;String&gt; concepts - Array of concept IDs, each identifying a concept.<br>
     * <li> String concept - the concept name.<br>
     * <li> Integer level - A number in the range 0 - 3 that represents the level of popularity of related concepts.<br>
     * <li> Integer limit - The maximum number of concepts to be returned.<br>
     * </ul>
     * @return {@link Concepts}
     */
    public Concepts getGraphsRelatedConcepts(Map<String, Object> parameters) {
        //TODO: we may need to divide this into 2 methods
        Validate.notNull(parameters.get(ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(GRAPH), "graph can't be null");
        if (parameters.get(CONCEPTS) == null && parameters.get(CONCEPT) == null)
            throw new MissingFormatArgumentException("concept or concepts should be identified");

        String graphId = createGraphIdPath((String) parameters.get(ACCOUNT_ID), (String) parameters.get(GRAPH));
        Map<String, Object> queryParameters = new HashMap<String, Object>();
        String[] queryParms = new String[]{LEVEL, LIMIT};
        for (String param : queryParms) {
            if (parameters.containsKey(param))
                queryParameters.put(param, parameters.get(param));
        }
        if (parameters.get(CONCEPT_FIELDS) != null) {
            RequestedFields fields = (RequestedFields) parameters.get(CONCEPT_FIELDS);
            if (fields != null && fields.getFields() != null && !fields.getFields().isEmpty())
                queryParameters.put(CONCEPT_FIELDS, fields.toString());
        }
        if (parameters.get(CONCEPTS) != null) {
            JsonObject contentJson = new JsonObject();
            JsonArray conceptsJson = new JsonArray();
            @SuppressWarnings("unchecked")
			List<String> concepts = (List<String>) parameters.get(CONCEPTS);
			for (String value : concepts) {
                conceptsJson.add(new JsonPrimitive(value));
            }
            contentJson.add(CONCEPTS, conceptsJson);
            queryParameters.put(CONCEPTS, conceptsJson.toString());
            return executeRequest(graphId + RELATED_CONCEPTS_PATH, queryParameters, Concepts.class);
        } else {
            String conceptId = createConceptIdPath((String) parameters.get(ACCOUNT_ID), (String) parameters.get(GRAPH), (String) parameters.get(CONCEPT));
            return executeRequest(conceptId + RELATED_CONCEPTS_PATH, queryParameters, Concepts.class);
        }
    }

    /**
     * Returns a list of scores that denotes how related a source concept is
     * to a list of individual concepts.
     *
	 * @param parameters The parameters to be used in the service call, account_id,
	 * graph and concept or concepts are required.
	 * <ul>
	 * <li> String account_id - The account identifier.<br>
	 * <li> String graph - The graph name.<br>
	 * <li> String concept - The concept name.<br>
 	 * <li> List&lt;String&gt; concepts - Array of concept IDs, each identifying a concept.<br>
	 * </ul>
	 *
     * @return {@link Scores}
     */
    public Scores getGraphsRelationScores(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(GRAPH), "graph can't be null");
        Validate.notNull(parameters.get(CONCEPT), "concept can't be null");
        Validate.notNull(parameters.get(CONCEPTS), "concepts can't be null");

        String conceptId = createConceptIdPath((String) parameters.get(ACCOUNT_ID), (String) parameters.get(GRAPH), (String) parameters.get(CONCEPT));

        Map<String, Object> queryParameters = new HashMap<String, Object>();
        JsonObject contentJson = new JsonObject();
        JsonArray conceptsJson = new JsonArray();
        @SuppressWarnings("unchecked")
		List<String> concepts = (List<String>) parameters.get(CONCEPTS);
		for (String value : concepts) {
            conceptsJson.add(new JsonPrimitive(value));
        }
        contentJson.add(CONCEPTS, conceptsJson);
        queryParameters.put(CONCEPTS, conceptsJson.toString());

        return executeRequest(conceptId + RELATION_SCORES_PATH, queryParameters, Scores.class);
    }

    /**
     * Retrieves the available corpus objects.
     *
     * @return {@link Corpora}
     */
    public Corpora listCorpora() {
        return executeRequest(CORPORA_PATH,null,Corpora.class);
    }

    /**
     * Retrieves the available corpus objects associated with an account identifier.
     *
     * @param accountId The account identifier.
     * @return {@link Corpora}
     */
    public Corpora listCorpora(String accountId) {
        Validate.notNull(accountId, "account_id can't be null");
        return executeRequest(CORPORA_PATH + FORWARD_SLASH + accountId,null,Corpora.class);
    }

    /**
     * Retrieves the document ids of a corpus.
	 *
	 * @param parameters The parameters to be used in the service call, account_id,
	 * and corpus are required.
	 * <ul>
	 * <li> String account_id - The account identifier.<br>
	 * <li> String corpus - The corpus name.<br>
	 * <li> String concept - The concept name.<br>
	 * <li> String query - For query syntax see <a href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/concept_insights.html">API Explorer</a>.<br> JSON object that allows to filter the list of documents.
	 * Valid values are {"status":"error"}, {"status":"processing"},
	 * and {"status":"ready"} which allow to filter documents by status.<br>
	 * <li> Integer cursor - The number of possible items to return.
	 * Specify '0' to return the maximum value of 100,000...<br>
	 * <li> Integer limit - The number of possible concepts to return..<br>
	 * </ul>
	 * 
     * @return {@link Documents}
     */
    public Documents listDocuments(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(CORPUS), "corpus can't be null");
        Map<String, Object> queryParameters = new HashMap<String, Object>();
        String[] queryParams = new String[]{CURSOR, LIMIT};
        for (String param : queryParams) {
            if (parameters.containsKey(param)) {
                queryParameters.put(param, parameters.get(param));
            }
        }
        if (parameters.get(QUERY) != null) {
            // TODO we may need to work in the query format,for now we do expect 
        	// the query parameter String formatted as documented in Concept Insights.
            queryParameters.put(QUERY, parameters.get(QUERY));
        }

        return executeRequest(createCorpusIdPath((String) parameters.get(ACCOUNT_ID),
                (String) parameters.get(CORPUS)) + DOCUMENTS,queryParameters,Documents.class);
    }

    /**
     * Retrieves the available {@link Graphs}.
     *
     * @return the {@link Graphs}
     */
    public Graphs listGraphs() {
        return executeRequest(GRAPHS_PATH,null,Graphs.class);
    }

    /**
     * Searches for documents and concepts by using partial matches on the label(s) fields.
     *
	 * @param parameters The parameters to be used in the service call, account_id,
	 * corpus and query are required.
	 * <ul>
	 * <li> String account_id - The account identifier.<br>
	 * <li> String corpus - The corpus name.<br>
     * <li> RequestedFields concept_fields - Additional fields to be included in the concept objects.<br>
     * <li> RequestedFields document_fields - Additional fields to be included in the document objects.<br>
 	 * <li> Boolean concepts - Whether to return concepts that have a label match.<br>
 	 * <li> String query - The query string.<br>
	 * <li> Boolean prefix - Whether the query string should be treated as a prefix.<br>
     * <li> Integer limit - The maximum number of concepts to be returned.<br>
  	 * </ul>
	 *
     * @return {@link Matches}
     */
    public Matches searchCorpusByLabel(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(CORPUS), "corpus can't be null");
        Validate.notNull(parameters.get(QUERY), "query can't be null");

        String corpusId = createCorpusIdPath((String) parameters.get(ACCOUNT_ID), (String) parameters.get(CORPUS));

        Map<String, Object> queryParameters = new HashMap<String, Object>();
        String[] queryParams = new String[]{QUERY, PREFIX, LIMIT, CONCEPTS};
        for (String param : queryParams) {
            if (parameters.containsKey(param))
                queryParameters.put(param, parameters.get(param));
        }

        if (parameters.get(CONCEPT_FIELDS) != null) {
            RequestedFields fields = (RequestedFields) parameters.get(CONCEPT_FIELDS);
            if (fields != null && fields.getFields() != null && !fields.getFields().isEmpty())
                queryParameters.put(CONCEPT_FIELDS, fields.toString());
        }

        if (parameters.get(DOCUMENT_FIELDS) != null) {
            RequestedFields fields = (RequestedFields) parameters.get(DOCUMENT_FIELDS);
            if (fields != null && fields.getFields() != null && !fields.getFields().isEmpty())
                queryParameters.put(DOCUMENT_FIELDS, fields.toString());
        }
        return executeRequest(corpusId + LABEL_SEARCH_PATH, queryParameters, Matches.class);
    }

    /**
	 * Searches for graph concepts by using partial matches.<br>
     *
	 * @param parameters The parameters to be used in the service call, account_id,
	 * graph and query are required.
	 * <ul>
	 * <li> String account_id - The account identifier.<br>
	 * <li> String graph - The graph name.<br>
	 * <li> String query - The query string.<br>
	 * <li> Boolean prefix - Whether the query string should be treated as a prefix.<br>
	 * <li> Integer limit - The maximum number of items to be returned.<br>
	 * <li> RequestedFields concept_fields - An additional fields to include in the concept objects.<br>
	 * </ul>
	 * @return {@link Matches}
	 */
    public Matches searchGraphsConceptByLabel(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(GRAPH), "graph can't be null");
        Validate.notNull(parameters.get(QUERY), "query can't be null");

        String graph_id = createGraphIdPath((String) parameters.get(ACCOUNT_ID), (String) parameters.get(GRAPH));

        Map<String, Object> queryParameters = new HashMap<String, Object>();
        String[] params = new String[]{QUERY, PREFIX, LIMIT};
        for (String param : params) {
            if (parameters.containsKey(param)) {
                queryParameters.put(param, parameters.get(param));
            }
        }
        if (parameters.get(CONCEPT_FIELDS) != null) {
            RequestedFields fields = (RequestedFields) parameters.get(CONCEPT_FIELDS);
            if (fields != null && fields.getFields() != null && !fields.getFields().isEmpty())
                queryParameters.put(CONCEPT_FIELDS, fields.toString());
        }
        return executeRequest(graph_id + LABEL_SEARCH_PATH, queryParameters, Matches.class);
    }

    /**
     * Updates existing corpus meta-data (access and permissions).
     *
     * @param accountId String the Account identifier.
     * @param corpus    {@link Corpus} the corpus to update.
     */
    public void updateCorpus(final String accountId, final Corpus corpus) {
        Validate.notNull(accountId, "account_id can't be null");
        Validate.notNull(corpus, "corpus can't be null");
        Validate.notNull(corpus.getId(), "corpus.id can't be null");

        HttpRequestBase request = Request.Post(createCorpusIdPath(accountId, corpus.getId()))
                .withContent(GsonSingleton.getGson().toJson(corpus), MediaType.APPLICATION_JSON).build();
        executeWithoutResponse(request);
    }

    /**
     * Updates a document in a given corpus.
     *
     * @param accountId  String the account identifier,
     * @param corpusName String the corpus name.
     * @param document   {@link Document} The document to update.
     */
    public void updateDocument(final String accountId, final String corpusName, final Document document) {
        Validate.notNull(accountId, "accountId can't be null");
        Validate.notNull(corpusName, "corpusName can't be null");
        Validate.notNull(document, "document can't be null");
        Validate.notNull(document.getId(), "document.id can't be null");

        HttpRequestBase request = Request.Post(createDocumentIdPath(accountId, corpusName, document.getId()))
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
    private <T> T executeRequest(String resourcePath, Map<String, Object> params,  Class<T> returnType) {
        Request request = Request.Get(resourcePath);
        if(params!=null && !params.isEmpty()) {
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

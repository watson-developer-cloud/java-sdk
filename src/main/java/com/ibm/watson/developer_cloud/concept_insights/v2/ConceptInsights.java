/*
 * *
 *  * Copyright 2015 IBM Corp. All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.ibm.watson.developer_cloud.concept_insights.v2;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingFormatArgumentException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Accounts;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Annotations;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.ConceptMetaData;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Concepts;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Corpora;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Corpus;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.CorpusProcessingState;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.CorpusStats;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Document;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.DocumentAnnotations;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.DocumentProcessingState;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Documents;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Graphs;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Matches;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.QueryConcepts;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Scores;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.HttpHeaders;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.ibm.watson.developer_cloud.util.Validate;

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
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/concept_insights.html">
 *      Concept Insights</a>
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
     * @param graph the graph
     * @param concept the concept
     * @return the string
     */
    private static String createConceptIdPath(final String accountId, final String graph, final String concept) {
    	return String.format("%s/%s/%s/%s/%s/", GRAPHS_PATH, accountId, graph, CONCEPTS, concept);
    }
	
    /**
     * Creates the corpus id path.
     *
     * @param accountId the account id
     * @param corpus the corpus
     * @return the string
     */
    private static String createCorpusIdPath(final String accountId, final String corpus) {
    	return String.format("%s/%s/%s/", CORPORA_PATH, accountId, corpus);
    }

    /**
     * Creates the document id path.
     *
     * @param accountId the account id
     * @param corpus the corpus
     * @param document the document
     * @return the string
     */
    private static String createDocumentIdPath(final String accountId, final String corpus, final String document) {
    	return String.format("%s/%s/%s/%s/%s/", CORPORA_PATH, accountId, corpus, DOCUMENTS, document);
    }

	/**
     * Creates the graph id path.
     *
     * @param accountId the account id
     * @param graph the graph
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
     * <li> String concept_fields - Additional fields to be included in the concept objects.<br>
     * <li> String document_fields - Additional fields to be included in the document objects.<br>
     * <li> String ids - JSON array of concept and/or document ids.<br>
     * <li> Integer cursor - A number of items to skip.<br> 
     * <li> Integer limit - The maximum number of concepts to be returned.<br>
   	 * </ul>
	 * 
     * @return {@link QueryConcepts}
     */
    @SuppressWarnings("unchecked")
	public QueryConcepts conceptualSearch(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(CORPUS), "corpus can't be null");
        Validate.notNull(parameters.get(IDS), "ids can't be null");
        
        String corpusId = createCorpusIdPath((String) parameters.get(ACCOUNT_ID), (String) parameters.get(CORPUS));
        Request request = Request.Get(corpusId + CONCEPTUAL_SEARCH_PATH);
        String[] queryParameters = new String[]{ CURSOR, LIMIT};
        
        for (String param : queryParameters) {
            if (parameters.containsKey(param))
                request.withQuery(param, parameters.get(param));
        }
        
        JsonArray IdsJsonArray = new JsonArray();
        for (String value : (List<String>) parameters.get(IDS)) {
            IdsJsonArray.add(new JsonPrimitive(value));
        }
        
        request.withQuery(IDS, IdsJsonArray.toString());
        
        if (parameters.get(CONCEPT_FIELDS) != null) {
            JsonArray conceptFieldJsonArray = new JsonArray();
            for (String value : (List<String>) parameters.get(CONCEPT_FIELDS)) {
                conceptFieldJsonArray.add(new JsonPrimitive(value));
            }
            request.withQuery(CONCEPT_FIELDS, conceptFieldJsonArray.toString());
        }
        
        if (parameters.get(DOCUMENT_FIELDS) != null) {
            JsonArray documentFieldJsonJsonArray = new JsonArray();
            for (String value : (List<String>) parameters.get(DOCUMENT_FIELDS)) {
                documentFieldJsonJsonArray.add(new JsonPrimitive(value));
            }
            request.withQuery(DOCUMENT_FIELDS, documentFieldJsonJsonArray.toString());
        }
        
        HttpRequestBase requestBase = request.build();
        
        try {
            HttpResponse response = execute(requestBase);
            String jsonString = ResponseUtil.getString(response);
            QueryConcepts concepts = GsonSingleton.getGson().fromJson(jsonString, QueryConcepts.class);
            return concepts;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates an empty corpus.
     *
     * @param accountId String the Account identifier,
     * @param corpus    String the corpus name.
     * @return The created {@link Corpus}.
     */
    public Corpus createCorpus(final String accountId, final Corpus corpus) {
        Validate.notNull(accountId, "account_id can't be null");
        Validate.notNull(corpus, "corpus can't be null");
        Validate.notNull(corpus.getId(), "corpus.id can't be null");
     
        HttpRequestBase request = Request.Put(createCorpusIdPath(accountId, corpus.getId()))
        		.withContent(GsonSingleton.getGson().toJson(corpus), MediaType.APPLICATION_JSON).build();
        executeWithoutResponse(request);
        
        return corpus;
    }

    /**
     * Creates a document in a given corpus.
     *
     * @param accountId String the account identifier,
     * @param corpusName    String the corpus name.
     * @param document  {@link Document} The document to create.
	 *
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
     * @param accountId String the Account identifier.
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
     * @param accountId String the account identifier,
     * @param corpusName    String the corpus name.
     * @param documentName  String the document name.
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
        Request request = Request.Get(ACCOUNTS_PATH);
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
            Accounts accounts = GsonSingleton.getGson().fromJson(
                    jsonObject, Accounts.class);
            return accounts;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
     * @return {@link ConceptMetaData}
     */
    public ConceptMetaData getConcept(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(GRAPH), "graph can't be null");
        Validate.notNull(parameters.get(CONCEPT), "concept can't be null");
        String conceptId = createConceptIdPath((String) parameters.get(ACCOUNT_ID), (String) parameters.get(GRAPH), (String) parameters.get(CONCEPT));
        
        HttpRequestBase request = Request.Get(conceptId).build();
        
        try {
            HttpResponse response = execute(request);
            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
            ConceptMetaData conceptMetaData = GsonSingleton.getGson().fromJson(
                    jsonObject, ConceptMetaData.class);
            return conceptMetaData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the concept by label.
     *
     * @param resourcePath the resource path
     * @param queryParameters the query parameters
     * @return the concept by label
     */
    private Matches getConceptByLabel(String resourcePath, Map<String, Object> queryParameters) {
        Request request = Request.Get(resourcePath);
        for (Map.Entry<String, Object> entry : queryParameters.entrySet()) {
            request.withQuery(entry.getKey(), entry.getValue());
        }
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
            Matches matches = GsonSingleton.getGson().fromJson(
                    jsonObject, Matches.class);
            return matches;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves corpus object to a list of individual concepts.
     *
     * @param accountId String the Account identifier.
     * @param corpusName String the corpus name.
     * @return the Corpus
     */
    public Corpus getCorpus(final String accountId, final String corpusName) {
        Validate.notNull(accountId, "accountId can't be null");
        Validate.notNull(corpusName, "corpusName can't be null");
        HttpRequestBase request = Request.Get(createCorpusIdPath(accountId, corpusName)).build();
        try {
            HttpResponse response = execute(request);
            String jsonString = ResponseUtil.getString(response);
            Corpus result = GsonSingleton.getGson().fromJson(jsonString, Corpus.class);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets processing state of a Corpus.
     *
     * @param accountId String the account identifier,
     * @param corpusName    String the corpus name.
     * @return {@link CorpusProcessingState} The processing state of a given corpus.
     */
    public CorpusProcessingState getCorpusProcessingState(final String accountId, final String corpusName) {
        Validate.notNull(accountId, "accountId can't be null");
        Validate.notNull(corpusName, "corpusName can't be null");
        HttpRequestBase request = Request.Get(createCorpusIdPath(accountId, corpusName) + PROCESSING_STATE_PATH)
        		.build();
        try {
            HttpResponse response = execute(request);
            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
            CorpusProcessingState corpusProcessingState = GsonSingleton.getGson().fromJson(
                    jsonObject, CorpusProcessingState.class);
            return corpusProcessingState;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves concepts that are related to an entire corpus.
     * 
	 * @param parameters The parameters to be used in the service call, account_id, 
	 * corpus and concepts are required.
	 * <ul>
	 * <li> String account_id - The account identifier.<br>
	 * <li> String corpus - The corpus name.<br>
     * <li> String concept_fields - Additional fields to be included in the concept objects.<br>
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
            JsonArray conceptFieldJsonArray = new JsonArray();
            @SuppressWarnings("unchecked")
			List<String> conceptFields = (List<String>) parameters.get(CONCEPT_FIELDS);
			for (String value : conceptFields) {
                conceptFieldJsonArray.add(new JsonPrimitive(value));
            }
            queryParameters.put(CONCEPT_FIELDS, conceptFieldJsonArray.toString());
        }
        return getRelatedConcepts(corpusId + RELATED_CONCEPTS_PATH, queryParameters);
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
        return getRelationScores(corpusId + RELATION_SCORES_PATH, queryParameters);
    }

    /**
     * Gets processing state of a Corpus.
     *
     * @param accountId String the account identifier,
     * @param corpusName String the corpus name.
     * @return the {@link CorpusStats}
     */
    public CorpusStats getCorpusStats(final String accountId, final String corpusName) {
        Validate.notNull(accountId, "accountId can't be null");
        Validate.notNull(corpusName, "corpusName can't be null");
        HttpRequestBase request = Request.Get(createCorpusIdPath(accountId, corpusName) + STATS_PATH).build();
        try {
            HttpResponse response = execute(request);
            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
            CorpusStats corpusStats = GsonSingleton.getGson().fromJson(
                    jsonObject, CorpusStats.class);
            return corpusStats;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves a document from a corpus.
     *
     * @param accountId String the account identifier,
     * @param corpusName    String the corpus name.
     * @param documentName  String the document name.
     * @return {@link Document}
     */
    public Document getDocument(final String accountId, final String corpusName, final String documentName) {
        Validate.notNull(accountId, "accountId can't be null");
        Validate.notNull(corpusName, "corpusName can't be null");
        Validate.notNull(documentName, "documentName can't be null");
        
        Request request = Request.Get(createDocumentIdPath(accountId, corpusName, documentName));
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
            Document result = GsonSingleton.getGson().fromJson(
                    jsonObject, Document.class);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves conceptual view of document (including annotations).
     *
     * @param accountId String the account identifier,
     * @param corpusName    String the corpus name,
     * @param documentName  String the document name.
     * @return {@link DocumentAnnotations}
     */
    public DocumentAnnotations getDocumentAnnotations(final String accountId, final String corpusName, final String documentName) {
        Validate.notNull(accountId, "accountId can't be null");
        Validate.notNull(corpusName, "corpusName can't be null");
        Validate.notNull(documentName, "documentName can't be null");
        
        String documentId = createDocumentIdPath(accountId, corpusName, documentName);
        
        Request request = Request.Get(documentId + ANNOTATIONS_PATH);
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            String jsonString = ResponseUtil.getString(response);
            DocumentAnnotations documents = GsonSingleton.getGson().fromJson(
                    jsonString, DocumentAnnotations.class);
            return documents;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves processing state of document.
     *
     * @param accountId String the account identifier,
     * @param corpusName    String the corpus name,
     * @param documentName  String the document name.
     * @return {@link DocumentProcessingState}
     */
    public DocumentProcessingState getDocumentProcessingState(final String accountId, final String corpusName, final String documentName) {
        Validate.notNull(accountId, "accountId can't be null");
        Validate.notNull(corpusName, "corpusName can't be null");
        Validate.notNull(documentName, "documentName can't be null");

        String documentId = createDocumentIdPath(accountId, corpusName, documentName);
        HttpRequestBase request = Request.Get(documentId + PROCESSING_STATE_PATH).build();
        
        try {
            HttpResponse response = execute(request);
            String jsonString = ResponseUtil.getString(response);
            DocumentProcessingState documentProcessingState = GsonSingleton.getGson().fromJson(
                    jsonString, DocumentProcessingState.class);
            return documentProcessingState;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
     * <li> String concept_fields - Additional fields to be included in the concept objects.<br>
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
            JsonArray conceptFieldJsonArray = new JsonArray();
            @SuppressWarnings("unchecked")
			List<String> list = (List<String>) parameters.get(CONCEPT_FIELDS);
			for (String value : list) {
                conceptFieldJsonArray.add(new JsonPrimitive(value));
            }
            queryParams.put(CONCEPT_FIELDS, conceptFieldJsonArray.toString());
        }
        return getRelatedConcepts(documentId + RELATED_CONCEPTS_PATH, queryParams);
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
        return getRelationScores(documentId + RELATION_SCORES_PATH, queryParams);
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
     * <li> String concept_fields - Additional fields to be included in the concept objects.<br>
     * </ul>
     * @return {@link Concepts}
     */
    @SuppressWarnings("unchecked")
	public Concepts getGraphsRelatedConcepts(Map<String, Object> parameters) {
        //TODO may be need to divide into 2 methods
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
        if (parameters.get(CONCEPTS) != null) {
            JsonObject contentJson = new JsonObject();
            JsonArray conceptsJson = new JsonArray();
            for (String value : (List<String>) parameters.get(CONCEPTS)) {
                conceptsJson.add(new JsonPrimitive(value));
            }
            contentJson.add(CONCEPTS, conceptsJson);
            queryParameters.put(CONCEPTS, conceptsJson.toString());
            return getRelatedConcepts(graphId + RELATED_CONCEPTS_PATH, queryParameters);
        } else {
            String conceptId = createConceptIdPath((String) parameters.get(ACCOUNT_ID), (String) parameters.get(GRAPH), (String) parameters.get(CONCEPT));
            return getRelatedConcepts(conceptId + RELATED_CONCEPTS_PATH, queryParameters);
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
    @SuppressWarnings("unchecked")
	public Scores getGraphsRelationScores(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(GRAPH), "graph can't be null");
        Validate.notNull(parameters.get(CONCEPT), "concept can't be null");
        Validate.notNull(parameters.get(CONCEPTS), "concepts can't be null");
        
        String conceptId = createConceptIdPath((String) parameters.get(ACCOUNT_ID), (String) parameters.get(GRAPH), (String) parameters.get(CONCEPT));
        
        Map<String, Object> queryParameters = new HashMap<String, Object>();
        JsonObject contentJson = new JsonObject();
        JsonArray conceptsJson = new JsonArray();
        for (String value : (List<String>) parameters.get(CONCEPTS)) {
            conceptsJson.add(new JsonPrimitive(value));
        }
        contentJson.add(CONCEPTS, conceptsJson);
        queryParameters.put(CONCEPTS, conceptsJson.toString());
        
        return getRelationScores(conceptId + RELATION_SCORES_PATH, queryParameters);
    }

    /**
     * Gets the related concepts.
     *
     * @param resourcePath the resource path
     * @param queryParameters the query parameters
     * @return the related concepts
     */
    private Concepts getRelatedConcepts(String resourcePath, Map<String, Object> queryParameters) {
        Request request = Request.Get(resourcePath);
        for (Map.Entry<String, Object> entry : queryParameters.entrySet()) {
            request.withQuery(entry.getKey(), entry.getValue());
        }
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
            Concepts concepts = GsonSingleton.getGson().fromJson(
                    jsonObject, Concepts.class);
            return concepts;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the relation scores.
     *
     * @param resourcePath the resource path
     * @param queryParameters the query parameters
     * @return the relation scores
     */
    private Scores getRelationScores(String resourcePath, Map<String, Object> queryParameters) {
        Request request = Request.Get(resourcePath);
        for (Map.Entry<String, Object> entry : queryParameters.entrySet()) {
            request.withQuery(entry.getKey(), entry.getValue());
        }
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
            Scores scores = GsonSingleton.getGson().fromJson(
                    jsonObject, Scores.class);
            return scores;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the available corpus objects.
     *
     * @return {@link Corpora}
     */
    public Corpora listCorpora() {

    	HttpRequestBase request = Request.Get(CORPORA_PATH).build();
        try {
            HttpResponse response = execute(request);
            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
            Corpora corpora = GsonSingleton.getGson().fromJson(
                    jsonObject, Corpora.class);
            return corpora;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the available corpus objects associated with an account identifier.
     *
     * @param accountId The account identifier.
     * @return {@link Corpora}
     */
    public Corpora listCorpora(String accountId) {
        Validate.notNull(accountId, "account_id can't be null");
        HttpRequestBase request = Request.Get(CORPORA_PATH + FORWARD_SLASH + accountId).build();
        
        try {
            HttpResponse response = execute(request);
            String jsonString = ResponseUtil.getString(response);
            Corpora corpora = GsonSingleton.getGson().fromJson(jsonString, Corpora.class);
            return corpora;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
	 * <li> String query - JSON object that allows to filter the list of documents. 
	 * Valid values are {"status":"error"}, {"status":"processing"}, 
	 * and {"status":"ready"} which allow to filter documents by status<br>
	 * <li> Integer cursor - The number of possible items to return. 
	 * Specify '0' to return the maximum value of 100,000...<br>
	 * <li> Integer limit - The number of possible concepts to return..<br>
	 * </ul>
	 * 
     * @return {@link Documents}
     */
    @SuppressWarnings("unchecked")
	public Documents listDocuments(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(CORPUS), "corpus can't be null");

        Request request = Request.Get(createCorpusIdPath((String) parameters.get(ACCOUNT_ID), 
        		(String) parameters.get(CORPUS)) + DOCUMENTS);

        String[] queryParameters = new String[]{CURSOR, LIMIT};
        for (String param : queryParameters) {
            if (parameters.containsKey(param)) {
                request.withQuery(param, parameters.get(param));
            }
        }
        
        if (parameters.get(QUERY) != null) {
            // TODO need to work in the query format
            JsonObject contentJson = new JsonObject();
            JsonArray conceptsJson = new JsonArray();
            for (String value : (List<String>) parameters.get(QUERY)) {
                conceptsJson.add(new JsonPrimitive(value));
            }
            contentJson.add(QUERY, conceptsJson);
            request.withQuery(QUERY, conceptsJson.toString());
        }
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
            Documents documents = GsonSingleton.getGson().fromJson(
                    jsonObject, Documents.class);
            return documents;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the available {@link Graphs}.
     *
     * @return the {@link Graphs}
     */
    public Graphs listGraphs() {
        Request request = Request.Get(GRAPHS_PATH);
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
            Graphs graphs = GsonSingleton.getGson().fromJson(
                    jsonObject, Graphs.class);
            return graphs;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Searches for documents and concepts by using partial matches on the label(s) fields.
     * 
	 * @param parameters The parameters to be used in the service call, account_id, 
	 * corpus and query are required.
	 * <ul>
	 * <li> String account_id - The account identifier.<br>
	 * <li> String corpus - The corpus name.<br>
     * <li> String concept_fields - Additional fields to be included in the concept objects.<br>
     * <li> String document_fields - Additional fields to be included in the document objects.<br> 
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
        String[] queryParams = new String[]{QUERY,PREFIX, LIMIT, CONCEPTS};
        for (String param : queryParams) {
            if (parameters.containsKey(param))
                queryParameters.put(param, parameters.get(param));
        }
        
        // Concept Field JSON
        if (parameters.get(CONCEPT_FIELDS) != null) {
            JsonObject conceptFieldJson = new JsonObject();
            JsonArray conceptFieldJsonArray = new JsonArray();
            @SuppressWarnings("unchecked")
			List<String> conceptFields = (List<String>) parameters.get(CONCEPT_FIELDS);
			for (String value : conceptFields) {
                conceptFieldJsonArray.add(new JsonPrimitive(value));
            }
            conceptFieldJson.add(CONCEPT_FIELDS, conceptFieldJsonArray);
            queryParameters.put(CONCEPT_FIELDS, conceptFieldJsonArray.toString());
        }
        
        // document Field JSON
        if (parameters.get(DOCUMENT_FIELDS) != null) {
            JsonObject documentFieldJson = new JsonObject();
            JsonArray documentFieldJsonJsonArray = new JsonArray();
            @SuppressWarnings("unchecked")
			List<String> documentFields = (List<String>) parameters.get(DOCUMENT_FIELDS);
			for (String value : documentFields) {
                documentFieldJsonJsonArray.add(new JsonPrimitive(value));
            }
            documentFieldJson.add(DOCUMENT_FIELDS, documentFieldJsonJsonArray);
            queryParameters.put(DOCUMENT_FIELDS, documentFieldJsonJsonArray.toString());
        }
        return getConceptByLabel(corpusId + LABEL_SEARCH_PATH, queryParameters);
    }

    /**
	 * Searches for graph concepts by using partial matches.<br>
	 * @param parameters The parameters to be used in the service call, account_id, 
	 * graph and query are required.
	 * <ul>
	 * <li> String account_id - The account identifier.<br>
	 * <li> String graph - The graph name.<br>
	 * <li> String query - The query string.<br>
	 * <li> Boolean prefix - Whether the query string should be treated as a prefix.<br> 
	 * <li> Integer limit - The maximum number of items to be returned.<br>
	 * <li> String concept_fields - An additional fields to include in the concept objects.<br>
	 * </ul>
	 * @return the matches
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
        return getConceptByLabel(graph_id + LABEL_SEARCH_PATH, queryParameters);
    }

    /**
     * Updates existing corpus meta-data (access and permissions).
     *
     * @param accountId String the Account identifier.
     * @param corpus    {@link Corpus} the corpus to update.
     * @return The updated {@link Corpus}.
     */
    public Corpus updateCorpus(final String accountId, final Corpus corpus) {
        Validate.notNull(accountId, "account_id can't be null");
        Validate.notNull(corpus, "corpus can't be null");
        Validate.notNull(corpus.getId(), "corpus.id can't be null");
     
        HttpRequestBase request = Request.Post(createCorpusIdPath(accountId, corpus.getId()))
        		.withContent(GsonSingleton.getGson().toJson(corpus), MediaType.APPLICATION_JSON).build();
        executeWithoutResponse(request);
        
        return corpus;
    }

    /**
     * Updates a document in a given corpus.
     *
     * @param accountId String the account identifier,
     * @param corpusName    String the corpus name.
     * @param document  {@link Document} The document to update.
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

}

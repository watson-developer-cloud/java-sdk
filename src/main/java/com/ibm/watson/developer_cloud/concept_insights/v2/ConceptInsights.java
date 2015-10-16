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

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Accounts;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Annotations;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Concept;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.ConceptMetadata;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Concepts;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Corpora;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Corpus;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.CorpusProcessingState;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.CorpusStats;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Document;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.DocumentAnnotations;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.DocumentProcessingStatus;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Documents;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Graph;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Graphs;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Matches;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.QueryConcepts;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.RequestedFields;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Scores;
import com.ibm.watson.developer_cloud.concept_insights.v2.util.IDHelper;
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
	 * The ACCOUNTS_PATH. (value is "/v2/accounts")
	 */
	private static final String ACCOUNTS_PATH = "/v2/accounts";

	/**
	 * The Constant ANNOTATE_TEXT_PATH. (value is "/annotate_text")
	 */
	private static final String ANNOTATE_TEXT_PATH = "/annotate_text";

	/**
	 * The ANNOTATIONS_PATH. (value is "/annotations")
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
	 * The Constant CONCEPTUAL_SEARCH_PATH. (value is "/conceptual_search")
	 */
	private static final String CONCEPTUAL_SEARCH_PATH = "/conceptual_search";

	/**
	 * The CORPORA_PATH. (value is "/v2/corpora")
	 */
	private static final String CORPORA_PATH = "/v2/corpora";

	/**
	 * The Constant CURSOR. (value is "cursor")
	 */
	public static final String CURSOR = "cursor";

	/**
	 * The Constant DOCUMENT_FIELDS. (value is "document_fields")
	 */
	public static final String DOCUMENT_FIELDS = "document_fields";

	/**
	 * The Constant DOCUMENTS. (value is "documents")
	 */
	public static final String DOCUMENTS_PATH = "/documents";

	/**
	 * The GRAPHS_PATH. (value is "/v2/graphs")
	 */
	private static final String GRAPHS_PATH = "/v2/graphs";

	/**
	 * The Constant IDS. (value is "ids")
	 */
	public static final String IDS = "ids";

	/**
	 * The LABEL_SEARCH_PATH. (value is "/label_search")
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
	 * The Constant PROCESSING_STATE_PATH. (value is "/processing_state")
	 */
	private static final String PROCESSING_STATE_PATH = "/processing_state";

	/**
	 * The Constant query. (value is "query")
	 */
	public static final String QUERY = "query";

	/**
	 * The RELATED_CONCEPTS_PATH. (value is "/related_concepts")
	 */
	private static final String RELATED_CONCEPTS_PATH = "/related_concepts";

	/**
	 * The Constant RELATION_SCORES_PATH. (value is "/relation_scores")
	 */
	private static final String RELATION_SCORES_PATH = "/relation_scores";

	/**
	 * The Constant STATS_PATH. (value is "/stats")
	 */
	private static final String STATS_PATH = "/stats";

	/**
	 * The Constant TEXT. (value is "text")
	 */
	public static final String TEXT = "text";

	/**
	 * The service url. (value is
	 * "https://gateway.watsonplatform.net/concept-insights/api")
	 */
	private static final String URL = "https://gateway.watsonplatform.net/concept-insights/api";

	/**
	 * The API VERSION. (value is "/v2")
	 */
	private static final String API_VERSION = "/v2";

	/** The account id. */
	private String accountId = null;

	/**
	 * Instantiates a new Concept Insights service.
	 */
	public ConceptInsights() {
		super("concept_insights");
		setEndPoint(URL);

	}

	/**
	 * Identifies concepts in a piece of text.
	 * 
	 * @param graph
	 *            - The graph object.
	 * @param text
	 *            - The text to annotate.
	 * @return {@link Annotations}
	 */
	public Annotations annotateText(final Graph graph, final String text) {
		String graphId = IDHelper.getGraphId(graph, getAccountId());
		Validate.notEmpty(text, "text cannot be empty");

		HttpRequestBase request = Request.Post(API_VERSION + graphId + ANNOTATE_TEXT_PATH)
				.withContent(text, MediaType.TEXT_PLAIN).withHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
				.build();

		try {
			HttpResponse response = execute(request);
			return ResponseUtil.getObject(response, Annotations.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Performs a conceptual search within a corpus.
	 * 
	 * @param corpus
	 *            the corpus
	 * @param parameters
	 *            The parameters to be used in the service call ids is required.
	 *            <ul>
	 *            <li>RequestedFields concept_fields - Additional fields to be included in
	 *            the concept objects.<br>
	 *            <li>RequestedFields document_fields - Additional fields to be included
	 *            in the document objects.<br>
	 *            <li>String ids - JSON array of concept and/or document ids.<br>
	 *            <li>Integer cursor - A number of items to skip.<br>
	 *            <li>Integer limit - The maximum number of concepts to be returned.<br>
	 *            </ul>
	 * @return {@link QueryConcepts}
	 */
	public QueryConcepts conceptualSearch(Corpus corpus, Map<String, Object> parameters) {
		Validate.notNull(parameters.get(IDS), "ids cannot be null");
		String corpusId = IDHelper.getCorpusId(corpus, getAccountId());

		Map<String, Object> queryParams = new HashMap<String, Object>();
		String[] queryParameters = new String[] { CURSOR, LIMIT };

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
			if (fields != null && !fields.isEmpty())
				queryParams.put(CONCEPT_FIELDS, fields.toString());
		}

		if (parameters.get(DOCUMENT_FIELDS) != null) {
			RequestedFields fields = (RequestedFields) parameters.get(DOCUMENT_FIELDS);
			if (fields != null && !fields.isEmpty())
				queryParams.put(DOCUMENT_FIELDS, fields.toString());
		}

		return executeRequest(API_VERSION + corpusId + CONCEPTUAL_SEARCH_PATH, queryParams, QueryConcepts.class);
	}

	/**
	 * Creates an empty corpus.
	 * 
	 * @param corpus
	 *            Corpus the corpus object.
	 */
	public void createCorpus(final Corpus corpus) {
		String corpusId = IDHelper.getCorpusId(corpus, getAccountId());
		HttpRequestBase request = Request.Put(API_VERSION + corpusId)
				.withContent(GsonSingleton.getGson().toJson(corpus), MediaType.APPLICATION_JSON).build();
		executeWithoutResponse(request);
	}

	/**
	 * Creates a document in a given corpus.
	 * 
	 * @param document
	 *            {@link Document} The document to create.
	 */
	public void createDocument(final Document document) {
		IDHelper.getDocumentId(document);
		HttpRequestBase request = Request.Put(API_VERSION + document.getId())
				.withContent(GsonSingleton.getGson().toJson(document), MediaType.APPLICATION_JSON).build();

		executeWithoutResponse(request);
	}

	/**
	 * Deletes a corpus by ID.
	 * 
	 * @param corpus
	 *            Corpus the corpus object.
	 */
	public void deleteCorpus(final Corpus corpus) {
		String corpusId = IDHelper.getCorpusId(corpus, getAccountId());
		HttpRequestBase request = Request.Delete(API_VERSION + corpusId).build();
		executeWithoutResponse(request);
	}

	/**
	 * Deletes a document in a given corpus.
	 * 
	 * @param document
	 *            Document the document.
	 */

	public void deleteDocument(final Document document) {
		IDHelper.getDocumentId(document);
		HttpRequestBase request = Request.Delete(API_VERSION + document.getId()).build();
		executeWithoutResponse(request);
	}

	/**
	 * Execute the request and return the POJO that represent the response.
	 * 
	 * @param <T>
	 *            The POJO that represents the response object
	 * @param resourcePath
	 *            the resource path
	 * @param queryParams
	 *            the query parameters
	 * @param returnType
	 *            the POJO class to be parsed from the response
	 * @return the POJO object that represent the response
	 */
	private <T> T executeRequest(final String resourcePath, final Map<String, Object> queryParams,
			final Class<T> returnType) {
		Request request = Request.Get(resourcePath);
		if (queryParams != null && !queryParams.isEmpty()) {
			for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
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

	/**
	 * Gets the account id.
	 * 
	 * @return the account id
	 */
	private String getAccountId() {
		if (accountId == null) {
			Accounts accounts = getAccountsInfo();
			if (accounts != null && accounts.getAccounts() != null && !accounts.getAccounts().isEmpty()) {
				accountId = accounts.getAccounts().get(0).getId();
			}
		}
		return accountId;
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
	 * @param concept
	 *            Concept the concept object.
	 * @return {@link ConceptMetadata}
	 */
	public ConceptMetadata getConcept(final Concept concept) {
		IDHelper.getConceptId(concept);
		return executeRequest(API_VERSION + concept.getId(), null, ConceptMetadata.class);
	}

	/**
	 * Retrieves corpus object to a list of individual concepts.
	 * 
	 * @param corpus
	 *            Corpus the corpus object.
	 * @return the Corpus
	 */
	public Corpus getCorpus(final Corpus corpus) {
		String corpusId = IDHelper.getCorpusId(corpus, getAccountId());
		return executeRequest(API_VERSION + corpusId, null, Corpus.class);
	}

	/**
	 * Gets processing state of a Corpus.
	 * 
	 * @param corpus
	 *            Corpus the corpus object.
	 * @return {@link CorpusProcessingState} The processing state of a given corpus.
	 */
	public CorpusProcessingState getCorpusProcessingState(final Corpus corpus) {
		String corpusId = IDHelper.getCorpusId(corpus, getAccountId());
		return executeRequest(API_VERSION + corpusId + PROCESSING_STATE_PATH, null, CorpusProcessingState.class);
	}

	/**
	 * Retrieves concepts that are related to an entire corpus.
	 * 
	 * @param corpus
	 *            the corpus
	 * @param parameters
	 *            The parameters to be used in the service call.
	 *            <ul>
	 *            <li>RequestedFields concept_fields - Additional fields to be included in
	 *            the concept objects.<br>
	 *            <li>Integer level - A number in the range 0 - 3 that represents the
	 *            level of popularity of related concepts.<br>
	 *            <li>Integer limit - The maximum number of concepts to be returned.<br>
	 *            </ul>
	 * @return {@link Concepts}
	 */
	public Concepts getCorpusRelatedConcepts(final Corpus corpus, final Map<String, Object> parameters) {
		String corpusId = IDHelper.getCorpusId(corpus, getAccountId());

		Map<String, Object> queryParameters = new HashMap<String, Object>();
		String[] params = new String[] { LEVEL, LIMIT };
		for (String param : params) {
			if (parameters.containsKey(param))
				queryParameters.put(param, parameters.get(param));
		}
		if (parameters.get(CONCEPT_FIELDS) != null) {
			RequestedFields fields = (RequestedFields) parameters.get(CONCEPT_FIELDS);
			if (fields != null && !fields.isEmpty())
				queryParameters.put(CONCEPT_FIELDS, fields.toString());
		}
		return executeRequest(API_VERSION + corpusId + RELATED_CONCEPTS_PATH, queryParameters, Concepts.class);
	}

	/**
	 * Returns a list of scores that denotes how related an entire corpus is to a list of
	 * individual concepts.
	 * 
	 * @param corpus
	 *            The corpus object
	 * @param concepts
	 *            Array of concept IDs, each identifying a concept
	 * @return {@link Scores}
	 */
	public Scores getCorpusRelationScores(final Corpus corpus, final List<Concept> concepts) {
		String corpusId = IDHelper.getCorpusId(corpus, getAccountId());
		Validate.notEmpty(concepts, "concepts cannot be empty");

		Map<String, Object> queryParameters = new HashMap<String, Object>();
		JsonObject contentJson = new JsonObject();
		JsonArray conceptsJson = new JsonArray();
		for (Concept con : concepts) {
			conceptsJson.add(new JsonPrimitive(con.getId()));
		}
		contentJson.add(CONCEPTS, conceptsJson);
		queryParameters.put(CONCEPTS, conceptsJson.toString());
		return executeRequest(API_VERSION + corpusId + RELATION_SCORES_PATH, queryParameters, Scores.class);
	}

	/**
	 * Gets processing state of a Corpus.
	 * 
	 * @param corpus
	 *            The corpus object
	 * @return the {@link CorpusStats}
	 */
	public CorpusStats getCorpusStats(final Corpus corpus) {
		String corpusId = IDHelper.getCorpusId(corpus, getAccountId());
		return executeRequest(API_VERSION + corpusId + STATS_PATH, null, CorpusStats.class);
	}

	/**
	 * Retrieves a document from a corpus.
	 * 
	 * @param document
	 *            Document the document object,
	 * @return {@link Document}
	 */
	public Document getDocument(final Document document) {
		String documentId = IDHelper.getDocumentId(document);
		return executeRequest(API_VERSION + documentId, null, Document.class);
	}

	/**
	 * Retrieves conceptual view of document (including annotations).
	 * 
	 * @param document
	 *            Document the document object,
	 * @return {@link DocumentAnnotations}
	 */
	public DocumentAnnotations getDocumentAnnotations(final Document document) {
		String documentId = IDHelper.getDocumentId(document);
		return executeRequest(API_VERSION + documentId + ANNOTATIONS_PATH, null, DocumentAnnotations.class);
	}

	/**
	 * Retrieves processing state of document.
	 * 
	 * @param document
	 *            Document the document object,
	 * @return {@link DocumentProcessingStatus}
	 */
	public DocumentProcessingStatus getDocumentProcessingState(final Document document) {
		String documentId = IDHelper.getDocumentId(document);
		return executeRequest(API_VERSION + documentId + PROCESSING_STATE_PATH, null, DocumentProcessingStatus.class);
	}

	/**
	 * Retrieves concepts that are related (in conceptual sense) to a given document.
	 * 
	 * @param document
	 *            the document
	 * @param parameters
	 *            The parameters to be used in the service call.
	 *            <ul>
	 *            <li>Integer level - A number in the range 0 - 3 that represents the
	 *            level of popularity of related concepts.<br>
	 *            <li>Integer limit - The maximum number of concepts to be returned.<br>
	 *            <li>RequestedFields concept_fields - Additional fields to be included in
	 *            the concept objects.<br>
	 *            </ul>
	 * @return {@link Concepts}
	 */
	public Concepts getDocumentRelatedConcepts(final Document document, final Map<String, Object> parameters) {
		String documentId = IDHelper.getDocumentId(document);
		String[] queryParameters = new String[] { LEVEL, LIMIT };
		Map<String, Object> queryParams = new HashMap<String, Object>();
		for (String param : queryParameters) {
			if (parameters.containsKey(param))
				queryParams.put(param, parameters.get(param));
		}
		if (parameters.get(CONCEPT_FIELDS) != null) {
			RequestedFields fields = (RequestedFields) parameters.get(CONCEPT_FIELDS);
			if (fields != null && !fields.isEmpty())
				queryParams.put(CONCEPT_FIELDS, fields.toString());
		}
		return executeRequest(API_VERSION + documentId + RELATED_CONCEPTS_PATH, queryParams, Concepts.class);
	}

	/**
	 * Retrieves concepts that are related (in conceptual sense) to a given document.
	 * 
	 * @param document
	 *            Document the document object,
	 * @param concepts
	 *            the concepts
	 * @return {@link Scores}
	 */
	public Scores getDocumentRelationScores(final Document document, final List<Concept> concepts) {
		String documentId = IDHelper.getDocumentId(document);
		Validate.notEmpty(concepts, "concepts cannot be empty");

		Map<String, Object> queryParams = new HashMap<String, Object>();
		JsonObject contentJson = new JsonObject();
		JsonArray conceptsJson = new JsonArray();

		for (Concept con : concepts) {
			conceptsJson.add(new JsonPrimitive(con.getId()));
		}
		contentJson.add(CONCEPTS, conceptsJson);
		queryParams.put(CONCEPTS, conceptsJson.toString());
		return executeRequest(API_VERSION + documentId + RELATION_SCORES_PATH, queryParams, Scores.class);
	}

	/**
	 * Searches for graph concepts by using partial matches.
	 * 
	 * @param graph
	 *            the graph
	 * @param concepts
	 *            the concepts
	 * @param parameters
	 *            The parameters to be used in the service call, graph and concepts are
	 *            required.
	 *            <ul>
	 *            <li>RequestedFields concept_fields - Additional fields to be included in
	 *            the concept objects.<br>
	 *            <li>Integer level - A number in the range 0 - 3 that represents the
	 *            level of popularity of related concepts.<br>
	 *            <li>Integer limit - The maximum number of concepts to be returned.<br>
	 *            </ul>
	 * @return {@link Concepts}
	 */
	public Concepts getGraphRelatedConcepts(final Graph graph, final List<Concept> concepts,
			final Map<String, Object> parameters) {
		String graphId = IDHelper.getGraphId(graph, getAccountId());
		Validate.notEmpty(concepts, "concepts cannot be empty");

		Map<String, Object> queryParameters = new HashMap<String, Object>();
		String[] queryParms = new String[] { LEVEL, LIMIT };
		for (String param : queryParms) {
			if (parameters.containsKey(param))
				queryParameters.put(param, parameters.get(param));
		}
		if (parameters.get(CONCEPT_FIELDS) != null) {
			RequestedFields fields = (RequestedFields) parameters.get(CONCEPT_FIELDS);
			if (fields != null && !fields.isEmpty())
				queryParameters.put(CONCEPT_FIELDS, fields.toString());
		}
		JsonObject contentJson = new JsonObject();
		JsonArray conceptsJson = new JsonArray();
		for (Concept concept : concepts) {
			conceptsJson.add(new JsonPrimitive(concept.getId()));
		}
		contentJson.add(CONCEPTS, conceptsJson);
		queryParameters.put(CONCEPTS, conceptsJson.toString());
		return executeRequest(API_VERSION + graphId + RELATED_CONCEPTS_PATH, queryParameters, Concepts.class);
	}

	/**
	 * Searches for graph concepts from a Concept by using partial matches.
	 * 
	 * @param concept
	 *            the concept
	 * @param parameters
	 *            The parameters to be used in the service call.
	 *            <ul>
	 *            <li>RequestedFields concept_fields - Additional fields to be included in
	 *            the concept objects.<br>
	 *            <li>Integer level - A number in the range 0 - 3 that represents the
	 *            level of popularity of related concepts.<br>
	 *            <li>Integer limit - The maximum number of concepts to be returned.<br>
	 *            </ul>
	 * @return {@link Concepts}
	 */
	public Concepts getConceptRelatedConcepts(final Concept concept, final Map<String, Object> parameters) {
		String conceptId = IDHelper.getConceptId(concept);

		Map<String, Object> queryParameters = new HashMap<String, Object>();
		String[] queryParms = new String[] { LEVEL, LIMIT };
		for (String param : queryParms) {
			if (parameters.containsKey(param))
				queryParameters.put(param, parameters.get(param));
		}
		if (parameters.get(CONCEPT_FIELDS) != null) {
			RequestedFields fields = (RequestedFields) parameters.get(CONCEPT_FIELDS);
			if (fields != null && !fields.isEmpty())
				queryParameters.put(CONCEPT_FIELDS, fields.toString());
		}
		return executeRequest(API_VERSION + conceptId + RELATED_CONCEPTS_PATH, queryParameters, Concepts.class);
	}

	/**
	 * Returns a list of scores that denotes how related a source concept is to a list of
	 * individual concepts.
	 * 
	 * @param concept
	 *            Concept the concept object,
	 * @param concepts
	 *            Array of concept IDs, each identifying a concept.
	 * 
	 * @return {@link Scores}
	 */
	public Scores getGraphRelationScores(final Concept concept, final List<String> concepts) {
		String conceptId = IDHelper.getConceptId(concept);
		Validate.notEmpty(concepts, "concepts cannot be empty");

		Map<String, Object> queryParameters = new HashMap<String, Object>();
		JsonObject contentJson = new JsonObject();
		JsonArray conceptsJson = new JsonArray();

		for (String value : concepts) {
			conceptsJson.add(new JsonPrimitive(value));
		}
		contentJson.add(CONCEPTS, conceptsJson);
		queryParameters.put(CONCEPTS, conceptsJson.toString());

		return executeRequest(API_VERSION + conceptId + RELATION_SCORES_PATH, queryParameters, Scores.class);
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
	 * @param accountId
	 *            The account identifier.
	 * @return {@link Corpora}
	 */
	public Corpora listCorpora(final String accountId) {
		Validate.notEmpty(accountId, "account_id cannot be empty");
		return executeRequest(CORPORA_PATH + FORWARD_SLASH + accountId, null, Corpora.class);
	}

	/**
	 * Retrieves the document ids of a corpus.
	 * 
	 * @param corpus
	 *            the corpus
	 * @param parameters
	 *            The parameters to be used in the service call.
	 *            <ul>
	 *            <li>String concept - The concept name.<br>
	 *            <li>String query - For query syntax see <a href=
	 *            "http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/concept_insights.html"
	 *            >API Explorer</a>.<br>
	 *            JSON object that allows to filter the list of documents. Valid values
	 *            are {"status":"error"}, {"status":"processing"}, and {"status":"ready"}
	 *            which allow to filter documents by status.<br>
	 *            <li>Integer cursor - The number of possible items to return. Specify '0'
	 *            to return the maximum value of 100,000...<br>
	 *            <li>Integer limit - The number of possible concepts to return..<br>
	 *            </ul>
	 * @return {@link Documents}
	 */
	public Documents listDocuments(final Corpus corpus, final Map<String, Object> parameters) {
		String corpusId = IDHelper.getCorpusId(corpus, getAccountId());

		Map<String, Object> queryParameters = new HashMap<String, Object>();
		String[] queryParams = new String[] { CURSOR, LIMIT };
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

		return executeRequest(API_VERSION + corpusId + DOCUMENTS_PATH, queryParameters, Documents.class);
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
	 * Searches for documents and concepts by using partial matches on the label(s)
	 * fields.
	 * 
	 * @param corpus
	 *            the corpus
	 * @param parameters
	 *            The parameters to be used in the service call query is required.
	 *            <ul>
	 *            <li>RequestedFields concept_fields - Additional fields to be included in
	 *            the concept objects.<br>
	 *            <li>RequestedFields document_fields - Additional fields to be included
	 *            in the document objects.<br>
	 *            <li>Boolean concepts - Whether to return concepts that have a label
	 *            match.<br>
	 *            <li>String query - The query string.<br>
	 *            <li>Boolean prefix - Whether the query string should be treated as a
	 *            prefix.<br>
	 *            <li>Integer limit - The maximum number of concepts to be returned.<br>
	 *            </ul>
	 * @return {@link Matches}
	 */
	public Matches searchCorpusByLabel(final Corpus corpus, final Map<String, Object> parameters) {
		String corpusId = IDHelper.getCorpusId(corpus, getAccountId());
		Validate.notEmpty((String)parameters.get(QUERY), "query cannot be empty");

		Map<String, Object> queryParameters = new HashMap<String, Object>();
		String[] queryParams = new String[] { QUERY, PREFIX, LIMIT, CONCEPTS };
		for (String param : queryParams) {
			if (parameters.containsKey(param))
				queryParameters.put(param, parameters.get(param));
		}

		if (parameters.get(CONCEPT_FIELDS) != null) {
			RequestedFields fields = (RequestedFields) parameters.get(CONCEPT_FIELDS);
			if (fields != null && !fields.isEmpty())
				queryParameters.put(CONCEPT_FIELDS, fields.toString());
		}

		if (parameters.get(DOCUMENT_FIELDS) != null) {
			RequestedFields fields = (RequestedFields) parameters.get(DOCUMENT_FIELDS);
			if (fields != null && !fields.isEmpty())
				queryParameters.put(DOCUMENT_FIELDS, fields.toString());
		}
		return executeRequest(API_VERSION + corpusId + LABEL_SEARCH_PATH, queryParameters, Matches.class);
	}

	/**
	 * Searches for graph concepts by using partial matches.<br>
	 * 
	 * @param graph
	 *            the graph
	 * @param parameters
	 *            The parameters to be used in the service call, account_id, graph and
	 *            query are required.
	 *            <ul>
	 *            <li>String account_id - The account identifier.<br>
	 *            <li>String graph - The graph name.<br>
	 *            <li>String query - The query string.<br>
	 *            <li>Boolean prefix - Whether the query string should be treated as a
	 *            prefix.<br>
	 *            <li>Integer limit - The maximum number of items to be returned.<br>
	 *            <li>RequestedFields concept_fields - An additional fields to include in
	 *            the concept objects.<br>
	 *            </ul>
	 * @return {@link Matches}
	 */
	public Matches searchGraphsConceptByLabel(final Graph graph, final Map<String, Object> parameters) {
		String graphId = IDHelper.getGraphId(graph, getAccountId());
		Validate.notEmpty((String)parameters.get(QUERY), "query cannot be empty");

		Map<String, Object> queryParameters = new HashMap<String, Object>();
		String[] params = new String[] { QUERY, PREFIX, LIMIT };
		for (String param : params) {
			if (parameters.containsKey(param)) {
				queryParameters.put(param, parameters.get(param));
			}
		}
		if (parameters.get(CONCEPT_FIELDS) != null) {
			RequestedFields fields = (RequestedFields) parameters.get(CONCEPT_FIELDS);
			if (fields != null && !fields.isEmpty())
				queryParameters.put(CONCEPT_FIELDS, fields.toString());
		}
		return executeRequest(API_VERSION + graphId + LABEL_SEARCH_PATH, queryParameters, Matches.class);
	}

	/**
	 * Updates existing corpus meta-data (access and permissions).
	 * 
	 * @param corpus
	 *            {@link Corpus} the corpus to update.
	 */
	public void updateCorpus(final Corpus corpus) {
		String corpusId = IDHelper.getCorpusId(corpus, getAccountId());
		HttpRequestBase request = Request.Post(API_VERSION + corpusId)
				.withContent(GsonSingleton.getGson().toJson(corpus), MediaType.APPLICATION_JSON).build();
		executeWithoutResponse(request);
	}

	/**
	 * Updates a document in a given corpus.
	 * 
	 * @param document
	 *            {@link Document} The document to update.
	 */
	public void updateDocument(final Document document) {
		String documentId = IDHelper.getDocumentId(document);
		HttpRequestBase request = Request.Post(API_VERSION + documentId)
				.withContent(GsonSingleton.getGson().toJson(document), MediaType.APPLICATION_JSON).build();
		executeWithoutResponse(request);
	}
}

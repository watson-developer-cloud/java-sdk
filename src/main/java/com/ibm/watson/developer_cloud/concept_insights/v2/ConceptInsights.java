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
 * The IBM Watson™ Concept Insights service provides APIs that enable you to work with concepts and identify
 * conceptual associations in the content that you provide as input to the service.
 * Input content is auto-tagged against a concept graph, which is a formal representation of the relationship(s) between concepts.
 * The concept graph used by the Concept Insights service is based on content that has been ingested from the English language Wikipedia
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 * @version v2
 * @see <a
 * href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/concept_insights.html">
 * Concept Insights</a>
 */
public class ConceptInsights extends WatsonService {

    /**
     * the version
     */
    private static final String VERSION = "/v2";

    /**
     * The url.
     */
    private static final String URL = "https://gateway-s.watsonplatform.net/concept-insights-beta/api";

    /**
     * Retrieves a Concept Insights account identified.
     *
     * @return the accounts
     */
    public Accounts getAccountsInfo() {
        Request request = Request.Get(ConceptInsightsConstants.ACCOUNTS_PATH);
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
     * Retrieves the available Graphs.
     *
     * @return the graphs
     */
    public Graphs getGraphs() {
        Request request = Request.Get(VERSION + FORWARD_SLASH + ConceptInsightsConstants.GRAPHS);
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
     * Searches for graph concepts by using partial matches
     *
     * @param params String account_id the Account Id,
     *               String graph the graph name,
     *               String query the query string,
     *               boolean prefix Whether the query string should be treated as a prefix
     *               Integer limit the maximum number of items to be returned
     *               String concept_fields an additional fields to include in the concept objects. Format is a JSON object, e.g., { "abstract" : 1 } will include the concept abstracts in each concept object.
     * @return the matches
     */
    public Matches searchGraphsConceptByLabel(Map<String, Object> params) {
        Validate.notNull(params.get(ConceptInsightsConstants.ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(params.get(ConceptInsightsConstants.GRAPH), "graph can't be null");
        Validate.notNull(params.get(ConceptInsightsConstants.QUERY), "query can't be null");
        String graph_id = new GraphId((String) params.get(ConceptInsightsConstants.ACCOUNT_ID), (String) params.get(ConceptInsightsConstants.GRAPH)).toString();
        Map<String, Object> queryParameters = new HashMap<String, Object>();
        String[] parameters = new String[]{ConceptInsightsConstants.QUERY,
                ConceptInsightsConstants.PREFIX, ConceptInsightsConstants.LIMIT};
        for (String param : parameters) {
            if (params.containsKey(param)) {
                queryParameters.put(param, params.get(param));
            }
        }
        return getConceptByLabel(VERSION + graph_id + FORWARD_SLASH + ConceptInsightsConstants.LABEL_SEARCH, queryParameters);
    }
    /**
     * Searches for graph concepts by using partial matches
     *
     * @param parameters String account_id the Account Id,
     *                   String graph the graph name,
     *                   List<String> concepts an array of concept IDs,
     *                   String concept the concept name
     *                   String concepts, Array of concept IDs, each identifying a concept. Must be string with a JSON format array, e.g., ["/graphs/wikipedia/en-20120601/concepts/IBM_Watson"]
     *                   Integer level a number in the range 0 - 3 that represents the level of popularity of related concepts
     *                   Integer limit the number of possible concepts to return.
     *                   String concept_fields an additional fields to include in the concept objects. Format is a JSON object, e.g., { "abstract" : 1 } will include the concept abstracts in each concept object.
     * @return the concepts
     */
    public Concepts getGraphsRelatedConcepts(Map<String, Object> parameters) {
        //TODO may be need to divide into 2 methods
        Validate.notNull(parameters.get(ConceptInsightsConstants.ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(ConceptInsightsConstants.GRAPH), "graph can't be null");
        if (parameters.get(ConceptInsightsConstants.CONCEPTS) == null && parameters.get(ConceptInsightsConstants.CONCEPT) == null)
            throw new MissingFormatArgumentException("concepts or concept_id should be identified");
        String graphId = new GraphId((String) parameters.get(ConceptInsightsConstants.ACCOUNT_ID), (String) parameters.get(ConceptInsightsConstants.GRAPH)).toString();
        Map<String, Object> queryParameters = new HashMap<String, Object>();
        String[] queryParms = new String[]{ConceptInsightsConstants.LEVEL,
                ConceptInsightsConstants.LIMIT};
        for (String param : queryParms) {
            if (parameters.containsKey(param))
                queryParameters.put(param, parameters.get(param));
        }
        if (parameters.get(ConceptInsightsConstants.CONCEPTS) != null) {
            JsonObject contentJson = new JsonObject();
            JsonArray conceptsJson = new JsonArray();
            for (String value : (List<String>) parameters.get(ConceptInsightsConstants.CONCEPTS)) {
                conceptsJson.add(new JsonPrimitive(value));
            }
            contentJson.add(ConceptInsightsConstants.CONCEPTS, conceptsJson);
            queryParameters.put(ConceptInsightsConstants.CONCEPTS, conceptsJson.toString());
            return getRelatedConcepts(VERSION + graphId + FORWARD_SLASH + ConceptInsightsConstants.RELATED_CONCEPTS, queryParameters);
        } else
            return getRelatedConcepts(VERSION + graphId + FORWARD_SLASH + ConceptInsightsConstants.CONCEPTS + FORWARD_SLASH + parameters.get(ConceptInsightsConstants.CONCEPT) + FORWARD_SLASH + ConceptInsightsConstants.RELATED_CONCEPTS, queryParameters);
    }
    /**
     * Identifies concepts in a piece of text
     *
     * @param params String account_id the Account Id,
     *               String graph the graph name,
     *               String body the text to analyze
     * @return the Annotations
     */
    public Annotations annotateText(Map<String, Object> params) {
        Validate.notNull(params.get(ConceptInsightsConstants.ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(params.get(ConceptInsightsConstants.GRAPH), "graph can't be null");
        Validate.notNull(params.get(ConceptInsightsConstants.BODY), "body can't be null");
        String graphId = new GraphId((String) params.get(ConceptInsightsConstants.ACCOUNT_ID), (String) params.get(ConceptInsightsConstants.GRAPH)).toString();
        Request request = Request.Post(VERSION + graphId + FORWARD_SLASH + ConceptInsightsConstants.ANNOTATE_TEXT);
        request.withContent((String) params.get(ConceptInsightsConstants.BODY), MediaType.TEXT_PLAIN)
                .withHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).build();
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            Annotations annotations = GsonSingleton.getGson().fromJson(
                    ResponseUtil.getString(response), Annotations.class);
            return annotations;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Returns information for a specific concept node in a graph
     *
     * @param params String account_id the Account Id,
     *               String graph the graph name,
     *               String concept the Concept name
     * @return the concept meta data
     */
    public ConceptMetaData getConcept(Map<String, Object> params) {
        Validate.notNull(params.get(ConceptInsightsConstants.ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(params.get(ConceptInsightsConstants.GRAPH), "graph can't be null");
        Validate.notNull(params.get(ConceptInsightsConstants.CONCEPT), "concept can't be null");
        String graphId = new GraphId((String) params.get(ConceptInsightsConstants.ACCOUNT_ID), (String) params.get(ConceptInsightsConstants.GRAPH)).toString();
        Request request = Request.Get(VERSION + graphId + FORWARD_SLASH + ConceptInsightsConstants.CONCEPTS + FORWARD_SLASH + params.get(ConceptInsightsConstants.CONCEPT));
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
            ConceptMetaData conceptMetaData = GsonSingleton.getGson().fromJson(
                    jsonObject, ConceptMetaData.class);
            return conceptMetaData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Returns a list of scores that denotes how related a source concept is
     * to a list of individual concepts
     *
     * @param parameters String account_id the Account Id,
     *                   String graph the graph name,
     *                   String concept the Concept name
     * @return the scores
     */
    public Scores getGraphsRelationScores(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ConceptInsightsConstants.ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(ConceptInsightsConstants.GRAPH), "graph can't be null");
        Validate.notNull(parameters.get(ConceptInsightsConstants.CONCEPT), "concept can't be null");
        Validate.notNull(parameters.get(ConceptInsightsConstants.CONCEPTS), "concepts can't be null");
        String graphId = new GraphId((String) parameters.get(ConceptInsightsConstants.ACCOUNT_ID), (String) parameters.get(ConceptInsightsConstants.GRAPH)).toString();
        Map<String, Object> queryParameters = new HashMap<String, Object>();
        JsonObject contentJson = new JsonObject();
        JsonArray conceptsJson = new JsonArray();
        for (String value : (List<String>) parameters.get(ConceptInsightsConstants.CONCEPTS)) {
            conceptsJson.add(new JsonPrimitive(value));
        }
        contentJson.add(ConceptInsightsConstants.CONCEPTS, conceptsJson);
        queryParameters.put(ConceptInsightsConstants.CONCEPTS, conceptsJson.toString());
        return getRelationScores(VERSION + graphId + FORWARD_SLASH + ConceptInsightsConstants.CONCEPTS + FORWARD_SLASH + parameters.get(ConceptInsightsConstants.CONCEPT) + FORWARD_SLASH + ConceptInsightsConstants.RELATION_SCORES, queryParameters);
    }
    /**
     * retrieves the available corpora.
     *
     * @return the Corpora
     */
    public Corpora listCorpora() {
        Request request = Request.Get(ConceptInsightsConstants.CORPORA_PATH);
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
            Corpora corpora = GsonSingleton.getGson().fromJson(
                    jsonObject, Corpora.class);
            return corpora;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Retrieves the available Corpora object associated with an account id
     *
     * @param accountId String account_id the Account Id,
     * @return the Corpora
     */
    public Corpora getCorpora(String accountId) {
        Validate.notNull(accountId, "account_id can't be null");
        Request request = Request.Get(ConceptInsightsConstants.CORPORA_PATH + FORWARD_SLASH + accountId);
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            String jsonString = ResponseUtil.getString(response);
            Corpora corpora = GsonSingleton.getGson().fromJson(
                    jsonString, Corpora.class);
            return corpora;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Retrieves corpus object
     * to a list of individual concepts
     *
     * @param accountId String the Account Id,
     * @param corpus    String the corpus name.
     * @return the Corpus
     */
    public Corpus getCorpus(final String accountId, final String corpus) {
        Validate.notNull(accountId, "account_id can't be null");
        Validate.notNull(corpus, "corpus can't be null");
        Request request = Request.Get(VERSION + new CorpusId(accountId, corpus).toString());
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            String jsonString = ResponseUtil.getString(response);
            Corpus result = GsonSingleton.getGson().fromJson(
                    jsonString, Corpus.class);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Delete a corpus by ID
     *
     * @param accountId String the Account Id,
     * @param corpus    String the corpus name.
     * @return void
     */
    public void deleteCorpus(final String accountId, final String corpus) {
        Validate.notNull(accountId, "account_id can't be null");
        Validate.notNull(corpus, "corpus can't be null");
        Request request = Request.Delete(VERSION + new CorpusId(accountId, corpus).toString());
        HttpRequestBase requestBase = request.build();
        executeWithoutResponse(requestBase);
    }
    /**
     * Update existing corpus meta-data (access and permissions)
     *
     * @param accountId String the Account Id,
     * @param corpus    String the corpus name.
     * @param body      String JSON the corpus object
     * @return void
     */
    public void updateCorpus(final String accountId, final String corpus, final String body) {
        // TODO Is better to let the user passing java objcet and we have a full handle of JSON
        Validate.notNull(accountId, "account_id can't be null");
        Validate.notNull(corpus, "corpus can't be null");
        Validate.notNull(body, "body can't be null");
        Request request = Request.Post(VERSION + new CorpusId(accountId, corpus).toString());
        request.withContent(body, MediaType.TEXT_PLAIN)
                .withHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).build();
        HttpRequestBase requestBase = request.build();
        executeWithoutResponse(requestBase);
    }
    /**
     * Create an empty corpus
     *
     * @param accountId String the Account Id,
     * @param corpus    String the corpus name.
     * @param body      String JSON the corpus object
     * @return void
     */
    public void createCorpus(final String accountId, final String corpus, final String body) {
        // TODO Is better to let the user passing java objcet and we have a full handle of JSON
        Validate.notNull(accountId, "account_id can't be null");
        Validate.notNull(corpus, "corpus can't be null");
        Validate.notNull(body, "body can't be null");
        Request request = Request.Put(VERSION + new CorpusId(accountId, corpus).toString());
        request.withContent(body, MediaType.TEXT_PLAIN)
                .withHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).build();
        HttpRequestBase requestBase = request.build();
        executeWithoutResponse(requestBase);
    }
    /**
     * Retrieves the document ids of a corpus
     *
     * @param params String account_id the Account Id,
     *               String corpus the corpus name,
     *               Integer cursor the number of possible items to return. Specify '0' to return the maximum value of 100,000..
     *               Integer limit the number of possible concepts to return.
     *               String query JSON object that allows to filter the list of documents. Valid values are {"status":"error"}, {"status":"processing"}, and {"status":"ready"} which allow to filter documents by status.
     * @return the Documents
     */
    public Documents listDocuments(Map<String, Object> params) {
        Validate.notNull(params.get(ConceptInsightsConstants.ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(params.get(ConceptInsightsConstants.CORPUS), "corpus can't be null");
        String[] queryParameters = new String[]{ConceptInsightsConstants.CURSOR,
                ConceptInsightsConstants.LIMIT};
        Request request = Request.Get(VERSION + new CorpusId((String) params.get(ConceptInsightsConstants.ACCOUNT_ID), (String) params.get(ConceptInsightsConstants.CORPUS)).toString() + FORWARD_SLASH + ConceptInsightsConstants.DOCUMENTS);
        for (String param : queryParameters) {
            if (params.containsKey(param)) {
                request.withQuery(param, params.get(param));
            }
        }
        if (params.get(ConceptInsightsConstants.QUERY) != null) {
            // TODO need to work in the query format
            JsonObject contentJson = new JsonObject();
            JsonArray conceptsJson = new JsonArray();
            for (String value : (List<String>) params.get(ConceptInsightsConstants.QUERY)) {
                conceptsJson.add(new JsonPrimitive(value));
            }
            contentJson.add(ConceptInsightsConstants.QUERY, conceptsJson);
            request.withQuery(ConceptInsightsConstants.QUERY, conceptsJson.toString());
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
     * Retrieves a document from a corpus.
     *
     * @param accountId String the Account Id,
     * @param corpus    String the corpus name.
     * @param document  String the document name.
     * @return the Document
     */
    public Document getDocument(final String accountId, final String corpus, final String document) {
        Validate.notNull(accountId, "account_id can't be null");
        Validate.notNull(corpus, "corpus can't be null");
        Validate.notNull(document, "document can't be null");
        Request request = Request.Get(VERSION + new DocumentId(accountId, corpus, document).toString());
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
     * Creates a document in corpus
     *
     * @param accountId String the Account Id,
     * @param corpus    String the corpus name.
     * @param document  String the document name.
     * @param body      String the document object to create
     * @return void
     */
    public void createDocument(final String accountId, final String corpus, final String document, final Document body) {
        Validate.notNull(accountId, "account_id can't be null");
        Validate.notNull(corpus, "corpus can't be null");
        Validate.notNull(document, "document can't be null");
        Validate.notNull(body, "body can't be null");
        Request request = Request.Put(VERSION + new DocumentId(accountId, corpus, document).toString());
        System.out.println(GsonSingleton.getGson().toJson(body));
        request.withContent(GsonSingleton.getGson().toJson(body), MediaType.TEXT_PLAIN)
                .withHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).build();
        HttpRequestBase requestBase = request.build();
        executeWithoutResponse(requestBase);
    }
    /**
     * Updates a document by ID
     *
     * @param accountId String the Account Id,
     * @param corpus    String the corpus name.
     * @param document  String the document name.
     * @param body      Document the document object to update
     * @return void
     */
    public void updateDocument(final String accountId, final String corpus, final String document, final Document body) {
        Validate.notNull(accountId, "account_id can't be null");
        Validate.notNull(corpus, "corpus can't be null");
        Validate.notNull(document, "document can't be null");
        Validate.notNull(body, "body can't be null");
        Request request = Request.Post(VERSION + new DocumentId(accountId, corpus, document).toString());
        System.out.println(GsonSingleton.getGson().toJson(body));
        request.withContent(GsonSingleton.getGson().toJson(body), MediaType.TEXT_PLAIN)
                .withHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).build();
        HttpRequestBase requestBase = request.build();
        executeWithoutResponse(requestBase);
    }
    /**
     * Delete a document by ID
     *
     * @param accountId String the Account Id,
     * @param corpus    String the corpus name.
     * @param document  String the document name.
     * @return void
     */
    public void deleteDocument(final String accountId, final String corpus, final String document) {
        Validate.notNull(accountId, "account_id can't be null");
        Validate.notNull(corpus, "corpus can't be null");
        Validate.notNull(document, "document can't be null");
        Request request = Request.Delete(VERSION + new DocumentId(accountId, corpus, document).toString());
        HttpRequestBase requestBase = request.build();
        executeWithoutResponse(requestBase);
    }
    /**
     * Get processing state of a Corpus
     *
     * @param accountId String the Account Id,
     * @param corpus    String the corpus name.
     * @return the CorpusProcessingState
     */
    public CorpusProcessingState getCorpusProcessingState(final String accountId, final String corpus) {
        Validate.notNull(accountId, "account_id can't be null");
        Validate.notNull(corpus, "corpus can't be null");
        Request request = Request.Get(VERSION + new CorpusId(accountId, corpus).toString() + FORWARD_SLASH + ConceptInsightsConstants.PROCESSING_STATE);
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
            CorpusProcessingState corpusProcessingState = GsonSingleton.getGson().fromJson(
                    jsonObject, CorpusProcessingState.class);
            return corpusProcessingState;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Get processing state of a Corpus
     *
     * @param accountId String the Account Id,
     * @param corpus    String the corpus name.
     * @return the CorpusStats
     */
    public CorpusStats getCorpusStats(final String accountId, final String corpus) {
        Validate.notNull(accountId, "account_id can't be null");
        Validate.notNull(corpus, "corpus can't be null");
        Request request = Request.Get(VERSION + new CorpusId(accountId, corpus).toString() + FORWARD_SLASH + ConceptInsightsConstants.STATS);
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
            CorpusStats corpusStats = GsonSingleton.getGson().fromJson(
                    jsonObject, CorpusStats.class);
            return corpusStats;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Searches for documents and concepts by using partial matches on the label(s) fields.
     *
     * @param params String account_id, the Account Id,
     *               String corpus, the corpus name,
     *               String query, the Query String,
     *               boolean concepts, Whether to return concepts that have a label match,
     *               boolean prefix, Whether the query string should be treated as a prefix,
     *               Integer limit, Maximum number of items to be returned,
     *               String concept_fields, Additional fields to include in the concept objects. Format is a JSON object, e.g., { "abstract" : 1 } will include the concept abstracts in each concept object.
     *               String document_fields, Additional fields to include in the document objects. Format is a JSON object, e.g., { "user_fields" : 1 } will include the document user_fields member.
     * @return the matches
     */
    public Matches searchCorpusByLabel(Map<String, Object> params) {
        Validate.notNull(params.get(ConceptInsightsConstants.ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(params.get(ConceptInsightsConstants.CORPUS), "corpus can't be null");
        Validate.notNull(params.get(ConceptInsightsConstants.QUERY), "query can't be null");
        String corpus_id = new GraphId((String) params.get(ConceptInsightsConstants.ACCOUNT_ID), (String) params.get(ConceptInsightsConstants.CORPUS)).toString();
        Map<String, Object> queryParameters = new HashMap<String, Object>();
        String[] parameters = new String[]{ConceptInsightsConstants.QUERY,
                ConceptInsightsConstants.PREFIX, ConceptInsightsConstants.LIMIT, ConceptInsightsConstants.CONCEPTS};
        for (String param : parameters) {
            if (params.containsKey(param))
                queryParameters.put(param, params.get(param));
        }
        // Concept Field JSON
        if (params.get(ConceptInsightsConstants.CONCEPT_FIELDS) != null) {
            JsonObject conceptFieldJson = new JsonObject();
            JsonArray conceptFieldJsonArray = new JsonArray();
            for (String value : (List<String>) params.get(ConceptInsightsConstants.CONCEPT_FIELDS)) {
                conceptFieldJsonArray.add(new JsonPrimitive(value));
            }
            conceptFieldJson.add(ConceptInsightsConstants.CONCEPT_FIELDS, conceptFieldJsonArray);
            queryParameters.put(ConceptInsightsConstants.CONCEPT_FIELDS, conceptFieldJsonArray.toString());
        }
        // document Field JSON
        if (params.get(ConceptInsightsConstants.DOCUMENT_FIELDS) != null) {
            JsonObject documentFieldJson = new JsonObject();
            JsonArray documentFieldJsonJsonArray = new JsonArray();
            for (String value : (List<String>) params.get(ConceptInsightsConstants.DOCUMENT_FIELDS)) {
                documentFieldJsonJsonArray.add(new JsonPrimitive(value));
            }
            documentFieldJson.add(ConceptInsightsConstants.DOCUMENT_FIELDS, documentFieldJsonJsonArray);
            queryParameters.put(ConceptInsightsConstants.DOCUMENT_FIELDS, documentFieldJsonJsonArray.toString());
        }
        return getConceptByLabel(VERSION + corpus_id + FORWARD_SLASH + ConceptInsightsConstants.LABEL_SEARCH, queryParameters);
    }
    /**
     * Retrieves concepts that are related to an entire corpus
     *
     * @param parameters String account_id, the Account Id,
     *                   String corpus, the corpus name,
     *                   Integer level, Number in the range 0 - 3 that represents the level of popularity of related concepts,
     *                   Integer limit, Maximum number of items to be returned,
     *                   String concept_fields, Additional fields to include in the concept objects. Format is a JSON object, e.g., { "abstract" : 1 } will include the concept abstracts in each concept object.
     * @return the Concepts
     */
    public Concepts getCorpusRelatedConcepts(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ConceptInsightsConstants.ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(ConceptInsightsConstants.CORPUS), "corpus can't be null");
        String corpus_id = new CorpusId((String) parameters.get(ConceptInsightsConstants.ACCOUNT_ID), (String) parameters.get(ConceptInsightsConstants.CORPUS)).toString();
        Map<String, Object> queryParameters = new HashMap<String, Object>();
        String[] params = new String[]{ConceptInsightsConstants.LEVEL, ConceptInsightsConstants.LIMIT};
        for (String param : params) {
            if (parameters.containsKey(param))
                queryParameters.put(param, parameters.get(param));
        }
        if (parameters.get(ConceptInsightsConstants.CONCEPT_FIELDS) != null) {
            JsonArray conceptFieldJsonArray = new JsonArray();
            for (String value : (List<String>) parameters.get(ConceptInsightsConstants.CONCEPT_FIELDS)) {
                conceptFieldJsonArray.add(new JsonPrimitive(value));
            }
            queryParameters.put(ConceptInsightsConstants.CONCEPT_FIELDS, conceptFieldJsonArray.toString());
        }
        return getRelatedConcepts(VERSION + corpus_id + FORWARD_SLASH + ConceptInsightsConstants.RELATED_CONCEPTS, queryParameters);
    }
    /**
     * Returns a list of scores that denotes how related an entire corpus is to a list of individual concepts
     *
     * @param parameters String account_id, the Account Id,
     *                   String corpus, the corpus name,
     *                   String concepts, References to Concept URIs.
     * @return the Scores
     */
    public Scores getCorpusRelationScores(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ConceptInsightsConstants.ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(ConceptInsightsConstants.CORPUS), "corpus can't be null");
        Validate.notNull(parameters.get(ConceptInsightsConstants.CONCEPTS), "concepts can't be null");
        Map<String, Object> queryParameters = new HashMap<String, Object>();
        JsonObject contentJson = new JsonObject();
        JsonArray conceptsJson = new JsonArray();
        for (String value : (List<String>) parameters.get(ConceptInsightsConstants.CONCEPTS)) {
            conceptsJson.add(new JsonPrimitive(value));
        }
        contentJson.add(ConceptInsightsConstants.CONCEPTS, conceptsJson);
        queryParameters.put(ConceptInsightsConstants.CONCEPTS, conceptsJson.toString());
        return getRelationScores(VERSION+new CorpusId((String) parameters.get(ConceptInsightsConstants.ACCOUNT_ID), (String) parameters.get(ConceptInsightsConstants.CORPUS)).toString()+FORWARD_SLASH+ConceptInsightsConstants.RELATION_SCORES,queryParameters);
    }
    /**
     * Performs a conceptual search within a corpus.
     *
     * @param params String account_id, the Account Id,
     *               String corpus, the corpus name,
     *               String ids, String field JSON array of concept and/or document ids,
     *               Integer cursor, Number of items to skip,
     *               Integer limit, Number of possible documents to return,
     *               String concept_fields, Additional fields to include in the concept objects. Format is a JSON object, e.g., { "abstract" : 1 } will include the concept abstracts in each concept object.
     *               String document_fields, Additional fields to include in the document objects. Format is a JSON object, e.g., { "user_fields" : 1 } will include the document user_fields member.
     * @return the QueryConcepts
     */
    public QueryConcepts conceptualSearch(Map<String, Object> params) {
        Validate.notNull(params.get(ConceptInsightsConstants.ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(params.get(ConceptInsightsConstants.CORPUS), "corpus can't be null");
        Validate.notNull(params.get(ConceptInsightsConstants.IDS), "ids can't be null");
        Request request = Request.Get(VERSION + new CorpusId((String) params.get(ConceptInsightsConstants.ACCOUNT_ID), (String) params.get(ConceptInsightsConstants.CORPUS)).toString()
                + FORWARD_SLASH + ConceptInsightsConstants.CONCEPTUAL_SEARCH);
        String[] queryParameters = new String[]{
                ConceptInsightsConstants.CURSOR, ConceptInsightsConstants.LIMIT};
        for (String param : queryParameters) {
            if (params.containsKey(param))
                request.withQuery(param, params.get(param));
        }
        JsonArray IdsJsonArray = new JsonArray();
        for (String value : (List<String>) params.get(ConceptInsightsConstants.IDS)) {
            IdsJsonArray.add(new JsonPrimitive(value));
        }
        request.withQuery(ConceptInsightsConstants.IDS, IdsJsonArray.toString());
        if (params.get(ConceptInsightsConstants.CONCEPT_FIELDS) != null) {
            JsonArray conceptFieldJsonArray = new JsonArray();
            for (String value : (List<String>) params.get(ConceptInsightsConstants.CONCEPT_FIELDS)) {
                conceptFieldJsonArray.add(new JsonPrimitive(value));
            }
            request.withQuery(ConceptInsightsConstants.CONCEPT_FIELDS, conceptFieldJsonArray.toString());
        }
        if (params.get(ConceptInsightsConstants.DOCUMENT_FIELDS) != null) {
            JsonArray documentFieldJsonJsonArray = new JsonArray();
            for (String value : (List<String>) params.get(ConceptInsightsConstants.DOCUMENT_FIELDS)) {
                documentFieldJsonJsonArray.add(new JsonPrimitive(value));
            }
            request.withQuery(ConceptInsightsConstants.DOCUMENT_FIELDS, documentFieldJsonJsonArray.toString());
        }
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            String jsonString = ResponseUtil.getString(response);
            QueryConcepts concepts = GsonSingleton.getGson().fromJson(
                    jsonString, QueryConcepts.class);
            return concepts;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Retrieves conceptual view of document (including annotations).
     *
     * @param accountId String the Account Id,
     * @param corpus    String the corpus name,
     * @param document  String the document name.
     *
     * @return the DocumentAnnotations
     */
    public DocumentAnnotations getDocumentAnnotations(final String  accountId,final String corpus,final String document) {
        Validate.notNull(accountId, "account_id can't be null");
        Validate.notNull(corpus, "corpus can't be null");
        Validate.notNull(document, "document can't be null");
        Request request = Request.Get(VERSION+new DocumentId(accountId,corpus,document).toString()+FORWARD_SLASH+ConceptInsightsConstants.ANNOTATIONS);
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
     * @param accountId String the Account Id,
     * @param corpus    String the corpus name,
     * @param document  String the document name.
     *
     * @return the DocumentProcessingState
     */
    public DocumentProcessingState getDocumentProcessingState(final String  accountId,final String corpus,final String document) {
        Validate.notNull(accountId, "account_id can't be null");
        Validate.notNull(corpus, "corpus can't be null");
        Validate.notNull(document, "document can't be null");
        Request request = Request.Get(VERSION+new DocumentId(accountId,corpus,document).toString()+FORWARD_SLASH+ConceptInsightsConstants.PROCESSING_STATE);
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            String jsonString = ResponseUtil.getString(response);
            DocumentProcessingState documentProcessingState = GsonSingleton.getGson().fromJson(
                    jsonString, DocumentProcessingState.class);
            return documentProcessingState;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Retrieve concepts that are related (in conceptual sense) to a given document.
     *
     * @param parameters String account_id, the Account Id,
     *               String corpus, the corpus name,
     *               String document, the document name,
     *               Integer level, number in the range 0 - 3 that represents the level of popularity of related concepts.
     *               Integer limit, Number of possible concepts to return.
     *               String concept_fields, Additional fields to include in the concept objects. Format is a JSON object, e.g., { "abstract" : 1 } will include the concept abstracts in each concept object.
     * @return the Concepts
     */
    public Concepts getDocumentRelatedConcepts(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ConceptInsightsConstants.ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(ConceptInsightsConstants.CORPUS), "corpus can't be null");
        Validate.notNull(parameters.get(ConceptInsightsConstants.DOCUMENT), "document can't be null");
        String[] queryParameters = new String[]{ConceptInsightsConstants.LEVEL, ConceptInsightsConstants.LIMIT};
        Map<String,Object> queryParams = new HashMap<String, Object>();
        for (String param : queryParameters) {
            if (parameters.containsKey(param))
                queryParams.put(param, parameters.get(param));
        }
        if (parameters.get(ConceptInsightsConstants.CONCEPT_FIELDS) != null) {
            JsonArray conceptFieldJsonArray = new JsonArray();
            for (String value : (List<String>) parameters.get(ConceptInsightsConstants.CONCEPT_FIELDS)) {
                conceptFieldJsonArray.add(new JsonPrimitive(value));
            }
            queryParams.put(ConceptInsightsConstants.CONCEPT_FIELDS, conceptFieldJsonArray.toString());
        }
        return getRelatedConcepts(VERSION+new DocumentId((String)parameters.get(ConceptInsightsConstants.ACCOUNT_ID),(String)parameters.get(ConceptInsightsConstants.CORPUS),(String)parameters.get(ConceptInsightsConstants.DOCUMENT)).toString()+
                FORWARD_SLASH+ConceptInsightsConstants.RELATED_CONCEPTS,queryParams);
    }
    /**
     * Retrieve concepts that are related (in conceptual sense) to a given document.
     *
     * @param parameters String account_id, the Account Id,
     *               String corpus, the corpus name,
     *               String document, the document name,
     *               String concepts, String field JSON array of concept IDs.s.
     * @return the Concepts
     */
    public Scores getDocumentRelationScores(Map<String, Object> parameters) {
        Validate.notNull(parameters.get(ConceptInsightsConstants.ACCOUNT_ID), "account_id can't be null");
        Validate.notNull(parameters.get(ConceptInsightsConstants.CORPUS), "corpus can't be null");
        Validate.notNull(parameters.get(ConceptInsightsConstants.DOCUMENT), "document can't be null");
        Validate.notNull(parameters.get(ConceptInsightsConstants.CONCEPTS), "document can't be null");
        Map<String,Object> queryParams = new HashMap<String, Object>();
        JsonObject contentJson = new JsonObject();
        JsonArray conceptsJson = new JsonArray();
        for (String value : (List<String>) parameters.get(ConceptInsightsConstants.CONCEPTS)) {
            conceptsJson.add(new JsonPrimitive(value));
        }
        contentJson.add(ConceptInsightsConstants.CONCEPTS, conceptsJson);
        queryParams.put(ConceptInsightsConstants.CONCEPTS, conceptsJson.toString());
        return getRelationScores(VERSION+new DocumentId((String)parameters.get(ConceptInsightsConstants.ACCOUNT_ID),(String)parameters.get(ConceptInsightsConstants.CORPUS),(String)parameters.get(ConceptInsightsConstants.DOCUMENT)).toString()+
                FORWARD_SLASH+ConceptInsightsConstants.RELATION_SCORES,queryParams);
    }

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
}

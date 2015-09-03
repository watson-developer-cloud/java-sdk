//
///*
// * *
// *  * Copyright 2015 IBM Corp. All Rights Reserved.
// *  *
// *  * Licensed under the Apache License, Version 2.0 (the "License");
// *  * you may not use this file except in compliance with the License.
// *  * You may obtain a copy of the License at
// *  *
// *  *      http://www.apache.org/licenses/LICENSE-2.0
// *  *
// *  * Unless required by applicable law or agreed to in writing, software
// *  * distributed under the License is distributed on an "AS IS" BASIS,
// *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// *  * See the License for the specific language governing permissions and
// *  * limitations under the License.
// *
// */
//
//package com.ibm.watson.developer_cloud.concept_insights.v2;
//
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonPrimitive;
//import com.ibm.watson.developer_cloud.concept_insights.v2.model.*;
//import com.ibm.watson.developer_cloud.service.Request;
//import com.ibm.watson.developer_cloud.util.GsonSingleton;
//import com.ibm.watson.developer_cloud.util.HttpHeaders;
//import com.ibm.watson.developer_cloud.util.MediaType;
//import com.ibm.watson.developer_cloud.util.ResponseUtil;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.methods.HttpRequestBase;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//import java.util.MissingFormatArgumentException;
//
///**
// * Concept Insights Graphs provides APIs that enable you to work with concept graphs
// *
// * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
// * @version v2
// * @see <a
// * href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/concept_insights.html">
// * Concept Insights Graphs</a>
// */
//public class ConceptInsightsGraphs extends ConceptInsights {
//
//    public ConceptInsightsGraphs() {
//    }
//
//    /**
//     * Retrieves the available Graphs.
//     *
//     * @return the graphs
//     */
//    public Graphs getGraphs() {
//        Request request = Request.Get(GRAPHS_PATH);
//        HttpRequestBase requestBase = request.build();
//        try {
//            HttpResponse response = execute(requestBase);
//            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
//            Graphs graphs = GsonSingleton.getGson().fromJson(
//                    jsonObject, Graphs.class);
//            return graphs;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * Searches for graph concepts by using partial matches
//     *
//     * @param params
//     * @return the matches
//     */
//    public Matches searchConceptByLabel(Map<String, Object> params) {
//
//        if (StringUtils.isEmpty((String) params.get(ACCOUNT_ID)))
//            throw new MissingFormatArgumentException("account_id can't be null");
//
//        if (StringUtils.isEmpty((String) params.get(GRAPH_ID)))
//            throw new MissingFormatArgumentException("graph_id can't be null");
//
//        if (StringUtils.isEmpty(QUERY))
//            throw new MissingFormatArgumentException("query can't be null");
//
//        StringBuilder path = new StringBuilder().append(GRAPHS_PATH).append(FORWARD_SLASH).
//                append((String) params.get(ACCOUNT_ID)).append(FORWARD_SLASH).append((String) params.get(GRAPH_ID)).
//                append(FORWARD_SLASH).append(LABEL_SEARCH);
//
//        Request request = Request.Get(path.toString());
//
//        String[] queryParameters = new String[]{QUERY,
//                PREFIX, LIMIT};
//
//        for (String param : queryParameters) {
//            if (params.containsKey(param))
//                request.withQuery(param, params.get(param));
//        }
//
//        HttpRequestBase requestBase = request.build();
//        try {
//            HttpResponse response = execute(requestBase);
//            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
//            Matches matches = GsonSingleton.getGson().fromJson(
//                    jsonObject, Matches.class);
//            return matches;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    /**
//     * Retrieves concepts that are related to a concept
//     *
//     * @param params
//     * @return the concepts
//     */
//    public Concepts getRelatedConcepts(Map<String, Object> params) {
//
//        if (StringUtils.isEmpty((String) params.get(ACCOUNT_ID)))
//            throw new MissingFormatArgumentException("account_id can't be null");
//
//        if (StringUtils.isEmpty((String) params.get(GRAPH_ID)))
//            throw new MissingFormatArgumentException("graph_id can't be null");
//
//        if (params.get(CONCEPTS) == null && (String) params.get(CONCEPT_ID) == null)
//            throw new MissingFormatArgumentException("concepts or concept_id should be identified");
//
//        StringBuilder path = new StringBuilder().append(GRAPHS_PATH).append(FORWARD_SLASH).
//                append((String) params.get(ACCOUNT_ID)).append(FORWARD_SLASH).append((String) params.get(GRAPH_ID));
//
//        Request request = null;
//
//        String[] queryParameters = new String[]{LEVEL,
//                LIMIT};
//
//        if (params.get(CONCEPTS) != null) {
//            path.append(FORWARD_SLASH).append(RELATED_CONCEPTS);
//            request = Request.Get(path.toString());
//            JsonObject contentJson = new JsonObject();
//            JsonArray conceptsJson = new JsonArray();
//            for (String value : (List<String>) params.get(CONCEPTS)) {
//                conceptsJson.add(new JsonPrimitive(value));
//            }
//            contentJson.add(CONCEPTS, conceptsJson);
//            request.withQuery(CONCEPTS, conceptsJson.toString());
//        } else if ((String) params.get(CONCEPT_ID) != null) {
//            path.append(FORWARD_SLASH).append(CONCEPTS).append(FORWARD_SLASH).append((String) params.get(CONCEPT_ID)).append(FORWARD_SLASH).append(RELATED_CONCEPTS);
//            request = Request.Get(path.toString());
//        }
//
//        for (String param : queryParameters) {
//            if (params.containsKey(param)) {
//                request.withQuery(param, params.get(param));
//            }
//        }
//        HttpRequestBase requestBase = request.build();
//        try {
//            HttpResponse response = execute(requestBase);
//            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
//            Concepts concepts1 = GsonSingleton.getGson().fromJson(
//                    jsonObject, Concepts.class);
//            return concepts1;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    /**
//     * Identifies concepts in a piece of text
//     *
//     * @param params
//     * @return the
//     */
//    public Annotations annotateText(Map<String, Object> params) {
//
//        String body = (String) params.get(BODY);
//
//        if (StringUtils.isEmpty((String) params.get(ACCOUNT_ID)))
//            throw new MissingFormatArgumentException("account_id can't be null");
//
//        if (StringUtils.isEmpty((String) params.get(GRAPH_ID)))
//            throw new MissingFormatArgumentException("graph_id can't be null");
//
//        if (body == null)
//            throw new MissingFormatArgumentException("body can't be null");
//
//        StringBuilder path = new StringBuilder().append(GRAPHS_PATH).append(FORWARD_SLASH).
//                append((String) params.get(ACCOUNT_ID)).append(FORWARD_SLASH).append((String) params.get(GRAPH_ID)).
//                append(FORWARD_SLASH).append(ANNOTATE_TEXT);
//
//        Request request = Request.Post(path.toString());
//
//        request.withContent(body, MediaType.TEXT_PLAIN)
//                .withHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).build();
//
//        HttpRequestBase requestBase = request.build();
//        try {
//            HttpResponse response = execute(requestBase);
//            String jsonstring = ResponseUtil.getString(response);
//            Annotations annotations = GsonSingleton.getGson().fromJson(
//                    jsonstring, Annotations.class);
//            return annotations;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * Retrieves the meta data of the concept
//     *
//     * @param params
//     * @return the concept meta data
//     */
//    public ConceptMetaData getConcept(Map<String, Object> params) {
//
//        if (StringUtils.isEmpty((String) params.get(ACCOUNT_ID)))
//            throw new MissingFormatArgumentException("account_id can't be null");
//
//        if (StringUtils.isEmpty((String) params.get(GRAPH_ID)))
//            throw new MissingFormatArgumentException("graph_id can't be null");
//
//        if ((String) params.get(CONCEPT_ID) == null)
//            throw new MissingFormatArgumentException("concept_id can't be null");
//
//        StringBuilder path = new StringBuilder().append(GRAPHS_PATH).append(FORWARD_SLASH).
//                append((String) params.get(ACCOUNT_ID)).append(FORWARD_SLASH).append((String) params.get(GRAPH_ID)).
//                append(FORWARD_SLASH).append(CONCEPTS).append(FORWARD_SLASH).append((String) params.get(CONCEPT_ID));
//
//        Request request = Request.Get(path.toString());
//
//        HttpRequestBase requestBase = request.build();
//        try {
//            HttpResponse response = execute(requestBase);
//            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
//            ConceptMetaData conceptMetaData = GsonSingleton.getGson().fromJson(
//                    jsonObject, ConceptMetaData.class);
//            return conceptMetaData;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * Returns a list of scores that denotes how related a source concept is
//     * to a list of individual concepts
//     *
//     * @param params
//     * @return the scores
//     */
//    public Scores getRelationScores(Map<String, Object> params) {
//
//        if (StringUtils.isEmpty((String) params.get(ACCOUNT_ID)))
//            throw new MissingFormatArgumentException("account_id can't be null");
//
//        if (StringUtils.isEmpty((String) params.get(GRAPH_ID)))
//            throw new MissingFormatArgumentException("graph_id can't be null");
//
//        if (params.get(CONCEPTS) == null)
//            throw new MissingFormatArgumentException("concepts can't be null");
//
//        if ((String) params.get(CONCEPT_ID) == null)
//            throw new MissingFormatArgumentException("conceptId can't be null");
//
//        StringBuilder path = new StringBuilder().append(GRAPHS_PATH).append(FORWARD_SLASH).
//                append((String) params.get(ACCOUNT_ID)).append(FORWARD_SLASH).append((String) params.get(GRAPH_ID)).append(FORWARD_SLASH).
//                append(CONCEPTS).append(FORWARD_SLASH).append((String) params.get(CONCEPT_ID)).append(FORWARD_SLASH).append(RELATION_SCORES);
//
//        Request request = Request.Get(path.toString());
//        JsonObject contentJson = new JsonObject();
//        JsonArray conceptsJson = new JsonArray();
//        for (String value : (List<String>) params.get(CONCEPTS)) {
//            conceptsJson.add(new JsonPrimitive(value));
//        }
//        contentJson.add(CONCEPTS, conceptsJson);
//        request.withQuery(CONCEPTS, conceptsJson.toString());
//
//        HttpRequestBase requestBase = request.build();
//        try {
//            HttpResponse response = execute(requestBase);
//            JsonObject jsonObject = ResponseUtil.getJsonObject(response);
//            Scores scores = GsonSingleton.getGson().fromJson(
//                    jsonObject, Scores.class);
//            return scores;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

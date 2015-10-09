/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */

package com.ibm.watson.developer_cloud.concept_insights.v2.util;

import com.ibm.watson.developer_cloud.concept_insights.v2.model.Concept;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Corpus;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Document;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Graph;
import com.ibm.watson.developer_cloud.util.Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nizar alseddeg.
 */
public class ConceptInsightsId {

    /**
     * The CORPUS_ID_REGEX. (format is "/corpora/{account_id}/{corpus}")
     */
    private final static String CORPUS_ID_REGEX = "^/corpora/[_\\-\\w\\s]*/[_\\-\\w\\s]*$";

    /**
     * The GRAPH_ID_REGEX. (format is "/graphs/{account_id}/{graph}")
     */
    private final static String GRAPH_ID_REGEX = "^/graphs/[_\\-\\w\\s]*/[_\\-\\w\\s]*$";

    /**
     * The DOCUMENT_ID_REGEX. (format is "/corpora/{account_id}/{corpus}/documents/{document}")
     */
    private final static String DOCUMENT_ID_REGEX = "^/corpora/[_\\-\\w\\s]*/[_\\-\\w\\s]*/documents/[_\\-\\w\\s]*$";

    /**
     * The CONCEPT_ID_REGEX. (format is "/graphs/{account_id}/{graph}/concepts/{concept}")
     */
    private final static String CONCEPT_ID_REGEX = "^/graphs/[_\\-\\w\\s]*/[_\\-\\w\\s]*/concepts/[_\\-\\w\\s]*$";

    /**
     * This method validate the id if it has been populated in the corpus object, otherwise it will generated it.
     *
     * @param corpus    Corpus the corpus object,
     * @param accoundId String the account id.
     */
    public static void validateGenarate(Corpus corpus, String accoundId) {
        Validate.notNull(corpus, "corpus can't be null");
        if (corpus.getId() != null) {
            validate(CORPUS_ID_REGEX, corpus.getId(), "Provide a valid corpus.id (format is " + '"' + "/corpora/{account_id}/{corpus} +" + '"' + ")");
        } else {
            Validate.notNull(corpus.getName(), "corpus.name can't be null");
            corpus.setId("/corpora/" + accoundId + "/" + corpus.getName());
        }
    }

    /**
     * This method validate the id if it has been populated in the graph object, otherwise it will generated it.
     *
     * @param graph     Graph the graph object,
     * @param accoundId String the account id.
     */
    public static void validateGenarate(Graph graph, String accoundId) {
        Validate.notNull(graph, "graph object can't be null");
        if (graph.getId() != null) {
            validate(GRAPH_ID_REGEX, graph.getId(), "Provide a valid graph.id (format is " + '"' + " (/graphs/{account_id}/{graph}) +" + '"' + ")");
        } else {
            Validate.notNull(graph.getName(), "graph.name can't be null");
            graph.setId("/graphs/" + accoundId + "/" + graph.getName());
        }
    }

    /**
     * The purpose of this method to validate / generate the document.id.
     *
     * @param document   Document the document object,
     * @param accoundId  String the account id.
     * @param corpusName String the corpus name.
     */
    public static void validateGenarate(Document document, String accoundId, String corpusName) {
        Validate.notNull(document, "document can't be null");
        if (document.getId() != null) {
            validate(DOCUMENT_ID_REGEX, document.getId(), "Provide a valid document.id (format is " + '"' + " (/corpora/{account_id}/{corpus}/documents/{document}) +" + '"' + ")");
        } else {
            Validate.notNull(document.getName(), "document.name can't be null");
            Validate.notNull(corpusName, "corpusName can't be null");
            document.setId("/corpora/" + accoundId + "/" + corpusName + "/documents/" + document.getName());
        }
    }

    /**
     * The purpose of this method to validate / generate the concept.id.
     *
     * @param concept   Document the document object,
     * @param accoundId String the account id.
     * @param graphName String the graph name.
     */
    public static void validateGenarate(Concept concept, String accoundId, String graphName) {
        Validate.notNull(concept, "concept can't be null");
        if (concept.getId() != null) {
            validate(CONCEPT_ID_REGEX, concept.getId(), "Provide a valid concept.id (format is " + '"' + " (/graphs/{account_id}/{graph}/concepts/{concept})+" + '"' + ")");
        } else {
            Validate.notNull(concept.getName(), "concept.name can't be null");
            Validate.notNull(graphName, "graphName can't be null");
            concept.setId("/graphs/" + accoundId + "/" + graphName + "/concepts/" + concept.getName());
        }
    }

    /**
     * ID validation.
     *
     * @param regex   the id regex,
     * @param id      the id to be check.
     * @param message the exception message if invalid.
     */
    private static void validate(String regex, String id, String message) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(id);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(message);
        }
    }

}

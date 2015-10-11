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
package com.ibm.watson.developer_cloud.concept_insights.v2.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Concept;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Corpus;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Document;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Graph;
import com.ibm.watson.developer_cloud.util.Validate;

/**
 * Validate resource ids such us corpus_id, graph_id, concept_id, and document_id for
 * {@link ConceptInsights},
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class IDValidator {

	/**
	 * The CORPUS_ID_REGEX. (format is "/corpora/{account_id}/{corpus}")
	 */
	private final static String CORPUS_ID_REGEX = "^/corpora/[_\\-\\w\\s]*/[_\\-\\w\\s]*$";

	/**
	 * The GRAPH_ID_REGEX. (format is "/graphs/{account_id}/{graph}")
	 */
	private final static String GRAPH_ID_REGEX = "^/graphs/[_\\-\\w\\s]*/[_\\-\\w\\s]*$";

	/**
	 * The DOCUMENT_ID_REGEX. (format is
	 * "/corpora/{account_id}/{corpus}/documents/{document}")
	 */
	private final static String DOCUMENT_ID_REGEX = "^/corpora/[_\\-\\w\\s]*/[_\\-\\w\\s]*/documents/[_\\-\\w\\s]*$";

	/**
	 * The CONCEPT_ID_REGEX. (format is "/graphs/{account_id}/{graph}/concepts/{concept}")
	 */
	private final static String CONCEPT_ID_REGEX = "^/graphs/[_\\-\\w\\s]*/[_\\-\\w\\s]*/concepts/[_\\-\\w\\s]*$";

	/**
	 * This method validate the id if it has been populated in the corpus object,
	 * otherwise it will generated it.
	 *
	 * @param corpus            Corpus the corpus object,
	 * @param accoundId            String the account id.
	 * @return the corpus id
	 */
	public static String getCorpusId(final Corpus corpus,final String accoundId) {
		Validate.notNull(corpus, "corpus can't be null");
		if (corpus.getId() != null) {
			validate(CORPUS_ID_REGEX, corpus.getId(), "Provide a valid corpus.id (format is " + '"'
					+ "/corpora/{account_id}/{corpus} +" + '"' + ")");
			return corpus.getId();
		} else {
			Validate.notNull(corpus.getName(), "corpus.name can't be null");
			return "/corpora/" + accoundId + "/" + corpus.getName();
		}
	}

	/**
	 * This method validate the id if it has been populated in the graph object, otherwise
	 * it will generated it.
	 *
	 * @param graph            Graph the graph object,
	 * @param accoundId            String the account id.
	 * @return the graph id
	 */
	public static String getGraphId(final Graph graph,final String accoundId) {
		Validate.notNull(graph, "graph object can't be null");
		if (graph.getId() != null) {
			validate(GRAPH_ID_REGEX, graph.getId(), "Provide a valid graph.id (format is " + '"'
					+ " (/graphs/{account_id}/{graph}) +" + '"' + ")");
			return graph.getId();
		} else {
			Validate.notNull(graph.getName(), "graph.name can't be null");
			return "/graphs/" + accoundId + "/" + graph.getName();
		}
	}

	/**
	 * The purpose of this method to validate / generate the document.id.
	 *
	 * @param document            Document the document object,
	 * @return the document id
	 */
	public static String getDocumentId(final Document document) {
		Validate.notNull(document, "document can't be null");
		Validate.notNull(document.getId(), "document.id can't be null");

		validate(DOCUMENT_ID_REGEX, document.getId(), "Provide a valid document.id (format is " + '"'
				+ " (/corpora/{account_id}/{corpus}/documents/{document}) +" + '"' + ")");
		return document.getId();
	}

	/**
	 * The purpose of this method to validate / generate the concept.id.
	 *
	 * @param concept            the concept object,
	 * @return the concept id
	 */
	public static String getConceptId(final Concept concept) {
		Validate.notNull(concept, "concept can't be null");
		Validate.notNull(concept.getId(), "concept.id can't be null");

		validate(CONCEPT_ID_REGEX, concept.getId(), "Provide a valid concept.id (format is " + '"'
					+ " (/graphs/{account_id}/{graph}/concepts/{concept})+" + '"' + ")");
		return concept.getId();
	}

	/**
	 * ID validation.
	 *
	 * @param regex
	 *            the regex the regular expression used during the validation,
	 * @param id
	 *            the id to be check.
	 * @param message
	 *            the exception message if invalid.
	 */
	private static void validate(final String regex,final String id,final String message) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(id);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(message);
		}
	}

}

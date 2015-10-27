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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
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

/**
 * The Class ConceptInsightsTest.
 */
public class ConceptInsightsTest extends WatsonServiceTest {

	/** The Constant PUBLIC. */
	private static final String PUBLIC = "public";
	/** The service. */
	private ConceptInsights service;

	/** The example concept. Value is "/graphs/wikipedia/en-20120601/IBM */
	private final Concept EXAMPLE_CONCEPT = new Concept(Graph.WIKIPEDIA, "IBM");

	/** The example document. Value is "/graphs/public/ibmresearcher/il-AHARONA */
	private final Document EXAMPLE_DOCUMENT = new Document(Corpus.IBM_RESEARCHERS, "il-AHARONA");

	/**
	 * Test conceptual search.
	 */
	@Test
	public void testConceptualSearch() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<String> ids = new ArrayList<String>();
		ids.add(EXAMPLE_CONCEPT.getId());
		params.put(ConceptInsights.IDS, ids);
		params.put(ConceptInsights.LIMIT, 10);
		params.put(ConceptInsights.CURSOR, 0);
		QueryConcepts cp = service.conceptualSearch(Corpus.TED_TALKS, params);
		Assert.assertNotNull(cp);
	}

	/**
	 * Test document annotations.
	 */
	@Test
	public void testDocumentAnnotations() {
		DocumentAnnotations annotations = service.getDocumentAnnotations(EXAMPLE_DOCUMENT);
		Assert.assertNotNull(annotations);
	}

	/**
	 * Test get concept.
	 */
	@Test
	public void testGetConcept() {
		ConceptMetadata conceptMetaData = service.getConcept(EXAMPLE_CONCEPT);
		Assert.assertNotNull(conceptMetaData);

	}

	/**
	 * Test get corpora by account.
	 */
	@Test
	public void testGetCorporaByAccount() {
		Corpora corpora = service.listCorpora(PUBLIC);
		Assert.assertNotNull(corpora);
		Assert.assertFalse(corpora.getCorpora().isEmpty());

		corpora = service.listCorpora();
		Assert.assertNotNull(corpora);
		Assert.assertFalse(corpora.getCorpora().isEmpty());
	}

	/**
	 * Test get corpus.
	 */
	@Test
	public void testGetCorpus() {
		Corpus corpus = service.getCorpus(Corpus.IBM_RESEARCHERS);
		Assert.assertNotNull(corpus);
		corpus = service.getCorpus(Corpus.TED_TALKS);
		Assert.assertNotNull(corpus);
	}

	/**
	 * Test get corpus label search.
	 */
	@Test
	public void testGetCorpusLabelSearch() {
		Map<String, Object> query = new HashMap<String, Object>();
		query.put(ConceptInsights.QUERY, "IBM");
		query.put(ConceptInsights.LIMIT, 10);
		query.put(ConceptInsights.PREFIX, false);
		Matches matches = service.searchCorpusByLabel(Corpus.IBM_RESEARCHERS, query);
		Assert.assertNotNull(matches);
	}

	/**
	 * Test get corpus processing state.
	 */
	@Test
	public void testGetCorpusProcessingState() {
		CorpusProcessingState corpusProcessingState = service.getCorpusProcessingState(Corpus.IBM_RESEARCHERS);
		Assert.assertNotNull(corpusProcessingState);
	}

	/**
	 * Test get corpus related concept.
	 */
	@Test
	public void testGetCorpusRelatedConcept() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(ConceptInsights.LIMIT, 10);
		params.put(ConceptInsights.PREFIX, false);
		Concepts concepts = service.getCorpusRelatedConcepts(Corpus.IBM_RESEARCHERS, params);
		Assert.assertNotNull(concepts);
	}

	/**
	 * Test get corpus relation scores.
	 */
	@Test
	public void testGetCorpusRelationScores() {
		List<Concept> concepts = new ArrayList<Concept>();
		concepts.add(EXAMPLE_CONCEPT);
		Scores scores = service.getCorpusRelationScores(Corpus.IBM_RESEARCHERS, concepts);
		Assert.assertNotNull(scores);
	}

	/**
	 * Test get corpus stats.
	 */
	@Test
	public void testGetCorpusStats() {
		CorpusStats corpusStats = service.getCorpusStats(Corpus.IBM_RESEARCHERS);
		Assert.assertNotNull(corpusStats);
	}

	/**
	 * Test get document.
	 */
	@Test
	public void testGetDocument() {
		Document document = service.getDocument(EXAMPLE_DOCUMENT);
		Assert.assertNotNull(document);
	}

	/**
	 * Test get document processing state.
	 */
	@Test
	public void testGetDocumentProcessingState() {
		DocumentProcessingStatus documentProcessingState = service.getDocumentProcessingState(EXAMPLE_DOCUMENT);
		Assert.assertNotNull(documentProcessingState);
	}

	/**
	 * Test get document related concepts.
	 */
	@Test
	public void testGetDocumentRelatedConcepts() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(ConceptInsights.LEVEL, "1");
		params.put(ConceptInsights.LIMIT, 10);
		Concepts concepts = service.getDocumentRelatedConcepts(EXAMPLE_DOCUMENT, params);
		Assert.assertNotNull(concepts);
	}

	/**
	 * Test get document relation scores.
	 */
	@Test
	public void testGetDocumentRelationScores() {
		List<Concept> concepts = new ArrayList<Concept>();
		concepts.add(EXAMPLE_CONCEPT);
		Scores scores = service.getDocumentRelationScores(EXAMPLE_DOCUMENT, concepts);
		Assert.assertNotNull(scores);
	}

	/**
	 * Test get documnet related concepts.
	 */
	@Test
	public void testGetDocumnetRelatedConcepts() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(ConceptInsights.LEVEL, "1");
		params.put(ConceptInsights.LIMIT, 10);
		Concepts concepts = service.getDocumentRelatedConcepts(EXAMPLE_DOCUMENT, params);
		Assert.assertNotNull(concepts);
	}

	/**
	 * Test get graphs label search.
	 */
	@Test
	public void testGetGraphsLabelSearch() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(ConceptInsights.QUERY, "cognitv");
		params.put(ConceptInsights.LIMIT, 10);
		params.put(ConceptInsights.PREFIX, false);

		RequestedFields fs = new RequestedFields();
		fs.include("abstract");
		params.put("concept_fields", fs);

		Matches matches = service.searchGraphsConceptByLabel(Graph.WIKIPEDIA, params);
		Assert.assertNotNull(matches);
		Assert.assertFalse(matches.getMatches().isEmpty());
	}

	/**
	 * Test get graph related concepts.
	 */
	@Test
	public void testGetGraphRelatedConcepts() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Concept> concepts = new ArrayList<Concept>();
		concepts.add(EXAMPLE_CONCEPT);
		params.put(ConceptInsights.LIMIT, 10);
		params.put(ConceptInsights.LEVEL, 1);
		RequestedFields fs = new RequestedFields();
		fs.include("abstract");
		params.put("concept_fields", fs);
		Concepts conceptResults = service.getGraphRelatedConcepts(Graph.WIKIPEDIA, concepts, params);
		Assert.assertNotNull(conceptResults);
	}

	/**
	 * Test get concept related concepts.
	 */
	@Test
	public void testGetConceptRelatedConcepts() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(ConceptInsights.LIMIT, 10);
		params.put(ConceptInsights.LEVEL, 1);
		RequestedFields fs = new RequestedFields();
		fs.include("abstract");
		params.put("concept_fields", fs);
		Concepts concepts = service.getConceptRelatedConcepts(EXAMPLE_CONCEPT, params);
		Assert.assertNotNull(concepts);
		
	}

	/**
	 * Test get graphs related scores.
	 */
	@Test
	public void testGetGraphsRelatedScores() {
		List<String> concepts = new ArrayList<String>();
		concepts.add(EXAMPLE_CONCEPT.getId());
		Scores scores = service.getGraphRelationScores(EXAMPLE_CONCEPT, concepts);
		Assert.assertNotNull(scores);
	}

	/**
	 * Test list documents.
	 */
	@Test
	public void testListDocuments() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(ConceptInsights.CURSOR, 0);
		params.put(ConceptInsights.LIMIT, 20);

		Documents documents = service.listDocuments(Corpus.TED_TALKS, params);
		Assert.assertNotNull(documents);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = new ConceptInsights();
		service.setUsernameAndPassword(getValidProperty("concept_insights.username"),
				getValidProperty("concept_insights.password"));
		service.setEndPoint(getValidProperty("concept_insights.url"));
	}

	/**
	 * Test annotate text.
	 */
	@Test
	public void testAnnotateText() {
		Annotations annotations = service.annotateText(Graph.WIKIPEDIA,
				"Nizar Magboul Alseddeg is currently living in Austin Texas");
		Assert.assertNotNull(annotations);
	}

	/**
	 * Test get accounts.
	 */
	@Test
	public void testGetAccounts() {
		Accounts accounts = service.getAccountsInfo();
		Assert.assertNotNull(accounts);
		Assert.assertFalse(accounts.getAccounts().isEmpty());
	}

	/**
	 * Test get graphs.
	 */
	@Test
	public void testGetGraphs() {
		Graphs graphs = service.listGraphs();
		Assert.assertNotNull(graphs);
		Assert.assertNotNull(graphs.getGraphs());
		Assert.assertFalse(graphs.getGraphs().isEmpty());
	}

	/**
	 * Testlist corpora.
	 */
	@Test
	public void testlistCorpora() {
		Corpora corpora = service.listCorpora();
		Assert.assertNotNull(corpora);
		Assert.assertFalse(corpora.getCorpora().isEmpty());
	}
}

/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.concept_insights.v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Account;
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
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Part;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.QueryConcepts;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.RequestedFields;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Scores;
import com.ibm.watson.developer_cloud.http.HttpMediaType;

/**
 * The Class ConceptInsightsTest.
 */
public class ConceptInsightsIT extends WatsonServiceTest {

  /** The Constant PUBLIC. */
  private static final String PUBLIC = "public";
  /** The example concept. Value is "/graphs/wikipedia/en-20120601/concepts/IBM */
  private final Concept EXAMPLE_CONCEPT = new Concept(Graph.WIKIPEDIA, "IBM");

  /** The example document. Value is "/corpora/public/ibmresearcher/documents/il-AHARONA */
  private final Document EXAMPLE_DOCUMENT = new Document(Corpus.IBM_RESEARCHERS, "il-AHARONA");

  /** The service. */
  private ConceptInsights service;

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
    service.setDefaultHeaders(getDefaultHeaders());
  }

  /**
   * Test annotate text.
   */
  @Test
  public void testAnnotateText() {
    final Annotations annotations =
        service.annotateText(Graph.WIKIPEDIA,
            "Nizar Magboul Alseddeg is currently living in Austin Texas");
    Assert.assertNotNull(annotations);
  }

  /**
   * Test conceptual search.
   */
  @Test
  public void testConceptualSearch() {
    final Map<String, Object> params = new HashMap<String, Object>();
    final List<String> ids = new ArrayList<String>();
    ids.add(EXAMPLE_CONCEPT.getId());
    params.put(ConceptInsights.IDS, ids);
    params.put(ConceptInsights.LIMIT, 10);
    params.put(ConceptInsights.CURSOR, 0);
    final QueryConcepts cp = service.conceptualSearch(Corpus.TED_TALKS, params);
    Assert.assertNotNull(cp);
  }

  /**
   * Test document annotations.
   */
  @Test
  public void testDocumentAnnotations() {
    final DocumentAnnotations annotations = service.getDocumentAnnotations(EXAMPLE_DOCUMENT);
    Assert.assertNotNull(annotations);
  }

  /**
   * Test get accounts.
   */
  @Test
  public void testGetAccounts() {
    final Accounts accounts = service.getAccountsInfo();
    Assert.assertNotNull(accounts);
    Assert.assertFalse(accounts.getAccounts().isEmpty());
  }

  /**
   * Test get concept.
   */
  @Test
  public void testGetConcept() {
    final ConceptMetadata conceptMetaData = service.getConcept(EXAMPLE_CONCEPT);
    Assert.assertNotNull(conceptMetaData);

  }

  /**
   * Test get concept related concepts.
   */
  @Test
  public void testGetConceptRelatedConcepts() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(ConceptInsights.LIMIT, 10);
    params.put(ConceptInsights.LEVEL, 1);
    final RequestedFields fs = new RequestedFields();
    fs.include("abstract");
    params.put("concept_fields", fs);
    Concepts concepts = service.getConceptRelatedConcepts(EXAMPLE_CONCEPT, params);
    Assert.assertNotNull(concepts);
    Assert.assertNotNull(concepts.getConcepts().get(0).getConcept().getAbstract());
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
    final Map<String, Object> query = new HashMap<String, Object>();
    query.put(ConceptInsights.QUERY, "IBM");
    query.put(ConceptInsights.LIMIT, 10);
    query.put(ConceptInsights.PREFIX, false);
    final Matches matches = service.searchCorpusByLabel(Corpus.IBM_RESEARCHERS, query);
    Assert.assertNotNull(matches);
  }

  /**
   * Test get corpus processing state.
   */
  @Test
  public void testGetCorpusProcessingState() {
    final CorpusProcessingState corpusProcessingState =
        service.getCorpusProcessingState(Corpus.IBM_RESEARCHERS);
    Assert.assertNotNull(corpusProcessingState);
  }

  /**
   * Test get corpus related concept.
   */
  @Test
  public void testGetCorpusRelatedConcept() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(ConceptInsights.LIMIT, 10);
    params.put(ConceptInsights.PREFIX, false);
    final Concepts concepts = service.getCorpusRelatedConcepts(Corpus.IBM_RESEARCHERS, params);
    Assert.assertNotNull(concepts);
  }

  /**
   * Test get corpus relation scores.
   */
  @Test
  public void testGetCorpusRelationScores() {
    final List<Concept> concepts = new ArrayList<Concept>();
    concepts.add(EXAMPLE_CONCEPT);
    final Scores scores = service.getCorpusRelationScores(Corpus.IBM_RESEARCHERS, concepts);
    Assert.assertNotNull(scores);
  }

  /**
   * Test get corpus stats.
   */
  @Test
  public void testGetCorpusStats() {
    final CorpusStats corpusStats = service.getCorpusStats(Corpus.IBM_RESEARCHERS);
    Assert.assertNotNull(corpusStats);
  }

  /**
   * Test get document.
   */
  @Test
  public void testGetDocument() {
    final Document document = service.getDocument(EXAMPLE_DOCUMENT);
    Assert.assertNotNull(document);
  }

  /**
   * Test get document processing state.
   */
  @Test
  public void testGetDocumentProcessingState() {
    final DocumentProcessingStatus documentProcessingState =
        service.getDocumentProcessingState(EXAMPLE_DOCUMENT);
    Assert.assertNotNull(documentProcessingState);
  }

  /**
   * Test get document related concepts.
   */
  @Test
  public void testGetDocumentRelatedConcepts() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(ConceptInsights.LEVEL, "1");
    params.put(ConceptInsights.LIMIT, 10);
    final Concepts concepts = service.getDocumentRelatedConcepts(EXAMPLE_DOCUMENT, params);
    Assert.assertNotNull(concepts);
  }

  /**
   * Test get document relation scores.
   */
  @Test
  public void testGetDocumentRelationScores() {
    final List<Concept> concepts = new ArrayList<Concept>();
    concepts.add(EXAMPLE_CONCEPT);
    final Scores scores = service.getDocumentRelationScores(EXAMPLE_DOCUMENT, concepts);
    Assert.assertNotNull(scores);
  }

  /**
   * Test get documnet related concepts.
   */
  @Test
  public void testGetDocumnetRelatedConcepts() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(ConceptInsights.LEVEL, "1");
    params.put(ConceptInsights.LIMIT, 10);
    final Concepts concepts = service.getDocumentRelatedConcepts(EXAMPLE_DOCUMENT, params);
    Assert.assertNotNull(concepts);
  }

  /**
   * Test get graph related concepts.
   */
  @Test
  public void testGetGraphRelatedConcepts() {
    final Map<String, Object> params = new HashMap<String, Object>();
    final List<Concept> concepts = new ArrayList<Concept>();
    concepts.add(EXAMPLE_CONCEPT);
    params.put(ConceptInsights.LIMIT, 10);
    params.put(ConceptInsights.LEVEL, 1);
    final RequestedFields fs = new RequestedFields();
    fs.include("abstract");
    fs.include("link");
    fs.include("name");
    params.put(ConceptInsights.CONCEPT_FIELDS, fs);
    Concepts conceptResults = service.getGraphRelatedConcepts(Graph.WIKIPEDIA, concepts, params);
    Assert.assertNotNull(conceptResults);
    Assert.assertTrue(!conceptResults.getConcepts().isEmpty());
    Assert.assertNotNull(conceptResults.getConcepts().get(0).getConcept().getAbstract());


  }

  /**
   * Test get graphs.
   */
  @Test
  public void testGetGraphs() {
    final Graphs graphs = service.listGraphs();
    Assert.assertNotNull(graphs);
    Assert.assertNotNull(graphs.getGraphs());
    Assert.assertFalse(graphs.getGraphs().isEmpty());
  }

  /**
   * Test create and delete corpus
   */
  @Test
  public void testCreateAndDeleteCorpus() {
    final String name = UUID.randomUUID().toString();
    final Account account = service.getAccountsInfo().getAccounts().get(0);
    Corpus corpus = new Corpus(account.getId(), name);
    try {
      service.createCorpus(corpus);
      corpus = service.getCorpus(corpus);
      corpus.setAccess(Corpus.ACCESS_PUBLIC);
      service.updateCorpus(corpus);
    } finally {
      service.deleteCorpus(corpus);
    }
  }

  /**
   * Test get graphs label search.
   */
  @Test
  public void testGetGraphsLabelSearch() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(ConceptInsights.QUERY, "cognitv");
    params.put(ConceptInsights.LIMIT, 10);
    params.put(ConceptInsights.PREFIX, false);

    final RequestedFields fs = new RequestedFields();
    fs.include("abstract");
    params.put("concept_fields", fs);

    final Matches matches = service.searchGraphsConceptByLabel(Graph.WIKIPEDIA, params);
    Assert.assertNotNull(matches);
    Assert.assertFalse(matches.getMatches().isEmpty());
    Assert.assertNotNull(matches.getMatches().get(0).getAbstract());

  }

  /**
   * Test get graphs related scores.
   */
  @Test
  public void testGetGraphsRelatedScores() {
    final List<String> concepts = new ArrayList<String>();
    concepts.add(EXAMPLE_CONCEPT.getId());
    final Scores scores = service.getGraphRelationScores(EXAMPLE_CONCEPT, concepts);
    Assert.assertNotNull(scores);
  }

  /**
   * Test list corpora.
   */
  @Test
  public void testlistCorpora() {
    final Corpora corpora = service.listCorpora();
    Assert.assertNotNull(corpora);
    Assert.assertFalse(corpora.getCorpora().isEmpty());
  }

  /**
   * Test list corpora for account
   */
  @Test
  public void testlistCorporaForAccount() {
    final Account account = service.getAccountsInfo().getAccounts().get(0);
    final Corpora corpora = service.listCorpora(account.getId());
    Assert.assertNotNull(corpora);
    Assert.assertFalse(corpora.getCorpora().isEmpty());
  }

  /**
   * Test create and delete document.
   */
  @Test
  public void testCreateAndDeleteDocument() {
    final Account account = service.getAccountsInfo().getAccounts().get(0);
    final Corpora corpora = service.listCorpora(account.getId());

    Assert.assertTrue(!corpora.getCorpora().isEmpty());

    final Corpus corpus = corpora.getCorpora().get(0);
    Document newDocument = new Document(corpus, "integration_doc");
    newDocument.setLabel("test document");
    newDocument.addParts(new Part("part1", "this is the first part", HttpMediaType.TEXT_PLAIN));
    try {
      service.createDocument(newDocument);
      newDocument = service.getDocument(newDocument);
      newDocument.setTimeToLive(3600);
      service.updateDocument(newDocument);
    } finally {
      service.deleteDocument(newDocument);
    }
  }

  /**
   * Test list documents.
   */
  @Test
  public void testListDocuments() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(ConceptInsights.CURSOR, 0);
    params.put(ConceptInsights.LIMIT, 20);

    final Documents documents = service.listDocuments(Corpus.TED_TALKS, params);
    Assert.assertNotNull(documents);
  }
}

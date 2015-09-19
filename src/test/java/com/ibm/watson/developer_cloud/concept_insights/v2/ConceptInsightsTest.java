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
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Graphs;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Matches;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.QueryConcepts;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.RequestedFields;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Scores;

/**
 * The Class ConceptInsightsTest.
 */
public class ConceptInsightsTest extends WatsonServiceTest {

    /** The service. */
    private ConceptInsights service;

    /**
     * Test conceptual search.
     */
    @Test
    public void testConceptualSearch() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "public");
        params.put(ConceptInsights.CORPUS, "ibmresearcher");
        List<String> ids = new ArrayList<String>();
        ids.add("/graphs/wikipedia/en-20120601/concepts/IBM_Watson");
        params.put(ConceptInsights.IDS, ids);
        params.put(ConceptInsights.LIMIT, 10);
        params.put(ConceptInsights.CURSOR, 0);
        QueryConcepts cp =  service.conceptualSearch(params);
        Assert.assertNotNull(cp);
    }

    /**
     * Test document annotations.
     */
    @Test
    public void testDocumentAnnotations() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "public");
        params.put(ConceptInsights.CORPUS, "ibmresearcher");
        params.put(ConceptInsights.DOCUMENT, "il-AHARONA");
        DocumentAnnotations document = service.getDocumentAnnotations("public", "ibmresearcher", "il-AHARONA");
        Assert.assertNotNull(document);
    }
    
    
    
    /**
     * Test get concept.
     */
    @Test
    public void testGetConcept() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "wikipedia");
        params.put("graph", "en-20120601");
        params.put("concept", "IBM");
        ConceptMetadata conceptMetaData =  service.getConcept(params);
        Assert.assertNotNull(conceptMetaData);

    }

    /**
     * Test get corpora by account.
     */
    @Test
    public void testGetCorporaByAccount() {
        Corpora corpora = service.listCorpora("public");
        Assert.assertNotNull(corpora);
        Assert.assertFalse(corpora.getCorpora().isEmpty());
    }

    /**
     * Test get corpus.
     */
    @Test
    public void testGetCorpus() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "public");
        params.put(ConceptInsights.CORPUS, "TEDTalks");

        Corpus corpus= service.getCorpus("public", "TEDTalks");
        Assert.assertNotNull(corpus);
    }

     /**
      * Test get corpus label search.
      */
    @Test
    public void testGetCorpusLabelSearch() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "public");
        params.put(ConceptInsights.CORPUS, "TEDTalks");
        params.put(ConceptInsights.QUERY, "IBM");
        params.put(ConceptInsights.LIMIT, 10);
        params.put(ConceptInsights.PREFIX, false);
        Matches matches =  service.searchCorpusByLabel(params);
        Assert.assertNotNull(matches);
    }
    
    /**
     * Test get corpus processing state.
     */
    @Test
    public void testGetCorpusProcessingState() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "public");
        params.put(ConceptInsights.CORPUS, "ibmresearcher");
        CorpusProcessingState corpusProcessingState = service.getCorpusProcessingState("public","ibmresearcher");
        Assert.assertNotNull(corpusProcessingState);
    }

    /**
     * Test get corpus related concept.
     */
    @Test
    public void testGetCorpusRelatedConcept() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "public");
        params.put(ConceptInsights.CORPUS, "ibmresearcher");
        params.put(ConceptInsights.LIMIT, 10);
        params.put(ConceptInsights.PREFIX, false);
        Concepts  concepts = service.getCorpusRelatedConcepts(params);
        Assert.assertNotNull(concepts);
    }

    /**
     * Test get corpus relation scores.
     */
    @Test
    public void testGetCorpusRelationScores() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "public");
        params.put(ConceptInsights.CORPUS, "ibmresearcher");
        List<String> concepts = new ArrayList<String>();
        concepts.add("/graphs/wikipedia/en-20120601/concepts/IBM_Watson");
        params.put(ConceptInsights.CONCEPTS, concepts);
        params.put(ConceptInsights.CONCEPT, "IBM");
        Scores scores = service.getCorpusRelationScores(params);
        Assert.assertNotNull(scores);
    }

    /**
     * Test get corpus stats.
     */
    @Test
    public void testGetCorpusStats() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "public");
        params.put(ConceptInsights.CORPUS, "ibmresearcher");
        CorpusStats corpusStats = service.getCorpusStats("public", "ibmresearcher");
        Assert.assertNotNull(corpusStats);
    }

    /**
     * Test get document.
     */
    @Test
    public void testGetDocument() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "public");
        params.put(ConceptInsights.CORPUS, "ibmresearcher");
        params.put(ConceptInsights.DOCUMENT, "il-AHARONA");
        Document document = service.getDocument("public", "ibmresearcher", "il-AHARONA");
        Assert.assertNotNull(document);
    }

    /**
     * Test get document processing state.
     */
    @Test
    public void testGetDocumentProcessingState() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "public");
        params.put(ConceptInsights.CORPUS, "ibmresearcher");
        params.put(ConceptInsights.DOCUMENT, "il-AHARONA");
        DocumentProcessingStatus documentProcessingState = service.getDocumentProcessingState("public", "ibmresearcher", "il-AHARONA");
        Assert.assertNotNull(documentProcessingState);
    }

    /**
     * Test get document related concepts.
     */
    @Test
    public void testGetDocumentRelatedConcepts() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "public");
        params.put(ConceptInsights.CORPUS, "ibmresearcher");
        params.put(ConceptInsights.DOCUMENT, "il-AHARONA");
        params.put(ConceptInsights.LEVEL, "1");
        params.put(ConceptInsights.LIMIT, 10);
        Concepts concepts =  service.getDocumentRelatedConcepts(params);
        Assert.assertNotNull(concepts);
    }

    /**
     * Test get document relation scores.
     */
    @Test
    public void testGetDocumentRelationScores() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "public");
        params.put(ConceptInsights.CORPUS, "ibmresearcher");
        params.put(ConceptInsights.DOCUMENT, "il-AHARONA");
        List<String> concepts = new ArrayList<String>();
        concepts.add("/graphs/wikipedia/en-20120601/concepts/IBM_Watson");
        params.put(ConceptInsights.CONCEPTS, concepts);
        params.put(ConceptInsights.CONCEPT_ID, "IBM");
        Scores scores = service.getDocumentRelationScores(params);
        Assert.assertNotNull(scores);
    }

    /**
     * Test get documnet related concepts.
     */
    @Test
    public void testGetDocumnetRelatedConcepts() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "public");
        params.put(ConceptInsights.CORPUS, "ibmresearcher");
        params.put(ConceptInsights.DOCUMENT, "il-AHARONA");
        params.put(ConceptInsights.LEVEL, "1");
        params.put(ConceptInsights.LIMIT, 10);
        Concepts concepts =  service.getDocumentRelatedConcepts(params);
        Assert.assertNotNull(concepts);
    }

    /**
     * Test get graphs label search.
     */
    @Test
    public void testGetGraphsLabelSearch() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "wikipedia");
        params.put("graph", "en-20120601");
        params.put("query", "cognitv");
        params.put(ConceptInsights.LIMIT, 10);
        params.put("perfix", false);
        
        RequestedFields fs = new RequestedFields();
        fs.include("abstract");
        params.put("concept_fields", fs);
        
        Matches matches =  service.searchGraphsConceptByLabel(params);
        Assert.assertNotNull(matches);
        Assert.assertFalse(matches.getMatches().isEmpty());
    }

    /**
     * Test get graphs related concepts.
     */
    @Test
    public void testGetGraphsRelatedConcepts() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "wikipedia");
        params.put("graph", "en-20120601");
        List<String> concepts = new ArrayList<String>();
        concepts.add("/graphs/wikipedia/en-20120601/concepts/IBM_Watson");
        params.put(ConceptInsights.CONCEPTS, concepts);
        params.put(ConceptInsights.LIMIT, 10);
        params.put(ConceptInsights.LEVEL, 1);
        RequestedFields fs = new RequestedFields();
        fs.include("abstract");
        params.put("concept_fields", fs);
        Concepts concepts1 =  service.getGraphsRelatedConcepts(params);
        Assert.assertNotNull(concepts1);
    }

    /**
     * Test get graphs related concepts by concept id.
     */
    @Test
    public void testGetGraphsRelatedConceptsByConceptId() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "wikipedia");
        params.put("graph", "en-20120601");
        List<String> concepts = new ArrayList<String>();
        concepts.add("/graphs/wikipedia/en-20120601/concepts/IBM_Watson");
        params.put("concept", "IBM");
        params.put(ConceptInsights.LIMIT, 10);
        params.put(ConceptInsights.LEVEL, 1);
        RequestedFields fs = new RequestedFields();
        fs.include("abstract");
        params.put("concept_fields", fs);
        Concepts concepts1 =  service.getGraphsRelatedConcepts(params);
        Assert.assertNotNull(concepts1);
    }

    /**
     * Test get graphs related scores.
     */
    @Test
    public void testGetGraphsRelatedScores() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "wikipedia");
        params.put("graph", "en-20120601");
        List<String> concepts = new ArrayList<String>();
        concepts.add("/graphs/wikipedia/en-20120601/concepts/IBM");
        params.put(ConceptInsights.CONCEPTS, concepts);
        params.put("concept", "IBM");
        Scores scores =  service.getGraphsRelationScores(params);
        Assert.assertNotNull(scores);
    }

    /**
     * Test list documents.
     */
    @Test
    public void testListDocuments() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "public");
        params.put(ConceptInsights.CORPUS, "ibmresearcher");
        params.put(ConceptInsights.CURSOR, 0);
        params.put(ConceptInsights.LIMIT, 20);

        Documents documents = service.listDocuments(params);
        Assert.assertNotNull(documents);
    }

    /* (non-Javadoc)
	 * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
	 */
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        service = new ConceptInsights();
        service.setUsernameAndPassword(
                prop.getProperty("concept_insights.username"),
                prop.getProperty("concept_insights.password")
        );
        service.setEndPoint(prop.getProperty("concept_insights.url"));
    }

    /**
     * Test annotate text.
     */
    @Test
    public void testAnnotateText() {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(ConceptInsights.ACCOUNT_ID, "wikipedia");
        params.put("graph", "en-20120601");
        params.put("text", "Nizar Magboul Alseddeg is currently living in Austin Texas");
        Annotations  annotations= service.annotateText(params);
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

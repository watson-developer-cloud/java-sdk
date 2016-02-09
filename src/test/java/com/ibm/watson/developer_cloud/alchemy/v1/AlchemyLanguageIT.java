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
package com.ibm.watson.developer_cloud.alchemy.v1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.alchemy.v1.model.CombinedResults;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Concepts;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentAuthors;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentPublicationDate;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentText;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentTitle;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entities;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Feeds;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keywords;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Language;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Microformats;
import com.ibm.watson.developer_cloud.alchemy.v1.model.SAORelations;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Taxonomies;

/**
 * Created by nizar on 8/25/15.
 */
public class AlchemyLanguageIT extends WatsonServiceTest {

  /** The html example. */
  private String htmlExample;

  /** The service. */
  private AlchemyLanguage service;

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new AlchemyLanguage();
    service.setApiKey(getValidProperty("alchemy.alchemy"));
    service.setDefaultHeaders(getDefaultHeaders());
    htmlExample =
        getStringFromInputStream(new FileInputStream("src/test/resources/alchemy/example.html"));

  }

  /**
   * Test api key is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testApiKeyIsNull() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");

    final AlchemyLanguage language = new AlchemyLanguage();
    language.setApiKey(null);
    language.getKeywords(params);
  }

  /**
   * Test comboined.
   */
  @Test
  public void testComboined() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final CombinedResults combined = service.getCombinedResults(params);
    Assert.assertNotNull(combined);
  }

  /**
   * Test Get testFeeds.
   */
  @Test
  public void testFeeds() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final Feeds feeds = service.getFeeds(params);
    Assert.assertNotNull(feeds);
  }

  /**
   * Test Get testGetAuthor.
   */
  @Test
  public void testGetAuthors() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params
        .put(AlchemyLanguage.URL,
            "http://www.politico.com/blogs/media/2012/02/detroit-news-ed-upset-over-romney-edit-115247.html");
    final DocumentAuthors authors = service.getAuthors(params);
    Assert.assertNotNull(authors);
  }

  /**
   * Test get concepts HTML.
   */
  @Test
  public void testGetConceptsHTML() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.HTML, htmlExample);
    final Concepts concepts = service.getConcepts(params);
    Assert.assertNotNull(concepts);
    Assert.assertFalse(concepts.getConcepts().isEmpty());
  }

  /**
   * Test get concepts HTML.
   */
  @Test
  public void testGetConceptsText() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.TEXT, htmlExample);
    final Concepts concepts = service.getConcepts(params);
    Assert.assertNotNull(concepts);
    Assert.assertFalse(concepts.getConcepts().isEmpty());
  }

  /**
   * Test Get getTaxonomy URL.
   */
  @Test
  public void testGetConceptsUrl() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final Concepts concepts = service.getConcepts(params);
    Assert.assertNotNull(concepts);
    Assert.assertFalse(concepts.getConcepts().isEmpty());
  }

  /**
   * Test Get entities HTML.
   */
  @Test
  public void testGetEntitiesHtml() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.HTML, htmlExample);

    final Entities entities = service.getEntities(params);
    Assert.assertNotNull(entities);
    Assert.assertFalse(entities.getEntities().isEmpty());
  }

  /**
   * Test Get entities URL.
   */
  @Test
  public void testGetEntitiesUrl() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final Entities entities = service.getEntities(params);
    Assert.assertNotNull(entities);
    Assert.assertFalse(entities.getEntities().isEmpty());
  }

  /**
   * Test Get entities HTML.
   */
  @Test
  public void testGetEntitiesWithDifferentCharacters() {
    final Map<String, Object> params = new HashMap<String, Object>();
    final String text =
        "Mr. Vice President, my old colleague from Massachusetts"
            + "and your new Speaker & John McCormack, Members of the 87th Congress, "
            + "ladies and gentlemen: -.*&^%$#@!@#$%^&*()";
    params.put(AlchemyLanguage.TEXT, text);

    final Entities entities = service.getEntities(params);
    Assert.assertNotNull(entities);
    Assert.assertFalse(entities.getEntities().isEmpty());
  }

  /**
   * Test Get testGetLanguage.
   */
  @Test
  public void testGetLanguage() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://news.google.fr/");
    final Language language = service.getLanguage(params);
    Assert.assertNotNull(language);
  }

  /**
   * Test get publication date html.
   */
  @Test
  public void testGetPublicationDateHTML() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.HTML, htmlExample);
    final DocumentPublicationDate date = service.getPublicationDate(params);
    Assert.assertNotNull(date);
    Assert.assertNotNull(date.getPublicationDate());
  }

  /**
   * Test get publication date url.
   */
  @Test
  public void testGetPublicationDateURL() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final DocumentPublicationDate date = service.getPublicationDate(params);
    Assert.assertNotNull(date);
    Assert.assertNotNull(date.getPublicationDate());
  }

  /**
   * Test Get testGetRelationsHtml HTML.
   * 
   */
  @Test
  public void testGetRelationsHtml() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.HTML, htmlExample);
    final SAORelations relations = service.getRelations(params);
    Assert.assertNotNull(relations);
  }

  /**
   * Test Get testGetRelationsUrl URL.
   */
  @Test
  public void testGetRelationsUrl() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final SAORelations relations = service.getRelations(params);
    Assert.assertNotNull(relations);
  }

  /**
   * Test Get testGetTargetedSentiment HTML.
   */
  @Test
  public void testGetTargetedSentimentHtml() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.HTML, htmlExample);
    params.put(AlchemyLanguage.TARGET, "Watson");
    final DocumentSentiment documentSentiment = service.getSentiment(params);
    Assert.assertNotNull(documentSentiment);
  }

  /**
   * Test Get testGetTargetedSentiment Url.
   */
  @Test
  public void testGetTargetedSentimentURL() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params
        .put(
            AlchemyLanguage.URL,
            "http://techcrunch.com/2012/03/01/keen-on-anand-rajaraman-how-walmart-wants-to-leapfrog-over-amazon-tctv/");
    params.put(AlchemyLanguage.TARGET, "Walmart");
    final DocumentSentiment documentSentiment = service.getSentiment(params);
    Assert.assertNotNull(documentSentiment);
  }

  /**
   * Test Get testGetTargetedSentiment Url and multiple targets.
   */
  @Test
  public void testGetTargetedSentimentURLAndTargets() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params
        .put(
            AlchemyLanguage.URL,
            "http://techcrunch.com/2012/03/01/keen-on-anand-rajaraman-how-walmart-wants-to-leapfrog-over-amazon-tctv/");
    params.put(AlchemyLanguage.TARGETS, "Walmart|Walmart");
    final DocumentSentiment documentSentiment = service.getSentiment(params);
    Assert.assertNotNull(documentSentiment);
  }

  /**
   * Test Get getTaxonomy HTML.
   * 
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testGetTaxonomyHtml() throws IOException {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.HTML, htmlExample);
    final Taxonomies taxonomy = service.getTaxonomy(params);
    Assert.assertNotNull(taxonomy);
    Assert.assertFalse(taxonomy.getTaxonomy().isEmpty());
  }

  /**
   * Test Get getTaxonomy URL.
   */
  @Test
  public void testGetTaxonomyUrl() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final Taxonomies taxonomy = service.getTaxonomy(params);
    Assert.assertNotNull(taxonomy);
    Assert.assertFalse(taxonomy.getTaxonomy().isEmpty());
  }

  /**
   * Test Get testGetTextSentiment HTML.
   */
  @Test
  public void testGetTextSentimentHtml() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.HTML, htmlExample);
    final DocumentSentiment documentSentiment = service.getSentiment(params);
    Assert.assertNotNull(documentSentiment);
  }

  /**
   * Test Get testGetTextSentiment URL.
   */
  @Test
  public void testGetTextSentimentUrl() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final DocumentSentiment documentSentiment = service.getSentiment(params);
    Assert.assertNotNull(documentSentiment);
  }

  /**
   * Test Get testGetTitle.
   */
  @Test
  public void testGetTitle() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final DocumentTitle title = service.getTitle(params);
    Assert.assertNotNull(title);
  }

  /**
   * Test Get keywords HTML.
   * 
   */
  @Test
  public void testGetWordsHtml() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.HTML, htmlExample);

    final Keywords keywords = service.getKeywords(params);
    Assert.assertNotNull(keywords);
    Assert.assertFalse(keywords.getKeywords().isEmpty());
  }

  /**
   * Test Get keywords URL.
   */
  @Test
  public void testGetWordsUrl() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final Keywords keywords = service.getKeywords(params);
    Assert.assertNotNull(keywords);
    Assert.assertFalse(keywords.getKeywords().isEmpty());
  }

  /**
   * Test microformats.
   */
  @Test
  public void testMicroformats() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://microformats.org/wiki/hcard");
    final Microformats microformats = service.getMicroformats(params);
    Assert.assertNotNull(microformats);
  }

  /**
   * Test Get testGetRawText.
   */
  @Test
  public void testRawText() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.test.com/");
    params.put(AlchemyLanguage.RAW, true);
    final DocumentText text = service.getText(params);
    Assert.assertNotNull(text);
  }

  /**
   * Test Get testGetText.
   */
  @Test
  public void testText() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final DocumentText text = service.getText(params);
    Assert.assertNotNull(text);
  }

}

/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.alchemy.v1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.alchemy.v1.model.CombinedResults;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Concepts;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Dates;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentAuthors;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentEmotion;
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
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedArguments;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedEntity;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelation;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelations;
import com.ibm.watson.developer_cloud.util.RetryRunner;

/**
 * Alchemy Language Integration tests.
 */
@RunWith(RetryRunner.class)
public class AlchemyLanguageIT extends WatsonServiceTest {

  private static final String testURL =
      "http://techcrunch.com/2012/03/01/" + "keen-on-anand-rajaraman-how-walmart-wants-to-leapfrog-over-amazon-tctv/";
  private String htmlExample;
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

    String apiKey = getProperty("alchemy.alchemy");
    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (apiKey == null) || apiKey.equals("API_KEY"));

    service = new AlchemyLanguage();
    service.setApiKey(apiKey);
    service.setDefaultHeaders(getDefaultHeaders());
    htmlExample = getStringFromInputStream(new FileInputStream("src/test/resources/alchemy/example.html"));

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
    language.getKeywords(params).execute();
  }

  /**
   * Test combined.
   */
  @Test
  public void testCombined() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    params.put("showSourceText", "1");
    final CombinedResults combined = service.getCombinedResults(params).execute();
    Assert.assertNotNull(combined);
    Assert.assertNotNull(combined.getText());
  }

  /**
   * Test Get testFeeds.
   */
  @Test
  public void testFeeds() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final Feeds feeds = service.getFeeds(params).execute();
    Assert.assertNotNull(feeds);
  }

  /**
   * Test Get testGetAuthor.
   */
  @Test
  public void testGetAuthors() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL,
        "http://www.politico.com/blogs/media/2012/02/detroit-news-ed-upset-over-romney-edit-115247.html");
    final DocumentAuthors authors = service.getAuthors(params).execute();
    Assert.assertNotNull(authors);
  }

  /**
   * Test get concepts HTML.
   */
  @Test
  public void testGetConceptsHTML() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.HTML, htmlExample);
    final Concepts concepts = service.getConcepts(params).execute();
    Assert.assertNotNull(concepts);
    Assert.assertFalse(concepts.getConcepts().isEmpty());
  }

  /**
   * Test get concepts Tet.
   */
  @Test
  public void testGetConceptsText() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.TEXT, htmlExample);
    final Concepts concepts = service.getConcepts(params).execute();
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
    final Concepts concepts = service.getConcepts(params).execute();
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

    final Entities entities = service.getEntities(params).execute();
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
    final Entities entities = service.getEntities(params).execute();
    Assert.assertNotNull(entities);
    Assert.assertFalse(entities.getEntities().isEmpty());
  }

  /**
   * Test Get entities HTML.
   */
  @Test
  public void testGetEntitiesWithDifferentCharacters() {
    final Map<String, Object> params = new HashMap<String, Object>();
    final String text = "Mr. Vice President, my old colleague from Massachusetts"
        + "and your new Speaker & John McCormack, Members of the 87th Congress, "
        + "ladies and gentlemen: -.*&^%$#@!@#$%^&*()";
    params.put(AlchemyLanguage.TEXT, text);

    final Entities entities = service.getEntities(params).execute();
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
    final Language language = service.getLanguage(params).execute();
    Assert.assertNotNull(language);
  }

  /**
   * Test get publication date html.
   */
  @Test
  public void testGetPublicationDateHTML() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.HTML, htmlExample);
    final DocumentPublicationDate date = service.getPublicationDate(params).execute();
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
    final DocumentPublicationDate date = service.getPublicationDate(params).execute();
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
    final SAORelations relations = service.getRelations(params).execute();
    Assert.assertNotNull(relations);
  }

  /**
   * Test Get testGetRelationsUrl URL.
   */
  @Test
  public void testGetRelationsUrl() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final SAORelations relations = service.getRelations(params).execute();
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
    final DocumentSentiment documentSentiment = service.getSentiment(params).execute();
    Assert.assertNotNull(documentSentiment);
  }

  /**
   * Test Get testGetTargetedSentiment Url.
   */
  @Test
  public void testGetTargetedSentimentURL() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, testURL);
    params.put(AlchemyLanguage.TARGET, "Walmart");
    final DocumentSentiment documentSentiment = service.getSentiment(params).execute();
    Assert.assertNotNull(documentSentiment);
  }

  /**
   * Test Get testGetTargetedSentiment Url and multiple targets.
   */
  @Test
  public void testGetTargetedSentimentURLAndTargets() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, testURL);
    params.put(AlchemyLanguage.TARGETS, "Walmart|Walmart");
    final DocumentSentiment documentSentiment = service.getSentiment(params).execute();
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
    final Taxonomies taxonomy = service.getTaxonomy(params).execute();
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
    final Taxonomies taxonomy = service.getTaxonomy(params).execute();
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
    final DocumentSentiment documentSentiment = service.getSentiment(params).execute();
    Assert.assertNotNull(documentSentiment);
  }

  /**
   * Test Get testGetTextSentiment URL.
   */
  @Test
  public void testGetTextSentimentUrl() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final DocumentSentiment documentSentiment = service.getSentiment(params).execute();
    Assert.assertNotNull(documentSentiment);
  }

  /**
   * Test Get testGetTitle.
   */
  @Test
  public void testGetTitle() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final DocumentTitle title = service.getTitle(params).execute();
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

    final Keywords keywords = service.getKeywords(params).execute();
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
    final Keywords keywords = service.getKeywords(params).execute();
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
    final Microformats microformats = service.getMicroformats(params).execute();
    Assert.assertNotNull(microformats);
  }

  /**
   * Test Get testGetRawText.
   *
   * @throws Exception the exception
   */
  @Test
  @Ignore
  public void testRawText() throws Exception {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.test.com/");
    params.put(AlchemyLanguage.RAW, true);
    final DocumentText text = service.getText(params).execute();
    Assert.assertNotNull(text);
    throw new Exception();
  }

  /**
   * Test Get testGetText.
   */
  @Test
  public void testText() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final DocumentText text = service.getText(params).execute();
    Assert.assertNotNull(text);
  }

  /**
   * Test get dates from a url.
   */
  @Test
  public void testGetDates() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.TEXT, "Let's meet on January 4th, 2004");
    params.put(AlchemyLanguage.ANCHOR_DATE, "2013-12-16 20:06:18");

    final Dates dates = service.getDates(params).execute();
    Assert.assertNotNull(dates);
    Assert.assertNotNull(dates.getDates());
    Assert.assertFalse(dates.getDates().isEmpty());
  }

  /**
   * Test get emotion from HTML.
   */
  @Test
  public void testGetEmotionHTML() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.HTML, htmlExample);
    final DocumentEmotion emotion = service.getEmotion(params).execute();
    Assert.assertNotNull(emotion);
    Assert.assertNotNull(emotion.getEmotion());
  }

  /**
   * Test get emotion from text.
   */
  @Test
  public void testGetEmotionText() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.TEXT, htmlExample);
    final DocumentEmotion emotion = service.getEmotion(params).execute();
    Assert.assertNotNull(emotion);
    Assert.assertNotNull(emotion.getEmotion());
  }

  /**
   * Test Get emotion from URL.
   */
  @Test
  public void testGetEmotionUrl() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final DocumentEmotion emotion = service.getEmotion(params).execute();
    Assert.assertNotNull(emotion);
    Assert.assertNotNull(emotion.getEmotion());
  }

  /**
   * Test get typed relations from HTML.
   */
  @Test
  @Ignore
  public void testGetTypedRelationsHTML() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.HTML, htmlExample);
    final TypedRelations typedRelations = service.getTypedRelations(params).execute();
    Assert.assertNotNull(typedRelations);
    Assert.assertNotNull(typedRelations.getTypedRelations());
  }

  /**
   * Test get typed relations from text.
   */
  @Test
  public void testGetTypedRelationsText() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.TEXT, "Leiming Qian lives in New York.");
    params.put(AlchemyLanguage.MODEL_ID, "ie-en-news");
    final TypedRelations typedRelations = service.getTypedRelations(params).execute();
    Assert.assertNotNull(typedRelations);
    List<TypedRelation> relations = typedRelations.getTypedRelations();
    Assert.assertNotNull(relations);
    Assert.assertFalse(relations.isEmpty());
    for (TypedRelation relation : relations) {
      Assert.assertNotNull(relation.getType());
      Assert.assertNotNull(relation.getSentence());
      Assert.assertNotNull(relation.getArguments());
      Assert.assertFalse(relation.getArguments().isEmpty());
      for (TypedArguments arg : relation.getArguments()) {
        Assert.assertNotNull(arg.getPart());
        Assert.assertNotNull(arg.getText());
        Assert.assertNotNull(arg.getEntities());
        for (TypedEntity e : arg.getEntities()) {
          Assert.assertNotNull(e.getId());
          Assert.assertNotNull(e.getText());
          Assert.assertNotNull(e.getType());
        }
      }
    }
  }

  /**
   * Test Get typed relations from URL.
   */
  @Test
  @Ignore
  public void testGetTypedRelationsUrl() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
    final TypedRelations typedRelations = service.getTypedRelations(params).execute();
    Assert.assertNotNull(typedRelations);
    Assert.assertNotNull(typedRelations.getTypedRelations());
  }
}

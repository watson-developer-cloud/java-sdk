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
package com.ibm.watson.developer_cloud.alchemy.v1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.alchemy.v1.model.CombinedResults;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentAuthors;
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
public class AlchemyLanguageTest extends WatsonServiceTest {

	/** The service. */
	private AlchemyLanguage service;

	/** The html example. */
	private String htmlExample;

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(AlchemyLanguageTest.class.getName());

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
		service.setApiKey(prop.getProperty("alchemy.alchemy"));
		htmlExample = getStringFromInputStream(new FileInputStream("src/test/resources/example.html"));

	}

	/**
	 * Test Get entities URL.
	 */
	@Test
	public void testGetEntitiesUrl() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
		Entities entities = service.getEntities(params);
		Assert.assertNotNull(entities);
		Assert.assertFalse(entities.getEntities().isEmpty());
		log.info(entities.toString());
	}

	/**
	 * Test Get entities HTML.
	 */
	@Test
	public void testGetEntitiesHtml() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.HTML, htmlExample);

		Entities entities = service.getEntities(params);
		Assert.assertNotNull(entities);
		Assert.assertFalse(entities.getEntities().isEmpty());
		log.info(entities.toString());

	}

	/**
	 * Test Get keywords URL.
	 */
	@Test
	public void testGetWordsUrl() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
		Keywords keywords = service.getKeywords(params);
		Assert.assertNotNull(keywords);
		Assert.assertFalse(keywords.getKeywords().isEmpty());
		log.info(keywords.toString());
	}

	/**
	 * Test Get keywords HTML.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testGetWordsHtml() throws IOException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.HTML, htmlExample);

		Keywords keywords = service.getKeywords(params);
		Assert.assertNotNull(keywords);
		Assert.assertFalse(keywords.getKeywords().isEmpty());
		log.info(keywords.toString());
	}

	/**
	 * Test Get geTaxonomy URL.
	 */
	@Test
	public void testGeTaxonomyUrl() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
		Taxonomies taxonomy = service.geTaxonomy(params);
		Assert.assertNotNull(taxonomy);
		Assert.assertFalse(taxonomy.getTaxonomy().isEmpty());
		log.info(taxonomy.toString());
	}

	/**
	 * Test Get geTaxonomy HTML.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testGeTaxonomyHtml() throws IOException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.HTML, htmlExample);
		Taxonomies taxonomy = service.geTaxonomy(params);
		Assert.assertNotNull(taxonomy);
		Assert.assertFalse(taxonomy.getTaxonomy().isEmpty());
		log.info(taxonomy.toString());
	}

	/**
	 * Test Get testGetTextSentiment URL.
	 */
	@Test
	public void testGetTextSentimentUrl() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
		DocumentSentiment documentSentiment = service.getSentiment(params);
		Assert.assertNotNull(documentSentiment);
		log.info(documentSentiment.toString());
	}

	/**
	 * Test Get testGetTextSentiment HTML.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testGetTextSentimentHtml() throws IOException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.HTML, htmlExample);
		DocumentSentiment documentSentiment = service.getSentiment(params);
		Assert.assertNotNull(documentSentiment);
	}

	/**
	 * Test Get testGetTargetedSentiment Url.
	 */
	@Test
	public void testGetTargetedSentimentURL() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.URL,
				"http://techcrunch.com/2012/03/01/keen-on-anand-rajaraman-how-walmart-wants-to-leapfrog-over-amazon-tctv/");
		params.put("target", "Walmart");
		DocumentSentiment documentSentiment = service.getSentiment(params);
		Assert.assertNotNull(documentSentiment);
	}

	/**
	 * Test Get testGetTargetedSentiment Url.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testGetTargetedSentimentHtml() throws IOException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.HTML, htmlExample);
		params.put(AlchemyLanguage.TARGET, "WujWuj");
		DocumentSentiment documentSentiment = service.getSentiment(params);
		Assert.assertNotNull(documentSentiment);
	}

	/**
	 * Test Get testGetTargetedSentiment URL.
	 */
	@Test
	public void testGetRelationsUrl() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
		SAORelations relations = service.getRelations(params);
		Assert.assertNotNull(relations);
	}

	/**
	 * Test Get testGetTargetedSentiment HTML.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testGetRelationsHtml() throws IOException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.HTML, htmlExample);
		SAORelations relations = service.getRelations(params);
		Assert.assertNotNull(relations);
		log.info(relations.toString());
	}

	/**
	 * Test Get testGetLanguage.
	 */
	@Test
	public void testGetLanguage() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.URL, "http://news.google.fr/");
		Language language = service.getLanguage(params);
		Assert.assertNotNull(language);
		log.info(language.toString());
	}

	/**
	 * Test Get testGetTitle.
	 */
	@Test
	public void testGetTitle() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
		DocumentTitle title = service.getTitle(params);
		Assert.assertNotNull(title);
		log.info(title.toString());
	}

	/**
	 * Test Get testGetAuthor.
	 */
	@Test
	public void testGetAuthors() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.URL,
				"http://www.politico.com/blogs/media/2012/02/detroit-news-ed-upset-over-romney-edit-115247.html");
		DocumentAuthors authors = service.getAuthors(params);
		Assert.assertNotNull(authors);
		log.info(authors.toString());
	}

	/**
	 * Test Get testGetText.
	 */
	@Test
	public void testText() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
		DocumentText text = service.getText(params);
		Assert.assertNotNull(text);
		log.info(text.toString());
	}

	/**
	 * Test Get testGetRawText.
	 */
	@Test
	public void testRawText() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.URL, "http://www.test.com/");
		params.put(AlchemyLanguage.RAW, true);
		DocumentText text = service.getText(params);
		Assert.assertNotNull(text);
		log.info(text.toString());
	}

	/**
	 * Test Get testFeeds.
	 */
	@Test
	public void testFeeds() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
		Feeds feeds = service.getFeeds(params);
		Assert.assertNotNull(feeds);
		log.info(feeds.toString());
	}

	/**
	 * Test microformats.
	 */
	@Test
	public void testMicroformats() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.URL, "http://microformats.org/wiki/hcard");
		Microformats microformats = service.getMicroformats(params);
		Assert.assertNotNull(microformats);
		log.info(microformats.toString());
	}

	/**
	 * Test comboined.
	 */
	@Test
	public void testComboined() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.URL, "http://www.techcrunch.com/");
		CombinedResults combined = service.getCombinedResults(params);
		Assert.assertNotNull(combined);
		log.info(combined.toString());
	}

}

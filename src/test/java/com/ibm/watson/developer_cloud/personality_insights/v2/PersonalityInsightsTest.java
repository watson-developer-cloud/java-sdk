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
package com.ibm.watson.developer_cloud.personality_insights.v2;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import io.netty.handler.codec.http.HttpHeaders;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.ContentItem;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Trait;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.MediaType;

/**
 * The Class PersonalityInsightsTest.
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class PersonalityInsightsTest extends WatsonServiceTest{

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(PersonalityInsightsTest.class.getName());

	/** The service. */
	private PersonalityInsights service;

	/** Mock Server *. */
	private ClientAndServer mockServer;

	/** The GET_PROFILE_PATH.  (value is "/v2/profile") */
	private final static String GET_PROFILE_PATH = "/v2/profile";

	/**
	 * Sets the up.
	 *
	 */
	private String englishText, spanishText;



	/**
	 * Start mock server.
	 */
	@Before
	public void startMockServer() {
		try {
			mockServer = startClientAndServer(Integer.parseInt(prop.getProperty("mock.server.port")));
			service = new PersonalityInsights();
			service.setApiKey("");
			service.setEndPoint("http://" + prop.getProperty("mock.server.host") + ":"
					+ prop.getProperty("mock.server.port"));
		} catch (NumberFormatException e) {
			log.log(Level.SEVERE, "Error mocking the service", e);
		}

	}

	/**
	 * Stop mock server.
	 */
	@After
	public void stopMockServer() {
		mockServer.stop();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ibm.watson.developercloud.WatsonServiceTest#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("en.txt");
		englishText =  getStringFromInputStream(in);

		in = this.getClass().getClassLoader().getResourceAsStream("es.txt");
		spanishText =  getStringFromInputStream(in);
	}


	/**
	 * Tear down.
	 *

	 * @throws Exception the exception */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test get profile.
	 */
	@Test
	public void testGetProfileWithContent() {

		ContentItem cItem = new ContentItem();
		cItem.setContent(englishText);

		Content content = new Content();
		content.addContentItem(cItem);


		Map<String, Object> params = new HashMap<String, Object>();
		params.put(PersonalityInsights.CONTENT,content);
		String contentJson = GsonSingleton.getGson().toJson(params.get(PersonalityInsights.CONTENT));

		Profile p =  new Profile();
		p.setId("*UNKNOWN*");
        p.setSource("*UNKNOWN*");
		p.setWordCount(1339);
		p.setWordCountMessage("There were 1,339 words in the input. We need a minimum of 3,500, preferably 6,000 or more, to compute a reliable estimate");
		p.setProcessedLanguage("en");

		Trait root = new Trait();
		root.setId("r");
		root.setName("root");

		Trait childA = new Trait();
		childA.setId("personality");
		childA.setName("Big 5");
		List<Trait> rootKids = new ArrayList<Trait>();
		rootKids.add(childA);
		root.setChildren(rootKids);

		Trait childA1 = new Trait();
		childA1.setId("Openness_parent");
		childA1.setName("Openness");
		childA1.setCategory("personality");
		childA1.setPercentage(0.8834414318445747);
		List<Trait> childAKids = new ArrayList<Trait>();
		childAKids.add(childA1);
		childA.setChildren(childAKids);

		Trait childA11 = new Trait();
		childA11.setId("Openness");
		childA11.setName("Openness");
		childA11.setCategory("personality");
		childA11.setPercentage(0.8834414318445747);
		childA11.setSamplingError(0.0577082256);
		List<Trait> childA1Kids = new ArrayList<Trait>();
		childA1Kids.add(childA11);
		childA1.setChildren(childA1Kids);

		Trait childA110 = new Trait();
		childA110.setId("Adventurousness");
		childA110.setName("Adventurousness");
		childA110.setCategory("personality");
		childA110.setPercentage(0.7395861152833635);
		childA110.setSamplingError(0.0494178204);

		Trait childA111 = new Trait();
		childA111.setId("Imagination");
		childA111.setName("Imagination");
		childA111.setCategory("personality");
		childA111.setPercentage(0.8226761749222228);
		childA111.setSamplingError(0.0616986395);

		Trait childA112 = new Trait();
		childA112.setId("Artistic interests");
		childA112.setName("Artistic interests");
		childA112.setCategory("personality");
		childA112.setPercentage(0.5127471735266416);
		childA112.setSamplingError(0.0464200574);

		Trait childA113 = new Trait();
		childA113.setId("Emotionality");
		childA113.setName("Emotionality");
		childA113.setCategory("personality");
		childA113.setPercentage(0.3995729122484725);
		childA113.setSamplingError(0.0464200574);

		List<Trait> childA11Kids = new ArrayList<Trait>();
		childA11Kids.add(childA110);
		childA11Kids.add(childA111);
		childA11Kids.add(childA112);
		childA11Kids.add(childA113);
		childA11.setChildren(childA11Kids);

		p.setTree(root);

		mockServer.when(
				request().withMethod("POST").withPath(GET_PROFILE_PATH)
						.withBody(contentJson.toString())

		)
				.respond(
						response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
								.withBody(GsonSingleton.getGson().toJson(p)));

		Profile profile = service.getProfile(params);
		Assert.assertNotNull(profile);
		Assert.assertEquals(profile, p);


	}

	/**
	 * Test get profile with english text.
	 */
	@Test
	public void testGetProfileWithEnglishText() {
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put(PersonalityInsights.TEXT, englishText);

		Profile englishTextProfile =  new Profile();
		englishTextProfile.setId("*UNKNOWN*");
		englishTextProfile.setSource("*UNKNOWN*");
		englishTextProfile.setWordCount(1339);
		englishTextProfile.setWordCountMessage("There were 1,339 words in the input. We need a minimum of 3,500, preferably 6,000 or more, to compute a reliable estimate");
		englishTextProfile.setProcessedLanguage("en");

		Trait root = new Trait();
		root.setId("r");
		root.setName("root");

		Trait childA = new Trait();
		childA.setId("personality");
		childA.setName("Big 5");
		List<Trait> rootKids = new ArrayList<Trait>();
		rootKids.add(childA);
		root.setChildren(rootKids);

		Trait childA1 = new Trait();
		childA1.setId("Openness_parent");
		childA1.setName("Openness");
		childA1.setCategory("personality");
		childA1.setPercentage(0.8834414318445747);
		List<Trait> childAKids = new ArrayList<Trait>();
		childAKids.add(childA1);
		childA.setChildren(childAKids);

		Trait childA11 = new Trait();
		childA11.setId("Openness");
		childA11.setName("Openness");
		childA11.setCategory("personality");
		childA11.setPercentage(0.8834414318445747);
		childA11.setSamplingError(0.0577082256);
		List<Trait> childA1Kids = new ArrayList<Trait>();
		childA1Kids.add(childA11);
		childA1.setChildren(childA1Kids);

		Trait childA110 = new Trait();
		childA110.setId("Adventurousness");
		childA110.setName("Adventurousness");
		childA110.setCategory("personality");
		childA110.setPercentage(0.7395861152833635);
		childA110.setSamplingError(0.0494178204);

		Trait childA111 = new Trait();
		childA111.setId("Imagination");
		childA111.setName("Imagination");
		childA111.setCategory("personality");
		childA111.setPercentage(0.8226761749222228);
		childA111.setSamplingError(0.0616986395);

		Trait childA112 = new Trait();
		childA112.setId("Artistic interests");
		childA112.setName("Artistic interests");
		childA112.setCategory("personality");
		childA112.setPercentage(0.5127471735266416);
		childA112.setSamplingError(0.0464200574);

		Trait childA113 = new Trait();
		childA113.setId("Emotionality");
		childA113.setName("Emotionality");
		childA113.setCategory("personality");
		childA113.setPercentage(0.3995729122484725);
		childA113.setSamplingError(0.0464200574);

		List<Trait> childA11Kids = new ArrayList<Trait>();
		childA11Kids.add(childA110);
		childA11Kids.add(childA111);
		childA11Kids.add(childA112);
		childA11Kids.add(childA113);
		childA11.setChildren(childA11Kids);

		englishTextProfile.setTree(root);

		mockServer.when(
				request().withMethod("POST").withPath(GET_PROFILE_PATH)
						.withBody(params.get(PersonalityInsights.TEXT).toString())

		)
				.respond(
						response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
								.withBody(GsonSingleton.getGson().toJson(englishTextProfile)));

		Profile profile = service.getProfile(params);
		
		Assert.assertNotNull(profile);
		Assert.assertEquals(profile, englishTextProfile);
	}

	/**
	 * Test get profile with spanish text.
	 */
	@Test
	public void testGetProfileWithSpanishText() {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put(PersonalityInsights.TEXT, spanishText);
		params.put(PersonalityInsights.LANGUAGE, "es");

		Profile spanishTextProfile =  new Profile();
		spanishTextProfile.setId("*UNKNOWN*");
		spanishTextProfile.setSource("*UNKNOWN*");
		spanishTextProfile.setWordCount(1870);
		spanishTextProfile.setWordCountMessage("There were 1,870 words in the input. We need a minimum of 3,500, preferably 6,000 or more, to compute a reliable estimate");
		spanishTextProfile.setProcessedLanguage("en");

		Trait root = new Trait();
		root.setId("r");
		root.setName("root");

		Trait childA = new Trait();
		childA.setId("personality");
		childA.setName("Big 5");
		List<Trait> rootKids = new ArrayList<Trait>();
		rootKids.add(childA);
		root.setChildren(rootKids);

		Trait childA1 = new Trait();
		childA1.setId("Openness_parent");
		childA1.setName("Openness");
		childA1.setCategory("personality");
		childA1.setPercentage(0.8834414318445747);
		List<Trait> childAKids = new ArrayList<Trait>();
		childAKids.add(childA1);
		childA.setChildren(childAKids);

		Trait childA11 = new Trait();
		childA11.setId("Openness");
		childA11.setName("Openness");
		childA11.setCategory("personality");
		childA11.setPercentage(0.8834414318445747);
		childA11.setSamplingError(0.0577082256);
		List<Trait> childA1Kids = new ArrayList<Trait>();
		childA1Kids.add(childA11);
		childA1.setChildren(childA1Kids);

		Trait childA110 = new Trait();
		childA110.setId("Adventurousness");
		childA110.setName("Adventurousness");
		childA110.setCategory("personality");
		childA110.setPercentage(0.7395861152833635);
		childA110.setSamplingError(0.0494178204);

		Trait childA111 = new Trait();
		childA111.setId("Imagination");
		childA111.setName("Imagination");
		childA111.setCategory("personality");
		childA111.setPercentage(0.8226761749222228);
		childA111.setSamplingError(0.0616986395);

		Trait childA112 = new Trait();
		childA112.setId("Artistic interests");
		childA112.setName("Artistic interests");
		childA112.setCategory("personality");
		childA112.setPercentage(0.5127471735266416);
		childA112.setSamplingError(0.0464200574);

		Trait childA113 = new Trait();
		childA113.setId("Emotionality");
		childA113.setName("Emotionality");
		childA113.setCategory("personality");
		childA113.setPercentage(0.3995729122484725);
		childA113.setSamplingError(0.0464200574);

		List<Trait> childA11Kids = new ArrayList<Trait>();
		childA11Kids.add(childA110);
		childA11Kids.add(childA111);
		childA11Kids.add(childA112);
		childA11Kids.add(childA113);
		childA11.setChildren(childA11Kids);
		spanishTextProfile.setTree(root);

		mockServer.when(
				request().withMethod("POST").withPath(GET_PROFILE_PATH)
						.withBody(params.get(PersonalityInsights.TEXT).toString())
				.withHeaders(new Header(HttpHeaders.Names.CONTENT_LANGUAGE, "es"))

		)
				.respond(
						response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
								.withBody(GsonSingleton.getGson().toJson(spanishTextProfile)));

		Profile profile = service.getProfile(params);

		Assert.assertNotNull(profile);
		Assert.assertEquals(profile, spanishTextProfile);

	}

}

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
package com.ibm.watson.developer_cloud.tone_analyzer.v1;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import io.netty.handler.codec.http.HttpHeaders;

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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.LinguisticEvidence;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.Scorecard;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.Synonym;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.SynonymResult;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.Tone;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.ToneDimension;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.ToneTrait;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.MediaType;

/**
 * The Class ToneAnalyzerTest.
 */
@SuppressWarnings("serial")
public class ToneAnalyzerTest extends WatsonServiceTest {

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(ToneAnalyzerTest.class.getName());

	/** Mock Server *. */
	private ClientAndServer mockServer;

	/** The TONE_PATH.  (value is "/v1/tone") */
	private final static String TONE_PATH = "/v1/tone";

	/** The SYNONYM_PATH.  (value is "/v1/synonym") */
	private final static String SYNONYM_PATH = "/v1/synonym";

	/** The service. */
	private ToneAnalyzer service;

	/**
	 * Start mock server.
	 */
	@Before
	public void startMockServer() {
		try {
			mockServer = startClientAndServer(Integer.parseInt(prop.getProperty("mock.server.port")));
			service = new ToneAnalyzer();
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
	 * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();

	}

	/**
	 * Test dilemmas.
	 */
	@Test
	public void testGetTone() {
		String text = "I know the times are difficult! Our sales have been "
			+ "disappointing for the past three quarters for our data analytics "
			+ "product suite. We have a competitive data analytics product "
			+ "suite in the industry. But we need to do our job selling it! ";

		Tone response = new Tone();
		response.setScorecard("email");

		final ToneDimension toneDimension = new ToneDimension();
		toneDimension.setId("emotion_tone");
		toneDimension.setName("Emotion Tone");
		response.setChildren(new ArrayList<ToneDimension>() {{
			add(toneDimension);
		}});

		final ToneTrait toneTrait = new ToneTrait();
		toneTrait.setId("Cheerfulness");
		toneTrait.setName("Cheerfulness");
		toneTrait.setNormalizedScore(0.6966722608487173);
		toneTrait.setRawScore(0.013608247422680412);
		toneTrait.setWordCount(2);
		toneDimension.setChildren(new ArrayList<ToneTrait>() {{
			add(toneTrait);
		}});

		final LinguisticEvidence linguisticEvidence = new LinguisticEvidence();
		linguisticEvidence.setCorrelation("positive");
		linguisticEvidence.setEvidenceScore(0.6966722608487173);
		linguisticEvidence.setWordCount(2);
		linguisticEvidence.setWords(new ArrayList<String>() {{
			add("challenges");
			add("improve");
		}});

		final LinguisticEvidence linguisticEvidence1 = new LinguisticEvidence();
		linguisticEvidence1.setCorrelation("positive");
		linguisticEvidence1.setEvidenceScore(0.6966722608487173);
		linguisticEvidence1.setWordCount(2);
		linguisticEvidence1.setWords(new ArrayList<String>() {{
			add("challenges");
			add("improve");
		}});

		final LinguisticEvidence linguisticEvidence2 = new LinguisticEvidence();
		linguisticEvidence2.setCorrelation("positive");
		linguisticEvidence2.setEvidenceScore(0.6966722608487173);
		linguisticEvidence2.setWordCount(2);
		linguisticEvidence2.setWords(new ArrayList<String>() {{
			add("challenges");
			add("improve");
		}});


		toneTrait.setLinguisticEvidence(new ArrayList<LinguisticEvidence>() {{
			add(linguisticEvidence);
			add(linguisticEvidence1);
			add(linguisticEvidence2);
		}});

		JsonObject contentJson = new JsonObject();
		contentJson.addProperty(ToneAnalyzer.TEXT, text);

		contentJson.addProperty(ToneAnalyzer.SCORECARD, Scorecard.EMAIL.getId());

		mockServer.when(
				request().withMethod("POST").withPath(TONE_PATH).withBody(contentJson.toString())
		)
			.respond(
					response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
							.withBody(GsonSingleton.getGson().toJson(response)));

		// Call the service and get the tone
		Tone tone = service.getTone(text, Scorecard.EMAIL);
		Assert.assertNotNull(tone);
		Assert.assertNotNull(tone.getChildren());
		Assert.assertEquals(tone, response);

	}

	/**
	 * Test get synonyms.
	 */
	@Test
	public void testGetSynonyms() {
		// Call the service and get the synonym for 'difficult'
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(ToneAnalyzer.WORDS, new String[]{"difficult", "inferior"});
		params.put(ToneAnalyzer.LIMIT, 3);

		/*** synonymResult ***/
		final SynonymResult synonymResult1 = new SynonymResult();
		synonymResult1.setTrait("openness");
		synonymResult1.setHeadword("difficult");

		final Synonym synonym10 = new Synonym();
		synonym10.setWord("petrified");
		synonym10.setSense("difficult");
		synonym10.setMeaning("not easy");
		synonym10.setHops(0);
		synonym10.setSemanticType("adj-all");
		synonym10.setWeight(-0.028989519600000006);

		final Synonym synonym11 = new Synonym();
		synonym11.setWord("embarrassing");
		synonym11.setSense("difficult");
		synonym11.setMeaning("not easy");
		synonym11.setHops(0);
		synonym11.setSemanticType("adj-all");
		synonym11.setWeight(-0.028989519600000);

		final Synonym synonym12 = new Synonym();
		synonym12.setWord("tough");
		synonym12.setSense("difficult");
		synonym12.setMeaning("not easy");
		synonym12.setHops(0);
		synonym12.setSemanticType("adj-all");
		synonym12.setWeight(-0.0289895196000009);

		synonymResult1.setSynonyms(new ArrayList<Synonym>() {{
			add(synonym10);
			add(synonym11);
			add(synonym12);
		}});

		/*** synonymResult2 ***/
		final SynonymResult synonymResult2 = new SynonymResult();
		synonymResult2.setTrait("conscientious");
		synonymResult2.setHeadword("difficult");

		final Synonym synonym20 = new Synonym();
		synonym20.setWord("trying");
		synonym20.setSense("difficult");
		synonym20.setMeaning("not easy");
		synonym20.setHops(0);
		synonym20.setSemanticType("adj-all");
		synonym20.setWeight(-0.02898951960000002);

		final Synonym synonym21 = new Synonym();
		synonym21.setWord("challenging");
		synonym21.setSense("difficult");
		synonym21.setMeaning("not easy");
		synonym21.setHops(0);
		synonym21.setSemanticType("adj-all");
		synonym21.setWeight(-0.0289895196007);

		final Synonym synonym22 = new Synonym();
		synonym22.setWord("tough");
		synonym22.setSense("difficult");
		synonym22.setMeaning("not easy");
		synonym22.setHops(0);
		synonym22.setSemanticType("adj-all");
		synonym22.setWeight(-0.0289895196000099);

		synonymResult2.setSynonyms(new ArrayList<Synonym>() {{
			add(synonym20);
			add(synonym21);
			add(synonym22);
		}});

		/*** synonymResult3 ***/
		final SynonymResult synonymResult3 = new SynonymResult();
		synonymResult3.setTrait("confident");
		synonymResult3.setHeadword("difficult");

		final Synonym synonym30 = new Synonym();
		synonym30.setWord("firm");
		synonym30.setSense("difficult");
		synonym30.setMeaning("not easy");
		synonym30.setHops(0);
		synonym30.setSemanticType("adj-all");
		synonym30.setWeight(-0.02898951960000112);

		synonymResult3.setSynonyms(new ArrayList<Synonym>() {{
			add(synonym30);
		}});

		List<SynonymResult> response = new ArrayList<SynonymResult>();
		response.add(synonymResult1);
		response.add(synonymResult1);
		response.add(synonymResult1);

		JsonObject contentJson = new JsonObject();


		// words
		JsonArray wordsJson = new JsonArray();
		for (String word : (String[])params.get(ToneAnalyzer.WORDS)) {
			wordsJson.add(new JsonPrimitive(word));
		}
		contentJson.add(ToneAnalyzer.WORDS, wordsJson);

		if (params.containsKey(ToneAnalyzer.LIMIT))
			contentJson.addProperty(ToneAnalyzer.LIMIT,(Integer)params.get(ToneAnalyzer.LIMIT));

		mockServer.when(
				request().withMethod("POST").withPath(SYNONYM_PATH).withBody(contentJson.toString())
		)
				.respond(
						response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
								.withBody(GsonSingleton.getGson().toJson(response)));

		List<SynonymResult> synonyms = service.getSynonyms(params);

		Assert.assertNotNull(synonyms);
		Assert.assertFalse(synonyms.isEmpty());
		Assert.assertEquals(synonyms,response);

	}

}

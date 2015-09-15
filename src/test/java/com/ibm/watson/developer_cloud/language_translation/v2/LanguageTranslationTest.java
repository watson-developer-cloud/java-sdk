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
package com.ibm.watson.developer_cloud.language_translation.v2;

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
import org.mockserver.model.Parameter;
import org.mockserver.verify.VerificationTimes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiableLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.Translation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationModel;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.MediaType;

/**
 * Created by nizar.
 */
public class LanguageTranslationTest extends WatsonServiceTest {

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(LanguageTranslationTest.class.getName());

	/** The model id. */
	private String modelId;

	/** The service. */
	private LanguageTranslation service;

	/** Mock Server *. */
	private ClientAndServer mockServer;

	/** The text. */
	private String text;

	/** The Constant LANGUAGE_TRANSLATION_PATH.  (value is "/v2/translate") */
	private final static String LANGUAGE_TRANSLATION_PATH = "/v2/translate";

	/** The Constant IDENTIFIABLE_LANGUAGES_PATH. (value is "/v2/identifiable_languages") */
	private final static String IDENTIFIABLE_LANGUAGES_PATH = "/v2/identifiable_languages";

	/** The Constant GET_MODELS_PATH. (value is "/v2/models") */
	private final static String GET_MODELS_PATH = "/v2/models";

	/** The Constant IDENTITY_PATH. (value is "/v2/identify") */
	private final static String IDENTITY_PATH = "/v2/identify";

	/**
	 * Start mock server.
	 */
	@Before
	public void startMockServer() {
		try {
			mockServer = startClientAndServer(Integer.parseInt(prop.getProperty("mock.server.port")));
			service = new LanguageTranslation();
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
		modelId = prop.getProperty("language_translation.model_id");
		text = "The IBM Watson team is awesome";
	}

	/**
	 * Test translate.
	 */
	@Test
	public void testTranslate() {

		// Mocking the response
		Map<String, Object> response = new HashMap<String, Object>();
		List<Translation> translations = new ArrayList<Translation>();

		Translation t = new Translation().withTranslation("El equipo es increible IBM Watson");
		translations.add(t);

		response.put("word_count", 6);
		response.put("character_count", 20);
		response.put("translations", translations);

		String[] text1 = new String[] { text };

		JsonObject contentJson = new JsonObject();
		JsonArray paragraphs = new JsonArray();
		for (String paragraph : text1) {
			paragraphs.add(new JsonPrimitive(paragraph));
		}
		contentJson.add(LanguageTranslation.TEXT, paragraphs);
		mockServer.when(
				request().withMethod("POST").withPath(LANGUAGE_TRANSLATION_PATH)
						.withQueryStringParameter(new Parameter(LanguageTranslation.MODEL_ID, modelId))
						.withBody(contentJson.toString())

		)
		.respond(
				response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
						.withBody(GsonSingleton.getGson().toJson(response)));

		TranslationResult translationResult = service.translate(text, modelId);
		testTranslationResult(text, translationResult);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put(LanguageTranslation.TEXT, new String[] { text });
		params.put(LanguageTranslation.MODEL_ID, modelId);

		translationResult = service.translate(params);
		testTranslationResult(text, translationResult);
	}

	/**
	 * Test translation result.
	 * 
	 * @param text
	 *            the text
	 * @param translationResult
	 *            the translation result
	 */
	private void testTranslationResult(String text, TranslationResult translationResult) {
		Assert.assertNotNull(translationResult);
		Assert.assertEquals(translationResult.getWordCount(), text.split(" ").length);
		Assert.assertNotNull(translationResult.getTranslations());
		Assert.assertNotNull(translationResult.getTranslations().get(0).getTranslation());
	}

	/**
	 * Test Get Identifiable languages.
	 */
	@Test
	public void testGetIdentifiableLanguages() {

		Map<String, Object> response = new HashMap<String, Object>();
		List<IdentifiableLanguage> langs = new ArrayList<IdentifiableLanguage>();
		langs.add(new IdentifiableLanguage("af", "Afrikaans"));
		langs.add(new IdentifiableLanguage("ar", "Arabic"));
		langs.add(new IdentifiableLanguage("az", "Azerbaijani"));
		langs.add(new IdentifiableLanguage("zh", "Chinese"));
		response.put("languages", langs);

		mockServer.when(request().withPath(IDENTIFIABLE_LANGUAGES_PATH)).respond(
				response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
						.withBody(GsonSingleton.getGson().toJson(response)));

		List<IdentifiableLanguage> languages = service.getIdentifiableLanguages();

		mockServer.verify(request().withPath(IDENTIFIABLE_LANGUAGES_PATH), VerificationTimes.exactly(1));
		Assert.assertNotNull(languages);
		Assert.assertEquals(languages,langs);
	}

	/**
	 * Test Get Identifiable languages.
	 */
	@Test
	public void testGetModel() {
		// Mock response
		TranslationModel tm = new TranslationModel();
		String model_id = "not-a-real-model";
		tm.setModelId(model_id);
		tm.setSource("en");
		tm.setBaseModelId("en-es");
		tm.setDomain("news");
		tm.setCustomizable(false);
		tm.setDefaultModel(false);
		tm.setOwner("not-a-real-user");
		tm.setStatus("error");
		tm.setName("custom-english-to-spanish");

		System.out.println(GsonSingleton.getGson().toJson(tm));

		mockServer.when(request().withPath(GET_MODELS_PATH + "/" + model_id)).respond(
				response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
						.withBody(GsonSingleton.getGson().toJson(tm)));

		TranslationModel model = service.getModel("not-a-real-model");

		mockServer.verify(request().withPath(GET_MODELS_PATH + "/" + model_id), VerificationTimes.exactly(1));
		Assert.assertNotNull(model);
		// Assert.assertEquals(model.getModelId(),tm.getModelId());
	}

	/**
	 * Test Get Models.
	 */
	@Test
	public void testGetModels() {

		Map<String, Object> response = new HashMap<String, Object>();
		List<TranslationModel> tsModels = new ArrayList<TranslationModel>();

		TranslationModel tm = new TranslationModel();
		tm.setModelId("not-a-real-model");
		tm.setSource("en");
		tm.setBaseModelId("en-es");
		tm.setDomain("news");
		tm.setCustomizable(false);
		tm.setDefaultModel(false);
		tm.setOwner("not-a-real-user");
		tm.setStatus("error");
		tm.setName("custom-english-to-spanish");
		tsModels.add(tm);

		TranslationModel tm1 = new TranslationModel();
		tm1.setModelId("not-a-real-model-2");
		tm1.setSource("en");
		tm1.setBaseModelId("es");
		tm1.setDomain("news");
		tm1.setCustomizable(false);
		tm1.setDefaultModel(false);
		tm1.setOwner("not-a-real-user");
		tm1.setStatus("error");
		tm1.setName("custom-english-to-spanish");
		tsModels.add(tm1);

		TranslationModel tm2 = new TranslationModel();
		tm2.setModelId("ar-en");
		tm2.setSource("en");
		tm2.setBaseModelId("");
		tm2.setDomain("news");
		tm2.setCustomizable(true);
		tm2.setDefaultModel(true);
		tm2.setOwner("");
		tm2.setStatus("available");
		tm2.setName("custom-english-to-spanish");
		tsModels.add(tm2);

		response.put("models", tsModels);

		mockServer.when(request().withPath(GET_MODELS_PATH)).respond(
				response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
						.withBody(GsonSingleton.getGson().toJson(response)));

		List<TranslationModel> models = service.getModels();

		mockServer.verify(request().withPath(GET_MODELS_PATH), VerificationTimes.exactly(1));
		Assert.assertNotNull(models);

		Assert.assertNotNull(models);
		Assert.assertFalse(models.isEmpty());
		Assert.assertNotNull(models.containsAll(tsModels));

	}

	/**
	 * Test Identify.
	 */
	@Test
	public void testIdentify() {

		Map<String, Object> response = new HashMap<String, Object>();
		List<IdentifiedLanguage> langs = new ArrayList<IdentifiedLanguage>();
		langs.add(new IdentifiedLanguage("en", 0.877159));
		langs.add(new IdentifiedLanguage("af", 0.0752636));
		langs.add(new IdentifiedLanguage("nl", 0.0301593));

		response.put("languages", langs);

		mockServer.when(request().withMethod("POST").withPath(IDENTITY_PATH).withBody(text)).respond(
				response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
						.withBody(GsonSingleton.getGson().toJson(response)));

		List<IdentifiedLanguage> identifiedLanguages = service.identify(text);
		Assert.assertNotNull(identifiedLanguages);
		Assert.assertFalse(identifiedLanguages.isEmpty());
		Assert.assertNotNull(identifiedLanguages.containsAll(langs));
	}

	/**
	 * Test Translate with an invalid model.
	 */
	@Test
	public void testTranslateNotSupported() {
		boolean fail = true;
		try {
			// Mocking the response
			service.translate("X", "FOO-BAR-FOO");
		} catch (Exception e) {
			fail = false;
		}
		Assert.assertFalse(fail);
	}
}

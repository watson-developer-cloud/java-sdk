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
package com.ibm.watson.developer_cloud.language_translation.v2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import io.netty.handler.codec.http.HttpHeaders;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
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
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiableLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.Translation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationModel;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Created by nizar.
 */
public class LanguageTranslationTest extends WatsonServiceTest {

  /** The Constant GET_MODELS_PATH. (value is "/v2/models") */
  private final static String GET_MODELS_PATH = "/v2/models";

  /** The Constant IDENTIFIABLE_LANGUAGES_PATH. (value is "/v2/identifiable_languages") */
  private final static String IDENTIFIABLE_LANGUAGES_PATH = "/v2/identifiable_languages";

  /** The Constant IDENTITY_PATH. (value is "/v2/identify") */
  private final static String IDENTITY_PATH = "/v2/identify";

  /** The Constant LANGUAGE_TRANSLATION_PATH. (value is "/v2/translate") */
  private final static String LANGUAGE_TRANSLATION_PATH = "/v2/translate";

  /** The Constant log. */
  private static final Logger log = Logger.getLogger(LanguageTranslationTest.class.getName());

  /** Mock Server *. */
  private ClientAndServer mockServer;

  /** The model id. */
  private String modelId;

  /** The service. */
  private LanguageTranslation service;

  /** The text. */
  private String text;

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developercloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    modelId = getValidProperty("language_translation.model_id");
    text = "The IBM Watson team is awesome";
  }

  /**
   * Start mock server.
   */
  @Before
  public void startMockServer() {
    try {
      mockServer = startClientAndServer(Integer.parseInt(getValidProperty("mock.server.port")));
      service = new LanguageTranslation();
      service.setApiKey("");
      service.setEndPoint("http://" + getValidProperty("mock.server.host") + ":"
          + getValidProperty("mock.server.port"));
    } catch (final NumberFormatException e) {
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

  /**
   * Testcreate model with base model null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testcreateModelWithBaseModelNull() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(LanguageTranslation.FORCED_GLOSSARY, new File("src/test/resources/car.png"));
    service.createModel(params);
  }

  /**
   * Testcreate model with glossary null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testcreateModelWithGlossaryNull() {
    final Map<String, Object> params = new HashMap<String, Object>();

    service.createModel(params);
  }

  /**
   * Testcreate model with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testcreateModelWithNull() {
    final Map<String, Object> params = new HashMap<String, Object>();
    service.createModel(params);
  }

  /**
   * Test delete with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDeleteWithNull() {
    service.deleteModel(null);
  }

  /**
   * Test Get Identifiable languages.
   */
  @Test
  public void testGetIdentifiableLanguages() {

    final Map<String, Object> response = new HashMap<String, Object>();
    final List<IdentifiableLanguage> langs = new ArrayList<IdentifiableLanguage>();
    langs.add(new IdentifiableLanguage("af", "Afrikaans"));
    langs.add(new IdentifiableLanguage("ar", "Arabic"));
    langs.add(new IdentifiableLanguage("az", "Azerbaijani"));
    langs.add(new IdentifiableLanguage("zh", "Chinese"));
    response.put("languages", langs);

    mockServer.when(request().withPath(IDENTIFIABLE_LANGUAGES_PATH)).respond(
        response().withHeaders(
            new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)).withBody(
            GsonSingleton.getGson().toJson(response)));

    final List<IdentifiableLanguage> languages = service.getIdentifiableLanguages();

    mockServer
        .verify(request().withPath(IDENTIFIABLE_LANGUAGES_PATH), VerificationTimes.exactly(1));
    assertNotNull(languages);
    assertEquals(languages, langs);
  }

  /**
   * Test Get Identifiable languages.
   */
  @Test
  public void testGetModel() {
    // Mock response
    final TranslationModel tm = new TranslationModel();
    final String model_id = "not-a-real-model";
    tm.setModelId(model_id);
    tm.setSource("en");
    tm.setBaseModelId("en-es");
    tm.setDomain("news");
    tm.setCustomizable(false);
    tm.setDefaultModel(false);
    tm.setOwner("not-a-real-user");
    tm.setStatus("error");
    tm.setName("custom-english-to-spanish");

    mockServer.when(request().withPath(GET_MODELS_PATH + "/" + model_id)).respond(
        response().withHeaders(
            new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)).withBody(
            GsonSingleton.getGson().toJson(tm)));

    final TranslationModel model = service.getModel("not-a-real-model");

    mockServer.verify(request().withPath(GET_MODELS_PATH + "/" + model_id),
        VerificationTimes.exactly(1));
    assertNotNull(model);
  }

  /**
   * Test Get Models.
   */
  @Test
  public void testGetModels() {

    final Map<String, Object> response = new HashMap<String, Object>();
    final List<TranslationModel> tsModels = new ArrayList<TranslationModel>();

    final TranslationModel tm = new TranslationModel();
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

    final TranslationModel tm1 = new TranslationModel();
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

    final TranslationModel tm2 = new TranslationModel();
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
        response().withHeaders(
            new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)).withBody(
            GsonSingleton.getGson().toJson(response)));

    final List<TranslationModel> models = service.getModels();

    mockServer.verify(request().withPath(GET_MODELS_PATH), VerificationTimes.exactly(1));
    assertNotNull(models);

    assertNotNull(models);
    assertFalse(models.isEmpty());
    assertNotNull(models.containsAll(tsModels));

  }

  /**
   * Test get model with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetModelWithNull() {
    final String model = null;
    service.getModel(model);
  }

  /**
   * Test Identify.
   */
  @Test
  public void testIdentify() {

    final Map<String, Object> response = new HashMap<String, Object>();
    final List<IdentifiedLanguage> langs = new ArrayList<IdentifiedLanguage>();
    langs.add(new IdentifiedLanguage("en", 0.877159));
    langs.add(new IdentifiedLanguage("af", 0.0752636));
    langs.add(new IdentifiedLanguage("nl", 0.0301593));

    response.put("languages", langs);

    mockServer.when(request().withMethod("POST").withPath(IDENTITY_PATH).withBody(text)).respond(
        response().withHeaders(
            new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)).withBody(
            GsonSingleton.getGson().toJson(response)));

    final List<IdentifiedLanguage> identifiedLanguages = service.identify(text);
    assertNotNull(identifiedLanguages);
    assertFalse(identifiedLanguages.isEmpty());
    assertNotNull(identifiedLanguages.containsAll(langs));
  }

  /**
   * Test translate.
   */
  @Test
  public void testTranslate() {

    // Mocking the response
    final Map<String, Object> response = new HashMap<String, Object>();
    final List<Translation> translations = new ArrayList<Translation>();

    final Translation t = new Translation().withTranslation("El equipo es increible IBM Watson");
    translations.add(t);

    response.put("word_count", 6);
    response.put("character_count", 20);
    response.put("translations", translations);

    final String[] text1 = new String[] {text};

    final JsonObject contentJson = new JsonObject();
    final JsonArray paragraphs = new JsonArray();
    for (final String paragraph : text1) {
      paragraphs.add(new JsonPrimitive(paragraph));
    }
    contentJson.add(LanguageTranslation.TEXT, paragraphs);
    mockServer.when(
        request().withMethod("POST").withPath(LANGUAGE_TRANSLATION_PATH)
            .withQueryStringParameter(new Parameter(LanguageTranslation.MODEL_ID, modelId))
            .withBody(contentJson.toString())

    ).respond(
        response().withHeaders(
            new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)).withBody(
            GsonSingleton.getGson().toJson(response)));

    TranslationResult translationResult = service.translate(text, modelId);
    testTranslationResult(text, translationResult);

    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(LanguageTranslation.TEXT, new String[] {text});
    params.put(LanguageTranslation.MODEL_ID, modelId);

    translationResult = service.translate(params);
    testTranslationResult(text, translationResult);
    assertNotNull(service.toString());
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
    } catch (final Exception e) {
      fail = false;
    }
    assertFalse(fail);
  }


  /**
   * Test translate with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTranslateWithNull() {
    service.translate(null, "", "");

  }

  /**
   * Test translation result.
   * 
   * @param text the text
   * @param translationResult the translation result
   */
  private void testTranslationResult(String text, TranslationResult translationResult) {
    assertNotNull(translationResult);
    assertEquals(translationResult.getWordCount(), text.split(" ").length);
    assertNotNull(translationResult.getTranslations());
    assertNotNull(translationResult.getTranslations().get(0).getTranslation());
  }
}

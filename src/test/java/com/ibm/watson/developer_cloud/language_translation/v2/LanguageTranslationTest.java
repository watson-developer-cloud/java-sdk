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
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import io.netty.handler.codec.http.HttpHeaders;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockserver.model.Header;
import org.mockserver.verify.VerificationTimes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.language_translation.v2.model.CreateModelOptions;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiableLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.LanguageList;
import com.ibm.watson.developer_cloud.language_translation.v2.model.Translation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationModel;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationModelList;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

public class LanguageTranslationTest extends WatsonServiceUnitTest {

  private final static String GET_MODELS_PATH = "/v2/models";
  private final static String IDENTIFIABLE_LANGUAGES_PATH = "/v2/identifiable_languages";
  private final static String IDENTITY_PATH = "/v2/identify";
  private final static String LANGUAGE_TRANSLATION_PATH = "/v2/translate";
  private final static String RESOURCE = "src/test/resources/language_translation/";

  private String modelId;
  private LanguageTranslation service;
  private String text;
  private LanguageList identifiableLanguages;
  private TranslationModel model;
  private TranslationModelList models;

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developercloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    modelId = "foo-bar";
    text = "The IBM Watson team is awesome";

    service = new LanguageTranslation();
    service.setApiKey("");
    service.setEndPoint(MOCK_SERVER_URL);

    // fixtures
    identifiableLanguages =
        loadFixture(RESOURCE + "identifiable_languages.json", LanguageList.class);
    model = loadFixture(RESOURCE + "model.json", TranslationModel.class);
    models = loadFixture(RESOURCE + "models.json", TranslationModelList.class);
  }

  /**
   * Test create model with base model null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testcreateModelWithBaseModelNull() {
    final CreateModelOptions options =
        new CreateModelOptions().forcedGlossary(new File("src/test/resources/car.png"));
    service.createModel(options);
  }

  /**
   * Test create model with glossary null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testcreateModelWithGlossaryNull() {
    service.createModel(new CreateModelOptions());
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

    mockServer.when(request().withPath(IDENTIFIABLE_LANGUAGES_PATH)).respond(
        response().withHeader(APPLICATION_JSON).withBody(
            GsonSingleton.getGson().toJson(identifiableLanguages)));

    List<IdentifiableLanguage> languages = service.getIdentifiableLanguages();

    assertEquals(GsonSingleton.getGson().toJson(languages),
        GsonSingleton.getGson().toJson(identifiableLanguages.getLanguages()));
  }

  /**
   * Test Get Model.
   */
  @Test
  public void testGetModel() {

    mockServer.when(request().withPath(GET_MODELS_PATH + "/" + model.getId())).respond(
        response().withHeader(APPLICATION_JSON).withBody(GsonSingleton.getGson().toJson(model)));

    TranslationModel returnedModel = service.getModel(model.getId());

    assertEquals(model, returnedModel);
  }

  /**
   * Test Get Models.
   */
  @Test
  public void testGetModels() {
    mockServer.when(request().withPath(GET_MODELS_PATH)).respond(
        response().withHeaders(
            new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)).withBody(
            GsonSingleton.getGson().toJson(models)));

    final List<TranslationModel> modelList = service.getModels();

    mockServer.verify(request().withPath(GET_MODELS_PATH), VerificationTimes.exactly(1));

    assertEquals(GsonSingleton.getGson().toJson(models.getModels()), GsonSingleton.getGson()
        .toJson(modelList));
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
    contentJson.add("text", paragraphs);
    contentJson.addProperty("model_id", modelId);
    mockServer.when(request().withMethod("POST").withPath(LANGUAGE_TRANSLATION_PATH)

    .withBody(contentJson.toString())

    ).respond(
        response().withHeaders(
            new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)).withBody(
            GsonSingleton.getGson().toJson(response)));

    TranslationResult translationResult = service.translate(text, modelId);
    testTranslationResult(text, translationResult);

    translationResult = service.translate(text, modelId);
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

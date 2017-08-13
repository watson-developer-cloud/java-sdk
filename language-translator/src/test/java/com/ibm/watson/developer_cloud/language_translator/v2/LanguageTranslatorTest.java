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
package com.ibm.watson.developer_cloud.language_translator.v2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.language_translator.v2.model.CreateModelOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.GetModelOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.IdentifiableLanguage;
import com.ibm.watson.developer_cloud.language_translator.v2.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.language_translator.v2.model.IdentifyOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.ListModelsOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslateOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.Translation;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationModel;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationModels;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult;
import com.ibm.watson.developer_cloud.language_translator.v2.util.Language;
import com.ibm.watson.developer_cloud.service.exception.BadRequestException;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import okhttp3.mockwebserver.RecordedRequest;

/**
 * Language Translator V2 Unit tests.
 */
public class LanguageTranslatorTest extends WatsonServiceUnitTest {

  private static final String GET_MODELS_PATH = "/v2/models";
  private static final String IDENTIFIABLE_LANGUAGES_PATH = "/v2/identifiable_languages";
  private static final String IDENTITY_PATH = "/v2/identify";
  private static final String LANGUAGE_TRANSLATION_PATH = "/v2/translate";
  private static final String RESOURCE = "src/test/resources/language_translation/";
  private static final Type TYPE_IDENTIFIED_LANGUAGES =
      new TypeToken<Map<String, List<IdentifiableLanguage>>>() { }.getType();
  private static final Gson GSON = GsonSingleton.getGsonWithoutPrettyPrinting();
  private final String modelId = "foo-bar";
  private LanguageTranslator service;

  private final Map<String, String> translations = ImmutableMap.of("The IBM Watson team is awesome",
      "El equipo es increíble IBM Watson", "Welcome to the cognitive era", "Bienvenido a la era cognitiva");
  private final List<String> texts = ImmutableList.copyOf(translations.keySet());

  private TranslationModel model;
  private TranslationModels models;
  private Map<String, Object> identifiableLanguages;

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developercloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    service = new LanguageTranslator();
    service.setApiKey("");
    service.setEndPoint(getMockWebServerUrl());

    // fixtures
    String jsonString = getStringFromInputStream(new FileInputStream(RESOURCE + "identifiable_languages.json"));
    identifiableLanguages = GSON.fromJson(jsonString, TYPE_IDENTIFIED_LANGUAGES);

    model = loadFixture(RESOURCE + "model.json", TranslationModel.class);
    models = loadFixture(RESOURCE + "models.json", TranslationModels.class);
  }

  /**
   * Test create model with base model null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testcreateModelWithBaseModelNull() throws IOException {
    InputStream glossary = new FileInputStream(new File(RESOURCE + "glossary.tmx"));
    final CreateModelOptions options = new CreateModelOptions.Builder()
        .forcedGlossary(glossary)
        .build();
    service.createModel(options).execute();
  }

  /**
   * Test create model with baseModelId null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testcreateModelWithBaseModelIdNull() {
    service.createModel(new CreateModelOptions.Builder().build()).execute();
  }

  /**
   * Test create model with glossary null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testcreateModelWithGlossaryNull() {
    service.createModel(new CreateModelOptions.Builder(modelId).build()).execute();
  }

  /**
   * Test delete with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDeleteWithNull() {
    service.deleteModel(null).execute();
  }

  /**
   * Test Get Identifiable languages.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetIdentifiableLanguages() throws InterruptedException {
    server.enqueue(jsonResponse(identifiableLanguages));

    final List<IdentifiableLanguage> languages = service.listIdentifiableLanguages().execute().getLanguages();
    final RecordedRequest request = server.takeRequest();

    assertEquals(IDENTIFIABLE_LANGUAGES_PATH, request.getPath());
    assertEquals(GSON.toJson(languages), GSON.toJson(identifiableLanguages.get("languages")));
  }

  /**
   * Test Get Model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetModel() throws InterruptedException {
    server.enqueue(jsonResponse(model));

    GetModelOptions getOptions = new GetModelOptions.Builder(model.getModelId()).build();
    final TranslationModel returnedModel = service.getModel(getOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(GET_MODELS_PATH + "/" + model.getModelId(), request.getPath());
    assertEquals(model, returnedModel);
  }

  /**
   * Test Get Models.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testListModels() throws InterruptedException {
    server.enqueue(jsonResponse(models));

    ListModelsOptions options = new ListModelsOptions.Builder().build();
    final List<TranslationModel> modelList = service.listModels(options).execute().getModels();
    final RecordedRequest request = server.takeRequest();

    assertEquals(GET_MODELS_PATH, request.getPath());
    assertEquals(GSON.toJson(models.getModels()), GSON.toJson(modelList));
  }

  /**
   * Test get model with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetModelWithNull() {
    final String modelId = null;
    GetModelOptions getOptions = new GetModelOptions.Builder(modelId).build();
    service.getModel(getOptions).execute();
  }

  /**
   * Test Identify.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testIdentify() throws InterruptedException {
    IdentifiedLanguage val1 = new IdentifiedLanguage();
    val1.setLanguage(Language.ENGLISH);
    val1.setConfidence(0.877159);
    IdentifiedLanguage val2 = new IdentifiedLanguage();
    val1.setLanguage(Language.AFRIKAANS);
    val1.setConfidence(0.0752636);
    final List<IdentifiedLanguage> langs = Arrays.asList(val1, val2);
    final Map<String, ?> response = ImmutableMap.of("languages", langs);
    final String text = texts.get(0);

    server.enqueue(jsonResponse(response));

    IdentifyOptions identifyOptions = new IdentifyOptions.Builder(text).build();
    final List<IdentifiedLanguage> identifiedLanguages = service.identify(identifyOptions).execute().getLanguages();
    final RecordedRequest request = server.takeRequest();

    assertEquals(IDENTITY_PATH, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(text, request.getBody().readUtf8());
    assertNotNull(identifiedLanguages);
    assertFalse(identifiedLanguages.isEmpty());
    assertNotNull(identifiedLanguages.containsAll(langs));
  }

  /**
   * Test translate.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testTranslate() throws InterruptedException {
    final String text = texts.get(0);
    final Translation t = new Translation();
    t.setTranslation(text);

    final Map<String, ?> response =
        ImmutableMap.of("word_count", 6, "character_count", 20, "translations", Collections.singletonList(t));

    final Map<String, ?> requestBody = ImmutableMap.of("text", Collections.singleton(text), "model_id", modelId);

    server.enqueue(jsonResponse(response));
    TranslateOptions translateOptions = new TranslateOptions.Builder().addText(text).modelId(modelId).build();
    TranslationResult translationResult = service.translate(translateOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(LANGUAGE_TRANSLATION_PATH, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(GSON.toJson(requestBody), request.getBody().readUtf8());
    testTranslationResult(text, translationResult);
  }

  /**
   * Test translate multiple texts.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testTranslateMultiple() throws InterruptedException {
    final Translation t1 = new Translation();
    t1.setTranslation(translations.get(texts.get(0)));
    final Translation t2 = new Translation();
    t2.setTranslation(translations.get(texts.get(1)));

    final Map<String, ?> response =
        ImmutableMap.of("word_count", 6, "character_count", 20, "translations", Arrays.asList(t1, t2));

    final Map<String, ?> requestBody = ImmutableMap.of("text", texts, "model_id", modelId);

    server.enqueue(jsonResponse(response));
    TranslateOptions translateOptions = new TranslateOptions.Builder()
        .text(texts)
        .modelId(modelId)
        .build();
    TranslationResult translationResult = service.translate(translateOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(LANGUAGE_TRANSLATION_PATH, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(GSON.toJson(requestBody), request.getBody().readUtf8());
    assertEquals(2, translationResult.getTranslations().size());
    assertEquals(translations.get(texts.get(0)), translationResult.getTranslations().get(0).getTranslation());
    assertEquals(translations.get(texts.get(1)), translationResult.getTranslations().get(1).getTranslation());
  }

  /**
   * Test Translate with an invalid model.
   */
  @Test(expected = BadRequestException.class)
  public void testTranslateNotSupported() {
    Map<String, ?> response = ImmutableMap.of("error_code", 400, "error message", "error");
    server.enqueue(jsonResponse(response).setResponseCode(400));
    TranslateOptions translateOptions = new TranslateOptions.Builder()
        .addText("X")
        .modelId("FOO-BAR-FOO")
        .build();
    service.translate(translateOptions).execute();
  }


  /**
   * Test translate with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTranslateWithNull() {
    TranslateOptions translateOptions = new TranslateOptions.Builder().build();
    service.translate(translateOptions).execute();
  }

  /**
   * Test translation result.
   *
   * @param text the text
   * @param translationResult the translation result
   */
  private void testTranslationResult(String text, TranslationResult translationResult) {
    assertNotNull(translationResult);
    assertEquals(translationResult.getWordCount().intValue(), text.split(" ").length);
    assertNotNull(translationResult.getTranslations());
    assertNotNull(translationResult.getTranslations().get(0).getTranslation());
  }

  /**
   * Test translate options.
   */
  @Test
  public void testTranslateOptions() {
    final String text = "Hello, Watson!";

    TranslateOptions options1 = new TranslateOptions.Builder()
        .addText(text)
        .modelId(modelId)
        .build();
    TranslateOptions.Builder builder = options1.newBuilder();
    TranslateOptions options2 = builder.text(texts).build();
    assertEquals(options2.text(), texts);
    assertEquals(options2.modelId(), modelId);
  }

  /**
   * Test create model options.
   */
  @Test
  public void testCreateModelOptions() {

    String myParallelCorpus = "{\"field\":\"value\"}";
    InputStream parallelCorpusStream = new ByteArrayInputStream(myParallelCorpus.getBytes());
    String myMonolingualCorpus = "{\"field\":\"value\"}";
    InputStream monolingualCorpusStream = new ByteArrayInputStream(myMonolingualCorpus.getBytes());

    CreateModelOptions options1 = new CreateModelOptions.Builder(modelId)
        .parallelCorpus(parallelCorpusStream)
        .monolingualCorpus(monolingualCorpusStream)
        .build();
    CreateModelOptions.Builder builder = options1.newBuilder();
    CreateModelOptions options2 = builder.name("baz").build();
    assertEquals(options2.baseModelId(), modelId);
    assertEquals(options2.parallelCorpus(), parallelCorpusStream);
    assertEquals(options2.monolingualCorpus(), monolingualCorpusStream);
    assertEquals(options2.name(), "baz");
  }
}

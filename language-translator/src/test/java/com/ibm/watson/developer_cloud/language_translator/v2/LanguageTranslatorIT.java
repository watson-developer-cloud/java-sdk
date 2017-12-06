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
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.ibm.watson.developer_cloud.language_translator.v2.model.CreateModelOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.DeleteModelOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.GetModelOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.IdentifiableLanguage;
import com.ibm.watson.developer_cloud.language_translator.v2.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.language_translator.v2.model.IdentifyOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.ListModelsOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslateOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationModel;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult;
import com.ibm.watson.developer_cloud.language_translator.v2.util.Language;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.ibm.watson.developer_cloud.WatsonServiceTest;

/**
 * Language Translator integration test.
 */
public class LanguageTranslatorIT extends WatsonServiceTest {

  private static final String ENGLISH_TO_SPANISH = "en-es";
  private static final String RESOURCE = "src/test/resources/language_translation/";

  private LanguageTranslator service;

  private final Map<String, String> translations = ImmutableMap.of("The IBM Watson team is awesome",
      "El equipo es increíble IBM Watson", "Welcome to the cognitive era", "Bienvenido a la era cognitiva");
  private final List<String> texts = ImmutableList.copyOf(translations.keySet());

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developercloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String username = getProperty("language_translator.username");
    String password = getProperty("language_translator.password");

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    service = new LanguageTranslator();
    service.setUsernameAndPassword(username, password);
    service.setEndPoint(getProperty("language_translator.url"));
    service.setDefaultHeaders(getDefaultHeaders());
  }

  /**
   * Test README.
   */
  @Test
  public void testReadme() throws InterruptedException, IOException {
//    LanguageTranslator service = new LanguageTranslator();
//    service.setUsernameAndPassword("<username>", "<password>");

    TranslateOptions translateOptions = new TranslateOptions.Builder()
        .addText("hello").source(Language.ENGLISH).target(Language.SPANISH).build();
    TranslationResult translationResult = service.translate(translateOptions).execute();

    System.out.println(translationResult);
  }

  /**
   * Test create and delete model.
   */
  @Test
  public void testCreateAndDeleteModel() throws IOException {

    String modelName = "integration-test";
    String baseModelId = "en-es";

    InputStream glossary = new FileInputStream(new File(RESOURCE + "glossary.tmx"));
    CreateModelOptions options = new CreateModelOptions.Builder()
        .name(modelName)
        .baseModelId(baseModelId)
        .forcedGlossary(glossary)
        .forcedGlossaryFilename("test_glossary")
        .build();

    TranslationModel model = null;
    try {
      model = service.createModel(options).execute();
      Thread.sleep(3000);
      assertNotNull(model);
      assertTrue(model.getModelId() != null && model.getModelId().length() > 0);
      assertEquals(model.getName(), modelName);
      assertEquals(model.getBaseModelId(), baseModelId);
      assertEquals(model.isCustomizable(), false);
      assertEquals(model.isDefaultModel(), false);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      if (model != null) {
        DeleteModelOptions deleteOptions = new DeleteModelOptions.Builder(model.getModelId()).build();
        service.deleteModel(deleteOptions).execute();
      }
    }
  }

  /**
   * Test Get Identifiable languages.
   */
  @Test
  public void testGetIdentifiableLanguages() {
    final List<IdentifiableLanguage> languages = service.listIdentifiableLanguages().execute().getLanguages();
    assertNotNull(languages);
    assertTrue(!languages.isEmpty());
  }

  /**
   * Test Get model by id.
   */
  @Test
  public void testGetModel() {
    GetModelOptions getOptions = new GetModelOptions.Builder(ENGLISH_TO_SPANISH).build();
    final TranslationModel model = service.getModel(getOptions).execute();
    assertNotNull(model);
  }

  /**
   * Test List Models.
   */
  @Test
  public void testListModels() {
    final List<TranslationModel> models = service.listModels(null).execute().getModels();

    assertNotNull(models);
    assertFalse(models.isEmpty());
  }

  /**
   * Test List Models with Options.
   */
  @Test
  public void testListModelsWithOptions() {
    ListModelsOptions options = new ListModelsOptions.Builder()
        .source("en")
        .target("es")
        .defaultModels(false)
        .build();
    final List<TranslationModel> models = service.listModels(options).execute().getModels();

    assertNotNull(models);
    assertFalse(models.isEmpty());
    assertEquals(models.get(0).getSource(), options.source());
    assertEquals(models.get(0).getTarget(), options.target());
  }

  /**
   * Test Identify.
   */
  @Test
  public void testIdentify() {

    IdentifyOptions options = new IdentifyOptions.Builder(texts.get(0)).build();
    final List<IdentifiedLanguage> identifiedLanguages = service.identify(options).execute().getLanguages();
    assertNotNull(identifiedLanguages);
    assertFalse(identifiedLanguages.isEmpty());
  }

  /**
   * Test translate.
   */
  @Test
  public void testTranslate() {
    for (String text : texts) {
      TranslateOptions options = new TranslateOptions.Builder()
          .addText(text).modelId(ENGLISH_TO_SPANISH).build();
      testTranslationResult(text, translations.get(text), service.translate(options).execute());
      TranslateOptions options1 = new TranslateOptions.Builder()
          .addText(text).source(Language.ENGLISH).target(Language.SPANISH).build();
      testTranslationResult(text, translations.get(text), service.translate(options1).execute());
    }
  }

  /**
   * Test translate multiple.
   */
  @Test
  public void testTranslateMultiple() {
    TranslateOptions options = new TranslateOptions.Builder(texts)
        .modelId(ENGLISH_TO_SPANISH).build();
    TranslationResult results = service.translate(options).execute();
    assertEquals(2, results.getTranslations().size());
    assertEquals(translations.get(texts.get(0)), results.getTranslations().get(0).getTranslation());
    assertEquals(translations.get(texts.get(1)), results.getTranslations().get(1).getTranslation());

    TranslateOptions.Builder builder = new TranslateOptions.Builder();
    builder.source(Language.ENGLISH).target(Language.SPANISH);
    for (String text : texts) {
      builder.addText(text);
    }
    results = service.translate(builder.build()).execute();
    assertEquals(2, results.getTranslations().size());
    assertEquals(translations.get(texts.get(0)), results.getTranslations().get(0).getTranslation());
    assertEquals(translations.get(texts.get(1)), results.getTranslations().get(1).getTranslation());
  }

  /**
   * Test delete all models.
   */
  @Test
  @Ignore
  public void testDeleteAllModels() {
    List<TranslationModel> models = service.listModels(null).execute().getModels();
    for (TranslationModel translationModel : models) {
      DeleteModelOptions options = new DeleteModelOptions.Builder(translationModel.getModelId()).build();
      service.deleteModel(options).execute();
    }
  }

  /**
   * Test translation result.
   *
   * @param text the text
   * @param result the result
   * @param translationResult the translation result
   */
  private void testTranslationResult(String text, String result, TranslationResult translationResult) {
    assertNotNull(translationResult);
    assertEquals(translationResult.getCharacterCount().intValue(), text.length());
    assertEquals(translationResult.getWordCount().intValue(), text.split(" ").length);
    assertNotNull(translationResult.getTranslations());
    assertNotNull(translationResult.getTranslations().get(0).getTranslation());
    assertEquals(result, translationResult.getTranslations().get(0).getTranslation());
  }

}

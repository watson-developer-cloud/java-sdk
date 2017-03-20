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
package com.ibm.watson.developer_cloud.language_translation.v2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.language_translation.v2.model.CreateModelOptions;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiableLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.Language;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationModel;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;

/**
 * Language Translation integration test.
 */
public class LanguageTranslationIT extends WatsonServiceTest {

  private static final String ENGLISH_TO_SPANISH = "en-es";
  private static final String RESOURCE = "src/test/resources/language_translation/";

  private LanguageTranslation service;

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
    String username = getProperty("language_translation.username");
    String password = getProperty("language_translation.password");

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    service = new LanguageTranslation();
    service.setUsernameAndPassword(username, password);
    service.setEndPoint(getProperty("language_translation.url"));
    service.setDefaultHeaders(getDefaultHeaders());
  }

  /**
   * Test create and delete model.
   */
  @Test
  public void testCreateAndDeleteModel() {
    CreateModelOptions options = new CreateModelOptions.Builder().name("integration-test").baseModelId("en-es")
        .forcedGlossary(new File(RESOURCE + "glossary.tmx")).build();

    TranslationModel model = null;
    try {
      model = service.createModel(options).execute();
      Thread.sleep(3000);
      assertNotNull(model);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      if (model != null) {
        service.deleteModel(model.getId()).execute();
      }
    }
  }

  /**
   * Test Get Identifiable languages.
   */
  @Test
  public void testGetIdentifiableLanguages() {
    final List<IdentifiableLanguage> languages = service.getIdentifiableLanguages().execute();
    assertNotNull(languages);
    assertTrue(!languages.isEmpty());
  }

  /**
   * Test Get model by id.
   */
  @Test
  public void testGetModel() {
    final TranslationModel model = service.getModel(ENGLISH_TO_SPANISH).execute();
    assertNotNull(model);
  }

  /**
   * Test Get Models.
   */
  @Test
  public void testGetModels() {
    final List<TranslationModel> models = service.getModels().execute();

    assertNotNull(models);
    assertFalse(models.isEmpty());
  }

  /**
   * Test Identify.
   */
  @Test
  public void testIdentify() {
    final List<IdentifiedLanguage> identifiedLanguages = service.identify(texts.get(0)).execute();
    assertNotNull(identifiedLanguages);
    assertFalse(identifiedLanguages.isEmpty());
  }

  /**
   * Test translate.
   */
  @Test
  public void testTranslate() {
    for (String text : texts) {
      testTranslationResult(text, translations.get(text), service.translate(text, ENGLISH_TO_SPANISH).execute());
      testTranslationResult(text, translations.get(text),
          service.translate(text, Language.ENGLISH, Language.SPANISH).execute());
    }
  }

  /**
   * Test translate multiple.
   */
  @Test
  public void testTranslateMultiple() {
    TranslationResult results = service.translate(texts, ENGLISH_TO_SPANISH).execute();
    assertEquals(2, results.getTranslations().size());
    assertEquals(translations.get(texts.get(0)), results.getTranslations().get(0).getTranslation());
    assertEquals(translations.get(texts.get(1)), results.getTranslations().get(1).getTranslation());

    results = service.translate(texts, Language.ENGLISH, Language.SPANISH).execute();
    assertEquals(2, results.getTranslations().size());
    assertEquals(translations.get(texts.get(0)), results.getTranslations().get(0).getTranslation());
    assertEquals(translations.get(texts.get(1)), results.getTranslations().get(1).getTranslation());

  }

  @Test
  @Ignore
  public void testDeleteAllModels() {
    List<TranslationModel> models = service.getModels().execute();
    for (TranslationModel translationModel : models) {
      service.deleteModel(translationModel.getId()).execute();
    }
  }

  private void testTranslationResult(String text, String result, TranslationResult translationResult) {
    assertNotNull(translationResult);
    assertEquals(translationResult.getWordCount().intValue(), text.split(" ").length);
    assertNotNull(translationResult.getTranslations());
    assertNotNull(translationResult.getTranslations().get(0).getTranslation());
    assertEquals(result, translationResult.getTranslations().get(0).getTranslation());
  }

}

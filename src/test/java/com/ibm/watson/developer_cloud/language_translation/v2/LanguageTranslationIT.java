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
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.language_translation.v2.model.CreateModelOptions;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiableLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationModel;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;

/**
 * Language Translation integration test.
 */
public class LanguageTranslationIT extends WatsonServiceTest {

  private static final String SPANISH = "es";
  private static final String ENGLISH = "en";
  private static final String ENGLISH_TO_SPANISH = "en-es";
  private static final String RESOURCE = "src/test/resources/language_translation/";

  private LanguageTranslation service;
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
    text = "The IBM Watson team is awesome";
    service = new LanguageTranslation();
    service.setUsernameAndPassword(getValidProperty("language_translation.username"),
        getValidProperty("language_translation.password"));
    service.setEndPoint(getValidProperty("language_translation.url"));
    service.setDefaultHeaders(getDefaultHeaders());
  }

  /**
   * Test create and delete model
   */
  @Test
  public void testCreateAndDeleteModel() {
    CreateModelOptions options = new CreateModelOptions("integration-test", "en-es");
    options.forcedGlossary(new File(RESOURCE + "glossary.tmx"));

    TranslationModel model = null;
    try {
      model = service.createModel(options);
      Thread.sleep(3000);
      assertNotNull(model);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      if (model != null)
        service.deleteModel(model.getId());
    }
  }

  /**
   * Test Get Identifiable languages.
   */
  @Test
  public void testGetIdentifiableLanguages() {
    final List<IdentifiableLanguage> languages = service.getIdentifiableLanguages();
    assertNotNull(languages);
    assertTrue(!languages.isEmpty());
  }

  /**
   * Test Get model by id.
   */
  @Test
  public void testGetModel() {
    final TranslationModel model = service.getModel(ENGLISH_TO_SPANISH);
    assertNotNull(model);
  }

  /**
   * Test Get Models.
   */
  @Test
  public void testGetModels() {
    final List<TranslationModel> models = service.getModels();

    assertNotNull(models);
    assertFalse(models.isEmpty());
  }

  /**
   * Test Identify.
   */
  @Test
  public void testIdentify() {
    final List<IdentifiedLanguage> identifiedLanguages = service.identify(text);
    assertNotNull(identifiedLanguages);
    assertFalse(identifiedLanguages.isEmpty());
  }

  /**
   * Test translate.
   */
  @Test
  public void testTranslate() {
    final String result = "El equipo es increíble IBM Watson";
    testTranslationResult(text, result, service.translate(text, ENGLISH_TO_SPANISH));
    testTranslationResult(text, result, service.translate(text, ENGLISH, SPANISH));
  }

  private void testTranslationResult(String text, String result, TranslationResult translationResult) {
    assertNotNull(translationResult);
    assertEquals(translationResult.getWordCount(), text.split(" ").length);
    assertNotNull(translationResult.getTranslations());
    assertNotNull(translationResult.getTranslations().get(0).getTranslation());
    assertEquals(result, translationResult.getTranslations().get(0).getTranslation());
  }

}

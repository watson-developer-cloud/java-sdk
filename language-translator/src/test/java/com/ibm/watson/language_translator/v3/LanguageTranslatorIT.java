/*
 * (C) Copyright IBM Corp. 2019, 2023.
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
package com.ibm.watson.language_translator.v3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.TooManyRequestsException;
import com.ibm.watson.common.WatsonHttpHeaders;
import com.ibm.watson.common.WatsonServiceTest;
import com.ibm.watson.language_translator.v3.model.*;
import com.ibm.watson.language_translator.v3.util.Language;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/** Language Translator integration test. */
public class LanguageTranslatorIT extends WatsonServiceTest {

  private static final String ENGLISH_TO_SPANISH = "en-es";

  private LanguageTranslator service;

  private final Map<String, String> translations =
      new HashMap<String, String>() {
        {
          put("The IBM Watson team is awesome", "El equipo de IBM Watson es impresionante");
          put("Welcome to the cognitive era", "Bienvenido a la era cognitiva");
        }
      };
  private final List<String> texts = new ArrayList<>(translations.keySet());

  /**
   * Sets up the tests.
   *
   * @throws Exception the exception
   */
  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developercloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String iamApiKey = System.getenv("LANGUAGE_TRANSLATOR_APIKEY");
    String serviceUrl = System.getenv("LANGUAGE_TRANSLATOR_URL");

    if (iamApiKey == null) {
      iamApiKey = getProperty("language_translator.apikey");
      serviceUrl = getProperty("language_translator.url");
    }

    assertNotNull(
        "LANGUAGE_TRANSLATOR_APIKEY is not defined and config.properties doesn't have valid credentials.",
        iamApiKey);

    Authenticator authenticator = new IamAuthenticator(iamApiKey);
    service = new LanguageTranslator("2018-05-01", authenticator);
    service.setServiceUrl(serviceUrl);

    // issue currently where document translation fails with learning opt-out
    Map<String, String> headers = new HashMap<>();
    headers.put(WatsonHttpHeaders.X_WATSON_TEST, "1");
    service.setDefaultHeaders(headers);
  }

  /**
   * Test README.
   *
   * @throws InterruptedException the interrupted exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testReadme() throws InterruptedException, IOException {
    TranslateOptions translateOptions =
        new TranslateOptions.Builder()
            .addText("hello")
            .source(Language.ENGLISH)
            .target(Language.SPANISH)
            .build();
    Response<TranslationResult> translationResult = service.translate(translateOptions).execute();

    System.out.println(translationResult);
  }

  /** Test Get Identifiable languages. */
  @Test
  public void testGetIdentifiableLanguages() {
    List<IdentifiableLanguage> languages =
        service.listIdentifiableLanguages().execute().getResult().getLanguages();
    assertNotNull(languages);
    assertTrue(!languages.isEmpty());
  }

  /** Test Get model by id. */
  @Test
  public void testGetModel() {
    GetModelOptions getOptions = new GetModelOptions.Builder(ENGLISH_TO_SPANISH).build();
    try {
      final Response<TranslationModel> model = service.getModel(getOptions).execute();
      assertNotNull(model);
    } catch (TooManyRequestsException e) {
      // The service seems to have a very strict rate limit. Failing this way is okay.
    }
  }

  /** Test List Models. */
  @Test
  public void testListModels() {
    try {
      List<TranslationModel> models = service.listModels(null).execute().getResult().getModels();

      assertNotNull(models);
      assertFalse(models.isEmpty());
    } catch (TooManyRequestsException e) {
      // The service seems to have a very strict rate limit. Failing this way is okay.
    }
  }

  /** Test List Models with Options. */
  @Test
  public void testListModelsWithOptions() {
    try {
      ListModelsOptions options =
          new ListModelsOptions.Builder().source("en").target("es").xDefault(true).build();
      List<TranslationModel> models = service.listModels(options).execute().getResult().getModels();

      assertNotNull(models);
      assertFalse(models.isEmpty());
      assertEquals(models.get(0).getSource(), options.source());
      assertEquals(models.get(0).getTarget(), options.target());
    } catch (TooManyRequestsException e) {
      // The service seems to have a very strict rate limit. Failing this way is okay.
    }
  }

  /** Test Identify. */
  @Test
  public void testIdentify() {

    IdentifyOptions options = new IdentifyOptions.Builder(texts.get(0)).build();
    List<IdentifiedLanguage> identifiedLanguages =
        service.identify(options).execute().getResult().getLanguages();
    assertNotNull(identifiedLanguages);
    assertFalse(identifiedLanguages.isEmpty());
  }

  /** Test translate. */
  @Test
  public void testTranslate() {
    for (String text : texts) {
      TranslateOptions options =
          new TranslateOptions.Builder().addText(text).modelId(ENGLISH_TO_SPANISH).build();
      testTranslationResult(
          text, translations.get(text), service.translate(options).execute().getResult());
      TranslateOptions options1 =
          new TranslateOptions.Builder()
              .addText(text)
              .source(Language.ENGLISH)
              .target(Language.SPANISH)
              .build();
      testTranslationResult(
          text, translations.get(text), service.translate(options1).execute().getResult());
    }
  }

  /** Test translate multiple. */
  @Test
  public void testTranslateMultiple() {
    TranslateOptions options =
        new TranslateOptions.Builder(texts).modelId(ENGLISH_TO_SPANISH).build();
    TranslationResult results = service.translate(options).execute().getResult();
    assertEquals(2, results.getTranslations().size());
    assertEquals(translations.get(texts.get(0)), results.getTranslations().get(0).getTranslation());
    assertEquals(translations.get(texts.get(1)), results.getTranslations().get(1).getTranslation());

    TranslateOptions.Builder builder = new TranslateOptions.Builder();
    builder.source(Language.ENGLISH).target(Language.SPANISH);
    for (String text : texts) {
      builder.addText(text);
    }
    results = service.translate(builder.build()).execute().getResult();
    assertEquals(2, results.getTranslations().size());
    assertEquals(translations.get(texts.get(0)), results.getTranslations().get(0).getTranslation());
    assertEquals(translations.get(texts.get(1)), results.getTranslations().get(1).getTranslation());
  }

  /** Test delete all models. */
  @Test
  @Ignore
  public void testDeleteAllModels() {
    List<TranslationModel> models = service.listModels(null).execute().getResult().getModels();
    for (TranslationModel translationModel : models) {
      DeleteModelOptions options =
          new DeleteModelOptions.Builder(translationModel.getModelId()).build();
      service.deleteModel(options).execute();
    }
  }

  /**
   * Test document translation.
   *
   * @throws FileNotFoundException the file not found exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDocumentTranslation() throws FileNotFoundException, InterruptedException {
    DocumentList listResponse = service.listDocuments().execute().getResult();
    int originalDocumentCount = listResponse.getDocuments().size();

    TranslateDocumentOptions translateOptions =
        new TranslateDocumentOptions.Builder()
            .file(new File("src/test/resources/language_translation/document_to_translate.txt"))
            .fileContentType(HttpMediaType.TEXT_PLAIN)
            .source("en")
            .target("es")
            .build();
    DocumentStatus translateResponse =
        service.translateDocument(translateOptions).execute().getResult();
    String documentId = translateResponse.getDocumentId();

    try {
      GetDocumentStatusOptions getOptions =
          new GetDocumentStatusOptions.Builder().documentId(documentId).build();
      DocumentStatus getResponse = service.getDocumentStatus(getOptions).execute().getResult();
      while (!getResponse.getStatus().equals(DocumentStatus.Status.AVAILABLE)) {
        Thread.sleep(3000);
        getResponse = service.getDocumentStatus(getOptions).execute().getResult();
      }

      GetTranslatedDocumentOptions getTranslatedDocumentOptions =
          new GetTranslatedDocumentOptions.Builder()
              .documentId(documentId)
              .accept(HttpMediaType.TEXT_PLAIN)
              .build();
      InputStream getTranslatedDocumentResponse =
          service.getTranslatedDocument(getTranslatedDocumentOptions).execute().getResult();
      assertNotNull(getTranslatedDocumentResponse);

      listResponse = service.listDocuments().execute().getResult();
      assertTrue(listResponse.getDocuments().size() > originalDocumentCount);
    } finally {
      DeleteDocumentOptions deleteOptions =
          new DeleteDocumentOptions.Builder().documentId(documentId).build();
      service.deleteDocument(deleteOptions).execute().getResult();
    }
  }

  /**
   * Test translation result.
   *
   * @param text the text
   * @param result the result
   * @param translationResult the translation result
   */
  private void testTranslationResult(
      String text, String result, TranslationResult translationResult) {
    assertNotNull(translationResult);
    assertEquals(translationResult.getCharacterCount().intValue(), text.length());
    assertEquals(translationResult.getWordCount().intValue(), text.split(" ").length);
    assertNotNull(translationResult.getTranslations());
    assertNotNull(translationResult.getTranslations().get(0).getTranslation());
    assertEquals(result, translationResult.getTranslations().get(0).getTranslation());
  }

  /** Test List Languages. */
  @Test
  public void testListLanguages_Success() {
    ListLanguagesOptions listLanguagesOptions = new ListLanguagesOptions();
    Languages response = service.listLanguages(listLanguagesOptions).execute().getResult();

    assertNotNull(response);
    assertNotNull(response.getLanguages());
    assertTrue(response.getLanguages().size() > 0);
  }
}

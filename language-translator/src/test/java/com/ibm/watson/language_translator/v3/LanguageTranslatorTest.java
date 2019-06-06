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
package com.ibm.watson.language_translator.v3;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.security.basicauth.BasicAuthConfig;
import com.ibm.cloud.sdk.core.service.exception.BadRequestException;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.watson.common.WatsonServiceUnitTest;
import com.ibm.watson.language_translator.v3.model.CreateModelOptions;
import com.ibm.watson.language_translator.v3.model.DeleteDocumentOptions;
import com.ibm.watson.language_translator.v3.model.DocumentList;
import com.ibm.watson.language_translator.v3.model.DocumentStatus;
import com.ibm.watson.language_translator.v3.model.GetDocumentStatusOptions;
import com.ibm.watson.language_translator.v3.model.GetModelOptions;
import com.ibm.watson.language_translator.v3.model.GetTranslatedDocumentOptions;
import com.ibm.watson.language_translator.v3.model.IdentifiableLanguage;
import com.ibm.watson.language_translator.v3.model.IdentifiedLanguage;
import com.ibm.watson.language_translator.v3.model.IdentifiedLanguages;
import com.ibm.watson.language_translator.v3.model.IdentifyOptions;
import com.ibm.watson.language_translator.v3.model.ListDocumentsOptions;
import com.ibm.watson.language_translator.v3.model.ListModelsOptions;
import com.ibm.watson.language_translator.v3.model.TranslateDocumentOptions;
import com.ibm.watson.language_translator.v3.model.TranslateOptions;
import com.ibm.watson.language_translator.v3.model.TranslationModel;
import com.ibm.watson.language_translator.v3.model.TranslationModels;
import com.ibm.watson.language_translator.v3.model.TranslationResult;
import com.ibm.watson.language_translator.v3.util.Language;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Language Translator v3 Unit tests.
 */
public class LanguageTranslatorTest extends WatsonServiceUnitTest {

  private static final String GET_MODELS_PATH = "/v3/models";
  private static final String IDENTIFIABLE_LANGUAGES_PATH = "/v3/identifiable_languages";
  private static final String IDENTITY_PATH = "/v3/identify";
  private static final String LANGUAGE_TRANSLATION_PATH = "/v3/translate";
  private static final String VERSION_PARAM = "?version=2018-05-01";
  private static final String RESOURCE = "src/test/resources/language_translation/";
  private static final Type TYPE_IDENTIFIED_LANGUAGES = new TypeToken<Map<String, List<IdentifiableLanguage>>>() {
  }.getType();
  private static final Gson GSON = GsonSingleton.getGsonWithoutPrettyPrinting();
  private final String modelId = "foo-bar";
  private LanguageTranslator service;

  private final Map<String, String> translations = ImmutableMap.of("The IBM Watson team is awesome",
      "El equipo es increíble IBM Watson", "Welcome to the cognitive era", "Bienvenido a la era cognitiva");
  private final List<String> texts = ImmutableList.copyOf(translations.keySet());

  private TranslationModel model;
  private TranslationModels models;
  private IdentifiedLanguages identifiedLanguages;
  private TranslationResult singleTranslation;
  private TranslationResult multipleTranslations;
  private Map<String, Object> identifiableLanguages;
  private DocumentList documentList;
  private DocumentStatus documentStatus;
  private File translatedDocument;

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developercloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    BasicAuthConfig authConfig = new BasicAuthConfig.Builder()
        .username("")
        .password("")
        .build();
    service = new LanguageTranslator("2018-05-01", authConfig);
    service.setEndPoint(getMockWebServerUrl());

    // fixtures
    String jsonString = getStringFromInputStream(new FileInputStream(RESOURCE + "identifiable_languages.json"));
    identifiableLanguages = GSON.fromJson(jsonString, TYPE_IDENTIFIED_LANGUAGES);

    model = loadFixture(RESOURCE + "model.json", TranslationModel.class);
    models = loadFixture(RESOURCE + "models.json", TranslationModels.class);
    identifiedLanguages = loadFixture(RESOURCE + "identify_response.json", IdentifiedLanguages.class);
    singleTranslation = loadFixture(RESOURCE + "single_translation.json", TranslationResult.class);
    multipleTranslations = loadFixture(RESOURCE + "multiple_translations.json", TranslationResult.class);
    documentList = loadFixture(RESOURCE + "list_documents_response.json", DocumentList.class);
    documentStatus = loadFixture(RESOURCE + "document_status.json", DocumentStatus.class);
    translatedDocument = new File(RESOURCE + "translated_document.txt");
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

    List<IdentifiableLanguage> languages = service.listIdentifiableLanguages().execute().getResult().getLanguages();
    RecordedRequest request = server.takeRequest();

    assertEquals(IDENTIFIABLE_LANGUAGES_PATH + VERSION_PARAM, request.getPath());
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
    TranslationModel returnedModel = service.getModel(getOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET_MODELS_PATH + "/" + model.getModelId() + VERSION_PARAM, request.getPath());
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
    List<TranslationModel> modelList = service.listModels(options).execute().getResult().getModels();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET_MODELS_PATH + VERSION_PARAM, request.getPath());
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
    server.enqueue(jsonResponse(identifiedLanguages));

    final String text = texts.get(0);
    IdentifyOptions identifyOptions = new IdentifyOptions.Builder(text).build();
    List<IdentifiedLanguage> identifiedLanguages
        = service.identify(identifyOptions).execute().getResult().getLanguages();
    RecordedRequest request = server.takeRequest();

    assertEquals(IDENTITY_PATH + VERSION_PARAM, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(text, request.getBody().readUtf8());
    assertNotNull(identifiedLanguages);
    assertFalse(identifiedLanguages.isEmpty());
    assertEquals(identifiedLanguages.get(0).getLanguage(), Language.ENGLISH);
    assertEquals(identifiedLanguages.get(0).getConfidence(), 0.877159, 0.05);
    assertEquals(identifiedLanguages.get(1).getLanguage(), Language.AFRIKAANS);
    assertEquals(identifiedLanguages.get(1).getConfidence(), 0.0752636, 0.05);

  }

  /**
   * Test translate.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testTranslate() throws InterruptedException {
    server.enqueue(jsonResponse(singleTranslation));

    final String text = texts.get(0);
    final Map<String, ?> requestBody = ImmutableMap.of("text", Collections.singleton(text), "model_id", modelId);

    TranslateOptions translateOptions = new TranslateOptions.Builder().addText(text).modelId(modelId).build();
    TranslationResult translationResult = service.translate(translateOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(LANGUAGE_TRANSLATION_PATH + VERSION_PARAM, request.getPath());
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
    server.enqueue(jsonResponse(multipleTranslations));

    final Map<String, ?> requestBody = ImmutableMap.of("text", texts, "model_id", modelId);

    TranslateOptions translateOptions = new TranslateOptions.Builder()
        .text(texts)
        .modelId(modelId)
        .build();
    TranslationResult translationResult = service.translate(translateOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(LANGUAGE_TRANSLATION_PATH + VERSION_PARAM, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(GSON.toJson(requestBody), request.getBody().readUtf8());
    assertEquals(2, translationResult.getTranslations().size());
    assertEquals(translations.get(texts.get(0)), translationResult.getTranslations().get(0).getTranslationOutput());
    assertEquals(translations.get(texts.get(1)), translationResult.getTranslations().get(1).getTranslationOutput());
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
    assertNotNull(translationResult.getTranslations().get(0).getTranslationOutput());
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

    CreateModelOptions options1 = new CreateModelOptions.Builder(modelId)
        .parallelCorpus(parallelCorpusStream)
        .build();
    CreateModelOptions.Builder builder = options1.newBuilder();
    CreateModelOptions options2 = builder.name("baz").build();
    assertEquals(options2.baseModelId(), modelId);
    assertEquals(options2.parallelCorpus(), parallelCorpusStream);
    assertEquals(options2.name(), "baz");
  }

  @Test
  public void testListDocumentsOptions() {
    ListDocumentsOptions options = new ListDocumentsOptions.Builder()
        .build();
    options = options.newBuilder().build();
  }

  @Test
  public void testListDocuments() throws InterruptedException {
    server.enqueue(jsonResponse(documentList));
    ListDocumentsOptions options = new ListDocumentsOptions.Builder().build();
    DocumentList response = service.listDocuments(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET, request.getMethod());
    assertEquals(documentList.getDocuments().get(0).getDocumentId(), response.getDocuments().get(0).getDocumentId());
    assertEquals(documentList.getDocuments().get(0).getBaseModelId(), response.getDocuments().get(0).getBaseModelId());
    assertEquals(documentList.getDocuments().get(0)
        .getCharacterCount(),response.getDocuments().get(0).getCharacterCount());
    assertEquals(documentList.getDocuments().get(0).getCompleted(), response.getDocuments().get(0).getCompleted());
    assertEquals(documentList.getDocuments().get(0).getCreated(), response.getDocuments().get(0).getCreated());
    assertEquals(documentList.getDocuments().get(0).getFilename(), response.getDocuments().get(0).getFilename());
    assertEquals(documentList.getDocuments().get(0).getModelId(), response.getDocuments().get(0).getModelId());
    assertEquals(documentList.getDocuments().get(0).getSource(), response.getDocuments().get(0).getSource());
    assertEquals(documentList.getDocuments().get(0).getStatus(), response.getDocuments().get(0).getStatus());
    assertEquals(documentList.getDocuments().get(0).getTarget(), response.getDocuments().get(0).getTarget());
    assertEquals(documentList.getDocuments().get(0).getWordCount(), response.getDocuments().get(0).getWordCount());
  }

  @Test
  public void testListDocumentsNoOptions() throws InterruptedException {
    server.enqueue(jsonResponse(documentList));
    DocumentList response = service.listDocuments().execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET, request.getMethod());
    assertEquals(documentList.getDocuments().get(0).getDocumentId(), response.getDocuments().get(0).getDocumentId());
    assertEquals(documentList.getDocuments().get(0).getBaseModelId(), response.getDocuments().get(0).getBaseModelId());
    assertEquals(documentList.getDocuments().get(0)
        .getCharacterCount(),response.getDocuments().get(0).getCharacterCount());
    assertEquals(documentList.getDocuments().get(0).getCompleted(), response.getDocuments().get(0).getCompleted());
    assertEquals(documentList.getDocuments().get(0).getCreated(), response.getDocuments().get(0).getCreated());
    assertEquals(documentList.getDocuments().get(0).getFilename(), response.getDocuments().get(0).getFilename());
    assertEquals(documentList.getDocuments().get(0).getModelId(), response.getDocuments().get(0).getModelId());
    assertEquals(documentList.getDocuments().get(0).getSource(), response.getDocuments().get(0).getSource());
    assertEquals(documentList.getDocuments().get(0).getStatus(), response.getDocuments().get(0).getStatus());
    assertEquals(documentList.getDocuments().get(0).getTarget(), response.getDocuments().get(0).getTarget());
    assertEquals(documentList.getDocuments().get(0).getWordCount(), response.getDocuments().get(0).getWordCount());
  }

  @Test
  public void testTranslateDocumentOptions() throws FileNotFoundException {
    File file = new File(RESOURCE + "document_to_translate.txt");
    String fileContentType = HttpMediaType.TEXT_PLAIN;
    String filename = "filename";
    String modelId = "modelId";
    String source = "en";
    String target = "es";
    String documentId = "documentId";

    TranslateDocumentOptions options = new TranslateDocumentOptions.Builder()
        .file(file)
        .fileContentType(fileContentType)
        .filename(filename)
        .modelId(modelId)
        .source(source)
        .target(target)
        .documentId(documentId)
        .build();
    options = options.newBuilder().build();

    assertNotNull(options.file());
    assertEquals(fileContentType, options.fileContentType());
    assertEquals(filename, options.filename());
    assertEquals(modelId, options.modelId());
    assertEquals(source, options.source());
    assertEquals(target, options.target());
    assertEquals(documentId, options.documentId());
  }

  @Test
  public void testTranslateDocument() throws FileNotFoundException, InterruptedException {
    server.enqueue(jsonResponse(documentStatus));
    File file = new File(RESOURCE + "document_to_translate.txt");
    TranslateDocumentOptions options = new TranslateDocumentOptions.Builder()
        .file(file)
        .build();
    DocumentStatus response = service.translateDocument(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(POST, request.getMethod());
    assertEquals(documentStatus.getWordCount(), response.getWordCount());
    assertEquals(documentStatus.getTarget(), response.getTarget());
    assertEquals(documentStatus.getStatus(), response.getStatus());
    assertEquals(documentStatus.getSource(), response.getSource());
    assertEquals(documentStatus.getModelId(), response.getModelId());
    assertEquals(documentStatus.getFilename(), response.getFilename());
    assertEquals(documentStatus.getCreated(), response.getCreated());
    assertEquals(documentStatus.getCompleted(), response.getCompleted());
    assertEquals(documentStatus.getCharacterCount(), response.getCharacterCount());
    assertEquals(documentStatus.getBaseModelId(), response.getBaseModelId());
    assertEquals(documentStatus.getDocumentId(), response.getDocumentId());
  }

  @Test
  public void testGetDocumentStatusOptions() {
    String documentId = "documentId";

    GetDocumentStatusOptions options = new GetDocumentStatusOptions.Builder()
        .documentId(documentId)
        .build();
    options = options.newBuilder().build();

    assertEquals(documentId, options.documentId());
  }

  @Test
  public void testGetDocumentStatus() throws InterruptedException {
    server.enqueue(jsonResponse(documentStatus));
    GetDocumentStatusOptions options = new GetDocumentStatusOptions.Builder()
        .documentId("documentId")
        .build();
    DocumentStatus response = service.getDocumentStatus(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET, request.getMethod());
    assertEquals(documentStatus.getWordCount(), response.getWordCount());
    assertEquals(documentStatus.getTarget(), response.getTarget());
    assertEquals(documentStatus.getStatus(), response.getStatus());
    assertEquals(documentStatus.getSource(), response.getSource());
    assertEquals(documentStatus.getModelId(), response.getModelId());
    assertEquals(documentStatus.getFilename(), response.getFilename());
    assertEquals(documentStatus.getCreated(), response.getCreated());
    assertEquals(documentStatus.getCompleted(), response.getCompleted());
    assertEquals(documentStatus.getCharacterCount(), response.getCharacterCount());
    assertEquals(documentStatus.getBaseModelId(), response.getBaseModelId());
    assertEquals(documentStatus.getDocumentId(), response.getDocumentId());
  }

  @Test
  public void testDeleteDocumentOptions() {
    String documentId = "documentId";

    DeleteDocumentOptions options = new DeleteDocumentOptions.Builder()
        .documentId(documentId)
        .build();
    options = options.newBuilder().build();

    assertEquals(documentId, options.documentId());
  }

  @Test
  public void testDeleteDocument() throws InterruptedException {
    server.enqueue(new MockResponse().setResponseCode(200));
    DeleteDocumentOptions options = new DeleteDocumentOptions.Builder()
        .documentId("documentId")
        .build();
    service.deleteDocument(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(DELETE, request.getMethod());
  }

  @Test
  public void testGetTranslatedDocumentOptions() {
    String documentId = "documentId";
    String accept = GetTranslatedDocumentOptions.Accept.APPLICATION_JSON;

    GetTranslatedDocumentOptions options = new GetTranslatedDocumentOptions.Builder()
        .accept(accept)
        .documentId(documentId)
        .build();
    options = options.newBuilder().build();

    assertEquals(documentId, options.documentId());
    assertEquals(accept, options.accept());
  }

  @Test
  public void testGetTranslatedDocument() throws IOException, InterruptedException {
    Buffer buffer = new Buffer().write(Files.toByteArray(translatedDocument));
    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.TEXT_PLAIN).setBody(buffer));

    GetTranslatedDocumentOptions options = new GetTranslatedDocumentOptions.Builder()
        .documentId("documentId")
        .accept("")
        .build();
    InputStream response = service.getTranslatedDocument(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET, request.getMethod());
    assertNotNull(response);
  }
}

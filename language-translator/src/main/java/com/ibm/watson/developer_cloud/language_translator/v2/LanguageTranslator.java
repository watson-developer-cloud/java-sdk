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

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.language_translator.v2.model.CreateModelOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.IdentifiableLanguage;
import com.ibm.watson.developer_cloud.language_translator.v2.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.language_translator.v2.model.Language;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationModel;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * The IBM Watson Language Translator service translate text from one language to another and identifies the language in
 * which text is written.
 *
 * @version v2
 * @see <a href= "http://www.ibm.com/watson/developercloud/language-translator.html"> Language translator</a>
 */
public class LanguageTranslator extends WatsonService {

  private static final String LANGUAGES = "languages";
  private static final String MODELS = "models";
  private static final String SERVICE_NAME = "language_translator";
  private static final String PATH_IDENTIFY = "/v2/identify";
  private static final String PATH_TRANSLATE = "/v2/translate";
  private static final String PATH_IDENTIFIABLE_LANGUAGES = "/v2/identifiable_languages";
  private static final String PATH_MODELS = "/v2/models";
  private static final String BASE_MODEL_ID = "base_model_id";
  private static final String DEFAULT = "default";
  private static final String FORCED_GLOSSARY = "forced_glossary";
  private static final String MODEL_ID = "model_id";
  private static final String MONOLINGUAL_CORPUS = "monolingual_corpus";
  private static final String NAME = "name";
  private static final String PARALLEL_CORPUS = "parallel_corpus";
  private static final String SOURCE = "source";
  private static final String TARGET = "target";
  private static final String TEXT = "text";
  private static final String URL = "https://gateway.watsonplatform.net/language-translator/api";
  private static final String PATH_MODEL = "/v2/models/%s";
  private static final Type TYPE_LIST_TRANSLATION_MODEL = new TypeToken<List<TranslationModel>>() { }.getType();
  private static final Type TYPE_LIST_IDENTIFIABLE_LANGUAGE = new TypeToken<List<IdentifiableLanguage>>() { }.getType();
  private static final Type TYPE_LIST_IDENTIFIED_LANGUAGE = new TypeToken<List<IdentifiedLanguage>>() { }.getType();

  /**
   * Instantiates a new Language Translator service.
   */
  public LanguageTranslator() {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }
  }

  /**
   * Instantiates a new language translator service by username and password.
   *
   * @param username the username
   * @param password the password
   */
  public LanguageTranslator(String username, String password) {
    this();
    setUsernameAndPassword(username, password);
  }

  /**
   * Creates a translation model.
   *
   * @param options the create model options
   * @return the translation model
   */
  public ServiceCall<TranslationModel> createModel(CreateModelOptions options) {
    Validator.notNull(options, "options cannot be null");
    Validator.notEmpty(options.baseModelId(), "options.baseModelId cannot be null or empty");

    final RequestBuilder requestBuilder = RequestBuilder.post(PATH_MODELS);
    requestBuilder.query(BASE_MODEL_ID, options.baseModelId());

    if (options.name() != null) {
      requestBuilder.query(NAME, options.name());
    }

    final MultipartBody.Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);

    // either forced glossary, monolingual corpus or parallel corpus should be specified
    if (options.forcedGlossary() != null) {
      bodyBuilder.addFormDataPart(FORCED_GLOSSARY, options.forcedGlossary().getName(),
          RequestBody.create(HttpMediaType.BINARY_FILE, options.forcedGlossary()));
    }
    if (options.monolingualCorpus() != null) {
      bodyBuilder.addFormDataPart(MONOLINGUAL_CORPUS, options.monolingualCorpus().getName(),
          RequestBody.create(HttpMediaType.BINARY_FILE, options.monolingualCorpus()));
    }
    if (options.parallelCorpus() != null) {
      bodyBuilder.addFormDataPart(PARALLEL_CORPUS, options.parallelCorpus().getName(),
          RequestBody.create(HttpMediaType.BINARY_FILE, options.parallelCorpus()));
    }

    return createServiceCall(requestBuilder.body(bodyBuilder.build()).build(),
        ResponseConverterUtils.getObject(TranslationModel.class));
  }

  /**
   * Deletes a translation model.
   *
   * @param modelId the model identifier
   * @return the service call
   */
  public ServiceCall<Void> deleteModel(String modelId) {
    if ((modelId == null) || modelId.isEmpty()) {
      throw new IllegalArgumentException("modelId cannot be null or empty");
    }

    Request request = RequestBuilder.delete(String.format(PATH_MODEL, modelId)).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }

  /**
   * Gets the The identifiable languages.
   *
   * @return the identifiable languages
   * @see TranslationModel See {@link IdentifiableLanguage}
   */
  public ServiceCall<List<IdentifiableLanguage>> getIdentifiableLanguages() {
    final RequestBuilder requestBuilder = RequestBuilder.get(PATH_IDENTIFIABLE_LANGUAGES);

    ResponseConverter<List<IdentifiableLanguage>> converter =
        ResponseConverterUtils.getGenericObject(TYPE_LIST_IDENTIFIABLE_LANGUAGE, LANGUAGES);

    return createServiceCall(requestBuilder.build(), converter);

  }

  /**
   * Gets a translation model.
   *
   * @param modelId the model identifier
   * @return the translation model
   * @see TranslationModel
   */
  public ServiceCall<TranslationModel> getModel(String modelId) {
    Validator.isTrue((modelId != null) && !modelId.isEmpty(), "modelId cannot be null or empty");
    Request request = RequestBuilder.get(String.format(PATH_MODEL, modelId)).build();
    return createServiceCall(request, ResponseConverterUtils.getObject(TranslationModel.class));
  }

  /**
   * Gets the translation model.
   *
   * @return the translation model
   * @see TranslationModel
   */
  public ServiceCall<List<TranslationModel>> getModels() {
    return getModels(null, null, null);
  }

  /**
   * Retrieves the list of model.
   *
   * @param showDefault show default model
   * @param source the source
   * @param target the target
   * @return the translation model
   * @see TranslationModel
   */
  public ServiceCall<List<TranslationModel>> getModels(final Boolean showDefault, final String source,
      final String target) {
    final RequestBuilder requestBuilder = RequestBuilder.get(PATH_MODELS);

    if ((source != null) && !source.isEmpty()) {
      requestBuilder.query(SOURCE, source);
    }

    if ((target != null) && !target.isEmpty()) {
      requestBuilder.query(TARGET, target);
    }

    if (showDefault != null) {
      requestBuilder.query(DEFAULT, showDefault);
    }

    ResponseConverter<List<TranslationModel>> converter =
        ResponseConverterUtils.getGenericObject(TYPE_LIST_TRANSLATION_MODEL, MODELS);

    return createServiceCall(requestBuilder.build(), converter);
  }

  /**
   * Identify language in which text is written.
   *
   * @param text the text to identify
   * @return the identified language
   */
  public ServiceCall<List<IdentifiedLanguage>> identify(final String text) {
    final RequestBuilder requestBuilder = RequestBuilder.post(PATH_IDENTIFY)
        .header(HttpHeaders.ACCEPT, HttpMediaType.APPLICATION_JSON).bodyContent(text, HttpMediaType.TEXT_PLAIN);

    ResponseConverter<List<IdentifiedLanguage>> converter =
        ResponseConverterUtils.getGenericObject(TYPE_LIST_IDENTIFIED_LANGUAGE, LANGUAGES);

    return createServiceCall(requestBuilder.build(), converter);
  }

  /**
   * Translate text using a given model.
   *
   * @param text The submitted paragraphs to translate
   * @param modelId the model id
   * @return The {@link TranslationResult}
   */
  public ServiceCall<TranslationResult> translate(final String text, final String modelId) {
    return translate(Collections.singletonList(text), modelId);
  }

  /**
   * Translate text using source and target languages.<br>
   *
   * @param text The paragraphs to translate
   * @param source The source language
   * @param target The target language
   * @return The {@link TranslationResult}
   */
  public ServiceCall<TranslationResult> translate(final String text, final Language source, final Language target) {
    return translate(Collections.singletonList(text), source, target);
  }

  /**
   * Translate multiple texts using a given model.
   *
   * @param texts The submitted texts to translate
   * @param modelId the model id
   * @return The {@link TranslationResult} with translations in the same order as the supplied texts.
   */
  public ServiceCall<TranslationResult> translate(final List<String> texts, final String modelId) {
    Validator.isTrue((modelId != null) && !modelId.isEmpty(), "modelId cannot be null or empty");
    return translateRequest(texts, modelId, null, null);
  }

  /**
   * Translate multiple texts using source and target languages.
   *
   * @param texts The texts to translate
   * @param source The source language
   * @param target The target language
   * @return The {@link TranslationResult} with translations in the same order as the supplied texts.
   */
  public ServiceCall<TranslationResult> translate(final List<String> texts, final Language source,
      final Language target) {
    return translateRequest(texts, null, source, target);
  }

  /**
   * Translate paragraphs of text using a model and or source and target. model_id or source and target needs to be
   * specified. If both are specified, then only model_id will be used
   *
   * @param texts the texts
   * @param modelId the model id
   * @param source the source
   * @param target the target
   * @return The {@link TranslationResult}
   */
  private ServiceCall<TranslationResult> translateRequest(List<String> texts, String modelId, Language source,
      Language target) {
    Validator.isTrue((texts != null) && !texts.isEmpty(), "texts cannot be null or empty");

    final JsonObject contentJson = new JsonObject();

    // convert the text into a json array
    final JsonArray paragraphs = new JsonArray();
    for (String text : texts) {
      Validator.notNull(text, "text cannot be null");
      paragraphs.add(new JsonPrimitive(text));
    }
    contentJson.add(TEXT, paragraphs);

    final RequestBuilder requestBuilder =
        RequestBuilder.post(PATH_TRANSLATE).header(HttpHeaders.ACCEPT, HttpMediaType.APPLICATION_JSON);

    if (source != null) {
      contentJson.addProperty(SOURCE, source.toString());
    }

    if (target != null) {
      contentJson.addProperty(TARGET, target.toString());
    }

    if ((modelId != null) && !modelId.isEmpty()) {
      contentJson.addProperty(MODEL_ID, modelId);
    }

    requestBuilder.bodyJson(contentJson);
    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(TranslationResult.class));
  }

}

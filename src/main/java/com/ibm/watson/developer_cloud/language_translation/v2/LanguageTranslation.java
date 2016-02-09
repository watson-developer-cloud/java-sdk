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

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.language_translation.v2.model.CreateModelOptions;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiableLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.LanguageList;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationModel;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationModelList;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.Validate;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

/**
 * The IBM Watson Language Translation service translate text from one language to another and
 * identifies the language in which text is written.
 * 
 * @version v2
 * @see <a href=
 *      "http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/language-translation.html">
 *      Language Translation</a>
 */
public class LanguageTranslation extends WatsonService {

  private static final String PATH_IDENTIFY = "/v2/identify";
  private static final String PATH_TRANSLATE = "/v2/translate";
  private static final String PATH_IDENTIFIABLE_LANGUAGES = "/v2/identifiable_languages";
  private static final String PATH_MODELS = "/v2/models";

  /** The Constant BASE_MODEL_ID (value is "base_model_id"). */
  private static final String BASE_MODEL_ID = "base_model_id";

  /** The Constant DEFAULT (value is "default"). */
  private static final String DEFAULT = "default";

  /** The Constant FORCED_GLOSSARY (value is "forced_glossary"). */
  private static final String FORCED_GLOSSARY = "forced_glossary";

  /** The Constant MODEL_ID (value is "model_id"). */
  private static final String MODEL_ID = "model_id";

  /** The Constant MONOLINGUAL_CORPUS (value is "monolingual_corpus"). */
  private static final String MONOLINGUAL_CORPUS = "monolingual_corpus";

  /** The Constant NAME (value is "name"). */
  private static final String NAME = "name";

  /** The Constant PARALLEL_CORPUS (value is "parallel_corpus"). */
  private static final String PARALLEL_CORPUS = "parallel_corpus";

  /** The Constant SOURCE (value is "source"). */
  private static final String SOURCE = "source";

  /** The Constant TARGET (value is "target"). */
  private static final String TARGET = "target";

  /** The Constant TEXT (value is "text"). */
  private static final String TEXT = "text";
  private static final String URL = "https://gateway.watsonplatform.net/language-translation/api";
  private static final String PATH_MODEL = "/v2/models/%s";

  /**
   * Instantiates a new Language Translation service.
   */
  public LanguageTranslation() {
    super("language_translation");
    setEndPoint(URL);
  }

  /**
   * Creates a translation models.
   * 
   * @param options the create model options
   * @return the translation model
   */
  public TranslationModel createModel(CreateModelOptions options) {
    Validate.notNull(options, "options cannot be null");
    Validate.notEmpty(options.getBaseModelId(), "options.baseModelId cannot be null or empty");

    final RequestBuilder requestBuilder = RequestBuilder.post(PATH_MODELS);
    requestBuilder.withQuery(BASE_MODEL_ID, options.getBaseModelId());

    if (options.getName() != null)
      requestBuilder.withQuery(NAME, options.getName());

    final MultipartBuilder bodyBuilder = new MultipartBuilder().type(MultipartBuilder.FORM);

    // either forced glossary, monolingual corpus or parallel corpus should be specified
    if (options.getForcedGlossary() != null)
      bodyBuilder.addFormDataPart(FORCED_GLOSSARY, options.getForcedGlossary().getName(),
          RequestBody.create(HttpMediaType.BINARY_FILE, options.getForcedGlossary()));
    if (options.getMonolingualCorpus() != null)
      bodyBuilder.addFormDataPart(MONOLINGUAL_CORPUS, options.getMonolingualCorpus().getName(),
          RequestBody.create(HttpMediaType.BINARY_FILE, options.getMonolingualCorpus()));
    if (options.getParallelCorpus() != null)
      bodyBuilder.addFormDataPart(PARALLEL_CORPUS, options.getParallelCorpus().getName(),
          RequestBody.create(HttpMediaType.BINARY_FILE, options.getParallelCorpus()));

    return executeRequest(requestBuilder.withBody(bodyBuilder.build()).build(),
        TranslationModel.class);
  }

  /**
   * Deletes a translation models.
   * 
   * @param modelId the model identifier
   */
  public void deleteModel(String modelId) {
    if (modelId == null || modelId.isEmpty())
      throw new IllegalArgumentException("modelId cannot be null or empty");

    final Request request = RequestBuilder.delete(String.format(PATH_MODEL, modelId)).build();
    executeWithoutResponse(request);
  }

  /**
   * Retrieves the list of identifiable languages.
   * 
   * @return the identifiable languages
   * @see TranslationModel
   */
  public List<IdentifiableLanguage> getIdentifiableLanguages() {
    final RequestBuilder requestBuilder = RequestBuilder.get(PATH_IDENTIFIABLE_LANGUAGES);
    final LanguageList languages = executeRequest(requestBuilder.build(), LanguageList.class);
    return languages.getLanguages();
  }

  /**
   * Retrieves a translation models.
   * 
   * @param modelId the model identifier
   * @return the translation models
   * @see TranslationModel
   */
  public TranslationModel getModel(String modelId) {
    if (modelId == null || modelId.isEmpty())
      throw new IllegalArgumentException("modelId cannot be null or empty");

    final Request request = RequestBuilder.get(String.format(PATH_MODEL, modelId)).build();
    return executeRequest(request, TranslationModel.class);
  }

  /**
   * Retrieves the list of translation models.
   * 
   * @return the translation models
   * @see TranslationModel
   */
  public List<TranslationModel> getModels() {
    return getModels(null, null, null);
  }

  /**
   * Retrieves the list of models.
   * 
   * @param showDefault show default models
   * @param source the source
   * @param target the target
   * @return the translation models
   * @see TranslationModel
   */
  public List<TranslationModel> getModels(final Boolean showDefault, final String source,
      final String target) {
    final RequestBuilder requestBuilder = RequestBuilder.get(PATH_MODELS);

    if (source != null && !source.isEmpty())
      requestBuilder.withQuery(SOURCE, source);

    if (target != null && !target.isEmpty())
      requestBuilder.withQuery(TARGET, source);

    if (showDefault != null)
      requestBuilder.withQuery(DEFAULT, showDefault.booleanValue());

    final TranslationModelList models =
        executeRequest(requestBuilder.build(), TranslationModelList.class);
    return models.getModels();
  }

  /**
   * Identify language in which text is written.
   * 
   * @param text the text to identify
   * @return the identified language
   */
  @SuppressWarnings("unchecked")
  public List<IdentifiedLanguage> identify(final String text) {
    final Request request = RequestBuilder.post(PATH_IDENTIFY)
        .withHeader(HttpHeaders.ACCEPT, HttpMediaType.APPLICATION_JSON)
        .withBodyContent(text, HttpMediaType.TEXT_PLAIN).build();

    final LanguageList languages = executeRequest(request, LanguageList.class);

    return (List<IdentifiedLanguage>) (List<?>) languages.getLanguages();
  }

  /**
   * Translate text using a model.
   * 
   * @param text The submitted paragraphs to translate
   * @param modelId the model id
   * @return The {@link TranslationResult}
   */
  public TranslationResult translate(final String text, final String modelId) {
    Validate.isTrue(modelId != null && !modelId.isEmpty(), "modelId cannot be null or empty");
    return translateRequest(text, modelId, null, null);
  }

  /**
   * Translate text using source and target languages.<br>
   * <br>
   * Here is an example of how to translate "hello" from English to Spanish:
   * 
   * 
   * <pre>
   * LanguageTranslation service = new LanguageTranslation();
   * service.setUsernameAndPassword(&quot;USERNAME&quot;, &quot;PASSWORD&quot;);
   * 
   * TranslationResult translationResult = service.translate(&quot;hello&quot;, &quot;en&quot;, &quot;es&quot;);
   * 
   * System.out.println(translationResult);
   * </pre>
   * 
   * @param text The submitted paragraphs to translate
   * @param source The source language
   * @param target The target language
   * @return The {@link TranslationResult}
   */
  public TranslationResult translate(final String text, final String source, final String target) {
    Validate.isTrue(source != null && !source.isEmpty(), "source cannot be null or empty");
    Validate.isTrue(target != null && !target.isEmpty(), "target cannot be null or empty");
    return translateRequest(text, null, source, target);
  }

  /**
   * Translate paragraphs of text using a model and or source and target. model_id or source and
   * target needs to be specified. If both are specified, then only model_id will be used
   * 
   * @param text the text
   * @param modelId the model id
   * @param source the source
   * @param target the target
   * @return The {@link TranslationResult}
   */
  private TranslationResult translateRequest(String text, String modelId, String source,
      String target) {
    Validate.isTrue(text != null && !text.isEmpty(), "text cannot be null or empty");

    final JsonObject contentJson = new JsonObject();

    // convert the text into a json array
    final JsonArray paragraphs = new JsonArray();
    paragraphs.add(new JsonPrimitive(text));
    contentJson.add(TEXT, paragraphs);

    final RequestBuilder requestBuilder = RequestBuilder.post(PATH_TRANSLATE)
        .withHeader(HttpHeaders.ACCEPT, HttpMediaType.APPLICATION_JSON);
    
    if (source != null && !source.isEmpty())
      contentJson.addProperty(SOURCE, source);

    if (target != null && !target.isEmpty())
      contentJson.addProperty(TARGET, target);

    if (modelId != null && !modelId.isEmpty())
      contentJson.addProperty(MODEL_ID, modelId);

    requestBuilder.withBodyJson(contentJson);
    return executeRequest(requestBuilder.build(), TranslationResult.class);
  }

}

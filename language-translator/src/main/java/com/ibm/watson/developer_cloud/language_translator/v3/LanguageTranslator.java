/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.language_translator.v3;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.WatsonService;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.language_translator.v3.model.CreateModelOptions;
import com.ibm.watson.developer_cloud.language_translator.v3.model.DeleteModelOptions;
import com.ibm.watson.developer_cloud.language_translator.v3.model.GetModelOptions;
import com.ibm.watson.developer_cloud.language_translator.v3.model.IdentifiableLanguages;
import com.ibm.watson.developer_cloud.language_translator.v3.model.IdentifiedLanguages;
import com.ibm.watson.developer_cloud.language_translator.v3.model.IdentifyOptions;
import com.ibm.watson.developer_cloud.language_translator.v3.model.ListIdentifiableLanguagesOptions;
import com.ibm.watson.developer_cloud.language_translator.v3.model.ListModelsOptions;
import com.ibm.watson.developer_cloud.language_translator.v3.model.TranslateOptions;
import com.ibm.watson.developer_cloud.language_translator.v3.model.TranslationModel;
import com.ibm.watson.developer_cloud.language_translator.v3.model.TranslationModels;
import com.ibm.watson.developer_cloud.language_translator.v3.model.TranslationResult;
import com.ibm.cloud.sdk.core.util.Validator;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * IBM Watson&trade; Language Translator translates text from one language to another. The service offers multiple IBM
 * provided translation models that you can customize based on your unique terminology and language. Use Language
 * Translator to take news from across the globe and present it in your language, communicate with your customers in
 * their own language, and more.
 *
 * @version v3
 * @see <a href="http://www.ibm.com/watson/developercloud/language-translator.html">Language Translator</a>
 */
public class LanguageTranslator extends WatsonService {

  private static final String SERVICE_NAME = "language_translator";
  private static final String URL = "https://gateway.watsonplatform.net/language-translator/api";

  private String versionDate;

  /**
   * Instantiates a new `LanguageTranslator`.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   */
  public LanguageTranslator(String versionDate) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");

    this.versionDate = versionDate;
  }

  /**
   * Instantiates a new `LanguageTranslator` with username and password.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param username the username
   * @param password the password
   */
  public LanguageTranslator(String versionDate, String username, String password) {
    this(versionDate);
    setUsernameAndPassword(username, password);
  }

  /**
   * Instantiates a new `LanguageTranslator` with IAM. Note that if the access token is specified in the
   * iamOptions, you accept responsibility for managing the access token yourself. You must set a new access token
   * before this
   * one expires or after receiving a 401 error from the service. Failing to do so will result in authentication errors
   * after this token expires.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param iamOptions the options for authenticating through IAM
   */
  public LanguageTranslator(String versionDate, IamOptions iamOptions) {
    this(versionDate);
    setIamCredentials(iamOptions);
  }

  /**
   * Translate.
   *
   * Translates the input text from the source language to the target language.
   *
   * @param translateOptions the {@link TranslateOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TranslationResult}
   */
  public ServiceCall<TranslationResult> translate(TranslateOptions translateOptions) {
    Validator.notNull(translateOptions, "translateOptions cannot be null");
    String[] pathSegments = { "v3/translate" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=language_translator;service_version=v3;operation_id=translate");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("text", GsonSingleton.getGson().toJsonTree(translateOptions.text()));
    if (translateOptions.modelId() != null) {
      contentJson.addProperty("model_id", translateOptions.modelId());
    }
    if (translateOptions.source() != null) {
      contentJson.addProperty("source", translateOptions.source());
    }
    if (translateOptions.target() != null) {
      contentJson.addProperty("target", translateOptions.target());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TranslationResult.class));
  }

  /**
   * Identify language.
   *
   * Identifies the language of the input text.
   *
   * @param identifyOptions the {@link IdentifyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link IdentifiedLanguages}
   */
  public ServiceCall<IdentifiedLanguages> identify(IdentifyOptions identifyOptions) {
    Validator.notNull(identifyOptions, "identifyOptions cannot be null");
    String[] pathSegments = { "v3/identify" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=language_translator;service_version=v3;operation_id=identify");
    builder.bodyContent(identifyOptions.text(), "text/plain");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(IdentifiedLanguages.class));
  }

  /**
   * List identifiable languages.
   *
   * Lists the languages that the service can identify. Returns the language code (for example, `en` for English or `es`
   * for Spanish) and name of each language.
   *
   * @param listIdentifiableLanguagesOptions the {@link ListIdentifiableLanguagesOptions} containing the options for the
   *          call
   * @return a {@link ServiceCall} with a response type of {@link IdentifiableLanguages}
   */
  public ServiceCall<IdentifiableLanguages> listIdentifiableLanguages(
      ListIdentifiableLanguagesOptions listIdentifiableLanguagesOptions) {
    String[] pathSegments = { "v3/identifiable_languages" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=language_translator;service_version=v3;operation_id=listIdentifiableLanguages");
    if (listIdentifiableLanguagesOptions != null) {
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(IdentifiableLanguages.class));
  }

  /**
   * List identifiable languages.
   *
   * Lists the languages that the service can identify. Returns the language code (for example, `en` for English or `es`
   * for Spanish) and name of each language.
   *
   * @return a {@link ServiceCall} with a response type of {@link IdentifiableLanguages}
   */
  public ServiceCall<IdentifiableLanguages> listIdentifiableLanguages() {
    return listIdentifiableLanguages(null);
  }

  /**
   * Create model.
   *
   * Uploads Translation Memory eXchange (TMX) files to customize a translation model.
   *
   * You can either customize a model with a forced glossary or with a corpus that contains parallel sentences. To
   * create a model that is customized with a parallel corpus <b>and</b> a forced glossary, proceed in two steps:
   * customize with a parallel corpus first and then customize the resulting model with a glossary. Depending on the
   * type of customization and the size of the uploaded corpora, training can range from minutes for a glossary to
   * several hours for a large parallel corpus. You can upload a single forced glossary file and this file must be less
   * than <b>10 MB</b>. You can upload multiple parallel corpora tmx files. The cumulative file size of all uploaded
   * files is limited to <b>250 MB</b>. To successfully train with a parallel corpus you must have at least <b>5,000
   * parallel sentences</b> in your corpus.
   *
   * You can have a <b>maxium of 10 custom models per language pair</b>.
   *
   * @param createModelOptions the {@link CreateModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TranslationModel}
   */
  public ServiceCall<TranslationModel> createModel(CreateModelOptions createModelOptions) {
    Validator.notNull(createModelOptions, "createModelOptions cannot be null");
    Validator.isTrue((createModelOptions.forcedGlossary() != null) || (createModelOptions.parallelCorpus() != null),
        "At least one of forcedGlossary or parallelCorpus must be supplied.");
    String[] pathSegments = { "v3/models" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=language_translator;service_version=v3;operation_id=createModel");
    builder.query("base_model_id", createModelOptions.baseModelId());
    if (createModelOptions.name() != null) {
      builder.query("name", createModelOptions.name());
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (createModelOptions.forcedGlossary() != null) {
      RequestBody forcedGlossaryBody = RequestUtils.inputStreamBody(createModelOptions.forcedGlossary(),
          "application/octet-stream");
      multipartBuilder.addFormDataPart("forced_glossary", createModelOptions.forcedGlossaryFilename(),
          forcedGlossaryBody);
    }
    if (createModelOptions.parallelCorpus() != null) {
      RequestBody parallelCorpusBody = RequestUtils.inputStreamBody(createModelOptions.parallelCorpus(),
          "application/octet-stream");
      multipartBuilder.addFormDataPart("parallel_corpus", createModelOptions.parallelCorpusFilename(),
          parallelCorpusBody);
    }
    builder.body(multipartBuilder.build());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TranslationModel.class));
  }

  /**
   * Delete model.
   *
   * Deletes a custom translation model.
   *
   * @param deleteModelOptions the {@link DeleteModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteModel(DeleteModelOptions deleteModelOptions) {
    Validator.notNull(deleteModelOptions, "deleteModelOptions cannot be null");
    String[] pathSegments = { "v3/models" };
    String[] pathParameters = { deleteModelOptions.modelId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=language_translator;service_version=v3;operation_id=deleteModel");
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get model details.
   *
   * Gets information about a translation model, including training status for custom models. Use this API call to poll
   * the status of your customization request. A successfully completed training will have a status of `available`.
   *
   * @param getModelOptions the {@link GetModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TranslationModel}
   */
  public ServiceCall<TranslationModel> getModel(GetModelOptions getModelOptions) {
    Validator.notNull(getModelOptions, "getModelOptions cannot be null");
    String[] pathSegments = { "v3/models" };
    String[] pathParameters = { getModelOptions.modelId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=language_translator;service_version=v3;operation_id=getModel");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TranslationModel.class));
  }

  /**
   * List models.
   *
   * Lists available translation models.
   *
   * @param listModelsOptions the {@link ListModelsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TranslationModels}
   */
  public ServiceCall<TranslationModels> listModels(ListModelsOptions listModelsOptions) {
    String[] pathSegments = { "v3/models" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=language_translator;service_version=v3;operation_id=listModels");
    if (listModelsOptions != null) {
      if (listModelsOptions.source() != null) {
        builder.query("source", listModelsOptions.source());
      }
      if (listModelsOptions.target() != null) {
        builder.query("target", listModelsOptions.target());
      }
      if (listModelsOptions.defaultModels() != null) {
        builder.query("default", String.valueOf(listModelsOptions.defaultModels()));
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TranslationModels.class));
  }

  /**
   * List models.
   *
   * Lists available translation models.
   *
   * @return a {@link ServiceCall} with a response type of {@link TranslationModels}
   */
  public ServiceCall<TranslationModels> listModels() {
    return listModels(null);
  }

}

/*
 * (C) Copyright IBM Corp. 2019, 2021.
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

/*
 * IBM OpenAPI SDK Code Generator Version: 3.38.0-07189efd-20210827-205025
 */

package com.ibm.watson.natural_language_understanding.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.watson.common.SdkCommon;
import com.ibm.watson.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.natural_language_understanding.v1.model.CategoriesModel;
import com.ibm.watson.natural_language_understanding.v1.model.CategoriesModelList;
import com.ibm.watson.natural_language_understanding.v1.model.ClassificationsModel;
import com.ibm.watson.natural_language_understanding.v1.model.ClassificationsModelList;
import com.ibm.watson.natural_language_understanding.v1.model.CreateCategoriesModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.CreateClassificationsModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.CreateSentimentModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.DeleteCategoriesModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.DeleteClassificationsModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.DeleteModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.DeleteModelResults;
import com.ibm.watson.natural_language_understanding.v1.model.DeleteSentimentModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.GetCategoriesModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.GetClassificationsModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.GetSentimentModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ListCategoriesModelsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ListClassificationsModelsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ListModelsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ListModelsResults;
import com.ibm.watson.natural_language_understanding.v1.model.ListSentimentModelsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ListSentimentModelsResponse;
import com.ibm.watson.natural_language_understanding.v1.model.SentimentModel;
import com.ibm.watson.natural_language_understanding.v1.model.UpdateCategoriesModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.UpdateClassificationsModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.UpdateSentimentModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.MultipartBody;

/**
 * Analyze various features of text content at scale. Provide text, raw HTML, or a public URL and
 * IBM Watson Natural Language Understanding will give you results for the features you request. The
 * service cleans HTML content before analysis by default, so the results can ignore most
 * advertisements and other unwanted content.
 *
 * <p>You can create [custom
 * models](https://cloud.ibm.com/docs/natural-language-understanding?topic=natural-language-understanding-customizing)
 * with Watson Knowledge Studio to detect custom entities and relations in Natural Language
 * Understanding.
 *
 * <p>API Version: 1.0 See: https://cloud.ibm.com/docs/natural-language-understanding
 */
public class NaturalLanguageUnderstanding extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "natural-language-understanding";

  public static final String DEFAULT_SERVICE_URL =
      "https://api.us-south.natural-language-understanding.watson.cloud.ibm.com";

  private String version;

  /**
   * Constructs an instance of the `NaturalLanguageUnderstanding` client. The default service name
   * is used to configure the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2021-08-01`.
   */
  public NaturalLanguageUnderstanding(String version) {
    this(
        version,
        DEFAULT_SERVICE_NAME,
        ConfigBasedAuthenticatorFactory.getAuthenticator(DEFAULT_SERVICE_NAME));
  }

  /**
   * Constructs an instance of the `NaturalLanguageUnderstanding` client. The default service name
   * and specified authenticator are used to configure the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2021-08-01`.
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public NaturalLanguageUnderstanding(String version, Authenticator authenticator) {
    this(version, DEFAULT_SERVICE_NAME, authenticator);
  }

  /**
   * Constructs an instance of the `NaturalLanguageUnderstanding` client. The specified service name
   * is used to configure the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2021-08-01`.
   * @param serviceName the service name to be used when configuring the client instance
   */
  public NaturalLanguageUnderstanding(String version, String serviceName) {
    this(version, serviceName, ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName));
  }

  /**
   * Constructs an instance of the `NaturalLanguageUnderstanding` client. The specified service name
   * and authenticator are used to configure the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2021-08-01`.
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public NaturalLanguageUnderstanding(
      String version, String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
    setVersion(version);
    this.configureService(serviceName);
  }

  /**
   * Gets the version.
   *
   * <p>Release date of the API version you want to use. Specify dates in YYYY-MM-DD format. The
   * current version is `2021-08-01`.
   *
   * @return the version
   */
  public String getVersion() {
    return this.version;
  }

  /**
   * Sets the version.
   *
   * @param version the new version
   */
  public void setVersion(final String version) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(version, "version cannot be empty.");
    this.version = version;
  }

  /**
   * Analyze text.
   *
   * <p>Analyzes text, HTML, or a public webpage for the following features: - Categories -
   * Classifications - Concepts - Emotion - Entities - Keywords - Metadata - Relations - Semantic
   * roles - Sentiment - Syntax - Summarization (Experimental)
   *
   * <p>If a language for the input text is not specified with the `language` parameter, the service
   * [automatically detects the
   * language](https://cloud.ibm.com/docs/natural-language-understanding?topic=natural-language-understanding-detectable-languages).
   *
   * @param analyzeOptions the {@link AnalyzeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AnalysisResults}
   */
  public ServiceCall<AnalysisResults> analyze(AnalyzeOptions analyzeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(analyzeOptions, "analyzeOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/analyze"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "analyze");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.add(
        "features",
        com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(analyzeOptions.features()));
    if (analyzeOptions.text() != null) {
      contentJson.addProperty("text", analyzeOptions.text());
    }
    if (analyzeOptions.html() != null) {
      contentJson.addProperty("html", analyzeOptions.html());
    }
    if (analyzeOptions.url() != null) {
      contentJson.addProperty("url", analyzeOptions.url());
    }
    if (analyzeOptions.clean() != null) {
      contentJson.addProperty("clean", analyzeOptions.clean());
    }
    if (analyzeOptions.xpath() != null) {
      contentJson.addProperty("xpath", analyzeOptions.xpath());
    }
    if (analyzeOptions.fallbackToRaw() != null) {
      contentJson.addProperty("fallback_to_raw", analyzeOptions.fallbackToRaw());
    }
    if (analyzeOptions.returnAnalyzedText() != null) {
      contentJson.addProperty("return_analyzed_text", analyzeOptions.returnAnalyzedText());
    }
    if (analyzeOptions.language() != null) {
      contentJson.addProperty("language", analyzeOptions.language());
    }
    if (analyzeOptions.limitTextCharacters() != null) {
      contentJson.addProperty("limit_text_characters", analyzeOptions.limitTextCharacters());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<AnalysisResults> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<AnalysisResults>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List models.
   *
   * <p>Lists Watson Knowledge Studio [custom entities and relations
   * models](https://cloud.ibm.com/docs/natural-language-understanding?topic=natural-language-understanding-customizing)
   * that are deployed to your Natural Language Understanding service.
   *
   * @param listModelsOptions the {@link ListModelsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListModelsResults}
   */
  public ServiceCall<ListModelsResults> listModels(ListModelsOptions listModelsOptions) {
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/models"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "listModels");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<ListModelsResults> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ListModelsResults>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List models.
   *
   * <p>Lists Watson Knowledge Studio [custom entities and relations
   * models](https://cloud.ibm.com/docs/natural-language-understanding?topic=natural-language-understanding-customizing)
   * that are deployed to your Natural Language Understanding service.
   *
   * @return a {@link ServiceCall} with a result of type {@link ListModelsResults}
   */
  public ServiceCall<ListModelsResults> listModels() {
    return listModels(null);
  }

  /**
   * Delete model.
   *
   * <p>Deletes a custom model.
   *
   * @param deleteModelOptions the {@link DeleteModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteModelResults}
   */
  public ServiceCall<DeleteModelResults> deleteModel(DeleteModelOptions deleteModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteModelOptions, "deleteModelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("model_id", deleteModelOptions.modelId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/models/{model_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "deleteModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<DeleteModelResults> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DeleteModelResults>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create sentiment model.
   *
   * <p>(Beta) Creates a custom sentiment model by uploading training data and associated metadata.
   * The model begins the training and deploying process and is ready to use when the `status` is
   * `available`.
   *
   * @param createSentimentModelOptions the {@link CreateSentimentModelOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link SentimentModel}
   */
  public ServiceCall<SentimentModel> createSentimentModel(
      CreateSentimentModelOptions createSentimentModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createSentimentModelOptions, "createSentimentModelOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/models/sentiment"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "createSentimentModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    multipartBuilder.addFormDataPart("language", createSentimentModelOptions.language());
    okhttp3.RequestBody trainingDataBody =
        RequestUtils.inputStreamBody(createSentimentModelOptions.trainingData(), "text/csv");
    multipartBuilder.addFormDataPart("training_data", "filename", trainingDataBody);
    if (createSentimentModelOptions.name() != null) {
      multipartBuilder.addFormDataPart("name", createSentimentModelOptions.name());
    }
    if (createSentimentModelOptions.description() != null) {
      multipartBuilder.addFormDataPart("description", createSentimentModelOptions.description());
    }
    if (createSentimentModelOptions.modelVersion() != null) {
      multipartBuilder.addFormDataPart("model_version", createSentimentModelOptions.modelVersion());
    }
    if (createSentimentModelOptions.workspaceId() != null) {
      multipartBuilder.addFormDataPart("workspace_id", createSentimentModelOptions.workspaceId());
    }
    if (createSentimentModelOptions.versionDescription() != null) {
      multipartBuilder.addFormDataPart(
          "version_description", createSentimentModelOptions.versionDescription());
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<SentimentModel> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<SentimentModel>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List sentiment models.
   *
   * <p>(Beta) Returns all custom sentiment models associated with this service instance.
   *
   * @param listSentimentModelsOptions the {@link ListSentimentModelsOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link ListSentimentModelsResponse}
   */
  public ServiceCall<ListSentimentModelsResponse> listSentimentModels(
      ListSentimentModelsOptions listSentimentModelsOptions) {
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/models/sentiment"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "listSentimentModels");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<ListSentimentModelsResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ListSentimentModelsResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List sentiment models.
   *
   * <p>(Beta) Returns all custom sentiment models associated with this service instance.
   *
   * @return a {@link ServiceCall} with a result of type {@link ListSentimentModelsResponse}
   */
  public ServiceCall<ListSentimentModelsResponse> listSentimentModels() {
    return listSentimentModels(null);
  }

  /**
   * Get sentiment model details.
   *
   * <p>(Beta) Returns the status of the sentiment model with the given model ID.
   *
   * @param getSentimentModelOptions the {@link GetSentimentModelOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link SentimentModel}
   */
  public ServiceCall<SentimentModel> getSentimentModel(
      GetSentimentModelOptions getSentimentModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getSentimentModelOptions, "getSentimentModelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("model_id", getSentimentModelOptions.modelId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/models/sentiment/{model_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "getSentimentModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<SentimentModel> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<SentimentModel>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update sentiment model.
   *
   * <p>(Beta) Overwrites the training data associated with this custom sentiment model and retrains
   * the model. The new model replaces the current deployment.
   *
   * @param updateSentimentModelOptions the {@link UpdateSentimentModelOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link SentimentModel}
   */
  public ServiceCall<SentimentModel> updateSentimentModel(
      UpdateSentimentModelOptions updateSentimentModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateSentimentModelOptions, "updateSentimentModelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("model_id", updateSentimentModelOptions.modelId());
    RequestBuilder builder =
        RequestBuilder.put(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/models/sentiment/{model_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "updateSentimentModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    multipartBuilder.addFormDataPart("language", updateSentimentModelOptions.language());
    okhttp3.RequestBody trainingDataBody =
        RequestUtils.inputStreamBody(updateSentimentModelOptions.trainingData(), "text/csv");
    multipartBuilder.addFormDataPart("training_data", "filename", trainingDataBody);
    if (updateSentimentModelOptions.name() != null) {
      multipartBuilder.addFormDataPart("name", updateSentimentModelOptions.name());
    }
    if (updateSentimentModelOptions.description() != null) {
      multipartBuilder.addFormDataPart("description", updateSentimentModelOptions.description());
    }
    if (updateSentimentModelOptions.modelVersion() != null) {
      multipartBuilder.addFormDataPart("model_version", updateSentimentModelOptions.modelVersion());
    }
    if (updateSentimentModelOptions.workspaceId() != null) {
      multipartBuilder.addFormDataPart("workspace_id", updateSentimentModelOptions.workspaceId());
    }
    if (updateSentimentModelOptions.versionDescription() != null) {
      multipartBuilder.addFormDataPart(
          "version_description", updateSentimentModelOptions.versionDescription());
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<SentimentModel> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<SentimentModel>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete sentiment model.
   *
   * <p>(Beta) Un-deploys the custom sentiment model with the given model ID and deletes all
   * associated customer data, including any training data or binary artifacts.
   *
   * @param deleteSentimentModelOptions the {@link DeleteSentimentModelOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteModelResults}
   */
  public ServiceCall<DeleteModelResults> deleteSentimentModel(
      DeleteSentimentModelOptions deleteSentimentModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteSentimentModelOptions, "deleteSentimentModelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("model_id", deleteSentimentModelOptions.modelId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/models/sentiment/{model_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "deleteSentimentModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<DeleteModelResults> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DeleteModelResults>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create categories model.
   *
   * <p>(Beta) Creates a custom categories model by uploading training data and associated metadata.
   * The model begins the training and deploying process and is ready to use when the `status` is
   * `available`.
   *
   * @param createCategoriesModelOptions the {@link CreateCategoriesModelOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link CategoriesModel}
   */
  public ServiceCall<CategoriesModel> createCategoriesModel(
      CreateCategoriesModelOptions createCategoriesModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createCategoriesModelOptions, "createCategoriesModelOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/models/categories"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "createCategoriesModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    multipartBuilder.addFormDataPart("language", createCategoriesModelOptions.language());
    okhttp3.RequestBody trainingDataBody =
        RequestUtils.inputStreamBody(
            createCategoriesModelOptions.trainingData(),
            createCategoriesModelOptions.trainingDataContentType());
    multipartBuilder.addFormDataPart("training_data", "filename", trainingDataBody);
    if (createCategoriesModelOptions.name() != null) {
      multipartBuilder.addFormDataPart("name", createCategoriesModelOptions.name());
    }
    if (createCategoriesModelOptions.description() != null) {
      multipartBuilder.addFormDataPart("description", createCategoriesModelOptions.description());
    }
    if (createCategoriesModelOptions.modelVersion() != null) {
      multipartBuilder.addFormDataPart(
          "model_version", createCategoriesModelOptions.modelVersion());
    }
    if (createCategoriesModelOptions.workspaceId() != null) {
      multipartBuilder.addFormDataPart("workspace_id", createCategoriesModelOptions.workspaceId());
    }
    if (createCategoriesModelOptions.versionDescription() != null) {
      multipartBuilder.addFormDataPart(
          "version_description", createCategoriesModelOptions.versionDescription());
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<CategoriesModel> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<CategoriesModel>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List categories models.
   *
   * <p>(Beta) Returns all custom categories models associated with this service instance.
   *
   * @param listCategoriesModelsOptions the {@link ListCategoriesModelsOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link CategoriesModelList}
   */
  public ServiceCall<CategoriesModelList> listCategoriesModels(
      ListCategoriesModelsOptions listCategoriesModelsOptions) {
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/models/categories"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "listCategoriesModels");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<CategoriesModelList> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<CategoriesModelList>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List categories models.
   *
   * <p>(Beta) Returns all custom categories models associated with this service instance.
   *
   * @return a {@link ServiceCall} with a result of type {@link CategoriesModelList}
   */
  public ServiceCall<CategoriesModelList> listCategoriesModels() {
    return listCategoriesModels(null);
  }

  /**
   * Get categories model details.
   *
   * <p>(Beta) Returns the status of the categories model with the given model ID.
   *
   * @param getCategoriesModelOptions the {@link GetCategoriesModelOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link CategoriesModel}
   */
  public ServiceCall<CategoriesModel> getCategoriesModel(
      GetCategoriesModelOptions getCategoriesModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getCategoriesModelOptions, "getCategoriesModelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("model_id", getCategoriesModelOptions.modelId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/models/categories/{model_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "getCategoriesModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<CategoriesModel> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<CategoriesModel>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update categories model.
   *
   * <p>(Beta) Overwrites the training data associated with this custom categories model and
   * retrains the model. The new model replaces the current deployment.
   *
   * @param updateCategoriesModelOptions the {@link UpdateCategoriesModelOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link CategoriesModel}
   */
  public ServiceCall<CategoriesModel> updateCategoriesModel(
      UpdateCategoriesModelOptions updateCategoriesModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateCategoriesModelOptions, "updateCategoriesModelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("model_id", updateCategoriesModelOptions.modelId());
    RequestBuilder builder =
        RequestBuilder.put(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/models/categories/{model_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "updateCategoriesModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    multipartBuilder.addFormDataPart("language", updateCategoriesModelOptions.language());
    okhttp3.RequestBody trainingDataBody =
        RequestUtils.inputStreamBody(
            updateCategoriesModelOptions.trainingData(),
            updateCategoriesModelOptions.trainingDataContentType());
    multipartBuilder.addFormDataPart("training_data", "filename", trainingDataBody);
    if (updateCategoriesModelOptions.name() != null) {
      multipartBuilder.addFormDataPart("name", updateCategoriesModelOptions.name());
    }
    if (updateCategoriesModelOptions.description() != null) {
      multipartBuilder.addFormDataPart("description", updateCategoriesModelOptions.description());
    }
    if (updateCategoriesModelOptions.modelVersion() != null) {
      multipartBuilder.addFormDataPart(
          "model_version", updateCategoriesModelOptions.modelVersion());
    }
    if (updateCategoriesModelOptions.workspaceId() != null) {
      multipartBuilder.addFormDataPart("workspace_id", updateCategoriesModelOptions.workspaceId());
    }
    if (updateCategoriesModelOptions.versionDescription() != null) {
      multipartBuilder.addFormDataPart(
          "version_description", updateCategoriesModelOptions.versionDescription());
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<CategoriesModel> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<CategoriesModel>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete categories model.
   *
   * <p>(Beta) Un-deploys the custom categories model with the given model ID and deletes all
   * associated customer data, including any training data or binary artifacts.
   *
   * @param deleteCategoriesModelOptions the {@link DeleteCategoriesModelOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteModelResults}
   */
  public ServiceCall<DeleteModelResults> deleteCategoriesModel(
      DeleteCategoriesModelOptions deleteCategoriesModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteCategoriesModelOptions, "deleteCategoriesModelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("model_id", deleteCategoriesModelOptions.modelId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/models/categories/{model_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "deleteCategoriesModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<DeleteModelResults> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DeleteModelResults>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create classifications model.
   *
   * <p>Creates a custom classifications model by uploading training data and associated metadata.
   * The model begins the training and deploying process and is ready to use when the `status` is
   * `available`.
   *
   * @param createClassificationsModelOptions the {@link CreateClassificationsModelOptions}
   *     containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ClassificationsModel}
   */
  public ServiceCall<ClassificationsModel> createClassificationsModel(
      CreateClassificationsModelOptions createClassificationsModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createClassificationsModelOptions, "createClassificationsModelOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/models/classifications"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders(
            "natural-language-understanding", "v1", "createClassificationsModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    multipartBuilder.addFormDataPart("language", createClassificationsModelOptions.language());
    okhttp3.RequestBody trainingDataBody =
        RequestUtils.inputStreamBody(
            createClassificationsModelOptions.trainingData(),
            createClassificationsModelOptions.trainingDataContentType());
    multipartBuilder.addFormDataPart("training_data", "filename", trainingDataBody);
    if (createClassificationsModelOptions.name() != null) {
      multipartBuilder.addFormDataPart("name", createClassificationsModelOptions.name());
    }
    if (createClassificationsModelOptions.description() != null) {
      multipartBuilder.addFormDataPart(
          "description", createClassificationsModelOptions.description());
    }
    if (createClassificationsModelOptions.modelVersion() != null) {
      multipartBuilder.addFormDataPart(
          "model_version", createClassificationsModelOptions.modelVersion());
    }
    if (createClassificationsModelOptions.workspaceId() != null) {
      multipartBuilder.addFormDataPart(
          "workspace_id", createClassificationsModelOptions.workspaceId());
    }
    if (createClassificationsModelOptions.versionDescription() != null) {
      multipartBuilder.addFormDataPart(
          "version_description", createClassificationsModelOptions.versionDescription());
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<ClassificationsModel> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ClassificationsModel>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List classifications models.
   *
   * <p>Returns all custom classifications models associated with this service instance.
   *
   * @param listClassificationsModelsOptions the {@link ListClassificationsModelsOptions} containing
   *     the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ClassificationsModelList}
   */
  public ServiceCall<ClassificationsModelList> listClassificationsModels(
      ListClassificationsModelsOptions listClassificationsModelsOptions) {
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/models/classifications"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders(
            "natural-language-understanding", "v1", "listClassificationsModels");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<ClassificationsModelList> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ClassificationsModelList>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List classifications models.
   *
   * <p>Returns all custom classifications models associated with this service instance.
   *
   * @return a {@link ServiceCall} with a result of type {@link ClassificationsModelList}
   */
  public ServiceCall<ClassificationsModelList> listClassificationsModels() {
    return listClassificationsModels(null);
  }

  /**
   * Get classifications model details.
   *
   * <p>Returns the status of the classifications model with the given model ID.
   *
   * @param getClassificationsModelOptions the {@link GetClassificationsModelOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link ClassificationsModel}
   */
  public ServiceCall<ClassificationsModel> getClassificationsModel(
      GetClassificationsModelOptions getClassificationsModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getClassificationsModelOptions, "getClassificationsModelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("model_id", getClassificationsModelOptions.modelId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/models/classifications/{model_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "getClassificationsModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<ClassificationsModel> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ClassificationsModel>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update classifications model.
   *
   * <p>Overwrites the training data associated with this custom classifications model and retrains
   * the model. The new model replaces the current deployment.
   *
   * @param updateClassificationsModelOptions the {@link UpdateClassificationsModelOptions}
   *     containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ClassificationsModel}
   */
  public ServiceCall<ClassificationsModel> updateClassificationsModel(
      UpdateClassificationsModelOptions updateClassificationsModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateClassificationsModelOptions, "updateClassificationsModelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("model_id", updateClassificationsModelOptions.modelId());
    RequestBuilder builder =
        RequestBuilder.put(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/models/classifications/{model_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders(
            "natural-language-understanding", "v1", "updateClassificationsModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    multipartBuilder.addFormDataPart("language", updateClassificationsModelOptions.language());
    okhttp3.RequestBody trainingDataBody =
        RequestUtils.inputStreamBody(
            updateClassificationsModelOptions.trainingData(),
            updateClassificationsModelOptions.trainingDataContentType());
    multipartBuilder.addFormDataPart("training_data", "filename", trainingDataBody);
    if (updateClassificationsModelOptions.name() != null) {
      multipartBuilder.addFormDataPart("name", updateClassificationsModelOptions.name());
    }
    if (updateClassificationsModelOptions.description() != null) {
      multipartBuilder.addFormDataPart(
          "description", updateClassificationsModelOptions.description());
    }
    if (updateClassificationsModelOptions.modelVersion() != null) {
      multipartBuilder.addFormDataPart(
          "model_version", updateClassificationsModelOptions.modelVersion());
    }
    if (updateClassificationsModelOptions.workspaceId() != null) {
      multipartBuilder.addFormDataPart(
          "workspace_id", updateClassificationsModelOptions.workspaceId());
    }
    if (updateClassificationsModelOptions.versionDescription() != null) {
      multipartBuilder.addFormDataPart(
          "version_description", updateClassificationsModelOptions.versionDescription());
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<ClassificationsModel> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ClassificationsModel>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete classifications model.
   *
   * <p>Un-deploys the custom classifications model with the given model ID and deletes all
   * associated customer data, including any training data or binary artifacts.
   *
   * @param deleteClassificationsModelOptions the {@link DeleteClassificationsModelOptions}
   *     containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteModelResults}
   */
  public ServiceCall<DeleteModelResults> deleteClassificationsModel(
      DeleteClassificationsModelOptions deleteClassificationsModelOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteClassificationsModelOptions, "deleteClassificationsModelOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("model_id", deleteClassificationsModelOptions.modelId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/models/classifications/{model_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders(
            "natural-language-understanding", "v1", "deleteClassificationsModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<DeleteModelResults> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DeleteModelResults>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }
}

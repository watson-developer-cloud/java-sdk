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
package com.ibm.watson.natural_language_understanding.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.AuthenticatorConfig;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.cloud.sdk.core.util.Validator;
import com.ibm.watson.common.SdkCommon;
import com.ibm.watson.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.natural_language_understanding.v1.model.DeleteModelOptions;
import com.ibm.watson.natural_language_understanding.v1.model.DeleteModelResults;
import com.ibm.watson.natural_language_understanding.v1.model.ListModelsOptions;
import com.ibm.watson.natural_language_understanding.v1.model.ListModelsResults;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Analyze various features of text content at scale. Provide text, raw HTML, or a public URL and IBM Watson Natural
 * Language Understanding will give you results for the features you request. The service cleans HTML content before
 * analysis by default, so the results can ignore most advertisements and other unwanted content.
 *
 * You can create [custom
 * models]
 * (https://cloud.ibm.com/docs/services/natural-language-understanding?topic=natural-language-understanding-customizing)
 * with Watson Knowledge Studio to detect custom entities, relations, and categories in Natural Language Understanding.
 *
 * @version v1
 * @see <a href="http://www.ibm.com/watson/developercloud/natural-language-understanding.html">Natural Language
 *      Understanding</a>
 */
public class NaturalLanguageUnderstanding extends BaseService {

  private static final String SERVICE_NAME = "natural_language_understanding";
  private static final String URL = "https://gateway.watsonplatform.net/natural-language-understanding/api";

  private String versionDate;

  /**
   * Instantiates a new `NaturalLanguageUnderstanding`.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @deprecated Use NaturalLanguageUnderstanding(String versionDate, AuthenticatorConfig authenticatorConfig) instead
   */
  @Deprecated
  public NaturalLanguageUnderstanding(String versionDate) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");

    this.versionDate = versionDate;
  }

  /**
   * Instantiates a new `NaturalLanguageUnderstanding` with username and password.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param username the username
   * @param password the password
   * @deprecated Use NaturalLanguageUnderstanding(String versionDate, AuthenticatorConfig authenticatorConfig) instead
   */
  @Deprecated
  public NaturalLanguageUnderstanding(String versionDate, String username, String password) {
    this(versionDate);
    setUsernameAndPassword(username, password);
  }

  /**
   * Instantiates a new `NaturalLanguageUnderstanding` with the specified authentication configuration.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param authenticatorConfig the authentication configuration for this service
   */
  public NaturalLanguageUnderstanding(String versionDate, AuthenticatorConfig authenticatorConfig) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }
    setAuthenticator(authenticatorConfig);

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");
    this.versionDate = versionDate;
  }

  /**
   * Analyze text.
   *
   * Analyzes text, HTML, or a public webpage for the following features:
   * - Categories
   * - Concepts
   * - Emotion
   * - Entities
   * - Keywords
   * - Metadata
   * - Relations
   * - Semantic roles
   * - Sentiment
   * - Syntax (Experimental).
   *
   * @param analyzeOptions the {@link AnalyzeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link AnalysisResults}
   */
  public ServiceCall<AnalysisResults> analyze(AnalyzeOptions analyzeOptions) {
    Validator.notNull(analyzeOptions, "analyzeOptions cannot be null");
    String[] pathSegments = { "v1/analyze" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "analyze");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("features", GsonSingleton.getGson().toJsonTree(analyzeOptions.features()));
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
    ResponseConverter<AnalysisResults> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<AnalysisResults>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List models.
   *
   * Lists Watson Knowledge Studio [custom entities and relations
   * models]
   * (https://cloud.ibm.com/docs/services/natural-language-understanding
   * ?topic=natural-language-understanding-customizing)
   * that are deployed to your Natural Language Understanding service.
   *
   * @param listModelsOptions the {@link ListModelsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ListModelsResults}
   */
  public ServiceCall<ListModelsResults> listModels(ListModelsOptions listModelsOptions) {
    String[] pathSegments = { "v1/models" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "listModels");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listModelsOptions != null) {
    }
    ResponseConverter<ListModelsResults> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<ListModelsResults>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List models.
   *
   * Lists Watson Knowledge Studio [custom entities and relations
   * models]
   * (https://cloud.ibm.com/docs/services/natural-language-understanding
   * ?topic=natural-language-understanding-customizing)
   * that are deployed to your Natural Language Understanding service.
   *
   * @return a {@link ServiceCall} with a response type of {@link ListModelsResults}
   */
  public ServiceCall<ListModelsResults> listModels() {
    return listModels(null);
  }

  /**
   * Delete model.
   *
   * Deletes a custom model.
   *
   * @param deleteModelOptions the {@link DeleteModelOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link DeleteModelResults}
   */
  public ServiceCall<DeleteModelResults> deleteModel(DeleteModelOptions deleteModelOptions) {
    Validator.notNull(deleteModelOptions, "deleteModelOptions cannot be null");
    String[] pathSegments = { "v1/models" };
    String[] pathParameters = { deleteModelOptions.modelId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("natural-language-understanding", "v1", "deleteModel");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<DeleteModelResults> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<DeleteModelResults>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}

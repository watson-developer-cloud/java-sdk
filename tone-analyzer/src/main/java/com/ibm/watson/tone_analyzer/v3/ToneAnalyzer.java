/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.tone_analyzer.v3;

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
import com.ibm.watson.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.tone_analyzer.v3.model.ToneChatOptions;
import com.ibm.watson.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.tone_analyzer.v3.model.UtteranceAnalyses;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The IBM Watson&trade; Tone Analyzer service uses linguistic analysis to detect emotional and language tones in
 * written text. The service can analyze tone at both the document and sentence levels. You can use the service to
 * understand how your written communications are perceived and then to improve the tone of your communications.
 * Businesses can use the service to learn the tone of their customers' communications and to respond to each customer
 * appropriately, or to understand and improve their customer conversations.
 *
 * **Note:** Request logging is disabled for the Tone Analyzer service. Regardless of whether you set the
 * `X-Watson-Learning-Opt-Out` request header, the service does not log or retain data from requests and responses.
 *
 * @version v3
 * @see <a href="https://cloud.ibm.com/docs/tone-analyzer/">Tone Analyzer</a>
 */
public class ToneAnalyzer extends BaseService {

  private static final String DEFAULT_SERVICE_NAME = "tone_analyzer";

  private static final String DEFAULT_SERVICE_URL = "https://gateway.watsonplatform.net/tone-analyzer/api";

  private String versionDate;

/**
   * Constructs a new `ToneAnalyzer` client using the DEFAULT_SERVICE_NAME.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   */
  public ToneAnalyzer(String versionDate) {
    this(versionDate, DEFAULT_SERVICE_NAME, ConfigBasedAuthenticatorFactory.getAuthenticator(DEFAULT_SERVICE_NAME));
  }

  /**
   * Constructs a new `ToneAnalyzer` client with the DEFAULT_SERVICE_NAME
   * and the specified Authenticator.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param authenticator the Authenticator instance to be configured for this service
   */
  public ToneAnalyzer(String versionDate, Authenticator authenticator) {
    this(versionDate, DEFAULT_SERVICE_NAME, authenticator);
  }

  /**
   * Constructs a new `ToneAnalyzer` client with the specified serviceName.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param serviceName The name of the service to configure.
   */
  public ToneAnalyzer(String versionDate, String serviceName) {
    this(versionDate, serviceName, ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName));
  }

  /**
   * Constructs a new `ToneAnalyzer` client with the specified Authenticator
   * and serviceName.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *        calls from failing when the service introduces breaking changes.
   * @param serviceName The name of the service to configure.
   * @param authenticator the Authenticator instance to be configured for this service
   */
  public ToneAnalyzer(String versionDate, String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
    com.ibm.cloud.sdk.core.util.Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");
    this.versionDate = versionDate;
    this.configureService(serviceName);
  }

  /**
   * Analyze general tone.
   *
   * Use the general-purpose endpoint to analyze the tone of your input content. The service analyzes the content for
   * emotional and language tones. The method always analyzes the tone of the full document; by default, it also
   * analyzes the tone of each individual sentence of the content.
   *
   * You can submit no more than 128 KB of total input content and no more than 1000 individual sentences in JSON, plain
   * text, or HTML format. The service analyzes the first 1000 sentences for document-level analysis and only the first
   * 100 sentences for sentence-level analysis.
   *
   * Per the JSON specification, the default character encoding for JSON content is effectively always UTF-8; per the
   * HTTP specification, the default encoding for plain text and HTML is ISO-8859-1 (effectively, the ASCII character
   * set). When specifying a content type of plain text or HTML, include the `charset` parameter to indicate the
   * character encoding of the input text; for example: `Content-Type: text/plain;charset=utf-8`. For `text/html`, the
   * service removes HTML tags and analyzes only the textual content.
   *
   * **See also:** [Using the general-purpose
   * endpoint](https://cloud.ibm.com/docs/tone-analyzer?topic=tone-analyzer-utgpe#utgpe).
   *
   * @param toneOptions the {@link ToneOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ToneAnalysis}
   */
  public ServiceCall<ToneAnalysis> tone(ToneOptions toneOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(toneOptions,
      "toneOptions cannot be null");
    String[] pathSegments = { "v3/tone" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("tone_analyzer", "v3", "tone");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (toneOptions.contentType() != null) {
      builder.header("Content-Type", toneOptions.contentType());
    }
    if (toneOptions.contentLanguage() != null) {
      builder.header("Content-Language", toneOptions.contentLanguage());
    }
    if (toneOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", toneOptions.acceptLanguage());
    }
    if (toneOptions.sentences() != null) {
      builder.query("sentences", String.valueOf(toneOptions.sentences()));
    }
    if (toneOptions.tones() != null) {
      builder.query("tones", RequestUtils.join(toneOptions.tones(), ","));
    }
    builder.bodyContent(toneOptions.contentType(), toneOptions.toneInput(),
      null, toneOptions.body());
    ResponseConverter<ToneAnalysis> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ToneAnalysis>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Analyze customer-engagement tone.
   *
   * Use the customer-engagement endpoint to analyze the tone of customer service and customer support conversations.
   * For each utterance of a conversation, the method reports the most prevalent subset of the following seven tones:
   * sad, frustrated, satisfied, excited, polite, impolite, and sympathetic.
   *
   * If you submit more than 50 utterances, the service returns a warning for the overall content and analyzes only the
   * first 50 utterances. If you submit a single utterance that contains more than 500 characters, the service returns
   * an error for that utterance and does not analyze the utterance. The request fails if all utterances have more than
   * 500 characters. Per the JSON specification, the default character encoding for JSON content is effectively always
   * UTF-8.
   *
   * **See also:** [Using the customer-engagement
   * endpoint](https://cloud.ibm.com/docs/tone-analyzer?topic=tone-analyzer-utco#utco).
   *
   * @param toneChatOptions the {@link ToneChatOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link UtteranceAnalyses}
   */
  public ServiceCall<UtteranceAnalyses> toneChat(ToneChatOptions toneChatOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(toneChatOptions,
      "toneChatOptions cannot be null");
    String[] pathSegments = { "v3/tone_chat" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("tone_analyzer", "v3", "toneChat");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (toneChatOptions.contentLanguage() != null) {
      builder.header("Content-Language", toneChatOptions.contentLanguage());
    }
    if (toneChatOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", toneChatOptions.acceptLanguage());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("utterances", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(toneChatOptions.utterances()));
    builder.bodyJson(contentJson);
    ResponseConverter<UtteranceAnalyses> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<UtteranceAnalyses>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}

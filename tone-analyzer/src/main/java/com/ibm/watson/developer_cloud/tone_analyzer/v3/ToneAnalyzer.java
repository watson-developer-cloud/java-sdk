/*
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
package com.ibm.watson.developer_cloud.tone_analyzer.v3;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneChatOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.UtteranceAnalyses;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.RequestUtils;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The IBM Watson Tone Analyzer service uses linguistic analysis to detect emotional, social, and language tones in
 * written text. The service can analyze tone at both the document and sentence levels. You can use the service to
 * understand how your written communications are perceived and then to improve the tone of your communications.
 * Businesses can use the service to learn the tone of their customers' communications and to respond to each customer
 * appropriately, or to understand and improve their customer conversations.
 *
 * @version v3
 * @see <a href="http://www.ibm.com/watson/developercloud/tone-analyzer.html">Tone Analyzer</a>
 */
public class ToneAnalyzer extends WatsonService {

  private static final String SERVICE_NAME = "tone_analyzer";
  private static final String URL = "https://gateway.watsonplatform.net/tone-analyzer/api";

  private String versionDate;

  /**
   * Instantiates a new {@link ToneAnalyzer} service.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *        calls from failing when the service introduces breaking changes.
   */
  public ToneAnalyzer(String versionDate) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "'version cannot be null.");

    this.versionDate = versionDate;
  }

  /**
   * Instantiates a new {@link ToneAnalyzer} with username and password.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *        calls from failing when the service introduces breaking changes.
   * @param username the username
   * @param password the password
   */
  public ToneAnalyzer(String versionDate, String username, String password) {
    this(versionDate);
    setUsernameAndPassword(username, password);
  }

  /**
   * Analyze general purpose tone.
   *
   * Uses the general purpose endpoint to analyze the tone of your input content. The service can analyze the input for
   * several tones: emotion, language, and social. It derives various characteristics for each tone that it analyzes.
   *
   * @param toneOptions the {@link ToneOptions} containing the options for the call
   * @return the {@link ToneAnalysis} with the response
   */
  public ServiceCall<ToneAnalysis> tone(ToneOptions toneOptions) {
    Validator.notNull(toneOptions, "toneOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post("/v3/tone");
    builder.query(VERSION, versionDate);
    builder.header("content-type", toneOptions.contentType());
    if (toneOptions.tones() != null) {
      builder.query("tones", RequestUtils.join(toneOptions.tones(), ","));
    }
    if (toneOptions.sentences() != null) {
      builder.query("sentences", String.valueOf(toneOptions.sentences()));
    }
    if (toneOptions.contentType().equalsIgnoreCase(ToneOptions.ContentType.APPLICATION_JSON)) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(toneOptions.toneInput()).getAsJsonObject());
    } else {
      builder.bodyContent(toneOptions.body(), toneOptions.contentType());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ToneAnalysis.class));
  }

  /**
   * Analyze customer engagement tone.
   *
   * Uses the customer engagement endpoint to analyze the tone of customer service and customer support conversations.
   * For each utterance of a conversation, the method reports the most prevalent subset of the following seven tones:
   * sad, frustrated, satisfied, excited, polite, impolite, and sympathetic. You can submit a maximum of 128 KB of JSON
   * input. Per the JSON specification, the default character encoding for JSON content is effectively always UTF-8.<br>
   * <b>Note:</b> The {@link ToneAnalyzer#toneChat(ToneChatOptions)} method is currently beta functionality.
   *
   * @param toneChatOptions the {@link ToneChatOptions} containing the options for the call
   * @return the {@link UtteranceAnalyses} with the response
   */
  public ServiceCall<UtteranceAnalyses> toneChat(ToneChatOptions toneChatOptions) {
    Validator.notNull(toneChatOptions, "toneChatOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post("/v3/tone_chat");
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    contentJson.add("utterances", GsonSingleton.getGson().toJsonTree(toneChatOptions.utterances()));
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(UtteranceAnalyses.class));
  }

}

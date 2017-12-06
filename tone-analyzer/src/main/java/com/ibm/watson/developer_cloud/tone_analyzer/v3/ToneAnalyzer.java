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

import com.ibm.watson.developer_cloud.util.RequestUtils;
import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneChatOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.UtteranceAnalyses;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * ### Service Overview
 * The IBM Watson Tone Analyzer service uses linguistic analysis to detect emotional and language tones in written text.
 * The service can analyze tone at both the document and sentence levels. You can use the service to understand how your
 * written communications are perceived and then to improve the tone of your communications. Businesses can use the
 * service to learn the tone of their customers' communications and to respond to each customer appropriately, or to
 * understand and improve their customer conversations.
 * ### API Usage
 * The following information provides details about using the service to analyze tone:
 * * **The tone method:** The service offers `GET` and `POST /v3/tone` methods that use the general purpose endpoint to
 * analyze the tone of input content. The methods accept content in JSON, plain text, or HTML format.
 * * **The tone_chat method:** The service offers a `POST /v3/tone_chat` method that uses the customer engagement
 * endpoint to analyze the tone of customer service and customer support conversations. The method accepts content in
 * JSON format.
 * * **Authentication:** You authenticate to the service by using your service credentials. You can use your credentials
 * to authenticate via a proxy server that resides in IBM Cloud, or you can use your credentials to obtain a token and
 * contact the service directly. See [Service credentials for Watson
 * services](https://console.bluemix.net/docs/services/watson/getting-started-credentials.html) and [Tokens for
 * authentication](https://console.bluemix.net/docs/services/watson/getting-started-tokens.html).
 * * **Request Logging:** By default, all Watson services log requests and their results. Data is collected only to
 * improve the Watson services. If you do not want to share your data, set the header parameter
 * `X-Watson-Learning-Opt-Out` to `true` for each request. Data is collected for any request that omits this header. See
 * [Controlling request logging for Watson
 * services](https://console.bluemix.net/docs/services/watson/getting-started-logging.html).
 *
 * For more information about the service, see [About Tone
 * Analyzer](https://console.bluemix.net/docs/services/tone-analyzer/index.html).
 *
 * **Note:** Method descriptions apply to the latest version of the interface, `2017-09-21`. Where necessary, parameters
 * and models describe differences between versions `2017-09-21` and `2016-05-19`.
 *
 * @version v3
 * @see <a href="http://www.ibm.com/watson/developercloud/tone-analyzer.html">Tone Analyzer</a>
 */
public class ToneAnalyzer extends WatsonService {

  private static final String SERVICE_NAME = "tone_analyzer";
  private static final String URL = "https://gateway.watsonplatform.net/tone-analyzer/api";

  private String versionDate;

  /**
   * Instantiates a new `ToneAnalyzer`.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   */
  public ToneAnalyzer(String versionDate) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(),
        "'version cannot be null.");

    this.versionDate = versionDate;
  }

  /**
   * Instantiates a new `ToneAnalyzer` with username and password.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
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
   * Uses the general purpose endpoint to analyze the tone of your input content. The service analyzes the content for
   * emotional and language tones. The method always analyzes the tone of the full document; by default, it also
   * analyzes the tone of each individual sentence of the content. You can submit no more than 128 KB of total input
   * content and no more than 1000 individual sentences in JSON, plain text, or HTML format. The service analyzes the
   * first 1000 sentences for document-level analysis and only the first 100 sentences for sentence-level analysis. Use
   * the `POST` request method to analyze larger amounts of content in any of the available formats. Use the `GET`
   * request method to analyze smaller quantities of plain text content. Per the JSON specification, the default
   * character encoding for JSON content is effectively always UTF-8; per the HTTP specification, the default encoding
   * for plain text and HTML is ISO-8859-1 (effectively, the ASCII character set). When specifying a content type of
   * plain text or HTML, include the `charset` parameter to indicate the character encoding of the input text; for
   * example: `Content-Type: text/plain;charset=utf-8`. For `text/html`, the service removes HTML tags and analyzes only
   * the textual content.
   *
   * @param toneOptions the {@link ToneOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ToneAnalysis}
   */
  public ServiceCall<ToneAnalysis> tone(ToneOptions toneOptions) {
    Validator.notNull(toneOptions, "toneOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post("/v3/tone");
    builder.query(VERSION, versionDate);
    builder.header("Content-Type", toneOptions.contentType());
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
   * Use the customer engagement endpoint to analyze the tone of customer service and customer support conversations.
   * For each utterance of a conversation, the method reports the most prevalent subset of the following seven tones:
   * sad, frustrated, satisfied, excited, polite, impolite, and sympathetic. If you submit more than 50 utterances, the
   * service returns a warning for the overall content and analyzes only the first 50 utterances. If you submit a single
   * utterance that contains more than 500 characters, the service returns an error for that utterance and does not
   * analyze the utterance. The request fails if all utterances have more than 500 characters. Per the JSON
   * specification, the default character encoding for JSON content is effectively always UTF-8.
   *
   * @param toneChatOptions the {@link ToneChatOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link UtteranceAnalyses}
   */
  public ServiceCall<UtteranceAnalyses> toneChat(ToneChatOptions toneChatOptions) {
    Validator.notNull(toneChatOptions, "toneChatOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post("/v3/tone_chat");
    builder.query(VERSION, versionDate);
    if (toneChatOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", toneChatOptions.acceptLanguage());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("utterances", GsonSingleton.getGson().toJsonTree(toneChatOptions.utterances()));
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(UtteranceAnalyses.class));
  }

}

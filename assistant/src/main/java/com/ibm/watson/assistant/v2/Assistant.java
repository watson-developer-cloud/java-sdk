/*
 * (C) Copyright IBM Corp. 2019.
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
package com.ibm.watson.assistant.v2;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.DeleteSessionOptions;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageResponse;
import com.ibm.watson.assistant.v2.model.SessionResponse;
import com.ibm.watson.common.SdkCommon;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The IBM Watson&trade; Assistant service combines machine learning, natural language understanding, and an integrated
 * dialog editor to create conversation flows between your apps and your users.
 *
 * The Assistant v2 API provides runtime methods your client application can use to send user input to an assistant and
 * receive a response.
 *
 * @version v2
 * @see <a href="https://cloud.ibm.com/docs/services/assistant/">Assistant</a>
 */
public class Assistant extends BaseService {

  private static final String SERVICE_NAME = "assistant";
  private static final String SERVICE_URL = "https://gateway.watsonplatform.net/assistant/api";

  private String versionDate;

  /**
   * Constructs a new `Assistant` client.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   */
  public Assistant(String versionDate) {
    this(versionDate, ConfigBasedAuthenticatorFactory.getAuthenticator(SERVICE_NAME));
  }

  /**
   * Constructs a new `Assistant` client with the specified Authenticator.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param authenticator the Authenticator instance to be configured for this service
   */
  public Assistant(String versionDate, Authenticator authenticator) {
    super(SERVICE_NAME, authenticator);
    if ((getServiceUrl() == null) || getServiceUrl().isEmpty()) {
      setServiceUrl(SERVICE_URL);
    }
    com.ibm.cloud.sdk.core.util.Validator.isTrue((versionDate != null) && !versionDate.isEmpty(),
        "version cannot be null.");
    this.versionDate = versionDate;
  }

  /**
   * Create a session.
   *
   * Create a new session. A session is used to send user input to a skill and receive responses. It also maintains the
   * state of the conversation.
   *
   * @param createSessionOptions the {@link CreateSessionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link SessionResponse}
   */
  public ServiceCall<SessionResponse> createSession(CreateSessionOptions createSessionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createSessionOptions,
        "createSessionOptions cannot be null");
    String[] pathSegments = { "v2/assistants", "sessions" };
    String[] pathParameters = { createSessionOptions.assistantId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "createSession");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<SessionResponse> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<SessionResponse>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete session.
   *
   * Deletes a session explicitly before it times out.
   *
   * @param deleteSessionOptions the {@link DeleteSessionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteSession(DeleteSessionOptions deleteSessionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteSessionOptions,
        "deleteSessionOptions cannot be null");
    String[] pathSegments = { "v2/assistants", "sessions" };
    String[] pathParameters = { deleteSessionOptions.assistantId(), deleteSessionOptions.sessionId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "deleteSession");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Send user input to assistant.
   *
   * Send user input to an assistant and receive a response.
   *
   * There is no rate limit for this operation.
   *
   * @param messageOptions the {@link MessageOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link MessageResponse}
   */
  public ServiceCall<MessageResponse> message(MessageOptions messageOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(messageOptions,
        "messageOptions cannot be null");
    String[] pathSegments = { "v2/assistants", "sessions", "message" };
    String[] pathParameters = { messageOptions.assistantId(), messageOptions.sessionId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "message");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (messageOptions.input() != null) {
      contentJson.add("input", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(messageOptions.input()));
    }
    if (messageOptions.context() != null) {
      contentJson.add("context", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(messageOptions
          .context()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<MessageResponse> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<MessageResponse>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}

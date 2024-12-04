/*
 * (C) Copyright IBM Corp. 2019, 2024.
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
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-77cc8190-20241107-152357
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
import com.ibm.watson.assistant.v2.model.AssistantCollection;
import com.ibm.watson.assistant.v2.model.AssistantData;
import com.ibm.watson.assistant.v2.model.BulkClassifyOptions;
import com.ibm.watson.assistant.v2.model.BulkClassifyResponse;
import com.ibm.watson.assistant.v2.model.CreateAssistantOptions;
import com.ibm.watson.assistant.v2.model.CreateAssistantReleaseImportResponse;
import com.ibm.watson.assistant.v2.model.CreateProviderOptions;
import com.ibm.watson.assistant.v2.model.CreateReleaseExportOptions;
import com.ibm.watson.assistant.v2.model.CreateReleaseExportWithStatusErrors;
import com.ibm.watson.assistant.v2.model.CreateReleaseImportOptions;
import com.ibm.watson.assistant.v2.model.CreateReleaseOptions;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.DeleteAssistantOptions;
import com.ibm.watson.assistant.v2.model.DeleteReleaseOptions;
import com.ibm.watson.assistant.v2.model.DeleteSessionOptions;
import com.ibm.watson.assistant.v2.model.DeleteUserDataOptions;
import com.ibm.watson.assistant.v2.model.DeployReleaseOptions;
import com.ibm.watson.assistant.v2.model.DownloadReleaseExportOptions;
import com.ibm.watson.assistant.v2.model.Environment;
import com.ibm.watson.assistant.v2.model.EnvironmentCollection;
import com.ibm.watson.assistant.v2.model.ExportSkillsOptions;
import com.ibm.watson.assistant.v2.model.GetEnvironmentOptions;
import com.ibm.watson.assistant.v2.model.GetReleaseImportStatusOptions;
import com.ibm.watson.assistant.v2.model.GetReleaseOptions;
import com.ibm.watson.assistant.v2.model.GetSkillOptions;
import com.ibm.watson.assistant.v2.model.ImportSkillsOptions;
import com.ibm.watson.assistant.v2.model.ImportSkillsStatusOptions;
import com.ibm.watson.assistant.v2.model.ListAssistantsOptions;
import com.ibm.watson.assistant.v2.model.ListEnvironmentsOptions;
import com.ibm.watson.assistant.v2.model.ListLogsOptions;
import com.ibm.watson.assistant.v2.model.ListProvidersOptions;
import com.ibm.watson.assistant.v2.model.ListReleasesOptions;
import com.ibm.watson.assistant.v2.model.LogCollection;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageStatelessOptions;
import com.ibm.watson.assistant.v2.model.MessageStreamOptions;
import com.ibm.watson.assistant.v2.model.MessageStreamStatelessOptions;
import com.ibm.watson.assistant.v2.model.MonitorAssistantReleaseImportArtifactResponse;
import com.ibm.watson.assistant.v2.model.ProviderCollection;
import com.ibm.watson.assistant.v2.model.ProviderResponse;
import com.ibm.watson.assistant.v2.model.Release;
import com.ibm.watson.assistant.v2.model.ReleaseCollection;
import com.ibm.watson.assistant.v2.model.SessionResponse;
import com.ibm.watson.assistant.v2.model.Skill;
import com.ibm.watson.assistant.v2.model.SkillsAsyncRequestStatus;
import com.ibm.watson.assistant.v2.model.SkillsExport;
import com.ibm.watson.assistant.v2.model.StatefulMessageResponse;
import com.ibm.watson.assistant.v2.model.StatelessMessageResponse;
import com.ibm.watson.assistant.v2.model.UpdateEnvironmentOptions;
import com.ibm.watson.assistant.v2.model.UpdateProviderOptions;
import com.ibm.watson.assistant.v2.model.UpdateSkillOptions;
import com.ibm.watson.common.SdkCommon;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The IBM&amp;reg; watsonx&amp;trade; Assistant service combines machine learning, natural language
 * understanding, and an integrated dialog editor to create conversation flows between your apps and
 * your users.
 *
 * <p>The Assistant v2 API provides runtime methods your client application can use to send user
 * input to an assistant and receive a response.
 *
 * <p>You need a paid Plus plan or higher to use the watsonx Assistant v2 API.
 *
 * <p>API Version: 2.0 See: https://cloud.ibm.com/docs/assistant
 */
public class Assistant extends BaseService {

  /** Default service name used when configuring the `Assistant` client. */
  public static final String DEFAULT_SERVICE_NAME = "assistant";

  /** Default service endpoint URL. */
  public static final String DEFAULT_SERVICE_URL =
      "https://api.us-south.assistant.watson.cloud.ibm.com";

  private String version;

  /**
   * Constructs an instance of the `Assistant` client. The default service name is used to configure
   * the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2023-06-15`.
   */
  public Assistant(String version) {
    this(
        version,
        DEFAULT_SERVICE_NAME,
        ConfigBasedAuthenticatorFactory.getAuthenticator(DEFAULT_SERVICE_NAME));
  }

  /**
   * Constructs an instance of the `Assistant` client. The default service name and specified
   * authenticator are used to configure the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2023-06-15`.
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public Assistant(String version, Authenticator authenticator) {
    this(version, DEFAULT_SERVICE_NAME, authenticator);
  }

  /**
   * Constructs an instance of the `Assistant` client. The specified service name is used to
   * configure the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2023-06-15`.
   * @param serviceName the service name to be used when configuring the client instance
   */
  public Assistant(String version, String serviceName) {
    this(version, serviceName, ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName));
  }

  /**
   * Constructs an instance of the `Assistant` client. The specified service name and authenticator
   * are used to configure the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2023-06-15`.
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public Assistant(String version, String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
    setVersion(version);
    this.configureService(serviceName);
  }

  /**
   * Gets the version.
   *
   * <p>Release date of the API version you want to use. Specify dates in YYYY-MM-DD format. The
   * current version is `2023-06-15`.
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
   * Create a conversational skill provider.
   *
   * <p>Create a new conversational skill provider.
   *
   * @param createProviderOptions the {@link CreateProviderOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link ProviderResponse}
   */
  public ServiceCall<ProviderResponse> createProvider(CreateProviderOptions createProviderOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createProviderOptions, "createProviderOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/providers"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "createProvider");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("provider_id", createProviderOptions.providerId());
    contentJson.add(
        "specification",
        com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
            .toJsonTree(createProviderOptions.specification()));
    contentJson.add(
        "private",
        com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
            .toJsonTree(createProviderOptions.xPrivate()));
    builder.bodyJson(contentJson);
    ResponseConverter<ProviderResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ProviderResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List conversational skill providers.
   *
   * <p>List the conversational skill providers associated with a Watson Assistant service instance.
   *
   * @param listProvidersOptions the {@link ListProvidersOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link ProviderCollection}
   */
  public ServiceCall<ProviderCollection> listProviders(ListProvidersOptions listProvidersOptions) {
    if (listProvidersOptions == null) {
      listProvidersOptions = new ListProvidersOptions.Builder().build();
    }
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/providers"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "listProviders");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listProvidersOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listProvidersOptions.pageLimit()));
    }
    if (listProvidersOptions.includeCount() != null) {
      builder.query("include_count", String.valueOf(listProvidersOptions.includeCount()));
    }
    if (listProvidersOptions.sort() != null) {
      builder.query("sort", String.valueOf(listProvidersOptions.sort()));
    }
    if (listProvidersOptions.cursor() != null) {
      builder.query("cursor", String.valueOf(listProvidersOptions.cursor()));
    }
    if (listProvidersOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(listProvidersOptions.includeAudit()));
    }
    ResponseConverter<ProviderCollection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ProviderCollection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List conversational skill providers.
   *
   * <p>List the conversational skill providers associated with a Watson Assistant service instance.
   *
   * @return a {@link ServiceCall} with a result of type {@link ProviderCollection}
   */
  public ServiceCall<ProviderCollection> listProviders() {
    return listProviders(null);
  }

  /**
   * Update a conversational skill provider.
   *
   * <p>Update a new conversational skill provider.
   *
   * @param updateProviderOptions the {@link UpdateProviderOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link ProviderResponse}
   */
  public ServiceCall<ProviderResponse> updateProvider(UpdateProviderOptions updateProviderOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateProviderOptions, "updateProviderOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("provider_id", updateProviderOptions.providerId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/providers/{provider_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "updateProvider");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.add(
        "specification",
        com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
            .toJsonTree(updateProviderOptions.specification()));
    contentJson.add(
        "private",
        com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
            .toJsonTree(updateProviderOptions.xPrivate()));
    builder.bodyJson(contentJson);
    ResponseConverter<ProviderResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ProviderResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create an assistant.
   *
   * <p>Create a new assistant.
   *
   * @param createAssistantOptions the {@link CreateAssistantOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link AssistantData}
   */
  public ServiceCall<AssistantData> createAssistant(CreateAssistantOptions createAssistantOptions) {
    boolean skipBody = false;
    if (createAssistantOptions == null) {
      createAssistantOptions = new CreateAssistantOptions.Builder().build();
      skipBody = true;
    }
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/assistants"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "createAssistant");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (!skipBody) {
      final JsonObject contentJson = new JsonObject();
      if (createAssistantOptions.name() != null) {
        contentJson.addProperty("name", createAssistantOptions.name());
      }
      if (createAssistantOptions.description() != null) {
        contentJson.addProperty("description", createAssistantOptions.description());
      }
      if (createAssistantOptions.language() != null) {
        contentJson.addProperty("language", createAssistantOptions.language());
      }
      builder.bodyJson(contentJson);
    }
    ResponseConverter<AssistantData> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<AssistantData>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create an assistant.
   *
   * <p>Create a new assistant.
   *
   * @return a {@link ServiceCall} with a result of type {@link AssistantData}
   */
  public ServiceCall<AssistantData> createAssistant() {
    return createAssistant(null);
  }

  /**
   * List assistants.
   *
   * <p>List the assistants associated with a watsonx Assistant service instance.
   *
   * @param listAssistantsOptions the {@link ListAssistantsOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link AssistantCollection}
   */
  public ServiceCall<AssistantCollection> listAssistants(
      ListAssistantsOptions listAssistantsOptions) {
    if (listAssistantsOptions == null) {
      listAssistantsOptions = new ListAssistantsOptions.Builder().build();
    }
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/assistants"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "listAssistants");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listAssistantsOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listAssistantsOptions.pageLimit()));
    }
    if (listAssistantsOptions.includeCount() != null) {
      builder.query("include_count", String.valueOf(listAssistantsOptions.includeCount()));
    }
    if (listAssistantsOptions.sort() != null) {
      builder.query("sort", String.valueOf(listAssistantsOptions.sort()));
    }
    if (listAssistantsOptions.cursor() != null) {
      builder.query("cursor", String.valueOf(listAssistantsOptions.cursor()));
    }
    if (listAssistantsOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(listAssistantsOptions.includeAudit()));
    }
    ResponseConverter<AssistantCollection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<AssistantCollection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List assistants.
   *
   * <p>List the assistants associated with a watsonx Assistant service instance.
   *
   * @return a {@link ServiceCall} with a result of type {@link AssistantCollection}
   */
  public ServiceCall<AssistantCollection> listAssistants() {
    return listAssistants(null);
  }

  /**
   * Delete assistant.
   *
   * <p>Delete an assistant.
   *
   * @param deleteAssistantOptions the {@link DeleteAssistantOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteAssistant(DeleteAssistantOptions deleteAssistantOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteAssistantOptions, "deleteAssistantOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", deleteAssistantOptions.assistantId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/assistants/{assistant_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "deleteAssistant");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a session.
   *
   * <p>Create a new session. A session is used to send user input to a skill and receive responses.
   * It also maintains the state of the conversation. A session persists until it is deleted, or
   * until it times out because of inactivity. (For more information, see the
   * [documentation](https://cloud.ibm.com/docs/assistant?topic=assistant-assistant-settings).).
   *
   * @param createSessionOptions the {@link CreateSessionOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link SessionResponse}
   */
  public ServiceCall<SessionResponse> createSession(CreateSessionOptions createSessionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createSessionOptions, "createSessionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", createSessionOptions.assistantId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/assistants/{assistant_id}/sessions", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "createSession");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (createSessionOptions.analytics() != null) {
      contentJson.add(
          "analytics",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createSessionOptions.analytics()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<SessionResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<SessionResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete session.
   *
   * <p>Deletes a session explicitly before it times out. (For more information about the session
   * inactivity timeout, see the
   * [documentation](https://cloud.ibm.com/docs/assistant?topic=assistant-assistant-settings)).
   *
   * @param deleteSessionOptions the {@link DeleteSessionOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteSession(DeleteSessionOptions deleteSessionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteSessionOptions, "deleteSessionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", deleteSessionOptions.assistantId());
    pathParamsMap.put("session_id", deleteSessionOptions.sessionId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/assistants/{assistant_id}/sessions/{session_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "deleteSession");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Send user input to assistant (stateful).
   *
   * <p>Send user input to an assistant and receive a response, with conversation state (including
   * context data) stored by watsonx Assistant for the duration of the session.
   *
   * @param messageOptions the {@link MessageOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link StatefulMessageResponse}
   */
  public ServiceCall<StatefulMessageResponse> message(MessageOptions messageOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(messageOptions, "messageOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", messageOptions.assistantId());
    pathParamsMap.put("environment_id", messageOptions.environmentId());
    pathParamsMap.put("session_id", messageOptions.sessionId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/assistants/{assistant_id}/sessions/{session_id}/message",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "message");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (messageOptions.input() != null) {
      contentJson.add(
          "input",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(messageOptions.input()));
    }
    if (messageOptions.context() != null) {
      contentJson.add(
          "context",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(messageOptions.context()));
    }
    if (messageOptions.userId() != null) {
      contentJson.addProperty("user_id", messageOptions.userId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<StatefulMessageResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<StatefulMessageResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Send user input to assistant (stateless).
   *
   * <p>Send user input to an assistant and receive a response, with conversation state (including
   * context data) managed by your application.
   *
   * @param messageStatelessOptions the {@link MessageStatelessOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link StatelessMessageResponse}
   */
  public ServiceCall<StatelessMessageResponse> messageStateless(
      MessageStatelessOptions messageStatelessOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        messageStatelessOptions, "messageStatelessOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", messageStatelessOptions.assistantId());
    pathParamsMap.put("environment_id", messageStatelessOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/assistants/{assistant_id}/message", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "messageStateless");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (messageStatelessOptions.input() != null) {
      contentJson.add(
          "input",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(messageStatelessOptions.input()));
    }
    if (messageStatelessOptions.context() != null) {
      contentJson.add(
          "context",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(messageStatelessOptions.context()));
    }
    if (messageStatelessOptions.userId() != null) {
      contentJson.addProperty("user_id", messageStatelessOptions.userId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<StatelessMessageResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<StatelessMessageResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Send user input to assistant (stateful).
   *
   * <p>Send user input to an assistant and receive a streamed response, with conversation state
   * (including context data) stored by watsonx Assistant for the duration of the session.
   *
   * @param messageStreamOptions the {@link MessageStreamOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> messageStream(MessageStreamOptions messageStreamOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        messageStreamOptions, "messageStreamOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", messageStreamOptions.assistantId());
    pathParamsMap.put("environment_id", messageStreamOptions.environmentId());
    pathParamsMap.put("session_id", messageStreamOptions.sessionId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/assistants/{assistant_id}/environments/{environment_id}/sessions/{session_id}/message_stream",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "messageStream");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "text/event-stream");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (messageStreamOptions.input() != null) {
      contentJson.add(
          "input",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(messageStreamOptions.input()));
    }
    if (messageStreamOptions.context() != null) {
      contentJson.add(
          "context",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(messageStreamOptions.context()));
    }
    if (messageStreamOptions.userId() != null) {
      contentJson.addProperty("user_id", messageStreamOptions.userId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Send user input to assistant (stateless).
   *
   * <p>Send user input to an assistant and receive a response, with conversation state (including
   * context data) managed by your application.
   *
   * @param messageStreamStatelessOptions the {@link MessageStreamStatelessOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> messageStreamStateless(
      MessageStreamStatelessOptions messageStreamStatelessOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        messageStreamStatelessOptions, "messageStreamStatelessOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", messageStreamStatelessOptions.assistantId());
    pathParamsMap.put("environment_id", messageStreamStatelessOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/assistants/{assistant_id}/environments/{environment_id}/message_stream",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "messageStreamStateless");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "text/event-stream");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (messageStreamStatelessOptions.input() != null) {
      contentJson.add(
          "input",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(messageStreamStatelessOptions.input()));
    }
    if (messageStreamStatelessOptions.context() != null) {
      contentJson.add(
          "context",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(messageStreamStatelessOptions.context()));
    }
    if (messageStreamStatelessOptions.userId() != null) {
      contentJson.addProperty("user_id", messageStreamStatelessOptions.userId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Identify intents and entities in multiple user utterances.
   *
   * <p>Send multiple user inputs to a dialog skill in a single request and receive information
   * about the intents and entities recognized in each input. This method is useful for testing and
   * comparing the performance of different skills or skill versions.
   *
   * <p>This method is available only with Enterprise with Data Isolation plans.
   *
   * @param bulkClassifyOptions the {@link BulkClassifyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BulkClassifyResponse}
   */
  public ServiceCall<BulkClassifyResponse> bulkClassify(BulkClassifyOptions bulkClassifyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        bulkClassifyOptions, "bulkClassifyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("skill_id", bulkClassifyOptions.skillId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/skills/{skill_id}/workspace/bulk_classify", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "bulkClassify");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.add(
        "input",
        com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
            .toJsonTree(bulkClassifyOptions.input()));
    builder.bodyJson(contentJson);
    ResponseConverter<BulkClassifyResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<BulkClassifyResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List log events for an assistant.
   *
   * <p>List the events from the log of an assistant.
   *
   * <p>This method requires Manager access.
   *
   * <p>**Note:** If you use the **cursor** parameter to retrieve results one page at a time,
   * subsequent requests must be no more than 5 minutes apart. Any returned value for the **cursor**
   * parameter becomes invalid after 5 minutes. For more information about using pagination, see
   * [Pagination](#pagination).
   *
   * @param listLogsOptions the {@link ListLogsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link LogCollection}
   */
  public ServiceCall<LogCollection> listLogs(ListLogsOptions listLogsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listLogsOptions, "listLogsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", listLogsOptions.assistantId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/assistants/{assistant_id}/logs", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "listLogs");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listLogsOptions.sort() != null) {
      builder.query("sort", String.valueOf(listLogsOptions.sort()));
    }
    if (listLogsOptions.filter() != null) {
      builder.query("filter", String.valueOf(listLogsOptions.filter()));
    }
    if (listLogsOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listLogsOptions.pageLimit()));
    }
    if (listLogsOptions.cursor() != null) {
      builder.query("cursor", String.valueOf(listLogsOptions.cursor()));
    }
    ResponseConverter<LogCollection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<LogCollection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete labeled data.
   *
   * <p>Deletes all data associated with a specified customer ID. The method has no effect if no
   * data is associated with the customer ID.
   *
   * <p>You associate a customer ID with data by passing the `X-Watson-Metadata` header with a
   * request that passes data. For more information about personal data and customer IDs, see
   * [Information
   * security](https://cloud.ibm.com/docs/assistant?topic=assistant-information-security#information-security).
   *
   * <p>**Note:** This operation is intended only for deleting data associated with a single
   * specific customer, not for deleting data associated with multiple customers or for any other
   * purpose. For more information, see [Labeling and deleting data in watsonx
   * Assistant](https://cloud.ibm.com/docs/assistant?topic=assistant-information-security#information-security-gdpr-wa).
   *
   * @param deleteUserDataOptions the {@link DeleteUserDataOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteUserData(DeleteUserDataOptions deleteUserDataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteUserDataOptions, "deleteUserDataOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/user_data"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "deleteUserData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    builder.query("customer_id", String.valueOf(deleteUserDataOptions.customerId()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List environments.
   *
   * <p>List the environments associated with an assistant.
   *
   * @param listEnvironmentsOptions the {@link ListEnvironmentsOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link EnvironmentCollection}
   */
  public ServiceCall<EnvironmentCollection> listEnvironments(
      ListEnvironmentsOptions listEnvironmentsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listEnvironmentsOptions, "listEnvironmentsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", listEnvironmentsOptions.assistantId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/assistants/{assistant_id}/environments", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "listEnvironments");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listEnvironmentsOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listEnvironmentsOptions.pageLimit()));
    }
    if (listEnvironmentsOptions.includeCount() != null) {
      builder.query("include_count", String.valueOf(listEnvironmentsOptions.includeCount()));
    }
    if (listEnvironmentsOptions.sort() != null) {
      builder.query("sort", String.valueOf(listEnvironmentsOptions.sort()));
    }
    if (listEnvironmentsOptions.cursor() != null) {
      builder.query("cursor", String.valueOf(listEnvironmentsOptions.cursor()));
    }
    if (listEnvironmentsOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(listEnvironmentsOptions.includeAudit()));
    }
    ResponseConverter<EnvironmentCollection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<EnvironmentCollection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get environment.
   *
   * <p>Get information about an environment. For more information about environments, see
   * [Environments](https://cloud.ibm.com/docs/watson-assistant?topic=watson-assistant-publish-overview#environments).
   *
   * @param getEnvironmentOptions the {@link GetEnvironmentOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Environment}
   */
  public ServiceCall<Environment> getEnvironment(GetEnvironmentOptions getEnvironmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getEnvironmentOptions, "getEnvironmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", getEnvironmentOptions.assistantId());
    pathParamsMap.put("environment_id", getEnvironmentOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/assistants/{assistant_id}/environments/{environment_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "getEnvironment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getEnvironmentOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(getEnvironmentOptions.includeAudit()));
    }
    ResponseConverter<Environment> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Environment>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update environment.
   *
   * <p>Update an environment with new or modified data. For more information about environments,
   * see
   * [Environments](https://cloud.ibm.com/docs/watson-assistant?topic=watson-assistant-publish-overview#environments).
   *
   * @param updateEnvironmentOptions the {@link UpdateEnvironmentOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Environment}
   */
  public ServiceCall<Environment> updateEnvironment(
      UpdateEnvironmentOptions updateEnvironmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateEnvironmentOptions, "updateEnvironmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", updateEnvironmentOptions.assistantId());
    pathParamsMap.put("environment_id", updateEnvironmentOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/assistants/{assistant_id}/environments/{environment_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "updateEnvironment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (updateEnvironmentOptions.name() != null) {
      contentJson.addProperty("name", updateEnvironmentOptions.name());
    }
    if (updateEnvironmentOptions.description() != null) {
      contentJson.addProperty("description", updateEnvironmentOptions.description());
    }
    if (updateEnvironmentOptions.orchestration() != null) {
      contentJson.add(
          "orchestration",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateEnvironmentOptions.orchestration()));
    }
    if (updateEnvironmentOptions.sessionTimeout() != null) {
      contentJson.addProperty("session_timeout", updateEnvironmentOptions.sessionTimeout());
    }
    if (updateEnvironmentOptions.skillReferences() != null) {
      contentJson.add(
          "skill_references",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateEnvironmentOptions.skillReferences()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Environment> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Environment>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create release.
   *
   * <p>Create a new release using the current content of the dialog and action skills in the draft
   * environment. (In the watsonx Assistant user interface, a release is called a *version*.).
   *
   * @param createReleaseOptions the {@link CreateReleaseOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Release}
   */
  public ServiceCall<Release> createRelease(CreateReleaseOptions createReleaseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createReleaseOptions, "createReleaseOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", createReleaseOptions.assistantId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/assistants/{assistant_id}/releases", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "createRelease");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (createReleaseOptions.description() != null) {
      contentJson.addProperty("description", createReleaseOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Release> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Release>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List releases.
   *
   * <p>List the releases associated with an assistant. (In the watsonx Assistant user interface, a
   * release is called a *version*.).
   *
   * @param listReleasesOptions the {@link ListReleasesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ReleaseCollection}
   */
  public ServiceCall<ReleaseCollection> listReleases(ListReleasesOptions listReleasesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listReleasesOptions, "listReleasesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", listReleasesOptions.assistantId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/assistants/{assistant_id}/releases", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "listReleases");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listReleasesOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listReleasesOptions.pageLimit()));
    }
    if (listReleasesOptions.includeCount() != null) {
      builder.query("include_count", String.valueOf(listReleasesOptions.includeCount()));
    }
    if (listReleasesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listReleasesOptions.sort()));
    }
    if (listReleasesOptions.cursor() != null) {
      builder.query("cursor", String.valueOf(listReleasesOptions.cursor()));
    }
    if (listReleasesOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(listReleasesOptions.includeAudit()));
    }
    ResponseConverter<ReleaseCollection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ReleaseCollection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get release.
   *
   * <p>Get information about a release.
   *
   * <p>Release data is not available until publishing of the release completes. If publishing is
   * still in progress, you can continue to poll by calling the same request again and checking the
   * value of the **status** property. When processing has completed, the request returns the
   * release data.
   *
   * @param getReleaseOptions the {@link GetReleaseOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Release}
   */
  public ServiceCall<Release> getRelease(GetReleaseOptions getReleaseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getReleaseOptions, "getReleaseOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", getReleaseOptions.assistantId());
    pathParamsMap.put("release", getReleaseOptions.release());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/assistants/{assistant_id}/releases/{release}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "getRelease");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getReleaseOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(getReleaseOptions.includeAudit()));
    }
    ResponseConverter<Release> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Release>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete release.
   *
   * <p>Delete a release. (In the watsonx Assistant user interface, a release is called a
   * *version*.).
   *
   * @param deleteReleaseOptions the {@link DeleteReleaseOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteRelease(DeleteReleaseOptions deleteReleaseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteReleaseOptions, "deleteReleaseOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", deleteReleaseOptions.assistantId());
    pathParamsMap.put("release", deleteReleaseOptions.release());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/assistants/{assistant_id}/releases/{release}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "deleteRelease");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Deploy release.
   *
   * <p>Update the environment with the content of the release. All snapshots saved as part of the
   * release become active in the environment.
   *
   * @param deployReleaseOptions the {@link DeployReleaseOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Environment}
   */
  public ServiceCall<Environment> deployRelease(DeployReleaseOptions deployReleaseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deployReleaseOptions, "deployReleaseOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", deployReleaseOptions.assistantId());
    pathParamsMap.put("release", deployReleaseOptions.release());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/assistants/{assistant_id}/releases/{release}/deploy",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "deployRelease");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (deployReleaseOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(deployReleaseOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("environment_id", deployReleaseOptions.environmentId());
    builder.bodyJson(contentJson);
    ResponseConverter<Environment> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Environment>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create release export.
   *
   * <p>Initiate an asynchronous process which will create a downloadable Zip file artifact
   * (/package) for an assistant release. This artifact will contain Action and/or Dialog skills
   * that are part of the release. The Dialog skill will only be included in the event that
   * coexistence is enabled on the assistant. The expected workflow with the use of Release Export
   * endpoint is to first initiate the creation of the artifact with the POST endpoint and then poll
   * the GET endpoint to retrieve the artifact. Once the artifact has been created, it will last for
   * the duration (/scope) of the release.
   *
   * @param createReleaseExportOptions the {@link CreateReleaseExportOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link CreateReleaseExportWithStatusErrors}
   */
  public ServiceCall<CreateReleaseExportWithStatusErrors> createReleaseExport(
      CreateReleaseExportOptions createReleaseExportOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createReleaseExportOptions, "createReleaseExportOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", createReleaseExportOptions.assistantId());
    pathParamsMap.put("release", createReleaseExportOptions.release());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/assistants/{assistant_id}/releases/{release}/export",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "createReleaseExport");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (createReleaseExportOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(createReleaseExportOptions.includeAudit()));
    }
    ResponseConverter<CreateReleaseExportWithStatusErrors> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<
                CreateReleaseExportWithStatusErrors>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get release export.
   *
   * <p>A dual function endpoint to either retrieve the Zip file artifact that is associated with an
   * assistant release or, retrieve the status of the artifact's creation. It is assumed that the
   * artifact creation was already initiated prior to calling this endpoint. In the event that the
   * artifact is not yet created and ready for download, this endpoint can be used to poll the
   * system until the creation is completed or has failed. On the other hand, if the artifact is
   * created, this endpoint will return the Zip file artifact as an octet stream. Once the artifact
   * has been created, it will last for the duration (/scope) of the release. &lt;br /&gt;&lt;br
   * /&gt; When you will have downloaded the Zip file artifact, you have one of three ways to import
   * it into an assistant's draft environment. These are as follows. &lt;br
   * /&gt;&lt;ol&gt;&lt;li&gt;Import the zip package in Tooling via &lt;var&gt;"Assistant Settings"
   * -&gt; "Download/Upload files" -&gt; "Upload" -&gt; "Assistant
   * only"&lt;/var&gt;.&lt;/li&gt;&lt;li&gt;Import the zip package via "Create release import"
   * endpoint using the APIs.&lt;/li&gt;&lt;li&gt;Extract the contents of the Zip file artifact and
   * individually import the skill JSONs via skill update endpoints.&lt;/li&gt;&lt;/ol&gt;.
   *
   * @param downloadReleaseExportOptions the {@link DownloadReleaseExportOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link CreateReleaseExportWithStatusErrors}
   */
  public ServiceCall<CreateReleaseExportWithStatusErrors> downloadReleaseExport(
      DownloadReleaseExportOptions downloadReleaseExportOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        downloadReleaseExportOptions, "downloadReleaseExportOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", downloadReleaseExportOptions.assistantId());
    pathParamsMap.put("release", downloadReleaseExportOptions.release());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/assistants/{assistant_id}/releases/{release}/export",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "downloadReleaseExport");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (downloadReleaseExportOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(downloadReleaseExportOptions.includeAudit()));
    }
    ResponseConverter<CreateReleaseExportWithStatusErrors> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<
                CreateReleaseExportWithStatusErrors>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get release export as stream.
   *
   * <p>A dual function endpoint to either retrieve the Zip file artifact that is associated with an
   * assistant release or, retrieve the status of the artifact's creation. It is assumed that the
   * artifact creation was already initiated prior to calling this endpoint. In the event that the
   * artifact is not yet created and ready for download, this endpoint can be used to poll the
   * system until the creation is completed or has failed. On the other hand, if the artifact is
   * created, this endpoint will return the Zip file artifact as an octet stream. Once the artifact
   * has been created, it will last for the duration (/scope) of the release. &lt;br /&gt;&lt;br
   * /&gt; When you will have downloaded the Zip file artifact, you have one of three ways to import
   * it into an assistant's draft environment. These are as follows. &lt;br
   * /&gt;&lt;ol&gt;&lt;li&gt;Import the zip package in Tooling via &lt;var&gt;"Assistant Settings"
   * -&gt; "Download/Upload files" -&gt; "Upload" -&gt; "Assistant
   * only"&lt;/var&gt;.&lt;/li&gt;&lt;li&gt;Import the zip package via "Create release import"
   * endpoint using the APIs.&lt;/li&gt;&lt;li&gt;Extract the contents of the Zip file artifact and
   * individually import the skill JSONs via skill update endpoints.&lt;/li&gt;&lt;/ol&gt;.
   *
   * @param downloadReleaseExportOptions the {@link DownloadReleaseExportOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> downloadReleaseExportAsStream(
      DownloadReleaseExportOptions downloadReleaseExportOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        downloadReleaseExportOptions, "downloadReleaseExportOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", downloadReleaseExportOptions.assistantId());
    pathParamsMap.put("release", downloadReleaseExportOptions.release());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/assistants/{assistant_id}/releases/{release}/export",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "downloadReleaseExportAsStream");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/octet-stream");
    builder.query("version", String.valueOf(this.version));
    if (downloadReleaseExportOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(downloadReleaseExportOptions.includeAudit()));
    }
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create release import.
   *
   * <p>Import a previously exported assistant release Zip file artifact (/package) into an
   * assistant. This endpoint creates (/initiates) an asynchronous task (/job) in the background
   * which will import the artifact contents into the draft environment of the assistant on which
   * this endpoint is called. Specifically, the asynchronous operation will override the action
   * and/or dialog skills in the assistant. It will be worth noting that when the artifact that is
   * provided to this endpoint is from an assistant release which has coexistence enabled (i.e., it
   * has both action and dialog skills), the import process will automatically enable coexistence,
   * if not already enabled, on the assistant into which said artifact is being uploaded to. On the
   * other hand, if the artifact package being imported only has action skill in it, the import
   * asynchronous process will only override the draft environment's action skill, regardless of
   * whether coexistence is enabled on the assistant into which the package is being imported.
   * Lastly, the system will only run one asynchronous import at a time on an assistant. As such,
   * consecutive imports will override previous import's updates to the skills in the draft
   * environment. Once created, you may poll the completion of the import via the "Get release
   * import Status" endpoint.
   *
   * @param createReleaseImportOptions the {@link CreateReleaseImportOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link
   *     CreateAssistantReleaseImportResponse}
   */
  public ServiceCall<CreateAssistantReleaseImportResponse> createReleaseImport(
      CreateReleaseImportOptions createReleaseImportOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createReleaseImportOptions, "createReleaseImportOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", createReleaseImportOptions.assistantId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/assistants/{assistant_id}/import", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "createReleaseImport");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (createReleaseImportOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(createReleaseImportOptions.includeAudit()));
    }
    builder.bodyContent(createReleaseImportOptions.body(), "application/octet-stream");
    ResponseConverter<CreateAssistantReleaseImportResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<
                CreateAssistantReleaseImportResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get release import Status.
   *
   * <p>Monitor the status of an assistant release import. You may poll this endpoint until the
   * status of the import has either succeeded or failed.
   *
   * @param getReleaseImportStatusOptions the {@link GetReleaseImportStatusOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link
   *     MonitorAssistantReleaseImportArtifactResponse}
   */
  public ServiceCall<MonitorAssistantReleaseImportArtifactResponse> getReleaseImportStatus(
      GetReleaseImportStatusOptions getReleaseImportStatusOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getReleaseImportStatusOptions, "getReleaseImportStatusOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", getReleaseImportStatusOptions.assistantId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/assistants/{assistant_id}/import", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "getReleaseImportStatus");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getReleaseImportStatusOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(getReleaseImportStatusOptions.includeAudit()));
    }
    ResponseConverter<MonitorAssistantReleaseImportArtifactResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<
                MonitorAssistantReleaseImportArtifactResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get skill.
   *
   * <p>Get information about a skill.
   *
   * @param getSkillOptions the {@link GetSkillOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Skill}
   */
  public ServiceCall<Skill> getSkill(GetSkillOptions getSkillOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getSkillOptions, "getSkillOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", getSkillOptions.assistantId());
    pathParamsMap.put("skill_id", getSkillOptions.skillId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/assistants/{assistant_id}/skills/{skill_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "getSkill");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Skill> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Skill>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update skill.
   *
   * <p>Update a skill with new or modified data.
   *
   * <p>**Note:** The update is performed asynchronously; you can see the status of the update by
   * calling the **Get skill** method and checking the value of the **status** property.
   *
   * @param updateSkillOptions the {@link UpdateSkillOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Skill}
   */
  public ServiceCall<Skill> updateSkill(UpdateSkillOptions updateSkillOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateSkillOptions, "updateSkillOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", updateSkillOptions.assistantId());
    pathParamsMap.put("skill_id", updateSkillOptions.skillId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/assistants/{assistant_id}/skills/{skill_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "updateSkill");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (updateSkillOptions.name() != null) {
      contentJson.addProperty("name", updateSkillOptions.name());
    }
    if (updateSkillOptions.description() != null) {
      contentJson.addProperty("description", updateSkillOptions.description());
    }
    if (updateSkillOptions.workspace() != null) {
      contentJson.add(
          "workspace",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateSkillOptions.workspace()));
    }
    if (updateSkillOptions.dialogSettings() != null) {
      contentJson.add(
          "dialog_settings",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateSkillOptions.dialogSettings()));
    }
    if (updateSkillOptions.searchSettings() != null) {
      contentJson.add(
          "search_settings",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateSkillOptions.searchSettings()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Skill> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Skill>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Export skills.
   *
   * <p>Asynchronously export the action skill and dialog skill (if enabled) for the assistant. Use
   * this method to save all skill data so that you can import it to a different assistant using the
   * **Import skills** method.
   *
   * <p>A successful call to this method only initiates an asynchronous export. The exported JSON
   * data is not available until processing completes.
   *
   * <p>After the initial request is submitted, you can poll the status of the operation by calling
   * the same request again and checking the value of the **status** property. If an error occurs
   * (indicated by a **status** value of `Failed`), the `status_description` property provides more
   * information about the error, and the `status_errors` property contains an array of error
   * messages that caused the failure.
   *
   * <p>When processing has completed, the request returns the exported JSON data. Remember that the
   * usual rate limits apply.
   *
   * @param exportSkillsOptions the {@link ExportSkillsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SkillsExport}
   */
  public ServiceCall<SkillsExport> exportSkills(ExportSkillsOptions exportSkillsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        exportSkillsOptions, "exportSkillsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", exportSkillsOptions.assistantId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/assistants/{assistant_id}/skills_export", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "exportSkills");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (exportSkillsOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(exportSkillsOptions.includeAudit()));
    }
    ResponseConverter<SkillsExport> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<SkillsExport>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Import skills.
   *
   * <p>Asynchronously import skills into an existing assistant from a previously exported file.
   *
   * <p>The request body for this method should contain the response data that was received from a
   * previous call to the **Export skills** method, without modification.
   *
   * <p>A successful call to this method initiates an asynchronous import. The updated skills
   * belonging to the assistant are not available until processing completes. To check the status of
   * the asynchronous import operation, use the **Get status of skills import** method.
   *
   * @param importSkillsOptions the {@link ImportSkillsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SkillsAsyncRequestStatus}
   */
  public ServiceCall<SkillsAsyncRequestStatus> importSkills(
      ImportSkillsOptions importSkillsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        importSkillsOptions, "importSkillsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", importSkillsOptions.assistantId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/assistants/{assistant_id}/skills_import", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v2", "importSkills");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (importSkillsOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(importSkillsOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add(
        "assistant_skills",
        com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
            .toJsonTree(importSkillsOptions.assistantSkills()));
    contentJson.add(
        "assistant_state",
        com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
            .toJsonTree(importSkillsOptions.assistantState()));
    builder.bodyJson(contentJson);
    ResponseConverter<SkillsAsyncRequestStatus> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<SkillsAsyncRequestStatus>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get status of skills import.
   *
   * <p>Retrieve the status of an asynchronous import operation previously initiated by using the
   * **Import skills** method.
   *
   * @param importSkillsStatusOptions the {@link ImportSkillsStatusOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link SkillsAsyncRequestStatus}
   */
  public ServiceCall<SkillsAsyncRequestStatus> importSkillsStatus(
      ImportSkillsStatusOptions importSkillsStatusOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        importSkillsStatusOptions, "importSkillsStatusOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", importSkillsStatusOptions.assistantId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/assistants/{assistant_id}/skills_import/status",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v2", "importSkillsStatus");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<SkillsAsyncRequestStatus> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<SkillsAsyncRequestStatus>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }
}

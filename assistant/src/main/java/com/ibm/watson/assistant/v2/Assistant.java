/*
 * (C) Copyright IBM Corp. 2022.
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
 * IBM OpenAPI SDK Code Generator Version: 3.53.0-9710cac3-20220713-193508
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
import com.ibm.watson.assistant.v2.model.BulkClassifyOptions;
import com.ibm.watson.assistant.v2.model.BulkClassifyResponse;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.DeleteSessionOptions;
import com.ibm.watson.assistant.v2.model.DeleteUserDataOptions;
import com.ibm.watson.assistant.v2.model.DeployReleaseOptions;
import com.ibm.watson.assistant.v2.model.Environment;
import com.ibm.watson.assistant.v2.model.EnvironmentCollection;
import com.ibm.watson.assistant.v2.model.GetEnvironmentOptions;
import com.ibm.watson.assistant.v2.model.GetReleaseOptions;
import com.ibm.watson.assistant.v2.model.ListEnvironmentsOptions;
import com.ibm.watson.assistant.v2.model.ListLogsOptions;
import com.ibm.watson.assistant.v2.model.ListReleasesOptions;
import com.ibm.watson.assistant.v2.model.LogCollection;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageResponse;
import com.ibm.watson.assistant.v2.model.MessageResponseStateless;
import com.ibm.watson.assistant.v2.model.MessageStatelessOptions;
import com.ibm.watson.assistant.v2.model.Release;
import com.ibm.watson.assistant.v2.model.ReleaseCollection;
import com.ibm.watson.assistant.v2.model.SessionResponse;
import com.ibm.watson.common.SdkCommon;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The IBM Watson&amp;trade; Assistant service combines machine learning, natural language
 * understanding, and an integrated dialog editor to create conversation flows between your apps and
 * your users.
 *
 * <p>The Assistant v2 API provides runtime methods your client application can use to send user
 * input to an assistant and receive a response.
 *
 * <p>API Version: 2.0 See: https://cloud.ibm.com/docs/assistant
 */
public class Assistant extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "assistant";

  public static final String DEFAULT_SERVICE_URL =
      "https://api.us-south.assistant.watson.cloud.ibm.com";

  private String version;

  /**
   * Constructs an instance of the `Assistant` client. The default service name is used to configure
   * the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2021-11-27`.
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
   *     format. The current version is `2021-11-27`.
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
   *     format. The current version is `2021-11-27`.
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
   *     format. The current version is `2021-11-27`.
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
   * current version is `2021-11-27`.
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
   * Create a session.
   *
   * <p>Create a new session. A session is used to send user input to a skill and receive responses.
   * It also maintains the state of the conversation. A session persists until it is deleted, or
   * until it times out because of inactivity. (For more information, see the
   * [documentation](https://cloud.ibm.com/docs/assistant?topic=assistant-assistant-settings).
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
   * context data) stored by Watson Assistant for the duration of the session.
   *
   * @param messageOptions the {@link MessageOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link MessageResponse}
   */
  public ServiceCall<MessageResponse> message(MessageOptions messageOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(messageOptions, "messageOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", messageOptions.assistantId());
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
    ResponseConverter<MessageResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<MessageResponse>() {}.getType());
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
   * @return a {@link ServiceCall} with a result of type {@link MessageResponseStateless}
   */
  public ServiceCall<MessageResponseStateless> messageStateless(
      MessageStatelessOptions messageStatelessOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        messageStatelessOptions, "messageStatelessOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assistant_id", messageStatelessOptions.assistantId());
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
    ResponseConverter<MessageResponseStateless> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<MessageResponseStateless>() {}.getType());
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
   * <p>This method requires Manager access, and is available only with Enterprise plans.
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
   * purpose. For more information, see [Labeling and deleting data in Watson
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
   * List releases.
   *
   * <p>List the releases associated with an assistant. (In the Watson Assistant user interface, a
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
}

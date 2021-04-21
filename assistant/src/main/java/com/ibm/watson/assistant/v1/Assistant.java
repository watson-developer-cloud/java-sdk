/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-be3b4618-20201201-123423
 */

package com.ibm.watson.assistant.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.watson.assistant.v1.model.BulkClassifyOptions;
import com.ibm.watson.assistant.v1.model.BulkClassifyResponse;
import com.ibm.watson.assistant.v1.model.Counterexample;
import com.ibm.watson.assistant.v1.model.CounterexampleCollection;
import com.ibm.watson.assistant.v1.model.CreateCounterexampleOptions;
import com.ibm.watson.assistant.v1.model.CreateDialogNodeOptions;
import com.ibm.watson.assistant.v1.model.CreateEntityOptions;
import com.ibm.watson.assistant.v1.model.CreateExampleOptions;
import com.ibm.watson.assistant.v1.model.CreateIntentOptions;
import com.ibm.watson.assistant.v1.model.CreateSynonymOptions;
import com.ibm.watson.assistant.v1.model.CreateValueOptions;
import com.ibm.watson.assistant.v1.model.CreateWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.DeleteCounterexampleOptions;
import com.ibm.watson.assistant.v1.model.DeleteDialogNodeOptions;
import com.ibm.watson.assistant.v1.model.DeleteEntityOptions;
import com.ibm.watson.assistant.v1.model.DeleteExampleOptions;
import com.ibm.watson.assistant.v1.model.DeleteIntentOptions;
import com.ibm.watson.assistant.v1.model.DeleteSynonymOptions;
import com.ibm.watson.assistant.v1.model.DeleteUserDataOptions;
import com.ibm.watson.assistant.v1.model.DeleteValueOptions;
import com.ibm.watson.assistant.v1.model.DeleteWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.DialogNode;
import com.ibm.watson.assistant.v1.model.DialogNodeCollection;
import com.ibm.watson.assistant.v1.model.Entity;
import com.ibm.watson.assistant.v1.model.EntityCollection;
import com.ibm.watson.assistant.v1.model.EntityMentionCollection;
import com.ibm.watson.assistant.v1.model.Example;
import com.ibm.watson.assistant.v1.model.ExampleCollection;
import com.ibm.watson.assistant.v1.model.GetCounterexampleOptions;
import com.ibm.watson.assistant.v1.model.GetDialogNodeOptions;
import com.ibm.watson.assistant.v1.model.GetEntityOptions;
import com.ibm.watson.assistant.v1.model.GetExampleOptions;
import com.ibm.watson.assistant.v1.model.GetIntentOptions;
import com.ibm.watson.assistant.v1.model.GetSynonymOptions;
import com.ibm.watson.assistant.v1.model.GetValueOptions;
import com.ibm.watson.assistant.v1.model.GetWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.Intent;
import com.ibm.watson.assistant.v1.model.IntentCollection;
import com.ibm.watson.assistant.v1.model.ListAllLogsOptions;
import com.ibm.watson.assistant.v1.model.ListCounterexamplesOptions;
import com.ibm.watson.assistant.v1.model.ListDialogNodesOptions;
import com.ibm.watson.assistant.v1.model.ListEntitiesOptions;
import com.ibm.watson.assistant.v1.model.ListExamplesOptions;
import com.ibm.watson.assistant.v1.model.ListIntentsOptions;
import com.ibm.watson.assistant.v1.model.ListLogsOptions;
import com.ibm.watson.assistant.v1.model.ListMentionsOptions;
import com.ibm.watson.assistant.v1.model.ListSynonymsOptions;
import com.ibm.watson.assistant.v1.model.ListValuesOptions;
import com.ibm.watson.assistant.v1.model.ListWorkspacesOptions;
import com.ibm.watson.assistant.v1.model.LogCollection;
import com.ibm.watson.assistant.v1.model.MessageOptions;
import com.ibm.watson.assistant.v1.model.MessageResponse;
import com.ibm.watson.assistant.v1.model.Synonym;
import com.ibm.watson.assistant.v1.model.SynonymCollection;
import com.ibm.watson.assistant.v1.model.UpdateCounterexampleOptions;
import com.ibm.watson.assistant.v1.model.UpdateDialogNodeNullableOptions;
import com.ibm.watson.assistant.v1.model.UpdateDialogNodeOptions;
import com.ibm.watson.assistant.v1.model.UpdateEntityOptions;
import com.ibm.watson.assistant.v1.model.UpdateExampleOptions;
import com.ibm.watson.assistant.v1.model.UpdateIntentOptions;
import com.ibm.watson.assistant.v1.model.UpdateSynonymOptions;
import com.ibm.watson.assistant.v1.model.UpdateValueOptions;
import com.ibm.watson.assistant.v1.model.UpdateWorkspaceOptions;
import com.ibm.watson.assistant.v1.model.Value;
import com.ibm.watson.assistant.v1.model.ValueCollection;
import com.ibm.watson.assistant.v1.model.Workspace;
import com.ibm.watson.assistant.v1.model.WorkspaceCollection;
import com.ibm.watson.common.SdkCommon;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The IBM Watson&amp;trade; Assistant service combines machine learning, natural language
 * understanding, and an integrated dialog editor to create conversation flows between your apps and
 * your users.
 *
 * <p>The Assistant v1 API provides authoring methods your application can use to create or update a
 * workspace.
 *
 * @version v1
 * @see <a href="https://cloud.ibm.com/docs/assistant">Assistant</a>
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
   *     format. The current version is `2020-04-01`.
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
   *     format. The current version is `2020-04-01`.
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
   *     format. The current version is `2020-04-01`.
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
   *     format. The current version is `2020-04-01`.
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
   * current version is `2020-04-01`.
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
   * Get response to user input.
   *
   * <p>Send user input to a workspace and receive a response.
   *
   * <p>**Important:** This method has been superseded by the new v2 runtime API. The v2 API offers
   * significant advantages, including ease of deployment, automatic state management, versioning,
   * and search capabilities. For more information, see the
   * [documentation](https://cloud.ibm.com/docs/assistant?topic=assistant-api-overview).
   *
   * @param messageOptions the {@link MessageOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link MessageResponse}
   */
  public ServiceCall<MessageResponse> message(MessageOptions messageOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(messageOptions, "messageOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", messageOptions.workspaceId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/message", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "message");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (messageOptions.nodesVisitedDetails() != null) {
      builder.query("nodes_visited_details", String.valueOf(messageOptions.nodesVisitedDetails()));
    }
    final JsonObject contentJson = new JsonObject();
    if (messageOptions.input() != null) {
      contentJson.add(
          "input",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(messageOptions.input()));
    }
    if (messageOptions.intents() != null) {
      contentJson.add(
          "intents",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(messageOptions.intents()));
    }
    if (messageOptions.entities() != null) {
      contentJson.add(
          "entities",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(messageOptions.entities()));
    }
    if (messageOptions.alternateIntents() != null) {
      contentJson.addProperty("alternate_intents", messageOptions.alternateIntents());
    }
    if (messageOptions.context() != null) {
      contentJson.add(
          "context",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(messageOptions.context()));
    }
    if (messageOptions.output() != null) {
      contentJson.add(
          "output",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(messageOptions.output()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<MessageResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<MessageResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Identify intents and entities in multiple user utterances.
   *
   * <p>Send multiple user inputs to a workspace in a single request and receive information about
   * the intents and entities recognized in each input. This method is useful for testing and
   * comparing the performance of different workspaces.
   *
   * <p>This method is available only with Premium plans.
   *
   * @param bulkClassifyOptions the {@link BulkClassifyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BulkClassifyResponse}
   */
  public ServiceCall<BulkClassifyResponse> bulkClassify(BulkClassifyOptions bulkClassifyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        bulkClassifyOptions, "bulkClassifyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", bulkClassifyOptions.workspaceId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/bulk_classify", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "bulkClassify");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (bulkClassifyOptions.input() != null) {
      contentJson.add(
          "input",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(bulkClassifyOptions.input()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<BulkClassifyResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<BulkClassifyResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List workspaces.
   *
   * <p>List the workspaces associated with a Watson Assistant service instance.
   *
   * @param listWorkspacesOptions the {@link ListWorkspacesOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link WorkspaceCollection}
   */
  public ServiceCall<WorkspaceCollection> listWorkspaces(
      ListWorkspacesOptions listWorkspacesOptions) {
    if (listWorkspacesOptions == null) {
      listWorkspacesOptions = new ListWorkspacesOptions.Builder().build();
    }
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/workspaces"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v1", "listWorkspaces");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listWorkspacesOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listWorkspacesOptions.pageLimit()));
    }
    if (listWorkspacesOptions.includeCount() != null) {
      builder.query("include_count", String.valueOf(listWorkspacesOptions.includeCount()));
    }
    if (listWorkspacesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listWorkspacesOptions.sort()));
    }
    if (listWorkspacesOptions.cursor() != null) {
      builder.query("cursor", String.valueOf(listWorkspacesOptions.cursor()));
    }
    if (listWorkspacesOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(listWorkspacesOptions.includeAudit()));
    }
    ResponseConverter<WorkspaceCollection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<WorkspaceCollection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List workspaces.
   *
   * <p>List the workspaces associated with a Watson Assistant service instance.
   *
   * @return a {@link ServiceCall} with a result of type {@link WorkspaceCollection}
   */
  public ServiceCall<WorkspaceCollection> listWorkspaces() {
    return listWorkspaces(null);
  }

  /**
   * Create workspace.
   *
   * <p>Create a workspace based on component objects. You must provide workspace components
   * defining the content of the new workspace.
   *
   * @param createWorkspaceOptions the {@link CreateWorkspaceOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Workspace}
   */
  public ServiceCall<Workspace> createWorkspace(CreateWorkspaceOptions createWorkspaceOptions) {
    boolean skipBody = false;
    if (createWorkspaceOptions == null) {
      createWorkspaceOptions = new CreateWorkspaceOptions.Builder().build();
      skipBody = true;
    }
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/workspaces"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v1", "createWorkspace");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (createWorkspaceOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(createWorkspaceOptions.includeAudit()));
    }
    if (!skipBody) {
      final JsonObject contentJson = new JsonObject();
      if (createWorkspaceOptions.name() != null) {
        contentJson.addProperty("name", createWorkspaceOptions.name());
      }
      if (createWorkspaceOptions.description() != null) {
        contentJson.addProperty("description", createWorkspaceOptions.description());
      }
      if (createWorkspaceOptions.language() != null) {
        contentJson.addProperty("language", createWorkspaceOptions.language());
      }
      if (createWorkspaceOptions.dialogNodes() != null) {
        contentJson.add(
            "dialog_nodes",
            com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
                .toJsonTree(createWorkspaceOptions.dialogNodes()));
      }
      if (createWorkspaceOptions.counterexamples() != null) {
        contentJson.add(
            "counterexamples",
            com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
                .toJsonTree(createWorkspaceOptions.counterexamples()));
      }
      if (createWorkspaceOptions.metadata() != null) {
        contentJson.add(
            "metadata",
            com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
                .toJsonTree(createWorkspaceOptions.metadata()));
      }
      if (createWorkspaceOptions.learningOptOut() != null) {
        contentJson.addProperty("learning_opt_out", createWorkspaceOptions.learningOptOut());
      }
      if (createWorkspaceOptions.systemSettings() != null) {
        contentJson.add(
            "system_settings",
            com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
                .toJsonTree(createWorkspaceOptions.systemSettings()));
      }
      if (createWorkspaceOptions.webhooks() != null) {
        contentJson.add(
            "webhooks",
            com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
                .toJsonTree(createWorkspaceOptions.webhooks()));
      }
      if (createWorkspaceOptions.intents() != null) {
        contentJson.add(
            "intents",
            com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
                .toJsonTree(createWorkspaceOptions.intents()));
      }
      if (createWorkspaceOptions.entities() != null) {
        contentJson.add(
            "entities",
            com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
                .toJsonTree(createWorkspaceOptions.entities()));
      }
      builder.bodyJson(contentJson);
    }
    ResponseConverter<Workspace> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Workspace>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create workspace.
   *
   * <p>Create a workspace based on component objects. You must provide workspace components
   * defining the content of the new workspace.
   *
   * @return a {@link ServiceCall} with a result of type {@link Workspace}
   */
  public ServiceCall<Workspace> createWorkspace() {
    return createWorkspace(null);
  }

  /**
   * Get information about a workspace.
   *
   * <p>Get information about a workspace, optionally including all workspace content.
   *
   * @param getWorkspaceOptions the {@link GetWorkspaceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Workspace}
   */
  public ServiceCall<Workspace> getWorkspace(GetWorkspaceOptions getWorkspaceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getWorkspaceOptions, "getWorkspaceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", getWorkspaceOptions.workspaceId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "getWorkspace");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getWorkspaceOptions.export() != null) {
      builder.query("export", String.valueOf(getWorkspaceOptions.export()));
    }
    if (getWorkspaceOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(getWorkspaceOptions.includeAudit()));
    }
    if (getWorkspaceOptions.sort() != null) {
      builder.query("sort", String.valueOf(getWorkspaceOptions.sort()));
    }
    ResponseConverter<Workspace> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Workspace>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update workspace.
   *
   * <p>Update an existing workspace with new or modified data. You must provide component objects
   * defining the content of the updated workspace.
   *
   * @param updateWorkspaceOptions the {@link UpdateWorkspaceOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Workspace}
   */
  public ServiceCall<Workspace> updateWorkspace(UpdateWorkspaceOptions updateWorkspaceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateWorkspaceOptions, "updateWorkspaceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", updateWorkspaceOptions.workspaceId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v1", "updateWorkspace");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (updateWorkspaceOptions.append() != null) {
      builder.query("append", String.valueOf(updateWorkspaceOptions.append()));
    }
    if (updateWorkspaceOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(updateWorkspaceOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    if (updateWorkspaceOptions.name() != null) {
      contentJson.addProperty("name", updateWorkspaceOptions.name());
    }
    if (updateWorkspaceOptions.description() != null) {
      contentJson.addProperty("description", updateWorkspaceOptions.description());
    }
    if (updateWorkspaceOptions.language() != null) {
      contentJson.addProperty("language", updateWorkspaceOptions.language());
    }
    if (updateWorkspaceOptions.dialogNodes() != null) {
      contentJson.add(
          "dialog_nodes",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateWorkspaceOptions.dialogNodes()));
    }
    if (updateWorkspaceOptions.counterexamples() != null) {
      contentJson.add(
          "counterexamples",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateWorkspaceOptions.counterexamples()));
    }
    if (updateWorkspaceOptions.metadata() != null) {
      contentJson.add(
          "metadata",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateWorkspaceOptions.metadata()));
    }
    if (updateWorkspaceOptions.learningOptOut() != null) {
      contentJson.addProperty("learning_opt_out", updateWorkspaceOptions.learningOptOut());
    }
    if (updateWorkspaceOptions.systemSettings() != null) {
      contentJson.add(
          "system_settings",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateWorkspaceOptions.systemSettings()));
    }
    if (updateWorkspaceOptions.webhooks() != null) {
      contentJson.add(
          "webhooks",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateWorkspaceOptions.webhooks()));
    }
    if (updateWorkspaceOptions.intents() != null) {
      contentJson.add(
          "intents",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateWorkspaceOptions.intents()));
    }
    if (updateWorkspaceOptions.entities() != null) {
      contentJson.add(
          "entities",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateWorkspaceOptions.entities()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Workspace> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Workspace>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete workspace.
   *
   * <p>Delete a workspace from the service instance.
   *
   * @param deleteWorkspaceOptions the {@link DeleteWorkspaceOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteWorkspace(DeleteWorkspaceOptions deleteWorkspaceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteWorkspaceOptions, "deleteWorkspaceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", deleteWorkspaceOptions.workspaceId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v1", "deleteWorkspace");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List intents.
   *
   * <p>List the intents for a workspace.
   *
   * @param listIntentsOptions the {@link ListIntentsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link IntentCollection}
   */
  public ServiceCall<IntentCollection> listIntents(ListIntentsOptions listIntentsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listIntentsOptions, "listIntentsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", listIntentsOptions.workspaceId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/intents", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "listIntents");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listIntentsOptions.export() != null) {
      builder.query("export", String.valueOf(listIntentsOptions.export()));
    }
    if (listIntentsOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listIntentsOptions.pageLimit()));
    }
    if (listIntentsOptions.includeCount() != null) {
      builder.query("include_count", String.valueOf(listIntentsOptions.includeCount()));
    }
    if (listIntentsOptions.sort() != null) {
      builder.query("sort", String.valueOf(listIntentsOptions.sort()));
    }
    if (listIntentsOptions.cursor() != null) {
      builder.query("cursor", String.valueOf(listIntentsOptions.cursor()));
    }
    if (listIntentsOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(listIntentsOptions.includeAudit()));
    }
    ResponseConverter<IntentCollection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<IntentCollection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create intent.
   *
   * <p>Create a new intent.
   *
   * <p>If you want to create multiple intents with a single API call, consider using the **[Update
   * workspace](#update-workspace)** method instead.
   *
   * @param createIntentOptions the {@link CreateIntentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Intent}
   */
  public ServiceCall<Intent> createIntent(CreateIntentOptions createIntentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createIntentOptions, "createIntentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", createIntentOptions.workspaceId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/intents", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "createIntent");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (createIntentOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(createIntentOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("intent", createIntentOptions.intent());
    if (createIntentOptions.description() != null) {
      contentJson.addProperty("description", createIntentOptions.description());
    }
    if (createIntentOptions.examples() != null) {
      contentJson.add(
          "examples",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createIntentOptions.examples()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Intent> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Intent>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get intent.
   *
   * <p>Get information about an intent, optionally including all intent content.
   *
   * @param getIntentOptions the {@link GetIntentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Intent}
   */
  public ServiceCall<Intent> getIntent(GetIntentOptions getIntentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getIntentOptions, "getIntentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", getIntentOptions.workspaceId());
    pathParamsMap.put("intent", getIntentOptions.intent());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/intents/{intent}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "getIntent");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getIntentOptions.export() != null) {
      builder.query("export", String.valueOf(getIntentOptions.export()));
    }
    if (getIntentOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(getIntentOptions.includeAudit()));
    }
    ResponseConverter<Intent> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Intent>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update intent.
   *
   * <p>Update an existing intent with new or modified data. You must provide component objects
   * defining the content of the updated intent.
   *
   * <p>If you want to update multiple intents with a single API call, consider using the **[Update
   * workspace](#update-workspace)** method instead.
   *
   * @param updateIntentOptions the {@link UpdateIntentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Intent}
   */
  public ServiceCall<Intent> updateIntent(UpdateIntentOptions updateIntentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateIntentOptions, "updateIntentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", updateIntentOptions.workspaceId());
    pathParamsMap.put("intent", updateIntentOptions.intent());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/intents/{intent}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "updateIntent");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (updateIntentOptions.append() != null) {
      builder.query("append", String.valueOf(updateIntentOptions.append()));
    }
    if (updateIntentOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(updateIntentOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    if (updateIntentOptions.newIntent() != null) {
      contentJson.addProperty("intent", updateIntentOptions.newIntent());
    }
    if (updateIntentOptions.newDescription() != null) {
      contentJson.addProperty("description", updateIntentOptions.newDescription());
    }
    if (updateIntentOptions.newExamples() != null) {
      contentJson.add(
          "examples",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateIntentOptions.newExamples()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Intent> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Intent>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete intent.
   *
   * <p>Delete an intent from a workspace.
   *
   * @param deleteIntentOptions the {@link DeleteIntentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteIntent(DeleteIntentOptions deleteIntentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteIntentOptions, "deleteIntentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", deleteIntentOptions.workspaceId());
    pathParamsMap.put("intent", deleteIntentOptions.intent());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/intents/{intent}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "deleteIntent");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List user input examples.
   *
   * <p>List the user input examples for an intent, optionally including contextual entity mentions.
   *
   * @param listExamplesOptions the {@link ListExamplesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ExampleCollection}
   */
  public ServiceCall<ExampleCollection> listExamples(ListExamplesOptions listExamplesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listExamplesOptions, "listExamplesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", listExamplesOptions.workspaceId());
    pathParamsMap.put("intent", listExamplesOptions.intent());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/intents/{intent}/examples",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "listExamples");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listExamplesOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listExamplesOptions.pageLimit()));
    }
    if (listExamplesOptions.includeCount() != null) {
      builder.query("include_count", String.valueOf(listExamplesOptions.includeCount()));
    }
    if (listExamplesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listExamplesOptions.sort()));
    }
    if (listExamplesOptions.cursor() != null) {
      builder.query("cursor", String.valueOf(listExamplesOptions.cursor()));
    }
    if (listExamplesOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(listExamplesOptions.includeAudit()));
    }
    ResponseConverter<ExampleCollection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ExampleCollection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create user input example.
   *
   * <p>Add a new user input example to an intent.
   *
   * <p>If you want to add multiple examples with a single API call, consider using the **[Update
   * intent](#update-intent)** method instead.
   *
   * @param createExampleOptions the {@link CreateExampleOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Example}
   */
  public ServiceCall<Example> createExample(CreateExampleOptions createExampleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createExampleOptions, "createExampleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", createExampleOptions.workspaceId());
    pathParamsMap.put("intent", createExampleOptions.intent());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/intents/{intent}/examples",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "createExample");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (createExampleOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(createExampleOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("text", createExampleOptions.text());
    if (createExampleOptions.mentions() != null) {
      contentJson.add(
          "mentions",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createExampleOptions.mentions()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Example> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Example>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get user input example.
   *
   * <p>Get information about a user input example.
   *
   * @param getExampleOptions the {@link GetExampleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Example}
   */
  public ServiceCall<Example> getExample(GetExampleOptions getExampleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getExampleOptions, "getExampleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", getExampleOptions.workspaceId());
    pathParamsMap.put("intent", getExampleOptions.intent());
    pathParamsMap.put("text", getExampleOptions.text());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/intents/{intent}/examples/{text}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "getExample");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getExampleOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(getExampleOptions.includeAudit()));
    }
    ResponseConverter<Example> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Example>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update user input example.
   *
   * <p>Update the text of a user input example.
   *
   * <p>If you want to update multiple examples with a single API call, consider using the **[Update
   * intent](#update-intent)** method instead.
   *
   * @param updateExampleOptions the {@link UpdateExampleOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Example}
   */
  public ServiceCall<Example> updateExample(UpdateExampleOptions updateExampleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateExampleOptions, "updateExampleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", updateExampleOptions.workspaceId());
    pathParamsMap.put("intent", updateExampleOptions.intent());
    pathParamsMap.put("text", updateExampleOptions.text());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/intents/{intent}/examples/{text}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "updateExample");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (updateExampleOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(updateExampleOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    if (updateExampleOptions.newText() != null) {
      contentJson.addProperty("text", updateExampleOptions.newText());
    }
    if (updateExampleOptions.newMentions() != null) {
      contentJson.add(
          "mentions",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateExampleOptions.newMentions()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Example> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Example>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete user input example.
   *
   * <p>Delete a user input example from an intent.
   *
   * @param deleteExampleOptions the {@link DeleteExampleOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteExample(DeleteExampleOptions deleteExampleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteExampleOptions, "deleteExampleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", deleteExampleOptions.workspaceId());
    pathParamsMap.put("intent", deleteExampleOptions.intent());
    pathParamsMap.put("text", deleteExampleOptions.text());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/intents/{intent}/examples/{text}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "deleteExample");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List counterexamples.
   *
   * <p>List the counterexamples for a workspace. Counterexamples are examples that have been marked
   * as irrelevant input.
   *
   * @param listCounterexamplesOptions the {@link ListCounterexamplesOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link CounterexampleCollection}
   */
  public ServiceCall<CounterexampleCollection> listCounterexamples(
      ListCounterexamplesOptions listCounterexamplesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listCounterexamplesOptions, "listCounterexamplesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", listCounterexamplesOptions.workspaceId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/counterexamples", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v1", "listCounterexamples");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listCounterexamplesOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listCounterexamplesOptions.pageLimit()));
    }
    if (listCounterexamplesOptions.includeCount() != null) {
      builder.query("include_count", String.valueOf(listCounterexamplesOptions.includeCount()));
    }
    if (listCounterexamplesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listCounterexamplesOptions.sort()));
    }
    if (listCounterexamplesOptions.cursor() != null) {
      builder.query("cursor", String.valueOf(listCounterexamplesOptions.cursor()));
    }
    if (listCounterexamplesOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(listCounterexamplesOptions.includeAudit()));
    }
    ResponseConverter<CounterexampleCollection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<CounterexampleCollection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create counterexample.
   *
   * <p>Add a new counterexample to a workspace. Counterexamples are examples that have been marked
   * as irrelevant input.
   *
   * <p>If you want to add multiple counterexamples with a single API call, consider using the
   * **[Update workspace](#update-workspace)** method instead.
   *
   * @param createCounterexampleOptions the {@link CreateCounterexampleOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link Counterexample}
   */
  public ServiceCall<Counterexample> createCounterexample(
      CreateCounterexampleOptions createCounterexampleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createCounterexampleOptions, "createCounterexampleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", createCounterexampleOptions.workspaceId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/counterexamples", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v1", "createCounterexample");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (createCounterexampleOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(createCounterexampleOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("text", createCounterexampleOptions.text());
    builder.bodyJson(contentJson);
    ResponseConverter<Counterexample> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Counterexample>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get counterexample.
   *
   * <p>Get information about a counterexample. Counterexamples are examples that have been marked
   * as irrelevant input.
   *
   * @param getCounterexampleOptions the {@link GetCounterexampleOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Counterexample}
   */
  public ServiceCall<Counterexample> getCounterexample(
      GetCounterexampleOptions getCounterexampleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getCounterexampleOptions, "getCounterexampleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", getCounterexampleOptions.workspaceId());
    pathParamsMap.put("text", getCounterexampleOptions.text());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/counterexamples/{text}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v1", "getCounterexample");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getCounterexampleOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(getCounterexampleOptions.includeAudit()));
    }
    ResponseConverter<Counterexample> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Counterexample>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update counterexample.
   *
   * <p>Update the text of a counterexample. Counterexamples are examples that have been marked as
   * irrelevant input.
   *
   * @param updateCounterexampleOptions the {@link UpdateCounterexampleOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link Counterexample}
   */
  public ServiceCall<Counterexample> updateCounterexample(
      UpdateCounterexampleOptions updateCounterexampleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateCounterexampleOptions, "updateCounterexampleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", updateCounterexampleOptions.workspaceId());
    pathParamsMap.put("text", updateCounterexampleOptions.text());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/counterexamples/{text}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v1", "updateCounterexample");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (updateCounterexampleOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(updateCounterexampleOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    if (updateCounterexampleOptions.newText() != null) {
      contentJson.addProperty("text", updateCounterexampleOptions.newText());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Counterexample> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Counterexample>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete counterexample.
   *
   * <p>Delete a counterexample from a workspace. Counterexamples are examples that have been marked
   * as irrelevant input.
   *
   * @param deleteCounterexampleOptions the {@link DeleteCounterexampleOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteCounterexample(
      DeleteCounterexampleOptions deleteCounterexampleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteCounterexampleOptions, "deleteCounterexampleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", deleteCounterexampleOptions.workspaceId());
    pathParamsMap.put("text", deleteCounterexampleOptions.text());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/counterexamples/{text}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v1", "deleteCounterexample");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List entities.
   *
   * <p>List the entities for a workspace.
   *
   * @param listEntitiesOptions the {@link ListEntitiesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link EntityCollection}
   */
  public ServiceCall<EntityCollection> listEntities(ListEntitiesOptions listEntitiesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listEntitiesOptions, "listEntitiesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", listEntitiesOptions.workspaceId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/entities", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "listEntities");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listEntitiesOptions.export() != null) {
      builder.query("export", String.valueOf(listEntitiesOptions.export()));
    }
    if (listEntitiesOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listEntitiesOptions.pageLimit()));
    }
    if (listEntitiesOptions.includeCount() != null) {
      builder.query("include_count", String.valueOf(listEntitiesOptions.includeCount()));
    }
    if (listEntitiesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listEntitiesOptions.sort()));
    }
    if (listEntitiesOptions.cursor() != null) {
      builder.query("cursor", String.valueOf(listEntitiesOptions.cursor()));
    }
    if (listEntitiesOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(listEntitiesOptions.includeAudit()));
    }
    ResponseConverter<EntityCollection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<EntityCollection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create entity.
   *
   * <p>Create a new entity, or enable a system entity.
   *
   * <p>If you want to create multiple entities with a single API call, consider using the **[Update
   * workspace](#update-workspace)** method instead.
   *
   * @param createEntityOptions the {@link CreateEntityOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Entity}
   */
  public ServiceCall<Entity> createEntity(CreateEntityOptions createEntityOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createEntityOptions, "createEntityOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", createEntityOptions.workspaceId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/entities", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "createEntity");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (createEntityOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(createEntityOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("entity", createEntityOptions.entity());
    if (createEntityOptions.description() != null) {
      contentJson.addProperty("description", createEntityOptions.description());
    }
    if (createEntityOptions.metadata() != null) {
      contentJson.add(
          "metadata",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createEntityOptions.metadata()));
    }
    if (createEntityOptions.fuzzyMatch() != null) {
      contentJson.addProperty("fuzzy_match", createEntityOptions.fuzzyMatch());
    }
    if (createEntityOptions.values() != null) {
      contentJson.add(
          "values",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createEntityOptions.values()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Entity> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Entity>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get entity.
   *
   * <p>Get information about an entity, optionally including all entity content.
   *
   * @param getEntityOptions the {@link GetEntityOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Entity}
   */
  public ServiceCall<Entity> getEntity(GetEntityOptions getEntityOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getEntityOptions, "getEntityOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", getEntityOptions.workspaceId());
    pathParamsMap.put("entity", getEntityOptions.entity());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/entities/{entity}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "getEntity");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getEntityOptions.export() != null) {
      builder.query("export", String.valueOf(getEntityOptions.export()));
    }
    if (getEntityOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(getEntityOptions.includeAudit()));
    }
    ResponseConverter<Entity> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Entity>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update entity.
   *
   * <p>Update an existing entity with new or modified data. You must provide component objects
   * defining the content of the updated entity.
   *
   * <p>If you want to update multiple entities with a single API call, consider using the **[Update
   * workspace](#update-workspace)** method instead.
   *
   * @param updateEntityOptions the {@link UpdateEntityOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Entity}
   */
  public ServiceCall<Entity> updateEntity(UpdateEntityOptions updateEntityOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateEntityOptions, "updateEntityOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", updateEntityOptions.workspaceId());
    pathParamsMap.put("entity", updateEntityOptions.entity());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/entities/{entity}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "updateEntity");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (updateEntityOptions.append() != null) {
      builder.query("append", String.valueOf(updateEntityOptions.append()));
    }
    if (updateEntityOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(updateEntityOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    if (updateEntityOptions.newEntity() != null) {
      contentJson.addProperty("entity", updateEntityOptions.newEntity());
    }
    if (updateEntityOptions.newDescription() != null) {
      contentJson.addProperty("description", updateEntityOptions.newDescription());
    }
    if (updateEntityOptions.newMetadata() != null) {
      contentJson.add(
          "metadata",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateEntityOptions.newMetadata()));
    }
    if (updateEntityOptions.newFuzzyMatch() != null) {
      contentJson.addProperty("fuzzy_match", updateEntityOptions.newFuzzyMatch());
    }
    if (updateEntityOptions.newValues() != null) {
      contentJson.add(
          "values",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateEntityOptions.newValues()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Entity> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Entity>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete entity.
   *
   * <p>Delete an entity from a workspace, or disable a system entity.
   *
   * @param deleteEntityOptions the {@link DeleteEntityOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteEntity(DeleteEntityOptions deleteEntityOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteEntityOptions, "deleteEntityOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", deleteEntityOptions.workspaceId());
    pathParamsMap.put("entity", deleteEntityOptions.entity());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/entities/{entity}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "deleteEntity");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List entity mentions.
   *
   * <p>List mentions for a contextual entity. An entity mention is an occurrence of a contextual
   * entity in the context of an intent user input example.
   *
   * @param listMentionsOptions the {@link ListMentionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link EntityMentionCollection}
   */
  public ServiceCall<EntityMentionCollection> listMentions(
      ListMentionsOptions listMentionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listMentionsOptions, "listMentionsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", listMentionsOptions.workspaceId());
    pathParamsMap.put("entity", listMentionsOptions.entity());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/entities/{entity}/mentions",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "listMentions");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listMentionsOptions.export() != null) {
      builder.query("export", String.valueOf(listMentionsOptions.export()));
    }
    if (listMentionsOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(listMentionsOptions.includeAudit()));
    }
    ResponseConverter<EntityMentionCollection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<EntityMentionCollection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List entity values.
   *
   * <p>List the values for an entity.
   *
   * @param listValuesOptions the {@link ListValuesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ValueCollection}
   */
  public ServiceCall<ValueCollection> listValues(ListValuesOptions listValuesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listValuesOptions, "listValuesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", listValuesOptions.workspaceId());
    pathParamsMap.put("entity", listValuesOptions.entity());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/entities/{entity}/values",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "listValues");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listValuesOptions.export() != null) {
      builder.query("export", String.valueOf(listValuesOptions.export()));
    }
    if (listValuesOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listValuesOptions.pageLimit()));
    }
    if (listValuesOptions.includeCount() != null) {
      builder.query("include_count", String.valueOf(listValuesOptions.includeCount()));
    }
    if (listValuesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listValuesOptions.sort()));
    }
    if (listValuesOptions.cursor() != null) {
      builder.query("cursor", String.valueOf(listValuesOptions.cursor()));
    }
    if (listValuesOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(listValuesOptions.includeAudit()));
    }
    ResponseConverter<ValueCollection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ValueCollection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create entity value.
   *
   * <p>Create a new value for an entity.
   *
   * <p>If you want to create multiple entity values with a single API call, consider using the
   * **[Update entity](#update-entity)** method instead.
   *
   * @param createValueOptions the {@link CreateValueOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Value}
   */
  public ServiceCall<Value> createValue(CreateValueOptions createValueOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createValueOptions, "createValueOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", createValueOptions.workspaceId());
    pathParamsMap.put("entity", createValueOptions.entity());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/entities/{entity}/values",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "createValue");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (createValueOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(createValueOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("value", createValueOptions.value());
    if (createValueOptions.metadata() != null) {
      contentJson.add(
          "metadata",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createValueOptions.metadata()));
    }
    if (createValueOptions.type() != null) {
      contentJson.addProperty("type", createValueOptions.type());
    }
    if (createValueOptions.synonyms() != null) {
      contentJson.add(
          "synonyms",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createValueOptions.synonyms()));
    }
    if (createValueOptions.patterns() != null) {
      contentJson.add(
          "patterns",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createValueOptions.patterns()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Value> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Value>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get entity value.
   *
   * <p>Get information about an entity value.
   *
   * @param getValueOptions the {@link GetValueOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Value}
   */
  public ServiceCall<Value> getValue(GetValueOptions getValueOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getValueOptions, "getValueOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", getValueOptions.workspaceId());
    pathParamsMap.put("entity", getValueOptions.entity());
    pathParamsMap.put("value", getValueOptions.value());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/entities/{entity}/values/{value}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "getValue");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getValueOptions.export() != null) {
      builder.query("export", String.valueOf(getValueOptions.export()));
    }
    if (getValueOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(getValueOptions.includeAudit()));
    }
    ResponseConverter<Value> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Value>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update entity value.
   *
   * <p>Update an existing entity value with new or modified data. You must provide component
   * objects defining the content of the updated entity value.
   *
   * <p>If you want to update multiple entity values with a single API call, consider using the
   * **[Update entity](#update-entity)** method instead.
   *
   * @param updateValueOptions the {@link UpdateValueOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Value}
   */
  public ServiceCall<Value> updateValue(UpdateValueOptions updateValueOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateValueOptions, "updateValueOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", updateValueOptions.workspaceId());
    pathParamsMap.put("entity", updateValueOptions.entity());
    pathParamsMap.put("value", updateValueOptions.value());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/entities/{entity}/values/{value}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "updateValue");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (updateValueOptions.append() != null) {
      builder.query("append", String.valueOf(updateValueOptions.append()));
    }
    if (updateValueOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(updateValueOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    if (updateValueOptions.newValue() != null) {
      contentJson.addProperty("value", updateValueOptions.newValue());
    }
    if (updateValueOptions.newMetadata() != null) {
      contentJson.add(
          "metadata",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateValueOptions.newMetadata()));
    }
    if (updateValueOptions.newType() != null) {
      contentJson.addProperty("type", updateValueOptions.newType());
    }
    if (updateValueOptions.newSynonyms() != null) {
      contentJson.add(
          "synonyms",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateValueOptions.newSynonyms()));
    }
    if (updateValueOptions.newPatterns() != null) {
      contentJson.add(
          "patterns",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateValueOptions.newPatterns()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Value> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Value>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete entity value.
   *
   * <p>Delete a value from an entity.
   *
   * @param deleteValueOptions the {@link DeleteValueOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteValue(DeleteValueOptions deleteValueOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteValueOptions, "deleteValueOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", deleteValueOptions.workspaceId());
    pathParamsMap.put("entity", deleteValueOptions.entity());
    pathParamsMap.put("value", deleteValueOptions.value());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/entities/{entity}/values/{value}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "deleteValue");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List entity value synonyms.
   *
   * <p>List the synonyms for an entity value.
   *
   * @param listSynonymsOptions the {@link ListSynonymsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SynonymCollection}
   */
  public ServiceCall<SynonymCollection> listSynonyms(ListSynonymsOptions listSynonymsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listSynonymsOptions, "listSynonymsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", listSynonymsOptions.workspaceId());
    pathParamsMap.put("entity", listSynonymsOptions.entity());
    pathParamsMap.put("value", listSynonymsOptions.value());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/entities/{entity}/values/{value}/synonyms",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "listSynonyms");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listSynonymsOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listSynonymsOptions.pageLimit()));
    }
    if (listSynonymsOptions.includeCount() != null) {
      builder.query("include_count", String.valueOf(listSynonymsOptions.includeCount()));
    }
    if (listSynonymsOptions.sort() != null) {
      builder.query("sort", String.valueOf(listSynonymsOptions.sort()));
    }
    if (listSynonymsOptions.cursor() != null) {
      builder.query("cursor", String.valueOf(listSynonymsOptions.cursor()));
    }
    if (listSynonymsOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(listSynonymsOptions.includeAudit()));
    }
    ResponseConverter<SynonymCollection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<SynonymCollection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create entity value synonym.
   *
   * <p>Add a new synonym to an entity value.
   *
   * <p>If you want to create multiple synonyms with a single API call, consider using the **[Update
   * entity](#update-entity)** or **[Update entity value](#update-entity-value)** method instead.
   *
   * @param createSynonymOptions the {@link CreateSynonymOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Synonym}
   */
  public ServiceCall<Synonym> createSynonym(CreateSynonymOptions createSynonymOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createSynonymOptions, "createSynonymOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", createSynonymOptions.workspaceId());
    pathParamsMap.put("entity", createSynonymOptions.entity());
    pathParamsMap.put("value", createSynonymOptions.value());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/entities/{entity}/values/{value}/synonyms",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "createSynonym");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (createSynonymOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(createSynonymOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("synonym", createSynonymOptions.synonym());
    builder.bodyJson(contentJson);
    ResponseConverter<Synonym> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Synonym>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get entity value synonym.
   *
   * <p>Get information about a synonym of an entity value.
   *
   * @param getSynonymOptions the {@link GetSynonymOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Synonym}
   */
  public ServiceCall<Synonym> getSynonym(GetSynonymOptions getSynonymOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getSynonymOptions, "getSynonymOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", getSynonymOptions.workspaceId());
    pathParamsMap.put("entity", getSynonymOptions.entity());
    pathParamsMap.put("value", getSynonymOptions.value());
    pathParamsMap.put("synonym", getSynonymOptions.synonym());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/entities/{entity}/values/{value}/synonyms/{synonym}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "getSynonym");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getSynonymOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(getSynonymOptions.includeAudit()));
    }
    ResponseConverter<Synonym> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Synonym>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update entity value synonym.
   *
   * <p>Update an existing entity value synonym with new text.
   *
   * <p>If you want to update multiple synonyms with a single API call, consider using the **[Update
   * entity](#update-entity)** or **[Update entity value](#update-entity-value)** method instead.
   *
   * @param updateSynonymOptions the {@link UpdateSynonymOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Synonym}
   */
  public ServiceCall<Synonym> updateSynonym(UpdateSynonymOptions updateSynonymOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateSynonymOptions, "updateSynonymOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", updateSynonymOptions.workspaceId());
    pathParamsMap.put("entity", updateSynonymOptions.entity());
    pathParamsMap.put("value", updateSynonymOptions.value());
    pathParamsMap.put("synonym", updateSynonymOptions.synonym());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/entities/{entity}/values/{value}/synonyms/{synonym}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "updateSynonym");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (updateSynonymOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(updateSynonymOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    if (updateSynonymOptions.newSynonym() != null) {
      contentJson.addProperty("synonym", updateSynonymOptions.newSynonym());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Synonym> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Synonym>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete entity value synonym.
   *
   * <p>Delete a synonym from an entity value.
   *
   * @param deleteSynonymOptions the {@link DeleteSynonymOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteSynonym(DeleteSynonymOptions deleteSynonymOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteSynonymOptions, "deleteSynonymOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", deleteSynonymOptions.workspaceId());
    pathParamsMap.put("entity", deleteSynonymOptions.entity());
    pathParamsMap.put("value", deleteSynonymOptions.value());
    pathParamsMap.put("synonym", deleteSynonymOptions.synonym());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/entities/{entity}/values/{value}/synonyms/{synonym}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "deleteSynonym");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List dialog nodes.
   *
   * <p>List the dialog nodes for a workspace.
   *
   * @param listDialogNodesOptions the {@link ListDialogNodesOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link DialogNodeCollection}
   */
  public ServiceCall<DialogNodeCollection> listDialogNodes(
      ListDialogNodesOptions listDialogNodesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listDialogNodesOptions, "listDialogNodesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", listDialogNodesOptions.workspaceId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/dialog_nodes", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v1", "listDialogNodes");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listDialogNodesOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listDialogNodesOptions.pageLimit()));
    }
    if (listDialogNodesOptions.includeCount() != null) {
      builder.query("include_count", String.valueOf(listDialogNodesOptions.includeCount()));
    }
    if (listDialogNodesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listDialogNodesOptions.sort()));
    }
    if (listDialogNodesOptions.cursor() != null) {
      builder.query("cursor", String.valueOf(listDialogNodesOptions.cursor()));
    }
    if (listDialogNodesOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(listDialogNodesOptions.includeAudit()));
    }
    ResponseConverter<DialogNodeCollection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DialogNodeCollection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create dialog node.
   *
   * <p>Create a new dialog node.
   *
   * <p>If you want to create multiple dialog nodes with a single API call, consider using the
   * **[Update workspace](#update-workspace)** method instead.
   *
   * @param createDialogNodeOptions the {@link CreateDialogNodeOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link DialogNode}
   */
  public ServiceCall<DialogNode> createDialogNode(CreateDialogNodeOptions createDialogNodeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createDialogNodeOptions, "createDialogNodeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", createDialogNodeOptions.workspaceId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/dialog_nodes", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v1", "createDialogNode");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (createDialogNodeOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(createDialogNodeOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("dialog_node", createDialogNodeOptions.dialogNode());
    if (createDialogNodeOptions.description() != null) {
      contentJson.addProperty("description", createDialogNodeOptions.description());
    }
    if (createDialogNodeOptions.conditions() != null) {
      contentJson.addProperty("conditions", createDialogNodeOptions.conditions());
    }
    if (createDialogNodeOptions.parent() != null) {
      contentJson.addProperty("parent", createDialogNodeOptions.parent());
    }
    if (createDialogNodeOptions.previousSibling() != null) {
      contentJson.addProperty("previous_sibling", createDialogNodeOptions.previousSibling());
    }
    if (createDialogNodeOptions.output() != null) {
      contentJson.add(
          "output",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createDialogNodeOptions.output()));
    }
    if (createDialogNodeOptions.context() != null) {
      contentJson.add(
          "context",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createDialogNodeOptions.context()));
    }
    if (createDialogNodeOptions.metadata() != null) {
      contentJson.add(
          "metadata",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createDialogNodeOptions.metadata()));
    }
    if (createDialogNodeOptions.nextStep() != null) {
      contentJson.add(
          "next_step",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createDialogNodeOptions.nextStep()));
    }
    if (createDialogNodeOptions.title() != null) {
      contentJson.addProperty("title", createDialogNodeOptions.title());
    }
    if (createDialogNodeOptions.type() != null) {
      contentJson.addProperty("type", createDialogNodeOptions.type());
    }
    if (createDialogNodeOptions.eventName() != null) {
      contentJson.addProperty("event_name", createDialogNodeOptions.eventName());
    }
    if (createDialogNodeOptions.variable() != null) {
      contentJson.addProperty("variable", createDialogNodeOptions.variable());
    }
    if (createDialogNodeOptions.actions() != null) {
      contentJson.add(
          "actions",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createDialogNodeOptions.actions()));
    }
    if (createDialogNodeOptions.digressIn() != null) {
      contentJson.addProperty("digress_in", createDialogNodeOptions.digressIn());
    }
    if (createDialogNodeOptions.digressOut() != null) {
      contentJson.addProperty("digress_out", createDialogNodeOptions.digressOut());
    }
    if (createDialogNodeOptions.digressOutSlots() != null) {
      contentJson.addProperty("digress_out_slots", createDialogNodeOptions.digressOutSlots());
    }
    if (createDialogNodeOptions.userLabel() != null) {
      contentJson.addProperty("user_label", createDialogNodeOptions.userLabel());
    }
    if (createDialogNodeOptions.disambiguationOptOut() != null) {
      contentJson.addProperty(
          "disambiguation_opt_out", createDialogNodeOptions.disambiguationOptOut());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<DialogNode> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DialogNode>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get dialog node.
   *
   * <p>Get information about a dialog node.
   *
   * @param getDialogNodeOptions the {@link GetDialogNodeOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link DialogNode}
   */
  public ServiceCall<DialogNode> getDialogNode(GetDialogNodeOptions getDialogNodeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getDialogNodeOptions, "getDialogNodeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", getDialogNodeOptions.workspaceId());
    pathParamsMap.put("dialog_node", getDialogNodeOptions.dialogNode());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/dialog_nodes/{dialog_node}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "getDialogNode");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getDialogNodeOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(getDialogNodeOptions.includeAudit()));
    }
    ResponseConverter<DialogNode> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DialogNode>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update dialog node.
   *
   * <p>Update an existing dialog node with new or modified data.
   *
   * <p>If you want to update multiple dialog nodes with a single API call, consider using the
   * **[Update workspace](#update-workspace)** method instead.
   *
   * @param updateDialogNodeOptions the {@link UpdateDialogNodeOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link DialogNode}
   */
  public ServiceCall<DialogNode> updateDialogNode(UpdateDialogNodeOptions updateDialogNodeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateDialogNodeOptions, "updateDialogNodeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", updateDialogNodeOptions.workspaceId());
    pathParamsMap.put("dialog_node", updateDialogNodeOptions.dialogNode());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/dialog_nodes/{dialog_node}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v1", "updateDialogNode");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (updateDialogNodeOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(updateDialogNodeOptions.includeAudit()));
    }
    final JsonObject contentJson = new JsonObject();
    if (updateDialogNodeOptions.newDialogNode() != null) {
      contentJson.addProperty("dialog_node", updateDialogNodeOptions.newDialogNode());
    }
    if (updateDialogNodeOptions.newDescription() != null) {
      contentJson.addProperty("description", updateDialogNodeOptions.newDescription());
    }
    if (updateDialogNodeOptions.newConditions() != null) {
      contentJson.addProperty("conditions", updateDialogNodeOptions.newConditions());
    }
    if (updateDialogNodeOptions.newParent() != null) {
      contentJson.addProperty("parent", updateDialogNodeOptions.newParent());
    }
    if (updateDialogNodeOptions.newPreviousSibling() != null) {
      contentJson.addProperty("previous_sibling", updateDialogNodeOptions.newPreviousSibling());
    }
    if (updateDialogNodeOptions.newOutput() != null) {
      contentJson.add(
          "output",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateDialogNodeOptions.newOutput()));
    }
    if (updateDialogNodeOptions.newContext() != null) {
      contentJson.add(
          "context",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateDialogNodeOptions.newContext()));
    }
    if (updateDialogNodeOptions.newMetadata() != null) {
      contentJson.add(
          "metadata",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateDialogNodeOptions.newMetadata()));
    }
    if (updateDialogNodeOptions.newNextStep() != null) {
      contentJson.add(
          "next_step",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateDialogNodeOptions.newNextStep()));
    }
    if (updateDialogNodeOptions.newTitle() != null) {
      contentJson.addProperty("title", updateDialogNodeOptions.newTitle());
    }
    if (updateDialogNodeOptions.newType() != null) {
      contentJson.addProperty("type", updateDialogNodeOptions.newType());
    }
    if (updateDialogNodeOptions.newEventName() != null) {
      contentJson.addProperty("event_name", updateDialogNodeOptions.newEventName());
    }
    if (updateDialogNodeOptions.newVariable() != null) {
      contentJson.addProperty("variable", updateDialogNodeOptions.newVariable());
    }
    if (updateDialogNodeOptions.newActions() != null) {
      contentJson.add(
          "actions",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateDialogNodeOptions.newActions()));
    }
    if (updateDialogNodeOptions.newDigressIn() != null) {
      contentJson.addProperty("digress_in", updateDialogNodeOptions.newDigressIn());
    }
    if (updateDialogNodeOptions.newDigressOut() != null) {
      contentJson.addProperty("digress_out", updateDialogNodeOptions.newDigressOut());
    }
    if (updateDialogNodeOptions.newDigressOutSlots() != null) {
      contentJson.addProperty("digress_out_slots", updateDialogNodeOptions.newDigressOutSlots());
    }
    if (updateDialogNodeOptions.newUserLabel() != null) {
      contentJson.addProperty("user_label", updateDialogNodeOptions.newUserLabel());
    }
    if (updateDialogNodeOptions.newDisambiguationOptOut() != null) {
      contentJson.addProperty(
          "disambiguation_opt_out", updateDialogNodeOptions.newDisambiguationOptOut());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<DialogNode> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DialogNode>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update dialog node.
   *
   * <p>Update an existing dialog node with new or modified data.
   *
   * <p>If you want to update multiple dialog nodes with a single API call, consider using the
   * **[Update workspace](#update-workspace)** method instead.
   *
   * @param UpdateDialogNodeNullableOptions the {@link UpdateDialogNodeNullableOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link DialogNode}
   */
  public ServiceCall<DialogNode> updateDialogNodeNullable(
          UpdateDialogNodeNullableOptions UpdateDialogNodeNullableOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
            UpdateDialogNodeNullableOptions, "UpdateDialogNodeNullableOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", UpdateDialogNodeNullableOptions.workspaceId());
    pathParamsMap.put("dialog_node", UpdateDialogNodeNullableOptions.dialogNode());
    RequestBuilder builder =
            RequestBuilder.post(
                    RequestBuilder.resolveRequestUrl(
                            getServiceUrl(),
                            "/v1/workspaces/{workspace_id}/dialog_nodes/{dialog_node}",
                            pathParamsMap));
    Map<String, String> sdkHeaders =
            SdkCommon.getSdkHeaders("conversation", "v1", "testUpdateDialogNode");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (UpdateDialogNodeNullableOptions.includeAudit() != null) {
      builder.query("include_audit", String.valueOf(UpdateDialogNodeNullableOptions.includeAudit()));
    }
    builder.bodyContent(
            com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithSerializeNulls()
                    .toJson(UpdateDialogNodeNullableOptions.body()),
            "application/json");
    ResponseConverter<DialogNode> responseConverter =
            ResponseConverterUtils.getValue(
                    new com.google.gson.reflect.TypeToken<DialogNode>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete dialog node.
   *
   * <p>Delete a dialog node from a workspace.
   *
   * @param deleteDialogNodeOptions the {@link DeleteDialogNodeOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteDialogNode(DeleteDialogNodeOptions deleteDialogNodeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteDialogNodeOptions, "deleteDialogNodeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", deleteDialogNodeOptions.workspaceId());
    pathParamsMap.put("dialog_node", deleteDialogNodeOptions.dialogNode());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/workspaces/{workspace_id}/dialog_nodes/{dialog_node}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v1", "deleteDialogNode");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List log events in a workspace.
   *
   * <p>List the events from the log of a specific workspace.
   *
   * @param listLogsOptions the {@link ListLogsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link LogCollection}
   */
  public ServiceCall<LogCollection> listLogs(ListLogsOptions listLogsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listLogsOptions, "listLogsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("workspace_id", listLogsOptions.workspaceId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/workspaces/{workspace_id}/logs", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "listLogs");
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
   * List log events in all workspaces.
   *
   * <p>List the events from the logs of all workspaces in the service instance.
   *
   * @param listAllLogsOptions the {@link ListAllLogsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link LogCollection}
   */
  public ServiceCall<LogCollection> listAllLogs(ListAllLogsOptions listAllLogsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listAllLogsOptions, "listAllLogsOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/logs"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("conversation", "v1", "listAllLogs");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    builder.query("filter", String.valueOf(listAllLogsOptions.filter()));
    if (listAllLogsOptions.sort() != null) {
      builder.query("sort", String.valueOf(listAllLogsOptions.sort()));
    }
    if (listAllLogsOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listAllLogsOptions.pageLimit()));
    }
    if (listAllLogsOptions.cursor() != null) {
      builder.query("cursor", String.valueOf(listAllLogsOptions.cursor()));
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
   * @param deleteUserDataOptions the {@link DeleteUserDataOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteUserData(DeleteUserDataOptions deleteUserDataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteUserDataOptions, "deleteUserDataOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/user_data"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("conversation", "v1", "deleteUserData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    builder.query("customer_id", String.valueOf(deleteUserDataOptions.customerId()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }
}

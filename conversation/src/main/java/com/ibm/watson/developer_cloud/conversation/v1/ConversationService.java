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
package com.ibm.watson.developer_cloud.conversation.v1;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.RecordsInstructions;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.WorkspaceExportResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.WorkspaceListResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.WorkspaceRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.WorkspaceResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent.CreateIntent;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent.IntentExportResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent.IntentListResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent.IntentResponse;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * Thin wrapper around the Conversation Service REST API.
 *
 * @version v1
 * @see <a href= "http://www.ibm.com/watson/developercloud/conversation.html">
 *      Conversation</a>
 */
public final class ConversationService extends WatsonService {

  /** The Constant VERSION_DATE_2017-02-03. */
  public static final String VERSION_DATE_2017_02_03 = "2017-02-03";
  /** The Constant VERSION_DATE_2016-09-20. */
  public static final String VERSION_DATE_2016_09_20 = "2016-09-20";
  /** The Constant VERSION_DATE_2016-07-11. */
  public static final String VERSION_DATE_2016_07_11 = "2016-07-11";
  public static final String URL = "https://gateway.watsonplatform.net/conversation/api";
  public static final String SERVICE_NAME = "conversation";
  public static final String PATH_MESSAGE = "/v1/workspaces/%s/message";
  public static final String PATH_INTENTS = "/v1/workspaces/%s/intents";
  public static final String PATH_INTENT = "/v1/workspaces/%s/intents/%s";
  public static final String PATH_WORKSPACES = "/v1/workspaces";
  public static final String PATH_WORKSPACE = "/v1/workspaces/%s";
  public static final String VERSION_PARAM = "version";
  public static final String EXPORT_PARAM = "export";
  public static final String CURSOR_PARAM = "cursor";
  public static final String INCLUDE_COUNT_PARAM = "include_count";
  public static final String SORT_PARAM = "sort";
  public static final String PAGE_LIMIT_PARAM = "page_limit";

  private final String versionDate;

  /**
   * Returns an instance of the Conversation Service using the service's default
   * endpoint (URL).
   *
   * @param versionDate
   *          Version of the API which is to be invoked by the REST client.
   */
  public ConversationService(final String versionDate) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(),
        "'version cannot be null. Use " + VERSION_DATE_2017_02_03);
    this.versionDate = versionDate;
  }

  /**
   * Returns an instance of the Conversation Service using the service's default
   * endpoint (URL), username and password.
   *
   * @param versionDate
   *          Version of the API which is to be invoked by the REST client.
   * @param username
   *          the username
   * @param password
   *          the password
   */
  public ConversationService(final String versionDate, String username, String password) {
    this(versionDate);
    setUsernameAndPassword(username, password);
  }

  /**
   * Retrieves the workspace list to the service.
   * @param instructions
   *          instructions how to return the list. see
   *          {@link RecordsInstructions}
   * @return The list of workspaces.
   */
  public ServiceCall<WorkspaceListResponse> listWorkspaces(RecordsInstructions instructions) {
    RequestBuilder builder = RequestBuilder.get(String.format(PATH_WORKSPACES));
    builder.query(VERSION_PARAM, versionDate);
    buildRecordsInstructions(instructions, builder);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(WorkspaceListResponse.class));
  }

  /**
   * Retrieves the workspace list to the service.
   *
   * @return The list of workspaces.
   */
  public ServiceCall<WorkspaceListResponse> listWorkspaces() {
    return listWorkspaces(null);
  }

  /**
   * Creates a Workspace in Conversation service.
   *
   * @param payload
   *          the workspace
   * @return a request to create the workspace.
   */
  public ServiceCall<WorkspaceResponse> createWorkspace(WorkspaceRequest payload) {
    RequestBuilder builder = RequestBuilder.post(String.format(PATH_WORKSPACES));
    if (payload != null) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(payload).getAsJsonObject());
    } else {
      builder.bodyJson(new JsonObject());
    }
    builder.query(VERSION_PARAM, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(WorkspaceResponse.class));
  }

  /**
   * Deletes a specific intent for the service.
   *
   * @param workspaceId
   *          the workspace id
   * @return an empty service call
   */
  public ServiceCall<Void> deleteWorkspace(String workspaceId) {
    Validator.isTrue((workspaceId != null) && !workspaceId.isEmpty(), "'workspaceId' cannot be null or empty");
    RequestBuilder builder = RequestBuilder.delete(String.format(PATH_WORKSPACE, workspaceId));
    builder.query(VERSION_PARAM, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Retrieves a specific intent for the service.
   *
   * @param workspaceId
   *          the workspace id
   * @param export
   *          true if the returned information should contain also export data
   *          ((entities, intents, counterexamples, and dialog nodes).
   * @return The intent for a given workspace.
   */
  public ServiceCall<WorkspaceExportResponse> getWorkspace(String workspaceId, boolean export) {
    Validator.isTrue((workspaceId != null) && !workspaceId.isEmpty(), "'workspaceId' cannot be null or empty");

    RequestBuilder builder = RequestBuilder.get(String.format(PATH_WORKSPACE, workspaceId));
    builder.query(VERSION_PARAM, versionDate);
    if (export) {
      builder.query(EXPORT_PARAM, export);
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(WorkspaceExportResponse.class));
  }

  /**
   * Retrieves a specific intent for the service.
   *
   * @param workspaceId
   *          the workspace id
   * @return The workspace without export data (entities, intents,
   *         counterexamples, and dialog nodes).
   */
  public ServiceCall<WorkspaceExportResponse> getWorkspace(String workspaceId) {
    return getWorkspace(workspaceId, false);
  }

  /**
   * Update a specific intent for the service through a {@link CreateIntent}.
   *
   * @param workspaceId
   *          the workspace id
   * @param payload
   *          the new data
   * @return The intent for a given workspace.
   */
  public ServiceCall<WorkspaceResponse> updateWorkspace(String workspaceId, WorkspaceRequest payload) {
    Validator.isTrue((workspaceId != null) && !workspaceId.isEmpty(), "'workspaceId' cannot be null or empty");

    RequestBuilder builder = RequestBuilder.post(String.format(PATH_WORKSPACE, workspaceId));
    if (payload != null) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(payload).getAsJsonObject());
    } else {
      builder.bodyJson(new JsonObject());
    }
    builder.query(VERSION_PARAM, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(WorkspaceResponse.class));
  }

  /**
   * Retrieves the intent list to the service.
   *
   * @param workspaceId
   *          the workspace id
   * @param export
   *          Whether to include all element content in the returned data. If
   *          export=false, the returned data includes only information about
   *          the element itself. If export=true, all content, including
   *          subelements, is included.
   * @param instructions
   *          see {@link RecordsInstructions}
   * @return The list of intents for a given workspace.
   */
  public ServiceCall<IntentListResponse> getIntents(String workspaceId, boolean export,
      RecordsInstructions instructions) {
    Validator.isTrue((workspaceId != null) && !workspaceId.isEmpty(), "'workspaceId' cannot be null or empty");

    RequestBuilder builder = RequestBuilder.get(String.format(PATH_INTENTS, workspaceId));
    builder.query(VERSION_PARAM, versionDate);
    if (export)
      builder.query(EXPORT_PARAM, export);
    buildRecordsInstructions(instructions, builder);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(IntentListResponse.class));
  }

  private void buildRecordsInstructions(RecordsInstructions instructions, RequestBuilder builder) {
    if (instructions == null)
      return;
    if (instructions.getCursor() != null)
      builder.query(CURSOR_PARAM, instructions.getCursor());
    if (instructions.getIncludeCount())
      builder.query(INCLUDE_COUNT_PARAM, instructions.getIncludeCount());
    if (instructions.getPageLimit() != 0)
      builder.query(PAGE_LIMIT_PARAM, instructions.getPageLimit());
    if (instructions.getSort() != null)
      builder.query(SORT_PARAM, instructions.getSort());
  }

  /**
   * Retrieves the intent list to the service (without sub-elements, with
   * default page size and default sort order).
   *
   * @param workspaceId
   *          the workspace id
   * @return The list of intents for a given workspace.
   */
  public ServiceCall<IntentListResponse> getIntents(String workspaceId) {
    return getIntents(workspaceId, false, null);
  }

  /**
   * Retrieves a specific intent for the service through a {@link CreateIntent}.
   *
   * @param workspaceId
   *          the workspace id
   * @param payload
   *          the new data
   * @return The intent for a given workspace.
   */
  public ServiceCall<IntentResponse> createIntent(String workspaceId, CreateIntent payload) {
    Validator.isTrue((workspaceId != null) && !workspaceId.isEmpty(), "'workspaceId' cannot be null or empty");

    RequestBuilder builder = RequestBuilder.post(String.format(PATH_INTENTS, workspaceId));
    if (payload != null) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(payload).getAsJsonObject());
    } else {
      builder.bodyJson(new JsonObject());
    }
    builder.query(VERSION_PARAM, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(IntentResponse.class));
  }

  /**
   * Deletes a specific intent for the service.
   *
   * @param workspaceId
   *          the workspace id
   * @param intentId
   *          the intent id
   * @return an empty service call
   */
  public ServiceCall<Void> deleteIntent(String workspaceId, String intentId) {
    Validator.isTrue((workspaceId != null) && !workspaceId.isEmpty(), "'workspaceId' cannot be null or empty");
    Validator.isTrue((intentId != null) && !intentId.isEmpty(), "'intentId' cannot be null or empty");

    RequestBuilder builder = RequestBuilder.delete(String.format(PATH_INTENT, workspaceId, intentId));
    builder.query(VERSION_PARAM, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Retrieves a specific intent for the service.
   *
   * @param workspaceId
   *          the workspace id
   * @param intentId
   *          the intent id
   * @param export
   *          Whether to include all element content in the returned data. If
   *          export=false, the returned data includes only information about
   *          the element itself. If export=true, all content, including
   *          subelements, is included.
   * @return The intent for a given workspace.
   */
  public ServiceCall<IntentExportResponse> getIntent(String workspaceId, String intentId, boolean export) {
    Validator.isTrue((workspaceId != null) && !workspaceId.isEmpty(), "'workspaceId' cannot be null or empty");
    Validator.isTrue((intentId != null) && !intentId.isEmpty(), "'intentId' cannot be null or empty");

    RequestBuilder builder = RequestBuilder.get(String.format(PATH_INTENT, workspaceId, intentId));
    builder.query(VERSION_PARAM, versionDate);
    if (export) {
      builder.query(EXPORT_PARAM, export);
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(IntentExportResponse.class));
  }

  /**
   * Retrieves a specific intent for the service without its sub-elements.
   *
   * @param workspaceId
   *          the workspace id
   * @param intentId
   *          the intent id
   * @return The intent for a given workspace.
   */
  public ServiceCall<IntentExportResponse> getIntent(String workspaceId, String intentId) {
    return getIntent(workspaceId, intentId, false);
  }

  /**
   * Update a specific intent for the service through a {@link CreateIntent}.
   *
   * @param workspaceId
   *          the workspace id
   * @param intentId
   *          the intent id
   * @param payload
   *          the new data
   * @return The intent for a given workspace.
   */
  public ServiceCall<IntentResponse> updateIntent(String workspaceId, String intentId, CreateIntent payload) {
    Validator.isTrue((workspaceId != null) && !workspaceId.isEmpty(), "'workspaceId' cannot be null or empty");
    Validator.isTrue((intentId != null) && !intentId.isEmpty(), "'intentId' cannot be null or empty");

    RequestBuilder builder = RequestBuilder.post(String.format(PATH_INTENT, workspaceId, intentId));
    if (payload != null) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(payload).getAsJsonObject());
    } else {
      builder.bodyJson(new JsonObject());
    }
    builder.query(VERSION_PARAM, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(IntentResponse.class));
  }

  /**
   * Sends a message to the service through a {@link MessageRequest}.
   *
   * @param workspaceId
   *          the workspace id
   * @param request
   *          the request
   * @return The response for the given message.
   */
  public ServiceCall<MessageResponse> message(String workspaceId, MessageRequest request) {
    Validator.isTrue((workspaceId != null) && !workspaceId.isEmpty(), "'workspaceId' cannot be null or empty");

    RequestBuilder builder = RequestBuilder.post(String.format(PATH_MESSAGE, workspaceId));
    builder.query(VERSION_PARAM, versionDate);
    if (request != null) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(request).getAsJsonObject());
    } else {
      builder.bodyJson(new JsonObject());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(MessageResponse.class));
  }
}

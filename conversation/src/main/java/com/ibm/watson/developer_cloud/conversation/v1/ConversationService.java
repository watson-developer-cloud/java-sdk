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
import com.ibm.watson.developer_cloud.conversation.v1.model.CounterexampleCollectionResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateExample;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateWorkspace;
import com.ibm.watson.developer_cloud.conversation.v1.model.ExampleCollectionResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.ExampleResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.IntentCollectionResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.IntentExportResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.IntentResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateWorkspace;
import com.ibm.watson.developer_cloud.conversation.v1.model.WorkspaceCollectionResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.WorkspaceExportResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.WorkspaceResponse;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

import java.util.List;

/**
 * Thin wrapper around the Conversation Service REST API.
 *
 * @version v1
 * @see <a href= "http://www.ibm.com/watson/developercloud/conversation.html"> Conversation</a>
 */
public final class ConversationService extends WatsonService {

  /** The Constant VERSION_DATE_2017-02-03. */
  public static final String VERSION_DATE_2017_02_03 = "2017-02-03";
  /** The Constant VERSION_DATE_2016-09-20. */
  public static final String VERSION_DATE_2016_09_20 = "2016-09-20";
  /** The Constant VERSION_DATE_2016-07-11. */
  public static final String VERSION_DATE_2016_07_11 = "2016-07-11";
  private static final String URL = "https://gateway.watsonplatform.net/conversation/api";
  private static final String SERVICE_NAME = "conversation";
  private static final String PATH_MESSAGE = "/v1/workspaces/%s/message";
  private static final String VERSION_PARAM = "version";
  private final String versionDate;


  /**
   * Returns an instance of the Conversation Service using the service's default endpoint (URL).
   *
   * @param versionDate Version of the API which is to be invoked by the REST client.
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
   * Returns an instance of the Conversation Service using the service's default endpoint (URL), username and password.
   *
   * @param versionDate Version of the API which is to be invoked by the REST client.
   * @param username the username
   * @param password the password
   */
  public ConversationService(final String versionDate, String username, String password) {
    this(versionDate);
    setUsernameAndPassword(username, password);
  }

  /**
   * Sends a message to the service through a {@link MessageRequest}.
   *
   * @param workspaceId the workspace id
   * @param request the request
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

  /**
   * Create counterexample.
   *
   * Add a new counterexample to a workspace. Counterexamples are examples that have been marked as irrelevant input.
   *
   * @param workspaceId The workspace ID.
   * @param text        The text of a user input example.
   * @return the {@link ExampleResponse} with the response
   */
  public ServiceCall<ExampleResponse> createCounterexample(String workspaceId, String text) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    Validator.notNull(text, "text cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/counterexamples", workspaceId));
    builder.query(VERSION, versionDate);

    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("text", text);
    builder.bodyJson(contentJson);

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ExampleResponse.class));
  }

  /**
   * Delete counterexample.
   *
   * Delete a counterexample from a workspace. Counterexamples are examples that have been marked as irrelevant input.
   *
   * @param workspaceId The workspace ID.
   * @param text        The text of a user input counterexample (for example, `What are you wearing?`).
   * @return the service call
   */
  public ServiceCall<Void> deleteCounterexample(String workspaceId, String text) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    Validator.notNull(text, "text cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/workspaces/%s/counterexamples/%s", workspaceId,
        text));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get counterexample.
   *
   * Get information about a counterexample. Counterexamples are examples that have been marked as irrelevant input.
   *
   * @param workspaceId The workspace ID.
   * @param text        The text of a user input counterexample (for example, `What are you wearing?`).
   * @return the {@link ExampleResponse} with the response
   */
  public ServiceCall<ExampleResponse> getCounterexample(String workspaceId, String text) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    Validator.notNull(text, "text cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/counterexamples/%s", workspaceId,
        text));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ExampleResponse.class));
  }

  /**
   * List counterexamples.
   *
   * List the counterexamples for a workspace. Counterexamples are examples that have been marked as irrelevant input.
   *
   * @param workspaceId  The workspace ID.
   * @param pageLimit    The number of records to return in each page of results. The default page limit is 100.
   * @param includeCount Whether to include information about the number of records returned.
   * @param sort         The sort order that determines the behavior of the pagination cursor.
   * @param cursor       A token identifying the last value from the previous page of results.
   * @return the {@link CounterexampleCollectionResponse} with the response
   */
  public ServiceCall<CounterexampleCollectionResponse> listCounterexamples(String workspaceId, Long pageLimit,
                                                                           Boolean includeCount, String sort, String
                                                                               cursor) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/counterexamples", workspaceId));
    builder.query(VERSION, versionDate);
    if (pageLimit != null) {
      builder.query("page_limit", String.valueOf(pageLimit));
    }
    if (includeCount != null) {
      builder.query("include_count", String.valueOf(includeCount));
    }
    if (sort != null) {
      builder.query("sort", sort);
    }
    if (cursor != null) {
      builder.query("cursor", cursor);
    }

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(CounterexampleCollectionResponse.class));
  }

  /**
   * Update counterexample.
   *
   * Update the text of a counterexample. Counterexamples are examples that have been marked as irrelevant input.
   *
   * @param workspaceId The workspace ID.
   * @param text        The text of a user input counterexample (for example, `What are you wearing?`).
   * @param newText     The text of the user input example.
   * @return the {@link ExampleResponse} with the response
   */
  public ServiceCall<ExampleResponse> updateCounterexample(String workspaceId, String text, String newText) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    Validator.notNull(text, "text cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/counterexamples/%s", workspaceId,
        text));
    builder.query(VERSION, versionDate);

    final JsonObject contentJson = new JsonObject();
    if (newText != null) {
      contentJson.addProperty("text", newText);
    }
    builder.bodyJson(contentJson);

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ExampleResponse.class));
  }

  /**
   * Create user input example.
   *
   * Add a new user input example to an intent.
   *
   * @param workspaceId The workspace ID.
   * @param intent      The intent name (for example, `pizza_order`).
   * @param text        The text of a user input example.
   * @return the {@link ExampleResponse} with the response
   */
  public ServiceCall<ExampleResponse> createExample(String workspaceId, String intent, String text) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    Validator.notNull(intent, "intent cannot be null");
    Validator.notNull(text, "text cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/intents/%s/examples", workspaceId,
        intent));
    builder.query(VERSION, versionDate);

    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("text", text);
    builder.bodyJson(contentJson);

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ExampleResponse.class));
  }

  /**
   * Delete user input example.
   *
   * Delete a user input example from an intent.
   *
   * @param workspaceId The workspace ID.
   * @param intent      The intent name (for example, `pizza_order`).
   * @param text        The text of the user input example.
   * @return the service call
   */
  public ServiceCall<Void> deleteExample(String workspaceId, String intent, String text) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    Validator.notNull(intent, "intent cannot be null");
    Validator.notNull(text, "text cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/workspaces/%s/intents/%s/examples/%s",
        workspaceId, intent, text));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get user input example.
   *
   * Get information about a user input example.
   *
   * @param workspaceId The workspace ID.
   * @param intent      The intent name (for example, `pizza_order`).
   * @param text        The text of the user input example.
   * @return the {@link ExampleResponse} with the response
   */
  public ServiceCall<ExampleResponse> getExample(String workspaceId, String intent, String text) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    Validator.notNull(intent, "intent cannot be null");
    Validator.notNull(text, "text cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/intents/%s/examples/%s",
        workspaceId, intent, text));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ExampleResponse.class));
  }

  /**
   * List user input examples.
   *
   * List the user input examples for an intent.
   *
   * @param workspaceId  The workspace ID.
   * @param intent       The intent name (for example, `pizza_order`).
   * @param pageLimit    The number of records to return in each page of results. The default page limit is 100.
   * @param includeCount Whether to include information about the number of records returned.
   * @param sort         The sort order that determines the behavior of the pagination cursor.
   * @param cursor       A token identifying the last value from the previous page of results.
   * @return the {@link ExampleCollectionResponse} with the response
   */
  public ServiceCall<ExampleCollectionResponse> listExamples(String workspaceId, String intent, Long pageLimit,
                                                             Boolean includeCount, String sort, String cursor) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    Validator.notNull(intent, "intent cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/intents/%s/examples", workspaceId,
        intent));
    builder.query(VERSION, versionDate);
    if (pageLimit != null) {
      builder.query("page_limit", String.valueOf(pageLimit));
    }
    if (includeCount != null) {
      builder.query("include_count", String.valueOf(includeCount));
    }
    if (sort != null) {
      builder.query("sort", sort);
    }
    if (cursor != null) {
      builder.query("cursor", cursor);
    }

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ExampleCollectionResponse.class));
  }

  /**
   * Update user input example.
   *
   * Update the text of a user input example.
   *
   * @param workspaceId The workspace ID.
   * @param intent      The intent name (for example, `pizza_order`).
   * @param text        The text of the user input example.
   * @param newText     The text of the user input example.
   * @return the {@link ExampleResponse} with the response
   */
  public ServiceCall<ExampleResponse> updateExample(String workspaceId, String intent, String text, String newText) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    Validator.notNull(intent, "intent cannot be null");
    Validator.notNull(text, "text cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/intents/%s/examples/%s",
        workspaceId, intent, text));
    builder.query(VERSION, versionDate);

    final JsonObject contentJson = new JsonObject();
    if (newText != null) {
      contentJson.addProperty("text", newText);
    }
    builder.bodyJson(contentJson);

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ExampleResponse.class));
  }

  /**
   * Create intent.
   *
   * Create a new intent.
   *
   * @param workspaceId The workspace ID.
   * @param intent      The name of the intent.
   * @param description The description of the intent.
   * @param examples    An array of user input examples.
   * @return the {@link IntentResponse} with the response
   */
  public ServiceCall<IntentResponse> createIntent(String workspaceId, String intent, String description,
                                                  List<CreateExample> examples) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    Validator.notNull(intent, "intent cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/intents", workspaceId));
    builder.query(VERSION, versionDate);

    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("intent", intent);
    if (description != null) {
      contentJson.addProperty("description", description);
    }
    if (examples != null) {
      contentJson.add("examples", GsonSingleton.getGson().toJsonTree(examples));
    }
    builder.bodyJson(contentJson);

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(IntentResponse.class));
  }

  /**
   * Delete intent.
   *
   * Delete an intent from a workspace.
   *
   * @param workspaceId The workspace ID.
   * @param intent      The intent name (for example, `pizza_order`).
   * @return the service call
   */
  public ServiceCall<Void> deleteIntent(String workspaceId, String intent) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    Validator.notNull(intent, "intent cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/workspaces/%s/intents/%s", workspaceId, intent));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get intent.
   *
   * Get information about an intent, optionally including all intent content.
   *
   * @param workspaceId The workspace ID.
   * @param intent      The intent name (for example, `pizza_order`).
   * @param export      Whether to include all element content in the returned data. If export=`false`, the returned
   *                    data includes only information about the element itself. If export=`true`, all content,
   *                    including subelements, is included. The default value is `false`.
   * @return the {@link IntentExportResponse} with the response
   */
  public ServiceCall<IntentExportResponse> getIntent(String workspaceId, String intent, Boolean export) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    Validator.notNull(intent, "intent cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/intents/%s", workspaceId, intent));
    builder.query(VERSION, versionDate);
    if (export != null) {
      builder.query("export", String.valueOf(export));
    }

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(IntentExportResponse.class));
  }

  /**
   * List intents.
   *
   * List the intents for a workspace.
   *
   * @param workspaceId  The workspace ID.
   * @param export       Whether to include all element content in the returned data. If export=`false`, the returned
   *                     data includes only information about the element itself. If export=`true`, all content,
   *                     including subelements, is included. The default value is `false`.
   * @param pageLimit    The number of records to return in each page of results. The default page limit is 100.
   * @param includeCount Whether to include information about the number of records returned.
   * @param sort         The sort order that determines the behavior of the pagination cursor.
   * @param cursor       A token identifying the last value from the previous page of results.
   * @return the {@link IntentCollectionResponse} with the response
   */
  public ServiceCall<IntentCollectionResponse> listIntents(String workspaceId, Boolean export, Long pageLimit,
                                                           Boolean includeCount, String sort, String cursor) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/intents", workspaceId));
    builder.query(VERSION, versionDate);
    if (export != null) {
      builder.query("export", String.valueOf(export));
    }
    if (pageLimit != null) {
      builder.query("page_limit", String.valueOf(pageLimit));
    }
    if (includeCount != null) {
      builder.query("include_count", String.valueOf(includeCount));
    }
    if (sort != null) {
      builder.query("sort", sort);
    }
    if (cursor != null) {
      builder.query("cursor", cursor);
    }

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(IntentCollectionResponse.class));
  }

  /**
   * Update intent.
   *
   * Update an existing intent with new or modified data. You must provide JSON data defining the content of the
   * updated intent.
   *
   * @param workspaceId    The workspace ID.
   * @param intent         The intent name (for example, `pizza_order`).
   * @param newIntent      The name of the intent.
   * @param newDescription The description of the intent.
   * @param newExamples    An array of user input examples for the intent.
   * @return the {@link IntentResponse} with the response
   */
  public ServiceCall<IntentResponse> updateIntent(String workspaceId, String intent, String newIntent, String
      newDescription, List<CreateExample> newExamples) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    Validator.notNull(intent, "intent cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/intents/%s", workspaceId, intent));
    builder.query(VERSION, versionDate);

    final JsonObject contentJson = new JsonObject();
    if (newIntent != null) {
      contentJson.addProperty("intent", newIntent);
    }
    if (newDescription != null) {
      contentJson.addProperty("description", newDescription);
    }
    if (newExamples != null) {
      contentJson.add("examples", GsonSingleton.getGson().toJsonTree(newExamples));
    }
    builder.bodyJson(contentJson);

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(IntentResponse.class));
  }

  /**
   * Create workspace.
   *
   * Create a workspace based on component objects. You must provide workspace components defining the content of the
   * new workspace.
   *
   * @param body Valid JSON data defining the content of the new workspace.
   * @return the {@link WorkspaceResponse} with the response
   */
  public ServiceCall<WorkspaceResponse> createWorkspace(CreateWorkspace body) {
    RequestBuilder builder = RequestBuilder.post("/v1/workspaces");
    builder.query(VERSION, versionDate);

    if (body != null) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(body).getAsJsonObject());
    } else {
      builder.bodyJson(new JsonObject());
    }

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(WorkspaceResponse.class));
  }

  /**
   * Delete workspace.
   *
   * Delete a workspace from the service instance.
   *
   * @param workspaceId The workspace ID.
   * @return the service call
   */
  public ServiceCall<Void> deleteWorkspace(String workspaceId) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/workspaces/%s", workspaceId));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get information about a workspace.
   *
   * Get information about a workspace, optionally including all workspace content.
   *
   * @param workspaceId The workspace ID.
   * @param export      Whether to include all element content in the returned data. If export=`false`, the returned
   *                    data includes only information about the element itself. If export=`true`, all content,
   *                    including subelements, is included. The default value is `false`.
   * @return the {@link WorkspaceExportResponse} with the response
   */
  public ServiceCall<WorkspaceExportResponse> getWorkspace(String workspaceId, Boolean export) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s", workspaceId));
    builder.query(VERSION, versionDate);
    if (export != null) {
      builder.query("export", String.valueOf(export));
    }

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(WorkspaceExportResponse.class));
  }

  /**
   * List workspaces.
   *
   * List the workspaces associated with a Conversation service instance.
   *
   * @param pageLimit    The number of records to return in each page of results. The default page limit is 100.
   * @param includeCount Whether to include information about the number of records returned.
   * @param sort         The sort order that determines the behavior of the pagination cursor.
   * @param cursor       A token identifying the last value from the previous page of results.
   * @return the {@link WorkspaceCollectionResponse} with the response
   */
  public ServiceCall<WorkspaceCollectionResponse> listWorkspaces(Long pageLimit, Boolean includeCount, String sort,
                                                                 String cursor) {
    RequestBuilder builder = RequestBuilder.get("/v1/workspaces");
    builder.query(VERSION, versionDate);
    if (pageLimit != null) {
      builder.query("page_limit", String.valueOf(pageLimit));
    }
    if (includeCount != null) {
      builder.query("include_count", String.valueOf(includeCount));
    }
    if (sort != null) {
      builder.query("sort", sort);
    }
    if (cursor != null) {
      builder.query("cursor", cursor);
    }

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(WorkspaceCollectionResponse.class));
  }

  /**
   * Update workspace.
   *
   * Update an existing workspace with new or modified data. You must provide component objects defining the content
   * of the updated workspace.
   *
   * @param workspaceId The workspace ID.
   * @param body        Valid JSON data defining the new workspace content. Any elements included in the new JSON
   *                    will completely replace the existing elements, including all subelements. Previously existing
   *                    subelements are not retained unless they are included in the new JSON.
   * @return the {@link WorkspaceResponse} with the response
   */
  public ServiceCall<WorkspaceResponse> updateWorkspace(String workspaceId, UpdateWorkspace body) {
    Validator.notNull(workspaceId, "workspaceId cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s", workspaceId));
    builder.query(VERSION, versionDate);

    if (body != null) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(body).getAsJsonObject());
    } else {
      builder.bodyJson(new JsonObject());
    }

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(WorkspaceResponse.class));
  }
}

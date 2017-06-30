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
import com.ibm.watson.developer_cloud.conversation.v1.model.Counterexample;
import com.ibm.watson.developer_cloud.conversation.v1.model.CounterexampleCollection;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateCounterexampleOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateEntityOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateExampleOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateIntentOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateSynonymOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateValueOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.CreateWorkspaceOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.DeleteCounterexampleOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.DeleteEntityOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.DeleteExampleOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.DeleteIntentOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.DeleteSynonymOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.DeleteValueOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.DeleteWorkspaceOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.Entity;
import com.ibm.watson.developer_cloud.conversation.v1.model.EntityCollection;
import com.ibm.watson.developer_cloud.conversation.v1.model.EntityExport;
import com.ibm.watson.developer_cloud.conversation.v1.model.Example;
import com.ibm.watson.developer_cloud.conversation.v1.model.ExampleCollection;
import com.ibm.watson.developer_cloud.conversation.v1.model.GetCounterexampleOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.GetEntityOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.GetExampleOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.GetIntentOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.GetSynonymOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.GetValueOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.GetWorkspaceOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.Intent;
import com.ibm.watson.developer_cloud.conversation.v1.model.IntentCollection;
import com.ibm.watson.developer_cloud.conversation.v1.model.IntentExport;
import com.ibm.watson.developer_cloud.conversation.v1.model.ListCounterexamplesOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.ListEntitiesOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.ListExamplesOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.ListIntentsOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.ListLogsOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.ListSynonymsOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.ListValuesOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.ListWorkspacesOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.LogCollection;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.Synonym;
import com.ibm.watson.developer_cloud.conversation.v1.model.SynonymCollection;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateCounterexampleOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateEntityOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateExampleOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateIntentOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateSynonymOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateValueOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.UpdateWorkspaceOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.Value;
import com.ibm.watson.developer_cloud.conversation.v1.model.ValueCollection;
import com.ibm.watson.developer_cloud.conversation.v1.model.ValueExport;
import com.ibm.watson.developer_cloud.conversation.v1.model.Workspace;
import com.ibm.watson.developer_cloud.conversation.v1.model.WorkspaceCollection;
import com.ibm.watson.developer_cloud.conversation.v1.model.WorkspaceExport;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The IBM Watson Conversation service combines machine learning, natural language understanding, and integrated dialog
 * tools to create conversation flows between your apps and your users.
 *
 * @version v1
 * @see <a href="http://www.ibm.com/watson/developercloud/conversation.html">Conversation</a>
 */
public class ConversationService extends WatsonService {

  private static final String SERVICE_NAME = "conversation";
  private static final String URL = "https://gateway.watsonplatform.net/conversation/api";

  private String versionDate;

  /** The Constant VERSION_DATE_2017_05_26. */
  public static final String VERSION_DATE_2017_05_26 = "2017-05-26";

  /**
   * Instantiates a new `Conversation`.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   */
  public ConversationService(String versionDate) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(),
        "'version cannot be null. Use " + VERSION_DATE_2017_05_26);

    this.versionDate = versionDate;
  }

  /**
   * Instantiates a new `Conversation` with username and password.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param username the username
   * @param password the password
   */
  public ConversationService(String versionDate, String username, String password) {
    this(versionDate);
    setUsernameAndPassword(username, password);
  }

  /**
   * Create counterexample.
   *
   * Add a new counterexample to a workspace. Counterexamples are examples that have been marked as irrelevant input.
   *
   * @param createCounterexampleOptions the {@link CreateCounterexampleOptions} containing the options for the call
   * @return the {@link Counterexample} with the response
   */
  public ServiceCall<Counterexample> createCounterexample(CreateCounterexampleOptions createCounterexampleOptions) {
    Validator.notNull(createCounterexampleOptions, "createCounterexampleOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/counterexamples",
        createCounterexampleOptions.workspaceId()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("text", createCounterexampleOptions.text());
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Counterexample.class));
  }

  /**
   * Delete counterexample.
   *
   * Delete a counterexample from a workspace. Counterexamples are examples that have been marked as irrelevant input.
   *
   * @param deleteCounterexampleOptions the {@link DeleteCounterexampleOptions} containing the options for the call
   * @return the service call
   */
  public ServiceCall<Void> deleteCounterexample(DeleteCounterexampleOptions deleteCounterexampleOptions) {
    Validator.notNull(deleteCounterexampleOptions, "deleteCounterexampleOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/workspaces/%s/counterexamples/%s",
        deleteCounterexampleOptions.workspaceId(), deleteCounterexampleOptions.text()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get counterexample.
   *
   * Get information about a counterexample. Counterexamples are examples that have been marked as irrelevant input.
   *
   * @param getCounterexampleOptions the {@link GetCounterexampleOptions} containing the options for the call
   * @return the {@link Counterexample} with the response
   */
  public ServiceCall<Counterexample> getCounterexample(GetCounterexampleOptions getCounterexampleOptions) {
    Validator.notNull(getCounterexampleOptions, "getCounterexampleOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/counterexamples/%s",
        getCounterexampleOptions.workspaceId(), getCounterexampleOptions.text()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Counterexample.class));
  }

  /**
   * List counterexamples.
   *
   * List the counterexamples for a workspace. Counterexamples are examples that have been marked as irrelevant input.
   *
   * @param listCounterexamplesOptions the {@link ListCounterexamplesOptions} containing the options for the call
   * @return the {@link CounterexampleCollection} with the response
   */
  public ServiceCall<CounterexampleCollection> listCounterexamples(
      ListCounterexamplesOptions listCounterexamplesOptions) {
    Validator.notNull(listCounterexamplesOptions, "listCounterexamplesOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/counterexamples",
        listCounterexamplesOptions.workspaceId()));
    builder.query(VERSION, versionDate);
    if (listCounterexamplesOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listCounterexamplesOptions.pageLimit()));
    }
    if (listCounterexamplesOptions.includeCount() != null) {
      builder.query("include_count", String.valueOf(listCounterexamplesOptions.includeCount()));
    }
    if (listCounterexamplesOptions.sort() != null) {
      builder.query("sort", listCounterexamplesOptions.sort());
    }
    if (listCounterexamplesOptions.cursor() != null) {
      builder.query("cursor", listCounterexamplesOptions.cursor());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(CounterexampleCollection.class));
  }

  /**
   * Update counterexample.
   *
   * Update the text of a counterexample. Counterexamples are examples that have been marked as irrelevant input.
   *
   * @param updateCounterexampleOptions the {@link UpdateCounterexampleOptions} containing the options for the call
   * @return the {@link Counterexample} with the response
   */
  public ServiceCall<Counterexample> updateCounterexample(UpdateCounterexampleOptions updateCounterexampleOptions) {
    Validator.notNull(updateCounterexampleOptions, "updateCounterexampleOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/counterexamples/%s",
        updateCounterexampleOptions.workspaceId(), updateCounterexampleOptions.text()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    if (updateCounterexampleOptions.newText() != null) {
      contentJson.addProperty("text", updateCounterexampleOptions.newText());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Counterexample.class));
  }

  /**
   * Create entity.
   *
   * Create a new entity.
   *
   * @param createEntityOptions the {@link CreateEntityOptions} containing the options for the call
   * @return the {@link Entity} with the response
   */
  public ServiceCall<Entity> createEntity(CreateEntityOptions createEntityOptions) {
    Validator.notNull(createEntityOptions, "createEntityOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/entities", createEntityOptions
        .workspaceId()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    if (createEntityOptions.metadata() != null) {
      contentJson.add("metadata", GsonSingleton.getGson().toJsonTree(createEntityOptions.metadata()));
    }
    if (createEntityOptions.values() != null) {
      contentJson.add("values", GsonSingleton.getGson().toJsonTree(createEntityOptions.values()));
    }
    if (createEntityOptions.fuzzyMatch() != null) {
      contentJson.addProperty("fuzzy_match", createEntityOptions.fuzzyMatch());
    }
    if (createEntityOptions.description() != null) {
      contentJson.addProperty("description", createEntityOptions.description());
    }
    contentJson.addProperty("entity", createEntityOptions.entity());
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Entity.class));
  }

  /**
   * Delete entity.
   *
   * Delete an entity from a workspace.
   *
   * @param deleteEntityOptions the {@link DeleteEntityOptions} containing the options for the call
   * @return the service call
   */
  public ServiceCall<Void> deleteEntity(DeleteEntityOptions deleteEntityOptions) {
    Validator.notNull(deleteEntityOptions, "deleteEntityOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/workspaces/%s/entities/%s", deleteEntityOptions
        .workspaceId(), deleteEntityOptions.entity()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get entity.
   *
   * Get information about an entity, optionally including all entity content.
   *
   * @param getEntityOptions the {@link GetEntityOptions} containing the options for the call
   * @return the {@link EntityExport} with the response
   */
  public ServiceCall<EntityExport> getEntity(GetEntityOptions getEntityOptions) {
    Validator.notNull(getEntityOptions, "getEntityOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/entities/%s", getEntityOptions
        .workspaceId(), getEntityOptions.entity()));
    builder.query(VERSION, versionDate);
    if (getEntityOptions.export() != null) {
      builder.query("export", String.valueOf(getEntityOptions.export()));
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(EntityExport.class));
  }

  /**
   * List entities.
   *
   * List the entities for a workspace.
   *
   * @param listEntitiesOptions the {@link ListEntitiesOptions} containing the options for the call
   * @return the {@link EntityCollection} with the response
   */
  public ServiceCall<EntityCollection> listEntities(ListEntitiesOptions listEntitiesOptions) {
    Validator.notNull(listEntitiesOptions, "listEntitiesOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/entities", listEntitiesOptions
        .workspaceId()));
    builder.query(VERSION, versionDate);
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
      builder.query("sort", listEntitiesOptions.sort());
    }
    if (listEntitiesOptions.cursor() != null) {
      builder.query("cursor", listEntitiesOptions.cursor());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(EntityCollection.class));
  }

  /**
   * Update entity.
   *
   * Update an existing entity with new or modified data.
   *
   * @param updateEntityOptions the {@link UpdateEntityOptions} containing the options for the call
   * @return the {@link Entity} with the response
   */
  public ServiceCall<Entity> updateEntity(UpdateEntityOptions updateEntityOptions) {
    Validator.notNull(updateEntityOptions, "updateEntityOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/entities/%s", updateEntityOptions
        .workspaceId(), updateEntityOptions.entity()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    if (updateEntityOptions.newFuzzyMatch() != null) {
      contentJson.addProperty("fuzzy_match", updateEntityOptions.newFuzzyMatch());
    }
    if (updateEntityOptions.newEntity() != null) {
      contentJson.addProperty("entity", updateEntityOptions.newEntity());
    }
    if (updateEntityOptions.newMetadata() != null) {
      contentJson.add("metadata", GsonSingleton.getGson().toJsonTree(updateEntityOptions.newMetadata()));
    }
    if (updateEntityOptions.newValues() != null) {
      contentJson.add("values", GsonSingleton.getGson().toJsonTree(updateEntityOptions.newValues()));
    }
    if (updateEntityOptions.newDescription() != null) {
      contentJson.addProperty("description", updateEntityOptions.newDescription());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Entity.class));
  }

  /**
   * Create user input example.
   *
   * Add a new user input example to an intent.
   *
   * @param createExampleOptions the {@link CreateExampleOptions} containing the options for the call
   * @return the {@link Example} with the response
   */
  public ServiceCall<Example> createExample(CreateExampleOptions createExampleOptions) {
    Validator.notNull(createExampleOptions, "createExampleOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/intents/%s/examples",
        createExampleOptions.workspaceId(), createExampleOptions.intent()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("text", createExampleOptions.text());
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Example.class));
  }

  /**
   * Delete user input example.
   *
   * Delete a user input example from an intent.
   *
   * @param deleteExampleOptions the {@link DeleteExampleOptions} containing the options for the call
   * @return the service call
   */
  public ServiceCall<Void> deleteExample(DeleteExampleOptions deleteExampleOptions) {
    Validator.notNull(deleteExampleOptions, "deleteExampleOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/workspaces/%s/intents/%s/examples/%s",
        deleteExampleOptions.workspaceId(), deleteExampleOptions.intent(), deleteExampleOptions.text()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get user input example.
   *
   * Get information about a user input example.
   *
   * @param getExampleOptions the {@link GetExampleOptions} containing the options for the call
   * @return the {@link Example} with the response
   */
  public ServiceCall<Example> getExample(GetExampleOptions getExampleOptions) {
    Validator.notNull(getExampleOptions, "getExampleOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/intents/%s/examples/%s",
        getExampleOptions.workspaceId(), getExampleOptions.intent(), getExampleOptions.text()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Example.class));
  }

  /**
   * List user input examples.
   *
   * List the user input examples for an intent.
   *
   * @param listExamplesOptions the {@link ListExamplesOptions} containing the options for the call
   * @return the {@link ExampleCollection} with the response
   */
  public ServiceCall<ExampleCollection> listExamples(ListExamplesOptions listExamplesOptions) {
    Validator.notNull(listExamplesOptions, "listExamplesOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/intents/%s/examples",
        listExamplesOptions.workspaceId(), listExamplesOptions.intent()));
    builder.query(VERSION, versionDate);
    if (listExamplesOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listExamplesOptions.pageLimit()));
    }
    if (listExamplesOptions.includeCount() != null) {
      builder.query("include_count", String.valueOf(listExamplesOptions.includeCount()));
    }
    if (listExamplesOptions.sort() != null) {
      builder.query("sort", listExamplesOptions.sort());
    }
    if (listExamplesOptions.cursor() != null) {
      builder.query("cursor", listExamplesOptions.cursor());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ExampleCollection.class));
  }

  /**
   * Update user input example.
   *
   * Update the text of a user input example.
   *
   * @param updateExampleOptions the {@link UpdateExampleOptions} containing the options for the call
   * @return the {@link Example} with the response
   */
  public ServiceCall<Example> updateExample(UpdateExampleOptions updateExampleOptions) {
    Validator.notNull(updateExampleOptions, "updateExampleOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/intents/%s/examples/%s",
        updateExampleOptions.workspaceId(), updateExampleOptions.intent(), updateExampleOptions.text()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    if (updateExampleOptions.newText() != null) {
      contentJson.addProperty("text", updateExampleOptions.newText());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Example.class));
  }

  /**
   * Create intent.
   *
   * Create a new intent.
   *
   * @param createIntentOptions the {@link CreateIntentOptions} containing the options for the call
   * @return the {@link Intent} with the response
   */
  public ServiceCall<Intent> createIntent(CreateIntentOptions createIntentOptions) {
    Validator.notNull(createIntentOptions, "createIntentOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/intents", createIntentOptions
        .workspaceId()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    if (createIntentOptions.examples() != null) {
      contentJson.add("examples", GsonSingleton.getGson().toJsonTree(createIntentOptions.examples()));
    }
    if (createIntentOptions.description() != null) {
      contentJson.addProperty("description", createIntentOptions.description());
    }
    contentJson.addProperty("intent", createIntentOptions.intent());
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Intent.class));
  }

  /**
   * Delete intent.
   *
   * Delete an intent from a workspace.
   *
   * @param deleteIntentOptions the {@link DeleteIntentOptions} containing the options for the call
   * @return the service call
   */
  public ServiceCall<Void> deleteIntent(DeleteIntentOptions deleteIntentOptions) {
    Validator.notNull(deleteIntentOptions, "deleteIntentOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/workspaces/%s/intents/%s", deleteIntentOptions
        .workspaceId(), deleteIntentOptions.intent()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get intent.
   *
   * Get information about an intent, optionally including all intent content.
   *
   * @param getIntentOptions the {@link GetIntentOptions} containing the options for the call
   * @return the {@link IntentExport} with the response
   */
  public ServiceCall<IntentExport> getIntent(GetIntentOptions getIntentOptions) {
    Validator.notNull(getIntentOptions, "getIntentOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/intents/%s", getIntentOptions
        .workspaceId(), getIntentOptions.intent()));
    builder.query(VERSION, versionDate);
    if (getIntentOptions.export() != null) {
      builder.query("export", String.valueOf(getIntentOptions.export()));
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(IntentExport.class));
  }

  /**
   * List intents.
   *
   * List the intents for a workspace.
   *
   * @param listIntentsOptions the {@link ListIntentsOptions} containing the options for the call
   * @return the {@link IntentCollection} with the response
   */
  public ServiceCall<IntentCollection> listIntents(ListIntentsOptions listIntentsOptions) {
    Validator.notNull(listIntentsOptions, "listIntentsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/intents", listIntentsOptions
        .workspaceId()));
    builder.query(VERSION, versionDate);
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
      builder.query("sort", listIntentsOptions.sort());
    }
    if (listIntentsOptions.cursor() != null) {
      builder.query("cursor", listIntentsOptions.cursor());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(IntentCollection.class));
  }

  /**
   * Update intent.
   *
   * Update an existing intent with new or modified data. You must provide data defining the content of the updated
   * intent.
   *
   * @param updateIntentOptions the {@link UpdateIntentOptions} containing the options for the call
   * @return the {@link Intent} with the response
   */
  public ServiceCall<Intent> updateIntent(UpdateIntentOptions updateIntentOptions) {
    Validator.notNull(updateIntentOptions, "updateIntentOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/intents/%s", updateIntentOptions
        .workspaceId(), updateIntentOptions.intent()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    if (updateIntentOptions.newIntent() != null) {
      contentJson.addProperty("intent", updateIntentOptions.newIntent());
    }
    if (updateIntentOptions.newExamples() != null) {
      contentJson.add("examples", GsonSingleton.getGson().toJsonTree(updateIntentOptions.newExamples()));
    }
    if (updateIntentOptions.newDescription() != null) {
      contentJson.addProperty("description", updateIntentOptions.newDescription());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Intent.class));
  }

  /**
   * List log events.
   *
   * @param listLogsOptions the {@link ListLogsOptions} containing the options for the call
   * @return the {@link LogCollection} with the response
   */
  public ServiceCall<LogCollection> listLogs(ListLogsOptions listLogsOptions) {
    Validator.notNull(listLogsOptions, "listLogsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/logs", listLogsOptions.workspaceId()));
    builder.query(VERSION, versionDate);
    if (listLogsOptions.sort() != null) {
      builder.query("sort", listLogsOptions.sort());
    }
    if (listLogsOptions.filter() != null) {
      builder.query("filter", listLogsOptions.filter());
    }
    if (listLogsOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listLogsOptions.pageLimit()));
    }
    if (listLogsOptions.cursor() != null) {
      builder.query("cursor", listLogsOptions.cursor());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(LogCollection.class));
  }

  /**
   * Get a response to a user's input.
   *
   * @param messageOptions the {@link MessageOptions} containing the options for the call
   * @return the {@link MessageResponse} with the response
   */
  public ServiceCall<MessageResponse> message(MessageOptions messageOptions) {
    Validator.notNull(messageOptions, "messageOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/message", messageOptions
        .workspaceId()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    if (messageOptions.output() != null) {
      contentJson.add("output", GsonSingleton.getGson().toJsonTree(messageOptions.output()));
    }
    if (messageOptions.input() != null) {
      contentJson.add("input", GsonSingleton.getGson().toJsonTree(messageOptions.input()));
    }
    if (messageOptions.intents() != null) {
      contentJson.add("intents", GsonSingleton.getGson().toJsonTree(messageOptions.intents()));
    }
    if (messageOptions.entities() != null) {
      contentJson.add("entities", GsonSingleton.getGson().toJsonTree(messageOptions.entities()));
    }
    if (messageOptions.alternateIntents() != null) {
      contentJson.addProperty("alternate_intents", messageOptions.alternateIntents());
    }
    if (messageOptions.context() != null) {
      contentJson.add("context", GsonSingleton.getGson().toJsonTree(messageOptions.context()));
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(MessageResponse.class));
  }

  /**
   * Add entity value synonym.
   *
   * Add a new synonym to an entity value.
   *
   * @param createSynonymOptions the {@link CreateSynonymOptions} containing the options for the call
   * @return the {@link Synonym} with the response
   */
  public ServiceCall<Synonym> createSynonym(CreateSynonymOptions createSynonymOptions) {
    Validator.notNull(createSynonymOptions, "createSynonymOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/entities/%s/values/%s/synonyms",
        createSynonymOptions.workspaceId(), createSynonymOptions.entity(), createSynonymOptions.value()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("synonym", createSynonymOptions.synonym());
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Synonym.class));
  }

  /**
   * Delete entity value synonym.
   *
   * Delete a synonym for an entity value.
   *
   * @param deleteSynonymOptions the {@link DeleteSynonymOptions} containing the options for the call
   * @return the service call
   */
  public ServiceCall<Void> deleteSynonym(DeleteSynonymOptions deleteSynonymOptions) {
    Validator.notNull(deleteSynonymOptions, "deleteSynonymOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/workspaces/%s/entities/%s/values/%s/synonyms/%s",
        deleteSynonymOptions.workspaceId(), deleteSynonymOptions.entity(), deleteSynonymOptions.value(),
        deleteSynonymOptions.synonym()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get entity value synonym.
   *
   * Get information about a synonym for an entity value.
   *
   * @param getSynonymOptions the {@link GetSynonymOptions} containing the options for the call
   * @return the {@link Synonym} with the response
   */
  public ServiceCall<Synonym> getSynonym(GetSynonymOptions getSynonymOptions) {
    Validator.notNull(getSynonymOptions, "getSynonymOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/entities/%s/values/%s/synonyms/%s",
        getSynonymOptions.workspaceId(), getSynonymOptions.entity(), getSynonymOptions.value(), getSynonymOptions
            .synonym()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Synonym.class));
  }

  /**
   * List entity value synonyms.
   *
   * List the synonyms for an entity value.
   *
   * @param listSynonymsOptions the {@link ListSynonymsOptions} containing the options for the call
   * @return the {@link SynonymCollection} with the response
   */
  public ServiceCall<SynonymCollection> listSynonyms(ListSynonymsOptions listSynonymsOptions) {
    Validator.notNull(listSynonymsOptions, "listSynonymsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/entities/%s/values/%s/synonyms",
        listSynonymsOptions.workspaceId(), listSynonymsOptions.entity(), listSynonymsOptions.value()));
    builder.query(VERSION, versionDate);
    if (listSynonymsOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listSynonymsOptions.pageLimit()));
    }
    if (listSynonymsOptions.includeCount() != null) {
      builder.query("include_count", String.valueOf(listSynonymsOptions.includeCount()));
    }
    if (listSynonymsOptions.sort() != null) {
      builder.query("sort", listSynonymsOptions.sort());
    }
    if (listSynonymsOptions.cursor() != null) {
      builder.query("cursor", listSynonymsOptions.cursor());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(SynonymCollection.class));
  }

  /**
   * Update entity value synonym.
   *
   * Update the information about a synonym for an entity value.
   *
   * @param updateSynonymOptions the {@link UpdateSynonymOptions} containing the options for the call
   * @return the {@link Synonym} with the response
   */
  public ServiceCall<Synonym> updateSynonym(UpdateSynonymOptions updateSynonymOptions) {
    Validator.notNull(updateSynonymOptions, "updateSynonymOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/entities/%s/values/%s/synonyms/%s",
        updateSynonymOptions.workspaceId(), updateSynonymOptions.entity(), updateSynonymOptions.value(),
        updateSynonymOptions.synonym()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    if (updateSynonymOptions.newSynonym() != null) {
      contentJson.addProperty("synonym", updateSynonymOptions.newSynonym());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Synonym.class));
  }

  /**
   * Add entity value.
   *
   * Create a new value for an entity.
   *
   * @param createValueOptions the {@link CreateValueOptions} containing the options for the call
   * @return the {@link Value} with the response
   */
  public ServiceCall<Value> createValue(CreateValueOptions createValueOptions) {
    Validator.notNull(createValueOptions, "createValueOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/entities/%s/values",
        createValueOptions.workspaceId(), createValueOptions.entity()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    if (createValueOptions.metadata() != null) {
      contentJson.add("metadata", GsonSingleton.getGson().toJsonTree(createValueOptions.metadata()));
    }
    if (createValueOptions.synonyms() != null) {
      contentJson.add("synonyms", GsonSingleton.getGson().toJsonTree(createValueOptions.synonyms()));
    }
    contentJson.addProperty("value", createValueOptions.value());
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Value.class));
  }

  /**
   * Delete entity value.
   *
   * Delete a value for an entity.
   *
   * @param deleteValueOptions the {@link DeleteValueOptions} containing the options for the call
   * @return the service call
   */
  public ServiceCall<Void> deleteValue(DeleteValueOptions deleteValueOptions) {
    Validator.notNull(deleteValueOptions, "deleteValueOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/workspaces/%s/entities/%s/values/%s",
        deleteValueOptions.workspaceId(), deleteValueOptions.entity(), deleteValueOptions.value()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get entity value.
   *
   * Get information about an entity value.
   *
   * @param getValueOptions the {@link GetValueOptions} containing the options for the call
   * @return the {@link ValueExport} with the response
   */
  public ServiceCall<ValueExport> getValue(GetValueOptions getValueOptions) {
    Validator.notNull(getValueOptions, "getValueOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/entities/%s/values/%s", getValueOptions
        .workspaceId(), getValueOptions.entity(), getValueOptions.value()));
    builder.query(VERSION, versionDate);
    if (getValueOptions.export() != null) {
      builder.query("export", String.valueOf(getValueOptions.export()));
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ValueExport.class));
  }

  /**
   * List entity values.
   *
   * List the values for an entity.
   *
   * @param listValuesOptions the {@link ListValuesOptions} containing the options for the call
   * @return the {@link ValueCollection} with the response
   */
  public ServiceCall<ValueCollection> listValues(ListValuesOptions listValuesOptions) {
    Validator.notNull(listValuesOptions, "listValuesOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s/entities/%s/values", listValuesOptions
        .workspaceId(), listValuesOptions.entity()));
    builder.query(VERSION, versionDate);
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
      builder.query("sort", listValuesOptions.sort());
    }
    if (listValuesOptions.cursor() != null) {
      builder.query("cursor", listValuesOptions.cursor());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ValueCollection.class));
  }

  /**
   * Update entity value.
   *
   * Update the content of a value for an entity.
   *
   * @param updateValueOptions the {@link UpdateValueOptions} containing the options for the call
   * @return the {@link Value} with the response
   */
  public ServiceCall<Value> updateValue(UpdateValueOptions updateValueOptions) {
    Validator.notNull(updateValueOptions, "updateValueOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s/entities/%s/values/%s",
        updateValueOptions.workspaceId(), updateValueOptions.entity(), updateValueOptions.value()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    if (updateValueOptions.newSynonyms() != null) {
      contentJson.add("synonyms", GsonSingleton.getGson().toJsonTree(updateValueOptions.newSynonyms()));
    }
    if (updateValueOptions.newMetadata() != null) {
      contentJson.add("metadata", GsonSingleton.getGson().toJsonTree(updateValueOptions.newMetadata()));
    }
    if (updateValueOptions.newValue() != null) {
      contentJson.addProperty("value", updateValueOptions.newValue());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Value.class));
  }

  /**
   * Create workspace.
   *
   * Create a workspace based on component objects. You must provide workspace components defining the content of the
   * new workspace.
   *
   * @param createWorkspaceOptions the {@link CreateWorkspaceOptions} containing the options for the call
   * @return the {@link Workspace} with the response
   */
  public ServiceCall<Workspace> createWorkspace(CreateWorkspaceOptions createWorkspaceOptions) {
    RequestBuilder builder = RequestBuilder.post("/v1/workspaces");
    builder.query(VERSION, versionDate);
    if (createWorkspaceOptions != null) {
      final JsonObject contentJson = new JsonObject();
      if (createWorkspaceOptions.metadata() != null) {
        contentJson.add("metadata", GsonSingleton.getGson().toJsonTree(createWorkspaceOptions.metadata()));
      }
      if (createWorkspaceOptions.intents() != null) {
        contentJson.add("intents", GsonSingleton.getGson().toJsonTree(createWorkspaceOptions.intents()));
      }
      if (createWorkspaceOptions.entities() != null) {
        contentJson.add("entities", GsonSingleton.getGson().toJsonTree(createWorkspaceOptions.entities()));
      }
      if (createWorkspaceOptions.name() != null) {
        contentJson.addProperty("name", createWorkspaceOptions.name());
      }
      if (createWorkspaceOptions.counterexamples() != null) {
        contentJson.add("counterexamples", GsonSingleton.getGson().toJsonTree(createWorkspaceOptions
            .counterexamples()));
      }
      if (createWorkspaceOptions.description() != null) {
        contentJson.addProperty("description", createWorkspaceOptions.description());
      }
      if (createWorkspaceOptions.language() != null) {
        contentJson.addProperty("language", createWorkspaceOptions.language());
      }
      if (createWorkspaceOptions.dialogNodes() != null) {
        contentJson.add("dialog_nodes", GsonSingleton.getGson().toJsonTree(createWorkspaceOptions.dialogNodes()));
      }
      builder.bodyJson(contentJson);
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Workspace.class));
  }

  /**
   * Delete workspace.
   *
   * Delete a workspace from the service instance.
   *
   * @param deleteWorkspaceOptions the {@link DeleteWorkspaceOptions} containing the options for the call
   * @return the service call
   */
  public ServiceCall<Void> deleteWorkspace(DeleteWorkspaceOptions deleteWorkspaceOptions) {
    Validator.notNull(deleteWorkspaceOptions, "deleteWorkspaceOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/workspaces/%s", deleteWorkspaceOptions
        .workspaceId()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get information about a workspace.
   *
   * Get information about a workspace, optionally including all workspace content.
   *
   * @param getWorkspaceOptions the {@link GetWorkspaceOptions} containing the options for the call
   * @return the {@link WorkspaceExport} with the response
   */
  public ServiceCall<WorkspaceExport> getWorkspace(GetWorkspaceOptions getWorkspaceOptions) {
    Validator.notNull(getWorkspaceOptions, "getWorkspaceOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/workspaces/%s", getWorkspaceOptions.workspaceId()));
    builder.query(VERSION, versionDate);
    if (getWorkspaceOptions.export() != null) {
      builder.query("export", String.valueOf(getWorkspaceOptions.export()));
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(WorkspaceExport.class));
  }

  /**
   * List workspaces.
   *
   * List the workspaces associated with a Conversation service instance.
   *
   * @param listWorkspacesOptions the {@link ListWorkspacesOptions} containing the options for the call
   * @return the {@link WorkspaceCollection} with the response
   */
  public ServiceCall<WorkspaceCollection> listWorkspaces(ListWorkspacesOptions listWorkspacesOptions) {
    RequestBuilder builder = RequestBuilder.get("/v1/workspaces");
    builder.query(VERSION, versionDate);
    if (listWorkspacesOptions != null) {
      if (listWorkspacesOptions.pageLimit() != null) {
        builder.query("page_limit", String.valueOf(listWorkspacesOptions.pageLimit()));
      }
      if (listWorkspacesOptions.includeCount() != null) {
        builder.query("include_count", String.valueOf(listWorkspacesOptions.includeCount()));
      }
      if (listWorkspacesOptions.sort() != null) {
        builder.query("sort", listWorkspacesOptions.sort());
      }
      if (listWorkspacesOptions.cursor() != null) {
        builder.query("cursor", listWorkspacesOptions.cursor());
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(WorkspaceCollection.class));
  }

  /**
   * Update workspace.
   *
   * Update an existing workspace with new or modified data. You must provide component objects defining the content of
   * the updated workspace.
   *
   * @param updateWorkspaceOptions the {@link UpdateWorkspaceOptions} containing the options for the call
   * @return the {@link Workspace} with the response
   */
  public ServiceCall<Workspace> updateWorkspace(UpdateWorkspaceOptions updateWorkspaceOptions) {
    Validator.notNull(updateWorkspaceOptions, "updateWorkspaceOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/workspaces/%s", updateWorkspaceOptions
        .workspaceId()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    if (updateWorkspaceOptions.metadata() != null) {
      contentJson.add("metadata", GsonSingleton.getGson().toJsonTree(updateWorkspaceOptions.metadata()));
    }
    if (updateWorkspaceOptions.intents() != null) {
      contentJson.add("intents", GsonSingleton.getGson().toJsonTree(updateWorkspaceOptions.intents()));
    }
    if (updateWorkspaceOptions.entities() != null) {
      contentJson.add("entities", GsonSingleton.getGson().toJsonTree(updateWorkspaceOptions.entities()));
    }
    if (updateWorkspaceOptions.name() != null) {
      contentJson.addProperty("name", updateWorkspaceOptions.name());
    }
    if (updateWorkspaceOptions.counterexamples() != null) {
      contentJson.add("counterexamples", GsonSingleton.getGson().toJsonTree(updateWorkspaceOptions.counterexamples()));
    }
    if (updateWorkspaceOptions.description() != null) {
      contentJson.addProperty("description", updateWorkspaceOptions.description());
    }
    if (updateWorkspaceOptions.language() != null) {
      contentJson.addProperty("language", updateWorkspaceOptions.language());
    }
    if (updateWorkspaceOptions.dialogNodes() != null) {
      contentJson.add("dialog_nodes", GsonSingleton.getGson().toJsonTree(updateWorkspaceOptions.dialogNodes()));
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Workspace.class));
  }

}

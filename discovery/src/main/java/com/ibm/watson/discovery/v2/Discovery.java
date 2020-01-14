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
package com.ibm.watson.discovery.v2;

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
import com.ibm.watson.discovery.v2.model.AddDocumentOptions;
import com.ibm.watson.discovery.v2.model.Completions;
import com.ibm.watson.discovery.v2.model.ComponentSettingsResponse;
import com.ibm.watson.discovery.v2.model.CreateTrainingQueryOptions;
import com.ibm.watson.discovery.v2.model.DeleteDocumentOptions;
import com.ibm.watson.discovery.v2.model.DeleteDocumentResponse;
import com.ibm.watson.discovery.v2.model.DeleteTrainingQueriesOptions;
import com.ibm.watson.discovery.v2.model.DocumentAccepted;
import com.ibm.watson.discovery.v2.model.GetAutocompletionOptions;
import com.ibm.watson.discovery.v2.model.GetComponentSettingsOptions;
import com.ibm.watson.discovery.v2.model.GetTrainingQueryOptions;
import com.ibm.watson.discovery.v2.model.ListCollectionsOptions;
import com.ibm.watson.discovery.v2.model.ListCollectionsResponse;
import com.ibm.watson.discovery.v2.model.ListFieldsOptions;
import com.ibm.watson.discovery.v2.model.ListFieldsResponse;
import com.ibm.watson.discovery.v2.model.ListTrainingQueriesOptions;
import com.ibm.watson.discovery.v2.model.QueryNoticesOptions;
import com.ibm.watson.discovery.v2.model.QueryNoticesResponse;
import com.ibm.watson.discovery.v2.model.QueryOptions;
import com.ibm.watson.discovery.v2.model.QueryResponse;
import com.ibm.watson.discovery.v2.model.TrainingQuery;
import com.ibm.watson.discovery.v2.model.TrainingQuerySet;
import com.ibm.watson.discovery.v2.model.UpdateDocumentOptions;
import com.ibm.watson.discovery.v2.model.UpdateTrainingQueryOptions;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.MultipartBody;

/**
 * IBM Watson&trade; Discovery for IBM Cloud Pak for Data is a cognitive search and content analytics engine that you
 * can add to applications to identify patterns, trends and actionable insights to drive better decision-making.
 * Securely unify structured and unstructured data with pre-enriched content, and use a simplified query language to
 * eliminate the need for manual filtering of results.
 *
 * @version v2
 * @see <a href="https://cloud.ibm.com/docs/services/discovery-data/">Discovery</a>
 */
public class Discovery extends BaseService {

  private static final String DEFAULT_SERVICE_NAME = "discovery";

  private String versionDate;

  /**
   * Constructs a new `Discovery` client using the DEFAULT_SERVICE_NAME.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   */
  public Discovery(String versionDate) {
    this(versionDate, DEFAULT_SERVICE_NAME, ConfigBasedAuthenticatorFactory.getAuthenticator(DEFAULT_SERVICE_NAME));
  }

  /**
   * Constructs a new `Discovery` client with the DEFAULT_SERVICE_NAME
   * and the specified Authenticator.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param authenticator the Authenticator instance to be configured for this service
   */
  public Discovery(String versionDate, Authenticator authenticator) {
    this(versionDate, DEFAULT_SERVICE_NAME, authenticator);
  }

  /**
   * Constructs a new `Discovery` client with the specified serviceName.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param serviceName The name of the service to configure.
   */
  public Discovery(String versionDate, String serviceName) {
    this(versionDate, serviceName, ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName));
  }

  /**
   * Constructs a new `Discovery` client with the specified Authenticator
   * and serviceName.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param serviceName The name of the service to configure.
   * @param authenticator the Authenticator instance to be configured for this service
   */
  public Discovery(String versionDate, String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    com.ibm.cloud.sdk.core.util.Validator.isTrue((versionDate != null) && !versionDate.isEmpty(),
        "version cannot be null.");
    this.versionDate = versionDate;
    this.configureService(serviceName);
  }

  /**
   * List collections.
   *
   * Lists existing collections for the specified project.
   *
   * @param listCollectionsOptions the {@link ListCollectionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ListCollectionsResponse}
   */
  public ServiceCall<ListCollectionsResponse> listCollections(ListCollectionsOptions listCollectionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listCollectionsOptions,
        "listCollectionsOptions cannot be null");
    String[] pathSegments = { "v2/projects", "collections" };
    String[] pathParameters = { listCollectionsOptions.projectId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "listCollections");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<ListCollectionsResponse> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<ListCollectionsResponse>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a project.
   *
   * By using this method, you can construct queries. For details, see the [Discovery
   * documentation](https://cloud.ibm.com/docs/services/discovery-data?topic=discovery-data-query-concepts).
   *
   * @param queryOptions the {@link QueryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link QueryResponse}
   */
  public ServiceCall<QueryResponse> query(QueryOptions queryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(queryOptions,
        "queryOptions cannot be null");
    String[] pathSegments = { "v2/projects", "query" };
    String[] pathParameters = { queryOptions.projectId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "query");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (queryOptions.collectionIds() != null) {
      contentJson.add("collection_ids", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(queryOptions
          .collectionIds()));
    }
    if (queryOptions.filter() != null) {
      contentJson.addProperty("filter", queryOptions.filter());
    }
    if (queryOptions.query() != null) {
      contentJson.addProperty("query", queryOptions.query());
    }
    if (queryOptions.naturalLanguageQuery() != null) {
      contentJson.addProperty("natural_language_query", queryOptions.naturalLanguageQuery());
    }
    if (queryOptions.aggregation() != null) {
      contentJson.addProperty("aggregation", queryOptions.aggregation());
    }
    if (queryOptions.count() != null) {
      contentJson.addProperty("count", queryOptions.count());
    }
    if (queryOptions.xReturn() != null) {
      contentJson.add("return", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(queryOptions.xReturn()));
    }
    if (queryOptions.offset() != null) {
      contentJson.addProperty("offset", queryOptions.offset());
    }
    if (queryOptions.sort() != null) {
      contentJson.addProperty("sort", queryOptions.sort());
    }
    if (queryOptions.highlight() != null) {
      contentJson.addProperty("highlight", queryOptions.highlight());
    }
    if (queryOptions.spellingSuggestions() != null) {
      contentJson.addProperty("spelling_suggestions", queryOptions.spellingSuggestions());
    }
    if (queryOptions.tableResults() != null) {
      contentJson.add("table_results", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(queryOptions
          .tableResults()));
    }
    if (queryOptions.suggestedRefinements() != null) {
      contentJson.add("suggested_refinements", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(
          queryOptions.suggestedRefinements()));
    }
    if (queryOptions.passages() != null) {
      contentJson.add("passages", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(queryOptions
          .passages()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<QueryResponse> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<QueryResponse>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get Autocomplete Suggestions.
   *
   * Returns completion query suggestions for the specified prefix.
   *
   * @param getAutocompletionOptions the {@link GetAutocompletionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Completions}
   */
  public ServiceCall<Completions> getAutocompletion(GetAutocompletionOptions getAutocompletionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAutocompletionOptions,
        "getAutocompletionOptions cannot be null");
    String[] pathSegments = { "v2/projects", "autocompletion" };
    String[] pathParameters = { getAutocompletionOptions.projectId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "getAutocompletion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("prefix", getAutocompletionOptions.prefix());
    if (getAutocompletionOptions.collectionIds() != null) {
      builder.query("collection_ids", RequestUtils.join(getAutocompletionOptions.collectionIds(), ","));
    }
    if (getAutocompletionOptions.field() != null) {
      builder.query("field", getAutocompletionOptions.field());
    }
    if (getAutocompletionOptions.count() != null) {
      builder.query("count", String.valueOf(getAutocompletionOptions.count()));
    }
    ResponseConverter<Completions> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Completions>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query system notices.
   *
   * Queries for notices (errors or warnings) that might have been generated by the system. Notices are generated when
   * ingesting documents and performing relevance training.
   *
   * @param queryNoticesOptions the {@link QueryNoticesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link QueryNoticesResponse}
   */
  public ServiceCall<QueryNoticesResponse> queryNotices(QueryNoticesOptions queryNoticesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(queryNoticesOptions,
        "queryNoticesOptions cannot be null");
    String[] pathSegments = { "v2/projects", "notices" };
    String[] pathParameters = { queryNoticesOptions.projectId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "queryNotices");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (queryNoticesOptions.filter() != null) {
      builder.query("filter", queryNoticesOptions.filter());
    }
    if (queryNoticesOptions.query() != null) {
      builder.query("query", queryNoticesOptions.query());
    }
    if (queryNoticesOptions.naturalLanguageQuery() != null) {
      builder.query("natural_language_query", queryNoticesOptions.naturalLanguageQuery());
    }
    if (queryNoticesOptions.count() != null) {
      builder.query("count", String.valueOf(queryNoticesOptions.count()));
    }
    if (queryNoticesOptions.offset() != null) {
      builder.query("offset", String.valueOf(queryNoticesOptions.offset()));
    }
    ResponseConverter<QueryNoticesResponse> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<QueryNoticesResponse>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List fields.
   *
   * Gets a list of the unique fields (and their types) stored in the the specified collections.
   *
   * @param listFieldsOptions the {@link ListFieldsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ListFieldsResponse}
   */
  public ServiceCall<ListFieldsResponse> listFields(ListFieldsOptions listFieldsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listFieldsOptions,
        "listFieldsOptions cannot be null");
    String[] pathSegments = { "v2/projects", "fields" };
    String[] pathParameters = { listFieldsOptions.projectId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "listFields");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listFieldsOptions.collectionIds() != null) {
      builder.query("collection_ids", RequestUtils.join(listFieldsOptions.collectionIds(), ","));
    }
    ResponseConverter<ListFieldsResponse> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<ListFieldsResponse>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Configuration settings for components.
   *
   * Returns default configuration settings for components.
   *
   * @param getComponentSettingsOptions the {@link GetComponentSettingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ComponentSettingsResponse}
   */
  public ServiceCall<ComponentSettingsResponse> getComponentSettings(
      GetComponentSettingsOptions getComponentSettingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getComponentSettingsOptions,
        "getComponentSettingsOptions cannot be null");
    String[] pathSegments = { "v2/projects", "component_settings" };
    String[] pathParameters = { getComponentSettingsOptions.projectId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "getComponentSettings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<ComponentSettingsResponse> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<ComponentSettingsResponse>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add a document.
   *
   * Add a document to a collection with optional metadata.
   *
   * Returns immediately after the system has accepted the document for processing.
   *
   * * The user must provide document content, metadata, or both. If the request is missing both document content and
   * metadata, it is rejected.
   *
   * * The user can set the **Content-Type** parameter on the **file** part to indicate the media type of the
   * document. If the **Content-Type** parameter is missing or is one of the generic media types (for example,
   * `application/octet-stream`), then the service attempts to automatically detect the document's media type.
   *
   * * The following field names are reserved and will be filtered out if present after normalization: `id`, `score`,
   * `highlight`, and any field with the prefix of: `_`, `+`, or `-`
   *
   * * Fields with empty name values after normalization are filtered out before indexing.
   *
   * * Fields containing the following characters after normalization are filtered out before indexing: `#` and `,`
   *
   * If the document is uploaded to a collection that has it's data shared with another collection, the
   * **X-Watson-Discovery-Force** header must be set to `true`.
   *
   * **Note:** Documents can be added with a specific **document_id** by using the
   * **_/v2/projects/{project_id}/collections/{collection_id}/documents** method.
   *
   * **Note:** This operation only works on collections created to accept direct file uploads. It cannot be used to
   * modify a collection that connects to an external source such as Microsoft SharePoint.
   *
   * @param addDocumentOptions the {@link AddDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link DocumentAccepted}
   */
  public ServiceCall<DocumentAccepted> addDocument(AddDocumentOptions addDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addDocumentOptions,
        "addDocumentOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue((addDocumentOptions.file() != null) || (addDocumentOptions
        .metadata() != null), "At least one of file or metadata must be supplied.");
    String[] pathSegments = { "v2/projects", "collections", "documents" };
    String[] pathParameters = { addDocumentOptions.projectId(), addDocumentOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "addDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (addDocumentOptions.xWatsonDiscoveryForce() != null) {
      builder.header("X-Watson-Discovery-Force", addDocumentOptions.xWatsonDiscoveryForce());
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (addDocumentOptions.file() != null) {
      okhttp3.RequestBody fileBody = RequestUtils.inputStreamBody(addDocumentOptions.file(), addDocumentOptions
          .fileContentType());
      multipartBuilder.addFormDataPart("file", addDocumentOptions.filename(), fileBody);
    }
    if (addDocumentOptions.metadata() != null) {
      multipartBuilder.addFormDataPart("metadata", addDocumentOptions.metadata());
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<DocumentAccepted> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<DocumentAccepted>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a document.
   *
   * Replace an existing document or add a document with a specified **document_id**. Starts ingesting a document with
   * optional metadata.
   *
   * If the document is uploaded to a collection that has it's data shared with another collection, the
   * **X-Watson-Discovery-Force** header must be set to `true`.
   *
   * **Note:** When uploading a new document with this method it automatically replaces any document stored with the
   * same **document_id** if it exists.
   *
   * **Note:** This operation only works on collections created to accept direct file uploads. It cannot be used to
   * modify a collection that connects to an external source such as Microsoft SharePoint.
   *
   * @param updateDocumentOptions the {@link UpdateDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link DocumentAccepted}
   */
  public ServiceCall<DocumentAccepted> updateDocument(UpdateDocumentOptions updateDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateDocumentOptions,
        "updateDocumentOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue((updateDocumentOptions.file() != null) || (updateDocumentOptions
        .metadata() != null), "At least one of file or metadata must be supplied.");
    String[] pathSegments = { "v2/projects", "collections", "documents" };
    String[] pathParameters = { updateDocumentOptions.projectId(), updateDocumentOptions.collectionId(),
        updateDocumentOptions.documentId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "updateDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (updateDocumentOptions.xWatsonDiscoveryForce() != null) {
      builder.header("X-Watson-Discovery-Force", updateDocumentOptions.xWatsonDiscoveryForce());
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (updateDocumentOptions.file() != null) {
      okhttp3.RequestBody fileBody = RequestUtils.inputStreamBody(updateDocumentOptions.file(), updateDocumentOptions
          .fileContentType());
      multipartBuilder.addFormDataPart("file", updateDocumentOptions.filename(), fileBody);
    }
    if (updateDocumentOptions.metadata() != null) {
      multipartBuilder.addFormDataPart("metadata", updateDocumentOptions.metadata());
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<DocumentAccepted> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<DocumentAccepted>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a document.
   *
   * If the given document ID is invalid, or if the document is not found, then the a success response is returned (HTTP
   * status code `200`) with the status set to 'deleted'.
   *
   * **Note:** This operation only works on collections created to accept direct file uploads. It cannot be used to
   * modify a collection that connects to an external source such as Microsoft SharePoint.
   *
   * @param deleteDocumentOptions the {@link DeleteDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link DeleteDocumentResponse}
   */
  public ServiceCall<DeleteDocumentResponse> deleteDocument(DeleteDocumentOptions deleteDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteDocumentOptions,
        "deleteDocumentOptions cannot be null");
    String[] pathSegments = { "v2/projects", "collections", "documents" };
    String[] pathParameters = { deleteDocumentOptions.projectId(), deleteDocumentOptions.collectionId(),
        deleteDocumentOptions.documentId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "deleteDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteDocumentOptions.xWatsonDiscoveryForce() != null) {
      builder.header("X-Watson-Discovery-Force", deleteDocumentOptions.xWatsonDiscoveryForce());
    }
    ResponseConverter<DeleteDocumentResponse> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<DeleteDocumentResponse>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List training queries.
   *
   * List the training queries for the specified project.
   *
   * @param listTrainingQueriesOptions the {@link ListTrainingQueriesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingQuerySet}
   */
  public ServiceCall<TrainingQuerySet> listTrainingQueries(ListTrainingQueriesOptions listTrainingQueriesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listTrainingQueriesOptions,
        "listTrainingQueriesOptions cannot be null");
    String[] pathSegments = { "v2/projects", "training_data/queries" };
    String[] pathParameters = { listTrainingQueriesOptions.projectId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "listTrainingQueries");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<TrainingQuerySet> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<TrainingQuerySet>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete training queries.
   *
   * Removes all training queries for the specified project.
   *
   * @param deleteTrainingQueriesOptions the {@link DeleteTrainingQueriesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteTrainingQueries(DeleteTrainingQueriesOptions deleteTrainingQueriesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteTrainingQueriesOptions,
        "deleteTrainingQueriesOptions cannot be null");
    String[] pathSegments = { "v2/projects", "training_data/queries" };
    String[] pathParameters = { deleteTrainingQueriesOptions.projectId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "deleteTrainingQueries");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create training query.
   *
   * Add a query to the training data for this project. The query can contain a filter and natural language query.
   *
   * @param createTrainingQueryOptions the {@link CreateTrainingQueryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingQuery}
   */
  public ServiceCall<TrainingQuery> createTrainingQuery(CreateTrainingQueryOptions createTrainingQueryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createTrainingQueryOptions,
        "createTrainingQueryOptions cannot be null");
    String[] pathSegments = { "v2/projects", "training_data/queries" };
    String[] pathParameters = { createTrainingQueryOptions.projectId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "createTrainingQuery");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("natural_language_query", createTrainingQueryOptions.naturalLanguageQuery());
    contentJson.add("examples", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(
        createTrainingQueryOptions.examples()));
    if (createTrainingQueryOptions.filter() != null) {
      contentJson.addProperty("filter", createTrainingQueryOptions.filter());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<TrainingQuery> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<TrainingQuery>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a training data query.
   *
   * Get details for a specific training data query, including the query string and all examples.
   *
   * @param getTrainingQueryOptions the {@link GetTrainingQueryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingQuery}
   */
  public ServiceCall<TrainingQuery> getTrainingQuery(GetTrainingQueryOptions getTrainingQueryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getTrainingQueryOptions,
        "getTrainingQueryOptions cannot be null");
    String[] pathSegments = { "v2/projects", "training_data/queries" };
    String[] pathParameters = { getTrainingQueryOptions.projectId(), getTrainingQueryOptions.queryId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "getTrainingQuery");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<TrainingQuery> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<TrainingQuery>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a training query.
   *
   * Updates an existing training query and it's examples.
   *
   * @param updateTrainingQueryOptions the {@link UpdateTrainingQueryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingQuery}
   */
  public ServiceCall<TrainingQuery> updateTrainingQuery(UpdateTrainingQueryOptions updateTrainingQueryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateTrainingQueryOptions,
        "updateTrainingQueryOptions cannot be null");
    String[] pathSegments = { "v2/projects", "training_data/queries" };
    String[] pathParameters = { updateTrainingQueryOptions.projectId(), updateTrainingQueryOptions.queryId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "updateTrainingQuery");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("natural_language_query", updateTrainingQueryOptions.naturalLanguageQuery());
    contentJson.add("examples", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(
        updateTrainingQueryOptions.examples()));
    if (updateTrainingQueryOptions.filter() != null) {
      contentJson.addProperty("filter", updateTrainingQueryOptions.filter());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<TrainingQuery> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<TrainingQuery>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}

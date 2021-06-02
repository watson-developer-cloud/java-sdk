/*
 * (C) Copyright IBM Corp. 2019, 2021.
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
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-902c9336-20210513-140138
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
import com.ibm.watson.discovery.v2.model.AnalyzeDocumentOptions;
import com.ibm.watson.discovery.v2.model.AnalyzedDocument;
import com.ibm.watson.discovery.v2.model.CollectionDetails;
import com.ibm.watson.discovery.v2.model.Completions;
import com.ibm.watson.discovery.v2.model.ComponentSettingsResponse;
import com.ibm.watson.discovery.v2.model.CreateCollectionOptions;
import com.ibm.watson.discovery.v2.model.CreateEnrichmentOptions;
import com.ibm.watson.discovery.v2.model.CreateProjectOptions;
import com.ibm.watson.discovery.v2.model.CreateTrainingQueryOptions;
import com.ibm.watson.discovery.v2.model.DeleteCollectionOptions;
import com.ibm.watson.discovery.v2.model.DeleteDocumentOptions;
import com.ibm.watson.discovery.v2.model.DeleteDocumentResponse;
import com.ibm.watson.discovery.v2.model.DeleteEnrichmentOptions;
import com.ibm.watson.discovery.v2.model.DeleteProjectOptions;
import com.ibm.watson.discovery.v2.model.DeleteTrainingQueriesOptions;
import com.ibm.watson.discovery.v2.model.DeleteTrainingQueryOptions;
import com.ibm.watson.discovery.v2.model.DeleteUserDataOptions;
import com.ibm.watson.discovery.v2.model.DocumentAccepted;
import com.ibm.watson.discovery.v2.model.Enrichment;
import com.ibm.watson.discovery.v2.model.Enrichments;
import com.ibm.watson.discovery.v2.model.GetAutocompletionOptions;
import com.ibm.watson.discovery.v2.model.GetCollectionOptions;
import com.ibm.watson.discovery.v2.model.GetComponentSettingsOptions;
import com.ibm.watson.discovery.v2.model.GetEnrichmentOptions;
import com.ibm.watson.discovery.v2.model.GetProjectOptions;
import com.ibm.watson.discovery.v2.model.GetTrainingQueryOptions;
import com.ibm.watson.discovery.v2.model.ListCollectionsOptions;
import com.ibm.watson.discovery.v2.model.ListCollectionsResponse;
import com.ibm.watson.discovery.v2.model.ListEnrichmentsOptions;
import com.ibm.watson.discovery.v2.model.ListFieldsOptions;
import com.ibm.watson.discovery.v2.model.ListFieldsResponse;
import com.ibm.watson.discovery.v2.model.ListProjectsOptions;
import com.ibm.watson.discovery.v2.model.ListProjectsResponse;
import com.ibm.watson.discovery.v2.model.ListTrainingQueriesOptions;
import com.ibm.watson.discovery.v2.model.ProjectDetails;
import com.ibm.watson.discovery.v2.model.QueryCollectionNoticesOptions;
import com.ibm.watson.discovery.v2.model.QueryNoticesOptions;
import com.ibm.watson.discovery.v2.model.QueryNoticesResponse;
import com.ibm.watson.discovery.v2.model.QueryOptions;
import com.ibm.watson.discovery.v2.model.QueryResponse;
import com.ibm.watson.discovery.v2.model.TrainingQuery;
import com.ibm.watson.discovery.v2.model.TrainingQuerySet;
import com.ibm.watson.discovery.v2.model.UpdateCollectionOptions;
import com.ibm.watson.discovery.v2.model.UpdateDocumentOptions;
import com.ibm.watson.discovery.v2.model.UpdateEnrichmentOptions;
import com.ibm.watson.discovery.v2.model.UpdateProjectOptions;
import com.ibm.watson.discovery.v2.model.UpdateTrainingQueryOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.MultipartBody;

/**
 * IBM Watson&amp;trade; Discovery is a cognitive search and content analytics engine that you can
 * add to applications to identify patterns, trends and actionable insights to drive better
 * decision-making. Securely unify structured and unstructured data with pre-enriched content, and
 * use a simplified query language to eliminate the need for manual filtering of results.
 *
 * @version v2
 * @see <a href="https://cloud.ibm.com/docs/discovery-data">Discovery</a>
 */
public class Discovery extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "discovery";

  public static final String DEFAULT_SERVICE_URL =
      "https://api.us-south.discovery.watson.cloud.ibm.com";

  private String version;

  /**
   * Constructs an instance of the `Discovery` client. The default service name is used to configure
   * the client instance.
   *
   * @param version Release date of the version of the API you want to use. Specify dates in
   *     YYYY-MM-DD format. The current version is `2019-11-22`.
   */
  public Discovery(String version) {
    this(
        version,
        DEFAULT_SERVICE_NAME,
        ConfigBasedAuthenticatorFactory.getAuthenticator(DEFAULT_SERVICE_NAME));
  }

  /**
   * Constructs an instance of the `Discovery` client. The default service name and specified
   * authenticator are used to configure the client instance.
   *
   * @param version Release date of the version of the API you want to use. Specify dates in
   *     YYYY-MM-DD format. The current version is `2019-11-22`.
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public Discovery(String version, Authenticator authenticator) {
    this(version, DEFAULT_SERVICE_NAME, authenticator);
  }

  /**
   * Constructs an instance of the `Discovery` client. The specified service name is used to
   * configure the client instance.
   *
   * @param version Release date of the version of the API you want to use. Specify dates in
   *     YYYY-MM-DD format. The current version is `2019-11-22`.
   * @param serviceName the service name to be used when configuring the client instance
   */
  public Discovery(String version, String serviceName) {
    this(version, serviceName, ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName));
  }

  /**
   * Constructs an instance of the `Discovery` client. The specified service name and authenticator
   * are used to configure the client instance.
   *
   * @param version Release date of the version of the API you want to use. Specify dates in
   *     YYYY-MM-DD format. The current version is `2019-11-22`.
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public Discovery(String version, String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
    setVersion(version);
    this.configureService(serviceName);
  }

  /**
   * Gets the version.
   *
   * <p>Release date of the version of the API you want to use. Specify dates in YYYY-MM-DD format.
   * The current version is `2019-11-22`.
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
   * List collections.
   *
   * <p>Lists existing collections for the specified project.
   *
   * @param listCollectionsOptions the {@link ListCollectionsOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link ListCollectionsResponse}
   */
  public ServiceCall<ListCollectionsResponse> listCollections(
      ListCollectionsOptions listCollectionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listCollectionsOptions, "listCollectionsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", listCollectionsOptions.projectId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/projects/{project_id}/collections", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "listCollections");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<ListCollectionsResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ListCollectionsResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a collection.
   *
   * <p>Create a new collection in the specified project.
   *
   * @param createCollectionOptions the {@link CreateCollectionOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link CollectionDetails}
   */
  public ServiceCall<CollectionDetails> createCollection(
      CreateCollectionOptions createCollectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createCollectionOptions, "createCollectionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", createCollectionOptions.projectId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/projects/{project_id}/collections", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "createCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createCollectionOptions.name());
    if (createCollectionOptions.description() != null) {
      contentJson.addProperty("description", createCollectionOptions.description());
    }
    if (createCollectionOptions.language() != null) {
      contentJson.addProperty("language", createCollectionOptions.language());
    }
    if (createCollectionOptions.enrichments() != null) {
      contentJson.add(
          "enrichments",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createCollectionOptions.enrichments()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<CollectionDetails> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<CollectionDetails>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get collection.
   *
   * <p>Get details about the specified collection.
   *
   * @param getCollectionOptions the {@link GetCollectionOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link CollectionDetails}
   */
  public ServiceCall<CollectionDetails> getCollection(GetCollectionOptions getCollectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getCollectionOptions, "getCollectionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", getCollectionOptions.projectId());
    pathParamsMap.put("collection_id", getCollectionOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/projects/{project_id}/collections/{collection_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "getCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<CollectionDetails> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<CollectionDetails>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a collection.
   *
   * <p>Updates the specified collection's name, description, and enrichments.
   *
   * @param updateCollectionOptions the {@link UpdateCollectionOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link CollectionDetails}
   */
  public ServiceCall<CollectionDetails> updateCollection(
      UpdateCollectionOptions updateCollectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateCollectionOptions, "updateCollectionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", updateCollectionOptions.projectId());
    pathParamsMap.put("collection_id", updateCollectionOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/projects/{project_id}/collections/{collection_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "updateCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (updateCollectionOptions.name() != null) {
      contentJson.addProperty("name", updateCollectionOptions.name());
    }
    if (updateCollectionOptions.description() != null) {
      contentJson.addProperty("description", updateCollectionOptions.description());
    }
    if (updateCollectionOptions.enrichments() != null) {
      contentJson.add(
          "enrichments",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateCollectionOptions.enrichments()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<CollectionDetails> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<CollectionDetails>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a collection.
   *
   * <p>Deletes the specified collection from the project. All documents stored in the specified
   * collection and not shared is also deleted.
   *
   * @param deleteCollectionOptions the {@link DeleteCollectionOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteCollection(DeleteCollectionOptions deleteCollectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteCollectionOptions, "deleteCollectionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", deleteCollectionOptions.projectId());
    pathParamsMap.put("collection_id", deleteCollectionOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/projects/{project_id}/collections/{collection_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "deleteCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a project.
   *
   * <p>By using this method, you can construct queries. For details, see the [Discovery
   * documentation](https://cloud.ibm.com/docs/discovery-data?topic=discovery-data-query-concepts).
   * The default query parameters are defined by the settings for this project, see the [Discovery
   * documentation](https://cloud.ibm.com/docs/discovery-data?topic=discovery-data-project-defaults)
   * for an overview of the standard default settings, and see [the Projects API
   * documentation](#create-project) for details about how to set custom default query settings.
   *
   * @param queryOptions the {@link QueryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link QueryResponse}
   */
  public ServiceCall<QueryResponse> query(QueryOptions queryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(queryOptions, "queryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", queryOptions.projectId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/projects/{project_id}/query", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "query");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (queryOptions.collectionIds() != null) {
      contentJson.add(
          "collection_ids",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(queryOptions.collectionIds()));
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
      contentJson.add(
          "return",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(queryOptions.xReturn()));
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
      contentJson.add(
          "table_results",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(queryOptions.tableResults()));
    }
    if (queryOptions.suggestedRefinements() != null) {
      contentJson.add(
          "suggested_refinements",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(queryOptions.suggestedRefinements()));
    }
    if (queryOptions.passages() != null) {
      contentJson.add(
          "passages",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(queryOptions.passages()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<QueryResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<QueryResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get Autocomplete Suggestions.
   *
   * <p>Returns completion query suggestions for the specified prefix.
   *
   * @param getAutocompletionOptions the {@link GetAutocompletionOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Completions}
   */
  public ServiceCall<Completions> getAutocompletion(
      GetAutocompletionOptions getAutocompletionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getAutocompletionOptions, "getAutocompletionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", getAutocompletionOptions.projectId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/projects/{project_id}/autocompletion", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v2", "getAutocompletion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    builder.query("prefix", String.valueOf(getAutocompletionOptions.prefix()));
    if (getAutocompletionOptions.collectionIds() != null) {
      builder.query(
          "collection_ids", RequestUtils.join(getAutocompletionOptions.collectionIds(), ","));
    }
    if (getAutocompletionOptions.field() != null) {
      builder.query("field", String.valueOf(getAutocompletionOptions.field()));
    }
    if (getAutocompletionOptions.count() != null) {
      builder.query("count", String.valueOf(getAutocompletionOptions.count()));
    }
    ResponseConverter<Completions> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Completions>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query collection notices.
   *
   * <p>Finds collection-level notices (errors and warnings) that are generated when documents are
   * ingested.
   *
   * @param queryCollectionNoticesOptions the {@link QueryCollectionNoticesOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link QueryNoticesResponse}
   */
  public ServiceCall<QueryNoticesResponse> queryCollectionNotices(
      QueryCollectionNoticesOptions queryCollectionNoticesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        queryCollectionNoticesOptions, "queryCollectionNoticesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", queryCollectionNoticesOptions.projectId());
    pathParamsMap.put("collection_id", queryCollectionNoticesOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/projects/{project_id}/collections/{collection_id}/notices",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v2", "queryCollectionNotices");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (queryCollectionNoticesOptions.filter() != null) {
      builder.query("filter", String.valueOf(queryCollectionNoticesOptions.filter()));
    }
    if (queryCollectionNoticesOptions.query() != null) {
      builder.query("query", String.valueOf(queryCollectionNoticesOptions.query()));
    }
    if (queryCollectionNoticesOptions.naturalLanguageQuery() != null) {
      builder.query(
          "natural_language_query",
          String.valueOf(queryCollectionNoticesOptions.naturalLanguageQuery()));
    }
    if (queryCollectionNoticesOptions.count() != null) {
      builder.query("count", String.valueOf(queryCollectionNoticesOptions.count()));
    }
    if (queryCollectionNoticesOptions.offset() != null) {
      builder.query("offset", String.valueOf(queryCollectionNoticesOptions.offset()));
    }
    ResponseConverter<QueryNoticesResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<QueryNoticesResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query project notices.
   *
   * <p>Finds project-level notices (errors and warnings). Currently, project-level notices are
   * generated by relevancy training.
   *
   * @param queryNoticesOptions the {@link QueryNoticesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link QueryNoticesResponse}
   */
  public ServiceCall<QueryNoticesResponse> queryNotices(QueryNoticesOptions queryNoticesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        queryNoticesOptions, "queryNoticesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", queryNoticesOptions.projectId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/projects/{project_id}/notices", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "queryNotices");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (queryNoticesOptions.filter() != null) {
      builder.query("filter", String.valueOf(queryNoticesOptions.filter()));
    }
    if (queryNoticesOptions.query() != null) {
      builder.query("query", String.valueOf(queryNoticesOptions.query()));
    }
    if (queryNoticesOptions.naturalLanguageQuery() != null) {
      builder.query(
          "natural_language_query", String.valueOf(queryNoticesOptions.naturalLanguageQuery()));
    }
    if (queryNoticesOptions.count() != null) {
      builder.query("count", String.valueOf(queryNoticesOptions.count()));
    }
    if (queryNoticesOptions.offset() != null) {
      builder.query("offset", String.valueOf(queryNoticesOptions.offset()));
    }
    ResponseConverter<QueryNoticesResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<QueryNoticesResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List fields.
   *
   * <p>Gets a list of the unique fields (and their types) stored in the the specified collections.
   *
   * @param listFieldsOptions the {@link ListFieldsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListFieldsResponse}
   */
  public ServiceCall<ListFieldsResponse> listFields(ListFieldsOptions listFieldsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listFieldsOptions, "listFieldsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", listFieldsOptions.projectId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/projects/{project_id}/fields", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "listFields");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listFieldsOptions.collectionIds() != null) {
      builder.query("collection_ids", RequestUtils.join(listFieldsOptions.collectionIds(), ","));
    }
    ResponseConverter<ListFieldsResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ListFieldsResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List component settings.
   *
   * <p>Returns default configuration settings for components.
   *
   * @param getComponentSettingsOptions the {@link GetComponentSettingsOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link ComponentSettingsResponse}
   */
  public ServiceCall<ComponentSettingsResponse> getComponentSettings(
      GetComponentSettingsOptions getComponentSettingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getComponentSettingsOptions, "getComponentSettingsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", getComponentSettingsOptions.projectId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/projects/{project_id}/component_settings", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v2", "getComponentSettings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<ComponentSettingsResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ComponentSettingsResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add a document.
   *
   * <p>Add a document to a collection with optional metadata.
   *
   * <p>Returns immediately after the system has accepted the document for processing.
   *
   * <p>* The user must provide document content, metadata, or both. If the request is missing both
   * document content and metadata, it is rejected.
   *
   * <p>* The user can set the **Content-Type** parameter on the **file** part to indicate the media
   * type of the document. If the **Content-Type** parameter is missing or is one of the generic
   * media types (for example, `application/octet-stream`), then the service attempts to
   * automatically detect the document's media type.
   *
   * <p>* The following field names are reserved and will be filtered out if present after
   * normalization: `id`, `score`, `highlight`, and any field with the prefix of: `_`, `+`, or `-`
   *
   * <p>* Fields with empty name values after normalization are filtered out before indexing.
   *
   * <p>* Fields containing the following characters after normalization are filtered out before
   * indexing: `#` and `,`
   *
   * <p>If the document is uploaded to a collection that has it's data shared with another
   * collection, the **X-Watson-Discovery-Force** header must be set to `true`.
   *
   * <p>**Note:** Documents can be added with a specific **document_id** by using the
   * **_/v2/projects/{project_id}/collections/{collection_id}/documents** method.
   *
   * <p>**Note:** This operation only works on collections created to accept direct file uploads. It
   * cannot be used to modify a collection that connects to an external source such as Microsoft
   * SharePoint.
   *
   * @param addDocumentOptions the {@link AddDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DocumentAccepted}
   */
  public ServiceCall<DocumentAccepted> addDocument(AddDocumentOptions addDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        addDocumentOptions, "addDocumentOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue(
        (addDocumentOptions.file() != null) || (addDocumentOptions.metadata() != null),
        "At least one of file or metadata must be supplied.");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", addDocumentOptions.projectId());
    pathParamsMap.put("collection_id", addDocumentOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/projects/{project_id}/collections/{collection_id}/documents",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "addDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (addDocumentOptions.xWatsonDiscoveryForce() != null) {
      builder.header("X-Watson-Discovery-Force", addDocumentOptions.xWatsonDiscoveryForce());
    }
    builder.query("version", String.valueOf(this.version));
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (addDocumentOptions.file() != null) {
      okhttp3.RequestBody fileBody =
          RequestUtils.inputStreamBody(
              addDocumentOptions.file(), addDocumentOptions.fileContentType());
      multipartBuilder.addFormDataPart("file", addDocumentOptions.filename(), fileBody);
    }
    if (addDocumentOptions.metadata() != null) {
      multipartBuilder.addFormDataPart("metadata", addDocumentOptions.metadata());
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<DocumentAccepted> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DocumentAccepted>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a document.
   *
   * <p>Replace an existing document or add a document with a specified **document_id**. Starts
   * ingesting a document with optional metadata.
   *
   * <p>If the document is uploaded to a collection that has it's data shared with another
   * collection, the **X-Watson-Discovery-Force** header must be set to `true`.
   *
   * <p>**Note:** When uploading a new document with this method it automatically replaces any
   * document stored with the same **document_id** if it exists.
   *
   * <p>**Note:** This operation only works on collections created to accept direct file uploads. It
   * cannot be used to modify a collection that connects to an external source such as Microsoft
   * SharePoint.
   *
   * <p>**Note:** If an uploaded document is segmented, all segments will be overwritten, even if
   * the updated version of the document has fewer segments.
   *
   * @param updateDocumentOptions the {@link UpdateDocumentOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link DocumentAccepted}
   */
  public ServiceCall<DocumentAccepted> updateDocument(UpdateDocumentOptions updateDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateDocumentOptions, "updateDocumentOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue(
        (updateDocumentOptions.file() != null) || (updateDocumentOptions.metadata() != null),
        "At least one of file or metadata must be supplied.");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", updateDocumentOptions.projectId());
    pathParamsMap.put("collection_id", updateDocumentOptions.collectionId());
    pathParamsMap.put("document_id", updateDocumentOptions.documentId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/projects/{project_id}/collections/{collection_id}/documents/{document_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "updateDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (updateDocumentOptions.xWatsonDiscoveryForce() != null) {
      builder.header("X-Watson-Discovery-Force", updateDocumentOptions.xWatsonDiscoveryForce());
    }
    builder.query("version", String.valueOf(this.version));
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (updateDocumentOptions.file() != null) {
      okhttp3.RequestBody fileBody =
          RequestUtils.inputStreamBody(
              updateDocumentOptions.file(), updateDocumentOptions.fileContentType());
      multipartBuilder.addFormDataPart("file", updateDocumentOptions.filename(), fileBody);
    }
    if (updateDocumentOptions.metadata() != null) {
      multipartBuilder.addFormDataPart("metadata", updateDocumentOptions.metadata());
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<DocumentAccepted> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DocumentAccepted>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a document.
   *
   * <p>If the given document ID is invalid, or if the document is not found, then the a success
   * response is returned (HTTP status code `200`) with the status set to 'deleted'.
   *
   * <p>**Note:** This operation only works on collections created to accept direct file uploads. It
   * cannot be used to modify a collection that connects to an external source such as Microsoft
   * SharePoint.
   *
   * <p>**Note:** Segments of an uploaded document cannot be deleted individually. Delete all
   * segments by deleting using the `parent_document_id` of a segment result.
   *
   * @param deleteDocumentOptions the {@link DeleteDocumentOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link DeleteDocumentResponse}
   */
  public ServiceCall<DeleteDocumentResponse> deleteDocument(
      DeleteDocumentOptions deleteDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteDocumentOptions, "deleteDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", deleteDocumentOptions.projectId());
    pathParamsMap.put("collection_id", deleteDocumentOptions.collectionId());
    pathParamsMap.put("document_id", deleteDocumentOptions.documentId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/projects/{project_id}/collections/{collection_id}/documents/{document_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "deleteDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteDocumentOptions.xWatsonDiscoveryForce() != null) {
      builder.header("X-Watson-Discovery-Force", deleteDocumentOptions.xWatsonDiscoveryForce());
    }
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<DeleteDocumentResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DeleteDocumentResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List training queries.
   *
   * <p>List the training queries for the specified project.
   *
   * @param listTrainingQueriesOptions the {@link ListTrainingQueriesOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link TrainingQuerySet}
   */
  public ServiceCall<TrainingQuerySet> listTrainingQueries(
      ListTrainingQueriesOptions listTrainingQueriesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listTrainingQueriesOptions, "listTrainingQueriesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", listTrainingQueriesOptions.projectId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/projects/{project_id}/training_data/queries", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v2", "listTrainingQueries");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<TrainingQuerySet> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TrainingQuerySet>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete training queries.
   *
   * <p>Removes all training queries for the specified project.
   *
   * @param deleteTrainingQueriesOptions the {@link DeleteTrainingQueriesOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteTrainingQueries(
      DeleteTrainingQueriesOptions deleteTrainingQueriesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteTrainingQueriesOptions, "deleteTrainingQueriesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", deleteTrainingQueriesOptions.projectId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/projects/{project_id}/training_data/queries", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v2", "deleteTrainingQueries");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create training query.
   *
   * <p>Add a query to the training data for this project. The query can contain a filter and
   * natural language query.
   *
   * @param createTrainingQueryOptions the {@link CreateTrainingQueryOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link TrainingQuery}
   */
  public ServiceCall<TrainingQuery> createTrainingQuery(
      CreateTrainingQueryOptions createTrainingQueryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createTrainingQueryOptions, "createTrainingQueryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", createTrainingQueryOptions.projectId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/projects/{project_id}/training_data/queries", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v2", "createTrainingQuery");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty(
        "natural_language_query", createTrainingQueryOptions.naturalLanguageQuery());
    contentJson.add(
        "examples",
        com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
            .toJsonTree(createTrainingQueryOptions.examples()));
    if (createTrainingQueryOptions.filter() != null) {
      contentJson.addProperty("filter", createTrainingQueryOptions.filter());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<TrainingQuery> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TrainingQuery>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a training data query.
   *
   * <p>Get details for a specific training data query, including the query string and all examples.
   *
   * @param getTrainingQueryOptions the {@link GetTrainingQueryOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link TrainingQuery}
   */
  public ServiceCall<TrainingQuery> getTrainingQuery(
      GetTrainingQueryOptions getTrainingQueryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getTrainingQueryOptions, "getTrainingQueryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", getTrainingQueryOptions.projectId());
    pathParamsMap.put("query_id", getTrainingQueryOptions.queryId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/projects/{project_id}/training_data/queries/{query_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "getTrainingQuery");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<TrainingQuery> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TrainingQuery>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a training query.
   *
   * <p>Updates an existing training query and it's examples.
   *
   * @param updateTrainingQueryOptions the {@link UpdateTrainingQueryOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link TrainingQuery}
   */
  public ServiceCall<TrainingQuery> updateTrainingQuery(
      UpdateTrainingQueryOptions updateTrainingQueryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateTrainingQueryOptions, "updateTrainingQueryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", updateTrainingQueryOptions.projectId());
    pathParamsMap.put("query_id", updateTrainingQueryOptions.queryId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/projects/{project_id}/training_data/queries/{query_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v2", "updateTrainingQuery");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty(
        "natural_language_query", updateTrainingQueryOptions.naturalLanguageQuery());
    contentJson.add(
        "examples",
        com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
            .toJsonTree(updateTrainingQueryOptions.examples()));
    if (updateTrainingQueryOptions.filter() != null) {
      contentJson.addProperty("filter", updateTrainingQueryOptions.filter());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<TrainingQuery> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TrainingQuery>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a training data query.
   *
   * <p>Removes details from a training data query, including the query string and all examples.
   *
   * @param deleteTrainingQueryOptions the {@link DeleteTrainingQueryOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteTrainingQuery(
      DeleteTrainingQueryOptions deleteTrainingQueryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteTrainingQueryOptions, "deleteTrainingQueryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", deleteTrainingQueryOptions.projectId());
    pathParamsMap.put("query_id", deleteTrainingQueryOptions.queryId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/projects/{project_id}/training_data/queries/{query_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v2", "deleteTrainingQuery");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Analyze a Document.
   *
   * <p>Process a document using the specified collection's settings and return it for realtime use.
   *
   * <p>**Note:** Documents processed using this method are not added to the specified collection.
   *
   * <p>**Note:** This method is only supported on IBM Cloud Pak for Data instances of Discovery.
   *
   * @param analyzeDocumentOptions the {@link AnalyzeDocumentOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link AnalyzedDocument}
   */
  public ServiceCall<AnalyzedDocument> analyzeDocument(
      AnalyzeDocumentOptions analyzeDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        analyzeDocumentOptions, "analyzeDocumentOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue(
        (analyzeDocumentOptions.file() != null) || (analyzeDocumentOptions.metadata() != null),
        "At least one of file or metadata must be supplied.");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", analyzeDocumentOptions.projectId());
    pathParamsMap.put("collection_id", analyzeDocumentOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/projects/{project_id}/collections/{collection_id}/analyze",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "analyzeDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (analyzeDocumentOptions.file() != null) {
      okhttp3.RequestBody fileBody =
          RequestUtils.inputStreamBody(
              analyzeDocumentOptions.file(), analyzeDocumentOptions.fileContentType());
      multipartBuilder.addFormDataPart("file", analyzeDocumentOptions.filename(), fileBody);
    }
    if (analyzeDocumentOptions.metadata() != null) {
      multipartBuilder.addFormDataPart("metadata", analyzeDocumentOptions.metadata());
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<AnalyzedDocument> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<AnalyzedDocument>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List Enrichments.
   *
   * <p>List the enrichments available to this project.
   *
   * @param listEnrichmentsOptions the {@link ListEnrichmentsOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Enrichments}
   */
  public ServiceCall<Enrichments> listEnrichments(ListEnrichmentsOptions listEnrichmentsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listEnrichmentsOptions, "listEnrichmentsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", listEnrichmentsOptions.projectId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/projects/{project_id}/enrichments", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "listEnrichments");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Enrichments> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Enrichments>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create an enrichment.
   *
   * <p>Create an enrichment for use with the specified project/.
   *
   * @param createEnrichmentOptions the {@link CreateEnrichmentOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Enrichment}
   */
  public ServiceCall<Enrichment> createEnrichment(CreateEnrichmentOptions createEnrichmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createEnrichmentOptions, "createEnrichmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", createEnrichmentOptions.projectId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/projects/{project_id}/enrichments", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "createEnrichment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    multipartBuilder.addFormDataPart("enrichment", createEnrichmentOptions.enrichment().toString());
    if (createEnrichmentOptions.file() != null) {
      okhttp3.RequestBody fileBody =
          RequestUtils.inputStreamBody(createEnrichmentOptions.file(), "application/octet-stream");
      multipartBuilder.addFormDataPart("file", "filename", fileBody);
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<Enrichment> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Enrichment>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get enrichment.
   *
   * <p>Get details about a specific enrichment.
   *
   * @param getEnrichmentOptions the {@link GetEnrichmentOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Enrichment}
   */
  public ServiceCall<Enrichment> getEnrichment(GetEnrichmentOptions getEnrichmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getEnrichmentOptions, "getEnrichmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", getEnrichmentOptions.projectId());
    pathParamsMap.put("enrichment_id", getEnrichmentOptions.enrichmentId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/projects/{project_id}/enrichments/{enrichment_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "getEnrichment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Enrichment> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Enrichment>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update an enrichment.
   *
   * <p>Updates an existing enrichment's name and description.
   *
   * @param updateEnrichmentOptions the {@link UpdateEnrichmentOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Enrichment}
   */
  public ServiceCall<Enrichment> updateEnrichment(UpdateEnrichmentOptions updateEnrichmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateEnrichmentOptions, "updateEnrichmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", updateEnrichmentOptions.projectId());
    pathParamsMap.put("enrichment_id", updateEnrichmentOptions.enrichmentId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/projects/{project_id}/enrichments/{enrichment_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "updateEnrichment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", updateEnrichmentOptions.name());
    if (updateEnrichmentOptions.description() != null) {
      contentJson.addProperty("description", updateEnrichmentOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Enrichment> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Enrichment>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an enrichment.
   *
   * <p>Deletes an existing enrichment from the specified project.
   *
   * <p>**Note:** Only enrichments that have been manually created can be deleted.
   *
   * @param deleteEnrichmentOptions the {@link DeleteEnrichmentOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteEnrichment(DeleteEnrichmentOptions deleteEnrichmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteEnrichmentOptions, "deleteEnrichmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", deleteEnrichmentOptions.projectId());
    pathParamsMap.put("enrichment_id", deleteEnrichmentOptions.enrichmentId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v2/projects/{project_id}/enrichments/{enrichment_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "deleteEnrichment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List projects.
   *
   * <p>Lists existing projects for this instance.
   *
   * @param listProjectsOptions the {@link ListProjectsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListProjectsResponse}
   */
  public ServiceCall<ListProjectsResponse> listProjects(ListProjectsOptions listProjectsOptions) {
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/projects"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "listProjects");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<ListProjectsResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ListProjectsResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List projects.
   *
   * <p>Lists existing projects for this instance.
   *
   * @return a {@link ServiceCall} with a result of type {@link ListProjectsResponse}
   */
  public ServiceCall<ListProjectsResponse> listProjects() {
    return listProjects(null);
  }

  /**
   * Create a Project.
   *
   * <p>Create a new project for this instance.
   *
   * @param createProjectOptions the {@link CreateProjectOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link ProjectDetails}
   */
  public ServiceCall<ProjectDetails> createProject(CreateProjectOptions createProjectOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createProjectOptions, "createProjectOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/projects"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "createProject");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createProjectOptions.name());
    contentJson.addProperty("type", createProjectOptions.type());
    if (createProjectOptions.defaultQueryParameters() != null) {
      contentJson.add(
          "default_query_parameters",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createProjectOptions.defaultQueryParameters()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ProjectDetails> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ProjectDetails>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get project.
   *
   * <p>Get details on the specified project.
   *
   * @param getProjectOptions the {@link GetProjectOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProjectDetails}
   */
  public ServiceCall<ProjectDetails> getProject(GetProjectOptions getProjectOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getProjectOptions, "getProjectOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", getProjectOptions.projectId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/projects/{project_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "getProject");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<ProjectDetails> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ProjectDetails>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a project.
   *
   * <p>Update the specified project's name.
   *
   * @param updateProjectOptions the {@link UpdateProjectOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link ProjectDetails}
   */
  public ServiceCall<ProjectDetails> updateProject(UpdateProjectOptions updateProjectOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateProjectOptions, "updateProjectOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", updateProjectOptions.projectId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/projects/{project_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "updateProject");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (updateProjectOptions.name() != null) {
      contentJson.addProperty("name", updateProjectOptions.name());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ProjectDetails> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ProjectDetails>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a project.
   *
   * <p>Deletes the specified project.
   *
   * <p>**Important:** Deleting a project deletes everything that is part of the specified project,
   * including all collections.
   *
   * @param deleteProjectOptions the {@link DeleteProjectOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteProject(DeleteProjectOptions deleteProjectOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteProjectOptions, "deleteProjectOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("project_id", deleteProjectOptions.projectId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v2/projects/{project_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "deleteProject");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete labeled data.
   *
   * <p>Deletes all data associated with a specified customer ID. The method has no effect if no
   * data is associated with the customer ID.
   *
   * <p>You associate a customer ID with data by passing the **X-Watson-Metadata** header with a
   * request that passes data. For more information about personal data and customer IDs, see
   * [Information
   * security](https://cloud.ibm.com/docs/discovery-data?topic=discovery-data-information-security#information-security).
   *
   * <p>**Note:** This method is only supported on IBM Cloud instances of Discovery.
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
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v2", "deleteUserData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", String.valueOf(this.version));
    builder.query("customer_id", String.valueOf(deleteUserDataOptions.customerId()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }
}

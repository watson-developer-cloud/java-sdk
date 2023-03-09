/*
 * (C) Copyright IBM Corp. 2019, 2023.
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
 * IBM OpenAPI SDK Code Generator Version: 3.64.1-cee95189-20230124-211647
 */

package com.ibm.watson.discovery.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.watson.common.SdkCommon;
import com.ibm.watson.discovery.v1.model.AddDocumentOptions;
import com.ibm.watson.discovery.v1.model.AddTrainingDataOptions;
import com.ibm.watson.discovery.v1.model.Collection;
import com.ibm.watson.discovery.v1.model.Completions;
import com.ibm.watson.discovery.v1.model.Configuration;
import com.ibm.watson.discovery.v1.model.CreateCollectionOptions;
import com.ibm.watson.discovery.v1.model.CreateConfigurationOptions;
import com.ibm.watson.discovery.v1.model.CreateCredentialsOptions;
import com.ibm.watson.discovery.v1.model.CreateEnvironmentOptions;
import com.ibm.watson.discovery.v1.model.CreateEventOptions;
import com.ibm.watson.discovery.v1.model.CreateEventResponse;
import com.ibm.watson.discovery.v1.model.CreateExpansionsOptions;
import com.ibm.watson.discovery.v1.model.CreateGatewayOptions;
import com.ibm.watson.discovery.v1.model.CreateStopwordListOptions;
import com.ibm.watson.discovery.v1.model.CreateTokenizationDictionaryOptions;
import com.ibm.watson.discovery.v1.model.CreateTrainingExampleOptions;
import com.ibm.watson.discovery.v1.model.Credentials;
import com.ibm.watson.discovery.v1.model.CredentialsList;
import com.ibm.watson.discovery.v1.model.DeleteAllTrainingDataOptions;
import com.ibm.watson.discovery.v1.model.DeleteCollectionOptions;
import com.ibm.watson.discovery.v1.model.DeleteCollectionResponse;
import com.ibm.watson.discovery.v1.model.DeleteConfigurationOptions;
import com.ibm.watson.discovery.v1.model.DeleteConfigurationResponse;
import com.ibm.watson.discovery.v1.model.DeleteCredentials;
import com.ibm.watson.discovery.v1.model.DeleteCredentialsOptions;
import com.ibm.watson.discovery.v1.model.DeleteDocumentOptions;
import com.ibm.watson.discovery.v1.model.DeleteDocumentResponse;
import com.ibm.watson.discovery.v1.model.DeleteEnvironmentOptions;
import com.ibm.watson.discovery.v1.model.DeleteEnvironmentResponse;
import com.ibm.watson.discovery.v1.model.DeleteExpansionsOptions;
import com.ibm.watson.discovery.v1.model.DeleteGatewayOptions;
import com.ibm.watson.discovery.v1.model.DeleteStopwordListOptions;
import com.ibm.watson.discovery.v1.model.DeleteTokenizationDictionaryOptions;
import com.ibm.watson.discovery.v1.model.DeleteTrainingDataOptions;
import com.ibm.watson.discovery.v1.model.DeleteTrainingExampleOptions;
import com.ibm.watson.discovery.v1.model.DeleteUserDataOptions;
import com.ibm.watson.discovery.v1.model.DocumentAccepted;
import com.ibm.watson.discovery.v1.model.DocumentStatus;
import com.ibm.watson.discovery.v1.model.Environment;
import com.ibm.watson.discovery.v1.model.Expansions;
import com.ibm.watson.discovery.v1.model.FederatedQueryNoticesOptions;
import com.ibm.watson.discovery.v1.model.FederatedQueryOptions;
import com.ibm.watson.discovery.v1.model.Gateway;
import com.ibm.watson.discovery.v1.model.GatewayDelete;
import com.ibm.watson.discovery.v1.model.GatewayList;
import com.ibm.watson.discovery.v1.model.GetAutocompletionOptions;
import com.ibm.watson.discovery.v1.model.GetCollectionOptions;
import com.ibm.watson.discovery.v1.model.GetConfigurationOptions;
import com.ibm.watson.discovery.v1.model.GetCredentialsOptions;
import com.ibm.watson.discovery.v1.model.GetDocumentStatusOptions;
import com.ibm.watson.discovery.v1.model.GetEnvironmentOptions;
import com.ibm.watson.discovery.v1.model.GetGatewayOptions;
import com.ibm.watson.discovery.v1.model.GetMetricsEventRateOptions;
import com.ibm.watson.discovery.v1.model.GetMetricsQueryEventOptions;
import com.ibm.watson.discovery.v1.model.GetMetricsQueryNoResultsOptions;
import com.ibm.watson.discovery.v1.model.GetMetricsQueryOptions;
import com.ibm.watson.discovery.v1.model.GetMetricsQueryTokenEventOptions;
import com.ibm.watson.discovery.v1.model.GetStopwordListStatusOptions;
import com.ibm.watson.discovery.v1.model.GetTokenizationDictionaryStatusOptions;
import com.ibm.watson.discovery.v1.model.GetTrainingDataOptions;
import com.ibm.watson.discovery.v1.model.GetTrainingExampleOptions;
import com.ibm.watson.discovery.v1.model.ListCollectionFieldsOptions;
import com.ibm.watson.discovery.v1.model.ListCollectionFieldsResponse;
import com.ibm.watson.discovery.v1.model.ListCollectionsOptions;
import com.ibm.watson.discovery.v1.model.ListCollectionsResponse;
import com.ibm.watson.discovery.v1.model.ListConfigurationsOptions;
import com.ibm.watson.discovery.v1.model.ListConfigurationsResponse;
import com.ibm.watson.discovery.v1.model.ListCredentialsOptions;
import com.ibm.watson.discovery.v1.model.ListEnvironmentsOptions;
import com.ibm.watson.discovery.v1.model.ListEnvironmentsResponse;
import com.ibm.watson.discovery.v1.model.ListExpansionsOptions;
import com.ibm.watson.discovery.v1.model.ListFieldsOptions;
import com.ibm.watson.discovery.v1.model.ListGatewaysOptions;
import com.ibm.watson.discovery.v1.model.ListTrainingDataOptions;
import com.ibm.watson.discovery.v1.model.ListTrainingExamplesOptions;
import com.ibm.watson.discovery.v1.model.LogQueryResponse;
import com.ibm.watson.discovery.v1.model.MetricResponse;
import com.ibm.watson.discovery.v1.model.MetricTokenResponse;
import com.ibm.watson.discovery.v1.model.QueryLogOptions;
import com.ibm.watson.discovery.v1.model.QueryNoticesOptions;
import com.ibm.watson.discovery.v1.model.QueryNoticesResponse;
import com.ibm.watson.discovery.v1.model.QueryOptions;
import com.ibm.watson.discovery.v1.model.QueryResponse;
import com.ibm.watson.discovery.v1.model.TokenDictStatusResponse;
import com.ibm.watson.discovery.v1.model.TrainingDataSet;
import com.ibm.watson.discovery.v1.model.TrainingExample;
import com.ibm.watson.discovery.v1.model.TrainingExampleList;
import com.ibm.watson.discovery.v1.model.TrainingQuery;
import com.ibm.watson.discovery.v1.model.UpdateCollectionOptions;
import com.ibm.watson.discovery.v1.model.UpdateConfigurationOptions;
import com.ibm.watson.discovery.v1.model.UpdateCredentialsOptions;
import com.ibm.watson.discovery.v1.model.UpdateDocumentOptions;
import com.ibm.watson.discovery.v1.model.UpdateEnvironmentOptions;
import com.ibm.watson.discovery.v1.model.UpdateTrainingExampleOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.MultipartBody;

/**
 * IBM Watson&amp;trade; Discovery v1 is a cognitive search and content analytics engine that you
 * can add to applications to identify patterns, trends and actionable insights to drive better
 * decision-making. Securely unify structured and unstructured data with pre-enriched content, and
 * use a simplified query language to eliminate the need for manual filtering of results.
 *
 * <p>API Version: 1.0 See: https://cloud.ibm.com/docs/discovery
 */
public class Discovery extends BaseService {

  /** Default service name used when configuring the `Discovery` client. */
  public static final String DEFAULT_SERVICE_NAME = "discovery";

  /** Default service endpoint URL. */
  public static final String DEFAULT_SERVICE_URL =
      "https://api.us-south.discovery.watson.cloud.ibm.com";

  private String version;

  /**
   * Constructs an instance of the `Discovery` client. The default service name is used to configure
   * the client instance.
   *
   * @param version Release date of the version of the API you want to use. Specify dates in
   *     YYYY-MM-DD format. The current version is `2019-04-30`.
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
   *     YYYY-MM-DD format. The current version is `2019-04-30`.
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
   *     YYYY-MM-DD format. The current version is `2019-04-30`.
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
   *     YYYY-MM-DD format. The current version is `2019-04-30`.
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
   * The current version is `2019-04-30`.
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
   * Create an environment.
   *
   * <p>Creates a new environment for private data. An environment must be created before
   * collections can be created.
   *
   * <p>**Note**: You can create only one environment for private data per service instance. An
   * attempt to create another environment results in an error.
   *
   * @param createEnvironmentOptions the {@link CreateEnvironmentOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Environment}
   */
  public ServiceCall<Environment> createEnvironment(
      CreateEnvironmentOptions createEnvironmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createEnvironmentOptions, "createEnvironmentOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/environments"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "createEnvironment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createEnvironmentOptions.name());
    if (createEnvironmentOptions.description() != null) {
      contentJson.addProperty("description", createEnvironmentOptions.description());
    }
    if (createEnvironmentOptions.size() != null) {
      contentJson.addProperty("size", createEnvironmentOptions.size());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Environment> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Environment>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List environments.
   *
   * <p>List existing environments for the service instance.
   *
   * @param listEnvironmentsOptions the {@link ListEnvironmentsOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link ListEnvironmentsResponse}
   */
  public ServiceCall<ListEnvironmentsResponse> listEnvironments(
      ListEnvironmentsOptions listEnvironmentsOptions) {
    if (listEnvironmentsOptions == null) {
      listEnvironmentsOptions = new ListEnvironmentsOptions.Builder().build();
    }
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/environments"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "listEnvironments");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listEnvironmentsOptions.name() != null) {
      builder.query("name", String.valueOf(listEnvironmentsOptions.name()));
    }
    ResponseConverter<ListEnvironmentsResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ListEnvironmentsResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List environments.
   *
   * <p>List existing environments for the service instance.
   *
   * @return a {@link ServiceCall} with a result of type {@link ListEnvironmentsResponse}
   */
  public ServiceCall<ListEnvironmentsResponse> listEnvironments() {
    return listEnvironments(null);
  }

  /**
   * Get environment info.
   *
   * @param getEnvironmentOptions the {@link GetEnvironmentOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Environment}
   */
  public ServiceCall<Environment> getEnvironment(GetEnvironmentOptions getEnvironmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getEnvironmentOptions, "getEnvironmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", getEnvironmentOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/environments/{environment_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "getEnvironment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Environment> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Environment>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update an environment.
   *
   * <p>Updates an environment. The environment's **name** and **description** parameters can be
   * changed. You must specify a **name** for the environment.
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
    pathParamsMap.put("environment_id", updateEnvironmentOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.put(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/environments/{environment_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "updateEnvironment");
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
    if (updateEnvironmentOptions.size() != null) {
      contentJson.addProperty("size", updateEnvironmentOptions.size());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Environment> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Environment>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete environment.
   *
   * @param deleteEnvironmentOptions the {@link DeleteEnvironmentOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteEnvironmentResponse}
   */
  public ServiceCall<DeleteEnvironmentResponse> deleteEnvironment(
      DeleteEnvironmentOptions deleteEnvironmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteEnvironmentOptions, "deleteEnvironmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", deleteEnvironmentOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/environments/{environment_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "deleteEnvironment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<DeleteEnvironmentResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DeleteEnvironmentResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List fields across collections.
   *
   * <p>Gets a list of the unique fields (and their types) stored in the indexes of the specified
   * collections.
   *
   * @param listFieldsOptions the {@link ListFieldsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListCollectionFieldsResponse}
   */
  public ServiceCall<ListCollectionFieldsResponse> listFields(ListFieldsOptions listFieldsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listFieldsOptions, "listFieldsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", listFieldsOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/environments/{environment_id}/fields", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "listFields");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    builder.query("collection_ids", RequestUtils.join(listFieldsOptions.collectionIds(), ","));
    ResponseConverter<ListCollectionFieldsResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ListCollectionFieldsResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add configuration.
   *
   * <p>Creates a new configuration.
   *
   * <p>If the input configuration contains the **configuration_id**, **created**, or **updated**
   * properties, then they are ignored and overridden by the system, and an error is not returned so
   * that the overridden fields do not need to be removed when copying a configuration.
   *
   * <p>The configuration can contain unrecognized JSON fields. Any such fields are ignored and do
   * not generate an error. This makes it easier to use newer configuration files with older
   * versions of the API and the service. It also makes it possible for the tooling to add
   * additional metadata and information to the configuration.
   *
   * @param createConfigurationOptions the {@link CreateConfigurationOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link Configuration}
   */
  public ServiceCall<Configuration> createConfiguration(
      CreateConfigurationOptions createConfigurationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createConfigurationOptions, "createConfigurationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", createConfigurationOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/configurations",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "createConfiguration");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createConfigurationOptions.name());
    if (createConfigurationOptions.description() != null) {
      contentJson.addProperty("description", createConfigurationOptions.description());
    }
    if (createConfigurationOptions.conversions() != null) {
      contentJson.add(
          "conversions",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createConfigurationOptions.conversions()));
    }
    if (createConfigurationOptions.enrichments() != null) {
      contentJson.add(
          "enrichments",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createConfigurationOptions.enrichments()));
    }
    if (createConfigurationOptions.normalizations() != null) {
      contentJson.add(
          "normalizations",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createConfigurationOptions.normalizations()));
    }
    if (createConfigurationOptions.source() != null) {
      contentJson.add(
          "source",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createConfigurationOptions.source()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Configuration> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Configuration>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List configurations.
   *
   * <p>Lists existing configurations for the service instance.
   *
   * @param listConfigurationsOptions the {@link ListConfigurationsOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link ListConfigurationsResponse}
   */
  public ServiceCall<ListConfigurationsResponse> listConfigurations(
      ListConfigurationsOptions listConfigurationsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listConfigurationsOptions, "listConfigurationsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", listConfigurationsOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/configurations",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "listConfigurations");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listConfigurationsOptions.name() != null) {
      builder.query("name", String.valueOf(listConfigurationsOptions.name()));
    }
    ResponseConverter<ListConfigurationsResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ListConfigurationsResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get configuration details.
   *
   * @param getConfigurationOptions the {@link GetConfigurationOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Configuration}
   */
  public ServiceCall<Configuration> getConfiguration(
      GetConfigurationOptions getConfigurationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getConfigurationOptions, "getConfigurationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", getConfigurationOptions.environmentId());
    pathParamsMap.put("configuration_id", getConfigurationOptions.configurationId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/configurations/{configuration_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "getConfiguration");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Configuration> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Configuration>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a configuration.
   *
   * <p>Replaces an existing configuration. * Completely replaces the original configuration. * The
   * **configuration_id**, **updated**, and **created** fields are accepted in the request, but they
   * are ignored, and an error is not generated. It is also acceptable for users to submit an
   * updated configuration with none of the three properties. * Documents are processed with a
   * snapshot of the configuration as it was at the time the document was submitted to be ingested.
   * This means that already submitted documents will not see any updates made to the configuration.
   *
   * @param updateConfigurationOptions the {@link UpdateConfigurationOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link Configuration}
   */
  public ServiceCall<Configuration> updateConfiguration(
      UpdateConfigurationOptions updateConfigurationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateConfigurationOptions, "updateConfigurationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", updateConfigurationOptions.environmentId());
    pathParamsMap.put("configuration_id", updateConfigurationOptions.configurationId());
    RequestBuilder builder =
        RequestBuilder.put(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/configurations/{configuration_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "updateConfiguration");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", updateConfigurationOptions.name());
    if (updateConfigurationOptions.description() != null) {
      contentJson.addProperty("description", updateConfigurationOptions.description());
    }
    if (updateConfigurationOptions.conversions() != null) {
      contentJson.add(
          "conversions",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateConfigurationOptions.conversions()));
    }
    if (updateConfigurationOptions.enrichments() != null) {
      contentJson.add(
          "enrichments",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateConfigurationOptions.enrichments()));
    }
    if (updateConfigurationOptions.normalizations() != null) {
      contentJson.add(
          "normalizations",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateConfigurationOptions.normalizations()));
    }
    if (updateConfigurationOptions.source() != null) {
      contentJson.add(
          "source",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateConfigurationOptions.source()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Configuration> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Configuration>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a configuration.
   *
   * <p>The deletion is performed unconditionally. A configuration deletion request succeeds even if
   * the configuration is referenced by a collection or document ingestion. However, documents that
   * have already been submitted for processing continue to use the deleted configuration. Documents
   * are always processed with a snapshot of the configuration as it existed at the time the
   * document was submitted.
   *
   * @param deleteConfigurationOptions the {@link DeleteConfigurationOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteConfigurationResponse}
   */
  public ServiceCall<DeleteConfigurationResponse> deleteConfiguration(
      DeleteConfigurationOptions deleteConfigurationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteConfigurationOptions, "deleteConfigurationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", deleteConfigurationOptions.environmentId());
    pathParamsMap.put("configuration_id", deleteConfigurationOptions.configurationId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/configurations/{configuration_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "deleteConfiguration");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<DeleteConfigurationResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DeleteConfigurationResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a collection.
   *
   * @param createCollectionOptions the {@link CreateCollectionOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Collection}
   */
  public ServiceCall<Collection> createCollection(CreateCollectionOptions createCollectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createCollectionOptions, "createCollectionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", createCollectionOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/environments/{environment_id}/collections", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "createCollection");
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
    if (createCollectionOptions.configurationId() != null) {
      contentJson.addProperty("configuration_id", createCollectionOptions.configurationId());
    }
    if (createCollectionOptions.language() != null) {
      contentJson.addProperty("language", createCollectionOptions.language());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Collection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Collection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List collections.
   *
   * <p>Lists existing collections for the service instance.
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
    pathParamsMap.put("environment_id", listCollectionsOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/environments/{environment_id}/collections", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "listCollections");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listCollectionsOptions.name() != null) {
      builder.query("name", String.valueOf(listCollectionsOptions.name()));
    }
    ResponseConverter<ListCollectionsResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ListCollectionsResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get collection details.
   *
   * @param getCollectionOptions the {@link GetCollectionOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Collection}
   */
  public ServiceCall<Collection> getCollection(GetCollectionOptions getCollectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getCollectionOptions, "getCollectionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", getCollectionOptions.environmentId());
    pathParamsMap.put("collection_id", getCollectionOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "getCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Collection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Collection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a collection.
   *
   * @param updateCollectionOptions the {@link UpdateCollectionOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Collection}
   */
  public ServiceCall<Collection> updateCollection(UpdateCollectionOptions updateCollectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateCollectionOptions, "updateCollectionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", updateCollectionOptions.environmentId());
    pathParamsMap.put("collection_id", updateCollectionOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.put(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "updateCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", updateCollectionOptions.name());
    if (updateCollectionOptions.description() != null) {
      contentJson.addProperty("description", updateCollectionOptions.description());
    }
    if (updateCollectionOptions.configurationId() != null) {
      contentJson.addProperty("configuration_id", updateCollectionOptions.configurationId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Collection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Collection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a collection.
   *
   * @param deleteCollectionOptions the {@link DeleteCollectionOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteCollectionResponse}
   */
  public ServiceCall<DeleteCollectionResponse> deleteCollection(
      DeleteCollectionOptions deleteCollectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteCollectionOptions, "deleteCollectionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", deleteCollectionOptions.environmentId());
    pathParamsMap.put("collection_id", deleteCollectionOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "deleteCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<DeleteCollectionResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DeleteCollectionResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List collection fields.
   *
   * <p>Gets a list of the unique fields (and their types) stored in the index.
   *
   * @param listCollectionFieldsOptions the {@link ListCollectionFieldsOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListCollectionFieldsResponse}
   */
  public ServiceCall<ListCollectionFieldsResponse> listCollectionFields(
      ListCollectionFieldsOptions listCollectionFieldsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listCollectionFieldsOptions, "listCollectionFieldsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", listCollectionFieldsOptions.environmentId());
    pathParamsMap.put("collection_id", listCollectionFieldsOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/fields",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "listCollectionFields");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<ListCollectionFieldsResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ListCollectionFieldsResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the expansion list.
   *
   * <p>Returns the current expansion list for the specified collection. If an expansion list is not
   * specified, an object with empty expansion arrays is returned.
   *
   * @param listExpansionsOptions the {@link ListExpansionsOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Expansions}
   */
  public ServiceCall<Expansions> listExpansions(ListExpansionsOptions listExpansionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listExpansionsOptions, "listExpansionsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", listExpansionsOptions.environmentId());
    pathParamsMap.put("collection_id", listExpansionsOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/expansions",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "listExpansions");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Expansions> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Expansions>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create or update expansion list.
   *
   * <p>Create or replace the Expansion list for this collection. The maximum number of expanded
   * terms per collection is `500`. The current expansion list is replaced with the uploaded
   * content.
   *
   * @param createExpansionsOptions the {@link CreateExpansionsOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Expansions}
   */
  public ServiceCall<Expansions> createExpansions(CreateExpansionsOptions createExpansionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createExpansionsOptions, "createExpansionsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", createExpansionsOptions.environmentId());
    pathParamsMap.put("collection_id", createExpansionsOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/expansions",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "createExpansions");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.add(
        "expansions",
        com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
            .toJsonTree(createExpansionsOptions.expansions()));
    builder.bodyJson(contentJson);
    ResponseConverter<Expansions> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Expansions>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete the expansion list.
   *
   * <p>Remove the expansion information for this collection. The expansion list must be deleted to
   * disable query expansion for a collection.
   *
   * @param deleteExpansionsOptions the {@link DeleteExpansionsOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteExpansions(DeleteExpansionsOptions deleteExpansionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteExpansionsOptions, "deleteExpansionsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", deleteExpansionsOptions.environmentId());
    pathParamsMap.put("collection_id", deleteExpansionsOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/expansions",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "deleteExpansions");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get tokenization dictionary status.
   *
   * <p>Returns the current status of the tokenization dictionary for the specified collection.
   *
   * @param getTokenizationDictionaryStatusOptions the {@link
   *     GetTokenizationDictionaryStatusOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TokenDictStatusResponse}
   */
  public ServiceCall<TokenDictStatusResponse> getTokenizationDictionaryStatus(
      GetTokenizationDictionaryStatusOptions getTokenizationDictionaryStatusOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getTokenizationDictionaryStatusOptions,
        "getTokenizationDictionaryStatusOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", getTokenizationDictionaryStatusOptions.environmentId());
    pathParamsMap.put("collection_id", getTokenizationDictionaryStatusOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/word_lists/tokenization_dictionary",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "getTokenizationDictionaryStatus");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<TokenDictStatusResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TokenDictStatusResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create tokenization dictionary.
   *
   * <p>Upload a custom tokenization dictionary to use with the specified collection.
   *
   * @param createTokenizationDictionaryOptions the {@link CreateTokenizationDictionaryOptions}
   *     containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TokenDictStatusResponse}
   */
  public ServiceCall<TokenDictStatusResponse> createTokenizationDictionary(
      CreateTokenizationDictionaryOptions createTokenizationDictionaryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createTokenizationDictionaryOptions, "createTokenizationDictionaryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", createTokenizationDictionaryOptions.environmentId());
    pathParamsMap.put("collection_id", createTokenizationDictionaryOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/word_lists/tokenization_dictionary",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "createTokenizationDictionary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (createTokenizationDictionaryOptions.tokenizationRules() != null) {
      contentJson.add(
          "tokenization_rules",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createTokenizationDictionaryOptions.tokenizationRules()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<TokenDictStatusResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TokenDictStatusResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete tokenization dictionary.
   *
   * <p>Delete the tokenization dictionary from the collection.
   *
   * @param deleteTokenizationDictionaryOptions the {@link DeleteTokenizationDictionaryOptions}
   *     containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteTokenizationDictionary(
      DeleteTokenizationDictionaryOptions deleteTokenizationDictionaryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteTokenizationDictionaryOptions, "deleteTokenizationDictionaryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", deleteTokenizationDictionaryOptions.environmentId());
    pathParamsMap.put("collection_id", deleteTokenizationDictionaryOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/word_lists/tokenization_dictionary",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "deleteTokenizationDictionary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get stopword list status.
   *
   * <p>Returns the current status of the stopword list for the specified collection.
   *
   * @param getStopwordListStatusOptions the {@link GetStopwordListStatusOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link TokenDictStatusResponse}
   */
  public ServiceCall<TokenDictStatusResponse> getStopwordListStatus(
      GetStopwordListStatusOptions getStopwordListStatusOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getStopwordListStatusOptions, "getStopwordListStatusOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", getStopwordListStatusOptions.environmentId());
    pathParamsMap.put("collection_id", getStopwordListStatusOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/word_lists/stopwords",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "getStopwordListStatus");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<TokenDictStatusResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TokenDictStatusResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create stopword list.
   *
   * <p>Upload a custom stopword list to use with the specified collection.
   *
   * @param createStopwordListOptions the {@link CreateStopwordListOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link TokenDictStatusResponse}
   */
  public ServiceCall<TokenDictStatusResponse> createStopwordList(
      CreateStopwordListOptions createStopwordListOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createStopwordListOptions, "createStopwordListOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", createStopwordListOptions.environmentId());
    pathParamsMap.put("collection_id", createStopwordListOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/word_lists/stopwords",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "createStopwordList");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    okhttp3.RequestBody stopwordFileBody =
        RequestUtils.inputStreamBody(
            createStopwordListOptions.stopwordFile(), "application/octet-stream");
    multipartBuilder.addFormDataPart(
        "stopword_file", createStopwordListOptions.stopwordFilename(), stopwordFileBody);
    builder.body(multipartBuilder.build());
    ResponseConverter<TokenDictStatusResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TokenDictStatusResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a custom stopword list.
   *
   * <p>Delete a custom stopword list from the collection. After a custom stopword list is deleted,
   * the default list is used for the collection.
   *
   * @param deleteStopwordListOptions the {@link DeleteStopwordListOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteStopwordList(DeleteStopwordListOptions deleteStopwordListOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteStopwordListOptions, "deleteStopwordListOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", deleteStopwordListOptions.environmentId());
    pathParamsMap.put("collection_id", deleteStopwordListOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/word_lists/stopwords",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "deleteStopwordList");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add a document.
   *
   * <p>Add a document to a collection with optional metadata.
   *
   * <p>* The **version** query parameter is still required.
   *
   * <p>* Returns immediately after the system has accepted the document for processing.
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
   * <p>**Note:** Documents can be added with a specific **document_id** by using the
   * **_/v1/environments/{environment_id}/collections/{collection_id}/documents** method.
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
    pathParamsMap.put("environment_id", addDocumentOptions.environmentId());
    pathParamsMap.put("collection_id", addDocumentOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/documents",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "addDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
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
   * Get document details.
   *
   * <p>Fetch status details about a submitted document. **Note:** this operation does not return
   * the document itself. Instead, it returns only the document's processing status and any notices
   * (warnings or errors) that were generated when the document was ingested. Use the query API to
   * retrieve the actual document content.
   *
   * @param getDocumentStatusOptions the {@link GetDocumentStatusOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link DocumentStatus}
   */
  public ServiceCall<DocumentStatus> getDocumentStatus(
      GetDocumentStatusOptions getDocumentStatusOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getDocumentStatusOptions, "getDocumentStatusOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", getDocumentStatusOptions.environmentId());
    pathParamsMap.put("collection_id", getDocumentStatusOptions.collectionId());
    pathParamsMap.put("document_id", getDocumentStatusOptions.documentId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/documents/{document_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "getDocumentStatus");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<DocumentStatus> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DocumentStatus>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a document.
   *
   * <p>Replace an existing document or add a document with a specified **document_id**. Starts
   * ingesting a document with optional metadata.
   *
   * <p>**Note:** When uploading a new document with this method it automatically replaces any
   * document stored with the same **document_id** if it exists.
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
    pathParamsMap.put("environment_id", updateDocumentOptions.environmentId());
    pathParamsMap.put("collection_id", updateDocumentOptions.collectionId());
    pathParamsMap.put("document_id", updateDocumentOptions.documentId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/documents/{document_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "updateDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
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
   * @param deleteDocumentOptions the {@link DeleteDocumentOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link DeleteDocumentResponse}
   */
  public ServiceCall<DeleteDocumentResponse> deleteDocument(
      DeleteDocumentOptions deleteDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteDocumentOptions, "deleteDocumentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", deleteDocumentOptions.environmentId());
    pathParamsMap.put("collection_id", deleteDocumentOptions.collectionId());
    pathParamsMap.put("document_id", deleteDocumentOptions.documentId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/documents/{document_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "deleteDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<DeleteDocumentResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DeleteDocumentResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query a collection.
   *
   * <p>By using this method, you can construct long queries. For details, see the [Discovery
   * documentation](https://cloud.ibm.com/docs/discovery?topic=discovery-query-concepts#query-concepts).
   *
   * @param queryOptions the {@link QueryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link QueryResponse}
   */
  public ServiceCall<QueryResponse> query(QueryOptions queryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(queryOptions, "queryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", queryOptions.environmentId());
    pathParamsMap.put("collection_id", queryOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/query",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "query");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (queryOptions.xWatsonLoggingOptOut() != null) {
      builder.header("X-Watson-Logging-Opt-Out", queryOptions.xWatsonLoggingOptOut());
    }
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (queryOptions.filter() != null) {
      contentJson.addProperty("filter", queryOptions.filter());
    }
    if (queryOptions.query() != null) {
      contentJson.addProperty("query", queryOptions.query());
    }
    if (queryOptions.naturalLanguageQuery() != null) {
      contentJson.addProperty("natural_language_query", queryOptions.naturalLanguageQuery());
    }
    if (queryOptions.passages() != null) {
      contentJson.addProperty("passages", queryOptions.passages());
    }
    if (queryOptions.aggregation() != null) {
      contentJson.addProperty("aggregation", queryOptions.aggregation());
    }
    if (queryOptions.count() != null) {
      contentJson.addProperty("count", queryOptions.count());
    }
    if (queryOptions.xReturn() != null) {
      contentJson.addProperty("return", queryOptions.xReturn());
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
    if (queryOptions.passagesFields() != null) {
      contentJson.addProperty("passages.fields", queryOptions.passagesFields());
    }
    if (queryOptions.passagesCount() != null) {
      contentJson.addProperty("passages.count", queryOptions.passagesCount());
    }
    if (queryOptions.passagesCharacters() != null) {
      contentJson.addProperty("passages.characters", queryOptions.passagesCharacters());
    }
    if (queryOptions.deduplicate() != null) {
      contentJson.addProperty("deduplicate", queryOptions.deduplicate());
    }
    if (queryOptions.deduplicateField() != null) {
      contentJson.addProperty("deduplicate.field", queryOptions.deduplicateField());
    }
    if (queryOptions.similar() != null) {
      contentJson.addProperty("similar", queryOptions.similar());
    }
    if (queryOptions.similarDocumentIds() != null) {
      contentJson.addProperty("similar.document_ids", queryOptions.similarDocumentIds());
    }
    if (queryOptions.similarFields() != null) {
      contentJson.addProperty("similar.fields", queryOptions.similarFields());
    }
    if (queryOptions.bias() != null) {
      contentJson.addProperty("bias", queryOptions.bias());
    }
    if (queryOptions.spellingSuggestions() != null) {
      contentJson.addProperty("spelling_suggestions", queryOptions.spellingSuggestions());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<QueryResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<QueryResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query system notices.
   *
   * <p>Queries for notices (errors or warnings) that might have been generated by the system.
   * Notices are generated when ingesting documents and performing relevance training. See the
   * [Discovery
   * documentation](https://cloud.ibm.com/docs/discovery?topic=discovery-query-concepts#query-concepts)
   * for more details on the query language.
   *
   * @param queryNoticesOptions the {@link QueryNoticesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link QueryNoticesResponse}
   */
  public ServiceCall<QueryNoticesResponse> queryNotices(QueryNoticesOptions queryNoticesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        queryNoticesOptions, "queryNoticesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", queryNoticesOptions.environmentId());
    pathParamsMap.put("collection_id", queryNoticesOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/notices",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "queryNotices");
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
    if (queryNoticesOptions.passages() != null) {
      builder.query("passages", String.valueOf(queryNoticesOptions.passages()));
    }
    if (queryNoticesOptions.aggregation() != null) {
      builder.query("aggregation", String.valueOf(queryNoticesOptions.aggregation()));
    }
    if (queryNoticesOptions.count() != null) {
      builder.query("count", String.valueOf(queryNoticesOptions.count()));
    }
    if (queryNoticesOptions.xReturn() != null) {
      builder.query("return", RequestUtils.join(queryNoticesOptions.xReturn(), ","));
    }
    if (queryNoticesOptions.offset() != null) {
      builder.query("offset", String.valueOf(queryNoticesOptions.offset()));
    }
    if (queryNoticesOptions.sort() != null) {
      builder.query("sort", RequestUtils.join(queryNoticesOptions.sort(), ","));
    }
    if (queryNoticesOptions.highlight() != null) {
      builder.query("highlight", String.valueOf(queryNoticesOptions.highlight()));
    }
    if (queryNoticesOptions.passagesFields() != null) {
      builder.query(
          "passages.fields", RequestUtils.join(queryNoticesOptions.passagesFields(), ","));
    }
    if (queryNoticesOptions.passagesCount() != null) {
      builder.query("passages.count", String.valueOf(queryNoticesOptions.passagesCount()));
    }
    if (queryNoticesOptions.passagesCharacters() != null) {
      builder.query(
          "passages.characters", String.valueOf(queryNoticesOptions.passagesCharacters()));
    }
    if (queryNoticesOptions.deduplicateField() != null) {
      builder.query("deduplicate.field", String.valueOf(queryNoticesOptions.deduplicateField()));
    }
    if (queryNoticesOptions.similar() != null) {
      builder.query("similar", String.valueOf(queryNoticesOptions.similar()));
    }
    if (queryNoticesOptions.similarDocumentIds() != null) {
      builder.query(
          "similar.document_ids", RequestUtils.join(queryNoticesOptions.similarDocumentIds(), ","));
    }
    if (queryNoticesOptions.similarFields() != null) {
      builder.query("similar.fields", RequestUtils.join(queryNoticesOptions.similarFields(), ","));
    }
    ResponseConverter<QueryNoticesResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<QueryNoticesResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query multiple collections.
   *
   * <p>By using this method, you can construct long queries that search multiple collection. For
   * details, see the [Discovery
   * documentation](https://cloud.ibm.com/docs/discovery?topic=discovery-query-concepts#query-concepts).
   *
   * @param federatedQueryOptions the {@link FederatedQueryOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link QueryResponse}
   */
  public ServiceCall<QueryResponse> federatedQuery(FederatedQueryOptions federatedQueryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        federatedQueryOptions, "federatedQueryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", federatedQueryOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/environments/{environment_id}/query", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "federatedQuery");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (federatedQueryOptions.xWatsonLoggingOptOut() != null) {
      builder.header("X-Watson-Logging-Opt-Out", federatedQueryOptions.xWatsonLoggingOptOut());
    }
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("collection_ids", federatedQueryOptions.collectionIds());
    if (federatedQueryOptions.filter() != null) {
      contentJson.addProperty("filter", federatedQueryOptions.filter());
    }
    if (federatedQueryOptions.query() != null) {
      contentJson.addProperty("query", federatedQueryOptions.query());
    }
    if (federatedQueryOptions.naturalLanguageQuery() != null) {
      contentJson.addProperty(
          "natural_language_query", federatedQueryOptions.naturalLanguageQuery());
    }
    if (federatedQueryOptions.passages() != null) {
      contentJson.addProperty("passages", federatedQueryOptions.passages());
    }
    if (federatedQueryOptions.aggregation() != null) {
      contentJson.addProperty("aggregation", federatedQueryOptions.aggregation());
    }
    if (federatedQueryOptions.count() != null) {
      contentJson.addProperty("count", federatedQueryOptions.count());
    }
    if (federatedQueryOptions.xReturn() != null) {
      contentJson.addProperty("return", federatedQueryOptions.xReturn());
    }
    if (federatedQueryOptions.offset() != null) {
      contentJson.addProperty("offset", federatedQueryOptions.offset());
    }
    if (federatedQueryOptions.sort() != null) {
      contentJson.addProperty("sort", federatedQueryOptions.sort());
    }
    if (federatedQueryOptions.highlight() != null) {
      contentJson.addProperty("highlight", federatedQueryOptions.highlight());
    }
    if (federatedQueryOptions.passagesFields() != null) {
      contentJson.addProperty("passages.fields", federatedQueryOptions.passagesFields());
    }
    if (federatedQueryOptions.passagesCount() != null) {
      contentJson.addProperty("passages.count", federatedQueryOptions.passagesCount());
    }
    if (federatedQueryOptions.passagesCharacters() != null) {
      contentJson.addProperty("passages.characters", federatedQueryOptions.passagesCharacters());
    }
    if (federatedQueryOptions.deduplicate() != null) {
      contentJson.addProperty("deduplicate", federatedQueryOptions.deduplicate());
    }
    if (federatedQueryOptions.deduplicateField() != null) {
      contentJson.addProperty("deduplicate.field", federatedQueryOptions.deduplicateField());
    }
    if (federatedQueryOptions.similar() != null) {
      contentJson.addProperty("similar", federatedQueryOptions.similar());
    }
    if (federatedQueryOptions.similarDocumentIds() != null) {
      contentJson.addProperty("similar.document_ids", federatedQueryOptions.similarDocumentIds());
    }
    if (federatedQueryOptions.similarFields() != null) {
      contentJson.addProperty("similar.fields", federatedQueryOptions.similarFields());
    }
    if (federatedQueryOptions.bias() != null) {
      contentJson.addProperty("bias", federatedQueryOptions.bias());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<QueryResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<QueryResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Query multiple collection system notices.
   *
   * <p>Queries for notices (errors or warnings) that might have been generated by the system.
   * Notices are generated when ingesting documents and performing relevance training. See the
   * [Discovery
   * documentation](https://cloud.ibm.com/docs/discovery?topic=discovery-query-concepts#query-concepts)
   * for more details on the query language.
   *
   * @param federatedQueryNoticesOptions the {@link FederatedQueryNoticesOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link QueryNoticesResponse}
   */
  public ServiceCall<QueryNoticesResponse> federatedQueryNotices(
      FederatedQueryNoticesOptions federatedQueryNoticesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        federatedQueryNoticesOptions, "federatedQueryNoticesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", federatedQueryNoticesOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/environments/{environment_id}/notices", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "federatedQueryNotices");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    builder.query(
        "collection_ids", RequestUtils.join(federatedQueryNoticesOptions.collectionIds(), ","));
    if (federatedQueryNoticesOptions.filter() != null) {
      builder.query("filter", String.valueOf(federatedQueryNoticesOptions.filter()));
    }
    if (federatedQueryNoticesOptions.query() != null) {
      builder.query("query", String.valueOf(federatedQueryNoticesOptions.query()));
    }
    if (federatedQueryNoticesOptions.naturalLanguageQuery() != null) {
      builder.query(
          "natural_language_query",
          String.valueOf(federatedQueryNoticesOptions.naturalLanguageQuery()));
    }
    if (federatedQueryNoticesOptions.aggregation() != null) {
      builder.query("aggregation", String.valueOf(federatedQueryNoticesOptions.aggregation()));
    }
    if (federatedQueryNoticesOptions.count() != null) {
      builder.query("count", String.valueOf(federatedQueryNoticesOptions.count()));
    }
    if (federatedQueryNoticesOptions.xReturn() != null) {
      builder.query("return", RequestUtils.join(federatedQueryNoticesOptions.xReturn(), ","));
    }
    if (federatedQueryNoticesOptions.offset() != null) {
      builder.query("offset", String.valueOf(federatedQueryNoticesOptions.offset()));
    }
    if (federatedQueryNoticesOptions.sort() != null) {
      builder.query("sort", RequestUtils.join(federatedQueryNoticesOptions.sort(), ","));
    }
    if (federatedQueryNoticesOptions.highlight() != null) {
      builder.query("highlight", String.valueOf(federatedQueryNoticesOptions.highlight()));
    }
    if (federatedQueryNoticesOptions.deduplicateField() != null) {
      builder.query(
          "deduplicate.field", String.valueOf(federatedQueryNoticesOptions.deduplicateField()));
    }
    if (federatedQueryNoticesOptions.similar() != null) {
      builder.query("similar", String.valueOf(federatedQueryNoticesOptions.similar()));
    }
    if (federatedQueryNoticesOptions.similarDocumentIds() != null) {
      builder.query(
          "similar.document_ids",
          RequestUtils.join(federatedQueryNoticesOptions.similarDocumentIds(), ","));
    }
    if (federatedQueryNoticesOptions.similarFields() != null) {
      builder.query(
          "similar.fields", RequestUtils.join(federatedQueryNoticesOptions.similarFields(), ","));
    }
    ResponseConverter<QueryNoticesResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<QueryNoticesResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get Autocomplete Suggestions.
   *
   * <p>Returns completion query suggestions for the specified prefix. /n/n **Important:** this
   * method is only valid when using the Cloud Pak version of Discovery.
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
    pathParamsMap.put("environment_id", getAutocompletionOptions.environmentId());
    pathParamsMap.put("collection_id", getAutocompletionOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/autocompletion",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "getAutocompletion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    builder.query("prefix", String.valueOf(getAutocompletionOptions.prefix()));
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
   * List training data.
   *
   * <p>Lists the training data for the specified collection.
   *
   * @param listTrainingDataOptions the {@link ListTrainingDataOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link TrainingDataSet}
   */
  public ServiceCall<TrainingDataSet> listTrainingData(
      ListTrainingDataOptions listTrainingDataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listTrainingDataOptions, "listTrainingDataOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", listTrainingDataOptions.environmentId());
    pathParamsMap.put("collection_id", listTrainingDataOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/training_data",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "listTrainingData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<TrainingDataSet> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TrainingDataSet>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add query to training data.
   *
   * <p>Adds a query to the training data for this collection. The query can contain a filter and
   * natural language query.
   *
   * @param addTrainingDataOptions the {@link AddTrainingDataOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link TrainingQuery}
   */
  public ServiceCall<TrainingQuery> addTrainingData(AddTrainingDataOptions addTrainingDataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        addTrainingDataOptions, "addTrainingDataOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", addTrainingDataOptions.environmentId());
    pathParamsMap.put("collection_id", addTrainingDataOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/training_data",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "addTrainingData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (addTrainingDataOptions.naturalLanguageQuery() != null) {
      contentJson.addProperty(
          "natural_language_query", addTrainingDataOptions.naturalLanguageQuery());
    }
    if (addTrainingDataOptions.filter() != null) {
      contentJson.addProperty("filter", addTrainingDataOptions.filter());
    }
    if (addTrainingDataOptions.examples() != null) {
      contentJson.add(
          "examples",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(addTrainingDataOptions.examples()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<TrainingQuery> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TrainingQuery>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete all training data.
   *
   * <p>Deletes all training data from a collection.
   *
   * @param deleteAllTrainingDataOptions the {@link DeleteAllTrainingDataOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteAllTrainingData(
      DeleteAllTrainingDataOptions deleteAllTrainingDataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteAllTrainingDataOptions, "deleteAllTrainingDataOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", deleteAllTrainingDataOptions.environmentId());
    pathParamsMap.put("collection_id", deleteAllTrainingDataOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/training_data",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "deleteAllTrainingData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get details about a query.
   *
   * <p>Gets details for a specific training data query, including the query string and all
   * examples.
   *
   * @param getTrainingDataOptions the {@link GetTrainingDataOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link TrainingQuery}
   */
  public ServiceCall<TrainingQuery> getTrainingData(GetTrainingDataOptions getTrainingDataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getTrainingDataOptions, "getTrainingDataOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", getTrainingDataOptions.environmentId());
    pathParamsMap.put("collection_id", getTrainingDataOptions.collectionId());
    pathParamsMap.put("query_id", getTrainingDataOptions.queryId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/training_data/{query_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "getTrainingData");
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
   * Delete a training data query.
   *
   * <p>Removes the training data query and all associated examples from the training data set.
   *
   * @param deleteTrainingDataOptions the {@link DeleteTrainingDataOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteTrainingData(DeleteTrainingDataOptions deleteTrainingDataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteTrainingDataOptions, "deleteTrainingDataOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", deleteTrainingDataOptions.environmentId());
    pathParamsMap.put("collection_id", deleteTrainingDataOptions.collectionId());
    pathParamsMap.put("query_id", deleteTrainingDataOptions.queryId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/training_data/{query_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "deleteTrainingData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List examples for a training data query.
   *
   * <p>List all examples for this training data query.
   *
   * @param listTrainingExamplesOptions the {@link ListTrainingExamplesOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link TrainingExampleList}
   */
  public ServiceCall<TrainingExampleList> listTrainingExamples(
      ListTrainingExamplesOptions listTrainingExamplesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listTrainingExamplesOptions, "listTrainingExamplesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", listTrainingExamplesOptions.environmentId());
    pathParamsMap.put("collection_id", listTrainingExamplesOptions.collectionId());
    pathParamsMap.put("query_id", listTrainingExamplesOptions.queryId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/training_data/{query_id}/examples",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "listTrainingExamples");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<TrainingExampleList> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TrainingExampleList>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add example to training data query.
   *
   * <p>Adds a example to this training data query.
   *
   * @param createTrainingExampleOptions the {@link CreateTrainingExampleOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link TrainingExample}
   */
  public ServiceCall<TrainingExample> createTrainingExample(
      CreateTrainingExampleOptions createTrainingExampleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createTrainingExampleOptions, "createTrainingExampleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", createTrainingExampleOptions.environmentId());
    pathParamsMap.put("collection_id", createTrainingExampleOptions.collectionId());
    pathParamsMap.put("query_id", createTrainingExampleOptions.queryId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/training_data/{query_id}/examples",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "createTrainingExample");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (createTrainingExampleOptions.documentId() != null) {
      contentJson.addProperty("document_id", createTrainingExampleOptions.documentId());
    }
    if (createTrainingExampleOptions.crossReference() != null) {
      contentJson.addProperty("cross_reference", createTrainingExampleOptions.crossReference());
    }
    if (createTrainingExampleOptions.relevance() != null) {
      contentJson.addProperty("relevance", createTrainingExampleOptions.relevance());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<TrainingExample> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TrainingExample>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete example for training data query.
   *
   * <p>Deletes the example document with the given ID from the training data query.
   *
   * @param deleteTrainingExampleOptions the {@link DeleteTrainingExampleOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteTrainingExample(
      DeleteTrainingExampleOptions deleteTrainingExampleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteTrainingExampleOptions, "deleteTrainingExampleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", deleteTrainingExampleOptions.environmentId());
    pathParamsMap.put("collection_id", deleteTrainingExampleOptions.collectionId());
    pathParamsMap.put("query_id", deleteTrainingExampleOptions.queryId());
    pathParamsMap.put("example_id", deleteTrainingExampleOptions.exampleId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/training_data/{query_id}/examples/{example_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "deleteTrainingExample");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Change label or cross reference for example.
   *
   * <p>Changes the label or cross reference query for this training data example.
   *
   * @param updateTrainingExampleOptions the {@link UpdateTrainingExampleOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link TrainingExample}
   */
  public ServiceCall<TrainingExample> updateTrainingExample(
      UpdateTrainingExampleOptions updateTrainingExampleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateTrainingExampleOptions, "updateTrainingExampleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", updateTrainingExampleOptions.environmentId());
    pathParamsMap.put("collection_id", updateTrainingExampleOptions.collectionId());
    pathParamsMap.put("query_id", updateTrainingExampleOptions.queryId());
    pathParamsMap.put("example_id", updateTrainingExampleOptions.exampleId());
    RequestBuilder builder =
        RequestBuilder.put(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/training_data/{query_id}/examples/{example_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "updateTrainingExample");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (updateTrainingExampleOptions.crossReference() != null) {
      contentJson.addProperty("cross_reference", updateTrainingExampleOptions.crossReference());
    }
    if (updateTrainingExampleOptions.relevance() != null) {
      contentJson.addProperty("relevance", updateTrainingExampleOptions.relevance());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<TrainingExample> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TrainingExample>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get details for training data example.
   *
   * <p>Gets the details for this training example.
   *
   * @param getTrainingExampleOptions the {@link GetTrainingExampleOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link TrainingExample}
   */
  public ServiceCall<TrainingExample> getTrainingExample(
      GetTrainingExampleOptions getTrainingExampleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getTrainingExampleOptions, "getTrainingExampleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", getTrainingExampleOptions.environmentId());
    pathParamsMap.put("collection_id", getTrainingExampleOptions.collectionId());
    pathParamsMap.put("query_id", getTrainingExampleOptions.queryId());
    pathParamsMap.put("example_id", getTrainingExampleOptions.exampleId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/collections/{collection_id}/training_data/{query_id}/examples/{example_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "getTrainingExample");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<TrainingExample> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TrainingExample>() {}.getType());
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
   * security](https://cloud.ibm.com/docs/discovery?topic=discovery-information-security#information-security).
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
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "deleteUserData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", String.valueOf(this.version));
    builder.query("customer_id", String.valueOf(deleteUserDataOptions.customerId()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create event.
   *
   * <p>The **Events** API can be used to create log entries that are associated with specific
   * queries. For example, you can record which documents in the results set were "clicked" by a
   * user and when that click occurred.
   *
   * @param createEventOptions the {@link CreateEventOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CreateEventResponse}
   */
  public ServiceCall<CreateEventResponse> createEvent(CreateEventOptions createEventOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createEventOptions, "createEventOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/events"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "createEvent");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("type", createEventOptions.type());
    contentJson.add(
        "data",
        com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createEventOptions.data()));
    builder.bodyJson(contentJson);
    ResponseConverter<CreateEventResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<CreateEventResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Search the query and event log.
   *
   * <p>Searches the query and event log to find query sessions that match the specified criteria.
   * Searching the **logs** endpoint uses the standard Discovery query syntax for the parameters
   * that are supported.
   *
   * @param queryLogOptions the {@link QueryLogOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link LogQueryResponse}
   */
  public ServiceCall<LogQueryResponse> queryLog(QueryLogOptions queryLogOptions) {
    if (queryLogOptions == null) {
      queryLogOptions = new QueryLogOptions.Builder().build();
    }
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/logs"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "queryLog");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (queryLogOptions.filter() != null) {
      builder.query("filter", String.valueOf(queryLogOptions.filter()));
    }
    if (queryLogOptions.query() != null) {
      builder.query("query", String.valueOf(queryLogOptions.query()));
    }
    if (queryLogOptions.count() != null) {
      builder.query("count", String.valueOf(queryLogOptions.count()));
    }
    if (queryLogOptions.offset() != null) {
      builder.query("offset", String.valueOf(queryLogOptions.offset()));
    }
    if (queryLogOptions.sort() != null) {
      builder.query("sort", RequestUtils.join(queryLogOptions.sort(), ","));
    }
    ResponseConverter<LogQueryResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<LogQueryResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Search the query and event log.
   *
   * <p>Searches the query and event log to find query sessions that match the specified criteria.
   * Searching the **logs** endpoint uses the standard Discovery query syntax for the parameters
   * that are supported.
   *
   * @return a {@link ServiceCall} with a result of type {@link LogQueryResponse}
   */
  public ServiceCall<LogQueryResponse> queryLog() {
    return queryLog(null);
  }

  /**
   * Number of queries over time.
   *
   * <p>Total number of queries using the **natural_language_query** parameter over a specific time
   * window.
   *
   * @param getMetricsQueryOptions the {@link GetMetricsQueryOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link MetricResponse}
   */
  public ServiceCall<MetricResponse> getMetricsQuery(
      GetMetricsQueryOptions getMetricsQueryOptions) {
    if (getMetricsQueryOptions == null) {
      getMetricsQueryOptions = new GetMetricsQueryOptions.Builder().build();
    }
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/metrics/number_of_queries"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "getMetricsQuery");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getMetricsQueryOptions.startTime() != null) {
      builder.query("start_time", DateUtils.formatAsDateTime(getMetricsQueryOptions.startTime()));
    }
    if (getMetricsQueryOptions.endTime() != null) {
      builder.query("end_time", DateUtils.formatAsDateTime(getMetricsQueryOptions.endTime()));
    }
    if (getMetricsQueryOptions.resultType() != null) {
      builder.query("result_type", String.valueOf(getMetricsQueryOptions.resultType()));
    }
    ResponseConverter<MetricResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<MetricResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Number of queries over time.
   *
   * <p>Total number of queries using the **natural_language_query** parameter over a specific time
   * window.
   *
   * @return a {@link ServiceCall} with a result of type {@link MetricResponse}
   */
  public ServiceCall<MetricResponse> getMetricsQuery() {
    return getMetricsQuery(null);
  }

  /**
   * Number of queries with an event over time.
   *
   * <p>Total number of queries using the **natural_language_query** parameter that have a
   * corresponding "click" event over a specified time window. This metric requires having
   * integrated event tracking in your application using the **Events** API.
   *
   * @param getMetricsQueryEventOptions the {@link GetMetricsQueryEventOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link MetricResponse}
   */
  public ServiceCall<MetricResponse> getMetricsQueryEvent(
      GetMetricsQueryEventOptions getMetricsQueryEventOptions) {
    if (getMetricsQueryEventOptions == null) {
      getMetricsQueryEventOptions = new GetMetricsQueryEventOptions.Builder().build();
    }
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/metrics/number_of_queries_with_event"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "getMetricsQueryEvent");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getMetricsQueryEventOptions.startTime() != null) {
      builder.query(
          "start_time", DateUtils.formatAsDateTime(getMetricsQueryEventOptions.startTime()));
    }
    if (getMetricsQueryEventOptions.endTime() != null) {
      builder.query("end_time", DateUtils.formatAsDateTime(getMetricsQueryEventOptions.endTime()));
    }
    if (getMetricsQueryEventOptions.resultType() != null) {
      builder.query("result_type", String.valueOf(getMetricsQueryEventOptions.resultType()));
    }
    ResponseConverter<MetricResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<MetricResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Number of queries with an event over time.
   *
   * <p>Total number of queries using the **natural_language_query** parameter that have a
   * corresponding "click" event over a specified time window. This metric requires having
   * integrated event tracking in your application using the **Events** API.
   *
   * @return a {@link ServiceCall} with a result of type {@link MetricResponse}
   */
  public ServiceCall<MetricResponse> getMetricsQueryEvent() {
    return getMetricsQueryEvent(null);
  }

  /**
   * Number of queries with no search results over time.
   *
   * <p>Total number of queries using the **natural_language_query** parameter that have no results
   * returned over a specified time window.
   *
   * @param getMetricsQueryNoResultsOptions the {@link GetMetricsQueryNoResultsOptions} containing
   *     the options for the call
   * @return a {@link ServiceCall} with a result of type {@link MetricResponse}
   */
  public ServiceCall<MetricResponse> getMetricsQueryNoResults(
      GetMetricsQueryNoResultsOptions getMetricsQueryNoResultsOptions) {
    if (getMetricsQueryNoResultsOptions == null) {
      getMetricsQueryNoResultsOptions = new GetMetricsQueryNoResultsOptions.Builder().build();
    }
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/metrics/number_of_queries_with_no_search_results"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "getMetricsQueryNoResults");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getMetricsQueryNoResultsOptions.startTime() != null) {
      builder.query(
          "start_time", DateUtils.formatAsDateTime(getMetricsQueryNoResultsOptions.startTime()));
    }
    if (getMetricsQueryNoResultsOptions.endTime() != null) {
      builder.query(
          "end_time", DateUtils.formatAsDateTime(getMetricsQueryNoResultsOptions.endTime()));
    }
    if (getMetricsQueryNoResultsOptions.resultType() != null) {
      builder.query("result_type", String.valueOf(getMetricsQueryNoResultsOptions.resultType()));
    }
    ResponseConverter<MetricResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<MetricResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Number of queries with no search results over time.
   *
   * <p>Total number of queries using the **natural_language_query** parameter that have no results
   * returned over a specified time window.
   *
   * @return a {@link ServiceCall} with a result of type {@link MetricResponse}
   */
  public ServiceCall<MetricResponse> getMetricsQueryNoResults() {
    return getMetricsQueryNoResults(null);
  }

  /**
   * Percentage of queries with an associated event.
   *
   * <p>The percentage of queries using the **natural_language_query** parameter that have a
   * corresponding "click" event over a specified time window. This metric requires having
   * integrated event tracking in your application using the **Events** API.
   *
   * @param getMetricsEventRateOptions the {@link GetMetricsEventRateOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link MetricResponse}
   */
  public ServiceCall<MetricResponse> getMetricsEventRate(
      GetMetricsEventRateOptions getMetricsEventRateOptions) {
    if (getMetricsEventRateOptions == null) {
      getMetricsEventRateOptions = new GetMetricsEventRateOptions.Builder().build();
    }
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/metrics/event_rate"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "getMetricsEventRate");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getMetricsEventRateOptions.startTime() != null) {
      builder.query(
          "start_time", DateUtils.formatAsDateTime(getMetricsEventRateOptions.startTime()));
    }
    if (getMetricsEventRateOptions.endTime() != null) {
      builder.query("end_time", DateUtils.formatAsDateTime(getMetricsEventRateOptions.endTime()));
    }
    if (getMetricsEventRateOptions.resultType() != null) {
      builder.query("result_type", String.valueOf(getMetricsEventRateOptions.resultType()));
    }
    ResponseConverter<MetricResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<MetricResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Percentage of queries with an associated event.
   *
   * <p>The percentage of queries using the **natural_language_query** parameter that have a
   * corresponding "click" event over a specified time window. This metric requires having
   * integrated event tracking in your application using the **Events** API.
   *
   * @return a {@link ServiceCall} with a result of type {@link MetricResponse}
   */
  public ServiceCall<MetricResponse> getMetricsEventRate() {
    return getMetricsEventRate(null);
  }

  /**
   * Most frequent query tokens with an event.
   *
   * <p>The most frequent query tokens parsed from the **natural_language_query** parameter and
   * their corresponding "click" event rate within the recording period (queries and events are
   * stored for 30 days). A query token is an individual word or unigram within the query string.
   *
   * @param getMetricsQueryTokenEventOptions the {@link GetMetricsQueryTokenEventOptions} containing
   *     the options for the call
   * @return a {@link ServiceCall} with a result of type {@link MetricTokenResponse}
   */
  public ServiceCall<MetricTokenResponse> getMetricsQueryTokenEvent(
      GetMetricsQueryTokenEventOptions getMetricsQueryTokenEventOptions) {
    if (getMetricsQueryTokenEventOptions == null) {
      getMetricsQueryTokenEventOptions = new GetMetricsQueryTokenEventOptions.Builder().build();
    }
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/metrics/top_query_tokens_with_event_rate"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "getMetricsQueryTokenEvent");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getMetricsQueryTokenEventOptions.count() != null) {
      builder.query("count", String.valueOf(getMetricsQueryTokenEventOptions.count()));
    }
    ResponseConverter<MetricTokenResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<MetricTokenResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Most frequent query tokens with an event.
   *
   * <p>The most frequent query tokens parsed from the **natural_language_query** parameter and
   * their corresponding "click" event rate within the recording period (queries and events are
   * stored for 30 days). A query token is an individual word or unigram within the query string.
   *
   * @return a {@link ServiceCall} with a result of type {@link MetricTokenResponse}
   */
  public ServiceCall<MetricTokenResponse> getMetricsQueryTokenEvent() {
    return getMetricsQueryTokenEvent(null);
  }

  /**
   * List credentials.
   *
   * <p>List all the source credentials that have been created for this service instance.
   *
   * <p>**Note:** All credentials are sent over an encrypted connection and encrypted at rest.
   *
   * @param listCredentialsOptions the {@link ListCredentialsOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link CredentialsList}
   */
  public ServiceCall<CredentialsList> listCredentials(
      ListCredentialsOptions listCredentialsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listCredentialsOptions, "listCredentialsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", listCredentialsOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/environments/{environment_id}/credentials", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "listCredentials");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<CredentialsList> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<CredentialsList>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create credentials.
   *
   * <p>Creates a set of credentials to connect to a remote source. Created credentials are used in
   * a configuration to associate a collection with the remote source.
   *
   * <p>**Note:** All credentials are sent over an encrypted connection and encrypted at rest.
   *
   * @param createCredentialsOptions the {@link CreateCredentialsOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Credentials}
   */
  public ServiceCall<Credentials> createCredentials(
      CreateCredentialsOptions createCredentialsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createCredentialsOptions, "createCredentialsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", createCredentialsOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/environments/{environment_id}/credentials", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "createCredentials");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (createCredentialsOptions.sourceType() != null) {
      contentJson.addProperty("source_type", createCredentialsOptions.sourceType());
    }
    if (createCredentialsOptions.credentialDetails() != null) {
      contentJson.add(
          "credential_details",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createCredentialsOptions.credentialDetails()));
    }
    if (createCredentialsOptions.status() != null) {
      contentJson.add(
          "status",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createCredentialsOptions.status()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Credentials> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Credentials>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * View Credentials.
   *
   * <p>Returns details about the specified credentials.
   *
   * <p>**Note:** Secure credential information such as a password or SSH key is never returned and
   * must be obtained from the source system.
   *
   * @param getCredentialsOptions the {@link GetCredentialsOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Credentials}
   */
  public ServiceCall<Credentials> getCredentials(GetCredentialsOptions getCredentialsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getCredentialsOptions, "getCredentialsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", getCredentialsOptions.environmentId());
    pathParamsMap.put("credential_id", getCredentialsOptions.credentialId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/credentials/{credential_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "getCredentials");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Credentials> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Credentials>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update credentials.
   *
   * <p>Updates an existing set of source credentials.
   *
   * <p>**Note:** All credentials are sent over an encrypted connection and encrypted at rest.
   *
   * @param updateCredentialsOptions the {@link UpdateCredentialsOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Credentials}
   */
  public ServiceCall<Credentials> updateCredentials(
      UpdateCredentialsOptions updateCredentialsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateCredentialsOptions, "updateCredentialsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", updateCredentialsOptions.environmentId());
    pathParamsMap.put("credential_id", updateCredentialsOptions.credentialId());
    RequestBuilder builder =
        RequestBuilder.put(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/credentials/{credential_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "updateCredentials");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (updateCredentialsOptions.sourceType() != null) {
      contentJson.addProperty("source_type", updateCredentialsOptions.sourceType());
    }
    if (updateCredentialsOptions.credentialDetails() != null) {
      contentJson.add(
          "credential_details",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateCredentialsOptions.credentialDetails()));
    }
    if (updateCredentialsOptions.status() != null) {
      contentJson.add(
          "status",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateCredentialsOptions.status()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Credentials> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Credentials>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete credentials.
   *
   * <p>Deletes a set of stored credentials from your Discovery instance.
   *
   * @param deleteCredentialsOptions the {@link DeleteCredentialsOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteCredentials}
   */
  public ServiceCall<DeleteCredentials> deleteCredentials(
      DeleteCredentialsOptions deleteCredentialsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteCredentialsOptions, "deleteCredentialsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", deleteCredentialsOptions.environmentId());
    pathParamsMap.put("credential_id", deleteCredentialsOptions.credentialId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/credentials/{credential_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("discovery", "v1", "deleteCredentials");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<DeleteCredentials> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<DeleteCredentials>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List Gateways.
   *
   * <p>List the currently configured gateways.
   *
   * @param listGatewaysOptions the {@link ListGatewaysOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GatewayList}
   */
  public ServiceCall<GatewayList> listGateways(ListGatewaysOptions listGatewaysOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listGatewaysOptions, "listGatewaysOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", listGatewaysOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/environments/{environment_id}/gateways", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "listGateways");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<GatewayList> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<GatewayList>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create Gateway.
   *
   * <p>Create a gateway configuration to use with a remotely installed gateway.
   *
   * @param createGatewayOptions the {@link CreateGatewayOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Gateway}
   */
  public ServiceCall<Gateway> createGateway(CreateGatewayOptions createGatewayOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createGatewayOptions, "createGatewayOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", createGatewayOptions.environmentId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/environments/{environment_id}/gateways", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "createGateway");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (createGatewayOptions.name() != null) {
      contentJson.addProperty("name", createGatewayOptions.name());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Gateway> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Gateway>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List Gateway Details.
   *
   * <p>List information about the specified gateway.
   *
   * @param getGatewayOptions the {@link GetGatewayOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Gateway}
   */
  public ServiceCall<Gateway> getGateway(GetGatewayOptions getGatewayOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getGatewayOptions, "getGatewayOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", getGatewayOptions.environmentId());
    pathParamsMap.put("gateway_id", getGatewayOptions.gatewayId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/gateways/{gateway_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "getGateway");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Gateway> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Gateway>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete Gateway.
   *
   * <p>Delete the specified gateway configuration.
   *
   * @param deleteGatewayOptions the {@link DeleteGatewayOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link GatewayDelete}
   */
  public ServiceCall<GatewayDelete> deleteGateway(DeleteGatewayOptions deleteGatewayOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteGatewayOptions, "deleteGatewayOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("environment_id", deleteGatewayOptions.environmentId());
    pathParamsMap.put("gateway_id", deleteGatewayOptions.gatewayId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v1/environments/{environment_id}/gateways/{gateway_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("discovery", "v1", "deleteGateway");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<GatewayDelete> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<GatewayDelete>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }
}

/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.discovery.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.cloud.sdk.core.util.Validator;
import com.ibm.watson.discovery.v1.model.AddDocumentOptions;
import com.ibm.watson.discovery.v1.model.AddTrainingDataOptions;
import com.ibm.watson.discovery.v1.model.Collection;
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
import com.ibm.watson.discovery.v1.model.DeleteConfigurationOptions;
import com.ibm.watson.discovery.v1.model.DeleteCredentialsOptions;
import com.ibm.watson.discovery.v1.model.DeleteDocumentOptions;
import com.ibm.watson.discovery.v1.model.DeleteEnvironmentOptions;
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
import com.ibm.watson.discovery.v1.model.GatewayList;
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
import com.ibm.watson.discovery.v1.model.QueryEntitiesOptions;
import com.ibm.watson.discovery.v1.model.QueryEntitiesResponse;
import com.ibm.watson.discovery.v1.model.QueryLogOptions;
import com.ibm.watson.discovery.v1.model.QueryNoticesOptions;
import com.ibm.watson.discovery.v1.model.QueryNoticesResponse;
import com.ibm.watson.discovery.v1.model.QueryOptions;
import com.ibm.watson.discovery.v1.model.QueryRelationsOptions;
import com.ibm.watson.discovery.v1.model.QueryRelationsResponse;
import com.ibm.watson.discovery.v1.model.QueryResponse;
import com.ibm.watson.discovery.v1.model.TestConfigurationInEnvironmentOptions;
import com.ibm.watson.discovery.v1.model.TestDocument;
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
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.apache.commons.lang3.StringUtils;

/**
 * The IBM Watson&trade; Discovery Service is a cognitive search and content analytics engine that you can add to
 * applications to identify patterns, trends and actionable insights to drive better decision-making. Securely unify
 * structured and unstructured data with pre-enriched content, and use a simplified query language to eliminate the need
 * for manual filtering of results.
 *
 * @version v1
 * @see <a href="http://www.ibm.com/watson/developercloud/discovery.html">Discovery</a>
 */
public class Discovery extends BaseService {

  private static final String SERVICE_NAME = "discovery";
  private static final String URL = "https://gateway.watsonplatform.net/discovery/api";

  private String versionDate;

  /**
   * Instantiates a new `Discovery`.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   */
  public Discovery(String versionDate) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");

    this.versionDate = versionDate;
  }

  /**
   * Instantiates a new `Discovery` with username and password.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param username the username
   * @param password the password
   */
  public Discovery(String versionDate, String username, String password) {
    this(versionDate);
    setUsernameAndPassword(username, password);
  }

  /**
   * Instantiates a new `Discovery` with IAM. Note that if the access token is specified in the
   * iamOptions, you accept responsibility for managing the access token yourself. You must set a new access token
   * before this
   * one expires or after receiving a 401 error from the service. Failing to do so will result in authentication errors
   * after this token expires.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param iamOptions the options for authenticating through IAM
   */
  public Discovery(String versionDate, IamOptions iamOptions) {
    this(versionDate);
    setIamCredentials(iamOptions);
  }

  /**
   * Create an environment.
   *
   * Creates a new environment for private data. An environment must be created before collections can be created.
   *
   * **Note**: You can create only one environment for private data per service instance. An attempt to create another
   * environment results in an error.
   *
   * @param createEnvironmentOptions the {@link CreateEnvironmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Environment}
   */
  public ServiceCall<Environment> createEnvironment(CreateEnvironmentOptions createEnvironmentOptions) {
    Validator.notNull(createEnvironmentOptions, "createEnvironmentOptions cannot be null");
    String[] pathSegments = { "v1/environments" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=createEnvironment");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createEnvironmentOptions.name());
    if (createEnvironmentOptions.description() != null) {
      contentJson.addProperty("description", createEnvironmentOptions.description());
    }
    if (createEnvironmentOptions.size() != null) {
      contentJson.addProperty("size", createEnvironmentOptions.size());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Environment.class));
  }

  /**
   * Delete environment.
   *
   * @param deleteEnvironmentOptions the {@link DeleteEnvironmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteEnvironment(DeleteEnvironmentOptions deleteEnvironmentOptions) {
    Validator.notNull(deleteEnvironmentOptions, "deleteEnvironmentOptions cannot be null");
    String[] pathSegments = { "v1/environments" };
    String[] pathParameters = { deleteEnvironmentOptions.environmentId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=deleteEnvironment");
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get environment info.
   *
   * @param getEnvironmentOptions the {@link GetEnvironmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Environment}
   */
  public ServiceCall<Environment> getEnvironment(GetEnvironmentOptions getEnvironmentOptions) {
    Validator.notNull(getEnvironmentOptions, "getEnvironmentOptions cannot be null");
    String[] pathSegments = { "v1/environments" };
    String[] pathParameters = { getEnvironmentOptions.environmentId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=getEnvironment");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Environment.class));
  }

  /**
   * List environments.
   *
   * List existing environments for the service instance.
   *
   * @param listEnvironmentsOptions the {@link ListEnvironmentsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ListEnvironmentsResponse}
   */
  public ServiceCall<ListEnvironmentsResponse> listEnvironments(ListEnvironmentsOptions listEnvironmentsOptions) {
    String[] pathSegments = { "v1/environments" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=listEnvironments");
    if (listEnvironmentsOptions != null) {
      if (listEnvironmentsOptions.name() != null) {
        builder.query("name", listEnvironmentsOptions.name());
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ListEnvironmentsResponse.class));
  }

  /**
   * List environments.
   *
   * List existing environments for the service instance.
   *
   * @return a {@link ServiceCall} with a response type of {@link ListEnvironmentsResponse}
   */
  public ServiceCall<ListEnvironmentsResponse> listEnvironments() {
    return listEnvironments(null);
  }

  /**
   * List fields across collections.
   *
   * Gets a list of the unique fields (and their types) stored in the indexes of the specified collections.
   *
   * @param listFieldsOptions the {@link ListFieldsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ListCollectionFieldsResponse}
   */
  public ServiceCall<ListCollectionFieldsResponse> listFields(ListFieldsOptions listFieldsOptions) {
    Validator.notNull(listFieldsOptions, "listFieldsOptions cannot be null");
    String[] pathSegments = { "v1/environments", "fields" };
    String[] pathParameters = { listFieldsOptions.environmentId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=listFields");
    builder.query("collection_ids", RequestUtils.join(listFieldsOptions.collectionIds(), ","));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ListCollectionFieldsResponse.class));
  }

  /**
   * Update an environment.
   *
   * Updates an environment. The environment's **name** and **description** parameters can be changed. You must specify
   * a **name** for the environment.
   *
   * @param updateEnvironmentOptions the {@link UpdateEnvironmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Environment}
   */
  public ServiceCall<Environment> updateEnvironment(UpdateEnvironmentOptions updateEnvironmentOptions) {
    Validator.notNull(updateEnvironmentOptions, "updateEnvironmentOptions cannot be null");
    String[] pathSegments = { "v1/environments" };
    String[] pathParameters = { updateEnvironmentOptions.environmentId() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=updateEnvironment");
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
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Environment.class));
  }

  /**
   * Add configuration.
   *
   * Creates a new configuration.
   *
   * If the input configuration contains the **configuration_id**, **created**, or **updated** properties, then they are
   * ignored and overridden by the system, and an error is not returned so that the overridden fields do not need to be
   * removed when copying a configuration.
   *
   * The configuration can contain unrecognized JSON fields. Any such fields are ignored and do not generate an error.
   * This makes it easier to use newer configuration files with older versions of the API and the service. It also makes
   * it possible for the tooling to add additional metadata and information to the configuration.
   *
   * @param createConfigurationOptions the {@link CreateConfigurationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Configuration}
   */
  public ServiceCall<Configuration> createConfiguration(CreateConfigurationOptions createConfigurationOptions) {
    Validator.notNull(createConfigurationOptions, "createConfigurationOptions cannot be null");
    String[] pathSegments = { "v1/environments", "configurations" };
    String[] pathParameters = { createConfigurationOptions.environmentId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=createConfiguration");
    final JsonObject contentJson = new JsonObject();
    if (createConfigurationOptions.name() != null) {
      contentJson.addProperty("name", createConfigurationOptions.name());
    }
    if (createConfigurationOptions.description() != null) {
      contentJson.addProperty("description", createConfigurationOptions.description());
    }
    if (createConfigurationOptions.conversions() != null) {
      contentJson.add("conversions", GsonSingleton.getGson().toJsonTree(createConfigurationOptions.conversions()));
    }
    if (createConfigurationOptions.enrichments() != null) {
      contentJson.add("enrichments", GsonSingleton.getGson().toJsonTree(createConfigurationOptions.enrichments()));
    }
    if (createConfigurationOptions.normalizations() != null) {
      contentJson.add("normalizations", GsonSingleton.getGson().toJsonTree(createConfigurationOptions
          .normalizations()));
    }
    if (createConfigurationOptions.source() != null) {
      contentJson.add("source", GsonSingleton.getGson().toJsonTree(createConfigurationOptions.source()));
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Configuration.class));
  }

  /**
   * Delete a configuration.
   *
   * The deletion is performed unconditionally. A configuration deletion request succeeds even if the configuration is
   * referenced by a collection or document ingestion. However, documents that have already been submitted for
   * processing continue to use the deleted configuration. Documents are always processed with a snapshot of the
   * configuration as it existed at the time the document was submitted.
   *
   * @param deleteConfigurationOptions the {@link DeleteConfigurationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteConfiguration(DeleteConfigurationOptions deleteConfigurationOptions) {
    Validator.notNull(deleteConfigurationOptions, "deleteConfigurationOptions cannot be null");
    String[] pathSegments = { "v1/environments", "configurations" };
    String[] pathParameters = { deleteConfigurationOptions.environmentId(), deleteConfigurationOptions
        .configurationId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=deleteConfiguration");
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get configuration details.
   *
   * @param getConfigurationOptions the {@link GetConfigurationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Configuration}
   */
  public ServiceCall<Configuration> getConfiguration(GetConfigurationOptions getConfigurationOptions) {
    Validator.notNull(getConfigurationOptions, "getConfigurationOptions cannot be null");
    String[] pathSegments = { "v1/environments", "configurations" };
    String[] pathParameters = { getConfigurationOptions.environmentId(), getConfigurationOptions.configurationId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=getConfiguration");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Configuration.class));
  }

  /**
   * List configurations.
   *
   * Lists existing configurations for the service instance.
   *
   * @param listConfigurationsOptions the {@link ListConfigurationsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ListConfigurationsResponse}
   */
  public ServiceCall<ListConfigurationsResponse> listConfigurations(
      ListConfigurationsOptions listConfigurationsOptions) {
    Validator.notNull(listConfigurationsOptions, "listConfigurationsOptions cannot be null");
    String[] pathSegments = { "v1/environments", "configurations" };
    String[] pathParameters = { listConfigurationsOptions.environmentId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=listConfigurations");
    if (listConfigurationsOptions.name() != null) {
      builder.query("name", listConfigurationsOptions.name());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ListConfigurationsResponse.class));
  }

  /**
   * Update a configuration.
   *
   * Replaces an existing configuration.
   * * Completely replaces the original configuration.
   * * The **configuration_id**, **updated**, and **created** fields are accepted in the request, but they are
   * ignored, and an error is not generated. It is also acceptable for users to submit an updated configuration with
   * none of the three properties.
   * * Documents are processed with a snapshot of the configuration as it was at the time the document was submitted
   * to be ingested. This means that already submitted documents will not see any updates made to the configuration.
   *
   * @param updateConfigurationOptions the {@link UpdateConfigurationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Configuration}
   */
  public ServiceCall<Configuration> updateConfiguration(UpdateConfigurationOptions updateConfigurationOptions) {
    Validator.notNull(updateConfigurationOptions, "updateConfigurationOptions cannot be null");
    String[] pathSegments = { "v1/environments", "configurations" };
    String[] pathParameters = { updateConfigurationOptions.environmentId(), updateConfigurationOptions
        .configurationId() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=updateConfiguration");
    final JsonObject contentJson = new JsonObject();
    if (updateConfigurationOptions.name() != null) {
      contentJson.addProperty("name", updateConfigurationOptions.name());
    }
    if (updateConfigurationOptions.description() != null) {
      contentJson.addProperty("description", updateConfigurationOptions.description());
    }
    if (updateConfigurationOptions.conversions() != null) {
      contentJson.add("conversions", GsonSingleton.getGson().toJsonTree(updateConfigurationOptions.conversions()));
    }
    if (updateConfigurationOptions.enrichments() != null) {
      contentJson.add("enrichments", GsonSingleton.getGson().toJsonTree(updateConfigurationOptions.enrichments()));
    }
    if (updateConfigurationOptions.normalizations() != null) {
      contentJson.add("normalizations", GsonSingleton.getGson().toJsonTree(updateConfigurationOptions
          .normalizations()));
    }
    if (updateConfigurationOptions.source() != null) {
      contentJson.add("source", GsonSingleton.getGson().toJsonTree(updateConfigurationOptions.source()));
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Configuration.class));
  }

  /**
   * Test configuration.
   *
   * Runs a sample document through the default or your configuration and returns diagnostic information designed to
   * help you understand how the document was processed. The document is not added to the index.
   *
   * @param testConfigurationInEnvironmentOptions the {@link TestConfigurationInEnvironmentOptions} containing the
   *          options for the call
   * @return a {@link ServiceCall} with a response type of {@link TestDocument}
   */
  public ServiceCall<TestDocument> testConfigurationInEnvironment(
      TestConfigurationInEnvironmentOptions testConfigurationInEnvironmentOptions) {
    Validator.notNull(testConfigurationInEnvironmentOptions, "testConfigurationInEnvironmentOptions cannot be null");
    Validator.isTrue((testConfigurationInEnvironmentOptions.configuration() != null)
        || (testConfigurationInEnvironmentOptions.file() != null) || (testConfigurationInEnvironmentOptions
            .metadata() != null), "At least one of configuration, file, or metadata must be supplied.");
    String[] pathSegments = { "v1/environments", "preview" };
    String[] pathParameters = { testConfigurationInEnvironmentOptions.environmentId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=testConfigurationInEnvironment");
    if (testConfigurationInEnvironmentOptions.step() != null) {
      builder.query("step", testConfigurationInEnvironmentOptions.step());
    }
    if (testConfigurationInEnvironmentOptions.configurationId() != null) {
      builder.query("configuration_id", testConfigurationInEnvironmentOptions.configurationId());
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (testConfigurationInEnvironmentOptions.configuration() != null) {
      multipartBuilder.addFormDataPart("configuration", testConfigurationInEnvironmentOptions.configuration());
    }
    if (testConfigurationInEnvironmentOptions.file() != null) {
      RequestBody fileBody = RequestUtils.inputStreamBody(testConfigurationInEnvironmentOptions.file(),
          testConfigurationInEnvironmentOptions.fileContentType());
      multipartBuilder.addFormDataPart("file", testConfigurationInEnvironmentOptions.filename(), fileBody);
    }
    if (testConfigurationInEnvironmentOptions.metadata() != null) {
      multipartBuilder.addFormDataPart("metadata", testConfigurationInEnvironmentOptions.metadata());
    }
    builder.body(multipartBuilder.build());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TestDocument.class));
  }

  /**
   * Create a collection.
   *
   * @param createCollectionOptions the {@link CreateCollectionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Collection}
   */
  public ServiceCall<Collection> createCollection(CreateCollectionOptions createCollectionOptions) {
    Validator.notNull(createCollectionOptions, "createCollectionOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections" };
    String[] pathParameters = { createCollectionOptions.environmentId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=createCollection");
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
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Collection.class));
  }

  /**
   * Delete a collection.
   *
   * @param deleteCollectionOptions the {@link DeleteCollectionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteCollection(DeleteCollectionOptions deleteCollectionOptions) {
    Validator.notNull(deleteCollectionOptions, "deleteCollectionOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections" };
    String[] pathParameters = { deleteCollectionOptions.environmentId(), deleteCollectionOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=deleteCollection");
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get collection details.
   *
   * @param getCollectionOptions the {@link GetCollectionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Collection}
   */
  public ServiceCall<Collection> getCollection(GetCollectionOptions getCollectionOptions) {
    Validator.notNull(getCollectionOptions, "getCollectionOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections" };
    String[] pathParameters = { getCollectionOptions.environmentId(), getCollectionOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=getCollection");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Collection.class));
  }

  /**
   * List collection fields.
   *
   * Gets a list of the unique fields (and their types) stored in the index.
   *
   * @param listCollectionFieldsOptions the {@link ListCollectionFieldsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ListCollectionFieldsResponse}
   */
  public ServiceCall<ListCollectionFieldsResponse> listCollectionFields(
      ListCollectionFieldsOptions listCollectionFieldsOptions) {
    Validator.notNull(listCollectionFieldsOptions, "listCollectionFieldsOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "fields" };
    String[] pathParameters = { listCollectionFieldsOptions.environmentId(), listCollectionFieldsOptions
        .collectionId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=listCollectionFields");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ListCollectionFieldsResponse.class));
  }

  /**
   * List collections.
   *
   * Lists existing collections for the service instance.
   *
   * @param listCollectionsOptions the {@link ListCollectionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ListCollectionsResponse}
   */
  public ServiceCall<ListCollectionsResponse> listCollections(ListCollectionsOptions listCollectionsOptions) {
    Validator.notNull(listCollectionsOptions, "listCollectionsOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections" };
    String[] pathParameters = { listCollectionsOptions.environmentId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=listCollections");
    if (listCollectionsOptions.name() != null) {
      builder.query("name", listCollectionsOptions.name());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ListCollectionsResponse.class));
  }

  /**
   * Update a collection.
   *
   * @param updateCollectionOptions the {@link UpdateCollectionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Collection}
   */
  public ServiceCall<Collection> updateCollection(UpdateCollectionOptions updateCollectionOptions) {
    Validator.notNull(updateCollectionOptions, "updateCollectionOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections" };
    String[] pathParameters = { updateCollectionOptions.environmentId(), updateCollectionOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=updateCollection");
    final JsonObject contentJson = new JsonObject();
    if (updateCollectionOptions.name() != null) {
      contentJson.addProperty("name", updateCollectionOptions.name());
    }
    if (updateCollectionOptions.description() != null) {
      contentJson.addProperty("description", updateCollectionOptions.description());
    }
    if (updateCollectionOptions.configurationId() != null) {
      contentJson.addProperty("configuration_id", updateCollectionOptions.configurationId());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Collection.class));
  }

  /**
   * Create or update expansion list.
   *
   * Create or replace the Expansion list for this collection. The maximum number of expanded terms per collection is
   * `500`.
   * The current expansion list is replaced with the uploaded content.
   *
   * @param createExpansionsOptions the {@link CreateExpansionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Expansions}
   */
  public ServiceCall<Expansions> createExpansions(CreateExpansionsOptions createExpansionsOptions) {
    Validator.notNull(createExpansionsOptions, "createExpansionsOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "expansions" };
    String[] pathParameters = { createExpansionsOptions.environmentId(), createExpansionsOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=createExpansions");
    final JsonObject contentJson = new JsonObject();
    if (createExpansionsOptions.expansions() != null) {
      contentJson.add("expansions", GsonSingleton.getGson().toJsonTree(createExpansionsOptions.expansions()));
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Expansions.class));
  }

  /**
   * Create stopword list.
   *
   * Upload a custom stopword list to use with the specified collection.
   *
   * @param createStopwordListOptions the {@link CreateStopwordListOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TokenDictStatusResponse}
   */
  public ServiceCall<TokenDictStatusResponse> createStopwordList(CreateStopwordListOptions createStopwordListOptions) {
    Validator.notNull(createStopwordListOptions, "createStopwordListOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "word_lists/stopwords" };
    String[] pathParameters = { createStopwordListOptions.environmentId(), createStopwordListOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=createStopwordList");
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    RequestBody stopwordFileBody = RequestUtils.inputStreamBody(createStopwordListOptions.stopwordFile(),
        "application/octet-stream");
    multipartBuilder.addFormDataPart("stopword_file", createStopwordListOptions.stopwordFilename(), stopwordFileBody);
    builder.body(multipartBuilder.build());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TokenDictStatusResponse.class));
  }

  /**
   * Create tokenization dictionary.
   *
   * Upload a custom tokenization dictionary to use with the specified collection.
   *
   * @param createTokenizationDictionaryOptions the {@link CreateTokenizationDictionaryOptions} containing the options
   *          for the call
   * @return a {@link ServiceCall} with a response type of {@link TokenDictStatusResponse}
   */
  public ServiceCall<TokenDictStatusResponse> createTokenizationDictionary(
      CreateTokenizationDictionaryOptions createTokenizationDictionaryOptions) {
    Validator.notNull(createTokenizationDictionaryOptions, "createTokenizationDictionaryOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "word_lists/tokenization_dictionary" };
    String[] pathParameters = { createTokenizationDictionaryOptions.environmentId(), createTokenizationDictionaryOptions
        .collectionId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=createTokenizationDictionary");
    final JsonObject contentJson = new JsonObject();
    if (createTokenizationDictionaryOptions.tokenizationRules() != null) {
      contentJson.add("tokenization_rules", GsonSingleton.getGson().toJsonTree(createTokenizationDictionaryOptions
          .tokenizationRules()));
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TokenDictStatusResponse.class));
  }

  /**
   * Delete the expansion list.
   *
   * Remove the expansion information for this collection. The expansion list must be deleted to disable query expansion
   * for a collection.
   *
   * @param deleteExpansionsOptions the {@link DeleteExpansionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteExpansions(DeleteExpansionsOptions deleteExpansionsOptions) {
    Validator.notNull(deleteExpansionsOptions, "deleteExpansionsOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "expansions" };
    String[] pathParameters = { deleteExpansionsOptions.environmentId(), deleteExpansionsOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=deleteExpansions");
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Delete a custom stopword list.
   *
   * Delete a custom stopword list from the collection. After a custom stopword list is deleted, the default list is
   * used for the collection.
   *
   * @param deleteStopwordListOptions the {@link DeleteStopwordListOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteStopwordList(DeleteStopwordListOptions deleteStopwordListOptions) {
    Validator.notNull(deleteStopwordListOptions, "deleteStopwordListOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "word_lists/stopwords" };
    String[] pathParameters = { deleteStopwordListOptions.environmentId(), deleteStopwordListOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=deleteStopwordList");
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Delete tokenization dictionary.
   *
   * Delete the tokenization dictionary from the collection.
   *
   * @param deleteTokenizationDictionaryOptions the {@link DeleteTokenizationDictionaryOptions} containing the options
   *          for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteTokenizationDictionary(
      DeleteTokenizationDictionaryOptions deleteTokenizationDictionaryOptions) {
    Validator.notNull(deleteTokenizationDictionaryOptions, "deleteTokenizationDictionaryOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "word_lists/tokenization_dictionary" };
    String[] pathParameters = { deleteTokenizationDictionaryOptions.environmentId(), deleteTokenizationDictionaryOptions
        .collectionId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=deleteTokenizationDictionary");
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get stopword list status.
   *
   * Returns the current status of the stopword list for the specified collection.
   *
   * @param getStopwordListStatusOptions the {@link GetStopwordListStatusOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TokenDictStatusResponse}
   */
  public ServiceCall<TokenDictStatusResponse> getStopwordListStatus(
      GetStopwordListStatusOptions getStopwordListStatusOptions) {
    Validator.notNull(getStopwordListStatusOptions, "getStopwordListStatusOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "word_lists/stopwords" };
    String[] pathParameters = { getStopwordListStatusOptions.environmentId(), getStopwordListStatusOptions
        .collectionId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=getStopwordListStatus");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TokenDictStatusResponse.class));
  }

  /**
   * Get tokenization dictionary status.
   *
   * Returns the current status of the tokenization dictionary for the specified collection.
   *
   * @param getTokenizationDictionaryStatusOptions the {@link GetTokenizationDictionaryStatusOptions} containing the
   *          options for the call
   * @return a {@link ServiceCall} with a response type of {@link TokenDictStatusResponse}
   */
  public ServiceCall<TokenDictStatusResponse> getTokenizationDictionaryStatus(
      GetTokenizationDictionaryStatusOptions getTokenizationDictionaryStatusOptions) {
    Validator.notNull(getTokenizationDictionaryStatusOptions, "getTokenizationDictionaryStatusOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "word_lists/tokenization_dictionary" };
    String[] pathParameters = { getTokenizationDictionaryStatusOptions.environmentId(),
        getTokenizationDictionaryStatusOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=getTokenizationDictionaryStatus");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TokenDictStatusResponse.class));
  }

  /**
   * Get the expansion list.
   *
   * Returns the current expansion list for the specified collection. If an expansion list is not specified, an object
   * with empty expansion arrays is returned.
   *
   * @param listExpansionsOptions the {@link ListExpansionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Expansions}
   */
  public ServiceCall<Expansions> listExpansions(ListExpansionsOptions listExpansionsOptions) {
    Validator.notNull(listExpansionsOptions, "listExpansionsOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "expansions" };
    String[] pathParameters = { listExpansionsOptions.environmentId(), listExpansionsOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=listExpansions");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Expansions.class));
  }

  /**
   * Add a document.
   *
   * Add a document to a collection with optional metadata.
   *
   * * The **version** query parameter is still required.
   *
   * * Returns immediately after the system has accepted the document for processing.
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
   * * Fields containing the following characters after normalization are filtered out before indexing: `#` and `,`.
   *
   * @param addDocumentOptions the {@link AddDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link DocumentAccepted}
   */
  public ServiceCall<DocumentAccepted> addDocument(AddDocumentOptions addDocumentOptions) {
    Validator.notNull(addDocumentOptions, "addDocumentOptions cannot be null");
    Validator.isTrue((addDocumentOptions.file() != null) || (addDocumentOptions.metadata() != null),
        "At least one of file or metadata must be supplied.");
    String[] pathSegments = { "v1/environments", "collections", "documents" };
    String[] pathParameters = { addDocumentOptions.environmentId(), addDocumentOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=addDocument");
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (addDocumentOptions.file() != null) {
      RequestBody fileBody = RequestUtils.inputStreamBody(addDocumentOptions.file(), addDocumentOptions
          .fileContentType());
      multipartBuilder.addFormDataPart("file", addDocumentOptions.filename(), fileBody);
    }
    if (addDocumentOptions.metadata() != null) {
      multipartBuilder.addFormDataPart("metadata", addDocumentOptions.metadata());
    }
    builder.body(multipartBuilder.build());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DocumentAccepted.class));
  }

  /**
   * Delete a document.
   *
   * If the given document ID is invalid, or if the document is not found, then the a success response is returned (HTTP
   * status code `200`) with the status set to 'deleted'.
   *
   * @param deleteDocumentOptions the {@link DeleteDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteDocument(DeleteDocumentOptions deleteDocumentOptions) {
    Validator.notNull(deleteDocumentOptions, "deleteDocumentOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "documents" };
    String[] pathParameters = { deleteDocumentOptions.environmentId(), deleteDocumentOptions.collectionId(),
        deleteDocumentOptions.documentId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=deleteDocument");
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get document details.
   *
   * Fetch status details about a submitted document. **Note:** this operation does not return the document itself.
   * Instead, it returns only the document's processing status and any notices (warnings or errors) that were generated
   * when the document was ingested. Use the query API to retrieve the actual document content.
   *
   * @param getDocumentStatusOptions the {@link GetDocumentStatusOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link DocumentStatus}
   */
  public ServiceCall<DocumentStatus> getDocumentStatus(GetDocumentStatusOptions getDocumentStatusOptions) {
    Validator.notNull(getDocumentStatusOptions, "getDocumentStatusOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "documents" };
    String[] pathParameters = { getDocumentStatusOptions.environmentId(), getDocumentStatusOptions.collectionId(),
        getDocumentStatusOptions.documentId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=getDocumentStatus");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DocumentStatus.class));
  }

  /**
   * Update a document.
   *
   * Replace an existing document. Starts ingesting a document with optional metadata.
   *
   * @param updateDocumentOptions the {@link UpdateDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link DocumentAccepted}
   */
  public ServiceCall<DocumentAccepted> updateDocument(UpdateDocumentOptions updateDocumentOptions) {
    Validator.notNull(updateDocumentOptions, "updateDocumentOptions cannot be null");
    Validator.isTrue((updateDocumentOptions.file() != null) || (updateDocumentOptions.metadata() != null),
        "At least one of file or metadata must be supplied.");
    String[] pathSegments = { "v1/environments", "collections", "documents" };
    String[] pathParameters = { updateDocumentOptions.environmentId(), updateDocumentOptions.collectionId(),
        updateDocumentOptions.documentId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=updateDocument");
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (updateDocumentOptions.file() != null) {
      RequestBody fileBody = RequestUtils.inputStreamBody(updateDocumentOptions.file(), updateDocumentOptions
          .fileContentType());
      multipartBuilder.addFormDataPart("file", updateDocumentOptions.filename(), fileBody);
    }
    if (updateDocumentOptions.metadata() != null) {
      multipartBuilder.addFormDataPart("metadata", updateDocumentOptions.metadata());
    }
    builder.body(multipartBuilder.build());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DocumentAccepted.class));
  }

  /**
   * Long environment queries.
   *
   * Complex queries might be too long for a standard method query. By using this method, you can construct longer
   * queries. However, these queries may take longer to complete than the standard method. For details, see the
   * [Discovery service documentation](https://console.bluemix.net/docs/services/discovery/using.html).
   *
   * @param federatedQueryOptions the {@link FederatedQueryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link QueryResponse}
   */
  public ServiceCall<QueryResponse> federatedQuery(FederatedQueryOptions federatedQueryOptions) {
    Validator.notNull(federatedQueryOptions, "federatedQueryOptions cannot be null");
    String[] pathSegments = { "v1/environments", "query" };
    String[] pathParameters = { federatedQueryOptions.environmentId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=federatedQuery");
    if (federatedQueryOptions.loggingOptOut() != null) {
      builder.header("X-Watson-Logging-Opt-Out", federatedQueryOptions.loggingOptOut());
    }
    final JsonObject contentJson = new JsonObject();
    if (federatedQueryOptions.filter() != null) {
      contentJson.addProperty("filter", federatedQueryOptions.filter());
    }
    if (federatedQueryOptions.query() != null) {
      contentJson.addProperty("query", federatedQueryOptions.query());
    }
    if (federatedQueryOptions.naturalLanguageQuery() != null) {
      contentJson.addProperty("natural_language_query", federatedQueryOptions.naturalLanguageQuery());
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
    if (federatedQueryOptions.returnFields() != null) {
      contentJson.addProperty("return", StringUtils.join(federatedQueryOptions.returnFields(), ","));
    }
    if (federatedQueryOptions.offset() != null) {
      contentJson.addProperty("offset", federatedQueryOptions.offset());
    }
    if (federatedQueryOptions.sort() != null) {
      contentJson.addProperty("sort", StringUtils.join(federatedQueryOptions.sort(), ","));
    }
    if (federatedQueryOptions.highlight() != null) {
      contentJson.addProperty("highlight", federatedQueryOptions.highlight());
    }
    if (federatedQueryOptions.passagesFields() != null) {
      contentJson.addProperty("passages.fields", StringUtils.join(federatedQueryOptions.passagesFields(), ","));
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
    if (federatedQueryOptions.collectionIds() != null) {
      contentJson.addProperty("collection_ids", StringUtils.join(federatedQueryOptions.collectionIds(), ","));
    }
    if (federatedQueryOptions.similar() != null) {
      contentJson.addProperty("similar", federatedQueryOptions.similar());
    }
    if (federatedQueryOptions.similarDocumentIds() != null) {
      contentJson.addProperty("similar.document_ids", StringUtils.join(federatedQueryOptions.similarDocumentIds(),
          ","));
    }
    if (federatedQueryOptions.similarFields() != null) {
      contentJson.addProperty("similar.fields", StringUtils.join(federatedQueryOptions.similarFields(), ","));
    }
    if (federatedQueryOptions.bias() != null) {
      contentJson.addProperty("bias", federatedQueryOptions.bias());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(QueryResponse.class));
  }

  /**
   * Query multiple collection system notices.
   *
   * Queries for notices (errors or warnings) that might have been generated by the system. Notices are generated when
   * ingesting documents and performing relevance training. See the [Discovery service
   * documentation](https://console.bluemix.net/docs/services/discovery/using.html) for more details on the query
   * language.
   *
   * @param federatedQueryNoticesOptions the {@link FederatedQueryNoticesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link QueryNoticesResponse}
   */
  public ServiceCall<QueryNoticesResponse> federatedQueryNotices(
      FederatedQueryNoticesOptions federatedQueryNoticesOptions) {
    Validator.notNull(federatedQueryNoticesOptions, "federatedQueryNoticesOptions cannot be null");
    String[] pathSegments = { "v1/environments", "notices" };
    String[] pathParameters = { federatedQueryNoticesOptions.environmentId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=federatedQueryNotices");
    builder.query("collection_ids", RequestUtils.join(federatedQueryNoticesOptions.collectionIds(), ","));
    if (federatedQueryNoticesOptions.filter() != null) {
      builder.query("filter", federatedQueryNoticesOptions.filter());
    }
    if (federatedQueryNoticesOptions.query() != null) {
      builder.query("query", federatedQueryNoticesOptions.query());
    }
    if (federatedQueryNoticesOptions.naturalLanguageQuery() != null) {
      builder.query("natural_language_query", federatedQueryNoticesOptions.naturalLanguageQuery());
    }
    if (federatedQueryNoticesOptions.aggregation() != null) {
      builder.query("aggregation", federatedQueryNoticesOptions.aggregation());
    }
    if (federatedQueryNoticesOptions.count() != null) {
      builder.query("count", String.valueOf(federatedQueryNoticesOptions.count()));
    }
    if (federatedQueryNoticesOptions.returnFields() != null) {
      builder.query("return", RequestUtils.join(federatedQueryNoticesOptions.returnFields(), ","));
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
      builder.query("deduplicate.field", federatedQueryNoticesOptions.deduplicateField());
    }
    if (federatedQueryNoticesOptions.similar() != null) {
      builder.query("similar", String.valueOf(federatedQueryNoticesOptions.similar()));
    }
    if (federatedQueryNoticesOptions.similarDocumentIds() != null) {
      builder.query("similar.document_ids", RequestUtils.join(federatedQueryNoticesOptions.similarDocumentIds(), ","));
    }
    if (federatedQueryNoticesOptions.similarFields() != null) {
      builder.query("similar.fields", RequestUtils.join(federatedQueryNoticesOptions.similarFields(), ","));
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(QueryNoticesResponse.class));
  }

  /**
   * Long collection queries.
   *
   * Complex queries might be too long for a standard method query. By using this method, you can construct longer
   * queries. However, these queries may take longer to complete than the standard method. For details, see the
   * [Discovery service documentation](https://console.bluemix.net/docs/services/discovery/using.html).
   *
   * @param queryOptions the {@link QueryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link QueryResponse}
   */
  public ServiceCall<QueryResponse> query(QueryOptions queryOptions) {
    Validator.notNull(queryOptions, "queryOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "query" };
    String[] pathParameters = { queryOptions.environmentId(), queryOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=query");
    if (queryOptions.loggingOptOut() != null) {
      builder.header("X-Watson-Logging-Opt-Out", queryOptions.loggingOptOut());
    }
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
    if (queryOptions.returnFields() != null) {
      contentJson.addProperty("return", StringUtils.join(queryOptions.returnFields(), ","));
    }
    if (queryOptions.offset() != null) {
      contentJson.addProperty("offset", queryOptions.offset());
    }
    if (queryOptions.sort() != null) {
      contentJson.addProperty("sort", StringUtils.join(queryOptions.sort(), ","));
    }
    if (queryOptions.highlight() != null) {
      contentJson.addProperty("highlight", queryOptions.highlight());
    }
    if (queryOptions.passagesFields() != null) {
      contentJson.addProperty("passages.fields", StringUtils.join(queryOptions.passagesFields(), ","));
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
    if (queryOptions.collectionIds() != null) {
      contentJson.addProperty("collection_ids", StringUtils.join(queryOptions.collectionIds(), ","));
    }
    if (queryOptions.similar() != null) {
      contentJson.addProperty("similar", queryOptions.similar());
    }
    if (queryOptions.similarDocumentIds() != null) {
      contentJson.addProperty("similar.document_ids", StringUtils.join(queryOptions.similarDocumentIds(), ","));
    }
    if (queryOptions.similarFields() != null) {
      contentJson.addProperty("similar.fields", StringUtils.join(queryOptions.similarFields(), ","));
    }
    if (queryOptions.bias() != null) {
      contentJson.addProperty("bias", queryOptions.bias());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(QueryResponse.class));
  }

  /**
   * Knowledge Graph entity query.
   *
   * See the [Knowledge Graph documentation](https://console.bluemix.net/docs/services/discovery/building-kg.html) for
   * more details.
   *
   * @param queryEntitiesOptions the {@link QueryEntitiesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link QueryEntitiesResponse}
   */
  public ServiceCall<QueryEntitiesResponse> queryEntities(QueryEntitiesOptions queryEntitiesOptions) {
    Validator.notNull(queryEntitiesOptions, "queryEntitiesOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "query_entities" };
    String[] pathParameters = { queryEntitiesOptions.environmentId(), queryEntitiesOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=queryEntities");
    final JsonObject contentJson = new JsonObject();
    if (queryEntitiesOptions.feature() != null) {
      contentJson.addProperty("feature", queryEntitiesOptions.feature());
    }
    if (queryEntitiesOptions.entity() != null) {
      contentJson.add("entity", GsonSingleton.getGson().toJsonTree(queryEntitiesOptions.entity()));
    }
    if (queryEntitiesOptions.context() != null) {
      contentJson.add("context", GsonSingleton.getGson().toJsonTree(queryEntitiesOptions.context()));
    }
    if (queryEntitiesOptions.count() != null) {
      contentJson.addProperty("count", queryEntitiesOptions.count());
    }
    if (queryEntitiesOptions.evidenceCount() != null) {
      contentJson.addProperty("evidence_count", queryEntitiesOptions.evidenceCount());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(QueryEntitiesResponse.class));
  }

  /**
   * Query system notices.
   *
   * Queries for notices (errors or warnings) that might have been generated by the system. Notices are generated when
   * ingesting documents and performing relevance training. See the [Discovery service
   * documentation](https://console.bluemix.net/docs/services/discovery/using.html) for more details on the query
   * language.
   *
   * @param queryNoticesOptions the {@link QueryNoticesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link QueryNoticesResponse}
   */
  public ServiceCall<QueryNoticesResponse> queryNotices(QueryNoticesOptions queryNoticesOptions) {
    Validator.notNull(queryNoticesOptions, "queryNoticesOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "notices" };
    String[] pathParameters = { queryNoticesOptions.environmentId(), queryNoticesOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=queryNotices");
    if (queryNoticesOptions.filter() != null) {
      builder.query("filter", queryNoticesOptions.filter());
    }
    if (queryNoticesOptions.query() != null) {
      builder.query("query", queryNoticesOptions.query());
    }
    if (queryNoticesOptions.naturalLanguageQuery() != null) {
      builder.query("natural_language_query", queryNoticesOptions.naturalLanguageQuery());
    }
    if (queryNoticesOptions.passages() != null) {
      builder.query("passages", String.valueOf(queryNoticesOptions.passages()));
    }
    if (queryNoticesOptions.aggregation() != null) {
      builder.query("aggregation", queryNoticesOptions.aggregation());
    }
    if (queryNoticesOptions.count() != null) {
      builder.query("count", String.valueOf(queryNoticesOptions.count()));
    }
    if (queryNoticesOptions.returnFields() != null) {
      builder.query("return", RequestUtils.join(queryNoticesOptions.returnFields(), ","));
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
      builder.query("passages.fields", RequestUtils.join(queryNoticesOptions.passagesFields(), ","));
    }
    if (queryNoticesOptions.passagesCount() != null) {
      builder.query("passages.count", String.valueOf(queryNoticesOptions.passagesCount()));
    }
    if (queryNoticesOptions.passagesCharacters() != null) {
      builder.query("passages.characters", String.valueOf(queryNoticesOptions.passagesCharacters()));
    }
    if (queryNoticesOptions.deduplicateField() != null) {
      builder.query("deduplicate.field", queryNoticesOptions.deduplicateField());
    }
    if (queryNoticesOptions.similar() != null) {
      builder.query("similar", String.valueOf(queryNoticesOptions.similar()));
    }
    if (queryNoticesOptions.similarDocumentIds() != null) {
      builder.query("similar.document_ids", RequestUtils.join(queryNoticesOptions.similarDocumentIds(), ","));
    }
    if (queryNoticesOptions.similarFields() != null) {
      builder.query("similar.fields", RequestUtils.join(queryNoticesOptions.similarFields(), ","));
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(QueryNoticesResponse.class));
  }

  /**
   * Knowledge Graph relationship query.
   *
   * See the [Knowledge Graph documentation](https://console.bluemix.net/docs/services/discovery/building-kg.html) for
   * more details.
   *
   * @param queryRelationsOptions the {@link QueryRelationsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link QueryRelationsResponse}
   */
  public ServiceCall<QueryRelationsResponse> queryRelations(QueryRelationsOptions queryRelationsOptions) {
    Validator.notNull(queryRelationsOptions, "queryRelationsOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "query_relations" };
    String[] pathParameters = { queryRelationsOptions.environmentId(), queryRelationsOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=queryRelations");
    final JsonObject contentJson = new JsonObject();
    if (queryRelationsOptions.entities() != null) {
      contentJson.add("entities", GsonSingleton.getGson().toJsonTree(queryRelationsOptions.entities()));
    }
    if (queryRelationsOptions.context() != null) {
      contentJson.add("context", GsonSingleton.getGson().toJsonTree(queryRelationsOptions.context()));
    }
    if (queryRelationsOptions.sort() != null) {
      contentJson.addProperty("sort", queryRelationsOptions.sort());
    }
    if (queryRelationsOptions.filter() != null) {
      contentJson.add("filter", GsonSingleton.getGson().toJsonTree(queryRelationsOptions.filter()));
    }
    if (queryRelationsOptions.count() != null) {
      contentJson.addProperty("count", queryRelationsOptions.count());
    }
    if (queryRelationsOptions.evidenceCount() != null) {
      contentJson.addProperty("evidence_count", queryRelationsOptions.evidenceCount());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(QueryRelationsResponse.class));
  }

  /**
   * Add query to training data.
   *
   * Adds a query to the training data for this collection. The query can contain a filter and natural language query.
   *
   * @param addTrainingDataOptions the {@link AddTrainingDataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingQuery}
   */
  public ServiceCall<TrainingQuery> addTrainingData(AddTrainingDataOptions addTrainingDataOptions) {
    Validator.notNull(addTrainingDataOptions, "addTrainingDataOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "training_data" };
    String[] pathParameters = { addTrainingDataOptions.environmentId(), addTrainingDataOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=addTrainingData");
    final JsonObject contentJson = new JsonObject();
    if (addTrainingDataOptions.naturalLanguageQuery() != null) {
      contentJson.addProperty("natural_language_query", addTrainingDataOptions.naturalLanguageQuery());
    }
    if (addTrainingDataOptions.filter() != null) {
      contentJson.addProperty("filter", addTrainingDataOptions.filter());
    }
    if (addTrainingDataOptions.examples() != null) {
      contentJson.add("examples", GsonSingleton.getGson().toJsonTree(addTrainingDataOptions.examples()));
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TrainingQuery.class));
  }

  /**
   * Add example to training data query.
   *
   * Adds a example to this training data query.
   *
   * @param createTrainingExampleOptions the {@link CreateTrainingExampleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingExample}
   */
  public ServiceCall<TrainingExample> createTrainingExample(CreateTrainingExampleOptions createTrainingExampleOptions) {
    Validator.notNull(createTrainingExampleOptions, "createTrainingExampleOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "training_data", "examples" };
    String[] pathParameters = { createTrainingExampleOptions.environmentId(), createTrainingExampleOptions
        .collectionId(), createTrainingExampleOptions.queryId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=createTrainingExample");
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
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TrainingExample.class));
  }

  /**
   * Delete all training data.
   *
   * Deletes all training data from a collection.
   *
   * @param deleteAllTrainingDataOptions the {@link DeleteAllTrainingDataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteAllTrainingData(DeleteAllTrainingDataOptions deleteAllTrainingDataOptions) {
    Validator.notNull(deleteAllTrainingDataOptions, "deleteAllTrainingDataOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "training_data" };
    String[] pathParameters = { deleteAllTrainingDataOptions.environmentId(), deleteAllTrainingDataOptions
        .collectionId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=deleteAllTrainingData");
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Delete a training data query.
   *
   * Removes the training data query and all associated examples from the training data set.
   *
   * @param deleteTrainingDataOptions the {@link DeleteTrainingDataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteTrainingData(DeleteTrainingDataOptions deleteTrainingDataOptions) {
    Validator.notNull(deleteTrainingDataOptions, "deleteTrainingDataOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "training_data" };
    String[] pathParameters = { deleteTrainingDataOptions.environmentId(), deleteTrainingDataOptions.collectionId(),
        deleteTrainingDataOptions.queryId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=deleteTrainingData");
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Delete example for training data query.
   *
   * Deletes the example document with the given ID from the training data query.
   *
   * @param deleteTrainingExampleOptions the {@link DeleteTrainingExampleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteTrainingExample(DeleteTrainingExampleOptions deleteTrainingExampleOptions) {
    Validator.notNull(deleteTrainingExampleOptions, "deleteTrainingExampleOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "training_data", "examples" };
    String[] pathParameters = { deleteTrainingExampleOptions.environmentId(), deleteTrainingExampleOptions
        .collectionId(), deleteTrainingExampleOptions.queryId(), deleteTrainingExampleOptions.exampleId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=deleteTrainingExample");
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Get details about a query.
   *
   * Gets details for a specific training data query, including the query string and all examples.
   *
   * @param getTrainingDataOptions the {@link GetTrainingDataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingQuery}
   */
  public ServiceCall<TrainingQuery> getTrainingData(GetTrainingDataOptions getTrainingDataOptions) {
    Validator.notNull(getTrainingDataOptions, "getTrainingDataOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "training_data" };
    String[] pathParameters = { getTrainingDataOptions.environmentId(), getTrainingDataOptions.collectionId(),
        getTrainingDataOptions.queryId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=getTrainingData");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TrainingQuery.class));
  }

  /**
   * Get details for training data example.
   *
   * Gets the details for this training example.
   *
   * @param getTrainingExampleOptions the {@link GetTrainingExampleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingExample}
   */
  public ServiceCall<TrainingExample> getTrainingExample(GetTrainingExampleOptions getTrainingExampleOptions) {
    Validator.notNull(getTrainingExampleOptions, "getTrainingExampleOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "training_data", "examples" };
    String[] pathParameters = { getTrainingExampleOptions.environmentId(), getTrainingExampleOptions.collectionId(),
        getTrainingExampleOptions.queryId(), getTrainingExampleOptions.exampleId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=getTrainingExample");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TrainingExample.class));
  }

  /**
   * List training data.
   *
   * Lists the training data for the specified collection.
   *
   * @param listTrainingDataOptions the {@link ListTrainingDataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingDataSet}
   */
  public ServiceCall<TrainingDataSet> listTrainingData(ListTrainingDataOptions listTrainingDataOptions) {
    Validator.notNull(listTrainingDataOptions, "listTrainingDataOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "training_data" };
    String[] pathParameters = { listTrainingDataOptions.environmentId(), listTrainingDataOptions.collectionId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=listTrainingData");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TrainingDataSet.class));
  }

  /**
   * List examples for a training data query.
   *
   * List all examples for this training data query.
   *
   * @param listTrainingExamplesOptions the {@link ListTrainingExamplesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingExampleList}
   */
  public ServiceCall<TrainingExampleList> listTrainingExamples(
      ListTrainingExamplesOptions listTrainingExamplesOptions) {
    Validator.notNull(listTrainingExamplesOptions, "listTrainingExamplesOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "training_data", "examples" };
    String[] pathParameters = { listTrainingExamplesOptions.environmentId(), listTrainingExamplesOptions.collectionId(),
        listTrainingExamplesOptions.queryId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=listTrainingExamples");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TrainingExampleList.class));
  }

  /**
   * Change label or cross reference for example.
   *
   * Changes the label or cross reference query for this training data example.
   *
   * @param updateTrainingExampleOptions the {@link UpdateTrainingExampleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingExample}
   */
  public ServiceCall<TrainingExample> updateTrainingExample(UpdateTrainingExampleOptions updateTrainingExampleOptions) {
    Validator.notNull(updateTrainingExampleOptions, "updateTrainingExampleOptions cannot be null");
    String[] pathSegments = { "v1/environments", "collections", "training_data", "examples" };
    String[] pathParameters = { updateTrainingExampleOptions.environmentId(), updateTrainingExampleOptions
        .collectionId(), updateTrainingExampleOptions.queryId(), updateTrainingExampleOptions.exampleId() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=updateTrainingExample");
    final JsonObject contentJson = new JsonObject();
    if (updateTrainingExampleOptions.crossReference() != null) {
      contentJson.addProperty("cross_reference", updateTrainingExampleOptions.crossReference());
    }
    if (updateTrainingExampleOptions.relevance() != null) {
      contentJson.addProperty("relevance", updateTrainingExampleOptions.relevance());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TrainingExample.class));
  }

  /**
   * Delete labeled data.
   *
   * Deletes all data associated with a specified customer ID. The method has no effect if no data is associated with
   * the customer ID.
   *
   * You associate a customer ID with data by passing the **X-Watson-Metadata** header with a request that passes data.
   * For more information about personal data and customer IDs, see [Information
   * security](https://console.bluemix.net/docs/services/discovery/information-security.html).
   *
   * @param deleteUserDataOptions the {@link DeleteUserDataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteUserData(DeleteUserDataOptions deleteUserDataOptions) {
    Validator.notNull(deleteUserDataOptions, "deleteUserDataOptions cannot be null");
    String[] pathSegments = { "v1/user_data" };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=deleteUserData");
    builder.query("customer_id", deleteUserDataOptions.customerId());
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Create event.
   *
   * The **Events** API can be used to create log entries that are associated with specific queries. For example, you
   * can record which documents in the results set were \"clicked\" by a user and when that click occured.
   *
   * @param createEventOptions the {@link CreateEventOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link CreateEventResponse}
   */
  public ServiceCall<CreateEventResponse> createEvent(CreateEventOptions createEventOptions) {
    Validator.notNull(createEventOptions, "createEventOptions cannot be null");
    String[] pathSegments = { "v1/events" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=createEvent");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("type", createEventOptions.type());
    contentJson.add("data", GsonSingleton.getGson().toJsonTree(createEventOptions.data()));
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(CreateEventResponse.class));
  }

  /**
   * Percentage of queries with an associated event.
   *
   * The percentage of queries using the **natural_language_query** parameter that have a corresponding \"click\" event
   * over a specified time window. This metric requires having integrated event tracking in your application using the
   * **Events** API.
   *
   * @param getMetricsEventRateOptions the {@link GetMetricsEventRateOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link MetricResponse}
   */
  public ServiceCall<MetricResponse> getMetricsEventRate(GetMetricsEventRateOptions getMetricsEventRateOptions) {
    String[] pathSegments = { "v1/metrics/event_rate" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=getMetricsEventRate");
    if (getMetricsEventRateOptions != null) {
      if (getMetricsEventRateOptions.startTime() != null) {
        builder.query("start_time", String.valueOf(getMetricsEventRateOptions.startTime()));
      }
      if (getMetricsEventRateOptions.endTime() != null) {
        builder.query("end_time", String.valueOf(getMetricsEventRateOptions.endTime()));
      }
      if (getMetricsEventRateOptions.resultType() != null) {
        builder.query("result_type", getMetricsEventRateOptions.resultType());
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(MetricResponse.class));
  }

  /**
   * Percentage of queries with an associated event.
   *
   * The percentage of queries using the **natural_language_query** parameter that have a corresponding \"click\" event
   * over a specified time window. This metric requires having integrated event tracking in your application using the
   * **Events** API.
   *
   * @return a {@link ServiceCall} with a response type of {@link MetricResponse}
   */
  public ServiceCall<MetricResponse> getMetricsEventRate() {
    return getMetricsEventRate(null);
  }

  /**
   * Number of queries over time.
   *
   * Total number of queries using the **natural_language_query** parameter over a specific time window.
   *
   * @param getMetricsQueryOptions the {@link GetMetricsQueryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link MetricResponse}
   */
  public ServiceCall<MetricResponse> getMetricsQuery(GetMetricsQueryOptions getMetricsQueryOptions) {
    String[] pathSegments = { "v1/metrics/number_of_queries" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=getMetricsQuery");
    if (getMetricsQueryOptions != null) {
      if (getMetricsQueryOptions.startTime() != null) {
        builder.query("start_time", String.valueOf(getMetricsQueryOptions.startTime()));
      }
      if (getMetricsQueryOptions.endTime() != null) {
        builder.query("end_time", String.valueOf(getMetricsQueryOptions.endTime()));
      }
      if (getMetricsQueryOptions.resultType() != null) {
        builder.query("result_type", getMetricsQueryOptions.resultType());
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(MetricResponse.class));
  }

  /**
   * Number of queries over time.
   *
   * Total number of queries using the **natural_language_query** parameter over a specific time window.
   *
   * @return a {@link ServiceCall} with a response type of {@link MetricResponse}
   */
  public ServiceCall<MetricResponse> getMetricsQuery() {
    return getMetricsQuery(null);
  }

  /**
   * Number of queries with an event over time.
   *
   * Total number of queries using the **natural_language_query** parameter that have a corresponding \"click\" event
   * over a specified time window. This metric requires having integrated event tracking in your application using the
   * **Events** API.
   *
   * @param getMetricsQueryEventOptions the {@link GetMetricsQueryEventOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link MetricResponse}
   */
  public ServiceCall<MetricResponse> getMetricsQueryEvent(GetMetricsQueryEventOptions getMetricsQueryEventOptions) {
    String[] pathSegments = { "v1/metrics/number_of_queries_with_event" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=getMetricsQueryEvent");
    if (getMetricsQueryEventOptions != null) {
      if (getMetricsQueryEventOptions.startTime() != null) {
        builder.query("start_time", String.valueOf(getMetricsQueryEventOptions.startTime()));
      }
      if (getMetricsQueryEventOptions.endTime() != null) {
        builder.query("end_time", String.valueOf(getMetricsQueryEventOptions.endTime()));
      }
      if (getMetricsQueryEventOptions.resultType() != null) {
        builder.query("result_type", getMetricsQueryEventOptions.resultType());
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(MetricResponse.class));
  }

  /**
   * Number of queries with an event over time.
   *
   * Total number of queries using the **natural_language_query** parameter that have a corresponding \"click\" event
   * over a specified time window. This metric requires having integrated event tracking in your application using the
   * **Events** API.
   *
   * @return a {@link ServiceCall} with a response type of {@link MetricResponse}
   */
  public ServiceCall<MetricResponse> getMetricsQueryEvent() {
    return getMetricsQueryEvent(null);
  }

  /**
   * Number of queries with no search results over time.
   *
   * Total number of queries using the **natural_language_query** parameter that have no results returned over a
   * specified time window.
   *
   * @param getMetricsQueryNoResultsOptions the {@link GetMetricsQueryNoResultsOptions} containing the options for the
   *          call
   * @return a {@link ServiceCall} with a response type of {@link MetricResponse}
   */
  public ServiceCall<MetricResponse> getMetricsQueryNoResults(
      GetMetricsQueryNoResultsOptions getMetricsQueryNoResultsOptions) {
    String[] pathSegments = { "v1/metrics/number_of_queries_with_no_search_results" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=getMetricsQueryNoResults");
    if (getMetricsQueryNoResultsOptions != null) {
      if (getMetricsQueryNoResultsOptions.startTime() != null) {
        builder.query("start_time", String.valueOf(getMetricsQueryNoResultsOptions.startTime()));
      }
      if (getMetricsQueryNoResultsOptions.endTime() != null) {
        builder.query("end_time", String.valueOf(getMetricsQueryNoResultsOptions.endTime()));
      }
      if (getMetricsQueryNoResultsOptions.resultType() != null) {
        builder.query("result_type", getMetricsQueryNoResultsOptions.resultType());
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(MetricResponse.class));
  }

  /**
   * Number of queries with no search results over time.
   *
   * Total number of queries using the **natural_language_query** parameter that have no results returned over a
   * specified time window.
   *
   * @return a {@link ServiceCall} with a response type of {@link MetricResponse}
   */
  public ServiceCall<MetricResponse> getMetricsQueryNoResults() {
    return getMetricsQueryNoResults(null);
  }

  /**
   * Most frequent query tokens with an event.
   *
   * The most frequent query tokens parsed from the **natural_language_query** parameter and their corresponding
   * \"click\" event rate within the recording period (queries and events are stored for 30 days). A query token is an
   * individual word or unigram within the query string.
   *
   * @param getMetricsQueryTokenEventOptions the {@link GetMetricsQueryTokenEventOptions} containing the options for the
   *          call
   * @return a {@link ServiceCall} with a response type of {@link MetricTokenResponse}
   */
  public ServiceCall<MetricTokenResponse> getMetricsQueryTokenEvent(
      GetMetricsQueryTokenEventOptions getMetricsQueryTokenEventOptions) {
    String[] pathSegments = { "v1/metrics/top_query_tokens_with_event_rate" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=getMetricsQueryTokenEvent");
    if (getMetricsQueryTokenEventOptions != null) {
      if (getMetricsQueryTokenEventOptions.count() != null) {
        builder.query("count", String.valueOf(getMetricsQueryTokenEventOptions.count()));
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(MetricTokenResponse.class));
  }

  /**
   * Most frequent query tokens with an event.
   *
   * The most frequent query tokens parsed from the **natural_language_query** parameter and their corresponding
   * \"click\" event rate within the recording period (queries and events are stored for 30 days). A query token is an
   * individual word or unigram within the query string.
   *
   * @return a {@link ServiceCall} with a response type of {@link MetricTokenResponse}
   */
  public ServiceCall<MetricTokenResponse> getMetricsQueryTokenEvent() {
    return getMetricsQueryTokenEvent(null);
  }

  /**
   * Search the query and event log.
   *
   * Searches the query and event log to find query sessions that match the specified criteria. Searching the **logs**
   * endpoint uses the standard Discovery query syntax for the parameters that are supported.
   *
   * @param queryLogOptions the {@link QueryLogOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link LogQueryResponse}
   */
  public ServiceCall<LogQueryResponse> queryLog(QueryLogOptions queryLogOptions) {
    String[] pathSegments = { "v1/logs" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=queryLog");
    if (queryLogOptions != null) {
      if (queryLogOptions.filter() != null) {
        builder.query("filter", queryLogOptions.filter());
      }
      if (queryLogOptions.query() != null) {
        builder.query("query", queryLogOptions.query());
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
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(LogQueryResponse.class));
  }

  /**
   * Search the query and event log.
   *
   * Searches the query and event log to find query sessions that match the specified criteria. Searching the **logs**
   * endpoint uses the standard Discovery query syntax for the parameters that are supported.
   *
   * @return a {@link ServiceCall} with a response type of {@link LogQueryResponse}
   */
  public ServiceCall<LogQueryResponse> queryLog() {
    return queryLog(null);
  }

  /**
   * Create credentials.
   *
   * Creates a set of credentials to connect to a remote source. Created credentials are used in a configuration to
   * associate a collection with the remote source.
   *
   * **Note:** All credentials are sent over an encrypted connection and encrypted at rest.
   *
   * @param createCredentialsOptions the {@link CreateCredentialsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Credentials}
   */
  public ServiceCall<Credentials> createCredentials(CreateCredentialsOptions createCredentialsOptions) {
    Validator.notNull(createCredentialsOptions, "createCredentialsOptions cannot be null");
    String[] pathSegments = { "v1/environments", "credentials" };
    String[] pathParameters = { createCredentialsOptions.environmentId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=createCredentials");
    final JsonObject contentJson = new JsonObject();
    if (createCredentialsOptions.sourceType() != null) {
      contentJson.addProperty("source_type", createCredentialsOptions.sourceType());
    }
    if (createCredentialsOptions.credentialDetails() != null) {
      contentJson.add("credential_details", GsonSingleton.getGson().toJsonTree(createCredentialsOptions
          .credentialDetails()));
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Credentials.class));
  }

  /**
   * Delete credentials.
   *
   * Deletes a set of stored credentials from your Discovery instance.
   *
   * @param deleteCredentialsOptions the {@link DeleteCredentialsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteCredentials(DeleteCredentialsOptions deleteCredentialsOptions) {
    Validator.notNull(deleteCredentialsOptions, "deleteCredentialsOptions cannot be null");
    String[] pathSegments = { "v1/environments", "credentials" };
    String[] pathParameters = { deleteCredentialsOptions.environmentId(), deleteCredentialsOptions.credentialId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=deleteCredentials");
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * View Credentials.
   *
   * Returns details about the specified credentials.
   *
   * **Note:** Secure credential information such as a password or SSH key is never returned and must be obtained from
   * the source system.
   *
   * @param getCredentialsOptions the {@link GetCredentialsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Credentials}
   */
  public ServiceCall<Credentials> getCredentials(GetCredentialsOptions getCredentialsOptions) {
    Validator.notNull(getCredentialsOptions, "getCredentialsOptions cannot be null");
    String[] pathSegments = { "v1/environments", "credentials" };
    String[] pathParameters = { getCredentialsOptions.environmentId(), getCredentialsOptions.credentialId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=getCredentials");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Credentials.class));
  }

  /**
   * List credentials.
   *
   * List all the source credentials that have been created for this service instance.
   *
   * **Note:** All credentials are sent over an encrypted connection and encrypted at rest.
   *
   * @param listCredentialsOptions the {@link ListCredentialsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link CredentialsList}
   */
  public ServiceCall<CredentialsList> listCredentials(ListCredentialsOptions listCredentialsOptions) {
    Validator.notNull(listCredentialsOptions, "listCredentialsOptions cannot be null");
    String[] pathSegments = { "v1/environments", "credentials" };
    String[] pathParameters = { listCredentialsOptions.environmentId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=listCredentials");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(CredentialsList.class));
  }

  /**
   * Update credentials.
   *
   * Updates an existing set of source credentials.
   *
   * **Note:** All credentials are sent over an encrypted connection and encrypted at rest.
   *
   * @param updateCredentialsOptions the {@link UpdateCredentialsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Credentials}
   */
  public ServiceCall<Credentials> updateCredentials(UpdateCredentialsOptions updateCredentialsOptions) {
    Validator.notNull(updateCredentialsOptions, "updateCredentialsOptions cannot be null");
    String[] pathSegments = { "v1/environments", "credentials" };
    String[] pathParameters = { updateCredentialsOptions.environmentId(), updateCredentialsOptions.credentialId() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=discovery;service_version=v1;operation_id=updateCredentials");
    final JsonObject contentJson = new JsonObject();
    if (updateCredentialsOptions.sourceType() != null) {
      contentJson.addProperty("source_type", updateCredentialsOptions.sourceType());
    }
    if (updateCredentialsOptions.credentialDetails() != null) {
      contentJson.add("credential_details", GsonSingleton.getGson().toJsonTree(updateCredentialsOptions
          .credentialDetails()));
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Credentials.class));
  }

  /**
   * Create Gateway.
   *
   * Create a gateway configuration to use with a remotely installed gateway.
   *
   * @param createGatewayOptions the {@link CreateGatewayOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Gateway}
   */
  public ServiceCall<Gateway> createGateway(CreateGatewayOptions createGatewayOptions) {
    Validator.notNull(createGatewayOptions, "createGatewayOptions cannot be null");
    String[] pathSegments = { "v1/environments", "gateways" };
    String[] pathParameters = { createGatewayOptions.environmentId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=createGateway");
    final JsonObject contentJson = new JsonObject();
    if (createGatewayOptions.name() != null) {
      contentJson.addProperty("name", createGatewayOptions.name());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Gateway.class));
  }

  /**
   * Delete Gateway.
   *
   * Delete the specified gateway configuration.
   *
   * @param deleteGatewayOptions the {@link DeleteGatewayOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteGateway(DeleteGatewayOptions deleteGatewayOptions) {
    Validator.notNull(deleteGatewayOptions, "deleteGatewayOptions cannot be null");
    String[] pathSegments = { "v1/environments", "gateways" };
    String[] pathParameters = { deleteGatewayOptions.environmentId(), deleteGatewayOptions.gatewayId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=deleteGateway");
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * List Gateway Details.
   *
   * List information about the specified gateway.
   *
   * @param getGatewayOptions the {@link GetGatewayOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Gateway}
   */
  public ServiceCall<Gateway> getGateway(GetGatewayOptions getGatewayOptions) {
    Validator.notNull(getGatewayOptions, "getGatewayOptions cannot be null");
    String[] pathSegments = { "v1/environments", "gateways" };
    String[] pathParameters = { getGatewayOptions.environmentId(), getGatewayOptions.gatewayId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=getGateway");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Gateway.class));
  }

  /**
   * List Gateways.
   *
   * List the currently configured gateways.
   *
   * @param listGatewaysOptions the {@link ListGatewaysOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link GatewayList}
   */
  public ServiceCall<GatewayList> listGateways(ListGatewaysOptions listGatewaysOptions) {
    Validator.notNull(listGatewaysOptions, "listGatewaysOptions cannot be null");
    String[] pathSegments = { "v1/environments", "gateways" };
    String[] pathParameters = { listGatewaysOptions.environmentId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=discovery;service_version=v1;operation_id=listGateways");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(GatewayList.class));
  }

}

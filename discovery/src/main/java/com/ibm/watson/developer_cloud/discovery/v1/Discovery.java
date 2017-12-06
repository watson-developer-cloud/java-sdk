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
package com.ibm.watson.developer_cloud.discovery.v1;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import com.ibm.watson.developer_cloud.util.RequestUtils;
import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.discovery.v1.model.AddDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.AddTrainingDataOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.Collection;
import com.ibm.watson.developer_cloud.discovery.v1.model.Configuration;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateCollectionOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateTrainingExampleOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteAllTrainingDataOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteCollectionOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteTrainingDataOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteTrainingExampleOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DocumentAccepted;
import com.ibm.watson.developer_cloud.discovery.v1.model.DocumentStatus;
import com.ibm.watson.developer_cloud.discovery.v1.model.Environment;
import com.ibm.watson.developer_cloud.discovery.v1.model.FederatedQueryNoticesOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.FederatedQueryOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetCollectionOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetDocumentStatusOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetTrainingDataOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetTrainingExampleOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionFieldsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionFieldsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListConfigurationsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListConfigurationsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListEnvironmentsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListEnvironmentsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListFieldsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListTrainingDataOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListTrainingExamplesOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryEntitiesOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryEntitiesResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryNoticesOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryNoticesResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryRelationsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryRelationsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.TestConfigurationInEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.TestDocument;
import com.ibm.watson.developer_cloud.discovery.v1.model.TrainingDataSet;
import com.ibm.watson.developer_cloud.discovery.v1.model.TrainingExample;
import com.ibm.watson.developer_cloud.discovery.v1.model.TrainingExampleList;
import com.ibm.watson.developer_cloud.discovery.v1.model.TrainingQuery;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateCollectionOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateTrainingExampleOptions;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The IBM Watson Discovery Service is a cognitive search and content analytics engine that you can add to applications
 * to identify patterns, trends and actionable insights to drive better decision-making. Securely unify structured and
 * unstructured data with pre-enriched content, and use a simplified query language to eliminate the need for manual
 * filtering of results.
 *
 * @version v1
 * @see <a href="http://www.ibm.com/watson/developercloud/discovery.html">Discovery</a>
 */
public class Discovery extends WatsonService {

  private static final String SERVICE_NAME = "discovery";
  private static final String URL = "https://gateway.watsonplatform.net/discovery/api";

  private String versionDate;

  /** The Constant VERSION_DATE_2017_11_07. */
  public static final String VERSION_DATE_2017_11_07 = "2017-11-07";
  /** The Constant VERSION_DATE_2017_09_01. */
  public static final String VERSION_DATE_2017_09_01 = "2017-09-01";
  /** The Constant VERSION_DATE_2017_08_01. */
  public static final String VERSION_DATE_2017_08_01 = "2017-08-01";
  /** The Constant VERSION_DATE_2017_07_19. */
  public static final String VERSION_DATE_2017_07_19 = "2017-07-19";
  /** The Constant VERSION_DATE_2017_06_25. */
  public static final String VERSION_DATE_2017_06_25 = "2017-06-25";
  /** The Constant VERSION_DATE_2016_12_01. */
  public static final String VERSION_DATE_2016_12_01 = "2016-12-01";

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

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(),
        "'version cannot be null. Use " + VERSION_DATE_2017_11_07);

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
   * Add an environment.
   *
   * Creates a new environment. You can create only one environment per service instance. An attempt to create another
   * environment results in an error.
   *
   * @param createEnvironmentOptions the {@link CreateEnvironmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Environment}
   */
  public ServiceCall<Environment> createEnvironment(CreateEnvironmentOptions createEnvironmentOptions) {
    Validator.notNull(createEnvironmentOptions, "createEnvironmentOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post("/v1/environments");
    builder.query(VERSION, versionDate);
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
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/environments/%s", deleteEnvironmentOptions
        .environmentId()));
    builder.query(VERSION, versionDate);
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
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s", getEnvironmentOptions
        .environmentId()));
    builder.query(VERSION, versionDate);
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
    RequestBuilder builder = RequestBuilder.get("/v1/environments");
    builder.query(VERSION, versionDate);
    if (listEnvironmentsOptions != null) {
      if (listEnvironmentsOptions.name() != null) {
        builder.query("name", listEnvironmentsOptions.name());
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ListEnvironmentsResponse.class));
  }

  /**
   * List environments
   *
   * List existing environments for the service instance.
   *
   * @return a {@link ServiceCall} with a response type of {@link ListEnvironmentsResponse}
   */
  public ServiceCall<ListEnvironmentsResponse> listEnvironments() {
    return listEnvironments(null);
  }

  /**
   * List fields in specified collecitons.
   *
   * Gets a list of the unique fields (and their types) stored in the indexes of the specified collecitons.
   *
   * @param listFieldsOptions the {@link ListFieldsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ListCollectionFieldsResponse}
   */
  public ServiceCall<ListCollectionFieldsResponse> listFields(ListFieldsOptions listFieldsOptions) {
    Validator.notNull(listFieldsOptions, "listFieldsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/fields", listFieldsOptions
        .environmentId()));
    builder.query(VERSION, versionDate);
    builder.query("collection_ids", RequestUtils.join(listFieldsOptions.collectionIds(), ","));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ListCollectionFieldsResponse.class));
  }

  /**
   * Update an environment.
   *
   * Updates an environment. The environment's `name` and `description` parameters can be changed. You must specify a
   * `name` for the environment.
   *
   * @param updateEnvironmentOptions the {@link UpdateEnvironmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Environment}
   */
  public ServiceCall<Environment> updateEnvironment(UpdateEnvironmentOptions updateEnvironmentOptions) {
    Validator.notNull(updateEnvironmentOptions, "updateEnvironmentOptions cannot be null");
    RequestBuilder builder = RequestBuilder.put(String.format("/v1/environments/%s", updateEnvironmentOptions
        .environmentId()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    if (updateEnvironmentOptions.name() != null) {
      contentJson.addProperty("name", updateEnvironmentOptions.name());
    }
    if (updateEnvironmentOptions.description() != null) {
      contentJson.addProperty("description", updateEnvironmentOptions.description());
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Environment.class));
  }

  /**
   * Add configuration.
   *
   * Creates a new configuration. If the input configuration contains the `configuration_id`, `created`, or `updated`
   * properties, then they are ignored and overridden by the system, and an error is not returned so that the overridden
   * fields do not need to be removed when copying a configuration. The configuration can contain unrecognized JSON
   * fields. Any such fields are ignored and do not generate an error. This makes it easier to use newer configuration
   * files with older versions of the API and the service. It also makes it possible for the tooling to add additional
   * metadata and information to the configuration.
   *
   * @param createConfigurationOptions the {@link CreateConfigurationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Configuration}
   */
  public ServiceCall<Configuration> createConfiguration(CreateConfigurationOptions createConfigurationOptions) {
    Validator.notNull(createConfigurationOptions, "createConfigurationOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/configurations",
        createConfigurationOptions.environmentId()));
    builder.query(VERSION, versionDate);
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
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/environments/%s/configurations/%s",
        deleteConfigurationOptions.environmentId(), deleteConfigurationOptions.configurationId()));
    builder.query(VERSION, versionDate);
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
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/configurations/%s",
        getConfigurationOptions.environmentId(), getConfigurationOptions.configurationId()));
    builder.query(VERSION, versionDate);
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
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/configurations",
        listConfigurationsOptions.environmentId()));
    builder.query(VERSION, versionDate);
    if (listConfigurationsOptions.name() != null) {
      builder.query("name", listConfigurationsOptions.name());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ListConfigurationsResponse.class));
  }

  /**
   * Update a configuration.
   *
   * Replaces an existing configuration. * Completely replaces the original configuration. * The `configuration_id`,
   * `updated`, and `created` fields are accepted in the request, but they are ignored, and an error is not generated.
   * It is also acceptable for users to submit an updated configuration with none of the three properties. * Documents
   * are processed with a snapshot of the configuration as it was at the time the document was submitted to be ingested.
   * This means that already submitted documents will not see any updates made to the configuration.
   *
   * @param updateConfigurationOptions the {@link UpdateConfigurationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Configuration}
   */
  public ServiceCall<Configuration> updateConfiguration(UpdateConfigurationOptions updateConfigurationOptions) {
    Validator.notNull(updateConfigurationOptions, "updateConfigurationOptions cannot be null");
    RequestBuilder builder = RequestBuilder.put(String.format("/v1/environments/%s/configurations/%s",
        updateConfigurationOptions.environmentId(), updateConfigurationOptions.configurationId()));
    builder.query(VERSION, versionDate);
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
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/preview",
        testConfigurationInEnvironmentOptions.environmentId()));
    builder.query(VERSION, versionDate);
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
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/collections",
        createCollectionOptions.environmentId()));
    builder.query(VERSION, versionDate);
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
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/environments/%s/collections/%s",
        deleteCollectionOptions.environmentId(), deleteCollectionOptions.collectionId()));
    builder.query(VERSION, versionDate);
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
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections/%s", getCollectionOptions
        .environmentId(), getCollectionOptions.collectionId()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Collection.class));
  }

  /**
   * List unique fields.
   *
   * Gets a list of the unique fields (and their types) stored in the index.
   *
   * @param listCollectionFieldsOptions the {@link ListCollectionFieldsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ListCollectionFieldsResponse}
   */
  public ServiceCall<ListCollectionFieldsResponse> listCollectionFields(
      ListCollectionFieldsOptions listCollectionFieldsOptions) {
    Validator.notNull(listCollectionFieldsOptions, "listCollectionFieldsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections/%s/fields",
        listCollectionFieldsOptions.environmentId(), listCollectionFieldsOptions.collectionId()));
    builder.query(VERSION, versionDate);
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
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections", listCollectionsOptions
        .environmentId()));
    builder.query(VERSION, versionDate);
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
    RequestBuilder builder = RequestBuilder.put(String.format("/v1/environments/%s/collections/%s",
        updateCollectionOptions.environmentId(), updateCollectionOptions.collectionId()));
    builder.query(VERSION, versionDate);
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
   * Add a document.
   *
   * Add a document to a collection with optional metadata. * The `version` query parameter is still required. * Returns
   * immediately after the system has accepted the document for processing. * The user must provide document content,
   * metadata, or both. If the request is missing both document content and metadata, it is rejected. * The user can set
   * the `Content-Type` parameter on the `file` part to indicate the media type of the document. If the `Content-Type`
   * parameter is missing or is one of the generic media types (for example, `application/octet-stream`), then the
   * service attempts to automatically detect the document's media type. * The following field names are reserved and
   * will be filtered out if present after normalization: `id`, `score`, `highlight`, and any field with the prefix of:
   * `_`, `+`, or `-` * Fields with empty name values after normalization are filtered out before indexing. * Fields
   * containing the following characters after normalization are filtered out before indexing: `#` and `,`
   *
   * @param addDocumentOptions the {@link AddDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link DocumentAccepted}
   */
  public ServiceCall<DocumentAccepted> addDocument(AddDocumentOptions addDocumentOptions) {
    Validator.notNull(addDocumentOptions, "addDocumentOptions cannot be null");
    Validator.isTrue((addDocumentOptions.file() != null) || (addDocumentOptions.metadata() != null),
        "At least one of file or metadata must be supplied.");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/collections/%s/documents",
        addDocumentOptions.environmentId(), addDocumentOptions.collectionId()));
    builder.query(VERSION, versionDate);
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
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/environments/%s/collections/%s/documents/%s",
        deleteDocumentOptions.environmentId(), deleteDocumentOptions.collectionId(), deleteDocumentOptions
            .documentId()));
    builder.query(VERSION, versionDate);
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
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections/%s/documents/%s",
        getDocumentStatusOptions.environmentId(), getDocumentStatusOptions.collectionId(), getDocumentStatusOptions
            .documentId()));
    builder.query(VERSION, versionDate);
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
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/collections/%s/documents/%s",
        updateDocumentOptions.environmentId(), updateDocumentOptions.collectionId(), updateDocumentOptions
            .documentId()));
    builder.query(VERSION, versionDate);
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
   * Query documents in multiple collections.
   *
   * See the [Discovery service documentation](https://console.bluemix.net/docs/services/discovery/using.html) for more
   * details.
   *
   * @param federatedQueryOptions the {@link FederatedQueryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link QueryResponse}
   */
  public ServiceCall<QueryResponse> federatedQuery(FederatedQueryOptions federatedQueryOptions) {
    Validator.notNull(federatedQueryOptions, "federatedQueryOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/query", federatedQueryOptions
        .environmentId()));
    builder.query(VERSION, versionDate);
    builder.query("collection_ids", RequestUtils.join(federatedQueryOptions.collectionIds(), ","));
    if (federatedQueryOptions.filter() != null) {
      builder.query("filter", federatedQueryOptions.filter());
    }
    if (federatedQueryOptions.query() != null) {
      builder.query("query", federatedQueryOptions.query());
    }
    if (federatedQueryOptions.naturalLanguageQuery() != null) {
      builder.query("natural_language_query", federatedQueryOptions.naturalLanguageQuery());
    }
    if (federatedQueryOptions.aggregation() != null) {
      builder.query("aggregation", federatedQueryOptions.aggregation());
    }
    if (federatedQueryOptions.count() != null) {
      builder.query("count", String.valueOf(federatedQueryOptions.count()));
    }
    if (federatedQueryOptions.returnFields() != null) {
      builder.query("return_fields", RequestUtils.join(federatedQueryOptions.returnFields(), ","));
    }
    if (federatedQueryOptions.offset() != null) {
      builder.query("offset", String.valueOf(federatedQueryOptions.offset()));
    }
    if (federatedQueryOptions.sort() != null) {
      builder.query("sort", RequestUtils.join(federatedQueryOptions.sort(), ","));
    }
    if (federatedQueryOptions.highlight() != null) {
      builder.query("highlight", String.valueOf(federatedQueryOptions.highlight()));
    }
    if (federatedQueryOptions.deduplicate() != null) {
      builder.query("deduplicate", String.valueOf(federatedQueryOptions.deduplicate()));
    }
    if (federatedQueryOptions.deduplicateField() != null) {
      builder.query("deduplicate.field", federatedQueryOptions.deduplicateField());
    }
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
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/notices",
        federatedQueryNoticesOptions.environmentId()));
    builder.query(VERSION, versionDate);
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
      builder.query("return_fields", RequestUtils.join(federatedQueryNoticesOptions.returnFields(), ","));
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
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(QueryNoticesResponse.class));
  }

  /**
   * Query documents.
   *
   * See the [Discovery service documentation](https://console.bluemix.net/docs/services/discovery/using.html) for more
   * details.
   *
   * @param queryOptions the {@link QueryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link QueryResponse}
   */
  public ServiceCall<QueryResponse> query(QueryOptions queryOptions) {
    Validator.notNull(queryOptions, "queryOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections/%s/query", queryOptions
        .environmentId(), queryOptions.collectionId()));
    builder.query(VERSION, versionDate);
    if (queryOptions.filter() != null) {
      builder.query("filter", queryOptions.filter());
    }
    if (queryOptions.query() != null) {
      builder.query("query", queryOptions.query());
    }
    if (queryOptions.naturalLanguageQuery() != null) {
      builder.query("natural_language_query", queryOptions.naturalLanguageQuery());
    }
    if (queryOptions.passages() != null) {
      builder.query("passages", String.valueOf(queryOptions.passages()));
    }
    if (queryOptions.aggregation() != null) {
      builder.query("aggregation", queryOptions.aggregation());
    }
    if (queryOptions.count() != null) {
      builder.query("count", String.valueOf(queryOptions.count()));
    }
    if (queryOptions.returnFields() != null) {
      builder.query("return", RequestUtils.join(queryOptions.returnFields(), ","));
    }
    if (queryOptions.offset() != null) {
      builder.query("offset", String.valueOf(queryOptions.offset()));
    }
    if (queryOptions.sort() != null) {
      builder.query("sort", RequestUtils.join(queryOptions.sort(), ","));
    }
    if (queryOptions.highlight() != null) {
      builder.query("highlight", String.valueOf(queryOptions.highlight()));
    }
    if (queryOptions.passagesFields() != null) {
      builder.query("passages.fields", RequestUtils.join(queryOptions.passagesFields(), ","));
    }
    if (queryOptions.passagesCount() != null) {
      builder.query("passages.count", String.valueOf(queryOptions.passagesCount()));
    }
    if (queryOptions.passagesCharacters() != null) {
      builder.query("passages.characters", String.valueOf(queryOptions.passagesCharacters()));
    }
    if (queryOptions.deduplicate() != null) {
      builder.query("deduplicate", String.valueOf(queryOptions.deduplicate()));
    }
    if (queryOptions.deduplicateField() != null) {
      builder.query("deduplicate.field", queryOptions.deduplicateField());
    }
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
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/collections/%s/query_entities",
        queryEntitiesOptions.environmentId(), queryEntitiesOptions.collectionId()));
    builder.query(VERSION, versionDate);
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
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections/%s/notices",
        queryNoticesOptions.environmentId(), queryNoticesOptions.collectionId()));
    builder.query(VERSION, versionDate);
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
      builder.query("return_fields", RequestUtils.join(queryNoticesOptions.returnFields(), ","));
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
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/collections/%s/query_relations",
        queryRelationsOptions.environmentId(), queryRelationsOptions.collectionId()));
    builder.query(VERSION, versionDate);
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
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(QueryRelationsResponse.class));
  }

  /**
   * Adds a query to the training data for this collection. The query can contain a filter and natural language query.
   *
   * @param addTrainingDataOptions the {@link AddTrainingDataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingQuery}
   */
  public ServiceCall<TrainingQuery> addTrainingData(AddTrainingDataOptions addTrainingDataOptions) {
    Validator.notNull(addTrainingDataOptions, "addTrainingDataOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/collections/%s/training_data",
        addTrainingDataOptions.environmentId(), addTrainingDataOptions.collectionId()));
    builder.query(VERSION, versionDate);
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
   * Adds a new example to this training data query.
   *
   * @param createTrainingExampleOptions the {@link CreateTrainingExampleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingExample}
   */
  public ServiceCall<TrainingExample> createTrainingExample(CreateTrainingExampleOptions createTrainingExampleOptions) {
    Validator.notNull(createTrainingExampleOptions, "createTrainingExampleOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format(
        "/v1/environments/%s/collections/%s/training_data/%s/examples", createTrainingExampleOptions.environmentId(),
        createTrainingExampleOptions.collectionId(), createTrainingExampleOptions.queryId()));
    builder.query(VERSION, versionDate);
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
   * Clears all training data for this collection.
   *
   * @param deleteAllTrainingDataOptions the {@link DeleteAllTrainingDataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteAllTrainingData(DeleteAllTrainingDataOptions deleteAllTrainingDataOptions) {
    Validator.notNull(deleteAllTrainingDataOptions, "deleteAllTrainingDataOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/environments/%s/collections/%s/training_data",
        deleteAllTrainingDataOptions.environmentId(), deleteAllTrainingDataOptions.collectionId()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Removes the training data and all associated examples from the training data set.
   *
   * @param deleteTrainingDataOptions the {@link DeleteTrainingDataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteTrainingData(DeleteTrainingDataOptions deleteTrainingDataOptions) {
    Validator.notNull(deleteTrainingDataOptions, "deleteTrainingDataOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/environments/%s/collections/%s/training_data/%s",
        deleteTrainingDataOptions.environmentId(), deleteTrainingDataOptions.collectionId(), deleteTrainingDataOptions
            .queryId()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Removes the example with the given ID for the training data query.
   *
   * @param deleteTrainingExampleOptions the {@link DeleteTrainingExampleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteTrainingExample(DeleteTrainingExampleOptions deleteTrainingExampleOptions) {
    Validator.notNull(deleteTrainingExampleOptions, "deleteTrainingExampleOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format(
        "/v1/environments/%s/collections/%s/training_data/%s/examples/%s", deleteTrainingExampleOptions.environmentId(),
        deleteTrainingExampleOptions.collectionId(), deleteTrainingExampleOptions.queryId(),
        deleteTrainingExampleOptions.exampleId()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Shows details for a specific training data query, including the query string and all examples.
   *
   * @param getTrainingDataOptions the {@link GetTrainingDataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingQuery}
   */
  public ServiceCall<TrainingQuery> getTrainingData(GetTrainingDataOptions getTrainingDataOptions) {
    Validator.notNull(getTrainingDataOptions, "getTrainingDataOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections/%s/training_data/%s",
        getTrainingDataOptions.environmentId(), getTrainingDataOptions.collectionId(), getTrainingDataOptions
            .queryId()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TrainingQuery.class));
  }

  /**
   * Gets the details for this training example.
   *
   * @param getTrainingExampleOptions the {@link GetTrainingExampleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingExample}
   */
  public ServiceCall<TrainingExample> getTrainingExample(GetTrainingExampleOptions getTrainingExampleOptions) {
    Validator.notNull(getTrainingExampleOptions, "getTrainingExampleOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format(
        "/v1/environments/%s/collections/%s/training_data/%s/examples/%s", getTrainingExampleOptions.environmentId(),
        getTrainingExampleOptions.collectionId(), getTrainingExampleOptions.queryId(), getTrainingExampleOptions
            .exampleId()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TrainingExample.class));
  }

  /**
   * Lists the training data for this collection.
   *
   * @param listTrainingDataOptions the {@link ListTrainingDataOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingDataSet}
   */
  public ServiceCall<TrainingDataSet> listTrainingData(ListTrainingDataOptions listTrainingDataOptions) {
    Validator.notNull(listTrainingDataOptions, "listTrainingDataOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections/%s/training_data",
        listTrainingDataOptions.environmentId(), listTrainingDataOptions.collectionId()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TrainingDataSet.class));
  }

  /**
   * List all examples for this training data query.
   *
   * @param listTrainingExamplesOptions the {@link ListTrainingExamplesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingExampleList}
   */
  public ServiceCall<TrainingExampleList> listTrainingExamples(
      ListTrainingExamplesOptions listTrainingExamplesOptions) {
    Validator.notNull(listTrainingExamplesOptions, "listTrainingExamplesOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format(
        "/v1/environments/%s/collections/%s/training_data/%s/examples", listTrainingExamplesOptions.environmentId(),
        listTrainingExamplesOptions.collectionId(), listTrainingExamplesOptions.queryId()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TrainingExampleList.class));
  }

  /**
   * Changes the label or cross reference query for this training example.
   *
   * @param updateTrainingExampleOptions the {@link UpdateTrainingExampleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TrainingExample}
   */
  public ServiceCall<TrainingExample> updateTrainingExample(UpdateTrainingExampleOptions updateTrainingExampleOptions) {
    Validator.notNull(updateTrainingExampleOptions, "updateTrainingExampleOptions cannot be null");
    RequestBuilder builder = RequestBuilder.put(String.format(
        "/v1/environments/%s/collections/%s/training_data/%s/examples/%s", updateTrainingExampleOptions.environmentId(),
        updateTrainingExampleOptions.collectionId(), updateTrainingExampleOptions.queryId(),
        updateTrainingExampleOptions.exampleId()));
    builder.query(VERSION, versionDate);
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

}

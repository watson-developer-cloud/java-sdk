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

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.discovery.v1.model.AddDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.Collection;
import com.ibm.watson.developer_cloud.discovery.v1.model.Configuration;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateCollectionOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteCollectionOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteCollectionResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DocumentAccepted;
import com.ibm.watson.developer_cloud.discovery.v1.model.DocumentStatus;
import com.ibm.watson.developer_cloud.discovery.v1.model.Environment;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetCollectionOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionFieldsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionFieldsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListCollectionsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListConfigurationsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListConfigurationsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListEnvironmentsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListEnvironmentsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.NoticeQueryResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryNoticesOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.TestConfigurationInEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.TestDocument;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateCollectionOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateEnvironmentOptions;
import com.ibm.watson.developer_cloud.http.InputStreamRequestBody;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * The IBM Watson&trade; Discovery Service is a cognitive search and content analytics engine that you can add to
 * applications to identify patterns, trends and actionable insights to drive better decision-making. Securely unify
 * structured and unstructured data with pre-enriched content, and use a simplified query language to eliminate the need
 * for manual filtering of results.
 *
 * @version v1
 * @see <a href="http://www.ibm.com/watson/developercloud/discovery.html">Discovery</a>
 */
public class Discovery extends WatsonService {

  private static final String SERVICE_NAME = "discovery";
  private static final String URL = "https://gateway.watsonplatform.net/discovery/api";

  private String versionDate;

  /** The Constant VERSION_DATE_2016_12_01. */
  public static final String VERSION_DATE_2016_12_01 = "2016-12-01";

  /**
   * Instantiates a new `Discovery`.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *                    calls from failing when the service introduces breaking changes.
   */
  public Discovery(String versionDate) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(),
        "'version cannot be null. Use " + VERSION_DATE_2016_12_01);

    this.versionDate = versionDate;
  }

  /**
   * Instantiates a new `Discovery` with username and password.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *                    calls from failing when the service introduces breaking changes.
   * @param username    the username
   * @param password    the password
   */
  public Discovery(String versionDate, String username, String password) {
    this(versionDate);
    setUsernameAndPassword(username, password);
  }

  /**
   * Create a collection.
   *
   * @param createCollectionOptions the {@link CreateCollectionOptions} containing the options for the call
   * @return the {@link Collection} with the response
   */
  public ServiceCall<Collection> createCollection(CreateCollectionOptions createCollectionOptions) {
    Validator.notNull(createCollectionOptions, "createCollectionOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/collections",
        createCollectionOptions.environmentId()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    if (createCollectionOptions.name() != null) {
      contentJson.addProperty("name", createCollectionOptions.name());
    }
    if (createCollectionOptions.description() != null) {
      contentJson.addProperty("description", createCollectionOptions.description());
    }
    if (createCollectionOptions.configurationId() != null) {
      contentJson.addProperty("configuration_id", createCollectionOptions.configurationId());
    }
    builder.bodyJson(contentJson);

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Collection.class));
  }

  /**
   * Delete a collection.
   *
   * @param deleteCollectionOptions the {@link DeleteCollectionOptions} containing the options for the call
   * @return the {@link DeleteCollectionResponse} with the response
   */
  public ServiceCall<DeleteCollectionResponse> deleteCollection(DeleteCollectionOptions deleteCollectionOptions) {
    Validator.notNull(deleteCollectionOptions, "deleteCollectionOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/environments/%s/collections/%s",
        deleteCollectionOptions.environmentId(), deleteCollectionOptions.collectionId()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DeleteCollectionResponse.class));
  }

  /**
   * Get collection details.
   *
   * @param getCollectionOptions the {@link GetCollectionOptions} containing the options for the call
   * @return the {@link Collection} with the response
   */
  public ServiceCall<Collection> getCollection(GetCollectionOptions getCollectionOptions) {
    Validator.notNull(getCollectionOptions, "getCollectionOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections/%s",
        getCollectionOptions.environmentId(), getCollectionOptions.collectionId()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Collection.class));
  }

  /**
   * List unique fields.
   *
   * Gets a list of the the unique fields (and their types) stored in the index.
   *
   * @param listCollectionFieldsOptions the {@link ListCollectionFieldsOptions} containing the options for the call
   * @return the {@link ListCollectionFieldsResponse} with the response
   */
  public ServiceCall<ListCollectionFieldsResponse> listCollectionFields(ListCollectionFieldsOptions
                                                                            listCollectionFieldsOptions) {
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
   * @return the {@link ListCollectionsResponse} with the response
   */
  public ServiceCall<ListCollectionsResponse> listCollections(ListCollectionsOptions listCollectionsOptions) {
    Validator.notNull(listCollectionsOptions, "listCollectionsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections",
        listCollectionsOptions.environmentId()));
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
   * @return the {@link Collection} with the response
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
   * Add configuration.
   *
   * Creates a new configuration.  If the input configuration contains the `configuration_id`, `created`, or
   * `updated` properties, then they are ignored and overridden by the system, and an error is not returned so that
   * the overridden fields do not need to be removed when copying a configuration.  The configuration can contain
   * unrecognized JSON fields. Any such fields are ignored and do not generate an error. This makes it easier to use
   * newer configuration files with older versions of the API and the service. It also makes it possible for the
   * tooling to add additional metadata and information to the configuration.
   *
   * @param createConfigurationOptions the {@link CreateConfigurationOptions} containing the options for the call
   * @return the {@link Configuration} with the response
   */
  public ServiceCall<Configuration> createConfiguration(CreateConfigurationOptions createConfigurationOptions) {
    Validator.notNull(createConfigurationOptions, "createConfigurationOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/configurations",
        createConfigurationOptions.environmentId()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    if (createConfigurationOptions.conversions() != null) {
      contentJson.add("conversions", GsonSingleton.getGson().toJsonTree(createConfigurationOptions.conversions()));
    }
    if (createConfigurationOptions.name() != null) {
      contentJson.addProperty("name", createConfigurationOptions.name());
    }
    if (createConfigurationOptions.description() != null) {
      contentJson.addProperty("description", createConfigurationOptions.description());
    }
    if (createConfigurationOptions.normalizations() != null) {
      contentJson.add("normalizations", GsonSingleton.getGson().toJsonTree(createConfigurationOptions.normalizations(
          )));
    }
    if (createConfigurationOptions.enrichments() != null) {
      contentJson.add("enrichments", GsonSingleton.getGson().toJsonTree(createConfigurationOptions.enrichments()));
    }
    builder.bodyJson(contentJson);

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Configuration.class));
  }

  /**
   * Delete a configuration.
   *
   * The deletion is performed unconditionally. A configuration deletion request succeeds even if the configuration
   * is referenced by a collection or document ingestion. However, documents that have already been submitted for
   * processing continue to use the deleted configuration. Documents are always processed with a snapshot of the
   * configuration as it existed at the time the document was submitted.
   *
   * @param deleteConfigurationOptions the {@link DeleteConfigurationOptions} containing the options for the call
   * @return the {@link DeleteConfigurationResponse} with the response
   */
  public ServiceCall<DeleteConfigurationResponse> deleteConfiguration(DeleteConfigurationOptions
                                                                          deleteConfigurationOptions) {
    Validator.notNull(deleteConfigurationOptions, "deleteConfigurationOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/environments/%s/configurations/%s",
        deleteConfigurationOptions.environmentId(), deleteConfigurationOptions.configurationId()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DeleteConfigurationResponse.class));
  }

  /**
   * Get configuration details.
   *
   * @param getConfigurationOptions the {@link GetConfigurationOptions} containing the options for the call
   * @return the {@link Configuration} with the response
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
   * @return the {@link ListConfigurationsResponse} with the response
   */
  public ServiceCall<ListConfigurationsResponse> listConfigurations(ListConfigurationsOptions
                                                                        listConfigurationsOptions) {
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
   * Replaces an existing configuration.   * Completely replaces the original configuration.   * The
   * `configuration_id`, `updated`, and `created` fields are accepted in the request, but they are ignored, and an
   * error is not generated. It is also acceptable for users to submit an updated configuration with none of the
   * three properties.   * Documents are processed with a snapshot of the configuration as it was at the time the
   * document was submitted to be ingested. This means that already submitted documents will not see any updates made
   * to the configuration.
   *
   * @param updateConfigurationOptions the {@link UpdateConfigurationOptions} containing the options for the call
   * @return the {@link Configuration} with the response
   */
  public ServiceCall<Configuration> updateConfiguration(UpdateConfigurationOptions updateConfigurationOptions) {
    Validator.notNull(updateConfigurationOptions, "updateConfigurationOptions cannot be null");
    RequestBuilder builder = RequestBuilder.put(String.format("/v1/environments/%s/configurations/%s",
        updateConfigurationOptions.environmentId(), updateConfigurationOptions.configurationId()));
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    if (updateConfigurationOptions.conversions() != null) {
      contentJson.add("conversions", GsonSingleton.getGson().toJsonTree(updateConfigurationOptions.conversions()));
    }
    if (updateConfigurationOptions.name() != null) {
      contentJson.addProperty("name", updateConfigurationOptions.name());
    }
    if (updateConfigurationOptions.description() != null) {
      contentJson.addProperty("description", updateConfigurationOptions.description());
    }
    if (updateConfigurationOptions.normalizations() != null) {
      contentJson.add("normalizations", GsonSingleton.getGson().toJsonTree(updateConfigurationOptions.normalizations(
          )));
    }
    if (updateConfigurationOptions.enrichments() != null) {
      contentJson.add("enrichments", GsonSingleton.getGson().toJsonTree(updateConfigurationOptions.enrichments()));
    }
    builder.bodyJson(contentJson);

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Configuration.class));
  }

  /**
   * Add a document.
   *
   * Add a document to a collection with optional metadata and optional configuration.   Set the `Content-Type`
   * header on the request to indicate the media type of the document. If the `Content-Type` header is missing or is
   * one of the generic media types (for example,  `application/octet-stream`), then the service attempts to
   * automatically detect the document's media type.       * The configuration to use to process the document can be
   * provided by using the `configuration_id` query parameter.       * The `version` query parameter is still
   * required.    * Returns immediately after the system has accepted the document for processing.    * The user must
   * provide document content, metadata, or both. If the request is missing both document content and metadata, it is
   * rejected.       * The user can set the `Content-Type` parameter on the `file` part to indicate the media type of
   * the document. If the `Content-Type` parameter is missing or is one of the generic media types (for example,
   * `application/octet-stream`), then the service attempts to automatically detect the document's media type.
   *
   * @param addDocumentOptions the {@link AddDocumentOptions} containing the options for the call
   * @return the {@link DocumentAccepted} with the response
   */
  public ServiceCall<DocumentAccepted> addDocument(AddDocumentOptions addDocumentOptions) {
    Validator.notNull(addDocumentOptions, "addDocumentOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/collections/%s/documents",
        addDocumentOptions.environmentId(), addDocumentOptions.collectionId()));
    builder.query(VERSION, versionDate);
    if (addDocumentOptions.configurationId() != null) {
      builder.query("configuration_id", addDocumentOptions.configurationId());
    }

    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (addDocumentOptions.file() != null) {
      MediaType mediaType = null;
      if (addDocumentOptions.fileMediaType() != null) {
        mediaType = MediaType.parse(addDocumentOptions.fileMediaType());
      }
      RequestBody body = InputStreamRequestBody.create(mediaType, addDocumentOptions.file());
      multipartBuilder.addFormDataPart("file", "filename", body);
    }
    if (addDocumentOptions.metadata() != null) {
      multipartBuilder.addFormDataPart("metadata", addDocumentOptions.metadata());
    }
    if (addDocumentOptions.configuration() != null) {
      multipartBuilder.addFormDataPart("configuration", addDocumentOptions.configuration());
    }
    builder.body(multipartBuilder.build());

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DocumentAccepted.class));
  }

  /**
   * Delete a document.
   *
   * If the given document id is invalid, or if the document is not found, then the a success response is returned
   * (HTTP status code `200`) with the status set to 'deleted'.
   *
   * @param deleteDocumentOptions the {@link DeleteDocumentOptions} containing the options for the call
   * @return the {@link DeleteDocumentResponse} with the response
   */
  public ServiceCall<DeleteDocumentResponse> deleteDocument(DeleteDocumentOptions deleteDocumentOptions) {
    Validator.notNull(deleteDocumentOptions, "deleteDocumentOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/environments/%s/collections/%s/documents/%s",
        deleteDocumentOptions.environmentId(), deleteDocumentOptions.collectionId(), deleteDocumentOptions.documentId(
            )));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DeleteDocumentResponse.class));
  }

  /**
   * Get document details.
   *
   * Fetch status details about a submitted document. **Note:** this operation does not return the document itself.
   * Instead, it returns only the document's processing status and any notices (warnings or errors) that were
   * generated when the document was ingested. Use the query API to retrieve the actual document content.
   *
   * @param getDocumentOptions the {@link GetDocumentOptions} containing the options for the call
   * @return the {@link DocumentStatus} with the response
   */
  public ServiceCall<DocumentStatus> getDocument(GetDocumentOptions getDocumentOptions) {
    Validator.notNull(getDocumentOptions, "getDocumentOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections/%s/documents/%s",
        getDocumentOptions.environmentId(), getDocumentOptions.collectionId(), getDocumentOptions.documentId()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DocumentStatus.class));
  }

  /**
   * Update a document.
   *
   * Replace an existing document. Starts ingesting a document with optional metadata and optional configurations.
   *
   * @param updateDocumentOptions the {@link UpdateDocumentOptions} containing the options for the call
   * @return the {@link DocumentAccepted} with the response
   */
  public ServiceCall<DocumentAccepted> updateDocument(UpdateDocumentOptions updateDocumentOptions) {
    Validator.notNull(updateDocumentOptions, "updateDocumentOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/collections/%s/documents/%s",
        updateDocumentOptions.environmentId(), updateDocumentOptions.collectionId(), updateDocumentOptions.documentId(
            )));
    builder.query(VERSION, versionDate);
    if (updateDocumentOptions.configurationId() != null) {
      builder.query("configuration_id", updateDocumentOptions.configurationId());
    }

    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (updateDocumentOptions.file() != null) {
      MediaType mediaType = null;
      if (updateDocumentOptions.fileMediaType() != null) {
        mediaType = MediaType.parse(updateDocumentOptions.fileMediaType());
      }
      RequestBody body = InputStreamRequestBody.create(mediaType, updateDocumentOptions.file());
      multipartBuilder.addFormDataPart("file", "filename", body);
    }
    if (updateDocumentOptions.metadata() != null) {
      multipartBuilder.addFormDataPart("metadata", updateDocumentOptions.metadata());
    }
    if (updateDocumentOptions.configuration() != null) {
      multipartBuilder.addFormDataPart("configuration", updateDocumentOptions.configuration());
    }
    builder.body(multipartBuilder.build());

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DocumentAccepted.class));
  }

  /**
   * Add an environment.
   *
   * Creates a new environment.  You can create only one environment per service instance. An attempt to create
   * another environment will result in an error.  The size of the new environment can be controlled by specifying
   * the `size` parameter. Use the table below to map size values to the size of the environment which is created:  |
   * Size | Disk (GB)  | RAM (GB) | Included Standard Enrichments | Notes | | ---:  | -----------: | -----------: |
   * --------------------------------------------: | -------- | | 0  | 2              | 1              | n/a
   * (effectively unlimited)   | Free Plan only, no HA (single node in elastic.co)| | 1     | 48             | 2
   * | 4,000    | | | 2     | 192            | 8              | 16,000   | | | 3     | 384            | 16
   * | 32,000   | |  **Note:** you cannot set the size property when using the free plan.
   *
   * @param createEnvironmentOptions the {@link CreateEnvironmentOptions} containing the options for the call
   * @return the {@link Environment} with the response
   */
  public ServiceCall<Environment> createEnvironment(CreateEnvironmentOptions createEnvironmentOptions) {
    RequestBuilder builder = RequestBuilder.post("/v1/environments");
    builder.query(VERSION, versionDate);
    final JsonObject contentJson = new JsonObject();
    if (createEnvironmentOptions.size() != null) {
      contentJson.addProperty("size", createEnvironmentOptions.size());
    }
    if (createEnvironmentOptions.name() != null) {
      contentJson.addProperty("name", createEnvironmentOptions.name());
    }
    if (createEnvironmentOptions.description() != null) {
      contentJson.addProperty("description", createEnvironmentOptions.description());
    }
    builder.bodyJson(contentJson);

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Environment.class));
  }

  /**
   * Delete environment.
   *
   * @param deleteEnvironmentOptions the {@link DeleteEnvironmentOptions} containing the options for the call
   * @return the {@link DeleteEnvironmentResponse} with the response
   */
  public ServiceCall<DeleteEnvironmentResponse> deleteEnvironment(DeleteEnvironmentOptions deleteEnvironmentOptions) {
    Validator.notNull(deleteEnvironmentOptions, "deleteEnvironmentOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/environments/%s", deleteEnvironmentOptions
        .environmentId()));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DeleteEnvironmentResponse.class));
  }

  /**
   * Get environment info.
   *
   * @param getEnvironmentOptions the {@link GetEnvironmentOptions} containing the options for the call
   * @return the {@link Environment} with the response
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
   * @return the {@link ListEnvironmentsResponse} with the response
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
   * Update an environment.
   *
   * Updates an environment. The environment's `name` and  `description` parameters can be changed. You can increase
   * the value of the `size` parameter. If you need to decrease an environment's size, contact IBM Support.
   *
   * @param updateEnvironmentOptions the {@link UpdateEnvironmentOptions} containing the options for the call
   * @return the {@link Environment} with the response
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
   * Query documents.
   *
   * See the [Discovery service documentation](https://www.ibm.com/watson/developercloud/doc/discovery/using.html)
   * for more details.
   *
   * @param queryOptions the {@link QueryOptions} containing the options for the call
   * @return the {@link QueryResponse} with the response
   */
  public ServiceCall<QueryResponse> query(QueryOptions queryOptions) {
    Validator.notNull(queryOptions, "queryOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections/%s/query",
        queryOptions.environmentId(), queryOptions.collectionId()));
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
      builder.query("return", queryOptions.returnFields());
    }
    if (queryOptions.offset() != null) {
      builder.query("offset", String.valueOf(queryOptions.offset()));
    }
    if (queryOptions.sort() != null) {
      builder.query("sort", queryOptions.sort());
    }

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(QueryResponse.class));
  }

  /**
   * Queries for notices (errors or warnings) that may have been generated by the system. Currently, notices are only
   * generated when ingesting documents. See the [Discovery service documentation](https://www.ibm
   * .com/watson/developercloud/doc/discovery/using.html) for more details on the query language.
   *
   * @param queryNoticesOptions the {@link QueryNoticesOptions} containing the options for the call
   * @return the {@link NoticeQueryResponse} with the response
   */
  public ServiceCall<NoticeQueryResponse> queryNotices(QueryNoticesOptions queryNoticesOptions) {
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
      builder.query("return", queryNoticesOptions.returnFields());
    }
    if (queryNoticesOptions.offset() != null) {
      builder.query("offset", String.valueOf(queryNoticesOptions.offset()));
    }
    if (queryNoticesOptions.sort() != null) {
      builder.query("sort", queryNoticesOptions.sort());
    }

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(NoticeQueryResponse.class));
  }

  /**
   * Test configuration.
   *
   * Runs a sample document through the default or your configuration and returns diagnostic information designed to
   * help you understand how the document was processed. The document is not added to the index.
   *
   * @param testConfigurationInEnvironmentOptions the {@link TestConfigurationInEnvironmentOptions} containing the
   *                                              options for the call
   * @return the {@link TestDocument} with the response
   */
  public ServiceCall<TestDocument> testConfigurationInEnvironment(TestConfigurationInEnvironmentOptions
                                                                      testConfigurationInEnvironmentOptions) {
    Validator.notNull(testConfigurationInEnvironmentOptions, "testConfigurationInEnvironmentOptions cannot be null");
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
      MediaType mediaType = null;
      if (testConfigurationInEnvironmentOptions.fileMediaType() != null) {
        mediaType = MediaType.parse(testConfigurationInEnvironmentOptions.fileMediaType());
      }
      RequestBody body = InputStreamRequestBody.create(mediaType, testConfigurationInEnvironmentOptions.file());
      multipartBuilder.addFormDataPart("file", "filename", body);
    }
    if (testConfigurationInEnvironmentOptions.metadata() != null) {
      multipartBuilder.addFormDataPart("metadata", testConfigurationInEnvironmentOptions.metadata());
    }
    builder.body(multipartBuilder.build());

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TestDocument.class));
  }

}

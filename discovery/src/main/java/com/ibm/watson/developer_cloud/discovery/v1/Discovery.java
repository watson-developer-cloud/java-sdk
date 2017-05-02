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
import com.ibm.watson.developer_cloud.discovery.v1.model.Collection;
import com.ibm.watson.developer_cloud.discovery.v1.model.Configuration;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateCollectionRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteCollectionResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.DocumentAccepted;
import com.ibm.watson.developer_cloud.discovery.v1.model.DocumentStatus;
import com.ibm.watson.developer_cloud.discovery.v1.model.Environment;
import com.ibm.watson.developer_cloud.discovery.v1.model.FullQueryTemplate;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetCollectionFieldsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetCollectionsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetConfigurationsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.GetEnvironmentsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.NoticeQueryResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryNoticesOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryTemplate;
import com.ibm.watson.developer_cloud.discovery.v1.model.TestDocument;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateCollectionRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateEnvironmentRequest;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.InputStreamRequestBody;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.RequestUtils;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;
import java.io.InputStream;
import java.util.Date;
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
   *        calls from failing when the service introduces breaking changes.
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
   *        calls from failing when the service introduces breaking changes.
   * @param username the username
   * @param password the password
   */
  public Discovery(String versionDate, String username, String password) {
    this(versionDate);
    setUsernameAndPassword(username, password);
  }

  /**
   * Create a collection.
   *
   * @param environmentId the ID of your environment
   * @param body Input a JSON object that allows you to add a collection.
   * @return the {@link Collection} with the response
   */
  public ServiceCall<Collection> createCollection(String environmentId, CreateCollectionRequest body) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/collections", environmentId));
    builder.query(VERSION, versionDate);
    if (body != null) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(body).getAsJsonObject());
    } else {
      builder.bodyJson(new JsonObject());
    }

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Collection.class));
  }

  /**
   * Delete a collection.
   *
   * @param environmentId the ID of your environment
   * @param collectionId the ID of your collection
   * @return the {@link DeleteCollectionResponse} with the response
   */
  public ServiceCall<DeleteCollectionResponse> deleteCollection(String environmentId, String collectionId) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notEmpty(collectionId, "collectionId cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/environments/%s/collections/%s", environmentId, collectionId));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DeleteCollectionResponse.class));
  }

  /**
   * Get collection details.
   *
   * @param environmentId the ID of your environment
   * @param collectionId the ID of your collection
   * @return the {@link Collection} with the response
   */
  public ServiceCall<Collection> getCollection(String environmentId, String collectionId) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notEmpty(collectionId, "collectionId cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections/%s", environmentId, collectionId));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Collection.class));
  }

  /**
   * Get unique fields.
   *
   * Gets a list of the the unique fields (and their types) stored in the index.
   *
   * @param environmentId the ID of your environment
   * @param collectionId the ID of your collection
   * @return the {@link GetCollectionFieldsResponse} with the response
   */
  public ServiceCall<GetCollectionFieldsResponse> getCollectionFields(String environmentId, String collectionId) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notEmpty(collectionId, "collectionId cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections/%s/fields", environmentId, collectionId));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(GetCollectionFieldsResponse.class));
  }

  /**
   * Get collections.
   *
   * @param environmentId the ID of your environment
   * @param name Find collections with the given name.
   * @return the {@link GetCollectionsResponse} with the response
   */
  public ServiceCall<GetCollectionsResponse> getCollections(String environmentId, String name) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections", environmentId));
    builder.query(VERSION, versionDate);
    if (name != null) {
      builder.query("name", RequestUtils.encode(name));
    }


    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(GetCollectionsResponse.class));
  }

  /**
   * Update a collection.
   *
   * @param environmentId the ID of your environment
   * @param collectionId the ID of your collection
   * @param body Input a JSON object that allows you to update a collection.
   * @return the {@link Collection} with the response
   */
  public ServiceCall<Collection> updateCollection(String environmentId, String collectionId, UpdateCollectionRequest body) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notEmpty(collectionId, "collectionId cannot be null");
    RequestBuilder builder = RequestBuilder.put(String.format("/v1/environments/%s/collections/%s", environmentId, collectionId));
    builder.query(VERSION, versionDate);
    if (body != null) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(body).getAsJsonObject());
    } else {
      builder.bodyJson(new JsonObject());
    }

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Collection.class));
  }

  /**
   * Add configuration.
   *
   * Creates a new configuration.  If the input configuration contains the `configuration_id`, `created`, or `updated` properties, then they are ignored and overridden by the system, and an error is not returned so that the overridden fields do not need to be removed when copying a configuration.  The configuration can contain unrecognized JSON fields. Any such fields are ignored and do not generate an error. This makes it easier to use newer configuration files with older versions of the API and the service. It also makes it possible for the tooling to add additional metadata and information to the configuration.
   *
   * @param environmentId the ID of your environment
   * @param configuration Input a JSON object that enables you to customize how your content is ingested and what enrichments are added to your data.   `name` is required and must be unique within the current `environment`. All other properties are optional.  If the input configuration contains the `configuration_id`, `created`, or `updated` properties, then they will be ignored and overridden by the system (an error is not returned so that the overridden fields do not need to be removed when copying a configuration).   The configuration can contain unrecognized JSON fields. Any such fields will be ignored and will not generate an error. This makes it easier to use newer configuration files with older versions of the API and the service. It also makes it possible for the tooling to add additional metadata and information to the configuration.
   * @return the {@link Configuration} with the response
   */
  public ServiceCall<Configuration> createConfiguration(String environmentId, Configuration configuration) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notNull(configuration, "configuration cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/configurations", environmentId));
    builder.query(VERSION, versionDate);
    builder.bodyJson(GsonSingleton.getGson().toJsonTree(configuration).getAsJsonObject());

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Configuration.class));
  }

  /**
   * Delete a configuration.
   *
   * The deletion is performed unconditionally. A configuration deletion request succeeds even if the configuration is referenced by a collection or document ingestion. However, documents that have already been submitted for processing continue to use the deleted configuration. Documents are always processed with a snapshot of the configuration as it existed at the time the document was submitted.
   *
   * @param environmentId the ID of your environment
   * @param configurationId the ID of your configuration
   * @return the {@link DeleteConfigurationResponse} with the response
   */
  public ServiceCall<DeleteConfigurationResponse> deleteConfiguration(String environmentId, String configurationId) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notEmpty(configurationId, "configurationId cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/environments/%s/configurations/%s", environmentId, configurationId));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DeleteConfigurationResponse.class));
  }

  /**
   * Get configuration details.
   *
   * @param environmentId the ID of your environment
   * @param configurationId the ID of your configuration
   * @return the {@link Configuration} with the response
   */
  public ServiceCall<Configuration> getConfiguration(String environmentId, String configurationId) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notEmpty(configurationId, "configurationId cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/configurations/%s", environmentId, configurationId));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Configuration.class));
  }

  /**
   * Get configurations.
   *
   * @param environmentId the ID of your environment
   * @param name Find configurations with the given name.
   * @return the {@link GetConfigurationsResponse} with the response
   */
  public ServiceCall<GetConfigurationsResponse> getConfigurations(String environmentId, String name) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/configurations", environmentId));
    builder.query(VERSION, versionDate);
    if (name != null) {
      builder.query("name", RequestUtils.encode(name));
    }


    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(GetConfigurationsResponse.class));
  }

  /**
   * Update a configuration.
   *
   * Replaces an existing configuration.   * Completely replaces the original configuration.   * The `configuration_id`, `updated`, and `created` fields are accepted in the request, but they are ignored, and an error is not generated. It is also acceptable for users to submit an updated configuration with none of the three properties.   * Documents are processed with a snapshot of the configuration as it was at the time the document was submitted to be ingested. This means that already submitted documents will not see any updates made to the configuration.
   *
   * @param environmentId the ID of your environment
   * @param configurationId the ID of your configuration
   * @param configuration Input a JSON object that enables you to update and customize how your data is ingested and what enrichments are added to your data.  The `name` parameter is required and must be unique within the current `environment`. All other properties are optional, but if they are omitted  the default values replace the current value of each omitted property.  If the input configuration contains the `configuration_id`, `created`, or `updated` properties, they are ignored and overridden by the system, and an error is not returned so that the overridden fields do not need to be removed when updating a configuration.   The configuration can contain unrecognized JSON fields. Any such fields are ignored and do not generate an error. This makes it easier to use newer configuration files with older versions of the API and the service. It also makes it possible for the tooling to add additional metadata and information to the configuration.
   * @return the {@link Configuration} with the response
   */
  public ServiceCall<Configuration> updateConfiguration(String environmentId, String configurationId, Configuration configuration) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notEmpty(configurationId, "configurationId cannot be null");
    Validator.notNull(configuration, "configuration cannot be null");
    RequestBuilder builder = RequestBuilder.put(String.format("/v1/environments/%s/configurations/%s", environmentId, configurationId));
    builder.query(VERSION, versionDate);
    builder.bodyJson(GsonSingleton.getGson().toJsonTree(configuration).getAsJsonObject());

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Configuration.class));
  }

  /**
   * Add a document.
   *
   * Add a document to a collection with optional metadata and optional configuration.   Set the `Content-Type` header on the request to indicate the media type of the document. If the `Content-Type` header is missing or is one of the generic media types (for example,  `application/octet-stream`), then the service attempts to automatically detect the document's media type.       * The configuration to use to process the document can be provided by using the `configuration_id` query parameter.       * The `version` query parameter is still required.    * Returns immediately after the system has accepted the document for processing.    * The user must provide document content, metadata, or both. If the request is missing both document content and metadata, it is  rejected.       * The user can set the `Content-Type` parameter on the `file` part to indicate the media type of the document. If the `Content-Type` parameter is missing or is one of the generic media types (for example, `application/octet-stream`), then the service attempts to automatically detect the document's media type.
   *
   * @param environmentId the ID of your environment
   * @param collectionId the ID of your collection
   * @param configurationId The ID of the configuration to use to process the document. If the `configuration` form part is also provided (both are present at the same time), then request will be rejected.
   * @param file The content of the document to ingest.The maximum supported file size is 50 megabytes. Files larger than 50 megabytes is rejected.
   * @param fileMediaType the media type of file.
   * @param metadata If you're using the Data Crawler to upload your documents, you can test a document against the type of metadata that the Data Crawler might send. The maximum supported metadata file size is 1 MB. Metadata parts larger than 1 MB are rejected. Example:  ``` {   "Creator": "Johnny Appleseed",   "Subject": "Apples" } ```
   * @param configuration The configuration to use to process the document. If this part is provided, then the provided configuration is used to process the document. If the `configuration_id` is also provided (both are present at the same time), then request is rejected. The maximum supported configuration size is 1 MB. Configuration parts larger than 1 MB are rejected. See the `GET /configurations/{configuration_id}` operation for an example configuration.
   * @return the {@link DocumentAccepted} with the response
   */
  public ServiceCall<DocumentAccepted> addDocument(String environmentId, String collectionId, String configurationId, InputStream file, String fileMediaType, String metadata, String configuration) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notEmpty(collectionId, "collectionId cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/collections/%s/documents", environmentId, collectionId));
    builder.query(VERSION, versionDate);
    if (configurationId != null) {
      builder.query("configuration_id", RequestUtils.encode(configurationId));
    }


    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (file != null) {
      MediaType fileMediaTypeVal = null;
      if (fileMediaType != null) {
        fileMediaTypeVal = MediaType.parse(fileMediaType);
      }
      RequestBody fileBody = InputStreamRequestBody.create(fileMediaTypeVal, file);
      multipartBuilder.addFormDataPart("file", "filename", fileBody);
    }
    if (metadata != null) {
      multipartBuilder.addFormDataPart("metadata", metadata);
    }
    if (configuration != null) {
      multipartBuilder.addFormDataPart("configuration", configuration);
    }
    builder.body(multipartBuilder.build());

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DocumentAccepted.class));
  }

  /**
   * Delete a document.
   *
   * If the given document id is invalid, or if the document is not found, then the a success response is returned (HTTP status code `200`) with the status set to 'deleted'.
   *
   * @param environmentId the ID of your environment
   * @param collectionId the ID of your collection
   * @param documentId the ID of your document
   * @return the {@link DeleteDocumentResponse} with the response
   */
  public ServiceCall<DeleteDocumentResponse> deleteDocument(String environmentId, String collectionId, String documentId) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notEmpty(collectionId, "collectionId cannot be null");
    Validator.notEmpty(documentId, "documentId cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/environments/%s/collections/%s/documents/%s", environmentId, collectionId, documentId));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DeleteDocumentResponse.class));
  }

  /**
   * Get document details.
   *
   * Fetch status details about a submitted document. **Note:** this operation does not return the document itself. Instead, it returns only the document's processing status and any notices (warnings or errors) that were generated when the document was ingested. Use the query API to retrieve the actual document content.
   *
   * @param environmentId the ID of your environment
   * @param collectionId the ID of your collection
   * @param documentId the ID of your document
   * @return the {@link DocumentStatus} with the response
   */
  public ServiceCall<DocumentStatus> getDocument(String environmentId, String collectionId, String documentId) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notEmpty(collectionId, "collectionId cannot be null");
    Validator.notEmpty(documentId, "documentId cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections/%s/documents/%s", environmentId, collectionId, documentId));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DocumentStatus.class));
  }

  /**
   * Update a document.
   *
   * Replace an existing document. Starts ingesting a document with optional metadata and optional configurations.
   *
   * @param environmentId the ID of your environment
   * @param collectionId the ID of your collection
   * @param documentId the ID of your document
   * @param configurationId The ID of the configuration to use to process the document. If the `configuration` form part is also provided (both are present at the same time), then request will be rejected.
   * @param file The content of the document to ingest.The maximum supported file size is 50 megabytes. Files larger than 50 megabytes is rejected.
   * @param fileMediaType the media type of file.
   * @param metadata If you're using the Data Crawler to upload your documents, you can test a document against the type of metadata that the Data Crawler might send. The maximum supported metadata file size is 1 MB. Metadata parts larger than 1 MB are rejected. Example:  ``` {   "Creator": "Johnny Appleseed",   "Subject": "Apples" } ```
   * @param configuration The configuration to use to process the document. If this part is provided, then the provided configuration is used to process the document. If the `configuration_id` is also provided (both are present at the same time), then request is rejected. The maximum supported configuration size is 1 MB. Configuration parts larger than 1 MB are rejected. See the `GET /configurations/{configuration_id}` operation for an example configuration.
   * @return the {@link DocumentAccepted} with the response
   */
  public ServiceCall<DocumentAccepted> updateDocument(String environmentId, String collectionId, String documentId, String configurationId, InputStream file, String fileMediaType, String metadata, String configuration) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notEmpty(collectionId, "collectionId cannot be null");
    Validator.notEmpty(documentId, "documentId cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/collections/%s/documents/%s", environmentId, collectionId, documentId));
    builder.query(VERSION, versionDate);
    if (configurationId != null) {
      builder.query("configuration_id", RequestUtils.encode(configurationId));
    }


    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (file != null) {
      MediaType fileMediaTypeVal = null;
      if (fileMediaType != null) {
        fileMediaTypeVal = MediaType.parse(fileMediaType);
      }
      RequestBody fileBody = InputStreamRequestBody.create(fileMediaTypeVal, file);
      multipartBuilder.addFormDataPart("file", "filename", fileBody);
    }
    if (metadata != null) {
      multipartBuilder.addFormDataPart("metadata", metadata);
    }
    if (configuration != null) {
      multipartBuilder.addFormDataPart("configuration", configuration);
    }
    builder.body(multipartBuilder.build());

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DocumentAccepted.class));
  }

  /**
   * Add an environment.
   *
   * Creates a new environment.  You can create only one environment per service instance. An attempt to create another environment will result in an error.  The size of the new environment can be controlled by specifying the `size` parameter. Use the table below to map size values to the size of the environment which is created:  | Size | Disk (GB)  | RAM (GB) | Included Standard Enrichments | Notes | | ---:  | -----------: | -----------: | --------------------------------------------: | -------- | | 0  | 2              | 1              | n/a (effectively unlimited)   | Free Plan only, no HA (single node in elastic.co)| | 1     | 48             | 2              | 4,000    | | | 2     | 192            | 8              | 16,000   | | | 3     | 384            | 16             | 32,000   | |  **Note:** you cannot set the size property when using the free plan.
   *
   * @param body A JSON object where you define an environment name, description, and size.
   * @return the {@link Environment} with the response
   */
  public ServiceCall<Environment> createEnvironment(CreateEnvironmentRequest body) {
    Validator.notNull(body, "body cannot be null");
    RequestBuilder builder = RequestBuilder.post("/v1/environments");
    builder.query(VERSION, versionDate);
    builder.bodyJson(GsonSingleton.getGson().toJsonTree(body).getAsJsonObject());

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Environment.class));
  }

  /**
   * Delete environment.
   *
   * @param environmentId the ID of your environment
   * @return the {@link DeleteEnvironmentResponse} with the response
   */
  public ServiceCall<DeleteEnvironmentResponse> deleteEnvironment(String environmentId) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    RequestBuilder builder = RequestBuilder.delete(String.format("/v1/environments/%s", environmentId));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DeleteEnvironmentResponse.class));
  }

  /**
   * Get environment info.
   *
   * @param environmentId the ID of your environment
   * @return the {@link Environment} with the response
   */
  public ServiceCall<Environment> getEnvironment(String environmentId) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s", environmentId));
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Environment.class));
  }

  /**
   * Get environments.
   *
   * List existing environments for the service instance.
   *
   * @param name Show only the environment with the given name.
   * @return the {@link GetEnvironmentsResponse} with the response
   */
  public ServiceCall<GetEnvironmentsResponse> getEnvironments(String name) {
    RequestBuilder builder = RequestBuilder.get("/v1/environments");
    builder.query(VERSION, versionDate);
    if (name != null) {
      builder.query("name", RequestUtils.encode(name));
    }


    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(GetEnvironmentsResponse.class));
  }

  /**
   * Update an environment.
   *
   * Updates an environment. The environment's `name` and  `description` parameters can be changed. You can increase the value of the `size` parameter. If you need to decrease an environment's size, contact IBM Support.
   *
   * @param environmentId the ID of your environment
   * @param body 
   * @return the {@link Environment} with the response
   */
  public ServiceCall<Environment> updateEnvironment(String environmentId, UpdateEnvironmentRequest body) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notNull(body, "body cannot be null");
    RequestBuilder builder = RequestBuilder.put(String.format("/v1/environments/%s", environmentId));
    builder.query(VERSION, versionDate);
    builder.bodyJson(GsonSingleton.getGson().toJsonTree(body).getAsJsonObject());

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Environment.class));
  }

  /**
   * Query documents.
   *
   * See the [Query Language wiki page](https://github.ibm.com/Watson-Discovery/discovery-wiki/blob/master/design/query-language.md) for more details.
   *
   * @param environmentId the ID of your environment
   * @param collectionId the ID of your collection
   * @param queryOptions the query options
   * @return the {@link QueryResponse} with the response
   */
  public ServiceCall<QueryResponse> query(String environmentId, String collectionId, QueryOptions queryOptions) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notEmpty(collectionId, "collectionId cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections/%s/query", environmentId, collectionId));
    builder.query(VERSION, versionDate);
    if (queryOptions != null) {
    if (queryOptions.filter() != null) {
      builder.query("filter", RequestUtils.encode(queryOptions.filter()));
    }
    if (queryOptions.offset() != null) {
      builder.query("offset", RequestUtils.encode(String.valueOf(queryOptions.offset())));
    }
    if (queryOptions.naturalLanguageQuery() != null) {
      builder.query("natural_language_query", RequestUtils.encode(queryOptions.naturalLanguageQuery()));
    }
    if (queryOptions.query() != null) {
      builder.query("query", RequestUtils.encode(queryOptions.query()));
    }
    if (queryOptions.count() != null) {
      builder.query("count", RequestUtils.encode(String.valueOf(queryOptions.count())));
    }
    if (queryOptions.passages() != null) {
      builder.query("passages", RequestUtils.encode(String.valueOf(queryOptions.passages())));
    }
    if (queryOptions.aggregation() != null) {
      builder.query("aggregation", RequestUtils.encode(queryOptions.aggregation()));
    }
    if (queryOptions.sort() != null) {
      builder.query("sort", RequestUtils.encode(queryOptions.sort()));
    }
    if (queryOptions.returnFields() != null) {
      builder.query("return", queryOptions.returnFields());
    }

    }

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(QueryResponse.class));
  }

  /**
   * Queries for notices (errors or warnings) that may have been generated by the system. Currently, notices are only generated when ingesting documents. See the [Query Language wiki page](https://github.ibm.com/Watson-Discovery/discovery-wiki/blob/master/design/query-language.md) for more details on the query language.
   *
   * @param environmentId the ID of your environment
   * @param collectionId the ID of your collection
   * @param queryNoticesOptions the queryNotices options
   * @return the {@link NoticeQueryResponse} with the response
   */
  public ServiceCall<NoticeQueryResponse> queryNotices(String environmentId, String collectionId, QueryNoticesOptions queryNoticesOptions) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notEmpty(collectionId, "collectionId cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections/%s/notices", environmentId, collectionId));
    builder.query(VERSION, versionDate);
    if (queryNoticesOptions != null) {
    if (queryNoticesOptions.filter() != null) {
      builder.query("filter", RequestUtils.encode(queryNoticesOptions.filter()));
    }
    if (queryNoticesOptions.offset() != null) {
      builder.query("offset", RequestUtils.encode(String.valueOf(queryNoticesOptions.offset())));
    }
    if (queryNoticesOptions.naturalLanguageQuery() != null) {
      builder.query("natural_language_query", RequestUtils.encode(queryNoticesOptions.naturalLanguageQuery()));
    }
    if (queryNoticesOptions.query() != null) {
      builder.query("query", RequestUtils.encode(queryNoticesOptions.query()));
    }
    if (queryNoticesOptions.count() != null) {
      builder.query("count", RequestUtils.encode(String.valueOf(queryNoticesOptions.count())));
    }
    if (queryNoticesOptions.passages() != null) {
      builder.query("passages", RequestUtils.encode(String.valueOf(queryNoticesOptions.passages())));
    }
    if (queryNoticesOptions.aggregation() != null) {
      builder.query("aggregation", RequestUtils.encode(queryNoticesOptions.aggregation()));
    }
    if (queryNoticesOptions.sort() != null) {
      builder.query("sort", RequestUtils.encode(queryNoticesOptions.sort()));
    }
    if (queryNoticesOptions.returnFields() != null) {
      builder.query("return", queryNoticesOptions.returnFields());
    }

    }

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(NoticeQueryResponse.class));
  }

  /**
   * Creates a new query template. Query templates can be used to execute complex queries without having to submit the full query on every request. Query templates use the [Mustache](https://mustache.github.io/) or [Handlebars](http://handlebarsjs.com/) templating syntax. **Template constructs**   * `{{parameter_name}}` - String interpolation. Replace this portion with the specified parameter.   * `{{#if parameter_name}}{{/if}}` - `If` logic helper. Contents of this segment will be included in `parameter_name` is included and valid.   * `{{#default parameter_name Default Value}}` - `Default` logic helper. If `parameter_name` is included, it will be used. Otherwise, the provided default value will be used. For more details, see the [Query Templating design page](https://github.ibm.com/Watson-Discovery/discovery-wiki/blob/master/design/query-templating.md).
   *
   * @param environmentId the ID of your environment
   * @param collectionId the ID of your collection
   * @param body 
   * @return the {@link FullQueryTemplate} with the response
   */
  public ServiceCall<FullQueryTemplate> createQueryTemplate(String environmentId, String collectionId, QueryTemplate body) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notEmpty(collectionId, "collectionId cannot be null");
    Validator.notNull(body, "body cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/collections/%s/templates", environmentId, collectionId));
    builder.query(VERSION, versionDate);
    builder.bodyJson(GsonSingleton.getGson().toJsonTree(body).getAsJsonObject());

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(FullQueryTemplate.class));
  }

  /**
   * Gets a list of existing query templates. For more details, see the [Query Templating design page](https://github.ibm.com/Watson-Discovery/discovery-wiki/blob/master/design/query-templating.md).
   *
   * @param environmentId the ID of your environment
   * @param collectionId the ID of your collection
   * @param configurationId The ID of the configuration to use to process the document. If the `configuration` form part is also provided (both are present at the same time), then request will be rejected.
   * @param file The content of the document to ingest.The maximum supported file size is 50 megabytes. Files larger than 50 megabytes is rejected.
   * @param fileMediaType the media type of file.
   * @param metadata If you're using the Data Crawler to upload your documents, you can test a document against the type of metadata that the Data Crawler might send. The maximum supported metadata file size is 1 MB. Metadata parts larger than 1 MB are rejected. Example:  ``` {   "Creator": "Johnny Appleseed",   "Subject": "Apples" } ```
   * @param configuration The configuration to use to process the document. If this part is provided, then the provided configuration is used to process the document. If the `configuration_id` is also provided (both are present at the same time), then request is rejected. The maximum supported configuration size is 1 MB. Configuration parts larger than 1 MB are rejected. See the `GET /configurations/{configuration_id}` operation for an example configuration.
   * @return the {@link DocumentAccepted} with the response
   */
  public ServiceCall<DocumentAccepted> getQueryTemplates(String environmentId, String collectionId, String configurationId, InputStream file, String fileMediaType, String metadata, String configuration) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    Validator.notEmpty(collectionId, "collectionId cannot be null");
    RequestBuilder builder = RequestBuilder.get(String.format("/v1/environments/%s/collections/%s/templates", environmentId, collectionId));
    builder.query(VERSION, versionDate);
    if (configurationId != null) {
      builder.query("configuration_id", RequestUtils.encode(configurationId));
    }


    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (file != null) {
      MediaType fileMediaTypeVal = null;
      if (fileMediaType != null) {
        fileMediaTypeVal = MediaType.parse(fileMediaType);
      }
      RequestBody fileBody = InputStreamRequestBody.create(fileMediaTypeVal, file);
      multipartBuilder.addFormDataPart("file", "filename", fileBody);
    }
    if (metadata != null) {
      multipartBuilder.addFormDataPart("metadata", metadata);
    }
    if (configuration != null) {
      multipartBuilder.addFormDataPart("configuration", configuration);
    }
    builder.body(multipartBuilder.build());

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DocumentAccepted.class));
  }

  /**
   * Test configuration.
   *
   * Runs a sample document through the default or your configuration and returns diagnostic information designed to help you understand how the document was processed. The document is not added to the index.
   *
   * @param environmentId the ID of your environment
   * @param configuration The configuration to use to process the document. If this part is provided, then the provided configuration is used to process the document. If the `configuration_id` is also provided (both are present at the same time), then request is rejected. The maximum supported configuration size is 1 MB. Configuration parts larger than 1 MB are rejected. See the `GET /configurations/{configuration_id}` operation for an example configuration.
   * @param step Specify to only run the input document through the given step instead of running the input document through the entire ingestion workflow. Valid values are `convert`, `enrich`, and `normalize`.
   * @param configurationId The ID of the configuration to use to process the document. If the `configuration` form part is also provided (both are present at the same time), then request will be rejected.
   * @param file The content of the document to ingest.The maximum supported file size is 50 megabytes. Files larger than 50 megabytes is rejected.
   * @param fileMediaType the media type of file.
   * @param metadata If you're using the Data Crawler to upload your documents, you can test a document against the type of metadata that the Data Crawler might send. The maximum supported metadata file size is 1 MB. Metadata parts larger than 1 MB are rejected. Example:  ``` {   "Creator": "Johnny Appleseed",   "Subject": "Apples" } ```
   * @return the {@link TestDocument} with the response
   */
  public ServiceCall<TestDocument> testConfigurationInEnvironment(String environmentId, String configuration, String step, String configurationId, InputStream file, String fileMediaType, String metadata) {
    Validator.notEmpty(environmentId, "environmentId cannot be null");
    RequestBuilder builder = RequestBuilder.post(String.format("/v1/environments/%s/preview", environmentId));
    builder.query(VERSION, versionDate);
    if (step != null) {
      builder.query("step", RequestUtils.encode(step));
    }
    if (configurationId != null) {
      builder.query("configuration_id", RequestUtils.encode(configurationId));
    }


    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (configuration != null) {
      multipartBuilder.addFormDataPart("configuration", configuration);
    }
    if (file != null) {
      MediaType fileMediaTypeVal = null;
      if (fileMediaType != null) {
        fileMediaTypeVal = MediaType.parse(fileMediaType);
      }
      RequestBody fileBody = InputStreamRequestBody.create(fileMediaTypeVal, file);
      multipartBuilder.addFormDataPart("file", "filename", fileBody);
    }
    if (metadata != null) {
      multipartBuilder.addFormDataPart("metadata", metadata);
    }
    builder.body(multipartBuilder.build());

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TestDocument.class));
  }

}

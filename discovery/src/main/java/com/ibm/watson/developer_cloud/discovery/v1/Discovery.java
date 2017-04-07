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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ibm.watson.developer_cloud.discovery.v1.model.collection.CollectionManager;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.CreateCollectionRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.CreateCollectionResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.DeleteCollectionRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.DeleteCollectionResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.GetCollectionRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.GetCollectionResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.GetCollectionsRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.GetCollectionsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.field.GetCollectionFieldsRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.field.GetCollectionFieldsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.Configuration;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.ConfigurationManager;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.CreateConfigurationRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.CreateConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.DeleteConfigurationRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.DeleteConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.GetConfigurationRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.GetConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.GetConfigurationsRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.GetConfigurationsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.UpdateConfigurationRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.UpdateConfigurationResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.CreateDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.CreateDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.DeleteDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.DeleteDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.DocumentManager;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.GetDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.GetDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.UpdateDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.UpdateDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.CreateEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.CreateEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.DeleteEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.DeleteEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.EnvironmentManager;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentsRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.UpdateEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.UpdateEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.Operator;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryManager;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryResponse;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.InputStreamRequestBody;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.RequestUtils;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Discovery service API for CRUD operations for indexing and searching data.
 */
public class Discovery extends WatsonService implements EnvironmentManager, ConfigurationManager, CollectionManager,
        DocumentManager, QueryManager {
    private static final String VERSION_DATE = "version";
    private static final String SERVICE_NAME = "discovery";
    private static final String FILENAME = "filename";
    private static final String PATH_ENVIRONMENTS = "/v1/environments";
    private static final String PATH_ENVIRONMENT = PATH_ENVIRONMENTS + "/%s";
    private static final String PATH_CONFIGURATIONS = PATH_ENVIRONMENT + "/configurations";
    private static final String PATH_CONFIGURATION = PATH_CONFIGURATIONS + "/%s";
    private static final String PATH_COLLECTIONS = PATH_ENVIRONMENT + "/collections";
    private static final String PATH_COLLECTION = PATH_COLLECTIONS + "/%s";
    private static final String PATH_FIELDS = PATH_COLLECTION + "/fields";
    private static final String PATH_DOCUMENTS = PATH_COLLECTION + "/documents";
    private static final String PATH_DOCUMENT = PATH_DOCUMENTS + "/%s";
    private static final String PATH_QUERY = PATH_COLLECTION + "/query";
    private static final Pattern invalidFieldCharactersPattern = Pattern.compile("[^\\w\\.]");
    private static final Pattern escapeControlCharactersPattern;
    private static final String INVALID_FIELD_CHARACTER_REPLACEMENT = "_";

    private String versionDate;
    private static Map<String, MediaType> supportedMediaTypes = new HashMap<String, MediaType>();

    static {
        supportedMediaTypes.put(HttpMediaType.APPLICATION_JSON, MediaType.parse(HttpMediaType.APPLICATION_JSON));
        supportedMediaTypes.put(HttpMediaType.APPLICATION_MS_WORD, MediaType.parse(HttpMediaType.APPLICATION_MS_WORD));
        supportedMediaTypes
                .put(HttpMediaType.APPLICATION_MS_WORD_DOCX, MediaType.parse(HttpMediaType.APPLICATION_MS_WORD_DOCX));
        supportedMediaTypes.put(HttpMediaType.APPLICATION_PDF, MediaType.parse(HttpMediaType.APPLICATION_PDF));
        supportedMediaTypes.put(HttpMediaType.TEXT_HTML, MediaType.parse(HttpMediaType.TEXT_HTML));
        supportedMediaTypes
                .put(HttpMediaType.APPLICATION_XHTML_XML, MediaType.parse(HttpMediaType.APPLICATION_XHTML_XML));

        List<String> operatorsToEscape = new ArrayList<String>();
        for (Operator operator : Operator.values()) {
            if (operator.shouldEscape()) {
                operatorsToEscape.add(Pattern.quote(operator.getSymbol()));
            }
        }

        escapeControlCharactersPattern = Pattern.compile("(" + RequestUtils.join(operatorsToEscape, "|") + ")");
    }

    /**
     * Instantiates a new Discovery service.
     *
     * @param versionDate the version date
     */
    public Discovery(String versionDate) {
        super(SERVICE_NAME);
        this.versionDate = versionDate;
    }

    /**
     * Utility method to replace unsupported characters in a field name.
     *
     * @param fieldName the field name to escape
     * @return a clean field name
     */
    public static String cleanFieldName(String fieldName) {
        return invalidFieldCharactersPattern.matcher(fieldName).replaceAll(INVALID_FIELD_CHARACTER_REPLACEMENT);
    }

    /**
     * Utility method to escape control characters in a value for querying.
     *
     * @param value the value that potentially contains control characters
     * @return a value with control characters escaped
     */
    public static String escapeControlChracters(String value) {
        return escapeControlCharactersPattern.matcher(value)
                .replaceAll(Matcher.quoteReplacement(Operator.ESCAPE.getSymbol()) + "$1");
    }

    /**
     * Ping the service.
     *
     * @return true if the service is reachable
     * @throws RuntimeException if the service is unreachable
     */
    public boolean ping() throws RuntimeException {
        getEnvironments(new GetEnvironmentsRequest.Builder().build()).execute();
        return true;
    }

    @Override
    public ServiceCall<GetEnvironmentsResponse> getEnvironments(GetEnvironmentsRequest getRequest) {
        RequestBuilder builder = RequestBuilder.get(String.format(PATH_ENVIRONMENTS));
        if (getRequest.hasName()) {
            builder.query(EnvironmentManager.NAME, getRequest.getName());
        }
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(GetEnvironmentsResponse.class));
    }

    @Override
    public ServiceCall<GetEnvironmentResponse> getEnvironment(GetEnvironmentRequest getRequest) {
        Validator.notEmpty(getRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        Validator.notNull(getRequest, "Environment request cannot be null");
        RequestBuilder builder = RequestBuilder.get(String.format(PATH_ENVIRONMENT, getRequest.getEnvironmentId()));
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(GetEnvironmentResponse.class));
    }

    @Override
    public ServiceCall<CreateEnvironmentResponse> createEnvironment(CreateEnvironmentRequest createRequest) {
        Validator.notEmpty(createRequest.getName(), EnvironmentManager.NAME + " cannot be empty");
        Validator.notNull(createRequest.getSize(), EnvironmentManager.SIZE + " cannot be null");
        RequestBuilder builder = RequestBuilder.post(String.format(PATH_ENVIRONMENTS));
        builder.bodyJson(GsonSingleton.getGson().toJsonTree(createRequest).getAsJsonObject());
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(CreateEnvironmentResponse.class));
    }

    @Override
    public ServiceCall<DeleteEnvironmentResponse> deleteEnvironment(DeleteEnvironmentRequest deleteRequest) {
        Validator.notEmpty(deleteRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        Validator.notNull(deleteRequest, "Environment request cannot be null");
        RequestBuilder builder = RequestBuilder
                .delete(String.format(PATH_ENVIRONMENT, deleteRequest.getEnvironmentId()));
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(DeleteEnvironmentResponse.class));
    }

    @Override
    public ServiceCall<UpdateEnvironmentResponse> updateEnvironment(UpdateEnvironmentRequest updateRequest) {
        Validator.notEmpty(updateRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        Validator.notEmpty(updateRequest.getName(), EnvironmentManager.NAME + " cannot be empty");
        Validator.notNull(updateRequest, "Environment request cannot be null");
        RequestBuilder builder = RequestBuilder.put(String.format(PATH_ENVIRONMENT, updateRequest.getEnvironmentId()));
        builder.bodyJson(GsonSingleton.getGson().toJsonTree(updateRequest).getAsJsonObject());
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(UpdateEnvironmentResponse.class));
    }

    @Override
    public ServiceCall<GetConfigurationsResponse> getConfigurations(GetConfigurationsRequest getRequest) {
        Validator.notEmpty(getRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        RequestBuilder builder = RequestBuilder.get(String.format(PATH_CONFIGURATIONS, getRequest.getEnvironmentId()));
        if (getRequest.hasName()) {
            builder.query(ConfigurationManager.NAME, getRequest.getName());
        }
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(GetConfigurationsResponse.class));
    }

    @Override
    public ServiceCall<GetConfigurationResponse> getConfiguration(GetConfigurationRequest getRequest) {
        Validator.notEmpty(getRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        Validator.notEmpty(getRequest.getConfigurationId(), ConfigurationManager.ID + " cannot be empty");
        RequestBuilder builder = RequestBuilder
                .get(String.format(PATH_CONFIGURATION, getRequest.getEnvironmentId(), getRequest.getConfigurationId()));
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(GetConfigurationResponse.class));
    }

    @Override
    public ServiceCall<CreateConfigurationResponse> createConfiguration(CreateConfigurationRequest createRequest) {
        Validator.notEmpty(createRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        Validator.notNull(createRequest.getConfiguration(), ConfigurationManager.CONFIGURATION + " cannot be null");
        Validator.notEmpty(createRequest.getConfiguration().getName(),
                ConfigurationManager.CONFIGURATION + "." + ConfigurationManager.NAME + " cannot be empty");
        RequestBuilder builder = RequestBuilder
                .post(String.format(PATH_CONFIGURATIONS, createRequest.getEnvironmentId()));
        builder.bodyJson(GsonSingleton.getGson().toJsonTree(createRequest.getConfiguration(), Configuration.class)
                .getAsJsonObject());
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(CreateConfigurationResponse.class));
    }

    @Override
    public ServiceCall<DeleteConfigurationResponse> deleteConfiguration(DeleteConfigurationRequest deleteRequest) {
        Validator.notEmpty(deleteRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        Validator.notEmpty(deleteRequest.getConfigurationId(), ConfigurationManager.ID + " cannot be empty");
        RequestBuilder builder = RequestBuilder.delete(String
                .format(PATH_CONFIGURATION, deleteRequest.getEnvironmentId(), deleteRequest.getConfigurationId()));
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(DeleteConfigurationResponse.class));
    }

    @Override
    public ServiceCall<UpdateConfigurationResponse> updateConfiguration(UpdateConfigurationRequest updateRequest) {
        Validator.notEmpty(updateRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        Validator.notEmpty(updateRequest.getConfigurationId(), ConfigurationManager.ID + " cannot be empty");
        Validator.notNull(updateRequest.getConfiguration(), ConfigurationManager.CONFIGURATION + " cannot be null");
        Validator.notEmpty(updateRequest.getConfiguration().getName(),
                ConfigurationManager.CONFIGURATION + "." + ConfigurationManager.NAME + " cannot be empty");
        RequestBuilder builder = RequestBuilder.put(String
                .format(PATH_CONFIGURATION, updateRequest.getEnvironmentId(), updateRequest.getConfigurationId()));
        builder.bodyJson(GsonSingleton.getGson().toJsonTree(updateRequest.getConfiguration(), Configuration.class)
                .getAsJsonObject());
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(UpdateConfigurationResponse.class));
    }

    @Override
    public ServiceCall<GetCollectionsResponse> getCollections(GetCollectionsRequest getRequest) {
        Validator.notEmpty(getRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        RequestBuilder builder = RequestBuilder.get(String.format(PATH_COLLECTIONS, getRequest.getEnvironmentId()));
        if (getRequest.hasName()) {
            builder.query(CollectionManager.NAME, getRequest.getName());
        }
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(GetCollectionsResponse.class));
    }

    @Override
    public ServiceCall<GetCollectionResponse> getCollection(GetCollectionRequest getRequest) {
        Validator.notEmpty(getRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        Validator.notEmpty(getRequest.getCollectionId(), CollectionManager.ID + " cannot be empty");
        RequestBuilder builder = RequestBuilder
                .get(String.format(PATH_COLLECTION, getRequest.getEnvironmentId(), getRequest.getCollectionId()));
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(GetCollectionResponse.class));
    }

    @Override
    public ServiceCall<CreateCollectionResponse> createCollection(CreateCollectionRequest createRequest) {
        Validator.notEmpty(createRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        Validator.notEmpty(createRequest.getConfigurationId(), ConfigurationManager.ID + " cannot be empty");
        Validator.notEmpty(createRequest.getName(), CollectionManager.NAME + " cannot be empty");
        RequestBuilder builder = RequestBuilder.post(String.format(PATH_COLLECTIONS, createRequest.getEnvironmentId()));
        builder.bodyJson(
                GsonSingleton.getGson().toJsonTree(createRequest, CreateCollectionRequest.class).getAsJsonObject());
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(CreateCollectionResponse.class));
    }

    @Override
    public ServiceCall<DeleteCollectionResponse> deleteCollection(DeleteCollectionRequest deleteRequest) {
        Validator.notEmpty(deleteRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        Validator.notEmpty(deleteRequest.getCollectionId(), CollectionManager.ID + " cannot be empty");
        RequestBuilder builder = RequestBuilder.delete(String
                .format(PATH_COLLECTION, deleteRequest.getEnvironmentId(), deleteRequest.getCollectionId()));
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(DeleteCollectionResponse.class));
    }

    @Override
    public ServiceCall<GetCollectionFieldsResponse> getCollectionFields(GetCollectionFieldsRequest getRequest) {
        Validator.notEmpty(getRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        Validator.notEmpty(getRequest.getCollectionId(), CollectionManager.ID + " cannot be empty");
        RequestBuilder builder = RequestBuilder
                .get(String.format(PATH_FIELDS, getRequest.getEnvironmentId(), getRequest.getCollectionId()));
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(GetCollectionFieldsResponse.class));
    }

    @Override
    public ServiceCall<GetDocumentResponse> getDocument(GetDocumentRequest getRequest) {
        Validator.notEmpty(getRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        Validator.notEmpty(getRequest.getCollectionId(), CollectionManager.ID + " cannot be empty");
        Validator.notEmpty(getRequest.getDocumentId(), DocumentManager.ID + " cannot be empty");
        RequestBuilder builder = RequestBuilder.get(String
                .format(PATH_DOCUMENT, getRequest.getEnvironmentId(), getRequest.getCollectionId(),
                        getRequest.getDocumentId()));
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(GetDocumentResponse.class));
    }

    @Override
    public ServiceCall<CreateDocumentResponse> createDocument(CreateDocumentRequest createRequest) {
        Validator.notEmpty(createRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        Validator.notEmpty(createRequest.getCollectionId(), CollectionManager.ID + " cannot be empty");

        String pathElements;
        if (createRequest.getDocumentId() == null) {
            pathElements = String.format(PATH_DOCUMENTS, createRequest.getEnvironmentId(),
                                         createRequest.getCollectionId());
        } else {
            Validator.notEmpty(createRequest.getDocumentId(), DocumentManager.ID + " cannot be empty");
            pathElements = String.format(PATH_DOCUMENT, createRequest.getEnvironmentId(),
                                         createRequest.getCollectionId(), createRequest.getDocumentId());
        }

        RequestBuilder builder = RequestBuilder.post(pathElements);

        if (createRequest.getConfigurationId() != null) {
            builder.query(CollectionManager.CONFIGURATION_ID, createRequest.getConfigurationId());
        }
        Validator.notNull(createRequest.getFile(), "Document " + FILE + " cannot be null");
        MediaType mediaType = supportedMediaTypes.get(createRequest.getMediaType());
        RequestBody file = InputStreamRequestBody.create(mediaType, createRequest.getFile());
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.setType(MultipartBody.FORM);
        multipartBuilder.addFormDataPart(FILE, FILENAME, file);
        if (createRequest.getMetadata() != null) {
            multipartBuilder.addFormDataPart(METADATA, createRequest.getMetadata().toString());
        }
        builder.body(multipartBuilder.build());
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(CreateDocumentResponse.class));
    }

    @Override
    public ServiceCall<DeleteDocumentResponse> deleteDocument(DeleteDocumentRequest deleteRequest) {
        Validator.notEmpty(deleteRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        Validator.notEmpty(deleteRequest.getCollectionId(), CollectionManager.ID + " cannot be empty");
        Validator.notEmpty(deleteRequest.getDocumentId(), DocumentManager.ID + " cannot be empty");
        RequestBuilder builder = RequestBuilder.delete(String
                .format(PATH_DOCUMENT, deleteRequest.getEnvironmentId(), deleteRequest.getCollectionId(),
                        deleteRequest.getDocumentId()));
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(DeleteDocumentResponse.class));
    }

    @Override
    public ServiceCall<UpdateDocumentResponse> updateDocument(UpdateDocumentRequest updateRequest) {
        Validator.notEmpty(updateRequest.getEnvironmentId(), EnvironmentManager.ID + " cannot be empty");
        Validator.notEmpty(updateRequest.getCollectionId(), CollectionManager.ID + " cannot be empty");
        Validator.notEmpty(updateRequest.getDocumentId(), DocumentManager.ID + " cannot be empty");
        RequestBuilder builder = RequestBuilder.post(String
                .format(PATH_DOCUMENT, updateRequest.getEnvironmentId(), updateRequest.getCollectionId(),
                        updateRequest.getDocumentId()));
        if (updateRequest.getConfigurationId() != null) {
            builder.query(CollectionManager.CONFIGURATION_ID, updateRequest.getConfigurationId());
        }
        Validator.notNull(updateRequest.getFile(), "Document " + FILE + " cannot be null");
        MediaType mediaType = supportedMediaTypes.get(updateRequest.getMediaType());
        Validator.notNull(mediaType, String.format("Media Type '%s' not supported", updateRequest.getMediaType()));
        RequestBody file = InputStreamRequestBody.create(mediaType, updateRequest.getFile());
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.setType(MultipartBody.FORM);
        multipartBuilder.addFormDataPart(FILE, FILENAME, file);
        if (updateRequest.getMetadata() != null) {
            multipartBuilder.addFormDataPart(METADATA, updateRequest.getMetadata().toString());
        }
        builder.body(multipartBuilder.build());
        final Request request = createVersionedRequest(builder);
        return createServiceCall(request, ResponseConverterUtils.getObject(UpdateDocumentResponse.class));
    }

    @Override
    public ServiceCall<QueryResponse> query(QueryRequest queryRequest) {
        Validator.notNull(queryRequest.getEnvironmentId(), "Environment ID cannot be null");
        Validator.notNull(queryRequest.getCollectionId(), "Collection ID cannot be null");
        RequestBuilder requestBuilder = RequestBuilder
                .get(String.format(PATH_QUERY, queryRequest.getEnvironmentId(), queryRequest.getCollectionId()));
        if (queryRequest.getFilter() != null) {
            requestBuilder.query(FILTER, queryRequest.getFilter());
        }
        if (queryRequest.getQuery() != null) {
            requestBuilder.query(QUERY, queryRequest.getQuery());
        }
        if (queryRequest.getAggregation() != null) {
            requestBuilder.query(AGGREGATION, queryRequest.getAggregation());
        }
        if (queryRequest.getCount() > -1) {
            requestBuilder.query(COUNT, queryRequest.getCount());
        }
        if (queryRequest.getOffset() > -1) {
            requestBuilder.query(OFFSET, queryRequest.getOffset());
        }
        if (queryRequest.getReturnFields() != null) {
            String fields = RequestUtils.join(queryRequest.getReturnFields(), ",");
            if (!fields.isEmpty()) {
                requestBuilder.query(RETURN, fields);
            }
        }
        final Request request = createVersionedRequest(requestBuilder);
        return createServiceCall(request, ResponseConverterUtils.getObject(QueryResponse.class));
    }

    private Request createVersionedRequest(RequestBuilder requestBuilder) {
        Validator.notEmpty(versionDate, "versionDate cannot be empty");
        return requestBuilder.query(VERSION_DATE, versionDate).build();
    }
}

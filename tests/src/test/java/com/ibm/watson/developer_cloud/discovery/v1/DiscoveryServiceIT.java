/**
 * Copyright 2016 IBM Corp. All Rights Reserved.
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

import static org.junit.Assert.*;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
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
import com.ibm.watson.developer_cloud.discovery.v1.model.document.GetDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.GetDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.UpdateDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.UpdateDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.CreateEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.CreateEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.DeleteEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.DeleteEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.Environment;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentsRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.UpdateEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.UpdateEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.Aggregation;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.Calculation;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.Histogram;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.Operator;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.Term;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.service.exception.ForbiddenException;
import com.ibm.watson.developer_cloud.service.exception.ServiceResponseException;
import com.ibm.watson.developer_cloud.service.exception.UnauthorizedException;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Integration tests for {@link Discovery}
 *
 * @author apturgeo
 */
public class DiscoveryServiceIT extends WatsonServiceTest {
    private static final String DISCOVERY_TEST_CONFIG_FILE = "src/test/resources/discovery/test-config.json";
    private static Discovery discovery;
    private static String environmentId;
    private static String uniqueName;

    @BeforeClass
    public static void setup() throws Exception {
        String username = properties.getProperty("discovery.username");
        String password = properties.getProperty("discovery.password");
        String url = properties.getProperty("discovery.url");
        discovery = new Discovery("2016-12-16");
        discovery.setEndPoint(url);
        discovery.setUsernameAndPassword(username, password);

        //create an environment to use for the duration of the tests
        String environmentName = "watson_developer_cloud_test_environment";
        CreateEnvironmentRequest.Builder builder = new CreateEnvironmentRequest.Builder(environmentName);
        environmentId = discovery.createEnvironment(builder.build()).execute().getEnvironmentId();
        uniqueName = UUID.randomUUID().toString();
    }

    @AfterClass
    public static void cleanup() {
        DeleteEnvironmentRequest deleteEnvironmentRequest = new DeleteEnvironmentRequest.Builder(environmentId).build();
        try {
            discovery.deleteEnvironment(deleteEnvironmentRequest).execute();
        } catch (ServiceResponseException e) {
            //oops
        }
    }

    @Test
    public void ping_is_successful() {
        assertTrue(discovery.ping());
    }

    @Test(expected = UnauthorizedException.class)
    public void ping_bad_credentials_throws_exception() {
        discovery.setUsernameAndPassword("foo", "bar");
        discovery.ping();
    }

    @Test(expected = ForbiddenException.class)
    public void ping_bad_url_throws_exception() {
        discovery.setEndPoint("https://gateway.watsonplatform.net/discovery-foo/api");
        discovery.ping();
    }

    @Test
    public void get_environment_is_successful() {
        GetEnvironmentRequest getRequest = new GetEnvironmentRequest.Builder(environmentId).build();
        GetEnvironmentResponse getResponse = discovery.getEnvironment(getRequest).execute();

        assertEquals(environmentId, getResponse.getEnvironmentId());
    }

    @Test
    public void get_environments_is_successful() {
        GetEnvironmentsRequest getRequest = new GetEnvironmentsRequest.Builder().build();
        GetEnvironmentsResponse getResponse = discovery.getEnvironments(getRequest).execute();

        assertFalse(getResponse.getEnvironments().isEmpty());
    }

    @Test
    public void get_environments_has_news_environment() {
        GetEnvironmentsRequest getRequest = new GetEnvironmentsRequest.Builder().build();
        GetEnvironmentsResponse getResponse = discovery.getEnvironments(getRequest).execute();

        boolean foundNews = false;
        for (Environment environment : getResponse.getEnvironments()) {
            if (environment.isReadOnly()) {
                foundNews = true;
                break;
            }
        }
        assertTrue(foundNews);
    }

    @Test
    public void get_environments_by_name_is_successful() {
        GetEnvironmentRequest getRequest = new GetEnvironmentRequest.Builder(environmentId).build();
        GetEnvironmentResponse getResponse = discovery.getEnvironment(getRequest).execute();

        GetEnvironmentsRequest.Builder getBuilder = new GetEnvironmentsRequest.Builder();
        getBuilder.name(getResponse.getName());
        GetEnvironmentsResponse getsResponse = discovery.getEnvironments(getBuilder.build()).execute();

        assertEquals(1, getsResponse.getEnvironments().size());
    }

    @Test
    @Ignore("Environment creation/deletion is expensive")
    public void create_environment_is_successful() {
        String environmentName = uniqueName + "-environment";
        CreateEnvironmentRequest createRequest = new CreateEnvironmentRequest.Builder(environmentName).build();
        CreateEnvironmentResponse createResponse = createEnvironment(createRequest);

        assertEquals(environmentName, createResponse.getName());
    }

    @Test
    @Ignore("Environment creation/deletion is expensive")
    public void delete_environment_is_successful() {
        String environmentName = uniqueName + "-environment";
        CreateEnvironmentRequest createRequest = new CreateEnvironmentRequest.Builder(environmentName).build();
        CreateEnvironmentResponse createResponse = createEnvironment(createRequest);

        DeleteEnvironmentRequest deleteRequest = new DeleteEnvironmentRequest.Builder(createResponse.getEnvironmentId())
                .build();
        DeleteEnvironmentResponse deleteRepsonse = deleteEnvironment(deleteRequest);

        assertEquals(createResponse.getEnvironmentId(), deleteRepsonse.getEnvironmentId());
    }

    @Test
    @Ignore("Environment creation/deletion is expensive")
    public void update_environment_is_successful() {
        String environmentName = uniqueName + "-environment";
        CreateEnvironmentRequest createRequest = new CreateEnvironmentRequest.Builder(environmentName).build();
        CreateEnvironmentResponse createResponse = createEnvironment(createRequest);

        String randomDescription = UUID.randomUUID().toString() + " appbuilder tests";
        UpdateEnvironmentRequest.Builder updateBuilder = new UpdateEnvironmentRequest.Builder(
                createResponse.getEnvironmentId(), environmentName);
        updateBuilder.description(randomDescription);
        UpdateEnvironmentResponse updateResponse = discovery.updateEnvironment(updateBuilder.build()).execute();

        assertEquals(randomDescription, updateResponse.getDescription());
    }

    @Test
    public void get_configurations_is_successful() {
        GetConfigurationsRequest getRequest = new GetConfigurationsRequest.Builder(environmentId).build();
        GetConfigurationsResponse getResponse = discovery.getConfigurations(getRequest).execute();

        assertFalse(getResponse.getConfigurations().isEmpty());
    }

    @Test
    public void create_configuration_is_successful() {
        String uniqueConfigName = uniqueName + "-config";
        CreateConfigurationRequest.Builder createBuilder = new CreateConfigurationRequest.Builder(environmentId);
        Configuration configuration = getTestConfiguration();
        configuration.setName(uniqueConfigName);
        createBuilder.configuration(configuration);
        CreateConfigurationResponse createResponse = createConfiguration(createBuilder.build());

        assertEquals(uniqueConfigName, createResponse.getName());
    }

    @Test
    public void delete_configuration_is_successful() {
        CreateConfigurationResponse createResponse = createTestConfig();

        DeleteConfigurationRequest deleteRequest = new DeleteConfigurationRequest.Builder(environmentId,
                createResponse.getConfigurationId()).build();
        DeleteConfigurationResponse deleteResponse = deleteConfiguration(deleteRequest);

        assertEquals(createResponse.getConfigurationId(), deleteResponse.getConfigurationId());
    }

    @Test
    public void get_configuration_is_successful() {
        CreateConfigurationResponse createResponse = createTestConfig();

        GetConfigurationRequest getRequest = new GetConfigurationRequest.Builder(environmentId,
                createResponse.getConfigurationId()).build();
        GetConfigurationResponse getResponse = discovery.getConfiguration(getRequest).execute();

        assertEquals(createResponse.getName(), getResponse.getName());
    }

    @Test
    public void get_configurations_by_name_is_successful() {
        CreateConfigurationResponse createResponse = createTestConfig();

        GetConfigurationsRequest.Builder getBuilder = new GetConfigurationsRequest.Builder(environmentId);
        getBuilder.name(createResponse.getName());
        GetConfigurationsResponse getResponse = discovery.getConfigurations(getBuilder.build()).execute();

        assertEquals(1, getResponse.getConfigurations().size());
        assertEquals(createResponse.getName(), getResponse.getConfigurations().get(0).getName());
    }

    @Test
    public void update_configuration_is_successful() {
        CreateConfigurationResponse createResponse = createTestConfig();

        String newUniqueName = createResponse.getName() + UUID.randomUUID().toString();
        UpdateConfigurationRequest.Builder updateBuilder = new UpdateConfigurationRequest.Builder(environmentId,
                createResponse.getConfigurationId());
        createResponse.setName(newUniqueName);
        updateBuilder.configuration(createResponse);
        UpdateConfigurationResponse updateResponse = discovery.updateConfiguration(updateBuilder.build()).execute();

        assertEquals(newUniqueName, updateResponse.getName());
    }

    @Test
    public void get_collections_is_successful() {
        createTestCollection();
        GetCollectionsRequest getRequest = new GetCollectionsRequest.Builder(environmentId).build();
        GetCollectionsResponse getResponse = discovery.getCollections(getRequest).execute();

        assertFalse(getResponse.getCollections().isEmpty());
    }

    @Test
    public void create_collection_is_successful() {
        CreateConfigurationResponse createConfigResponse = createTestConfig();

        String uniqueCollectionName = uniqueName + "-collection";
        CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder(environmentId,
                createConfigResponse.getConfigurationId(), uniqueCollectionName);
        CreateCollectionResponse createResponse = createCollection(createCollectionBuilder.build());

        assertEquals(uniqueCollectionName, createResponse.getName());
    }

    @Test
    public void delete_collection_is_successful() {
        CreateConfigurationResponse createConfigResponse = createTestConfig();

        String uniqueCollectionName = uniqueName + "-collection";
        CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder(environmentId,
                createConfigResponse.getConfigurationId(), uniqueCollectionName);
        CreateCollectionResponse createResponse = createCollection(createCollectionBuilder.build());

        //need to wait for collection to be ready

        DeleteCollectionRequest deleteRequest = new DeleteCollectionRequest.Builder(environmentId,
                createResponse.getCollectionId()).build();
        DeleteCollectionResponse deleteResponse = deleteCollection(deleteRequest);

        assertEquals("deleted", deleteResponse.getStatus());
    }

    @Test
    public void get_collection_is_successful() {
        CreateConfigurationResponse createConfigResponse = createTestConfig();

        String uniqueCollectionName = uniqueName + "-collection";
        CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder(environmentId,
                createConfigResponse.getConfigurationId(), uniqueCollectionName);
        CreateCollectionResponse createResponse = createCollection(createCollectionBuilder.build());

        GetCollectionRequest getRequest = new GetCollectionRequest.Builder(environmentId,
                createResponse.getCollectionId()).build();

        //need to wait for collection to be ready

        GetCollectionResponse getResponse = discovery.getCollection(getRequest).execute();

        assertEquals(createResponse.getName(), getResponse.getName());
    }

    @Test
    public void get_collections_by_name_is_successful() {
        CreateConfigurationResponse createConfigResponse = createTestConfig();

        String uniqueCollectionName = uniqueName + "-collection";
        CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder(environmentId,
                createConfigResponse.getConfigurationId(), uniqueCollectionName);
        createCollection(createCollectionBuilder.build());

        GetCollectionsRequest.Builder getBuilder = new GetCollectionsRequest.Builder(environmentId);
        getBuilder.name(uniqueCollectionName);
        GetCollectionsResponse getResponse = discovery.getCollections(getBuilder.build()).execute();

        assertEquals(1, getResponse.getCollections().size());
        assertEquals(uniqueCollectionName, getResponse.getCollections().get(0).getName());
    }

    @Test
    public void create_document_is_successful() {
        CreateCollectionResponse createCollectionResponse = createTestCollection();

        String myDocumentJson = "{\"field\":\"value\"}";
        InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());

        CreateDocumentRequest.Builder builder = new CreateDocumentRequest.Builder(environmentId,
                createCollectionResponse.getCollectionId());
        builder.inputStream(documentStream, HttpMediaType.APPLICATION_JSON);


        CreateDocumentResponse createResponse = discovery.createDocument(builder.build()).execute();
        assertFalse(createResponse.getDocumentId().isEmpty());
        assertNull(createResponse.getNotices());
    }

    @Test
    public void delete_document_is_successful() {
        CreateCollectionResponse createCollectionResponse = createTestCollection();
        String collectionId = createCollectionResponse.getCollectionId();
        CreateDocumentResponse createDocumentResponse = createTestDocument(collectionId);

        DeleteDocumentRequest deleteRequest = new DeleteDocumentRequest.Builder(environmentId, collectionId,
                createDocumentResponse.getDocumentId()).build();
        DeleteDocumentResponse deleteResponse = discovery.deleteDocument(deleteRequest).execute();
        assertEquals("deleted", deleteResponse.getStatus());
    }

    @Test
    public void get_document_is_successful() {
        CreateCollectionResponse createCollectionResponse = createTestCollection();
        String collectionId = createCollectionResponse.getCollectionId();
        CreateDocumentResponse createDocumentResponse = createTestDocument(collectionId);

        //TODO need to poll for document to be accepted
        GetDocumentRequest getRequest = new GetDocumentRequest.Builder(environmentId, collectionId, createDocumentResponse.getDocumentId()).build();
        GetDocumentResponse getResponse = discovery.getDocument(getRequest).execute();

        assertEquals("available", getResponse.getStatus());
    }

    @Test
    public void update_document_is_successful() {
        CreateCollectionResponse createCollectionResponse = createTestCollection();
        String collectionId = createCollectionResponse.getCollectionId();
        CreateDocumentResponse createDocumentResponse = createTestDocument(collectionId);

        UpdateDocumentRequest.Builder updateBuilder = new UpdateDocumentRequest.Builder(environmentId, collectionId,
                createDocumentResponse.getDocumentId());
        String myDocumentJson = "{\"field\":\"value2\"}";
        InputStream documentStream = new ByteArrayInputStream(myDocumentJson.getBytes());
        updateBuilder.inputStream(documentStream, HttpMediaType.APPLICATION_JSON);
        UpdateDocumentResponse updateResponse = discovery.updateDocument(updateBuilder.build()).execute();

        //TODO need to poll for document to be accepted
        GetDocumentRequest getRequest = new GetDocumentRequest.Builder(environmentId, collectionId, updateResponse.getDocumentId()).build();
        GetDocumentResponse getResponse = discovery.getDocument(getRequest).execute();

        assertEquals("available", getResponse.getStatus());
    }

    @Test
    public void get_collection_fields_is_successful() {
        CreateCollectionResponse createCollectionResponse = createTestCollection();
        String collectionId = createCollectionResponse.getCollectionId();
        CreateDocumentResponse createDocumentResponse = createTestDocument(collectionId);

        //TODO need to poll for document to be accepted

        GetCollectionFieldsRequest getRequest = new GetCollectionFieldsRequest.Builder(environmentId, collectionId)
                .build();
        GetCollectionFieldsResponse getResponse = discovery.getCollectionFields(getRequest).execute();

        assertEquals(1, getResponse.getFields().size());
    }

    @Test
    public void query_with_count_is_successful() {
        String collectionId = setupTestDocuments();

        QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
        queryBuilder.count(5);
        QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
        assertEquals(new Long(10), queryResponse.getMatchingResults());
        assertEquals(5, queryResponse.getResults().size());
    }

    @Test
    public void query_with_offset_is_successful() {
        String collectionId = setupTestDocuments();

        QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
        queryBuilder.offset(5);
        QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
        assertEquals(new Long(10), queryResponse.getMatchingResults());
        assertEquals(5, queryResponse.getResults().size());
    }

    @Test
    public void query_with_return_fields_is_successful() {
        String collectionId = setupTestDocuments();
        createTestDocument("{\"field_2\":\"value_2\"}", collectionId);

        QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
        Set<String> fieldNames = new HashSet<String>();
        fieldNames.add("field");
        queryBuilder.returnFields(fieldNames);
        QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
        String[] expected = new String[]{"id", "score", "field"};
        assertArrayEquals(expected, queryResponse.getResults().get(0).keySet().toArray());
    }

    @Test
    public void query_with_query_is_successful() {
        String collectionId = setupTestDocuments();

        QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
        queryBuilder.query("field" + Operator.CONTAINS + 1);
        QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
        assertEquals(new Long(1), queryResponse.getMatchingResults());
        assertEquals(1, queryResponse.getResults().size());
        assertTrue((double) queryResponse.getResults().get(0).get("score") > 1.0);
    }

    @Test
    public void query_with_filter_is_successful() {
        String collectionId = setupTestDocuments();

        QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
        queryBuilder.filter("field" + Operator.CONTAINS + 1);
        QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
        assertEquals(new Long(1), queryResponse.getMatchingResults());
        assertEquals(1, queryResponse.getResults().size());
        assertEquals(new Double(1.0), (Double) queryResponse.getResults().get(0).get("score"));
    }

    @Test
    public void query_with_aggregation_term_is_successful() {
        String collectionId = setupTestDocuments();

        QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
        StringBuilder sb = new StringBuilder();
        sb.append(Aggregation.TERM);
        sb.append(Operator.OPENING_GROUPING);
        sb.append("field");
        sb.append(Operator.CLOSING_GROUPING);
        String aggregation = sb.toString();
        queryBuilder.aggregation(aggregation);
        QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
        assertEquals(1, queryResponse.getAggregations().size());
    }

    @Test
    public void query_with_nested_aggregation_term_is_successful() {
        String collectionId = setupTestDocuments();

        QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
        StringBuilder sb = new StringBuilder();
        sb.append(Aggregation.TERM);
        sb.append(Operator.OPENING_GROUPING);
        sb.append("field");
        sb.append(Operator.CLOSING_GROUPING);
        sb.append(Operator.NEST_AGGREGATION);
        sb.append(Aggregation.TERM);
        sb.append(Operator.OPENING_GROUPING);
        sb.append("field");
        sb.append(Operator.CLOSING_GROUPING);
        String aggregation = sb.toString();
        queryBuilder.aggregation(aggregation);
        QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
        Term term = (Term) queryResponse.getAggregations().get(0);
        assertFalse(term.getResults().get(0).getAggregations().isEmpty());
    }

    @Test
    public void query_with_aggregation_histogram_is_successful() throws InterruptedException {
        String collectionName = setupTestDocuments();

        QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionName);
        StringBuilder sb = new StringBuilder();
        sb.append(Aggregation.HISTOGRAM);
        sb.append(Operator.OPENING_GROUPING);
        sb.append("field");
        sb.append(Operator.AND);
        sb.append(5);
        sb.append(Operator.CLOSING_GROUPING);
        String aggregation = sb.toString();
        queryBuilder.aggregation(aggregation);
        QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
        Histogram histogram = (Histogram) queryResponse.getAggregations().get(0);
        assertEquals(5, histogram.getInterval());
        assertEquals(2, histogram.getResults().size());
    }

    @Test
    public void query_with_aggregation_maximum_is_successful() throws InterruptedException {
        String collectionName = setupTestDocuments();

        QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionName);
        StringBuilder sb = new StringBuilder();
        sb.append(Aggregation.MAX);
        sb.append(Operator.OPENING_GROUPING);
        sb.append("field");
        sb.append(Operator.CLOSING_GROUPING);
        String aggregation = sb.toString();
        queryBuilder.aggregation(aggregation);
        QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
        Calculation max = (Calculation) queryResponse.getAggregations().get(0);
        assertEquals(Aggregation.MAX.getName(), max.getType());
        assertEquals(new Double(9), max.getValue());
    }

    @Test
    public void query_with_aggregation_minimum_is_successful() throws InterruptedException {
        String collectionName = setupTestDocuments();

        QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionName);
        StringBuilder sb = new StringBuilder();
        sb.append(Aggregation.MIN);
        sb.append(Operator.OPENING_GROUPING);
        sb.append("field");
        sb.append(Operator.CLOSING_GROUPING);
        String aggregation = sb.toString();
        queryBuilder.aggregation(aggregation);
        QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
        Calculation min = (Calculation) queryResponse.getAggregations().get(0);
        assertEquals(Aggregation.MIN.getName(), min.getType());
        assertEquals(new Double(0), min.getValue());
    }

    @Test
    public void query_with_aggregation_summation_is_successful() throws InterruptedException {
        String collectionName = setupTestDocuments();

        QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionName);
        StringBuilder sb = new StringBuilder();
        sb.append(Aggregation.SUM);
        sb.append(Operator.OPENING_GROUPING);
        sb.append("field");
        sb.append(Operator.CLOSING_GROUPING);
        String aggregation = sb.toString();
        queryBuilder.aggregation(aggregation);
        QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
        Calculation sum = (Calculation) queryResponse.getAggregations().get(0);
        assertEquals(Aggregation.SUM.getName(), sum.getType());
        assertEquals(new Double(45), sum.getValue());
    }

    @Test
    public void query_with_aggregation_average_is_successful() throws InterruptedException {
        String collectionName = setupTestDocuments();

        QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionName);
        StringBuilder sb = new StringBuilder();
        sb.append(Aggregation.AVERAGE);
        sb.append(Operator.OPENING_GROUPING);
        sb.append("field");
        sb.append(Operator.CLOSING_GROUPING);
        String aggregation = sb.toString();
        queryBuilder.aggregation(aggregation);
        QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
        Calculation avg = (Calculation) queryResponse.getAggregations().get(0);
        assertEquals(Aggregation.AVERAGE.getName(), avg.getType());
        assertEquals(new Double(4.5), avg.getValue());
    }

    private CreateEnvironmentResponse createEnvironment(CreateEnvironmentRequest createRequest) {
        CreateEnvironmentResponse createResponse = discovery.createEnvironment(createRequest).execute();
        return createResponse;
    }

    private DeleteEnvironmentResponse deleteEnvironment(DeleteEnvironmentRequest deleteRequest) {
        DeleteEnvironmentResponse deleteResponse = discovery.deleteEnvironment(deleteRequest).execute();
        return deleteResponse;
    }

    private CreateConfigurationResponse createConfiguration(CreateConfigurationRequest createRequest) {
        CreateConfigurationResponse createResponse = discovery.createConfiguration(createRequest).execute();
        return createResponse;
    }

    private DeleteConfigurationResponse deleteConfiguration(DeleteConfigurationRequest deleteRequest) {
        DeleteConfigurationResponse deleteResponse = discovery.deleteConfiguration(deleteRequest).execute();
        return deleteResponse;
    }

    private CreateConfigurationResponse createTestConfig() {
        String uniqueConfigName = uniqueName + "-config";
        CreateConfigurationRequest.Builder createBuilder = new CreateConfigurationRequest.Builder(environmentId);
        Configuration configuration = getTestConfiguration();
        configuration.setName(uniqueConfigName);
        createBuilder.configuration(configuration);
        return createConfiguration(createBuilder.build());
    }

    private CreateCollectionResponse createCollection(CreateCollectionRequest createRequest) {
        CreateCollectionResponse createResponse = discovery.createCollection(createRequest).execute();
        return createResponse;
    }

    private DeleteCollectionResponse deleteCollection(DeleteCollectionRequest deleteRequest) {
        DeleteCollectionResponse deleteResponse = discovery.deleteCollection(deleteRequest).execute();
        return deleteResponse;
    }

    private CreateCollectionResponse createTestCollection() {
        CreateConfigurationResponse createConfigResponse = createTestConfig();

        String uniqueCollectionName = uniqueName + "-collection";
        CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder(environmentId,
                createConfigResponse.getConfigurationId(), uniqueCollectionName);
        CreateCollectionResponse createResponse = createCollection(createCollectionBuilder.build());
        return createResponse;
    }

    private CreateDocumentResponse createTestDocument(String collectionId) {
        String myDocumentJson = "{\"field\":\"value\"}";
        return createTestDocument(myDocumentJson, collectionId);
    }

    private CreateDocumentResponse createTestDocument(String json, String collectionId) {
        InputStream documentStream = new ByteArrayInputStream(json.getBytes());
        CreateDocumentRequest.Builder builder = new CreateDocumentRequest.Builder(environmentId, collectionId);
        builder.inputStream(documentStream, HttpMediaType.APPLICATION_JSON);
        CreateDocumentResponse createResponse = discovery.createDocument(builder.build()).execute();
        return createResponse;
    }

    private List<CreateDocumentResponse> createTestDocuments(String collectionId, int totalDocuments) {
        List<CreateDocumentResponse> responses = new ArrayList<CreateDocumentResponse>();
        String baseDocumentJson = "{\"field\":";
        for (int i = 0; i < totalDocuments; i++) {
            String json = baseDocumentJson + i + "}";
            responses.add(createTestDocument(json, collectionId));
        }
        return responses;
    }

    private String setupTestDocuments() {
        CreateCollectionResponse createCollectionResponse = createTestCollection();
        String collectionId = createCollectionResponse.getCollectionId();
        List<CreateDocumentResponse> createDocumentResponses = createTestDocuments(collectionId, 10);
        return collectionId;
    }

    public static Configuration getTestConfiguration() {
        try {
            return GsonSingleton.getGson().fromJson(new FileReader(DISCOVERY_TEST_CONFIG_FILE), Configuration.class);
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}

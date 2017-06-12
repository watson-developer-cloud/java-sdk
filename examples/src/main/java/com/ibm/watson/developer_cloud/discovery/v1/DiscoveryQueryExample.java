/**
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

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.ibm.watson.developer_cloud.discovery.v1.model.collection.CreateCollectionRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.CreateCollectionResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.DeleteCollectionRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.GetCollectionRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.GetCollectionResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.common.Status;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.Configuration;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.GetConfigurationsRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.GetConfigurationsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.CreateDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.CreateDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.Document;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.GetDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.GetDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.CreateEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.CreateEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.Environment;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentsRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryResponse;
import com.ibm.watson.developer_cloud.http.HttpMediaType;

/**
 * End-to-end example for querying Discovery.
 */
public class DiscoveryQueryExample {
    private static final String DEFAULT_CONFIG_NAME = "Default Configuration";

    public static void main(String[] args) {
        Discovery discovery = new Discovery("2016-12-15");
        discovery.setEndPoint("https://gateway.watsonplatform.net/discovery/api");
        discovery.setUsernameAndPassword("<username>", "<password");
        String environmentId = null;
        String configurationId = null;
        String collectionId = null;
        String documentId = null;

        //See if an environment already exists
        System.out.println("Check if environment exists");
        ListEnvironmentsOptions listOptions = new ListEnvironmentsOptions.Builder().build();
        ListEnvironmentsResponse listResponse = discovery.listEnvironments(listOptions).execute();
        for (Environment environment : listResponse.getEnvironments()) {
            //look for an existing environment that isn't read only
            if (!environment.isReadOnly()) {
                environmentId = environment.getEnvironmentId();
                System.out.println("Found existing environment ID: " + environmentId);
                break;
            }
        }

        if (environmentId == null) {
            System.out.println("No environment found, creating new one...");
            //no environment found, create a new one (assuming we are a FREE plan)
            String environmentName = "watson_developer_cloud_test_environment";
            CreateEnvironmentOptions createOptions = new CreateEnvironmentOptions.Builder()
                .name(environmentName)
                .size(0L)  /* FREE */
                .build();
            Environment createResponse = discovery.createEnvironment(createOptions).execute();
            environmentId = createResponse.getEnvironmentId();
            System.out.println("Created new environment ID: " + environmentId);

            //wait for environment to be ready
            System.out.println("Waiting for environment to be ready...");
            boolean environmentReady = false;
            while (!environmentReady) {
                GetEnvironmentOptions getEnvironmentOptions = new GetEnvironmentOptions.Builder(environmentId).build();
                Environment getEnvironmentResponse = discovery.getEnvironment(getEnvironmentOptions).execute();
                environmentReady = getEnvironmentResponse.getStatus().equals(Environment.Status.ACTIVE);
                try {
                    if (!environmentReady) {
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException("Interrupted", e);
                }
            }
            System.out.println("Environment Ready!");
        }

        //find the default configuration
        System.out.println("Finding the default configuration");
        ListConfigurationsOptions listConfigsOptions = new ListConfigurationsOptions.Builder(environmentId).build();
        ListConfigurationsResponse listConfigsResponse = discovery.listConfigurations(listConfigsOptions).execute();
        for (Configuration configuration : listConfigsResponse.getConfigurations()) {
            if (configuration.getName().equals(DEFAULT_CONFIG_NAME)) {
                configurationId = configuration.getConfigurationId();
                System.out.println("Found default configuration ID: " + configurationId);
                break;
            }
        }

        //create a new collection
        System.out.println("Creating a new collection...");
        String collectionName = "my_watson_developer_cloud_collection";
        CreateCollectionOptions createCollectionOptions =
            new CreateCollectionOptions.Builder(environmentId, collectionName).configurationId(configurationId).build();
        Collection collection = discovery.createCollection(createCollectionOptions).execute();
        collectionId = collection.getCollectionId();
        System.out.println("Created a collection ID: " + collectionId);

        //wait for the collection to be "available"
        System.out.println("Waiting for collection to be ready...");
        boolean collectionReady = false;
        while (!collectionReady) {
            GetCollectionOptions getCollectionOptions =
                new GetCollectionOptions.Builder(environmentId, collectionId).build();
            Collection getCollectionResponse = discovery.getCollection(getCollectionOptions).execute();
            collectionReady = getCollectionResponse.getStatus().equals(Collection.Status.ACTIVE);
            try {
                if (!collectionReady) {
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted", e);
            }
        }
        System.out.println("Collection Ready!");

        //add a document
        System.out.println("Creating a new document...");
        String documentJson = "{\"field\":\"value\"}";
        InputStream documentStream = new ByteArrayInputStream(documentJson.getBytes());

        AddDocumentOptions.Builder createDocumentBuilder =
            new AddDocumentOptions.Builder(environmentId, collectionId);
        createDocumentBuilder.file(documentStream).fileMediaType(HttpMediaType.APPLICATION_JSON);
        DocumentAccepted createDocumentResponse = discovery.addDocument(createDocumentBuilder.build()).execute();
        documentId = createDocumentResponse.getDocumentId();
        System.out.println("Created a document ID: " + documentId);

        //wait for document to be ready
        System.out.println("Waiting for document to be ready...");
        boolean documentReady = false;
        while (!documentReady) {
            GetDocumentStatusOptions getDocumentStatusOptions =
                new GetDocumentStatusOptions.Builder(environmentId, collectionId, documentId).build();
            DocumentStatus getDocumentResponse = discovery.getDocument(getDocumentStatusOptions).execute();
            documentReady = !getDocumentResponse.getStatus().equals(DocumentStatus.Status.PROCESSING);
            try {
                if (!documentReady) {
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted");
            }
        }
        System.out.println("Document Ready!");

        //query document
        System.out.println("Querying the collection...");
        QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
        queryBuilder.query("field:value");
        QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();

        //print out the results
        System.out.println("Query Results:");
        System.out.println(queryResponse);

        //cleanup the collection created
        System.out.println("Deleting the collection...");
        DeleteCollectionOptions deleteOptions =
            new DeleteCollectionOptions.Builder(environmentId, collectionId).build();
        discovery.deleteCollection(deleteOptions).execute();
        System.out.println("Collection deleted!");

        System.out.println("Discovery example finished");
    }
}

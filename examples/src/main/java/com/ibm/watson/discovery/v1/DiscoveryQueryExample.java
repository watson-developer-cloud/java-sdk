/*
 * (C) Copyright IBM Corp. 2019, 2020.
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

import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.discovery.v1.model.AddDocumentOptions;
import com.ibm.watson.discovery.v1.model.Collection;
import com.ibm.watson.discovery.v1.model.Configuration;
import com.ibm.watson.discovery.v1.model.CreateCollectionOptions;
import com.ibm.watson.discovery.v1.model.CreateEnvironmentOptions;
import com.ibm.watson.discovery.v1.model.DeleteCollectionOptions;
import com.ibm.watson.discovery.v1.model.DocumentAccepted;
import com.ibm.watson.discovery.v1.model.DocumentStatus;
import com.ibm.watson.discovery.v1.model.Environment;
import com.ibm.watson.discovery.v1.model.GetCollectionOptions;
import com.ibm.watson.discovery.v1.model.GetDocumentStatusOptions;
import com.ibm.watson.discovery.v1.model.GetEnvironmentOptions;
import com.ibm.watson.discovery.v1.model.ListConfigurationsOptions;
import com.ibm.watson.discovery.v1.model.ListConfigurationsResponse;
import com.ibm.watson.discovery.v1.model.ListEnvironmentsOptions;
import com.ibm.watson.discovery.v1.model.ListEnvironmentsResponse;
import com.ibm.watson.discovery.v1.model.QueryOptions;
import com.ibm.watson.discovery.v1.model.QueryResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/** End-to-end example for querying Discovery. */
public class DiscoveryQueryExample {
  private static final String DEFAULT_CONFIG_NAME = "Default Configuration";

  public static void main(String[] args) {
    Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
    Discovery discovery = new Discovery("2019-04-30", authenticator);

    String environmentId = null;
    String configurationId = null;
    String collectionId = null;
    String documentId = null;

    // See if an environment already exists
    System.out.println("Check if environment exists");
    ListEnvironmentsOptions listOptions = new ListEnvironmentsOptions.Builder().build();
    ListEnvironmentsResponse listResponse =
        discovery.listEnvironments(listOptions).execute().getResult();
    for (Environment environment : listResponse.getEnvironments()) {
      // look for an existing environment that isn't read only
      if (!environment.isReadOnly()) {
        environmentId = environment.getEnvironmentId();
        System.out.println("Found existing environment ID: " + environmentId);
        break;
      }
    }

    if (environmentId == null) {
      System.out.println("No environment found, creating new one...");
      // no environment found, create a new one (assuming we are a FREE plan)
      String environmentName = "watson_developer_cloud_test_environment";
      CreateEnvironmentOptions createOptions =
          new CreateEnvironmentOptions.Builder().name(environmentName).size(0L) /* FREE */.build();
      Environment createResponse = discovery.createEnvironment(createOptions).execute().getResult();
      environmentId = createResponse.getEnvironmentId();
      System.out.println("Created new environment ID: " + environmentId);

      // wait for environment to be ready
      System.out.println("Waiting for environment to be ready...");
      boolean environmentReady = false;
      while (!environmentReady) {
        GetEnvironmentOptions getEnvironmentOptions =
            new GetEnvironmentOptions.Builder(environmentId).build();
        Environment getEnvironmentResponse =
            discovery.getEnvironment(getEnvironmentOptions).execute().getResult();
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

    // find the default configuration
    System.out.println("Finding the default configuration");
    ListConfigurationsOptions listConfigsOptions =
        new ListConfigurationsOptions.Builder(environmentId).build();
    ListConfigurationsResponse listConfigsResponse =
        discovery.listConfigurations(listConfigsOptions).execute().getResult();
    for (Configuration configuration : listConfigsResponse.getConfigurations()) {
      if (configuration.getName().equals(DEFAULT_CONFIG_NAME)) {
        configurationId = configuration.getConfigurationId();
        System.out.println("Found default configuration ID: " + configurationId);
        break;
      }
    }

    // create a new collection
    System.out.println("Creating a new collection...");
    String collectionName = "my_watson_developer_cloud_collection";
    CreateCollectionOptions createCollectionOptions =
        new CreateCollectionOptions.Builder(environmentId, collectionName)
            .configurationId(configurationId)
            .build();
    Collection collection =
        discovery.createCollection(createCollectionOptions).execute().getResult();
    collectionId = collection.getCollectionId();
    System.out.println("Created a collection ID: " + collectionId);

    // wait for the collection to be "available"
    System.out.println("Waiting for collection to be ready...");
    boolean collectionReady = false;
    while (!collectionReady) {
      GetCollectionOptions getCollectionOptions =
          new GetCollectionOptions.Builder(environmentId, collectionId).build();
      Collection getCollectionResponse =
          discovery.getCollection(getCollectionOptions).execute().getResult();
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

    // add a document
    System.out.println("Creating a new document...");
    String documentJson = "{\"field\":\"value\"}";
    InputStream documentStream = new ByteArrayInputStream(documentJson.getBytes());

    AddDocumentOptions.Builder createDocumentBuilder =
        new AddDocumentOptions.Builder(environmentId, collectionId);
    createDocumentBuilder.file(documentStream).fileContentType(HttpMediaType.APPLICATION_JSON);
    DocumentAccepted createDocumentResponse =
        discovery.addDocument(createDocumentBuilder.build()).execute().getResult();
    documentId = createDocumentResponse.getDocumentId();
    System.out.println("Created a document ID: " + documentId);

    // wait for document to be ready
    System.out.println("Waiting for document to be ready...");
    boolean documentReady = false;
    while (!documentReady) {
      GetDocumentStatusOptions getDocumentStatusOptions =
          new GetDocumentStatusOptions.Builder(environmentId, collectionId, documentId).build();
      DocumentStatus getDocumentResponse =
          discovery.getDocumentStatus(getDocumentStatusOptions).execute().getResult();
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

    // query document
    System.out.println("Querying the collection...");
    QueryOptions.Builder queryBuilder = new QueryOptions.Builder(environmentId, collectionId);
    queryBuilder.query("field:value");
    QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute().getResult();

    // print out the results
    System.out.println("Query Results:");
    System.out.println(queryResponse);

    // cleanup the collection created
    System.out.println("Deleting the collection...");
    DeleteCollectionOptions deleteOptions =
        new DeleteCollectionOptions.Builder(environmentId, collectionId).build();
    discovery.deleteCollection(deleteOptions).execute();
    System.out.println("Collection deleted!");

    System.out.println("Discovery example finished");
  }
}

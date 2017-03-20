/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.watson.developer_cloud.retrieve_and_rank;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpCoreContext;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.CollectionAdminRequest;
import org.apache.solr.client.solrj.response.CollectionAdminResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.RetrieveAndRank;

/**
 * The Class RetrieveAndRankSolrJExample.
 */
public class RetrieveAndRankSolrJExample {

  private static final String USERNAME = "<username>";
  private static final String PASSWORD = "<password>";
  private static final String SOLR_CLUSTER_ID = "<your-solr-cluster-id>";

  /**
   * The name of the collection to create, index data into, and search.
   */
  private static final String COLLECTION_NAME = "retrieve_and_rank_example_collection";

  /**
   * The name of the configuration to use to create the collection. This example uploads the
   * configuration with this name and then later creates the collection referencing the
   * configuration's name.
   */
  private static final String CONFIG_NAME = "retrieve_and_rank_example_config";

  /**
   * The location of the solrconfig.xml and schema.xml configuration files to upload.
   */
  private static final String CONFIG_DIRECTORY = "<path-to-your-solr-configuration-files>";

  private static final String ID_FIELD = "id";
  private static final String ID_VALUE = "ID_VALUE";
  private static final String HELLO_FIELD_NAME = "HELLO_FIELD_NAME_s";
  private static final String HELLO_FIELD_VALUE = "HELLO WORLD!";
  private static final String QUERY_MATCHING_ANY_DOCUMENT = "*:*";

  private static HttpSolrClient solrClient;
  private static RetrieveAndRank service;

  /**
   * The main method.
   * 
   * @param args the arguments
   * @throws SolrServerException the solr server exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static void main(String[] args) throws SolrServerException, IOException {
    service = new RetrieveAndRank();
    service.setUsernameAndPassword(USERNAME, PASSWORD);
    solrClient = getSolrClient(service.getSolrUrl(SOLR_CLUSTER_ID), USERNAME, PASSWORD);

    try {
      uploadConfiguration();
      createCollection();
      indexDocumentAndCommit();
      searchAllDocs();
    } catch (final Exception e) {
      e.printStackTrace();
    } finally {
      cleanupResources();
    }
  }

  private static HttpSolrClient getSolrClient(String uri, String username, String password) {
    return new HttpSolrClient(service.getSolrUrl(SOLR_CLUSTER_ID), createHttpClient(uri, username, password));
  }

  private static HttpClient createHttpClient(String uri, String username, String password) {
    final URI scopeUri = URI.create(uri);

    final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    credentialsProvider.setCredentials(new AuthScope(scopeUri.getHost(), scopeUri.getPort()),
        new UsernamePasswordCredentials(username, password));

    final HttpClientBuilder builder = HttpClientBuilder.create()
        .setMaxConnTotal(128)
        .setMaxConnPerRoute(32)
        .setDefaultRequestConfig(RequestConfig.copy(RequestConfig.DEFAULT).setRedirectsEnabled(true).build())
        .setDefaultCredentialsProvider(credentialsProvider)
        .addInterceptorFirst(new PreemptiveAuthInterceptor());
    return builder.build();
  }

  /**
   * Upload the collection configuration from the local filesystem.
   * 
   * This is a retrieve-and-rank API as solrj does not offer a programmatic API to upload
   * configuration.
   */
  private static void uploadConfiguration() {
    System.out.println("Uploading configuration...");
    service.uploadSolrClusterConfigurationDirectory(SOLR_CLUSTER_ID, CONFIG_NAME, new File(
        CONFIG_DIRECTORY)).execute();
    System.out.println("Uploaded configuration.");
  }

  /**
   * Create the collection referencing the name of the configuration that was previously uploaded.
   */
  private static void createCollection() throws SolrServerException, IOException {
    final CollectionAdminRequest.Create createCollectionRequest =
        new CollectionAdminRequest.Create();
    createCollectionRequest.setCollectionName(COLLECTION_NAME);
    createCollectionRequest.setConfigName(CONFIG_NAME);

    System.out.println("Creating collection...");
    final CollectionAdminResponse response = createCollectionRequest.process(solrClient);
    if (!response.isSuccess()) {
      System.out.println(response.getErrorMessages());
      throw new IllegalStateException("Failed to create collection: "
          + response.getErrorMessages().toString());
    }
    System.out.println("Collection created.");
  }

  /**
   * Index a simple document with an ID and field mapped to the configuration uploaded earlier.
   */
  private static void indexDocumentAndCommit() throws SolrServerException, IOException {
    final SolrInputDocument document = new SolrInputDocument();
    document.addField(ID_FIELD, ID_VALUE);
    document.addField(HELLO_FIELD_NAME, HELLO_FIELD_VALUE);

    System.out.println("Indexing document...");
    final UpdateResponse addResponse = solrClient.add(COLLECTION_NAME, document);
    System.out.println(addResponse);

    // Commit the document to the index so that it will be available for searching.
    solrClient.commit(COLLECTION_NAME);
    System.out.println("Indexed document.");
  }

  /**
   * Search for the document indexed earlier.
   */
  private static void searchAllDocs() throws IOException {
    System.out.println("Searching for document...");
    final SolrQuery query = new SolrQuery(QUERY_MATCHING_ANY_DOCUMENT);
    try {
      final QueryResponse response = solrClient.query(COLLECTION_NAME, query);
      System.out.println("Found " + response.getResults().size() + " documents!");
      System.out.println(response);
    } catch (final SolrServerException e) {
      throw new RuntimeException("Failed to search!", e);
    }

  }

  /**
   * Cleanup the resources created via the example.
   */
  private static void cleanupResources() throws SolrServerException, IOException {
    try {
      final CollectionAdminRequest.Delete deleteCollectionRequest =
          new CollectionAdminRequest.Delete();
      deleteCollectionRequest.setCollectionName(COLLECTION_NAME);

      System.out.println("Deleting collection...");
      deleteCollectionRequest.process(solrClient);
      System.out.println("Collection deleted.");
    } finally {
      try {
        System.out.println("Deleting configuration...");
        service.deleteSolrClusterConfiguration(SOLR_CLUSTER_ID, CONFIG_NAME).execute();
        System.out.println("Configuration deleted.");
      } finally {
        System.out.println("Closing Solr client...");
        solrClient.close();
        System.out.println("Clients closed.");
      }
    }
  }

  private static class PreemptiveAuthInterceptor implements HttpRequestInterceptor {
    public void process(final HttpRequest request, final HttpContext context) throws HttpException {
      final AuthState authState = (AuthState) context.getAttribute(HttpClientContext.TARGET_AUTH_STATE);

      if (authState.getAuthScheme() == null) {
        final CredentialsProvider credsProvider = (CredentialsProvider) context
            .getAttribute(HttpClientContext.CREDS_PROVIDER);
        final HttpHost targetHost = (HttpHost) context.getAttribute(HttpCoreContext.HTTP_TARGET_HOST);
        final Credentials creds = credsProvider.getCredentials(new AuthScope(targetHost.getHostName(),
            targetHost.getPort()));
        if (creds == null) {
          throw new HttpException("No creds provided for preemptive auth.");
        }
        authState.update(new BasicScheme(), creds);
      }
    }
  }
}

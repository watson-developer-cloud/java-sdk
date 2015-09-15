/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package java.com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.request.CollectionAdminRequest;
import org.apache.solr.client.solrj.response.CollectionAdminResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.HttpSolrConfigManager;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.RetrieveAndRankSolrClient;

public class RetrieveAndRankSolrHttpClientExample {
    /**
     * The URL of the Watson Solr search service.
     * <p>
     * You must first create a Solr cluster and specify its ID here. A Solr cluster can be created with the
     * {@link RetrieveAndRankSolrClusterCreateAndListExample}.
     */
    private static final String SERVICE_URL =
            "{your-base-url}/retrieve-and-rank/api/v1/solr_clusters/{your-cluster-id}";

    /**
     * The username for your Watson Solr search service.
     */
    private static final String USERNAME = "your-username";

    /**
     * The password for your Watson Solr search service.
     */
    private static final String PASSWORD = "your-password";

    /**
     * The name of the collection to create, index data into, and search.
     */
    private static final String COLLECTION_NAME = "watson_solr_client_example_collection";

    /**
     * The name of the configuration to use to create the collection. This example uploads the configuration with this
     * name and then later creates the collection referencing the configuration's name.
     */
    private static final String CONFIG_NAME = "test_config";

    /**
     * The location of the Solr collection configuration files to upload.
     */
    private static final String CONFIG_DIRECTORY = "your-configuration-directory";

    private static final String QUERY_MATCHING_ANY_DOCUMENT = "*:*";

    private static final String ID_FIELD = "id";
    private static final String ID_VALUE = "ID_VALUE";
    private static final String HELLO_FIELD_NAME = "HELLO_FIELD_NAME_s";
    private static final String HELLO_FIELD_VALUE = "HELLO WORLD!";

    private static RetrieveAndRankSolrClient watsonSolrClient;
    private static HttpSolrConfigManager solrConfigManager;

    public static void main(String[] args) throws SolrServerException, IOException {
        watsonSolrClient = new RetrieveAndRankSolrClient(URI.create(SERVICE_URL), USERNAME, PASSWORD);
        solrConfigManager = new HttpSolrConfigManager(URI.create(SERVICE_URL), USERNAME, PASSWORD);

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

    /**
     * Upload the collection configuration from the local filesystem.
     *
     * This is a watson-solr-client API as solrj does not offer a programmatic API to upload configuration.
     */
    private static void uploadConfiguration() {
        System.out.println("Uploading configuration...");
        solrConfigManager.uploadConfigurationDirectory(CONFIG_NAME, new File(CONFIG_DIRECTORY));
        System.out.println("Uploaded configuration.");
    }

    /**
     * Create the collection referencing the name of the configuration that was previously uploaded.
     */
    private static void createCollection() throws SolrServerException, IOException {
        final CollectionAdminRequest.Create createCollectionRequest = new CollectionAdminRequest.Create();
        createCollectionRequest.setCollectionName(COLLECTION_NAME);
        createCollectionRequest.setConfigName(CONFIG_NAME);

        System.out.println("Creating collection...");
        final CollectionAdminResponse response = createCollectionRequest.process(watsonSolrClient);
        if (!response.isSuccess()) {
            throw new IllegalStateException("Failed to create collection: " + response.getErrorMessages().toString());
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
        final UpdateResponse addResponse = watsonSolrClient.add(COLLECTION_NAME, document);
        System.out.println(addResponse);

        // Commit the document to the index so that it will be available for searching.
        watsonSolrClient.commit(COLLECTION_NAME);
        System.out.println("Indexed document.");
    }

    /**
     * Search for the document indexed earlier.
     */
    private static void searchAllDocs() throws IOException {
        System.out.println("Searching for document...");
        final SolrQuery query = new SolrQuery(QUERY_MATCHING_ANY_DOCUMENT);
        try {
            final QueryResponse response = watsonSolrClient.query(COLLECTION_NAME, query);
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
            final CollectionAdminRequest.Delete deleteCollectionRequest = new CollectionAdminRequest.Delete();
            deleteCollectionRequest.setCollectionName(COLLECTION_NAME);

            System.out.println("Deleting collection...");
            deleteCollectionRequest.process(watsonSolrClient);
            System.out.println("Collection deleted.");
        } finally {
            try {
                System.out.println("Deleting configuration...");
                solrConfigManager.deleteConfiguration(CONFIG_NAME);
                System.out.println("Configuration deleted.");
            } finally {
                System.out.println("Closing clients...");
                watsonSolrClient.close();
                solrConfigManager.close();
                System.out.println("Clients closed.");
            }
        }
    }

    private RetrieveAndRankSolrHttpClientExample() {
        throw new UnsupportedOperationException("WatsonSolrClientExample example cannot be instantiated!");
    }
}

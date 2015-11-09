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
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import java.io.File;

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.HttpSolrConfigManager;

public class RetrieveAndRankSolrHttpClientExample {
    /**
     * The URL of the Watson Solr search service.
     * <p>
     * You must first create a Solr cluster and specify its ID here. A Solr cluster can be created with the
     * {@link RetrieveAndRankSolrClusterCreateAndListExample}.
     */
    private static final String SERVICE_URL =
            "https://gateway.watsonplatform.net/retrieve-and-rank/api/v1/solr_clusters/{your-cluster-id}";

    /**
     * The username for your Watson Solr search service.
     */
    private static final String USERNAME = "your-username";

    /**
     * The password for your Watson Solr search service.
     */
    private static final String PASSWORD = "your-password";

    /**
     * The name of the configuration to use to create the collection. This example uploads the configuration with this
     * name and then later creates the collection referencing the configuration's name.
     */
    private static final String CONFIG_NAME = "example_config";

    /**
     * The location of the Solr collection configuration files to upload.
     */
    private static final String CONFIG_DIRECTORY =
            "examples/java/com/ibm/watson/developer_cloud/retrieve_and_rank/v1/config";

    private static HttpSolrConfigManager solrConfigManager;

    public static void main(String[] args) {
        solrConfigManager = new HttpSolrConfigManager(SERVICE_URL);
        solrConfigManager.setUsernameAndPassword(USERNAME, PASSWORD);

        uploadConfiguration();
        listConfigurations();
        deleteConfiguration();
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
     * List the collection configurations in Solr.
     *
     * This is a watson-solr-client API as solrj does not offer a programmatic API to upload configuration.
     */
    private static void listConfigurations() {
        System.out.println("Listing configurations:");
        System.out.println(solrConfigManager.listConfigurations());
    }

    /**
     * Delete the collection configuration from the Solr.
     *
     * This is a watson-solr-client API as solrj does not offer a programmatic API to upload configuration.
     */
    private static void deleteConfiguration() {
        System.out.println("Deleting configuration...");
        solrConfigManager.deleteConfiguration(CONFIG_NAME);
        System.out.println("Deleted configuration.");
    }
}

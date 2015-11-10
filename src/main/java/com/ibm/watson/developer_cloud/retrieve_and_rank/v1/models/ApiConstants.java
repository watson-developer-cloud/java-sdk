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
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.models;

/**
 * Collection of constants related to Watson Search Service's REST API.
 */
public class ApiConstants {

    private ApiConstants() {
        /* Private constructor prevents instantiation */
    }

    public static final String SOLR_CLUSTER_ID = "solr_cluster_id";
    public static final String CLUSTER_NAME = "cluster_name";
    public static final String CLUSTER_SIZE = "cluster_size";
    public static final String SOLR_CLUSTER_STATUS = "solr_cluster_status";
    public static final String SOLR_CLUSTER_RESPONSES = "clusters";
    public static final String SOLR_CLUSTERS_PATH_SEGMENT = "solr_clusters";
    public static final String SOLR_CONFIGS = "solr_configs";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String ERROR_MESSAGE = "msg";
}

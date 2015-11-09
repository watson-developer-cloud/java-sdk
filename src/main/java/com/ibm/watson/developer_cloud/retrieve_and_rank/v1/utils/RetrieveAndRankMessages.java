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
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils;

public enum RetrieveAndRankMessages implements BundleKey {
    // HttpClusterLifecycleClient
    UNABLE_TO_CLOSE_HTTP_CLIENT,

    // HttpSolrConfigManager
    CONFIG_NOT_DIR_1,

    // HttpClientFactory
    NO_CREDENTIALS_FOR_PREEMPTIVE_AUTH,

    // ClusterLifecycleRestSender
    ERROR_CREATING_CLUSTER, ERROR_CREATING_CLUSTER_1, ERROR_DELETING_CLUSTER_1, ERROR_DELETING_CLUSTER_2,
    ERROR_LISTING_CLUSTERS, ERROR_LISTING_CLUSTERS_1,
    ERROR_POLLING_CLUSTER_1, ERROR_POLLING_CLUSTER_2, ERROR_CAUSE_1,

    // SolrConfigRestSender
    FAILED_LISTING_CONFIGS, FAILED_LISTING_CONFIGS_WITH_CODE_1, FAILED_TO_DELETE_TEMP_2, FAILED_GETTING_CONFIG_1,
    FAILED_GETTING_CONFIG_WITH_CODE_2, FAILURE_RESPONSE_3,

    // ZipUtils
    ERROR_ZIPPING_1, ERROR_CREATING_ZIP_1, FAILED_TO_VISIT_1,

    // Preconditions
    NOT_NULL_1, NOT_EMPTY_1, NOT_BLANK_1, CANNOT_CONTAIN_2, AT_LEAST_3, IN_RANGE_4, BEFORE_DATE_3, AFTER_DATE_3,
    CHECK_COLLECTIONS_NULL_1, CHECK_PAIR_3;

    public static String bundleName() {
        return "RetrieveAndRankMessages";
    }
}
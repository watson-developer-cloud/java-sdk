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
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

/**
 * Collection of constants related to Watson Search Service's REST API.
 */
public class ApiConstants {

  private ApiConstants() {
    /* Private constructor prevents instantiation */
  }

  /** The Constant String SOLR_CLUSTER_ID. */
  public static final String SOLR_CLUSTER_ID = "solr_cluster_id";

  /** The Constant String CLUSTER_NAME. */
  public static final String CLUSTER_NAME = "cluster_name";

  /** The Constant String CLUSTER_SIZE. */
  public static final String CLUSTER_SIZE = "cluster_size";

  /** The Constant String SOLR_CLUSTER_STATUS. */
  public static final String SOLR_CLUSTER_STATUS = "solr_cluster_status";

  /** The Constant String SOLR_CLUSTER_RESPONSES. */
  public static final String SOLR_CLUSTER_RESPONSES = "clusters";

  /** The Constant String SOLR_CLUSTERS_PATH_SEGMENT. */
  public static final String SOLR_CLUSTERS_PATH_SEGMENT = "solr_clusters";

  /** The Constant String SOLR_CONFIGS. */
  public static final String SOLR_CONFIGS = "solr_configs";

  /** The Constant String CONTENT_TYPE. */
  public static final String CONTENT_TYPE = "Content-Type";

  /** The Constant String ERROR_MESSAGE. */
  public static final String ERROR_MESSAGE = "msg";


  /** The Constant DISK_USAGE. */
  public static final String DISK_USAGE = "disk_usage";

  /** The Constant MEMORY_USAGE. */
  public static final String MEMORY_USAGE = "memory_usage";

  /** The Constant READABLE_USED_RESOURCES. */
  public static final String READABLE_USED_RESOURCES = "used";

  /** The Constant READABLE_TOTAL_RESOURCES. */
  public static final String READABLE_TOTAL_RESOURCES = "total";

  /** The Constant USED_RESOURCES_IN_BYTES. */
  public static final String USED_RESOURCES_IN_BYTES = "used_bytes";

  /** The Constant TOTAL_RESOURCES_IN_BYTES. */
  public static final String TOTAL_RESOURCES_IN_BYTES = "total_bytes";

  /** The Constant PERCENT_USED. */
  public static final String PERCENT_USED = "percent_used";
  /** The Constant RESIZE_STATUS. */

  public static final String RESIZE_STATUS = "status";

  /** The Constant RESIZE_MESSAGE. */
  public static final String RESIZE_MESSAGE = "message";

  /** The Constant TARGET_CLUSTER_SIZE. */
  public static final String TARGET_CLUSTER_SIZE = "target_cluster_size";

  /** The Constant String CLUSTER_ID. */
  public static final String CLUSTER_ID = "cluster_id";
}

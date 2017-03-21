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
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.util;

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.RetrieveAndRank;

/**
 * The {@link RetrieveAndRank} messages.
 */
@SuppressWarnings("javadoc")
public enum Messages implements BundleKey {

  /** The unable to close http client. */
  UNABLE_TO_CLOSE_HTTP_CLIENT, /** The CONFI g_ no t_ di r_1. */
  CONFIG_NOT_DIR_1, /** The no credentials for preemptive auth. */
  NO_CREDENTIALS_FOR_PREEMPTIVE_AUTH, /** The error creating cluster. */
  ERROR_CREATING_CLUSTER, /** The ERRO r_ creatin g_ cluste r_1. */
  ERROR_CREATING_CLUSTER_1, /** The ERRO r_ deletin g_ cluste r_1. */
  ERROR_DELETING_CLUSTER_1, /** The ERRO r_ deletin g_ cluste r_2. */
  ERROR_DELETING_CLUSTER_2, /** The error listing clusters. */
  ERROR_LISTING_CLUSTERS, /** The ERRO r_ listin g_ cluster s_1. */
  ERROR_LISTING_CLUSTERS_1, /** The ERRO r_ pollin g_ cluste r_1. */
  ERROR_POLLING_CLUSTER_1, /** The ERRO r_ pollin g_ cluste r_2. */
  ERROR_POLLING_CLUSTER_2, /** The ERRO r_ caus e_1. */
  ERROR_CAUSE_1, /** The failed listing configs. */
  FAILED_LISTING_CONFIGS, /** The FAILE d_ listin g_ config s_ wit h_ cod e_1. */
  FAILED_LISTING_CONFIGS_WITH_CODE_1, /** The FAILE d_ t o_ delet e_ tem p_2. */
  FAILED_TO_DELETE_TEMP_2, /** The FAILE d_ gettin g_ confi g_1. */
  FAILED_GETTING_CONFIG_1, /** The FAILE d_ gettin g_ confi g_ wit h_ cod e_2. */
  FAILED_GETTING_CONFIG_WITH_CODE_2, /** The FAILUR e_ respons e_3. */
  FAILURE_RESPONSE_3, /** The ERRO r_ zippin g_1. */
  ERROR_ZIPPING_1, /** The ERRO r_ creatin g_ zi p_1. */
  ERROR_CREATING_ZIP_1, /** The FAILE d_ t o_ visi t_1. */
  FAILED_TO_VISIT_1, /** The ERRO r_ readin g_ fil e_1. */
  ERROR_READING_FILE_1, /** The NO t_ nul l_1. */
  NOT_NULL_1, /** The NO t_ empt y_1. */
  NOT_EMPTY_1, /** The NO t_ blan k_1. */
  NOT_BLANK_1, /** The CANNO t_ contai n_2. */
  CANNOT_CONTAIN_2, /** The A t_ leas t_3. */
  AT_LEAST_3, /** The I n_ rang e_4. */
  IN_RANGE_4, /** The BEFOR e_ dat e_3. */
  BEFORE_DATE_3, /** The AFTE r_ dat e_3. */
  AFTER_DATE_3, /** The CHEC k_ collection s_ nul l_1. */
  CHECK_COLLECTIONS_NULL_1, /** The CHEC k_ pai r_3. */
  CHECK_PAIR_3;

  /**
   * Bundle name.
   *
   * @return the string
   */
  public static String bundleName() {
    return "RetrieveAndRankMessages";
  }
}

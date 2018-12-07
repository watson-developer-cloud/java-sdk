/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.compare_comply.v1.model;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Document counts.
 */
public class DocCounts extends GenericModel {

  private Long total;
  private Long pending;
  private Long successful;
  private Long failed;

  /**
   * Gets the total.
   *
   * Total number of documents.
   *
   * @return the total
   */
  public Long getTotal() {
    return total;
  }

  /**
   * Gets the pending.
   *
   * Number of pending documents.
   *
   * @return the pending
   */
  public Long getPending() {
    return pending;
  }

  /**
   * Gets the successful.
   *
   * Number of documents successfully processed.
   *
   * @return the successful
   */
  public Long getSuccessful() {
    return successful;
  }

  /**
   * Gets the failed.
   *
   * Number of documents not successfully processed.
   *
   * @return the failed
   */
  public Long getFailed() {
    return failed;
  }
}

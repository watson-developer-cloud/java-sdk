/*
 * (C) Copyright IBM Corp. 2019.
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
package com.ibm.watson.discovery.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object containing collection document count information.
 */
public class DocumentCounts extends GenericModel {

  private Long available;
  private Long processing;
  private Long failed;
  private Long pending;

  /**
   * Gets the available.
   *
   * The total number of available documents in the collection.
   *
   * @return the available
   */
  public Long getAvailable() {
    return available;
  }

  /**
   * Gets the processing.
   *
   * The number of documents in the collection that are currently being processed.
   *
   * @return the processing
   */
  public Long getProcessing() {
    return processing;
  }

  /**
   * Gets the failed.
   *
   * The number of documents in the collection that failed to be ingested.
   *
   * @return the failed
   */
  public Long getFailed() {
    return failed;
  }

  /**
   * Gets the pending.
   *
   * The number of documents that have been uploaded to the collection, but have not yet started processing.
   *
   * @return the pending
   */
  public Long getPending() {
    return pending;
  }
}

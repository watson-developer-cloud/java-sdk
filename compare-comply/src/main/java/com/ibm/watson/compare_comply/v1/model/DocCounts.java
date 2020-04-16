/*
 * (C) Copyright IBM Corp. 2018, 2020.
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
package com.ibm.watson.compare_comply.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Document counts. */
public class DocCounts extends GenericModel {

  protected Long total;
  protected Long pending;
  protected Long successful;
  protected Long failed;

  /**
   * Gets the total.
   *
   * <p>Total number of documents.
   *
   * @return the total
   */
  public Long getTotal() {
    return total;
  }

  /**
   * Gets the pending.
   *
   * <p>Number of pending documents.
   *
   * @return the pending
   */
  public Long getPending() {
    return pending;
  }

  /**
   * Gets the successful.
   *
   * <p>Number of documents successfully processed.
   *
   * @return the successful
   */
  public Long getSuccessful() {
    return successful;
  }

  /**
   * Gets the failed.
   *
   * <p>Number of documents not successfully processed.
   *
   * @return the failed
   */
  public Long getFailed() {
    return failed;
  }
}

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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object containing source crawl status information.
 */
public class SourceStatus extends GenericModel {

  /**
   * The current status of the source crawl for this collection. This field returns `not_configured` if the default
   * configuration for this source does not have a **source** object defined.
   *
   * - `running` indicates that a crawl to fetch more documents is in progress.
   * - `complete` indicates that the crawl has completed with no errors.
   * - `complete_with_notices` indicates that some notices were generated during the crawl. Notices can be checked by
   * using the **notices** query method.
   * - `stopped` indicates that the crawl has stopped but is not complete.
   */
  public interface Status {
    /** running. */
    String RUNNING = "running";
    /** complete. */
    String COMPLETE = "complete";
    /** complete_with_notices. */
    String COMPLETE_WITH_NOTICES = "complete_with_notices";
    /** stopped. */
    String STOPPED = "stopped";
    /** not_configured. */
    String NOT_CONFIGURED = "not_configured";
  }

  private String status;
  @SerializedName("last_updated")
  private Date lastUpdated;

  /**
   * Gets the status.
   *
   * The current status of the source crawl for this collection. This field returns `not_configured` if the default
   * configuration for this source does not have a **source** object defined.
   *
   * - `running` indicates that a crawl to fetch more documents is in progress.
   * - `complete` indicates that the crawl has completed with no errors.
   * - `complete_with_notices` indicates that some notices were generated during the crawl. Notices can be checked by
   * using the **notices** query method.
   * - `stopped` indicates that the crawl has stopped but is not complete.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the lastUpdated.
   *
   * Date in UTC format indicating when the last crawl was attempted. If `null`, no crawl was completed.
   *
   * @return the lastUpdated
   */
  public Date getLastUpdated() {
    return lastUpdated;
  }
}

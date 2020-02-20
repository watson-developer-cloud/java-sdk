/*
 * (C) Copyright IBM Corp. 2020.
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
   * - `queued` indicates that the crawl has been paused by the system and will automatically restart when possible.
   * - `unknown` indicates that an unidentified error has occured in the service.
   */
  public interface Status {
    /** running. */
    String RUNNING = "running";
    /** complete. */
    String COMPLETE = "complete";
    /** not_configured. */
    String NOT_CONFIGURED = "not_configured";
    /** queued. */
    String QUEUED = "queued";
    /** unknown. */
    String UNKNOWN = "unknown";
  }

  protected String status;
  @SerializedName("next_crawl")
  protected Date nextCrawl;

  /**
   * Gets the status.
   *
   * The current status of the source crawl for this collection. This field returns `not_configured` if the default
   * configuration for this source does not have a **source** object defined.
   *
   * - `running` indicates that a crawl to fetch more documents is in progress.
   * - `complete` indicates that the crawl has completed with no errors.
   * - `queued` indicates that the crawl has been paused by the system and will automatically restart when possible.
   * - `unknown` indicates that an unidentified error has occured in the service.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the nextCrawl.
   *
   * Date in `RFC 3339` format indicating the time of the next crawl attempt.
   *
   * @return the nextCrawl
   */
  public Date getNextCrawl() {
    return nextCrawl;
  }
}

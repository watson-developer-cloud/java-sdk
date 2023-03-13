/*
 * (C) Copyright IBM Corp. 2017, 2023.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Summary of the disk usage statistics for the environment. */
public class DiskUsage extends GenericModel {

  @SerializedName("used_bytes")
  protected Long usedBytes;

  @SerializedName("maximum_allowed_bytes")
  protected Long maximumAllowedBytes;

  protected DiskUsage() {}

  /**
   * Gets the usedBytes.
   *
   * <p>Number of bytes within the environment's disk capacity that are currently used to store
   * data.
   *
   * @return the usedBytes
   */
  public Long getUsedBytes() {
    return usedBytes;
  }

  /**
   * Gets the maximumAllowedBytes.
   *
   * <p>Total number of bytes available in the environment's disk capacity.
   *
   * @return the maximumAllowedBytes
   */
  public Long getMaximumAllowedBytes() {
    return maximumAllowedBytes;
  }
}

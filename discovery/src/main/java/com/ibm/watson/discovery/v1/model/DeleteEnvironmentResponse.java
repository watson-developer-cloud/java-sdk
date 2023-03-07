/*
 * (C) Copyright IBM Corp. 2023.
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

/** Response object returned when deleting an environment. */
public class DeleteEnvironmentResponse extends GenericModel {

  /** Status of the environment. */
  public interface Status {
    /** deleted. */
    String DELETED = "deleted";
  }

  @SerializedName("environment_id")
  protected String environmentId;

  protected String status;

  protected DeleteEnvironmentResponse() {}

  /**
   * Gets the environmentId.
   *
   * <p>The unique identifier for the environment.
   *
   * @return the environmentId
   */
  public String getEnvironmentId() {
    return environmentId;
  }

  /**
   * Gets the status.
   *
   * <p>Status of the environment.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }
}

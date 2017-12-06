/*
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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * DeleteEnvironmentResponse.
 */
public class DeleteEnvironmentResponse extends GenericModel {

  /**
   * Status of the environment.
   */
  public interface Status {
    /** deleted. */
    String DELETED = "deleted";
  }

  @SerializedName("environment_id")
  private String environmentId;
  private String status;

  /**
   * Gets the environmentId.
   *
   * The unique identifier for the environment.
   *
   * @return the environmentId
   */
  public String getEnvironmentId() {
    return environmentId;
  }

  /**
   * Gets the status.
   *
   * Status of the environment.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets the environmentId.
   *
   * @param environmentId the new environmentId
   */
  public void setEnvironmentId(final String environmentId) {
    this.environmentId = environmentId;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(final String status) {
    this.status = status;
  }
}

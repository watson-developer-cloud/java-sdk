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
package com.ibm.watson.assistant.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Metadata related to the message.
 */
public class MessageContextMetadata extends GenericModel {

  private String deployment;
  @SerializedName("user_id")
  private String userId;

  /**
   * Gets the deployment.
   *
   * A label identifying the deployment environment, used for filtering log data. This string cannot contain carriage
   * return, newline, or tab characters.
   *
   * @return the deployment
   */
  public String getDeployment() {
    return deployment;
  }

  /**
   * Gets the userId.
   *
   * A string value that identifies the user who is interacting with the workspace. The client must provide a unique
   * identifier for each individual end user who accesses the application. For Plus and Premium plans, this user ID is
   * used to identify unique users for billing purposes. This string cannot contain carriage return, newline, or tab
   * characters.
   *
   * @return the userId
   */
  public String getUserId() {
    return userId;
  }

  /**
   * Sets the deployment.
   *
   * @param deployment the new deployment
   */
  public void setDeployment(final String deployment) {
    this.deployment = deployment;
  }

  /**
   * Sets the userId.
   *
   * @param userId the new userId
   */
  public void setUserId(final String userId) {
    this.userId = userId;
  }
}

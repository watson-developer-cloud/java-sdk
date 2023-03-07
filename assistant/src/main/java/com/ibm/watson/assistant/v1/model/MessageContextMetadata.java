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
package com.ibm.watson.assistant.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Metadata related to the message. */
public class MessageContextMetadata extends GenericModel {

  protected String deployment;

  @SerializedName("user_id")
  protected String userId;

  /** Builder. */
  public static class Builder {
    private String deployment;
    private String userId;

    /**
     * Instantiates a new Builder from an existing MessageContextMetadata instance.
     *
     * @param messageContextMetadata the instance to initialize the Builder with
     */
    private Builder(MessageContextMetadata messageContextMetadata) {
      this.deployment = messageContextMetadata.deployment;
      this.userId = messageContextMetadata.userId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a MessageContextMetadata.
     *
     * @return the new MessageContextMetadata instance
     */
    public MessageContextMetadata build() {
      return new MessageContextMetadata(this);
    }

    /**
     * Set the deployment.
     *
     * @param deployment the deployment
     * @return the MessageContextMetadata builder
     */
    public Builder deployment(String deployment) {
      this.deployment = deployment;
      return this;
    }

    /**
     * Set the userId.
     *
     * @param userId the userId
     * @return the MessageContextMetadata builder
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }
  }

  protected MessageContextMetadata() {}

  protected MessageContextMetadata(Builder builder) {
    deployment = builder.deployment;
    userId = builder.userId;
  }

  /**
   * New builder.
   *
   * @return a MessageContextMetadata builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the deployment.
   *
   * <p>A label identifying the deployment environment, used for filtering log data. This string
   * cannot contain carriage return, newline, or tab characters.
   *
   * @return the deployment
   */
  public String deployment() {
    return deployment;
  }

  /**
   * Gets the userId.
   *
   * <p>A string value that identifies the user who is interacting with the workspace. The client
   * must provide a unique identifier for each individual end user who accesses the application. For
   * user-based plans, this user ID is used to identify unique users for billing purposes. This
   * string cannot contain carriage return, newline, or tab characters. If no value is specified in
   * the input, **user_id** is automatically set to the value of **context.conversation_id**.
   *
   * <p>**Note:** This property is the same as the **user_id** property at the root of the message
   * body. If **user_id** is specified in both locations in a message request, the value specified
   * at the root is used.
   *
   * @return the userId
   */
  public String userId() {
    return userId;
  }
}

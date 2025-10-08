/*
 * (C) Copyright IBM Corp. 2018, 2025.
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

package com.ibm.watson.assistant.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The deleteSession options. */
public class DeleteSessionOptions extends GenericModel {

  protected String assistantId;
  protected String environmentId;
  protected String sessionId;

  /** Builder. */
  public static class Builder {
    private String assistantId;
    private String environmentId;
    private String sessionId;

    /**
     * Instantiates a new Builder from an existing DeleteSessionOptions instance.
     *
     * @param deleteSessionOptions the instance to initialize the Builder with
     */
    private Builder(DeleteSessionOptions deleteSessionOptions) {
      this.assistantId = deleteSessionOptions.assistantId;
      this.environmentId = deleteSessionOptions.environmentId;
      this.sessionId = deleteSessionOptions.sessionId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param assistantId the assistantId
     * @param environmentId the environmentId
     * @param sessionId the sessionId
     */
    public Builder(String assistantId, String environmentId, String sessionId) {
      this.assistantId = assistantId;
      this.environmentId = environmentId;
      this.sessionId = sessionId;
    }

    /**
     * Builds a DeleteSessionOptions.
     *
     * @return the new DeleteSessionOptions instance
     */
    public DeleteSessionOptions build() {
      return new DeleteSessionOptions(this);
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the DeleteSessionOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the DeleteSessionOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the sessionId.
     *
     * @param sessionId the sessionId
     * @return the DeleteSessionOptions builder
     */
    public Builder sessionId(String sessionId) {
      this.sessionId = sessionId;
      return this;
    }
  }

  protected DeleteSessionOptions() {}

  protected DeleteSessionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.assistantId, "assistantId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.sessionId, "sessionId cannot be empty");
    assistantId = builder.assistantId;
    environmentId = builder.environmentId;
    sessionId = builder.sessionId;
  }

  /**
   * New builder.
   *
   * @return a DeleteSessionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assistantId.
   *
   * <p>Unique identifier of the assistant. To get the **assistant ID** in the watsonx Assistant
   * interface, open the **Assistant settings** page, and scroll to the **Assistant IDs and API
   * details** section and click **View Details**.
   *
   * @return the assistantId
   */
  public String assistantId() {
    return assistantId;
  }

  /**
   * Gets the environmentId.
   *
   * <p>Unique identifier of the environment. To find the environment ID in the watsonx Assistant
   * user interface, open the environment settings and click **API Details**. **Note:** Currently,
   * the API does not support creating environments.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the sessionId.
   *
   * <p>Unique identifier of the session.
   *
   * @return the sessionId
   */
  public String sessionId() {
    return sessionId;
  }
}

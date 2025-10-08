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

/** The createSession options. */
public class CreateSessionOptions extends GenericModel {

  protected String assistantId;
  protected String environmentId;
  protected RequestAnalytics analytics;

  /** Builder. */
  public static class Builder {
    private String assistantId;
    private String environmentId;
    private RequestAnalytics analytics;

    /**
     * Instantiates a new Builder from an existing CreateSessionOptions instance.
     *
     * @param createSessionOptions the instance to initialize the Builder with
     */
    private Builder(CreateSessionOptions createSessionOptions) {
      this.assistantId = createSessionOptions.assistantId;
      this.environmentId = createSessionOptions.environmentId;
      this.analytics = createSessionOptions.analytics;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param assistantId the assistantId
     * @param environmentId the environmentId
     */
    public Builder(String assistantId, String environmentId) {
      this.assistantId = assistantId;
      this.environmentId = environmentId;
    }

    /**
     * Builds a CreateSessionOptions.
     *
     * @return the new CreateSessionOptions instance
     */
    public CreateSessionOptions build() {
      return new CreateSessionOptions(this);
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the CreateSessionOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the CreateSessionOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the analytics.
     *
     * @param analytics the analytics
     * @return the CreateSessionOptions builder
     */
    public Builder analytics(RequestAnalytics analytics) {
      this.analytics = analytics;
      return this;
    }
  }

  protected CreateSessionOptions() {}

  protected CreateSessionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.assistantId, "assistantId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    assistantId = builder.assistantId;
    environmentId = builder.environmentId;
    analytics = builder.analytics;
  }

  /**
   * New builder.
   *
   * @return a CreateSessionOptions builder
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
   * Gets the analytics.
   *
   * <p>An optional object containing analytics data. Currently, this data is used only for events
   * sent to the Segment extension.
   *
   * @return the analytics
   */
  public RequestAnalytics analytics() {
    return analytics;
  }
}

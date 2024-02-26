/*
 * (C) Copyright IBM Corp. 2022, 2024.
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

/** The getEnvironment options. */
public class GetEnvironmentOptions extends GenericModel {

  protected String assistantId;
  protected String environmentId;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String assistantId;
    private String environmentId;
    private Boolean includeAudit;

    /**
     * Instantiates a new Builder from an existing GetEnvironmentOptions instance.
     *
     * @param getEnvironmentOptions the instance to initialize the Builder with
     */
    private Builder(GetEnvironmentOptions getEnvironmentOptions) {
      this.assistantId = getEnvironmentOptions.assistantId;
      this.environmentId = getEnvironmentOptions.environmentId;
      this.includeAudit = getEnvironmentOptions.includeAudit;
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
     * Builds a GetEnvironmentOptions.
     *
     * @return the new GetEnvironmentOptions instance
     */
    public GetEnvironmentOptions build() {
      return new GetEnvironmentOptions(this);
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the GetEnvironmentOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the GetEnvironmentOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the GetEnvironmentOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected GetEnvironmentOptions() {}

  protected GetEnvironmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.assistantId, "assistantId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    assistantId = builder.assistantId;
    environmentId = builder.environmentId;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a GetEnvironmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assistantId.
   *
   * <p>The assistant ID or the environment ID of the environment where the assistant is deployed,
   * depending on the type of request: - For message, session, and log requests, specify the
   * environment ID of the environment where the assistant is deployed. - For all other requests,
   * specify the assistant ID of the assistant.
   *
   * <p>To find the environment ID or assistant ID in the watsonx Assistant user interface, open the
   * assistant settings and scroll to the **Environments** section.
   *
   * <p>**Note:** If you are using the classic Watson Assistant experience, always use the assistant
   * ID. To find the assistant ID in the user interface, open the assistant settings and click API
   * Details.
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
   * Gets the includeAudit.
   *
   * <p>Whether to include the audit properties (`created` and `updated` timestamps) in the
   * response.
   *
   * @return the includeAudit
   */
  public Boolean includeAudit() {
    return includeAudit;
  }
}

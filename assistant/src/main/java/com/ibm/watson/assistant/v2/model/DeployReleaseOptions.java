/*
 * (C) Copyright IBM Corp. 2022.
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

/** The deployRelease options. */
public class DeployReleaseOptions extends GenericModel {

  protected String assistantId;
  protected String release;
  protected String environmentId;
  protected Boolean includeAudit;

  /** Builder. */
  public static class Builder {
    private String assistantId;
    private String release;
    private String environmentId;
    private Boolean includeAudit;

    private Builder(DeployReleaseOptions deployReleaseOptions) {
      this.assistantId = deployReleaseOptions.assistantId;
      this.release = deployReleaseOptions.release;
      this.environmentId = deployReleaseOptions.environmentId;
      this.includeAudit = deployReleaseOptions.includeAudit;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param assistantId the assistantId
     * @param release the release
     * @param environmentId the environmentId
     */
    public Builder(String assistantId, String release, String environmentId) {
      this.assistantId = assistantId;
      this.release = release;
      this.environmentId = environmentId;
    }

    /**
     * Builds a DeployReleaseOptions.
     *
     * @return the new DeployReleaseOptions instance
     */
    public DeployReleaseOptions build() {
      return new DeployReleaseOptions(this);
    }

    /**
     * Set the assistantId.
     *
     * @param assistantId the assistantId
     * @return the DeployReleaseOptions builder
     */
    public Builder assistantId(String assistantId) {
      this.assistantId = assistantId;
      return this;
    }

    /**
     * Set the release.
     *
     * @param release the release
     * @return the DeployReleaseOptions builder
     */
    public Builder release(String release) {
      this.release = release;
      return this;
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the DeployReleaseOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the includeAudit.
     *
     * @param includeAudit the includeAudit
     * @return the DeployReleaseOptions builder
     */
    public Builder includeAudit(Boolean includeAudit) {
      this.includeAudit = includeAudit;
      return this;
    }
  }

  protected DeployReleaseOptions() {}

  protected DeployReleaseOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.assistantId, "assistantId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.release, "release cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.environmentId, "environmentId cannot be null");
    assistantId = builder.assistantId;
    release = builder.release;
    environmentId = builder.environmentId;
    includeAudit = builder.includeAudit;
  }

  /**
   * New builder.
   *
   * @return a DeployReleaseOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assistantId.
   *
   * <p>Unique identifier of the assistant. To find the assistant ID in the Watson Assistant user
   * interface, open the assistant settings and click **API Details**. For information about
   * creating assistants, see the
   * [documentation](https://cloud.ibm.com/docs/assistant?topic=assistant-assistant-add#assistant-add-task).
   *
   * <p>**Note:** Currently, the v2 API does not support creating assistants.
   *
   * @return the assistantId
   */
  public String assistantId() {
    return assistantId;
  }

  /**
   * Gets the release.
   *
   * <p>Unique identifier of the release.
   *
   * @return the release
   */
  public String release() {
    return release;
  }

  /**
   * Gets the environmentId.
   *
   * <p>The environment ID of the environment where the release is to be deployed.
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

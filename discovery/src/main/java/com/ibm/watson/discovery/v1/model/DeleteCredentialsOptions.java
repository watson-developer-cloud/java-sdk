/*
 * (C) Copyright IBM Corp. 2018, 2023.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The deleteCredentials options. */
public class DeleteCredentialsOptions extends GenericModel {

  protected String environmentId;
  protected String credentialId;

  /** Builder. */
  public static class Builder {
    private String environmentId;
    private String credentialId;

    /**
     * Instantiates a new Builder from an existing DeleteCredentialsOptions instance.
     *
     * @param deleteCredentialsOptions the instance to initialize the Builder with
     */
    private Builder(DeleteCredentialsOptions deleteCredentialsOptions) {
      this.environmentId = deleteCredentialsOptions.environmentId;
      this.credentialId = deleteCredentialsOptions.credentialId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     * @param credentialId the credentialId
     */
    public Builder(String environmentId, String credentialId) {
      this.environmentId = environmentId;
      this.credentialId = credentialId;
    }

    /**
     * Builds a DeleteCredentialsOptions.
     *
     * @return the new DeleteCredentialsOptions instance
     */
    public DeleteCredentialsOptions build() {
      return new DeleteCredentialsOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the DeleteCredentialsOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the credentialId.
     *
     * @param credentialId the credentialId
     * @return the DeleteCredentialsOptions builder
     */
    public Builder credentialId(String credentialId) {
      this.credentialId = credentialId;
      return this;
    }
  }

  protected DeleteCredentialsOptions() {}

  protected DeleteCredentialsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.environmentId, "environmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.credentialId, "credentialId cannot be empty");
    environmentId = builder.environmentId;
    credentialId = builder.credentialId;
  }

  /**
   * New builder.
   *
   * @return a DeleteCredentialsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * <p>The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the credentialId.
   *
   * <p>The unique identifier for a set of source credentials.
   *
   * @return the credentialId
   */
  public String credentialId() {
    return credentialId;
  }
}

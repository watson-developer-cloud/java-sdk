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
package com.ibm.watson.discovery.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The getCredentials options.
 */
public class GetCredentialsOptions extends GenericModel {

  private String environmentId;
  private String credentialId;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String credentialId;

    private Builder(GetCredentialsOptions getCredentialsOptions) {
      environmentId = getCredentialsOptions.environmentId;
      credentialId = getCredentialsOptions.credentialId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

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
     * Builds a GetCredentialsOptions.
     *
     * @return the getCredentialsOptions
     */
    public GetCredentialsOptions build() {
      return new GetCredentialsOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the GetCredentialsOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the credentialId.
     *
     * @param credentialId the credentialId
     * @return the GetCredentialsOptions builder
     */
    public Builder credentialId(String credentialId) {
      this.credentialId = credentialId;
      return this;
    }
  }

  private GetCredentialsOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    Validator.notEmpty(builder.credentialId, "credentialId cannot be empty");
    environmentId = builder.environmentId;
    credentialId = builder.credentialId;
  }

  /**
   * New builder.
   *
   * @return a GetCredentialsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the credentialId.
   *
   * The unique identifier for a set of source credentials.
   *
   * @return the credentialId
   */
  public String credentialId() {
    return credentialId;
  }
}

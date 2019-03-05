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
 * The updateCredentials options.
 */
public class UpdateCredentialsOptions extends GenericModel {

  /**
   * The source that this credentials object connects to.
   * - `box` indicates the credentials are used to connect an instance of Enterprise Box.
   * - `salesforce` indicates the credentials are used to connect to Salesforce.
   * - `sharepoint` indicates the credentials are used to connect to Microsoft SharePoint Online.
   * - `web_crawl` indicates the credentials are used to perform a web crawl.
   */
  public interface SourceType {
    /** box. */
    String BOX = "box";
    /** salesforce. */
    String SALESFORCE = "salesforce";
    /** sharepoint. */
    String SHAREPOINT = "sharepoint";
    /** web_crawl. */
    String WEB_CRAWL = "web_crawl";
  }

  private String environmentId;
  private String credentialId;
  private String sourceType;
  private CredentialDetails credentialDetails;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String credentialId;
    private String sourceType;
    private CredentialDetails credentialDetails;

    private Builder(UpdateCredentialsOptions updateCredentialsOptions) {
      environmentId = updateCredentialsOptions.environmentId;
      credentialId = updateCredentialsOptions.credentialId;
      sourceType = updateCredentialsOptions.sourceType;
      credentialDetails = updateCredentialsOptions.credentialDetails;
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
     * Builds a UpdateCredentialsOptions.
     *
     * @return the updateCredentialsOptions
     */
    public UpdateCredentialsOptions build() {
      return new UpdateCredentialsOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the UpdateCredentialsOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the credentialId.
     *
     * @param credentialId the credentialId
     * @return the UpdateCredentialsOptions builder
     */
    public Builder credentialId(String credentialId) {
      this.credentialId = credentialId;
      return this;
    }

    /**
     * Set the sourceType.
     *
     * @param sourceType the sourceType
     * @return the UpdateCredentialsOptions builder
     */
    public Builder sourceType(String sourceType) {
      this.sourceType = sourceType;
      return this;
    }

    /**
     * Set the credentialDetails.
     *
     * @param credentialDetails the credentialDetails
     * @return the UpdateCredentialsOptions builder
     */
    public Builder credentialDetails(CredentialDetails credentialDetails) {
      this.credentialDetails = credentialDetails;
      return this;
    }

    /**
     * Set the credentials.
     *
     * @param credentials the credentials
     * @return the UpdateCredentialsOptions builder
     */
    public Builder credentials(Credentials credentials) {
      this.sourceType = credentials.getSourceType();
      this.credentialDetails = credentials.getCredentialDetails();
      return this;
    }
  }

  private UpdateCredentialsOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    Validator.notEmpty(builder.credentialId, "credentialId cannot be empty");
    environmentId = builder.environmentId;
    credentialId = builder.credentialId;
    sourceType = builder.sourceType;
    credentialDetails = builder.credentialDetails;
  }

  /**
   * New builder.
   *
   * @return a UpdateCredentialsOptions builder
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

  /**
   * Gets the sourceType.
   *
   * The source that this credentials object connects to.
   * - `box` indicates the credentials are used to connect an instance of Enterprise Box.
   * - `salesforce` indicates the credentials are used to connect to Salesforce.
   * - `sharepoint` indicates the credentials are used to connect to Microsoft SharePoint Online.
   * - `web_crawl` indicates the credentials are used to perform a web crawl.
   *
   * @return the sourceType
   */
  public String sourceType() {
    return sourceType;
  }

  /**
   * Gets the credentialDetails.
   *
   * Object containing details of the stored credentials.
   *
   * Obtain credentials for your source from the administrator of the source.
   *
   * @return the credentialDetails
   */
  public CredentialDetails credentialDetails() {
    return credentialDetails;
  }
}

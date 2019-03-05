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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The createCredentials options.
 */
public class CreateCredentialsOptions extends GenericModel {

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
  private String sourceType;
  private CredentialDetails credentialDetails;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String sourceType;
    private CredentialDetails credentialDetails;

    private Builder(CreateCredentialsOptions createCredentialsOptions) {
      environmentId = createCredentialsOptions.environmentId;
      sourceType = createCredentialsOptions.sourceType;
      credentialDetails = createCredentialsOptions.credentialDetails;
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
     */
    public Builder(String environmentId) {
      this.environmentId = environmentId;
    }

    /**
     * Builds a CreateCredentialsOptions.
     *
     * @return the createCredentialsOptions
     */
    public CreateCredentialsOptions build() {
      return new CreateCredentialsOptions(this);
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the CreateCredentialsOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the sourceType.
     *
     * @param sourceType the sourceType
     * @return the CreateCredentialsOptions builder
     */
    public Builder sourceType(String sourceType) {
      this.sourceType = sourceType;
      return this;
    }

    /**
     * Set the credentialDetails.
     *
     * @param credentialDetails the credentialDetails
     * @return the CreateCredentialsOptions builder
     */
    public Builder credentialDetails(CredentialDetails credentialDetails) {
      this.credentialDetails = credentialDetails;
      return this;
    }

    /**
     * Set the credentials.
     *
     * @param credentials the credentials
     * @return the CreateCredentialsOptions builder
     */
    public Builder credentials(Credentials credentials) {
      this.sourceType = credentials.getSourceType();
      this.credentialDetails = credentials.getCredentialDetails();
      return this;
    }
  }

  private CreateCredentialsOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    environmentId = builder.environmentId;
    sourceType = builder.sourceType;
    credentialDetails = builder.credentialDetails;
  }

  /**
   * New builder.
   *
   * @return a CreateCredentialsOptions builder
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

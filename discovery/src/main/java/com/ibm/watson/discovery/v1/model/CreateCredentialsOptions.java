/*
 * (C) Copyright IBM Corp. 2020.
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

/**
 * The createCredentials options.
 */
public class CreateCredentialsOptions extends GenericModel {

  /**
   * The source that this credentials object connects to.
   * -  `box` indicates the credentials are used to connect an instance of Enterprise Box.
   * -  `salesforce` indicates the credentials are used to connect to Salesforce.
   * -  `sharepoint` indicates the credentials are used to connect to Microsoft SharePoint Online.
   * -  `web_crawl` indicates the credentials are used to perform a web crawl.
   * =  `cloud_object_storage` indicates the credentials are used to connect to an IBM Cloud Object Store.
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
    /** cloud_object_storage. */
    String CLOUD_OBJECT_STORAGE = "cloud_object_storage";
  }

  /**
   * The current status of this set of credentials. `connected` indicates that the credentials are available to use with
   * the source configuration of a collection. `invalid` refers to the credentials (for example, the password provided
   * has expired) and must be corrected before they can be used with a collection.
   */
  public interface Status {
    /** connected. */
    String CONNECTED = "connected";
    /** invalid. */
    String INVALID = "invalid";
  }

  protected String environmentId;
  protected String sourceType;
  protected CredentialDetails credentialDetails;
  protected String status;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String sourceType;
    private CredentialDetails credentialDetails;
    private String status;

    private Builder(CreateCredentialsOptions createCredentialsOptions) {
      this.environmentId = createCredentialsOptions.environmentId;
      this.sourceType = createCredentialsOptions.sourceType;
      this.credentialDetails = createCredentialsOptions.credentialDetails;
      this.status = createCredentialsOptions.status;
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
     * Set the status.
     *
     * @param status the status
     * @return the CreateCredentialsOptions builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Set the credentials.
     *
     * @param credentials the credentials
     * @return the CreateCredentialsOptions builder
     */
    public Builder credentials(Credentials credentials) {
      this.sourceType = credentials.sourceType();
      this.credentialDetails = credentials.credentialDetails();
      this.status = credentials.status();
      return this;
    }
  }

  protected CreateCredentialsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.environmentId,
      "environmentId cannot be empty");
    environmentId = builder.environmentId;
    sourceType = builder.sourceType;
    credentialDetails = builder.credentialDetails;
    status = builder.status;
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
   * -  `box` indicates the credentials are used to connect an instance of Enterprise Box.
   * -  `salesforce` indicates the credentials are used to connect to Salesforce.
   * -  `sharepoint` indicates the credentials are used to connect to Microsoft SharePoint Online.
   * -  `web_crawl` indicates the credentials are used to perform a web crawl.
   * =  `cloud_object_storage` indicates the credentials are used to connect to an IBM Cloud Object Store.
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

  /**
   * Gets the status.
   *
   * The current status of this set of credentials. `connected` indicates that the credentials are available to use with
   * the source configuration of a collection. `invalid` refers to the credentials (for example, the password provided
   * has expired) and must be corrected before they can be used with a collection.
   *
   * @return the status
   */
  public String status() {
    return status;
  }
}


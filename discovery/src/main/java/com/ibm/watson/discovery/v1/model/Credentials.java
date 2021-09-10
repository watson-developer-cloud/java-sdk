/*
 * (C) Copyright IBM Corp. 2021.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Object containing credential information. */
public class Credentials extends GenericModel {

  /**
   * The source that this credentials object connects to. - `box` indicates the credentials are used
   * to connect an instance of Enterprise Box. - `salesforce` indicates the credentials are used to
   * connect to Salesforce. - `sharepoint` indicates the credentials are used to connect to
   * Microsoft SharePoint Online. - `web_crawl` indicates the credentials are used to perform a web
   * crawl. = `cloud_object_storage` indicates the credentials are used to connect to an IBM Cloud
   * Object Store.
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

  @SerializedName("credential_id")
  protected String credentialId;

  @SerializedName("source_type")
  protected String sourceType;

  @SerializedName("credential_details")
  protected CredentialDetails credentialDetails;

  protected StatusDetails status;

  /** Builder. */
  public static class Builder {
    private String sourceType;
    private CredentialDetails credentialDetails;
    private StatusDetails status;

    private Builder(Credentials credentials) {
      this.sourceType = credentials.sourceType;
      this.credentialDetails = credentials.credentialDetails;
      this.status = credentials.status;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a Credentials.
     *
     * @return the new Credentials instance
     */
    public Credentials build() {
      return new Credentials(this);
    }

    /**
     * Set the sourceType.
     *
     * @param sourceType the sourceType
     * @return the Credentials builder
     */
    public Builder sourceType(String sourceType) {
      this.sourceType = sourceType;
      return this;
    }

    /**
     * Set the credentialDetails.
     *
     * @param credentialDetails the credentialDetails
     * @return the Credentials builder
     */
    public Builder credentialDetails(CredentialDetails credentialDetails) {
      this.credentialDetails = credentialDetails;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the Credentials builder
     */
    public Builder status(StatusDetails status) {
      this.status = status;
      return this;
    }
  }

  protected Credentials(Builder builder) {
    sourceType = builder.sourceType;
    credentialDetails = builder.credentialDetails;
    status = builder.status;
  }

  /**
   * New builder.
   *
   * @return a Credentials builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the credentialId.
   *
   * <p>Unique identifier for this set of credentials.
   *
   * @return the credentialId
   */
  public String credentialId() {
    return credentialId;
  }

  /**
   * Gets the sourceType.
   *
   * <p>The source that this credentials object connects to. - `box` indicates the credentials are
   * used to connect an instance of Enterprise Box. - `salesforce` indicates the credentials are
   * used to connect to Salesforce. - `sharepoint` indicates the credentials are used to connect to
   * Microsoft SharePoint Online. - `web_crawl` indicates the credentials are used to perform a web
   * crawl. = `cloud_object_storage` indicates the credentials are used to connect to an IBM Cloud
   * Object Store.
   *
   * @return the sourceType
   */
  public String sourceType() {
    return sourceType;
  }

  /**
   * Gets the credentialDetails.
   *
   * <p>Object containing details of the stored credentials.
   *
   * <p>Obtain credentials for your source from the administrator of the source.
   *
   * @return the credentialDetails
   */
  public CredentialDetails credentialDetails() {
    return credentialDetails;
  }

  /**
   * Gets the status.
   *
   * <p>Object that contains details about the status of the authentication process.
   *
   * @return the status
   */
  public StatusDetails status() {
    return status;
  }
}

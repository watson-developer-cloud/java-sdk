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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object containing credential information.
 */
public class Credentials extends GenericModel {

  /**
   * The source that this credentials object connects to.
   * - `box` indicates the credentials are used to connect an instance of Enterprise Box.
   * - `salesforce` indicates the credentials are used to connect to Salesforce.
   * - `sharepoint` indicates the credentials are used to connect to Microsoft SharePoint Online.
   * - `web_crawl` indicates the credentials are used to perform a web crawl.
   * = `cloud_object_storage` indicates the credentials are used to connect to an IBM Cloud Object Store.
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

  @SerializedName("credential_id")
  private String credentialId;
  @SerializedName("source_type")
  private String sourceType;
  @SerializedName("credential_details")
  private CredentialDetails credentialDetails;
  private String status;

  /**
   * Gets the credentialId.
   *
   * Unique identifier for this set of credentials.
   *
   * @return the credentialId
   */
  public String getCredentialId() {
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
   * = `cloud_object_storage` indicates the credentials are used to connect to an IBM Cloud Object Store.
   *
   * @return the sourceType
   */
  public String getSourceType() {
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
  public CredentialDetails getCredentialDetails() {
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
  public String getStatus() {
    return status;
  }

  /**
   * Sets the sourceType.
   *
   * @param sourceType the new sourceType
   */
  public void setSourceType(final String sourceType) {
    this.sourceType = sourceType;
  }

  /**
   * Sets the credentialDetails.
   *
   * @param credentialDetails the new credentialDetails
   */
  public void setCredentialDetails(final CredentialDetails credentialDetails) {
    this.credentialDetails = credentialDetails;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(final String status) {
    this.status = status;
  }
}

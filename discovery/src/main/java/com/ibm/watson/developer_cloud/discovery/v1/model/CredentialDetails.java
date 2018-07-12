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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Object containing details of the stored credentials.
 *
 * Obtain credentials for your source from the administrator of the source.
 */
public class CredentialDetails extends GenericModel {

  /**
   * The authentication method for this credentials definition. The **credential_type** specified must be supported by
   * the **source_type**. The following combinations are possible:
   *
   * - `"source_type": "box"` - valid `credential_type`s: `oauth2`
   * - `"source_type": "salesforce"` - valid `credential_type`s: `username_password`
   * - `"source_type": "sharepoint"` - valid `credential_type`s: `saml`.
   */
  public interface CredentialType {
    /** oauth2. */
    String OAUTH2 = "oauth2";
    /** saml. */
    String SAML = "saml";
    /** username_password. */
    String USERNAME_PASSWORD = "username_password";
  }

  @SerializedName("credential_type")
  private String credentialType;
  @SerializedName("client_id")
  private String clientId;
  @SerializedName("enterprise_id")
  private String enterpriseId;
  private String url;
  private String username;
  @SerializedName("organization_url")
  private String organizationUrl;
  @SerializedName("site_collection.path")
  private String siteCollectionPath;
  @SerializedName("client_secret")
  private String clientSecret;
  @SerializedName("public_key_id")
  private String publicKeyId;
  @SerializedName("private_key")
  private String privateKey;
  private String passphrase;
  private String password;

  /**
   * Gets the credentialType.
   *
   * The authentication method for this credentials definition. The **credential_type** specified must be supported by
   * the **source_type**. The following combinations are possible:
   *
   * - `"source_type": "box"` - valid `credential_type`s: `oauth2`
   * - `"source_type": "salesforce"` - valid `credential_type`s: `username_password`
   * - `"source_type": "sharepoint"` - valid `credential_type`s: `saml`.
   *
   * @return the credentialType
   */
  public String getCredentialType() {
    return credentialType;
  }

  /**
   * Gets the clientId.
   *
   * The **client_id** of the source that these credentials connect to. Only valid, and required, with a
   * **credential_type** of `oauth2`.
   *
   * @return the clientId
   */
  public String getClientId() {
    return clientId;
  }

  /**
   * Gets the enterpriseId.
   *
   * The **enterprise_id** of the Box site that these credentials connect to. Only valid, and required, with a
   * **source_type** of `box`.
   *
   * @return the enterpriseId
   */
  public String getEnterpriseId() {
    return enterpriseId;
  }

  /**
   * Gets the url.
   *
   * The **url** of the source that these credentials connect to. Only valid, and required, with a **credential_type**
   * of `username_password`.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the username.
   *
   * The **username** of the source that these credentials connect to. Only valid, and required, with a
   * **credential_type** of `saml` and `username_password`.
   *
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Gets the organizationUrl.
   *
   * The **organization_url** of the source that these credentials connect to. Only valid, and required, with a
   * **credential_type** of `saml`.
   *
   * @return the organizationUrl
   */
  public String getOrganizationUrl() {
    return organizationUrl;
  }

  /**
   * Gets the siteCollectionPath.
   *
   * The **site_collection.path** of the source that these credentials connect to. Only valid, and required, with a
   * **source_type** of `sharepoint`.
   *
   * @return the siteCollectionPath
   */
  public String getSiteCollectionPath() {
    return siteCollectionPath;
  }

  /**
   * Gets the clientSecret.
   *
   * The **client_secret** of the source that these credentials connect to. Only valid, and required, with a
   * **credential_type** of `oauth2`. This value is never returned and is only used when creating or modifying
   * **credentials**.
   *
   * @return the clientSecret
   */
  public String getClientSecret() {
    return clientSecret;
  }

  /**
   * Gets the publicKeyId.
   *
   * The **public_key_id** of the source that these credentials connect to. Only valid, and required, with a
   * **credential_type** of `oauth2`. This value is never returned and is only used when creating or modifying
   * **credentials**.
   *
   * @return the publicKeyId
   */
  public String getPublicKeyId() {
    return publicKeyId;
  }

  /**
   * Gets the privateKey.
   *
   * The **private_key** of the source that these credentials connect to. Only valid, and required, with a
   * **credential_type** of `oauth2`. This value is never returned and is only used when creating or modifying
   * **credentials**.
   *
   * @return the privateKey
   */
  public String getPrivateKey() {
    return privateKey;
  }

  /**
   * Gets the passphrase.
   *
   * The **passphrase** of the source that these credentials connect to. Only valid, and required, with a
   * **credential_type** of `oauth2`. This value is never returned and is only used when creating or modifying
   * **credentials**.
   *
   * @return the passphrase
   */
  public String getPassphrase() {
    return passphrase;
  }

  /**
   * Gets the password.
   *
   * The **password** of the source that these credentials connect to. Only valid, and required, with
   * **credential_type**s of `saml` and `username_password`.
   *
   * **Note:** When used with a **source_type** of `salesforce`, the password consists of the Salesforce password and a
   * valid Salesforce security token concatenated. This value is never returned and is only used when creating or
   * modifying **credentials**.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the credentialType.
   *
   * @param credentialType the new credentialType
   */
  public void setCredentialType(final String credentialType) {
    this.credentialType = credentialType;
  }

  /**
   * Sets the clientId.
   *
   * @param clientId the new clientId
   */
  public void setClientId(final String clientId) {
    this.clientId = clientId;
  }

  /**
   * Sets the enterpriseId.
   *
   * @param enterpriseId the new enterpriseId
   */
  public void setEnterpriseId(final String enterpriseId) {
    this.enterpriseId = enterpriseId;
  }

  /**
   * Sets the url.
   *
   * @param url the new url
   */
  public void setUrl(final String url) {
    this.url = url;
  }

  /**
   * Sets the username.
   *
   * @param username the new username
   */
  public void setUsername(final String username) {
    this.username = username;
  }

  /**
   * Sets the organizationUrl.
   *
   * @param organizationUrl the new organizationUrl
   */
  public void setOrganizationUrl(final String organizationUrl) {
    this.organizationUrl = organizationUrl;
  }

  /**
   * Sets the siteCollectionPath.
   *
   * @param siteCollectionPath the new siteCollectionPath
   */
  public void setSiteCollectionPath(final String siteCollectionPath) {
    this.siteCollectionPath = siteCollectionPath;
  }

  /**
   * Sets the clientSecret.
   *
   * @param clientSecret the new clientSecret
   */
  public void setClientSecret(final String clientSecret) {
    this.clientSecret = clientSecret;
  }

  /**
   * Sets the publicKeyId.
   *
   * @param publicKeyId the new publicKeyId
   */
  public void setPublicKeyId(final String publicKeyId) {
    this.publicKeyId = publicKeyId;
  }

  /**
   * Sets the privateKey.
   *
   * @param privateKey the new privateKey
   */
  public void setPrivateKey(final String privateKey) {
    this.privateKey = privateKey;
  }

  /**
   * Sets the passphrase.
   *
   * @param passphrase the new passphrase
   */
  public void setPassphrase(final String passphrase) {
    this.passphrase = passphrase;
  }

  /**
   * Sets the password.
   *
   * @param password the new password
   */
  public void setPassword(final String password) {
    this.password = password;
  }
}

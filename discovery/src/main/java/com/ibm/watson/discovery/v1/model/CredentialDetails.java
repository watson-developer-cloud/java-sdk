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
   * - `"source_type": "sharepoint"` - valid `credential_type`s: `saml` with **source_version** of `online`, or
   * `ntlm_v1` with **source_version** of `2016`
   * - `"source_type": "web_crawl"` - valid `credential_type`s: `noauth` or `basic`
   * - "source_type": "cloud_object_storage"` - valid `credential_type`s: `aws4_hmac`.
   */
  public interface CredentialType {
    /** oauth2. */
    String OAUTH2 = "oauth2";
    /** saml. */
    String SAML = "saml";
    /** username_password. */
    String USERNAME_PASSWORD = "username_password";
    /** noauth. */
    String NOAUTH = "noauth";
    /** basic. */
    String BASIC = "basic";
    /** ntlm_v1. */
    String NTLM_V1 = "ntlm_v1";
    /** aws4_hmac. */
    String AWS4_HMAC = "aws4_hmac";
  }

  /**
   * The type of Sharepoint repository to connect to. Only valid, and required, with a **source_type** of `sharepoint`.
   */
  public interface SourceVersion {
    /** online. */
    String ONLINE = "online";
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
  @SerializedName("gateway_id")
  private String gatewayId;
  @SerializedName("source_version")
  private String sourceVersion;
  @SerializedName("web_application_url")
  private String webApplicationUrl;
  private String domain;
  private String endpoint;
  @SerializedName("access_key_id")
  private String accessKeyId;
  @SerializedName("secret_access_key")
  private String secretAccessKey;

  /**
   * Gets the credentialType.
   *
   * The authentication method for this credentials definition. The **credential_type** specified must be supported by
   * the **source_type**. The following combinations are possible:
   *
   * - `"source_type": "box"` - valid `credential_type`s: `oauth2`
   * - `"source_type": "salesforce"` - valid `credential_type`s: `username_password`
   * - `"source_type": "sharepoint"` - valid `credential_type`s: `saml` with **source_version** of `online`, or
   * `ntlm_v1` with **source_version** of `2016`
   * - `"source_type": "web_crawl"` - valid `credential_type`s: `noauth` or `basic`
   * - "source_type": "cloud_object_storage"` - valid `credential_type`s: `aws4_hmac`.
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
   * of `username_password`, `noauth`, and `basic`.
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
   * **credential_type** of `saml`, `username_password`, `basic`, or `ntlm_v1`.
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
   * **credential_type**s of `saml`, `username_password`, `basic`, or `ntlm_v1`.
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
   * Gets the gatewayId.
   *
   * The ID of the **gateway** to be connected through (when connecting to intranet sites). Only valid with a
   * **credential_type** of `noauth`, `basic`, or `ntlm_v1`. Gateways are created using the
   * `/v1/environments/{environment_id}/gateways` methods.
   *
   * @return the gatewayId
   */
  public String getGatewayId() {
    return gatewayId;
  }

  /**
   * Gets the sourceVersion.
   *
   * The type of Sharepoint repository to connect to. Only valid, and required, with a **source_type** of `sharepoint`.
   *
   * @return the sourceVersion
   */
  public String getSourceVersion() {
    return sourceVersion;
  }

  /**
   * Gets the webApplicationUrl.
   *
   * SharePoint OnPrem WebApplication URL. Only valid, and required, with a **source_version** of `2016`. If a port is
   * not supplied, the default to port `80` for http and port `443` for https connections are used.
   *
   * @return the webApplicationUrl
   */
  public String getWebApplicationUrl() {
    return webApplicationUrl;
  }

  /**
   * Gets the domain.
   *
   * The domain used to log in to your OnPrem SharePoint account. Only valid, and required, with a **source_version** of
   * `2016`.
   *
   * @return the domain
   */
  public String getDomain() {
    return domain;
  }

  /**
   * Gets the endpoint.
   *
   * The endpoint associated with the cloud object store that your are connecting to. Only valid, and required, with a
   * **credential_type** of `aws4_hmac`.
   *
   * @return the endpoint
   */
  public String getEndpoint() {
    return endpoint;
  }

  /**
   * Gets the accessKeyId.
   *
   * The access key ID associated with the cloud object store. Only valid, and required, with a **credential_type** of
   * `aws4_hmac`. This value is never returned and is only used when creating or modifying **credentials**. For more
   * infomation, see the [cloud object store
   * documentation]
   * (https://cloud.ibm.com/docs/services/cloud-object-storage
   * ?topic=cloud-object-storage-using-hmac-credentials#using-hmac-credentials).
   *
   * @return the accessKeyId
   */
  public String getAccessKeyId() {
    return accessKeyId;
  }

  /**
   * Gets the secretAccessKey.
   *
   * The secret access key associated with the cloud object store. Only valid, and required, with a **credential_type**
   * of `aws4_hmac`. This value is never returned and is only used when creating or modifying **credentials**. For more
   * infomation, see the [cloud object store
   * documentation]
   * (https://cloud.ibm.com/docs/services/cloud-object-storage
   * ?topic=cloud-object-storage-using-hmac-credentials#using-hmac-credentials).
   *
   * @return the secretAccessKey
   */
  public String getSecretAccessKey() {
    return secretAccessKey;
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

  /**
   * Sets the gatewayId.
   *
   * @param gatewayId the new gatewayId
   */
  public void setGatewayId(final String gatewayId) {
    this.gatewayId = gatewayId;
  }

  /**
   * Sets the sourceVersion.
   *
   * @param sourceVersion the new sourceVersion
   */
  public void setSourceVersion(final String sourceVersion) {
    this.sourceVersion = sourceVersion;
  }

  /**
   * Sets the webApplicationUrl.
   *
   * @param webApplicationUrl the new webApplicationUrl
   */
  public void setWebApplicationUrl(final String webApplicationUrl) {
    this.webApplicationUrl = webApplicationUrl;
  }

  /**
   * Sets the domain.
   *
   * @param domain the new domain
   */
  public void setDomain(final String domain) {
    this.domain = domain;
  }

  /**
   * Sets the endpoint.
   *
   * @param endpoint the new endpoint
   */
  public void setEndpoint(final String endpoint) {
    this.endpoint = endpoint;
  }

  /**
   * Sets the accessKeyId.
   *
   * @param accessKeyId the new accessKeyId
   */
  public void setAccessKeyId(final String accessKeyId) {
    this.accessKeyId = accessKeyId;
  }

  /**
   * Sets the secretAccessKey.
   *
   * @param secretAccessKey the new secretAccessKey
   */
  public void setSecretAccessKey(final String secretAccessKey) {
    this.secretAccessKey = secretAccessKey;
  }
}

/*
 * (C) Copyright IBM Corp. 2018, 2020.
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
 * <p>Obtain credentials for your source from the administrator of the source.
 */
public class CredentialDetails extends GenericModel {

  /**
   * The authentication method for this credentials definition. The **credential_type** specified
   * must be supported by the **source_type**. The following combinations are possible:
   *
   * <p>- `"source_type": "box"` - valid `credential_type`s: `oauth2` - `"source_type":
   * "salesforce"` - valid `credential_type`s: `username_password` - `"source_type": "sharepoint"` -
   * valid `credential_type`s: `saml` with **source_version** of `online`, or `ntlm_v1` with
   * **source_version** of `2016` - `"source_type": "web_crawl"` - valid `credential_type`s:
   * `noauth` or `basic` - "source_type": "cloud_object_storage"` - valid `credential_type`s:
   * `aws4_hmac`.
   */
  public interface CredentialType {
    /** oauth2. */
    String OAUTH2 = "oauth2";
    /** saml. */
    String SAML = "saml";
    /** username_password. */
    String USERNAME_PASSWORD = "username_password"; // pragma: whitelist secret
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
   * The type of Sharepoint repository to connect to. Only valid, and required, with a
   * **source_type** of `sharepoint`.
   */
  public interface SourceVersion {
    /** online. */
    String ONLINE = "online";
  }

  @SerializedName("credential_type")
  protected String credentialType;

  @SerializedName("client_id")
  protected String clientId;

  @SerializedName("enterprise_id")
  protected String enterpriseId;

  protected String url;
  protected String username;

  @SerializedName("organization_url")
  protected String organizationUrl;

  @SerializedName("site_collection.path")
  protected String siteCollectionPath;

  @SerializedName("client_secret")
  protected String clientSecret;

  @SerializedName("public_key_id")
  protected String publicKeyId;

  @SerializedName("private_key")
  protected String privateKey;

  protected String passphrase;
  protected String password;

  @SerializedName("gateway_id")
  protected String gatewayId;

  @SerializedName("source_version")
  protected String sourceVersion;

  @SerializedName("web_application_url")
  protected String webApplicationUrl;

  protected String domain;
  protected String endpoint;

  @SerializedName("access_key_id")
  protected String accessKeyId;

  @SerializedName("secret_access_key")
  protected String secretAccessKey;

  /** Builder. */
  public static class Builder {
    private String credentialType;
    private String clientId;
    private String enterpriseId;
    private String url;
    private String username;
    private String organizationUrl;
    private String siteCollectionPath;
    private String clientSecret;
    private String publicKeyId;
    private String privateKey;
    private String passphrase;
    private String password;
    private String gatewayId;
    private String sourceVersion;
    private String webApplicationUrl;
    private String domain;
    private String endpoint;
    private String accessKeyId;
    private String secretAccessKey;

    private Builder(CredentialDetails credentialDetails) {
      this.credentialType = credentialDetails.credentialType;
      this.clientId = credentialDetails.clientId;
      this.enterpriseId = credentialDetails.enterpriseId;
      this.url = credentialDetails.url;
      this.username = credentialDetails.username;
      this.organizationUrl = credentialDetails.organizationUrl;
      this.siteCollectionPath = credentialDetails.siteCollectionPath;
      this.clientSecret = credentialDetails.clientSecret;
      this.publicKeyId = credentialDetails.publicKeyId;
      this.privateKey = credentialDetails.privateKey;
      this.passphrase = credentialDetails.passphrase;
      this.password = credentialDetails.password; // pragma: whitelist secret
      this.gatewayId = credentialDetails.gatewayId;
      this.sourceVersion = credentialDetails.sourceVersion;
      this.webApplicationUrl = credentialDetails.webApplicationUrl;
      this.domain = credentialDetails.domain;
      this.endpoint = credentialDetails.endpoint;
      this.accessKeyId = credentialDetails.accessKeyId;
      this.secretAccessKey = credentialDetails.secretAccessKey;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a CredentialDetails.
     *
     * @return the credentialDetails
     */
    public CredentialDetails build() {
      return new CredentialDetails(this);
    }

    /**
     * Set the credentialType.
     *
     * @param credentialType the credentialType
     * @return the CredentialDetails builder
     */
    public Builder credentialType(String credentialType) {
      this.credentialType = credentialType;
      return this;
    }

    /**
     * Set the clientId.
     *
     * @param clientId the clientId
     * @return the CredentialDetails builder
     */
    public Builder clientId(String clientId) {
      this.clientId = clientId;
      return this;
    }

    /**
     * Set the enterpriseId.
     *
     * @param enterpriseId the enterpriseId
     * @return the CredentialDetails builder
     */
    public Builder enterpriseId(String enterpriseId) {
      this.enterpriseId = enterpriseId;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the CredentialDetails builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the username.
     *
     * @param username the username
     * @return the CredentialDetails builder
     */
    public Builder username(String username) {
      this.username = username;
      return this;
    }

    /**
     * Set the organizationUrl.
     *
     * @param organizationUrl the organizationUrl
     * @return the CredentialDetails builder
     */
    public Builder organizationUrl(String organizationUrl) {
      this.organizationUrl = organizationUrl;
      return this;
    }

    /**
     * Set the siteCollectionPath.
     *
     * @param siteCollectionPath the siteCollectionPath
     * @return the CredentialDetails builder
     */
    public Builder siteCollectionPath(String siteCollectionPath) {
      this.siteCollectionPath = siteCollectionPath;
      return this;
    }

    /**
     * Set the clientSecret.
     *
     * @param clientSecret the clientSecret
     * @return the CredentialDetails builder
     */
    public Builder clientSecret(String clientSecret) {
      this.clientSecret = clientSecret;
      return this;
    }

    /**
     * Set the publicKeyId.
     *
     * @param publicKeyId the publicKeyId
     * @return the CredentialDetails builder
     */
    public Builder publicKeyId(String publicKeyId) {
      this.publicKeyId = publicKeyId;
      return this;
    }

    /**
     * Set the privateKey.
     *
     * @param privateKey the privateKey
     * @return the CredentialDetails builder
     */
    public Builder privateKey(String privateKey) {
      this.privateKey = privateKey;
      return this;
    }

    /**
     * Set the passphrase.
     *
     * @param passphrase the passphrase
     * @return the CredentialDetails builder
     */
    public Builder passphrase(String passphrase) {
      this.passphrase = passphrase;
      return this;
    }

    /**
     * Set the password.
     *
     * @param password the password
     * @return the CredentialDetails builder
     */
    public Builder password(String password) {
      this.password = password; // pragma: whitelist secret
      return this;
    }

    /**
     * Set the gatewayId.
     *
     * @param gatewayId the gatewayId
     * @return the CredentialDetails builder
     */
    public Builder gatewayId(String gatewayId) {
      this.gatewayId = gatewayId;
      return this;
    }

    /**
     * Set the sourceVersion.
     *
     * @param sourceVersion the sourceVersion
     * @return the CredentialDetails builder
     */
    public Builder sourceVersion(String sourceVersion) {
      this.sourceVersion = sourceVersion;
      return this;
    }

    /**
     * Set the webApplicationUrl.
     *
     * @param webApplicationUrl the webApplicationUrl
     * @return the CredentialDetails builder
     */
    public Builder webApplicationUrl(String webApplicationUrl) {
      this.webApplicationUrl = webApplicationUrl;
      return this;
    }

    /**
     * Set the domain.
     *
     * @param domain the domain
     * @return the CredentialDetails builder
     */
    public Builder domain(String domain) {
      this.domain = domain;
      return this;
    }

    /**
     * Set the endpoint.
     *
     * @param endpoint the endpoint
     * @return the CredentialDetails builder
     */
    public Builder endpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    /**
     * Set the accessKeyId.
     *
     * @param accessKeyId the accessKeyId
     * @return the CredentialDetails builder
     */
    public Builder accessKeyId(String accessKeyId) {
      this.accessKeyId = accessKeyId;
      return this;
    }

    /**
     * Set the secretAccessKey.
     *
     * @param secretAccessKey the secretAccessKey
     * @return the CredentialDetails builder
     */
    public Builder secretAccessKey(String secretAccessKey) {
      this.secretAccessKey = secretAccessKey;
      return this;
    }
  }

  protected CredentialDetails(Builder builder) {
    credentialType = builder.credentialType;
    clientId = builder.clientId;
    enterpriseId = builder.enterpriseId;
    url = builder.url;
    username = builder.username;
    organizationUrl = builder.organizationUrl;
    siteCollectionPath = builder.siteCollectionPath;
    clientSecret = builder.clientSecret;
    publicKeyId = builder.publicKeyId;
    privateKey = builder.privateKey;
    passphrase = builder.passphrase;
    password = builder.password; // pragma: whitelist secret
    gatewayId = builder.gatewayId;
    sourceVersion = builder.sourceVersion;
    webApplicationUrl = builder.webApplicationUrl;
    domain = builder.domain;
    endpoint = builder.endpoint;
    accessKeyId = builder.accessKeyId;
    secretAccessKey = builder.secretAccessKey;
  }

  /**
   * New builder.
   *
   * @return a CredentialDetails builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the credentialType.
   *
   * <p>The authentication method for this credentials definition. The **credential_type** specified
   * must be supported by the **source_type**. The following combinations are possible:
   *
   * <p>- `"source_type": "box"` - valid `credential_type`s: `oauth2` - `"source_type":
   * "salesforce"` - valid `credential_type`s: `username_password` - `"source_type": "sharepoint"` -
   * valid `credential_type`s: `saml` with **source_version** of `online`, or `ntlm_v1` with
   * **source_version** of `2016` - `"source_type": "web_crawl"` - valid `credential_type`s:
   * `noauth` or `basic` - "source_type": "cloud_object_storage"` - valid `credential_type`s:
   * `aws4_hmac`.
   *
   * @return the credentialType
   */
  public String credentialType() {
    return credentialType;
  }

  /**
   * Gets the clientId.
   *
   * <p>The **client_id** of the source that these credentials connect to. Only valid, and required,
   * with a **credential_type** of `oauth2`.
   *
   * @return the clientId
   */
  public String clientId() {
    return clientId;
  }

  /**
   * Gets the enterpriseId.
   *
   * <p>The **enterprise_id** of the Box site that these credentials connect to. Only valid, and
   * required, with a **source_type** of `box`.
   *
   * @return the enterpriseId
   */
  public String enterpriseId() {
    return enterpriseId;
  }

  /**
   * Gets the url.
   *
   * <p>The **url** of the source that these credentials connect to. Only valid, and required, with
   * a **credential_type** of `username_password`, `noauth`, and `basic`.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the username.
   *
   * <p>The **username** of the source that these credentials connect to. Only valid, and required,
   * with a **credential_type** of `saml`, `username_password`, `basic`, or `ntlm_v1`.
   *
   * @return the username
   */
  public String username() {
    return username;
  }

  /**
   * Gets the organizationUrl.
   *
   * <p>The **organization_url** of the source that these credentials connect to. Only valid, and
   * required, with a **credential_type** of `saml`.
   *
   * @return the organizationUrl
   */
  public String organizationUrl() {
    return organizationUrl;
  }

  /**
   * Gets the siteCollectionPath.
   *
   * <p>The **site_collection.path** of the source that these credentials connect to. Only valid,
   * and required, with a **source_type** of `sharepoint`.
   *
   * @return the siteCollectionPath
   */
  public String siteCollectionPath() {
    return siteCollectionPath;
  }

  /**
   * Gets the clientSecret.
   *
   * <p>The **client_secret** of the source that these credentials connect to. Only valid, and
   * required, with a **credential_type** of `oauth2`. This value is never returned and is only used
   * when creating or modifying **credentials**.
   *
   * @return the clientSecret
   */
  public String clientSecret() {
    return clientSecret;
  }

  /**
   * Gets the publicKeyId.
   *
   * <p>The **public_key_id** of the source that these credentials connect to. Only valid, and
   * required, with a **credential_type** of `oauth2`. This value is never returned and is only used
   * when creating or modifying **credentials**.
   *
   * @return the publicKeyId
   */
  public String publicKeyId() {
    return publicKeyId;
  }

  /**
   * Gets the privateKey.
   *
   * <p>The **private_key** of the source that these credentials connect to. Only valid, and
   * required, with a **credential_type** of `oauth2`. This value is never returned and is only used
   * when creating or modifying **credentials**.
   *
   * @return the privateKey
   */
  public String privateKey() {
    return privateKey;
  }

  /**
   * Gets the passphrase.
   *
   * <p>The **passphrase** of the source that these credentials connect to. Only valid, and
   * required, with a **credential_type** of `oauth2`. This value is never returned and is only used
   * when creating or modifying **credentials**.
   *
   * @return the passphrase
   */
  public String passphrase() {
    return passphrase;
  }

  /**
   * Gets the password.
   *
   * <p>The **password** of the source that these credentials connect to. Only valid, and required,
   * with **credential_type**s of `saml`, `username_password`, `basic`, or `ntlm_v1`.
   *
   * <p>**Note:** When used with a **source_type** of `salesforce`, the password consists of the
   * Salesforce password and a valid Salesforce security token concatenated. This value is never
   * returned and is only used when creating or modifying **credentials**.
   *
   * @return the password
   */
  public String password() {
    return password;
  }

  /**
   * Gets the gatewayId.
   *
   * <p>The ID of the **gateway** to be connected through (when connecting to intranet sites). Only
   * valid with a **credential_type** of `noauth`, `basic`, or `ntlm_v1`. Gateways are created using
   * the `/v1/environments/{environment_id}/gateways` methods.
   *
   * @return the gatewayId
   */
  public String gatewayId() {
    return gatewayId;
  }

  /**
   * Gets the sourceVersion.
   *
   * <p>The type of Sharepoint repository to connect to. Only valid, and required, with a
   * **source_type** of `sharepoint`.
   *
   * @return the sourceVersion
   */
  public String sourceVersion() {
    return sourceVersion;
  }

  /**
   * Gets the webApplicationUrl.
   *
   * <p>SharePoint OnPrem WebApplication URL. Only valid, and required, with a **source_version** of
   * `2016`. If a port is not supplied, the default to port `80` for http and port `443` for https
   * connections are used.
   *
   * @return the webApplicationUrl
   */
  public String webApplicationUrl() {
    return webApplicationUrl;
  }

  /**
   * Gets the domain.
   *
   * <p>The domain used to log in to your OnPrem SharePoint account. Only valid, and required, with
   * a **source_version** of `2016`.
   *
   * @return the domain
   */
  public String domain() {
    return domain;
  }

  /**
   * Gets the endpoint.
   *
   * <p>The endpoint associated with the cloud object store that your are connecting to. Only valid,
   * and required, with a **credential_type** of `aws4_hmac`.
   *
   * @return the endpoint
   */
  public String endpoint() {
    return endpoint;
  }

  /**
   * Gets the accessKeyId.
   *
   * <p>The access key ID associated with the cloud object store. Only valid, and required, with a
   * **credential_type** of `aws4_hmac`. This value is never returned and is only used when creating
   * or modifying **credentials**. For more infomation, see the [cloud object store
   * documentation](https://cloud.ibm.com/docs/cloud-object-storage?topic=cloud-object-storage-using-hmac-credentials#using-hmac-credentials).
   *
   * @return the accessKeyId
   */
  public String accessKeyId() {
    return accessKeyId;
  }

  /**
   * Gets the secretAccessKey.
   *
   * <p>The secret access key associated with the cloud object store. Only valid, and required, with
   * a **credential_type** of `aws4_hmac`. This value is never returned and is only used when
   * creating or modifying **credentials**. For more infomation, see the [cloud object store
   * documentation](https://cloud.ibm.com/docs/cloud-object-storage?topic=cloud-object-storage-using-hmac-credentials#using-hmac-credentials).
   *
   * @return the secretAccessKey
   */
  public String secretAccessKey() {
    return secretAccessKey;
  }
}

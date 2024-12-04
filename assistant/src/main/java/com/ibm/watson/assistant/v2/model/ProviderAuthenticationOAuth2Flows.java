/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.watson.assistant.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Scenarios performed by the API client to fetch an access token from the authorization server.
 *
 * <p>Classes which extend this class: -
 * ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password -
 * ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials -
 * ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2AuthorizationCode
 */
public class ProviderAuthenticationOAuth2Flows extends GenericModel {

  /** The client authorization type. */
  public interface ClientAuthType {
    /** Body. */
    String BODY = "Body";
    /** BasicAuthHeader. */
    String BASICAUTHHEADER = "BasicAuthHeader";
  }

  @SerializedName("token_url")
  protected String tokenUrl;

  @SerializedName("refresh_url")
  protected String refreshUrl;

  @SerializedName("client_auth_type")
  protected String clientAuthType;

  @SerializedName("content_type")
  protected String contentType;

  @SerializedName("header_prefix")
  protected String headerPrefix;

  protected ProviderAuthenticationOAuth2PasswordUsername username;

  @SerializedName("authorization_url")
  protected String authorizationUrl;

  @SerializedName("redirect_uri")
  protected String redirectUri;

  protected ProviderAuthenticationOAuth2Flows() {}

  /**
   * Gets the tokenUrl.
   *
   * <p>The token URL.
   *
   * @return the tokenUrl
   */
  public String tokenUrl() {
    return tokenUrl;
  }

  /**
   * Gets the refreshUrl.
   *
   * <p>The refresh token URL.
   *
   * @return the refreshUrl
   */
  public String refreshUrl() {
    return refreshUrl;
  }

  /**
   * Gets the clientAuthType.
   *
   * <p>The client authorization type.
   *
   * @return the clientAuthType
   */
  public String clientAuthType() {
    return clientAuthType;
  }

  /**
   * Gets the contentType.
   *
   * <p>The content type.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }

  /**
   * Gets the headerPrefix.
   *
   * <p>The prefix fo the header.
   *
   * @return the headerPrefix
   */
  public String headerPrefix() {
    return headerPrefix;
  }

  /**
   * Gets the username.
   *
   * <p>The username for oauth2 authentication when the preferred flow is "password".
   *
   * @return the username
   */
  public ProviderAuthenticationOAuth2PasswordUsername username() {
    return username;
  }

  /**
   * Gets the authorizationUrl.
   *
   * <p>The authorization URL.
   *
   * @return the authorizationUrl
   */
  public String authorizationUrl() {
    return authorizationUrl;
  }

  /**
   * Gets the redirectUri.
   *
   * <p>The redirect URI.
   *
   * @return the redirectUri
   */
  public String redirectUri() {
    return redirectUri;
  }
}

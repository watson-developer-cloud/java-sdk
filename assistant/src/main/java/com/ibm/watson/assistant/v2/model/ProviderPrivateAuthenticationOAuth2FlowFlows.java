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
 * ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password -
 * ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2ClientCredentials
 * -
 * ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
 */
public class ProviderPrivateAuthenticationOAuth2FlowFlows extends GenericModel {

  @SerializedName("client_id")
  protected String clientId;

  @SerializedName("client_secret")
  protected String clientSecret;

  @SerializedName("access_token")
  protected String accessToken;

  @SerializedName("refresh_token")
  protected String refreshToken;

  protected ProviderPrivateAuthenticationOAuth2PasswordPassword password;

  @SerializedName("authorization_code")
  protected String authorizationCode;

  protected ProviderPrivateAuthenticationOAuth2FlowFlows() {}

  /**
   * Gets the clientId.
   *
   * <p>The client ID.
   *
   * @return the clientId
   */
  public String clientId() {
    return clientId;
  }

  /**
   * Gets the clientSecret.
   *
   * <p>The client secret.
   *
   * @return the clientSecret
   */
  public String clientSecret() {
    return clientSecret;
  }

  /**
   * Gets the accessToken.
   *
   * <p>The access token.
   *
   * @return the accessToken
   */
  public String accessToken() {
    return accessToken;
  }

  /**
   * Gets the refreshToken.
   *
   * <p>The refresh token.
   *
   * @return the refreshToken
   */
  public String refreshToken() {
    return refreshToken;
  }

  /**
   * Gets the password.
   *
   * <p>The password for oauth2 authentication when the preferred flow is "password".
   *
   * @return the password
   */
  public ProviderPrivateAuthenticationOAuth2PasswordPassword password() {
    return password;
  }

  /**
   * Gets the authorizationCode.
   *
   * <p>The authorization code.
   *
   * @return the authorizationCode
   */
  public String authorizationCode() {
    return authorizationCode;
  }
}

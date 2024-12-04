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

/** Private authentication settings for client credentials flow. */
public
class ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
    extends ProviderPrivateAuthenticationOAuth2FlowFlows {

  /** Builder. */
  public static class Builder {
    private String clientId;
    private String clientSecret;
    private String accessToken;
    private String refreshToken;
    private String authorizationCode;

    /**
     * Instantiates a new Builder from an existing
     * ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
     * instance.
     *
     * @param
     *     providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
     *     the instance to initialize the Builder with
     */
    public Builder(
        ProviderPrivateAuthenticationOAuth2FlowFlows
            providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode) {
      this.clientId =
          providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
              .clientId;
      this.clientSecret =
          providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
              .clientSecret;
      this.accessToken =
          providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
              .accessToken;
      this.refreshToken =
          providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
              .refreshToken;
      this.authorizationCode =
          providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
              .authorizationCode;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a
     * ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode.
     *
     * @return the new
     *     ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
     *     instance
     */
    public
    ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
        build() {
      return new ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode(
          this);
    }

    /**
     * Set the clientId.
     *
     * @param clientId the clientId
     * @return the
     *     ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
     *     builder
     */
    public Builder clientId(String clientId) {
      this.clientId = clientId;
      return this;
    }

    /**
     * Set the clientSecret.
     *
     * @param clientSecret the clientSecret
     * @return the
     *     ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
     *     builder
     */
    public Builder clientSecret(String clientSecret) {
      this.clientSecret = clientSecret;
      return this;
    }

    /**
     * Set the accessToken.
     *
     * @param accessToken the accessToken
     * @return the
     *     ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
     *     builder
     */
    public Builder accessToken(String accessToken) {
      this.accessToken = accessToken;
      return this;
    }

    /**
     * Set the refreshToken.
     *
     * @param refreshToken the refreshToken
     * @return the
     *     ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
     *     builder
     */
    public Builder refreshToken(String refreshToken) {
      this.refreshToken = refreshToken;
      return this;
    }

    /**
     * Set the authorizationCode.
     *
     * @param authorizationCode the authorizationCode
     * @return the
     *     ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
     *     builder
     */
    public Builder authorizationCode(String authorizationCode) {
      this.authorizationCode = authorizationCode;
      return this;
    }
  }

  protected
  ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode() {}

  protected
  ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode(
      Builder builder) {
    clientId = builder.clientId;
    clientSecret = builder.clientSecret;
    accessToken = builder.accessToken;
    refreshToken = builder.refreshToken;
    authorizationCode = builder.authorizationCode;
  }

  /**
   * New builder.
   *
   * @return a
   *     ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2AuthorizationCode
   *     builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

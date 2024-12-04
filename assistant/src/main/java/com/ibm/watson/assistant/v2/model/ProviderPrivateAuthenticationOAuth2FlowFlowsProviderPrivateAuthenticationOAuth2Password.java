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

/** Private authentication settings for resource owner password flow. */
public class ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
    extends ProviderPrivateAuthenticationOAuth2FlowFlows {

  /** Builder. */
  public static class Builder {
    private String clientId;
    private String clientSecret;
    private String accessToken;
    private String refreshToken;
    private ProviderPrivateAuthenticationOAuth2PasswordPassword password;

    /**
     * Instantiates a new Builder from an existing
     * ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
     * instance.
     *
     * @param
     *     providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
     *     the instance to initialize the Builder with
     */
    public Builder(
        ProviderPrivateAuthenticationOAuth2FlowFlows
            providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password) {
      this.clientId =
          providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
              .clientId;
      this.clientSecret =
          providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
              .clientSecret;
      this.accessToken =
          providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
              .accessToken;
      this.refreshToken =
          providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
              .refreshToken;
      this.password =
          providerPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
              .password;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a
     * ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password.
     *
     * @return the new
     *     ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
     *     instance
     */
    public ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
        build() {
      return new ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password(
          this);
    }

    /**
     * Set the clientId.
     *
     * @param clientId the clientId
     * @return the
     *     ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
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
     *     ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
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
     *     ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
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
     *     ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
     *     builder
     */
    public Builder refreshToken(String refreshToken) {
      this.refreshToken = refreshToken;
      return this;
    }

    /**
     * Set the password.
     *
     * @param password the password
     * @return the
     *     ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
     *     builder
     */
    public Builder password(ProviderPrivateAuthenticationOAuth2PasswordPassword password) {
      this.password = password;
      return this;
    }
  }

  protected
  ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password() {}

  protected ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password(
      Builder builder) {
    clientId = builder.clientId;
    clientSecret = builder.clientSecret;
    accessToken = builder.accessToken;
    refreshToken = builder.refreshToken;
    password = builder.password;
  }

  /**
   * New builder.
   *
   * @return a
   *     ProviderPrivateAuthenticationOAuth2FlowFlowsProviderPrivateAuthenticationOAuth2Password
   *     builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

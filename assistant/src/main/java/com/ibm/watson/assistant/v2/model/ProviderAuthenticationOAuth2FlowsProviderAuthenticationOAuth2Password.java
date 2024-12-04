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

/** Non-private authentication settings for resource owner password flow. */
public class ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password
    extends ProviderAuthenticationOAuth2Flows {

  /** The client authorization type. */
  public interface ClientAuthType {
    /** Body. */
    String BODY = "Body";
    /** BasicAuthHeader. */
    String BASICAUTHHEADER = "BasicAuthHeader";
  }

  /** Builder. */
  public static class Builder {
    private String tokenUrl;
    private String refreshUrl;
    private String clientAuthType;
    private String contentType;
    private String headerPrefix;
    private ProviderAuthenticationOAuth2PasswordUsername username;

    /**
     * Instantiates a new Builder from an existing
     * ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password instance.
     *
     * @param providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password the instance to
     *     initialize the Builder with
     */
    public Builder(
        ProviderAuthenticationOAuth2Flows
            providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password) {
      this.tokenUrl =
          providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password.tokenUrl;
      this.refreshUrl =
          providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password.refreshUrl;
      this.clientAuthType =
          providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password.clientAuthType;
      this.contentType =
          providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password.contentType;
      this.headerPrefix =
          providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password.headerPrefix;
      this.username =
          providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password.username;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password.
     *
     * @return the new ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password
     *     instance
     */
    public ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password build() {
      return new ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password(this);
    }

    /**
     * Set the tokenUrl.
     *
     * @param tokenUrl the tokenUrl
     * @return the ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password builder
     */
    public Builder tokenUrl(String tokenUrl) {
      this.tokenUrl = tokenUrl;
      return this;
    }

    /**
     * Set the refreshUrl.
     *
     * @param refreshUrl the refreshUrl
     * @return the ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password builder
     */
    public Builder refreshUrl(String refreshUrl) {
      this.refreshUrl = refreshUrl;
      return this;
    }

    /**
     * Set the clientAuthType.
     *
     * @param clientAuthType the clientAuthType
     * @return the ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password builder
     */
    public Builder clientAuthType(String clientAuthType) {
      this.clientAuthType = clientAuthType;
      return this;
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the headerPrefix.
     *
     * @param headerPrefix the headerPrefix
     * @return the ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password builder
     */
    public Builder headerPrefix(String headerPrefix) {
      this.headerPrefix = headerPrefix;
      return this;
    }

    /**
     * Set the username.
     *
     * @param username the username
     * @return the ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password builder
     */
    public Builder username(ProviderAuthenticationOAuth2PasswordUsername username) {
      this.username = username;
      return this;
    }
  }

  protected ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password() {}

  protected ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password(Builder builder) {
    tokenUrl = builder.tokenUrl;
    refreshUrl = builder.refreshUrl;
    clientAuthType = builder.clientAuthType;
    contentType = builder.contentType;
    headerPrefix = builder.headerPrefix;
    username = builder.username;
  }

  /**
   * New builder.
   *
   * @return a ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2Password builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

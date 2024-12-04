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

/** ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials. */
public class ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials
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

    /**
     * Instantiates a new Builder from an existing
     * ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials instance.
     *
     * @param providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials the
     *     instance to initialize the Builder with
     */
    public Builder(
        ProviderAuthenticationOAuth2Flows
            providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials) {
      this.tokenUrl =
          providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials.tokenUrl;
      this.refreshUrl =
          providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials.refreshUrl;
      this.clientAuthType =
          providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials
              .clientAuthType;
      this.contentType =
          providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials
              .contentType;
      this.headerPrefix =
          providerAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials
              .headerPrefix;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials.
     *
     * @return the new
     *     ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials instance
     */
    public ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials build() {
      return new ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials(
          this);
    }

    /**
     * Set the tokenUrl.
     *
     * @param tokenUrl the tokenUrl
     * @return the ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials
     *     builder
     */
    public Builder tokenUrl(String tokenUrl) {
      this.tokenUrl = tokenUrl;
      return this;
    }

    /**
     * Set the refreshUrl.
     *
     * @param refreshUrl the refreshUrl
     * @return the ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials
     *     builder
     */
    public Builder refreshUrl(String refreshUrl) {
      this.refreshUrl = refreshUrl;
      return this;
    }

    /**
     * Set the clientAuthType.
     *
     * @param clientAuthType the clientAuthType
     * @return the ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials
     *     builder
     */
    public Builder clientAuthType(String clientAuthType) {
      this.clientAuthType = clientAuthType;
      return this;
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials
     *     builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the headerPrefix.
     *
     * @param headerPrefix the headerPrefix
     * @return the ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials
     *     builder
     */
    public Builder headerPrefix(String headerPrefix) {
      this.headerPrefix = headerPrefix;
      return this;
    }
  }

  protected ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials() {}

  protected ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials(
      Builder builder) {
    tokenUrl = builder.tokenUrl;
    refreshUrl = builder.refreshUrl;
    clientAuthType = builder.clientAuthType;
    contentType = builder.contentType;
    headerPrefix = builder.headerPrefix;
  }

  /**
   * New builder.
   *
   * @return a ProviderAuthenticationOAuth2FlowsProviderAuthenticationOAuth2ClientCredentials
   *     builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

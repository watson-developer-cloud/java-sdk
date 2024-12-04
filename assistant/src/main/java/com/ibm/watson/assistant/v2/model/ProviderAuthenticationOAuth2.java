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

/** Non-private settings for oauth2 authentication. */
public class ProviderAuthenticationOAuth2 extends GenericModel {

  /**
   * The preferred "flow" or "grant type" for the API client to fetch an access token from the
   * authorization server.
   */
  public interface PreferredFlow {
    /** password. */
    String PASSWORD = "password";
    /** client_credentials. */
    String CLIENT_CREDENTIALS = "client_credentials";
    /** authorization_code. */
    String AUTHORIZATION_CODE = "authorization_code";
    /** &lt;$custom_flow_name&gt;. */
    String CUSTOM_FLOW_NAME = "<$custom_flow_name>";
  }

  @SerializedName("preferred_flow")
  protected String preferredFlow;

  protected ProviderAuthenticationOAuth2Flows flows;

  /** Builder. */
  public static class Builder {
    private String preferredFlow;
    private ProviderAuthenticationOAuth2Flows flows;

    /**
     * Instantiates a new Builder from an existing ProviderAuthenticationOAuth2 instance.
     *
     * @param providerAuthenticationOAuth2 the instance to initialize the Builder with
     */
    private Builder(ProviderAuthenticationOAuth2 providerAuthenticationOAuth2) {
      this.preferredFlow = providerAuthenticationOAuth2.preferredFlow;
      this.flows = providerAuthenticationOAuth2.flows;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a ProviderAuthenticationOAuth2.
     *
     * @return the new ProviderAuthenticationOAuth2 instance
     */
    public ProviderAuthenticationOAuth2 build() {
      return new ProviderAuthenticationOAuth2(this);
    }

    /**
     * Set the preferredFlow.
     *
     * @param preferredFlow the preferredFlow
     * @return the ProviderAuthenticationOAuth2 builder
     */
    public Builder preferredFlow(String preferredFlow) {
      this.preferredFlow = preferredFlow;
      return this;
    }

    /**
     * Set the flows.
     *
     * @param flows the flows
     * @return the ProviderAuthenticationOAuth2 builder
     */
    public Builder flows(ProviderAuthenticationOAuth2Flows flows) {
      this.flows = flows;
      return this;
    }
  }

  protected ProviderAuthenticationOAuth2() {}

  protected ProviderAuthenticationOAuth2(Builder builder) {
    preferredFlow = builder.preferredFlow;
    flows = builder.flows;
  }

  /**
   * New builder.
   *
   * @return a ProviderAuthenticationOAuth2 builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the preferredFlow.
   *
   * <p>The preferred "flow" or "grant type" for the API client to fetch an access token from the
   * authorization server.
   *
   * @return the preferredFlow
   */
  public String preferredFlow() {
    return preferredFlow;
  }

  /**
   * Gets the flows.
   *
   * <p>Scenarios performed by the API client to fetch an access token from the authorization
   * server.
   *
   * @return the flows
   */
  public ProviderAuthenticationOAuth2Flows flows() {
    return flows;
  }
}
